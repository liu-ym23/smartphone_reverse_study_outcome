package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.c;
import am3.g;
import am3.h;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _BattleStarActivityGradeMedal_ProtoDecoder implements c<BattleStarActivityGradeMedal> {
    public _BattleStarActivityGradeMedal_ProtoDecoder() {
    }

    public static BattleStarActivityGradeMedal decodeStatic(g r100) throws Exception {
        BattleStarActivityGradeMedal r101 = new BattleStarActivityGradeMedal();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.gradeMedal = (k) f.a(r100, k.class);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.levelImage = (k) f.a(r100, k.class);
        goto L3
    L9:
        h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final BattleStarActivityGradeMedal decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ BattleStarActivityGradeMedal decode(g r100) throws Exception {
        return decode(r100);
    }
}
