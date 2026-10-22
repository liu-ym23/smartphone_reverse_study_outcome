package com.obric.oui.tips;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000f\u0010\u000eR#\u0010\u0016\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u001b\u001a\n \u0011*\u0004\u0018\u00010\u00170\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001e\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R(\u0010/\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u00102\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R(\u00108\u001a\u0004\u0018\u00010%2\b\u00103\u001a\u0004\u0018\u00010%8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010>\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010E\u001a\u00020?2\u0006\u0010@\u001a\u00020?8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/obric/oui/tips/OTips;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lkotlin/Function0;", "", "clickAction", "setRightIconOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setLeftIconOnClickListener", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getLeftIcon", "()Landroid/widget/ImageView;", "leftIcon", "Landroid/widget/TextView;", "b", "getTipsTv", "()Landroid/widget/TextView;", "tipsTv", "c", "getRightIcon", "rightIcon", "Landroid/content/res/ColorStateList;", "d", "Landroid/content/res/ColorStateList;", "rightIconTint", "e", "leftIconTint", "", "f", "Ljava/lang/String;", "spanText", "Landroid/graphics/drawable/Drawable;", "ic", "getLeftIc", "()Landroid/graphics/drawable/Drawable;", "setLeftIc", "(Landroid/graphics/drawable/Drawable;)V", "leftIc", "getRightIc", "setRightIc", "rightIc", "txt", "getTipsText", "()Ljava/lang/String;", "setTipsText", "(Ljava/lang/String;)V", "tipsText", "num", "getTipsLine", "()I", "setTipsLine", "(I)V", "tipsLine", "", CommonKey.KEY_VALUE, "getTextRolling", "()Z", "setTextRolling", "(Z)V", "textRolling", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTips extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f17359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f17360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f17361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f17362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorStateList f17363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f17364f;

    @JvmOverloads
    public OTips(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void g(Function0 r10, View r11) {
        j(r10, r11);
    }

    private final Drawable getLeftIc() {
        return getLeftIcon().getDrawable();
    }

    private final Drawable getRightIc() {
        return getRightIcon().getDrawable();
    }

    public static /* synthetic */ void h(Function0 r10, View r11) {
        i(r10, r11);
    }

    public static final void i(Function0 r10, View r11) {
        q.g(r10, "$clickAction");
        r10.invoke();
    }

    public static final void j(Function0 r10, View r11) {
        q.g(r10, "$clickAction");
        r10.invoke();
    }

    private final void setLeftIc(Drawable r10) {
        getLeftIcon().setImageDrawable(r10);
        ImageView r11 = getLeftIcon();
        q.f(r11, "leftIcon");
        l.m(r11);
        invalidate();
    }

    private final void setRightIc(Drawable r10) {
        getRightIcon().setImageDrawable(r10);
        ImageView r11 = getRightIcon();
        q.f(r11, "rightIcon");
        l.m(r11);
        invalidate();
    }

    public final ImageView getLeftIcon() {
        return (ImageView) this.f17359a.getValue();
    }

    public final ImageView getRightIcon() {
        return (ImageView) this.f17361c.getValue();
    }

    public final boolean getTextRolling() {
        if (getTipsTv().isSelected() == true) goto L5;
    L7:
        return false;
    L5:
        if (getTipsLine() != 1) goto L7;
        return true;
    }

    public final int getTipsLine() {
        return getTipsTv().getMaxLines();
    }

    @Nullable
    public final String getTipsText() {
        CharSequence r10 = getTipsTv().getText();
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.toString();
    }

    public final TextView getTipsTv() {
        return (TextView) this.f17360b.getValue();
    }

    public final void setLeftIconOnClickListener(@NotNull final Function0<Unit> r10) {
        q.g(r10, "clickAction");
        ImageView r11 = getLeftIcon();
        if (r11 == null) goto L7;
        r11.setOnClickListener(new b(r10));
        return;
    }

    public final void setRightIconOnClickListener(@NotNull final Function0<Unit> r10) {
        q.g(r10, "clickAction");
        ImageView r11 = getRightIcon();
        if (r11 == null) goto L7;
        r11.setOnClickListener(new a(r10));
        return;
    }

    public final void setTextRolling(boolean r10) {
        getTipsTv().setSelected(r10);
        if (r10 == false) goto L5;
        getTipsTv().setMovementMethod(null);
        String r11 = getTipsText();
        getTipsTv().setText(null);
        getTipsTv().setText(r11);
        setTipsLine(1);
        getTipsTv().setMarqueeRepeatLimit(-1);
        getTipsTv().setEllipsize(TextUtils.TruncateAt.MARQUEE);
    L6:
        invalidate();
        return;
    L5:
        getTipsTv().setEllipsize(TextUtils.TruncateAt.END);
        goto L6
    }

    public final void setTipsLine(int r10) {
        getTipsTv().setMaxLines(r10);
        TextView r11 = getTipsTv();
        boolean r12 = true;
        if (r10 == 1) goto L6;
        r12 = false;
    L6:
        r11.setSingleLine(r12);
        invalidate();
    }

    public final void setTipsText(@Nullable String r10) {
        getTipsTv().setText(r10);
        invalidate();
    }

    @JvmOverloads
    public OTips(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OTips(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OTips(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f17359a = kotlin.b.b(new OTips$leftIcon$2(this));
        this.f17360b = kotlin.b.b(new OTips$tipsTv$2(this));
        this.f17361c = kotlin.b.b(new OTips$rightIcon$2(this));
        LayoutInflater.from(r10).inflate(R$layout.o_tips, this);
        if (r11 == null) goto L44;
        TypedArray r13 = r10.obtainStyledAttributes(r11, R$styleable.OTips);
        q.f(r13, "context.obtainStyledAttr…attrs, R.styleable.OTips)");
        Drawable r14 = r13.getDrawable(R$styleable.OTips_oui_leftIcon);
        if (r14 == null) goto L8;
        setLeftIc(r14);
    L8:
        Drawable r15 = r13.getDrawable(R$styleable.OTips_oui_RightIcon);
        if (r15 == null) goto L12;
        setRightIc(r15);
    L12:
        ColorStateList r16 = r13.getColorStateList(R$styleable.OTips_oui_leftIcon_tint);
        if (r16 == null) goto L22;
        this.f17363e = r16;
        ImageView r17 = getLeftIcon();
        if (r17 == null) goto L22;
        Drawable r18 = r17.getDrawable();
        if (r18 == null) goto L22;
        r18.setTintList(r16);
    L22:
        ColorStateList r19 = r13.getColorStateList(R$styleable.OTips_oui_rightIcon_tint);
        if (r19 == null) goto L32;
        this.f17362d = r19;
        ImageView r20 = getRightIcon();
        if (r20 == null) goto L32;
        Drawable r21 = r20.getDrawable();
        if (r21 == null) goto L32;
        r21.setTintList(r19);
    L32:
        Integer r22 = Integer.valueOf(r13.getColor(R$styleable.OTips_oui_tipsTextColor, -1));
        if (r22.intValue() != (-1)) goto L36;
        r22 = null;
    L36:
        if (r22 == null) goto L42;
        int r23 = r22.intValue();
        TextView r24 = getTipsTv();
        if (r24 == null) goto L42;
        r24.setTextColor(r23);
    L42:
        setTipsText(r13.getString(R$styleable.OTips_oui_tipsText));
        setTipsLine(r13.getInteger(R$styleable.OTips_oui_tipsLine, 1));
        setTextRolling(r13.getBoolean(R$styleable.OTips_oui_textRolling, false));
        this.f17364f = r13.getString(R$styleable.OTips_oui_spanText);
        r13.recycle();
        return;
    }
}
