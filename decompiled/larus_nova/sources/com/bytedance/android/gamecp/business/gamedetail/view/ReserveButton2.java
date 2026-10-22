package com.bytedance.android.gamecp.business.gamedetail.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.gamecp.base.gamedetail.s0;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u0004\u0018\u00010\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/ReserveButton2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/gamecp/base/gamedetail/s0;", "config", "", "setConfig", "", "textColor", "setTitleTextColor", "", "text", "setTitleText", "getConfig", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReserveButton2 extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s0 f55743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f55744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f55745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f55746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProcessView f55747e;

    public ReserveButton2(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReserveButton2(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final s0 getConfig() {
        return this.f55743a;
    }

    public final void setConfig(s0 r100) {
        this.f55743a = r100;
        if (r100 == null) goto L37;
        TextView r101 = this.f55745c;
        if (r101 == null) goto L7;
        r101.setText(r100.d(getContext()));
    L7:
        TextView r102 = this.f55745c;
        if (r102 == null) goto L10;
        r102.setTextColor(r100.c(getContext()));
    L10:
        TextView r103 = this.f55745c;
        if (r103 == null) goto L13;
        yt.o.a(r103, 500);
    L13:
        TextView r104 = this.f55746d;
        if (r104 == null) goto L16;
        r104.setText(r100.e(getContext()));
    L16:
        TextView r105 = this.f55746d;
        if (r105 == null) goto L19;
        r105.setTextColor(r100.f(getContext()));
    L19:
        TextView r106 = this.f55746d;
        if (r106 == null) goto L23;
        yt.o.a(r106, 400);
    L23:
        if (TextUtils.isEmpty(r100.e(getContext())) == true) goto L34;
        TextView r107 = this.f55746d;
        if (r107 == null) goto L37;
        if (TextUtils.isEmpty(r107.getText()) == true) goto L31;
        TextView r108 = this.f55746d;
        if (r108 == null) goto L37;
        r108.setVisibility(0);
        goto L37
    L31:
        TextView r109 = this.f55746d;
        if (r109 == null) goto L37;
        r109.setVisibility(8);
        goto L37
    L34:
        TextView r110 = this.f55746d;
        if (r110 == null) goto L37;
        r110.setVisibility(8);
    L37:
        GradientDrawable r111 = new GradientDrawable();
        r111.setShape(0);
        r111.setCornerRadius(UIUtils.dip2Px(getContext(), 8.0f));
        s0 r112 = this.f55743a;
        if (r112 == null) goto L40;
        r111.setColor(r112.a(getContext()));
    L40:
        View r113 = this.f55744b;
        if (r113 == null) goto L43;
        r113.setBackground(r111);
    L43:
        s0 r114 = this.f55743a;
        if (r114 == null) goto L49;
        ProcessView r115 = this.f55747e;
        if (r115 == null) goto L50;
        r115.setColor(r114.c(getContext()));
        return;
    L50:
        return;
    }

    public final void setTitleText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f55745c;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setTitleTextColor(int r100) {
        TextView r101 = this.f55745c;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public ReserveButton2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View.inflate(r100, R.layout.gamecp_game_promote_detail_reserve_button2, this);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.loadingStrokeWidth, R.attr.titleSize});
        this.f55744b = findViewById(R.id.root_layout);
        TextView r104 = (TextView) findViewById(R.id.tv_desc);
        this.f55745c = r104;
        this.f55746d = (TextView) findViewById(R.id.tv_sub_desc);
        ProcessView r105 = (ProcessView) findViewById(R.id.process_view);
        this.f55747e = r105;
        if (r104 == null) goto L5;
        r104.setTextSize(0, r103.getDimension(1, UtilityKotlinExtentionsKt.d(15)));
    L5:
        if (r105 == null) goto L8;
        r105.setStrokeWidth(r103.getDimension(0, UtilityKotlinExtentionsKt.b(2)));
        return;
    }

    public /* synthetic */ ReserveButton2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
