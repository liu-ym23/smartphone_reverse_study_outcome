package com.obric.oui.panel.header;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OAttributes;
import com.obric.oui.common.util.SimpleColorFilter;
import com.obric.oui.divider.ODivider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPanelPadHeaderView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/panel/header/OPanelPadHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dividerView", "Lcom/obric/oui/divider/ODivider;", "ivBack", "Landroid/widget/ImageView;", "ivClose", "Landroidx/appcompat/widget/AppCompatImageView;", "tvTitle", "Landroid/widget/TextView;", "getCloseIconView", "getTitleView", "switchToBlackIconStyle", "", "switchToPadIconStyle", "switchToWhiteIconStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPanelPadHeaderView extends ConstraintLayout {
    private final ODivider dividerView;
    private final ImageView ivBack;
    private final AppCompatImageView ivClose;
    private final TextView tvTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public OPanelPadHeaderView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OPanelPadHeaderView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OPanelPadHeaderView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        ConstraintLayout.inflate(r4, R.layout.o_basic_panel_pad_header, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, OAttributes.INSTANCE.resolveDimension(r4, R.attr.oui_PanelDefaultHeaderHeight, R.dimen.oui_panel_default_header_height)));
        setBackgroundColor(0);
        View r6 = findViewById(R.id.iv_close);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.iv_close)");
        this.ivClose = (AppCompatImageView) r6;
        View r7 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) r7;
        View r8 = findViewById(R.id.iv_back);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.iv_back)");
        this.ivBack = (ImageView) r8;
        View r9 = findViewById(R.id.divider);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.divider)");
        this.dividerView = (ODivider) r9;
    }

    public final AppCompatImageView getCloseIconView() {
        return this.ivClose;
    }

    public final TextView getTitleView() {
        return this.tvTitle;
    }

    public final void switchToWhiteIconStyle() {
        SimpleColorFilter r0 = new SimpleColorFilter(ContextCompat.getColor(getContext(), R.color.ConstTextInverse));
        Drawable r1 = ContextCompat.getDrawable(getContext(), R.drawable.o_basic_panel_normal_header_close_bg_light);
        SimpleColorFilter r2 = r0;
        this.ivBack.setColorFilter(r2);
        this.ivClose.setColorFilter(r2);
        this.ivBack.setBackground(r1);
        this.ivClose.setBackground(r1);
    }

    public final void switchToBlackIconStyle() {
        SimpleColorFilter r0 = new SimpleColorFilter(ContextCompat.getColor(getContext(), R.color.TextReverse));
        Drawable r1 = ContextCompat.getDrawable(getContext(), R.drawable.o_basic_panel_normal_header_close_bg_dark);
        SimpleColorFilter r2 = r0;
        this.ivBack.setColorFilter(r2);
        this.ivClose.setColorFilter(r2);
        this.ivBack.setBackground(r1);
        this.ivClose.setBackground(r1);
    }

    public final void switchToPadIconStyle() {
        SimpleColorFilter r0 = new SimpleColorFilter(ContextCompat.getColor(getContext(), R.color.TextReverse));
        SimpleColorFilter r1 = r0;
        this.ivBack.setColorFilter(r1);
        this.ivClose.setColorFilter(r1);
        Drawable r2 = (Drawable) null;
        this.ivBack.setBackground(null);
        this.ivClose.setBackground(null);
    }
}
