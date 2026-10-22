package com.bytedance.android.ec.core.arch.state;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\b\b\u0002\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lcom/bytedance/android/ec/core/arch/state/b;", ExifInterface.LATITUDE_SOUTH, "it", "Lcom/bytedance/android/ec/core/arch/state/g;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/ec/core/arch/state/b;)Lcom/bytedance/android/ec/core/arch/state/g;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class StateRepository$observePartOfState$3 extends Lambda implements Function1<b, g<Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;

    public StateRepository$observePartOfState$3(KProperty1 r100, KProperty1 r101) {
        this.$prop1 = r100;
        this.$prop2 = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final g<Object, Object> invoke2(b r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return new g(this.$prop1.get(r100), this.$prop2.get(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ g<Object, Object> invoke(b r100) {
        return invoke2(r100);
    }
}
