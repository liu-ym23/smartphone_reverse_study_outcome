package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

/* JADX INFO: loaded from: classes46.dex */
public final class x implements am3.c<TalkRoomEmojiPermission> {
    public x() {
    }

    public static TalkRoomEmojiPermission a(am3.g r100) throws Exception {
        TalkRoomEmojiPermission r101 = new TalkRoomEmojiPermission();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.hasPermission = am3.h.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.toastWithoutPermission = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.bottomText = am3.h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.schemaJumpUrl = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final TalkRoomEmojiPermission decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
