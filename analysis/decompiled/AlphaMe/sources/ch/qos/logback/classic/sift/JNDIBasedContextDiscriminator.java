package ch.qos.logback.classic.sift;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.selector.ContextSelector;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
import ch.qos.logback.core.sift.AbstractDiscriminator;

/* loaded from: classes.dex */
public class JNDIBasedContextDiscriminator extends AbstractDiscriminator<ILoggingEvent> {
    private static final String KEY = "contextName";
    private String defaultValue;

    public String getDefaultValue() {
        return this.defaultValue;
    }

    @Override // ch.qos.logback.core.sift.Discriminator
    public String getKey() {
        return KEY;
    }

    public void setDefaultValue(String str) {
        this.defaultValue = str;
    }

    public void setKey(String str) {
        throw new UnsupportedOperationException("Key cannot be set. Using fixed key contextName");
    }

    @Override // ch.qos.logback.core.sift.Discriminator
    public String getDiscriminatingValue(ILoggingEvent iLoggingEvent) {
        ContextSelector contextSelector = ContextSelectorStaticBinder.getSingleton().getContextSelector();
        if (contextSelector == null) {
            return this.defaultValue;
        }
        LoggerContext loggerContext = contextSelector.getLoggerContext();
        return loggerContext == null ? this.defaultValue : loggerContext.getName();
    }
}
