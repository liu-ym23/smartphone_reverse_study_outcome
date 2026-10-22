package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m6<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String[] f63552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f63553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f63554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0 f63555d;

    public m6(String[] r100, String r101, Function0 r102, Function0 r103) {
        this.f63552a = r100;
        this.f63553b = r101;
        this.f63554c = r102;
        this.f63555d = r103;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        IMiddlewareHostBusiness r101 = (IMiddlewareHostBusiness) jc1.k.f(IMiddlewareHostBusiness.class);     // Catch: Exception -> L14
        if (r101 == null) goto L6;
        Integer r102 = Integer.valueOf(r101.concatVideo(this.f63552a, this.f63553b));     // Catch: Exception -> L14
    L7:
        if (r102 != null) goto L10;
    L12:
        this.f63555d.invoke();     // Catch: Exception -> L14
        r100.onError(new RuntimeException("concat failed with result " + r102 + '.'));     // Catch: Exception -> L14
        return;
    L10:
        if (r102.intValue() != 0) goto L12;
        this.f63554c.invoke();     // Catch: Exception -> L14
        r100.onNext(95);     // Catch: Exception -> L14
        r100.onComplete();     // Catch: Exception -> L14
        return;
    L6:
        r102 = null;
    L14:
        e = move-exception;
        r100.onError(e);
    }
}
