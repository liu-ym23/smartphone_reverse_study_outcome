package ch.qos.logback.core.joran.conditional;

import ch.qos.logback.core.joran.event.InPlayListener;
import ch.qos.logback.core.joran.event.SaxEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class ThenActionState implements InPlayListener {
    List<SaxEvent> eventList = new ArrayList();
    boolean isRegistered = false;

    @Override // ch.qos.logback.core.joran.event.InPlayListener
    public void inPlay(SaxEvent saxEvent) {
        this.eventList.add(saxEvent);
    }
}
