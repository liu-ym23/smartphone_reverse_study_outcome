package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _VSCameraInfo_ProtoDecoder implements c<VSCameraInfo> {
    public _VSCameraInfo_ProtoDecoder() {
    }

    public static VSCameraInfo decodeStatic(g r100) throws Exception {
        VSCameraInfo r101 = new VSCameraInfo();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L24;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L7;
            case 18: goto L9;
            case 19: goto L7;
            case 20: goto L7;
            case 21: goto L8;
            default: goto L7;
        };
    L8:
        r101.banSwitch = h.a(r100);
        goto L3
    L9:
        r101.isSubscribed = h.a(r100);
        goto L3
    L10:
        r101.label = (k) f.a(r100, k.class);
        goto L3
    L11:
        r101.cameraType = r100.i();
        goto L3
    L12:
        r101.groupId = r100.j();
        goto L3
    L13:
        r101.cameraMatchInfo = new CameraMatchInfo(r100);
        goto L3
    L14:
        r101.cameraRoomAuth = (IRoomAuthStatus) f.a(r100, IRoomAuthStatus.class);
        goto L3
    L15:
        r101.style = r100.i();
        goto L3
    L16:
        r101.endTime = r100.j();
        goto L3
    L17:
        r101.startTim = r100.j();
        goto L3
    L18:
        r101.streamUrl = (IBaseStreamUrl) f.a(r100, IBaseStreamUrl.class);
        goto L3
    L19:
        r101.verticalCover = (k) f.a(r100, k.class);
        goto L3
    L20:
        r101.cover = (k) f.a(r100, k.class);
        goto L3
    L21:
        r101.title = h.c(r100);
        goto L3
    L22:
        r101.cameraIdStr = h.c(r100);
        goto L3
    L23:
        r101.cameraId = r100.j();
        goto L3
    L7:
        h.d(r104, r100);
        goto L3
    L24:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final VSCameraInfo decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ VSCameraInfo decode(g r100) throws Exception {
        return decode(r100);
    }
}
