package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopFooterDTO;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/dto/ECShopFooterDTO;", "p1", "", "p2", "Lej3/c;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/shopping/store/hybridproduct/dto/ECShopFooterDTO;Ljava/lang/String;)Lej3/c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ShopHybridDataTransformer$customSingleTransformers$9 extends FunctionReferenceImpl implements Function2<ECShopFooterDTO, String, ej3.c> {
    public ShopHybridDataTransformer$customSingleTransformers$9(ej3.c.a r100) {
        super(2, r100, ej3.c.a.class, "transFromDTO", "transFromDTO(Lcom/bytedance/android/shopping/store/hybridproduct/dto/ECShopFooterDTO;Ljava/lang/String;)Lcom/bytedance/android/shopping/store/hybridproduct/vo/ECShopFooterVO;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ej3.c invoke2(ECShopFooterDTO r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((ej3.c.a) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "dto");
        ej3.c r102 = new ej3.c();
        r102.f472843a = r100.getText();
        r100.getTextColor();
        r100.getFontSize();
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ej3.c invoke(ECShopFooterDTO r100, String r101) {
        return invoke2(r100, r101);
    }
}
