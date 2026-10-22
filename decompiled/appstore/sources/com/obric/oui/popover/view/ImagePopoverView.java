package com.obric.oui.popover.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/popover/view/ImagePopoverView;", "Lcom/obric/oui/popover/view/LinkPopoverView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setImageClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setLeftIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "", "setShowArrow", "show", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImagePopoverView extends LinkPopoverView {
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ImagePopoverView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public final void setImageClickListener(@NotNull View.OnClickListener r10) {
        q.g(r10, "listener");
        getIvIcon().setOnClickListener(r10);
    }

    @Override // com.obric.oui.popover.view.LinkPopoverView
    public void setLeftIcon(int r10) {
        setPadding(f.r(this, 12), f.r(this, 9), f.r(this, 12), f.r(this, 9));
        super.setLeftIcon(r10);
    }

    public final void setShowArrow(boolean r10) {
        ImageView r11 = getIvArrow();
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public /* synthetic */ ImagePopoverView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public ImagePopoverView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        ImageView r12 = getIvIcon();
        ViewGroup.LayoutParams r13 = getIvIcon().getLayoutParams();
        if (r13 == null) goto L7;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        r14.height = f.r(this, 24);
        r14.width = f.r(this, 24);
        r14.setMarginEnd(f.r(this, 8));
        r12.setLayoutParams(r14);
        getIvIcon().setImageTintList(null);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // com.obric.oui.popover.view.LinkPopoverView
    public void setLeftIcon(@Nullable Drawable r10) {
        setPadding(f.r(this, 12), f.r(this, 9), f.r(this, 12), f.r(this, 9));
        super.setLeftIcon(r10);
    }
}
