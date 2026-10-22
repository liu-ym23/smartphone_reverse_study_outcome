package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.shopping.store.router.hybridpage.vo.HybridPageGeneralCardVO;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/store/router/hybridpage/vo/HybridPageGeneralCardVO;", "p1", "", "p2", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ShopHybridDataTransformer$customSingleTransformers$22 extends FunctionReferenceImpl implements Function2<String, String, HybridPageGeneralCardVO> {
    public ShopHybridDataTransformer$customSingleTransformers$22(HybridPageGeneralCardVO.a r100) {
        super(2, r100, HybridPageGeneralCardVO.a.class, "transFromRawData", "transFromRawData(Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/store/router/hybridpage/vo/HybridPageGeneralCardVO;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final HybridPageGeneralCardVO invoke2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((HybridPageGeneralCardVO.a) this.receiver).getClass();
        return HybridPageGeneralCardVO.a.a(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ HybridPageGeneralCardVO invoke(String r100, String r101) {
        return invoke2(r100, r101);
    }
}
