package com.bytedance.android.live.livepkaudience.seat;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, PkSeatAnimationView> f82240a;

    public f() {
        this.f82240a = new LinkedHashMap();
    }

    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Map<String, PkSeatAnimationView> r101 = this.f82240a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        PkSeatAnimationView r103 = (PkSeatAnimationView) r102.get(r100.f82236a.f559921a.getIdString());
        if (r103 == null) goto L5;
        SeatAnimTaskState r104 = r103.getTaskState();
    L6:
        if (r104 != null) goto L8;
        return;
    L8:
        if (r104 != SeatAnimTaskState.LINK_SUC_ANIM) goto L10;
        return;
    L10:
        if (r104 == SeatAnimTaskState.GUEST_BATTLE_ANIM) goto L22;
        Map<String, PkSeatAnimationView> r105 = this.f82240a;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        PkSeatAnimationView r107 = (PkSeatAnimationView) r106.get(r100.f82236a.f559921a.getIdString());
        if (r107 == null) goto L20;
        Intrinsics.checkNotNullParameter(r100, "event");
        g r108 = r107.f82230a;
        if (r108 == null) goto L21;
        Intrinsics.checkNotNullParameter(r100, "event");
        r108.f82242b.a(r100);
        return;
    L21:
        return;
    L20:
        return;
    L22:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
