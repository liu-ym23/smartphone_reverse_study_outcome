package com.bytedance.android.live.revlink.impl.multianchor.dialog.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/ui/NoSwipeViewPager;", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NoSwipeViewPager extends SSViewPager {
    @Override // com.bytedance.android.live.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return false;
    }

    @Override // com.bytedance.android.live.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return true;
    }

    public NoSwipeViewPager(Context r100) {
        this(r100, null);
    }

    public NoSwipeViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
