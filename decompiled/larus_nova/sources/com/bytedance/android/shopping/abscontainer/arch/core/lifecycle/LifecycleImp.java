package com.bytedance.android.shopping.abscontainer.arch.core.lifecycle;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class LifecycleImp {
    public LifecycleImp() {
    }

    public abstract List<s33.b<?, ?>> i(LifecycleEnum r100);

    public final void a() {
        List<s33.b<?, ?>> r100 = i(LifecycleEnum.FLOW_FIRST_SCREEN_RENDER_FINISHED);
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        final s33.b r103 = (s33.b) r102.next();
        r101.add(new LifecycleImp$flowFirstScreenRenderFinished$executeList$1$1(r103));
        goto L4
    L6:
        f.c(r101);
    }

    public final void b() {
        List<s33.b<?, ?>> r100 = i(LifecycleEnum.FLOW_PROTOCOL_DISPATCH_END);
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        final s33.b r103 = (s33.b) r102.next();
        r101.add(new LifecycleImp$flowProtocolDispatchEnd$executeList$1$1(r103));
        goto L4
    L6:
        f.c(r101);
    }

    public final a c() {
        List<s33.b<?, ?>> r100 = i(LifecycleEnum.FLOW_PROTOCOL_RELOAD_END);
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        final s33.b r103 = (s33.b) r102.next();
        r101.add(new LifecycleImp$flowProtocolReloadEnd$executeList$1$1(r103));
        goto L4
    L6:
        int r104 = f.f164147a;
        Intrinsics.checkNotNullParameter(r101, "processors");
        Iterator r105 = r101.iterator();
    L7:
        boolean r106 = false;
    L9:
        if (r105.hasNext() == false) goto L15;
        if (((a) ((Function0) r105.next()).invoke()).f164135a == true) goto L13;
        if (r106 == false) goto L7;
    L13:
        r106 = true;
        goto L9
    L15:
        return new a(r106);
    }

    public final a j() {
        List<s33.b<?, ?>> r100 = i(LifecycleEnum.INTERCEPT_CLOSE_PAGE);
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        final s33.b r103 = (s33.b) r102.next();
        r101.add(new LifecycleImp$interceptClosePage$executeList$1$1(r103));
        goto L4
    L7:
        return f.a(r101);
    }

    public final void q() {
        List<s33.b<?, ?>> r100 = i(LifecycleEnum.ON_BODY_CONTAINER_WILL_BEGIN_DRAGGING);
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        final s33.b r103 = (s33.b) r102.next();
        r101.add(new LifecycleImp$onBodyContainerWillBeginDragging$executeList$1$1(r103));
        goto L4
    L6:
        f.c(r101);
    }

    public final void v() {
        List<s33.b<?, ?>> r100 = i(LifecycleEnum.PAGE_DID_APPEAR);
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        final s33.b r103 = (s33.b) r102.next();
        r101.add(new LifecycleImp$pageDidAppear$executeList$1$1(r103));
        goto L4
    L6:
        f.c(r101);
    }

    public final void w() {
        List<s33.b<?, ?>> r100 = i(LifecycleEnum.PAGE_DID_MOUNT);
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        final s33.b r103 = (s33.b) r102.next();
        r101.add(new LifecycleImp$pageDidMount$executeList$1$1(r103));
        goto L4
    L6:
        f.c(r101);
    }

    public final void x() {
        List<s33.b<?, ?>> r100 = i(LifecycleEnum.PAGE_WILL_DISAPPEAR);
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        final s33.b r103 = (s33.b) r102.next();
        r101.add(new LifecycleImp$pageWillDisappear$executeList$1$1(r103));
        goto L4
    L6:
        f.c(r101);
    }

    public final void y() {
        List<s33.b<?, ?>> r100 = i(LifecycleEnum.PAGE_WILL_UNMOUNT);
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        final s33.b r103 = (s33.b) r102.next();
        r101.add(new LifecycleImp$pageWillUnmount$executeList$1$1(r103));
        goto L4
    L6:
        f.c(r101);
    }

    public final void d(final n33.c r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        List<s33.b<?, ?>> r101 = i(LifecycleEnum.FLOW_QUERY_FETCH_FAILED);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        final s33.b r104 = (s33.b) r103.next();
        r102.add(new LifecycleImp$flowQueryFetchFailed$$inlined$map$lambda$1(r104, r100));
        goto L4
    L6:
        f.c(r102);
    }

    public final void e(final n33.f r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        List<s33.b<?, ?>> r101 = i(LifecycleEnum.FLOW_QUERY_FETCH_SUCCEED);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        final s33.b r104 = (s33.b) r103.next();
        r102.add(new LifecycleImp$flowQueryFetchSucceed$$inlined$map$lambda$1(r104, r100));
        goto L4
    L6:
        f.c(r102);
    }

    public final void g(final com.bytedance.kmp.ec.yata.common.biz.callback.a r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        List<s33.b<?, ?>> r101 = i(LifecycleEnum.FLOW_UPLINK_START);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        final s33.b r104 = (s33.b) r103.next();
        r102.add(new LifecycleImp$flowUplinkStart$$inlined$map$lambda$1(r104, r100));
        goto L4
    L6:
        f.c(r102);
    }

    public final a m(final d r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        List<s33.b<?, ?>> r101 = i(LifecycleEnum.INTERCEPT_UPLINK);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        final s33.b r104 = (s33.b) r103.next();
        r102.add(new LifecycleImp$interceptUplink$$inlined$map$lambda$1(r104, r100));
        goto L4
    L7:
        return f.a(r102);
    }

    public final q33.b n(final b r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        List<s33.b<?, ?>> r101 = i(LifecycleEnum.INTERCEPT_TRACKER);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        final s33.b r104 = (s33.b) r103.next();
        r102.add(new LifecycleImp$interceptYataTracker$$inlined$map$lambda$1(r104, r100));
        goto L4
    L7:
        return f.b(r102);
    }

    public final a o(final c r100) {
        Intrinsics.checkNotNullParameter(r100, "triggerInfo");
        List<s33.b<?, ?>> r101 = i(LifecycleEnum.INTERCEPT_YATA_TRIGGER);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        final s33.b r104 = (s33.b) r103.next();
        r102.add(new LifecycleImp$interceptYataTrigger$$inlined$map$lambda$1(r104, r100));
        goto L4
    L7:
        return f.a(r102);
    }

    public final void f(final com.bytedance.kmp.ec.yata.common.biz.callback.a r100, final n33.c r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "response");
        List<s33.b<?, ?>> r102 = i(LifecycleEnum.FLOW_UPLINK_FAILED);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        final s33.b r105 = (s33.b) r104.next();
        r103.add(new LifecycleImp$flowUplinkFailed$$inlined$map$lambda$1(r105, r100, r101));
        goto L4
    L6:
        f.c(r103);
    }

    public final void h(final com.bytedance.kmp.ec.yata.common.biz.callback.a r100, final n33.f r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "response");
        List<s33.b<?, ?>> r102 = i(LifecycleEnum.FLOW_UPLINK_SUCCEED);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        final s33.b r105 = (s33.b) r104.next();
        r103.add(new LifecycleImp$flowUplinkSuccess$$inlined$map$lambda$1(r105, r100, r101));
        goto L4
    L6:
        f.c(r103);
    }

    public final q33.a k(final String r100, final Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        List<s33.b<?, ?>> r102 = i(LifecycleEnum.INTERCEPT_PROCESSOR);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        final s33.b r105 = (s33.b) r104.next();
        r103.add(new LifecycleImp$interceptProcessor$$inlined$map$lambda$1(r105, r100, r101));
        goto L4
    L6:
        int r106 = f.f164147a;
        Intrinsics.checkNotNullParameter(r103, "processors");
        Iterator r107 = r103.iterator();
    L8:
        if (r107.hasNext() == false) goto L13;
        q33.a r108 = (q33.a) ((Function0) r107.next()).invoke();
        if (r108.f164135a == false) goto L8;
        return r108;
    L13:
        return new q33.a();
    }

    public final void l(final String r100, final Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        List<s33.b<?, ?>> r102 = i(LifecycleEnum.INTERCEPT_TRACKER);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        final s33.b r105 = (s33.b) r104.next();
        r103.add(new LifecycleImp$interceptTrackerForCatcher$$inlined$map$lambda$1(r105, r100, r101));
        goto L4
    L6:
        f.b(r103);
    }

    public final void p(final int r100, final int r101) {
        List<s33.b<?, ?>> r102 = i(LifecycleEnum.ON_BODY_CONTAINER_SCROLLED);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        final s33.b r105 = (s33.b) r104.next();
        r103.add(new LifecycleImp$onBodyContainerScrolled$$inlined$map$lambda$1(r105, r100, r101));
        goto L4
    L6:
        f.c(r103);
    }

    public final void r(final com.bytedance.android.shopping.abscontainer.arch.platform.yata.d r100, final Map r101) {
        Intrinsics.checkNotNullParameter(r101, "containerMap");
        List<s33.b<?, ?>> r102 = i(LifecycleEnum.ON_POPUP_DISMISS);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        final s33.b r105 = (s33.b) r104.next();
        r103.add(new LifecycleImp$onPopupDismiss$$inlined$map$lambda$1(r105, r100, r101));
        goto L4
    L6:
        f.c(r103);
    }

    public final void s(final com.bytedance.android.shopping.abscontainer.arch.platform.yata.d r100, final Map r101) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "containerMap");
        List<s33.b<?, ?>> r102 = i(LifecycleEnum.ON_POPUP_MASK_CLICK);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        final s33.b r105 = (s33.b) r104.next();
        r103.add(new LifecycleImp$onPopupMaskClick$$inlined$map$lambda$1(r105, r100, r101));
        goto L4
    L6:
        f.c(r103);
    }

    public final void t(final com.bytedance.android.shopping.abscontainer.arch.platform.yata.d r100, final Map r101) {
        Intrinsics.checkNotNullParameter(r101, "containerMap");
        List<s33.b<?, ?>> r102 = i(LifecycleEnum.ON_POPUP_SHOW);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        final s33.b r105 = (s33.b) r104.next();
        r103.add(new LifecycleImp$onPopupShow$$inlined$map$lambda$1(r105, r100, r101));
        goto L4
    L6:
        f.c(r103);
    }

    public final void u(final com.bytedance.android.shopping.abscontainer.arch.platform.yata.d r100, final ga6.c r101) {
        Intrinsics.checkNotNullParameter(r101, "config");
        List<s33.b<?, ?>> r102 = i(LifecycleEnum.ON_POPUP_WILL_SHOW);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        final s33.b r105 = (s33.b) r104.next();
        r103.add(new LifecycleImp$onPopupWillShow$$inlined$map$lambda$1(r105, r100, r101));
        goto L4
    L6:
        f.c(r103);
    }
}
