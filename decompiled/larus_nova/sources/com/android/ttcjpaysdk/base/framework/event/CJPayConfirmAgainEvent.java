package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayConfirmAgainEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "params", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "service", "", "(Lorg/json/JSONObject;Ljava/lang/String;)V", "getParams", "()Lorg/json/JSONObject;", "getService", "()Ljava/lang/String;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayConfirmAgainEvent extends BaseEvent {
    private final JSONObject params;
    private final String service;

    public final JSONObject getParams() {
        return this.params;
    }

    public final String getService() {
        return this.service;
    }

    public CJPayConfirmAgainEvent(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this(r100, null);
    }

    public CJPayConfirmAgainEvent(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.params = r100;
        this.service = r101;
    }
}
