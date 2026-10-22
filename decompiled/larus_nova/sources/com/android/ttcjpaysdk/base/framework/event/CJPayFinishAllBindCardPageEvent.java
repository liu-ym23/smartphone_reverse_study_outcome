package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayFinishAllBindCardPageEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "isDoAnim", "", "(Z)V", "()Z", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFinishAllBindCardPageEvent extends BaseEvent {
    private final boolean isDoAnim;

    public CJPayFinishAllBindCardPageEvent() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public final boolean isDoAnim() {
        return this.isDoAnim;
    }

    public CJPayFinishAllBindCardPageEvent(boolean r100) {
        this.isDoAnim = r100;
    }

    public /* synthetic */ CJPayFinishAllBindCardPageEvent(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }
}
