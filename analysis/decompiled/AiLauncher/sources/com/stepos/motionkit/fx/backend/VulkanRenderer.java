package com.stepos.motionkit.fx.backend;

import B7.a;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.fx.backend.VulkanRenderer;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v7.i;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ \u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082 ¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\fH\u0082 ¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u0016J\r\u0010\u001b\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010-¨\u00060"}, d2 = {"Lcom/stepos/motionkit/fx/backend/VulkanRenderer;", "", "", "shaderSource", "LB7/a;", "binder", "Lv7/i;", "target", "<init>", "(Ljava/lang/String;LB7/a;Lv7/i;)V", "surface", "spirvSource", "", "nativeInit", "(Ljava/lang/Object;Ljava/lang/String;)J", "handle", "", "time", "LY8/t;", "nativeRenderFrame", "(JF)V", "nativeDestroy", "(J)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", "elapsedMs", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "LB7/a;", "c", "Lv7/i;", "Landroid/os/HandlerThread;", "Landroid/os/HandlerThread;", "renderThread", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "", "f", "Z", "running", "J", "nativeHandle", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VulkanRenderer {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String shaderSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final a binder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final i target;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final HandlerThread renderThread;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Handler handler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean running;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public long nativeHandle;

    static {
        try {
            System.loadLibrary("motionkit_vulkan");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public VulkanRenderer(String shaderSource, a binder, i target) {
        p.i(shaderSource, "shaderSource");
        p.i(binder, "binder");
        p.i(target, "target");
        this.shaderSource = shaderSource;
        this.binder = binder;
        this.target = target;
        HandlerThread handlerThread = new HandlerThread("VulkanRenderer");
        handlerThread.start();
        this.renderThread = handlerThread;
        this.handler = new Handler(handlerThread.getLooper());
    }

    public static final void f(VulkanRenderer vulkanRenderer, long j10) {
        vulkanRenderer.binder.e(j10);
        vulkanRenderer.nativeRenderFrame(vulkanRenderer.nativeHandle, j10 / 1000.0f);
    }

    public static final void h(VulkanRenderer vulkanRenderer) {
        vulkanRenderer.d();
    }

    public static final void j(VulkanRenderer vulkanRenderer) {
        long j10 = vulkanRenderer.nativeHandle;
        if (j10 != 0) {
            vulkanRenderer.nativeDestroy(j10);
            vulkanRenderer.nativeHandle = 0L;
        }
        vulkanRenderer.renderThread.quitSafely();
    }

    private final native void nativeDestroy(long handle);

    private final native long nativeInit(Object surface, String spirvSource);

    private final native void nativeRenderFrame(long handle, float time);

    public final void d() {
        Surface surface = this.target.getSurface();
        if (surface == null) {
            return;
        }
        this.nativeHandle = nativeInit(surface, this.shaderSource);
    }

    public final void e(final long elapsedMs) {
        if (!this.running || this.nativeHandle == 0) {
            return;
        }
        this.handler.post(new Runnable() { // from class: v7.E
            @Override // java.lang.Runnable
            public final void run() {
                VulkanRenderer.f(this.f42715a, elapsedMs);
            }
        });
    }

    public final void g() {
        this.running = true;
        this.handler.post(new Runnable() { // from class: v7.G
            @Override // java.lang.Runnable
            public final void run() {
                VulkanRenderer.h(this.f42718a);
            }
        });
    }

    public final void i() {
        this.running = false;
        this.handler.post(new Runnable() { // from class: v7.F
            @Override // java.lang.Runnable
            public final void run() {
                VulkanRenderer.j(this.f42717a);
            }
        });
    }
}
