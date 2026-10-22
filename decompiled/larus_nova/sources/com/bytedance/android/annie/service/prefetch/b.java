package com.bytedance.android.annie.service.prefetch;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends AbsAnnieGeckoResLoader {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f39943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f39944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f39945e;

    public b() {
        this(0);
    }

    @Override // com.bytedance.android.annie.service.prefetch.AbsAnnieGeckoResLoader, com.bytedance.android.annie.service.prefetch.n
    public Context getContext() {
        return this.f39943c;
    }

    public b(int r100) {
        Application r101 = com.bytedance.android.annie.ng.g.a();
        String r102 = com.bytedance.android.annie.resource.m.a(null);
        String r103 = com.bytedance.android.annie.resource.m.c();
        this.f39943c = r101;
        this.f39944d = r102;
        this.f39945e = r103;
    }
}
