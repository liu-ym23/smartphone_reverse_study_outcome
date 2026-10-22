package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;

/* JADX INFO: loaded from: classes11.dex */
public final class ao implements am3.c<td> {
    public ao() {
    }

    @Override // am3.c
    public final td decode(am3.g r100) throws Exception {
        td r101 = new td();
        r101.getDelegate().setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        am3.g.a r104 = r101.getDelegate().decodeExtensionFields(r103, r100);
        if (r103 != 5000) goto L7;
        r101.openId = am3.h.c(r100);
        goto L3
    L7:
        switch(r103) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L8;
        };
    L9:
        r101.level3_thresHold = r100.j();
        goto L3
    L10:
        r101.level2_thresHold = r100.j();
        goto L3
    L11:
        r101.userId = r100.j();
        goto L3
    L12:
        r101.songId = r100.j();
        goto L3
    L13:
        r101.hotLevel = r100.i();
        goto L3
    L14:
        r101.hotStatus = r100.i();
        goto L3
    L15:
        r101.hot = r100.j();
        goto L3
    L16:
        r101.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        am3.h.d(r104, r100);
        goto L3
    L18:
        r100.d(r102);
        r101.getDelegate().setThreadSafe(true);
        return r101;
    }
}
