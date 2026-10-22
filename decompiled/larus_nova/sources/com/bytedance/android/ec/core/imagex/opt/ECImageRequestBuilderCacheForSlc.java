package com.bytedance.android.ec.core.imagex.opt;

import android.util.LruCache;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class ECImageRequestBuilderCacheForSlc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f44787a = null;

    static {
        f44787a = LazyKt.lazy(ECImageRequestBuilderCacheForSlc$imageRequestCache$2.INSTANCE);
    }

    public static Triple a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Lazy r101 = f44787a;
        SoftReference r102 = (SoftReference) ((LruCache) r101.getValue()).get(r100);
        if (r102 == null) goto L5;
        Triple r103 = (Triple) r102.get();
    L6:
        if (r103 == null) goto L8;
        List r104 = (List) r103.getSecond();
    L9:
        List r105 = r104;
        if (r105 != null) goto L12;
    L15:
        boolean r106 = true;
    L16:
        if (r106 == false) goto L21;
        if (r102 == null) goto L20;
        if (r103 != null) goto L20;
        ((LruCache) r101.getValue()).remove(r100);
    L20:
        return null;
    L21:
        return r103;
    L12:
        if (r105.isEmpty() == true) goto L15;
        r106 = false;
        goto L16
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }
}
