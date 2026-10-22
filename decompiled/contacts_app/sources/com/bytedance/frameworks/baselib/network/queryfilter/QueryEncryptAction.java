package com.bytedance.frameworks.baselib.network.queryfilter;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.retrofit2.client.Request;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class QueryEncryptAction extends QueryFilterAction {
    protected static final String ENCRYPT_QUERY_KEY = "x-tt-encrypt-queries";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static final String TAG = "QueryEncryptAction";
    private boolean mEncryptBodyEnabled;
    private List<String> mEncryptQueryList;
    private boolean mIsInvalid;

    static {
    }

    public QueryEncryptAction(int r1) {
        super(r1);
        this.mEncryptQueryList = new ArrayList();
        this.mIsInvalid = false;
        this.mEncryptBodyEnabled = false;
    }

    @Override // com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterAction
    protected void loadActionParam(JSONObject r3) {
        loadMatchRules(r3);
        QueryFilterEngine.parseArrayListConfig(r3.optJSONArray("encrypt_query_list"), this.mEncryptQueryList);
        boolean r1 = false;
        if (r3.optInt("encrypt_body_enabled", 0) <= 0) goto L5;
        r1 = true;
    L5:
        this.mEncryptBodyEnabled = r1;
        if (this.mEncryptQueryList.isEmpty() == true) goto L8;
        return;
    L8:
        if (this.mEncryptBodyEnabled == true) goto L12;
        this.mIsInvalid = true;
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterAction
    protected boolean dispatch(Request r9, Map<String, List<String>> r10) {
        boolean r1 = false;
        if (this.mIsInvalid == false) goto L5;
    L47:
        return r1;
    L5:
        if (isMatchUrlRules(r9) == false) goto L47;
        if (this.mEncryptBodyEnabled == false) goto L11;
        r9.setBodyEncryptEnabled(true);
        r1 = true;
    L11:
        if (r10.isEmpty() == false) goto L14;
        return r1;
    L14:
        if (this.mEncryptQueryList.isEmpty() == true) goto L47;
        if (r10.containsKey(ENCRYPT_QUERY_KEY) == true) goto L47;
        LinkedList r3 = new LinkedList();
        Iterator<String> r4 = this.mEncryptQueryList.iterator();
    L20:
        if (r4.hasNext() == false) goto L25;
        String r5 = r4.next();
        if (r10.containsKey(r5) == false) goto L20;
        r3.add(new Pair(r5, r10.get(r5)));
        goto L20
    L25:
        if (r3.isEmpty() == false) goto L27;
        return r1;
    L27:
        String r6 = format(r3);
        if (TextUtils.isEmpty(r6) == false) goto L48;
        return r1;
    L48:
        byte[] r7 = r6.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L32
    L34:
        if (r7 != null) goto L36;
        return r1;
    L36:
        byte[] r8 = EncryptorUtil.encrypt(r7, r7.length);
        if (r8 != null) goto L39;
        return r1;
    L39:
        String r2 = Base64.encodeToString(r8, 2);
        if (Logger.debug() == false) goto L42;
        Logger.d(TAG, "encryptBytes:" + r8 + " , encryptString:" + r2);
    L42:
        LinkedList r11 = new LinkedList();
        r11.add(r2);
        r9.setQueryEncryptEnabled(true);
        r10.put(ENCRYPT_QUERY_KEY, r11);
        Iterator<String> r12 = this.mEncryptQueryList.iterator();
    L44:
        if (r12.hasNext() == false) goto L46;
        r10.remove(r12.next());
        goto L44
    L46:
        return true;
    L32:
        e = move-exception;
        e.printStackTrace();
        r7 = null;
        goto L34
    }

    private static String format(List<Pair<String, List<String>>> r5) {
        StringBuilder r0 = new StringBuilder();
        Iterator<Pair<String, List<String>>> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L17;
        Pair<String, List<String>> r1 = r6.next();
        String r2 = (String) r1.first;
        List r3 = (List) r1.second;
        if (r3 == null) goto L4;
        if (r3.size() <= 0) goto L4;
        Iterator r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L4;
        String r7 = (String) r4.next();
        if (r0.length() <= 0) goto L15;
        r0.append(PARAMETER_SEPARATOR);
    L15:
        r0.append(r2);
        r0.append(NAME_VALUE_SEPARATOR);
        r0.append(r7);
        goto L11
    L17:
        return r0.toString();
    }
}
