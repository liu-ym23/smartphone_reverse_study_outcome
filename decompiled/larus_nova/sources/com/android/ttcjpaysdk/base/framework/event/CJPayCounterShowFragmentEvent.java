package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayCounterShowFragmentEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "originType", "", "respectType", "isNeedAnimation", "", "(IIZ)V", "()Z", "getOriginType", "()I", "getRespectType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCounterShowFragmentEvent extends BaseEvent {
    private final boolean isNeedAnimation;
    private final int originType;
    private final int respectType;

    public final int getOriginType() {
        return this.originType;
    }

    public final int getRespectType() {
        return this.respectType;
    }

    public final boolean isNeedAnimation() {
        return this.isNeedAnimation;
    }

    public CJPayCounterShowFragmentEvent(int r100, int r101, boolean r102) {
        this.originType = r100;
        this.respectType = r101;
        this.isNeedAnimation = r102;
    }
}
