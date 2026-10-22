package com.bytedance.android.livesdk.interactivity.pin.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/ui/HighlightViewPager;", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getContentHeight", "()I", "setContentHeight", "(I)V", "contentHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HighlightViewPager extends SSViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f138870a;

    public final int getContentHeight() {
        return this.f138870a;
    }

    public HighlightViewPager(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        float r101 = r100.getY();
        int r102 = this.f138870a;
        if (r102 <= 0) goto L11;
        if (r101 <= r102) goto L11;
        if (r100.getAction() != 0) goto L11;
        return false;
    L11:
        return super.dispatchTouchEvent(r100);
    }

    public final void setContentHeight(int r100) {
        this.f138870a = r100;
    }

    public HighlightViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
