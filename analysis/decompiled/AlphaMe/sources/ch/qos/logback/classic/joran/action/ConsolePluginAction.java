package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.net.SocketAppender;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import org.xml.sax.Attributes;

/* loaded from: classes.dex */
public class ConsolePluginAction extends Action {
    private static final Integer DEFAULT_PORT = 4321;
    private static final String PORT_ATTR = "port";

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) throws ActionException, NumberFormatException {
        Integer numValueOf;
        String value = attributes.getValue(PORT_ATTR);
        if (value == null) {
            numValueOf = DEFAULT_PORT;
        } else {
            try {
                numValueOf = Integer.valueOf(value);
            } catch (NumberFormatException unused) {
                addError("Port " + value + " in ConsolePlugin config is not a correct number");
                numValueOf = null;
            }
        }
        LoggerContext loggerContext = (LoggerContext) interpretationContext.getContext();
        SocketAppender socketAppender = new SocketAppender();
        socketAppender.setContext(loggerContext);
        socketAppender.setIncludeCallerData(true);
        socketAppender.setRemoteHost("localhost");
        socketAppender.setPort(numValueOf.intValue());
        socketAppender.start();
        loggerContext.getLogger("ROOT").addAppender(socketAppender);
        addInfo("Sending LoggingEvents to the plugin using port " + numValueOf);
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) throws ActionException {
    }
}
