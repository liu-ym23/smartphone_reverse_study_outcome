package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogConfirmView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "only for o demo")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u0014H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/dialog/alert/view/DialogConfirmView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkBox", "Lcom/obric/oui/checkbox/OCheckBox;", "clickContainer", "Landroid/view/ViewGroup;", "linkContainer", "Landroid/widget/RelativeLayout;", "tvLink", "Landroid/widget/TextView;", "tvNormal", "getCheckBox", "getLinkTextView", "getNormalTextView", "onAttachedToWindow", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogConfirmView extends ConstraintLayout {
    private final OCheckBox checkBox;
    private final ViewGroup clickContainer;
    private final RelativeLayout linkContainer;
    private final TextView tvLink;
    private final TextView tvNormal;

    /* JADX INFO: renamed from: $r8$lambda$BsXn_ZPWI6NkLD3Z4h-ZTakIuCE, reason: not valid java name */
    public static /* synthetic */ void m457$r8$lambda$BsXn_ZPWI6NkLD3Z4hZTakIuCE(DialogConfirmView r0, View r1) {
        m459onAttachedToWindow$lambda1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$SGfCbP9WVzDAKBw06y1vY_H4cMs(DialogConfirmView r0, View r1) {
        m458onAttachedToWindow$lambda0(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DialogConfirmView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ DialogConfirmView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public DialogConfirmView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        ConstraintLayout.inflate(r2, R.layout.o_layout_dialog_options, this);
        int r4 = OUnitExtensionKt.vdp(this, 5);
        setPadding(r4, r4, r4, 0);
        View r5 = findViewById(R.id.radio);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.radio)");
        this.checkBox = (OCheckBox) r5;
        View r6 = findViewById(R.id.tv_normal);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.tv_normal)");
        this.tvNormal = (TextView) r6;
        View r7 = findViewById(R.id.tv_link);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.tv_link)");
        this.tvLink = (TextView) r7;
        View r8 = findViewById(R.id.link_text_container);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.link_text_container)");
        this.linkContainer = (RelativeLayout) r8;
        View r9 = findViewById(R.id.click_container);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.click_container)");
        this.clickContainer = (ViewGroup) r9;
    }

    public final OCheckBox getCheckBox() {
        return this.checkBox;
    }

    public final TextView getNormalTextView() {
        return this.tvNormal;
    }

    public final TextView getLinkTextView() {
        return this.tvLink;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() != null) goto L5;
        return;
    L5:
        if ((getParent() instanceof ViewGroup) == false) goto L12;
        ViewParent r0 = getParent();
        if (r0 == null) goto L10;
        ViewGroup r1 = (ViewGroup) r0;
        this.linkContainer.setPadding(0, r1.getPaddingTop(), 0, r1.getPaddingBottom());
        this.linkContainer.setOnClickListener(new DialogConfirmView$$ExternalSyntheticLambda0(this));
        r1.setPadding(r1.getPaddingLeft(), 0, r1.getPaddingRight(), 0);
        this.clickContainer.setOnClickListener(new DialogConfirmView$$ExternalSyntheticLambda1(this));
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* JADX INFO: renamed from: onAttachedToWindow$lambda-0, reason: not valid java name */
    private static final void m458onAttachedToWindow$lambda0(DialogConfirmView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.tvLink.performClick();
    }

    /* JADX INFO: renamed from: onAttachedToWindow$lambda-1, reason: not valid java name */
    private static final void m459onAttachedToWindow$lambda1(DialogConfirmView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.getCheckBox().performClick();
    }
}
