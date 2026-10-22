package com.bytedance.android.livesdk.livecommerce.promotionlist.base;

import android.view.View;
import com.bytedance.android.shopping.ligo.context.LigoViewManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements x83.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, List<x83.b>> f150898a;

    @Override // x83.a
    public final void clear() {
        dm.a.a("ItemCacheCenter").i("Clear list item view cache center");
        Iterator<Map.Entry<String, List<x83.b>>> r100 = this.f150898a.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Iterator<T> r101 = r100.next().getValue().iterator();
    L7:
        if (r101.hasNext() == false) goto L4;
        View r102 = ((x83.b) r101.next()).f562895a;
        int r103 = LigoViewManager.f176433l;
        LigoViewManager.a.a(r102);
        goto L7
    L9:
        this.f150898a.clear();
    }

    public d() {
        this.f150898a = new ConcurrentHashMap();
    }

    @Override // x83.a
    public final void a(String r100) {
        if (r100 != null) goto L4;
    L18:
        Iterator<Map.Entry<String, List<x83.b>>> r101 = this.f150898a.entrySet().iterator();
    L20:
        if (r101.hasNext() == false) goto L25;
        Iterator<T> r102 = r101.next().getValue().iterator();
    L23:
        if (r102.hasNext() == false) goto L20;
        View r103 = ((x83.b) r102.next()).f562895a;
        int r104 = LigoViewManager.f176433l;
        LigoViewManager.a.a(r103);
        goto L23
    L25:
        this.f150898a.clear();
        Unit r105 = Unit.INSTANCE;
        return;
    L4:
        if (r100.length() <= 0) goto L6;
        boolean r106 = true;
    L7:
        if (r106 == false) goto L9;
        String r107 = r100;
    L10:
        if (r107 == null) goto L18;
        List<x83.b> r108 = this.f150898a.get(r100);
        if (r108 == null) goto L17;
        Iterator<T> r109 = r108.iterator();
    L15:
        if (r109.hasNext() == false) goto L17;
        View r110 = ((x83.b) r109.next()).f562895a;
        int r111 = LigoViewManager.f176433l;
        LigoViewManager.a.a(r110);
    L17:
        this.f150898a.remove(r100);
        return;
    L9:
        r107 = null;
        goto L10
    L6:
        r106 = false;
        goto L7
    }

    @Override // x83.a
    public final List<x83.b> b(String r100) {
        dm.a.b r101 = dm.a.a("ItemCacheCenter");
        StringBuilder r102 = new StringBuilder("get view cache for ");
        r102.append(r100);
        r102.append(", has view = ");
        ConcurrentHashMap<String, List<x83.b>> r103 = this.f150898a;
        if (r100 != null) goto L5;
        String r104 = "";
    L6:
        List<x83.b> r105 = r103.get(r104);
        boolean r106 = false;
        if (r105 == null) goto L9;
        boolean r107 = true;
    L10:
        r102.append(r107);
        r101.a(r102.toString());
        if (r100 != null) goto L13;
    L21:
        return null;
    L13:
        if (r100.length() <= 0) goto L15;
        r106 = true;
    L15:
        if (r106 == false) goto L17;
        String r108 = r100;
    L18:
        if (r108 == null) goto L21;
        return this.f150898a.get(r100);
    L17:
        r108 = null;
        goto L18
    L9:
        r107 = false;
        goto L10
    L5:
        r104 = r100;
        goto L6
    }

    @Override // x83.a
    public final void c(String r100, List<x83.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        Intrinsics.checkNotNullParameter(r101, "viewsWrapper");
        dm.a.a("ItemCacheCenter").a("set view cache for " + r100);
        this.f150898a.put(r100, r101);
    }
}
