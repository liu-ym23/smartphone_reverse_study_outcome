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
import com.obric.common.oui.R;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.utils.KtExt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ODialogListItemView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/J\u0010\u00100\u001a\u00020\b2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J(\u00104\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0002J\u0016\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020/2\u0006\u00105\u001a\u000209J\u0010\u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020\bH\u0016J\u0010\u0010<\u001a\u00020+2\b\u0010=\u001a\u0004\u0018\u00010>J\u0010\u0010?\u001a\u00020+2\b\u0010=\u001a\u0004\u0018\u00010>J\u0010\u0010@\u001a\u00020+2\b\u0010A\u001a\u0004\u0018\u00010BJ\u000e\u0010C\u001a\u00020+2\u0006\u00108\u001a\u00020/J\u0016\u0010C\u001a\u00020+2\u0006\u00108\u001a\u00020/2\u0006\u00105\u001a\u000206J\b\u0010D\u001a\u00020\bH\u0016J\u000e\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020\bJ\u0010\u0010G\u001a\u00020+2\u0006\u0010F\u001a\u00020\bH\u0002J\u0016\u0010H\u001a\u00020+*\u00020\u001f2\b\u0010I\u001a\u0004\u0018\u00010>H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001a\u0010'\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000e¨\u0006J"}, d2 = {"Lcom/obric/oui/dialog/v2/common/ODialogListItemView;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isShowDivider", "", "leadingContainer", "Landroid/widget/FrameLayout;", "getLeadingContainer", "()Landroid/widget/FrameLayout;", "setLeadingContainer", "(Landroid/widget/FrameLayout;)V", "lineColor", "", "getLineColor", "()I", "lineColor$delegate", "Lkotlin/Lazy;", "lineHeight", "getLineHeight", "lineHeight$delegate", "listItemRoot", "Lcom/obric/oui/layout/OUILinearLayout;", "getListItemRoot", "()Lcom/obric/oui/layout/OUILinearLayout;", "setListItemRoot", "(Lcom/obric/oui/layout/OUILinearLayout;)V", "subtitleView", "Landroid/widget/TextView;", "getSubtitleView", "()Landroid/widget/TextView;", "setSubtitleView", "(Landroid/widget/TextView;)V", "titleView", "getTitleView", "setTitleView", "trailingContainer", "getTrailingContainer", "setTrailingContainer", "addChildToParent", "", "parent", "Landroid/view/ViewGroup;", "child", "Landroid/view/View;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "init", "setChildToParent", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "setLeadingView", "view", "Landroid/widget/FrameLayout$LayoutParams;", "setSelected", "selected", "setSubtitle", "str", "", "setTitle", "setTrailingImageView", "drawable", "Landroid/graphics/drawable/Drawable;", "setTrailingView", "shouldUpdateDividerColorOnPress", "showDivider", "show", "updateBottomDividerInternal", "updateText", "text", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ODialogListItemView extends OUIFrameLayout {
    private boolean isShowDivider;
    public FrameLayout leadingContainer;
    private final Lazy lineColor$delegate;
    private final Lazy lineHeight$delegate;
    public OUILinearLayout listItemRoot;
    public TextView subtitleView;
    public TextView titleView;
    public FrameLayout trailingContainer;

    /* JADX WARN: Multi-variable type inference failed */
    public ODialogListItemView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.IOUILayout
    public boolean shouldUpdateDividerColorOnPress() {
        return true;
    }

    public /* synthetic */ ODialogListItemView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ void access$updateBottomDividerInternal(ODialogListItemView r0, boolean r1) {
        r0.updateBottomDividerInternal(r1);
    }

    public ODialogListItemView(final Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, 0, null, 12, null);
        this.lineColor$delegate = LazyKt.lazy(new ODialogListItemView$lineColor$2(r9));
        this.lineHeight$delegate = LazyKt.lazy(new ODialogListItemView$lineHeight$2(this));
        init(r9);
    }

    public final OUILinearLayout getListItemRoot() {
        OUILinearLayout r0 = this.listItemRoot;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("listItemRoot");
        return null;
    }

    public final void setListItemRoot(OUILinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.listItemRoot = r2;
    }

    public final FrameLayout getLeadingContainer() {
        FrameLayout r0 = this.leadingContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("leadingContainer");
        return null;
    }

    public final void setLeadingContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.leadingContainer = r2;
    }

    public final FrameLayout getTrailingContainer() {
        FrameLayout r0 = this.trailingContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("trailingContainer");
        return null;
    }

    public final void setTrailingContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.trailingContainer = r2;
    }

    public final TextView getTitleView() {
        TextView r0 = this.titleView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        return null;
    }

    public final void setTitleView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.titleView = r2;
    }

    public final TextView getSubtitleView() {
        TextView r0 = this.subtitleView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
        return null;
    }

    public final void setSubtitleView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.subtitleView = r2;
    }

    private final int getLineColor() {
        return ((Number) this.lineColor$delegate.getValue()).intValue();
    }

    private final int getLineHeight() {
        return ((Number) this.lineHeight$delegate.getValue()).intValue();
    }

    private final void init(Context r3) {
        LayoutInflater.from(r3).inflate(R.layout.o_dialog_listitem_view, this);
        View r4 = findViewById(R.id.list_item_root);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.list_item_root)");
        setListItemRoot((OUILinearLayout) r4);
        KtExt r5 = KtExt.INSTANCE;
        OUILinearLayout r6 = getListItemRoot();
        if (r6 != null) goto L6;
    L4:
        r6 = null;
    L7:
        OUILinearLayout r7 = r6;
        if (r7 == null) goto L11;
        r7.setChangeAlphaWhenPress(false);
    L11:
        View r8 = findViewById(R.id.list_item_title);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.list_item_title)");
        setTitleView((TextView) r8);
        View r9 = findViewById(R.id.list_item_subtitle);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.list_item_subtitle)");
        setSubtitleView((TextView) r9);
        View r10 = findViewById(R.id.list_leading_element);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.list_leading_element)");
        setLeadingContainer((FrameLayout) r10);
        View r11 = findViewById(R.id.list_trailing_element);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.list_trailing_element)");
        setTrailingContainer((FrameLayout) r11);
        setRadius(OUnitExtensionKt.vdp(this, 12));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if ((r6 instanceof IOUIAlpha) == false) goto L4;
        goto L4
    }

    public final void showDivider(final boolean r3) {
        this.isShowDivider = r3;
        getLeadingContainer().measure(0, 0);
        final ODialogListItemView r0 = this;
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(r0, new ODialogListItemView$showDivider$$inlined$doOnPreDraw$1(r0, this, r3)), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    public final void setTitle(CharSequence r2) {
        updateText(getTitleView(), r2);
    }

    public final void setSubtitle(CharSequence r2) {
        updateText(getSubtitleView(), r2);
    }

    public final void setLeadingView(View r5, FrameLayout.LayoutParams r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "layoutParams");
        setChildToParent(getLeadingContainer(), r5, r6);
        getListItemRoot().setPadding(OUnitExtensionKt.vdp(this, 0), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        getLeadingContainer().measure(0, 0);
        updateBottomDividerInternal(this.isShowDivider);
    }

    public final void setTrailingView(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 17;
        setChildToParent(getTrailingContainer(), r3, r0);
    }

    public final void setTrailingView(View r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "layoutParams");
        setChildToParent(getTrailingContainer(), r2, r3);
    }

    private final void updateText(TextView r1, CharSequence r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        ViewExtensionsKt.makeGone(r1);
        return;
    L10:
        r1.setText(r2);
        ViewExtensionsKt.makeVisible(r1);
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
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

    private final void setChildToParent(ViewGroup r1, View r2, ViewGroup.LayoutParams r3) {
        if (r2 == null) goto L16;
        if (r1 == null) goto L6;
        ViewExtensionsKt.makeVisible(r1);
    L6:
        if (r1 == null) goto L9;
        r1.removeAllViews();
    L9:
        if (r3 != null) goto L13;
        if (r1 == null) goto L22;
        r1.addView(r2);
        return;
    L22:
        return;
    L13:
        if (r1 == null) goto L23;
        r1.addView(r2, r3);
        return;
    L23:
        return;
    L16:
        if (r1 == null) goto L24;
        ViewExtensionsKt.makeGone(r1);
        return;
    }

    public final void addChildToParent(ViewGroup r1, View r2) {
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        ViewExtensionsKt.makeVisible(r1);
    L6:
        if (r1 == null) goto L14;
        r1.addView(r2);
        return;
    L14:
        return;
    L9:
        if (r1 == null) goto L15;
        ViewExtensionsKt.makeGone(r1);
        return;
    }

    public final void setTrailingImageView(Drawable r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ImageView r0 = new ImageView(getContext());
        r0.setImageDrawable(r3);
        setTrailingView(r0);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r2);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        getAlphaHelper().onSelectedChanged(this, r2);
    }

    private final void updateBottomDividerInternal(boolean r4) {
        if (r4 == false) goto L5;
        updateBottomDivider(getListItemRoot().getPaddingLeft() + getLeadingContainer().getMeasuredWidth(), 0, getLineHeight(), getLineColor());
        return;
    L5:
        updateBottomDivider(getListItemRoot().getPaddingLeft(), 0, 0, getLineColor());
    }
}
