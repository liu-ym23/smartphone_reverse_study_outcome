package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayFinishH5ActivityFastPayEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "from", "", "(Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFinishH5ActivityFastPayEvent extends BaseEvent {
    private final String from;

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayFinishH5ActivityFastPayEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String getFrom() {
        return this.from;
    }

    public CJPayFinishH5ActivityFastPayEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.from = r100;
    }

    public /* synthetic */ CJPayFinishH5ActivityFastPayEvent(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}
