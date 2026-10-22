package com.bytedance.android.sdk.bdticketguard.key;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"readLen", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class DerEcdsaSignature$decode$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ DerEcdsaSignature$decode$1 $readByte$1;

    public DerEcdsaSignature$decode$2(DerEcdsaSignature$decode$1 r100) {
        this.$readByte$1 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        int r100 = this.$readByte$1.invoke2();
        if ((r100 & 128) != 0) goto L5;
        return r100;
    L5:
        int r101 = r100 & 127;
        if (r101 == 0) goto L14;
        if (r101 > 4) goto L14;
        int r102 = 0;
        int r103 = 0;
    L10:
        if (r102 >= r101) goto L12;
        r103 = (r103 << 8) | this.$readByte$1.invoke2();
        r102 = r102 + 1;
        goto L10
    L12:
        return r103;
    L14:
        throw new IllegalArgumentException("Unsupported DER length");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }
}
