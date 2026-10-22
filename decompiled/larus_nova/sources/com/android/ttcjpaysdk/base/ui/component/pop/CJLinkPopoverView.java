package com.android.ttcjpaysdk.base.ui.component.pop;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\r\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0019\u0010\u0011\u001a\u00020\u00122\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJLinkPopoverView;", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopoverLinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ivArrow", "Landroid/widget/ImageView;", "getIvArrow", "()Landroid/widget/ImageView;", "ivIcon", "getIvIcon", "tvTips", "Landroid/widget/TextView;", "getTvTips", "()Landroid/widget/TextView;", "setLeftIcon", "", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "", "(Ljava/lang/Integer;)V", "setMaxTipsLength", "maxLength", "setMaxTipsWidth", "maxWidth", "setTextColor", "color", "setTips", "charSequence", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CJLinkPopoverView extends CJPopoverLinearLayout {
    private final ImageView ivArrow;
    private final ImageView ivIcon;
    private final TextView tvTips;

    /* JADX WARN: Multi-variable type inference failed */
    public CJLinkPopoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 2, 0 == true ? 1 : 0);
    }

    public final ImageView getIvArrow() {
        return this.ivArrow;
    }

    public final ImageView getIvIcon() {
        return this.ivIcon;
    }

    public final TextView getTvTips() {
        return this.tvTips;
    }

    public void setLeftIcon(Integer r100) {
        if (r100 != null) goto L4;
        this.ivIcon.setVisibility(8);
        return;
    L4:
        this.ivIcon.setImageResource(r100.intValue());
        this.ivIcon.setVisibility(0);
    }

    public final void setMaxTipsLength(int r100) {
        CharSequence r101 = this.tvTips.getText();
        if (r101.length() <= r100) goto L6;
        this.tvTips.setText(TextUtils.substring(r101, 0, r100) + "...");
        return;
    }

    public final void setMaxTipsWidth(int r100) {
        this.tvTips.setMaxWidth(r100);
        this.tvTips.setSingleLine(true);
        this.tvTips.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void setTextColor(int r100) {
        this.tvTips.setTextColor(r100);
    }

    public final void setTips(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "charSequence");
        this.tvTips.setText(r100);
    }

    public void setLeftIcon(Drawable r100) {
        this.ivIcon.setImageDrawable(r100);
        this.ivIcon.setVisibility(0);
    }

    public CJLinkPopoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LinearLayout.inflate(r100, R.layout.cj_pay_view_popover_link_view, this);
        setOrientation(0);
        this.ivIcon = (ImageView) findViewById(R.id.iv_icon);
        this.tvTips = (TextView) findViewById(R.id.tv_tips);
        this.ivArrow = (ImageView) findViewById(R.id.iv_arrow);
    }

    public /* synthetic */ CJLinkPopoverView(Context r100, AttributeSet r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
