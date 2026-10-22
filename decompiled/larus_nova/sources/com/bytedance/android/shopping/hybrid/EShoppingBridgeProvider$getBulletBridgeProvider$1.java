package com.bytedance.android.shopping.hybrid;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.hybrid.bridges.ECGalleryMethod;
import com.bytedance.android.shopping.hybrid.bridges.HideTaskBannerMethod;
import com.bytedance.android.shopping.hybrid.bridges.ShowTaskBannerMethod;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class EShoppingBridgeProvider$getBulletBridgeProvider$1 extends Lambda implements Function0<List<? extends ECBaseBridgeMethod>> {
    public static final EShoppingBridgeProvider$getBulletBridgeProvider$1 INSTANCE = null;

    static {
        INSTANCE = new EShoppingBridgeProvider$getBulletBridgeProvider$1();
    }

    public EShoppingBridgeProvider$getBulletBridgeProvider$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends ECBaseBridgeMethod> invoke2() {
        return CollectionsKt.listOf(new ECBaseBridgeMethod[]{new ECGalleryMethod(), new ShowTaskBannerMethod(), new HideTaskBannerMethod()});
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends ECBaseBridgeMethod> invoke() {
        return invoke2();
    }
}
