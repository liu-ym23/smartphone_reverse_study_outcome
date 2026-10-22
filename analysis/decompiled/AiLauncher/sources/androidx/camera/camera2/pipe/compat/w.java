package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.pipe.compat.o;
import androidx.camera.camera2.pipe.compat.q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import w9.InterfaceC5745d;
import x.InputConfigData;
import x.w0;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0012\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\rJ%\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u0015\u0010\rJ-\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001eH\u0017¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u0004\u0018\u00010#2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010,J)\u00102\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010/*\u00020.2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020*H\u0000¢\u0006\u0004\b4\u0010,J\u0017\u00107\u001a\u00020*2\u0006\u00106\u001a\u000205H\u0017¢\u0006\u0004\b7\u00108R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b7\u00109\u001a\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b4\u0010?R\u0014\u0010D\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006E"}, d2 = {"Landroidx/camera/camera2/pipe/compat/w;", "Landroidx/camera/camera2/pipe/compat/p;", "Landroidx/camera/camera2/pipe/compat/a;", "androidCameraDevice", "<init>", "(Landroidx/camera/camera2/pipe/compat/a;)V", "", "Landroid/view/Surface;", "outputs", "Landroidx/camera/camera2/pipe/compat/o$a;", "stateCallback", "", "N0", "(Ljava/util/List;Landroidx/camera/camera2/pipe/compat/o$a;)Z", "Landroid/hardware/camera2/params/InputConfiguration;", "input", "f1", "(Landroid/hardware/camera2/params/InputConfiguration;Ljava/util/List;Landroidx/camera/camera2/pipe/compat/o$a;)Z", "Y", "Lx/w0;", "outputConfigurations", "Y0", "Lx/u0;", "inputConfig", "m", "(Lx/u0;Ljava/util/List;Landroidx/camera/camera2/pipe/compat/o$a;)Z", "Landroidx/camera/camera2/pipe/compat/t;", "config", "T0", "(Landroidx/camera/camera2/pipe/compat/t;)Z", "Landroidx/camera/camera2/pipe/compat/v;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroidx/camera/camera2/pipe/compat/v;)Z", "Lw/M;", M5.e.FAIL_TEMPLATE, "Landroid/hardware/camera2/CaptureRequest$Builder;", "J", "(I)Landroid/hardware/camera2/CaptureRequest$Builder;", "Landroid/hardware/camera2/TotalCaptureResult;", "inputResult", "D0", "(Landroid/hardware/camera2/TotalCaptureResult;)Landroid/hardware/camera2/CaptureRequest$Builder;", "LY8/t;", "G", "()V", "k1", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "c", "Landroidx/camera/camera2/pipe/a;", "mode", Const.INTENT_KEY_APIKEY, "(I)V", "Landroidx/camera/camera2/pipe/compat/a;", "getAndroidCameraDevice$camera_camera2_pipe", "()Landroidx/camera/camera2/pipe/compat/a;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "lock", "Z", "disconnected", "Lw/n;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/String;", "cameraId", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class w implements p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AndroidCameraDevice androidCameraDevice;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean disconnected;

    public w(AndroidCameraDevice androidCameraDevice) {
        kotlin.jvm.internal.p.i(androidCameraDevice, "androidCameraDevice");
        this.androidCameraDevice = androidCameraDevice;
        this.lock = new Object();
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public CaptureRequest.Builder D0(TotalCaptureResult inputResult) {
        CaptureRequest.Builder builderD0;
        kotlin.jvm.internal.p.i(inputResult, "inputResult");
        synchronized (this.lock) {
            try {
                if (this.disconnected) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "createReprocessCaptureRequest failed: Virtual device disconnected");
                    }
                    builderD0 = null;
                } else {
                    builderD0 = this.androidCameraDevice.D0(inputResult);
                }
            } finally {
            }
        }
        return builderD0;
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public void G() {
        this.androidCameraDevice.G();
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public CaptureRequest.Builder J(int template) {
        CaptureRequest.Builder builderJ;
        synchronized (this.lock) {
            try {
                if (this.disconnected) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "createCaptureRequest failed: Virtual device disconnected");
                    }
                    builderJ = null;
                } else {
                    builderJ = this.androidCameraDevice.J(template);
                }
            } finally {
            }
        }
        return builderJ;
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public boolean N0(List<? extends Surface> outputs, o.a stateCallback) {
        boolean zN0;
        kotlin.jvm.internal.p.i(outputs, "outputs");
        kotlin.jvm.internal.p.i(stateCallback, "stateCallback");
        synchronized (this.lock) {
            try {
                if (this.disconnected) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "createCaptureSession failed: Virtual device disconnected");
                    }
                    stateCallback.a();
                    zN0 = false;
                } else {
                    zN0 = this.androidCameraDevice.N0(outputs, stateCallback);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zN0;
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        return (T) this.androidCameraDevice.R0(type);
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public boolean T0(ExtensionSessionConfigData config) {
        boolean zT0;
        kotlin.jvm.internal.p.i(config, "config");
        synchronized (this.lock) {
            try {
                if (this.disconnected) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "createExtensionSession failed: Virtual device disconnected");
                    }
                    q.a extensionStateCallback = config.getExtensionStateCallback();
                    kotlin.jvm.internal.p.f(extensionStateCallback);
                    extensionStateCallback.a();
                    zT0 = false;
                } else {
                    zT0 = this.androidCameraDevice.T0(config);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zT0;
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public boolean V(v config) {
        boolean zV;
        kotlin.jvm.internal.p.i(config, "config");
        synchronized (this.lock) {
            try {
                if (this.disconnected) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "createCaptureSession failed: Virtual device disconnected");
                    }
                    config.getStateCallback().a();
                    zV = false;
                } else {
                    zV = this.androidCameraDevice.V(config);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zV;
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public boolean Y(List<? extends Surface> outputs, o.a stateCallback) {
        boolean zY;
        kotlin.jvm.internal.p.i(outputs, "outputs");
        kotlin.jvm.internal.p.i(stateCallback, "stateCallback");
        synchronized (this.lock) {
            try {
                if (this.disconnected) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "createConstrainedHighSpeedCaptureSession failed: Virtual device disconnected");
                    }
                    stateCallback.a();
                    zY = false;
                } else {
                    zY = this.androidCameraDevice.Y(outputs, stateCallback);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zY;
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public boolean Y0(List<? extends w0> outputConfigurations, o.a stateCallback) {
        boolean zY0;
        kotlin.jvm.internal.p.i(outputConfigurations, "outputConfigurations");
        kotlin.jvm.internal.p.i(stateCallback, "stateCallback");
        synchronized (this.lock) {
            try {
                if (this.disconnected) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "createCaptureSessionByOutputConfigurations failed: Virtual device disconnected");
                    }
                    stateCallback.a();
                    zY0 = false;
                } else {
                    zY0 = this.androidCameraDevice.Y0(outputConfigurations, stateCallback);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zY0;
    }

    @Override // androidx.camera.camera2.pipe.compat.j.a
    public void a(int mode) {
        this.androidCameraDevice.a(mode);
    }

    public final void c() {
        synchronized (this.lock) {
            this.disconnected = true;
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public boolean f1(InputConfiguration input, List<? extends Surface> outputs, o.a stateCallback) {
        boolean zF1;
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(outputs, "outputs");
        kotlin.jvm.internal.p.i(stateCallback, "stateCallback");
        synchronized (this.lock) {
            try {
                if (this.disconnected) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "createReprocessableCaptureSession failed: Virtual device disconnected");
                    }
                    stateCallback.a();
                    zF1 = false;
                } else {
                    zF1 = this.androidCameraDevice.f1(input, outputs, stateCallback);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zF1;
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    /* renamed from: g */
    public String getCameraId() {
        return this.androidCameraDevice.getCameraId();
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public void k1() {
        this.androidCameraDevice.k1();
    }

    @Override // androidx.camera.camera2.pipe.compat.p
    public boolean m(InputConfigData inputConfig, List<? extends w0> outputs, o.a stateCallback) {
        boolean zM;
        kotlin.jvm.internal.p.i(inputConfig, "inputConfig");
        kotlin.jvm.internal.p.i(outputs, "outputs");
        kotlin.jvm.internal.p.i(stateCallback, "stateCallback");
        synchronized (this.lock) {
            try {
                if (this.disconnected) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "createReprocessableCaptureSessionByConfigurations failed: Virtual device disconnected");
                    }
                    stateCallback.a();
                    zM = false;
                } else {
                    zM = this.androidCameraDevice.m(inputConfig, outputs, stateCallback);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zM;
    }
}
