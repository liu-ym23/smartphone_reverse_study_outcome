package y4;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f26101l = "b";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f26102i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f26103j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f26104k;

    static {
    }

    public b(int r10) {
        super(r10);
        this.f26102i = new ArrayList();
        this.f26103j = false;
        this.f26104k = false;
    }

    public static String n(List r10) {
        StringBuilder r11 = new StringBuilder();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L17;
        Pair r13 = (Pair) r12.next();
        String r14 = (String) r13.first;
        List r15 = (List) r13.second;
        if (r15 == null) goto L4;
        if (r15.size() <= 0) goto L4;
        Iterator r16 = r15.iterator();
    L11:
        if (r16.hasNext() == false) goto L4;
        String r17 = (String) r16.next();
        if (r11.length() <= 0) goto L15;
        r11.append("&");
    L15:
        r11.append(r14);
        r11.append("=");
        r11.append(r17);
        goto L11
    L17:
        return r11.toString();
    }

    @Override // y4.c
    public boolean b(g6.b r10, Map r11) {
        boolean r12 = false;
        if (this.f26103j == false) goto L5;
    L44:
        return r12;
    L5:
        if (g(r10) == false) goto L44;
        if (this.f26104k == false) goto L11;
        r10.L(true);
        r12 = true;
    L11:
        if (this.f26102i.isEmpty() == true) goto L44;
        if (r11.containsKey("x-tt-encrypt-queries") == true) goto L44;
        LinkedList r13 = new LinkedList();
        Iterator r14 = this.f26102i.iterator();
    L17:
        if (r14.hasNext() == false) goto L22;
        String r15 = (String) r14.next();
        if (r11.containsKey(r15) == false) goto L17;
        r13.add(new Pair(r15, r11.get(r15)));
        goto L17
    L22:
        if (r13.isEmpty() == false) goto L24;
        return r12;
    L24:
        String r16 = n(r13);
        if (TextUtils.isEmpty(r16) == false) goto L45;
        return r12;
    L45:
        byte[] r17 = r16.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L29
    L31:
        if (r17 != null) goto L33;
        return r12;
    L33:
        byte[] r18 = EncryptorUtil.a(r17, r17.length);
        if (r18 != null) goto L36;
        return r12;
    L36:
        String r19 = Base64.encodeToString(r18, 2);
        if (Logger.debug() == false) goto L39;
        Logger.d(f26101l, "encryptBytes:" + r18 + " , encryptString:" + r19);
    L39:
        LinkedList r20 = new LinkedList();
        r20.add(r19);
        r10.O(true);
        r11.put("x-tt-encrypt-queries", r20);
        Iterator r21 = this.f26102i.iterator();
    L41:
        if (r21.hasNext() == false) goto L43;
        r11.remove((String) r21.next());
        goto L41
    L43:
        return true;
    L29:
        e = move-exception;
        e.printStackTrace();
        r17 = null;
        goto L31
    }

    @Override // y4.c
    public void h(JSONObject r10) {
        i(r10);
        d.h(r10.optJSONArray("encrypt_query_list"), this.f26102i);
        boolean r11 = false;
        if (r10.optInt("encrypt_body_enabled", 0) <= 0) goto L5;
        r11 = true;
    L5:
        this.f26104k = r11;
        if (this.f26102i.isEmpty() == true) goto L8;
        return;
    L8:
        if (this.f26104k == true) goto L12;
        this.f26103j = true;
        return;
    }
}
