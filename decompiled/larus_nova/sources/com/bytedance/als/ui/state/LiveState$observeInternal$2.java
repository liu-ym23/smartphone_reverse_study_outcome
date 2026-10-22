package com.bytedance.als.ui.state;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class LiveState$observeInternal$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LiveState.CallbackWithLifecycle $callbackWithLifecycle;
    final /* synthetic */ LiveState this$0;

    public LiveState$observeInternal$2(LiveState r100, LiveState.CallbackWithLifecycle r101) {
        this.this$0 = r100;
        this.$callbackWithLifecycle = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
