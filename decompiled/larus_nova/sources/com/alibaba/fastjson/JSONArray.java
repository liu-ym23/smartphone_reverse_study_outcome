package com.alibaba.fastjson;

import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes28.dex */
public class JSONArray extends JSON implements List<Object>, Cloneable, RandomAccess, Serializable {
    private static final long serialVersionUID = 1;
    protected transient Type componentType;
    private final List<Object> list;
    protected transient Object relatedArray;

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.list.clear();
    }

    public Object clone() {
        return new JSONArray(new ArrayList(this.list));
    }

    public JSONArray fluentClear() {
        this.list.clear();
        return this;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.list.iterator();
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.list.size();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    public JSONArray() {
        this.list = new ArrayList();
    }

    public Type getComponentType() {
        return this.componentType;
    }

    public Object getRelatedArray() {
        return this.relatedArray;
    }

    public JSONArray(List<Object> r100) {
        if (r100 == null) goto L7;
        this.list = r100;
        return;
    L7:
        throw new IllegalArgumentException("list is null.");
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object r100) {
        return this.list.add(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<?> r100) {
        return this.list.addAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r100) {
        return this.list.contains(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        return this.list.containsAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof JSONArray) == false) goto L10;
        return this.list.equals(((JSONArray) r100).list);
    L10:
        return this.list.equals(r100);
    }

    public JSONArray fluentAdd(Object r100) {
        this.list.add(r100);
        return this;
    }

    public JSONArray fluentAddAll(Collection<?> r100) {
        this.list.addAll(r100);
        return this;
    }

    public JSONArray fluentRemove(int r100) {
        ListProtector.remove(this.list, r100);
        return this;
    }

    public JSONArray fluentRemoveAll(Collection<?> r100) {
        this.list.removeAll(r100);
        return this;
    }

    public JSONArray fluentRetainAll(Collection<?> r100) {
        this.list.retainAll(r100);
        return this;
    }

    @Override // java.util.List
    public Object get(int r100) {
        return ListProtector.get(this.list, r100);
    }

    public BigDecimal getBigDecimal(int r100) {
        return TypeUtils.castToBigDecimal(get(r100));
    }

    public BigInteger getBigInteger(int r100) {
        return TypeUtils.castToBigInteger(get(r100));
    }

    public Boolean getBoolean(int r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return TypeUtils.castToBoolean(r101);
    }

    public boolean getBooleanValue(int r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return TypeUtils.castToBoolean(r101).booleanValue();
    }

    public Byte getByte(int r100) {
        return TypeUtils.castToByte(get(r100));
    }

    public byte getByteValue(int r100) {
        Byte r101 = TypeUtils.castToByte(get(r100));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.byteValue();
    }

    public Date getDate(int r100) {
        return TypeUtils.castToDate(get(r100));
    }

    public Double getDouble(int r100) {
        return TypeUtils.castToDouble(get(r100));
    }

    public double getDoubleValue(int r100) {
        Double r101 = TypeUtils.castToDouble(get(r100));
        if (r101 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r101.doubleValue();
    }

    public Float getFloat(int r100) {
        return TypeUtils.castToFloat(get(r100));
    }

    public float getFloatValue(int r100) {
        Float r101 = TypeUtils.castToFloat(get(r100));
        if (r101 != null) goto L7;
        return 0.0f;
    L7:
        return r101.floatValue();
    }

    public int getIntValue(int r100) {
        Integer r101 = TypeUtils.castToInt(get(r100));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.intValue();
    }

    public Integer getInteger(int r100) {
        return TypeUtils.castToInt(get(r100));
    }

    public JSONArray getJSONArray(int r100) {
        Object r101 = ListProtector.get(this.list, r100);
        if ((r101 instanceof JSONArray) == false) goto L7;
        return (JSONArray) r101;
    L7:
        if ((r101 instanceof List) == false) goto L11;
        return new JSONArray((List) r101);
    L11:
        return (JSONArray) JSON.toJSON(r101);
    }

    public JSONObject getJSONObject(int r100) {
        Object r101 = ListProtector.get(this.list, r100);
        if ((r101 instanceof JSONObject) == false) goto L7;
        return (JSONObject) r101;
    L7:
        if ((r101 instanceof Map) == false) goto L11;
        return new JSONObject((Map) r101);
    L11:
        return (JSONObject) JSON.toJSON(r101);
    }

    public Long getLong(int r100) {
        return TypeUtils.castToLong(get(r100));
    }

    public long getLongValue(int r100) {
        Long r101 = TypeUtils.castToLong(get(r100));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.longValue();
    }

    public Short getShort(int r100) {
        return TypeUtils.castToShort(get(r100));
    }

    public short getShortValue(int r100) {
        Short r101 = TypeUtils.castToShort(get(r100));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.shortValue();
    }

    public Object getSqlDate(int r100) {
        return TypeUtils.castToSqlDate(get(r100));
    }

    public String getString(int r100) {
        return TypeUtils.castToString(get(r100));
    }

    public Object getTimestamp(int r100) {
        return TypeUtils.castToTimestamp(get(r100));
    }

    @Override // java.util.List
    public int indexOf(Object r100) {
        return this.list.indexOf(r100);
    }

    @Override // java.util.List
    public int lastIndexOf(Object r100) {
        return this.list.lastIndexOf(r100);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int r100) {
        return this.list.listIterator(r100);
    }

    @Override // java.util.List
    public Object remove(int r100) {
        return ListProtector.remove(this.list, r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> r100) {
        return this.list.removeAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> r100) {
        return this.list.retainAll(r100);
    }

    public void setComponentType(Type r100) {
        this.componentType = r100;
    }

    public void setRelatedArray(Object r100) {
        this.relatedArray = r100;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r100) {
        return (T[]) this.list.toArray(r100);
    }

    public <T> List<T> toJavaList(Class<T> r100) {
        ArrayList r101 = new ArrayList(size());
        ParserConfig r102 = ParserConfig.getGlobalInstance();
        Iterator<Object> r103 = iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r101.add(TypeUtils.cast(r103.next(), r100, r102));
        goto L4
    L6:
        return r101;
    }

    public JSONArray(int r100) {
        this.list = new ArrayList(r100);
    }

    public JSONArray fluentRemove(Object r100) {
        this.list.remove(r100);
        return this;
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r100) {
        return this.list.remove(r100);
    }

    @Override // java.util.List
    public void add(int r100, Object r101) {
        ListProtector.add(this.list, r100, r101);
    }

    @Override // java.util.List
    public boolean addAll(int r100, Collection<? extends Object> r101) {
        return this.list.addAll(r100, r101);
    }

    public JSONArray fluentAdd(int r100, Object r101) {
        ListProtector.add(this.list, r100, r101);
        return this;
    }

    public JSONArray fluentAddAll(int r100, Collection<?> r101) {
        this.list.addAll(r100, r101);
        return this;
    }

    public JSONArray fluentSet(int r100, Object r101) {
        set(r100, r101);
        return this;
    }

    public <T> T getObject(int r100, Type r101) {
        Object r102 = ListProtector.get(this.list, r100);
        if ((r101 instanceof Class) == false) goto L7;
        return (T) TypeUtils.castToJavaBean(r102, (Class) r101);
    L7:
        return (T) JSON.parseObject(JSON.toJSONString(r102), r101, new Feature[0]);
    }

    @Override // java.util.List
    public Object set(int r100, Object r101) {
        if (r100 != (-1)) goto L7;
        this.list.add(r101);
        return null;
    L7:
        if (this.list.size() > r100) goto L14;
        int r102 = this.list.size();
    L9:
        if (r102 >= r100) goto L11;
        this.list.add(null);
        r102 = r102 + 1;
        goto L9
    L11:
        this.list.add(r101);
        return null;
    L14:
        return ListProtector.set(this.list, r100, r101);
    }

    @Override // java.util.List
    public List<Object> subList(int r100, int r101) {
        return this.list.subList(r100, r101);
    }

    public <T> T getObject(int r100, Class<T> r101) {
        return (T) TypeUtils.castToJavaBean(ListProtector.get(this.list, r100), r101);
    }
}
