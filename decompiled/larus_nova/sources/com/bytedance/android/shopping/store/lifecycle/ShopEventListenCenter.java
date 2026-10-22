package com.bytedance.android.shopping.store.lifecycle;

import android.view.WindowManager;
import com.bytedance.android.ec.store.api.IShopEventListener;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes14.dex */
public final class ShopEventListenCenter implements IShopEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f185438a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ShopEventListenCenter f185439b = null;

    public ShopEventListenCenter() {
    }

    public static ConcurrentHashMap a() {
        return (ConcurrentHashMap) f185438a.getValue();
    }

    static {
        f185439b = new ShopEventListenCenter();
        f185438a = LazyKt.lazy(ShopEventListenCenter$listeners$2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.store.api.IShopEventListener
    public final void onDestroy() {
        Iterator r100 = a().values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((IShopEventListener) r100.next()).onDestroy();
        goto L4
    }

    @Override // com.bytedance.android.ec.store.api.IShopEventListener
    public final void onPause(String r100) {
        Iterator r101 = a().values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IShopEventListener) r101.next()).onPause(r100);
        goto L4
    }

    @Override // com.bytedance.android.ec.store.api.IShopEventListener
    public final void onResume(String r100) {
        Iterator r101 = a().values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IShopEventListener) r101.next()).onResume(r100);
        goto L4
    }

    @Override // com.bytedance.android.ec.store.api.IShopEventListener
    public final void onShow(WindowManager r100) {
        Iterator r101 = a().values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IShopEventListener) r101.next()).onShow(r100);
        goto L4
    }
}
