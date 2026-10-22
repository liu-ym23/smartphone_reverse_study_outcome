package Y;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.z;
import java.util.List;

/* loaded from: classes.dex */
public class h implements z<f>, s, P.n {

    /* renamed from: S, reason: collision with root package name */
    public static final Config.a<List<UseCaseConfigFactory.CaptureType>> f6959S = Config.a.a("camerax.core.streamSharing.captureTypes", List.class);

    /* renamed from: R, reason: collision with root package name */
    public final v f6960R;

    public h(v vVar) {
        this.f6960R = vVar;
    }

    @Override // androidx.camera.core.impl.x
    public Config getConfig() {
        return this.f6960R;
    }

    public List<UseCaseConfigFactory.CaptureType> h0() {
        return (List) a(f6959S);
    }
}
