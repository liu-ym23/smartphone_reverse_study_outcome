package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/GiftListRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "J", "getStartTime", "()J", "setStartTime", "(J)V", DyPayConstant.KEY_START_TIME, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftListRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f126645a;

    public GiftListRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GiftListRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final long getStartTime() {
        return this.f126645a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getAction());
    L5:
        if (r101 != null) goto L8;
    L10:
        if (r101 == null) goto L19;
        if (r101.intValue() != 2) goto L19;
        if ((System.currentTimeMillis() - this.f126645a) <= 500) goto L31;
        return false;
    L31:
        return super.onInterceptTouchEvent(r100);
    L19:
        if (r101 != null) goto L22;
    L24:
        if (r101 != null) goto L27;
    L29:
        this.f126645a = 0;
        goto L31
    L27:
        if (r101.intValue() != 3) goto L29;
    L28:
        this.f126645a = 0;
        goto L31
    L22:
        if (r101.intValue() != 1) goto L24;
    L8:
        if (r101.intValue() != 0) goto L10;
        this.f126645a = System.currentTimeMillis();
        goto L31
    L4:
        r101 = null;
        goto L5
    }

    public final void setStartTime(long r100) {
        this.f126645a = r100;
    }

    public GiftListRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ GiftListRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
