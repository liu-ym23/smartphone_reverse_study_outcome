package com.bytedance.android.scope;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/scope/j;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/scope/k;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/scope/k;Lcom/bytedance/android/scope/j;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class IntrinsicsKt$createScope$1 extends Lambda implements Function2 {
    public static final IntrinsicsKt$createScope$1 INSTANCE = null;

    static {
        INSTANCE = new IntrinsicsKt$createScope$1();
    }

    public IntrinsicsKt$createScope$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        invoke((k) r100, (j) r101);
        return Unit.INSTANCE;
    }

    public final void invoke(k r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        Intrinsics.checkNotNullParameter(r101, "it");
    }
}
