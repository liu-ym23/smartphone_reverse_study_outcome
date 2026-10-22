package com.bytedance.frameworks.baselib.network.queryfilter;

import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class QueryRemoveAction extends QueryFilterAction {
    private static final String KEY_ADD_BACKGROUND_RM_MARK = "add_background_rm_mark";
    private static final String KEY_BACKGROUND_MARK_PARAM = "bgrm";
    private static final String KEY_BACKGROUND_PROTECT = "protect_background_request";
    private static final String TAG = "QueryRemoveAction";
    private boolean mIsInvalid;
    private List<String> mKeepQueryList;
    private boolean mNeedBackgroundRmMark;
    private List<String> mRemoveQueryList;

    static {
    }

    public QueryRemoveAction(int r1) {
        super(r1);
        this.mKeepQueryList = new ArrayList();
        this.mRemoveQueryList = new ArrayList();
        this.mIsInvalid = false;
        this.mNeedBackgroundRmMark = false;
    }

    @Override // com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterAction
    protected void loadActionParam(JSONObject r4) {
        loadMatchRules(r4);
        QueryFilterEngine.parseArrayListConfig(r4.optJSONArray("keep_list"), this.mKeepQueryList);
        QueryFilterEngine.parseArrayListConfig(r4.optJSONArray("remove_list"), this.mRemoveQueryList);
        boolean r1 = false;
        if (r4.optInt(KEY_BACKGROUND_PROTECT, 0) <= 0) goto L5;
        boolean r0 = true;
    L6:
        this.mNeedBackgroundProtect = r0;
        if (r4.optInt(KEY_ADD_BACKGROUND_RM_MARK, 0) <= 0) goto L9;
        r1 = true;
    L9:
        this.mNeedBackgroundRmMark = r1;
        if (this.mKeepQueryList.isEmpty() == false) goto L12;
        return;
    L12:
        if (this.mRemoveQueryList.isEmpty() == true) goto L16;
        this.mIsInvalid = true;
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterAction
    protected boolean dispatch(Request r3, Map<String, List<String>> r4) {
        if (this.mIsInvalid == false) goto L5;
    L44:
        return false;
    L5:
        if (isMatchUrlRules(r3) == false) goto L44;
        if (r4.isEmpty() == false) goto L11;
        return false;
    L11:
        if (this.mKeepQueryList.isEmpty() == true) goto L23;
        Map<? extends String, ? extends List<String>> r5 = new LinkedHashMap();
        if (r4.containsKey("x-tt-encrypt-queries") == false) goto L15;
        r5.put("x-tt-encrypt-queries", r4.get("x-tt-encrypt-queries"));
    L15:
        Iterator<String> r2 = this.mKeepQueryList.iterator();
    L17:
        if (r2.hasNext() == false) goto L21;
        String r0 = r2.next();
        if (r4.containsKey(r0) == false) goto L17;
        r5.put(r0, r4.get(r0));
        goto L17
    L21:
        r4.clear();
        r4.putAll(r5);
        return true;
    L23:
        if (this.mRemoveQueryList.isEmpty() == true) goto L55;
        Iterator<String> r1 = this.mRemoveQueryList.iterator();
    L26:
        if (r1.hasNext() == false) goto L29;
        r4.remove(r1.next());
        goto L26
    L29:
        if (r3.getUrl() == null) goto L31;
        String r6 = r3.getUrl();
    L33:
        if (this.mNeedBackgroundRmMark == true) goto L35;
        return true;
    L35:
        if (r6.contains(KEY_BACKGROUND_MARK_PARAM) == true) goto L57;
        Iterator<String> r7 = this.mRemoveQueryList.iterator();
    L38:
        if (r7.hasNext() == false) goto L58;
        if (r6.contains(r7.next()) == false) goto L38;
        ArrayList r8 = new ArrayList();
        r8.add("1");
        r4.put(KEY_BACKGROUND_MARK_PARAM, r8);
        return true;
    L58:
        return true;
    L57:
        return true;
    L31:
        r6 = "";
        goto L33
    L55:
        return true;
    }
}
