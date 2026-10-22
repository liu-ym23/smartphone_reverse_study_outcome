package com.stepos.alphame.reflect;

import androidx.room.AbstractC0351g;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class Utils {
    private static final String TAG = "Utils";

    public static int getStaticVariableInt(String str, String str2) throws NoSuchFieldException, ClassNotFoundException, SecurityException {
        try {
            Class<?> cls = Class.forName(str);
            Field declaredField = cls.getDeclaredField(str2);
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get(cls)).intValue();
        } catch (Exception e4) {
            AbstractC0351g.B("getStaticVariableInt exception: ", e4, TAG);
            return -1;
        }
    }
}
