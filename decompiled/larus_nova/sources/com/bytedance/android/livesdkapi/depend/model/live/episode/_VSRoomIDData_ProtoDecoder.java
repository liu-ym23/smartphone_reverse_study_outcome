package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _VSRoomIDData_ProtoDecoder implements c<VSRoomIDData> {
    public _VSRoomIDData_ProtoDecoder() {
    }

    public static VSRoomIDData decodeStatic(g r100) throws Exception {
        VSRoomIDData r101 = new VSRoomIDData();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.episodeStage = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.episode = (Episode) f.a(r100, Episode.class);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.room = (IRoom) f.a(r100, IRoom.class);
        goto L3
    L11:
        h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final VSRoomIDData decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ VSRoomIDData decode(g r100) throws Exception {
        return decode(r100);
    }
}
