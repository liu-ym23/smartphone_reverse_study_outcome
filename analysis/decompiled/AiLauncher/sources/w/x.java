package w;

import android.hardware.camera2.CaptureResult;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u0002J&\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H¦\u0002¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lw/x;", "Landroidx/camera/camera2/pipe/q;", "Lw/U;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/hardware/camera2/CaptureResult$Key;", "key", "U", "(Landroid/hardware/camera2/CaptureResult$Key;)Ljava/lang/Object;", "default", SdCardDbCreator.FIELD_LASTLOC_ID, "(Landroid/hardware/camera2/CaptureResult$Key;Ljava/lang/Object;)Ljava/lang/Object;", "Lw/n;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", C3081a.CAMERA_FOCUS, "Lw/y;", "m1", "()J", "frameNumber", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface x extends androidx.camera.camera2.pipe.q, U {
    <T> T U(CaptureResult.Key<T> key);

    <T> T a1(CaptureResult.Key<T> key, T t10);

    String b();

    long m1();
}
