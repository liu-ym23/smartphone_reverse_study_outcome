package androidx.camera.camera2.compat.workaround;

import Y8.h;
import android.hardware.camera2.CaptureResult;
import android.util.Log;
import androidx.camera.camera2.compat.quirk.UltraWideFlashCaptureUnderexposureQuirk;
import androidx.camera.camera2.compat.quirk.a;
import androidx.camera.camera2.compat.workaround.UseTorchAsFlashImpl;
import androidx.camera.camera2.pipe.g;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import r.K;
import u.InterfaceC5562j;
import w.C5708n;
import w.InterfaceC5705k;
import w.x;
import z.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ0\u0010\u0010\u001a\u00020\u000f2\u001e\u0010\u000e\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\nH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u000f*\u00020\fH\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0013¨\u0006\u001e"}, d2 = {"Landroidx/camera/camera2/compat/workaround/UseTorchAsFlashImpl;", "Lr/K;", "Landroidx/camera/camera2/compat/quirk/a;", "cameraQuirks", "Lw/k;", "cameraDevices", "Lu/j;", "intrinsicZoomCalculator", "<init>", "(Landroidx/camera/camera2/compat/quirk/a;Lw/k;Lu/j;)V", "Lkotlin/Function1;", "Le9/c;", "Lw/x;", "", "frameMetadata", "", Const.INTENT_KEY_PKGNAME, "(Lp9/l;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lw/x;)Ljava/lang/Boolean;", "Landroidx/camera/camera2/compat/quirk/a;", "Lw/k;", "c", "Lu/j;", Const.INTENT_KEY_UMID, "LY8/h;", "e", "hasUwCameraUnderexposedFlashCaptureQuirk", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UseTorchAsFlashImpl implements K {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final a cameraQuirks;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5705k cameraDevices;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5562j intrinsicZoomCalculator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final h hasUwCameraUnderexposedFlashCaptureQuirk;

    public UseTorchAsFlashImpl(a cameraQuirks, InterfaceC5705k cameraDevices, InterfaceC5562j intrinsicZoomCalculator) {
        p.i(cameraQuirks, "cameraQuirks");
        p.i(cameraDevices, "cameraDevices");
        p.i(intrinsicZoomCalculator, "intrinsicZoomCalculator");
        this.cameraQuirks = cameraQuirks;
        this.cameraDevices = cameraDevices;
        this.intrinsicZoomCalculator = intrinsicZoomCalculator;
        this.hasUwCameraUnderexposedFlashCaptureQuirk = C4848b.b(new InterfaceC5063a() { // from class: r.L
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(UseTorchAsFlashImpl.f(this.f38696a));
            }
        });
    }

    public static final boolean f(UseTorchAsFlashImpl useTorchAsFlashImpl) {
        return useTorchAsFlashImpl.cameraQuirks.b().a(UltraWideFlashCaptureUnderexposureQuirk.class);
    }

    @Override // r.K
    public boolean a() {
        return !e();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // r.K
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(p9.InterfaceC5074l<? super e9.InterfaceC4014c<? super w.x>, ? extends java.lang.Object> r6, e9.InterfaceC4014c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.camera.camera2.compat.workaround.UseTorchAsFlashImpl$shouldUseTorchAsFlash$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.camera.camera2.compat.workaround.UseTorchAsFlashImpl$shouldUseTorchAsFlash$1 r0 = (androidx.camera.camera2.compat.workaround.UseTorchAsFlashImpl$shouldUseTorchAsFlash$1) r0
            int r1 = r0.f9528c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9528c = r1
            goto L18
        L13:
            androidx.camera.camera2.compat.workaround.UseTorchAsFlashImpl$shouldUseTorchAsFlash$1 r0 = new androidx.camera.camera2.compat.workaround.UseTorchAsFlashImpl$shouldUseTorchAsFlash$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f9526a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f9528c
            java.lang.String r3 = "CXCP"
            r4 = 1
            if (r2 == 0) goto L33
            if (r2 != r4) goto L2b
            kotlin.C4849c.b(r7)
            goto L6a
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.C4849c.b(r7)
            z.k r7 = z.k.f44508a
            boolean r7 = r7.a()
            if (r7 == 0) goto L56
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "shouldUseTorchAsFlash: hasUwCameraUnderexposedFlashCaptureQuirk = "
            r7.append(r2)
            boolean r2 = d(r5)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r3, r7)
        L56:
            boolean r7 = r5.e()
            if (r7 != 0) goto L61
            java.lang.Boolean r5 = g9.C4109a.a(r4)
            return r5
        L61:
            r0.f9528c = r4
            java.lang.Object r7 = r6.invoke(r0)
            if (r7 != r1) goto L6a
            return r1
        L6a:
            w.x r7 = (w.x) r7
            if (r7 != 0) goto L80
            z.k r5 = z.k.f44508a
            boolean r5 = r5.d()
            if (r5 == 0) goto L7b
            java.lang.String r5 = "shouldUseTorchAsFlash: frameMetadata is null, defaulting to workaround for safety."
            android.util.Log.w(r3, r5)
        L7b:
            java.lang.Boolean r5 = g9.C4109a.a(r4)
            return r5
        L80:
            java.lang.Boolean r5 = r5.g(r7)
            if (r5 == 0) goto L8a
            boolean r4 = r5.booleanValue()
        L8a:
            java.lang.Boolean r5 = g9.C4109a.a(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.compat.workaround.UseTorchAsFlashImpl.b(p9.l, e9.c):java.lang.Object");
    }

    public final boolean e() {
        return ((Boolean) this.hasUwCameraUnderexposedFlashCaptureQuirk.getValue()).booleanValue();
    }

    public final Boolean g(x xVar) {
        CaptureResult.Key LOGICAL_MULTI_CAMERA_ACTIVE_PHYSICAL_ID = CaptureResult.LOGICAL_MULTI_CAMERA_ACTIVE_PHYSICAL_ID;
        p.h(LOGICAL_MULTI_CAMERA_ACTIVE_PHYSICAL_ID, "LOGICAL_MULTI_CAMERA_ACTIVE_PHYSICAL_ID");
        String str = (String) xVar.U(LOGICAL_MULTI_CAMERA_ACTIVE_PHYSICAL_ID);
        if (str == null) {
            if (k.f44508a.d()) {
                Log.w("CXCP", "isUltraWideCamera: could not get active physical camera ID to identify if it's ultra wide camera.");
            }
            return null;
        }
        g gVarA = InterfaceC5705k.a(this.cameraDevices, C5708n.b(str), null, 2, null);
        if (gVarA == null) {
            if (k.f44508a.d()) {
                Log.w("CXCP", "isUltraWideCamera: failed to get CameraMetadata for " + str);
            }
            return null;
        }
        Float fA = this.intrinsicZoomCalculator.a(gVarA);
        if (fA == null) {
            if (k.f44508a.d()) {
                Log.w("CXCP", "isUltraWideCamera: could not calculate intrinsic zoom ratio.");
            }
            return null;
        }
        float fFloatValue = fA.floatValue();
        if (k.f44508a.a()) {
            Log.d("CXCP", "isUltraWideCamera: cameraId = " + str + ", intrinsicZoomRatio = " + fFloatValue);
        }
        return Boolean.valueOf(fFloatValue < 1.0f);
    }
}
