package K;

import android.content.Context;
import android.util.Size;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: K.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0896t extends InterfaceC0876c0 {

    /* renamed from: K.t$a */
    public interface a {
        InterfaceC0896t a(Context context, Object obj, Set<String> set) throws InitializationException;
    }

    SurfaceConfig a(int i10, String str, int i11, Size size, StreamUseCase streamUseCase);

    SurfaceStreamSpecQueryResult b(int i10, String str, List<androidx.camera.core.impl.b> list, Map<androidx.camera.core.impl.z<?>, List<Size>> map, VideoStabilization videoStabilization, boolean z10, boolean z11, boolean z12);
}
