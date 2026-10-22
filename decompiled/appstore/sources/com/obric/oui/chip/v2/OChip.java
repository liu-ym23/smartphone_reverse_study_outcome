package com.obric.oui.chip.v2;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0007\u0018\u0000 ~2\u00020\u0001:\u0001:B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0012J\u0015\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u0019J\u0015\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0019J\u0015\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u0019J\u0015\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\u0019J\u0015\u0010#\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b#\u0010\u0019J\u0015\u0010%\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\b%\u0010\u0019J\u0017\u0010(\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)JE\u0010.\u001a\u00020\u001026\u0010'\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\f¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100*¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020\u00102\u0006\u00100\u001a\u00020\f¢\u0006\u0004\b1\u0010\u0012J\u000f\u00102\u001a\u00020\fH\u0016¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010\u0019J\u0017\u00107\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\u0019R\u001c\u0010<\u001a\n 9*\u0004\u0018\u000108088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0017\u0010A\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b\u0016\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010F\u001a\u00020B8\u0006¢\u0006\f\n\u0004\b\u0014\u0010C\u001a\u0004\bD\u0010ER\u0017\u0010K\u001a\u00020G8\u0006¢\u0006\f\n\u0004\b\u0015\u0010H\u001a\u0004\bI\u0010JR\u0017\u0010N\u001a\u00020B8\u0006¢\u0006\f\n\u0004\bL\u0010C\u001a\u0004\bM\u0010ER\u0017\u0010P\u001a\u00020B8\u0006¢\u0006\f\n\u0004\b\r\u0010C\u001a\u0004\bO\u0010ER\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010RR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010RR\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010RR\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010RR\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010RR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010RR\u0016\u0010Y\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XRH\u0010\\\u001a4\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\f¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010RR\u0016\u0010c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010RR\u0016\u0010e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010RR\u0016\u0010g\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010RR\u0016\u0010i\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010RR\u0016\u0010k\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010RR\u0016\u0010m\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010RR\u0016\u0010o\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010XR\u001e\u0010t\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR*\u0010\u000f\u001a\u00020\f2\u0006\u0010u\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010X\u001a\u0004\bQ\u00103\"\u0004\bw\u0010\u0012R$\u0010}\u001a\u00020x2\u0006\u0010u\u001a\u00020x8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\by\u0010z\"\u0004\b{\u0010|¨\u0006\u007f"}, d2 = {"Lcom/obric/oui/chip/v2/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/content/res/TypedArray;", "typedArray", "", "f", "(Landroid/content/Context;Landroid/content/res/TypedArray;)Z", "isOn", "", "h", "(Z)V", "enable", "c", "d", "b", "widgetBgColor", "setWidgetBgColor", "(I)V", "textColor", "setChipTextColor", "chipIconTintColor", "setChipIconTintColor", "closeIconTintColor", "setCloseIconTintColor", "arrowIconTintColor", "setArrowIconTintColor", "widgetBgColorDisabled", "setWidgetBgColorDisabled", "textColorDisabled", "setChipTextColorDisabled", "Landroid/view/View$OnClickListener;", "l", "setOnCloseListener", "(Landroid/view/View$OnClickListener;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "setOnCheckedListener", "(Lkotlin/jvm/functions/Function2;)V", "isToggleable", "setToggleable", "performClick", "()Z", "minWidth", "setMinimumWidth", "minHeight", "setMinimumHeight", "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Landroid/view/View;", "parent", "Lcom/obric/oui/layout/OUILinearLayout;", "Lcom/obric/oui/layout/OUILinearLayout;", "getChipContainer", "()Lcom/obric/oui/layout/OUILinearLayout;", "chipContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "getChipIcon", "()Landroid/widget/ImageView;", "chipIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "e", "getCloseIcon", "closeIcon", "getArrowIcon", "arrowIcon", "g", "I", "i", "j", "k", "m", "n", "Z", "toggleable", "o", "Lkotlin/jvm/functions/Function2;", "onCheckedListener", "p", "Landroid/view/View$OnClickListener;", "onCloseListener", "q", "widgetPaddingLeft", "r", "widgetPaddingRight", "s", "chipIconSpaceL", "t", "chipIconSpaceR", "u", "chipArrowSpaceL", "v", "chipArrowSpaceR", "w", "pressColor", FixCard.FixStyle.KEY_X, "haveShadow", "", "Lcom/obric/oui/common/style/Shadow;", FixCard.FixStyle.KEY_Y, "Ljava/util/List;", "shadowsNormal", CommonKey.KEY_VALUE, "z", "setOn", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "A", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OChip extends OUIFrameLayout {
    public static final a A = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f12786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OUILinearLayout f12787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f12788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f12789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f12790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f12791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12794i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12796k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12797l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12798m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12799n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function2 f12800o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View.OnClickListener f12801p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12802q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12803r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f12804s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12805t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12806u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12807v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12808w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12809x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List f12810y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12811z;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        A = new a(null);
    }

    @JvmOverloads
    public OChip(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void a(OChip r10, View r11) {
        e(r10, r11);
    }

    public static final void e(OChip r10, View r11) {
        q.g(r10, "this$0");
        if (r10.isEnabled() == false) goto L9;
        View.OnClickListener r12 = r10.f12801p;
        if (r12 == null) goto L10;
        r12.onClick(r10.f12790e);
        return;
    L10:
        return;
    }

    public final void b(boolean r10) {
        if (r10 == false) goto L9;
        ImageView r11 = this.f12791f;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L8;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        r13.setMarginStart(this.f12806u);
        r11.setLayoutParams(r13);
        this.f12791f.setVisibility(0);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        ImageView r14 = this.f12791f;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L14;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        r16.setMarginStart(0);
        r14.setLayoutParams(r16);
        this.f12791f.setVisibility(8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void c(boolean r10) {
        if (r10 == false) goto L9;
        TextView r11 = this.f12789d;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L8;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        r13.setMarginStart(this.f12804s);
        r11.setLayoutParams(r13);
        this.f12788c.setVisibility(0);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        TextView r14 = this.f12789d;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L14;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        r16.setMarginStart(0);
        r14.setLayoutParams(r16);
        this.f12788c.setVisibility(8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void d(boolean r10) {
        if (r10 == false) goto L9;
        ImageView r11 = this.f12790e;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L8;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        r13.setMarginStart(this.f12805t);
        r11.setLayoutParams(r13);
        this.f12790e.setVisibility(0);
        this.f12790e.setOnClickListener(new rc.a(this));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        ImageView r14 = this.f12790e;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L14;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        r16.setMarginStart(0);
        r14.setLayoutParams(r16);
        this.f12790e.setVisibility(8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final boolean f(Context r10, TypedArray r11) {
        List r12 = OUILayoutHelper.p(r10, r11, R$styleable.OChip_oui_widgetShadowNormal);
        if (r12 == null) goto L5;
        this.f12810y = r12;
        q.d(r12);
        Shadow r13 = (Shadow) b0.a0(r12, 0);
        List r14 = this.f12810y;
        q.d(r14);
        setShadow(r13, (Shadow) b0.a0(r14, 1));
    L5:
        if (r12 == null) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean g() {
        return this.f12811z;
    }

    @NotNull
    public final ImageView getArrowIcon() {
        return this.f12791f;
    }

    @NotNull
    public final OUILinearLayout getChipContainer() {
        return this.f12787b;
    }

    @NotNull
    public final ImageView getChipIcon() {
        return this.f12788c;
    }

    @NotNull
    public final ImageView getCloseIcon() {
        return this.f12790e;
    }

    @NotNull
    public final CharSequence getText() {
        CharSequence r10 = this.f12789d.getText();
        q.f(r10, "textView.text");
        return r10;
    }

    @NotNull
    public final TextView getTextView() {
        return this.f12789d;
    }

    public final void h(boolean r10) {
        if (r10 == false) goto L27;
        int r11 = this.f12797l;
        if (r11 == 0) goto L7;
        this.f12787b.setBackgroundColor(r11);
    L7:
        if (this.f12792g == 0) goto L13;
        Drawable r12 = this.f12788c.getDrawable();
        if (r12 == null) goto L13;
        r12.setTint(this.f12792g);
    L13:
        if (this.f12793h == 0) goto L19;
        Drawable r13 = this.f12790e.getDrawable();
        if (r13 == null) goto L19;
        r13.setTint(this.f12793h);
    L19:
        if (this.f12794i == 0) goto L24;
        Drawable r14 = this.f12791f.getDrawable();
        if (r14 == null) goto L24;
        r14.setTint(this.f12794i);
    L24:
        int r15 = this.f12795j;
        if (r15 == 0) goto L38;
        this.f12789d.setTextColor(r15);
        return;
    L38:
        return;
    L27:
        int r16 = this.f12798m;
        if (r16 == 0) goto L31;
        this.f12787b.setBackgroundColor(r16);
    L31:
        if (this.f12796k == 0) goto L40;
        Drawable r17 = this.f12788c.getDrawable();
        if (r17 == null) goto L36;
        r17.setTint(this.f12796k);
    L36:
        this.f12789d.setTextColor(this.f12796k);
        return;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f12799n == false) goto L6;
        setOn(!g());
    L6:
        return super.performClick();
    }

    public final void setArrowIconTintColor(int r10) {
        if (r10 == 0) goto L10;
        this.f12794i = r10;
        if (g() == false) goto L11;
        Drawable r11 = this.f12791f.getDrawable();
        if (r11 == null) goto L12;
        r11.setTint(r10);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setChipIconTintColor(int r10) {
        if (r10 == 0) goto L10;
        this.f12792g = r10;
        if (g() == false) goto L11;
        Drawable r11 = this.f12788c.getDrawable();
        if (r11 == null) goto L12;
        r11.setTint(r10);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setChipTextColor(int r10) {
        if (r10 == 0) goto L7;
        this.f12795j = r10;
        if (g() == false) goto L8;
        this.f12789d.setTextColor(r10);
        return;
    L8:
        return;
    }

    public final void setChipTextColorDisabled(int r10) {
        if (r10 == 0) goto L11;
        this.f12796k = r10;
        if (g() == true) goto L12;
        Drawable r11 = this.f12788c.getDrawable();
        if (r11 == null) goto L9;
        r11.setTint(r10);
    L9:
        this.f12789d.setTextColor(r10);
        return;
    L12:
        return;
    }

    public final void setCloseIconTintColor(int r10) {
        if (r10 == 0) goto L10;
        this.f12793h = r10;
        if (g() == false) goto L11;
        Drawable r11 = this.f12790e.getDrawable();
        if (r11 == null) goto L12;
        r11.setTint(r10);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // android.view.View
    public void setMinimumHeight(int r10) {
        super.setMinimumHeight(r10);
        this.f12787b.setMinimumHeight(r10);
    }

    @Override // android.view.View
    public void setMinimumWidth(int r10) {
        super.setMinimumWidth(r10);
        this.f12787b.setMinimumWidth(r10);
    }

    public final void setOn(boolean r10) {
        if (this.f12811z == r10) goto L9;
        this.f12811z = r10;
        h(r10);
        Function2 r11 = this.f12800o;
        if (r11 == null) goto L10;
        r11.mo0invoke(this, Boolean.valueOf(this.f12811z));
        return;
    L10:
        return;
    }

    public final void setOnCheckedListener(@NotNull Function2<? super OChip, ? super Boolean, Unit> r10) {
        q.g(r10, "l");
        this.f12800o = r10;
    }

    public final void setOnCloseListener(@Nullable View.OnClickListener r10) {
        this.f12801p = r10;
    }

    public final void setText(@NotNull CharSequence r10) {
        q.g(r10, CommonKey.KEY_VALUE);
        this.f12789d.setText(r10);
    }

    public final void setToggleable(boolean r10) {
        this.f12799n = r10;
    }

    public final void setWidgetBgColor(int r10) {
        if (r10 == 0) goto L7;
        this.f12797l = r10;
        if (g() == false) goto L8;
        this.f12787b.setBackgroundColor(r10);
        return;
    L8:
        return;
    }

    public final void setWidgetBgColorDisabled(int r10) {
        if (r10 == 0) goto L7;
        this.f12798m = r10;
        if (g() == true) goto L8;
        this.f12787b.setBackgroundColor(r10);
        return;
    L8:
        return;
    }

    @JvmOverloads
    public OChip(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OChip(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OChip(@NotNull Context r12, @Nullable AttributeSet r13, int r14) {
        q.g(r12, "context");
        super(r12, r13, r14, null, 8, null);
        View r15 = FrameLayout.inflate(r12, R$layout.o_chip_v2, this);
        this.f12786a = r15;
        View r10 = r15.findViewById(R$id.chip_container);
        q.f(r10, "parent.findViewById(R.id.chip_container)");
        OUILinearLayout r11 = (OUILinearLayout) r10;
        this.f12787b = r11;
        View r16 = r15.findViewById(R$id.chip_icon);
        q.f(r16, "parent.findViewById(R.id.chip_icon)");
        ImageView r17 = (ImageView) r16;
        this.f12788c = r17;
        View r18 = r15.findViewById(R$id.chip_text);
        q.f(r18, "parent.findViewById(R.id.chip_text)");
        this.f12789d = (TextView) r18;
        View r19 = r15.findViewById(R$id.close_icon);
        q.f(r19, "parent.findViewById(R.id.close_icon)");
        ImageView r20 = (ImageView) r19;
        this.f12790e = r20;
        View r110 = r15.findViewById(R$id.arrow_icon);
        q.f(r110, "parent.findViewById(R.id.arrow_icon)");
        ImageView r111 = (ImageView) r110;
        this.f12791f = r111;
        this.f12811z = true;
        TypedArray r21 = r12.obtainStyledAttributes(r13, R$styleable.OChip);
        getChipIcon().setImageDrawable(r21.getDrawable(R$styleable.OChip_oui_chip_icon));
        getTextView().setText(r21.getText(R$styleable.OChip_oui_text));
        getCloseIcon().setImageDrawable(r21.getDrawable(R$styleable.OChip_oui_close_icon));
        getArrowIcon().setImageDrawable(r21.getDrawable(R$styleable.OChip_oui_chipArrowIcon));
        this.f12792g = r21.getColor(R$styleable.OChip_oui_chip_icon_tint_color, 0);
        this.f12793h = r21.getColor(R$styleable.OChip_oui_close_icon_tint_color, 0);
        this.f12794i = r21.getColor(R$styleable.OChip_oui_arrow_icon_tint_color, 0);
        this.f12795j = r21.getColor(R$styleable.OChip_oui_text_color, 0);
        this.f12796k = r21.getColor(R$styleable.OChip_oui_text_color_disabled, 0);
        this.f12797l = r21.getColor(R$styleable.OChip_oui_widgetBgColor, 0);
        this.f12798m = r21.getColor(R$styleable.OChip_oui_widgetBgColorDisabled, 0);
        this.f12799n = r21.getBoolean(R$styleable.OChip_oui_chip_toggleable, false);
        this.f12802q = r21.getDimensionPixelSize(R$styleable.OChip_oui_widgetPaddingL, 0);
        this.f12803r = r21.getDimensionPixelSize(R$styleable.OChip_oui_widgetPaddingR, 0);
        this.f12804s = r21.getDimensionPixelSize(R$styleable.OChip_oui_chipIconSpaceL, 0);
        this.f12805t = r21.getDimensionPixelSize(R$styleable.OChip_oui_chipIconSpaceR, 0);
        this.f12806u = r21.getDimensionPixelSize(R$styleable.OChip_oui_chipArrowSpaceL, 0);
        this.f12807v = r21.getDimensionPixelSize(R$styleable.OChip_oui_chipArrowSpaceR, 0);
        getChipContainer().setPadding(this.f12802q, getChipContainer().getPaddingTop(), this.f12803r, getChipContainer().getPaddingBottom());
        int r22 = r21.getColor(R$styleable.OChip_oui_widgetPressColor, 0);
        this.f12808w = r22;
        if (r22 == 0) goto L5;
        getChipContainer().setOverridePressColor(this.f12808w);
        getChipContainer().refreshColors("OChip");
    L5:
        q.f(r21, "this");
        this.f12809x = f(r12, r21);
        r21.recycle();
        TypedArray r112 = r12.obtainStyledAttributes(r13, new int[]{R.attr.minWidth, R.attr.minHeight});
        int r113 = r112.getDimensionPixelSize(0, 0);
        int r23 = r112.getDimensionPixelSize(1, 0);
        if (r113 <= 0) goto L8;
        getChipContainer().setMinimumWidth(r113);
    L8:
        if (r23 <= 0) goto L10;
        getChipContainer().setMinimumHeight(r23);
    L10:
        r112.recycle();
        setChangeAlphaWhenPress(false);
        if (r17.getDrawable() == null) goto L13;
        boolean r114 = true;
    L14:
        c(r114);
        if (r20.getDrawable() == null) goto L17;
        boolean r115 = true;
    L18:
        d(r115);
        if (r111.getDrawable() == null) goto L21;
        boolean r116 = true;
    L22:
        b(r116);
        h(true);
        int r117 = f.r(this, 99);
        if (this.f12809x == false) goto L25;
        L.a("OChip", "initShadows, have shadow");
        setShadowCornerRadius(r117);
        r11.setRadius(r117);
    L26:
        setClipChildren(false);
        return;
    L25:
        setRadius(r117);
        goto L26
    L21:
        r116 = false;
        goto L22
    L17:
        r115 = false;
        goto L18
    L13:
        r114 = false;
        goto L14
    }
}
