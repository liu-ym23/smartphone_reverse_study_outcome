package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.KtvSeatAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f72225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KtvSeatAnimationView f72226c;

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void b(w r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof h) == true) goto L5;
        d r101 = this.f72224a;
        if (r101 == null) goto L25;
        r101.b(r100);
        return;
    L25:
        return;
    L5:
        if (((h) r100).f72227a == false) goto L13;
        this.f72225b.a(SeatAnimTaskState.KTV_SINGER_ANIMA);
        KtvSeatAnimationView r102 = this.f72226c;
        if (r102 != null) goto L9;
    L10:
        KtvSeatAnimationView r103 = this.f72226c;
        if (r103 == null) goto L22;
        r103.setVisibility(0);
        return;
    L22:
        return;
    L9:
        if (r102.getVisibility() != 0) goto L10;
        return;
    L13:
        KtvSeatAnimationView r104 = this.f72226c;
        if (r104 == null) goto L16;
        r104.setVisibility(8);
    L16:
        this.f72225b.a(SeatAnimTaskState.IDLE);
    }

    public g(f r100, KtvSeatAnimationView r101) {
        Intrinsics.checkNotNullParameter(r100, "taskStateListener");
        this.f72225b = r100;
        this.f72226c = r101;
    }
}
