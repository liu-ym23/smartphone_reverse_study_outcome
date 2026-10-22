package com.bytedance.android.livesdk.chatroom.vs_base.player;

import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import mq1.p;
import mq1.r;
import mq1.s;
import mq1.t;
import mq1.u;
import mq1.v;

/* JADX INFO: loaded from: classes8.dex */
public final class ReplayPlayerServiceImpl implements t, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f118035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f118036b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public ReplayPlayerServiceImpl() {
        this.f118035a = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(ReplayPlayerServiceImpl$playerControlBrickService$2.INSTANCE);
        this.f118036b = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(ReplayPlayerServiceImpl$playerBrickService$2.INSTANCE);
    }

    @Override // mq1.t
    public final p a(DataCenter r100) {
        s r101 = (s) this.f118035a.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(r100);
    }

    @Override // mq1.t
    public final u provideVSPlayerTipService(DataCenter r100) {
        s r101 = (s) this.f118035a.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.provideVSPlayerTipService(r100);
    }

    @Override // mq1.t
    public final v provideVSPlayerViewControlService(DataCenter r100) {
        s r101 = (s) this.f118035a.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.provideVSPlayerViewControlService(r100);
    }

    @Override // mq1.t
    public final IReplayInnerProgressService provideVSProgressService(DataCenter r100) {
        r r101 = (r) this.f118036b.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(r100);
    }

    @Override // mq1.t
    public final void releaseService(DataCenter r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r r101 = (r) this.f118036b.getValue();
        if (r101 == null) goto L7;
        r101.releaseService(r100);
    L7:
        s r102 = (s) this.f118035a.getValue();
        if (r102 == null) goto L11;
        r102.releaseService(r100);
        return;
    }
}
