package com.bytedance.android.shopping.abscontainer.arch.core.starter;

import com.bytedance.android.shopping.abscontainer.arch.platform.net.PlatformHttpRequestAPI;
import g43.g;
import g43.i;
import java.util.Map;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class QueryFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f164149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f164150b;

    public QueryFetcher(b r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "queryAPI");
        Intrinsics.checkNotNullParameter(r101, "record");
        this.f164149a = r100;
        this.f164150b = r101;
    }

    public final void a(final Function1<? super n33.f, Unit> r100, final Function1<? super n33.c, Unit> r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "successCallback");
        Intrinsics.checkNotNullParameter(r101, "failureCallback");
        final Function1<Result<? extends g<n33.a>>, Unit> r103 = new QueryFetcher$fetch$completion$1(this, r100, r101);
        d r104 = this.f164150b.f164172a;
        if (r104.f164167e != null) goto L5;
        r104.f164167e = Long.valueOf(System.currentTimeMillis());
    L5:
        Map<String, Object> r105 = this.f164149a.d(r102);
        d r106 = this.f164150b.f164172a;
        if (r106.f164168f != null) goto L8;
        r106.f164168f = Long.valueOf(System.currentTimeMillis());
    L8:
        PlatformHttpRequestAPI r107 = i.f479991a;
        i.a(this.f164149a.c(), this.f164149a.e(), r105, n33.a.class, new QueryFetcher$fetch$1(r103));
        f r108 = this.f164150b;
        r108.f164173b = this.f164149a.b();
    }
}
