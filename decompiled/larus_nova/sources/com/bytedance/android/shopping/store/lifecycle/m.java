package com.bytedance.android.shopping.store.lifecycle;

import android.content.Context;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.preload.resource.PageType;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class m implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f185494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECStorePerfMonitor f185495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f185496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f185497d;

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void C() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).C();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void H() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).H();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void K() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).K();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void O() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).O();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void T() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).T();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void a() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).a();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void b() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).b();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void f() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).f();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void g() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).g();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void j() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).j();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void l() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).l();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void n() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).n();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void onPause() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).onPause();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void t() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).t();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void v() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).v();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void w() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).w();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void y() {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).y();
        goto L4
    }

    public m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "entranceClassName");
        this.f185497d = r100;
        this.f185494a = new ArrayList();
        ECStorePerfMonitor r101 = new ECStorePerfMonitor(r100);
        this.f185495b = r101;
        o r102 = new o();
        this.f185496c = r102;
        U(r101);
        U(r102);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void A(ECStoreParam r100) {
        Intrinsics.checkNotNullParameter(r100, "storeParam");
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).A(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void L(f r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Iterator r101 = ((ArrayList) this.f185494a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).L(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void N(StoreTabConfig r100) {
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).N(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void Q(ECStoreParam r100) {
        Intrinsics.checkNotNullParameter(r100, "storeParam");
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).Q(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void R(StoreTabConfig r100) {
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).R(r100);
        goto L4
    }

    public final void U(c r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeCycle");
        ((ArrayList) this.f185494a).add(r100);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void c(StoreTabConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "tabConfig");
        Iterator r101 = ((ArrayList) this.f185494a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).c(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void e(StoreTabConfig r100) {
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).e(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void h(ECStorePreloadInfoResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "preloadInfo");
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).h(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void i(StoreTabConfig r100) {
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).i(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void k(StoreTabConfig r100) {
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).k(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void m(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "preContext");
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).m(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void o(ECShopHeadInfoBlock r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).o(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void onResume(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).onResume(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void s(StoreTabConfig r100) {
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).s(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void x(StoreTabConfig r100) {
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).x(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void z(ECStorePreloadInfoResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "preloadInfo");
        Iterator<T> r101 = this.f185494a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).z(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void F(uj3.j r100, long r101) {
        Iterator<T> r102 = this.f185494a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).F(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void I(StoreTabConfig r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "tabConfig");
        Intrinsics.checkNotNullParameter(r101, "metaInfo");
        Iterator<T> r102 = this.f185494a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).I(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void M(int r100, int r101) {
        Iterator<T> r102 = this.f185494a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).M(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void S(int r100, ECHybridListAdapter r101) {
        Intrinsics.checkNotNullParameter(r101, "listAdapter");
        Iterator r102 = ((ArrayList) this.f185494a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).S(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void d(Throwable r100, CommerceBaseResponse r101) {
        Iterator<T> r102 = this.f185494a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).d(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void q(Context r100, ECStoreParam r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "storeParam");
        Iterator<T> r102 = this.f185494a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).q(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void r(int r100, int r101) {
        Iterator<T> r102 = this.f185494a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).r(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void G(ECStoreParam r100, ECStoreTabAreaVO r101, ECStoreHomeTabResponseTabkit r102) {
        Intrinsics.checkNotNullParameter(r100, "storeParam");
        Intrinsics.checkNotNullParameter(r101, "tabData");
        Intrinsics.checkNotNullParameter(r102, "response");
        Iterator r103 = ((ArrayList) this.f185494a).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((c) r103.next()).G(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void J(ECStoreViewModel r100, ECStoreParam r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "storeParam");
        Iterator<T> r103 = this.f185494a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((c) r103.next()).J(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void P(String r100, Map<String, ? extends Object> r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Iterator<T> r103 = this.f185494a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((c) r103.next()).P(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void p(StoreTabConfig r100, JSONObject r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "filterParams");
        Iterator r103 = ((ArrayList) this.f185494a).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((c) r103.next()).p(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void u(ECStoreParam r100, com.bytedance.android.shopping.store.home.entity.n r101, CommerceBaseResponse r102) {
        Intrinsics.checkNotNullParameter(r100, "storeParam");
        Intrinsics.checkNotNullParameter(r101, "infoData");
        Intrinsics.checkNotNullParameter(r102, "response");
        Iterator<T> r103 = this.f185494a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((c) r103.next()).u(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void B(Context r100, ECStoreParam r101, JSONObject r102, PageType r103) {
        Intrinsics.checkNotNullParameter(r101, "storeParam");
        Intrinsics.checkNotNullParameter(r103, "pageType");
        Iterator r104 = ((ArrayList) this.f185494a).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((c) r104.next()).B(r100, r101, r102, r103);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void E(ECStoreViewModel r110, StoreTabConfig r111, ECStoreParam r112, JSONObject r113, JSONObject r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        Intrinsics.checkNotNullParameter(r112, "storeParam");
        Iterator r100 = ((ArrayList) this.f185494a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).E(r110, r111, r112, r113, r114, r115);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void D(StoreTabConfig r110, int r111, int r112, Integer r113, Integer r114, String r115, String r116, String r210) {
        Iterator<T> r100 = this.f185494a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).D(r110, r111, r112, r113, r114, r115, r116, r210);
        goto L4
    }
}
