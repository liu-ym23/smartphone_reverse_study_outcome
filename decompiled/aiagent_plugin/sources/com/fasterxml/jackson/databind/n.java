package com.fasterxml.jackson.databind;

import java.util.Iterator;

/* JADX INFO: compiled from: JsonNode.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class n extends o.a implements Iterable<n> {
    public n a(String r1) {
        return null;
    }

    public boolean a() {
        return false;
    }

    public double b() {
        return 0.0d;
    }

    public n() {
    }

    @Override // java.lang.Iterable
    public final Iterator<n> iterator() {
        return c();
    }

    public Iterator<n> c() {
        return com.fasterxml.jackson.databind.l.h.a();
    }
}
