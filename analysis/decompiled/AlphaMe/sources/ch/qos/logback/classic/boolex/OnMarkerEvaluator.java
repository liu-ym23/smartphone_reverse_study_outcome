package ch.qos.logback.classic.boolex;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluatorBase;
import java.util.ArrayList;
import java.util.List;
import n3.e;
import o3.a;

/* loaded from: classes.dex */
public class OnMarkerEvaluator extends EventEvaluatorBase<ILoggingEvent> {
    List<String> markerList = new ArrayList();

    public void addMarker(String str) {
        this.markerList.add(str);
    }

    @Override // ch.qos.logback.core.boolex.EventEvaluator
    public boolean evaluate(ILoggingEvent iLoggingEvent) throws NullPointerException, EvaluationException {
        e marker = iLoggingEvent.getMarker();
        if (marker == null) {
            return false;
        }
        for (String str : this.markerList) {
            a aVar = (a) marker;
            if (str == null) {
                throw new IllegalArgumentException("Other cannot be null");
            }
            if (aVar.f13804a.equals(str)) {
                return true;
            }
            synchronized (aVar) {
            }
        }
        return false;
    }
}
