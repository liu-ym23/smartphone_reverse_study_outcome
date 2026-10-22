package com.android.ttcjpaysdk.base.adapter;

import com.android.ttcjpaysdk.base.service.ICJExternalEventCenterCallback;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u001a\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/adapter/ICJExternalEventCenterAdapter;", "", "enqueueEvent", "", "eventName", "", "timestamp", "", "params", "Lorg/json/JSONObject;", "registerJsEventSubscriber", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJExternalEventCenterCallback;", "registerSubscriber", "containerId", "unregisterJsEventSubscriber", "subscriber", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJExternalEventCenterAdapter {
    void enqueueEvent(String r100, long r101, JSONObject r102);

    Object registerJsEventSubscriber(String r100, ICJExternalEventCenterCallback r101);

    void registerSubscriber(String r100, long r101, String r102, ICJExternalEventCenterCallback r103);

    void unregisterJsEventSubscriber(String r100, Object r101);
}
