package com.obric.tracker.intf.event;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: ITeaEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/tracker/intf/event/ITeaEvent;", "Lcom/obric/tracker/intf/event/IEvent;", "getEventName", "", "getEventParams", "Lorg/json/JSONObject;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ITeaEvent extends IEvent {
    String getEventName();

    JSONObject getEventParams();
}
