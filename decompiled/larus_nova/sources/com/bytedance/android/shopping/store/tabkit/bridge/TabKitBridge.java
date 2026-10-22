package com.bytedance.android.shopping.store.tabkit.bridge;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.model.k;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pd.e;
import pd.f;

/* JADX INFO: loaded from: classes14.dex */
public final class TabKitBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Function1<k, TabKitBaseBridgeMethod>> f186578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f186579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f186580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f186581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TabKitViewModel f186582e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class TabKitBaseBridgeMethod extends ECBaseBridgeMethod {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final k f186603e;

        public TabKitBaseBridgeMethod() {
            this(null);
        }

        public TabKitBaseBridgeMethod(k r100) {
            this.f186603e = r100;
        }
    }

    public static final class a {
    }

    static {
        new ArrayList();
    }

    public TabKitBridge(TabKitViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        this.f186582e = r100;
        ArrayList<Function1<k, TabKitBaseBridgeMethod>> r101 = new ArrayList();
        this.f186578a = r101;
        this.f186579b = LazyKt.lazy(new TabKitBridge$baseMethodsCreatedV2$2(this));
        boolean r102 = ECServiceManager.f42805a;
        IAdapterService r103 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r103 == null) goto L7;
        e r104 = r103.getIExternaHybridService();
        if (r104 == null) goto L7;
        f r105 = r104.getExternalJsBridgeMethodInjectorAdapter();
    L8:
        this.f186580c = r105;
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$1(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$2(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$3(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$4(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$5(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$6(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$7(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$8(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$9(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$10(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$11(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$12(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$13(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$14(this));
        r101.add(TabKitBridge$1$15.INSTANCE);
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$15(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$16(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$17(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$18(this));
        r101.add(new TabKitBridge$$special$$inlined$apply$lambda$19(this));
        return;
    L7:
        r105 = null;
        goto L8
    }
}
