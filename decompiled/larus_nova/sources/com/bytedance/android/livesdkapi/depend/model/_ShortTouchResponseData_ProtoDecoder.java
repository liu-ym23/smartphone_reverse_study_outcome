package com.bytedance.android.livesdkapi.depend.model;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.live.base.model.n;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class _ShortTouchResponseData_ProtoDecoder implements c<ShortTouchResponseData> {
    public _ShortTouchResponseData_ProtoDecoder() {
    }

    public static ShortTouchResponseData decodeStatic(g r100) throws Exception {
        ShortTouchResponseData r101 = new ShortTouchResponseData();
        r101.shortTouchAreas = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.shortTouchAreas.add(new n(r100));
        goto L3
    L7:
        h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final ShortTouchResponseData decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ ShortTouchResponseData decode(g r100) throws Exception {
        return decode(r100);
    }
}
