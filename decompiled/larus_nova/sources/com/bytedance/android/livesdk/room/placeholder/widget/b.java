package com.bytedance.android.livesdk.room.placeholder.widget;

import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.shopping.ICommerceFlashData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f157806a;

    public static final class a implements ICommerceFlashData {
        public a() {
        }

        @Override // com.bytedance.android.livesdkapi.shopping.ICommerceFlashData
        public final boolean hasAuth() {
            return false;
        }

        @Override // com.bytedance.android.livesdkapi.shopping.ICommerceFlashData
        public final boolean isOpen() {
            return false;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.room.placeholder.widget.b$b, reason: collision with other inner class name */
    public static final class C2421b implements ICommerceFlashData {
        public C2421b() {
        }

        @Override // com.bytedance.android.livesdkapi.shopping.ICommerceFlashData
        public final boolean hasAuth() {
            return true;
        }

        @Override // com.bytedance.android.livesdkapi.shopping.ICommerceFlashData
        public final boolean isOpen() {
            return true;
        }
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.widget.d
    public final void attachWidget(IExternalWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.widget.d
    public final void detachWidget(IExternalWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
    }

    public b(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f157806a = r100;
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.widget.d
    public final void requestDismiss(IExternalWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        IFeatureService r101 = (IFeatureService) k.f(IFeatureService.class);
        if (r101 == null) goto L7;
        z90.a r102 = r101.getFeatureManager();
        if (r102 == null) goto L7;
        r102.c("show_flash_shop_type", 0);
    L7:
        this.f157806a.put("data_commerce_flash_info", new a());
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.widget.d
    public final void requestShow(IExternalWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        IFeatureService r101 = (IFeatureService) k.f(IFeatureService.class);
        if (r101 == null) goto L7;
        z90.a r102 = r101.getFeatureManager();
        if (r102 == null) goto L7;
        r102.c("show_flash_shop_type", 1);
    L7:
        this.f157806a.put("data_commerce_flash_info", new C2421b());
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.widget.d
    public final void requestWidgetHeight(IExternalWidget r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r100, "widget");
    }
}
