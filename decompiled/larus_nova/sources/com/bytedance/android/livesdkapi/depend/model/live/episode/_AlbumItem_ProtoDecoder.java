package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _AlbumItem_ProtoDecoder implements c<AlbumItem> {
    public _AlbumItem_ProtoDecoder() {
    }

    public static AlbumItem decodeStatic(g r100) throws Exception {
        AlbumItem r101 = new AlbumItem();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 1) goto L8;
        r101.episode = (Episode) f.a(r100, Episode.class);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.room = (IRoom) f.a(r100, IRoom.class);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.type = r100.i();
        goto L3
    L12:
        if (r103 != 4) goto L14;
        r101.isPlaying = h.a(r100);
        goto L3
    L14:
        if (r103 != 5) goto L15;
        r101.isHide = h.a(r100);
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
    public final AlbumItem decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ AlbumItem decode(g r100) throws Exception {
        return decode(r100);
    }
}
