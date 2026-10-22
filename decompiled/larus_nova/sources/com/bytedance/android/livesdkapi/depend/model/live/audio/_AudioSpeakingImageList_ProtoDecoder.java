package com.bytedance.android.livesdkapi.depend.model.live.audio;

import am3.c;
import am3.g;
import am3.h;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _AudioSpeakingImageList_ProtoDecoder implements c<AudioSpeakingImageList> {
    public _AudioSpeakingImageList_ProtoDecoder() {
    }

    public static AudioSpeakingImageList decodeStatic(g r100) throws Exception {
        AudioSpeakingImageList r101 = new AudioSpeakingImageList();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.maleImage = (SpeakingImage) f.a(r100, SpeakingImage.class);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.femaleImage = (SpeakingImage) f.a(r100, SpeakingImage.class);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.unknownImage = (SpeakingImage) f.a(r100, SpeakingImage.class);
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.audioStageSpeakingImage = (SpeakingImage) f.a(r100, SpeakingImage.class);
        goto L3
    L13:
        h.d(r104, r100);
        goto L3
    L18:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final AudioSpeakingImageList decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ AudioSpeakingImageList decode(g r100) throws Exception {
        return decode(r100);
    }
}
