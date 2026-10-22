package org.yaml.snakeyaml.util;

/* loaded from: classes5.dex */
public class PlatformFeatureDetector {
    private Boolean isRunningOnAndroid = null;

    public boolean isIntrospectionAvailable() throws ClassNotFoundException {
        if (isRunningOnAndroid()) {
            return false;
        }
        try {
            Class.forName("java.beans.Introspector");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public boolean isRunningOnAndroid() {
        if (this.isRunningOnAndroid == null) {
            String property = System.getProperty("java.runtime.name");
            this.isRunningOnAndroid = Boolean.valueOf(property != null && property.startsWith("Android Runtime"));
        }
        return this.isRunningOnAndroid.booleanValue();
    }
}
