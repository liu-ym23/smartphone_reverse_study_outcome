package com.obric.oui.badge;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.OUIStyleProvider;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.chrono.HijrahDate;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 N2\u00020\u0001:\u0001OB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0014¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020!H\u0014¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020!H\u0016¢\u0006\u0004\b&\u0010'J\u0019\u0010*\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b-\u0010.J\u001f\u00102\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00062\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020\f2\u0006\u00104\u001a\u00020\u0015¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010.J\u0019\u00109\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b9\u0010'J\u0015\u0010;\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u0006¢\u0006\u0004\b;\u0010.J!\u0010<\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\fH\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\fH\u0002¢\u0006\u0004\b@\u0010?J\u0017\u0010B\u001a\u00020\f2\u0006\u0010A\u001a\u000200H\u0002¢\u0006\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006P"}, d2 = {"Lcom/obric/oui/badge/OBadgeView;", "Lcom/obric/oui/text/OTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/drawable/Drawable;", "who", "verifyDrawable", "(Landroid/graphics/drawable/Drawable;)Z", "drawable", "invalidateDrawable", "(Landroid/graphics/drawable/Drawable;)V", "", "contentDescription", "setContentDescription", "(Ljava/lang/CharSequence;)V", "color", "setTextColor", "(I)V", "unit", "", "size", "setTextSize", "(IF)V", "enabled", "setEnableFontScale", "(Z)V", "setBackgroundColor", "background", "setBackground", "maxNumber", "setMaxNumberInCount", "c", "(Landroid/util/AttributeSet;I)V", "d", "()V", "e", "sizePx", "f", "(F)V", "Lcom/obric/oui/badge/OBadgeDrawable;", "i", "Lcom/obric/oui/badge/OBadgeDrawable;", "badge", "j", "Ljava/lang/Integer;", "initialBgColor", "k", "Z", "enableFontScale", "l", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBadgeView extends OTextView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f12417l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f12418m;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OBadgeDrawable f12419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f12420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12421k;

    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBadgeView f12422a;

        public a(OBadgeView r10) {
            this.f12422a = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            OBadgeDrawable r14 = OBadgeView.b(this.f12422a);
            String r15 = null;
            if (r14 != null) goto L5;
            q.y("badge");
            r14 = null;
        L5:
            if (r10 == null) goto L8;
            r15 = r10.toString();
        L8:
            r14.i(r15);
            this.f12422a.requestLayout();
            this.f12422a.invalidate();
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    static {
        f12417l = new b(null);
        f12418m = HijrahDate.MAX_VALUE_OF_ERA;
    }

    @JvmOverloads
    public OBadgeView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ OBadgeDrawable b(OBadgeView r10) {
        return r10.f12419i;
    }

    public final void c(AttributeSet r10, int r11) {
        OBadgeDrawable r12 = this.f12419i;
        OBadgeDrawable r13 = null;
        if (r12 != null) goto L5;
        q.y("badge");
        r12 = null;
    L5:
        r12.h(OBadgeDrawable.BadgeGravity.CENTER);
        if (r10 != null) goto L13;
        OBadgeDrawable r14 = this.f12419i;
        if (r14 != null) goto L10;
        q.y("badge");
    L11:
        r13.k(getContentDescription());
        return;
    L10:
        r13 = r14;
        goto L11
    L13:
        TypedArray r15 = getContext().obtainStyledAttributes(r10, R$styleable.OBadgeView, r11, 0);
        q.f(r15, "context.obtainStyledAttr…dgeView, defStyleAttr, 0)");
        this.f12421k = r15.getBoolean(R$styleable.OBadgeView_oui_widgetEnableFontScale, true);     // Catch: Throwable -> L17
        OBadgeDrawable r16 = this.f12419i;     // Catch: Throwable -> L17
        if (r16 != null) goto L19;
        q.y("badge");     // Catch: Throwable -> L17
        r16 = null;
    L19:
        r16.m(this.f12421k);     // Catch: Throwable -> L17
        int r17 = R$styleable.OBadgeView_o_maxNumber;     // Catch: Throwable -> L17
        OBadgeDrawable r18 = this.f12419i;     // Catch: Throwable -> L17
        if (r18 != null) goto L22;
        q.y("badge");     // Catch: Throwable -> L17
        r18 = null;
    L22:
        int r19 = r15.getInt(r17, r18.c());     // Catch: Throwable -> L17
        OBadgeDrawable r20 = this.f12419i;     // Catch: Throwable -> L17
        if (r20 != null) goto L25;
        q.y("badge");     // Catch: Throwable -> L17
        r20 = null;
    L25:
        r20.n(r19);     // Catch: Throwable -> L17
        int r21 = r15.getColor(R$styleable.OBadgeView_oui_badgeview_ellipsis_color, 0);     // Catch: Throwable -> L17
        OBadgeDrawable r22 = this.f12419i;     // Catch: Throwable -> L17
        if (r22 != null) goto L28;
        q.y("badge");     // Catch: Throwable -> L17
        r22 = null;
    L28:
        r22.l(Integer.valueOf(r21));     // Catch: Throwable -> L17
        int r23 = R$styleable.OBadgeView_android_text;     // Catch: Throwable -> L17
        if (r15.hasValue(r23) == false) goto L37;
        CharSequence r24 = r15.getText(r23);     // Catch: Throwable -> L17
        OBadgeDrawable r25 = this.f12419i;     // Catch: Throwable -> L17
        if (r25 != null) goto L33;
        q.y("badge");     // Catch: Throwable -> L17
        r25 = null;
    L33:
        if (r24 != null) goto L35;
        String r26 = null;
    L36:
        r25.i(r26);     // Catch: Throwable -> L17
        goto L37
    L35:
        r26 = r24.toString();     // Catch: Throwable -> L17
    L37:
        int r27 = R$styleable.OBadgeView_android_textColor;     // Catch: Throwable -> L17
        if (r15.hasValue(r27) == false) goto L43;
        int r28 = r15.getColor(r27, getCurrentTextColor());     // Catch: Throwable -> L17
        OBadgeDrawable r29 = this.f12419i;     // Catch: Throwable -> L17
        if (r29 != null) goto L42;
        q.y("badge");     // Catch: Throwable -> L17
        r29 = null;
    L42:
        r29.j(r28);     // Catch: Throwable -> L17
    L43:
        int r30 = R$styleable.OBadgeView_android_textSize;     // Catch: Throwable -> L17
        if (r15.hasValue(r30) == false) goto L46;
        f(r15.getDimension(r30, getTextSize()));     // Catch: Throwable -> L17
    L46:
        int r31 = R$styleable.OBadgeView_android_background;     // Catch: Throwable -> L17
        if (r15.hasValue(r31) == false) goto L52;
        int r32 = r15.getColor(r31, ContextCompat.b(getContext(), R$color.oui_red_6));     // Catch: Throwable -> L17
        OBadgeDrawable r33 = this.f12419i;     // Catch: Throwable -> L17
        if (r33 != null) goto L51;
        q.y("badge");     // Catch: Throwable -> L17
        r33 = null;
    L51:
        r33.g(r32);     // Catch: Throwable -> L17
    L52:
        r15.recycle();
        OBadgeDrawable r34 = this.f12419i;
        if (r34 != null) goto L55;
        q.y("badge");
    L56:
        r13.k(getContentDescription());
        return;
    L55:
        r13 = r34;
    L17:
        th = move-exception;
        r15.recycle();
        throw th;
    }

    public final void d() {
        OBadgeDrawable r10 = this.f12419i;
        OBadgeDrawable r11 = null;
        if (r10 != null) goto L5;
        q.y("badge");
        r10 = null;
    L5:
        CharSequence r12 = getText();
        if (r12 != null) goto L8;
        String r13 = null;
    L9:
        r10.i(r13);
        OBadgeDrawable r14 = this.f12419i;
        if (r14 != null) goto L12;
        q.y("badge");
        r14 = null;
    L12:
        r14.j(getCurrentTextColor());
        OBadgeDrawable r15 = this.f12419i;
        if (r15 != null) goto L15;
        q.y("badge");
        r15 = null;
    L15:
        r15.m(this.f12421k);
        f(getTextSize());
        Drawable r16 = getBackground();
        if ((r16 instanceof ColorDrawable) == false) goto L23;
        OBadgeDrawable r17 = this.f12419i;
        if (r17 != null) goto L20;
        q.y("badge");
    L21:
        r11.g(((ColorDrawable) r16).getColor());
        return;
    L20:
        r11 = r17;
        goto L21
    L23:
        if (this.f12420j == null) goto L31;
        OBadgeDrawable r18 = this.f12419i;
        if (r18 != null) goto L27;
        q.y("badge");
    L28:
        Integer r19 = this.f12420j;
        q.d(r19);
        r11.g(r19.intValue());
        return;
    L27:
        r11 = r18;
        goto L28
    L31:
        return;
    L8:
        r13 = r12.toString();
        goto L9
    }

    public final void e() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L12;
        OBadgeDrawable r10 = this.f12419i;
        if (r10 != null) goto L9;
        q.y("badge");
        r10 = null;
    L9:
        r10.q(this);
        return;
    }

    public final void f(float r10) {
        float r11 = r10 / getResources().getDisplayMetrics().scaledDensity;
        OBadgeDrawable r12 = this.f12419i;
        if (r12 != null) goto L5;
        q.y("badge");
        r12 = null;
    L5:
        r12.o(r11);
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r10) {
        q.g(r10, "drawable");
        OBadgeDrawable r11 = this.f12419i;
        if (r11 != null) goto L6;
        q.y("badge");
        r11 = null;
    L6:
        if (q.b(r10, r11) == false) goto L8;
        invalidate();
        return;
    L8:
        super.invalidateDrawable(r10);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        OBadgeDrawable r11 = this.f12419i;
        if (r11 != null) goto L5;
        q.y("badge");
        r11 = null;
    L5:
        r11.draw(r10);
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (r10 == false) goto L6;
        e();
        return;
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        OBadgeDrawable r12 = this.f12419i;
        OBadgeDrawable r13 = null;
        if (r12 != null) goto L5;
        q.y("badge");
        r12 = null;
    L5:
        r12.q(this);
        OBadgeDrawable r14 = this.f12419i;
        if (r14 != null) goto L8;
        q.y("badge");
    L9:
        Rect r15 = r13.getBounds();
        q.f(r15, "badge.bounds");
        int r16 = r15.width();
        int r17 = r15.height();
        setMeasuredDimension(TextView.resolveSize(r16 + (getPaddingLeft() + getPaddingRight()), r10), TextView.resolveSize(r17 + (getPaddingTop() + getPaddingBottom()), r11));
        return;
    L8:
        r13 = r14;
        goto L9
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        e();
    }

    @Override // android.view.View
    public void setBackground(@Nullable Drawable r10) {
        OBadgeDrawable r11 = this.f12419i;
        if (r11 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof ColorDrawable) == false) goto L7;
        ColorDrawable r12 = (ColorDrawable) r10;
    L8:
        if (r12 == null) goto L15;
        if (r11 != null) goto L12;
        q.y("badge");
        r11 = null;
    L12:
        r11.g(r12.getColor());
        invalidate();
        return;
    L15:
        return;
    L7:
        r12 = null;
        goto L8
    }

    @Override // android.view.View
    public void setBackgroundColor(int r10) {
        OBadgeDrawable r11 = this.f12419i;
        if (r11 == null) goto L8;
        if (r11 != null) goto L6;
        q.y("badge");
        r11 = null;
    L6:
        r11.g(r10);
        invalidate();
        return;
    }

    @Override // android.view.View
    public void setContentDescription(@Nullable CharSequence r10) {
        super.setContentDescription(r10);
        OBadgeDrawable r11 = this.f12419i;
        if (r11 != null) goto L5;
        q.y("badge");
        r11 = null;
    L5:
        r11.k(r10);
    }

    public final void setEnableFontScale(boolean r10) {
        if (this.f12421k != r10) goto L5;
        return;
    L5:
        this.f12421k = r10;
        OBadgeDrawable r11 = this.f12419i;
        if (r11 != null) goto L8;
        q.y("badge");
        r11 = null;
    L8:
        r11.m(r10);
        d();
        requestLayout();
        invalidate();
    }

    public final void setMaxNumberInCount(int r10) {
        OBadgeDrawable r11 = this.f12419i;
        if (r11 != null) goto L5;
        q.y("badge");
        r11 = null;
    L5:
        r11.n(r10);
        requestLayout();
        invalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int r10) {
        if (this.f12419i == null) goto L9;
        super.setTextColor(r10);
        OBadgeDrawable r11 = this.f12419i;
        if (r11 != null) goto L7;
        q.y("badge");
        r11 = null;
    L7:
        r11.j(getCurrentTextColor());
        invalidate();
        return;
    }

    @Override // android.widget.TextView
    public void setTextSize(int r10, float r11) {
        super.setTextSize(r10, r11);
        if (this.f12419i == null) goto L5;
        f(getTextSize());
    L5:
        requestLayout();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r10) {
        q.g(r10, "who");
        if (super.verifyDrawable(r10) == true) goto L11;
        OBadgeDrawable r11 = this.f12419i;
        if (r11 != null) goto L8;
        q.y("badge");
        r11 = null;
    L8:
        if (q.b(r10, r11) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @JvmOverloads
    public OBadgeView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OBadgeView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OBadgeView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        OUIStyleProvider r13 = null;
        super(r10, r11, r12, r13, 8, null);
        this.f12421k = true;
        OBadgeDrawable r14 = OBadgeDrawable.f12389J.a(r10);
        this.f12419i = r14;
        if (r14 != null) goto L5;
        q.y("badge");
        r14 = null;
    L5:
        r14.setCallback(this);
        c(r11, r12);
        d();
        addTextChangedListener(new a(this));
    }
}
