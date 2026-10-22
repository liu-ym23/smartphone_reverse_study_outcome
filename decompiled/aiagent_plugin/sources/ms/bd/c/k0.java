package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import com.obric.capabilitykit.common.ErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes4.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f39533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f39534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WindowManager f39535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f39536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f39537e;
    private final LinkedBlockingDeque<m0> f;
    private final m0 g;
    private final Object h;

    static {
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b222ad", new byte[]{87, 63, 84, 127, 87, 125, 77, 26, 117, 103}), String.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1110f3", new byte[]{44, 58, 84, 65, 102, 48, 55, 3}), String.class, "com.obric.aiagent.plugin");
    }

    public k0(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        this.f39537e = false;
        this.g = new m0();
        this.f = new LinkedBlockingDeque();
        this.h = new Object();
        boolean r0 = a(r10);
        this.f39533a = r0;
        if (r0 == true) goto L6;
        String r8 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "385538", new byte[]{6, 53, 83, 120, 5, 33, 28, 16, 114, 96}), String.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7e7c84", new byte[]{9, 113, 65, 5, 11, 34, 45, 4, 118, 54, 52, 106, 77, 4, 20, 42, 59, 74, 38, 58, 53, 39, 74, 24, 19, 99, 51, 86, 103, 61, 50, 98, 64, 89}), String.class, "com.obric.aiagent.plugin");
        return;
    L6:
        this.f39534b = ZeusTransformUtils.wrapperContext(r10, "com.obric.aiagent.plugin");
        this.f39535c = (WindowManager) ZeusTransformUtils.preCheckCast(r10.getSystemService((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "01d4fd", new byte[]{54, 58, 25, 68, 86, 100}), String.class, "com.obric.aiagent.plugin")), WindowManager.class, "com.obric.aiagent.plugin");
    }

    static /* synthetic */ m0 a(k0 r0) {
        return r0.g;
    }

    public static boolean a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return true;
    L5:
        return Settings.canDrawOverlays(r3);
    }

    public final void a(boolean r3) {
        if (this.f39533a == false) goto L16;
        View r0 = this.f39536d;
        if (r0 != null) goto L7;
    L10:
        if (r3 == false) goto L17;
        this.f39536d = null;
        m0 r2 = this.g;
        r2.f39553b = 0;
        r2.f39554c = 0;
        r2.f39552a = 0;
        return;
    L17:
        return;
    L7:
        if (this.f39537e == false) goto L10;
        this.f39535c.removeView(r0);     // Catch: Exception -> L13
    L9:
        this.f39537e = false;
        goto L10
    }

    public final boolean a() {
        return this.f39533a;
    }

    public final void b() {
        if (this.f39533a == true) goto L5;
        return;
    L5:
        if (this.f39536d != null) goto L8;
        this.f39536d = new j0(this, this.f39534b);
    L8:
        if (this.f39537e == false) goto L11;
        return;
    L11:
        if (Build.VERSION.SDK_INT < 26) goto L13;
        int r1 = 2038;
    L14:
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams(1, 1, r1, 262152, -3);
        r0.gravity = 8388661;
        this.f39535c.addView(this.f39536d, r0);     // Catch: Exception -> L18
    L16:
        this.f39537e = true;
        return;
    L13:
        r1 = ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_RINGING_AFTER_24_HOURS_ERROR;
        goto L14
    }

    public final void c() {
        if (this.f39533a == false) goto L15;
        this.g.f = SystemClock.uptimeMillis();
        this.g.f39552a++;
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ca2239", new byte[]{47, 62, 28, 27, 81, 115, 61, 29, 62, 63, 50, 38, 82, 6, 81, 115, 61, 29, 62, 63, 47, 62, 28, 27, 76}), String.class, "com.obric.aiagent.plugin");
        m0 r1 = this.g.a();
        Object r2 = this.h;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f.size() <= 50) goto L9;
        this.f.pop();     // Catch: Throwable -> L12
    L9:
        this.f.add(r1);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        m0 r7 = this.g;
        r7.f39553b = 0;
        r7.f39554c = 0;
        return;
    }

    public final String d() {
        if (this.f39533a == true) goto L7;
        m0 r15 = this.g;
        r15.f39553b = -1;
        return r15.toString();
    L7:
        if (this.f.isEmpty() == true) goto L31;
        Object r0 = this.h;
        monitor-enter(r0);
        int r7 = 0;
        String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "518446", new byte[]{97, 55, 11, 82, 14, 44, 55, 25, 103, 97, 32, 115, 95, 79, 75, 35, 51, 80, 123, 97, 52, 60, 89, 84, 14, 37, 120}), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        this.f.size();     // Catch: Throwable -> L28
        LinkedBlockingDeque<m0> r2 = this.f;     // Catch: Throwable -> L28
        int r3 = w1.f39673a;     // Catch: Throwable -> L28
        if (r2 != null) goto L14;
    L24:
        String r4 = "";
    L25:
        this.f.clear();     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        return r4;
    L14:
        if (r2.isEmpty() == true) goto L24;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L28
        Iterator<m0> r6 = r2.iterator();     // Catch: Throwable -> L28
    L18:
        if (r6.hasNext() == false) goto L23;
        r5.append(r6.next().toString());     // Catch: Throwable -> L28
        if (r7 >= (r2.size() - 1)) goto L22;
        r5.append('|');     // Catch: Throwable -> L28
    L22:
        r7 = r7 + 1;     // Catch: Throwable -> L28
        goto L18
    L23:
        r4 = r5.toString();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    L31:
        return "";
    }
}
