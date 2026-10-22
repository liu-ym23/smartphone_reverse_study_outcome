package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
public final class b0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f166604a;

    public b0(Function1 r100) {
        this.f166604a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Function1 r102 = this.f166604a;
        int r103 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "error: " + r101.getMessage(), null, null, 41));
        EnsureManager.ensureNotReachHere("FetchDataActionHandler " + r101);
    }
}
