package stepos.support.v7.app;

import android.view.View;
import com.stepos.alphame.utils.Property;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.StepOSAppBarLayout;

/* loaded from: classes2.dex */
public final class J extends C.b {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f14289e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ M f14290f;

    public /* synthetic */ J(M m4, int i4) {
        this.f14289e = i4;
        this.f14290f = m4;
    }

    @Override // C.b, K.f0
    public final void c(View view) {
        int i4 = this.f14289e;
        M m4 = this.f14290f;
        switch (i4) {
            case 2:
                boolean z4 = m4.f14314o;
                ActionBarContainer actionBarContainer = m4.f14307h;
                if (actionBarContainer != null) {
                    actionBarContainer.setVisibility(8);
                }
                m4.f14304e.setVisibility(8);
                m4.f14304e.setTransitioning(false);
                m4.f14317r = null;
                m4.f14320u = false;
                K3.b bVar = m4.f14311l;
                if (bVar != null) {
                    bVar.e(m4.f14310k);
                    m4.f14310k = null;
                    m4.f14311l = null;
                }
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = m4.f14302c;
                if (actionBarCoordinatorLayout != null) {
                    WeakHashMap weakHashMap = K.S.f939a;
                    K.H.c(actionBarCoordinatorLayout);
                    break;
                }
                break;
            default:
                m4.f14317r = null;
                m4.f14320u = true;
                StepOSAppBarLayout stepOSAppBarLayout = m4.f14304e;
                WeakHashMap weakHashMap2 = K.S.f939a;
                stepOSAppBarLayout.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
                ActionBarContainer actionBarContainer2 = m4.f14307h;
                if (actionBarContainer2 != null) {
                    actionBarContainer2.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
                }
                m4.f14304e.requestLayout();
                break;
        }
    }
}
