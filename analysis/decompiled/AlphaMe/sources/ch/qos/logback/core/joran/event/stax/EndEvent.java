package ch.qos.logback.core.joran.event.stax;

import javax.xml.stream.Location;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class EndEvent extends StaxEvent {
    public EndEvent(String str, Location location) {
        super(str, location);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EndEvent(");
        sb.append(getName());
        sb.append(")  [");
        sb.append(this.location.getLineNumber());
        sb.append(",");
        return AbstractC0831a.d(sb, this.location.getColumnNumber(), "]");
    }
}
