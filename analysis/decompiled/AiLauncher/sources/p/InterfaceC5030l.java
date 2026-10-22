package p;

import Ua.Q;
import android.util.Range;
import android.util.Rational;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Lp/l;", "", "", "throwable", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/Throwable;)V", "", "evCompIndex", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "", "cancelPreviousTask", "LUa/Q;", Const.INTENT_KEY_PKGNAME, "(ILandroidx/camera/camera2/impl/UseCaseCameraRequestControl;Z)LUa/Q;", "c", "()Z", "supported", "Landroid/util/Range;", Const.INTENT_KEY_APIKEY, "()Landroid/util/Range;", "range", "Landroid/util/Rational;", "e", "()Landroid/util/Rational;", "step", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: p.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC5030l {
    Range<Integer> a();

    Q<Integer> b(int evCompIndex, UseCaseCameraRequestControl requestControl, boolean cancelPreviousTask);

    boolean c();

    void d(Throwable throwable);

    Rational e();
}
