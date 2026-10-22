package com.bytedance.android.ec.sdk.plugin.initializer;

import com.bytedance.android.ec.common.api.marketing.IMarketingRouterUtilsService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes44.dex */
public final class MarketingServiceV2Initializer extends com.bytedance.android.ec.sdk.initalizer.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f48159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f48160c;

    public static final class a<T> implements ServiceProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MarketingServiceV2Initializer f48161a;

        public a(MarketingServiceV2Initializer r100) {
            this.f48161a = r100;
        }

        @Override // com.ss.android.ugc.aweme.framework.services.ServiceProvider
        public final Object get() {
            return (IMarketingServiceV2) this.f48161a.f48159b.getValue();
        }
    }

    public static final class b<T> implements ServiceProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MarketingServiceV2Initializer f48162a;

        public b(MarketingServiceV2Initializer r100) {
            this.f48162a = r100;
        }

        @Override // com.ss.android.ugc.aweme.framework.services.ServiceProvider
        public final Object get() {
            return (IMarketingRouterUtilsService) this.f48162a.f48160c.getValue();
        }
    }

    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object b() {
        Lazy r100 = ECAppInfoService.f48110a;
        return Boxing.boxBoolean(we.a.f559330a);
    }

    public MarketingServiceV2Initializer() {
        this.f48159b = LazyKt.lazy(MarketingServiceV2Initializer$ecMarketingServiceV2$2.INSTANCE);
        this.f48160c = LazyKt.lazy(MarketingServiceV2Initializer$ecMarketingRouterService$2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object c(Continuation<? super Unit> r100) {
        Lazy r101 = ECAppInfoService.f48110a;
        if (we.a.f559330a == false) goto L9;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L6
        ServiceManager.get().bind(IMarketingServiceV2.class, new a(this));     // Catch: Throwable -> L6
        Result.m9449constructorimpl(ServiceManager.get().bind(IMarketingRouterUtilsService.class, new b(this)));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L9:
        return Unit.INSTANCE;
    }
}
