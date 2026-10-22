package com.bytedance.als.ui.state;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "it", "Lkotlin/Triple;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class LiveState3$observe$1 extends Lambda implements Function1<Triple<Object, Object, Object>, Unit> {
    final /* synthetic */ Function3 $callback;

    public LiveState3$observe$1(Function3 r100) {
        this.$callback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Triple<Object, Object, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.$callback.invoke(r100.getFirst(), r100.getSecond(), r100.getThird());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Triple<Object, Object, Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
