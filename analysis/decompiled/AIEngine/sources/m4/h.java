package m4;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h implements w0.d {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f10492g;

    public h(SwipeDismissBehavior swipeDismissBehavior) {
        this.f10492g = swipeDismissBehavior;
    }

    @Override // w0.d
    public final boolean a(View view) {
        SwipeDismissBehavior swipeDismissBehavior = this.f10492g;
        if (!swipeDismissBehavior.g(view)) {
            return false;
        }
        boolean z = view.getLayoutDirection() == 1;
        int i10 = swipeDismissBehavior.f4633d;
        int width = (!(i10 == 0 && z) && (i10 != 1 || z)) ? view.getWidth() : -view.getWidth();
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        view.offsetLeftAndRight(width);
        view.setAlpha(0.0f);
        return true;
    }
}
