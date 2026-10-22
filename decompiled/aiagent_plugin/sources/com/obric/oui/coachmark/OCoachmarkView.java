package com.obric.oui.coachmark;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.common.style.i;
import com.obric.oui.common.util.g;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OCoachmarkView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OCoachmarkView extends OUIFrameLayout {
    public static final int CARD_CONTENT_PADDING_DP = 16;
    public static final int CARD_HORIZONTAL_PADDING_DP = 20;
    public static final int CARD_RADIUS_DP = 20;
    public static final int CARD_WIDTH_DP = 320;
    public static final c Companion = null;
    public static final int DEFAULT_HEIGHT_DP = 48;
    public static final int DEFAULT_ICON_GAP_DP = 12;
    public static final int DEFAULT_MAX_WIDTH_DP = 320;
    public static final int PILL_CONTENT_PADDING_DP = 8;
    public static final int PILL_HORIZONTAL_PADDING_DP = 20;
    public static final int PILL_RADIUS_DP = 28;
    public static final int SIDE_ARROW_HEIGHT_DP = 20;
    public static final int SIDE_ARROW_INTRUSION_DP = 2;
    public static final int SIDE_ARROW_WIDTH_DP = 10;
    private static final String TAG = "OCoachmarkView";
    public static final int TEXT_ACTION_TOP_MARGIN_TEXT_ONLY_DP = 12;
    public static final int TEXT_ACTION_TOP_MARGIN_WITH_ICON_DP = 8;
    public static final int TITLE_DESC_GAP_DP = 4;
    public static final int TOP_BOTTOM_ARROW_HEIGHT_DP = 9;
    public static final int TOP_BOTTOM_ARROW_INTRUSION_DP = 1;
    public static final int TOP_BOTTOM_ARROW_WIDTH_DP = 20;
    private final OButton actionFilledButton;
    private Integer actionNeutralTextColor;
    private Integer actionPrimaryTextColor;
    private a actionStyle;
    private final OButton actionTextButton;
    private final View actionTextContainer;
    private final OButton actionTextPrimaryButton;
    private ColorStateList arrowColor;
    private int arrowOffsetPx;
    private b arrowPosition;
    private final OCoachmarkView$arrowTriangleOutlineProvider$1 arrowTriangleOutlineProvider;
    private final ImageView arrowView;
    private int bgColor;
    private final OIconButton closeButton;
    private ColorStateList closeIconTint;
    private final OUIFrameLayout containerView;
    private final ViewGroup contentContainer;
    private int contentPaddingBottomPx;
    private int contentPaddingEndPx;
    private int contentPaddingStartPx;
    private int contentPaddingTopPx;
    private d contentStyle;
    private View customContentView;
    private int descTextAppearance;
    private ColorStateList descTextColor;
    private CharSequence descriptionText;
    private final OTextView descriptionView;
    private boolean enableMaterial;
    private Integer filledActionBackgroundColor;
    private Integer filledActionTextColor;
    private final View heroContainer;
    private Drawable heroDrawable;
    private final ImageView heroImage;
    private final OUIFrameLayout iconContainer;
    private Drawable iconDrawable;
    private ColorStateList iconTint;
    private final ImageView iconView;
    private boolean isContentPaddingCustomized;
    private boolean isPopWindowMode;
    private com.obric.oui.material.c[] materials;
    private int maxWidthPx;
    private View.OnClickListener primaryActionClickListener;
    private CharSequence primaryActionText;
    private View.OnClickListener secondaryActionClickListener;
    private CharSequence secondaryActionText;
    private boolean showArrow;
    private boolean showCloseIcon;
    private final View textGroup;
    private CharSequence titleText;
    private int titleTextAppearance;
    private ColorStateList titleTextColor;
    private final OTextView titleView;

    /* JADX INFO: compiled from: OCoachmarkView.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0932a f34411a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f34412b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f34413c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f34414d = null;
        private static final /* synthetic */ a[] f = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f34415e;

        /* JADX INFO: renamed from: com.obric.oui.coachmark.OCoachmarkView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OCoachmarkView.kt */
        public static final class C0932a {
            public /* synthetic */ C0932a(h r1) {
                this();
            }

            private C0932a() {
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
                return a.f34412b;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }
        }

        private static final /* synthetic */ a[] b() {
            return new a[]{f34412b, f34413c, f34414d};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f34415e = r3;
        }

        public final int a() {
            return this.f34415e;
        }

        static {
            f34412b = new a("NONE", 0, 0);
            f34413c = new a("TEXT_ONLY", 1, 1);
            f34414d = new a("FILLED_BUTTON", 2, 2);
            f = b();
            f34411a = new C0932a(null);
        }
    }

    /* JADX INFO: compiled from: OCoachmarkView.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f34416a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f34417b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f34418c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f34419d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f34420e = null;
        private static final /* synthetic */ b[] g = null;
        private final int f;

        /* JADX INFO: compiled from: OCoachmarkView.kt */
        public static final class a {
            public /* synthetic */ a(h r1) {
                this();
            }

            private a() {
            }

            public final b a(int r6) {
                b[] r5 = b.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                b r3 = r5[r2];
                if (r3.a() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L14;
                return r3;
            L14:
                return b.f34417b;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }
        }

        private static final /* synthetic */ b[] b() {
            return new b[]{f34417b, f34418c, f34419d, f34420e};
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(g.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f = r3;
        }

        public final int a() {
            return this.f;
        }

        static {
            f34417b = new b("TOP", 0, 0);
            f34418c = new b("BOTTOM", 1, 1);
            f34419d = new b("LEFT", 2, 2);
            f34420e = new b("RIGHT", 3, 3);
            g = b();
            f34416a = new a(null);
        }
    }

    /* JADX INFO: compiled from: OCoachmarkView.kt */
    public static final class c {
        public /* synthetic */ c(h r1) {
            this();
        }

        private c() {
        }
    }

    /* JADX INFO: compiled from: OCoachmarkView.kt */
    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f34421a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f34422b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f34423c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d[] f34424e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f34425d;

        /* JADX INFO: compiled from: OCoachmarkView.kt */
        public static final class a {
            public /* synthetic */ a(h r1) {
                this();
            }

            private a() {
            }

            public final d a(int r6) {
                d[] r5 = d.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                d r3 = r5[r2];
                if (r3.a() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L14;
                return r3;
            L14:
                return d.f34422b;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }
        }

        private static final /* synthetic */ d[] b() {
            return new d[]{f34422b, f34423c};
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f34424e.clone(), d[].class, "com.obric.aiagent.plugin");
        }

        private d(String r1, int r2, int r3) {
            super(r1, r2);
            this.f34425d = r3;
        }

        public final int a() {
            return this.f34425d;
        }

        static {
            f34422b = new d("PILL", 0, 0);
            f34423c = new d("CARD", 1, 1);
            f34424e = b();
            f34421a = new a(null);
        }
    }

    /* JADX INFO: compiled from: OCoachmarkView.kt */
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34426a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f34427b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f34428c = null;

        static {
            int[] r0 = new int[d.values().length];
            r0[d.f34422b.ordinal()] = 1;
            r0[d.f34423c.ordinal()] = 2;
            f34426a = r0;
            int[] r1 = new int[a.values().length];
            r1[a.f34413c.ordinal()] = 1;
            r1[a.f34414d.ordinal()] = 2;
            r1[a.f34412b.ordinal()] = 3;
            f34427b = r1;
            int[] r2 = new int[b.values().length];
            r2[b.f34417b.ordinal()] = 1;
            r2[b.f34418c.ordinal()] = 2;
            r2[b.f34419d.ordinal()] = 3;
            r2[b.f34420e.ordinal()] = 4;
            f34428c = r2;
        }
    }

    static {
        Companion = new c(null);
    }

    public OCoachmarkView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OCoachmarkView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OCoachmarkView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public final void setDescription(CharSequence r7) {
        setDescription$default(this, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin"), null, null, 6, null);
    }

    public final void setDescription(CharSequence r7, Integer r8) {
        setDescription$default(this, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin"), r8, null, 4, null);
    }

    public static final /* synthetic */ a access$getActionStyle$p(OCoachmarkView r0) {
        return r0.actionStyle;
    }

    public static final /* synthetic */ b access$getArrowPosition$p(OCoachmarkView r0) {
        return r0.arrowPosition;
    }

    public /* synthetic */ OCoachmarkView(Context r2, AttributeSet r3, int r4, int r5, int r6, h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = ZeusTransformUtils.mapRes(R.attr.ocoachmarkViewStyle, "attr", "ocoachmarkViewStyle");
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = ZeusTransformUtils.mapRes(R.style.OStyleV2_OCoachmarkView_DayNight, "style", "OStyleV2_OCoachmarkView_DayNight");
    L11:
        this(r8, r9, r4, r5);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.oui.coachmark.OCoachmarkView$arrowTriangleOutlineProvider$1, java.lang.Object] */
    public OCoachmarkView(Context r8, AttributeSet r9, int r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        super(r12, r13, r10, new i(r12, r13, r10, r11));
        ?? r0 = new OCoachmarkView$arrowTriangleOutlineProvider$1(this);
        this.arrowTriangleOutlineProvider = r0;
        this.actionStyle = a.f34412b;
        this.arrowPosition = b.f34417b;
        this.contentStyle = d.f34422b;
        this.showArrow = true;
        this.maxWidthPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 320);
        this.contentPaddingStartPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20);
        this.contentPaddingTopPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        this.contentPaddingEndPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20);
        this.contentPaddingBottomPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        if (k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.enableMaterial = r3;
        ZeusTransformUtils.inflate(LayoutInflater.from(r12), ZeusTransformUtils.mapRes(R.layout.o_coachmark, "layout", "o_coachmark"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        setClipChildren(false);
        setClipToPadding(false);
        setChangeAlphaWhenPress(false);
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_container, DbHelper.COL_ID, "coachmark_container"));
        o.c(r14, "findViewById(R.id.coachmark_container)");
        OUIFrameLayout r15 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r14, OUIFrameLayout.class, "com.obric.aiagent.plugin");
        this.containerView = r15;
        r15.setChangeAlphaWhenPress(false);
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_coachmark_arrow, DbHelper.COL_ID, "iv_coachmark_arrow"));
        o.c(r16, "findViewById(R.id.iv_coachmark_arrow)");
        ImageView r17 = (ImageView) ZeusTransformUtils.preCheckCast(r16, ImageView.class, "com.obric.aiagent.plugin");
        this.arrowView = r17;
        r17.setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(r0, ViewOutlineProvider.class, "com.obric.aiagent.plugin"));
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_hero_container, DbHelper.COL_ID, "coachmark_hero_container"));
        o.c(r18, "findViewById(R.id.coachmark_hero_container)");
        this.heroContainer = r18;
        View r19 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_hero_image, DbHelper.COL_ID, "coachmark_hero_image"));
        o.c(r19, "findViewById(R.id.coachmark_hero_image)");
        this.heroImage = (ImageView) ZeusTransformUtils.preCheckCast(r19, ImageView.class, "com.obric.aiagent.plugin");
        View r20 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_content_container, DbHelper.COL_ID, "coachmark_content_container"));
        o.c(r20, "findViewById(R.id.coachmark_content_container)");
        this.contentContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r20, ViewGroup.class, "com.obric.aiagent.plugin");
        View r21 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_icon_container, DbHelper.COL_ID, "coachmark_icon_container"));
        o.c(r21, "findViewById(R.id.coachmark_icon_container)");
        this.iconContainer = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r21, OUIFrameLayout.class, "com.obric.aiagent.plugin");
        View r22 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_icon, DbHelper.COL_ID, "coachmark_icon"));
        o.c(r22, "findViewById(R.id.coachmark_icon)");
        this.iconView = (ImageView) ZeusTransformUtils.preCheckCast(r22, ImageView.class, "com.obric.aiagent.plugin");
        View r23 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_coachmark_title, DbHelper.COL_ID, "tv_coachmark_title"));
        o.c(r23, "findViewById(R.id.tv_coachmark_title)");
        OTextView r24 = (OTextView) ZeusTransformUtils.preCheckCast(r23, OTextView.class, "com.obric.aiagent.plugin");
        this.titleView = r24;
        r24.getPaint().setSubpixelText(true);
        r24.setIncludeFontPadding(true);
        View r25 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_coachmark_description, DbHelper.COL_ID, "tv_coachmark_description"));
        o.c(r25, "findViewById(R.id.tv_coachmark_description)");
        OTextView r26 = (OTextView) ZeusTransformUtils.preCheckCast(r25, OTextView.class, "com.obric.aiagent.plugin");
        this.descriptionView = r26;
        r26.getPaint().setSubpixelText(true);
        r26.setIncludeFontPadding(true);
        View r27 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_text_group, DbHelper.COL_ID, "coachmark_text_group"));
        o.c(r27, "findViewById(R.id.coachmark_text_group)");
        this.textGroup = r27;
        View r28 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_action_text_container, DbHelper.COL_ID, "coachmark_action_text_container"));
        o.c(r28, "findViewById(R.id.coachmark_action_text_container)");
        this.actionTextContainer = r28;
        View r29 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_coachmark_action_text, DbHelper.COL_ID, "btn_coachmark_action_text"));
        o.c(r29, "findViewById(R.id.btn_coachmark_action_text)");
        this.actionTextButton = (OButton) ZeusTransformUtils.preCheckCast(r29, OButton.class, "com.obric.aiagent.plugin");
        View r30 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_coachmark_action_text_primary, DbHelper.COL_ID, "btn_coachmark_action_text_primary"));
        o.c(r30, "findViewById(R.id.btn_co…mark_action_text_primary)");
        this.actionTextPrimaryButton = (OButton) ZeusTransformUtils.preCheckCast(r30, OButton.class, "com.obric.aiagent.plugin");
        View r31 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_coachmark_action_filled, DbHelper.COL_ID, "btn_coachmark_action_filled"));
        o.c(r31, "findViewById(R.id.btn_coachmark_action_filled)");
        this.actionFilledButton = (OButton) ZeusTransformUtils.preCheckCast(r31, OButton.class, "com.obric.aiagent.plugin");
        View r32 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_coachmark_close, DbHelper.COL_ID, "btn_coachmark_close"));
        o.c(r32, "findViewById(R.id.btn_coachmark_close)");
        this.closeButton = (OIconButton) ZeusTransformUtils.preCheckCast(r32, OIconButton.class, "com.obric.aiagent.plugin");
        applyDefaults();
        applyAttributes(r13, r10, r11);
        updateLayout();
        return;
    L5:
        if (l.d() == false) goto L7;
        r3 = true;
        goto L8
    }

    public final boolean isPopWindowMode() {
        return this.isPopWindowMode;
    }

    public final void setPopWindowMode(boolean r2) {
        if (this.isPopWindowMode == r2) goto L12;
        this.isPopWindowMode = r2;
        if (this.enableMaterial == true) goto L7;
        return;
    L7:
        if (this.materials == null) goto L14;
        if (r2 == false) goto L10;
        l.b(this.containerView, 3);
        l.b(this.arrowView, 3);
        return;
    L10:
        l.b(this.containerView, 2);
        l.b(this.arrowView, 2);
        return;
    L14:
        return;
    }

    public final void setText(CharSequence r7) {
        setDescription$default(this, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin"), null, null, 6, null);
    }

    public final CharSequence getText() {
        CharSequence r0 = this.descriptionText;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.descriptionView.getText();
    }

    public final void setTitle(CharSequence r3) {
        this.titleText = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        updateLayout();
    }

    public static /* synthetic */ void setDescription$default(OCoachmarkView r1, CharSequence r2, Integer r3, TextUtils.TruncateAt r4, int r5, Object r6) {
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
        this.descriptionText = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue();
        this.descriptionView.setMaxLines(r6);
    L6:
        if (r5 == null) goto L9;
        this.descriptionView.setEllipsize(r5);
    L9:
        updateLayout();
    }

    public final void setContentStyle(d r2) {
        o.e(r2, "style");
        if (this.contentStyle == r2) goto L6;
        this.contentStyle = r2;
        applyStylePadding();
        updateLayout();
        return;
    }

    public final void setIcon(Drawable r1) {
        this.iconDrawable = r1;
        updateLayout();
    }

    public final void setHeroImage(Drawable r1) {
        this.heroDrawable = r1;
        updateLayout();
    }

    public final void setCustomContentView$OUI_standardRelease(View r4) {
        o.e(r4, "view");
        if (this.customContentView != r4) goto L7;
        updateLayout();
        return;
    L7:
        if (detachFromParent(r4) == true) goto L13;
        com.obric.oui.d.a.b r3 = com.obric.oui.d.a.b.f35007a;
        if (r3.a(8) == true) goto L15;
        r3.a().a(TAG, 8, "custom content view ignored because it cannot be moved into coachmark content container.", null);
        return;
    L15:
        return;
    L13:
        this.contentContainer.removeAllViews();
        this.customContentView = r4;
        this.contentContainer.addView(r4);
        updateLayout();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        releaseCustomContentView();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        if (this.bgColor == r2) goto L6;
        this.bgColor = r2;
        applyAppearance();
        return;
    }

    public final void setTitleTextAppearance(int r2) {
        if (this.titleTextAppearance == r2) goto L6;
        this.titleTextAppearance = r2;
        applyAppearance();
        return;
    }

    public final void setDescTextAppearance(int r2) {
        if (this.descTextAppearance == r2) goto L6;
        this.descTextAppearance = r2;
        applyAppearance();
        return;
    }

    public final void setMaxWidth(int r2) {
        if (r2 > 0) goto L4;
        return;
    L4:
        if (this.maxWidthPx == r2) goto L8;
        this.maxWidthPx = r2;
        updateLayout();
        return;
    }

    public final void setContentPadding(int r2) {
        this.isContentPaddingCustomized = true;
        this.contentPaddingStartPx = r2;
        this.contentPaddingTopPx = r2;
        this.contentPaddingEndPx = r2;
        this.contentPaddingBottomPx = r2;
        updateLayout();
    }

    public final void setContentPadding(int r2, int r3, int r4, int r5) {
        this.isContentPaddingCustomized = true;
        this.contentPaddingStartPx = r2;
        this.contentPaddingTopPx = r3;
        this.contentPaddingEndPx = r4;
        this.contentPaddingBottomPx = r5;
        updateLayout();
    }

    public final void setActionText(CharSequence r3) {
        setPrimaryButtonText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final void setPrimaryButtonText(CharSequence r3) {
        this.primaryActionText = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        updateLayout();
    }

    public final void setSecondaryButtonText(CharSequence r3) {
        this.secondaryActionText = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        updateLayout();
    }

    public final void setActionStyle(a r2) {
        o.e(r2, "style");
        if (this.actionStyle == r2) goto L6;
        this.actionStyle = r2;
        updateLayout();
        return;
    }

    public final void setOnActionClickListener(View.OnClickListener r3) {
        setOnPrimaryActionClickListener((View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin"));
    }

    public final void setOnPrimaryActionClickListener(View.OnClickListener r3) {
        this.primaryActionClickListener = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        updateDisplayedActionClickListener();
    }

    public final void setOnSecondaryActionClickListener(View.OnClickListener r3) {
        this.secondaryActionClickListener = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        updateDisplayedActionClickListener();
    }

    public final void setArrowVisible(boolean r3) {
        if (this.showArrow != r3) goto L5;
        return;
    L5:
        this.showArrow = r3;
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.arrowView, View.class, "com.obric.aiagent.plugin"), this.showArrow);
        updateArrowPosition();
    }

    public final void setArrowPosition(b r2) {
        o.e(r2, "position");
        if (this.arrowPosition != r2) goto L5;
        return;
    L5:
        this.arrowPosition = r2;
        updateArrowPosition();
    }

    public final void setArrowOffset(int r2) {
        if (this.arrowOffsetPx != r2) goto L5;
        return;
    L5:
        this.arrowOffsetPx = r2;
        updateArrowPosition();
    }

    public final void setOnCloseClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        this.closeButton.setOnClickListener(r4);
    }

    public final void setShowCloseIcon(boolean r2) {
        if (this.showCloseIcon == r2) goto L6;
        this.showCloseIcon = r2;
        applyStylePadding();
        updateLayout();
        return;
    }

    public final void setCloseVisible(boolean r1) {
        setShowCloseIcon(r1);
    }

    private final void applyDefaults() {
        this.bgColor = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_bg_base_3_high_elevation, "color", "oui_bg_base_3_high_elevation"));
        this.containerView.setMinimumHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 48));
        this.containerView.setBackgroundColor(this.bgColor);
        this.containerView.setOuterNormalColor(this.bgColor);
        updateArrowPosition();
    }

    private final void applyAttributes(AttributeSet r25, int r26, int r27) {
        TypedArray r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r25, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.OCoachmarkView, r26, r27);
        CharSequence r4 = r3.getText(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_android_text, "styleable", "OCoachmarkView_android_text"));     // Catch: Throwable -> L71
        if (r4 == null) goto L8;
        this.descriptionText = r4;     // Catch: Throwable -> L71
    L8:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmTitle, "styleable", "OCoachmarkView_cmTitle")) == false) goto L11;
        this.titleText = r3.getText(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmTitle, "styleable", "OCoachmarkView_cmTitle"));     // Catch: Throwable -> L71
    L11:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmIcon, "styleable", "OCoachmarkView_cmIcon")) == false) goto L14;
        this.iconDrawable = r3.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmIcon, "styleable", "OCoachmarkView_cmIcon"));     // Catch: Throwable -> L71
    L14:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmHeroImage, "styleable", "OCoachmarkView_cmHeroImage")) == false) goto L16;
        Drawable r1 = r3.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmHeroImage, "styleable", "OCoachmarkView_cmHeroImage"));     // Catch: Throwable -> L71
    L17:
        if (r1 == null) goto L20;
        this.heroDrawable = r1;     // Catch: Throwable -> L71
    L20:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentStyle, "styleable", "OCoachmarkView_cmContentStyle")) == false) goto L23;
        this.contentStyle = d.f34421a.a(r3.getInt(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentStyle, "styleable", "OCoachmarkView_cmContentStyle"), d.f34422b.a()));     // Catch: Throwable -> L71
    L23:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmShowCloseIcon, "styleable", "OCoachmarkView_cmShowCloseIcon")) == false) goto L25;
        this.showCloseIcon = r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmShowCloseIcon, "styleable", "OCoachmarkView_cmShowCloseIcon"), false);     // Catch: Throwable -> L71
    L25:
        applyStylePadding();     // Catch: Throwable -> L71
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionText, "styleable", "OCoachmarkView_cmActionText")) == false) goto L28;
        this.primaryActionText = r3.getText(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionText, "styleable", "OCoachmarkView_cmActionText"));     // Catch: Throwable -> L71
        boolean r2 = true;
    L30:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmPrimaryButtonText, "styleable", "OCoachmarkView_cmPrimaryButtonText")) == false) goto L33;
        this.primaryActionText = r3.getText(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmPrimaryButtonText, "styleable", "OCoachmarkView_cmPrimaryButtonText"));     // Catch: Throwable -> L71
        r2 = true;
    L33:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmSecondaryButtonText, "styleable", "OCoachmarkView_cmSecondaryButtonText")) == false) goto L36;
        this.secondaryActionText = r3.getText(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmSecondaryButtonText, "styleable", "OCoachmarkView_cmSecondaryButtonText"));     // Catch: Throwable -> L71
        r2 = true;
    L36:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionStyle, "styleable", "OCoachmarkView_cmActionStyle")) == false) goto L38;
        this.actionStyle = a.f34411a.a(r3.getInt(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionStyle, "styleable", "OCoachmarkView_cmActionStyle"), a.f34412b.a()));     // Catch: Throwable -> L71
        boolean r6 = true;
    L39:
        o.c(r3, "this");     // Catch: Throwable -> L71
        applyAppearanceAttributes(r3);     // Catch: Throwable -> L71
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmMaxWidth, "styleable", "OCoachmarkView_cmMaxWidth")) == false) goto L43;
        this.maxWidthPx = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmMaxWidth, "styleable", "OCoachmarkView_cmMaxWidth"), this.maxWidthPx);     // Catch: Throwable -> L71
    L43:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPadding, "styleable", "OCoachmarkView_cmContentPadding")) == false) goto L45;
        int r7 = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPadding, "styleable", "OCoachmarkView_cmContentPadding"), this.contentPaddingStartPx);     // Catch: Throwable -> L71
        this.contentPaddingStartPx = r7;     // Catch: Throwable -> L71
        this.contentPaddingTopPx = r7;     // Catch: Throwable -> L71
        this.contentPaddingEndPx = r7;     // Catch: Throwable -> L71
        this.contentPaddingBottomPx = r7;     // Catch: Throwable -> L71
        boolean r8 = true;
    L47:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingStart, "styleable", "OCoachmarkView_cmContentPaddingStart")) == false) goto L50;
        this.contentPaddingStartPx = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingStart, "styleable", "OCoachmarkView_cmContentPaddingStart"), this.contentPaddingStartPx);     // Catch: Throwable -> L71
        r8 = true;
    L50:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingTop, "styleable", "OCoachmarkView_cmContentPaddingTop")) == false) goto L53;
        this.contentPaddingTopPx = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingTop, "styleable", "OCoachmarkView_cmContentPaddingTop"), this.contentPaddingTopPx);     // Catch: Throwable -> L71
        r8 = true;
    L53:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingEnd, "styleable", "OCoachmarkView_cmContentPaddingEnd")) == false) goto L56;
        this.contentPaddingEndPx = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingEnd, "styleable", "OCoachmarkView_cmContentPaddingEnd"), this.contentPaddingEndPx);     // Catch: Throwable -> L71
        r8 = true;
    L56:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingBottom, "styleable", "OCoachmarkView_cmContentPaddingBottom")) == false) goto L58;
        this.contentPaddingBottomPx = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingBottom, "styleable", "OCoachmarkView_cmContentPaddingBottom"), this.contentPaddingBottomPx);     // Catch: Throwable -> L71
        r8 = true;
    L58:
        if (r8 == false) goto L60;
        this.isContentPaddingCustomized = true;     // Catch: Throwable -> L71
    L60:
        this.showArrow = r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmShowArrow, "styleable", "OCoachmarkView_cmShowArrow"), true);     // Catch: Throwable -> L71
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.arrowView, View.class, "com.obric.aiagent.plugin"), this.showArrow);     // Catch: Throwable -> L71
        this.arrowPosition = b.f34416a.a(r3.getInt(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmArrowPosition, "styleable", "OCoachmarkView_cmArrowPosition"), b.f34417b.a()));     // Catch: Throwable -> L71
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmArrowOffset, "styleable", "OCoachmarkView_cmArrowOffset")) == false) goto L63;
        this.arrowOffsetPx = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmArrowOffset, "styleable", "OCoachmarkView_cmArrowOffset"), 0);     // Catch: Throwable -> L71
    L63:
        r3.recycle();
        if (r6 == true) goto L76;
        if (r2 == false) goto L77;
        com.obric.oui.d.a.b r0 = com.obric.oui.d.a.b.f35007a;
        if (r0.a(8) == true) goto L78;
        r0.a().a(TAG, 8, "Action text is set without cmActionStyle; action will stay hidden.", null);
        return;
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L45:
        r8 = false;
        goto L47
    L38:
        r6 = false;
        goto L39
    L28:
        r2 = false;
        goto L30
    L16:
        r1 = r3.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_android_src, "styleable", "OCoachmarkView_android_src"));     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        r3.recycle();
        throw th;
    }

    private final void applyAppearanceAttributes(TypedArray r8) {
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmBackgroundColor, "styleable", "OCoachmarkView_cmBackgroundColor")) == false) goto L6;
        this.bgColor = r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmBackgroundColor, "styleable", "OCoachmarkView_cmBackgroundColor"), this.bgColor);
    L21:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmTitleTextColor, "styleable", "OCoachmarkView_cmTitleTextColor")) == false) goto L24;
        this.titleTextColor = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmTitleTextColor, "styleable", "OCoachmarkView_cmTitleTextColor"));
    L24:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmDescTextColor, "styleable", "OCoachmarkView_cmDescTextColor")) == false) goto L27;
        this.descTextColor = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmDescTextColor, "styleable", "OCoachmarkView_cmDescTextColor"));
    L27:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmIconTint, "styleable", "OCoachmarkView_cmIconTint")) == false) goto L30;
        this.iconTint = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmIconTint, "styleable", "OCoachmarkView_cmIconTint"));
    L30:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmCloseIconTint, "styleable", "OCoachmarkView_cmCloseIconTint")) == false) goto L33;
        this.closeIconTint = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmCloseIconTint, "styleable", "OCoachmarkView_cmCloseIconTint"));
    L33:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmArrowColor, "styleable", "OCoachmarkView_cmArrowColor")) == false) goto L36;
        this.arrowColor = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmArrowColor, "styleable", "OCoachmarkView_cmArrowColor"));
    L36:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionNeutralTextColor, "styleable", "OCoachmarkView_cmActionNeutralTextColor")) == false) goto L39;
        this.actionNeutralTextColor = Integer.valueOf(r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionNeutralTextColor, "styleable", "OCoachmarkView_cmActionNeutralTextColor"), 0));
    L39:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionPrimaryTextColor, "styleable", "OCoachmarkView_cmActionPrimaryTextColor")) == false) goto L42;
        this.actionPrimaryTextColor = Integer.valueOf(r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionPrimaryTextColor, "styleable", "OCoachmarkView_cmActionPrimaryTextColor"), 0));
    L42:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmFilledActionTextColor, "styleable", "OCoachmarkView_cmFilledActionTextColor")) == false) goto L45;
        this.filledActionTextColor = Integer.valueOf(r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmFilledActionTextColor, "styleable", "OCoachmarkView_cmFilledActionTextColor"), 0));
    L45:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmFilledActionBackgroundColor, "styleable", "OCoachmarkView_cmFilledActionBackgroundColor")) == false) goto L48;
        this.filledActionBackgroundColor = Integer.valueOf(r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmFilledActionBackgroundColor, "styleable", "OCoachmarkView_cmFilledActionBackgroundColor"), 0));
    L48:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmTitleTextAppearance, "styleable", "OCoachmarkView_cmTitleTextAppearance")) == false) goto L51;
        this.titleTextAppearance = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmTitleTextAppearance, "styleable", "OCoachmarkView_cmTitleTextAppearance"), 0);
    L51:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmDescTextAppearance, "styleable", "OCoachmarkView_cmDescTextAppearance")) == false) goto L54;
        this.descTextAppearance = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmDescTextAppearance, "styleable", "OCoachmarkView_cmDescTextAppearance"), 0);
    L54:
        if (this.enableMaterial == false) goto L57;
        this.enableMaterial = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_oui_widgetEnableMaterial, "styleable", "OCoachmarkView_oui_widgetEnableMaterial"), true);
    L57:
        if (this.enableMaterial == false) goto L63;
        String r0 = r8.getString(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_oui_widgetMaterial, "styleable", "OCoachmarkView_oui_widgetMaterial"));
        if (r0 != null) goto L61;
        r0 = ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_material_bg_popup, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_material_bg_popup"));
    L61:
        this.materials = MaterialToken.parseSet(r0, !isDarkTheme());
        return;
    L63:
        return;
    L6:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_android_background, "styleable", "OCoachmarkView_android_background")) == false) goto L21;
        Drawable r1 = r8.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_android_background, "styleable", "OCoachmarkView_android_background"));
        if (ZeusTransformUtils.instanceOf(r1, ColorDrawable.class) == false) goto L10;
        ColorDrawable r2 = (ColorDrawable) ZeusTransformUtils.preCheckCast(r1, ColorDrawable.class, "com.obric.aiagent.plugin");
    L11:
        if (r2 != null) goto L13;
        Integer r3 = null;
    L14:
        if (r3 == null) goto L16;
        this.bgColor = r3.intValue();
        goto L21
    L16:
        com.obric.oui.d.a.b r4 = com.obric.oui.d.a.b.f35007a;
        if (r4.a(8) == true) goto L21;
        r4.a().a(TAG, 8, "android:background is not a color; ignored. Use cmBackgroundColor for color.", null);
        goto L21
    L13:
        r3 = Integer.valueOf(r2.getColor());
        goto L14
    L10:
        r2 = null;
        goto L11
    }

    private final boolean isDarkTheme() {
        int r0 = this.bgColor;
        if (r0 != 0) goto L7;
        return com.obric.oui.d.i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    L7:
        return com.obric.oui.color.d.a(r0);
    }

    private final void updateLayout() {
        updateContentStyle();
        updateContent();
        if (this.materials == null) goto L6;
        this.containerView.setEnableShadowWidthRadius(true);
    L6:
        applyAppearance();
        applyStylePadding();
        updateContainerPadding();
        updateArrowPosition();
    }

    private final void updateContentStyle() {
        this.containerView.setWidthLimit(this.maxWidthPx);
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.containerView, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        d r4 = this.contentStyle;
        int r5 = e.f34426a[r4.ordinal()];
        if (r5 != 1) goto L5;
        int r6 = -2;
    L12:
        r3.width = r6;
        r0.setLayoutParams(r2);
        return;
    L5:
        if (r5 != 2) goto L10;
        int r7 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getWidth();
        r6 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 320);
        if (r6 <= r7) goto L12;
        r6 = -1;
        goto L12
    L10:
        throw new d.k();
    }

    private final void applyStylePadding() {
        if (this.isContentPaddingCustomized == false) goto L6;
        return;
    L6:
        if (this.customContentView == null) goto L9;
        applyCustomContentPadding();
        return;
    L9:
        int r0 = e.f34426a[this.contentStyle.ordinal()];
        int r1 = 0;
        if (r0 != 1) goto L12;
        this.contentPaddingStartPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20);
        this.contentPaddingTopPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        if (this.showCloseIcon == true) goto L33;
        r1 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20);
    L33:
        this.contentPaddingEndPx = r1;
        this.contentPaddingBottomPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        return;
    L12:
        if (r0 != 2) goto L36;
        boolean r2 = hasVisibleActions();
        if (this.iconDrawable == null) goto L20;
        if (this.heroDrawable != null) goto L20;
        r1 = 1;
    L20:
        if (r1 == 0) goto L23;
        if (r2 == false) goto L23;
        int r3 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16);
    L24:
        this.contentPaddingStartPx = r3;
        this.contentPaddingTopPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16);
        if (r2 == false) goto L27;
        int r4 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16);
    L28:
        this.contentPaddingEndPx = r4;
        this.contentPaddingBottomPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16);
        return;
    L27:
        r4 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20);
    L23:
        r3 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20);
        goto L24
    }

    private final void applyCustomContentPadding() {
        d r0 = this.contentStyle;
        int r1 = e.f34426a[r0.ordinal()];
        if (r1 != 1) goto L5;
        int r2 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20);
        int r3 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        this.contentPaddingStartPx = r2;
        this.contentPaddingTopPx = r3;
        this.contentPaddingEndPx = r2;
        this.contentPaddingBottomPx = r3;
        return;
    L5:
        if (r1 != 2) goto L11;
        int r4 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20);
        int r5 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16);
        this.contentPaddingStartPx = r4;
        this.contentPaddingTopPx = r5;
        this.contentPaddingEndPx = r4;
        this.contentPaddingBottomPx = r5;
        return;
    }

    private final void applyAppearance() {
        int r0 = e.f34426a[this.contentStyle.ordinal()];
        if (r0 != 1) goto L5;
        int r1 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 28);
    L10:
        applyContainerRadius(r1);
        if (this.enableMaterial == false) goto L20;
        if (this.materials == null) goto L20;
        if (this.showArrow == false) goto L17;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.containerView, View.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.c[] r2 = this.materials;
        o.a(r2);
        k.a(r4, r2[0], false, 0, 6, null);
        l.a(this.containerView, 0.0f, 0);
        this.containerView.setOuterNormalColor(0);
        this.containerView.setBorderWidth(0);
    L18:
        OUIFrameLayout r3 = this.containerView;
        GradientDrawable r5 = new GradientDrawable();
        r5.setShape(0);
        r5.setCornerRadius(r1);
        r5.setColor(0);
        r3.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r5, Drawable.class, "com.obric.aiagent.plugin"));
    L23:
        if (this.titleTextAppearance == 0) goto L26;
        TextViewCompat.a((TextView) ZeusTransformUtils.preCheckCast(this.titleView, TextView.class, "com.obric.aiagent.plugin"), this.titleTextAppearance);
    L26:
        if (this.descTextAppearance == 0) goto L28;
        TextViewCompat.a((TextView) ZeusTransformUtils.preCheckCast(this.descriptionView, TextView.class, "com.obric.aiagent.plugin"), this.descTextAppearance);
    L28:
        applyStyledColors();
        return;
    L17:
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.containerView, View.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.c[] r7 = this.materials;
        o.a(r7);
        k.a(r6, r7, false, 0, null, 14, null);
    L20:
        if (this.bgColor == 0) goto L23;
        OUIFrameLayout r8 = this.containerView;
        GradientDrawable r9 = new GradientDrawable();
        r9.setCornerRadius(r1);
        r9.setColor(this.bgColor);
        r8.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r9, Drawable.class, "com.obric.aiagent.plugin"));
        this.containerView.setOuterNormalColor(this.bgColor);
        goto L23
    L5:
        if (r0 != 2) goto L8;
        r1 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20);
        goto L10
    L8:
        throw new d.k();
    }

    private final void applyContainerRadius(int r2) {
        this.containerView.setShadowCornerRadius(r2);
        if (this.containerView.isEnableShadowWidthRadius() == false) goto L6;
        this.containerView.setRadius(r2);
        return;
    }

    private final void applyStyledColors() {
        ColorStateList r0 = this.titleTextColor;
        if (r0 == null) goto L6;
        this.titleView.setTextColor(r0);
    L6:
        ColorStateList r1 = this.descTextColor;
        if (r1 == null) goto L10;
        this.descriptionView.setTextColor(r1);
    L10:
        this.iconView.setImageTintList(this.iconTint);
        ColorStateList r2 = this.closeIconTint;
        if (r2 == null) goto L14;
        this.closeButton.setImageTintList(r2);
    L14:
        Integer r3 = this.actionNeutralTextColor;
        if (r3 == null) goto L18;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue();
        this.actionTextButton.setTextColor(r4);
    L18:
        Integer r5 = this.actionPrimaryTextColor;
        if (r5 == null) goto L22;
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue();
        this.actionTextPrimaryButton.setTextColor(r6);
    L22:
        Integer r7 = this.filledActionTextColor;
        if (r7 == null) goto L26;
        int r8 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue();
        this.actionFilledButton.setTextColor(r8);
    L26:
        Integer r9 = this.filledActionBackgroundColor;
        if (r9 == null) goto L31;
        int r10 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue();
        this.actionFilledButton.setBackgroundTintList(ColorStateList.valueOf(r10));
        this.actionFilledButton.setOuterNormalColor(r10);
        return;
    }

    private final void updateContent() {
        View r0 = this.customContentView;
        boolean r1 = true;
        if (r0 == null) goto L9;
        if (r0 == null) goto L76;
        com.obric.oui.common.util.k.a(r0, true);
        return;
    L76:
        return;
    L9:
        if (this.heroDrawable == null) goto L11;
        boolean r2 = true;
    L12:
        com.obric.oui.common.util.k.a(this.heroContainer, r2);
        if (r2 == false) goto L15;
        this.heroImage.setImageDrawable(this.heroDrawable);
    L17:
        if (r2 == true) goto L19;
    L24:
        if (r2 == false) goto L26;
    L28:
        boolean r3 = false;
    L29:
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.iconContainer, View.class, "com.obric.aiagent.plugin"), r3);
        if (r3 == false) goto L32;
        this.iconView.setImageDrawable(this.iconDrawable);
    L33:
        View r6 = this.textGroup;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r8 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r3 == false) goto L36;
        int r11 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
    L37:
        r10.setMarginStart(r11);
        r6.setLayoutParams(r8);
        CharSequence r9 = this.titleText;
        if (r9 != null) goto L40;
    L43:
        boolean r12 = true;
    L44:
        boolean r13 = !r12;
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.titleView, View.class, "com.obric.aiagent.plugin"), r13);
        this.titleView.setText(this.titleText);
        View r14 = (View) ZeusTransformUtils.preCheckCast(this.descriptionView, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r16 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r16, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r13 == false) goto L47;
        int r18 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4);
    L48:
        r17.topMargin = r18;
        r14.setLayoutParams(r16);
        this.descriptionView.setText(this.descriptionText);
        this.descriptionView.setMaxWidth(Math.min(this.maxWidthPx, com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getWidth()));
        CharSequence r19 = this.titleText;
        if (r19 != null) goto L51;
    L54:
        boolean r20 = true;
    L55:
        if (r20 == false) goto L68;
        CharSequence r21 = this.descriptionText;
        if (r21 != null) goto L59;
    L62:
        boolean r22 = true;
    L63:
        if (r22 == false) goto L68;
        com.obric.oui.d.a.b r23 = com.obric.oui.d.a.b.f35007a;
        if (r23.a(8) == true) goto L68;
        r23.a().a(TAG, 8, "Coachmark title and description are empty.", null);
        goto L68
    L59:
        if (d.o.o.d(r21) == true) goto L62;
        r22 = false;
    L68:
        updateActions();
        updateActionTextTopMargin(r3);
        if (this.contentStyle == d.f34422b) goto L71;
    L73:
        r1 = false;
    L74:
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.closeButton, View.class, "com.obric.aiagent.plugin"), r1);
        return;
    L71:
        if (this.showCloseIcon == false) goto L73;
    L51:
        if (d.o.o.d(r19) == true) goto L54;
        r20 = false;
        goto L55
    L47:
        r18 = 0;
        goto L48
    L40:
        if (d.o.o.d(r9) == true) goto L43;
        r12 = false;
        goto L44
    L36:
        r11 = 0;
        goto L37
    L32:
        this.iconView.setImageDrawable(null);
        goto L33
    L26:
        if (this.iconDrawable == null) goto L28;
        r3 = true;
        goto L29
    L19:
        if (this.iconDrawable == null) goto L24;
        com.obric.oui.d.a.b r24 = com.obric.oui.d.a.b.f35007a;
        if (r24.a(8) == true) goto L24;
        r24.a().a(TAG, 8, "Hero image is set; cmIcon will be ignored.", null);
        goto L24
    L15:
        this.heroImage.setImageDrawable(null);
        goto L17
    L11:
        r2 = false;
        goto L12
    }

    private final boolean detachFromParent(View r7) {
        ViewParent r0 = r7.getParent();
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0 != this.contentContainer) goto L9;
        return true;
    L9:
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == true) goto L16;
        com.obric.oui.d.a.b r6 = com.obric.oui.d.a.b.f35007a;
        if (r6.a(8) == true) goto L22;
        r6.a().a(TAG, 8, o.a("custom content view has a non-ViewGroup parent: ", r0.getClass().getSimpleName()), null);
        return false;
    L22:
        return false;
    L16:
        com.obric.oui.d.a.b r8 = com.obric.oui.d.a.b.f35007a;
        if (r8.a(8) == true) goto L20;
        r8.a().a(TAG, 8, "custom content view already has a parent; it will be moved into coachmark content container.", null);
    L20:
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(r7);
        return true;
    }

    private final void releaseCustomContentView() {
        View r0 = this.customContentView;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = r0.getParent();
        ViewGroup r2 = this.contentContainer;
        if (r1 != r2) goto L8;
        r2.removeView(r0);
    L8:
        this.customContentView = null;
    }

    private final void updateActionTextTopMargin(boolean r5) {
        View r0 = this.actionTextContainer;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r5 == false) goto L5;
        int r4 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
    L6:
        r3.topMargin = r4;
        r0.setLayoutParams(r2);
        return;
    L5:
        r4 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        goto L6
    }

    private final void updateActions() {
        CharSequence r0 = resolveDisplayedActionText();
        boolean r1 = hasPrimaryActionText();
        boolean r2 = hasSecondaryActionText();
        boolean r3 = hasDualTextActions();
        com.obric.oui.common.util.k.a(this.actionTextContainer, false);
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.actionTextButton, View.class, "com.obric.aiagent.plugin"), false);
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.actionTextPrimaryButton, View.class, "com.obric.aiagent.plugin"), false);
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.actionFilledButton, View.class, "com.obric.aiagent.plugin"), false);
        this.actionTextButton.setOnClickListener(null);
        this.actionTextPrimaryButton.setOnClickListener(null);
        this.actionFilledButton.setOnClickListener(null);
        if (this.primaryActionClickListener == null) goto L10;
        if (r1 == true) goto L10;
        com.obric.oui.d.a.b r4 = com.obric.oui.d.a.b.f35007a;
        if (r4.a(8) == true) goto L10;
        r4.a().a(TAG, 8, "Primary action listener is set without primary action text.", null);
    L10:
        if (this.secondaryActionClickListener == null) goto L16;
        if (r2 == true) goto L16;
        com.obric.oui.d.a.b r5 = com.obric.oui.d.a.b.f35007a;
        if (r5.a(8) == true) goto L16;
        r5.a().a(TAG, 8, "Secondary action listener is set without secondary action text.", null);
    L16:
        if (r2 == false) goto L22;
        if (r1 == true) goto L22;
        com.obric.oui.d.a.b r6 = com.obric.oui.d.a.b.f35007a;
        if (r6.a(8) == true) goto L22;
        r6.a().a(TAG, 8, "Secondary action text is set without primary action text; secondary action will not render by itself.", null);
    L22:
        if (r2 == true) goto L24;
    L29:
        int r7 = e.f34427b[this.actionStyle.ordinal()];
        if (r7 != 1) goto L32;
        if (r3 == false) goto L51;
        com.obric.oui.common.util.k.a(this.actionTextContainer, true);
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.actionTextButton, View.class, "com.obric.aiagent.plugin"), true);
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.actionTextPrimaryButton, View.class, "com.obric.aiagent.plugin"), true);
        this.actionTextButton.setText(this.secondaryActionText);
        this.actionTextPrimaryButton.setText(this.primaryActionText);
        this.actionTextButton.setOnClickListener(this.secondaryActionClickListener);
        this.actionTextPrimaryButton.setOnClickListener(this.primaryActionClickListener);
        return;
    L51:
        if (r0 != null) goto L57;
        com.obric.oui.d.a.b r8 = com.obric.oui.d.a.b.f35007a;
        if (r8.a(8) == true) goto L60;
        r8.a().a(TAG, 8, "ActionStyle " + access$getActionStyle$p(this) + " is set without action text.", null);
        return;
    L60:
        return;
    L57:
        com.obric.oui.common.util.k.a(this.actionTextContainer, true);
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.actionTextButton, View.class, "com.obric.aiagent.plugin"), true);
        this.actionTextButton.setText(r0);
        updateDisplayedActionClickListener();
        return;
    L32:
        if (r7 != 2) goto L34;
        if (r0 != null) goto L47;
        com.obric.oui.d.a.b r9 = com.obric.oui.d.a.b.f35007a;
        if (r9.a(8) == true) goto L59;
        r9.a().a(TAG, 8, "ActionStyle " + access$getActionStyle$p(this) + " is set without action text.", null);
        return;
    L59:
        return;
    L47:
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.actionFilledButton, View.class, "com.obric.aiagent.plugin"), true);
        this.actionFilledButton.setText(r0);
        updateDisplayedActionClickListener();
        return;
    L34:
        if (r7 != 3) goto L64;
        if (r0 == null) goto L61;
        com.obric.oui.d.a.b r10 = com.obric.oui.d.a.b.f35007a;
        if (r10.a(8) == true) goto L65;
        r10.a().a(TAG, 8, "action text is set while ActionStyle.NONE; action will stay hidden.", null);
        return;
    L65:
        return;
    L61:
        return;
    L64:
        return;
    L24:
        if (this.actionStyle != a.f34414d) goto L29;
        com.obric.oui.d.a.b r11 = com.obric.oui.d.a.b.f35007a;
        if (r11.a(8) == true) goto L29;
        r11.a().a(TAG, 8, "Secondary action text is set with FILLED_BUTTON; filled coachmark renders only the primary action.", null);
        goto L29
    }

    private final void updateDisplayedActionClickListener() {
        if (hasDualTextActions() == false) goto L6;
        this.actionTextButton.setOnClickListener(this.secondaryActionClickListener);
        this.actionTextPrimaryButton.setOnClickListener(this.primaryActionClickListener);
        return;
    L6:
        View.OnClickListener r0 = resolveDisplayedActionClickListener();
        this.actionTextButton.setOnClickListener(r0);
        this.actionTextPrimaryButton.setOnClickListener(null);
        this.actionFilledButton.setOnClickListener(r0);
    }

    private final boolean hasPrimaryActionText() {
        CharSequence r1 = this.primaryActionText;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        return !r2;
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final boolean hasSecondaryActionText() {
        CharSequence r1 = this.secondaryActionText;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        return !r2;
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final boolean hasDualTextActions() {
        if (this.actionStyle == a.f34413c) goto L5;
    L9:
        return false;
    L5:
        if (hasPrimaryActionText() == false) goto L9;
        if (hasSecondaryActionText() == false) goto L9;
        return true;
    }

    private final CharSequence resolveDisplayedActionText() {
        if (hasPrimaryActionText() == true) goto L7;
        return null;
    L7:
        return this.primaryActionText;
    }

    private final View.OnClickListener resolveDisplayedActionClickListener() {
        if (hasPrimaryActionText() == true) goto L7;
        return null;
    L7:
        return this.primaryActionClickListener;
    }

    private final boolean hasVisibleActions() {
        if (this.actionStyle != a.f34412b) goto L5;
    L7:
        return false;
    L5:
        if (resolveDisplayedActionText() == null) goto L7;
        return true;
    }

    private final void updateArrowPosition() {
        if (this.arrowPosition != b.f34417b) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (this.showArrow == true) goto L12;
        int r2 = 0;
    L16:
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.containerView, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams r8 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r7, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r8, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r9.topMargin = 0;
        r9.bottomMargin = 0;
        r9.setMarginStart(0);
        r9.setMarginEnd(0);
        int r10 = e.f34428c[this.arrowPosition.ordinal()];
        int r13 = 81;
        if (r10 == 1) goto L26;
        if (r10 == 2) goto L25;
        if (r10 == 3) goto L24;
        if (r10 != 4) goto L23;
        int r11 = 8388629;
    L27:
        r9.gravity = r11;
        int r12 = e.f34428c[this.arrowPosition.ordinal()];
        if (r12 == 1) goto L36;
        if (r12 == 2) goto L35;
        if (r12 == 3) goto L34;
        if (r12 != 4) goto L37;
        r9.setMarginEnd(r2);
    L37:
        r6.setLayoutParams(r8);
        if (r1 == false) goto L40;
        int r3 = ZeusTransformUtils.mapRes(R.drawable.oui_coachmark_arrow, "drawable", "oui_coachmark_arrow");
    L41:
        View r14 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        if (r1 == false) goto L44;
        int r15 = g.a(r14, 20);
    L45:
        if (r1 == false) goto L47;
        int r16 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 9);
    L48:
        View r17 = (View) ZeusTransformUtils.preCheckCast(this.arrowView, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        Objects.requireNonNull(r18, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams r19 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r18, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r110 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r19, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r110.width = r15;
        r110.height = r16;
        int r20 = e.f34428c[this.arrowPosition.ordinal()];
        if (r20 == 1) goto L57;
        if (r20 == 2) goto L58;
        if (r20 == 3) goto L56;
        if (r20 != 4) goto L55;
        r13 = 8388629;
        goto L58
    L55:
        throw new d.k();
    L56:
        r13 = 8388627;
    L58:
        r110.gravity = r13;
        r17.setLayoutParams(r19);
        this.arrowView.setImageResource(r3);
        ColorStateList r4 = this.arrowColor;
        if (r4 == null) goto L62;
        this.arrowView.setImageTintList(r4);
    L62:
        ImageView r5 = this.arrowView;
        int r21 = e.f34428c[this.arrowPosition.ordinal()];
        float r22 = 0.0f;
        if (r21 == 1) goto L71;
        if (r21 == 2) goto L70;
        if (r21 == 3) goto L71;
        if (r21 == 4) goto L71;
        throw new d.k();
    L70:
        float r23 = 180.0f;
    L72:
        r5.setRotation(r23);
        ImageView r24 = this.arrowView;
        if (this.arrowPosition != b.f34420e) goto L75;
        float r25 = -1.0f;
    L76:
        r24.setScaleX(r25);
        this.arrowView.setScaleY(1.0f);
        ImageView r26 = this.arrowView;
        if (r1 == false) goto L79;
        r22 = this.arrowOffsetPx;
    L79:
        r26.setTranslationX(r22);
        this.arrowView.invalidateOutline();
        if (this.enableMaterial == false) goto L92;
        com.obric.oui.material.c[] r27 = this.materials;
        if (r27 == null) goto L94;
        com.obric.oui.material.c r28 = r27[0];
        k.a((View) ZeusTransformUtils.preCheckCast(this.arrowView, View.class, "com.obric.aiagent.plugin"), r28, false, 0, 6, null);
        this.arrowView.setBackgroundColor(0);
        this.arrowView.setImageDrawable(null);
        com.obric.oui.color.e r29 = r28.e();
        if (r29 != null) goto L88;
        return;
    L88:
        if (this.arrowView.getVisibility() != 0) goto L90;
        this.containerView.setBorderWidth(0);
        return;
    L90:
        this.containerView.setBorderWidth(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r29.a()));
        return;
    L94:
        return;
    L92:
        return;
    L75:
        r25 = 1.0f;
    L71:
        r23 = 0.0f;
        goto L72
    L57:
        r13 = 49;
        goto L58
    L47:
        r16 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20);
        goto L48
    L44:
        r15 = g.a(r14, 10);
        goto L45
    L40:
        r3 = ZeusTransformUtils.mapRes(R.drawable.oui_coachmark_arrow_left, "drawable", "oui_coachmark_arrow_left");
        goto L41
    L34:
        r9.setMarginStart(r2);
        goto L37
    L35:
        r9.bottomMargin = r2;
        goto L37
    L36:
        r9.topMargin = r2;
        goto L37
    L23:
        throw new d.k();
    L24:
        r11 = 8388627;
        goto L27
    L25:
        r11 = 81;
        goto L27
    L26:
        r11 = 49;
        goto L27
    L12:
        if (r1 == false) goto L14;
        r2 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        goto L16
    L14:
        r2 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        goto L16
    L5:
        if (this.arrowPosition == b.f34418c) goto L8;
        r1 = false;
        goto L10
    }

    private final void updateContainerPadding() {
        this.contentContainer.setPaddingRelative(this.contentPaddingStartPx, this.contentPaddingTopPx, this.contentPaddingEndPx, this.contentPaddingBottomPx);
    }
}
