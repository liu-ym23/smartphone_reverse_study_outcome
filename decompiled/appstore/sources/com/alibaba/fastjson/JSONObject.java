package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class JSONObject extends JSON implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {
    private final Map<String, Object> map;

    public JSONObject() {
        this(16, false);
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        return new JSONObject(new LinkedHashMap(this.map));
    }

    @Override // java.util.Map
    public boolean containsKey(Object r10) {
        return this.map.containsKey(r10);
    }

    @Override // java.util.Map
    public boolean containsValue(Object r10) {
        return this.map.containsValue(r10);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object r10) {
        return this.map.equals(r10);
    }

    @Override // java.util.Map
    public Object get(Object r10) {
        return this.map.get(r10);
    }

    public BigDecimal getBigDecimal(String r10) {
        return TypeUtils.castToBigDecimal(get(r10));
    }

    public BigInteger getBigInteger(String r10) {
        return TypeUtils.castToBigInteger(get(r10));
    }

    public Boolean getBoolean(String r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return TypeUtils.castToBoolean(r11);
    }

    public boolean getBooleanValue(String r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return TypeUtils.castToBoolean(r11).booleanValue();
    }

    public Byte getByte(String r10) {
        return TypeUtils.castToByte(get(r10));
    }

    public byte getByteValue(String r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return TypeUtils.castToByte(r11).byteValue();
    }

    public byte[] getBytes(String r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return TypeUtils.castToBytes(r11);
    }

    public Date getDate(String r10) {
        return TypeUtils.castToDate(get(r10));
    }

    public Double getDouble(String r10) {
        return TypeUtils.castToDouble(get(r10));
    }

    public double getDoubleValue(String r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return 0.0d;
    L7:
        return TypeUtils.castToDouble(r11).doubleValue();
    }

    public Float getFloat(String r10) {
        return TypeUtils.castToFloat(get(r10));
    }

    public float getFloatValue(String r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return 0.0f;
    L7:
        return TypeUtils.castToFloat(r11).floatValue();
    }

    public Map<String, Object> getInnerMap() {
        return this.map;
    }

    public int getIntValue(String r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return TypeUtils.castToInt(r11).intValue();
    }

    public Integer getInteger(String r10) {
        return TypeUtils.castToInt(get(r10));
    }

    public JSONArray getJSONArray(String r10) {
        Object r11 = this.map.get(r10);
        if ((r11 instanceof JSONArray) == false) goto L7;
        return (JSONArray) r11;
    L7:
        if ((r11 instanceof String) == false) goto L11;
        return (JSONArray) JSON.parse((String) r11);
    L11:
        return (JSONArray) JSON.toJSON(r11);
    }

    public JSONObject getJSONObject(String r10) {
        Object r11 = this.map.get(r10);
        if ((r11 instanceof JSONObject) == false) goto L7;
        return (JSONObject) r11;
    L7:
        if ((r11 instanceof String) == false) goto L11;
        return JSON.parseObject((String) r11);
    L11:
        return (JSONObject) JSON.toJSON(r11);
    }

    public Long getLong(String r10) {
        return TypeUtils.castToLong(get(r10));
    }

    public long getLongValue(String r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return TypeUtils.castToLong(r11).longValue();
    }

    public <T> T getObject(String r10, Class<T> r11) {
        return (T) TypeUtils.castToJavaBean(this.map.get(r10), r11);
    }

    public Short getShort(String r10) {
        return TypeUtils.castToShort(get(r10));
    }

    public short getShortValue(String r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return TypeUtils.castToShort(r11).shortValue();
    }

    public String getString(String r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.toString();
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r10, Method r11, Object[] r12) throws Throwable {
        Class<?>[] r13 = r11.getParameterTypes();
        String r14 = null;
        if (r13.length != 1) goto L31;
        if (r11.getName().equals("equals") == false) goto L9;
        return Boolean.valueOf(equals(r12[0]));
    L9:
        if (r11.getReturnType() != Void.TYPE) goto L29;
        JSONField r15 = (JSONField) r11.getAnnotation(JSONField.class);
        if (r15 != null) goto L13;
    L15:
        String r16 = null;
    L16:
        if (r16 != null) goto L26;
        String r17 = r11.getName();
        if (r17.startsWith("set") == false) goto L25;
        String r18 = r17.substring(3);
        if (r18.length() == 0) goto L23;
        r16 = Character.toLowerCase(r18.charAt(0)) + r18.substring(1);
        goto L26
    L23:
        throw new JSONException("illegal setter");
    L25:
        throw new JSONException("illegal setter");
    L26:
        this.map.put(r16, r12[0]);
        return null;
    L13:
        if (r15.name().length() == 0) goto L15;
        r16 = r15.name();
        goto L16
    L29:
        throw new JSONException("illegal setter");
    L31:
        if (r13.length != 0) goto L69;
        if (r11.getReturnType() == Void.TYPE) goto L67;
        JSONField r19 = (JSONField) r11.getAnnotation(JSONField.class);
        if (r19 != null) goto L37;
    L39:
        if (r14 != null) goto L65;
        String r20 = r11.getName();
        if (r20.startsWith("get") == false) goto L48;
        String r21 = r20.substring(3);
        if (r21.length() == 0) goto L46;
        r14 = Character.toLowerCase(r21.charAt(0)) + r21.substring(1);
        goto L65
    L46:
        throw new JSONException("illegal getter");
    L48:
        if (r20.startsWith("is") == false) goto L55;
        String r22 = r20.substring(2);
        if (r22.length() == 0) goto L53;
        r14 = Character.toLowerCase(r22.charAt(0)) + r22.substring(1);
        goto L65
    L53:
        throw new JSONException("illegal getter");
    L55:
        if (r20.startsWith("hashCode") == false) goto L59;
        return Integer.valueOf(hashCode());
    L59:
        if (r20.startsWith("toString") == false) goto L63;
        return toString();
    L63:
        throw new JSONException("illegal getter");
    L65:
        return TypeUtils.cast(this.map.get(r14), r11.getGenericReturnType(), ParserConfig.global);
    L37:
        if (r19.name().length() == 0) goto L39;
        r14 = r19.name();
        goto L39
    L67:
        throw new JSONException("illegal getter");
    L69:
        throw new UnsupportedOperationException(r11.toGenericString());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(String r10, Object r11) {
        return put2(r10, r11);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> r10) {
        this.map.putAll(r10);
    }

    @Override // java.util.Map
    public Object remove(Object r10) {
        return this.map.remove(r10);
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.map.values();
    }

    public JSONObject(Map<String, Object> r10) {
        this.map = r10;
    }

    /* JADX INFO: renamed from: put, reason: avoid collision after fix types in other method */
    public Object put2(String r10, Object r11) {
        return this.map.put(r10, r11);
    }

    public JSONObject(boolean r10) {
        this(16, r10);
    }

    public JSONObject(int r10) {
        this(r10, false);
    }

    public JSONObject(int r10, boolean r11) {
        if (r11 == false) goto L5;
        this.map = new LinkedHashMap(r10);
        return;
    L5:
        this.map = new HashMap(r10);
    }
}
