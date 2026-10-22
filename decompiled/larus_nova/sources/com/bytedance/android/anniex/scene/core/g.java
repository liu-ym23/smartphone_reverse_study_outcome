package com.bytedance.android.anniex.scene.core;

import java.util.Iterator;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements Grouping<k, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f41139a;

    @Override // kotlin.collections.Grouping
    public final Iterator<k> sourceIterator() {
        return this.f41139a.iterator();
    }

    public g(Iterable r100) {
        this.f41139a = r100;
    }

    @Override // kotlin.collections.Grouping
    public final String keyOf(k r100) {
        return r100.f41155a;
    }
}
