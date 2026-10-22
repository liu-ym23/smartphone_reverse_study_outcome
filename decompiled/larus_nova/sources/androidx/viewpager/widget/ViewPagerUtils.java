package androidx.viewpager.widget;

import android.view.View;

/* JADX INFO: loaded from: classes17.dex */
public class ViewPagerUtils {
    public ViewPagerUtils() {
    }

    public static View getCurrentView(ViewPager r100) {
        int r101 = r100.getCurrentItem();
        int r102 = 0;
    L4:
        if (r102 >= r100.getChildCount()) goto L12;
        View r103 = r100.getChildAt(r102);
        ViewPager.LayoutParams r104 = (ViewPager.LayoutParams) r103.getLayoutParams();
        if (r104.isDecor == true) goto L11;
        if (r101 != r104.position) goto L11;
        return r103;
    L11:
        r102 = r102 + 1;
    L12:
        return null;
    }
}
