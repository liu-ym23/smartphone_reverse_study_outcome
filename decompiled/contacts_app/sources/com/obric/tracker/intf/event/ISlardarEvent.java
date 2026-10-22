package com.obric.tracker.intf.event;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: ISlardarEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\u0003H&J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nH&J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nH&J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\nH&J\b\u0010\u000f\u001a\u00020\u0003H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/tracker/intf/event/ISlardarEvent;", "Lcom/obric/tracker/intf/event/IEvent;", "eventId", "", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "getAction", "getCategoryParams", "", "", "getExtraParams", "getMetricsParams", "", "getScene", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ISlardarEvent extends IEvent {
    /* JADX INFO: renamed from: getAction */
    String mo779getAction();

    Map<String, Object> getCategoryParams();

    String getEventId();

    Map<String, Object> getExtraParams();

    Map<String, Long> getMetricsParams();

    String getScene();

    void setEventId(String r1);
}
