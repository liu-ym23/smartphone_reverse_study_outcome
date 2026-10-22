package com.bytedance.android.livesdkapi.depend.model.live.audio;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _VoiceLiveTheme_ProtoDecoder implements c<VoiceLiveTheme> {
    public _VoiceLiveTheme_ProtoDecoder() {
    }

    public static VoiceLiveTheme decodeStatic(g r100) throws Exception {
        VoiceLiveTheme r101 = new VoiceLiveTheme();
        r101.setThreadSafe(false);
        r101.iconMicNormals = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L42;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L35;
            case 8: goto L34;
            case 9: goto L33;
            case 10: goto L32;
            case 11: goto L31;
            case 12: goto L30;
            case 13: goto L29;
            case 14: goto L28;
            case 15: goto L27;
            case 16: goto L26;
            case 17: goto L25;
            case 18: goto L24;
            case 19: goto L23;
            case 20: goto L22;
            case 21: goto L21;
            case 22: goto L20;
            case 23: goto L19;
            case 24: goto L18;
            case 25: goto L17;
            case 26: goto L16;
            case 27: goto L15;
            case 28: goto L7;
            case 29: goto L14;
            case 30: goto L13;
            case 31: goto L12;
            case 32: goto L11;
            case 33: goto L10;
            case 34: goto L9;
            case 35: goto L8;
            default: goto L7;
        };
    L8:
        r101.isPreLoad = h.a(r100);
        goto L3
    L9:
        r101.speakImageListV2 = (AudioSpeakingImageList) f.a(r100, AudioSpeakingImageList.class);
        goto L3
    L10:
        r101.formatType = r100.i();
        goto L3
    L11:
        r101.endTime = r100.j();
        goto L3
    L12:
        r101.startTime = r100.j();
        goto L3
    L13:
        r101.themeTag = h.c(r100);
        goto L3
    L14:
        r101.playMode = r100.i();
        goto L3
    L15:
        r101.animatedBgInfo = new AnimatedBgInfo(r100);
        goto L3
    L16:
        r101.bgStatus = r100.i();
        goto L3
    L17:
        r101.themeLabel = h.c(r100);
        goto L3
    L18:
        r101.colorMicBG = h.c(r100);
        goto L3
    L19:
        r101.colorMicLine = h.c(r100);
        goto L3
    L20:
        r101.colorMicText = h.c(r100);
        goto L3
    L21:
        r101.iconMicLock = (k) f.a(r100, k.class);
        goto L3
    L22:
        r101.iconMicNormals.add((k) f.a(r100, k.class));
        goto L3
    L23:
        r101.micBGColorValue = h.c(r100);
        goto L3
    L24:
        r101.imageColdBg = (k) f.a(r100, k.class);
        goto L3
    L25:
        r101.emptyEndColor = h.c(r100);
        goto L3
    L26:
        r101.emptyStartColor = h.c(r100);
        goto L3
    L27:
        r101.bgType = r100.i();
        goto L3
    L28:
        r101.timeLimit = r100.i();
        goto L3
    L29:
        r101.publicScreenColorValue = h.c(r100);
        goto L3
    L30:
        r101.statusColorValue = h.c(r100);
        goto L3
    L31:
        r101.speakImageList = (AudioSpeakingImageList) f.a(r100, AudioSpeakingImageList.class);
        goto L3
    L32:
        r101.singleStaticBackground = (k) f.a(r100, k.class);
        goto L3
    L33:
        r101.seatIcon = (k) f.a(r100, k.class);
        goto L3
    L34:
        r101.effectAvatarStartTalk = (k) f.a(r100, k.class);
        goto L3
    L35:
        r101.effectAvatarTalk = (k) f.a(r100, k.class);
        goto L3
    L36:
        r101.animatedBackground = (k) f.a(r100, k.class);
        goto L3
    L37:
        r101.thumbnailBackground = (k) f.a(r100, k.class);
        goto L3
    L38:
        r101.staticBackground = (k) f.a(r100, k.class);
        goto L3
    L39:
        r101.imageType = r100.i();
        goto L3
    L40:
        r101.imageUri = h.c(r100);
        goto L3
    L41:
        r101.f162615id = r100.j();
        goto L3
    L7:
        h.d(r104, r100);
        goto L3
    L42:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final VoiceLiveTheme decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ VoiceLiveTheme decode(g r100) throws Exception {
        return decode(r100);
    }
}
