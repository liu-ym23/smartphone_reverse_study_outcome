package ch.qos.logback.core.joran.event.stax;

import javax.xml.stream.Location;

/* loaded from: classes.dex */
public class StaxEvent {
    final Location location;
    final String name;

    public StaxEvent(String str, Location location) {
        this.name = str;
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }
}
