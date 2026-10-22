package com.bytedance.android.debug;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/debug/KmpDebugAssetsManager$downloadAssetByUrl$2$finalResult$1$onResult$1"}, k = 3, mv = {1, 5, 1})
final class KmpDebugAssetsManager$downloadAssetByUrl$$inlined$let$lambda$1$1 extends Lambda implements Function1<String, Boolean> {
    final /* synthetic */ n this$0;

    public KmpDebugAssetsManager$downloadAssetByUrl$$inlined$let$lambda$1$1(n r100) {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String r100) {
        return Boolean.valueOf(invoke2(r100));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        throw null;
    }
}
