package x;

import Z8.C1174w;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Handler;
import android.os.Trace;
import android.util.Log;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import w.C5706l;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0018\u001a\u0004\u0018\u00010\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001a\u001a\u0004\u0018\u00010\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J!\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u000f\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u000eJ\u001d\u0010\u001f\u001a\u00020\f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016H\u0017¢\u0006\u0004\b\u001f\u0010 J)\u0010$\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u001a*\u00020!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001a\u00108\u001a\u0002038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0004\u0018\u0001098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Lx/b;", "Landroidx/camera/camera2/pipe/compat/o;", "Landroidx/camera/camera2/pipe/compat/p;", Parameters.DEVICE, "Landroid/hardware/camera2/CameraCaptureSession;", "cameraCaptureSession", "LB/c;", "cameraErrorListener", "Landroid/os/Handler;", "callbackHandler", "<init>", "(Landroidx/camera/camera2/pipe/compat/p;Landroid/hardware/camera2/CameraCaptureSession;LB/c;Landroid/os/Handler;)V", "", "f", "()Z", "Landroid/hardware/camera2/CaptureRequest;", "request", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "listener", "", "F0", "(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Ljava/lang/Integer;", "", "requests", "p", "(Ljava/util/List;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Ljava/lang/Integer;", ExifInterface.GPS_DIRECTION_TRUE, "q0", "stopRepeating", "Lx/w0;", "outputConfigs", "f0", "(Ljava/util/List;)Z", "", "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "LY8/t;", "close", "()V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/p;", "getDevice", "()Landroidx/camera/camera2/pipe/compat/p;", Const.INTENT_KEY_PKGNAME, "Landroid/hardware/camera2/CameraCaptureSession;", "c", "LB/c;", Const.INTENT_KEY_UMID, "Landroid/os/Handler;", "Landroidx/camera/camera2/pipe/f$a;", "e", "I", "w", "()I", "id", "Landroid/view/Surface;", "getInputSurface", "()Landroid/view/Surface;", "inputSurface", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5805b implements androidx.camera.camera2.pipe.compat.o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.compat.p device;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CameraCaptureSession cameraCaptureSession;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final B.c cameraErrorListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Handler callbackHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int id;

    public C5805b(androidx.camera.camera2.pipe.compat.p device, CameraCaptureSession cameraCaptureSession, B.c cameraErrorListener, Handler callbackHandler) {
        kotlin.jvm.internal.p.i(device, "device");
        kotlin.jvm.internal.p.i(cameraCaptureSession, "cameraCaptureSession");
        kotlin.jvm.internal.p.i(cameraErrorListener, "cameraErrorListener");
        kotlin.jvm.internal.p.i(callbackHandler, "callbackHandler");
        this.device = device;
        this.cameraCaptureSession = cameraCaptureSession;
        this.cameraErrorListener = cameraErrorListener;
        this.callbackHandler = callbackHandler;
        this.id = androidx.camera.camera2.pipe.f.a();
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public Integer F0(CaptureRequest request, CameraCaptureSession.CaptureCallback listener) throws Throwable {
        double d10;
        Integer numValueOf;
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(listener, "listener");
        z.h hVar = z.h.f44503a;
        String str = "CXCP#capture-" + getDevice().g();
        long jA = hVar.g().a();
        try {
            Trace.beginSection(str);
            d10 = 1000000.0d;
        } catch (Throwable th) {
            th = th;
            d10 = 1000000.0d;
        }
        try {
            String strG = getDevice().g();
            B.c cVar = this.cameraErrorListener;
            try {
                numValueOf = Integer.valueOf(this.cameraCaptureSession.capture(request, listener, this.callbackHandler));
            } catch (Exception e10) {
                if (e10 instanceof CameraAccessException) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                    }
                    cVar.a(strG, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                } else if ((e10 instanceof IllegalArgumentException) || (e10 instanceof SecurityException) || (e10 instanceof UnsupportedOperationException) || (e10 instanceof NullPointerException)) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
                    }
                    cVar.a(strG, C5706l.INSTANCE.m(), false);
                } else {
                    if (!(e10 instanceof IllegalStateException)) {
                        throw e10;
                    }
                    if (z.k.f44508a.a()) {
                        Log.d("CXCP", "Failed to execute call: Camera may be closed");
                    }
                }
                numValueOf = null;
            }
            Trace.endSection();
            long jC = z.i.c(hVar.g().a() - jA);
            if (z.k.f44508a.a()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" - ");
                z.y yVar = z.y.f44525a;
                String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                kotlin.jvm.internal.p.h(str2, "format(...)");
                sb2.append(str2);
                Log.d("CXCP", sb2.toString());
            }
            return numValueOf;
        } catch (Throwable th2) {
            th = th2;
            Trace.endSection();
            long jC2 = z.i.c(hVar.g().a() - jA);
            if (z.k.f44508a.a()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" - ");
                z.y yVar2 = z.y.f44525a;
                String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC2 / d10)}, 1));
                kotlin.jvm.internal.p.h(str3, "format(...)");
                sb3.append(str3);
                Log.d("CXCP", sb3.toString());
            }
            throw th;
        }
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(CameraCaptureSession.class))) {
            return (T) this.cameraCaptureSession;
        }
        return null;
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public Integer T(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener) throws Throwable {
        double d10;
        Integer numValueOf;
        kotlin.jvm.internal.p.i(requests, "requests");
        kotlin.jvm.internal.p.i(listener, "listener");
        z.h hVar = z.h.f44503a;
        String str = "CXCP#setRepeatingBurst-" + getDevice().g();
        long jA = hVar.g().a();
        try {
            Trace.beginSection(str);
            d10 = 1000000.0d;
        } catch (Throwable th) {
            th = th;
            d10 = 1000000.0d;
        }
        try {
            String strG = getDevice().g();
            B.c cVar = this.cameraErrorListener;
            try {
                numValueOf = Integer.valueOf(this.cameraCaptureSession.setRepeatingBurst(requests, listener, this.callbackHandler));
            } catch (Exception e10) {
                if (e10 instanceof CameraAccessException) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                    }
                    cVar.a(strG, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                } else if ((e10 instanceof IllegalArgumentException) || (e10 instanceof SecurityException) || (e10 instanceof UnsupportedOperationException) || (e10 instanceof NullPointerException)) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
                    }
                    cVar.a(strG, C5706l.INSTANCE.m(), false);
                } else {
                    if (!(e10 instanceof IllegalStateException)) {
                        throw e10;
                    }
                    if (z.k.f44508a.a()) {
                        Log.d("CXCP", "Failed to execute call: Camera may be closed");
                    }
                }
                numValueOf = null;
            }
            Trace.endSection();
            long jC = z.i.c(hVar.g().a() - jA);
            if (z.k.f44508a.a()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" - ");
                z.y yVar = z.y.f44525a;
                String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                kotlin.jvm.internal.p.h(str2, "format(...)");
                sb2.append(str2);
                Log.d("CXCP", sb2.toString());
            }
            return numValueOf;
        } catch (Throwable th2) {
            th = th2;
            Trace.endSection();
            long jC2 = z.i.c(hVar.g().a() - jA);
            if (z.k.f44508a.a()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" - ");
                z.y yVar2 = z.y.f44525a;
                String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC2 / d10)}, 1));
                kotlin.jvm.internal.p.h(str3, "format(...)");
                sb3.append(str3);
                Log.d("CXCP", sb3.toString());
            }
            throw th;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.cameraCaptureSession.close();
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public boolean f() throws Throwable {
        double d10;
        Y8.t tVar;
        z.h hVar = z.h.f44503a;
        String str = "CXCP#abortCaptures-" + getDevice().g();
        long jA = hVar.g().a();
        try {
            Trace.beginSection(str);
            String strG = getDevice().g();
            d10 = 1000000.0d;
            try {
                B.c cVar = this.cameraErrorListener;
                try {
                    this.cameraCaptureSession.abortCaptures();
                    tVar = Y8.t.f7040a;
                } catch (Exception e10) {
                    if (e10 instanceof CameraAccessException) {
                        if (z.k.f44508a.d()) {
                            Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                        }
                        cVar.a(strG, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                    } else if ((e10 instanceof IllegalArgumentException) || (e10 instanceof SecurityException) || (e10 instanceof UnsupportedOperationException) || (e10 instanceof NullPointerException)) {
                        if (z.k.f44508a.d()) {
                            Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
                        }
                        cVar.a(strG, C5706l.INSTANCE.m(), false);
                    } else {
                        if (!(e10 instanceof IllegalStateException)) {
                            throw e10;
                        }
                        if (z.k.f44508a.a()) {
                            Log.d("CXCP", "Failed to execute call: Camera may be closed");
                        }
                    }
                    tVar = null;
                }
                Trace.endSection();
                long jC = z.i.c(hVar.g().a() - jA);
                if (z.k.f44508a.a()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" - ");
                    z.y yVar = z.y.f44525a;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                    kotlin.jvm.internal.p.h(str2, "format(...)");
                    sb2.append(str2);
                    Log.d("CXCP", sb2.toString());
                }
                return tVar != null;
            } catch (Throwable th) {
                th = th;
                Trace.endSection();
                long jC2 = z.i.c(hVar.g().a() - jA);
                if (z.k.f44508a.a()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(" - ");
                    z.y yVar2 = z.y.f44525a;
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

    @Override // androidx.camera.camera2.pipe.compat.o
    public boolean f0(List<? extends w0> outputConfigs) throws Throwable {
        double d10;
        String strG;
        boolean z10;
        Y8.t tVar;
        kotlin.jvm.internal.p.i(outputConfigs, "outputConfigs");
        z.h hVar = z.h.f44503a;
        String str = "CXCP#finalizeOutputConfigurations-" + getDevice().g();
        long jA = hVar.g().a();
        try {
            Trace.beginSection(str);
            strG = getDevice().g();
            d10 = 1000000.0d;
        } catch (Throwable th) {
            th = th;
            d10 = 1000000.0d;
        }
        try {
            B.c cVar = this.cameraErrorListener;
            try {
                CameraCaptureSession cameraCaptureSession = this.cameraCaptureSession;
                List<? extends w0> list = outputConfigs;
                ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((OutputConfiguration) ((w0) it.next()).R0(kotlin.jvm.internal.t.b(OutputConfiguration.class)));
                }
                C5821j.c(cameraCaptureSession, arrayList);
                tVar = Y8.t.f7040a;
            } catch (Exception e10) {
                if (e10 instanceof CameraAccessException) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                    }
                    cVar.a(strG, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                } else {
                    if (!(e10 instanceof IllegalArgumentException) && !(e10 instanceof SecurityException) && !(e10 instanceof UnsupportedOperationException) && !(e10 instanceof NullPointerException)) {
                        if (!(e10 instanceof IllegalStateException)) {
                            throw e10;
                        }
                        if (z.k.f44508a.a()) {
                            Log.d("CXCP", "Failed to execute call: Camera may be closed");
                        }
                    }
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
                    }
                    z10 = false;
                    cVar.a(strG, C5706l.INSTANCE.m(), false);
                    tVar = null;
                }
                tVar = null;
            }
            z10 = false;
            Trace.endSection();
            long jC = z.i.c(hVar.g().a() - jA);
            if (z.k.f44508a.a()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" - ");
                z.y yVar = z.y.f44525a;
                String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                kotlin.jvm.internal.p.h(str2, "format(...)");
                sb2.append(str2);
                Log.d("CXCP", sb2.toString());
            }
            if (tVar != null) {
                return true;
            }
            return z10;
        } catch (Throwable th2) {
            th = th2;
            Trace.endSection();
            long jC2 = z.i.c(hVar.g().a() - jA);
            if (z.k.f44508a.a()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" - ");
                z.y yVar2 = z.y.f44525a;
                String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC2 / d10)}, 1));
                kotlin.jvm.internal.p.h(str3, "format(...)");
                sb3.append(str3);
                Log.d("CXCP", sb3.toString());
            }
            throw th;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public androidx.camera.camera2.pipe.compat.p getDevice() {
        return this.device;
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public Surface getInputSurface() {
        return this.cameraCaptureSession.getInputSurface();
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public Integer p(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener) throws Throwable {
        double d10;
        Integer numValueOf;
        kotlin.jvm.internal.p.i(requests, "requests");
        kotlin.jvm.internal.p.i(listener, "listener");
        z.h hVar = z.h.f44503a;
        String str = "CXCP#captureBurst-" + getDevice().g();
        long jA = hVar.g().a();
        try {
            Trace.beginSection(str);
            d10 = 1000000.0d;
        } catch (Throwable th) {
            th = th;
            d10 = 1000000.0d;
        }
        try {
            String strG = getDevice().g();
            B.c cVar = this.cameraErrorListener;
            try {
                numValueOf = Integer.valueOf(this.cameraCaptureSession.captureBurst(requests, listener, this.callbackHandler));
            } catch (Exception e10) {
                if (e10 instanceof CameraAccessException) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                    }
                    cVar.a(strG, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                } else if ((e10 instanceof IllegalArgumentException) || (e10 instanceof SecurityException) || (e10 instanceof UnsupportedOperationException) || (e10 instanceof NullPointerException)) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
                    }
                    cVar.a(strG, C5706l.INSTANCE.m(), false);
                } else {
                    if (!(e10 instanceof IllegalStateException)) {
                        throw e10;
                    }
                    if (z.k.f44508a.a()) {
                        Log.d("CXCP", "Failed to execute call: Camera may be closed");
                    }
                }
                numValueOf = null;
            }
            Trace.endSection();
            long jC = z.i.c(hVar.g().a() - jA);
            if (z.k.f44508a.a()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" - ");
                z.y yVar = z.y.f44525a;
                String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                kotlin.jvm.internal.p.h(str2, "format(...)");
                sb2.append(str2);
                Log.d("CXCP", sb2.toString());
            }
            return numValueOf;
        } catch (Throwable th2) {
            th = th2;
            Trace.endSection();
            long jC2 = z.i.c(hVar.g().a() - jA);
            if (z.k.f44508a.a()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" - ");
                z.y yVar2 = z.y.f44525a;
                String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC2 / d10)}, 1));
                kotlin.jvm.internal.p.h(str3, "format(...)");
                sb3.append(str3);
                Log.d("CXCP", sb3.toString());
            }
            throw th;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public Integer q0(CaptureRequest request, CameraCaptureSession.CaptureCallback listener) throws Throwable {
        double d10;
        Integer numValueOf;
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(listener, "listener");
        z.h hVar = z.h.f44503a;
        String str = "CXCP#setRepeatingRequest-" + getDevice().g();
        long jA = hVar.g().a();
        try {
            Trace.beginSection(str);
            d10 = 1000000.0d;
        } catch (Throwable th) {
            th = th;
            d10 = 1000000.0d;
        }
        try {
            String strG = getDevice().g();
            B.c cVar = this.cameraErrorListener;
            try {
                numValueOf = Integer.valueOf(this.cameraCaptureSession.setRepeatingRequest(request, listener, this.callbackHandler));
            } catch (Exception e10) {
                if (e10 instanceof CameraAccessException) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                    }
                    cVar.a(strG, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                } else if ((e10 instanceof IllegalArgumentException) || (e10 instanceof SecurityException) || (e10 instanceof UnsupportedOperationException) || (e10 instanceof NullPointerException)) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
                    }
                    cVar.a(strG, C5706l.INSTANCE.m(), false);
                } else {
                    if (!(e10 instanceof IllegalStateException)) {
                        throw e10;
                    }
                    if (z.k.f44508a.a()) {
                        Log.d("CXCP", "Failed to execute call: Camera may be closed");
                    }
                }
                numValueOf = null;
            }
            Trace.endSection();
            long jC = z.i.c(hVar.g().a() - jA);
            if (z.k.f44508a.a()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" - ");
                z.y yVar = z.y.f44525a;
                String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                kotlin.jvm.internal.p.h(str2, "format(...)");
                sb2.append(str2);
                Log.d("CXCP", sb2.toString());
            }
            return numValueOf;
        } catch (Throwable th2) {
            th = th2;
            Trace.endSection();
            long jC2 = z.i.c(hVar.g().a() - jA);
            if (z.k.f44508a.a()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" - ");
                z.y yVar2 = z.y.f44525a;
                String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC2 / d10)}, 1));
                kotlin.jvm.internal.p.h(str3, "format(...)");
                sb3.append(str3);
                Log.d("CXCP", sb3.toString());
            }
            throw th;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public boolean stopRepeating() throws Throwable {
        double d10;
        Y8.t tVar;
        z.h hVar = z.h.f44503a;
        String str = "CXCP#stopRepeating-" + getDevice().g();
        long jA = hVar.g().a();
        try {
            Trace.beginSection(str);
            String strG = getDevice().g();
            d10 = 1000000.0d;
            try {
                B.c cVar = this.cameraErrorListener;
                try {
                    this.cameraCaptureSession.stopRepeating();
                    tVar = Y8.t.f7040a;
                } catch (Exception e10) {
                    if (e10 instanceof CameraAccessException) {
                        if (z.k.f44508a.d()) {
                            Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                        }
                        cVar.a(strG, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                    } else if ((e10 instanceof IllegalArgumentException) || (e10 instanceof SecurityException) || (e10 instanceof UnsupportedOperationException) || (e10 instanceof NullPointerException)) {
                        if (z.k.f44508a.d()) {
                            Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
                        }
                        cVar.a(strG, C5706l.INSTANCE.m(), false);
                    } else {
                        if (!(e10 instanceof IllegalStateException)) {
                            throw e10;
                        }
                        if (z.k.f44508a.a()) {
                            Log.d("CXCP", "Failed to execute call: Camera may be closed");
                        }
                    }
                    tVar = null;
                }
                Trace.endSection();
                long jC = z.i.c(hVar.g().a() - jA);
                if (z.k.f44508a.a()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" - ");
                    z.y yVar = z.y.f44525a;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                    kotlin.jvm.internal.p.h(str2, "format(...)");
                    sb2.append(str2);
                    Log.d("CXCP", sb2.toString());
                }
                return tVar != null;
            } catch (Throwable th) {
                th = th;
                Trace.endSection();
                long jC2 = z.i.c(hVar.g().a() - jA);
                if (z.k.f44508a.a()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(" - ");
                    z.y yVar2 = z.y.f44525a;
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

    @Override // androidx.camera.camera2.pipe.compat.o
    /* renamed from: w, reason: from getter */
    public int getId() {
        return this.id;
    }
}
