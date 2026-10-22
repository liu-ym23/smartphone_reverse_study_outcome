package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.util.FieldInfo;
import com.obric.miniapp.alarm.AlarmSessionType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes28.dex */
public abstract class FieldDeserializer {
    protected BeanContext beanContext;
    protected final Class<?> clazz;
    public final FieldInfo fieldInfo;

    public int getFastMatchToken() {
        return 0;
    }

    public abstract void parseField(DefaultJSONParser r100, Object r101, Type r102, Map<String, Object> r103);

    public Class<?> getOwnerClass() {
        return this.clazz;
    }

    public FieldDeserializer(Class<?> r100, FieldInfo r101) {
        this.clazz = r100;
        this.fieldInfo = r101;
    }

    public void setValue(Object r100, Object r101) {
        if (r101 == null) goto L4;
    L6:
        FieldInfo r102 = this.fieldInfo;
        if (r102.fieldClass != String.class) goto L147;
        String r103 = r102.format;
        if (r103 == null) goto L147;
        if (r103.equals("trim") == false) goto L147;
        r101 = ((String) r101).trim();
    L147:
        FieldInfo r104 = this.fieldInfo;     // Catch: Exception -> L142
        Method r105 = r104.method;     // Catch: Exception -> L142
        if (r105 != null) goto L17;
        Field r106 = r104.field;     // Catch: Exception -> L142
        if (r104.getOnly == false) goto L139;
        Class<?> r107 = r104.fieldClass;     // Catch: Exception -> L142
        if (r107 != AtomicInteger.class) goto L107;
        AtomicInteger r108 = (AtomicInteger) r106.get(r100);     // Catch: Exception -> L142
        if (r108 == null) goto L174;
        r108.set(((AtomicInteger) r101).get());     // Catch: Exception -> L142
        return;
    L174:
        return;
    L107:
        if (r107 != AtomicLong.class) goto L112;
        AtomicLong r109 = (AtomicLong) r106.get(r100);     // Catch: Exception -> L142
        if (r109 == null) goto L176;
        r109.set(((AtomicLong) r101).get());     // Catch: Exception -> L142
        return;
    L176:
        return;
    L112:
        if (r107 != AtomicBoolean.class) goto L117;
        AtomicBoolean r110 = (AtomicBoolean) r106.get(r100);     // Catch: Exception -> L142
        if (r110 == null) goto L178;
        r110.set(((AtomicBoolean) r101).get());     // Catch: Exception -> L142
        return;
    L178:
        return;
    L117:
        if (Map.class.isAssignableFrom(r107) == false) goto L127;
        Map r111 = (Map) r106.get(r100);     // Catch: Exception -> L142
        if (r111 != null) goto L121;
        return;
    L121:
        if (r111 != Collections.emptyMap()) goto L123;
        return;
    L123:
        if (r111.getClass().getName().startsWith("java.util.Collections$Unmodifiable") == true) goto L157;
        r111.putAll((Map) r101);     // Catch: Exception -> L142
        return;
    L157:
        return;
    L127:
        Collection r112 = (Collection) r106.get(r100);     // Catch: Exception -> L142
        if (r112 == null) goto L182;
        if (r101 != null) goto L131;
        return;
    L131:
        if (r112 != Collections.emptySet()) goto L133;
        return;
    L133:
        if (r112 != Collections.emptyList()) goto L135;
        return;
    L135:
        if (r112.getClass().getName().startsWith("java.util.Collections$Unmodifiable") == true) goto L159;
        r112.clear();     // Catch: Exception -> L142
        r112.addAll((Collection) r101);     // Catch: Exception -> L142
        return;
    L159:
        return;
    L182:
        return;
    L139:
        if (r106 == null) goto L185;
        r106.set(r100, r101);     // Catch: Exception -> L142
        return;
    L185:
        return;
    L17:
        if (r104.getOnly == false) goto L98;
        Class<?> r113 = r104.fieldClass;     // Catch: Exception -> L142
        if (r113 != AtomicInteger.class) goto L25;
        AtomicInteger r114 = (AtomicInteger) r105.invoke(r100, new Object[0]);     // Catch: Exception -> L142
        if (r114 == null) goto L23;
        r114.set(((AtomicInteger) r101).get());     // Catch: Exception -> L142
        return;
    L23:
        degradeValueAssignment(this.fieldInfo.field, r105, r100, r101);     // Catch: Exception -> L142
        return;
    L25:
        if (r113 != AtomicLong.class) goto L31;
        AtomicLong r115 = (AtomicLong) r105.invoke(r100, new Object[0]);     // Catch: Exception -> L142
        if (r115 == null) goto L29;
        r115.set(((AtomicLong) r101).get());     // Catch: Exception -> L142
        return;
    L29:
        degradeValueAssignment(this.fieldInfo.field, r105, r100, r101);     // Catch: Exception -> L142
        return;
    L31:
        if (r113 != AtomicBoolean.class) goto L37;
        AtomicBoolean r116 = (AtomicBoolean) r105.invoke(r100, new Object[0]);     // Catch: Exception -> L142
        if (r116 == null) goto L35;
        r116.set(((AtomicBoolean) r101).get());     // Catch: Exception -> L142
        return;
    L35:
        degradeValueAssignment(this.fieldInfo.field, r105, r100, r101);     // Catch: Exception -> L142
        return;
    L37:
        if (Map.class.isAssignableFrom(r105.getReturnType()) == false) goto L148;
        Map r117 = (Map) r105.invoke(r100, new Object[0]);     // Catch: InvocationTargetException -> L63 Exception -> L142
        if (r117 != null) goto L41;
        if (r101 == null) goto L167;
        degradeValueAssignment(this.fieldInfo.field, r105, r100, r101);     // Catch: Exception -> L142
        return;
    L167:
        return;
    L41:
        if (r117 != Collections.emptyMap()) goto L44;
        return;
    L44:
        if (r117.isEmpty() == true) goto L46;
    L48:
        String r118 = r117.getClass().getName();     // Catch: Exception -> L142
        if (r118.equals("java.util.ImmutableCollections$Map1") == false) goto L51;
        return;
    L51:
        if (r118.equals("java.util.ImmutableCollections$MapN") == false) goto L53;
        return;
    L53:
        if (r118.startsWith("java.util.Collections$Unmodifiable") == false) goto L56;
        return;
    L56:
        if (r117.getClass().getName().equals("kotlin.collections.EmptyMap") == false) goto L59;
        degradeValueAssignment(this.fieldInfo.field, r105, r100, r101);     // Catch: Exception -> L142
        return;
    L59:
        r117.putAll((Map) r101);     // Catch: Exception -> L142
        return;
    L46:
        if (((Map) r101).isEmpty() == false) goto L48;
        return;
    L63:
        degradeValueAssignment(this.fieldInfo.field, r105, r100, r101);     // Catch: Exception -> L142
        return;
    L148:
        Collection r119 = (Collection) r105.invoke(r100, new Object[0]);     // Catch: InvocationTargetException -> L96 Exception -> L142
        if (r119 == null) goto L93;
        if (r101 == null) goto L93;
        String r120 = r119.getClass().getName();     // Catch: Exception -> L142
        if (r119 != Collections.emptySet()) goto L71;
        return;
    L71:
        if (r119 != Collections.emptyList()) goto L73;
        return;
    L73:
        if (r120 != "java.util.ImmutableCollections$ListN") goto L75;
        return;
    L75:
        if (r120 != "java.util.ImmutableCollections$List12") goto L77;
        return;
    L77:
        if (r120.startsWith("java.util.Collections$Unmodifiable") == false) goto L80;
        return;
    L80:
        if (r119.isEmpty() == true) goto L83;
        r119.clear();     // Catch: Exception -> L142
    L86:
        if (r120.equals("kotlin.collections.EmptyList") == false) goto L88;
    L91:
        degradeValueAssignment(this.fieldInfo.field, r105, r100, r101);     // Catch: Exception -> L142
        return;
    L88:
        if (r120.equals("kotlin.collections.EmptySet") == true) goto L91;
        r119.addAll((Collection) r101);     // Catch: Exception -> L142
        return;
    L83:
        if (((Collection) r101).isEmpty() == false) goto L86;
        return;
    L93:
        if (r119 != null) goto L170;
        if (r101 == null) goto L171;
        degradeValueAssignment(this.fieldInfo.field, r105, r100, r101);     // Catch: Exception -> L142
        return;
    L171:
        return;
    L170:
        return;
    L96:
        degradeValueAssignment(this.fieldInfo.field, r105, r100, r101);     // Catch: Exception -> L142
        return;
    L98:
        r105.invoke(r100, new Object[]{r101});     // Catch: Exception -> L142
        return;
    L142:
        e = move-exception;
        throw new JSONException("set property error, " + this.clazz.getName() + "#" + this.fieldInfo.name, e);
    L4:
        if (this.fieldInfo.fieldClass.isPrimitive() == false) goto L6;
    }

    public void setWrappedValue(String r100, Object r101) {
        throw new JSONException(AlarmSessionType.TODO);
    }

    public void setValue(Object r100, int r101) {
        setValue(r100, Integer.valueOf(r101));
    }

    public void setValue(Object r100, long r101) {
        setValue(r100, Long.valueOf(r101));
    }

    public void setValue(Object r100, boolean r101) {
        setValue(r100, Boolean.valueOf(r101));
    }

    public void setValue(Object r100, String r101) {
        setValue(r100, r101);
    }

    private static boolean setFieldValue(Field r100, Object r101, Object r102) throws IllegalAccessException {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (Modifier.isFinal(r100.getModifiers()) == true) goto L9;
        r100.set(r101, r102);
        return true;
    L9:
        return false;
    }

    private static boolean degradeValueAssignment(Field r100, Method r101, Object r102, Object r103) throws InvocationTargetException, IllegalAccessException {
        if (setFieldValue(r100, r102, r103) == false) goto L9;
        return true;
    L9:
        r102.getClass().getDeclaredMethod("set" + r101.getName().substring(3), new Class[]{r101.getReturnType()}).invoke(r102, new Object[]{r103});     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    }
}
