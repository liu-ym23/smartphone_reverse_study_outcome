package p;

import Ua.Q;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v.C5649f;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\nJ+\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lp/f;", "Landroidx/camera/camera2/pipe/t$a;", "Lv/f;", "bundle", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lv/f;)V", "U", "()Lv/f;", "n", "()V", "l", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "", "cancelPreviousTask", "LUa/Q;", "Ljava/lang/Void;", "J", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;Z)LUa/Q;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: p.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC5024f extends t.a {
    static /* synthetic */ Q e0(InterfaceC5024f interfaceC5024f, UseCaseCameraRequestControl useCaseCameraRequestControl, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyAsync");
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return interfaceC5024f.J(useCaseCameraRequestControl, z10);
    }

    Q<Void> J(UseCaseCameraRequestControl requestControl, boolean cancelPreviousTask);

    C5649f U();

    void b(C5649f bundle);

    void l();

    void n();
}
