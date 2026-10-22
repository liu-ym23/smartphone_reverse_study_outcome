package com.bytedance.bdtracker;

/* loaded from: classes.dex */
public abstract class w5<T> {
    public volatile T a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = a(objArr);
                }
            }
        }
        return this.a;
    }
}
