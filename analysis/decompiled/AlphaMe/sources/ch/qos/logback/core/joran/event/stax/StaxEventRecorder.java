package ch.qos.logback.core.joran.event.stax;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/* loaded from: classes.dex */
public class StaxEventRecorder extends ContextAwareBase {
    List<StaxEvent> eventList = new ArrayList();
    ElementPath globalElementPath = new ElementPath();

    public StaxEventRecorder(Context context) {
        setContext(context);
    }

    private void addCharacters(XMLEvent xMLEvent) {
        Characters charactersAsCharacters = xMLEvent.asCharacters();
        StaxEvent lastEvent = getLastEvent();
        if (lastEvent instanceof BodyEvent) {
            ((BodyEvent) lastEvent).append(charactersAsCharacters.getData());
        } else {
            if (charactersAsCharacters.isWhiteSpace()) {
                return;
            }
            this.eventList.add(new BodyEvent(charactersAsCharacters.getData(), xMLEvent.getLocation()));
        }
    }

    private void addEndEvent(XMLEvent xMLEvent) {
        EndElement endElementAsEndElement = xMLEvent.asEndElement();
        this.eventList.add(new EndEvent(endElementAsEndElement.getName().getLocalPart(), endElementAsEndElement.getLocation()));
        this.globalElementPath.pop();
    }

    private void addStartElement(XMLEvent xMLEvent) {
        StartElement startElementAsStartElement = xMLEvent.asStartElement();
        String localPart = startElementAsStartElement.getName().getLocalPart();
        this.globalElementPath.push(localPart);
        this.eventList.add(new StartEvent(this.globalElementPath.duplicate(), localPart, startElementAsStartElement.getAttributes(), startElementAsStartElement.getLocation()));
    }

    private void read(XMLEventReader xMLEventReader) throws XMLStreamException {
        while (xMLEventReader.hasNext()) {
            XMLEvent xMLEventNextEvent = xMLEventReader.nextEvent();
            int eventType = xMLEventNextEvent.getEventType();
            if (eventType == 1) {
                addStartElement(xMLEventNextEvent);
            } else if (eventType == 2) {
                addEndEvent(xMLEventNextEvent);
            } else if (eventType == 4) {
                addCharacters(xMLEventNextEvent);
            }
        }
    }

    public List<StaxEvent> getEventList() {
        return this.eventList;
    }

    public StaxEvent getLastEvent() {
        int size;
        if (this.eventList.isEmpty() || (size = this.eventList.size()) == 0) {
            return null;
        }
        return this.eventList.get(size - 1);
    }

    public void recordEvents(InputStream inputStream) throws JoranException {
        try {
            read(XMLInputFactory.newInstance().createXMLEventReader(inputStream));
        } catch (XMLStreamException e4) {
            throw new JoranException("Problem parsing XML document. See previously reported errors.", e4);
        }
    }
}
