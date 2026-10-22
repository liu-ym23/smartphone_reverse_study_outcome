package com.obric.oui.paneltitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: OPanelTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OPanelTitleBar extends ConstraintLayout {
    public static final a Companion = null;
    public static final int DISPLAY = 0;
    public static final int REGULAR = 1;
    private String info;
    private boolean showExpandIcon;
    private boolean showInfo;
    private boolean showInfoIcon;
    private String title;
    private int type;
    private FrameLayout vActionContainer;
    private View vActionView;
    private ImageView vExpandIcon;
    private ImageView vInfoIcon;
    private OTextView vInfoText;
    private OTextView vTitleText;

    /* JADX INFO: compiled from: OPanelTitleBar.kt */
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

    public OPanelTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPanelTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OPanelTitleBar(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OPanelTitleBar(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        super(r8, r9, r7);
        boolean r0 = true;
        this.type = 1;
        TypedArray r10 = r8.getTheme().obtainStyledAttributes(r9, R.styleable.OPanelTitleBar, r7, 0);
        this.type = r10.getInt(ZeusTransformUtils.mapRes(R.styleable.OPanelTitleBar_oui_panel_type, "styleable", "OPanelTitleBar_oui_panel_type"), 1);
        this.showInfo = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OPanelTitleBar_oui_panel_show_info, "styleable", "OPanelTitleBar_oui_panel_show_info"), true);
        this.showInfoIcon = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OPanelTitleBar_oui_panel_show_info_icon, "styleable", "OPanelTitleBar_oui_panel_show_info_icon"), false);
        this.showExpandIcon = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OPanelTitleBar_oui_panel_show_expand_icon, "styleable", "OPanelTitleBar_oui_panel_show_expand_icon"), false);
        this.title = r10.getString(ZeusTransformUtils.mapRes(R.styleable.OPanelTitleBar_oui_panel_title, "styleable", "OPanelTitleBar_oui_panel_title"));
        this.info = r10.getString(ZeusTransformUtils.mapRes(R.styleable.OPanelTitleBar_oui_panel_info, "styleable", "OPanelTitleBar_oui_panel_info"));
        r10.recycle();
        inflate(this.type);
        setTitle(this.title);
        setInfo(this.info);
        if (this.showInfo == false) goto L13;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(this.info, CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L7;
    L10:
        boolean r12 = true;
    L11:
        if (r12 == true) goto L13;
    L14:
        showInfo(r0);
        showExpandIcon(this.showExpandIcon);
        showInfoIcon(this.showInfoIcon);
        return;
    L7:
        if (r11.length() == 0) goto L10;
        r12 = false;
    L13:
        r0 = false;
        goto L14
    }

    public final void setType(int r2) {
        if (r2 == 0) goto L6;
        if (r2 == 1) goto L6;
        return;
    L6:
        if (r2 == this.type) goto L13;
        this.type = r2;
        inflate(r2);
        setTitle(this.title);
        setInfo(this.info);
        showInfo(this.showInfo);
        showExpandIcon(this.showExpandIcon);
        showInfoIcon(this.showInfoIcon);
        View r3 = this.vActionView;
        if (r3 == null) goto L14;
        setActionView(r3);
        return;
    L14:
        return;
    }

    public final void setTitle(String r3) {
        this.title = r3;
        OTextView r2 = this.vTitleText;
        if (r2 == null) goto L7;
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void setInfo(String r3) {
        this.info = r3;
        OTextView r2 = this.vInfoText;
        if (r2 == null) goto L7;
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void showInfoIcon(boolean r3) {
        this.showInfoIcon = r3;
        ImageView r2 = this.vInfoIcon;
        if (r2 == null) goto L7;
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), r3);
        return;
    }

    public final void showInfo(boolean r3) {
        this.showInfo = r3;
        OTextView r2 = this.vInfoText;
        if (r2 == null) goto L7;
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), r3);
        return;
    }

    public final void showExpandIcon(boolean r3) {
        this.showExpandIcon = r3;
        ImageView r2 = this.vExpandIcon;
        if (r2 == null) goto L7;
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), r3);
        return;
    }

    public final void setActionView(View r4) {
        this.vActionView = r4;
        FrameLayout r0 = this.vActionContainer;
        if (r0 == null) goto L6;
        r0.removeAllViews();
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        FrameLayout r3 = this.vActionContainer;
        if (r3 == null) goto L13;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 21;
        x r2 = x.f38692a;
        r3.addView(r4, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void inflate(int r9) {
        if (r9 != 0) goto L5;
        setPadding(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 14), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8));
        int r10 = ZeusTransformUtils.mapRes(R.layout.o_panel_title_bar_display, "layout", "o_panel_title_bar_display");
    L9:
        removeAllViews();
        View r11 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r10, (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        this.vTitleText = (OTextView) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.panel_title, DbHelper.COL_ID, "panel_title")), OTextView.class, "com.obric.aiagent.plugin");
        this.vInfoText = (OTextView) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.panel_info, DbHelper.COL_ID, "panel_info")), OTextView.class, "com.obric.aiagent.plugin");
        this.vExpandIcon = (ImageView) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.panel_expand_icon, DbHelper.COL_ID, "panel_expand_icon")), ImageView.class, "com.obric.aiagent.plugin");
        this.vInfoIcon = (ImageView) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.panel_info_icon, DbHelper.COL_ID, "panel_info_icon")), ImageView.class, "com.obric.aiagent.plugin");
        this.vActionContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.panel_action_container, DbHelper.COL_ID, "panel_action_container")), FrameLayout.class, "com.obric.aiagent.plugin");
        return;
    L5:
        if (r9 == 1) goto L7;
        setPadding(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12));
        r10 = ZeusTransformUtils.mapRes(R.layout.o_panel_title_bar_regular, "layout", "o_panel_title_bar_regular");
        goto L9
    L7:
        setPadding(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12));
        r10 = ZeusTransformUtils.mapRes(R.layout.o_panel_title_bar_regular, "layout", "o_panel_title_bar_regular");
        goto L9
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
