package com.bytedance.android.ec.core.address;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Disposable> f43673a;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.address.a$a, reason: collision with other inner class name */
    public static final class C0789a {
    }

    static {
    }

    public a() {
        this.f43673a = new ConcurrentHashMap();
    }

    public final void a(String r100, Disposable r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "disposable");
        Intrinsics.checkNotNullParameter(r100, "key");
        Disposable r102 = this.f43673a.remove(r100);
        if (r102 != null) goto L5;
    L7:
        this.f43673a.put(r100, r101);
        return;
    L5:
        if (r102.isDisposed() == true) goto L7;
        r102.dispose();
        goto L7
    }
}
