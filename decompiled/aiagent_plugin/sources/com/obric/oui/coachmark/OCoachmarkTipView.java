package com.obric.oui.coachmark;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.s;
import java.util.Objects;

/* JADX INFO: compiled from: OCoachmarkTipView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OCoachmarkTipView extends OUILinearLayout {
    public static final b Companion = null;
    private static final int MULTI_LINE_RADIUS_DP = 20;
    private static final String TAG = "OCoachmarkTipView";
    private a actionType;
    private Integer backgroundColor;
    private boolean closable;
    private Float customCornerRadius;
    private final OTextView descText;
    private boolean hasXmlBackground;
    private final OButton inlineAction;
    private final View inlineContainer;
    private final OIconButton inlineDismiss;
    private final ImageView inlineIcon;
    private final OTextView inlineText;
    private final OButton multiAction;
    private final View multiActions;
    private final View multiContainer;
    private final OButton multiDismiss;
    private final ImageView multiIcon;
    private final LinearLayout multiLeadingRow;
    private final View multiTextGroup;
    private boolean showIcon;
    private boolean singleLine;

    /* JADX INFO: compiled from: OCoachmarkTipView.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0931a f34405a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f34406b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f34407c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f34408e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f34409d;

        /* JADX INFO: renamed from: com.obric.oui.coachmark.OCoachmarkTipView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OCoachmarkTipView.kt */
        public static final class C0931a {
            public /* synthetic */ C0931a(h r1) {
                this();
            }

            private C0931a() {
            }

            public final a a(int r6) {
                a[] r5 = a.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                a r3 = r5[r2];
                if (r3.a() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L14;
                return r3;
            L14:
                return a.f34406b;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }
        }

        private static final /* synthetic */ a[] b() {
            return new a[]{f34406b, f34407c};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f34408e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f34409d = r3;
        }

        public final int a() {
            return this.f34409d;
        }

        static {
            f34406b = new a("PRIMARY", 0, 0);
            f34407c = new a("NEUTRAL", 1, 1);
            f34408e = b();
            f34405a = new C0931a(null);
        }
    }

    /* JADX INFO: compiled from: OCoachmarkTipView.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: OCoachmarkTipView.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34410a = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f34406b.ordinal()] = 1;
            r0[a.f34407c.ordinal()] = 2;
            f34410a = r0;
        }
    }

    static {
        Companion = new b(null);
    }

    public OCoachmarkTipView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OCoachmarkTipView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public final void setDescription(CharSequence r7) {
        setDescription$default(this, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin"), null, null, 6, null);
    }

    public final void setDescription(CharSequence r7, Integer r8) {
        setDescription$default(this, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin"), r8, null, 4, null);
    }

    public /* synthetic */ OCoachmarkTipView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OCoachmarkTipView(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        super(r13, r14, r12, null, 8, null);
        this.showIcon = true;
        this.actionType = a.f34406b;
        setOrientation(1);
        ZeusTransformUtils.inflate(LayoutInflater.from(r13), ZeusTransformUtils.mapRes(R.layout.o_coachmark_tip, "layout", "o_coachmark_tip"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.inline_container, DbHelper.COL_ID, "inline_container"));
        o.c(r15, "findViewById(R.id.inline_container)");
        this.inlineContainer = r15;
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_inline_icon, DbHelper.COL_ID, "iv_inline_icon"));
        o.c(r16, "findViewById(R.id.iv_inline_icon)");
        this.inlineIcon = (ImageView) ZeusTransformUtils.preCheckCast(r16, ImageView.class, "com.obric.aiagent.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_inline_text, DbHelper.COL_ID, "tv_inline_text"));
        o.c(r17, "findViewById(R.id.tv_inline_text)");
        this.inlineText = (OTextView) ZeusTransformUtils.preCheckCast(r17, OTextView.class, "com.obric.aiagent.plugin");
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_inline_action, DbHelper.COL_ID, "btn_inline_action"));
        o.c(r18, "findViewById(R.id.btn_inline_action)");
        this.inlineAction = (OButton) ZeusTransformUtils.preCheckCast(r18, OButton.class, "com.obric.aiagent.plugin");
        View r19 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_inline_dismiss, DbHelper.COL_ID, "btn_inline_dismiss"));
        o.c(r19, "findViewById(R.id.btn_inline_dismiss)");
        this.inlineDismiss = (OIconButton) ZeusTransformUtils.preCheckCast(r19, OIconButton.class, "com.obric.aiagent.plugin");
        View r110 = findViewById(ZeusTransformUtils.mapRes(R.id.multi_container, DbHelper.COL_ID, "multi_container"));
        o.c(r110, "findViewById(R.id.multi_container)");
        this.multiContainer = r110;
        View r111 = findViewById(ZeusTransformUtils.mapRes(R.id.multi_leading_row, DbHelper.COL_ID, "multi_leading_row"));
        o.c(r111, "findViewById(R.id.multi_leading_row)");
        this.multiLeadingRow = (LinearLayout) ZeusTransformUtils.preCheckCast(r111, LinearLayout.class, "com.obric.aiagent.plugin");
        View r112 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_multi_icon, DbHelper.COL_ID, "iv_multi_icon"));
        o.c(r112, "findViewById(R.id.iv_multi_icon)");
        this.multiIcon = (ImageView) ZeusTransformUtils.preCheckCast(r112, ImageView.class, "com.obric.aiagent.plugin");
        View r113 = findViewById(ZeusTransformUtils.mapRes(R.id.multi_text_group, DbHelper.COL_ID, "multi_text_group"));
        o.c(r113, "findViewById(R.id.multi_text_group)");
        this.multiTextGroup = r113;
        View r114 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_desc, DbHelper.COL_ID, "tv_desc"));
        o.c(r114, "findViewById(R.id.tv_desc)");
        this.descText = (OTextView) ZeusTransformUtils.preCheckCast(r114, OTextView.class, "com.obric.aiagent.plugin");
        View r115 = findViewById(ZeusTransformUtils.mapRes(R.id.multi_actions, DbHelper.COL_ID, "multi_actions"));
        o.c(r115, "findViewById(R.id.multi_actions)");
        this.multiActions = r115;
        View r116 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_multi_dismiss, DbHelper.COL_ID, "btn_multi_dismiss"));
        o.c(r116, "findViewById(R.id.btn_multi_dismiss)");
        this.multiDismiss = (OButton) ZeusTransformUtils.preCheckCast(r116, OButton.class, "com.obric.aiagent.plugin");
        View r117 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_multi_action, DbHelper.COL_ID, "btn_multi_action"));
        o.c(r117, "findViewById(R.id.btn_multi_action)");
        this.multiAction = (OButton) ZeusTransformUtils.preCheckCast(r117, OButton.class, "com.obric.aiagent.plugin");
        applyAttributes(r14, r12);
    }

    public static /* synthetic */ void setDescription$default(OCoachmarkTipView r1, CharSequence r2, Integer r3, TextUtils.TruncateAt r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.setDescription(r7, r3, r4);
    }

    public final void setDescription(CharSequence r3, Integer r4, TextUtils.TruncateAt r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.inlineText.setText(r6);
        this.descText.setText(r6);
        if (r4 == null) goto L6;
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue();
        this.inlineText.setMaxLines(r7);
        this.descText.setMaxLines(r7);
    L6:
        if (r5 == null) goto L9;
        this.inlineText.setEllipsize(r5);
        this.descText.setEllipsize(r5);
    L9:
        if (r6 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == false) goto L20;
        com.obric.oui.d.a.b r9 = com.obric.oui.d.a.b.f35007a;
        if (r9.a(8) == true) goto L20;
        r9.a().a(TAG, 8, "Description is empty.", null);
    L20:
        updateLayout();
        return;
    L11:
        if (d.o.o.d(r6) == true) goto L14;
        r8 = false;
        goto L15
    }

    public final void setActionText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.inlineAction.setText(r4);
        this.multiAction.setText(r4);
        updateLayout();
    }

    public final void setDismissText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.multiDismiss.setText(r4);
        updateLayout();
    }

    public final void setIcon(Drawable r2) {
        this.inlineIcon.setImageDrawable(r2);
        this.multiIcon.setImageDrawable(r2);
        updateLayout();
    }

    public final void setOnActionClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        this.inlineAction.setOnClickListener(r4);
        this.multiAction.setOnClickListener(r4);
    }

    public final void setOnDismissClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        this.inlineDismiss.setOnClickListener(r4);
        this.multiDismiss.setOnClickListener(r4);
    }

    public final void setShowIcon(boolean r2) {
        if (this.showIcon == r2) goto L6;
        this.showIcon = r2;
        updateLayout();
        return;
    }

    public final void setClosable(boolean r2) {
        if (this.closable == r2) goto L6;
        this.closable = r2;
        updateLayout();
        return;
    }

    public final void setSingleLine(boolean r2) {
        if (this.singleLine == r2) goto L6;
        this.singleLine = r2;
        updateBackground();
        updateLayout();
        return;
    }

    public final void setActionType(a r2) {
        o.e(r2, "type");
        if (this.actionType == r2) goto L6;
        this.actionType = r2;
        updateActionButtonStyle();
        return;
    }

    public final void setPrimaryButtonText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.inlineAction.setText(r4);
        this.multiAction.setText(r4);
        updateLayout();
    }

    public final void setSecondaryButtonText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.multiDismiss.setText(r4);
        updateLayout();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        this.backgroundColor = Integer.valueOf(r1);
        updateBackground();
    }

    public final void setCornerRadius(float r1) {
        this.customCornerRadius = Float.valueOf(r1);
        updateBackground();
    }

    private final void updateBackground() {
        Integer r0 = this.backgroundColor;
        if (r0 != null) goto L5;
        int r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_element_2, "color", "oui_fill_element_2"));
    L7:
        if (this.backgroundColor == null) goto L9;
    L11:
        float r2 = effectiveCornerRadius();
        GradientDrawable r3 = new GradientDrawable();
        r3.setShape(0);
        r3.setColor(r1);
        r3.setCornerRadius(r2);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        if (this.hasXmlBackground == false) goto L11;
        return;
    L5:
        r1 = r0.intValue();
        goto L7
    }

    private final float effectiveCornerRadius() {
        Float r0 = this.customCornerRadius;
        if (r0 != null) goto L9;
        if (isMultiLine() == false) goto L11;
        return g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20);
    L11:
        return g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 28);
    L9:
        return r0.floatValue();
    }

    private final boolean isMultiLine() {
        return !this.singleLine;
    }

    private final void applyAttributes(AttributeSet r6, int r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L6;
        updateBackground();
        updateLayout();
        return;
    L6:
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r8, R.styleable.OCoachmarkTip, r7, 0);
        this.showIcon = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipShowIcon, "styleable", "OCoachmarkTip_oui_cmTipShowIcon"), true);
        this.closable = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipClosable, "styleable", "OCoachmarkTip_oui_cmTipClosable"), false);
        this.singleLine = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipSingleLine, "styleable", "OCoachmarkTip_oui_cmTipSingleLine"), false);
        this.actionType = a.f34405a.a(r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipActionType, "styleable", "OCoachmarkTip_oui_cmTipActionType"), a.f34406b.a()));
        this.hasXmlBackground = r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_android_background, "styleable", "OCoachmarkTip_android_background"));
        CharSequence r10 = r9.getText(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_android_text, "styleable", "OCoachmarkTip_android_text"));
        if (r10 == null) goto L10;
        this.inlineText.setText(r10);
        this.descText.setText(r10);
    L10:
        String r11 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipActionText, "styleable", "OCoachmarkTip_oui_cmTipActionText"));
        this.inlineAction.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"));
        this.multiAction.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"));
        String r12 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipDismissText, "styleable", "OCoachmarkTip_oui_cmTipDismissText"));
        this.multiDismiss.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"));
        Drawable r13 = r9.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_android_src, "styleable", "OCoachmarkTip_android_src"));
        if (r13 == null) goto L14;
        this.inlineIcon.setImageDrawable(r13);
        this.multiIcon.setImageDrawable(r13);
    L14:
        String r14 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipPrimaryButtonText, "styleable", "OCoachmarkTip_oui_cmTipPrimaryButtonText"));
        if (r14 == null) goto L18;
        this.inlineAction.setText((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"));
        this.multiAction.setText((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"));
    L18:
        String r15 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipSecondaryButtonText, "styleable", "OCoachmarkTip_oui_cmTipSecondaryButtonText"));
        if (r15 == null) goto L23;
        this.multiDismiss.setText((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"));
    L23:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipBackgroundColor, "styleable", "OCoachmarkTip_oui_cmTipBackgroundColor")) == false) goto L26;
        this.backgroundColor = Integer.valueOf(r9.getColor(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipBackgroundColor, "styleable", "OCoachmarkTip_oui_cmTipBackgroundColor"), 0));
    L26:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipCornerRadius, "styleable", "OCoachmarkTip_oui_cmTipCornerRadius")) == false) goto L28;
        this.customCornerRadius = Float.valueOf(r9.getDimension(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipCornerRadius, "styleable", "OCoachmarkTip_oui_cmTipCornerRadius"), 0.0f));
    L28:
        r9.recycle();
        updateBackground();
        updateLayout();
    }

    private final void updateLayout() {
        boolean r0 = isMultiLine();
        k.a(this.inlineContainer, !r0);
        k.a(this.multiContainer, r0);
        applyPadding(r0);
        if (r0 == false) goto L5;
        int r1 = 48;
    L6:
        setGravity(r1);
        updateIconVisibility();
        updateInlineActions();
        updateMultiActions();
        updateLeadingVisibility();
        updateActionButtonStyle();
        return;
    L5:
        r1 = 16;
        goto L6
    }

    private final void applyPadding(boolean r7) {
        m r0 = s.a(Boolean.valueOf(this.showIcon), Boolean.valueOf(r7));
        if (o.a(r0, s.a(true, true)) == false) goto L6;
        int r1 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16);
    L9:
        if (r7 == false) goto L11;
        setPaddingRelative(r1, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16));
        setMinimumHeight(0);
        return;
    L11:
        setPaddingRelative(r1, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8));
        setMinimumHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 48));
        return;
    L6:
        if (o.a(r0, s.a(true, false)) == false) goto L8;
        r1 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        goto L9
    L8:
        r1 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20);
        goto L9
    }

    private final void updateInlineActions() {
        if (isMultiLine() == false) goto L5;
        return;
    L5:
        CharSequence r0 = this.inlineAction.getText();
        boolean r1 = false;
        if (r0 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        boolean r3 = !r2;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.inlineAction, View.class, "com.obric.aiagent.plugin");
        if (r3 == true) goto L15;
    L17:
        k.a(r4, r1);
        k.a((View) ZeusTransformUtils.preCheckCast(this.inlineDismiss, View.class, "com.obric.aiagent.plugin"), this.closable);
        return;
    L15:
        if (this.closable == true) goto L17;
        r1 = true;
        goto L17
    L8:
        if (d.o.o.d(r0) == true) goto L11;
        r2 = false;
        goto L12
    }

    private final void updateMultiActions() {
        if (isMultiLine() == true) goto L5;
        return;
    L5:
        CharSequence r0 = this.multiDismiss.getText();
        int r1 = 0;
        boolean r2 = true;
        if (r0 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        boolean r4 = !r3;
        CharSequence r5 = this.multiAction.getText();
        if (r5 != null) goto L15;
    L18:
        boolean r6 = true;
    L19:
        boolean r7 = !r6;
        if (r4 == true) goto L24;
        if (r7 == true) goto L24;
        r2 = false;
    L24:
        k.a(this.multiActions, r2);
        View r8 = this.multiActions;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r10 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r2 == false) goto L27;
        int r12 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
    L28:
        r11.topMargin = r12;
        r8.setLayoutParams(r10);
        updateMultiLeadingAlignment(r2);
        k.a((View) ZeusTransformUtils.preCheckCast(this.multiDismiss, View.class, "com.obric.aiagent.plugin"), r4);
        k.a((View) ZeusTransformUtils.preCheckCast(this.multiAction, View.class, "com.obric.aiagent.plugin"), r7);
        View r13 = (View) ZeusTransformUtils.preCheckCast(this.multiAction, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r15 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r14, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (this.multiDismiss.getVisibility() != 0) goto L31;
        r1 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
    L31:
        r16.setMarginStart(r1);
        r13.setLayoutParams(r15);
        return;
    L27:
        r12 = 0;
        goto L28
    L15:
        if (d.o.o.d(r5) == true) goto L18;
        r6 = false;
        goto L19
    L8:
        if (d.o.o.d(r0) == true) goto L11;
        r3 = false;
        goto L12
    }

    private final void updateMultiLeadingAlignment(boolean r2) {
        if (r2 == false) goto L4;
        int r3 = 48;
    L6:
        if (this.multiLeadingRow.getGravity() == r3) goto L9;
        this.multiLeadingRow.setGravity(r3);
        return;
    L9:
        return;
    L4:
        r3 = 16;
        goto L6
    }

    private final void updateLeadingVisibility() {
        if (isMultiLine() == true) goto L5;
        return;
    L5:
        k.a((View) ZeusTransformUtils.preCheckCast(this.multiIcon, View.class, "com.obric.aiagent.plugin"), this.showIcon);
        View r0 = this.multiTextGroup;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (this.showIcon == false) goto L8;
        int r5 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
    L9:
        r3.setMarginStart(r5);
        r0.setLayoutParams(r2);
        return;
    L8:
        r5 = 0;
        goto L9
    }

    private final void updateIconVisibility() {
        boolean r0 = isMultiLine();
        View r1 = (View) ZeusTransformUtils.preCheckCast(this.inlineIcon, View.class, "com.obric.aiagent.plugin");
        int r4 = 0;
        if (this.showIcon == false) goto L6;
        if (r0 == true) goto L6;
        boolean r2 = true;
    L7:
        k.a(r1, r2);
        View r3 = (View) ZeusTransformUtils.preCheckCast(this.inlineText, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r6 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (this.showIcon == false) goto L11;
        if (r0 == true) goto L11;
        r4 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
    L11:
        r7.setMarginStart(r4);
        r3.setLayoutParams(r6);
        return;
    L6:
        r2 = false;
        goto L7
    }

    private final void updateActionButtonStyle() {
        a r0 = this.actionType;
        int r1 = c.f34410a[r0.ordinal()];
        if (r1 != 1) goto L5;
        int r2 = ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, "color", "oui_accent_6_bg");
    L10:
        int r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(r2);
        this.inlineAction.setTextColor(r3);
        this.multiAction.setTextColor(r3);
        return;
    L5:
        if (r1 != 2) goto L8;
        r2 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1");
        goto L10
    L8:
        throw new d.k();
    }
}
