package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/CommomKtvButton;", "Landroid/widget/TextView;", "", "corner", "", "setCorner", "", "parseColor", "setBgColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getBASE_PADDING", "()I", "BASE_PADDING", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommomKtvButton extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f70709a;

    public final int getBASE_PADDING() {
        return this.f70709a;
    }

    public CommomKtvButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setBgColor(int r100) {
        Drawable r101 = getBackground();
        if ((r101 instanceof GradientDrawable) == true) goto L5;
        r101 = null;
    L5:
        GradientDrawable r102 = (GradientDrawable) r101;
        if (r102 != null) goto L8;
        return;
    L8:
        r102.setColor(r100);
    }

    public final void setCorner(float r100) {
        Drawable r101 = getBackground();
        if ((r101 instanceof GradientDrawable) == true) goto L5;
        r101 = null;
    L5:
        GradientDrawable r102 = (GradientDrawable) r101;
        if (r102 == null) goto L9;
        r102.setCornerRadius(r100);
        return;
    }

    public CommomKtvButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        int r102 = s1.f(5.0f);
        this.f70709a = r102;
        setBackgroundResource(R.drawable.ttlive_bg_ktv_bt_corner_4);
        setPadding(r102 * 3, r102, r102 * 3, r102);
        setGravity(17);
        setTextColor(-1);
    }
}
