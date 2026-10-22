package com.bytedance.android.live.revenue.platform.room.impl;

import com.bytedance.android.scope.o;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public class h implements o, yz0.n, yz0.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.scope.a<g> f91621a;

    @Override // com.bytedance.android.scope.o
    public void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // yz0.o
    public final void Ci() {
        Iterator<g> r100 = this.f91621a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onViewReady();
        goto L4
    }

    @Override // yz0.o
    public final void E() {
        Iterator<g> r100 = this.f91621a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onWidgetLoaded();
        goto L4
    }

    @Override // yz0.o
    public final void n8() {
        Iterator<g> r100 = this.f91621a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().i();
        goto L4
    }

    @Override // yz0.o
    public final void x() {
        Iterator<g> r100 = this.f91621a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().x();
        goto L4
    }

    public h(e33.a r100) {
        Intrinsics.checkNotNullParameter(r100, "roomStateDispatcher");
        this.f91621a = r100;
    }
}
