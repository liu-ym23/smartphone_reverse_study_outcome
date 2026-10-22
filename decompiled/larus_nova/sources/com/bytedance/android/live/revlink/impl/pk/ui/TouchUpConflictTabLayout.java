package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.google.android.material.tabs.TabLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B#\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013R*\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/TouchUpConflictTabLayout;", "Lcom/google/android/material/tabs/TabLayout;", "", "value", "b", "Z", "isEnableTouchHandle", "()Z", "setEnableTouchHandle", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defaultStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TouchUpConflictTabLayout extends TabLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f97026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f97027b;

    public TouchUpConflictTabLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f97027b == false) goto L15;
        r100.getX();
        float r101 = r100.getY();
        int r102 = r100.getAction();
        if (r102 != 0) goto L7;
        getParent().requestDisallowInterceptTouchEvent(true);
    L13:
        this.f97026a = r101;
        goto L15
    L7:
        if (r102 != 2) goto L13;
        if ((r101 - this.f97026a) >= 0) goto L13;
        getParent().requestDisallowInterceptTouchEvent(false);
    L15:
        return super.dispatchTouchEvent(r100);
    }

    public final void setEnableTouchHandle(boolean r100) {
        this.f97027b = r100;
        this.f97026a = 0.0f;
    }

    public TouchUpConflictTabLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public TouchUpConflictTabLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}
