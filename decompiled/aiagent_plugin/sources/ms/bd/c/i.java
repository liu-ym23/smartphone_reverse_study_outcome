package ms.bd.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f39509a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f39510b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f39511c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static i f39512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f39513e = null;
    private SharedPreferences f;
    private ArrayList g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f39514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f39515b;

        private a() {
            throw new RuntimeException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a5f221", new byte[]{89, 57, 29, 79, 15, 47, 118, 17, 51, 35}), String.class, "com.obric.aiagent.plugin"));
        }

        public a(String r1, String r2) {
            this.f39514a = r1;
            this.f39515b = r2;
        }

        public final String a() {
            return this.f39514a;
        }

        public final String b() {
            return this.f39515b;
        }
    }

    static {
        f39509a = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d27e43", new byte[]{58, 51, 69, 1, 31, 39, 111, 18, 41, 35, 112, 34, 77, 23, 18}), String.class, "com.obric.aiagent.plugin");
        f39510b = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6beb70", new byte[]{104, 112, 23, 5, 27, 55, 58, 81, 32, 125, 42, 111, 20, 31, 4, 34, 122, 78, 59, 48, 46, 108, 19, 41, 11, 38, 39, 71, 11, 62, 40, 103, 31, 24, 71}), String.class, "com.obric.aiagent.plugin");
        f39511c = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6a9dbb", new byte[]{104, 115, 75, 3, 78, 101, 58, 82, 124, 123, 42, 108, 72, 25, 81, 112, 122, 83, 101, 39, 24, 111, 69, 23, 84, 123, 122}), String.class, "com.obric.aiagent.plugin");
        f39513e = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "9feb69", new byte[]{58, 97, 17, 19, 17, 17, 55, 72, 48, 55, 23, 104, 31, 5, 29}), String.class, "com.obric.aiagent.plugin");
    }

    private i(Context r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        this.g = new ArrayList(10);
        SharedPreferences r15 = PreferenceManager.getDefaultSharedPreferences(r14);
        this.f = r15;
        a(r15.getString((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "78dde3", new byte[]{52, 63, 16, 21, 66, 27, 57, 22, 49, 49, 25, 54, 30, 3, 78}), String.class, "com.obric.aiagent.plugin"), ""), false);
        if (this.g.size() >= 1) goto L18;
        Object r16 = u0.a(3);
        Object r3 = u0.a(2);
        Object r4 = u0.a(1);
        if (r16 != null) goto L7;
    L9:
        if (r3 != null) goto L11;
    L13:
        if (r4 != null) goto L15;
        return;
    L15:
        if (((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin")).intValue() != 1) goto L20;
        a r17 = new a((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "9ee491", new byte[]{103, 119, 23, 83, 21, 54, 53, 86, 32, 43, 37, 104, 20, 73, 10, 35, 117, 87, 57, 119, 23, 107, 25, 71, 15, 40, 117}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "729a7c", new byte[]{53, 41, 68, 22}), String.class, "com.obric.aiagent.plugin"));
        this.g.add(r17);
        return;
    L20:
        return;
    L11:
        if (((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.aiagent.plugin")).intValue() != 1) goto L13;
        a r18 = new a((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f0cf3e", new byte[]{56, 34, 17, 1, 31, 98, 106, 3, 38, 121, 122, 61, 18, 27, 0, 119, 42, 28, 61, 52, 126, 62, 21, 45, 15, 115, 119, 21, 13, 58, 120, 53, 25, 28, 67}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "0d6103", new byte[]{50, 127, 75, 70}), String.class, "com.obric.aiagent.plugin"));
        this.g.add(r18);
        goto L13
    L7:
        if (((Integer) ZeusTransformUtils.preCheckCast(r16, Integer.class, "com.obric.aiagent.plugin")).intValue() == 0) goto L9;
        a r19 = new a((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6b6d6f", new byte[]{104, 99, 68, 0, 29, 114, 61, 66, 40, 34, 34, 114, 76, 22, 16}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "3fa838", new byte[]{49, 125, 28, 79}), String.class, "com.obric.aiagent.plugin"));
        this.g.add(r19);
        goto L9
    }

    public static synchronized i a(Context r3) {
        monitor-enter(i.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (f39512d != null) goto L7;
        f39512d = new i(r4);     // Catch: Throwable -> L10
    L7:
        i r5 = f39512d;     // Catch: Throwable -> L10
        monitor-exit(i.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized a a(String r12) {
        monitor-enter(this);
        if (r12 != null) goto L50;
        monitor-exit(this);
        return null;
    L50:
        Object r1 = com.bytedance.mobsec.matrix.a.a(33554445, 3, 0, null, null);     // Catch: Throwable -> L47
        boolean r2 = false;
        if (r1 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        Object r4 = com.bytedance.mobsec.matrix.a.a(33554445, 2, 0, null, null);     // Catch: Throwable -> L47
        if (r4 != null) goto L18;
    L20:
        boolean r5 = false;
    L21:
        Object r6 = com.bytedance.mobsec.matrix.a.a(33554445, 1, 0, null, null);     // Catch: Throwable -> L47
        if (r6 != null) goto L24;
    L26:
        Iterator r7 = this.g.iterator();     // Catch: Throwable -> L47
    L27:
        if (r7.hasNext() == false) goto L45;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r7.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        if (r8.a().equals(f39511c) == false) goto L34;
        if (r2 == false) goto L27;
    L34:
        if (r8.a().equals(f39510b) == false) goto L38;
        if (r5 == false) goto L27;
    L38:
        if (r8.a().equals(f39509a) == false) goto L42;
        if (r3 == false) goto L27;
    L42:
        if (Pattern.compile(r8.a()).matcher(r12).find() == false) goto L27;
        monitor-exit(this);
        return r8;
    L45:
        monitor-exit(this);
        return null;
    L24:
        if (((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin")).intValue() != 1) goto L26;
        r2 = true;
        goto L26
    L18:
        if (((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin")).intValue() != 1) goto L20;
        r5 = true;
        goto L21
    L11:
        if (((Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L14;
        r3 = false;
    L47:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r24, boolean r25) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r24) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        ArrayList r2 = new ArrayList(20);     // Catch: Throwable -> L23 JSONException -> L28
        JSONObject r3 = new JSONObject(r24);     // Catch: Throwable -> L23 JSONException -> L28
        String r4 = r3.getString((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "96c161", new byte[]{62, 49, 2, 86, 0, 41, 52}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23 JSONException -> L28
        String r5 = r3.getString((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b2a6dd", new byte[]{97, 37, 30, 71, 72}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23 JSONException -> L28
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1c4d94", new byte[]{113}), String.class, "com.obric.aiagent.plugin")).equals(r4) == false) goto L19;
        if (r5 == null) goto L19;
        String[] r6 = r5.split((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "cbe7eb", new byte[]{78, 124}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23 JSONException -> L28
        int r7 = r6.length;     // Catch: Throwable -> L23 JSONException -> L28
        int r8 = 0;
    L12:
        if (r8 >= r7) goto L19;
        String[] r9 = r6[r8].split((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "3b13c6", new byte[]{120}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23 JSONException -> L28
        if (r9 == null) goto L18;
        if (r9.length < 2) goto L18;
        r2.add(new a(new String(h.c(r9[0])), r9[1]));     // Catch: Throwable -> L23 JSONException -> L28
    L18:
        r8 = r8 + 1;     // Catch: Throwable -> L23 JSONException -> L28
    L19:
        this.g = r2;     // Catch: Throwable -> L23 JSONException -> L28
        if (r25 == false) goto L26;
        this.f.edit().putString(f39513e, r24).apply();     // Catch: Throwable -> L23 JSONException -> L28
    L26:
        monitor-exit(this);
    }
}
