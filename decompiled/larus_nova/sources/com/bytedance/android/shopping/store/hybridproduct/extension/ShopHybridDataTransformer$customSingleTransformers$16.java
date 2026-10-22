package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/l;", "p1", "", "p2", "Lcom/bytedance/android/ec/store/repository/vo/l;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/ec/store/repository/dto/l;Ljava/lang/String;)Lcom/bytedance/android/ec/store/repository/vo/l;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ShopHybridDataTransformer$customSingleTransformers$16 extends FunctionReferenceImpl implements Function2<com.bytedance.android.ec.store.repository.dto.l, String, com.bytedance.android.ec.store.repository.vo.l> {
    public ShopHybridDataTransformer$customSingleTransformers$16(com.bytedance.android.ec.store.repository.vo.l.a r100) {
        super(2, r100, com.bytedance.android.ec.store.repository.vo.l.a.class, "transFromStoreV2ProductItemDTO", "transFromStoreV2ProductItemDTO(Lcom/bytedance/android/ec/store/repository/dto/StoreV2ProductItemDTO;Ljava/lang/String;)Lcom/bytedance/android/ec/store/repository/vo/ShopSlcProductItemVO;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.bytedance.android.ec.store.repository.vo.l invoke2(com.bytedance.android.ec.store.repository.dto.l r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((com.bytedance.android.ec.store.repository.vo.l.a) this.receiver).getClass();
        return com.bytedance.android.ec.store.repository.vo.l.a.a(r100);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ com.bytedance.android.ec.store.repository.vo.l invoke(com.bytedance.android.ec.store.repository.dto.l r100, String r101) {
        return invoke2(r100, r101);
    }
}
