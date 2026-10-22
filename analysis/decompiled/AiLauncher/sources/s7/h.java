package s7;

import android.view.Choreographer;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\b\b*\u0001!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u0003J\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003R$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0011\u0010'\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Ls7/h;", "", "<init>", "()V", "Lkotlin/Function1;", "", "LY8/t;", "onFrame", "k", "(Lp9/l;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, "Lp9/l;", "callback", "", Const.INTENT_KEY_PKGNAME, "Z", "running", "", "c", "J", "lastFrameTimeNanos", "", Const.INTENT_KEY_UMID, "I", "getTargetFps", "()I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)V", "targetFps", "s7/h$a", "e", "Ls7/h$a;", "frameCallback", "f", "()Z", "isRunning", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5074l<? super Float, Y8.t> callback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean running;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public long lastFrameTimeNanos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public volatile int targetFps;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final a frameCallback = new a();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"s7/h$a", "Landroid/view/Choreographer$FrameCallback;", "", "frameTimeNanos", "LY8/t;", "doFrame", "(J)V", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Choreographer.FrameCallback {
        public a() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            if (h.this.running) {
                float fM = h.this.lastFrameTimeNanos == 0 ? 0.016f : C5685n.m((frameTimeNanos - h.this.lastFrameTimeNanos) / 1.0E9f, 0.0f, 0.1f);
                h.this.lastFrameTimeNanos = frameTimeNanos;
                InterfaceC5074l interfaceC5074l = h.this.callback;
                if (interfaceC5074l != null) {
                    interfaceC5074l.invoke(Float.valueOf(fM));
                }
                h.this.i();
            }
        }
    }

    /* renamed from: f, reason: from getter */
    public final boolean getRunning() {
        return this.running;
    }

    public final void g() {
        this.running = false;
        Choreographer.getInstance().removeFrameCallback(this.frameCallback);
    }

    public final void h() {
        if (this.running) {
            return;
        }
        this.running = true;
        this.lastFrameTimeNanos = 0L;
        Choreographer.getInstance().postFrameCallback(this.frameCallback);
    }

    public final void i() {
        int i10 = this.targetFps;
        if (i10 <= 0) {
            Choreographer.getInstance().postFrameCallback(this.frameCallback);
        } else {
            Choreographer.getInstance().postFrameCallbackDelayed(this.frameCallback, C5685n.g(1000 / i10, 1L));
        }
    }

    public final void j(int i10) {
        this.targetFps = i10;
    }

    public final void k(InterfaceC5074l<? super Float, Y8.t> onFrame) {
        kotlin.jvm.internal.p.i(onFrame, "onFrame");
        this.callback = onFrame;
        h();
    }

    public final void l() {
        g();
        this.callback = null;
    }
}
