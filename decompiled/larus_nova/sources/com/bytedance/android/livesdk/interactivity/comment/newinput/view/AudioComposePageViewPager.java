package com.bytedance.android.livesdk.interactivity.comment.newinput.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioComposePageViewPager;", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "", "can", "", "setCanScroll", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioComposePageViewPager extends SSViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f136041a;

    public AudioComposePageViewPager(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.android.live.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f136041a == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    public final void setCanScroll(boolean r100) {
        this.f136041a = r100;
    }

    public AudioComposePageViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f136041a = true;
    }
}
