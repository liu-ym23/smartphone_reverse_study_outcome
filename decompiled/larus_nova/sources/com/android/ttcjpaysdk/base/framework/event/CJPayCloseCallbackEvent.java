package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayCloseCallbackEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "code", "", "closeCallback", "Lkotlin/Function0;", "", "(ILkotlin/jvm/functions/Function0;)V", "getCloseCallback", "()Lkotlin/jvm/functions/Function0;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCloseCallbackEvent extends BaseEvent {
    private final Function0<Unit> closeCallback;
    public final int code;

    public final Function0<Unit> getCloseCallback() {
        return this.closeCallback;
    }

    public CJPayCloseCallbackEvent(int r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "closeCallback");
        this.code = r100;
        this.closeCallback = r101;
    }
}
