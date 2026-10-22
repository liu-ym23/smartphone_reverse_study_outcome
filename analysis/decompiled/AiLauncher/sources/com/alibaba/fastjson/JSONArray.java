package com.alibaba.fastjson;

import G1.a;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public class JSONArray extends a implements List<Object>, Cloneable, RandomAccess, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final List<Object> f15912f;

    /* renamed from: g, reason: collision with root package name */
    public transient Object f15913g;

    /* renamed from: h, reason: collision with root package name */
    public transient Type f15914h;

    public JSONArray() {
        this.f15912f = new ArrayList(10);
    }

    public Type P() {
        return this.f15914h;
    }

    public JSONObject Q(int i10) {
        Object obj = this.f15912f.get(i10);
        return obj instanceof JSONObject ? (JSONObject) obj : (JSONObject) a.K(obj);
    }

    public Object R() {
        return this.f15913g;
    }

    public void S(Type type) {
        this.f15914h = type;
    }

    public void T(Object obj) {
        this.f15913g = obj;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        return this.f15912f.add(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Object> collection) {
        return this.f15912f.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f15912f.clear();
    }

    public Object clone() {
        return new JSONArray(new ArrayList(this.f15912f));
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f15912f.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f15912f.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return this.f15912f.equals(obj);
    }

    @Override // java.util.List
    public Object get(int i10) {
        return this.f15912f.get(i10);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f15912f.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f15912f.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f15912f.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.f15912f.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f15912f.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return this.f15912f.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.f15912f.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.f15912f.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.f15912f.retainAll(collection);
    }

    @Override // java.util.List
    public Object set(int i10, Object obj) {
        return this.f15912f.set(i10, obj);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f15912f.size();
    }

    @Override // java.util.List
    public List<Object> subList(int i10, int i11) {
        return this.f15912f.subList(i10, i11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f15912f.toArray();
    }

    @Override // java.util.List
    public void add(int i10, Object obj) {
        this.f15912f.add(i10, obj);
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends Object> collection) {
        return this.f15912f.addAll(i10, collection);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int i10) {
        return this.f15912f.listIterator(i10);
    }

    @Override // java.util.List
    public Object remove(int i10) {
        return this.f15912f.remove(i10);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f15912f.toArray(tArr);
    }

    public JSONArray(List<Object> list) {
        this.f15912f = list;
    }

    public JSONArray(int i10) {
        this.f15912f = new ArrayList(i10);
    }
}
