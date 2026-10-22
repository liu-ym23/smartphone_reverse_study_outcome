package com.bytedance.android.live.screenrotate.rotate;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements com.bytedance.android.live.room.api.screenrotation.rotate.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.live.room.api.screenrotation.rotate.a> f100579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c81.a> f100580b;

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final void d() {
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final void release() {
        ((ArrayList) this.f100579a).clear();
        this.f100580b.clear();
    }

    public b() {
        this.f100579a = new ArrayList();
        this.f100580b = CollectionsKt.mutableListOf(new c81.a[]{oa1.a.f522529a});
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final List<com.bytedance.android.live.room.api.screenrotation.rotate.a> b() {
        return this.f100579a;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final List<c81.a> e() {
        return this.f100580b;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final void a(com.bytedance.android.live.room.api.screenrotation.rotate.a r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        if (((ArrayList) this.f100579a).contains(r100) == true) goto L6;
        ((ArrayList) this.f100579a).add(r100);
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final void c(c81.a r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        if (this.f100580b.contains(r100) == true) goto L6;
        this.f100580b.add(r100);
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final void f(com.bytedance.android.live.room.api.screenrotation.rotate.a r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        ((ArrayList) this.f100579a).remove(r100);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final void g(c81.a r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.f100580b.remove(r100);
    }
}
