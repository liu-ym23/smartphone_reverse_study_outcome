package com.bytedance.android.live.core.arch.mvvm;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "p1", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class StateBuffer$sendState$1 extends FunctionReferenceImpl implements Function1<Object, Unit> {
    public StateBuffer$sendState$1(StateBuffer r100) {
        super(1, r100, StateBuffer.class, "processState", "processState(Ljava/lang/Object;)V", 0);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        StateBuffer r101 = (StateBuffer) this.receiver;
        r101.f64756a.invoke((Object) r100);
        PublishSubject<T> r102 = r101.f64757b;
        Intrinsics.checkNotNull(r100);
        r102.onNext((T) r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
