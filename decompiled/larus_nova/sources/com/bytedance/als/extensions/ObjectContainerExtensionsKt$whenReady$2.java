package com.bytedance.als.extensions;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.als.b;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/als/b;", ExifInterface.GPS_DIRECTION_TRUE, "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/als/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class ObjectContainerExtensionsKt$whenReady$2 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ Function1 $callback;

    public ObjectContainerExtensionsKt$whenReady$2(Function1 r100) {
        this.$callback = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(b r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.$callback.invoke(r100);
    }
}
