package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.b0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context r10) {
        this(r10, null);
    }

    public TabItem(Context r10, AttributeSet r11) {
        super(r10, r11);
        b0 r12 = b0.u(r10, r11, R.styleable.TabItem);
        this.text = r12.p(R.styleable.TabItem_android_text);
        this.icon = r12.g(R.styleable.TabItem_android_icon);
        this.customLayout = r12.n(R.styleable.TabItem_android_layout, 0);
        r12.w();
    }
}
