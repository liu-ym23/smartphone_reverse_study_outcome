package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: OListItemSettings.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OListItemSettings extends OListItemGeneral {
    private int contentIconWidth;
    public OUIFrameLayout contentImgBackground;
    private com.obric.oui.lisitem.a heightMode;
    public FrameLayout mTitleInfo;
    private final ViewGroup rootLayout;
    private final SettingsTrailingView settingsTrailingView;
    private String trailingTextString;

    /* JADX INFO: compiled from: OListItemSettings.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35412a = null;

        static {
            int[] r0 = new int[com.obric.oui.lisitem.a.values().length];
            r0[com.obric.oui.lisitem.a.f35413a.ordinal()] = 1;
            r0[com.obric.oui.lisitem.a.f35414b.ordinal()] = 2;
            f35412a = r0;
        }
    }

    public /* synthetic */ OListItemSettings(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OListItemSettings(Context r10, AttributeSet r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        super(r12, r13);
        this.contentIconWidth = ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_listitem_content_width_large, "dimen", "oui_listitem_content_width_large"));
        this.heightMode = com.obric.oui.lisitem.a.f35413a;
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.ll_root, DbHelper.COL_ID, "ll_root"));
        o.c(r0, "findViewById(R.id.ll_root)");
        this.rootLayout = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin");
        this.settingsTrailingView = new SettingsTrailingView(r12, null, 0, 6, null);
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.title_info, DbHelper.COL_ID, "title_info"));
        o.c(r1, "findViewById(R.id.title_info)");
        setMTitleInfo((FrameLayout) ZeusTransformUtils.preCheckCast(r1, FrameLayout.class, "com.obric.aiagent.plugin"));
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_content_img_background, DbHelper.COL_ID, "iv_content_img_background"));
        o.c(r2, "findViewById(R.id.iv_content_img_background)");
        setContentImgBackground((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r2, OUIFrameLayout.class, "com.obric.aiagent.plugin"));
        TypedArray r14 = r12.obtainStyledAttributes(r13, R.styleable.OListItemGeneral);
        setTrailingTextString(r14.getString(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_trailing_text, "styleable", "OListItemGeneral_oui_list_item_trailing_text")));
        r14.recycle();
        if (getContentImage() == null) goto L6;
        getContentImgBackground().setVisibility(0);
        return;
    }

    public final SettingsTrailingView getSettingsTrailingView() {
        return this.settingsTrailingView;
    }

    public final FrameLayout getMTitleInfo() {
        FrameLayout r0 = this.mTitleInfo;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mTitleInfo");
        return null;
    }

    public final void setMTitleInfo(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.mTitleInfo = r2;
    }

    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r0 = this.contentImgBackground;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("contentImgBackground");
        return null;
    }

    public final void setContentImgBackground(OUIFrameLayout r2) {
        o.e(r2, "<set-?>");
        this.contentImgBackground = r2;
    }

    public final String getTrailingTextString() {
        return this.trailingTextString;
    }

    public final void setTrailingTextString(String r3) {
        this.trailingTextString = r3;
        updateState();
        String r4 = this.trailingTextString;
        if (r4 == null) goto L6;
        setTrailingText(r4);
    L6:
        setTrailingView((View) ZeusTransformUtils.preCheckCast(this.settingsTrailingView, View.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void inflateContent() {
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_listitem_settings, "layout", "o_listitem_settings"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public final void setTrailingText(String r2) {
        o.e(r2, "text");
        this.settingsTrailingView.setTrailingText(r2);
    }

    public final void setTrailingViewMinWidth(int r4) {
        ViewGroup.LayoutParams r0 = getMTrailingElement().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ConstraintLayout.LayoutParams.class) == false) goto L6;
        FrameLayout r3 = getMTrailingElement();
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin")).matchConstraintMinWidth = r4;
        r3.setLayoutParams(r0);
        return;
    }

    public final void setImageView(Drawable r1) {
        this.settingsTrailingView.setTrailingImage(r1);
    }

    public final void showTrailingImageView(Drawable r3) {
        if (r3 != null) goto L4;
        this.settingsTrailingView.showTrailingImageView(false);
        return;
    L4:
        this.settingsTrailingView.showTrailingImageView(true);
        this.settingsTrailingView.setTrailingImage(r3);
    }

    public static /* synthetic */ void setTrailingTextMaxLines$default(OListItemSettings r0, int r1, TextUtils.TruncateAt r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = TextUtils.TruncateAt.END;
    L6:
        r0.setTrailingTextMaxLines(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTrailingTextMaxLines");
    }

    public final void setTrailingTextMaxLines(int r2, TextUtils.TruncateAt r3) {
        o.e(r3, "ellipsize");
        this.settingsTrailingView.getTextView().setMaxLines(r2);
        this.settingsTrailingView.getTextView().setEllipsize(r3);
    }

    public final void setListItemSettingsEnabled(boolean r2) {
        setChangeAlphaWhenDisable(false);
        setEnabled(r2);
        if (r2 == false) goto L5;
        getMLeadingElement().setAlpha(1.0f);
        getMClContent().setAlpha(1.0f);
        getMContentElement().setAlpha(1.0f);
        return;
    L5:
        getMLeadingElement().setAlpha(0.3f);
        getMClContent().setAlpha(0.3f);
        getMContentElement().setAlpha(0.3f);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return this.contentIconWidth;
    }

    public final void setListItemHeightMode(com.obric.oui.lisitem.a r7) {
        o.e(r7, "mode");
        if (this.heightMode != r7) goto L5;
        return;
    L5:
        int r0 = a.f35412a[r7.ordinal()];
        if (r0 != 1) goto L8;
        int r1 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_listitem_content_width_large, "dimen", "oui_listitem_content_width_large"));
    L13:
        this.rootLayout.setMinimumHeight(r1);
        getMClContent().setMinimumHeight(r1);
        getMClContent().setMinHeight(r1);
        ViewGroup.LayoutParams r2 = getMTrailingElement().getLayoutParams();
        if (r2 != null) goto L17;
    L21:
        this.contentIconWidth = r1;
        updateState();
        this.heightMode = r7;
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r2, ConstraintLayout.LayoutParams.class) == false) goto L21;
        int r3 = (r1 - getMClContent().getPaddingTop()) - getMClContent().getPaddingBottom();
        if (r3 >= ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin")).matchConstraintMinHeight) goto L21;
        FrameLayout r4 = getMTrailingElement();
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin")).matchConstraintMinHeight = r3;
        r4.setLayoutParams(r2);
        goto L21
    L8:
        if (r0 != 2) goto L11;
        r1 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_listitem_content_width_middle, "dimen", "oui_listitem_content_width_middle"));
        goto L13
    L11:
        throw new k();
    }
}
