package com.obric.oui.popover.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.popover.PopoverLinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GuidePopoverView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/popover/view/GuidePopoverView;", "Lcom/obric/oui/popover/PopoverLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tvGuide", "Landroid/widget/TextView;", "getTvGuide", "()Landroid/widget/TextView;", "tvStatus", "getTvStatus", "setGuideText", "", "charSequence", "", "setStatusText", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuidePopoverView extends PopoverLinearLayout {
    private final TextView tvGuide;
    private final TextView tvStatus;

    /* JADX WARN: Multi-variable type inference failed */
    public GuidePopoverView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ GuidePopoverView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public GuidePopoverView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        LinearLayout.inflate(r2, R.layout.o_popover_guide_view, this);
        setOrientation(0);
        int r4 = OUnitExtensionKt.vdp(this, 12);
        setPadding(r4, r4, r4, r4);
        setBackground(ContextCompat.getDrawable(r2, R.drawable.o_popover_view_bg));
        View r5 = findViewById(R.id.tv_status_text);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.tv_status_text)");
        this.tvStatus = (TextView) r5;
        View r6 = findViewById(R.id.tv_guide_text);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.tv_guide_text)");
        this.tvGuide = (TextView) r6;
    }

    public final TextView getTvStatus() {
        return this.tvStatus;
    }

    public final TextView getTvGuide() {
        return this.tvGuide;
    }

    public final void setStatusText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "charSequence");
        this.tvStatus.setText(r2);
    }

    public final void setGuideText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "charSequence");
        this.tvGuide.setText(r2);
    }
}
