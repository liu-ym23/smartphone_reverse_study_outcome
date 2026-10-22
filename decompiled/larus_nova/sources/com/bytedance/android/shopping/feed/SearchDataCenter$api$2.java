package com.bytedance.android.shopping.feed;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/feed/SearchWordApi;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class SearchDataCenter$api$2 extends Lambda implements Function0<SearchWordApi> {
    public static final SearchDataCenter$api$2 INSTANCE = null;

    static {
        INSTANCE = new SearchDataCenter$api$2();
    }

    public SearchDataCenter$api$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SearchWordApi invoke() {
        int r100 = ld3.f.f508690a;
        int r101 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
        Object r102 = Boolean.TRUE;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r104 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r105 = jj4.a.a("ec_video_search_domain_opt", Boolean.class, r102, false);     // Catch: Throwable -> L7
        if (r105 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        if (((Boolean) r105).booleanValue() == false) goto L17;
        return (SearchWordApi) com.bytedance.android.ec.sdk.helper.n.f48128a.create("https://tsearch.amemv.com", SearchWordApi.class);
    L17:
        return (SearchWordApi) com.bytedance.android.ec.sdk.helper.n.f48128a.create("https://search.amemv.com", SearchWordApi.class);
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == true) goto L12;
        r102 = r107;
    L12:
        r105 = r102;
        goto L14
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SearchWordApi invoke() {
        return invoke();
    }
}
