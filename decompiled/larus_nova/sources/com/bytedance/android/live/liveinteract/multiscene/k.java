package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.android.live.base.model.user.o0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k {
    public static final String b(j r100) {
        o0.a r101 = o0.f58946a;
        Long r102 = Long.valueOf(r100.get_ownerId());
        String r103 = r100.get_ownerOpenId();
        r101.getClass();
        return o0.a.g(r102, r103);
    }

    public static final boolean c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$hasPlayer");
        if (r100.getPlayers() == null) goto L7;
        List<f> r101 = r100.getPlayers();
        Intrinsics.checkNotNull(r101);
        if ((!r101.isEmpty()) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static final f a(j r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getFightPlayerById");
        Intrinsics.checkNotNullParameter(r101, "userId");
        if (c(r100) == false) goto L12;
        List<f> r102 = r100.getPlayers();
        Intrinsics.checkNotNull(r102);
        Iterator<f> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L20;
        f r104 = r103.next();
        if (r104 == null) goto L6;
        if (Intrinsics.areEqual(r104.getUserIdString(), r101) == false) goto L6;
        return r104;
    L20:
        return null;
    L12:
        return null;
    }
}
