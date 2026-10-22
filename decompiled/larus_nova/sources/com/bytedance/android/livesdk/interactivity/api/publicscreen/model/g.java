package com.bytedance.android.livesdk.interactivity.api.publicscreen.model;

import am3.h;
import com.bytedance.android.livesdk.chatroom.model.n;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements am3.c<b> {
    public g() {
    }

    @Override // am3.c
    public final b decode(am3.g r100) throws Exception {
        b r101 = new b();
        r101.messages = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.messages.add(new n(r100));
        goto L3
    L7:
        h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }
}
