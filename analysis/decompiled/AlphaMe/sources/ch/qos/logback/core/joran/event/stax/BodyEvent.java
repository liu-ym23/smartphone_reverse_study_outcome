package ch.qos.logback.core.joran.event.stax;

import B0.g;
import javax.xml.stream.Location;

/* loaded from: classes.dex */
public class BodyEvent extends StaxEvent {
    private String text;

    public BodyEvent(String str, Location location) {
        super(null, location);
        this.text = str;
    }

    public void append(String str) {
        this.text = g.r(new StringBuilder(), this.text, str);
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "BodyEvent(" + getText() + ")" + this.location.getLineNumber() + "," + this.location.getColumnNumber();
    }
}
