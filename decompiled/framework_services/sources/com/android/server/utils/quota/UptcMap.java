package com.android.server.utils.quota;

import android.util.ArrayMap;
import android.util.SparseArrayMap;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
class UptcMap<T> {
    private final SparseArrayMap<String, ArrayMap<String, T>> mData;

    interface UptcDataConsumer<D> {
        void accept(int r1, String r2, String r3, D r4);
    }

    public static /* synthetic */ void $r8$lambda$d6yUTqkiV7qCVDI1h44DX07LvM8(Consumer r0, ArrayMap r1) {
        lambda$forEach$0(r0, r1);
    }

    UptcMap() {
        this.mData = new SparseArrayMap();
    }

    public void add(int userId, String packageName, String tag, T obj) {
        ArrayMap<String, T> data = (ArrayMap) this.mData.get(userId, packageName);
        if (data != null) goto L5;
        data = new ArrayMap();
        this.mData.add(userId, packageName, data);
    L5:
        data.put(tag, obj);
    }

    public void clear() {
        this.mData.clear();
    }

    public boolean contains(int userId, String packageName) {
        return this.mData.contains(userId, packageName);
    }

    public boolean contains(int userId, String packageName, String tag) {
        ArrayMap<String, T> data = (ArrayMap) this.mData.get(userId, packageName);
        if (data != null) goto L5;
    L7:
        return false;
    L5:
        if (data.containsKey(tag) == false) goto L7;
        return true;
    }

    public void delete(int userId) {
        this.mData.delete(userId);
    }

    public void delete(int userId, String packageName, String tag) {
        ArrayMap<String, T> data = (ArrayMap) this.mData.get(userId, packageName);
        if (data == null) goto L8;
        data.remove(tag);
        if (data.size() != 0) goto L9;
        this.mData.delete(userId, packageName);
        return;
    L9:
        return;
    }

    public ArrayMap<String, T> delete(int userId, String packageName) {
        return (ArrayMap) this.mData.delete(userId, packageName);
    }

    public ArrayMap<String, T> get(int userId, String packageName) {
        return (ArrayMap) this.mData.get(userId, packageName);
    }

    public T get(int userId, String packageName, String tag) {
        ArrayMap<String, T> data = (ArrayMap) this.mData.get(userId, packageName);
        if (data != null) goto L7;
        return null;
    L7:
        return data.get(tag);
    }

    public T getOrCreate(int userId, String packageName, String tag, Function<Void, T> creator) {
        ArrayMap<String, T> data = (ArrayMap) this.mData.get(userId, packageName);
        if (data != null) goto L5;
    L9:
        T val = creator.apply(null);
        add(userId, packageName, tag, val);
        return val;
    L5:
        if (data.containsKey(tag) == false) goto L9;
        return data.get(tag);
    }

    private int getUserIdAtIndex(int index) {
        return this.mData.keyAt(index);
    }

    private String getPackageNameAtIndex(int userIndex, int packageIndex) {
        return (String) this.mData.keyAt(userIndex, packageIndex);
    }

    private String getTagAtIndex(int userIndex, int packageIndex, int tagIndex) {
        return (String) ((ArrayMap) this.mData.valueAt(userIndex, packageIndex)).keyAt(tagIndex);
    }

    public int userCount() {
        return this.mData.numMaps();
    }

    public int packageCountForUser(int userId) {
        return this.mData.numElementsForKey(userId);
    }

    public int tagCountForUserAndPackage(int userId, String packageName) {
        ArrayMap data = (ArrayMap) this.mData.get(userId, packageName);
        if (data != null) goto L7;
        return 0;
    L7:
        return data.size();
    }

    public T valueAt(int userIndex, int packageIndex, int tagIndex) {
        ArrayMap<String, T> data = (ArrayMap) this.mData.valueAt(userIndex, packageIndex);
        if (data != null) goto L7;
        return null;
    L7:
        return data.valueAt(tagIndex);
    }

    public void forEach(final Consumer<T> consumer) {
        this.mData.forEach(new UptcMap$$ExternalSyntheticLambda0(consumer));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static /* synthetic */ void lambda$forEach$0(Consumer r2, ArrayMap tagMap) {
        int i = tagMap.size() - 1;
    L3:
        if (i < 0) goto L6;
        r2.accept(tagMap.valueAt(i));
        i = i - 1;
        goto L3
    }

    public void forEach(UptcDataConsumer<T> consumer) {
        int uCount = userCount();
        int u = 0;
    L3:
        if (u >= uCount) goto L12;
        int userId = getUserIdAtIndex(u);
        int pkgCount = packageCountForUser(userId);
        int p = 0;
    L5:
        if (p >= pkgCount) goto L10;
        String pkgName = getPackageNameAtIndex(u, p);
        int tagCount = tagCountForUserAndPackage(userId, pkgName);
        int t = 0;
    L7:
        if (t >= tagCount) goto L9;
        String tag = getTagAtIndex(u, p, t);
        consumer.accept(userId, pkgName, tag, get(userId, pkgName, tag));
        t = t + 1;
        goto L7
    L9:
        p = p + 1;
        goto L5
    L10:
        u = u + 1;
        goto L3
    }
}
