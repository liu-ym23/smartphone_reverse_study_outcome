package S;

import D.i0;
import android.media.MediaCodec;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5640a;

    public g() {
        this.f5640a = R.c.b(SurfaceOrderQuirk.class) != null;
    }

    public static /* synthetic */ int a(g gVar, SessionConfig.f fVar, SessionConfig.f fVar2) {
        gVar.getClass();
        return gVar.b(fVar.f()) - gVar.b(fVar2.f());
    }

    public final int b(DeferrableSurface deferrableSurface) {
        if (deferrableSurface.g() == MediaCodec.class) {
            return 2;
        }
        return (deferrableSurface.g() == i0.class || deferrableSurface.g() == Y.f.class) ? 0 : 1;
    }

    public void c(List<SessionConfig.f> list) {
        if (this.f5640a) {
            Collections.sort(list, new Comparator() { // from class: S.f
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return g.a(this.f5639a, (SessionConfig.f) obj, (SessionConfig.f) obj2);
                }
            });
        }
    }
}
