package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.view.Surface;
import androidx.camera.camera2.pipe.compat.j;
import androidx.camera.camera2.pipe.compat.o;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import w.U;
import x.InputConfigData;
import x.w0;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u00012\u00020\u0002J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0012\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0018\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0018\u0010\u0013J%\u0010\u001b\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u001b\u0010\u0013J-\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00112\u0006\u0010!\u001a\u00020 H'¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00112\u0006\u0010!\u001a\u00020$H'¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H&¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020'H&¢\u0006\u0004\b*\u0010)R\u0014\u0010.\u001a\u00020+8&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006/À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/p;", "Lw/U;", "Landroidx/camera/camera2/pipe/compat/j$a;", "Lw/M;", M5.e.FAIL_TEMPLATE, "Landroid/hardware/camera2/CaptureRequest$Builder;", "J", "(I)Landroid/hardware/camera2/CaptureRequest$Builder;", "Landroid/hardware/camera2/TotalCaptureResult;", "inputResult", "D0", "(Landroid/hardware/camera2/TotalCaptureResult;)Landroid/hardware/camera2/CaptureRequest$Builder;", "", "Landroid/view/Surface;", "outputs", "Landroidx/camera/camera2/pipe/compat/o$a;", "stateCallback", "", "N0", "(Ljava/util/List;Landroidx/camera/camera2/pipe/compat/o$a;)Z", "Landroid/hardware/camera2/params/InputConfiguration;", "input", "f1", "(Landroid/hardware/camera2/params/InputConfiguration;Ljava/util/List;Landroidx/camera/camera2/pipe/compat/o$a;)Z", "Y", "Lx/w0;", "outputConfigurations", "Y0", "Lx/u0;", "inputConfig", "m", "(Lx/u0;Ljava/util/List;Landroidx/camera/camera2/pipe/compat/o$a;)Z", "Landroidx/camera/camera2/pipe/compat/v;", "config", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroidx/camera/camera2/pipe/compat/v;)Z", "Landroidx/camera/camera2/pipe/compat/t;", "T0", "(Landroidx/camera/camera2/pipe/compat/t;)Z", "LY8/t;", "G", "()V", "k1", "Lw/n;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/String;", "cameraId", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface p extends U, j.a {
    CaptureRequest.Builder D0(TotalCaptureResult inputResult);

    void G();

    CaptureRequest.Builder J(int template);

    boolean N0(List<? extends Surface> outputs, o.a stateCallback);

    boolean T0(ExtensionSessionConfigData config);

    boolean V(v config);

    boolean Y(List<? extends Surface> outputs, o.a stateCallback);

    boolean Y0(List<? extends w0> outputConfigurations, o.a stateCallback);

    boolean f1(InputConfiguration input, List<? extends Surface> outputs, o.a stateCallback);

    String g();

    void k1();

    boolean m(InputConfigData inputConfig, List<? extends w0> outputs, o.a stateCallback);
}
