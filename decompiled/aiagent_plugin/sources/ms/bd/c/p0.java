package ms.bd.c;

import android.os.Build;
import android.util.Base64;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f39579a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f39580b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f39581c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f39582d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f39583e = null;
    private int f;
    private String g;
    private String h;
    private Throwable i;

    static {
        f39579a = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "70ce7b", new byte[]{50}), String.class, "com.obric.aiagent.plugin");
        f39580b = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ea321c", new byte[]{102}), String.class, "com.obric.aiagent.plugin");
        f39581c = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "8d2fb2", new byte[]{58}), String.class, "com.obric.aiagent.plugin");
        f39582d = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7095aa", new byte[]{32}), String.class, "com.obric.aiagent.plugin");
        f39583e = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6d058a", new byte[]{36}), String.class, "com.obric.aiagent.plugin");
    }

    private p0(int r1, String r2, String r3, Throwable r4) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }

    public p0(String r2, String r3, int r4) {
        this(r4, r2, r3, null);
    }

    public static p0 a(int r3) {
        return new p0(r3, "", "", null);
    }

    public static p0 a(Throwable r3) {
        return new p0(-100, "", "", r3);
    }

    public final String[] a() {
        String[] r1 = new String[2];
        int r3 = 0;
        r1[0] = String.valueOf(this.f);
        JSONObject r2 = new JSONObject();
        r2.put(f39579a, System.currentTimeMillis());     // Catch: Throwable -> L20
        r2.put(f39580b, this.f);     // Catch: Throwable -> L20
        if (this.i == null) goto L12;
        String r4 = f39581c;     // Catch: Throwable -> L20
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L20
        r5.append(this.i.getMessage());     // Catch: Throwable -> L20
        StackTraceElement[] r11 = this.i.getStackTrace();     // Catch: Throwable -> L20
        int r6 = r11.length;     // Catch: Throwable -> L20
        int r7 = 0;
    L6:
        if (r3 >= r6) goto L11;
        StackTraceElement r8 = r11[r3];     // Catch: Throwable -> L20
        int r9 = r7 + 1;     // Catch: Throwable -> L20
        if (r7 >= 3) goto L11;
        r5.append("\n");     // Catch: Throwable -> L20
        r5.append(r8.toString());     // Catch: Throwable -> L20
        r3 = r3 + 1;     // Catch: Throwable -> L20
        r7 = r9;
    L11:
        r2.put(r4, r5.toString());     // Catch: Throwable -> L20
    L14:
        if (Build.VERSION.SDK_INT < 19) goto L17;
        String r12 = Base64.encodeToString(r2.toString().getBytes(StandardCharsets.UTF_8), 2);     // Catch: Throwable -> L20
    L18:
        r1[1] = r12;
        return r1;
    L12:
        r2.put(f39582d, this.g);     // Catch: Throwable -> L20
        r2.put(f39583e, this.h);     // Catch: Throwable -> L20
    L17:
        r12 = "";
        goto L18
    }
}
