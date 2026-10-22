package com.stepos.alphame.data;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes.dex */
public class Cache<T> {
    private static final String TAG = "AlphaMe";
    private Stack<T> mCache = new Stack<>();
    private Class<? extends T> mClass;
    private int mMaxSize;

    public Cache(Class<? extends T> cls, int i4) {
        this.mMaxSize = 5;
        this.mClass = cls;
        this.mMaxSize = i4;
    }

    public void clear() {
        synchronized (this) {
            this.mCache.clear();
        }
    }

    public T pop() {
        synchronized (this) {
            if (!this.mCache.isEmpty()) {
                return this.mCache.pop();
            }
            try {
                return this.mClass.newInstance();
            } catch (Exception e4) {
                Log.e(TAG, "Cache instance : " + e4);
                return null;
            }
        }
    }

    public void put(T t4) {
        synchronized (this) {
            try {
                if (t4 == null) {
                    return;
                }
                for (int size = this.mCache.size() - 1; size >= 0; size--) {
                    if (this.mCache.get(size) == t4) {
                        return;
                    }
                }
                if (this.mCache.size() < this.mMaxSize) {
                    this.mCache.push(t4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void put(ArrayList<T> arrayList) {
        synchronized (this) {
            try {
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    T next = it.next();
                    if (this.mCache.size() < this.mMaxSize) {
                        put((Cache<T>) next);
                    }
                }
            } finally {
            }
        }
    }
}
