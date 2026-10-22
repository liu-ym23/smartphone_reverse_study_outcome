package com.alibaba.android.vlayout.layout;

import com.alibaba.android.vlayout.LayoutManagerHelper;

/* JADX INFO: loaded from: classes.dex */
public class ScrollFixLayoutHelper extends FixLayoutHelper {
    public static final int SHOW_ALWAYS = 0;
    public static final int SHOW_ON_ENTER = 1;
    public static final int SHOW_ON_LEAVE = 2;
    private static final String TAG = "ScrollFixLayoutHelper";
    private int mShowType;

    public ScrollFixLayoutHelper(int r10, int r11) {
        this(0, r10, r11);
    }

    public int getShowType() {
        return this.mShowType;
    }

    public void setShowType(int r10) {
        this.mShowType = r10;
    }

    @Override // com.alibaba.android.vlayout.layout.FixLayoutHelper
    public boolean shouldBeDraw(LayoutManagerHelper r10, int r11, int r12, int r13) {
        int r14 = this.mShowType;
        if (r14 == 1) goto L12;
        if (r14 == 2) goto L8;
        return true;
    L8:
        if (r11 >= (((Integer) getRange().getLower()).intValue() + 1)) goto L10;
        return false;
    L10:
        return true;
    L12:
        if (r12 >= (((Integer) getRange().getLower()).intValue() - 1)) goto L14;
        return false;
    L14:
        return true;
    }

    public ScrollFixLayoutHelper(int r10, int r11, int r12) {
        super(r10, r11, r12);
        this.mShowType = 0;
    }
}
