package com.fasterxml.jackson.databind.j;

import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.e.w;
import java.io.Serializable;

/* JADX INFO: compiled from: PropertyWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class o extends w implements Serializable {
    public abstract void a(Object r1, com.fasterxml.jackson.a.h r2, ac r3);

    public abstract void b(Object r1, com.fasterxml.jackson.a.h r2, ac r3);

    public o(com.fasterxml.jackson.databind.w r1) {
        super(r1);
    }

    public o(com.fasterxml.jackson.databind.e.t r1) {
        super(r1.h());
    }

    public o(o r1) {
        super(r1);
    }
}
