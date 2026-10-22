package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _VSToolbarConfigData_ProtoDecoder implements c<VSToolbarConfigData> {
    public _VSToolbarConfigData_ProtoDecoder() {
    }

    public static VSToolbarConfigData decodeStatic(g r100) throws Exception {
        VSToolbarConfigData r101 = new VSToolbarConfigData();
        r101.setThreadSafe(false);
        r101.toastList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        r101.toastList.add(_TopicToast_ProtoDecoder.decodeStatic(r100));
        goto L3
    L9:
        r101.bottomIcon = (k) f.a(r100, k.class);
        goto L3
    L10:
        r101.dynamicBottomIcon = (k) f.a(r100, k.class);
        goto L3
    L11:
        r101.iconVertical = (k) f.a(r100, k.class);
        goto L3
    L12:
        r101.dynamicIcon = (k) f.a(r100, k.class);
        goto L3
    L13:
        r101.displayType = r100.i();
        goto L3
    L14:
        r101.schema = h.c(r100);
        goto L3
    L15:
        r101.icon = (k) f.a(r100, k.class);
        goto L3
    L16:
        r101.type = r100.i();
        goto L3
    L7:
        h.d(r104, r100);
        goto L3
    L17:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final VSToolbarConfigData decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ VSToolbarConfigData decode(g r100) throws Exception {
        return decode(r100);
    }
}
