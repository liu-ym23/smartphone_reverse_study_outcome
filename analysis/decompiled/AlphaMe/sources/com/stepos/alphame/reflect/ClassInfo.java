package com.stepos.alphame.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ClassInfo {
    Class<?> mClass;
    HashMap<String, Method> methods = new HashMap<>();
    HashMap<String, Field> fields = new HashMap<>();

    public ClassInfo(Class<?> cls, String str) {
        this.mClass = cls;
    }

    public void addCachedField(String str, Field field) {
        this.fields.put(str, field);
    }

    public void addCachedMethod(String str, Method method) {
        this.methods.put(str, method);
    }

    public Field getCachedField(String str) {
        return this.fields.get(str);
    }

    public Method getCachedMethod(String str) {
        return this.methods.get(str);
    }
}
