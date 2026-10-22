package cib;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.forseti.widget.MinChildHeightFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f23902a = 0;

    static {
    }

    public static AppBarLayout a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof AppBarLayout) == false) goto L7;
        return (AppBarLayout) r100;
    L7:
        if ((r100 instanceof ViewGroup) == false) goto L14;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount() - 1;
    L9:
        if ((-1) >= r102) goto L18;
        View r103 = r101.getChildAt(r102);
        Intrinsics.checkNotNull(r103);
        AppBarLayout r104 = a(r103);
        if (r104 != null) goto L12;
        r102 = r102 - 1;
        goto L9
    L12:
        return r104;
    L18:
        return null;
    L14:
        return null;
    }

    public static ViewGroup c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof ViewPager) == true) goto L17;
        if ((r100 instanceof ViewPager2) == true) goto L17;
        if ((r100 instanceof ViewGroup) == false) goto L15;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount() - 1;
    L10:
        if ((-1) >= r102) goto L15;
        View r103 = r101.getChildAt(r102);
        Intrinsics.checkNotNull(r103);
        ViewGroup r104 = c(r103);
        if (r104 != null) goto L13;
        r102 = r102 - 1;
        goto L10
    L13:
        return r104;
    L15:
        return null;
    L17:
        if ((r100 instanceof ViewGroup) == true) goto L19;
        return null;
    L19:
        return (ViewGroup) r100;
    }

    public static View b(View r100, float r101, float r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (Intrinsics.areEqual(r100.getClass().getSimpleName(), "TextureMapView") == false) goto L5;
    L55:
        return r100;
    L5:
        if (Intrinsics.areEqual(r100.getClass().getSimpleName(), "MapView") == true) goto L55;
        if ((r100 instanceof ViewGroup) == false) goto L37;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount() - 1;
    L11:
        if ((-1) >= r103) goto L37;
        View r104 = r102.getChildAt(r103);
        Intrinsics.checkNotNull(r104);
        int[] r105 = new int[2];
        r104.getLocationOnScreen(r105);
        boolean r106 = false;
        int r107 = r105[0];
        if (r101 >= r107) goto L15;
    L21:
        boolean r108 = false;
    L22:
        if (r108 == false) goto L35;
        if (r104.getVisibility() != 0) goto L26;
        boolean r109 = true;
    L27:
        if (r109 == false) goto L35;
        View r111 = b(r104, r101, r110);
        if (r111 == null) goto L35;
        if (r111.getVisibility() != 0) goto L33;
        r106 = true;
    L33:
        if (r106 == false) goto L35;
        return r111;
    L26:
        r109 = false;
    L35:
        r103 = r103 - 1;
        goto L11
    L15:
        if (r101 >= (r107 + r104.getWidth())) goto L21;
        int r112 = r105[1];
        if (r110 < r112) goto L21;
        if (r110 >= (r112 + r104.getHeight())) goto L21;
        r108 = true;
    L37:
        if ((r100 instanceof ScrollView) == false) goto L40;
        ((ScrollView) r100).setNestedScrollingEnabled(true);
    L40:
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L42;
        return r100;
    L42:
        ViewGroup.LayoutParams r113 = r100.getLayoutParams();
        if ((r113 instanceof CoordinatorLayout.LayoutParams) == false) goto L45;
        CoordinatorLayout.LayoutParams r114 = (CoordinatorLayout.LayoutParams) r113;
    L46:
        if (r114 == null) goto L48;
        CoordinatorLayout.Behavior r115 = r114.getBehavior();
    L49:
        if (r115 == null) goto L52;
        return r100;
    L52:
        if ((r100 instanceof MinChildHeightFrameLayout) == false) goto L54;
        return r100;
    L54:
        return null;
    L48:
        r115 = null;
        goto L49
    L45:
        r114 = null;
        goto L46
    }
}
