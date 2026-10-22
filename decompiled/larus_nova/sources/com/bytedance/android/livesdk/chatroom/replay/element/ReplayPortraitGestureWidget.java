package com.bytedance.android.livesdk.chatroom.replay.element;

import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.danmaku.VSDanmakuContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq1.h0;
import mq1.i0;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/element/ReplayPortraitGestureWidget;", "Lcom/bytedance/android/livesdk/chatroom/replay/element/ReplayBaseGestureWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/view/View$OnTouchListener;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayPortraitGestureWidget extends ReplayBaseGestureWidget implements Observer<KVData>, View.OnTouchListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public GestureDetector f108540l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f108541m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public mq1.v f108542n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f108543o;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayPortraitGestureWidget f108544a;

        public a(ReplayPortraitGestureWidget r100) {
            this.f108544a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            ReplayDataContext.a r101 = ReplayDataContext.Companion;
            DataCenter r102 = this.f108544a.dataCenter;
            r101.getClass();
            ReplayDataContext r103 = ReplayDataContext.a.b(r102);
            mq1.v r104 = null;
            if (r103 == null) goto L11;
            com.bytedance.live.datacontext.j<VSDanmakuContext> r105 = r103.getVsDanmakuContext();
            if (r105 == null) goto L11;
            VSDanmakuContext r106 = r105.getValue();
            if (r106 == null) goto L11;
            com.bytedance.live.datacontext.m<Boolean> r107 = r106.isDanmakuHandlePopupShow();
            if (r107 == null) goto L11;
            Boolean r108 = r107.getValue();
        L13:
            if ((!Intrinsics.areEqual(r108, Boolean.TRUE)) == false) goto L30;
            mq1.t r109 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e();
            if (r109 == null) goto L17;
            r104 = r109.provideVSPlayerViewControlService(this.f108544a.dataCenter);
        L17:
            if (r104 == null) goto L24;
            VSPlayerViewControlContext r110 = r104.provideContext();
            if (r110 == null) goto L24;
            com.bytedance.live.datacontext.m<Boolean> r111 = r110.isLocked();
            if (r111 == null) goto L24;
            if (r111.getValue().booleanValue() == true) goto L30;
        L24:
            if (r104 == null) goto L26;
            r104.changeVisibilityStatus();
        L26:
            if (r104 == null) goto L30;
            if (r104.getVisibilityStatus() != true) goto L30;
            r104.markVisibilityStatusChangeByUser();
        L30:
            return true;
        L11:
            r108 = null;
            goto L13
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.element.ReplayBaseGestureWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public ReplayPortraitGestureWidget() {
        this.f108543o = new a(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.element.ReplayBaseGestureWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        super.onUnload();
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L6;
        SparseArray<br1.b> r101 = br1.b.f20120d;
        br1.b r102 = br1.b.a.a(r100);
        Intrinsics.checkNotNullParameter(this, "listener");
        r102.f20121a.remove(this);
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.element.ReplayBaseGestureWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        super.onLoad(r100);
        new com.bytedance.android.livesdk.chatroom.replay.util.b(this.dataCenter, this.contentView);
        this.f108541m = findViewById(R.id.replay_gesture_container);
        this.f108540l = new GestureDetector(this.context, this.f108543o);
        mq1.t r101 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e();
        if (r101 == null) goto L5;
        mq1.v r102 = r101.provideVSPlayerViewControlService(this.dataCenter);
    L6:
        this.f108542n = r102;
        DataCenter r103 = this.dataCenter;
        if (r103 == null) goto L10;
        SparseArray<br1.b> r104 = br1.b.f20120d;
        br1.b r105 = br1.b.a.a(r103);
        Intrinsics.checkNotNullParameter(this, "listener");
        r105.f20121a.add(this);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        h0 r102 = i0.a(this.dataCenter, this);
        if (r102 != null) goto L5;
    L7:
        if (r101 != null) goto L9;
    L10:
        if (r101 == null) goto L12;
        r101.getAction();
    L12:
        if (r101 != null) goto L14;
        return true;
    L14:
        GestureDetector r103 = this.f108540l;
        if (r103 != null) goto L17;
        return true;
    L17:
        return r103.onTouchEvent(r101);
    L9:
        if (r101.getAction() == 1) goto L12;
    L5:
        if (r102.a(r100, r101, null, null) != true) goto L7;
        return true;
    }
}
