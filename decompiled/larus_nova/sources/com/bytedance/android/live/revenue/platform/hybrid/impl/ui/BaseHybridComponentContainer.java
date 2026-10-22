package com.bytedance.android.live.revenue.platform.hybrid.impl.ui;

import bz0.g;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.revenue.common.j;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class BaseHybridComponentContainer<T extends IHybridComponent> extends j implements zy0.c, IHybridComponent.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public az0.a f91461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Function1<wy0.e, Unit>> f91462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f91463d;

    @Override // zy0.c
    public final xy0.a<?> g() {
        com.bytedance.android.live.revenue.platform.hybrid.impl.component.d.a r100 = com.bytedance.android.live.revenue.platform.hybrid.impl.component.d.f91415d;
        T r101 = this.f91463d;
        r100.getClass();
        return com.bytedance.android.live.revenue.platform.hybrid.impl.component.d.a.b(r101);
    }

    @Override // zy0.c
    public final xy0.a<?> w() {
        xy0.a<?> r100 = g();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException(("hybrid component must not be null in container: " + this.f91463d).toString());
    }

    @Override // zy0.c
    public final void l1(final Function1<? super wy0.e, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        az0.a r101 = this.f91461b;
        if (r101 == null) goto L6;
        r100.invoke(r101);
        return;
    L6:
        List<Function1<wy0.e, Unit>> r102 = this.f91462c;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new BaseHybridComponentContainer$awaitJsBridge$2(r100));
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent.a
    public final void onJSBridgeCreated(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        az0.a r101 = new az0.a(r100);
        this.f91461b = r101;
        Iterator<T> r102 = this.f91462c.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((Function1) r102.next()).invoke(r101);
        goto L4
    L6:
        ((ArrayList) this.f91462c).clear();
    }

    public BaseHybridComponentContainer(T r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "originalContainer");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f91463d = r100;
        this.f91462c = new ArrayList();
        r100.setJSBridgeListener(this);
    }
}
