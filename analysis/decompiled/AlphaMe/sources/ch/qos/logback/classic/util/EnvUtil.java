package ch.qos.logback.classic.util;

import ch.qos.logback.core.util.Loader;

/* loaded from: classes.dex */
public class EnvUtil {
    public static boolean isGroovyAvailable() {
        try {
            return Loader.getClassLoaderOfClass(EnvUtil.class).loadClass("groovy.lang.Binding") != null;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
