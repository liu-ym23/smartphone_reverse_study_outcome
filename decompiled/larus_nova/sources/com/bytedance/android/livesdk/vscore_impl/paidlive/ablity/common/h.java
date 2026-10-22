package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common;

import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.replay.paid.PaidReplayPresenter;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidSceneContext;
import com.bytedance.android.livesdk.vscore_api.paidlive.n;
import com.bytedance.android.livesdkapi.replay.PaidReplayCallback;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pu2.m;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements m, o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<PaidSceneEnum> f160193c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PaidReplayCallback f160194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.b f160195b;

    public static final class a {
    }

    @Override // pu2.m
    public final void enterRoom(Bundle r100) {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // pu2.m
    public final ILivePlayerClient s6() {
        return null;
    }

    static {
        f160193c = CollectionsKt.arrayListOf(new PaidSceneEnum[]{PaidSceneEnum.PAID_REPLAY_ROOM, PaidSceneEnum.PAID_REPLAY_CAMERA, PaidSceneEnum.PAID_REPLAY_PRIVILEGE_CAMERA});
    }

    public h(com.bytedance.android.livesdk.vscore_api.paidlive.scope.b r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f160195b = r100;
        if (r100.w0().isReplay() == false) goto L6;
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.b(r100).J1(m.class, this);
        return;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("PaidReplayPresenterCallbackDispatchAbility(" + hashCode() + ')', r100);
    }

    public final void c(PaidReplayPresenter r100) {
        PaidReplayCallback r101 = this.f160194a;
        if (r101 != null) goto L5;
    L6:
        Iterator<T> r102 = f160193c.iterator();
    L8:
        if (r102.hasNext() == false) goto L28;
        final PaidSceneEnum r103 = (PaidSceneEnum) r102.next();
        com.bytedance.android.livesdk.vscore_api.paidlive.e r104 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.b(this.f160195b).E1(r103);
        if (r104 == null) goto L16;
        PaidSceneContext r105 = r104.Xb();
        if (r105 == null) goto L16;
        com.bytedance.live.datacontext.m<n> r106 = r105.getSceneStateMachine();
        if (r106 == null) goto L16;
        n r107 = r106.getValue();
    L17:
        if (r107 == null) goto L19;
        r107.a(new PaidReplayPresenterCallbackDispatchAbility$registerSceneTransition$$inlined$forEach$lambda$1(r103, this));
        a("register transition Listener for " + r103.name());
    L19:
        com.bytedance.android.livesdk.vscore_api.paidlive.e r108 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.b(this.f160195b).E1(r103);
        if (r108 == null) goto L8;
        PaidSceneContext r109 = r108.Xb();
        if (r109 == null) goto L8;
        com.bytedance.live.datacontext.m<Triple<Long, Long, Long>> r110 = r109.getPaidTempWatchRemainTime();
        if (r110 == null) goto L8;
        Observable<Triple<Long, Long, Long>> r111 = r110.a();
        if (r111 == null) goto L8;
        r111.subscribe(new i(this));
    L16:
        r107 = null;
    L28:
        this.f160194a = r100;
        return;
    L5:
        if ((!Intrinsics.areEqual(r101, r100)) == false) goto L28;
        goto L6
    }
}
