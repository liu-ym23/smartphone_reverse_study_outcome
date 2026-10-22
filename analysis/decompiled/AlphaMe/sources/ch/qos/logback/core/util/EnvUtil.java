package ch.qos.logback.core.util;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class EnvUtil {
    public static boolean isJDK5() {
        return isJDK_N_OrHigher(5);
    }

    public static boolean isJDK6OrHigher() {
        return isJDK_N_OrHigher(6);
    }

    public static boolean isJDK7OrHigher() {
        return isJDK_N_OrHigher(7);
    }

    private static boolean isJDK_N_OrHigher(int i4) {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < 5; i5++) {
            arrayList.add("1." + (i4 + i5));
        }
        String property = System.getProperty("java.version");
        if (property == null) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (property.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isJaninoAvailable() {
        try {
            return EnvUtil.class.getClassLoader().loadClass("org.codehaus.janino.ScriptEvaluator") != null;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").startsWith("Windows");
    }
}
