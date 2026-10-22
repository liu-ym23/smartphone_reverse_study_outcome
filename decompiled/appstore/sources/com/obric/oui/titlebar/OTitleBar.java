package com.obric.oui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f17452a;

    public OTitleBar(@NonNull Context r10) {
        super(r10);
    }

    public TextView getTitleView() {
        return this.f17452a;
    }

    public abstract void setDividerLineBackground(@ColorInt int r10);

    public void setTitle(CharSequence r10) {
        TextView r11 = this.f17452a;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setText(r10);
    }

    public void setTitleColor(@ColorInt int r10) {
        TextView r11 = this.f17452a;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setTextColor(r10);
    }

    public void setTitleSize(float r10) {
        TextView r11 = this.f17452a;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setTextSize(r10);
    }

    public void setTitleSizePixel(float r10) {
        TextView r11 = this.f17452a;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setTextSize(0, r10);
    }

    public OTitleBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
    }

    public OTitleBar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        if (getBackground() != null) goto L6;
        setBackgroundColor(ContextCompat.b(r10, R$color.BGPrimary));
        return;
    }

    public void setTitle(@StringRes int r10) {
        TextView r11 = this.f17452a;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setText(r10);
    }
}
