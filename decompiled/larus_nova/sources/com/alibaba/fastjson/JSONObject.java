package com.alibaba.fastjson;

import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class JSONObject extends JSON implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final long serialVersionUID = 1;
    private final Map<String, Object> map;

    public JSONObject() {
        this(16, false);
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    public JSONObject clone() {
        if ((this.map instanceof LinkedHashMap) == false) goto L5;
        Map r100 = new LinkedHashMap(this.map);
    L7:
        return new JSONObject(r100);
    L5:
        r100 = new HashMap(this.map);
        goto L7
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    public JSONObject fluentClear() {
        this.map.clear();
        return this;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
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
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.map.values();
    }

    public Map<String, Object> getInnerMap() {
        return this.map;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8013clone() throws CloneNotSupportedException {
        return clone();
    }

    public JSONObject(Map<String, Object> r100) {
        if (r100 == null) goto L7;
        this.map = r100;
        return;
    L7:
        throw new IllegalArgumentException("map is null.");
    }

    @Override // java.util.Map
    public boolean containsKey(Object r100) {
        boolean r101 = this.map.containsKey(r100);
        if (r101 == false) goto L5;
        return r101;
    L5:
        if ((r100 instanceof Number) == true) goto L13;
        if ((r100 instanceof Character) == true) goto L13;
        if ((r100 instanceof Boolean) == true) goto L13;
        if ((r100 instanceof UUID) == true) goto L13;
        return r101;
    L13:
        return this.map.containsKey(r100.toString());
    }

    @Override // java.util.Map
    public boolean containsValue(Object r100) {
        return this.map.containsValue(r100);
    }

    @Override // java.util.Map
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof JSONObject) == false) goto L10;
        return this.map.equals(((JSONObject) r100).map);
    L10:
        return this.map.equals(r100);
    }

    public JSONObject fluentPutAll(Map<? extends String, ?> r100) {
        this.map.putAll(r100);
        return this;
    }

    public JSONObject fluentRemove(Object r100) {
        this.map.remove(r100);
        return this;
    }

    @Override // java.util.Map
    public Object get(Object r100) {
        Object r101 = this.map.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        if ((r100 instanceof Number) == true) goto L13;
        if ((r100 instanceof Character) == true) goto L13;
        if ((r100 instanceof Boolean) == true) goto L13;
        if ((r100 instanceof UUID) == true) goto L13;
        return r101;
    L13:
        return this.map.get(r100.toString());
    }

    public BigDecimal getBigDecimal(String r100) {
        return TypeUtils.castToBigDecimal(get(r100));
    }

    public BigInteger getBigInteger(String r100) {
        return TypeUtils.castToBigInteger(get(r100));
    }

    public Boolean getBoolean(String r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return TypeUtils.castToBoolean(r101);
    }

    public boolean getBooleanValue(String r100) {
        Boolean r101 = TypeUtils.castToBoolean(get(r100));
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.booleanValue();
    }

    public Byte getByte(String r100) {
        return TypeUtils.castToByte(get(r100));
    }

    public byte getByteValue(String r100) {
        Byte r101 = TypeUtils.castToByte(get(r100));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.byteValue();
    }

    public byte[] getBytes(String r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return TypeUtils.castToBytes(r101);
    }

    public Date getDate(String r100) {
        return TypeUtils.castToDate(get(r100));
    }

    public Double getDouble(String r100) {
        return TypeUtils.castToDouble(get(r100));
    }

    public double getDoubleValue(String r100) {
        Double r101 = TypeUtils.castToDouble(get(r100));
        if (r101 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r101.doubleValue();
    }

    public Float getFloat(String r100) {
        return TypeUtils.castToFloat(get(r100));
    }

    public float getFloatValue(String r100) {
        Float r101 = TypeUtils.castToFloat(get(r100));
        if (r101 != null) goto L7;
        return 0.0f;
    L7:
        return r101.floatValue();
    }

    public int getIntValue(String r100) {
        Integer r101 = TypeUtils.castToInt(get(r100));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.intValue();
    }

    public Integer getInteger(String r100) {
        return TypeUtils.castToInt(get(r100));
    }

    public JSONArray getJSONArray(String r100) {
        Object r101 = this.map.get(r100);
        if ((r101 instanceof JSONArray) == false) goto L7;
        return (JSONArray) r101;
    L7:
        if ((r101 instanceof List) == false) goto L11;
        return new JSONArray((List) r101);
    L11:
        if ((r101 instanceof String) == false) goto L15;
        return (JSONArray) JSON.parse((String) r101);
    L15:
        return (JSONArray) JSON.toJSON(r101);
    }

    public JSONObject getJSONObject(String r100) {
        Object r101 = this.map.get(r100);
        if ((r101 instanceof JSONObject) == false) goto L7;
        return (JSONObject) r101;
    L7:
        if ((r101 instanceof Map) == false) goto L11;
        return new JSONObject((Map) r101);
    L11:
        if ((r101 instanceof String) == false) goto L15;
        return JSON.parseObject((String) r101);
    L15:
        return (JSONObject) JSON.toJSON(r101);
    }

    public Long getLong(String r100) {
        return TypeUtils.castToLong(get(r100));
    }

    public long getLongValue(String r100) {
        Long r101 = TypeUtils.castToLong(get(r100));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.longValue();
    }

    public Short getShort(String r100) {
        return TypeUtils.castToShort(get(r100));
    }

    public short getShortValue(String r100) {
        Short r101 = TypeUtils.castToShort(get(r100));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.shortValue();
    }

    public Object getSqlDate(String r100) {
        return TypeUtils.castToSqlDate(get(r100));
    }

    public String getString(String r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.toString();
    }

    public Object getTimestamp(String r100) {
        return TypeUtils.castToTimestamp(get(r100));
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> r100) {
        this.map.putAll(r100);
    }

    @Override // java.util.Map
    public Object remove(Object r100) {
        return this.map.remove(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.JSON
    public <T> T toJavaObject(Class<T> r100) {
        if (r100 != Map.class) goto L5;
    L16:
        return this;
    L5:
        if (r100 == JSONObject.class) goto L16;
        if (r100 == JSON.class) goto L16;
        if (r100 != Object.class) goto L15;
        if (containsKey(JSON.DEFAULT_TYPE_KEY) == true) goto L15;
        return this;
    L15:
        return (T) TypeUtils.castToJavaBean(this, r100, ParserConfig.getGlobalInstance());
    }

    public JSONObject(boolean r100) {
        this(16, r100);
    }

    public JSONObject(int r100) {
        this(r100, false);
    }

    public JSONObject(int r100, boolean r101) {
        if (r101 == false) goto L5;
        this.map = new LinkedHashMap(r100);
        return;
    L5:
        this.map = new HashMap(r100);
    }

    public JSONObject fluentPut(String r100, Object r101) {
        this.map.put(r100, r101);
        return this;
    }

    public <T> T getObject(String r100, TypeReference r101) {
        T r102 = (T) this.map.get(r100);
        if (r101 != null) goto L6;
        return r102;
    L6:
        return (T) TypeUtils.cast(r102, r101.getType(), ParserConfig.getGlobalInstance());
    }

    @Override // java.util.Map
    public Object getOrDefault(Object r100, Object r101) {
        Object r102 = get(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102;
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(String r100, Object r101) {
        return put2(r100, r101);
    }

    public <T> T getObject(String r100, Type r101) {
        return (T) TypeUtils.cast(this.map.get(r100), r101, ParserConfig.getGlobalInstance());
    }

    /* JADX INFO: renamed from: put, reason: avoid collision after fix types in other method */
    public Object put2(String r100, Object r101) {
        return this.map.put(r100, r101);
    }

    public <T> T getObject(String r100, Class<T> r101) {
        return (T) TypeUtils.castToJavaBean(this.map.get(r100), r101);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
        Class<?>[] r103 = r101.getParameterTypes();
        String r104 = null;
        if (r103.length != 1) goto L31;
        if (r101.getName().equals("equals") == false) goto L9;
        return Boolean.valueOf(equals(r102[0]));
    L9:
        if (r101.getReturnType() != Void.TYPE) goto L29;
        JSONField r105 = (JSONField) TypeUtils.getAnnotation(r101, JSONField.class);
        if (r105 != null) goto L13;
    L15:
        String r106 = null;
    L16:
        if (r106 != null) goto L26;
        String r107 = r101.getName();
        if (r107.startsWith("set") == false) goto L25;
        String r108 = r107.substring(3);
        if (r108.length() == 0) goto L23;
        r106 = Character.toLowerCase(r108.charAt(0)) + r108.substring(1);
        goto L26
    L23:
        throw new JSONException("illegal setter");
    L25:
        throw new JSONException("illegal setter");
    L26:
        this.map.put(r106, r102[0]);
        return null;
    L13:
        if (r105.name().length() == 0) goto L15;
        r106 = r105.name();
        goto L16
    L29:
        throw new JSONException("illegal setter");
    L31:
        if (r103.length != 0) goto L69;
        if (r101.getReturnType() == Void.TYPE) goto L67;
        JSONField r109 = (JSONField) TypeUtils.getAnnotation(r101, JSONField.class);
        if (r109 != null) goto L37;
    L39:
        if (r104 != null) goto L65;
        String r110 = r101.getName();
        if (r110.startsWith(MonitorConstants.CONNECT_TYPE_GET) == false) goto L48;
        String r111 = r110.substring(3);
        if (r111.length() == 0) goto L46;
        r104 = Character.toLowerCase(r111.charAt(0)) + r111.substring(1);
        goto L65
    L46:
        throw new JSONException("illegal getter");
    L48:
        if (r110.startsWith("is") == false) goto L55;
        String r112 = r110.substring(2);
        if (r112.length() == 0) goto L53;
        r104 = Character.toLowerCase(r112.charAt(0)) + r112.substring(1);
        goto L65
    L53:
        throw new JSONException("illegal getter");
    L55:
        if (r110.startsWith("hashCode") == false) goto L59;
        return Integer.valueOf(hashCode());
    L59:
        if (r110.startsWith("toString") == false) goto L63;
        return toString();
    L63:
        throw new JSONException("illegal getter");
    L65:
        return TypeUtils.cast(this.map.get(r104), r101.getGenericReturnType(), ParserConfig.getGlobalInstance());
    L37:
        if (r109.name().length() == 0) goto L39;
        r104 = r109.name();
        goto L39
    L67:
        throw new JSONException("illegal getter");
    L69:
        throw new UnsupportedOperationException(r101.toGenericString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T toJavaObject(Class<T> r100, ParserConfig r101, int r102) {
        if (r100 != Map.class) goto L6;
        return this;
    L6:
        if (r100 != Object.class) goto L11;
        if (containsKey(JSON.DEFAULT_TYPE_KEY) == true) goto L11;
        return this;
    L11:
        return (T) TypeUtils.castToJavaBean(this, r100, r101);
    }
}
