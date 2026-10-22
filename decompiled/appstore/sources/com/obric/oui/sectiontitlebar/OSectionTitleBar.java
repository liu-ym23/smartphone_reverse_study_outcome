package com.obric.oui.sectiontitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 <2\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u0011J\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0011J\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b#\u0010\u000eJ\u0015\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J\u0015\u0010*\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b*\u0010\u0011J\u0015\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0006¢\u0006\u0004\b-\u0010\u0011J\u0015\u0010.\u001a\u00020\f2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b.\u0010'R\u0016\u00100\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/obric/oui/sectiontitlebar/OSectionTitleBar;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "text", "", "setTitleText", "(Ljava/lang/CharSequence;)V", "resId", "setTitleStyle", "(I)V", "", "size", "setTitleTextSize", "(F)V", "color", "setTitleTextColor", "Landroid/view/View;", "view", "setCustomEndView", "(Landroid/view/View;)V", "defaultCustomEnd", "setDefaultCustomEndView", "getCustomEndView", "()Landroid/view/View;", "Lcom/obric/oui/text/OTextView;", "getEndDetail", "()Lcom/obric/oui/text/OTextView;", "setDetailEndText", "", "show", "a", "(Z)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setTailIcon", "(Landroid/graphics/drawable/Drawable;)V", "defaultTailIcon", "setDefaultTailIcon", "b", "Landroid/widget/LinearLayout;", "container", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleTextView", "Landroid/widget/FrameLayout;", "c", "Landroid/widget/FrameLayout;", "customEndContainer", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "tailIcon", "e", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSectionTitleBar extends LinearLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f16546e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16547f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f16548g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f16549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f16550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f16551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f16552d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f16546e = new a(null);
    }

    @JvmOverloads
    public OSectionTitleBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final void a(boolean r10) {
        int r11 = 8;
        if (this.f16551c.getChildCount() == 0) goto L8;
        FrameLayout r12 = this.f16551c;
        if (r10 == false) goto L7;
        r11 = 0;
    L7:
        r12.setVisibility(r11);
        return;
    L8:
        this.f16551c.setVisibility(8);
    }

    public final void b(boolean r10) {
        int r11 = 8;
        if (this.f16552d.getDrawable() == null) goto L8;
        ImageView r12 = this.f16552d;
        if (r10 == false) goto L7;
        r11 = 0;
    L7:
        r12.setVisibility(r11);
        return;
    L8:
        this.f16552d.setVisibility(8);
    }

    @Nullable
    public final View getCustomEndView() {
        if (this.f16551c.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.f16551c.getChildAt(0);
    }

    @Nullable
    public final OTextView getEndDetail() {
        if ((getCustomEndView() instanceof OTextView) == false) goto L10;
        View r10 = getCustomEndView();
        if (r10 == null) goto L9;
        return (OTextView) r10;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L10:
        return null;
    }

    public final void setCustomEndView(@Nullable View r10) {
        this.f16551c.removeAllViews();
        if (r10 == null) goto L5;
        this.f16551c.addView(r10);
        return;
    L5:
        a(false);
    }

    public final void setDefaultCustomEndView(int r10) {
        this.f16551c.removeAllViews();
        if (r10 != f16547f) goto L5;
        setCustomEndView(R$layout.o_section_titlebar_custom_end_detail);
        return;
    L5:
        a(false);
    }

    public final void setDefaultTailIcon(int r10) {
        if (r10 != f16548g) goto L5;
        setTailIcon(getResources().getDrawable(R$drawable.o_section_titlebar_tail_icon_arrow));
        return;
    L5:
        b(false);
    }

    public final void setDetailEndText(@Nullable CharSequence r10) {
        setDefaultCustomEndView(f16547f);
        if ((getCustomEndView() instanceof OTextView) == false) goto L9;
        View r11 = getCustomEndView();
        if (r11 == null) goto L8;
        ((OTextView) r11).setText(r10);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    }

    public final void setTailIcon(@Nullable Drawable r10) {
        if (r10 == null) goto L4;
        this.f16552d.setImageDrawable(r10);
        return;
    L4:
        b(false);
    }

    public final void setTitleStyle(int r10) {
        this.f16550b.setTextAppearance(r10);
    }

    public final void setTitleText(@Nullable CharSequence r10) {
        this.f16550b.setText(r10);
    }

    public final void setTitleTextColor(int r10) {
        this.f16550b.setTextColor(r10);
    }

    public final void setTitleTextSize(float r10) {
        this.f16550b.setTextSize(r10);
    }

    @JvmOverloads
    public OSectionTitleBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OSectionTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public final void setTailIcon(int r10) {
        if (r10 == 0) goto L4;
        this.f16552d.setImageResource(r10);
        return;
    L4:
        this.f16552d.setImageDrawable(null);
        b(false);
    }

    @JvmOverloads
    public OSectionTitleBar(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        setOrientation(0);
        LayoutInflater.from(r10).inflate(R$layout.o_section_title_bar, this, true);
        View r13 = findViewById(R$id.container);
        q.f(r13, "findViewById(R.id.container)");
        this.f16549a = (LinearLayout) r13;
        View r14 = findViewById(R$id.titleTextView);
        q.f(r14, "findViewById(R.id.titleTextView)");
        this.f16550b = (TextView) r14;
        View r15 = findViewById(R$id.custom_end_container);
        q.f(r15, "findViewById(R.id.custom_end_container)");
        this.f16551c = (FrameLayout) r15;
        View r16 = findViewById(R$id.tail_icon);
        q.f(r16, "findViewById(R.id.tail_icon)");
        this.f16552d = (ImageView) r16;
        TypedArray r17 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.SectionTitleBar, 0, 0);
        q.f(r17, "context.theme.obtainStyl…           0, 0\n        )");
        int r18 = R$styleable.SectionTitleBar_sectionTitle_titleText;     // Catch: Throwable -> L6
        if (r17.hasValue(r18) == false) goto L8;
        setTitleText(r17.getString(r18));     // Catch: Throwable -> L6
    L8:
        int r19 = R$styleable.SectionTitleBar_sectionTitle_titleStyle;     // Catch: Throwable -> L6
        if (r17.hasValue(r19) == false) goto L11;
        setTitleStyle(r17.getResourceId(r19, R$style.OSectionTitleBar_S));     // Catch: Throwable -> L6
    L11:
        int r20 = R$styleable.SectionTitleBar_sectionTitle_customEnd;     // Catch: Throwable -> L6
        if (r17.hasValue(r20) == false) goto L14;
        setCustomEndView(r17.getResourceId(r20, 0));     // Catch: Throwable -> L6
    L14:
        int r21 = R$styleable.SectionTitleBar_sectionTitle_defaultCustomEnd;     // Catch: Throwable -> L6
        if (r17.hasValue(r21) == false) goto L17;
        setDefaultCustomEndView(r17.getInt(r21, 0));     // Catch: Throwable -> L6
    L17:
        int r22 = R$styleable.SectionTitleBar_sectionTitle_detailEndText;     // Catch: Throwable -> L6
        if (r17.hasValue(r22) == false) goto L20;
        setDetailEndText(r17.getString(r22));     // Catch: Throwable -> L6
    L20:
        int r23 = R$styleable.SectionTitleBar_sectionTitle_showCustomEnd;     // Catch: Throwable -> L6
        if (r17.hasValue(r23) == false) goto L23;
        a(r17.getBoolean(r23, false));     // Catch: Throwable -> L6
    L23:
        int r24 = R$styleable.SectionTitleBar_sectionTitle_tail;     // Catch: Throwable -> L6
        if (r17.hasValue(r24) == false) goto L26;
        setTailIcon(r17.getResourceId(r24, 0));     // Catch: Throwable -> L6
    L26:
        int r25 = R$styleable.SectionTitleBar_sectionTitle_defaultTail;     // Catch: Throwable -> L6
        if (r17.hasValue(r25) == false) goto L29;
        setDefaultTailIcon(r17.getInt(r25, 0));     // Catch: Throwable -> L6
    L29:
        int r26 = R$styleable.SectionTitleBar_sectionTitle_showTail;     // Catch: Throwable -> L6
        if (r17.hasValue(r26) == false) goto L32;
        b(r17.getBoolean(r26, false));     // Catch: Throwable -> L6
    L32:
        r17.recycle();
        return;
    L6:
        th = move-exception;
        r17.recycle();
        throw th;
    }

    public final void setCustomEndView(int r10) {
        this.f16551c.removeAllViews();
        if (r10 != 0) goto L9;
    L6:
        a(false);
        return;
    L9:
        LinearLayout.inflate(getContext(), r10, this.f16551c);     // Catch: Exception -> L8
    }
}
