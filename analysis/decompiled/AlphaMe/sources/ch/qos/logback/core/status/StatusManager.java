package ch.qos.logback.core.status;

import java.util.List;

/* loaded from: classes.dex */
public interface StatusManager {
    void add(Status status);

    void add(StatusListener statusListener);

    void clear();

    List<Status> getCopyOfStatusList();

    List<StatusListener> getCopyOfStatusListenerList();

    int getCount();

    void remove(StatusListener statusListener);
}
