package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHC";
    private static final int[] THEME_ATTRS = null;

    public static class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        public SetIndicatorInfo(Activity r100) {
            this.setHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});     // Catch: NoSuchMethodException -> L5
            this.setHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            View r101 = r100.findViewById(R.id.home);
            if (r101 != null) goto L8;
            return;
        L8:
            ViewGroup r102 = (ViewGroup) r101.getParent();
            if (r102.getChildCount() == 2) goto L11;
            return;
        L11:
            View r103 = r102.getChildAt(0);
            View r104 = r102.getChildAt(1);
            if (r103.getId() != 16908332) goto L15;
            r103 = r104;
        L15:
            if ((r103 instanceof ImageView) == false) goto L20;
            this.upIndicatorView = (ImageView) r103;
            return;
        }
    }

    static {
        THEME_ATTRS = new int[]{R.attr.homeAsUpIndicator};
    }

    private ActionBarDrawerToggleHoneycomb() {
    }

    public static Drawable getThemeUpIndicator(Activity r100) {
        TypedArray r101 = r100.obtainStyledAttributes(THEME_ATTRS);
        Drawable r102 = r101.getDrawable(0);
        r101.recycle();
        return r102;
    }

    public static SetIndicatorInfo setActionBarDescription(SetIndicatorInfo r100, Activity r101, int r102) {
        if (r100 != null) goto L5;
        r100 = new SetIndicatorInfo(r101);
    L5:
        if (r100.setHomeAsUpIndicator != null) goto L9;
    L7:
        return r100;
    L9:
        android.app.ActionBar r103 = r101.getActionBar();     // Catch: Exception -> L8
        r100.setHomeActionContentDescription.invoke(r103, new Object[]{Integer.valueOf(r102)});     // Catch: Exception -> L8
        goto L7
    }

    public static SetIndicatorInfo setActionBarUpIndicator(Activity r100, Drawable r101, int r102) {
        SetIndicatorInfo r103 = new SetIndicatorInfo(r100);
        if (r103.setHomeAsUpIndicator != null) goto L11;
        ImageView r104 = r103.upIndicatorView;
        if (r104 == null) goto L9;
        r104.setImageDrawable(r101);
    L9:
        return r103;
    L11:
        android.app.ActionBar r105 = r100.getActionBar();     // Catch: Exception -> L10
        r103.setHomeAsUpIndicator.invoke(r105, new Object[]{r101});     // Catch: Exception -> L10
        r103.setHomeActionContentDescription.invoke(r105, new Object[]{Integer.valueOf(r102)});     // Catch: Exception -> L10
        goto L9
    }
}
