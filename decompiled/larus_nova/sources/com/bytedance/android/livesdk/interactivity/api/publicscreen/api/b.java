package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.AudienceMsgOptPanel")
public final class b extends a implements vh7.h {
    public b(am3.g r100) {
        this.itemList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.itemList.add(e0.a(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        this.itemList.isEmpty();
    }
}
