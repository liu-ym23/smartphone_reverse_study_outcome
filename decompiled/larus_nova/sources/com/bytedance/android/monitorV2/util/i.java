package com.bytedance.android.monitorV2.util;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class i extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f163237d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ArrayList<a> f163238e = null;

    static {
        f163237d = new i();
        kz2.a.C6634a r100 = kz2.a.f506727a;
        f163238e = CollectionsKt.arrayListOf(new a[]{t.f163255d, s.f163254d, e.f163235d});
    }

    public i() {
        super("default_bid");
    }

    @Override // com.bytedance.android.monitorV2.util.a
    public final a.C2495a a(String r100, String r101) {
        Iterator<a> r102 = f163238e.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        a.C2495a r103 = r102.next().a(r100, r101);
        if (r103.a() == false) goto L4;
        return r103;
    L9:
        return this.f163231b;
    }
}
