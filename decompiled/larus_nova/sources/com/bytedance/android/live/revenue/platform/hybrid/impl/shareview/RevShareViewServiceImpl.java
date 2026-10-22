package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.LoadFailCode;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.ShareViewLoadError;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.t0;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils.SettingUtilExtensionKt;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class RevShareViewServiceImpl implements com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, BehaviorSubject<h80.c<View>>> f91417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap<Context, l> f91418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.lynx.tasm.behavior.a> f91419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e> f91420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f91421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vy0.c f91422f;

    public static final class a {
    }

    public static final class b extends com.lynx.tasm.behavior.a {
        public b() {
            super("rev-share-view");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new RevShareViewUI(r100);
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RevShareViewServiceImpl f91423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f91424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.revenue.platform.hybrid.api.shareview.d f91425c;

        public c(RevShareViewServiceImpl r100, String r101, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.d r102) {
            this.f91423a = r100;
            this.f91424b = r101;
            this.f91425c = r102;
        }

        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r7v6 */
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r100 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c) r210;
            Intrinsics.checkNotNullParameter(r100, "sharer");
            RevShareViewServiceImpl r101 = this.f91423a;
            String r102 = this.f91424b;
            BehaviorSubject<h80.c<View>> r103 = (BehaviorSubject) ((LinkedHashMap) r101.f91417a).get(r102);
            if (r103 != null) goto L5;
            r103 = BehaviorSubject.create();
            r101.f91417a.put(r102, r103);
        L5:
            Observable<R> r104 = r103.filter(j.f91457a).map(k.f91458a).doOnDispose(new f(this, r100));
            com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f r105 = this.f91425c.f91399c;
            if (r105 == null) goto L8;
            r105.e(r100);
        L8:
            RevShareViewServiceImpl r106 = this.f91423a;
            String r107 = this.f91424b;
            com.bytedance.android.live.revenue.platform.hybrid.api.shareview.d r108 = this.f91425c;
            r106.getClass();
            Pair[] r109 = new Pair[5];
            ?? r110 = 0;
            r109[0] = TuplesKt.to("id", r107);
            r109[1] = TuplesKt.to("url", r108.f91397a.toString());
            Map<String, Object> r111 = r108.f91398b;
            if (r111 == null) goto L12;
            Map r112 = MapsKt.toMutableMap(r111);
            if (r112 == null) goto L12;
        L13:
            String r113 = UriProtector.getQueryParameter(r108.f91397a, BaseHybridComponent.INITIAL_PROPS_QUERY_KEY);
            int r114 = 2;
            Object r115 = null;
            if (r113 != null) goto L16;
            GsonMap r116 = null;
        L35:
            r112.put(BaseHybridComponent.INITIAL_PROPS_QUERY_KEY, r116);
            Unit r117 = Unit.INSTANCE;
            r109[2] = TuplesKt.to("initData", r112);
            Pair<Integer, Integer> r118 = r108.f91401e;
            if (r118 == null) goto L38;
            List r119 = CollectionsKt.listOf(new Integer[]{r118.getFirst(), r118.getSecond()});
        L39:
            r109[3] = TuplesKt.to("initSize", r119);
            r109[4] = TuplesKt.to(DyPayConstant.KEY_START_TIME, Double.valueOf(r108.f91402f));
            Map<String, ? extends Object> r120 = MapsKt.mapOf(r109);
            r100.a("share-view-load", r120);
            if (((Boolean) com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.f91396h.getValue(null, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.f91389a[6])).booleanValue() == false) goto L42;
            r100.getLynxView().sendGlobalEventToLepus("share-view-load", CollectionsKt.listOf(r120));
        L42:
            return r104;
        L38:
            r119 = null;
            goto L39
        L16:
            Gson r121 = new Gson();
            JsonObject r122 = new JsonObject();
            Iterator<JsonElement> r123 = ((JsonArray) GsonProtectorUtils.fromJson(r121, r113, JsonArray.class)).iterator();
        L18:
            if (r123.hasNext() == false) goto L34;
            String r124 = r123.next().getAsString();
            if (StringsKt.startsWith$default(r124, "setting:", r110, r114, r115) == false) goto L27;
            JsonObject r125 = new JsonObject();
            String r126 = r124.substring(8);
            char[] r127 = new char[1];
            r127[r110] = ':';
            Iterator<Pair<String, JsonElement>> r128 = SettingUtilExtensionKt.getSettingsValue(StringsKt.split$default(r126, r127, false, 0, 6, null)).iterator();
        L23:
            if (r128.hasNext() == false) goto L25;
            Pair<String, JsonElement> r129 = r128.next();
            r125.add(r129.component1(), r129.component2());
            goto L23
        L25:
            r122.add("setting", r125);
        L33:
            r110 = 0;
            r114 = 2;
            r115 = null;
            goto L18
        L27:
            if (StringsKt.startsWith$default(r124, "storage:", false, 2, r115) == false) goto L33;
            JsonObject r130 = new JsonObject();
            Iterator<T> r131 = StringsKt.split$default(r124.substring(8), new char[]{':'}, false, 0, 6, null).iterator();
        L30:
            if (r131.hasNext() == false) goto L32;
            String r132 = (String) r131.next();
            r130.add(r132, GsonProtectorUtils.toJsonTree(r121, ((nr2.a) r106.f91421e.getValue()).G0(r132, Object.class)));
            goto L30
        L32:
            r122.add("storage", r130);
            goto L33
        L34:
            r116 = UtilsKt.i(r122);
        L12:
            r112 = new LinkedHashMap();
            goto L13
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f91428a;

        public d(String r100) {
            this.f91428a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            View r101 = (View) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return TuplesKt.to(this.f91428a, r101);
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        Iterator r100 = ((LinkedHashMap) this.f91417a).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((BehaviorSubject) r100.next()).onError(new Throwable("ShareViewService released"));
        goto L4
    L6:
        ((LinkedHashMap) this.f91417a).clear();
        Collection<l> r101 = this.f91418b.values();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();
        if ((r104 instanceof l.a) == false) goto L8;
        r102.add(r104);
        goto L8
    L12:
        Iterator r105 = r102.iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        ((l.a) r105.next()).f91459a.release();
        goto L14
    }

    public static void a() {
        Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final List<com.lynx.tasm.behavior.a> Z9() {
        return this.f91419c;
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final List<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e> getMethods() {
        return this.f91420d;
    }

    public RevShareViewServiceImpl(vy0.c r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridService");
        this.f91422f = r100;
        this.f91417a = new LinkedHashMap();
        this.f91418b = new WeakHashMap();
        this.f91419c = CollectionsKt.mutableListOf(new com.lynx.tasm.behavior.a[]{new b()});
        this.f91420d = new ArrayList();
        this.f91421e = LazyKt.lazy(RevShareViewServiceImpl$propertyService$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c Ka(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        l r101 = this.f91418b.get(r100);
        if ((r101 instanceof l.a) == true) goto L5;
        return null;
    L5:
        return ((l.a) r101).f91459a;
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final void Y3(String r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "view");
        a();
        BehaviorSubject r102 = (BehaviorSubject) ((LinkedHashMap) this.f91417a).get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        h80.c r103 = (h80.c) r102.getValue();
        if (r103 == null) goto L14;
        View r104 = (View) z0.b(r103);
        if (r104 == null) goto L15;
        if (r104 == r101) goto L12;
        return;
    L12:
        UtilityKotlinExtentionsKt.q(r101);
        r102.onNext(h80.c.f484054b);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final void li(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        a();
        BehaviorSubject r102 = (BehaviorSubject) ((LinkedHashMap) this.f91417a).get(r100);
        if (r102 == null) goto L5;
        h80.c r103 = (h80.c) r102.getValue();
        Object r104 = null;
        if (r103 == null) goto L9;
        View r105 = (View) z0.b(r103);
    L10:
        if (r105 != null) goto L12;
    L19:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r101);
        if (r106 == null) goto L23;
        r102.onError(r106);
    L23:
        if (Result.m9456isSuccessimpl(r101) == false) goto L26;
        r102.onNext(new h80.c((View) r101));
        return;
    L26:
        return;
    L12:
        if (Result.m9455isFailureimpl(r101) == true) goto L16;
        r104 = r101;
    L16:
        if (((View) r104) != r105) goto L18;
        return;
    L18:
        Y3(r100, r105);
        goto L19
    L9:
        r105 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101) {
        t0.a r102 = t0.a.f131746a;
        Intrinsics.checkNotNullParameter("revenue.requestStickerEffectStatus", "name");
        Intrinsics.checkNotNullParameter(r102, "methodProvider");
        List<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e> r103 = this.f91420d;
        ArrayList r104 = (ArrayList) r103;
        r104.add(new com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.a());
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final Observable<Pair<String, View>> vd(Context r100, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        a();
        String r102 = UUID.randomUUID().toString();
        a();
        l r103 = this.f91418b.get(r100);
        if (r103 == null) goto L16;
        if ((r103 instanceof l.b) == false) goto L8;
        Single<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c> r104 = ((l.b) r103).f91460a;
    L41:
        return r104.toObservable().flatMap(new c(this, r102, r101)).map(new d(r102));
    L8:
        if ((r103 instanceof l.a) == false) goto L14;
        l.a r105 = (l.a) r103;
        if (r105.f91459a.isValid() == false) goto L12;
        r104 = Single.just(r105.f91459a);
        goto L41
    L12:
        r105.f91459a.release();
        l r106 = this.f91418b.remove(r100);
        goto L16
    L14:
        throw new NoWhenBranchMatchedException();
    L16:
        if ((r100 instanceof Activity) == true) goto L18;
    L39:
        r104 = Single.error(new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "context " + r100 + " is not an Activity or not a LifecycleOwner"));
        goto L41
    L18:
        if ((r100 instanceof LifecycleOwner) == false) goto L39;
        if (((Activity) r100).isDestroyed() == false) goto L23;
        r104 = Single.error(new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "context has been destroyed"));
        goto L41
    L23:
        ReadOnlyProperty r107 = com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.f91395g;
        KProperty<?>[] r108 = com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.f91389a;
        if (((Boolean) r107.getValue(null, r108[5])).booleanValue() == false) goto L26;
        Single r109 = Single.error(new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "force use standalone sharer"));
    L38:
        Single<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c> r110 = r109.onErrorResumeNext(new g(this, r100)).map(new h(this, r100)).doOnError(new i(this, r100)).toObservable().share().firstOrError();
        this.f91418b.put(r100, new l.b(r110));
        r104 = r110;
        goto L41
    L26:
        com.bytedance.android.live.revenue.platform.container.impl.core.d r111 = (com.bytedance.android.live.revenue.platform.container.impl.core.d) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.live.revenue.platform.container.impl.core.d.class);
        if (r111 != null) goto L30;
        r109 = Single.error(new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "service center not ready"));
        goto L38
    L30:
        if (((Boolean) com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.f91393e.getValue(null, r108[3])).booleanValue() == false) goto L35;
        if (r111.f91190d.hasValue() == true) goto L35;
        r109 = Single.error(new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "ignore the service center lazy load"));
    L35:
        if (((Boolean) com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.f91391c.getValue(null, r108[1])).booleanValue() == false) goto L37;
        r111.a();
    L37:
        r109 = RxUtilKt.h(r111.f91190d.flatMap(new com.bytedance.android.live.revenue.platform.hybrid.impl.shareview.c(r100))).take(1).firstOrError().map(e.f91448a);
        goto L38
    }
}
