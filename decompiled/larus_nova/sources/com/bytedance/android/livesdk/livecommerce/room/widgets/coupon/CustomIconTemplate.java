package com.bytedance.android.livesdk.livecommerce.room.widgets.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/coupon/CustomIconTemplate;", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/coupon/BaseIconTemplate;", "Landroid/view/View;", "value", "e", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CustomIconTemplate extends BaseIconTemplate {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f152075e;

    public CustomIconTemplate(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CustomIconTemplate(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View getContentView() {
        return this.f152075e;
    }

    public final void setContentView(View r100) {
        if ((!Intrinsics.areEqual(r100, this.f152075e)) == false) goto L15;
        getContentContainer().removeView(r100);
        if (r100 == null) goto L13;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L9;
        r101 = null;
    L9:
        ViewGroup r102 = (ViewGroup) r101;
        if (r102 == null) goto L12;
        r102.removeView(r100);
    L12:
        getContentContainer().addView(r100);
    L13:
        this.f152075e = r100;
        return;
    }

    public CustomIconTemplate(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ CustomIconTemplate(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
