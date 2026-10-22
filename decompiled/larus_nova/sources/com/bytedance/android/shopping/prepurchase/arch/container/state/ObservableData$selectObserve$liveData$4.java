package com.bytedance.android.shopping.prepurchase.arch.container.state;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\b\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u00042\u000b\u0010\u0006\u001a\u00078\u0004¢\u0006\u0002\b\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/jvm/JvmSuppressWildcards;", "it", "Lcom/bytedance/android/shopping/prepurchase/arch/container/state/n;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Lcom/bytedance/android/shopping/prepurchase/arch/container/state/n;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ObservableData$selectObserve$liveData$4 extends Lambda implements Function1<Object, n<Object, Object, Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;
    final /* synthetic */ KProperty1 $prop3;
    final /* synthetic */ KProperty1 $prop4;

    public ObservableData$selectObserve$liveData$4(KProperty1 r100, KProperty1 r101, KProperty1 r102, KProperty1 r103) {
        this.$prop1 = r100;
        this.$prop2 = r101;
        this.$prop3 = r102;
        this.$prop4 = r103;
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final n<Object, Object, Object, Object> invoke(Object r100) {
        return new n(this.$prop1.get(r100), this.$prop2.get(r100), this.$prop3.get(r100), this.$prop4.get(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ n<Object, Object, Object, Object> invoke(Object r100) {
        return invoke(r100);
    }
}
