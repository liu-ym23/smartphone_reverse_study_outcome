package com.bytedance.android.livesdkapi.depend.message;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.LinkerBaseInfo;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.livesdk.link.model.bridge.k;
import java.util.ArrayList;
import java.util.HashMap;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _RoomLinkMicSyncData_ProtoDecoder implements c<RoomLinkMicSyncData> {
    public _RoomLinkMicSyncData_ProtoDecoder() {
    }

    public static RoomLinkMicSyncData decodeStatic(g r110) throws Exception {
        RoomLinkMicSyncData r100 = new RoomLinkMicSyncData();
        r100.setThreadSafe(false);
        r100.mLinkUsers = new ArrayList();
        r100.lockedPositions = new ArrayList();
        r100.positions = new ArrayList();
        r100.linkerContentMap = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L39;
        g.a r103 = r100.decodeExtensionFields(r102, r110);
        if (r102 != 1) goto L8;
        r100.mLinkUsers.add((k) f.a(r110, k.class));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        long r104 = r110.c();
        Long r105 = null;
        RoomLinkerContent r106 = null;
    L23:
        int r111 = r110.f();
        if (r111 == (-1)) goto L30;
        if (r111 != 1) goto L26;
        r105 = Long.valueOf(r110.j());
        goto L23
    L26:
        if (r111 != 2) goto L23;
        r106 = (RoomLinkerContent) f.a(r110, RoomLinkerContent.class);
        goto L23
    L30:
        r110.d(r104);
        if (r105 == null) goto L37;
        if (r106 == null) goto L35;
        r100.linkerContentMap.put(r105, r106);
        goto L3
    L35:
        throw new IllegalStateException("Map value must not be null!");
    L37:
        throw new IllegalStateException("Map key must not be null!");
    L10:
        if (r102 != 3) goto L12;
        r100.linkerBaseInfo = new LinkerBaseInfo(r110);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        r100.lockedPositions.add((LinkmicPositionItem) f.a(r110, LinkmicPositionItem.class));
        goto L3
    L14:
        if (r102 != 5) goto L16;
        r100.positions.add((LinkmicPositionItem) f.a(r110, LinkmicPositionItem.class));
        goto L3
    L16:
        if (r102 != 7) goto L17;
        r100.clientUIInfo = (ClientUIInfo) f.a(r110, ClientUIInfo.class);
        goto L3
    L17:
        h.d(r103, r110);
        goto L3
    L39:
        r110.d(r101);
        r100.setThreadSafe(true);
        return r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final RoomLinkMicSyncData decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ RoomLinkMicSyncData decode(g r100) throws Exception {
        return decode(r100);
    }
}
