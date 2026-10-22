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
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.k;
import d.x;
import java.util.Objects;

/* JADX INFO: compiled from: OChip.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OChip extends OUIFrameLayout {
    private boolean checked;
    private final ImageView chipIcon;
    private final ImageView closeIcon;
    private final boolean enableChecked;
    private m<? super OChip, ? super Boolean, x> onCheckedListener;
    private final View parent;
    private final TextView textView;

    /* JADX INFO: compiled from: OChip.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f34399a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f34400b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ a[] f34401c = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f34399a, f34400b};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f34401c.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f34399a = new a("Default", 0);
            f34400b = new a("Rect", 1);
            f34401c = a();
        }
    }

    /* JADX INFO: compiled from: OChip.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34402a = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f34399a.ordinal()] = 1;
            r0[a.f34400b.ordinal()] = 2;
            f34402a = r0;
        }
    }

    /* JADX INFO: compiled from: OChip.kt */
    static final class c extends p implements m<OChip, Boolean, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OChip f34403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f34404b;

        c(OChip r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f34403a = r3;
            this.f34404b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(OChip r3, Boolean r4) {
            a((OChip) ZeusTransformUtils.preCheckCast(r3, OChip.class, "com.obric.aiagent.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return x.f38692a;
        }

        public final void a(OChip r4, boolean r5) {
            o.e(r4, "$noName_0");
            if (OChip.access$getChecked$p(this.f34403a) == false) goto L9;
            this.f34403a.setBackgroundColor(this.f34404b.getColor(ZeusTransformUtils.mapRes(R.color.oui_b_blue_bg_light, "color", "oui_b_blue_bg_light")));
            Drawable r6 = this.f34403a.getChipIcon().getDrawable();
            if (r6 == null) goto L8;
            r6.setTint(this.f34404b.getColor(ZeusTransformUtils.mapRes(R.color.oui_b_blue_fg, "color", "oui_b_blue_fg")));
        L8:
            this.f34403a.getTextView().setTextColor(this.f34404b.getColor(ZeusTransformUtils.mapRes(R.color.oui_b_blue_fg, "color", "oui_b_blue_fg")));
            return;
        L9:
            this.f34403a.setBackgroundColor(this.f34404b.getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_element_2, "color", "oui_fill_element_2")));
            Drawable r7 = this.f34403a.getChipIcon().getDrawable();
            if (r7 == null) goto L13;
            r7.setTint(this.f34404b.getColor(ZeusTransformUtils.mapRes(R.color.oui_text_3, "color", "oui_text_3")));
        L13:
            this.f34403a.getTextView().setTextColor(this.f34404b.getColor(ZeusTransformUtils.mapRes(R.color.oui_text_3, "color", "oui_text_3")));
        }
    }

    public OChip(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OChip(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static final /* synthetic */ boolean access$getChecked$p(OChip r0) {
        return r0.checked;
    }

    public /* synthetic */ OChip(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OChip(Context r12, AttributeSet r13, int r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r16 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r15, "context");
        super(r15, r16, r14, null, 8, null);
        View r17 = FrameLayout.inflate(r15, ZeusTransformUtils.mapRes(R.layout.o_chip, "layout", "o_chip"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        this.parent = r17;
        View r0 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.chip_icon, DbHelper.COL_ID, "chip_icon"));
        o.c(r0, "parent.findViewById(R.id.chip_icon)");
        ImageView r1 = (ImageView) ZeusTransformUtils.preCheckCast(r0, ImageView.class, "com.obric.aiagent.plugin");
        this.chipIcon = r1;
        View r3 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.chip_text, DbHelper.COL_ID, "chip_text"));
        o.c(r3, "parent.findViewById(R.id.chip_text)");
        TextView r4 = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin");
        this.textView = r4;
        View r18 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.close_icon, DbHelper.COL_ID, "close_icon"));
        o.c(r18, "parent.findViewById(R.id.close_icon)");
        ImageView r19 = (ImageView) ZeusTransformUtils.preCheckCast(r18, ImageView.class, "com.obric.aiagent.plugin");
        this.closeIcon = r19;
        this.onCheckedListener = (m) ZeusTransformUtils.preCheckCast(new c(this, r15), m.class, "com.obric.aiagent.plugin");
        TypedArray r110 = r15.obtainStyledAttributes(r16, R.styleable.OChip);
        getChipIcon().setImageDrawable(r110.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chip_icon, "styleable", "OChip_oui_chip_icon")));
        getTextView().setText(r110.getText(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_text, "styleable", "OChip_oui_text")));
        getCloseIcon().setImageDrawable(r110.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_close_icon, "styleable", "OChip_oui_close_icon")));
        int r111 = r110.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chip_icon_tint_color, "styleable", "OChip_oui_chip_icon_tint_color"), -1);
        int r5 = r110.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_close_icon_tint_color, "styleable", "OChip_oui_close_icon_tint_color"), -1);
        int r6 = r110.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_text_color, "styleable", "OChip_oui_text_color"), -1);
        boolean r8 = false;
        this.enableChecked = r110.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_enable_checked, "styleable", "OChip_oui_enable_checked"), false);
        a r7 = a.values()[r110.getInt(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chip_style, "styleable", "OChip_oui_chip_style"), 0)];
        r110.recycle();
        if (r1.getDrawable() == null) goto L5;
        boolean r112 = true;
    L6:
        updateChipIcon(r112);
        if (r19.getDrawable() == null) goto L9;
        r8 = true;
    L9:
        updateCloseIcon(r8);
        if (r111 == (-1)) goto L15;
        Drawable r113 = r1.getDrawable();
        if (r113 == null) goto L15;
        r113.setTint(r111);
    L15:
        if (r5 == (-1)) goto L20;
        Drawable r114 = r19.getDrawable();
        if (r114 == null) goto L20;
        r114.setTint(r5);
    L20:
        if (r6 == (-1)) goto L22;
        r4.setTextColor(r6);
    L22:
        int r115 = b.f34402a[r7.ordinal()];
        if (r115 != 1) goto L25;
        int r116 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 99);
    L30:
        setRadius(r116);
        return;
    L25:
        if (r115 != 2) goto L28;
        r116 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        goto L30
    L28:
        throw new k();
    L5:
        r112 = false;
        goto L6
    }

    public final ImageView getChipIcon() {
        return this.chipIcon;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final ImageView getCloseIcon() {
        return this.closeIcon;
    }

    private final void updateChipIcon(boolean r5) {
        if (r5 == false) goto L5;
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.textView, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r0 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMarginStart(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4));
        r6.setLayoutParams(r0);
        this.chipIcon.setVisibility(0);
        return;
    L5:
        View r7 = (View) ZeusTransformUtils.preCheckCast(this.textView, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r3 = r7.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMarginStart(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 6));
        r7.setLayoutParams(r1);
        this.chipIcon.setVisibility(8);
    }

    private final void updateCloseIcon(boolean r6) {
        if (r6 == false) goto L5;
        View r7 = (View) ZeusTransformUtils.preCheckCast(this.textView, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r3 = r7.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMarginEnd(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 6));
        r7.setLayoutParams(r1);
        this.closeIcon.setVisibility(0);
        return;
    L5:
        View r8 = (View) ZeusTransformUtils.preCheckCast(this.textView, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r4 = r8.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMarginEnd(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 6));
        r8.setLayoutParams(r2);
        this.closeIcon.setVisibility(8);
    }

    public final void setOnCloseListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        this.closeIcon.setOnClickListener(r4);
    }

    public final void setOnCheckedListener(m<? super OChip, ? super Boolean, x> r3) {
        m<? super OChip, ? super Boolean, x> r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        o.e(r4, "l");
        this.onCheckedListener = r4;
    }

    public final CharSequence getText() {
        CharSequence r1 = this.textView.getText();
        o.c(r1, "textView.text");
        return r1;
    }

    public final void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "value");
        this.textView.setText(r4);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.enableChecked == false) goto L6;
        boolean r0 = !this.checked;
        this.checked = r0;
        this.onCheckedListener.invoke(this, Boolean.valueOf(r0));
    L6:
        return super.performClick();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
