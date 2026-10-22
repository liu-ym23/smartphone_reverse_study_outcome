package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class FieldDeserializer {
    public final Class<?> clazz;
    protected long[] enumNameHashCodes;
    protected Enum[] enums;
    public final FieldInfo fieldInfo;

    public FieldDeserializer(Class<?> r10, FieldInfo r11, int r12) {
        this.clazz = r10;
        this.fieldInfo = r11;
        if (r11 != null) goto L5;
        return;
    L5:
        Class<?> r13 = r11.fieldClass;
        if (r13.isEnum() == false) goto L25;
        Enum[] r14 = (Enum[]) r13.getEnumConstants();
        int r15 = r14.length;
        long[] r16 = new long[r15];
        this.enumNameHashCodes = new long[r14.length];
        int r17 = 0;
    L9:
        if (r17 >= r14.length) goto L15;
        String r18 = r14[r17].name();
        long r19 = -2128831035;
        int r20 = 0;
    L12:
        if (r20 >= r18.length()) goto L14;
        r19 = (r19 ^ ((long) r18.charAt(r20))) * 16777619;
        r20 = r20 + 1;
        goto L12
    L14:
        r16[r17] = r19;
        this.enumNameHashCodes[r17] = r19;
        r17 = r17 + 1;
        goto L9
    L15:
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[r14.length];
        int r21 = 0;
    L17:
        if (r21 >= this.enumNameHashCodes.length) goto L32;
        int r22 = 0;
    L19:
        if (r22 >= r15) goto L24;
        if (this.enumNameHashCodes[r21] == r16[r22]) goto L22;
        r22 = r22 + 1;
        goto L19
    L22:
        this.enums[r21] = r14[r22];
    L24:
        r21 = r21 + 1;
        goto L17
    L32:
        return;
    }

    public Enum getEnumByHashCode(long r10) {
        if (this.enums != null) goto L5;
        return null;
    L5:
        int r11 = Arrays.binarySearch(this.enumNameHashCodes, r10);
        if (r11 != (-1)) goto L9;
        return null;
    L9:
        return this.enums[r11];
    }

    public abstract void parseField(DefaultJSONParser r10, Object r11, Type r12, Map<String, Object> r13);

    public void setValue(Object r10, int r11) throws IllegalAccessException {
        this.fieldInfo.field.setInt(r10, r11);
    }

    public void setValue(Object r10, long r11) throws IllegalAccessException {
        this.fieldInfo.field.setLong(r10, r11);
    }

    public void setValue(Object r10, float r11) throws IllegalAccessException {
        this.fieldInfo.field.setFloat(r10, r11);
    }

    public void setValue(Object r10, double r11) throws IllegalAccessException {
        this.fieldInfo.field.setDouble(r10, r11);
    }

    public void setValue(Object r10, Object r11) {
        if (r11 == null) goto L4;
    L6:
        FieldInfo r12 = this.fieldInfo;
        Field r13 = r12.field;
        Method r14 = r12.method;
    L17:
        e = move-exception;
        throw new JSONException("set property error, " + this.fieldInfo.name, e);
    L9:
        if (r12.fieldAccess == false) goto L24;
        if (r12.getOnly == true) goto L13;
        r13.set(r10, r11);     // Catch: Exception -> L17
        return;
    L13:
        if (Map.class.isAssignableFrom(r12.fieldClass) == false) goto L19;
        Map r15 = (Map) r13.get(r10);     // Catch: Exception -> L17
        if (r15 == null) goto L38;
        r15.putAll((Map) r11);     // Catch: Exception -> L17
        return;
    L38:
        return;
    L19:
        Collection r16 = (Collection) r13.get(r10);     // Catch: Exception -> L17
        if (r16 == null) goto L40;
        r16.addAll((Collection) r11);     // Catch: Exception -> L17
        return;
    L40:
        return;
    L24:
        if (r12.getOnly == true) goto L26;
        r14.invoke(r10, new Object[]{r11});     // Catch: Exception -> L17
        return;
    L26:
        if (Map.class.isAssignableFrom(r12.fieldClass) == false) goto L30;
        Map r17 = (Map) r14.invoke(r10, null);     // Catch: Exception -> L17
        if (r17 == null) goto L43;
        r17.putAll((Map) r11);     // Catch: Exception -> L17
        return;
    L43:
        return;
    L30:
        Collection r18 = (Collection) r14.invoke(r10, null);     // Catch: Exception -> L17
        if (r18 == null) goto L45;
        r18.addAll((Collection) r11);     // Catch: Exception -> L17
        return;
    L45:
        return;
    L4:
        if (this.fieldInfo.fieldClass.isPrimitive() == false) goto L6;
    }
}
