package com.bytedance.ai.applet.moa;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f34838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f34839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u2.e f34840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<u2.f> f34841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f34842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile f f34843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f34844g;

    public final u2.f a() {
        return (u2.f) CollectionsKt.getOrNull(this.f34841d, this.f34844g);
    }

    public g(i r100, m r101, u2.e r102, List r103, boolean r104, com.bytedance.applet.impl.moa.a r105) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "grantingData");
        Intrinsics.checkNotNullParameter(r103, "grantingItems");
        Intrinsics.checkNotNullParameter(r105, "callback");
        this.f34838a = r100;
        this.f34839b = r101;
        this.f34840c = r102;
        this.f34841d = r103;
        this.f34842e = r104;
        this.f34843f = r105;
    }
}
