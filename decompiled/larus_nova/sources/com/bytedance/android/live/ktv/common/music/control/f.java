package com.bytedance.android.live.ktv.common.music.control;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f70030a;

    public f() {
        this.f70030a = ((Boolean) vm2.h.K1.getValue(null, vm2.h.f556082a[139(0x8b, float:1.95E-43)])).booleanValue();
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.h
    public final boolean a(IMusicControlNode r100, CopyOnWriteArrayList<IMusicControlNode> r101, CopyOnWriteArrayList<IMusicControlNode> r102) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "waitingList");
        Intrinsics.checkNotNullParameter(r102, "runningList");
        boolean r103 = true;
        boolean r104 = !r102.isEmpty();
        Iterator<T> r105 = r102.iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        Object r106 = r105.next();
        if ((((IMusicControlNode) r106) instanceof c) == false) goto L4;
    L9:
        if (r106 != null) goto L13;
        r103 = false;
    L13:
        if (this.f70030a == true) goto L15;
        return r104;
    L15:
        return r103;
    L8:
        r106 = null;
        goto L9
    }
}
