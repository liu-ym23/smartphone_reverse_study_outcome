package com.bytedance.als;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.als.exceptions.ALSFrameworkInternalException;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/als/b;", ExifInterface.GPS_DIRECTION_TRUE, "api", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/als/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class LogicComponent$whenReadyOrThrowInternal$verifyOneShotOnReady$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ Function1 $onReady;
    final /* synthetic */ Ref.BooleanRef $onReadyInvoked;

    public LogicComponent$whenReadyOrThrowInternal$verifyOneShotOnReady$1(Ref.BooleanRef r100, Function1 r101) {
        this.$onReadyInvoked = r100;
        this.$onReady = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(b r100) {
        Intrinsics.checkNotNullParameter(r100, "api");
        Ref.BooleanRef r101 = this.$onReadyInvoked;
        if (r101.element == true) goto L7;
        r101.element = true;
        this.$onReady.invoke(r100);
        return;
    L7:
        throw new ALSFrameworkInternalException("Repeated call");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
