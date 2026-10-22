package ch.qos.logback.core;

import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.PropertyDefiner;

/* loaded from: classes.dex */
public abstract class PropertyDefinerBase extends ContextAwareBase implements PropertyDefiner {
    public static String booleanAsStr(boolean z4) {
        return (z4 ? Boolean.TRUE : Boolean.FALSE).toString();
    }
}
