package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> extends j91.a<j91.b<T>> {
    public c() {
    }

    public final <D> void a(D r100) {
        List<T> r101 = this.f497763a;
        monitor-enter(r101);
        int r102 = ((ArrayList) this.f497763a).size();     // Catch: Throwable -> L16
    L5:
        r102 = r102 - 1;     // Catch: Throwable -> L16
        if (r102 < 0) goto L13;
        Object r103 = ((ArrayList) this.f497763a).get(r102);     // Catch: Throwable -> L16
        if ((r103 instanceof j91.b) == true) goto L10;
        r103 = null;
    L10:
        j91.b r104 = (j91.b) r103;     // Catch: Throwable -> L16
        if (r104 == null) goto L5;
        r104.onChange();     // Catch: Throwable -> L16
        goto L5
    L13:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r101);
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
