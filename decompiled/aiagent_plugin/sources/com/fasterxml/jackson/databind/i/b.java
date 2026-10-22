package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import java.io.Serializable;

/* JADX INFO: compiled from: BaseJsonNode.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends com.fasterxml.jackson.databind.n implements Serializable {
    @Override // com.fasterxml.jackson.databind.o
    public abstract void a(com.fasterxml.jackson.a.h r1, ac r2);

    public b() {
    }

    public String toString() {
        return k.a(this);
    }
}
