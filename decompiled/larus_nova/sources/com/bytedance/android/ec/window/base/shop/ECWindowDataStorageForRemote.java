package com.bytedance.android.ec.window.base.shop;

import com.bytedance.android.ec.window.base.repository.vo.WindowRemoteStruct;
import com.bytedance.keva.Keva;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECWindowDataStorageForRemote {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECWindowDataStorageForRemote f49580a = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/ECWindowDataStorageForRemote$TYPE;", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface TYPE {
    }

    public ECWindowDataStorageForRemote() {
    }

    static {
        f49580a = new ECWindowDataStorageForRemote();
        Keva.getRepo("ec_shop_storage_for_remote_-1_-1", 1);
    }

    public final synchronized WindowRemoteStruct a(int r100, String r101, String r102, String r103, String r104) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r101, "secShopId");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullParameter(r102, "userId");     // Catch: Throwable -> L30
        Keva r105 = Keva.getRepo("ec_shop_storage_for_remote_" + r102 + '_' + r101, 1);     // Catch: Throwable -> L30
        Object r106 = null;
        if (r100 == 0) goto L23;
        if (r100 != 1) goto L7;
    L17:
        if (r103 != null) goto L20;
        monitor-exit(this);
        return null;
    L20:
        r105.storeString(r103, r104);     // Catch: Throwable -> L30
    L21:
        monitor-exit(this);
        return null;
    L7:
        if (r100 != 2) goto L9;
        if (r103 != null) goto L15;
        monitor-exit(this);
        return null;
    L15:
        r105.storeString(r103, null);     // Catch: Throwable -> L30
        goto L21
    L9:
        if (r100 == 3) goto L17;
        EnsureManager.ensureNotReachHere("ECShopDataStorageForRemote_error_action_type");     // Catch: Throwable -> L30
        goto L21
    L23:
        String r107 = r105.getString(r103, null);     // Catch: Throwable -> L30
        if ((r107 instanceof WindowRemoteStruct) == false) goto L27;
        r106 = r107;
    L27:
        WindowRemoteStruct r108 = (WindowRemoteStruct) r106;     // Catch: Throwable -> L30
        monitor-exit(this);
        return r108;
    L30:
        th = move-exception;
        throw th;
    }
}
