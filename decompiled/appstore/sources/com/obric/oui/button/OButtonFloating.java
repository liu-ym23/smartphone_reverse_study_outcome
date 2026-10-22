package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.text.OBaseTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u001e\u001a\u00020\u000f2\b\b\u0001\u0010 \u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u0014R\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/obric/oui/button/OButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Landroid/widget/FrameLayout;", "contentView", "Landroid/content/res/TypedArray;", "typedArray", "", "c", "(Landroid/content/Context;Landroid/widget/FrameLayout;Landroid/util/AttributeSet;Landroid/content/res/TypedArray;)V", "themeStyle", "applyDynamicTheme", "(I)V", "", "enabled", "k", "(Z)V", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "", "text", "setTitle", "(Ljava/lang/CharSequence;)V", "textRes", "Lcom/obric/oui/text/OBaseTextView;", "w", "Lcom/obric/oui/text/OBaseTextView;", "getTextView", "()Lcom/obric/oui/text/OBaseTextView;", "setTextView", "(Lcom/obric/oui/text/OBaseTextView;)V", "textView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OButtonFloating extends OShadowFrame {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OBaseTextView f12489w;

    @JvmOverloads
    public OButtonFloating(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 14, null);
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.common.style.ODynamicThemeWidget
    public void applyDynamicTheme(int r10) {
        super.applyDynamicTheme(r10);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void c(Context r10, FrameLayout r11, AttributeSet r12, TypedArray r13) {
        q.g(r10, "context");
        q.g(r11, "contentView");
        if (r13 != null) goto L5;
        return;
    L5:
        CharSequence r14 = r13.getText(R$styleable.OShadowFrame_oui_widgetText);
        int r15 = r13.getResourceId(R$styleable.OShadowFrame_oui_widgetTextStyle, R$style.Button_2_Medium);
        int r16 = r13.getColor(R$styleable.OShadowFrame_oui_widgetTextColor, getResources().getColor(R$color.oui_basic_text_1, null));
        OBaseTextView r17 = new OBaseTextView(r10, null, 0, 6, null);
        r17.setTextAppearance(r15);
        r17.setTextColor(r16);
        r17.setText(r14);
        r17.setSingleLine();
        r17.setIncludeFontPadding(false);
        r17.setGravity(17);
        setTextView(r17);
        View r18 = getTextView();
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(-2, -2);
        r19.gravity = 17;
        Unit r110 = Unit.f21064a;
        r11.addView(r18, r19);
        if (getMaterialApplied() == false) goto L9;
        d(r10, r13);
        return;
    }

    @NotNull
    public final OBaseTextView getTextView() {
        OBaseTextView r10 = this.f12489w;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("textView");
        return null;
    }

    @NotNull
    public final TextView getTitleView() {
        return getTextView();
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void k(boolean r10) {
        super.k(r10);
        if (r10 == false) goto L5;
        getTextView().setAlpha(1.0f);
        return;
    L5:
        getTextView().setAlpha(0.3f);
    }

    public final void setTextView(@NotNull OBaseTextView r10) {
        q.g(r10, "<set-?>");
        this.f12489w = r10;
    }

    public final void setTitle(@NotNull CharSequence r10) {
        q.g(r10, "text");
        getTextView().setText(r10);
    }

    @JvmOverloads
    public OButtonFloating(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 12, null);
    }

    public final void setTitle(@StringRes int r10) {
        getTextView().setText(r10);
    }

    @JvmOverloads
    public OButtonFloating(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        int r13 = 0;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OButtonFloating(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    public OButtonFloating(Context r10, AttributeSet r11, int r12, int r13) {
        q.g(r10, "context");
        super(r10, r11, r12, r13);
    }
}
