package ch.qos.logback.core.joran.conditional;

import ch.qos.logback.core.joran.event.SaxEvent;
import java.util.List;

/* loaded from: classes.dex */
public class ThenAction extends ThenOrElseActionBase {
    @Override // ch.qos.logback.core.joran.conditional.ThenOrElseActionBase
    public void registerEventList(IfAction ifAction, List<SaxEvent> list) {
        ifAction.setThenSaxEventList(list);
    }
}
