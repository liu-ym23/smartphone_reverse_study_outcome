package com.bytedance.als.ui.state;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u00032\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", "Lcom/bytedance/als/ui/state/e;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/als/ui/state/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class LiveState4$observe$1 extends Lambda implements Function1<e<Object, Object, Object, Object>, Unit> {
    final /* synthetic */ Function4 $callback;

    public LiveState4$observe$1(Function4 r100) {
        this.$callback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(e<Object, Object, Object, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Function4 r101 = this.$callback;
        r100.getClass();
        r101.invoke(null, null, null, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(e<Object, Object, Object, Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
