package com.obric.oui.chip.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.common.oui.R;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.utils.log.L;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OChip.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 Q2\u00020\u0001:\u0001QB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\u0019H\u0002J\u0010\u0010?\u001a\u00020$2\u0006\u0010>\u001a\u00020\u0019H\u0002J\u0010\u0010@\u001a\u00020$2\u0006\u0010>\u001a\u00020\u0019H\u0002J\u0018\u0010A\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020\u0019H\u0016J\u0010\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020\u0007H\u0016J\u0010\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020\u0007H\u0016J>\u0010I\u001a\u00020$26\u0010J\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020$0 J\u0010\u0010K\u001a\u00020$2\b\u0010J\u001a\u0004\u0018\u00010&J\u000e\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020\u0019J\u000e\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020\u0019J\u0010\u0010P\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u0019H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR@\u0010\u001f\u001a4\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020$\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n )*\u0004\u0018\u00010(0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010/\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/obric/oui/chip/v2/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowIcon", "Landroid/widget/ImageView;", "arrowIconTintColor", "chipArrowSpaceL", "chipArrowSpaceR", "chipContainer", "Lcom/obric/oui/layout/OUILinearLayout;", "chipIcon", "getChipIcon", "()Landroid/widget/ImageView;", "chipIconSpaceL", "chipIconSpaceR", "chipIconTintColor", "closeIcon", "closeIconTintColor", "haveShadow", "", "value", "isOn", "()Z", "setOn", "(Z)V", "onCheckedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "", "onCloseListener", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/View;", "kotlin.jvm.PlatformType", "pressColor", "shadowsNormal", "", "Lcom/obric/oui/common/style/Shadow;", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textColor", "textColorDisabled", "textView", "Landroid/widget/TextView;", "toggleable", "widgetBgColor", "widgetBgColorDisabled", "widgetPaddingLeft", "widgetPaddingRight", "initArrowIcon", "enable", "initChipIcon", "initCloseIcon", "initShadows", "typedArray", "Landroid/content/res/TypedArray;", "performClick", "setMinimumHeight", "minHeight", "setMinimumWidth", "minWidth", "setOnCheckedListener", "l", "setOnCloseListener", "setToggleable", "isToggleable", "updateCloseIcon", "visible", "updateColors", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OChip extends OUIFrameLayout {
    public static final Companion Companion = null;
    private static final String TAG = "OChip";
    private final ImageView arrowIcon;
    private final int arrowIconTintColor;
    private int chipArrowSpaceL;
    private int chipArrowSpaceR;
    private final OUILinearLayout chipContainer;
    private final ImageView chipIcon;
    private int chipIconSpaceL;
    private int chipIconSpaceR;
    private final int chipIconTintColor;
    private final ImageView closeIcon;
    private final int closeIconTintColor;
    private boolean haveShadow;
    private boolean isOn;
    private Function2<? super OChip, ? super Boolean, Unit> onCheckedListener;
    private View.OnClickListener onCloseListener;
    private final View parent;
    private int pressColor;
    private List<Shadow> shadowsNormal;
    private final int textColor;
    private final int textColorDisabled;
    private final TextView textView;
    private boolean toggleable;
    private final int widgetBgColor;
    private final int widgetBgColorDisabled;
    private int widgetPaddingLeft;
    private int widgetPaddingRight;

    /* JADX INFO: compiled from: OChip.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/chip/v2/OChip$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$IuiIXCwgeIVPgm2x1A0k5GxyJnU(OChip r0, View r1) {
        m422initCloseIcon$lambda5(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public OChip(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OChip(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OChip(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OChip(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13, null, 8, null);
        View r14 = FrameLayout.inflate(r11, R.layout.o_chip_v2, this);
        this.parent = r14;
        View r0 = r14.findViewById(R.id.chip_container);
        Intrinsics.checkNotNullExpressionValue(r0, "parent.findViewById(R.id.chip_container)");
        OUILinearLayout r1 = (OUILinearLayout) r0;
        this.chipContainer = r1;
        View r2 = r14.findViewById(R.id.chip_icon);
        Intrinsics.checkNotNullExpressionValue(r2, "parent.findViewById(R.id.chip_icon)");
        ImageView r3 = (ImageView) r2;
        this.chipIcon = r3;
        View r4 = r14.findViewById(R.id.chip_text);
        Intrinsics.checkNotNullExpressionValue(r4, "parent.findViewById(R.id.chip_text)");
        TextView r5 = (TextView) r4;
        this.textView = r5;
        View r6 = r14.findViewById(R.id.close_icon);
        Intrinsics.checkNotNullExpressionValue(r6, "parent.findViewById(R.id.close_icon)");
        ImageView r7 = (ImageView) r6;
        this.closeIcon = r7;
        View r15 = r14.findViewById(R.id.arrow_icon);
        Intrinsics.checkNotNullExpressionValue(r15, "parent.findViewById(R.id.arrow_icon)");
        ImageView r16 = (ImageView) r15;
        this.arrowIcon = r16;
        this.isOn = true;
        TypedArray r8 = r11.obtainStyledAttributes(r12, R.styleable.OChip);
        getChipIcon().setImageDrawable(r8.getDrawable(R.styleable.OChip_oui_chip_icon));
        r5.setText(r8.getText(R.styleable.OChip_oui_text));
        r7.setImageDrawable(r8.getDrawable(R.styleable.OChip_oui_close_icon));
        r16.setImageDrawable(r8.getDrawable(R.styleable.OChip_oui_chipArrowIcon));
        this.chipIconTintColor = r8.getColor(R.styleable.OChip_oui_chip_icon_tint_color, 0);
        this.closeIconTintColor = r8.getColor(R.styleable.OChip_oui_close_icon_tint_color, 0);
        this.arrowIconTintColor = r8.getColor(R.styleable.OChip_oui_arrow_icon_tint_color, 0);
        this.textColor = r8.getColor(R.styleable.OChip_oui_text_color, 0);
        this.textColorDisabled = r8.getColor(R.styleable.OChip_oui_text_color_disabled, 0);
        this.widgetBgColor = r8.getColor(R.styleable.OChip_oui_widgetBgColor, 0);
        this.widgetBgColorDisabled = r8.getColor(R.styleable.OChip_oui_widgetBgColorDisabled, 0);
        this.toggleable = r8.getBoolean(R.styleable.OChip_oui_chip_toggleable, false);
        this.widgetPaddingLeft = r8.getDimensionPixelSize(R.styleable.OChip_oui_widgetPaddingL, 0);
        this.widgetPaddingRight = r8.getDimensionPixelSize(R.styleable.OChip_oui_widgetPaddingR, 0);
        this.chipIconSpaceL = r8.getDimensionPixelSize(R.styleable.OChip_oui_chipIconSpaceL, 0);
        this.chipIconSpaceR = r8.getDimensionPixelSize(R.styleable.OChip_oui_chipIconSpaceR, 0);
        this.chipArrowSpaceL = r8.getDimensionPixelSize(R.styleable.OChip_oui_chipArrowSpaceL, 0);
        this.chipArrowSpaceR = r8.getDimensionPixelSize(R.styleable.OChip_oui_chipArrowSpaceR, 0);
        r1.setPadding(this.widgetPaddingLeft, r1.getPaddingTop(), this.widgetPaddingRight, r1.getPaddingBottom());
        int r9 = r8.getColor(R.styleable.OChip_oui_widgetPressColor, 0);
        this.pressColor = r9;
        if (r9 == 0) goto L5;
        r1.setOverridePressColor(r9);
        r1.refreshColors(TAG);
    L5:
        Intrinsics.checkNotNullExpressionValue(r8, "this");
        this.haveShadow = initShadows(r11, r8);
        r8.recycle();
        TypedArray r17 = r11.obtainStyledAttributes(r12, new int[]{android.R.attr.minWidth, android.R.attr.minHeight});
        int r18 = r17.getDimensionPixelSize(0, 0);
        int r10 = r17.getDimensionPixelSize(1, 0);
        if (r18 <= 0) goto L8;
        r1.setMinimumWidth(r18);
    L8:
        if (r10 <= 0) goto L10;
        r1.setMinimumHeight(r10);
    L10:
        r17.recycle();
        setChangeAlphaWhenPress(false);
        if (r3.getDrawable() == null) goto L13;
        boolean r19 = true;
    L14:
        initChipIcon(r19);
        if (r7.getDrawable() == null) goto L17;
        boolean r110 = true;
    L18:
        initCloseIcon(r110);
        if (r16.getDrawable() == null) goto L21;
        boolean r111 = true;
    L22:
        initArrowIcon(r111);
        updateColors(true);
        int r112 = OUnitExtensionKt.vdp(this, 99);
        if (this.haveShadow == false) goto L25;
        L.d(TAG, "initShadows, have shadow");
        setShadowCornerRadius(r112);
        r1.setRadius(r112);
    L26:
        setClipChildren(false);
        return;
    L25:
        setRadius(r112);
        goto L26
    L21:
        r111 = false;
        goto L22
    L17:
        r110 = false;
        goto L18
    L13:
        r19 = false;
        goto L14
    }

    public final ImageView getChipIcon() {
        return this.chipIcon;
    }

    public final boolean isOn() {
        return this.isOn;
    }

    public final void setOn(boolean r2) {
        if (this.isOn == r2) goto L9;
        this.isOn = r2;
        updateColors(r2);
        Function2<? super OChip, ? super Boolean, Unit> r3 = this.onCheckedListener;
        if (r3 == null) goto L10;
        r3.invoke(this, Boolean.valueOf(this.isOn));
        return;
    L10:
        return;
    }

    public final CharSequence getText() {
        CharSequence r1 = this.textView.getText();
        Intrinsics.checkNotNullExpressionValue(r1, "textView.text");
        return r1;
    }

    public final void setText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.textView.setText(r2);
    }

    private final boolean initShadows(Context r5, TypedArray r6) {
        int r7 = r6.getResourceId(R.styleable.OChip_oui_widgetShadowNormal, 0);
        if (r7 == 0) goto L5;
        boolean r2 = true;
    L6:
        if (r7 == 0) goto L8;
        List<Shadow> r8 = OUILayoutHelper.extractShadowInfo(r5, r7);
        List<Shadow> r9 = CollectionsKt.listOf(new Shadow[]{r8.get(0), r8.get(1)});
        this.shadowsNormal = r9;
        Intrinsics.checkNotNull(r9);
        Shadow r10 = (Shadow) CollectionsKt.getOrNull(r9, 0);
        List<Shadow> r11 = this.shadowsNormal;
        Intrinsics.checkNotNull(r11);
        setShadow(r10, (Shadow) CollectionsKt.getOrNull(r11, 1));
    L8:
        return r2;
    L5:
        r2 = false;
        goto L6
    }

    private final void updateColors(boolean r2) {
        if (r2 == false) goto L27;
        int r3 = this.widgetBgColor;
        if (r3 == 0) goto L7;
        this.chipContainer.setBackgroundColor(r3);
    L7:
        if (this.chipIconTintColor == 0) goto L13;
        Drawable r4 = this.chipIcon.getDrawable();
        if (r4 == null) goto L13;
        r4.setTint(this.chipIconTintColor);
    L13:
        if (this.closeIconTintColor == 0) goto L19;
        Drawable r5 = this.closeIcon.getDrawable();
        if (r5 == null) goto L19;
        r5.setTint(this.closeIconTintColor);
    L19:
        if (this.arrowIconTintColor == 0) goto L24;
        Drawable r6 = this.arrowIcon.getDrawable();
        if (r6 == null) goto L24;
        r6.setTint(this.arrowIconTintColor);
    L24:
        int r7 = this.textColor;
        if (r7 == 0) goto L38;
        this.textView.setTextColor(r7);
        return;
    L38:
        return;
    L27:
        int r8 = this.widgetBgColorDisabled;
        if (r8 == 0) goto L31;
        this.chipContainer.setBackgroundColor(r8);
    L31:
        if (this.textColorDisabled == 0) goto L40;
        Drawable r9 = this.chipIcon.getDrawable();
        if (r9 == null) goto L36;
        r9.setTint(this.textColorDisabled);
    L36:
        this.textView.setTextColor(this.textColorDisabled);
        return;
    }

    private final void initChipIcon(boolean r5) {
        if (r5 == false) goto L9;
        TextView r6 = this.textView;
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if (r2 == null) goto L8;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        r3.setMarginStart(this.chipIconSpaceL);
        r6.setLayoutParams(r3);
        this.chipIcon.setVisibility(0);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        TextView r7 = this.textView;
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        if (r4 == null) goto L14;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r4;
        r8.setMarginStart(0);
        r7.setLayoutParams(r8);
        this.chipIcon.setVisibility(8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void initCloseIcon(boolean r5) {
        if (r5 == false) goto L9;
        ImageView r6 = this.closeIcon;
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if (r2 == null) goto L8;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        r3.setMarginStart(this.chipIconSpaceR);
        r6.setLayoutParams(r3);
        this.closeIcon.setVisibility(0);
        this.closeIcon.setOnClickListener(new OChip$$ExternalSyntheticLambda0(this));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        ImageView r7 = this.closeIcon;
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        if (r4 == null) goto L14;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r4;
        r8.setMarginStart(0);
        r7.setLayoutParams(r8);
        this.closeIcon.setVisibility(8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* JADX INFO: renamed from: initCloseIcon$lambda-5, reason: not valid java name */
    private static final void m422initCloseIcon$lambda5(OChip r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r0.isEnabled() == false) goto L9;
        View.OnClickListener r2 = r0.onCloseListener;
        if (r2 == null) goto L10;
        r2.onClick(r0.closeIcon);
        return;
    L10:
        return;
    }

    private final void initArrowIcon(boolean r5) {
        if (r5 == false) goto L9;
        ImageView r6 = this.arrowIcon;
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if (r2 == null) goto L8;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        r3.setMarginStart(this.chipArrowSpaceL);
        r6.setLayoutParams(r3);
        this.arrowIcon.setVisibility(0);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        ImageView r7 = this.arrowIcon;
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        if (r4 == null) goto L14;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r4;
        r8.setMarginStart(0);
        r7.setLayoutParams(r8);
        this.arrowIcon.setVisibility(8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void updateCloseIcon(boolean r5) {
        if (r5 == false) goto L9;
        ImageView r6 = this.closeIcon;
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if (r2 == null) goto L8;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        r3.setMarginStart(this.chipIconSpaceR);
        r6.setLayoutParams(r3);
        this.closeIcon.setVisibility(0);
        OUILinearLayout r7 = this.chipContainer;
        r7.setPadding(this.widgetPaddingLeft, r7.getPaddingTop(), this.widgetPaddingRight, this.chipContainer.getPaddingBottom());
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        ImageView r8 = this.closeIcon;
        ViewGroup.LayoutParams r4 = r8.getLayoutParams();
        if (r4 == null) goto L18;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r4;
        r9.setMarginStart(0);
        r8.setLayoutParams(r9);
        this.closeIcon.setVisibility(8);
        if (this.widgetPaddingLeft != this.widgetPaddingRight) goto L14;
        return;
    L14:
        if (this.chipIcon.getVisibility() != 8) goto L21;
        OUILinearLayout r10 = this.chipContainer;
        r10.setPadding(this.widgetPaddingLeft, r10.getPaddingTop(), this.widgetPaddingLeft, this.chipContainer.getPaddingBottom());
        return;
    L21:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setOnCloseListener(View.OnClickListener r1) {
        this.onCloseListener = r1;
    }

    public final void setOnCheckedListener(Function2<? super OChip, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
        this.onCheckedListener = r2;
    }

    public final void setToggleable(boolean r1) {
        this.toggleable = r1;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.toggleable == false) goto L6;
        setOn(!isOn());
    L6:
        return super.performClick();
    }

    @Override // android.view.View
    public void setMinimumWidth(int r1) {
        super.setMinimumWidth(r1);
        this.chipContainer.setMinimumWidth(r1);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r1) {
        super.setMinimumHeight(r1);
        this.chipContainer.setMinimumHeight(r1);
    }
}
