package ch.qos.logback.core.joran.spi;

import ch.qos.logback.core.joran.event.BodyEvent;
import ch.qos.logback.core.joran.event.EndEvent;
import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.joran.event.StartEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class EventPlayer {
    int currentIndex;
    List<SaxEvent> eventList;
    final Interpreter interpreter;

    public EventPlayer(Interpreter interpreter) {
        this.interpreter = interpreter;
    }

    public void addEventsDynamically(List<SaxEvent> list, int i4) {
        this.eventList.addAll(this.currentIndex + i4, list);
    }

    public List<SaxEvent> getCopyOfPlayerEventList() {
        return new ArrayList(this.eventList);
    }

    public void play(List<SaxEvent> list) {
        this.eventList = list;
        int i4 = 0;
        while (true) {
            this.currentIndex = i4;
            if (this.currentIndex >= this.eventList.size()) {
                return;
            }
            SaxEvent saxEvent = this.eventList.get(this.currentIndex);
            if (saxEvent instanceof StartEvent) {
                this.interpreter.startElement((StartEvent) saxEvent);
                this.interpreter.getInterpretationContext().fireInPlay(saxEvent);
            }
            if (saxEvent instanceof BodyEvent) {
                this.interpreter.getInterpretationContext().fireInPlay(saxEvent);
                this.interpreter.characters((BodyEvent) saxEvent);
            }
            if (saxEvent instanceof EndEvent) {
                this.interpreter.getInterpretationContext().fireInPlay(saxEvent);
                this.interpreter.endElement((EndEvent) saxEvent);
            }
            i4 = this.currentIndex + 1;
        }
    }
}
