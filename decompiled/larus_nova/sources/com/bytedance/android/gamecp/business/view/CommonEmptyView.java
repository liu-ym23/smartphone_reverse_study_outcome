package com.bytedance.android.gamecp.business.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/gamecp/business/view/CommonEmptyView;", "Landroid/widget/LinearLayout;", "", "color", "", "setMsgTextColor", "", "msg", "setMsgText", "", "size", "setMsgTextSize", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageRes", "Landroid/widget/LinearLayout$LayoutParams;", "layoutParams", "setImageLayoutParams", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonEmptyView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f56442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f56443b;

    public CommonEmptyView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonEmptyView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setImageLayoutParams(LinearLayout.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutParams");
        ImageView r101 = this.f56443b;
        if (r101 == null) goto L6;
        r101.setLayoutParams(r100);
        return;
    }

    public final void setImageRes(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        ImageView r101 = this.f56443b;
        if (r101 == null) goto L6;
        r101.setImageDrawable(r100);
        return;
    }

    public final void setMsgText(String r100) {
        TextView r101 = this.f56442a;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setMsgTextColor(int r100) {
        TextView r101 = this.f56442a;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public final void setMsgTextSize(float r100) {
        TextView r101 = this.f56442a;
        if (r101 == null) goto L6;
        r101.setTextSize(r100);
        return;
    }

    public CommonEmptyView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.gamecp_empty_game_promote_list, this, false);
        this.f56442a = (TextView) r103.findViewById(R.id.tv_game_promote_common_empty_msg);
        this.f56443b = (ImageView) r103.findViewById(R.id.iv_game_promote_common_empty_image);
        addView(r103);
    }

    public /* synthetic */ CommonEmptyView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
