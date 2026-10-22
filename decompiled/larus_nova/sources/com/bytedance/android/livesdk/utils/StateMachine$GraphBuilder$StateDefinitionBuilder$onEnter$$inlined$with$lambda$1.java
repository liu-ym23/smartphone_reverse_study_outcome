package com.bytedance.android.livesdk.utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.miniapp.alarm.AlarmSessionType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u0002H\u0003\"\b\b\u0001\u0010\u0003*\u00020\u0004\"\b\b\u0002\u0010\u0005*\u00020\u0004\"\b\b\u0003\u0010\u0006*\u00020\u0004\"\b\b\u0004\u0010\u0003*\u00020\u0004\"\b\b\u0005\u0010\u0005*\u00020\u0004\"\b\b\u0006\u0010\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u0002H\u00032\u0006\u0010\b\u001a\u0002H\u0005H\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, "STATE", "", AlarmSessionType.EVENT, "SIDE_EFFECT", "state", "cause", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)V", "com/bytedance/android/livesdk/utils/StateMachine$GraphBuilder$StateDefinitionBuilder$onEnter$1$1"}, k = 3, mv = {1, 4, 3})
final class StateMachine$GraphBuilder$StateDefinitionBuilder$onEnter$$inlined$with$lambda$1 extends Lambda implements Function2<Object, Object, Unit> {
    final /* synthetic */ Function2 $listener$inlined;

    public StateMachine$GraphBuilder$StateDefinitionBuilder$onEnter$$inlined$with$lambda$1(Function2 r100) {
        this.$listener$inlined = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "cause");
        this.$listener$inlined.invoke(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object r100, Object r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
