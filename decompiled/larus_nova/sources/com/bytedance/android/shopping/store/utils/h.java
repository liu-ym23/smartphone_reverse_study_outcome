package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f186925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f186926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f186927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PolarisFileWrapper f186928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PolarisFileReaderWrapper f186929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedList<String> f186930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f186931g;

    public final void a() {
        PolarisFileReaderWrapper r100 = this.f186929e;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = e.f186924a;
        ArrayList r102 = new ArrayList();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        BufferedReader r104 = new BufferedReader(r100);     // Catch: Throwable -> L11
        String r105 = r104.readLine();     // Catch: Throwable -> L11
    L7:
        if (r105 == null) goto L9;
        r102.add(r105);     // Catch: Throwable -> L11
        r105 = r104.readLine();     // Catch: Throwable -> L11
        goto L7
    L9:
        r104.close();     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        this.f186926b = r102.size();
        this.f186930f.addAll(r102);
        return;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public final void b() {
        Iterator<String> r100 = this.f186930f.iterator();
        this.f186926b = this.f186930f.size();
    L4:
        if (this.f186926b <= this.f186925a) goto L9;
        String r101 = r100.next();
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.f186931g, r101 + ".js");
        int r103 = e.f186924a;
        Intrinsics.checkNotNullParameter(r102, "$this$deleteIfExists");
        if (r102.exists() == false) goto L8;
        r102.delete();
    L8:
        r100.remove();
        this.f186926b--;
        goto L4
    }

    public h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filesDir");
        this.f186931g = r100;
        Lazy r101 = ECStoreSettings.f48572a;
        int r102 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
        Object r103 = 100;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r105 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r106 = jj4.a.a("ec_shop_isv_cache_size", Integer.class, r103, false);     // Catch: Throwable -> L7
        if (r106 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        this.f186925a = ((Number) r106).intValue();
        PolarisFileWrapper r107 = new PolarisFileWrapper(this.f186931g);
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107, "lru_info");
        this.f186928d = r108;
        this.f186930f = new LinkedList();
    L22:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L15:
        if (r107.exists() == true) goto L18;
        r107.mkdir();     // Catch: Throwable -> L22
    L18:
        if (r108.exists() == true) goto L20;
        r108.createNewFile();     // Catch: Throwable -> L22
    L20:
        this.f186929e = new PolarisFileReaderWrapper(r108);     // Catch: Throwable -> L22
        a();     // Catch: Throwable -> L22
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
        return;
    L7:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Object r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r111) == true) goto L12;
        r103 = r111;
    L12:
        r106 = r103;
        goto L13
    }
}
