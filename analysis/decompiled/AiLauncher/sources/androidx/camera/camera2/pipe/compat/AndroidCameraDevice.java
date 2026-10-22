package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Trace;
import android.util.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.f;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import w.C5706l;
import w.C5708n;
import w9.InterfaceC5745d;
import x.C5827m;
import x.I0;
import z.y;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0016\u001a\u00020\u00152\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010 \u001a\u00020\u00152\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b \u0010\u0017J%\u0010#\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b#\u0010\u0017J-\u0010&\u001a\u00020\u00152\u0006\u0010%\u001a\u00020$2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020!0\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020(H\u0017¢\u0006\u0004\b)\u0010*J\u0019\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b.\u0010/J\u0019\u00102\u001a\u0004\u0018\u00010-2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00107\u001a\u0002062\u0006\u00105\u001a\u000204H\u0017¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u000206H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u000206H\u0016¢\u0006\u0004\b;\u0010:J)\u0010@\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010=*\u00020<2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DJ%\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010E0F2\u0006\u0010\u0014\u001a\u00020EH\u0002¢\u0006\u0004\bG\u0010HJ\u0013\u0010I\u001a\u000206*\u00020EH\u0002¢\u0006\u0004\bI\u0010JJ\u0013\u0010K\u001a\u000206*\u00020EH\u0002¢\u0006\u0004\bK\u0010JR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010LR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010DR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Z\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010YR\u001c\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E0[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]¨\u0006_"}, d2 = {"Landroidx/camera/camera2/pipe/compat/a;", "Landroidx/camera/camera2/pipe/compat/p;", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "Landroid/hardware/camera2/CameraDevice;", "cameraDevice", "Lw/n;", "cameraId", "LB/c;", "cameraErrorListener", "Landroidx/camera/camera2/pipe/f$b;", "interopCaptureSessionListener", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "<init>", "(Landroidx/camera/camera2/pipe/g;Landroid/hardware/camera2/CameraDevice;Ljava/lang/String;LB/c;Landroidx/camera/camera2/pipe/f$b;Landroidx/camera/camera2/pipe/core/Threads;Lkotlin/jvm/internal/i;)V", "", "Landroid/view/Surface;", "outputs", "Landroidx/camera/camera2/pipe/compat/o$a;", "stateCallback", "", "N0", "(Ljava/util/List;Landroidx/camera/camera2/pipe/compat/o$a;)Z", "Landroidx/camera/camera2/pipe/compat/t;", "config", "T0", "(Landroidx/camera/camera2/pipe/compat/t;)Z", "Landroid/hardware/camera2/params/InputConfiguration;", "input", "f1", "(Landroid/hardware/camera2/params/InputConfiguration;Ljava/util/List;Landroidx/camera/camera2/pipe/compat/o$a;)Z", "Y", "Lx/w0;", "outputConfigurations", "Y0", "Lx/u0;", "inputConfig", "m", "(Lx/u0;Ljava/util/List;Landroidx/camera/camera2/pipe/compat/o$a;)Z", "Landroidx/camera/camera2/pipe/compat/v;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroidx/camera/camera2/pipe/compat/v;)Z", "Lw/M;", M5.e.FAIL_TEMPLATE, "Landroid/hardware/camera2/CaptureRequest$Builder;", "J", "(I)Landroid/hardware/camera2/CaptureRequest$Builder;", "Landroid/hardware/camera2/TotalCaptureResult;", "inputResult", "D0", "(Landroid/hardware/camera2/TotalCaptureResult;)Landroid/hardware/camera2/CaptureRequest$Builder;", "Landroidx/camera/camera2/pipe/a;", "mode", "LY8/t;", Const.INTENT_KEY_APIKEY, "(I)V", "G", "()V", "k1", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lx/I0;", "Lkotlin/Pair;", "o", "(Lx/I0;)Lkotlin/Pair;", "q", "(Lx/I0;)V", "r", "Landroidx/camera/camera2/pipe/g;", Const.INTENT_KEY_PKGNAME, "Landroid/hardware/camera2/CameraDevice;", "c", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "LB/c;", "e", "Landroidx/camera/camera2/pipe/f$b;", "f", "Landroidx/camera/camera2/pipe/core/Threads;", "LOa/a;", "LOa/a;", AlipayXuiIsland.REASON_CLOSED, "LOa/e;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LOa/e;", "_lastStateCallback", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: androidx.camera.camera2.pipe.compat.a, reason: from toString */
/* loaded from: classes.dex */
public final class AndroidCameraDevice implements p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.g cameraMetadata;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CameraDevice cameraDevice;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String cameraId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final B.c cameraErrorListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final f.b interopCaptureSessionListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Oa.a closed;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Oa.e<I0> _lastStateCallback;

    public /* synthetic */ AndroidCameraDevice(androidx.camera.camera2.pipe.g gVar, CameraDevice cameraDevice, String str, B.c cVar, f.b bVar, Threads threads, kotlin.jvm.internal.i iVar) {
        this(gVar, cameraDevice, str, cVar, bVar, threads);
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public CaptureRequest.Builder D0(TotalCaptureResult inputResult) throws Throwable {
        double d10;
        String cameraId;
        CaptureRequest.Builder builderCreateReprocessCaptureRequest;
        kotlin.jvm.internal.p.i(inputResult, "inputResult");
        z.h hVar = z.h.f44503a;
        String str = "CXCP#createReprocessCaptureRequest-" + getCameraId();
        long jA = hVar.g().a();
        try {
            Trace.beginSection(str);
            cameraId = getCameraId();
            d10 = 1000000.0d;
        } catch (Throwable th) {
            th = th;
            d10 = 1000000.0d;
        }
        try {
            B.c cVar = this.cameraErrorListener;
            try {
                builderCreateReprocessCaptureRequest = this.cameraDevice.createReprocessCaptureRequest(inputResult);
            } catch (Exception e10) {
                if (e10 instanceof CameraAccessException) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                    }
                    cVar.a(cameraId, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                } else if ((e10 instanceof IllegalArgumentException) || (e10 instanceof SecurityException) || (e10 instanceof UnsupportedOperationException) || (e10 instanceof NullPointerException)) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
                    }
                    cVar.a(cameraId, C5706l.INSTANCE.m(), false);
                } else {
                    if (!(e10 instanceof IllegalStateException)) {
                        throw e10;
                    }
                    if (z.k.f44508a.a()) {
                        Log.d("CXCP", "Failed to execute call: Camera may be closed");
                    }
                }
                builderCreateReprocessCaptureRequest = null;
            }
            Trace.endSection();
            long jC = z.i.c(hVar.g().a() - jA);
            if (z.k.f44508a.a()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" - ");
                y yVar = y.f44525a;
                String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                kotlin.jvm.internal.p.h(str2, "format(...)");
                sb2.append(str2);
                Log.d("CXCP", sb2.toString());
            }
            return builderCreateReprocessCaptureRequest;
        } catch (Throwable th2) {
            th = th2;
            Trace.endSection();
            long jC2 = z.i.c(hVar.g().a() - jA);
            if (z.k.f44508a.a()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" - ");
                y yVar2 = y.f44525a;
                String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC2 / d10)}, 1));
                kotlin.jvm.internal.p.h(str3, "format(...)");
                sb3.append(str3);
                Log.d("CXCP", sb3.toString());
            }
            throw th;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public void G() {
        I0 i0C;
        if (!this.closed.a(false, true) || (i0C = this._lastStateCallback.c()) == null) {
            return;
        }
        q(i0C);
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public CaptureRequest.Builder J(int template) throws Throwable {
        double d10;
        CaptureRequest.Builder builderCreateCaptureRequest;
        z.h hVar = z.h.f44503a;
        String str = "CXCP#createCaptureRequest-" + getCameraId();
        long jA = hVar.g().a();
        try {
            Trace.beginSection(str);
            String cameraId = getCameraId();
            d10 = 1000000.0d;
            try {
                B.c cVar = this.cameraErrorListener;
                try {
                    builderCreateCaptureRequest = this.cameraDevice.createCaptureRequest(template);
                } catch (Exception e10) {
                    if (e10 instanceof CameraAccessException) {
                        if (z.k.f44508a.d()) {
                            Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                        }
                        cVar.a(cameraId, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                    } else if ((e10 instanceof IllegalArgumentException) || (e10 instanceof SecurityException) || (e10 instanceof UnsupportedOperationException) || (e10 instanceof NullPointerException)) {
                        if (z.k.f44508a.d()) {
                            Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
                        }
                        cVar.a(cameraId, C5706l.INSTANCE.m(), false);
                    } else {
                        if (!(e10 instanceof IllegalStateException)) {
                            throw e10;
                        }
                        if (z.k.f44508a.a()) {
                            Log.d("CXCP", "Failed to execute call: Camera may be closed");
                        }
                    }
                    builderCreateCaptureRequest = null;
                }
                Trace.endSection();
                long jC = z.i.c(hVar.g().a() - jA);
                if (z.k.f44508a.a()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" - ");
                    y yVar = y.f44525a;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                    kotlin.jvm.internal.p.h(str2, "format(...)");
                    sb2.append(str2);
                    Log.d("CXCP", sb2.toString());
                }
                return builderCreateCaptureRequest;
            } catch (Throwable th) {
                th = th;
                Trace.endSection();
                long jC2 = z.i.c(hVar.g().a() - jA);
                if (z.k.f44508a.a()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(" - ");
                    y yVar2 = y.f44525a;
                    String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC2 / d10)}, 1));
                    kotlin.jvm.internal.p.h(str3, "format(...)");
                    sb3.append(str3);
                    Log.d("CXCP", sb3.toString());
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            d10 = 1000000.0d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00de A[Catch: all -> 0x00b0, TryCatch #0 {all -> 0x00b0, blocks: (B:17:0x009d, B:33:0x00da, B:35:0x00de, B:37:0x00e6, B:38:0x00fe, B:41:0x010c, B:43:0x0110, B:45:0x0114, B:47:0x0118, B:50:0x011d, B:52:0x0121, B:54:0x0129, B:55:0x012f, B:56:0x0130, B:58:0x0138, B:59:0x0150), top: B:83:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010c A[Catch: all -> 0x00b0, TryCatch #0 {all -> 0x00b0, blocks: (B:17:0x009d, B:33:0x00da, B:35:0x00de, B:37:0x00e6, B:38:0x00fe, B:41:0x010c, B:43:0x0110, B:45:0x0114, B:47:0x0118, B:50:0x011d, B:52:0x0121, B:54:0x0129, B:55:0x012f, B:56:0x0130, B:58:0x0138, B:59:0x0150), top: B:83:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x020c  */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v2, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7, types: [int] */
    @Override // androidx.camera.camera2.pipe.compat.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean N0(java.util.List<? extends android.view.Surface> r27, androidx.camera.camera2.pipe.compat.o.a r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.AndroidCameraDevice.N0(java.util.List, androidx.camera.camera2.pipe.compat.o$a):boolean");
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (!kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(CameraDevice.class))) {
            return null;
        }
        T t10 = (T) this.cameraDevice;
        kotlin.jvm.internal.p.g(t10, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.AndroidCameraDevice.unwrapAs");
        return t10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014e A[Catch: all -> 0x010b, TryCatch #5 {all -> 0x010b, blocks: (B:32:0x00ea, B:34:0x00f7, B:36:0x0107, B:41:0x0115, B:42:0x011c, B:43:0x011d, B:54:0x014a, B:56:0x014e, B:58:0x0156, B:59:0x016e, B:62:0x017c, B:64:0x0180, B:66:0x0184, B:68:0x0188, B:71:0x018d, B:73:0x0191, B:75:0x0199, B:76:0x019f, B:77:0x01a0, B:79:0x01a8, B:80:0x01c0), top: B:110:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017c A[Catch: all -> 0x010b, TryCatch #5 {all -> 0x010b, blocks: (B:32:0x00ea, B:34:0x00f7, B:36:0x0107, B:41:0x0115, B:42:0x011c, B:43:0x011d, B:54:0x014a, B:56:0x014e, B:58:0x0156, B:59:0x016e, B:62:0x017c, B:64:0x0180, B:66:0x0184, B:68:0x0188, B:71:0x018d, B:73:0x0191, B:75:0x0199, B:76:0x019f, B:77:0x01a0, B:79:0x01a8, B:80:0x01c0), top: B:110:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x027c  */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v8, types: [int] */
    @Override // androidx.camera.camera2.pipe.compat.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean T0(androidx.camera.camera2.pipe.compat.ExtensionSessionConfigData r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 717
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.AndroidCameraDevice.T0(androidx.camera.camera2.pipe.compat.t):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022e A[Catch: all -> 0x0104, TryCatch #3 {all -> 0x0104, blocks: (B:24:0x00e7, B:26:0x00f4, B:31:0x010f, B:33:0x0115, B:35:0x011b, B:43:0x0164, B:45:0x0177, B:46:0x0198, B:48:0x019e, B:49:0x01ac, B:50:0x01b8, B:52:0x01be, B:54:0x01d0, B:56:0x01dd, B:57:0x01e1, B:59:0x01fd, B:61:0x0206, B:62:0x0209, B:64:0x020b, B:65:0x020e, B:36:0x011f, B:38:0x0127, B:40:0x0143, B:42:0x014b, B:73:0x022a, B:75:0x022e, B:77:0x0236, B:78:0x024e, B:81:0x025e, B:83:0x0264, B:85:0x0268, B:87:0x026c, B:90:0x0271, B:92:0x0275, B:94:0x027d, B:95:0x0283, B:96:0x0284, B:98:0x028c, B:99:0x02a4), top: B:123:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x025e A[Catch: all -> 0x0104, TryCatch #3 {all -> 0x0104, blocks: (B:24:0x00e7, B:26:0x00f4, B:31:0x010f, B:33:0x0115, B:35:0x011b, B:43:0x0164, B:45:0x0177, B:46:0x0198, B:48:0x019e, B:49:0x01ac, B:50:0x01b8, B:52:0x01be, B:54:0x01d0, B:56:0x01dd, B:57:0x01e1, B:59:0x01fd, B:61:0x0206, B:62:0x0209, B:64:0x020b, B:65:0x020e, B:36:0x011f, B:38:0x0127, B:40:0x0143, B:42:0x014b, B:73:0x022a, B:75:0x022e, B:77:0x0236, B:78:0x024e, B:81:0x025e, B:83:0x0264, B:85:0x0268, B:87:0x026c, B:90:0x0271, B:92:0x0275, B:94:0x027d, B:95:0x0283, B:96:0x0284, B:98:0x028c, B:99:0x02a4), top: B:123:0x0065 }] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v7, types: [int] */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // androidx.camera.camera2.pipe.compat.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean V(androidx.camera.camera2.pipe.compat.v r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 928
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.AndroidCameraDevice.V(androidx.camera.camera2.pipe.compat.v):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00de A[Catch: all -> 0x00b0, TryCatch #0 {all -> 0x00b0, blocks: (B:17:0x009d, B:33:0x00da, B:35:0x00de, B:37:0x00e6, B:38:0x00fe, B:41:0x010c, B:43:0x0110, B:45:0x0114, B:47:0x0118, B:50:0x011d, B:52:0x0121, B:54:0x0129, B:55:0x012f, B:56:0x0130, B:58:0x0138, B:59:0x0150), top: B:83:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010c A[Catch: all -> 0x00b0, TryCatch #0 {all -> 0x00b0, blocks: (B:17:0x009d, B:33:0x00da, B:35:0x00de, B:37:0x00e6, B:38:0x00fe, B:41:0x010c, B:43:0x0110, B:45:0x0114, B:47:0x0118, B:50:0x011d, B:52:0x0121, B:54:0x0129, B:55:0x012f, B:56:0x0130, B:58:0x0138, B:59:0x0150), top: B:83:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x020c  */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v2, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7, types: [int] */
    @Override // androidx.camera.camera2.pipe.compat.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean Y(java.util.List<? extends android.view.Surface> r27, androidx.camera.camera2.pipe.compat.o.a r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.AndroidCameraDevice.Y(java.util.List, androidx.camera.camera2.pipe.compat.o$a):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa A[Catch: all -> 0x00df, TryCatch #8 {all -> 0x00df, blocks: (B:26:0x00cc, B:38:0x00f6, B:40:0x00fa, B:42:0x0102, B:43:0x011a, B:46:0x0128, B:48:0x012c, B:50:0x0130, B:52:0x0134, B:55:0x0139, B:57:0x013d, B:59:0x0145, B:60:0x014b, B:61:0x014c, B:63:0x0154, B:64:0x016c), top: B:93:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0128 A[Catch: all -> 0x00df, TryCatch #8 {all -> 0x00df, blocks: (B:26:0x00cc, B:38:0x00f6, B:40:0x00fa, B:42:0x0102, B:43:0x011a, B:46:0x0128, B:48:0x012c, B:50:0x0130, B:52:0x0134, B:55:0x0139, B:57:0x013d, B:59:0x0145, B:60:0x014b, B:61:0x014c, B:63:0x0154, B:64:0x016c), top: B:93:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x022f  */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v8, types: [int] */
    @Override // androidx.camera.camera2.pipe.compat.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean Y0(java.util.List<? extends x.w0> r25, androidx.camera.camera2.pipe.compat.o.a r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.AndroidCameraDevice.Y0(java.util.List, androidx.camera.camera2.pipe.compat.o$a):boolean");
    }

    @Override // androidx.camera.camera2.pipe.compat.j.a
    public void a(int mode) {
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection("setCameraAudioRestriction");
            String cameraId = getCameraId();
            B.c cVar = this.cameraErrorListener;
            try {
                C5827m.b(this.cameraDevice, mode);
                Y8.t tVar = Y8.t.f7040a;
            } catch (Exception e10) {
                if (e10 instanceof CameraAccessException) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                    }
                    cVar.a(cameraId, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                } else if ((e10 instanceof IllegalArgumentException) || (e10 instanceof SecurityException) || (e10 instanceof UnsupportedOperationException) || (e10 instanceof NullPointerException)) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
                    }
                    cVar.a(cameraId, C5706l.INSTANCE.m(), false);
                } else {
                    if (!(e10 instanceof IllegalStateException)) {
                        throw e10;
                    }
                    if (z.k.f44508a.a()) {
                        Log.d("CXCP", "Failed to execute call: Camera may be closed");
                    }
                }
            }
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f4 A[Catch: all -> 0x00bb, TryCatch #5 {all -> 0x00bb, blocks: (B:15:0x00a8, B:31:0x00f0, B:33:0x00f4, B:35:0x00fc, B:36:0x0114, B:38:0x0121, B:40:0x0125, B:42:0x0129, B:44:0x012d, B:47:0x0132, B:49:0x0136, B:51:0x013e, B:52:0x0144, B:53:0x0145, B:55:0x014d, B:56:0x0165), top: B:84:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0121 A[Catch: all -> 0x00bb, TryCatch #5 {all -> 0x00bb, blocks: (B:15:0x00a8, B:31:0x00f0, B:33:0x00f4, B:35:0x00fc, B:36:0x0114, B:38:0x0121, B:40:0x0125, B:42:0x0129, B:44:0x012d, B:47:0x0132, B:49:0x0136, B:51:0x013e, B:52:0x0144, B:53:0x0145, B:55:0x014d, B:56:0x0165), top: B:84:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x022a  */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r14v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v5, types: [B.c] */
    @Override // androidx.camera.camera2.pipe.compat.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean f1(android.hardware.camera2.params.InputConfiguration r27, java.util.List<? extends android.view.Surface> r28, androidx.camera.camera2.pipe.compat.o.a r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 619
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.AndroidCameraDevice.f1(android.hardware.camera2.params.InputConfiguration, java.util.List, androidx.camera.camera2.pipe.compat.o$a):boolean");
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    /* renamed from: g, reason: from getter */
    public String getCameraId() {
        return this.cameraId;
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public void k1() {
        if (!this.closed.b()) {
            throw new IllegalStateException("Check failed.");
        }
        I0 i0B = this._lastStateCallback.b(null);
        if (i0B != null) {
            r(i0B);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011b A[Catch: all -> 0x00fe, TryCatch #6 {all -> 0x00fe, blocks: (B:26:0x00eb, B:38:0x0117, B:40:0x011b, B:42:0x0123, B:43:0x013b, B:45:0x0148, B:47:0x014c, B:49:0x0150, B:51:0x0154, B:54:0x0159, B:56:0x015d, B:58:0x0165, B:59:0x016b, B:60:0x016c, B:62:0x0174, B:63:0x018c), top: B:93:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0148 A[Catch: all -> 0x00fe, TryCatch #6 {all -> 0x00fe, blocks: (B:26:0x00eb, B:38:0x0117, B:40:0x011b, B:42:0x0123, B:43:0x013b, B:45:0x0148, B:47:0x014c, B:49:0x0150, B:51:0x0154, B:54:0x0159, B:56:0x015d, B:58:0x0165, B:59:0x016b, B:60:0x016c, B:62:0x0174, B:63:0x018c), top: B:93:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024f  */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v7, types: [int] */
    @Override // androidx.camera.camera2.pipe.compat.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m(x.InputConfigData r26, java.util.List<? extends x.w0> r27, androidx.camera.camera2.pipe.compat.o.a r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.AndroidCameraDevice.m(x.u0, java.util.List, androidx.camera.camera2.pipe.compat.o$a):boolean");
    }

    public final Pair<Boolean, I0> o(I0 stateCallback) {
        if (!this.closed.b()) {
            return new Pair<>(Boolean.TRUE, this._lastStateCallback.b(stateCallback));
        }
        r(stateCallback);
        return new Pair<>(Boolean.FALSE, null);
    }

    public final void q(I0 i02) {
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection(this + "#onSessionDisconnected");
            i02.h();
            Y8.t tVar = Y8.t.f7040a;
        } finally {
            Trace.endSection();
        }
    }

    public final void r(I0 i02) {
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection(this + "#onSessionFinalized");
            i02.a();
            Y8.t tVar = Y8.t.f7040a;
        } finally {
            Trace.endSection();
        }
    }

    public String toString() {
        return "AndroidCameraDevice(camera=" + ((Object) C5708n.f(getCameraId())) + ')';
    }

    public AndroidCameraDevice(androidx.camera.camera2.pipe.g cameraMetadata, CameraDevice cameraDevice, String cameraId, B.c cameraErrorListener, f.b bVar, Threads threads) {
        kotlin.jvm.internal.p.i(cameraMetadata, "cameraMetadata");
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        kotlin.jvm.internal.p.i(cameraErrorListener, "cameraErrorListener");
        kotlin.jvm.internal.p.i(threads, "threads");
        this.cameraMetadata = cameraMetadata;
        this.cameraDevice = cameraDevice;
        this.cameraId = cameraId;
        this.cameraErrorListener = cameraErrorListener;
        this.interopCaptureSessionListener = bVar;
        this.threads = threads;
        this.closed = Oa.b.a(false);
        this._lastStateCallback = Oa.b.g(null);
    }
}
