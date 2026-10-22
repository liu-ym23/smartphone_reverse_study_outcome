package com.bytedance.android.live.effect.avadjust.lens;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/lens/LensTabItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "name", "", "setTabName", "", "resId", "", "visible", "setDotVisibility", "getSelectedStatus", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LensTabItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f66853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f66854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f66855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f66856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f66857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f66858f;

    public LensTabItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LensTabItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean getSelectedStatus() {
        return this.f66856d;
    }

    public final void R5(boolean r100) {
        TextView r101 = this.f66853a;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r102 = R.color.ttlive_effect_av_adjust_tab_name_selected_color;
    L7:
        r101.setTextColor(s1.h(r102));
        goto L8
    L6:
        r102 = R.color.ttlive_effect_av_adjust_tab_name_unselected_color;
    L8:
        View r103 = this.f66855c;
        if (r103 == null) goto L11;
        UtilityKotlinExtentionsKt.A(r103, r100);
    L11:
        this.f66856d = r100;
    }

    public final void setDotVisibility(boolean r100) {
        View r101 = this.f66854b;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.A(r101, r100);
        return;
    }

    public final void setTabName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        TextView r101 = this.f66853a;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setTabName(int r100) {
        TextView r101 = this.f66853a;
        if (r101 == null) goto L6;
        r101.setText(s1.B(r100));
        return;
    }

    public LensTabItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_effect_av_adjust_tab_item, this);
        this.f66853a = (TextView) findViewById(R.id.tv_name);
        this.f66854b = findViewById(R.id.dot);
        this.f66855c = findViewById(R.id.indicator);
        this.f66857e = findViewById(R.id.bt_beauty);
        this.f66858f = findViewById(R.id.cl_tag);
    }

    public /* synthetic */ LensTabItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
