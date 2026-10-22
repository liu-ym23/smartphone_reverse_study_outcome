package com.bytedance.android.window.shop.home.presenter;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.window.base.floatlayout.WindowFloatLayout;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowFloatLayerPresenter;", "Lcom/bytedance/android/window/shop/home/presenter/AbsECWindowPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "unregisterJsv", "registerJsb", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowFloatLayerPresenter extends AbsECWindowPresenter implements LifecycleObserver {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f188363r = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f188364m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ECWindowFloatLayerPresenter$createDefaultFloatLayout$1 f188365n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WindowFloatLayout f188366o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f188367p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f188368q;

    public static final class a {
    }

    public static final class b implements ti.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowFloatLayerPresenter f188369a;

        public b(ECWindowFloatLayerPresenter r100) {
            this.f188369a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            String r101 = r100.optString(EventConstant.Key.MODULE);
            com.bytedance.android.ec.window.base.repository.dto.s r102 = (com.bytedance.android.ec.window.base.repository.dto.s) GsonProtectorUtils.fromJson(new Gson(), r101, com.bytedance.android.ec.window.base.repository.dto.s.class);
            int r103 = com.bytedance.android.ec.window.base.repository.vo.d.f49497a;
            com.bytedance.android.ec.window.base.repository.vo.d r104 = com.bytedance.android.ec.window.base.repository.vo.d.a.a(r102);
            ECWindowFloatLayerPresenter r105 = this.f188369a;
            ECWindowFloatLayerPresenter.Z(r105, r104, r105.O().getMetaInfo());
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowFloatLayerPresenter f188370a;

        public c(ECWindowFloatLayerPresenter r100) {
            this.f188370a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            JSONObject r102 = new JSONObject();
            if (r101 == null) goto L8;
        L13:
            ECWindowFloatLayerPresenter$createDefaultFloatLayout$1 r103 = this.f188370a.f188365n;
            if (r103 == null) goto L18;
            Intrinsics.checkNotNullParameter("ecom_window_scroll", "event");
            Intrinsics.checkNotNullParameter(r102, "params");
            ti.l r104 = r103.f49323a;
            if (r104 == null) goto L18;
            r104.sendJsEvent("ecom_window_scroll", r102);
        L18:
            WindowFloatLayout r105 = this.f188370a.f188366o;
            if (r105 == null) goto L26;
            Intrinsics.checkNotNullParameter("ecom_window_scroll", "event");
            Intrinsics.checkNotNullParameter(r102, "params");
            ti.l r106 = r105.f49323a;
            if (r106 == null) goto L27;
            r106.sendJsEvent("ecom_window_scroll", r102);
            return;
        L27:
            return;
        L26:
            return;
        L7:
            if (r101.intValue() != 0) goto L8;
            boolean r107 = false;
        L10:
            r102.put("scroll_state_scrolling", r107);     // Catch: Exception -> L12
        L8:
            r107 = true;
            goto L10
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void registerJsb() {
        ECLiveHybridUtil.m("ecom.store.create_float_lynx_container", this.f188368q);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void unregisterJsv() {
        ECLiveHybridUtil.p("ecom.store.create_float_lynx_container", this.f188368q);
    }

    public ECWindowFloatLayerPresenter() {
        this.f188367p = new c(this);
        this.f188368q = new b(this);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        O().getComponentResponse().d(U());
        O().getCroppedState().removeObservers(U());
        U().getLifecycle().removeObserver(this);
    }

    public final void c0() {
        O().getScrollState().b(this.f188367p);
        O().getScrollState().a(U(), this.f188367p, false);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        O().getCroppedState().observe(U(), new w0(this), true);
        if (O().getShopParam().isCroppedStyle() == false) goto L5;
        O().getCroppedState().observe(U(), new x0(this));
    L5:
        U().getLifecycle().addObserver(this);
    }

    /* JADX WARN: Type inference failed for: r9v4, types: [com.bytedance.android.ec.window.base.floatlayout.WindowFloatLayout, com.bytedance.android.window.shop.home.presenter.ECWindowFloatLayerPresenter$createDefaultFloatLayout$1] */
    public static final void Z(final ECWindowFloatLayerPresenter r110, final com.bytedance.android.ec.window.base.repository.vo.d r111, Map r112) {
        r110.getClass();
        List<com.bytedance.android.ec.window.base.repository.dto.t> r100 = r111.f();
        String r101 = null;
        if (r100 == null) goto L18;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        Object r103 = r102.next();
        Integer r104 = ((com.bytedance.android.ec.window.base.repository.dto.t) r103).a();
        if (r104 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == false) goto L6;
    L17:
        com.bytedance.android.ec.window.base.repository.dto.t r106 = (com.bytedance.android.ec.window.base.repository.dto.t) r103;
    L19:
        List<com.bytedance.android.ec.window.base.repository.dto.t> r107 = r111.f();
        if (r107 == null) goto L35;
        Iterator<T> r108 = r107.iterator();
    L23:
        if (r108.hasNext() == false) goto L33;
        Object r109 = r108.next();
        Integer r113 = ((com.bytedance.android.ec.window.base.repository.dto.t) r109).a();
        if (r113 != null) goto L28;
    L30:
        boolean r114 = false;
    L31:
        if (r114 == false) goto L23;
    L34:
        com.bytedance.android.ec.window.base.repository.dto.t r115 = (com.bytedance.android.ec.window.base.repository.dto.t) r109;
    L36:
        if (r106 != null) goto L39;
        if (r115 != null) goto L39;
        final long r116 = System.currentTimeMillis();
        final Context r117 = r110.u().c();
        final ECWindowDialogFragment r118 = r110.I();
        final JSONObject r119 = com.bytedance.android.ec.core.utils.z1.g(r111.c());
        final String r120 = r111.e();
        ?? r121 = new ECWindowFloatLayerPresenter$createDefaultFloatLayout$1(r110, r111, r117, r118, r119, r120);
        r110.f188365n = r121;
        r110.c0();
        r121.e(r111.d(), MapsKt.mapOf(new Pair[]{TuplesKt.to("metaInfo", r112), TuplesKt.to("data", r111.c()), TuplesKt.to("name", r111.e()), TuplesKt.to("component", com.bytedance.android.shopping.extensions.k.v(r111))}), new ECWindowFloatLayerPresenter$createDefaultFloatLayout$3(r110, r111, r116));
        return;
    L39:
        String r122 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (r106 == null) goto L42;
        Integer r123 = r106.c();
    L44:
        if (r123 != null) goto L47;
    L49:
        String r124 = r122;
    L50:
        if (r115 == null) goto L52;
        Integer r125 = r115.c();
    L53:
        if (r125 != null) goto L56;
    L58:
        String r126 = r122;
    L59:
        if (r106 == null) goto L61;
        String r127 = r106.d();
    L62:
        Intrinsics.checkNotNullParameter("shop", "default");
        if (r127 != null) goto L65;
        String r128 = "shop";
    L66:
        if (r115 == null) goto L68;
        r101 = r115.d();
    L68:
        Intrinsics.checkNotNullParameter("shop", "default");
        if (r101 != null) goto L71;
        String r129 = "shop";
    L72:
        jo.a r130 = jo.a.f499823a;
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(jo.a.b(r111.e(), com.bytedance.android.ec.sdk.helper.r.f48132a.f(), r124)).subscribe(new v0(r110, r128, r129, r106, r115, r111, r124, r126, r112)), r110.O());
        return;
    L71:
        r129 = r101;
        goto L72
    L65:
        r128 = r127;
        goto L66
    L61:
        r127 = null;
        goto L62
    L56:
        if (r125.intValue() != 0) goto L58;
        r126 = "all";
        goto L59
    L52:
        r125 = null;
        goto L53
    L47:
        if (r123.intValue() != 0) goto L49;
        r124 = "all";
        goto L50
    L42:
        r123 = null;
        goto L44
    L28:
        if (r113.intValue() != 1) goto L30;
        r114 = true;
        goto L31
    L33:
        r109 = null;
        goto L34
    L35:
        r115 = null;
        goto L36
    L11:
        if (r104.intValue() != 0) goto L13;
        r105 = true;
        goto L14
    L16:
        r103 = null;
        goto L17
    L18:
        r106 = null;
        goto L19
    }

    public static final Map a0(ECWindowFloatLayerPresenter r100, List r101, String r102, int r103) {
        r100.getClass();
        ArrayList r104 = new ArrayList();
        Iterator r105 = r101.iterator();
    L4:
        if (r105.hasNext() == false) goto L13;
        Object r106 = r105.next();
        io.a r107 = (io.a) r106;
        if (Intrinsics.areEqual(r107.f490645d, r102) == true) goto L8;
    L10:
        boolean r108 = false;
    L11:
        if (r108 == false) goto L4;
        r104.add(r106);
        goto L4
    L8:
        if (r107.f490646e != r103) goto L10;
        r108 = true;
        goto L11
    L13:
        LinkedHashMap r109 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r104, 10)), 16));
        Iterator r110 = r104.iterator();
    L15:
        if (r110.hasNext() == false) goto L17;
        Object r111 = r110.next();
        r109.put(((io.a) r111).f490645d, r111);
        goto L15
    L17:
        return r109;
    }

    public static final void b0(ECWindowFloatLayerPresenter r100, io.a r110, String r111, String r112, int r113, String r114) {
        r100.getClass();
        if (r110 == null) goto L5;
        r110.f490648g++;
        jo.a r101 = jo.a.f499823a;
        bg4.b.b(jo.a.c(r110)).subscribe();
        return;
    L5:
        io.a r102 = new io.a(0, r111, com.bytedance.android.ec.sdk.helper.r.f48132a.f(), r112, r113, r114, 1);
        jo.a r115 = jo.a.f499823a;
        bg4.b.b(jo.a.a(r102)).subscribe();
    }
}
