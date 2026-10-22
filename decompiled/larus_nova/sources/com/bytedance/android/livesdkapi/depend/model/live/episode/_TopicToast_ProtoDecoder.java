package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _TopicToast_ProtoDecoder implements c<TopicToast> {
    public _TopicToast_ProtoDecoder() {
    }

    public static TopicToast decodeStatic(g r100) throws Exception {
        TopicToast r101 = new TopicToast();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 1) goto L8;
        r101.startTime = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.endTime = r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.content = h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L14;
        r101.schema = h.c(r100);
        goto L3
    L14:
        if (r103 != 5) goto L15;
        r101.toastId = h.c(r100);
        goto L3
    L15:
        h.e(r100);
        goto L3
    L21:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final TopicToast decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ TopicToast decode(g r100) throws Exception {
        return decode(r100);
    }
}
