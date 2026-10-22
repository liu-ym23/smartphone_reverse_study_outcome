package com.bytedanceos.appstore.buss.network.demo;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
public final class DemoRepository extends BaseRepository {
    public DemoRepository() {
    }

    public static final /* synthetic */ Object f(DemoRepository r10, Response r11, Function3 r12, Function3 r13, Continuation r14) {
        return r10.c(r11, r12, r13, r14);
    }

    public final Object g(Continuation r10) {
        return e(new DemoRepository$getData1$2(this, null), r10);
    }

    public final Object h(Continuation r10) {
        return e(new DemoRepository$getData2$2(this, null), r10);
    }
}
