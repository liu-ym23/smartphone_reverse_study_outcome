package com.bytedance.android.shopping.anchorv4.schemav2;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PdpSchemaOld2NewConverter$Companion$composeProcessor$2 extends Lambda implements Function2<Object, Object, Boolean> {
    final /* synthetic */ String $enterFrom;

    public PdpSchemaOld2NewConverter$Companion$composeProcessor$2(String r100) {
        this.$enterFrom = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Object r100, Object r101) {
        if (Intrinsics.areEqual(this.$enterFrom, "my_history") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.$enterFrom, "shopping_cart_tag") == true) goto L8;
        return false;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Object r100, Object r101) {
        return Boolean.valueOf(invoke2(r100, r101));
    }
}
