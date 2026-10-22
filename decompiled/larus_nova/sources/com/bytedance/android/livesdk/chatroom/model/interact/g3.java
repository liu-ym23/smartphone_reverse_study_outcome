package com.bytedance.android.livesdk.chatroom.model.interact;

import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class g3 implements am3.c<SingingChallengeLiveCoreInfo> {
    public g3() {
    }

    @Override // am3.c
    public final SingingChallengeLiveCoreInfo decode(am3.g r110) throws Exception {
        SingingChallengeLiveCoreInfo r100 = new SingingChallengeLiveCoreInfo();
        r100.setThreadSafe(false);
        r100.livecoreInfoMap = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L25;
        am3.g.a r103 = r100.decodeExtensionFields(r102, r110);
        if (r102 != 1) goto L7;
        long r104 = r110.c();
        Long r105 = null;
        String r106 = null;
    L9:
        int r107 = r110.f();
        if (r107 == (-1)) goto L17;
        if (r107 != 1) goto L13;
        r105 = Long.valueOf(r110.j());
        goto L9
    L13:
        if (r107 != 2) goto L9;
        r106 = am3.h.c(r110);
        goto L9
    L17:
        r110.d(r104);
        if (r105 == null) goto L24;
        if (r106 == null) goto L22;
        r100.livecoreInfoMap.put(r105, r106);
        goto L3
    L22:
        throw new IllegalStateException("Map value must not be null!");
    L24:
        throw new IllegalStateException("Map key must not be null!");
    L7:
        am3.h.d(r103, r110);
        goto L3
    L25:
        r110.d(r101);
        r100.setThreadSafe(true);
        return r100;
    }
}
