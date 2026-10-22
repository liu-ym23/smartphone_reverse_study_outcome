package com.bytedance.android.bcm.impl2;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class ScopedBcmConfigManager$fetchBcmConfig$2$callback$1 extends Lambda implements Function0<String> {
    final /* synthetic */ InputStream $stream;

    public ScopedBcmConfigManager$fetchBcmConfig$2$callback$1(InputStream r100) {
        this.$stream = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        StringBuilder r100 = new StringBuilder("receiveBcmConfig, has content: ");
        if (this.$stream == null) goto L5;
        boolean r101 = true;
    L6:
        r100.append(r101);
        return r100.toString();
    L5:
        r101 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
