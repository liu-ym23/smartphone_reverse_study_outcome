package com.bytedance.android.shopping.new_cart.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.dto.CartMarketingResourceSchemaResponse;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.android.shopping.new_cart.repo.CartRepository;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001SB\u0007¢\u0006\u0004\bP\u0010QJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0003J\u001c\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006*\u00020\u0005H\u0002J4\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002J\"\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0006H\u0002J2\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00032\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u000eJ*\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00192\b\b\u0001\u0010\n\u001a\u00020\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\b\u0010%\u001a\u00020\u0002H\u0014J\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&J\u001e\u0010*\u001a\u00020\u00192\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u000206058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u000206098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020>058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00108R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020>098\u0006¢\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010=R\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010BR\u001d\u0010H\u001a\u0004\u0018\u00010C8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001d\u0010M\u001a\u0004\u0018\u00010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006T"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/viewmodel/CartViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/new_cart/viewmodel/CartState;", "", "getCartResourceExposeRecords", "", "", "toMutableStringKeyMapOrNull", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "response", "queryScene", "", RuleConditionBean.VERSION_CODE_KEY, "Lkotlin/Function0;", "", "successCallBack", "onGetQuery", "", "e", "onGetQueryErr", "getCommonTrackerParams", "name", "params", "duplicateKey", "doEventAction", "", "hasMore", "updateHasMore", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "queryForCoupon", "Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "objectContainer", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "reloadGul", "doQuery", "defaultState", "", "fps", "changeFps", "map", "updateExtraParam", "Lcom/bytedance/android/shopping/new_cart/yata/customdata/a;", "customDataCenter", "Lcom/bytedance/android/shopping/new_cart/yata/customdata/a;", "getCustomDataCenter", "()Lcom/bytedance/android/shopping/new_cart/yata/customdata/a;", "setCustomDataCenter", "(Lcom/bytedance/android/shopping/new_cart/yata/customdata/a;)V", "Lbg3/a;", "trackerImpl", "Lbg3/a;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/shopping/new_cart/viewmodel/d;", "_onQueryStartLiveData", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "onQueryStartLiveData", "Landroidx/lifecycle/LiveData;", "getOnQueryStartLiveData", "()Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/shopping/new_cart/viewmodel/c;", "_onQueryEndLiveData", "onQueryEndLiveData", "getOnQueryEndLiveData", "Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "Lvf3/a;", "multiUpdateImpl$delegate", "Lkotlin/Lazy;", "getMultiUpdateImpl", "()Lvf3/a;", "multiUpdateImpl", "Lcom/bytedance/android/shopping/new_cart/container/CartSliceCustomWidgetAdapterComponent;", "cartSliceCustomWidgetAdapterComponent$delegate", "getCartSliceCustomWidgetAdapterComponent", "()Lcom/bytedance/android/shopping/new_cart/container/CartSliceCustomWidgetAdapterComponent;", "cartSliceCustomWidgetAdapterComponent", "isInSplitScreen", "()Z", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartViewModel extends JediViewModel<CartState> {
    public static final a Companion = null;
    private static final String MARKETING_PLAN_REPORT_RECORDS_CART = "marketing_plan_report_records_cart_popup";
    private static final String VMTAG = "CartViewModel";
    private final MutableLiveData<com.bytedance.android.shopping.new_cart.viewmodel.c> _onQueryEndLiveData;
    private final MutableLiveData<com.bytedance.android.shopping.new_cart.viewmodel.d> _onQueryStartLiveData;
    private final Lazy cartSliceCustomWidgetAdapterComponent$delegate;
    private com.bytedance.android.shopping.new_cart.yata.customdata.a customDataCenter;
    private final Lazy multiUpdateImpl$delegate;
    private CartObjectContainer objectContainer;
    private final LiveData<com.bytedance.android.shopping.new_cart.viewmodel.c> onQueryEndLiveData;
    private final LiveData<com.bytedance.android.shopping.new_cart.viewmodel.d> onQueryStartLiveData;
    private final bg3.a trackerImpl;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Observer<SsResponse<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f179369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CartViewModel f179370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f179371c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0 f179372d;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f179373a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Throwable f179374b;

            public a(b r100, Throwable r101) {
                this.f179373a = r100;
                this.f179374b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b r100 = this.f179373a;     // Catch: Throwable -> L4
                CartViewModel.access$onGetQueryErr(r100.f179370b, this.f179374b, r100.f179371c, r100.f179369a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            bg3.a r101 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
            com.bytedance.android.shopping.new_cart.utils.a.f(new a(this, r100));
        }

        @Override // io.reactivex.Observer
        public final void onNext(SsResponse<String> r100) {
            SsResponse<String> r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "o");
            com.bytedance.kmp.ec.yata.common.protocol.data.e r102 = CartRepository.INSTANCE.transformToDTO(r101);
            if (r102 == null) goto L6;
            bg3.a r103 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
            com.bytedance.android.shopping.new_cart.utils.a.f(new com.bytedance.android.shopping.new_cart.viewmodel.a(r102, this));
            return;
        }

        public b(long r100, CartViewModel r101, String r102, Function0 r103) {
            this.f179369a = r100;
            this.f179370b = r101;
            this.f179371c = r102;
            this.f179372d = r103;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartViewModel f179375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f179376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f179377c;

        public c(CartViewModel r100, String r101, boolean r102) {
            this.f179375a = r100;
            this.f179376b = r101;
            this.f179377c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CartViewModel.access$get_onQueryStartLiveData$p(this.f179375a).setValue(new com.bytedance.android.shopping.new_cart.viewmodel.d(this.f179376b, this.f179377c));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartViewModel f179378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.kmp.ec.yata.common.protocol.data.e f179379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f179380c;

        public d(CartViewModel r100, com.bytedance.kmp.ec.yata.common.protocol.data.e r101, String r102) {
            this.f179378a = r100;
            this.f179379b = r101;
            this.f179380c = r102;
        }

        public final void a() {
            if (com.bytedance.kmp.ec.yata.common.protocol.data.f.d(this.f179379b) == false) goto L6;
            CartViewModel.access$getObjectContainer$p(this.f179378a).f178935e.f178983d.invoke().x(this.f179379b.g(), aa6.a.b.C0039a.f2349b, new com.bytedance.kmp.ec.yata.common.perf.d("biz_" + this.f179380c), com.bytedance.kmp.ec.yata.common.protocol.data.f.b(this.f179379b));
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartViewModel f179381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f179382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.kmp.ec.yata.common.protocol.data.e f179383c;

        public e(CartViewModel r100, String r101, com.bytedance.kmp.ec.yata.common.protocol.data.e r102) {
            this.f179381a = r100;
            this.f179382b = r101;
            this.f179383c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CartViewModel.access$get_onQueryEndLiveData$p(this.f179381a).setValue(new com.bytedance.android.shopping.new_cart.viewmodel.c(this.f179382b, this.f179383c));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartViewModel f179384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f179385b;

        public f(CartViewModel r100, String r101) {
            this.f179384a = r100;
            this.f179385b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CartViewModel.access$get_onQueryEndLiveData$p(this.f179384a).setValue(new com.bytedance.android.shopping.new_cart.viewmodel.c(this.f179385b, null));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartViewModel f179386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f179387b;

        public static final class a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f179388a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f179389b;

            public a(g r100, Object r101) {
                this.f179388a = r100;
                this.f179389b = r101;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                String r100 = CartViewModel.access$getCartResourceExposeRecords(this.f179388a.f179386a);
                if (r100 != null) goto L5;
            L8:
                boolean r101 = true;
            L9:
                if (r101 == true) goto L16;
                Map r102 = CartViewModel.access$toMutableStringKeyMapOrNull(this.f179388a.f179386a, this.f179389b);
                LinkedHashMap r103 = new LinkedHashMap();
                if (r102 == null) goto L14;
                r103.putAll(r102);
            L14:
                r103.put("resource_expose_records", r100);
                return r103;
            L16:
                return this.f179389b;
            L5:
                if (r100.length() == 0) goto L8;
                r101 = false;
                goto L9
            }
        }

        public static final class b<T, R> implements Function {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f179390a = null;

            static {
                f179390a = new b();
            }

            public b() {
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object r100) {
                Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
                Observable<wf3.b> r101 = CartRepository.INSTANCE.queryForCoupon(r100);
                if (r101 == null) goto L6;
                return r101;
            L6:
                return Observable.empty();
            }
        }

        public static final class c implements Observer<wf3.b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f179391a;

            public static final class a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Throwable f179392a;

                public a(Throwable r100) {
                    this.f179392a = r100;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f179392a.printStackTrace();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable r100) {
                Intrinsics.checkNotNullParameter(r100, "d");
            }

            public c(g r100) {
                this.f179391a = r100;
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable r100) {
                Intrinsics.checkNotNullParameter(r100, "e");
                com.bytedance.android.shopping.new_cart.utils.a.f179359c.d("queryForCoupon", new a(r100));
            }

            @Override // io.reactivex.Observer
            public final void onNext(wf3.b r100) {
                wf3.b r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "t");
                CartMarketingResourceSchemaResponse r102 = r101.a();
                if (r102 != null) goto L6;
                return;
            L6:
                if (r102.isShow() == false) goto L11;
                bg3.a r103 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
                com.bytedance.android.shopping.new_cart.utils.a.f(new com.bytedance.android.shopping.new_cart.viewmodel.b(this, r102));
                return;
            }
        }

        public g(CartViewModel r100, Context r101) {
            this.f179386a = r100;
            this.f179387b = r101;
        }

        public final void a() {
            Object r100 = CartViewModel.access$getObjectContainer$p(this.f179386a).f178935e.f178983d.invoke().i("growth_marketing_request");
            if (r100 != null) goto L5;
            return;
        L5:
            Observable.fromCallable(new a(this, r100)).subscribeOn(Schedulers.io()).flatMap(b.f179390a).subscribe(new c(this));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/shopping/new_cart/viewmodel/CartViewModel$h", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class h extends TypeToken<Map<String, Object>> {
        public h() {
        }
    }

    static {
        Companion = new a();
    }

    private final CartSliceCustomWidgetAdapterComponent getCartSliceCustomWidgetAdapterComponent() {
        return (CartSliceCustomWidgetAdapterComponent) this.cartSliceCustomWidgetAdapterComponent$delegate.getValue();
    }

    public final vf3.a getMultiUpdateImpl() {
        return (vf3.a) this.multiUpdateImpl$delegate.getValue();
    }

    public final void onDestroy() {
    }

    private final String getCartResourceExposeRecords() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(((IMarketingServiceV2) ServiceManager.get().getService(IMarketingServiceV2.class)).a());     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        return (String) r101;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final Map<String, Object> getCommonTrackerParams() {
        CartObjectContainer r100 = this.objectContainer;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        CartParams r101 = r100.f178935e.f178982c;
        Pair[] r102 = new Pair[8];
        r102[0] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r102[1] = TuplesKt.to("area_type", "104");
        r102[2] = TuplesKt.to("page_name", "product_cart_page");
        if (r101 == null) goto L9;
        String r103 = r101.getNewSourceType();
        if (r103 == null) goto L9;
    L10:
        r102[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r103);
        if (r101 == null) goto L14;
        String r104 = r101.getHistoryPath();
        if (r104 == null) goto L14;
    L15:
        r102[4] = TuplesKt.to("previous_page", r104);
        CartSliceCustomWidgetAdapterComponent r105 = getCartSliceCustomWidgetAdapterComponent();
        if (r105 == null) goto L19;
        String r106 = r105.f178940c;
        if (r106 == null) goto L19;
    L20:
        r102[5] = TuplesKt.to("top_tab_name", r106);
        CartObjectContainer r107 = this.objectContainer;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L23:
        String r108 = r107.f178935e.f178992m;
        if (r108 != null) goto L26;
        r108 = "none";
    L26:
        r102[6] = TuplesKt.to("session_id", r108);
        CartObjectContainer r109 = this.objectContainer;
        if (r109 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L29:
        r102[7] = TuplesKt.to("is_split_screen", Integer.valueOf(k.q(Boolean.valueOf(r109.f178935e.f178995p))));
        return MapsKt.mapOf(r102);
    L19:
        r106 = AccountType.MAIN;
    L14:
        r104 = "";
    L9:
        r103 = "local_test";
        goto L10
    }

    private final boolean isInSplitScreen() {
        int r100 = com.bytedance.android.shopping.new_cart.utils.c.f179363a;
        CartObjectContainer r101 = this.objectContainer;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        CartParams r102 = r101.f178935e.f178982c;
        if (r102 == null) goto L8;
        String r103 = r102.getSplitActivityScene();
    L10:
        return com.bytedance.android.shopping.new_cart.utils.c.a(r103);
    L8:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.jedi.arch.JediViewModel
    public CartState defaultState() {
        return new CartState(0);
    }

    public CartViewModel() {
        this.trackerImpl = new bg3.a();
        MutableLiveData<com.bytedance.android.shopping.new_cart.viewmodel.d> r100 = new MutableLiveData();
        this._onQueryStartLiveData = r100;
        this.onQueryStartLiveData = r100;
        MutableLiveData<com.bytedance.android.shopping.new_cart.viewmodel.c> r101 = new MutableLiveData();
        this._onQueryEndLiveData = r101;
        this.onQueryEndLiveData = r101;
        this.multiUpdateImpl$delegate = LazyKt.lazy(new CartViewModel$multiUpdateImpl$2(this));
        this.cartSliceCustomWidgetAdapterComponent$delegate = LazyKt.lazy(new CartViewModel$cartSliceCustomWidgetAdapterComponent$2(this));
    }

    public final com.bytedance.android.shopping.new_cart.yata.customdata.a getCustomDataCenter() {
        return this.customDataCenter;
    }

    public final LiveData<com.bytedance.android.shopping.new_cart.viewmodel.c> getOnQueryEndLiveData() {
        return this.onQueryEndLiveData;
    }

    public final LiveData<com.bytedance.android.shopping.new_cart.viewmodel.d> getOnQueryStartLiveData() {
        return this.onQueryStartLiveData;
    }

    @Override // com.bytedance.jedi.arch.JediViewModel
    public /* bridge */ /* synthetic */ State defaultState() {
        return defaultState();
    }

    public static final /* synthetic */ String access$getCartResourceExposeRecords(CartViewModel r100) {
        return r100.getCartResourceExposeRecords();
    }

    public static final /* synthetic */ CartObjectContainer access$getObjectContainer$p(CartViewModel r100) {
        CartObjectContainer r101 = r100.objectContainer;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        return r101;
    }

    public static final /* synthetic */ MutableLiveData access$get_onQueryEndLiveData$p(CartViewModel r100) {
        return r100._onQueryEndLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_onQueryStartLiveData$p(CartViewModel r100) {
        return r100._onQueryStartLiveData;
    }

    public static final /* synthetic */ boolean access$isInSplitScreen$p(CartViewModel r100) {
        return r100.isInSplitScreen();
    }

    private final Map<String, Object> toMutableStringKeyMapOrNull(Object r100) {
        boolean r101 = r100 instanceof Map;
        Object r102 = null;
        if (r101 == false) goto L9;
        if (r101 == true) goto L7;
        r100 = null;
    L7:
        return (Map) r100;
    L9:
        if ((r100 instanceof String) == true) goto L11;
        Object r103 = null;
    L12:
        String r104 = (String) r103;
        if (r104 == null) goto L34;
    L22:
        if (r104 != null) goto L36;
        return null;
    L36:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L26
        Object r106 = Result.m9449constructorimpl((Map) u0.c().fromJson(r104, new h().getType()));     // Catch: Throwable -> L26
    L29:
        if (Result.m9455isFailureimpl(r106) == true) goto L33;
        r102 = r106;
    L33:
        return (Map) r102;
    L26:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L34:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L16
        Object r109 = Result.m9449constructorimpl(u0.c().toJson(r100));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r109) == false) goto L21;
        r109 = null;
    L21:
        r104 = (String) r109;
    L16:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L11:
        r103 = r100;
        goto L12
    }

    public final void changeFps(final int r100) {
        if (ECAppInfoService.f48114e.i() == false) goto L6;
        withState(new AnonymousClass1(this, r100));
        return;
    }

    public final void onCreate(CartObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        this.objectContainer = r100;
    }

    public final void queryForCoupon(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.shopping.new_cart.utils.a.f179359c.d("queryForCoupon", new g(this, r100));
    }

    public final void setCustomDataCenter(com.bytedance.android.shopping.new_cart.yata.customdata.a r100) {
        this.customDataCenter = r100;
    }

    public final boolean updateExtraParam(Map<String, ? extends Object> r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<String, ? extends Object>> r101 = r100.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        Map.Entry<String, ? extends Object> r102 = r101.next();
        CartObjectContainer r103 = this.objectContainer;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L11:
        com.bytedance.android.shopping.new_cart.container.b r104 = r103.f178935e;
        String r105 = r102.getKey();
        Object r106 = r102.getValue();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "key");
        r104.f178981b.put(r105, r106);
        goto L7
    L12:
        return true;
    }

    public final void updateHasMore(final boolean r100) {
        withState(new C103541(this, r100));
    }

    public static final /* synthetic */ void access$setObjectContainer$p(CartViewModel r100, CartObjectContainer r101) {
        r100.objectContainer = r101;
    }

    public static final /* synthetic */ void access$setState(CartViewModel r100, Function1 r101) {
        r100.setState(r101);
    }

    public static final /* synthetic */ Map access$toMutableStringKeyMapOrNull(CartViewModel r100, Object r101) {
        return r100.toMutableStringKeyMapOrNull(r101);
    }

    private final void onGetQueryErr(Throwable r100, @QueryScene String r101, long r102) {
        vf3.a r103 = getMultiUpdateImpl();
        if (r103 == null) goto L22;
        boolean r104 = true;
        if (r103.p(r102, null) != true) goto L22;
        bg3.a r105 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.f(new f(this, r101));
        String r106 = r100.getMessage();
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        if (r106.length() == 0) goto L14;
        r104 = false;
    L14:
        if (r104 == false) goto L16;
        EnsureManager.ensureNotReachHere(r100);
        r106 = com.bytedance.android.shopping.new_cart.utils.g.a(r100);
    L16:
        StringBuilder r107 = new StringBuilder();
        r107.append(r106);
        r107.append("; cause: ");
        Throwable r108 = r100.getCause();
        if (r108 == null) goto L19;
        String r109 = r108.getMessage();
    L20:
        r107.append(r109);
        com.bytedance.android.shopping.new_cart.utils.a.j("PREFETCH-ON-Error", r107.toString(), null, 12);
        return;
    L19:
        r109 = null;
    L22:
        bg3.a r110 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.g(this, "onGetQueryErr_reject", r100.getMessage(), MapsKt.emptyMap());
    }

    public final void doEventAction(String r100, Map<String, ? extends Object> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(getCommonTrackerParams());
        r103.putAll(r101);
        bg3.a r104 = this.trackerImpl;
        CartObjectContainer r105 = this.objectContainer;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        r104.a(r100, r103, r105.f178935e.f178989j, r102);
    }

    public final void doQuery(boolean r100, @QueryScene String r101, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r101, "queryScene");
        bg3.a r102 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.f(new c(this, r101, r100));
        vf3.a r103 = getMultiUpdateImpl();
        if (r103 == null) goto L9;
        long r104 = r103.o();
        CartRepository r105 = CartRepository.INSTANCE;
        CartObjectContainer r106 = this.objectContainer;
        if (r106 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L7:
        r105.query(r106, r101, r104).subscribeOn(Schedulers.newThread()).subscribe(new b(r104, this, r101, r110));
        return;
    }

    public static final /* synthetic */ void access$onGetQueryErr(CartViewModel r100, Throwable r101, String r102, long r103) {
        r100.onGetQueryErr(r101, r102, r103);
    }

    private final void onGetQuery(com.bytedance.kmp.ec.yata.common.protocol.data.e r100, @QueryScene String r101, long r102, Function0<Unit> r103) {
        vf3.a r104 = getMultiUpdateImpl();
        if (r104 != null) goto L5;
    L11:
        dm.a.a(VMTAG).i("onGetQuery reject");
        return;
    L5:
        if (r104.p(r102, r100) != true) goto L11;
        bg3.a r105 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.c(this, "refreshProtocol", new d(this, r100, r101), null);
        com.bytedance.android.shopping.new_cart.utils.a.f(new e(this, r101, r100));
        if (r103 == null) goto L13;
        Unit r106 = r103.invoke();
        return;
    }

    public static final /* synthetic */ void access$onGetQuery(CartViewModel r100, com.bytedance.kmp.ec.yata.common.protocol.data.e r101, String r102, long r103, Function0 r104) {
        r100.onGetQuery(r101, r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void doEventAction$default(CartViewModel r100, String r101, Map r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = MapsKt.emptyMap();
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.doEventAction(r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void doQuery$default(CartViewModel r100, boolean r101, String r102, Function0 r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.doQuery(r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onGetQuery$default(CartViewModel r100, com.bytedance.kmp.ec.yata.common.protocol.data.e r101, String r102, long r103, Function0 r110, int r111, Object r112) {
        if ((r111 & 8) == 0) goto L5;
        r110 = null;
    L5:
        r100.onGetQuery(r101, r102, r103, r110);
    }
}
