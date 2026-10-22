package ch.qos.logback.core.db;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.util.PropertySetter;
import ch.qos.logback.core.util.OptionHelper;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.xml.sax.Attributes;

/* loaded from: classes.dex */
public class BindDataSourceToJNDIAction extends Action {
    static final String DATA_SOURCE_CLASS = "dataSourceClass";
    static final String PASSWORD = "password";
    static final String URL = "url";
    static final String USER = "user";

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        String property = interpretationContext.getProperty(DATA_SOURCE_CLASS);
        if (OptionHelper.isEmpty(property)) {
            addWarn("dsClassName is a required parameter");
            interpretationContext.addError("dsClassName is a required parameter");
            return;
        }
        String property2 = interpretationContext.getProperty("url");
        String property3 = interpretationContext.getProperty("user");
        String property4 = interpretationContext.getProperty(PASSWORD);
        try {
            DataSource dataSource = (DataSource) OptionHelper.instantiateByClassName(property, (Class<?>) DataSource.class, this.context);
            PropertySetter propertySetter = new PropertySetter(dataSource);
            propertySetter.setContext(this.context);
            if (!OptionHelper.isEmpty(property2)) {
                propertySetter.setProperty("url", property2);
            }
            if (!OptionHelper.isEmpty(property3)) {
                propertySetter.setProperty("user", property3);
            }
            if (!OptionHelper.isEmpty(property4)) {
                propertySetter.setProperty(PASSWORD, property4);
            }
            new InitialContext().rebind("dataSource", dataSource);
        } catch (Exception e4) {
            addError("Could not bind  datasource. Reported error follows.", e4);
            interpretationContext.addError("Could not not bind  datasource of type [" + property + "].");
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) {
    }
}
