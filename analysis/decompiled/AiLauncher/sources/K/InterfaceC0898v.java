package K;

import D.C0761b0;
import D.InterfaceC0778o;
import D.InterfaceC0780q;
import G.ResolvedFeatureGroup;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* renamed from: K.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0898v extends InterfaceC0778o {
    boolean B();

    Set<Integer> a();

    Set<D.B> c();

    default InterfaceC0898v getImplementation() {
        return this;
    }

    String h();

    Rect j();

    List<Size> o(int i10);

    Object q();

    default boolean r(ResolvedFeatureGroup aVar, D.o0 o0Var) {
        for (F.b bVar : aVar.a()) {
            if (!bVar.d(this, o0Var)) {
                C0761b0.a("CameraInfoInternal", bVar + " is not supported.");
                return false;
            }
        }
        try {
            G0.c(this, o0Var, false, aVar);
            return true;
        } catch (CameraUseCaseAdapter.CameraException | IllegalArgumentException e10) {
            C0761b0.b("CameraInfoInternal", "CameraInfoInternal.isResolvedFeatureGroupSupported failed", e10);
            return false;
        }
    }

    w0 s();

    List<Size> t(int i10);

    default Set<Integer> u() {
        return Collections.EMPTY_SET;
    }

    boolean v();

    default void x(InterfaceC0780q interfaceC0780q) {
        G0.b(interfaceC0780q);
    }
}
