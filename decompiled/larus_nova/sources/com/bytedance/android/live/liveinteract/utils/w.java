package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes46.dex */
public final class w {
    public static String a() {
        ArrayList r100 = new ArrayList();
        com.bytedance.live.datacontext.j<LivePlayModeLogContext> r101 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r101 == null) goto L19;
        LivePlayModeLogContext r102 = r101.getValue();
        if (r102 == null) goto L19;
        com.bytedance.live.datacontext.m<Set<Integer>> r103 = r102.getPlayModes();
        if (r103 == null) goto L19;
        Set<Integer> r104 = r103.getValue();
        if (r104 == null) goto L19;
        Sequence r105 = CollectionsKt.asSequence(r104);
        if (r105 == null) goto L19;
        Iterator r106 = r105.iterator();
    L14:
        if (r106.hasNext() == false) goto L19;
        String r107 = c(((Number) r106.next()).intValue());
        if ((!Intrinsics.areEqual(r107, "normal")) == false) goto L14;
        r100.add(r107);
    L19:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 16) goto L22;
        r100.add("link_room");
    L22:
        if (r100.size() != 0) goto L25;
        r100.add("normal");
    L25:
        return CollectionsKt.joinToString$default(r100, ",", "[", "]", 0, null, null, 56, null);
    }

    static {
    }

    public static void b(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        com.bytedance.android.live.liveinteract.revenue.battle.b0 r101 = ((IInteractService) jc1.k.n(IInteractService.class)).guestBattleContext();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isGameShowing() == false) goto L9;
        HashMap r102 = (HashMap) r100;
        r102.put("compete_mode", String.valueOf(r101.getCurrentScoreType()));
        return;
    }

    public static String c(int r100) {
        String r101 = x.f78837a.get(Integer.valueOf(r100));
        if (r101 != null) goto L6;
        r101 = "normal";
    L6:
        return r101.concat("");
    }
}
