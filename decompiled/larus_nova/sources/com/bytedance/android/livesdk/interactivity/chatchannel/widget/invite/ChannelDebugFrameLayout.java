package com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/invite/ChannelDebugFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/ViewGroup$LayoutParams;", "params", "", "setLayoutParams", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ChannelDebugFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f134609a;

    public ChannelDebugFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChannelDebugFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r100 = getParent();
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup r101 = (ViewGroup) r100;
    L6:
        if (r101 == null) goto L14;
        if (Intrinsics.areEqual(r101.getClass().getSimpleName(), "MatchRoomViewPager") == true) goto L9;
        ViewParent r102 = r101.getParent();
        if ((r102 instanceof ViewGroup) == true) goto L13;
        r102 = null;
    L13:
        r101 = (ViewGroup) r102;
        goto L6
    L9:
        return;
    L14:
        ALogger.e(this.f134609a, "not attach to MatchRoomViewPager");
        ViewParent r103 = getParent();
        if ((r103 instanceof ViewGroup) == true) goto L17;
        r103 = null;
    L17:
        ViewGroup r104 = (ViewGroup) r103;
        int r105 = 0;
    L19:
        if (r105 >= 3) goto L28;
        ALogger.e(this.f134609a, String.valueOf(r104));
        if (r104 == null) goto L23;
        ViewParent r106 = r104.getParent();
    L25:
        if ((r106 instanceof ViewGroup) == true) goto L27;
        r106 = null;
    L27:
        r104 = (ViewGroup) r106;
        r105 = r105 + 1;
        goto L19
    L23:
        r106 = null;
        goto L25
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        if (r100 != null) goto L4;
    L6:
        super.setLayoutParams(r100);
        return;
    L4:
        if (r100.height == (-1)) goto L6;
        ALogger.e(this.f134609a, "params.height=" + r100.height, new RuntimeException());
        goto L6
    }

    public ChannelDebugFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f134609a = "ChannelDebugFrameLayout";
    }

    public /* synthetic */ ChannelDebugFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
