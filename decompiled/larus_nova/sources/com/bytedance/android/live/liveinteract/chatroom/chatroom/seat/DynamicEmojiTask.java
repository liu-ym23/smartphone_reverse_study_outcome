package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class DynamicEmojiTask extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f72191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DynamicEmojiView f72192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f72193d;

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void b(final w r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof a) == false) goto L17;
        a r101 = (a) r100;
        wj0.b r102 = r101.f72212a;
        if (r102 == null) goto L11;
        TalkRoomBaseDynamicEmoji r103 = r102.f559922b;
        if (r103 == null) goto L11;
        if (r103.isNewRandomEmoji() != true) goto L11;
        return;
    L11:
        this.f72191b.a(SeatAnimTaskState.DYNAMIC_EMOJI);
        HSImageView r104 = this.f72193d;
        if (r104 == null) goto L14;
        r104.setVisibility(8);
    L14:
        DynamicEmojiView r105 = this.f72192c;
        if (r105 == null) goto L21;
        r105.b(r101.f72212a, new DynamicEmojiTask$handle$1(this, r100));
        return;
    L21:
        return;
    L17:
        d r106 = this.f72224a;
        if (r106 == null) goto L23;
        r106.b(r100);
        return;
    }

    public DynamicEmojiTask(f r100, DynamicEmojiView r101, HSImageView r102) {
        Intrinsics.checkNotNullParameter(r100, "taskStateListener");
        this.f72191b = r100;
        this.f72192c = r101;
        this.f72193d = r102;
    }
}
