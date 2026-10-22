package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.PreloadResourceResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "preloadResource")
public final class n1 extends e7.q<e7.p0, PreloadResourceResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m16.b f38732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f38733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f38734c;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f38733b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f38734c;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    public n1() {
    }

    public n1(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        this.f38732a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        e7.p0 r102 = (e7.p0) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.b();
        boolean r104 = false;
        if (r103 == null) goto L8;
        if (StringsKt.startsWith$default(r103, "http", false, 2, null) == true) goto L8;
        PreloadResourceResultModel r105 = new PreloadResourceResultModel();
        r105.a(PreloadResourceResultModel.Code.InvalidParam);
        r105.b("url mast start with http or null");
        finishWithResult(r105);
        return;
    L8:
        if (this.f38732a == null) goto L10;
        r104 = true;
    L10:
        if (r104 == false) goto L12;
        this.f38734c = Observable.just(1).subscribeOn(Schedulers.io()).map(new k1(r102, this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new l1(this), new m1(this));
        return;
    L12:
        this.f38733b = Observable.just(1).subscribeOn(Schedulers.io()).map(new h1(r102, r101)).observeOn(AndroidSchedulers.mainThread()).subscribe(new i1(this), new j1(this));
    }
}
