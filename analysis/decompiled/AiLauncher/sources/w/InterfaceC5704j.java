package w;

import android.hardware.camera2.params.MeteringRectangle;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001Jo\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Lw/j;", "", "Lw/a;", "aeMode", "Lw/b;", "afMode", "Lw/c;", "awbMode", "", "Landroid/hardware/camera2/params/MeteringRectangle;", "aeRegions", "afRegions", "awbRegions", "LUa/Q;", "Lw/N;", "e", "(Lw/a;Lw/b;Lw/c;Ljava/util/List;Ljava/util/List;Ljava/util/List;)LUa/Q;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LUa/Q;", Const.INTENT_KEY_PKGNAME, "(Lw/a;)LUa/Q;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: w.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC5704j {
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Ua.Q g(InterfaceC5704j interfaceC5704j, C5695a c5695a, C5696b c5696b, C5697c c5697c, List list, List list2, List list3, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update3A-ydBZfZg");
        }
        if ((i10 & 1) != 0) {
            c5695a = null;
        }
        if ((i10 & 2) != 0) {
            c5696b = null;
        }
        if ((i10 & 4) != 0) {
            c5697c = null;
        }
        if ((i10 & 8) != 0) {
            list = null;
        }
        if ((i10 & 16) != 0) {
            list2 = null;
        }
        if ((i10 & 32) != 0) {
            list3 = null;
        }
        return interfaceC5704j.e(c5695a, c5696b, c5697c, list, list2, list3);
    }

    Ua.Q<Result3A> b(C5695a aeMode);

    Ua.Q<Result3A> e(C5695a aeMode, C5696b afMode, C5697c awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions);

    Ua.Q<Result3A> i();
}
