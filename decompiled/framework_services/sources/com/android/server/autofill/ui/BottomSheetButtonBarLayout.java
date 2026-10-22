package com.android.server.autofill.ui;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.android.internal.widget.ButtonBarLayout;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetButtonBarLayout extends ButtonBarLayout {
    public BottomSheetButtonBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        View spacer = findViewById(R.id.autofill_dataset_footer);
        if (spacer != null) goto L6;
        return;
    L6:
        if (isStacked() == false) goto L8;
        spacer.getLayoutParams().width = 0;
        ViewGroup.LayoutParams r1 = spacer.getLayoutParams();
        r1.height = getResources().getDimensionPixelSize(R.dimen.autofill_save_button_bar_padding);
        setGravity(8388629);
        return;
    L8:
        ViewGroup.LayoutParams r2 = spacer.getLayoutParams();
        r2.width = getResources().getDimensionPixelSize(R.dimen.autofill_save_custom_subtitle_max_height);
        spacer.getLayoutParams().height = 0;
        setGravity(16);
    }

    private boolean isStacked() {
        if (getOrientation() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
