package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f38839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CallContext f38840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f38841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f38842d;

    public v(s r100, CallContext r101, String r102, String r103) {
        this.f38839a = r100;
        this.f38840b = r101;
        this.f38841c = r102;
        this.f38842d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f38839a.finishWithFailure(r101);
        IAnnieNetworkService r102 = this.f38839a.f38814c;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("service");
        r102 = null;
    L5:
        r102.handleFetchError(this.f38840b.f249269d, this.f38841c, this.f38842d, r101);
    }
}
