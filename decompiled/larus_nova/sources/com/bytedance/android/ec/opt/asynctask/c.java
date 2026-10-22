package com.bytedance.android.ec.opt.asynctask;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements IDispatcher {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<j> f48037b;

    public c() {
        ArrayList r100 = new ArrayList();
        this.f48037b = r100;
        r100.add(new v());
        r100.add(new b());
        r100.add(new y());
        r100.add(new p());
        r100.add(new q());
        r100.add(new e());
        r100.add(new f());
    }

    public final void a(i r100, w r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "policy");
        Intrinsics.checkNotNullParameter(r101, "task");
        StringBuilder r103 = new StringBuilder();
    L3:
        s r104 = r100.a();
        r103.append(r100.name());
        if ((r100 instanceof k) == false) goto L25;
        if (Intrinsics.areEqual(r100, r104) == false) goto L25;
        if ((r100 instanceof l) == false) goto L10;
        String r105 = ((l) r100).f48040b.toString();
    L11:
        String r106 = r103.toString();
        Iterator r107 = ((ArrayList) this.f48037b).iterator();
    L13:
        if (r107.hasNext() == false) goto L34;
        j r108 = (j) r107.next();
        if (Intrinsics.areEqual(r108.name(), r106) == false) goto L13;
        if ((r108 instanceof h) == false) goto L20;
        ((h) r108).setKey(r105);
    L20:
        if (r102 != 1) goto L22;
        r108.b(r101);
        return;
    L22:
        if (r102 != 0) goto L33;
        r108.a(r101);
        return;
    L33:
        return;
    L34:
        return;
    L10:
        r105 = "";
    L25:
        r103.append("_");
        r100 = r104;
        goto L3
    }
}
