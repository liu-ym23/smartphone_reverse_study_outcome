package ms.bd.c;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Display;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static r1 f39597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerThread f39598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f39599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f39600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DisplayManager f39601e;
    private q f;

    final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ r1 f39602a;

        a(r1 r1) {
            this.f39602a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (Build.VERSION.SDK_INT >= 17) goto L6;
            return;
        L6:
            if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.a(this.f39602a), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L23;
            r1.b(this.f39602a).start();     // Catch: Throwable -> L19
            Handler r1 = new Handler(r1.b(this.f39602a).getLooper());     // Catch: Throwable -> L19
            r1 r2 = this.f39602a;     // Catch: Throwable -> L19
            r1.a(r2, (DisplayManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.a(r2), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "9e6192", new byte[]{44, 110, 86, 85, 10, 36, 35}), String.class, "com.obric.aiagent.plugin")), DisplayManager.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
            if (r1.c(this.f39602a) == null) goto L24;
            Display[] r0 = r1.c(this.f39602a).getDisplays();     // Catch: Throwable -> L19
            int r3 = r0.length;     // Catch: Throwable -> L19
            if (r3 <= 1) goto L17;
            q1 r4 = q1.a();     // Catch: Throwable -> L19
            r4.getClass();     // Catch: Throwable -> L19
            String r5 = q1.a(r0);     // Catch: Throwable -> L19
            String r6 = q1.b(r0);     // Catch: Throwable -> L19
            r4.a(r3);     // Catch: Throwable -> L19
            r4.b();     // Catch: Throwable -> L19
            if (TextUtils.isEmpty(r5) == true) goto L15;
            r4.a(r5);     // Catch: Throwable -> L19
        L15:
            if (TextUtils.isEmpty(r6) == true) goto L17;
            r4.b(r6);     // Catch: Throwable -> L19
        L17:
            r1 r7 = this.f39602a;     // Catch: Throwable -> L19
            r1.a(r7, new q(r1.c(r7)));     // Catch: Throwable -> L19
            r1.c(this.f39602a).registerDisplayListener(r1.d(this.f39602a), r1);     // Catch: Throwable -> L19
            return;
        L24:
            return;
        L23:
            return;
        }
    }

    private r1(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        this.f39600d = false;
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        this.f39599c = ZeusTransformUtils.wrapperContext(r11, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Application.class) == true) goto L8;
        Object r12 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L7;
        r12 = this.f39599c;
    L7:
        this.f39599c = ZeusTransformUtils.wrapperContext(r12, "com.obric.aiagent.plugin");
    L8:
        this.f39598b = new HandlerThread((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "21ff4f", new byte[]{14, 0, 38, 32}), String.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ Context a(r1 r0) {
        return r0.f39599c;
    }

    public static r1 a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        monitor-enter(r1.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f39597a != null) goto L7;
        f39597a = new r1(r3);     // Catch: Throwable -> L10
    L7:
        r1 r4 = f39597a;     // Catch: Throwable -> L10
        monitor-exit(r1.class);     // Catch: Throwable -> L10
        return r4;
    }

    static /* synthetic */ void a(r1 r0, DisplayManager r1) {
        r0.f39601e = r1;
    }

    static /* synthetic */ void a(r1 r0, q r1) {
        r0.f = r1;
    }

    private static Application b() {
        Application r2 = null;
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a3dc77", new byte[]{113, 63, 19, 5, 7, 41, 102, 92, 52, 35, 96, 127, 54, 20, 28, 41, 116, 27, 33, 42, 68, 57, 5, 18, 9, 36}), String.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "72620e", new byte[]{37, 37, 87, 84, 10, 124, 32, 50, 119, 114, 42, 57, 70, 71, 27, 123, 59, 29}), String.class, "com.obric.aiagent.plugin"), new Class[0]).invoke(null, null), Application.class, "com.obric.aiagent.plugin");
    L9:
        return r2;
    L7:
        r2 = null;
        goto L9
    }

    static /* synthetic */ HandlerThread b(r1 r0) {
        return r0.f39598b;
    }

    static /* synthetic */ DisplayManager c(r1 r0) {
        return r0.f39601e;
    }

    static /* synthetic */ q d(r1 r0) {
        return r0.f;
    }

    public final synchronized void a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f39600d == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f39600d = true;     // Catch: Throwable -> L11
        new Thread(new a(this)).start();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final void finalize() {
        monitor-enter(this);
        if (Build.VERSION.SDK_INT < 17) goto L29;
        DisplayManager r0 = this.f39601e;     // Catch: Throwable -> L22
        if (r0 == null) goto L29;
        q r1 = this.f;     // Catch: Throwable -> L22
        if (r1 == null) goto L29;
        r0.unregisterDisplayListener(r1);     // Catch: Throwable -> L22
    L29:
        HandlerThread r2 = this.f39598b;     // Catch: Throwable -> L19
        if (r2 != null) goto L27;
    L16:
        monitor-exit(this);
        super.finalize();
        return;
    L27:
        if (Build.VERSION.SDK_INT < 18) goto L15;
        r2.quitSafely();     // Catch: Throwable -> L23
    L26:
        goto L16
    L15:
        r2.quit();     // Catch: Throwable -> L23
    L19:
        th = move-exception;
        throw th;
    }
}
