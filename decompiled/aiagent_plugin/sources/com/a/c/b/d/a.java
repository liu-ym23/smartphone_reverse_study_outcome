package com.a.c.b.d;

import java.io.Serializable;

/* JADX INFO: compiled from: FieldValue.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends Serializable> implements Serializable {
    public abstract T a();

    public a() {
    }

    public final String toString() {
        return String.format("%s", new Object[]{a()});
    }
}
