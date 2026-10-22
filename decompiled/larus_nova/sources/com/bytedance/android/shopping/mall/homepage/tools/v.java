package com.bytedance.android.shopping.mall.homepage.tools;

import android.util.LruCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class v<Int> extends LruCache<Int, Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f178543c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Int> f178544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f178545b;

    public static final class a {
    }

    static {
        f178543c = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(Int r100) {
        if (r100 == 0) goto L6;
        super(((Integer) r100).intValue());
        this.f178544a = Collections.synchronizedList(new ArrayList());
        this.f178545b = Boolean.FALSE;
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Override // android.util.LruCache
    public final void trimToSize(int r100) {
        super.trimToSize(r100);
    }

    @Override // android.util.LruCache
    public final void entryRemoved(boolean r100, Int r101, Object r102, Object r103) {
        super.entryRemoved(r100, r101, r102, r103);
        if (r100 == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.f178545b, Boolean.FALSE) == true) goto L7;
        return;
    L7:
        if ((!Intrinsics.areEqual(r101, null)) == true) goto L9;
        return;
    L9:
        if ((!Intrinsics.areEqual(r101, 0)) == false) goto L15;
        this.f178544a.add(r101);
        return;
    }
}
