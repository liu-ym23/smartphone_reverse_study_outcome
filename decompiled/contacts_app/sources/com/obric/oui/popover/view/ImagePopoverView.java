package com.obric.oui.popover.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePopoverView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/popover/view/ImagePopoverView;", "Lcom/obric/oui/popover/view/LinkPopoverView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setImageClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setLeftIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "", "setShowArrow", "show", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImagePopoverView extends LinkPopoverView {
    /* JADX WARN: Multi-variable type inference failed */
    public ImagePopoverView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ImagePopoverView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public ImagePopoverView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        ImageView r6 = getIvIcon();
        ViewGroup.LayoutParams r7 = getIvIcon().getLayoutParams();
        if (r7 == null) goto L7;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        ImagePopoverView r0 = this;
        r8.height = OUnitExtensionKt.vdp(r0, 24);
        r8.width = OUnitExtensionKt.vdp(r0, 24);
        r8.setMarginEnd(OUnitExtensionKt.vdp(r0, 8));
        r6.setLayoutParams(r8);
        getIvIcon().setImageTintList(null);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setShowArrow(boolean r1) {
        ImageView r0 = getIvArrow();
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public final void setImageClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        getIvIcon().setOnClickListener(r2);
    }

    @Override // com.obric.oui.popover.view.LinkPopoverView
    public void setLeftIcon(int r6) {
        ImagePopoverView r0 = this;
        setPadding(OUnitExtensionKt.vdp(r0, 12), OUnitExtensionKt.vdp(r0, 9), OUnitExtensionKt.vdp(r0, 12), OUnitExtensionKt.vdp(r0, 9));
        super.setLeftIcon(r6);
    }

    @Override // com.obric.oui.popover.view.LinkPopoverView
    public void setLeftIcon(Drawable r6) {
        ImagePopoverView r0 = this;
        setPadding(OUnitExtensionKt.vdp(r0, 12), OUnitExtensionKt.vdp(r0, 9), OUnitExtensionKt.vdp(r0, 12), OUnitExtensionKt.vdp(r0, 9));
        super.setLeftIcon(r6);
    }
}
