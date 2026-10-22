package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopEndDTO;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/dto/ECShopEndDTO;", "p1", "", "p2", "Lej3/b;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/shopping/store/hybridproduct/dto/ECShopEndDTO;Ljava/lang/String;)Lej3/b;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ShopHybridDataTransformer$customSingleTransformers$11 extends FunctionReferenceImpl implements Function2<ECShopEndDTO, String, ej3.b> {
    public ShopHybridDataTransformer$customSingleTransformers$11(ej3.b.a r100) {
        super(2, r100, ej3.b.a.class, "transFromDto", "transFromDto(Lcom/bytedance/android/shopping/store/hybridproduct/dto/ECShopEndDTO;Ljava/lang/String;)Lcom/bytedance/android/shopping/store/hybridproduct/vo/ECShopEndVO;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ej3.b invoke2(ECShopEndDTO r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((ej3.b.a) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "dto");
        return new ej3.b();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ej3.b invoke(ECShopEndDTO r100, String r101) {
        return invoke2(r100, r101);
    }
}
