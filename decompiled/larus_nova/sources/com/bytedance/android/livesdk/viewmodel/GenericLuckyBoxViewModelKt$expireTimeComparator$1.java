package com.bytedance.android.livesdk.viewmodel;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/viewmodel/f;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/viewmodel/f;Lcom/bytedance/android/livesdk/viewmodel/f;)I", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class GenericLuckyBoxViewModelKt$expireTimeComparator$1 extends Lambda implements Function2<f<?>, f<?>, Integer> {
    public static final GenericLuckyBoxViewModelKt$expireTimeComparator$1 INSTANCE = null;

    static {
        INSTANCE = new GenericLuckyBoxViewModelKt$expireTimeComparator$1();
    }

    public GenericLuckyBoxViewModelKt$expireTimeComparator$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(f<?> r100, f<?> r101) {
        return Integer.valueOf(invoke2(r100, r101));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(f<?> r100, f<?> r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        r100.getClass();
        r101.getClass();
        return 0;
    }
}
