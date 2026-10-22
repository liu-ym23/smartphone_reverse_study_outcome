package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class z<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fi3.i f166736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f166737b;

    public z(fi3.i r100, y r101, Function1 r102) {
        this.f166736a = r100;
        this.f166737b = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<SsResponse<String>> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L23
        Call<String> r102 = null;
        if (Intrinsics.areEqual(this.f166736a.d(), Boolean.TRUE) == false) goto L11;
        String r103 = this.f166736a.c();     // Catch: Throwable -> L23
        if (r103 == null) goto L16;
        PDPFetchDataApi.f166579a.getClass();     // Catch: Throwable -> L23
        PDPFetchDataApi r104 = PDPFetchDataApi.a.f166580a;     // Catch: Throwable -> L23
        if (r104 == null) goto L16;
        Call<String> r105 = r104.fetchPost(r103, this.f166736a.b());     // Catch: Throwable -> L23
    L10:
        r102 = r105;
    L16:
        if (r102 == null) goto L20;
        SsResponse<String> r106 = r102.execute();     // Catch: Throwable -> L23
        if (r106 == null) goto L20;
        r100.onNext(r106);     // Catch: Throwable -> L23
        Object r107 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L21:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L23
    L25:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L31;
        r100.tryOnError(r109);
        return;
    L31:
        return;
    L20:
        r107 = Boolean.valueOf(r100.tryOnError(new Throwable("empty response error !")));     // Catch: Throwable -> L23
        goto L21
    L11:
        String r110 = this.f166736a.c();     // Catch: Throwable -> L23
        if (r110 == null) goto L16;
        PDPFetchDataApi.f166579a.getClass();     // Catch: Throwable -> L23
        PDPFetchDataApi r111 = PDPFetchDataApi.a.f166580a;     // Catch: Throwable -> L23
        if (r111 == null) goto L16;
        r105 = r111.fetchGet(r110, this.f166736a.b());     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    }
}
