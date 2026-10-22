package com.bytedance.android.livesdk.utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.miniapp.alarm.AlarmSessionType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00070\b\"\b\b\u0000\u0010\u0000*\u00028\u0006\"\b\b\u0001\u0010\u0001*\u00028\u0005\"\b\b\u0002\u0010\u0003*\u00020\u0002\"\b\b\u0003\u0010\u0004*\u00020\u0002\"\b\b\u0004\u0010\u0005*\u00020\u0002\"\b\b\u0005\u0010\u0003*\u00020\u0002\"\b\b\u0006\u0010\u0004*\u00020\u0002\"\b\b\u0007\u0010\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u00052\u0006\u0010\u0007\u001a\u00028\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {ExifInterface.LONGITUDE_EAST, ExifInterface.LATITUDE_SOUTH, "", "STATE", AlarmSessionType.EVENT, "SIDE_EFFECT", "state", "event", "Lcom/bytedance/android/livesdk/utils/f6;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/bytedance/android/livesdk/utils/f6;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class StateMachine$GraphBuilder$StateDefinitionBuilder$on$1 extends Lambda implements Function2<Object, Object, f6<Object, Object>> {
    final /* synthetic */ Function2 $createTransitionTo;

    public StateMachine$GraphBuilder$StateDefinitionBuilder$on$1(Function2 r100) {
        this.$createTransitionTo = r100;
        super(2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function2
    public final f6<Object, Object> invoke(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "event");
        return (f6) this.$createTransitionTo.invoke(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ f6<Object, Object> invoke(Object r100, Object r101) {
        return invoke(r100, r101);
    }
}
