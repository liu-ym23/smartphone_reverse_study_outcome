package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes46.dex */
public final class r<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f75056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataCenter f75057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f75058c;

    public r(Context r100, DataCenter r101, int r102) {
        this.f75056a = r100;
        this.f75057b = r101;
        this.f75058c = r102;
    }

    @Override // java.util.concurrent.Callable
    public final Long call() {
        long r100 = System.currentTimeMillis();
        ih0.c r101 = u.f75061a;
        u.a(this.f75056a, this.f75057b, this.f75058c);
        return Long.valueOf(System.currentTimeMillis() - r100);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
