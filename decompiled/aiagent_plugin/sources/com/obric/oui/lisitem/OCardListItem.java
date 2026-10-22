package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.util.g;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.text.OTextView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OCardListItem.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OCardListItem extends FrameLayout {
    public static final int CUSTOM_END_CHECKBOX = 0;
    public static final int CUSTOM_END_DETAIL = 3;
    public static final int CUSTOM_END_HANDLE = 4;
    public static final int CUSTOM_END_MARK = 2;
    public static final int CUSTOM_END_SWITCH = 1;
    public static final int CUSTOM_START_CHECKBOX = 0;
    public static final int CUSTOM_TITLE_DETAIL = 1;
    public static final int CUSTOM_TITLE_ICON = 0;
    public static final int CUSTOM_TITLE_NONE = -1;
    public static final a Companion = null;
    public static final int DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP = 168;
    public static final int POSITION_BOTTOM = 3;
    public static final int POSITION_MIDDLE = 2;
    public static final int POSITION_SINGLE = 0;
    public static final int POSITION_TOP = 1;
    public static final int TAIL_ICON_ARROW = 0;
    public static final int TAIL_ICON_CHEVRON = 1;
    public static final int TYPE_CONTAINER = 2;
    public static final int TYPE_LARGE = 1;
    public static final int TYPE_NORMAL = 0;
    private OImageAppIcon appIcon;
    private int bgColor;
    private final OUIFrameLayout cardContainer;
    private final b cardListItemPositionHelper;
    private final OUICardConstraintLayout contentContainer;
    private OStateGradientDrawable contentContainerBg;
    private ColorStateList contentContainerBgColor;
    private ColorStateList contentDefaultContainerBgColor;
    private ColorStateList contentMarkContainerBgColor;
    private int currentPosition;
    private int currentSwipeOffset;
    private int currentType;
    private int customDividerEnd;
    private int customDividerStart;
    private final FrameLayout customEndContainer;
    private final FrameLayout customStartContainer;
    private View.OnLayoutChangeListener customStartLayoutChangeListener;
    private int customTitleMode;
    private final View divider;
    private boolean enableSwipeDivider;
    private final ImageView icon;
    private final FrameLayout iconContainer;
    private boolean isMark;
    private int maxTailTextWidth;
    private final FrameLayout root;
    private boolean showCardBg;
    private final OTextView subTitle;
    private int subTitleColor;
    private FrameLayout swipeContainer;
    private OSwipeLayout swipeLayout;
    private final ImageView tailIcon;
    private final OTextView title;
    private int titleColor;
    private final LinearLayout titleContainer;

    /* JADX INFO: compiled from: OCardListItem.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public OCardListItem(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OCardListItem(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$V3ppt_lP6BfUucBNKZySkjiFCOA(OCardListItem r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        m1100_init_$lambda1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void lambda$rOgupYxOd7hAmZabgnCvZANBZFs(OCardListItem r0) {
        m1101updateDividerPosition$lambda17(r0);
    }

    public final void setCardPosition(int r4) {
        setCardPosition$default(this, r4, false, 2, null);
    }

    public final void setCustomTitleView(int r7, int r8) {
        setCustomTitleView$default(this, r7, r8, false, 4, null);
    }

    public final void setCustomTitleView(View r7, int r8) {
        setCustomTitleView$default(this, r7, r8, false, 4, null);
    }

    public final void setDefaultCustomTitleView(int r7, int r8) {
        setDefaultCustomTitleView$default(this, r7, r8, false, 4, null);
    }

    public final void setEndDetailText(CharSequence r4) {
        setEndDetailText$default(this, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
    }

    public /* synthetic */ OCardListItem(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public static final /* synthetic */ int access$getCurrentType$p(OCardListItem r0) {
        return r0.currentType;
    }

    public static final /* synthetic */ View access$getDivider$p(OCardListItem r0) {
        return r0.divider;
    }

    public static final /* synthetic */ boolean access$getEnableSwipeDivider$p(OCardListItem r0) {
        return r0.enableSwipeDivider;
    }

    public static final /* synthetic */ void access$setCurrentSwipeOffset$p(OCardListItem r0, int r1) {
        r0.currentSwipeOffset = r1;
    }

    public OCardListItem(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10, r8);
        this.showCardBg = true;
        this.bgColor = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_list_item_card, "color", "oui_fill_list_item_card"));
        this.contentContainerBg = new OStateGradientDrawable();
        ColorStateList r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColorStateList(ZeusTransformUtils.mapRes(R.color.o_card_list_item_content_bg_color, "color", "o_card_list_item_content_bg_color"));
        o.c(r0, "resources.getColorStateL…st_item_content_bg_color)");
        this.contentDefaultContainerBgColor = r0;
        this.titleColor = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1"));
        this.subTitleColor = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3"));
        this.customDividerStart = -1;
        this.customDividerEnd = -1;
        this.enableSwipeDivider = true;
        this.customTitleMode = -1;
        this.contentContainerBgColor = this.contentDefaultContainerBgColor;
        this.maxTailTextWidth = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP);
        setClipChildren(false);
        setClipToPadding(false);
        if (getLayoutParams() != null) goto L5;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    L5:
        View r11 = ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.o_card_list_item_layout, "layout", "o_card_list_item_layout"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r12 = (FrameLayout) ZeusTransformUtils.preCheckCast(r11, FrameLayout.class, "com.obric.aiagent.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.card_list_item_root, DbHelper.COL_ID, "card_list_item_root"));
        o.c(r13, "findViewById(R.id.card_list_item_root)");
        FrameLayout r14 = (FrameLayout) ZeusTransformUtils.preCheckCast(r13, FrameLayout.class, "com.obric.aiagent.plugin");
        this.root = r14;
        r14.setClickable(true);
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.card_container, DbHelper.COL_ID, "card_container"));
        o.c(r15, "findViewById(R.id.card_container)");
        OUIFrameLayout r16 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r15, OUIFrameLayout.class, "com.obric.aiagent.plugin");
        this.cardContainer = r16;
        r16.setChangeAlphaWhenPress(false);
        r16.setChangeAlphaWhenDisable(false);
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.content_container, DbHelper.COL_ID, "content_container"));
        o.c(r3, "findViewById(R.id.content_container)");
        OUICardConstraintLayout r4 = (OUICardConstraintLayout) ZeusTransformUtils.preCheckCast(r3, OUICardConstraintLayout.class, "com.obric.aiagent.plugin");
        this.contentContainer = r4;
        r4.setChangeAlphaWhenPress(false);
        r4.setChangeAlphaWhenDisable(true);
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.custom_start_container, DbHelper.COL_ID, "custom_start_container"));
        o.c(r17, "findViewById(R.id.custom_start_container)");
        this.customStartContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r17, FrameLayout.class, "com.obric.aiagent.plugin");
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.icon_container, DbHelper.COL_ID, "icon_container"));
        o.c(r18, "findViewById(R.id.icon_container)");
        this.iconContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r18, FrameLayout.class, "com.obric.aiagent.plugin");
        View r19 = findViewById(ZeusTransformUtils.mapRes(R.id.icon, DbHelper.COL_ID, "icon"));
        o.c(r19, "findViewById(R.id.icon)");
        this.icon = (ImageView) ZeusTransformUtils.preCheckCast(r19, ImageView.class, "com.obric.aiagent.plugin");
        View r20 = findViewById(ZeusTransformUtils.mapRes(R.id.title_container, DbHelper.COL_ID, "title_container"));
        o.c(r20, "findViewById(R.id.title_container)");
        this.titleContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r20, LinearLayout.class, "com.obric.aiagent.plugin");
        View r21 = findViewById(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE));
        o.c(r21, "findViewById(R.id.title)");
        this.title = (OTextView) ZeusTransformUtils.preCheckCast(r21, OTextView.class, "com.obric.aiagent.plugin");
        View r22 = findViewById(ZeusTransformUtils.mapRes(R.id.sub_title, DbHelper.COL_ID, "sub_title"));
        o.c(r22, "findViewById(R.id.sub_title)");
        this.subTitle = (OTextView) ZeusTransformUtils.preCheckCast(r22, OTextView.class, "com.obric.aiagent.plugin");
        View r23 = findViewById(ZeusTransformUtils.mapRes(R.id.custom_end_container, DbHelper.COL_ID, "custom_end_container"));
        o.c(r23, "findViewById(R.id.custom_end_container)");
        this.customEndContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r23, FrameLayout.class, "com.obric.aiagent.plugin");
        View r24 = findViewById(ZeusTransformUtils.mapRes(R.id.tail_icon, DbHelper.COL_ID, "tail_icon"));
        o.c(r24, "findViewById(R.id.tail_icon)");
        this.tailIcon = (ImageView) ZeusTransformUtils.preCheckCast(r24, ImageView.class, "com.obric.aiagent.plugin");
        View r25 = findViewById(ZeusTransformUtils.mapRes(R.id.card_divider, DbHelper.COL_ID, "card_divider"));
        o.c(r25, "findViewById(R.id.card_divider)");
        this.divider = r25;
        this.customStartLayoutChangeListener = new $$Lambda$OCardListItem$V3ppt_lP6BfUucBNKZySkjiFCOA(this);
        View r26 = findViewById(ZeusTransformUtils.mapRes(R.id.swipe_layout, DbHelper.COL_ID, "swipe_layout"));
        o.c(r26, "findViewById(R.id.swipe_layout)");
        OSwipeLayout r27 = (OSwipeLayout) ZeusTransformUtils.preCheckCast(r26, OSwipeLayout.class, "com.obric.aiagent.plugin");
        this.swipeLayout = r27;
        r27.setChangeAlphaWhenPress(false);
        this.swipeLayout.setChangeAlphaWhenDisable(false);
        this.swipeLayout.setSwipeEnabled(false);
        this.swipeLayout.addSwipeListener((OSwipeLayout.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), OSwipeLayout.i.class, "com.obric.aiagent.plugin"));
        View r28 = findViewById(ZeusTransformUtils.mapRes(R.id.swip_container, DbHelper.COL_ID, "swip_container"));
        o.c(r28, "findViewById(R.id.swip_container)");
        this.swipeContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r28, FrameLayout.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L9;
        parseAttributes(r10);
    L9:
        resetContentContainerCorner();
        setCardType(this.currentType);
        setTitleColor(this.titleColor, this.subTitleColor);
        this.cardListItemPositionHelper = new b((FrameLayout) ZeusTransformUtils.preCheckCast(r16, FrameLayout.class, "com.obric.aiagent.plugin"), this.showCardBg, this.bgColor, this.currentPosition);
    }

    public final ColorStateList getContentContainerBgColor() {
        return this.contentContainerBgColor;
    }

    public final void setContentContainerBgColor(ColorStateList r2) {
        o.e(r2, "value");
        if (o.a(this.contentContainerBgColor, r2) == true) goto L9;
        this.contentContainerBgColor = r2;
        OStateGradientDrawable r1 = this.contentContainerBg;
        if (r1 == null) goto L10;
        r1.setSolidColors(r2);
        return;
    L10:
        return;
    }

    public final boolean isMark() {
        return this.isMark;
    }

    public final void setMark(boolean r2) {
        if (this.isMark == r2) goto L12;
        this.isMark = r2;
        if (r2 == false) goto L10;
        ColorStateList r3 = this.contentMarkContainerBgColor;
        if (r3 == null) goto L14;
        setContentContainerBgColor(r3);
        return;
    L14:
        return;
    L10:
        setContentContainerBgColor(this.contentDefaultContainerBgColor);
        return;
    }

    /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
    private static final void m1100_init_$lambda1(OCardListItem r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        o.e(r0, "this$0");
        if (r0.divider.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L9;
        r0.updateDividerPosition();
        return;
    L9:
        return;
    L5:
        r10 = false;
        goto L6
    }

    private final void parseAttributes(AttributeSet r27) {
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r27, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r12, R.styleable.OCardListItemContainer);
        o.c(r13, "context.obtainStyledAttr…e.OCardListItemContainer)");
    L74:
        th = move-exception;
        r13.recycle();
        throw th;
    L4:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showCardBg, "styleable", "OCardListItemContainer_ocardlistitem_showCardBg")) == false) goto L6;
        this.showCardBg = r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showCardBg, "styleable", "OCardListItemContainer_ocardlistitem_showCardBg"), true);     // Catch: Throwable -> L74
    L6:
        this.bgColor = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_bgColor, "styleable", "OCardListItemContainer_ocardlistitem_bgColor"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_list_item_card, "color", "oui_fill_list_item_card")));     // Catch: Throwable -> L74
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_contentColorList, "styleable", "OCardListItemContainer_ocardlistitem_contentColorList")) == false) goto L13;
        ColorStateList r1 = r13.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_contentColorList, "styleable", "OCardListItemContainer_ocardlistitem_contentColorList"));     // Catch: Throwable -> L74
        if (r1 != null) goto L11;
        r1 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColorStateList(ZeusTransformUtils.mapRes(R.color.o_card_list_item_content_bg_color, "color", "o_card_list_item_content_bg_color"));     // Catch: Throwable -> L74
        o.c(r1, "resources.getColorStateL…st_item_content_bg_color)");     // Catch: Throwable -> L74
    L11:
        this.contentDefaultContainerBgColor = r1;     // Catch: Throwable -> L74
        setContentContainerBgColor(r1);     // Catch: Throwable -> L74
    L13:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_cardType, "styleable", "OCardListItemContainer_ocardlistitem_cardType")) == false) goto L16;
        this.currentType = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_cardType, "styleable", "OCardListItemContainer_ocardlistitem_cardType"), 0);     // Catch: Throwable -> L74
    L16:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_cardPosition, "styleable", "OCardListItemContainer_ocardlistitem_cardPosition")) == false) goto L19;
        this.currentPosition = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_cardPosition, "styleable", "OCardListItemContainer_ocardlistitem_cardPosition"), 0);     // Catch: Throwable -> L74
    L19:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_customStart, "styleable", "OCardListItemContainer_ocardlistitem_customStart")) == false) goto L22;
        setCustomStartView(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_customStart, "styleable", "OCardListItemContainer_ocardlistitem_customStart"), 0));     // Catch: Throwable -> L74
    L22:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomStart, "styleable", "OCardListItemContainer_ocardlistitem_defaultCustomStart")) == false) goto L25;
        setDefaultCustomStartView(r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomStart, "styleable", "OCardListItemContainer_ocardlistitem_defaultCustomStart"), 0));     // Catch: Throwable -> L74
    L25:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_icon, "styleable", "OCardListItemContainer_ocardlistitem_icon")) == false) goto L28;
        setIcon(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_icon, "styleable", "OCardListItemContainer_ocardlistitem_icon"), 0));     // Catch: Throwable -> L74
    L28:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_title, "styleable", "OCardListItemContainer_ocardlistitem_title")) == false) goto L30;
        setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r13.getString(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_title, "styleable", "OCardListItemContainer_ocardlistitem_title")), CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L74
    L30:
        this.titleColor = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_titleColor, "styleable", "OCardListItemContainer_ocardlistitem_titleColor"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1")));     // Catch: Throwable -> L74
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_subTitle, "styleable", "OCardListItemContainer_ocardlistitem_subTitle")) == false) goto L33;
        setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r13.getString(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_subTitle, "styleable", "OCardListItemContainer_ocardlistitem_subTitle")), CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L74
    L33:
        this.subTitleColor = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_subTitleColor, "styleable", "OCardListItemContainer_ocardlistitem_subTitleColor"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3")));     // Catch: Throwable -> L74
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomTitle, "styleable", "OCardListItemContainer_ocardlistitem_defaultCustomTitle")) == false) goto L37;
        setDefaultCustomTitleView$default(this, r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomTitle, "styleable", "OCardListItemContainer_ocardlistitem_defaultCustomTitle"), 0), 0, false, 4, null);     // Catch: Throwable -> L74
    L37:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_customEnd, "styleable", "OCardListItemContainer_ocardlistitem_customEnd")) == false) goto L40;
        setCustomEndView(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_customEnd, "styleable", "OCardListItemContainer_ocardlistitem_customEnd"), 0));     // Catch: Throwable -> L74
    L40:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomEnd, "styleable", "OCardListItemContainer_ocardlistitem_defaultCustomEnd")) == false) goto L43;
        setDefaultCustomEndView(r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomEnd, "styleable", "OCardListItemContainer_ocardlistitem_defaultCustomEnd"), 0));     // Catch: Throwable -> L74
    L43:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_endDetailText, "styleable", "OCardListItemContainer_ocardlistitem_endDetailText")) == false) goto L46;
        setEndDetailText$default(this, (CharSequence) ZeusTransformUtils.preCheckCast(r13.getString(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_endDetailText, "styleable", "OCardListItemContainer_ocardlistitem_endDetailText")), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L74
    L46:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_tailIcon, "styleable", "OCardListItemContainer_ocardlistitem_tailIcon")) == false) goto L49;
        setTailIcon(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_tailIcon, "styleable", "OCardListItemContainer_ocardlistitem_tailIcon"), 0));     // Catch: Throwable -> L74
    L49:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultTailIcon, "styleable", "OCardListItemContainer_ocardlistitem_defaultTailIcon")) == false) goto L52;
        setDefaultTailIcon(r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultTailIcon, "styleable", "OCardListItemContainer_ocardlistitem_defaultTailIcon"), 0));     // Catch: Throwable -> L74
    L52:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showCustomStart, "styleable", "OCardListItemContainer_ocardlistitem_showCustomStart")) == false) goto L55;
        showCustomStart(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showCustomStart, "styleable", "OCardListItemContainer_ocardlistitem_showCustomStart"), false));     // Catch: Throwable -> L74
    L55:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showIcon, "styleable", "OCardListItemContainer_ocardlistitem_showIcon")) == false) goto L58;
        showIcon(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showIcon, "styleable", "OCardListItemContainer_ocardlistitem_showIcon"), false));     // Catch: Throwable -> L74
    L58:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showTitle, "styleable", "OCardListItemContainer_ocardlistitem_showTitle")) == false) goto L61;
        showTitle(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showTitle, "styleable", "OCardListItemContainer_ocardlistitem_showTitle"), false));     // Catch: Throwable -> L74
    L61:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showSubTitle, "styleable", "OCardListItemContainer_ocardlistitem_showSubTitle")) == false) goto L64;
        showSubTitle(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showSubTitle, "styleable", "OCardListItemContainer_ocardlistitem_showSubTitle"), false));     // Catch: Throwable -> L74
    L64:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showCustomEnd, "styleable", "OCardListItemContainer_ocardlistitem_showCustomEnd")) == false) goto L67;
        showCustomEnd(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showCustomEnd, "styleable", "OCardListItemContainer_ocardlistitem_showCustomEnd"), false));     // Catch: Throwable -> L74
    L67:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showTailIcon, "styleable", "OCardListItemContainer_ocardlistitem_showTailIcon")) == false) goto L70;
        showTailIcon(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showTailIcon, "styleable", "OCardListItemContainer_ocardlistitem_showTailIcon"), false));     // Catch: Throwable -> L74
    L70:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showDivider, "styleable", "OCardListItemContainer_ocardlistitem_showDivider")) == false) goto L72;
        showDivider(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showDivider, "styleable", "OCardListItemContainer_ocardlistitem_showDivider"), false));     // Catch: Throwable -> L74
    L72:
        r13.recycle();
    }

    private final void resetContentContainerBackground() {
        if (this.showCardBg == false) goto L5;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        int r1 = 12;
    L6:
        int r2 = g.a(r0, r1);
        OStateGradientDrawable r3 = this.contentContainerBg;
        if (r3 == null) goto L10;
        r3.setSolidColors(getContentContainerBgColor());
    L10:
        OStateGradientDrawable r4 = this.contentContainerBg;
        if (r4 == null) goto L14;
        r4.setCornerRadius(r2);
    L14:
        checkContentContainerListenerForBackground();
        return;
    L5:
        r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        r1 = 20;
        goto L6
    }

    private final void resetContentContainerCorner() {
        resetContentContainerBackground();
        if (this.showCardBg == false) goto L5;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        int r1 = 12;
    L6:
        int r2 = g.a(r0, r1);
        OSwipeLayout r3 = this.swipeLayout;
        boolean r4 = this.showCardBg;
        boolean r5 = false;
        if (r4 == false) goto L9;
        int r6 = r2;
    L10:
        if (r4 == true) goto L13;
        r2 = 0;
    L13:
        r3.setRadius(r6, 0, r2, 0);
        if (this.divider.getVisibility() != 0) goto L16;
        r5 = true;
    L16:
        if (r5 == false) goto L19;
        updateDividerPosition();
        return;
    L19:
        return;
    L9:
        r6 = 0;
        goto L10
    L5:
        r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        r1 = 20;
        goto L6
    }

    private final void checkContentContainerListenerForBackground() {
        if (this.contentContainer.hasOnClickListeners() == false) goto L5;
    L8:
        this.contentContainer.setBackground((Drawable) ZeusTransformUtils.preCheckCast(this.contentContainerBg, Drawable.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (this.contentContainer.hasOnLongClickListeners() == true) goto L8;
        this.contentContainer.setBackground(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OStateGradientDrawable r0 = this.contentContainerBg;
        if (r0 == null) goto L6;
        r0.endAnimation();
    L6:
        this.customStartContainer.addOnLayoutChangeListener(this.customStartLayoutChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.customStartContainer.removeOnLayoutChangeListener(this.customStartLayoutChangeListener);
    }

    public final void setBgColor(int r1) {
        this.cardListItemPositionHelper.a(r1);
    }

    public final void setContentColor(int r2) {
        ColorStateList r3 = ColorStateList.valueOf(r2);
        o.c(r3, "valueOf(color)");
        setContentColor(r3);
    }

    public final void setContentColor(ColorStateList r2) {
        o.e(r2, "color");
        setContentContainerBgColor(r2);
    }

    public final ColorStateList getContentColor() {
        return getContentContainerBgColor();
    }

    public final void setContentMarkColor(ColorStateList r1) {
        this.contentMarkContainerBgColor = r1;
        if (r1 != null) goto L6;
        setContentContainerBgColor(this.contentDefaultContainerBgColor);
        return;
    }

    public final void setContentChecked(boolean r4) {
        if (r4 == false) goto L9;
        this.contentContainer.setSelected(true);
        if (getContentContainerBgColor().isStateful() == true) goto L11;
        OStateGradientDrawable r5 = this.contentContainerBg;
        if (r5 == null) goto L13;
        r5.setColor(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_state_overlay_pressed, "color", "oui_state_overlay_pressed")));
        return;
    L13:
        return;
    L11:
        return;
    L9:
        this.contentContainer.setSelected(false);
    }

    public final void revertContentColor() {
        OStateGradientDrawable r0 = this.contentContainerBg;
        if (r0 == null) goto L7;
        r0.setSolidColors(getContentContainerBgColor());
        return;
    }

    public final void setShowCardBg(boolean r1) {
        this.showCardBg = r1;
        resetContentContainerCorner();
        this.cardListItemPositionHelper.a(this.showCardBg);
    }

    public final boolean getShowCardBg() {
        return this.showCardBg;
    }

    public final void setCardType(int r9) {
        this.currentType = r9;
        boolean r3 = true;
        if (r9 == 0) goto L10;
        if (r9 != 1) goto L6;
        this.contentContainer.setPaddingRelative(0, 0, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4), 0);
        this.contentContainer.setMinimumHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 60));
        this.titleContainer.setVisibility(0);
        FrameLayout r10 = this.customStartContainer;
        ViewGroup.LayoutParams r1 = r10.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r2.width = -2;
        r10.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        FrameLayout r11 = this.iconContainer;
        ViewGroup.LayoutParams r0 = r11.getLayoutParams();
        r0.width = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 60);
        r0.height = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 60);
        r11.setLayoutParams(r0);
        this.iconContainer.setPadding(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12));
    L11:
        resetIconCorner();
        if (this.divider.getVisibility() == 0) goto L15;
        r3 = false;
    L15:
        if (r3 == false) goto L18;
        updateDividerPosition();
        return;
    L18:
        return;
    L6:
        if (r9 != 2) goto L11;
        this.contentContainer.setPaddingRelative(0, 0, 0, 0);
        this.contentContainer.setMinimumHeight(0);
        this.titleContainer.setVisibility(8);
        FrameLayout r12 = this.customStartContainer;
        ViewGroup.LayoutParams r4 = r12.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r5.width = -1;
        r12.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        showCustomStart(true);
        goto L11
    L10:
        this.contentContainer.setPaddingRelative(0, 0, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4), 0);
        this.contentContainer.setMinimumHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 48));
        this.titleContainer.setVisibility(0);
        FrameLayout r13 = this.customStartContainer;
        ViewGroup.LayoutParams r6 = r13.getLayoutParams();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r7.width = -2;
        r13.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        FrameLayout r14 = this.iconContainer;
        ViewGroup.LayoutParams r8 = r14.getLayoutParams();
        r8.width = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 48);
        r8.height = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 48);
        r14.setLayoutParams(r8);
        this.iconContainer.setPadding(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 10), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 10), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 10), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 10));
        goto L11
    }

    public final void setTitleColor(int r1, int r2) {
        this.titleColor = r1;
        this.subTitleColor = r2;
        this.title.setTextColor(r1);
        this.subTitle.setTextColor(this.subTitleColor);
    }

    private final void resetIconCorner() {
        this.icon.setClipToOutline(true);
        this.icon.setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(new C11981(this), ViewOutlineProvider.class, "com.obric.aiagent.plugin"));
        this.icon.invalidateOutline();
    }

    public final int getCardType() {
        return this.currentType;
    }

    public static /* synthetic */ void setCardPosition$default(OCardListItem r0, int r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.setCardPosition(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCardPosition");
    }

    public final void setCardPosition(int r1, boolean r2) {
        this.currentPosition = r1;
        this.cardListItemPositionHelper.a(r1, r2);
    }

    public final int getCardPosition() {
        return this.currentPosition;
    }

    public final FrameLayout getCardRoot() {
        return this.root;
    }

    public final FrameLayout getCardContainer() {
        return (FrameLayout) ZeusTransformUtils.preCheckCast(this.cardContainer, FrameLayout.class, "com.obric.aiagent.plugin");
    }

    public final OUICardConstraintLayout getContentContainer() {
        return this.contentContainer;
    }

    public final void setCustomStartView(View r2) {
        this.customStartContainer.removeAllViews();
        if (r2 == null) goto L6;
        this.customStartContainer.addView(r2);
    L6:
        if (this.divider.getVisibility() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        updateDividerPosition();
        return;
    L12:
        return;
    L8:
        r3 = false;
        goto L9
    }

    public final void setCustomStartView(int r5) {
        this.customStartContainer.removeAllViews();
        if (r5 == 0) goto L6;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, (ViewGroup) ZeusTransformUtils.preCheckCast(this.customStartContainer, ViewGroup.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L12
    L6:
        if (this.divider.getVisibility() != 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L15;
        updateDividerPosition();
        return;
    L15:
        return;
    L8:
        r6 = false;
        goto L9
    }

    public final void setDefaultCustomStartView(int r3) {
        this.customStartContainer.removeAllViews();
        if (r3 != 0) goto L6;
        setCustomStartView(ZeusTransformUtils.mapRes(R.layout.o_card_list_item_custom_start_checkbox, "layout", "o_card_list_item_custom_start_checkbox"));
    L6:
        if (this.divider.getVisibility() != 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        updateDividerPosition();
        return;
    L12:
        return;
    L8:
        r4 = false;
        goto L9
    }

    public final View getCustomStartView() {
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.customStartContainer, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return null;
    L8:
        return this.customStartContainer.getChildAt(0);
    L5:
        r0 = false;
        goto L6
    }

    public final OCheckBoxLayout getStartCheckBox() {
        if (ZeusTransformUtils.instanceOf(getCustomStartView(), OCheckBoxLayout.class) == false) goto L6;
        View r2 = getCustomStartView();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
        return (OCheckBoxLayout) ZeusTransformUtils.preCheckCast(r2, OCheckBoxLayout.class, "com.obric.aiagent.plugin");
    L6:
        return null;
    }

    public final void showCustomStart(boolean r2) {
        FrameLayout r0 = this.customStartContainer;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        resetTitlePadding();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setIcon(Drawable r4) {
        boolean r1 = false;
        this.icon.setVisibility(0);
        OImageAppIcon r0 = this.appIcon;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        if (r4 == null) goto L8;
        this.icon.setImageDrawable(r4);
    L10:
        if (this.divider.getVisibility() != 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L15;
        updateDividerPosition();
        return;
    L15:
        return;
    L8:
        this.icon.setImageDrawable(null);
        goto L10
    }

    public final void setIcon(int r4) {
        boolean r1 = false;
        this.icon.setVisibility(0);
        OImageAppIcon r0 = this.appIcon;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        if (r4 == 0) goto L8;
        this.icon.setImageResource(r4);
    L10:
        if (this.divider.getVisibility() != 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L15;
        updateDividerPosition();
        return;
    L15:
        return;
    L8:
        this.icon.setImageDrawable(null);
        goto L10
    }

    public final void setAppIcon(Drawable r3) {
        this.icon.setVisibility(8);
        addAppIconIfNotExist();
        if (r3 == null) goto L8;
        OImageAppIcon r0 = this.appIcon;
        if (r0 == null) goto L13;
        r0.setImageDrawable(r3);
    L13:
        if (this.divider.getVisibility() != 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L19;
        updateDividerPosition();
        return;
    L19:
        return;
    L15:
        r4 = false;
        goto L16
    L8:
        OImageAppIcon r5 = this.appIcon;
        if (r5 == null) goto L13;
        r5.setImageDrawable(null);
        goto L13
    }

    public final void setAppIcon(int r3) {
        this.icon.setVisibility(8);
        addAppIconIfNotExist();
        if (r3 == 0) goto L8;
        OImageAppIcon r0 = this.appIcon;
        if (r0 == null) goto L13;
        r0.setImageResource(r3);
    L13:
        if (this.divider.getVisibility() != 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L19;
        updateDividerPosition();
        return;
    L19:
        return;
    L15:
        r4 = false;
        goto L16
    L8:
        OImageAppIcon r5 = this.appIcon;
        if (r5 == null) goto L13;
        r5.setImageDrawable(null);
        goto L13
    }

    private final void addAppIconIfNotExist() {
        OImageAppIcon r0 = (OImageAppIcon) ZeusTransformUtils.preCheckCast(this.iconContainer.findViewById(ZeusTransformUtils.mapRes(R.id.o_list_item_app_icon, DbHelper.COL_ID, "o_list_item_app_icon")), OImageAppIcon.class, "com.obric.aiagent.plugin");
        this.appIcon = r0;
        if (r0 != null) goto L5;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "context");
        OImageAppIcon r1 = new OImageAppIcon(r6, null, 0, 6, null);
        r1.setId(ZeusTransformUtils.mapRes(R.id.o_list_item_app_icon, DbHelper.COL_ID, "o_list_item_app_icon"));
        r1.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.appIcon = r1;
        this.iconContainer.addView((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (r0 == null) goto L10;
        r0.setVisibility(0);
        return;
    }

    public final ImageView getIconView() {
        return this.icon;
    }

    public final void showIcon(boolean r2) {
        FrameLayout r0 = this.iconContainer;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        resetTitlePadding();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.title.setText(r4);
    }

    public final CharSequence getTitle() {
        return this.title.getText();
    }

    public final OTextView getTitleView() {
        return this.title;
    }

    public final void showTitle(boolean r4) {
        CharSequence r0 = getTitle();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L16;
        OTextView r3 = this.title;
        if (r4 == true) goto L15;
        r1 = 8;
    L15:
        r3.setVisibility(r1);
        return;
    L16:
        this.title.setVisibility(8);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    private final void resetTitlePadding() {
        boolean r3 = true;
        if (((View) ZeusTransformUtils.preCheckCast(this.customStartContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() != 8) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        if (ZeusTransformUtils.instanceOf(getCustomStartView(), OCheckBoxLayout.class) == true) goto L10;
    L15:
        LinearLayout r1 = this.titleContainer;
        r1.setPadding(0, r1.getPaddingTop(), this.titleContainer.getPaddingRight(), this.titleContainer.getPaddingBottom());
    L17:
        if (this.divider.getVisibility() == 0) goto L20;
        r3 = false;
    L20:
        if (r3 == false) goto L22;
        updateDividerPosition();
    L22:
        requestLayout();
        return;
    L10:
        if (((View) ZeusTransformUtils.preCheckCast(this.iconContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() != 8) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        this.titleContainer.setPadding(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), this.titleContainer.getPaddingTop(), this.titleContainer.getPaddingRight(), this.titleContainer.getPaddingBottom());
        goto L17
    L12:
        r2 = false;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public final void setSubTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.subTitle.setText(r4);
    }

    public final CharSequence getSubTitle() {
        return this.subTitle.getText();
    }

    public final OTextView getSubTitleView() {
        return this.subTitle;
    }

    public final void showSubTitle(boolean r4) {
        CharSequence r0 = getSubTitle();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L16;
        OTextView r3 = this.subTitle;
        if (r4 == true) goto L15;
        r1 = 8;
    L15:
        r3.setVisibility(r1);
        return;
    L16:
        this.subTitle.setVisibility(8);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public final LinearLayout getTitleContainer() {
        return this.titleContainer;
    }

    public static /* synthetic */ void setCustomTitleView$default(OCardListItem r0, View r1, int r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        r0.setCustomTitleView(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCustomTitleView");
    }

    public final void setCustomTitleView(View r1, int r2, boolean r3) {
        if (r1 == null) goto L5;
        this.titleContainer.addView(r1, r2);
        return;
    }

    public static /* synthetic */ void setCustomTitleView$default(OCardListItem r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        r0.setCustomTitleView(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCustomTitleView");
    }

    public final void setCustomTitleView(int r11, int r12, boolean r13) {
        if (r11 != 0) goto L23;
        return;
    L23:
        int r3 = 0;
        setCustomTitleView$default(this, ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r11, (ViewGroup) ZeusTransformUtils.preCheckCast(this.titleContainer, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin"), r12, false, 4, null);     // Catch: Exception -> L22
        LinearLayout r10 = this.titleContainer;     // Catch: Exception -> L22
        ViewGroup.LayoutParams r14 = r10.getLayoutParams();     // Catch: Exception -> L22
        if (r14 == null) goto L20;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r14, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22
        if (r13 == false) goto L9;
        int r16 = 0;
    L10:
        r15.width = r16;     // Catch: Exception -> L22
        if (r13 == true) goto L13;
        boolean r1 = true;
    L14:
        r15.constrainedWidth = r1;     // Catch: Exception -> L22
        if (r13 == true) goto L18;
        r3 = 1;
    L18:
        r15.matchConstraintDefaultWidth = r3;     // Catch: Exception -> L22
        r10.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L22
        return;
    L13:
        r1 = false;
        goto L14
    L9:
        r16 = -2;
        goto L10
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");     // Catch: Exception -> L22
    }

    public static /* synthetic */ void setDefaultCustomTitleView$default(OCardListItem r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 4) == 0) goto L9;
        r3 = true;
        if (r1 == 1) goto L9;
        r3 = false;
    L9:
        r0.setDefaultCustomTitleView(r1, r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDefaultCustomTitleView");
    }

    public final void setDefaultCustomTitleView(int r6, int r7, boolean r8) {
        int r0 = this.customTitleMode;
        if (r0 != r6) goto L8;
        if (r0 != 1) goto L6;
        LinearLayout r5 = this.titleContainer;
        ViewGroup.LayoutParams r9 = r5.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r10.width = 0;
        r10.constrainedWidth = false;
        r10.matchConstraintDefaultWidth = 0;
        r5.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        LinearLayout r11 = this.titleContainer;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r12, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r13.width = -2;
        r13.constrainedWidth = true;
        r13.matchConstraintDefaultWidth = 1;
        r11.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        if (r0 < 0) goto L11;
        if (r0 == r6) goto L11;
        clearCustomTitleView();
    L11:
        this.customTitleMode = r6;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        this.customTitleMode = -1;
        clearCustomTitleView();
        LinearLayout r14 = this.titleContainer;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r16 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r15, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r16.width = -2;
        r16.constrainedWidth = true;
        r16.matchConstraintDefaultWidth = 1;
        r14.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r16, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        setCustomTitleView(ZeusTransformUtils.mapRes(R.layout.o_card_list_item_custom_title_detail, "layout", "o_card_list_item_custom_title_detail"), r7, r8);
        return;
    L16:
        setCustomTitleView(ZeusTransformUtils.mapRes(R.layout.o_card_list_item_custom_title_icon, "layout", "o_card_list_item_custom_title_icon"), r7, r8);
    }

    public final void clearCustomTitleView() {
        View r0 = this.titleContainer.findViewById(ZeusTransformUtils.mapRes(R.id.custom_title_container, DbHelper.COL_ID, "custom_title_container"));
        if (r0 == null) goto L7;
        this.titleContainer.removeView(r0);
        return;
    }

    public final View getCustomTitleView(int r4) {
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.titleContainer, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return null;
    L8:
        return this.titleContainer.getChildAt(r4);
    L5:
        r0 = false;
        goto L6
    }

    public final OTextView getCustomTitleText(int r4) {
        View r3 = getCustomTitleView(r4);
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == true) goto L5;
        return null;
    L5:
        return (OTextView) ZeusTransformUtils.preCheckCast(((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.custom_title_text, DbHelper.COL_ID, "custom_title_text")), OTextView.class, "com.obric.aiagent.plugin");
    }

    public final OTextView getCustomTitleDetail(int r4) {
        View r3 = getCustomTitleView(r4);
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == true) goto L5;
        return null;
    L5:
        return (OTextView) ZeusTransformUtils.preCheckCast(((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.custom_title_detail, DbHelper.COL_ID, "custom_title_detail")), OTextView.class, "com.obric.aiagent.plugin");
    }

    public final void setCustomEndView(View r4) {
        this.customEndContainer.removeAllViews();
        if (r4 != null) goto L6;
    L9:
        resetCustomEndDetail();
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4.getParent(), ViewGroup.class) == false) goto L8;
        ViewParent r0 = r4.getParent();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(r4);
    L8:
        this.customEndContainer.addView(r4);
        goto L9
    }

    public final void setCustomEndView(int r5) {
        this.customEndContainer.removeAllViews();
        if (r5 != 0) goto L8;
    L5:
        resetCustomEndDetail();
        return;
    L8:
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, (ViewGroup) ZeusTransformUtils.preCheckCast(this.customEndContainer, ViewGroup.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L7
        goto L5
    }

    public final void setDefaultCustomEndView(int r3) {
        this.customEndContainer.removeAllViews();
        if (r3 != 0) goto L5;
        setCustomEndView(ZeusTransformUtils.mapRes(R.layout.o_card_list_item_custom_end_checkbox, "layout", "o_card_list_item_custom_end_checkbox"));
        return;
    L5:
        if (r3 != 1) goto L7;
        setCustomEndView(ZeusTransformUtils.mapRes(R.layout.o_card_list_item_custom_end_switch, "layout", "o_card_list_item_custom_end_switch"));
        return;
    L7:
        if (r3 != 2) goto L9;
        setCustomEndView(ZeusTransformUtils.mapRes(R.layout.o_card_list_item_custom_end_mark, "layout", "o_card_list_item_custom_end_mark"));
        return;
    L9:
        if (r3 != 3) goto L11;
        setCustomEndView(ZeusTransformUtils.mapRes(R.layout.o_card_list_item_custom_end_detail, "layout", "o_card_list_item_custom_end_detail"));
        return;
    L11:
        if (r3 == 4) goto L13;
        setCustomEndView(null);
        return;
    L13:
        setCustomEndView(ZeusTransformUtils.mapRes(R.layout.o_card_list_item_custom_end_handle, "layout", "o_card_list_item_custom_end_handle"));
    }

    private final void resetCustomEndDetail() {
        boolean r1 = true;
        if (((View) ZeusTransformUtils.preCheckCast(this.customEndContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L41;
        View r2 = getCustomEndView();
        ViewGroup.LayoutParams r5 = this.customEndContainer.getLayoutParams();
        ViewGroup.MarginLayoutParams r7 = null;
        if (ZeusTransformUtils.instanceOf(r5, ConstraintLayout.LayoutParams.class) == false) goto L11;
        ConstraintLayout.LayoutParams r6 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L12:
        if (r2 == null) goto L18;
        if (ZeusTransformUtils.instanceOf(r2.getLayoutParams(), FrameLayout.LayoutParams.class) == false) goto L18;
        ViewGroup.LayoutParams r8 = r2.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r8, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin")).gravity = 8388613;
    L18:
        if (ZeusTransformUtils.instanceOf(r2, OTextView.class) == true) goto L20;
    L38:
        if (r6 == null) goto L45;
        r6.matchConstraintMaxWidth = -2;
        return;
    L45:
        return;
    L20:
        if (TextUtils.isEmpty(((OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin")).getText()) == true) goto L38;
        if (r6 == null) goto L24;
        r6.matchConstraintMaxWidth = this.maxTailTextWidth;
    L24:
        ViewGroup.LayoutParams r4 = ((OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.MarginLayoutParams.class) == false) goto L27;
        r7 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L27:
        if (r7 == null) goto L37;
        int r9 = r7.leftMargin;
        int r10 = r7.topMargin;
        if (((View) ZeusTransformUtils.preCheckCast(this.tailIcon, View.class, "com.obric.aiagent.plugin")).getVisibility() == 0) goto L33;
        r1 = false;
    L33:
        if (r1 == false) goto L35;
        int r11 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0);
    L36:
        r7.setMargins(r9, r10, r11, r7.bottomMargin);
        goto L37
    L35:
        r11 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 6);
    L37:
        ((OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin")).setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        r6 = null;
        goto L12
    L41:
        FrameLayout r12 = this.customEndContainer;
        ViewGroup.LayoutParams r3 = r12.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r13.matchConstraintMaxWidth = -2;
        r12.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final View getCustomEndView() {
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.customEndContainer, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return null;
    L8:
        return this.customEndContainer.getChildAt(0);
    L5:
        r0 = false;
        goto L6
    }

    public final OCheckBoxLayout getEndCheckBox() {
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OCheckBoxLayout.class) == false) goto L6;
        View r2 = getCustomEndView();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
        return (OCheckBoxLayout) ZeusTransformUtils.preCheckCast(r2, OCheckBoxLayout.class, "com.obric.aiagent.plugin");
    L6:
        return null;
    }

    public final OSwitch getEndSwitch() {
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OSwitch.class) == false) goto L6;
        View r2 = getCustomEndView();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.oswitch.OSwitch");
        return (OSwitch) ZeusTransformUtils.preCheckCast(r2, OSwitch.class, "com.obric.aiagent.plugin");
    L6:
        return null;
    }

    public final OCheckMark getEndMark() {
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OCheckMark.class) == false) goto L6;
        View r2 = getCustomEndView();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.checkbox.OCheckMark");
        return (OCheckMark) ZeusTransformUtils.preCheckCast(r2, OCheckMark.class, "com.obric.aiagent.plugin");
    L6:
        return null;
    }

    public final OTextView getEndDetail() {
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OTextView.class) == false) goto L6;
        View r2 = getCustomEndView();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin");
    L6:
        return null;
    }

    public static /* synthetic */ void setEndDetailText$default(OCardListItem r2, CharSequence r3, int r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r4 = -1;
    L7:
        r2.setEndDetailText(r7, r4);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEndDetailText");
    }

    public final void setEndDetailText(CharSequence r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 <= 0) goto L5;
        this.maxTailTextWidth = r5;
    L7:
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OTextView.class) == false) goto L9;
        View r7 = getCustomEndView();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        ((OTextView) ZeusTransformUtils.preCheckCast(r7, OTextView.class, "com.obric.aiagent.plugin")).setText(r6);
    L12:
        resetCustomEndDetail();
        return;
    L9:
        setDefaultCustomEndView(3);
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OTextView.class) == false) goto L12;
        View r8 = getCustomEndView();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        ((OTextView) ZeusTransformUtils.preCheckCast(r8, OTextView.class, "com.obric.aiagent.plugin")).setText(r6);
        goto L12
    L5:
        this.maxTailTextWidth = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP);
        goto L7
    }

    public final void showCustomEnd(boolean r2) {
        FrameLayout r0 = this.customEndContainer;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        resetCustomEndDetail();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setTailIcon(Drawable r1) {
        if (r1 == null) goto L5;
        this.tailIcon.setImageDrawable(r1);
        return;
    }

    public final void setTailIcon(int r1) {
        if (r1 == 0) goto L4;
        this.tailIcon.setImageResource(r1);
        return;
    L4:
        this.tailIcon.setImageDrawable(null);
    }

    public final void setDefaultTailIcon(int r4) {
        if (r4 != 0) goto L5;
        setTailIcon(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_card_list_item_tail_icon_arrow, "drawable", "o_card_list_item_tail_icon_arrow")));
        return;
    L5:
        if (r4 != 1) goto L11;
        setTailIcon(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_card_list_item_tail_icon_chevron, "drawable", "o_card_list_item_tail_icon_chevron")));
        return;
    }

    public final ImageView getTailIconView() {
        return this.tailIcon;
    }

    public final void showTailIcon(boolean r2) {
        ImageView r0 = this.tailIcon;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        resetCustomEndDetail();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void customDivider(int r1, int r2) {
        this.customDividerStart = r1;
        this.customDividerEnd = r2;
    }

    public final void showDivider(boolean r3) {
        View r0 = this.divider;
        if (r3 == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        if (r3 == false) goto L14;
        View r4 = this.divider;
        if (this.enableSwipeDivider == false) goto L11;
        float r2 = this.currentSwipeOffset;
    L12:
        r4.setTranslationX(r2);
        updateDividerPosition();
        return;
    L11:
        r2 = 0.0f;
        goto L12
    L14:
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public final void setEnableSwipeDivider(boolean r2) {
        this.enableSwipeDivider = r2;
        if (this.divider.getVisibility() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L13;
        View r4 = this.divider;
        if (this.enableSwipeDivider == false) goto L10;
        float r1 = this.currentSwipeOffset;
    L11:
        r4.setTranslationX(r1);
        return;
    L10:
        r1 = 0.0f;
        goto L11
    L13:
        return;
    L5:
        r3 = false;
        goto L6
    }

    private final void updateDividerPosition() {
        this.divider.post(new $$Lambda$OCardListItem$rOgupYxOd7hAmZabgnCvZANBZFs(this));
        requestLayout();
    }

    /* JADX INFO: renamed from: updateDividerPosition$lambda-17, reason: not valid java name */
    private static final void m1101updateDividerPosition$lambda17(OCardListItem r10) {
        o.e(r10, "this$0");
        int r0 = r10.customDividerStart;
        int r1 = r10.customDividerEnd;
        ViewGroup.MarginLayoutParams r3 = null;
        if (r0 == (-1)) goto L5;
        if (r1 == (-1)) goto L5;
    L42:
        ViewGroup.LayoutParams r2 = r10.divider.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.MarginLayoutParams.class) == false) goto L45;
        r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L45:
        if (r3 == null) goto L48;
        r3.setMargins(r0, r3.topMargin, r1, r3.bottomMargin);
    L48:
        r10.divider.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        ViewGroup.LayoutParams r4 = ((View) ZeusTransformUtils.preCheckCast(r10.cardContainer, View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.MarginLayoutParams.class) == true) goto L8;
        r4 = null;
    L8:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        boolean r6 = false;
        if (r5 == null) goto L11;
        int r7 = r5.leftMargin;
    L12:
        int r8 = r10.cardContainer.getPaddingLeft();
        ViewGroup.LayoutParams r9 = ((View) ZeusTransformUtils.preCheckCast(r10.cardContainer, View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r9, ViewGroup.MarginLayoutParams.class) == true) goto L15;
        r9 = null;
    L15:
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L18;
        int r12 = r11.rightMargin;
    L19:
        int r13 = r10.cardContainer.getPaddingRight();
        r0 = r7 + r8;
        if (((View) ZeusTransformUtils.preCheckCast(r10.customStartContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        r0 = r0 + r10.customStartContainer.getWidth();
    L26:
        if (((View) ZeusTransformUtils.preCheckCast(r10.iconContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L28;
        boolean r15 = true;
    L29:
        if (r15 == false) goto L32;
        r0 = r0 + r10.iconContainer.getWidth();
    L32:
        if (((View) ZeusTransformUtils.preCheckCast(r10.customStartContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() != 8) goto L34;
        boolean r16 = true;
    L35:
        if (r16 == true) goto L37;
    L41:
        r1 = g.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"), 8) + (r12 + r13);
        goto L42
    L37:
        if (((View) ZeusTransformUtils.preCheckCast(r10.iconContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() != 8) goto L39;
        r6 = true;
    L39:
        if (r6 == false) goto L41;
        r0 = r0 + r10.titleContainer.getPaddingLeft();
        goto L41
    L34:
        r16 = false;
        goto L35
    L28:
        r15 = false;
        goto L29
    L22:
        r14 = false;
        goto L23
    L18:
        r12 = 0;
        goto L19
    L11:
        r7 = 0;
        goto L12
    }

    public final void setEnableSwipe(boolean r2) {
        this.swipeLayout.setSwipeEnabled(r2);
        FrameLayout r1 = this.swipeContainer;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setSwipeView(View r2) {
        this.swipeContainer.removeAllViews();
        if (r2 == null) goto L6;
        this.swipeContainer.addView(r2);
        return;
    }

    public final void setSwipeView(int r4) {
        this.swipeContainer.removeAllViews();
        if (r4 == 0) goto L9;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, (ViewGroup) ZeusTransformUtils.preCheckCast(this.swipeContainer, ViewGroup.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final OSwipeLayout getSwipeLayout() {
        return this.swipeLayout;
    }

    public final View getSwipeView() {
        if (this.swipeContainer.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.swipeContainer.getChildAt(0);
    }

    public final void swipeOpen() {
        if (this.swipeLayout.isSwipeEnabled() == false) goto L6;
        this.swipeLayout.open();
        return;
    }

    public final void swipeClose() {
        if (this.swipeLayout.isSwipeEnabled() == false) goto L6;
        this.swipeLayout.close();
        return;
    }

    public final void swipeToggle() {
        if (this.swipeLayout.isSwipeEnabled() == false) goto L6;
        this.swipeLayout.toggle();
        return;
    }

    public final void setOnContentClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        this.contentContainer.setOnClickListener(r4);
        checkContentContainerListenerForBackground();
    }

    public final void setOnContentLongClickListener(View.OnLongClickListener r3) {
        View.OnLongClickListener r4 = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.aiagent.plugin");
        this.contentContainer.setOnLongClickListener(r4);
        checkContentContainerListenerForBackground();
    }

    @Override // android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        this.contentContainer.setEnabled(r4);
        this.customStartContainer.setEnabled(r4);
        this.iconContainer.setEnabled(r4);
        this.icon.setEnabled(r4);
        OImageAppIcon r0 = this.appIcon;
        if (r0 == null) goto L6;
        r0.setEnabled(r4);
    L6:
        this.titleContainer.setEnabled(r4);
        this.title.setEnabled(r4);
        this.subTitle.setEnabled(r4);
        this.customEndContainer.setEnabled(r4);
        this.tailIcon.setEnabled(r4);
        this.swipeLayout.setEnabled(r4);
        recursiveSetEnabled((View) ZeusTransformUtils.preCheckCast(this.customStartContainer, View.class, "com.obric.aiagent.plugin"), r4);
        recursiveSetEnabled((View) ZeusTransformUtils.preCheckCast(this.customEndContainer, View.class, "com.obric.aiagent.plugin"), r4);
        recursiveSetEnabled((View) ZeusTransformUtils.preCheckCast(this.swipeContainer, View.class, "com.obric.aiagent.plugin"), r4);
    }

    private final void recursiveSetEnabled(View r6, boolean r7) {
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L7;
        int r0 = 0;
        int r1 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount();
    L5:
        if (r0 >= r1) goto L9;
        int r3 = r0 + 1;
        View r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin")).getChildAt(r0);
        r2.setEnabled(r7);
        o.c(r2, "child");
        recursiveSetEnabled(r2, r7);
        r0 = r3;
        goto L5
    L9:
        return;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        this.maxTailTextWidth = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP);
    }
}
