package com.bytedance.android.live.network.impl.interceptor.business;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f83864a;

    /* JADX INFO: renamed from: com.bytedance.android.live.network.impl.interceptor.business.a$a, reason: collision with other inner class name */
    public static final class C1271a {
    }

    static {
    }

    public a() {
        this.f83864a = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.android.live.network.impl.interceptor.business.b
    public final void a(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "paramMapInOut");
        Iterator<b> r102 = this.f83864a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a(r100, r101);
        goto L4
    }
}
