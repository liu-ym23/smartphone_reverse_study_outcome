package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common;

import com.bytedance.android.livesdkapi.roomplayer.IPaidLiveMessageManager;
import com.bytedance.android.scope.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class PaidInRoomLiveMessageAbility implements pu2.h, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f160100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PaidInRoomLiveMessageAbility$paidLiveMessageManager$1 f160101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.b f160102c;

    public final vlc.d a() {
        return (vlc.d) this.f160102c.D().getDataCenter().get("data_message_manager", null);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (this.f160102c.w0().isReplay() == false) goto L8;
        vlc.d r100 = a();
        if (r100 == null) goto L9;
        r100.startMessage();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        vlc.d r100 = a();
        if (r100 == null) goto L5;
        r100.r(false);
    L5:
        vlc.d r101 = a();
        if (r101 == null) goto L9;
        r101.release();
        return;
    }

    @Override // pu2.h
    public final IPaidLiveMessageManager k6() {
        return this.f160101b;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.PaidInRoomLiveMessageAbility$paidLiveMessageManager$1] */
    public PaidInRoomLiveMessageAbility(com.bytedance.android.livesdk.vscore_api.paidlive.scope.b r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f160102c = r100;
        this.f160100a = LazyKt.lazy(new PaidInRoomLiveMessageAbility$messageManager$2(this));
        this.f160101b = new PaidInRoomLiveMessageAbility$paidLiveMessageManager$1(this);
    }
}
