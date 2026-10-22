package com.bytedance.android.sdk.bdticketguard.math;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class HmacHelper$byteArrayToHex$1 extends Lambda implements Function1<Byte, String> {
    public static final HmacHelper$byteArrayToHex$1 INSTANCE = null;

    static {
        INSTANCE = new HmacHelper$byteArrayToHex$1();
    }

    public HmacHelper$byteArrayToHex$1() {
        super(1);
    }

    public final String invoke(byte r100) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r100)}, 1));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Byte r100) {
        return invoke(r100.byteValue());
    }
}
