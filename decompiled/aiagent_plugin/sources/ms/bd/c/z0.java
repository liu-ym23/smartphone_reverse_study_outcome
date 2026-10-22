package ms.bd.c;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final z0 f39685a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f39686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.mobsec.metasec.ml.b.a.c f39687c;

    static {
        f39685a = new z0();
    }

    public z0() {
    }

    public static z0 a() {
        return f39685a;
    }

    public final String b() {
        com.bytedance.mobsec.metasec.ml.b.a.c r1 = this.f39687c;
        if (r1 != null) goto L5;
        return null;
    L5:
        if (f39686b == false) goto L20;
        return null;
    L20:
        f39686b = true;     // Catch: Exception -> L19
        String r2 = r1.a();     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return null;
    L10:
        if (r2.trim().length() > 3) goto L12;
        return null;
    L12:
        if (r2.contains((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ea9265", new byte[]{119, 108, 68, 82, 12, 44, 114}), String.class, "com.obric.aiagent.plugin")) == false) goto L16;
        return new JSONObject(r2).getString((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "865898", new byte[]{42, 59, 72, 88, 3, 33, 47}), String.class, "com.obric.aiagent.plugin"));
    L16:
        return r2.trim();
    L24:
        return null;
    }
}
