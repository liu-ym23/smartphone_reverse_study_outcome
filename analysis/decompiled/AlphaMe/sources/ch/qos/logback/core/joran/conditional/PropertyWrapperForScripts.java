package ch.qos.logback.core.joran.conditional;

import ch.qos.logback.core.spi.PropertyContainer;
import ch.qos.logback.core.util.OptionHelper;

/* loaded from: classes.dex */
public class PropertyWrapperForScripts {
    PropertyContainer context;
    PropertyContainer local;

    public boolean isDefined(String str) {
        return OptionHelper.propertyLookup(str, this.local, this.context) != null;
    }

    public boolean isNull(String str) {
        return OptionHelper.propertyLookup(str, this.local, this.context) == null;
    }

    public String p(String str) {
        return property(str);
    }

    public String property(String str) {
        String strPropertyLookup = OptionHelper.propertyLookup(str, this.local, this.context);
        return strPropertyLookup != null ? strPropertyLookup : "";
    }

    public void setPropertyContainers(PropertyContainer propertyContainer, PropertyContainer propertyContainer2) {
        this.local = propertyContainer;
        this.context = propertyContainer2;
    }
}
