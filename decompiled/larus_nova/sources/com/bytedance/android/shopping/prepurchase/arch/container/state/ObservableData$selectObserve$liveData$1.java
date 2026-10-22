package com.bytedance.android.shopping.prepurchase.arch.container.state;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\r\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000b\u0010\u0003\u001a\u00078\u0001¢\u0006\u0002\b\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/jvm/JvmSuppressWildcards;", "it", "Lcom/bytedance/android/shopping/prepurchase/arch/container/state/k;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Lcom/bytedance/android/shopping/prepurchase/arch/container/state/k;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ObservableData$selectObserve$liveData$1 extends Lambda implements Function1<Object, k<Object>> {
    final /* synthetic */ KProperty1 $prop1;

    public ObservableData$selectObserve$liveData$1(KProperty1 r100) {
        this.$prop1 = r100;
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final k<Object> invoke(Object r100) {
        return new k(this.$prop1.get(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ k<Object> invoke(Object r100) {
        return invoke(r100);
    }
}
