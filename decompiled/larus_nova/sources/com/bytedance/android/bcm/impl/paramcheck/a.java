package com.bytedance.android.bcm.impl.paramcheck;

import com.bytedance.android.bcm.impl.model.f;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f41865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f41866b;

    public a() {
        this(null);
    }

    public a(Object r100) {
        this.f41865a = CollectionsKt.emptyList();
        this.f41866b = null;
    }

    public final f a(String r100) {
        Iterator<T> r101 = this.f41865a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((f) r102).a(), r100) == false) goto L4;
    L10:
        return (f) r102;
    L8:
        r102 = null;
        goto L10
    }
}
