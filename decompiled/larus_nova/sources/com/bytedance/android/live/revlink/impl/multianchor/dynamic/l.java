package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f94090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f94091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Integer, Unit> f94092c;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "notifyDynamicConfigRefresh");
        this.f94092c = r100;
        this.f94090a = new LinkedHashSet();
        this.f94091b = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.g
    public final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        return this.f94090a.contains(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.g
    public final void a(List<String> r100, int r101) {
        jy0.b.c("MultiLocalComponentManager", "updateLocalComponent with tag: " + r100, null, 4);
        this.f94090a.clear();
        Set<String> r102 = this.f94090a;
        if (r100 != null) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        r102.addAll(r100);
        this.f94092c.invoke(Integer.valueOf(r101));
    }
}
