package K;

import D.InterfaceC0778o;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.impl.SessionConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface z0 {

    public interface a {
    }

    void a();

    SessionConfig b(InterfaceC0778o interfaceC0778o, r0 r0Var);

    default Map<Integer, List<Size>> c(Size size) {
        return Collections.EMPTY_MAP;
    }

    default void d(a aVar) {
    }

    default List<Pair<CameraCharacteristics.Key, Object>> e() {
        return Collections.EMPTY_LIST;
    }

    default Pair<Integer, Integer> f() {
        return Pair.create(0, 0);
    }

    default int[] g() {
        for (Pair<CameraCharacteristics.Key, Object> pair : e()) {
            if (((CameraCharacteristics.Key) pair.first).equals(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) {
                return (int[]) pair.second;
            }
        }
        return null;
    }
}
