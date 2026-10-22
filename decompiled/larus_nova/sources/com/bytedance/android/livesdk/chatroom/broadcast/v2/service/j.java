package com.bytedance.android.livesdk.chatroom.broadcast.v2.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements com.bytedance.android.scope.o, com.bytedance.android.scope.r, com.bytedance.android.live.broadcast.api.scope.service.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.live.broadcast.api.scope.service.g> f105520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i00.a f105521b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.live.broadcast.api.scope.service.g
    public final void i() {
        Iterator<T> r100 = this.f105520a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.live.broadcast.api.scope.service.g) r100.next()).i();
        goto L4
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        ((ArrayList) this.f105520a).clear();
    }

    public j(i00.a r100) {
        Intrinsics.checkNotNullParameter(r100, "inst");
        this.f105521b = r100;
        this.f105520a = new ArrayList();
    }

    @Override // com.bytedance.android.live.broadcast.api.scope.service.g
    public final void d(Room r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        ALogger.i("BroadcastInLiveInstanceScope", "BroadcastShellStateDispatcher onRoomReady");
        Iterator<T> r101 = this.f105520a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.android.live.broadcast.api.scope.service.g) r101.next()).d(r100);
        goto L4
    }

    @Override // com.bytedance.android.scope.g
    public final boolean c(com.bytedance.android.scope.j r100, com.bytedance.android.scope.j r101) {
        Intrinsics.checkNotNullParameter(r100, "parentScope");
        Intrinsics.checkNotNullParameter(r101, "childScope");
        Intrinsics.checkNotNullParameter(r100, "parentScope");
        Intrinsics.checkNotNullParameter(r101, "childScope");
        Intrinsics.checkNotNullParameter(r100, "parentScope");
        Intrinsics.checkNotNullParameter(r101, "childScope");
        return false;
    }

    @Override // com.bytedance.android.scope.r
    public final <T extends com.bytedance.android.scope.o> T a(e33.l r100, T r101, com.bytedance.android.scope.e r102) {
        Intrinsics.checkNotNullParameter(r100, "serviceDesc");
        Intrinsics.checkNotNullParameter(r101, "serviceInst");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r101 instanceof com.bytedance.android.live.broadcast.api.scope.service.g) == true) goto L5;
    L8:
        return r101;
    L5:
        if (this.f105521b.h() == false) goto L7;
        return r101;
    L7:
        ALogger.i("BroadcastInLiveInstanceScope", "BroadcastShellStateDispatcher transformService");
        ((ArrayList) this.f105520a).add(r101);
        goto L8
    }
}
