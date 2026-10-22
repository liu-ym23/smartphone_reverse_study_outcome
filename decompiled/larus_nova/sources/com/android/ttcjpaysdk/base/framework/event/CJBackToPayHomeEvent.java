package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJBackToPayHomeEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "needRetain", "", "(Z)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJBackToPayHomeEvent extends BaseEvent {
    public boolean needRetain;

    public CJBackToPayHomeEvent() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public CJBackToPayHomeEvent(boolean r100) {
        this.needRetain = r100;
    }

    public /* synthetic */ CJBackToPayHomeEvent(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }
}
