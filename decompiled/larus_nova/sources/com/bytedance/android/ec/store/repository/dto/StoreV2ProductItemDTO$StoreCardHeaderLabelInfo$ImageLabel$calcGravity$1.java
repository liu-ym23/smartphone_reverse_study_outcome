package com.bytedance.android.ec.store.repository.dto;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;)Ljava/lang/Integer;"}, k = 3, mv = {1, 4, 3})
final class StoreV2ProductItemDTO$StoreCardHeaderLabelInfo$ImageLabel$calcGravity$1 extends Lambda implements Function1<String, Integer> {
    public static final StoreV2ProductItemDTO$StoreCardHeaderLabelInfo$ImageLabel$calcGravity$1 INSTANCE = null;

    static {
        INSTANCE = new StoreV2ProductItemDTO$StoreCardHeaderLabelInfo$ImageLabel$calcGravity$1();
    }

    public StoreV2ProductItemDTO$StoreCardHeaderLabelInfo$ImageLabel$calcGravity$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return l.f.b.f48392a.get(StringsKt.trim(r100).toString());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(String r100) {
        return invoke2(r100);
    }
}
