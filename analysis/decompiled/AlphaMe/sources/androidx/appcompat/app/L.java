package androidx.appcompat.app;

import K.S;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.stepos.alphame.utils.Property;
import j.InterfaceC0623b;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class L extends C.b {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2550e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ N f2551f;

    public /* synthetic */ L(N n4, int i4) {
        this.f2550e = i4;
        this.f2551f = n4;
    }

    @Override // C.b, K.f0
    public final void c(View view) {
        View view2;
        int i4 = this.f2550e;
        N n4 = this.f2551f;
        switch (i4) {
            case 0:
                if (n4.f2573p && (view2 = n4.f2565h) != null) {
                    view2.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
                    n4.f2562e.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
                }
                n4.f2562e.setVisibility(8);
                n4.f2562e.setTransitioning(false);
                n4.f2577t = null;
                InterfaceC0623b interfaceC0623b = n4.f2569l;
                if (interfaceC0623b != null) {
                    interfaceC0623b.f(n4.f2568k);
                    n4.f2568k = null;
                    n4.f2569l = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = n4.f2561d;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = S.f939a;
                    K.H.c(actionBarOverlayLayout);
                    break;
                }
                break;
            default:
                n4.f2577t = null;
                n4.f2562e.requestLayout();
                break;
        }
    }
}
