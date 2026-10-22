package com.bytedance.android.livesdk.chatroom.model.interact;

import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class b3 implements am3.c<MultiAnchorLinkmicLiveCoreInfo> {
    public b3() {
    }

    @Override // am3.c
    public final MultiAnchorLinkmicLiveCoreInfo decode(am3.g r110) throws Exception {
        MultiAnchorLinkmicLiveCoreInfo r100 = new MultiAnchorLinkmicLiveCoreInfo();
        r100.setThreadSafe(false);
        r100.liveCoreExtInfoMap = new HashMap();
        r100.pushStreamModeLiveCoreMap = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L41;
        am3.g.a r103 = r100.decodeExtensionFields(r102, r110);
        Long r111 = null;
        if (r102 != 1) goto L7;
        long r112 = r110.c();
        String r104 = null;
    L26:
        int r105 = r110.f();
        if (r105 == (-1)) goto L33;
        if (r105 != 1) goto L29;
        r111 = Long.valueOf(r110.j());
        goto L26
    L29:
        if (r105 != 2) goto L26;
        r104 = am3.h.c(r110);
        goto L26
    L33:
        r110.d(r112);
        if (r111 == null) goto L40;
        if (r104 == null) goto L38;
        r100.liveCoreExtInfoMap.put(r111, r104);
        goto L3
    L38:
        throw new IllegalStateException("Map value must not be null!");
    L40:
        throw new IllegalStateException("Map key must not be null!");
    L7:
        if (r102 != 2) goto L8;
        long r113 = r110.c();
        String r106 = null;
    L10:
        int r107 = r110.f();
        if (r107 == (-1)) goto L17;
        if (r107 != 1) goto L13;
        r111 = Long.valueOf(r110.j());
        goto L10
    L13:
        if (r107 != 2) goto L10;
        r106 = am3.h.c(r110);
        goto L10
    L17:
        r110.d(r113);
        if (r111 == null) goto L24;
        if (r106 == null) goto L22;
        r100.pushStreamModeLiveCoreMap.put(r111, r106);
        goto L3
    L22:
        throw new IllegalStateException("Map value must not be null!");
    L24:
        throw new IllegalStateException("Map key must not be null!");
    L8:
        am3.h.d(r103, r110);
        goto L3
    L41:
        r110.d(r101);
        r100.setThreadSafe(true);
        return r100;
    }
}
