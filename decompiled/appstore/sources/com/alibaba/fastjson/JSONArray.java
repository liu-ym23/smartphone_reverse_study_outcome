package com.alibaba.fastjson;

import com.alibaba.fastjson.util.TypeUtils;
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
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public class JSONArray extends JSON implements List<Object>, Cloneable, RandomAccess, Serializable {
    protected transient Type componentType;
    private final List<Object> list;
    protected transient Object relatedArray;

    public JSONArray() {
        this.list = new ArrayList(10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object r10) {
        return this.list.add(r10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Object> r10) {
        return this.list.addAll(r10);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.list.clear();
    }

    public Object clone() {
        return new JSONArray(new ArrayList(this.list));
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r10) {
        return this.list.contains(r10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r10) {
        return this.list.containsAll(r10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r10) {
        return this.list.equals(r10);
    }

    @Override // java.util.List
    public Object get(int r10) {
        return this.list.get(r10);
    }

    public BigDecimal getBigDecimal(int r10) {
        return TypeUtils.castToBigDecimal(get(r10));
    }

    public BigInteger getBigInteger(int r10) {
        return TypeUtils.castToBigInteger(get(r10));
    }

    public Boolean getBoolean(int r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return TypeUtils.castToBoolean(r11);
    }

    public boolean getBooleanValue(int r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return TypeUtils.castToBoolean(r11).booleanValue();
    }

    public Byte getByte(int r10) {
        return TypeUtils.castToByte(get(r10));
    }

    public byte getByteValue(int r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return TypeUtils.castToByte(r11).byteValue();
    }

    public Type getComponentType() {
        return this.componentType;
    }

    public Date getDate(int r10) {
        return TypeUtils.castToDate(get(r10));
    }

    public Double getDouble(int r10) {
        return TypeUtils.castToDouble(get(r10));
    }

    public double getDoubleValue(int r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return 0.0d;
    L7:
        return TypeUtils.castToDouble(r11).doubleValue();
    }

    public Float getFloat(int r10) {
        return TypeUtils.castToFloat(get(r10));
    }

    public float getFloatValue(int r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return 0.0f;
    L7:
        return TypeUtils.castToFloat(r11).floatValue();
    }

    public int getIntValue(int r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return TypeUtils.castToInt(r11).intValue();
    }

    public Integer getInteger(int r10) {
        return TypeUtils.castToInt(get(r10));
    }

    public JSONArray getJSONArray(int r10) {
        Object r11 = this.list.get(r10);
        if ((r11 instanceof JSONArray) == false) goto L7;
        return (JSONArray) r11;
    L7:
        return (JSONArray) JSON.toJSON(r11);
    }

    public JSONObject getJSONObject(int r10) {
        Object r11 = this.list.get(r10);
        if ((r11 instanceof JSONObject) == false) goto L7;
        return (JSONObject) r11;
    L7:
        return (JSONObject) JSON.toJSON(r11);
    }

    public Long getLong(int r10) {
        return TypeUtils.castToLong(get(r10));
    }

    public long getLongValue(int r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return TypeUtils.castToLong(r11).longValue();
    }

    public <T> T getObject(int r10, Class<T> r11) {
        return (T) TypeUtils.castToJavaBean(this.list.get(r10), r11);
    }

    public Object getRelatedArray() {
        return this.relatedArray;
    }

    public Short getShort(int r10) {
        return TypeUtils.castToShort(get(r10));
    }

    public short getShortValue(int r10) {
        Object r11 = get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return TypeUtils.castToShort(r11).shortValue();
    }

    public String getString(int r10) {
        return TypeUtils.castToString(get(r10));
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object r10) {
        return this.list.indexOf(r10);
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
    public int lastIndexOf(Object r10) {
        return this.list.lastIndexOf(r10);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r10) {
        return this.list.remove(r10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> r10) {
        return this.list.removeAll(r10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> r10) {
        return this.list.retainAll(r10);
    }

    @Override // java.util.List
    public Object set(int r10, Object r11) {
        return this.list.set(r10, r11);
    }

    public void setComponentType(Type r10) {
        this.componentType = r10;
    }

    public void setRelatedArray(Object r10) {
        this.relatedArray = r10;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.list.size();
    }

    @Override // java.util.List
    public List<Object> subList(int r10, int r11) {
        return this.list.subList(r10, r11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.List
    public void add(int r10, Object r11) {
        this.list.add(r10, r11);
    }

    @Override // java.util.List
    public boolean addAll(int r10, Collection<? extends Object> r11) {
        return this.list.addAll(r10, r11);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int r10) {
        return this.list.listIterator(r10);
    }

    @Override // java.util.List
    public Object remove(int r10) {
        return this.list.remove(r10);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r10) {
        return (T[]) this.list.toArray(r10);
    }

    public JSONArray(List<Object> r10) {
        this.list = r10;
    }

    public JSONArray(int r10) {
        this.list = new ArrayList(r10);
    }
}
