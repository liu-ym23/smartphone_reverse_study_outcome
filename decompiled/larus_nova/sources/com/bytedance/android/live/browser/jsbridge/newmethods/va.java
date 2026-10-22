package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes45.dex */
public final class va<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wa f63691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CallContext f63692b;

    public va(wa r100, CallContext r101) {
        this.f63691a = r100;
        this.f63692b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        String r102 = (String) r101.component1();
        com.ss.ugc.live.sdk.message.wrsc.data.a r103 = (com.ss.ugc.live.sdk.message.wrsc.data.a) r101.component2();
        wa.j(this.f63691a, r103, this.f63692b);
    }
}
