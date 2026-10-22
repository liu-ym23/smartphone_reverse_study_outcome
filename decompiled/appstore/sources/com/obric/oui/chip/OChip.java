package com.obric.oui.chip;

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
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "use com.obric.oui.chip.v2.OChip instead")
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001HB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJE\u0010\u0015\u001a\u00020\f26\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\"\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0013H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0013H\u0002¢\u0006\u0004\b'\u0010&R\u001c\u0010,\u001a\n )*\u0004\u0018\u00010(0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0017\u00101\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b%\u0010.\u001a\u0004\b/\u00100R\u0017\u00106\u001a\u0002028\u0006¢\u0006\f\n\u0004\b'\u00103\u001a\u0004\b4\u00105R\u0017\u00109\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b7\u0010.\u001a\u0004\b8\u00100R\u0014\u0010<\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010;RF\u0010@\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f0\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R$\u0010G\u001a\u00020A2\u0006\u0010B\u001a\u00020A8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lcom/obric/oui/chip/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View$OnClickListener;", "l", "", "setOnCloseListener", "(Landroid/view/View$OnClickListener;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "", CommonConfirmDialog.ARGS_CHECKED, "setOnCheckedListener", "(Lkotlin/jvm/functions/Function2;)V", "performClick", "()Z", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "enable", "b", "(Z)V", "c", "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Landroid/view/View;", "parent", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "getChipIcon", "()Landroid/widget/ImageView;", "chipIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "d", "getCloseIcon", "closeIcon", "e", "Z", "enableChecked", "f", "g", "Lkotlin/jvm/functions/Function2;", "onCheckedListener", "", CommonKey.KEY_VALUE, "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "Style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OChip extends OUIFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f12778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f12779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f12780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f12781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function2 f12784g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/chip/OChip$Style;", "", "(Ljava/lang/String;I)V", "Default", "Rect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style Default = null;
        public static final Style Rect = null;

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{Default, Rect};
        }

        static {
            Default = new Style("Default", 0);
            Rect = new Style("Rect", 1);
            $VALUES = $values();
        }

        private Style(String r10, int r11) {
            super(r10, r11);
        }

        public static Style valueOf(String r10) {
            return (Style) Enum.valueOf(Style.class, r10);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12785a = null;

        static {
            int[] r10 = new int[Style.values().length];
            r10[Style.Default.ordinal()] = 1;
            r10[Style.Rect.ordinal()] = 2;
            f12785a = r10;
        }
    }

    @JvmOverloads
    public OChip(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ boolean a(OChip r10) {
        return r10.f12783f;
    }

    public final void b(boolean r10) {
        if (r10 == false) goto L9;
        TextView r11 = this.f12780c;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L8;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        r13.setMarginStart(f.r(this, 4));
        r11.setLayoutParams(r13);
        this.f12779b.setVisibility(0);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        TextView r14 = this.f12780c;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L14;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        r16.setMarginStart(f.r(this, 6));
        r14.setLayoutParams(r16);
        this.f12779b.setVisibility(8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void c(boolean r10) {
        if (r10 == false) goto L9;
        TextView r11 = this.f12780c;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L8;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        r13.setMarginEnd(f.r(this, 6));
        r11.setLayoutParams(r13);
        this.f12781d.setVisibility(0);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        TextView r14 = this.f12780c;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L14;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        r16.setMarginEnd(f.r(this, 6));
        r14.setLayoutParams(r16);
        this.f12781d.setVisibility(8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @NotNull
    public final ImageView getChipIcon() {
        return this.f12779b;
    }

    @NotNull
    public final ImageView getCloseIcon() {
        return this.f12781d;
    }

    @NotNull
    public final CharSequence getText() {
        CharSequence r10 = this.f12780c.getText();
        q.f(r10, "textView.text");
        return r10;
    }

    @NotNull
    public final TextView getTextView() {
        return this.f12780c;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f12782e == false) goto L6;
        boolean r10 = !this.f12783f;
        this.f12783f = r10;
        this.f12784g.mo0invoke(this, Boolean.valueOf(r10));
    L6:
        return super.performClick();
    }

    public final void setOnCheckedListener(@NotNull Function2<? super OChip, ? super Boolean, Unit> r10) {
        q.g(r10, "l");
        this.f12784g = r10;
    }

    public final void setOnCloseListener(@Nullable View.OnClickListener r10) {
        this.f12781d.setOnClickListener(r10);
    }

    public final void setText(@NotNull CharSequence r10) {
        q.g(r10, CommonKey.KEY_VALUE);
        this.f12780c.setText(r10);
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
    public OChip(@NotNull final Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12, null, 8, null);
        View r13 = FrameLayout.inflate(r10, R$layout.o_chip, this);
        this.f12778a = r13;
        View r14 = r13.findViewById(R$id.chip_icon);
        q.f(r14, "parent.findViewById(R.id.chip_icon)");
        ImageView r15 = (ImageView) r14;
        this.f12779b = r15;
        View r16 = r13.findViewById(R$id.chip_text);
        q.f(r16, "parent.findViewById(R.id.chip_text)");
        TextView r17 = (TextView) r16;
        this.f12780c = r17;
        View r18 = r13.findViewById(R$id.close_icon);
        q.f(r18, "parent.findViewById(R.id.close_icon)");
        ImageView r19 = (ImageView) r18;
        this.f12781d = r19;
        this.f12784g = new OChip$onCheckedListener$1(this, r10);
        TypedArray r20 = r10.obtainStyledAttributes(r11, R$styleable.OChip);
        getChipIcon().setImageDrawable(r20.getDrawable(R$styleable.OChip_oui_chip_icon));
        getTextView().setText(r20.getText(R$styleable.OChip_oui_text));
        getCloseIcon().setImageDrawable(r20.getDrawable(R$styleable.OChip_oui_close_icon));
        int r110 = r20.getColor(R$styleable.OChip_oui_chip_icon_tint_color, -1);
        int r21 = r20.getColor(R$styleable.OChip_oui_close_icon_tint_color, -1);
        int r22 = r20.getColor(R$styleable.OChip_oui_text_color, -1);
        boolean r23 = false;
        this.f12782e = r20.getBoolean(R$styleable.OChip_oui_enable_checked, false);
        Style r24 = Style.values()[r20.getInt(R$styleable.OChip_oui_chip_style, 0)];
        r20.recycle();
        if (r15.getDrawable() == null) goto L5;
        boolean r25 = true;
    L6:
        b(r25);
        if (r19.getDrawable() == null) goto L9;
        r23 = true;
    L9:
        c(r23);
        if (r110 == (-1)) goto L15;
        Drawable r26 = r15.getDrawable();
        if (r26 == null) goto L15;
        r26.setTint(r110);
    L15:
        if (r21 == (-1)) goto L20;
        Drawable r27 = r19.getDrawable();
        if (r27 == null) goto L20;
        r27.setTint(r21);
    L20:
        if (r22 == (-1)) goto L22;
        r17.setTextColor(r22);
    L22:
        int r28 = a.f12785a[r24.ordinal()];
        if (r28 != 1) goto L25;
        int r29 = f.r(this, 99);
    L30:
        setRadius(r29);
        return;
    L25:
        if (r28 != 2) goto L28;
        r29 = f.r(this, 8);
        goto L30
    L28:
        throw new NoWhenBranchMatchedException();
    L5:
        r25 = false;
        goto L6
    }
}
