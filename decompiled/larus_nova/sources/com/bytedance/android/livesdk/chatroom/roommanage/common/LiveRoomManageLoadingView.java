package com.bytedance.android.livesdk.chatroom.roommanage.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/roommanage/common/LiveRoomManageLoadingView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomManageLoadingView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveDoubleColorBallAnimationView f111346a;

    public LiveRoomManageLoadingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveRoomManageLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (r101 != 0) goto L5;
        this.f111346a.b();
        return;
    L5:
        this.f111346a.c();
    }

    public LiveRoomManageLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LiveDoubleColorBallAnimationView r103 = new LiveDoubleColorBallAnimationView(r100);
        this.f111346a = r103;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.i(36), UtilityKotlinExtentionsKt.i(36));
        r104.gravity = 17;
        Unit r105 = Unit.INSTANCE;
        addView(r103, r104);
    }

    public /* synthetic */ LiveRoomManageLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
