package com.bytedance.android.window.shop.home.tab.common;

import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes14.dex */
public final class a<L> implements Iterable<L>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<L> f188738a;

    @Override // java.lang.Iterable
    public final Iterator<L> iterator() {
        return this.f188738a.iterator();
    }

    public a() {
        this.f188738a = new LinkedHashSet();
    }
}
