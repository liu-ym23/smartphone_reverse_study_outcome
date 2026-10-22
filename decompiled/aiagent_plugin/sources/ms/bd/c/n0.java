package ms.bd.c;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f39562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f39563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f39564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f39565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f39566e;
    private boolean f;

    static {
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "914889", new byte[]{12, 60, 82, 117, 14, 32, 22, 25, 115, 109}), String.class, "com.obric.aiagent.plugin");
    }

    n0() {
        this.f39562a = 0;
        this.f39563b = 0;
        this.f39564c = 0;
        this.f39565d = 0;
        this.f39566e = false;
        this.f = false;
        g();
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ea9ebb", new byte[]{80, 108, 95, 40, 84, 123, 74, 73, 126, 48}), String.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4691a9", new byte[]{22, 49, 94, 81, 87, 32, 48, 4, 40, 114, 49, 53, 94, 80, 77, 116, 119, 82, 123}), String.class, "com.obric.aiagent.plugin");
        if (this.f == false) goto L6;
        this.f39565d = this.f39562a - this.f39563b;
        return;
    }

    private void g() {
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777224, 0, 0, null, null), String.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "044158", new byte[]{14, 36, 78, 66, 3, 33, 50, 25, 37, 98, 46, 56, 65, 76, 13, 117, 115, 80, 118}), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r0) == false) goto L6;
        this.f39566e = true;
        String r10 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "bddae8", new byte[]{67, 103, 5, 6, 95, 111, 98, 74, 59, 55, 122, 97, 87, 19, 91, 38, 109, 64, 49, 113, 124, 116, 87, 1, 82, 42, 33, 70, 58, 63, 117, 111, 16, 85, 77, 46, 114, 5, 59, 62, 103, 38, 4, 16, 78, 97}), String.class, "com.obric.aiagent.plugin");
        return;
    L6:
        String[] r2 = r0.split((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b5b99c", new byte[]{79, 43}), String.class, "com.obric.aiagent.plugin"));
        if (r2.length == 3) goto L10;
        this.f39566e = true;
        String r11 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d06a77", new byte[]{86, 61, 75, 19, 1, 39, 39, 6, 102, 34, 53, 59, 75, 85, 28, 40, 98, 81, 112, 35, 122, 60, 66, 85, 14, 47, 117, 28, 102, 37, 59}), String.class, "com.obric.aiagent.plugin");
        return;
    L10:
        boolean r4 = false;
        this.f39562a = Integer.parseInt(r2[0]);
        this.f39563b = Integer.parseInt(r2[1]);
        int r3 = Integer.parseInt(r2[2]);
        this.f39564c = r3;
        int r5 = this.f39562a;
        if (r5 < 0) goto L18;
        int r6 = this.f39563b;
        if (r6 < 0) goto L18;
        if (r5 < r6) goto L18;
        if (r3 == 0) goto L18;
        boolean r7 = false;
    L19:
        if (r7 == false) goto L23;
        this.f39566e = true;
        String r12 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "265d71", new byte[]{0, 59, 72, 22, 1, 33, 113, 0, 101, 39, 99, 39, 67, 4, 72, 47, 63, 87, 112, 60, 38, 116, 81, 2, 7, 40, 54, 87, 115, 53, 58, 122}), String.class, "com.obric.aiagent.plugin");
        return;
    L23:
        if (this.f39563b != 0) goto L26;
        if (r5 != 0) goto L26;
        r4 = true;
    L26:
        if (r4 == false) goto L29;
        String r13 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "40347c", new byte[]{6, 61, 78, 70, 1, 115, 119, 6, 99, 119, 101, 33, 69, 84, 72, 112, 62, 2, 99, 102, 41, 55, 68, 14}), String.class, "com.obric.aiagent.plugin");
        return;
    L29:
        this.f = true;
        return;
    L18:
        r7 = true;
        goto L19
    }

    public final boolean a() {
        return this.f39566e;
    }

    public final boolean b() {
        return this.f;
    }

    public final boolean c() {
        if (this.f == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f39563b != this.f39562a) goto L7;
        return true;
    }

    public final int d() {
        return this.f39563b;
    }

    public final int e() {
        return this.f39565d;
    }

    public final int f() {
        return this.f39564c;
    }

    public final String toString() {
        return String.format(Locale.US, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4148d8", new byte[]{32, 33, 85, 22, 30, 60, 43, 21, 107, 105, 39, 63, 66, 72, 1, 106, 36, 12, 32, 108, 105, 118, 67, 0, 30, 43}), String.class, "com.obric.aiagent.plugin"), new Object[]{Boolean.valueOf(this.f39566e), Boolean.valueOf(this.f), Integer.valueOf(this.f39562a), Integer.valueOf(this.f39563b), Integer.valueOf(this.f39564c)});
    }
}
