package com.bytedanceos.common.ui.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.toolbox.e;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class BaseViewPager extends ViewPagerCompat {
    private static final int HORIZONTAL_APP_ITEM_HEIGHT = 0;
    private static final int OFF_SCREEN_PAGE_LIMIT = 1;
    private static final int VERTICAL_APP_ITEM_HEIGHT = 0;
    private static final int VERTICAL_APP_ITEM_HEIGHT_BIG_FONT = 0;
    private ViewPagerCompat.OnPageChangeListener mOnPageChangeListener;

    static {
        VERTICAL_APP_ITEM_HEIGHT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.oui_app_list_height);
        VERTICAL_APP_ITEM_HEIGHT_BIG_FONT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.app_list_height_1X4);
        HORIZONTAL_APP_ITEM_HEIGHT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.oui_app_group_view_horizontal_item_height);
    }

    public BaseViewPager(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ ViewPagerCompat.OnPageChangeListener access$000(BaseViewPager r10) {
        return r10.mOnPageChangeListener;
    }

    private void init() {
        setClipChildren(false);
        setClipToPadding(false);
        setPadding(f.i(8), 0, f.i(8), 0);
        setDescendantFocusability(393216);
        setBackgroundColor(getContext().getResources().getColor(R.color.transparent));
        setOffscreenPageLimit(1);
        setOverScrollMode(0);
        setOnPageChangeListener(new AnonymousClass1(this));
    }

    public void addOnPageChangeListener(ViewPagerCompat.OnPageChangeListener r10) {
        this.mOnPageChangeListener = r10;
    }

    public void measureHeight(int r10, int r11) {
        ViewGroup.LayoutParams r12 = getLayoutParams();
        if (r10 == 1) goto L5;
        int r13 = HORIZONTAL_APP_ITEM_HEIGHT;
    L11:
        if (r12.height == r13) goto L14;
        r12.height = r13;
        requestLayout();
        return;
    L14:
        return;
    L5:
        if (e.n0() == false) goto L7;
        int r14 = VERTICAL_APP_ITEM_HEIGHT_BIG_FONT;
    L8:
        r13 = r14 * r11;
        goto L11
    L7:
        r14 = VERTICAL_APP_ITEM_HEIGHT;
        goto L8
    }

    public BaseViewPager(Context r10, AttributeSet r11) {
        super(r10, r11);
        init();
    }
}
