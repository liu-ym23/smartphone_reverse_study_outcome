package com.bytedance.android.livesdk.player.newstrategy.pullstream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<e> f155964a = null;

    static {
        f155964a = new ArrayList();
    }

    public static void a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        p r101 = new p();
        ((ArrayList) f155964a).add(r101);
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        e r103 = ((e.a) r102.next()).create();
        ((ArrayList) f155964a).add(r103);
        goto L4
    L6:
        d r104 = new d();
        ((ArrayList) f155964a).add(r104);
    }
}
