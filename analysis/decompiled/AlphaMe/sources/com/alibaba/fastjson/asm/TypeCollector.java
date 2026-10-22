package com.alibaba.fastjson.asm;

import B0.g;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.AbstractC0351g;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TypeCollector {
    private static final Map<String, String> primitives = new HashMap<String, String>() { // from class: com.alibaba.fastjson.asm.TypeCollector.1
        {
            put("int", "I");
            put("boolean", "Z");
            put("byte", "B");
            put("char", "C");
            put("short", ExifInterface.LATITUDE_SOUTH);
            put("float", "F");
            put("long", "J");
            put("double", "D");
        }
    };
    protected MethodCollector collector = null;
    private final String methodName;
    private final Class<?>[] parameterTypes;

    public TypeCollector(String str, Class<?>[] clsArr) {
        this.methodName = str;
        this.parameterTypes = clsArr;
    }

    private boolean correctTypeName(Type type, String str) {
        String className = type.getClassName();
        String strP = "";
        while (className.endsWith("[]")) {
            strP = AbstractC0351g.p(strP, "[");
            className = className.substring(0, className.length() - 2);
        }
        if (!strP.equals("")) {
            Map<String, String> map = primitives;
            if (map.containsKey(className)) {
                StringBuilder sbS = g.s(strP);
                sbS.append(map.get(className));
                className = sbS.toString();
            } else {
                className = strP + "L" + className + ";";
            }
        }
        return className.equals(str);
    }

    public String[] getParameterNamesForMethod() {
        MethodCollector methodCollector = this.collector;
        return (methodCollector == null || !methodCollector.debugInfoPresent) ? new String[0] : methodCollector.getResult().split(",");
    }

    public MethodCollector visitMethod(int i4, String str, String str2) {
        if (this.collector != null || !str.equals(this.methodName)) {
            return null;
        }
        Type[] argumentTypes = Type.getArgumentTypes(str2);
        int i5 = 0;
        for (Type type : argumentTypes) {
            String className = type.getClassName();
            if (className.equals("long") || className.equals("double")) {
                i5++;
            }
        }
        if (argumentTypes.length != this.parameterTypes.length) {
            return null;
        }
        for (int i6 = 0; i6 < argumentTypes.length; i6++) {
            if (!correctTypeName(argumentTypes[i6], this.parameterTypes[i6].getName())) {
                return null;
            }
        }
        MethodCollector methodCollector = new MethodCollector(!Modifier.isStatic(i4) ? 1 : 0, argumentTypes.length + i5);
        this.collector = methodCollector;
        return methodCollector;
    }
}
