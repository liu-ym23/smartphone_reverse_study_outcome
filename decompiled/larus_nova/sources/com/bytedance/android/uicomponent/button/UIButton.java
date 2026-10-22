package com.bytedance.android.uicomponent.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import fm3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/uicomponent/button/UIButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/graphics/Rect;", "d", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "bounds", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "uicomponent_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UIButton extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f187665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f187666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f187667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f187668d;

    public static final class a {
    }

    static {
    }

    public UIButton(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UIButton(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final Rect getBounds() {
        return this.f187668d;
    }

    public UIButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f187668d = new Rect();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ttlive_button_size, R.attr.ttlive_button_type, R.attr.ttlive_drawableBottom, R.attr.ttlive_drawableHeight, R.attr.ttlive_drawableLeft, R.attr.ttlive_drawableRight, R.attr.ttlive_drawableTop, R.attr.ttlive_drawableWidth});
        int r104 = r103.getInt(0, 1);
        if (r104 != 0) goto L5;
        this.f187665a = e.a(r100, 2.0f);
        this.f187666b = getResources().getDimensionPixelSize(R.dimen.uicomponent_button_text_size_xs);
        this.f187667c = getResources().getDimensionPixelSize(R.dimen.uicomponent_button_text_size_xs);
    L15:
        Drawable r105 = r103.getDrawable(4);
        Drawable r106 = null;
        if (r105 == null) goto L18;
        r105.setBounds(0, 0, this.f187666b, this.f187667c);
    L19:
        Drawable r107 = r103.getDrawable(6);
        if (r107 == null) goto L22;
        r107.setBounds(0, 0, this.f187666b, this.f187667c);
    L23:
        Drawable r108 = r103.getDrawable(5);
        if (r108 == null) goto L26;
        r108.setBounds(0, 0, this.f187666b, this.f187667c);
    L27:
        Drawable r109 = r103.getDrawable(2);
        if (r109 == null) goto L30;
        r109.setBounds(0, 0, this.f187666b, this.f187667c);
        r106 = r109;
    L30:
        setCompoundDrawables(r105, r107, r108, r106);
        setCompoundDrawablePadding((int) this.f187665a);
        r103.recycle();
        return;
    L26:
        r108 = null;
        goto L27
    L22:
        r107 = null;
        goto L23
    L18:
        r105 = null;
        goto L19
    L5:
        if (r104 != 1) goto L7;
        this.f187665a = e.a(r100, 4.0f);
        this.f187666b = getResources().getDimensionPixelSize(R.dimen.uicomponent_button_text_size_s);
        this.f187667c = getResources().getDimensionPixelSize(R.dimen.uicomponent_button_text_size_s);
        goto L15
    L7:
        if (r104 != 2) goto L9;
        this.f187665a = e.a(r100, 4.0f);
        this.f187666b = getResources().getDimensionPixelSize(R.dimen.uicomponent_button_text_size_m);
        this.f187667c = getResources().getDimensionPixelSize(R.dimen.uicomponent_button_text_size_m);
        goto L15
    L9:
        if (r104 == 3) goto L11;
        this.f187665a = e.a(r100, 4.0f);
        this.f187666b = getResources().getDimensionPixelSize(R.dimen.uicomponent_button_text_size_m);
        this.f187667c = getResources().getDimensionPixelSize(R.dimen.uicomponent_button_text_size_m);
        goto L15
    L11:
        this.f187665a = e.a(r100, 4.0f);
        this.f187666b = getResources().getDimensionPixelSize(R.dimen.uicomponent_button_text_size_l);
        this.f187667c = getResources().getDimensionPixelSize(R.dimen.uicomponent_button_text_size_l);
        goto L15
    }

    public /* synthetic */ UIButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), this.f187668d);
        int r105 = (int) ((((double) getWidth()) / 2.0d) - (((double) ((this.f187666b + this.f187665a) + this.f187668d.width())) / 2.0d));
        setCompoundDrawablePadding((int) ((-r105) + this.f187665a));
        boolean r106 = true;
        if (getCompoundDrawables()[0] == null) goto L5;
        boolean r107 = true;
    L7:
        if (getCompoundDrawables()[2] != null) goto L10;
        r106 = false;
    L10:
        if (r107 == false) goto L13;
        if (r106 == false) goto L13;
        setPadding(r105, getPaddingTop(), r105, getPaddingBottom());
        return;
    L13:
        if (r107 == false) goto L15;
        setPadding(r105, getPaddingTop(), 0, getPaddingBottom());
        return;
    L15:
        if (r106 == false) goto L17;
        setPadding(0, getPaddingTop(), r105, getPaddingBottom());
        return;
    L17:
        setPadding(0, getPaddingTop(), 0, getPaddingBottom());
        return;
    L5:
        r107 = false;
        goto L7
    }
}
