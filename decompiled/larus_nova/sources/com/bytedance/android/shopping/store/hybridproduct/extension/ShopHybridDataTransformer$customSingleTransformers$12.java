package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ldj3/e;", "p1", "", "p2", "Lej3/d;", AbsMethodDelegate.TAG_INVOKE, "(Ldj3/e;Ljava/lang/String;)Lej3/d;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ShopHybridDataTransformer$customSingleTransformers$12 extends FunctionReferenceImpl implements Function2<dj3.e, String, ej3.d> {
    public ShopHybridDataTransformer$customSingleTransformers$12(ej3.d.a r100) {
        super(2, r100, ej3.d.a.class, "transFromDTO", "transFromDTO(Lcom/bytedance/android/shopping/store/hybridproduct/dto/ECShopNoProductDTO;Ljava/lang/String;)Lcom/bytedance/android/shopping/store/hybridproduct/vo/ECShopNoProductVO;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ej3.d invoke2(dj3.e r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((ej3.d.a) this.receiver).getClass();
        return ej3.d.a.a(r100);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ej3.d invoke(dj3.e r100, String r101) {
        return invoke2(r100, r101);
    }
}
