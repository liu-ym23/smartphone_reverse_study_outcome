package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.livesdk.config.lc0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.PlayModeConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public final class d0 {
    @Deprecated(message = "replace by CPositionContext.getContext().isCPositionOpen.value")
    public static boolean d() {
        return ((gd0.n) jc1.k.f(gd0.n.class)).isCPositionOpen();
    }

    public static Pair<Boolean, Long> a(int r100) {
        lc0 r101 = lc0.f120668a;
        if (r101.getValue().totalEnable == true) goto L7;
        return new Pair(Boolean.FALSE, 0L);
    L7:
        if (r101.getValue().supportPlayModes == null) goto L9;
        PlayModeConfig r102 = r101.getValue().supportPlayModes.get(Integer.valueOf(r100));
    L10:
        if (r102 == null) goto L14;
        return new Pair(Boolean.TRUE, Long.valueOf(r102.consumeDelay));
    L14:
        return new Pair(Boolean.FALSE, 0L);
    L9:
        r102 = null;
        goto L10
    }

    public static boolean b(List<Long> r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.contains(32L) == false) goto L6;
        return true;
    }

    public static boolean c(List<Integer> r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.contains(13) == false) goto L6;
        return true;
    }

    public static boolean e(List<Integer> r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.contains(4) == false) goto L6;
        return true;
    }

    public static boolean f(List<Long> r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.contains(4L) == false) goto L6;
        return true;
    }

    public static boolean g(List<Integer> r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.contains(6) == false) goto L6;
        return true;
    }

    public static boolean h(IRoom r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getLinkInitResult() == null) goto L8;
        int r101 = r100.getLinkInitResult().getUiLayout();
    L13:
        if (r100.getLinkInitResult() != null) goto L15;
    L20:
        boolean r102 = false;
    L22:
        if (r100.getLinkerDetail() == null) goto L30;
        if (r100.getLinkerDetail().isTeamFightShowing() == false) goto L30;
        if (r100.getLinkerDetail().isFlexibleTeamFight() == false) goto L28;
        r102 = false;
        goto L30
    L28:
        r102 = true;
    L30:
        if (r101 != 24) goto L32;
    L34:
        return true;
    L32:
        if (r101 != 22) goto L36;
        if (r102 == false) goto L34;
        return false;
    L36:
        return false;
    L15:
        if (r100.getLinkInitResult().isTeamFightShowing() == false) goto L20;
        if (r100.getLinkInitResult().isFlexibleTeamFight() == true) goto L20;
        r102 = true;
        goto L22
    L8:
        if (r100.getLinkerDetail() != null) goto L10;
        r101 = 21;
        goto L13
    L10:
        r101 = r100.getLinkerDetail().getUiLayout();
        goto L13
    }

    public static boolean i(List<Long> r100) {
        if (lc0.f120668a.getValue().totalEnable == true) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        Iterator<Long> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L16;
        long r102 = r101.next().longValue();
        lc0 r103 = lc0.f120668a;
        if (r103.getValue().supportPlayModes == null) goto L9;
        if (r103.getValue().supportPlayModes.containsKey(Integer.valueOf((int) r102)) == false) goto L9;
        return true;
    L16:
        return false;
    }
}
