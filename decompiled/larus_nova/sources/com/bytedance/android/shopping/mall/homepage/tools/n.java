package com.bytedance.android.shopping.mall.homepage.tools;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes13.dex */
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f178534c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, CompletableDeferred<Object>> f178535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f178536b;

    public static final class a {
    }

    static {
    }

    public n() {
        this.f178535a = new ConcurrentHashMap();
        this.f178536b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    public final <T> T a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestKey");
        CompletableDeferred<Object> r101 = this.f178535a.get(r100);
        if (r101 == null) goto L5;
        Object r102 = r101.getCompleted();
    L7:
        if ((r102 instanceof Object) == true) goto L10;
        return null;
    L10:
        return (T) r102;
    L5:
        r102 = null;
        goto L7
    }
}
