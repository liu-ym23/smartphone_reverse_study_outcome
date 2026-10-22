package com.android.ttcjpaysdk.kmp.common.view.voucher_tag;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class CJStandardVoucherTagContainerKt$StandardVoucherTagContainer$lambda$5$lambda$2$lambda$1$$inlined$items$default$2 implements Function1<Integer, Object> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function1 $key;

    public CJStandardVoucherTagContainerKt$StandardVoucherTagContainer$lambda$5$lambda$2$lambda$1$$inlined$items$default$2(Function1 r100, List r101) {
        this.$key = r100;
        this.$items = r101;
    }

    public final Object invoke(int r100) {
        return this.$key.invoke(ListProtector.get(this.$items, r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
