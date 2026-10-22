package com.bytedance.android.shopping.prepurchase.arch.container.state;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a%\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\b¢\u0006\u0002\b\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u00052\u000b\u0010\u0007\u001a\u00078\u0005¢\u0006\u0002\b\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/jvm/JvmSuppressWildcards;", "it", "Lcom/bytedance/android/shopping/prepurchase/arch/container/state/o;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Lcom/bytedance/android/shopping/prepurchase/arch/container/state/o;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ObservableData$selectObserve$liveData$5 extends Lambda implements Function1<Object, o<Object, Object, Object, Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;
    final /* synthetic */ KProperty1 $prop3;
    final /* synthetic */ KProperty1 $prop4;
    final /* synthetic */ KProperty1 $prop5;

    public ObservableData$selectObserve$liveData$5(KProperty1 r100, KProperty1 r101, KProperty1 r102, KProperty1 r103, KProperty1 r104) {
        this.$prop1 = r100;
        this.$prop2 = r101;
        this.$prop3 = r102;
        this.$prop4 = r103;
        this.$prop5 = r104;
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final o<Object, Object, Object, Object, Object> invoke(Object r100) {
        return new o(this.$prop1.get(r100), this.$prop2.get(r100), this.$prop3.get(r100), this.$prop4.get(r100), this.$prop5.get(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ o<Object, Object, Object, Object, Object> invoke(Object r100) {
        return invoke(r100);
    }
}
