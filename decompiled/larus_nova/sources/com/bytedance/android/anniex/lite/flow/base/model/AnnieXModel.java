package com.bytedance.android.anniex.lite.flow.base.model;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class AnnieXModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f40927a;

    public static final class a {
    }

    static {
    }

    public final void a() {
        ConcurrentHashMap r100 = (ConcurrentHashMap) this.f40927a.getValue();
        if (r100 == null) goto L16;
        Iterator r101 = r100.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        Object r102 = ((Map.Entry) r101.next()).getValue();
        if (r102 == null) goto L6;
        if ((r102 instanceof Closeable) == false) goto L6;
        ((Closeable) r102).close();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    L16:
        ConcurrentHashMap r103 = (ConcurrentHashMap) this.f40927a.getValue();
        if (r103 == null) goto L28;
        r103.clear();
        return;
    }

    public AnnieXModel() {
        this.f40927a = LazyKt.lazy(AnnieXModel$mBagOfTags$2.INSTANCE);
    }
}
