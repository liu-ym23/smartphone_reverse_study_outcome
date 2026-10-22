package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

/* JADX INFO: loaded from: classes46.dex */
public final class v implements am3.c<TalkRoomDigitAvatarEmoji> {
    public v() {
    }

    public static TalkRoomDigitAvatarEmoji a(am3.g r100) throws Exception {
        TalkRoomDigitAvatarEmoji r101 = new TalkRoomDigitAvatarEmoji();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.actionID = (int) r100.j();
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final TalkRoomDigitAvatarEmoji decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
