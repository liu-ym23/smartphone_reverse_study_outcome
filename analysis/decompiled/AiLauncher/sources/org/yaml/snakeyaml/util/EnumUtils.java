package org.yaml.snakeyaml.util;

/* loaded from: classes5.dex */
public class EnumUtils {
    public static <T extends Enum<T>> T findEnumInsensitiveCase(Class<T> cls, String str) {
        for (T t10 : cls.getEnumConstants()) {
            if (t10.name().compareToIgnoreCase(str) == 0) {
                return t10;
            }
        }
        throw new IllegalArgumentException("No enum constant " + cls.getCanonicalName() + "." + str);
    }
}
