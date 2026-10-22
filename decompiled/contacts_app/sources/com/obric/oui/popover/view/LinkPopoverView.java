package com.obric.oui.popover.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.popover.PopoverLinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LinkPopoverView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/popover/view/LinkPopoverView;", "Lcom/obric/oui/popover/PopoverLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ivArrow", "Landroid/widget/ImageView;", "getIvArrow", "()Landroid/widget/ImageView;", "ivIcon", "getIvIcon", "tvTips", "Landroid/widget/TextView;", "getTvTips", "()Landroid/widget/TextView;", "setLeftIcon", "", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "", "setTips", "charSequence", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LinkPopoverView extends PopoverLinearLayout {
    private final ImageView ivArrow;
    private final ImageView ivIcon;
    private final TextView tvTips;

    /* JADX WARN: Multi-variable type inference failed */
    public LinkPopoverView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ LinkPopoverView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public LinkPopoverView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        LinearLayout.inflate(r2, R.layout.o_popover_link_view, this);
        setOrientation(0);
        int r4 = OUnitExtensionKt.vdp(this, 12);
        setPadding(r4, r4, r4, r4);
        setBackground(ContextCompat.getDrawable(r2, R.drawable.o_popover_view_bg));
        View r5 = findViewById(R.id.iv_icon);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.iv_icon)");
        this.ivIcon = (ImageView) r5;
        View r6 = findViewById(R.id.tv_tips);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.tv_tips)");
        this.tvTips = (TextView) r6;
        View r7 = findViewById(R.id.iv_arrow);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.iv_arrow)");
        this.ivArrow = (ImageView) r7;
    }

    public final ImageView getIvIcon() {
        return this.ivIcon;
    }

    public final TextView getTvTips() {
        return this.tvTips;
    }

    public final ImageView getIvArrow() {
        return this.ivArrow;
    }

    public void setLeftIcon(int r2) {
        this.ivIcon.setImageResource(r2);
        ViewExtensionsKt.makeVisible(this.ivIcon);
    }

    public void setLeftIcon(Drawable r2) {
        this.ivIcon.setImageDrawable(r2);
        ViewExtensionsKt.makeVisible(this.ivIcon);
    }

    public final void setTips(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "charSequence");
        this.tvTips.setText(r2);
    }
}
