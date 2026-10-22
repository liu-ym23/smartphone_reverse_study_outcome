package com.bytedance.android.sdk.bdticketguard.key;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"readBytes", "", "len", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class DerEcdsaSignature$decode$3 extends Lambda implements Function1<Integer, byte[]> {
    final /* synthetic */ byte[] $der;
    final /* synthetic */ Ref.IntRef $idx;

    public DerEcdsaSignature$decode$3(byte[] r100, Ref.IntRef r101) {
        this.$der = r100;
        this.$idx = r101;
        super(1);
    }

    public final byte[] invoke(int r100) {
        if (r100 < 0) goto L8;
        int r101 = this.$idx.element;
        int r102 = r101 + r100;
        byte[] r103 = this.$der;
        if (r102 > r103.length) goto L8;
        byte[] r104 = ArraysKt.copyOfRange(r103, r101, r101 + r100);
        this.$idx.element += r100;
        return r104;
    L8:
        throw new IllegalArgumentException("DER length out of range");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ byte[] invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
