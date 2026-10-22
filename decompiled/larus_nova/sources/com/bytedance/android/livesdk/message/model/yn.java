package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;

/* JADX INFO: loaded from: classes11.dex */
public final class yn implements am3.c<gd> {
    public yn() {
    }

    @Override // am3.c
    public final gd decode(am3.g r100) throws Exception {
        gd r101 = new gd();
        r101.getDelegate().setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        am3.g.a r104 = r101.getDelegate().decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.videoContent = new dd(r100);
        goto L3
    L9:
        am3.h.d(r104, r100);
        goto L3
    L12:
        r100.d(r102);
        r101.getDelegate().setThreadSafe(true);
        return r101;
    }
}
