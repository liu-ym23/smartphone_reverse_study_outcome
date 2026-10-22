package com.bytedance.android.livesdk.chatroom.replay.widget;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.replay.view.ReplayGestureDetectLayout;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/widget/ReplayGestureContainerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Landroid/view/View$OnTouchListener;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayGestureContainerWidget extends LiveRecyclableWidget implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplayGestureDetectLayout f110315a;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_replay_layout_gesture;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        ReplayGestureDetectLayout r100 = this.f110315a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mGestureView");
    L6:
        if (((ArrayList) r100.f110290b).contains(this) == false) goto L9;
        ((ArrayList) r100.f110290b).remove(this);
        return;
    }

    public ReplayGestureContainerWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f110315a = (ReplayGestureDetectLayout) this.contentView.findViewById(R.id.gesture_view);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ReplayGestureDetectLayout r101 = this.f110315a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mGestureView");
    L5:
        ((ArrayList) r101.f110290b).add(this);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r100 == null) goto L25;
        if (r101 == null) goto L25;
        SparseArray<br1.b> r102 = br1.b.f20120d;
        br1.b r103 = br1.b.a.a(this.dataCenter);
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "event");
        Iterator r104 = ((ArrayList) r103.f20122b).iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        if (((br1.a) r104.next()).f20119a.onTouch(r100, r101) == false) goto L8;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L33;
        Iterator<T> r106 = r103.f20121a.iterator();
    L16:
        boolean r107 = false;
    L18:
        if (r106.hasNext() == false) goto L24;
        if (((View.OnTouchListener) r106.next()).onTouch(r100, r101) == true) goto L22;
        if (r107 == false) goto L16;
    L22:
        r107 = true;
        goto L18
    L24:
        return r107;
    L33:
        return true;
    L12:
        r105 = false;
    L25:
        return false;
    }
}
