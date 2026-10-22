package ch.qos.logback.core.joran.conditional;

import ch.qos.logback.core.joran.event.SaxEvent;
import java.util.List;

/* loaded from: classes.dex */
class IfState {
    boolean active;
    Boolean boolResult;
    List<SaxEvent> elseSaxEventList;
    List<SaxEvent> thenSaxEventList;
}
