package com.android.ttcjpaysdk.base.eventbus;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/eventbus/Observer;", "", "listEvents", "", "Ljava/lang/Class;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "()[Ljava/lang/Class;", "onEvent", "", "event", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Observer {
    Class<? extends BaseEvent>[] listEvents();

    void onEvent(BaseEvent r100);
}
