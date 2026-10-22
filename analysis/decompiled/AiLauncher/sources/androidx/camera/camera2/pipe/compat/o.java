package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.List;
import kotlin.Metadata;
import w.U;
import x.I0;
import x.w0;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001%J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0012\u0010\u0011J!\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\u0006J\u001d\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eH&¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006&À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/o;", "Lw/U;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "", "f", "()Z", "Landroid/hardware/camera2/CaptureRequest;", "request", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "listener", "", "F0", "(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Ljava/lang/Integer;", "", "requests", "p", "(Ljava/util/List;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Ljava/lang/Integer;", ExifInterface.GPS_DIRECTION_TRUE, "q0", "stopRepeating", "Lx/w0;", "outputConfigs", "f0", "(Ljava/util/List;)Z", "Landroidx/camera/camera2/pipe/f$a;", "w", "()I", "id", "Landroidx/camera/camera2/pipe/compat/p;", "getDevice", "()Landroidx/camera/camera2/pipe/compat/p;", Parameters.DEVICE, "Landroid/view/Surface;", "getInputSurface", "()Landroid/view/Surface;", "inputSurface", Const.INTENT_KEY_APIKEY, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface o extends U, AutoCloseable {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/o$a;", "Lx/I0;", "Landroidx/camera/camera2/pipe/compat/o;", "session", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroidx/camera/camera2/pipe/compat/o;)V", "k", Const.INTENT_KEY_UMID, "e", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a extends I0 {
        void c(o session);

        void d(o session);

        void e(o session);

        void i(o session);

        void j(o session);

        void k(o session);
    }

    Integer F0(CaptureRequest request, CameraCaptureSession.CaptureCallback listener);

    Integer T(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener);

    boolean f();

    boolean f0(List<? extends w0> outputConfigs);

    p getDevice();

    Surface getInputSurface();

    Integer p(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener);

    Integer q0(CaptureRequest request, CameraCaptureSession.CaptureCallback listener);

    boolean stopRepeating();

    int w();
}
