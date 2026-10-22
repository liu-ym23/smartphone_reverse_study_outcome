package com.android.contacts.common.util;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ListView;
import com.android.contacts.common.R;
import com.android.contacts.common.compat.CompatUtils;

/* JADX INFO: loaded from: classes.dex */
public class ViewUtil {
    private static final ViewOutlineProvider OVAL_OUTLINE_PROVIDER = null;
    private static final ViewOutlineProvider RECT_OUTLINE_PROVIDER = null;

    private ViewUtil() {
    }

    public static int getConstantPreLayoutWidth(View r1) {
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2.width < 0) goto L7;
        return r2.width;
    L7:
        throw new IllegalStateException("Expecting view's width to be a constant rather than a result of the layout pass");
    }

    public static boolean isViewLayoutRtl(View r1) {
        if (r1.getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    static {
        if (CompatUtils.isLollipopCompatible() == false) goto L5;
        OVAL_OUTLINE_PROVIDER = new AnonymousClass1();
    L7:
        if (CompatUtils.isLollipopCompatible() == false) goto L9;
        RECT_OUTLINE_PROVIDER = new AnonymousClass2();
        return;
    L9:
        RECT_OUTLINE_PROVIDER = null;
        return;
    L5:
        OVAL_OUTLINE_PROVIDER = null;
        goto L7
    }

    public static void addRectangularOutlineProvider(View r0, Resources r1) {
        if (CompatUtils.isLollipopCompatible() == false) goto L6;
        r0.setOutlineProvider(RECT_OUTLINE_PROVIDER);
        return;
    }

    public static void setupFloatingActionButton(View r1, Resources r2) {
        if (CompatUtils.isLollipopCompatible() == false) goto L6;
        r1.setOutlineProvider(OVAL_OUTLINE_PROVIDER);
        r1.setTranslationZ(r2.getDimensionPixelSize(R.dimen.floating_action_button_translation_z));
        return;
    }

    public static void addBottomPaddingToListViewForFab(ListView r4, Resources r5) {
        int r6 = r5.getDimensionPixelSize(R.dimen.floating_action_button_list_bottom_padding);
        r4.setPaddingRelative(r4.getPaddingStart(), r4.getPaddingTop(), r4.getPaddingEnd(), r4.getPaddingBottom() + r6);
        r4.setClipToPadding(false);
    }
}
