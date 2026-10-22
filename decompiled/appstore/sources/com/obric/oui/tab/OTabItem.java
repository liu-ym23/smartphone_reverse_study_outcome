package com.obric.oui.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.b0;
import com.obric.common.oui.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public final class OTabItem extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f17099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f17100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17101c;

    public OTabItem(Context r10) {
        this(r10, null);
    }

    @SuppressLint({"RestrictedApi"})
    public OTabItem(Context r10, AttributeSet r11) {
        super(r10, r11);
        b0 r12 = b0.u(r10, r11, R$styleable.OTabItem);
        this.f17099a = r12.p(R$styleable.OTabItem_android_text);
        this.f17100b = r12.g(R$styleable.OTabItem_android_icon);
        this.f17101c = r12.n(R$styleable.OTabItem_android_layout, 0);
        r12.w();
    }
}
