package com.bytedance.android.sdk.bdticketguard.key;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"readByte", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class DerEcdsaSignature$decode$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ byte[] $der;
    final /* synthetic */ Ref.IntRef $idx;

    public DerEcdsaSignature$decode$1(Ref.IntRef r100, byte[] r101) {
        this.$idx = r100;
        this.$der = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        Ref.IntRef r100 = this.$idx;
        int r101 = r100.element;
        byte[] r102 = this.$der;
        if (r101 >= r102.length) goto L7;
        r100.element = r101 + 1;
        return r102[r101] & UByte.MAX_VALUE;
    L7:
        throw new IllegalArgumentException("DER truncated");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }
}
