package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.livesdk.chatroom.interact.model.RivalExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class _RivalsSearchAnchorInfo_ProtoDecoder implements am3.c<RivalsSearchAnchorInfo> {
    public _RivalsSearchAnchorInfo_ProtoDecoder() {
    }

    public static RivalsSearchAnchorInfo decodeStatic(am3.g r100) throws Exception {
        RivalsSearchAnchorInfo r101 = new RivalsSearchAnchorInfo();
        r101.setThreadSafe(false);
        r101.tags = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L34;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 14) goto L8;
        r101.room = new Room(r100);
        goto L3
    L8:
        if (r103 != 23) goto L10;
        r101.battleAttachedInfo = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 5000) goto L11;
        r101.userOpenId = am3.h.c(r100);
        goto L3
    L11:
        switch(r103) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L25;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            default: goto L12;
        };
    L20:
        r101.tags.add(new BattleRivalTag(r100));
        goto L3
    L21:
        r101.displayId = am3.h.c(r100);
        goto L3
    L22:
        r101.linkStatus = r100.j();
        goto L3
    L23:
        r101.customVerify = am3.h.c(r100);
        goto L3
    L24:
        r101.fansNum = r100.j();
        goto L3
    L25:
        r101.shortId = r100.j();
        goto L3
    L26:
        r101.nickName = am3.h.c(r100);
        goto L3
    L27:
        r101.avatarThumb = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L28:
        r101.roomId = r100.j();
        goto L3
    L29:
        r101.secUserId = am3.h.c(r100);
        goto L3
    L30:
        r101.userId = r100.j();
        goto L3
    L12:
        switch(r103) {
            case 16: goto L19;
            case 17: goto L18;
            case 18: goto L17;
            case 19: goto L16;
            case 20: goto L15;
            case 21: goto L14;
            default: goto L13;
        };
    L14:
        r101.statusReason = am3.h.c(r100);
        goto L3
    L15:
        r101.gender = (int) r100.j();
        goto L3
    L16:
        r101.linkText = am3.h.c(r100);
        goto L3
    L17:
        r101.rivalExtraInfo = new RivalExtraInfo(r100);
        goto L3
    L18:
        r101.followType = r100.i();
        goto L3
    L19:
        r101.signExtra = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r104, r100);
        goto L3
    L34:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final RivalsSearchAnchorInfo decode(am3.g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ RivalsSearchAnchorInfo decode(am3.g r100) throws Exception {
        return decode(r100);
    }
}
