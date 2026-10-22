package com.bytedance.android.live.core.utils.rxutils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0001\u0010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "OB", "Lio/reactivex/Observer;", ExifInterface.GPS_DIRECTION_TRUE, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class RxUtilKt$asDisposable$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $doOnDispose;
    final /* synthetic */ Observer $this_asDisposable;

    public RxUtilKt$asDisposable$2(Observer r100, Function1 r101) {
        this.$this_asDisposable = r100;
        this.$doOnDispose = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$doOnDispose.invoke(this.$this_asDisposable);
    }
}
