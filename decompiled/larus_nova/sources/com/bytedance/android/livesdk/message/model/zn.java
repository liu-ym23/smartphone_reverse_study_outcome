package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;

/* JADX INFO: loaded from: classes11.dex */
public final class zn implements am3.c<rd> {
    public zn() {
    }

    @Override // am3.c
    public final rd decode(am3.g r100) throws Exception {
        rd r101 = new rd();
        r101.getDelegate().setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        am3.g.a r104 = r101.getDelegate().decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.prompt = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.playModeType = r100.i();
        goto L3
    L11:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        r101.getDelegate().setThreadSafe(true);
        return r101;
    }
}
