package com.bytedance.android.livesdk.vscore_impl.paidlive.util.preload;

import com.bytedance.android.livesdk.vscore_api.paidlive.ability.common.EntPreloadApi;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonObject;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Result;", "Lcom/google/gson/JsonObject;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.vscore_impl.paidlive.util.preload.EntPreloadRequest$getBuyPanel$2", f = "EntPreloadRequest.kt", i = {}, l = {36, 64, 64}, m = "invokeSuspend", n = {}, s = {})
final class EntPreloadRequest$getBuyPanel$2 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends JsonObject>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $adId;
    final /* synthetic */ int $buySource;
    final /* synthetic */ int $currentEpisode;
    final /* synthetic */ boolean $firstEnter;
    final /* synthetic */ boolean $isPurchaseAll;
    final /* synthetic */ boolean $isSelectedDeduct;
    final /* synthetic */ int $personalStrategy;
    final /* synthetic */ String $productId;
    final /* synthetic */ String $selectedCoupon;
    final /* synthetic */ Object $selectedPurchasePackage;
    final /* synthetic */ String $tradePassThrough;
    final /* synthetic */ boolean $useDefaultCoupon;
    final /* synthetic */ boolean $useDefaultDeduct;
    private /* synthetic */ Object L$0;
    int label;

    public EntPreloadRequest$getBuyPanel$2(String r100, int r101, boolean r102, boolean r103, Object r104, boolean r105, boolean r106, boolean r107, String r108, String r110, int r111, int r112, String r113, Continuation r114) {
        this.$productId = r100;
        this.$currentEpisode = r101;
        this.$firstEnter = r102;
        this.$isPurchaseAll = r103;
        this.$selectedPurchasePackage = r104;
        this.$useDefaultDeduct = r105;
        this.$useDefaultCoupon = r106;
        this.$isSelectedDeduct = r107;
        this.$selectedCoupon = r108;
        this.$adId = r110;
        this.$buySource = r111;
        this.$personalStrategy = r112;
        this.$tradePassThrough = r113;
        super(2, r114);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        Intrinsics.checkNotNullParameter(r111, "completion");
        EntPreloadRequest$getBuyPanel$2 r100 = new EntPreloadRequest$getBuyPanel$2(this.$productId, this.$currentEpisode, this.$firstEnter, this.$isPurchaseAll, this.$selectedPurchasePackage, this.$useDefaultDeduct, this.$useDefaultCoupon, this.$isSelectedDeduct, this.$selectedCoupon, this.$adId, this.$buySource, this.$personalStrategy, this.$tradePassThrough, r111);
        r100.L$0 = r110;
        return r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Result<? extends JsonObject>> r100, Continuation<? super Unit> r101) {
        return ((EntPreloadRequest$getBuyPanel$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 == 1) goto L11;
        if (r102 == 2) goto L10;
        if (r102 == 3) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        FlowCollector r103 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r100);
    L54:
        Result r104 = Result.m9448boximpl(Result.m9449constructorimpl(r100));
        this.L$0 = null;
        this.label = 3;
        if (r103.emit(r104, this) != r101) goto L61;
        return r101;
    L61:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r100);
        goto L61
    L12:
        ResultKt.throwOnFailure(r100);
        r103 = (FlowCollector) this.L$0;
        String r105 = this.$productId;
        boolean r106 = false;
        if (r105 != null) goto L15;
    L18:
        boolean r107 = true;
    L19:
        if (r107 == false) goto L21;
    L57:
        Result.Companion r108 = Result.Companion;
        Result r109 = Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalArgumentException("productId = " + this.$productId + " currentEpisode = " + this.$currentEpisode))));
        this.label = 1;
        if (r103.emit(r109, this) != r101) goto L61;
        return r101;
    L21:
        if (Intrinsics.areEqual(this.$productId, "null") == true) goto L57;
        if (Intrinsics.areEqual(this.$productId, "0") == true) goto L57;
        JsonObject r110 = new JsonObject();
        r110.addProperty("product_id", this.$productId.toString());
        r110.addProperty("current_episode", Boxing.boxInt(this.$currentEpisode));
        r110.addProperty("first_enter", Boxing.boxBoolean(this.$firstEnter));
        r110.addProperty("is_purchase_all", Boxing.boxBoolean(this.$isPurchaseAll));
        Object r111 = this.$selectedPurchasePackage;
        if (r111 == null) goto L28;
        r110.addProperty("selected_purchase_package", r111.toString());
    L28:
        r110.addProperty("use_default_deduct", Boxing.boxBoolean(this.$useDefaultDeduct));
        r110.addProperty("use_default_coupon", Boxing.boxBoolean(this.$useDefaultCoupon));
        r110.addProperty("is_selected_deduct", Boxing.boxBoolean(this.$isSelectedDeduct));
        String r112 = this.$selectedCoupon;
        if (r112 == null) goto L31;
        r110.addProperty("selected_coupon", r112);
    L31:
        String r113 = this.$adId;
        if (r113 != null) goto L34;
    L38:
        r110.addProperty("buy_source", Boxing.boxInt(this.$buySource));
        int r114 = this.$personalStrategy;
        if (r114 < 0) goto L41;
        r110.addProperty("personal_strategy", Boxing.boxInt(r114));
    L41:
        int r115 = com.bytedance.android.livesdk.live.a.f147266a;
        if (com.bytedance.android.livesdk.live.a.c(this.$tradePassThrough) == false) goto L44;
        r110.addProperty("trade_pass_through", this.$tradePassThrough);
    L44:
        r110.addProperty("buy_panel_scene", Boxing.boxInt(1));
        Result.Companion r116 = Result.Companion;
        int r117 = b.f160606a;
        PaidEntBillNetClient r118 = (PaidEntBillNetClient) PaidEntBillNetClient.f160603c.getValue();
        r118.getClass();
        Intrinsics.checkNotNullParameter(EntPreloadApi.class, "cls");
        if (r118.f160604a.contains(EntPreloadApi.class) == true) goto L51;
        ConcurrentHashMap<Class<?>, Object> r119 = r118.f160604a;
        Object r120 = r118.f160605b.getRetrofitInstance().create(EntPreloadApi.class);
        if (r120 == null) goto L50;
        r119.putIfAbsent(EntPreloadApi.class, r120);
        goto L51
    L50:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L51:
        EntPreloadApi r121 = (EntPreloadApi) r118.f160604a.get(EntPreloadApi.class);
        this.L$0 = r103;
        this.label = 2;
        r100 = r121.getBuyPanel(r110, this);
        if (r100 != r101) goto L54;
        return r101;
    L34:
        if (r113.length() <= 0) goto L36;
        r106 = true;
    L36:
        if (r106 != true) goto L38;
        r110.addProperty("ad_id", this.$adId);
        goto L38
    L15:
        if (r105.length() == 0) goto L18;
        r107 = false;
        goto L19
    }
}
