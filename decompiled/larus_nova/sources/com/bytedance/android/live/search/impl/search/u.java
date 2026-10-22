package com.bytedance.android.live.search.impl.search;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f100790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f100791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f100792c;

    public u(t r100, String r101, int r102) {
        this.f100790a = r100;
        this.f100791b = r101;
        this.f100792c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ra1.h r101 = (ra1.h) r100;
        String r102 = this.f100791b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f536810a = r102;
        t r103 = this.f100790a;
        if (r103.f100787b != this.f100792c) goto L6;
        r103.f100789d.Xp(r101);
        return;
    }
}
