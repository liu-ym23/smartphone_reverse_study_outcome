package com.bytedance.android.livesdk.link.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x4 {
    public static final List<h7> a(w4 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$mvpListInfoList");
        ArrayList r101 = new ArrayList();
        if (r100.getUserArmiesList().isEmpty() == false) goto L6;
        return null;
    L6:
        Iterator<T> r102 = r100.getUserArmiesList().iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        w4.b r103 = (w4.b) r102.next();
        h7 r104 = (h7) vh7.f.c(h7.class);
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r103.getUserArmies().iterator();
    L11:
        if (r106.hasNext() == false) goto L13;
        w4.b.InterfaceC2290b r107 = (w4.b.InterfaceC2290b) r106.next();
        h7.b r108 = (h7.b) vh7.f.c(h7.b.class);
        r108.setUserId(r107.getUserId());
        r108.setScore(r107.getScore());
        r108.setNickname(r107.getNickname());
        r108.setAvatar(r107.getAvatar());
        r105.add(r108);
        goto L11
    L13:
        r104.setRankList(r105);
        r101.add(r104);
        goto L8
    L14:
        return r101;
    }
}
