package com.bytedance.android.ec.core.arch.state;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\b\b\u0006\u0010\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00028\u0006H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, FaceService.girlLabel, "Lcom/bytedance/android/ec/core/arch/state/b;", ExifInterface.LATITUDE_SOUTH, "it", "Lcom/bytedance/android/ec/core/arch/state/k;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/ec/core/arch/state/b;)Lcom/bytedance/android/ec/core/arch/state/k;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class StateRepository$observePartOfState$11 extends Lambda implements Function1<b, k<Object, Object, Object, Object, Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;
    final /* synthetic */ KProperty1 $prop3;
    final /* synthetic */ KProperty1 $prop4;
    final /* synthetic */ KProperty1 $prop5;
    final /* synthetic */ KProperty1 $prop6;

    public StateRepository$observePartOfState$11(KProperty1 r100, KProperty1 r101, KProperty1 r102, KProperty1 r103, KProperty1 r104, KProperty1 r105) {
        this.$prop1 = r100;
        this.$prop2 = r101;
        this.$prop3 = r102;
        this.$prop4 = r103;
        this.$prop5 = r104;
        this.$prop6 = r105;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final k<Object, Object, Object, Object, Object, Object> invoke2(b r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return new k(this.$prop1.get(r100), this.$prop2.get(r100), this.$prop3.get(r100), this.$prop4.get(r100), this.$prop5.get(r100), this.$prop6.get(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ k<Object, Object, Object, Object, Object, Object> invoke(b r100) {
        return invoke2(r100);
    }
}
