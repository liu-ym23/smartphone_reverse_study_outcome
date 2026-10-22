package com.bytedance.als.ui.state;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ExifInterface.GPS_DIRECTION_TRUE, AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
final class LiveState$getState$newLiveState$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ KProperty1 $property;
    final /* synthetic */ LiveState this$0;

    public LiveState$getState$newLiveState$1(LiveState r100, KProperty1 r101) {
        this.this$0 = r100;
        this.$property = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        LiveState r100 = this.this$0;
        monitor-enter(r100);
        r100.getClass();     // Catch: Throwable -> L6
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
