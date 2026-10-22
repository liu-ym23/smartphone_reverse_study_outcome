package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.android.livesdk.gift.model.n;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<e> f188945a;

    public final void b() {
        Iterator<T> r100 = this.f188945a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((e) r100.next()).b();
        goto L4
    L6:
        this.f188945a.clear();
    }

    public f() {
        this.f188945a = new LinkedHashSet();
    }

    public final void a(e... r100) {
        Intrinsics.checkNotNullParameter(r100, n.KEY_PLUGINS);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102].a();
        r102 = r102 + 1;
        goto L3
    L5:
        CollectionsKt.addAll(this.f188945a, r100);
    }
}
