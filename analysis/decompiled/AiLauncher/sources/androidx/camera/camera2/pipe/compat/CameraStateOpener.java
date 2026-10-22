package androidx.camera.camera2.pipe.compat;

import Ua.C1087w;
import Ua.InterfaceC1083u;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.h;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import x.C5810d0;
import x.InterfaceC5808c0;
import x.InterfaceC5818h0;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 22\u00020\u0001:\u0001\"BC\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0080@¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0004\b \u0010!R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010&R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010'R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u001f0.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CameraStateOpener;", "", "Lx/h0;", "cameraOpener", "Lx/c0;", "camera2MetadataProvider", "LB/c;", "cameraErrorListener", "Lx/d0;", "camera2Quirks", "Lz/w;", "timeSource", "Landroidx/camera/camera2/pipe/h$b;", "cameraInteropConfig", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "<init>", "(Lx/h0;Lx/c0;LB/c;Lx/d0;Lz/w;Landroidx/camera/camera2/pipe/h$b;Landroidx/camera/camera2/pipe/core/Threads;)V", "Lw/n;", "cameraId", "", "attempts", "Lz/x;", "requestTimestamp", "Lx/W;", "camera2DeviceCloser", "Landroidx/camera/camera2/pipe/compat/j;", "audioRestrictionController", "Lx/v0;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;IJLx/W;Landroidx/camera/camera2/pipe/compat/j;Le9/c;)Ljava/lang/Object;", "LY8/t;", "c", "()V", Const.INTENT_KEY_APIKEY, "Lx/h0;", Const.INTENT_KEY_PKGNAME, "Lx/c0;", "LB/c;", "Lx/d0;", "e", "Lz/w;", "f", "Landroidx/camera/camera2/pipe/h$b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/camera/camera2/pipe/core/Threads;", "LUa/u;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LUa/u;", "cameraOpenCancelled", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CameraStateOpener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5818h0 cameraOpener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5808c0 camera2MetadataProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final B.c cameraErrorListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C5810d0 camera2Quirks;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final z.w timeSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final h.CameraInteropConfig cameraInteropConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1083u<Y8.t> cameraOpenCancelled;

    public CameraStateOpener(InterfaceC5818h0 cameraOpener, InterfaceC5808c0 camera2MetadataProvider, B.c cameraErrorListener, C5810d0 camera2Quirks, z.w timeSource, h.CameraInteropConfig cameraInteropConfig, Threads threads) {
        kotlin.jvm.internal.p.i(cameraOpener, "cameraOpener");
        kotlin.jvm.internal.p.i(camera2MetadataProvider, "camera2MetadataProvider");
        kotlin.jvm.internal.p.i(cameraErrorListener, "cameraErrorListener");
        kotlin.jvm.internal.p.i(camera2Quirks, "camera2Quirks");
        kotlin.jvm.internal.p.i(timeSource, "timeSource");
        kotlin.jvm.internal.p.i(threads, "threads");
        this.cameraOpener = cameraOpener;
        this.camera2MetadataProvider = camera2MetadataProvider;
        this.cameraErrorListener = cameraErrorListener;
        this.camera2Quirks = camera2Quirks;
        this.timeSource = timeSource;
        this.cameraInteropConfig = cameraInteropConfig;
        this.threads = threads;
        this.cameraOpenCancelled = C1087w.c(null, 1, null);
    }

    public final void c() {
        this.cameraOpenCancelled.complete(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r23, int r24, long r25, x.W r27, androidx.camera.camera2.pipe.compat.j r28, e9.InterfaceC4014c<? super x.OpenCameraResult> r29) throws java.lang.Throwable {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r29
            boolean r3 = r2 instanceof androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$1
            if (r3 == 0) goto L19
            r3 = r2
            androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$1 r3 = (androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$1) r3
            int r4 = r3.f10425h
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.f10425h = r4
            goto L1e
        L19:
            androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$1 r3 = new androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$1
            r3.<init>(r0, r2)
        L1e:
            java.lang.Object r2 = r3.f10423f
            java.lang.Object r4 = f9.C4063a.g()
            int r5 = r3.f10425h
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L54
            if (r5 == r7) goto L3a
            if (r5 != r6) goto L32
            kotlin.C4849c.b(r2)
            return r2
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3a:
            long r7 = r3.f10422e
            int r1 = r3.f10421d
            java.lang.Object r5 = r3.f10420c
            androidx.camera.camera2.pipe.compat.j r5 = (androidx.camera.camera2.pipe.compat.j) r5
            java.lang.Object r9 = r3.f10419b
            x.W r9 = (x.W) r9
            java.lang.Object r10 = r3.f10418a
            java.lang.String r10 = (java.lang.String) r10
            kotlin.C4849c.b(r2)
            r18 = r5
            r11 = r7
            r15 = r9
            r8 = r10
            r10 = r1
            goto L7a
        L54:
            kotlin.C4849c.b(r2)
            x.c0 r2 = r0.camera2MetadataProvider
            r3.f10418a = r1
            r5 = r27
            r3.f10419b = r5
            r8 = r28
            r3.f10420c = r8
            r9 = r24
            r3.f10421d = r9
            r10 = r25
            r3.f10422e = r10
            r3.f10425h = r7
            java.lang.Object r2 = r2.c(r1, r3)
            if (r2 != r4) goto L74
            goto Lbf
        L74:
            r15 = r5
            r18 = r8
            r11 = r10
            r8 = r1
            r10 = r9
        L7a:
            r9 = r2
            androidx.camera.camera2.pipe.g r9 = (androidx.camera.camera2.pipe.g) r9
            androidx.camera.camera2.pipe.compat.AndroidCameraState r7 = new androidx.camera.camera2.pipe.compat.AndroidCameraState
            z.w r13 = r0.timeSource
            B.c r14 = r0.cameraErrorListener
            x.d0 r1 = r0.camera2Quirks
            androidx.camera.camera2.pipe.core.Threads r2 = r0.threads
            androidx.camera.camera2.pipe.h$b r5 = r0.cameraInteropConfig
            r6 = 0
            if (r5 == 0) goto L93
            android.hardware.camera2.CameraDevice$StateCallback r5 = r5.getCameraDeviceStateCallback()
            r19 = r5
            goto L95
        L93:
            r19 = r6
        L95:
            androidx.camera.camera2.pipe.h$b r5 = r0.cameraInteropConfig
            if (r5 == 0) goto La0
            androidx.camera.camera2.pipe.f$b r5 = r5.getCameraCaptureSessionListener()
            r20 = r5
            goto La2
        La0:
            r20 = r6
        La2:
            r21 = 0
            r16 = r1
            r17 = r2
            r7.<init>(r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2 r1 = new androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2
            r1.<init>(r0, r8, r7, r6)
            r3.f10418a = r6
            r3.f10419b = r6
            r3.f10420c = r6
            r0 = 2
            r3.f10425h = r0
            java.lang.Object r0 = Ua.L0.c(r1, r3)
            if (r0 != r4) goto Lc0
        Lbf:
            return r4
        Lc0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.CameraStateOpener.d(java.lang.String, int, long, x.W, androidx.camera.camera2.pipe.compat.j, e9.c):java.lang.Object");
    }
}
