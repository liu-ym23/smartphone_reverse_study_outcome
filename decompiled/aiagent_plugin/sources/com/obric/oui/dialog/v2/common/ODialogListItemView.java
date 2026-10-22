package com.obric.oui.dialog.v2.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;

/* JADX INFO: compiled from: ODialogListItemView.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ODialogListItemView extends OUIFrameLayout {
    private boolean isShowDivider;
    public FrameLayout leadingContainer;
    private final f lineColor$delegate;
    private final f lineHeight$delegate;
    public OUILinearLayout listItemRoot;
    public TextView subtitleView;
    public TextView titleView;
    public FrameLayout trailingContainer;

    /* JADX INFO: compiled from: ODialogListItemView.kt */
    static final class a extends p implements d.h.a.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35150a;

        a(Context r3) {
            this.f35150a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(ZeusTransformUtils.getResources(this.f35150a, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_line_1, "color", "oui_basic_line_1"), null));
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ODialogListItemView.kt */
    static final class b extends p implements d.h.a.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ODialogListItemView f35151a;

        b(ODialogListItemView r1) {
            this.f35151a = r1;
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(g.a((View) ZeusTransformUtils.preCheckCast(this.f35151a, View.class, "com.obric.aiagent.plugin"), 0.6d));
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: View.kt */
    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f35152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ODialogListItemView f35153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f35154c;

        public c(View r1, ODialogListItemView r2, boolean r3) {
            this.f35152a = r1;
            this.f35153b = r2;
            this.f35154c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ODialogListItemView.access$updateBottomDividerInternal(this.f35153b, this.f35154c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ODialogListItemView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.b
    public boolean shouldUpdateDividerColorOnPress() {
        return true;
    }

    public /* synthetic */ ODialogListItemView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ void access$updateBottomDividerInternal(ODialogListItemView r0, boolean r1) {
        r0.updateBottomDividerInternal(r1);
    }

    public ODialogListItemView(Context r10, AttributeSet r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        super(r12, r4, 0, null, 12, null);
        this.lineColor$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r12), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.lineHeight$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        init(r12);
    }

    public final OUILinearLayout getListItemRoot() {
        OUILinearLayout r0 = this.listItemRoot;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("listItemRoot");
        return null;
    }

    public final void setListItemRoot(OUILinearLayout r2) {
        o.e(r2, "<set-?>");
        this.listItemRoot = r2;
    }

    public final FrameLayout getLeadingContainer() {
        FrameLayout r0 = this.leadingContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("leadingContainer");
        return null;
    }

    public final void setLeadingContainer(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.leadingContainer = r2;
    }

    public final FrameLayout getTrailingContainer() {
        FrameLayout r0 = this.trailingContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("trailingContainer");
        return null;
    }

    public final void setTrailingContainer(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.trailingContainer = r2;
    }

    public final TextView getTitleView() {
        TextView r0 = this.titleView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("titleView");
        return null;
    }

    public final void setTitleView(TextView r2) {
        o.e(r2, "<set-?>");
        this.titleView = r2;
    }

    public final TextView getSubtitleView() {
        TextView r0 = this.subtitleView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("subtitleView");
        return null;
    }

    public final void setSubtitleView(TextView r2) {
        o.e(r2, "<set-?>");
        this.subtitleView = r2;
    }

    private final int getLineColor() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.lineColor$delegate.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    private final int getLineHeight() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.lineHeight$delegate.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    private final void init(Context r6) {
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_dialog_listitem_view, "layout", "o_dialog_listitem_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.list_item_root, DbHelper.COL_ID, "list_item_root"));
        o.c(r7, "findViewById(R.id.list_item_root)");
        setListItemRoot((OUILinearLayout) ZeusTransformUtils.preCheckCast(r7, OUILinearLayout.class, "com.obric.aiagent.plugin"));
        OUILinearLayout r8 = getListItemRoot();
        r8.setRadius(g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 12));
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -1);
        r2.topMargin = g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 2);
        r2.bottomMargin = g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 2);
        r8.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r8.setChangeAlphaWhenPress(true);
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.list_item_title, DbHelper.COL_ID, "list_item_title"));
        o.c(r9, "findViewById(R.id.list_item_title)");
        setTitleView((TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.aiagent.plugin"));
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.list_item_subtitle, DbHelper.COL_ID, "list_item_subtitle"));
        o.c(r10, "findViewById(R.id.list_item_subtitle)");
        setSubtitleView((TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.aiagent.plugin"));
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.list_leading_element, DbHelper.COL_ID, "list_leading_element"));
        o.c(r11, "findViewById(R.id.list_leading_element)");
        setLeadingContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r11, FrameLayout.class, "com.obric.aiagent.plugin"));
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.list_trailing_element, DbHelper.COL_ID, "list_trailing_element"));
        o.c(r12, "findViewById(R.id.list_trailing_element)");
        setTrailingContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.aiagent.plugin"));
        setChangeAlphaWhenPress(false);
        setChangeAlphaWhenDisable(false);
    }

    public final void showDivider(boolean r4) {
        this.isShowDivider = r4;
        getLeadingContainer().measure(0, 0);
        View r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        o.c(OneShotPreDrawListener.add(r0, (Runnable) ZeusTransformUtils.preCheckCast(new c(r0, this, r4), Runnable.class, "com.obric.aiagent.plugin")), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        updateText(getTitleView(), r4);
    }

    public final void setSubtitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        updateText(getSubtitleView(), r4);
    }

    public final void setLeadingView(View r5, FrameLayout.LayoutParams r6) {
        o.e(r5, "view");
        o.e(r6, "layoutParams");
        setChildToParent((ViewGroup) ZeusTransformUtils.preCheckCast(getLeadingContainer(), ViewGroup.class, "com.obric.aiagent.plugin"), r5, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        getListItemRoot().setPadding(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        getLeadingContainer().measure(0, 0);
        updateBottomDividerInternal(this.isShowDivider);
    }

    public final void setTrailingView(View r5) {
        o.e(r5, "view");
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 17;
        setChildToParent((ViewGroup) ZeusTransformUtils.preCheckCast(getTrailingContainer(), ViewGroup.class, "com.obric.aiagent.plugin"), r5, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    }

    public final void setTrailingView(View r4, ViewGroup.LayoutParams r5) {
        o.e(r4, "view");
        o.e(r5, "layoutParams");
        setChildToParent((ViewGroup) ZeusTransformUtils.preCheckCast(getTrailingContainer(), ViewGroup.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    private final void updateText(TextView r2, CharSequence r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        k.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        r2.setText(r1);
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    static /* synthetic */ void setChildToParent$default(ODialogListItemView r0, ViewGroup r1, View r2, ViewGroup.LayoutParams r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.setChildToParent(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setChildToParent");
    }

    private final void setChildToParent(ViewGroup r2, View r3, ViewGroup.LayoutParams r4) {
        if (r3 == null) goto L17;
        if (r2 == null) goto L7;
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
    L7:
        if (r2 == null) goto L10;
        r2.removeAllViews();
    L10:
        if (r4 != null) goto L14;
        if (r2 == null) goto L23;
        r2.addView(r3);
        return;
    L23:
        return;
    L14:
        if (r2 == null) goto L24;
        r2.addView(r3, r4);
        return;
    L24:
        return;
    L17:
        if (r2 == null) goto L25;
        k.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void addChildToParent(ViewGroup r2, View r3) {
        if (r3 == null) goto L10;
        if (r2 == null) goto L7;
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
    L7:
        if (r2 == null) goto L15;
        r2.addView(r3);
        return;
    L15:
        return;
    L10:
        if (r2 == null) goto L16;
        k.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void setTrailingImageView(Drawable r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        ImageView r0 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r0.setImageDrawable(r5);
        setTrailingView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        o.e(r2, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r2);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        getListItemRoot().setEnabled(r1);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r4) {
        super.setSelected(r4);
        getListItemRoot().getAlphaHelper().onSelectedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
    }

    private final void updateBottomDividerInternal(boolean r4) {
        if (r4 == false) goto L5;
        updateBottomDivider(getListItemRoot().getPaddingLeft() + getLeadingContainer().getMeasuredWidth(), 0, getLineHeight(), getLineColor());
        return;
    L5:
        updateBottomDivider(getListItemRoot().getPaddingLeft(), 0, 0, getLineColor());
    }
}
