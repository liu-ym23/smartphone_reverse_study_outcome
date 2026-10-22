package v7;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RuntimeShader;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010'R\u0016\u00100\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010'¨\u00061"}, d2 = {"Lv7/b;", "", "", "source", "LB7/a;", "binder", "Lv7/i;", "target", "<init>", "(Ljava/lang/String;LB7/a;Lv7/i;)V", "LY8/t;", Const.INTENT_KEY_UMID, "()V", "", "elapsedMs", Const.INTENT_KEY_PKGNAME, "(J)V", "e", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "LB7/a;", "c", "Lv7/i;", "Landroid/graphics/RuntimeShader;", "Landroid/graphics/RuntimeShader;", "shader", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "Landroid/os/HandlerThread;", "f", "Landroid/os/HandlerThread;", "renderThread", "Landroid/os/Handler;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/os/Handler;", "handler", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Z", "running", "Ljava/util/concurrent/atomic/AtomicBoolean;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/concurrent/atomic/AtomicBoolean;", "framePending", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "hasResolution", "k", "hasTime", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: v7.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5665b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final B7.a binder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final i target;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final RuntimeShader shader;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Paint paint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final HandlerThread renderThread;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Handler handler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public boolean running;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean framePending;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean hasResolution;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public boolean hasTime;

    public C5665b(String source, B7.a binder, i target) {
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.jvm.internal.p.i(binder, "binder");
        kotlin.jvm.internal.p.i(target, "target");
        this.source = source;
        this.binder = binder;
        this.target = target;
        RuntimeShader runtimeShader = new RuntimeShader(source);
        this.shader = runtimeShader;
        Paint paint = new Paint();
        paint.setShader(runtimeShader);
        this.paint = paint;
        HandlerThread handlerThread = new HandlerThread("AgslRenderer");
        handlerThread.start();
        this.renderThread = handlerThread;
        this.handler = new Handler(handlerThread.getLooper());
        this.framePending = new AtomicBoolean(false);
        this.hasResolution = true;
        this.hasTime = true;
    }

    public static final void c(C5665b c5665b, long j10) {
        Canvas canvasLockHardwareCanvas;
        c5665b.framePending.set(false);
        Surface surface = c5665b.target.getSurface();
        if (surface == null || !surface.isValid() || (canvasLockHardwareCanvas = surface.lockHardwareCanvas()) == null) {
            return;
        }
        try {
            canvasLockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            c5665b.binder.e(j10);
            c5665b.binder.a(c5665b.shader);
            if (c5665b.hasResolution) {
                try {
                    c5665b.shader.setFloatUniform("iResolution", canvasLockHardwareCanvas.getWidth(), canvasLockHardwareCanvas.getHeight());
                } catch (IllegalArgumentException unused) {
                    c5665b.hasResolution = false;
                }
            }
            if (c5665b.hasTime) {
                try {
                    c5665b.shader.setFloatUniform("iTime", j10 / 1000.0f);
                } catch (IllegalArgumentException unused2) {
                    c5665b.hasTime = false;
                }
            }
            canvasLockHardwareCanvas.drawRect(0.0f, 0.0f, canvasLockHardwareCanvas.getWidth(), canvasLockHardwareCanvas.getHeight(), c5665b.paint);
            surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
        } catch (Throwable th) {
            surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
            throw th;
        }
    }

    public final void b(final long elapsedMs) {
        if (this.running && this.framePending.compareAndSet(false, true)) {
            this.handler.post(new Runnable() { // from class: v7.a
                @Override // java.lang.Runnable
                public final void run() {
                    C5665b.c(this.f42719a, elapsedMs);
                }
            });
        }
    }

    public final void d() {
        this.running = true;
    }

    public final void e() {
        this.running = false;
        this.renderThread.quitSafely();
    }
}
