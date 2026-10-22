package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import w91.f;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b<D, VH extends w91.f> implements w91.b<D, VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f100037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j91.b<D> f100038b;

    @Override // w91.b
    public final void notifyDataSetChange() {
        j91.b<D> r100 = this.f100038b;
        if (r100 == null) goto L5;
        r100.onChange();
    L5:
        this.f100037a.a(null);
    }

    public b() {
        this.f100037a = new c();
    }

    @Override // w91.b
    public final void c(j91.b<D> r100) {
        this.f100038b = r100;
    }
}
