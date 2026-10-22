package com.obric.oui.sectiontitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OSectionTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSectionTitleBar extends LinearLayout {
    private static final int CUSTOM_END_DETAIL = 0;
    public static final a Companion = null;
    private static final int TAIL_ICON_ARROW = 0;
    private LinearLayout container;
    private final FrameLayout customEndContainer;
    private final ImageView tailIcon;
    private TextView titleTextView;

    /* JADX INFO: compiled from: OSectionTitleBar.kt */
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

    public OSectionTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSectionTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OSectionTitleBar(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public static final /* synthetic */ int access$getCUSTOM_END_DETAIL$cp() {
        return CUSTOM_END_DETAIL;
    }

    public static final /* synthetic */ int access$getTAIL_ICON_ARROW$cp() {
        return TAIL_ICON_ARROW;
    }

    public OSectionTitleBar(Context r19, AttributeSet r20, int r21) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r20, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        super(r11, r13, r21);
        setOrientation(0);
        ZeusTransformUtils.inflate(LayoutInflater.from(r11), ZeusTransformUtils.mapRes(R.layout.o_section_title_bar, "layout", "o_section_title_bar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.container, DbHelper.COL_ID, "container"));
        o.c(r1, "findViewById(R.id.container)");
        this.container = (LinearLayout) ZeusTransformUtils.preCheckCast(r1, LinearLayout.class, "com.obric.aiagent.plugin");
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.titleTextView, DbHelper.COL_ID, "titleTextView"));
        o.c(r2, "findViewById(R.id.titleTextView)");
        this.titleTextView = (TextView) ZeusTransformUtils.preCheckCast(r2, TextView.class, "com.obric.aiagent.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.custom_end_container, DbHelper.COL_ID, "custom_end_container"));
        o.c(r3, "findViewById(R.id.custom_end_container)");
        this.customEndContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r3, FrameLayout.class, "com.obric.aiagent.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.tail_icon, DbHelper.COL_ID, "tail_icon"));
        o.c(r4, "findViewById(R.id.tail_icon)");
        this.tailIcon = (ImageView) ZeusTransformUtils.preCheckCast(r4, ImageView.class, "com.obric.aiagent.plugin");
        TypedArray r5 = r11.getTheme().obtainStyledAttributes(r13, R.styleable.SectionTitleBar, 0, 0);
        o.c(r5, "context.theme.obtainStyl…           0, 0\n        )");
    L32:
        th = move-exception;
        r5.recycle();
        throw th;
    L4:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_titleText, "styleable", "SectionTitleBar_sectionTitle_titleText")) == false) goto L7;
        setTitleText((CharSequence) ZeusTransformUtils.preCheckCast(r5.getString(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_titleText, "styleable", "SectionTitleBar_sectionTitle_titleText")), CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L32
    L7:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_titleStyle, "styleable", "SectionTitleBar_sectionTitle_titleStyle")) == false) goto L10;
        setTitleStyle(r5.getResourceId(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_titleStyle, "styleable", "SectionTitleBar_sectionTitle_titleStyle"), ZeusTransformUtils.mapRes(R.style.OSectionTitleBar_S, "style", "OSectionTitleBar_S")));     // Catch: Throwable -> L32
    L10:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_customEnd, "styleable", "SectionTitleBar_sectionTitle_customEnd")) == false) goto L13;
        setCustomEndView(r5.getResourceId(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_customEnd, "styleable", "SectionTitleBar_sectionTitle_customEnd"), 0));     // Catch: Throwable -> L32
    L13:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_defaultCustomEnd, "styleable", "SectionTitleBar_sectionTitle_defaultCustomEnd")) == false) goto L16;
        setDefaultCustomEndView(r5.getInt(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_defaultCustomEnd, "styleable", "SectionTitleBar_sectionTitle_defaultCustomEnd"), 0));     // Catch: Throwable -> L32
    L16:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_detailEndText, "styleable", "SectionTitleBar_sectionTitle_detailEndText")) == false) goto L19;
        setDetailEndText((CharSequence) ZeusTransformUtils.preCheckCast(r5.getString(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_detailEndText, "styleable", "SectionTitleBar_sectionTitle_detailEndText")), CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L32
    L19:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_showCustomEnd, "styleable", "SectionTitleBar_sectionTitle_showCustomEnd")) == false) goto L22;
        showCustomEnd(r5.getBoolean(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_showCustomEnd, "styleable", "SectionTitleBar_sectionTitle_showCustomEnd"), false));     // Catch: Throwable -> L32
    L22:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_tail, "styleable", "SectionTitleBar_sectionTitle_tail")) == false) goto L25;
        setTailIcon(r5.getResourceId(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_tail, "styleable", "SectionTitleBar_sectionTitle_tail"), 0));     // Catch: Throwable -> L32
    L25:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_defaultTail, "styleable", "SectionTitleBar_sectionTitle_defaultTail")) == false) goto L28;
        setDefaultTailIcon(r5.getInt(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_defaultTail, "styleable", "SectionTitleBar_sectionTitle_defaultTail"), 0));     // Catch: Throwable -> L32
    L28:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_showTail, "styleable", "SectionTitleBar_sectionTitle_showTail")) == false) goto L30;
        showTailIcon(r5.getBoolean(ZeusTransformUtils.mapRes(R.styleable.SectionTitleBar_sectionTitle_showTail, "styleable", "SectionTitleBar_sectionTitle_showTail"), false));     // Catch: Throwable -> L32
    L30:
        r5.recycle();
    }

    public final void setTitleText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.titleTextView.setText(r4);
    }

    public final void setTitleStyle(int r1) {
        this.titleTextView.setTextAppearance(r1);
    }

    public final void setTitleTextSize(float r1) {
        this.titleTextView.setTextSize(r1);
    }

    public final void setTitleTextColor(int r1) {
        this.titleTextView.setTextColor(r1);
    }

    public final void setCustomEndView(View r2) {
        this.customEndContainer.removeAllViews();
        if (r2 == null) goto L5;
        this.customEndContainer.addView(r2);
        return;
    L5:
        showCustomEnd(false);
    }

    public final void setCustomEndView(int r5) {
        this.customEndContainer.removeAllViews();
        if (r5 != 0) goto L9;
    L6:
        showCustomEnd(false);
        return;
    L9:
        LinearLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, (ViewGroup) ZeusTransformUtils.preCheckCast(this.customEndContainer, ViewGroup.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L8
    }

    public final void setDefaultCustomEndView(int r3) {
        this.customEndContainer.removeAllViews();
        if (r3 != CUSTOM_END_DETAIL) goto L5;
        setCustomEndView(ZeusTransformUtils.mapRes(R.layout.o_section_titlebar_custom_end_detail, "layout", "o_section_titlebar_custom_end_detail"));
        return;
    L5:
        showCustomEnd(false);
    }

    public final View getCustomEndView() {
        if (this.customEndContainer.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.customEndContainer.getChildAt(0);
    }

    public final OTextView getEndDetail() {
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OTextView.class) == false) goto L6;
        View r2 = getCustomEndView();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin");
    L6:
        return null;
    }

    public final void setDetailEndText(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        setDefaultCustomEndView(CUSTOM_END_DETAIL);
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OTextView.class) == false) goto L6;
        View r3 = getCustomEndView();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        ((OTextView) ZeusTransformUtils.preCheckCast(r3, OTextView.class, "com.obric.aiagent.plugin")).setText(r5);
        return;
    }

    public final void showCustomEnd(boolean r3) {
        int r1 = 8;
        if (this.customEndContainer.getChildCount() == 0) goto L8;
        FrameLayout r2 = this.customEndContainer;
        if (r3 == false) goto L7;
        r1 = 0;
    L7:
        r2.setVisibility(r1);
        return;
    L8:
        this.customEndContainer.setVisibility(8);
    }

    public final void setTailIcon(Drawable r1) {
        if (r1 == null) goto L4;
        this.tailIcon.setImageDrawable(r1);
        return;
    L4:
        showTailIcon(false);
    }

    public final void setTailIcon(int r2) {
        if (r2 == 0) goto L4;
        this.tailIcon.setImageResource(r2);
        return;
    L4:
        this.tailIcon.setImageDrawable(null);
        showTailIcon(false);
    }

    public final void setDefaultTailIcon(int r4) {
        if (r4 != TAIL_ICON_ARROW) goto L5;
        setTailIcon(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_section_titlebar_tail_icon_arrow, "drawable", "o_section_titlebar_tail_icon_arrow")));
        return;
    L5:
        showTailIcon(false);
    }

    public final void showTailIcon(boolean r3) {
        int r1 = 8;
        if (this.tailIcon.getDrawable() == null) goto L8;
        ImageView r2 = this.tailIcon;
        if (r3 == false) goto L7;
        r1 = 0;
    L7:
        r2.setVisibility(r1);
        return;
    L8:
        this.tailIcon.setVisibility(8);
    }
}
