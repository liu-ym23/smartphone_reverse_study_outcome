package com.bytedance.android.livesdkapi.message;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.lazy.ITextWrapper;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _CommonMessageData_ProtoDecoder implements c<CommonMessageData> {
    public _CommonMessageData_ProtoDecoder() {
    }

    public static CommonMessageData decodeStatic(g r100) throws Exception {
        CommonMessageData r101 = new CommonMessageData();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L30;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L19;
            case 12: goto L18;
            case 13: goto L17;
            case 14: goto L16;
            case 15: goto L15;
            case 16: goto L7;
            case 17: goto L14;
            case 18: goto L13;
            case 19: goto L12;
            case 20: goto L11;
            case 21: goto L10;
            case 22: goto L9;
            case 23: goto L8;
            default: goto L7;
        };
    L8:
        r101.anchorFoldDuration = r100.j();
        goto L3
    L9:
        r101.diffSei2absSecond = r100.j();
        goto L3
    L10:
        r101.channelId = r100.j();
        goto L3
    L11:
        r101.isDispatch = h.a(r100);
        goto L3
    L12:
        r101.randomDispatchMs = r100.j();
        goto L3
    L13:
        r101.process_at_sei_time_ms = r100.j();
        goto L3
    L14:
        r101.anchorFoldTypeV2 = r100.j();
        goto L3
    L15:
        r101.user = (IBaseUser) f.a(r100, IBaseUser.class);
        goto L3
    L16:
        r101.msgProcessFilterV = h.c(r100);
        goto L3
    L17:
        r101.msgProcessFilterK = h.c(r100);
        goto L3
    L18:
        r101.logId = h.c(r100);
        goto L3
    L19:
        r101.priorityScore = r100.j();
        goto L3
    L20:
        r101.anchorFoldType = r100.j();
        goto L3
    L21:
        r101.foldType = r100.j();
        goto L3
    L22:
        r101.displayText = (ITextWrapper) f.a(r100, ITextWrapper.class);
        goto L3
    L23:
        r101.describe = h.c(r100);
        goto L3
    L24:
        r101.showMsg = h.a(r100);
        goto L3
    L25:
        r101.monitor = r100.i();
        goto L3
    L26:
        r101.createTime = r100.j();
        goto L3
    L27:
        r101.roomId = r100.j();
        goto L3
    L28:
        r101.messageId = r100.j();
        goto L3
    L29:
        r101.method = h.c(r100);
        goto L3
    L7:
        h.d(r104, r100);
        goto L3
    L30:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final CommonMessageData decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ CommonMessageData decode(g r100) throws Exception {
        return decode(r100);
    }
}
