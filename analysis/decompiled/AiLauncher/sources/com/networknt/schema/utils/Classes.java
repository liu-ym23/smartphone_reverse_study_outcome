package com.networknt.schema.utils;

/* loaded from: classes2.dex */
public class Classes {
    public static boolean isPresent(String str, ClassLoader classLoader) throws ClassNotFoundException {
        try {
            Class.forName(str, false, classLoader);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
