package com.bytedance.android.live.core.utils.rxutils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 3})
final class RxUtilKt$subscribeOnErrorNoOp$2 extends Lambda implements Function1 {
    public static final RxUtilKt$subscribeOnErrorNoOp$2 INSTANCE = null;

    static {
        INSTANCE = new RxUtilKt$subscribeOnErrorNoOp$2();
    }

    public RxUtilKt$subscribeOnErrorNoOp$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        m8172invoke(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m8172invoke(Object r100) {
    }
}
