package com.bytedance.android.gamecp.business.gamedetail.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.gamecp.base.gamedetail.z0;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/ReserveButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/gamecp/base/gamedetail/z0;", "config", "", "setConfig", "", "textColor", "setTitleTextColor", "", "text", "setTitleText", "setSubTitleTextColor", "setSubTitleText", "getConfig", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReserveButton extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z0 f55733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f55734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f55735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProcessView f55736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f55737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public yt.h f55738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public yt.h f55739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public yt.h f55740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public yt.h f55741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f55742j;

    public ReserveButton(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReserveButton(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void R5() {
        if (this.f55733a == null) goto L15;
        ProcessView r100 = this.f55736d;
        if (r100 == null) goto L7;
        UtilityKotlinExtentionsKt.h(r100);
    L7:
        ProcessView r101 = this.f55736d;
        if (r101 == null) goto L10;
        r101.b();
    L10:
        TextView r102 = this.f55734b;
        if (r102 == null) goto L13;
        UtilityKotlinExtentionsKt.j(r102);
    L13:
        T5();
        return;
    }

    public final void S5() {
        if (this.f55733a == null) goto L17;
        ProcessView r100 = this.f55736d;
        if (r100 == null) goto L7;
        UtilityKotlinExtentionsKt.j(r100);
    L7:
        TextView r101 = this.f55734b;
        if (r101 == null) goto L10;
        UtilityKotlinExtentionsKt.h(r101);
    L10:
        TextView r102 = this.f55735c;
        if (r102 == null) goto L13;
        r102.setVisibility(8);
    L13:
        ProcessView r103 = this.f55736d;
        if (r103 == null) goto L18;
        r103.a();
        return;
    L18:
        return;
    }

    public final void T5() {
        TextView r100 = this.f55735c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100.getText()) == true) goto L9;
        TextView r101 = this.f55735c;
        if (r101 == null) goto L14;
        r101.setVisibility(0);
        return;
    L14:
        return;
    L9:
        TextView r102 = this.f55735c;
        if (r102 == null) goto L16;
        r102.setVisibility(8);
        return;
    }

    public final z0 getConfig() {
        return this.f55733a;
    }

    public final void setConfig(z0 r100) {
        this.f55733a = r100;
        if (r100 == null) goto L32;
        TextView r101 = this.f55734b;
        if (r101 == null) goto L7;
        r101.setText(r100.b(getContext()));
    L7:
        Integer r102 = r100.e(getContext());
        if (r102 == null) goto L12;
        int r103 = r102.intValue();
        TextView r104 = this.f55735c;
        if (r104 == null) goto L12;
        r104.setTextColor(r103);
    L12:
        TextView r105 = this.f55734b;
        if (r105 == null) goto L15;
        r105.setTextColor(r100.c(getContext()));
    L15:
        Integer r106 = r100.j(getContext());
        if (r106 == null) goto L20;
        int r107 = r106.intValue();
        TextView r108 = this.f55734b;
        if (r108 == null) goto L20;
        r108.setTextSize(1, r107);
    L20:
        Integer r109 = r100.g(getContext());
        if (r109 == null) goto L32;
        int r110 = r109.intValue();
        if (500 > r110) goto L32;
        if (700 < r110) goto L32;
        TextView r111 = this.f55734b;
        if (r111 == null) goto L32;
        TextPaint r112 = r111.getPaint();
        if (r112 == null) goto L32;
        r112.setFakeBoldText(true);
    L32:
        z0 r113 = this.f55733a;
        if (r113 == null) goto L35;
        setBackground(r113.a(getContext()));
    L35:
        z0 r114 = this.f55733a;
        if (r114 == null) goto L40;
        ProcessView r115 = this.f55736d;
        if (r115 == null) goto L40;
        r115.setColor(r114.c(getContext()));
    L40:
        z0 r116 = this.f55733a;
        Drawable r117 = null;
        if (r116 == null) goto L45;
        TextView r118 = this.f55734b;
        if (r118 == null) goto L45;
        r118.setCompoundDrawablesWithIntrinsicBounds(r116.getIcon(getContext()), null, null, null);
    L45:
        z0 r119 = this.f55733a;
        if (r119 == null) goto L50;
        TextView r120 = this.f55734b;
        if (r120 == null) goto L50;
        r120.setTypeface(Typeface.defaultFromStyle(r119.d(getContext())));
    L50:
        this.f55738f = null;
        this.f55739g = null;
        this.f55740h = null;
        this.f55741i = null;
        z0 r121 = this.f55733a;
        if (r121 == null) goto L64;
        Pair<Integer, Integer> r122 = r121.i(getContext());
        if (r122 == null) goto L55;
        this.f55738f = new yt.h(r122.getFirst().intValue(), r122.getSecond().intValue());
    L55:
        this.f55737e = y0.b(r121.f(getContext()));
        Pair<Integer, Integer> r123 = r121.k(getContext());
        if (r123 == null) goto L58;
        this.f55739g = new yt.h(r123.getFirst().intValue(), r123.getSecond().intValue());
    L58:
        Pair<Integer, Integer> r124 = r121.h(getContext());
        if (r124 == null) goto L61;
        this.f55740h = new yt.h(r124.getFirst().intValue(), r124.getSecond().intValue());
    L61:
        Pair<Integer, Integer> r125 = r121.l(getContext());
        if (r125 == null) goto L64;
        this.f55741i = new yt.h(r125.getFirst().intValue(), r125.getSecond().intValue());
    L64:
        float r126 = this.f55742j;
        if (r126 == (-1.0f)) goto L93;
        this.f55742j = r126;
        Drawable r127 = getBackground();
        if (r127 == null) goto L69;
        Drawable r128 = r127.mutate();
    L71:
        if ((r128 instanceof GradientDrawable) == false) goto L74;
        r117 = r128;
    L74:
        GradientDrawable r129 = (GradientDrawable) r117;
        if (r129 == null) goto L82;
        yt.h r130 = this.f55738f;
        if (r130 == null) goto L79;
        r129.setColor(r130.a(r126));
    L79:
        yt.h r131 = this.f55739g;
        if (r131 == null) goto L82;
        r129.setStroke(this.f55737e, r131.a(r126));
    L82:
        yt.h r132 = this.f55740h;
        if (r132 == null) goto L87;
        int r133 = r132.a(r126);
        TextView r134 = this.f55734b;
        if (r134 == null) goto L87;
        r134.setTextColor(r133);
    L87:
        yt.h r135 = this.f55741i;
        if (r135 == null) goto L94;
        int r136 = r135.a(r126);
        TextView r137 = this.f55735c;
        if (r137 == null) goto L95;
        r137.setTextColor(r136);
        return;
    L95:
        return;
    L94:
        return;
    L69:
        r128 = null;
        goto L71
    }

    public final void setSubTitleText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f55735c;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setSubTitleTextColor(int r100) {
        TextView r101 = this.f55735c;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public final void setTitleText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f55734b;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setTitleTextColor(int r100) {
        TextView r101 = this.f55734b;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public ReserveButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View.inflate(r100, R.layout.gamecp_game_promote_detail_reserve_button, this);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.loadingStrokeWidth, R.attr.titleSize});
        TextView r104 = (TextView) findViewById(R.id.tv_desc);
        this.f55734b = r104;
        this.f55735c = (TextView) findViewById(R.id.tv_sub_desc);
        ProcessView r105 = (ProcessView) findViewById(R.id.process_view);
        this.f55736d = r105;
        if (r104 == null) goto L5;
        r104.setTextSize(0, r103.getDimension(1, UtilityKotlinExtentionsKt.b(15)));
    L5:
        if (r105 == null) goto L7;
        r105.setStrokeWidth(r103.getDimension(0, UtilityKotlinExtentionsKt.b(4)));
    L7:
        this.f55742j = -1.0f;
    }

    public /* synthetic */ ReserveButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
