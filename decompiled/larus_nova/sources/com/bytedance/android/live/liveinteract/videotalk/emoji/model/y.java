package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

/* JADX INFO: loaded from: classes46.dex */
public final class y implements am3.c<TalkRoomInteractEmoji> {
    public y() {
    }

    public static TalkRoomInteractEmoji a(am3.g r100) throws Exception {
        TalkRoomInteractEmoji r101 = new TalkRoomInteractEmoji();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.senderEmoji = (InteractEmojiAnim) vh7.f.a(r100, InteractEmojiAnim.class);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.pathEmoji = (InteractEmojiAnim) vh7.f.a(r100, InteractEmojiAnim.class);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.receiverEmoji = (InteractEmojiAnim) vh7.f.a(r100, InteractEmojiAnim.class);
        goto L3
    L11:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    @Override // am3.c
    public final TalkRoomInteractEmoji decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
