package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class ThemedCompetitionSeatAnimTask extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f72210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f72211c;

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void b(w r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof x) == false) goto L12;
        String r101 = ((x) r100).f72351b;
        if (r101 == null) goto L16;
        this.f72210b.a(SeatAnimTaskState.THEMED_COMPETITION_ANIM);
        HSImageView r102 = this.f72211c;
        if (r102 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r102);
    L9:
        HSImageView r103 = this.f72211c;
        if (r103 == null) goto L17;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.f.a(r103, r101, new ThemedCompetitionSeatAnimTask$handle$$inlined$let$lambda$1(this));
        return;
    L17:
        return;
    L16:
        return;
    L12:
        d r104 = this.f72224a;
        if (r104 == null) goto L19;
        r104.b(r100);
        return;
    }

    public ThemedCompetitionSeatAnimTask(f r100, HSImageView r101) {
        Intrinsics.checkNotNullParameter(r100, "taskStateListener");
        this.f72210b = r100;
        this.f72211c = r101;
    }
}
