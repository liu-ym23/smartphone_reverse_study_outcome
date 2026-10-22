package com.bytedance.android.shopping.anchorv4.containers.page;

import com.bytedance.android.shopping.anchorv4.vm.AnchorV4State;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class BaseProductDetailPage$subscribeViewModel$21 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new BaseProductDetailPage$subscribeViewModel$21();
    }

    public BaseProductDetailPage$subscribeViewModel$21() {
        super(AnchorV4State.class, "bottomNavVO", "getBottomNavVO()Lcom/bytedance/android/shopping/anchorv4/bottomnav/BottomNavVO;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return ((AnchorV4State) r100).H;
    }
}
