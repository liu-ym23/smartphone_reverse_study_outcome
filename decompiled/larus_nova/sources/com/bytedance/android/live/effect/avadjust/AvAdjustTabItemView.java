package com.bytedance.android.live.effect.avadjust;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/AvAdjustTabItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "name", "", "setTabName", "", "resId", "", "visible", "setDotVisibility", "getSelectedStatus", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AvAdjustTabItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f66784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f66785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f66786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f66787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f66788e;

    public static final class a {
    }

    public AvAdjustTabItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AvAdjustTabItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean getSelectedStatus() {
        return false;
    }

    static {
        s1.t();
    }

    public final void setDotVisibility(boolean r100) {
        View r101 = this.f66785b;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.A(r101, r100);
        return;
    }

    public final void setTabName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        TextView r101 = this.f66784a;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setTabName(int r100) {
        TextView r101 = this.f66784a;
        if (r101 == null) goto L6;
        r101.setText(s1.B(r100));
        return;
    }

    public AvAdjustTabItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_effect_av_adjust_container_tab_item, this);
        this.f66784a = (TextView) findViewById(R.id.tv_name);
        this.f66785b = findViewById(R.id.dot);
        this.f66786c = findViewById(R.id.indicator);
        this.f66787d = findViewById(R.id.bt_beauty);
        this.f66788e = findViewById(R.id.cl_tag);
    }

    public /* synthetic */ AvAdjustTabItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
