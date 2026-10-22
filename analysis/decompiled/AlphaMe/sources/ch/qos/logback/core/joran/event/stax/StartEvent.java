package ch.qos.logback.core.joran.event.stax;

import ch.qos.logback.core.joran.spi.ElementPath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.stream.Location;
import javax.xml.stream.events.Attribute;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class StartEvent extends StaxEvent {
    List<Attribute> attributes;
    public ElementPath elementPath;

    public StartEvent(ElementPath elementPath, String str, Iterator<Attribute> it, Location location) {
        super(str, location);
        populateAttributes(it);
        this.elementPath = elementPath;
    }

    private void populateAttributes(Iterator<Attribute> it) {
        while (it.hasNext()) {
            if (this.attributes == null) {
                this.attributes = new ArrayList(2);
            }
            this.attributes.add(it.next());
        }
    }

    public Attribute getAttributeByName(String str) {
        List<Attribute> list = this.attributes;
        if (list == null) {
            return null;
        }
        for (Attribute attribute : list) {
            if (str.equals(attribute.getName().getLocalPart())) {
                return attribute;
            }
        }
        return null;
    }

    public List<Attribute> getAttributeList() {
        return this.attributes;
    }

    public ElementPath getElementPath() {
        return this.elementPath;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StartEvent(");
        sb.append(getName());
        sb.append(")  [");
        sb.append(this.location.getLineNumber());
        sb.append(",");
        return AbstractC0831a.d(sb, this.location.getColumnNumber(), "]");
    }
}
