package com.bytedance.android.livesdk.interactivity.square;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements IModelListDataManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h52.c> f141102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PropertyOwner<IModelListDataManager.a> f141103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m52.e f141104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f141105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f141106e;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager
    public final PropertyOwner a() {
        PropertyOwner<IModelListDataManager.a> r100 = this.f141103b;
        r100.getClass();
        return r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager
    public final void destroy() {
        ((ArrayList) this.f141102a).clear();
    }

    public a() {
        this.f141105d = 100;
        this.f141106e = 30;
        this.f141102a = new ArrayList();
        this.f141103b = new PropertyOwner(new IModelListDataManager.a(IModelListDataManager.ModelChangeType.RELOAD_ALL, 0, 0, null, 30));
        this.f141104c = new m52.e();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager
    public final m52.e c() {
        return this.f141104c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager
    public final List<h52.c> getMessageList() {
        return this.f141102a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager
    public final void b(h52.c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (((ArrayList) this.f141102a).size() <= this.f141105d) goto L5;
        ((ArrayList) this.f141102a).subList(0, this.f141106e).clear();
        IModelListDataManager.a r101 = new IModelListDataManager.a(IModelListDataManager.ModelChangeType.REMOVE_RANGE, 0, this.f141106e, null, 18);
        this.f141104c.onEvent(r101);
        this.f141103b.a(r101);
    L5:
        ((ArrayList) this.f141102a).add(r100);
        IModelListDataManager.a r102 = new IModelListDataManager.a(IModelListDataManager.ModelChangeType.INSERT_BOTTOM, ((ArrayList) this.f141102a).size() - 1, 0, r100, 12);
        this.f141104c.onEvent(r102);
        this.f141103b.a(r102);
    }
}
