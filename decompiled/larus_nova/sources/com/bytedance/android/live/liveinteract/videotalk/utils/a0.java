package com.bytedance.android.live.liveinteract.videotalk.utils;

import com.bytedance.android.live.profit.dress.config.LinkmicPlayMode;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.ILinkerDetailKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a0 {
    public static final int b(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        z5 r101 = IRoomKt_androidKt.getLinkerDetailKt(r100);
        if (r101 != null) goto L5;
        return 0;
    L5:
        if (ILinkerDetailKt.getUiLayoutExt(r101) != 0) goto L7;
        return 0;
    L7:
        return ILinkerDetailKt.getUiLayoutExt(r101);
    }

    public static final int a(int r100, IRoom r101) {
        Intrinsics.checkNotNullParameter(r101, "room");
        z5 r102 = IRoomKt_androidKt.getLinkerDetailKt(r101);
        if (r102 != null) goto L5;
        return 0;
    L5:
        if (ILinkerDetailKt.getUiLayoutExt(r102) != 0) goto L7;
        List<Long> r103 = ILinkerDetailKt.getPlayModesEx(r102);
        if (r103 == null) goto L15;
        List<Long> r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r105.add(Long.valueOf(((Number) r106.next()).longValue()));
        goto L12
    L14:
        List r107 = CollectionsKt.toList(r105);
    L17:
        if (r107 != null) goto L19;
    L41:
        if (r100 != 12) goto L44;
        return 5;
    L44:
        if (r100 != 16) goto L57;
    L45:
        return 51;
    L57:
        return 0;
    L19:
        if (r107.isEmpty() == true) goto L41;
        if (r107.contains(Long.valueOf(LinkmicPlayMode.DYNAMIC_WINDOW_LAYOUT.getValue())) == false) goto L27;
        if (r100 != 12) goto L50;
        return 2;
    L50:
        return 7;
    L27:
        if (r107.contains(Long.valueOf(LinkmicPlayMode.C_POSITION_LAYOUT.getValue())) == false) goto L32;
        if (r100 != 12) goto L52;
        return 3;
    L52:
        return 6;
    L32:
        if (r107.contains(Long.valueOf(LinkmicPlayMode.VIDEO_CHAT_FLOAT_WINDOW_LAYOUT.getValue())) == false) goto L36;
        if (r100 == 12) goto L36;
        return 1;
    L36:
        if (r107.contains(Long.valueOf(LinkmicPlayMode.VIDEO_TEAM_FIGHT_LAYOUT.getValue())) == false) goto L39;
        return 4;
    L39:
        if (r107.contains(Long.valueOf(LinkmicPlayMode.LINK_ROOM_FIGHT.getValue())) == true) goto L45;
        return 0;
    L15:
        r107 = null;
        goto L17
    L7:
        return ILinkerDetailKt.getUiLayoutExt(r102);
    }
}
