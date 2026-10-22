package com.amap.api.mapcore.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes28.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Integer, a> f27697a;

    public class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<T> f27698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public T f27699b;

        public a(o r100) {
            this.f27698a = Collections.synchronizedList(new ArrayList());
            this.f27699b = null;
        }
    }

    public <T> void a() {
        ConcurrentHashMap<Integer, a> r100 = this.f27697a;
        if (r100 != null) goto L12;
        return;
    L12:
        Iterator<Map.Entry<Integer, a>> r101 = r100.entrySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r101.hasNext() == false) goto L9;
        a r102 = r101.next().getValue();     // Catch: Throwable -> L11
        r102.f27698a.clear();     // Catch: Throwable -> L11
        r102.f27699b = null;     // Catch: Throwable -> L11
        goto L7
    L9:
        this.f27697a.clear();     // Catch: Throwable -> L11
        return;
    }

    public o() {
        this.f27697a = new ConcurrentHashMap();
    }

    public <T> void a(Integer r100) {
        if (this.f27697a.containsKey(r100) == false) goto L13;
        a r101 = this.f27697a.get(r100);     // Catch: Throwable -> L10
        if (r101 == null) goto L14;
        List<T> r102 = r101.f27698a;     // Catch: Throwable -> L10
        if (r102 == null) goto L15;
        r102.clear();     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public <T> List<T> a(int r100) {
        a r101 = this.f27697a.get(Integer.valueOf(r100));     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        return r101.f27698a;
    L6:
        return null;
    L11:
        return null;
    }

    public <T> void a(int r100, T r101) {
        ConcurrentHashMap<Integer, a> r102 = this.f27697a;
        if (r102 != null) goto L14;
        return;
    L14:
        a r103 = r102.get(Integer.valueOf(r100));     // Catch: Throwable -> L13
        if (r103 != null) goto L9;
        r103 = new a(this);     // Catch: Throwable -> L13
        this.f27697a.putIfAbsent(Integer.valueOf(r100), r103);     // Catch: Throwable -> L13
    L9:
        if (r103.f27699b != r101) goto L11;
        return;
    L11:
        b(Integer.valueOf(r100), r103.f27699b);     // Catch: Throwable -> L13
        r103.f27699b = r101;     // Catch: Throwable -> L13
        a(Integer.valueOf(r100), r101);     // Catch: Throwable -> L13
        return;
    }

    public <T> void b(Integer r100, T r101) {
        if (r101 == null) goto L19;
        ConcurrentHashMap<Integer, a> r102 = this.f27697a;
        if (r102 == null) goto L24;
        if (r102.containsKey(r100) == false) goto L20;
        a r103 = this.f27697a.get(r100);     // Catch: Throwable -> L16
        if (r103 == null) goto L21;
        List<T> r104 = r103.f27698a;     // Catch: Throwable -> L16
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.contains(r101) == false) goto L23;
        r103.f27698a.remove(r101);     // Catch: Throwable -> L16
        return;
    L23:
        return;
    L21:
        return;
    L20:
        return;
    L25:
        return;
    L24:
        return;
    }

    public <T> void a(Integer r100, T r101) {
        if (r101 == null) goto L18;
        ConcurrentHashMap<Integer, a> r102 = this.f27697a;
        if (r102 == null) goto L21;
        a r103 = r102.get(r100);     // Catch: Throwable -> L15
        if (r103 != null) goto L9;
        r103 = new a(this);     // Catch: Throwable -> L15
        this.f27697a.putIfAbsent(r100, r103);     // Catch: Throwable -> L15
    L9:
        List<T> r104 = r103.f27698a;     // Catch: Throwable -> L15
        if (r104 != null) goto L12;
        return;
    L12:
        if (r104.contains(r101) == true) goto L20;
        r103.f27698a.add(r101);     // Catch: Throwable -> L15
        return;
    L20:
        return;
    L22:
        return;
    L21:
        return;
    }
}
