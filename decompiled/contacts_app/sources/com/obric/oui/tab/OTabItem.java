package com.obric.oui.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.obric.common.oui.R;

/* JADX INFO: loaded from: classes4.dex */
public final class OTabItem extends View {
    final int mCustomLayout;
    final Drawable mIcon;
    final CharSequence mText;

    public OTabItem(Context r2) {
        this(r2, null);
    }

    public OTabItem(Context r2, AttributeSet r3) {
        super(r2, r3);
        TintTypedArray r4 = TintTypedArray.obtainStyledAttributes(r2, r3, R.styleable.OTabItem);
        this.mText = r4.getText(R.styleable.OTabItem_android_text);
        this.mIcon = r4.getDrawable(R.styleable.OTabItem_android_icon);
        this.mCustomLayout = r4.getResourceId(R.styleable.OTabItem_android_layout, 0);
        r4.recycle();
    }
}
