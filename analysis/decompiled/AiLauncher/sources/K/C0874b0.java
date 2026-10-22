package K;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import g3.InterfaceFutureC4095a;

/* renamed from: K.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0874b0 extends DeferrableSurface {

    /* renamed from: o, reason: collision with root package name */
    public final Surface f3946o;

    public C0874b0(Surface surface, Size size, int i10) {
        super(size, i10);
        this.f3946o = surface;
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    public InterfaceFutureC4095a<Surface> o() {
        return O.f.h(this.f3946o);
    }
}
