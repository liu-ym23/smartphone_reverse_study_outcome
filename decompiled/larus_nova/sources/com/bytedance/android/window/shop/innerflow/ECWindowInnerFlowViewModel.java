package com.bytedance.android.window.shop.innerflow;

import android.graphics.Bitmap;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.window.shop.innerflow.repo.ECWindowInnerFlowRepo;
import com.bytedance.android.window.shop.innerflow.repo.d;
import com.bytedance.android.window.shop.innerflow.repo.e;
import com.bytedance.android.window.shop.innerflow.widget.ControllerState;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002CDB\u0007¢\u0006\u0004\bA\u0010BJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nJ=\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00110\u00102\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000e\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0004H\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\"8\u0006¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010'R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R/\u00108\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\n060\u00108\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010@\u001a\u00020<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u00102\u001a\u0004\b>\u0010?¨\u0006E"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Lcom/bytedance/android/window/shop/innerflow/repo/d;", "callback", "", DitoNode.LOAD_MORE, "getShopCartInfo", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "release", "", "key", "default", "getParam", "", "keys", "", "Lkotlin/Pair;", "getParamPairs", "([Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "onCleared", "Lcom/bytedance/android/window/shop/innerflow/b;", "fakeInnerFlowParam", "Lcom/bytedance/android/window/shop/innerflow/b;", "innerFlowParam", "getInnerFlowParam", "()Lcom/bytedance/android/window/shop/innerflow/b;", "setInnerFlowParam", "(Lcom/bytedance/android/window/shop/innerflow/b;)V", "Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel$b;", "cardUIStatus", "Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel$b;", "getCardUIStatus", "()Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel$b;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lvp3/a;", "cartInfoLiveData", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getCartInfoLiveData", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "", "lynxModuleStatus", "getLynxModuleStatus", "Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel$a;", "flyWeight", "Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel$a;", "getFlyWeight", "()Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel$a;", "Lcom/bytedance/android/window/shop/innerflow/repo/ECWindowInnerFlowRepo;", "dataSource$delegate", "Lkotlin/Lazy;", "getDataSource", "()Lcom/bytedance/android/window/shop/innerflow/repo/ECWindowInnerFlowRepo;", "dataSource", "Lkotlin/Triple;", "", "viewCacheTriples", "Ljava/util/List;", "getViewCacheTriples", "()Ljava/util/List;", "Lcom/bytedance/android/ec/core/imagex/r;", "imageCallerContext$delegate", "getImageCallerContext", "()Lcom/bytedance/android/ec/core/imagex/r;", "imageCallerContext", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowViewModel extends BaseViewModel {
    private final b cardUIStatus;
    private final QLiveData<vp3.a> cartInfoLiveData;
    private final Lazy dataSource$delegate;
    private final com.bytedance.android.window.shop.innerflow.b fakeInnerFlowParam;
    private final a flyWeight;
    private final Lazy imageCallerContext$delegate;
    private com.bytedance.android.window.shop.innerflow.b innerFlowParam;
    private final QLiveData<Boolean> lynxModuleStatus;
    private final List<Triple<Integer, Integer, String>> viewCacheTriples;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<String> f189030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bitmap f189031b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RecyclerView.RecycledViewPool f189032c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RecyclerView.RecycledViewPool f189033d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final C2758a f189034e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f189035f;

        /* JADX INFO: renamed from: com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel$a$a, reason: collision with other inner class name */
        public static final class C2758a extends com.bytedance.android.ec.window.base.utils.window.c<ECVideoPlayer> {
            public C2758a() {
                super(3);
            }
        }

        public static final class b extends com.bytedance.android.ec.window.base.utils.window.c<TextView> {
            public b() {
                super(1);
            }
        }

        public final void a() {
            this.f189032c.clear();
            this.f189033d.clear();
            C2758a r100 = this.f189034e;
            Iterator r101 = r100.f49792a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ECVideoPlayer r102 = (ECVideoPlayer) r101.next();
            r102.q();
            r102.l();
            goto L4
        L6:
            Iterator r103 = r100.f49793b.iterator();
        L8:
            if (r103.hasNext() == false) goto L10;
            ECVideoPlayer r104 = (ECVideoPlayer) r103.next();
            r104.q();
            r104.l();
            goto L8
        L10:
            this.f189031b = null;
        }

        public a() {
            this.f189030a = new LinkedHashSet();
            this.f189032c = new RecyclerView.RecycledViewPool();
            this.f189033d = new RecyclerView.RecycledViewPool();
            this.f189034e = new C2758a();
            this.f189035f = new b();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final QLiveData<ControllerState> f189036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final QLiveData<ControllerState> f189037b;

        public b() {
            QLiveData<ControllerState> r100 = new QLiveData();
            ControllerState r101 = ControllerState.ENABLED;
            r100.g(r101);
            Unit r102 = Unit.INSTANCE;
            this.f189036a = r100;
            QLiveData<ControllerState> r103 = new QLiveData();
            r103.g(r101);
            this.f189037b = r103;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel$getShopCartInfo$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel$getShopCartInfo$1", f = "ECWindowInnerFlowViewModel.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ECWindowInnerFlowViewModel this$0;

        public AnonymousClass1(ECWindowInnerFlowViewModel r100, Continuation r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            Intrinsics.checkNotNullParameter(r101, "completion");
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            vp3.a r103 = (vp3.a) r100;
            if (r103 == null) goto L15;
            this.this$0.getCartInfoLiveData().e(r103);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ECWindowInnerFlowRepo r104 = ECWindowInnerFlowViewModel.access$getDataSource$p(this.this$0);
            this.label = 1;
            r100 = r104.d(this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel$loadMore$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel$loadMore$1", f = "ECWindowInnerFlowViewModel.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    public static final class C104141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ d $callback;
        int label;
        final /* synthetic */ ECWindowInnerFlowViewModel this$0;

        public C104141(ECWindowInnerFlowViewModel r100, d r101, Continuation r102) {
            this.this$0 = r100;
            this.$callback = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            Intrinsics.checkNotNullParameter(r101, "completion");
            return new C104141(this.this$0, this.$callback, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C104141) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            e r103 = (e) r100;
            if ((r103 instanceof e.d) == false) goto L15;
            this.$callback.b((List) ((e.d) r103).f189193a);
        L22:
            return Unit.INSTANCE;
        L15:
            if ((r103 instanceof e.a) == false) goto L18;
            this.$callback.onError();
            goto L22
        L18:
            if ((r103 instanceof e.c) == false) goto L20;
            this.$callback.a();
            goto L22
        L20:
            boolean r104 = r103 instanceof e.b;
            goto L22
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ECWindowInnerFlowRepo r105 = ECWindowInnerFlowViewModel.access$getDataSource$p(this.this$0);
            this.label = 1;
            r100 = r105.b(this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECWindowInnerFlowViewModel() {
        super(null, null == true ? 1 : 0, 3, null == true ? 1 : 0);
        com.bytedance.android.window.shop.innerflow.b r100 = new com.bytedance.android.window.shop.innerflow.b(MapsKt.emptyMap(), "", -1);
        this.fakeInnerFlowParam = r100;
        this.innerFlowParam = r100;
        this.cardUIStatus = new b();
        this.cartInfoLiveData = new QLiveData();
        QLiveData<Boolean> r101 = new QLiveData();
        r101.g(Boolean.FALSE);
        Unit r102 = Unit.INSTANCE;
        this.lynxModuleStatus = r101;
        this.flyWeight = new a();
        this.dataSource$delegate = LazyKt.lazy(new ECWindowInnerFlowViewModel$dataSource$2(this));
        this.viewCacheTriples = CollectionsKt.listOf(new Triple[]{new Triple(Integer.valueOf(R.layout.ec_shop_layout_inner_flow_video_card), 2, "ec_shop_layout_inner_flow_video_card"), new Triple(Integer.valueOf(R.layout.ec_shop_layout_inner_flow_element_hot_comment), 2, "ec_shop_layout_inner_flow_element_hot_comment"), new Triple(Integer.valueOf(R.layout.ec_shop_layout_inner_flow_element_barrage), 2, "ec_shop_layout_inner_flow_element_barrage"), new Triple(Integer.valueOf(R.layout.ec_shop_layout_inner_flow_element_item_comment_banner), 2, "ec_shop_layout_inner_flow_element_item_comment_banner"), new Triple(Integer.valueOf(R.layout.ec_shop_layout_inner_flow_element_item_barrage), 2, "ec_shop_layout_inner_flow_element_item_barrage")});
        this.imageCallerContext$delegate = LazyKt.lazy(ECWindowInnerFlowViewModel$imageCallerContext$2.INSTANCE);
    }

    private final ECWindowInnerFlowRepo getDataSource() {
        return (ECWindowInnerFlowRepo) this.dataSource$delegate.getValue();
    }

    public final r getImageCallerContext() {
        return (r) this.imageCallerContext$delegate.getValue();
    }

    public final void getShopCartInfo() {
        BuildersKt.launch$default(mg.b.a(this), Dispatchers.getMain(), null, new AnonymousClass1(this, null), 2, null);
    }

    @Override // com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel, com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.flyWeight.a();
    }

    public final b getCardUIStatus() {
        return this.cardUIStatus;
    }

    public final QLiveData<vp3.a> getCartInfoLiveData() {
        return this.cartInfoLiveData;
    }

    public final a getFlyWeight() {
        return this.flyWeight;
    }

    public final com.bytedance.android.window.shop.innerflow.b getInnerFlowParam() {
        return this.innerFlowParam;
    }

    public final QLiveData<Boolean> getLynxModuleStatus() {
        return this.lynxModuleStatus;
    }

    public final List<Triple<Integer, Integer, String>> getViewCacheTriples() {
        return this.viewCacheTriples;
    }

    public static final /* synthetic */ ECWindowInnerFlowRepo access$getDataSource$p(ECWindowInnerFlowViewModel r100) {
        return r100.getDataSource();
    }

    public final void loadMore(d r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        BuildersKt.launch$default(mg.b.a(this), Dispatchers.getMain().getImmediate(), null, new C104141(this, r100, null), 2, null);
    }

    public final void release(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        this.flyWeight.a();
        b r101 = this.cardUIStatus;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        r101.f189036a.f450948a.removeObservers(r100);
        r101.f189037b.f450948a.removeObservers(r100);
    }

    public final void setInnerFlowParam(com.bytedance.android.window.shop.innerflow.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.innerFlowParam = r100;
    }

    public final String getParam(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "default");
        com.bytedance.android.window.shop.innerflow.b r102 = this.innerFlowParam;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        String r103 = r102.f189039a.get(r100);
        if (r103 != null) goto L6;
        return r101;
    L6:
        return r103;
    }

    public final List<Pair<String, String>> getParamPairs(String[] r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        Intrinsics.checkNotNullParameter(r101, "default");
        ArrayList r102 = new ArrayList(r100.length);
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        String r105 = r100[r104];
        com.bytedance.android.window.shop.innerflow.b r106 = this.innerFlowParam;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r105, "key");
        String r107 = r106.f189039a.get(r105);
        if (r107 != null) goto L7;
        r107 = r101;
    L7:
        r102.add(TuplesKt.to(r105, r107));
        r104 = r104 + 1;
        goto L3
    L8:
        return r102;
    }

    public static /* synthetic */ String getParam$default(ECWindowInnerFlowViewModel r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = "";
    L6:
        return r100.getParam(r101, r102);
    }

    public static /* synthetic */ List getParamPairs$default(ECWindowInnerFlowViewModel r100, String[] r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = "";
    L6:
        return r100.getParamPairs(r101, r102);
    }
}
