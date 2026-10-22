package com.bytedance.android.shopping.skubuy.platform.data.api;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.buynow.ultimate.data.remote.UltimateBuyNowApi;
import com.bytedance.android.shopping.utils.s;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.SsResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import q43.a;
import r43.c;
import r43.d;

/* JADX INFO: loaded from: classes13.dex */
public final class PlatformSkuBuyRepository implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SkuBuyApi f183158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PlatformSkuBuyRepository f183159b = null;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.skubuy.platform.data.api.PlatformSkuBuyRepository$createOrder$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@"}, d2 = {"Lr43/c;", ContainerPosition.BODY, "", "", "", "urlParams", "Lkotlin/coroutines/Continuation;", "Lr43/d;", "continuation", "createOrder"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.shopping.skubuy.platform.data.api.PlatformSkuBuyRepository", f = "PlatformSkuBuyRepository.kt", i = {}, l = {21}, m = "createOrder", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PlatformSkuBuyRepository this$0;

        public AnonymousClass1(PlatformSkuBuyRepository r100, Continuation r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.createOrder(null, null, this);
        }
    }

    public PlatformSkuBuyRepository() {
    }

    @Override // q43.a
    public final void a() {
    }

    static {
        f183159b = new PlatformSkuBuyRepository();
        n r100 = n.f48128a;
        UltimateBuyNowApi.f171179a.getClass();
        f183158a = (SkuBuyApi) r100.create(UltimateBuyNowApi.a.f171180a, SkuBuyApi.class);
    }

    @Override // q43.a
    public final Object createOrder(c r100, Map<String, ? extends Object> r101, Continuation<? super d> r102) {
        if ((r102 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r103 = (AnonymousClass1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L21
    L19:
        return (d) ((SsResponse) r105).body();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        SkuBuyApi r108 = f183158a;     // Catch: Exception -> L21
        r103.label = 1;     // Catch: Exception -> L21
        r105 = r108.createOrder(r100, r101, r103);     // Catch: Exception -> L21
        if (r105 != r106) goto L19;
        return r106;
    L21:
        e = move-exception;
        d r109 = new d(0);
        r109.c(s.a(e));
        return r109;
    L7:
        r103 = new AnonymousClass1(this, r102);
        goto L8
    }
}
