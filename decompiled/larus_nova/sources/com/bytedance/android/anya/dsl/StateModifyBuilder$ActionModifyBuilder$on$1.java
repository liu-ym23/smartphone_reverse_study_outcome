package com.bytedance.android.anya.dsl;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0010\u001a\u00020\r\"\n\b\u0000\u0010\u0000\u0018\u0001*\u00028\u0004\"\b\b\u0001\u0010\u0001*\u00028\u0003\"\f\b\u0002\u0010\u0003*\u0006\u0012\u0002\b\u00030\u0002\"\b\b\u0003\u0010\u0005*\u00020\u0004\"\b\b\u0004\u0010\u0007*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\n\u001a\u00028\u00022\u0006\u0010\u000b\u001a\u00028\u00032\u0006\u0010\f\u001a\u00028\u0004H\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/android/anya/MVIState;", "VIEW_STATE", "Lcom/bytedance/android/anya/r;", "STATE", "Lcom/bytedance/android/anya/p;", "ACTION", "Lcom/bytedance/android/anya/l0;", "readWriteStateContext", "state", "businessState", "action", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/anya/l0;Lcom/bytedance/android/anya/MVIState;Lcom/bytedance/android/anya/r;Lcom/bytedance/android/anya/p;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class StateModifyBuilder$ActionModifyBuilder$on$1 extends Lambda implements Function4<l0<MVIState<?>>, MVIState<?>, r, p, Unit> {
    final /* synthetic */ Function4 $modifierFun;

    public StateModifyBuilder$ActionModifyBuilder$on$1(Function4 r100) {
        this.$modifierFun = r100;
        super(4);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(l0<MVIState<?>> r100, MVIState<?> r101, r r102, p r103) {
        invoke2(r100, r101, r102, r103);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(l0<MVIState<?>> r100, MVIState<?> r101, r r102, p r103) {
        Function4 r104 = this.$modifierFun;
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        r104.invoke(r100, r103, r101, r102);
    }
}
