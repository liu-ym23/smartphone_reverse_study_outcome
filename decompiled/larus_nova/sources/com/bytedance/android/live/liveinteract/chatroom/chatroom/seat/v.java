package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.KtvSeatAnimationView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView;
import com.bytedance.android.live.liveinteract.view.MicSeatSponsorView;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class v implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SeatAnimTaskState f72348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f72349b;

    public v() {
        this.f72348a = SeatAnimTaskState.IDLE;
        this.f72349b = new o();
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.f
    public final void a(SeatAnimTaskState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f72348a = r100;
    }

    public final void c(w r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f72349b.b(r100);
    }

    public final void b(HSImageView r100, MicSeatSponsorView r101, HSImageView r102, LinkSucAnimationView r103, DynamicEmojiView r104, HSImageView r105, KtvSeatAnimationView r106) {
        GuestBattleSeatAnimTask r107 = new GuestBattleSeatAnimTask(this, r100, r101);
        ThemedCompetitionSeatAnimTask r108 = new ThemedCompetitionSeatAnimTask(this, r102);
        LinkSucAnimTask r109 = new LinkSucAnimTask(this, r103);
        DynamicEmojiTask r110 = new DynamicEmojiTask(this, r104, r105);
        m r111 = new m(this, r104);
        g r112 = new g(this, r106);
        o r113 = this.f72349b;
        r113.d(r107);
        r113.d(r108);
        r113.d(r109);
        r113.d(r110);
        r113.d(r112);
        r113.d(r111);
    }
}
