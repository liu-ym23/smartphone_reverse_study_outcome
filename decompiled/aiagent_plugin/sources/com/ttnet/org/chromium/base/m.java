package com.ttnet.org.chromium.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ObserverList.java */
/* JADX INFO: loaded from: classes4.dex */
public class m<E> implements Iterable<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f37721b = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<E> f37722a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ThreadUtils.a f37723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f37724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f37725e;
    private boolean f;
    private boolean g;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.m$1, reason: invalid class name */
    /* JADX INFO: compiled from: ObserverList.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: ObserverList.java */
    private class a implements b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f37726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f37727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f37728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f37729d;

        /* synthetic */ a(m r1, AnonymousClass1 r2) {
            this(r1);
        }

        private a(m r1) {
            this.f37726a = r1;
            m.a(r1);
            this.f37727b = m.b(r1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (m.c(this.f37726a) == false) goto L5;
            m.d(this.f37726a).a();
        L5:
            int r0 = this.f37728c;
        L7:
            if (r0 >= this.f37727b) goto L12;
            if (m.a(this.f37726a, r0) != null) goto L12;
            r0 = r0 + 1;
        L12:
            if (r0 >= this.f37727b) goto L15;
            return true;
        L15:
            a();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (m.c(this.f37726a) == false) goto L5;
            m.d(this.f37726a).a();
        L5:
            int r0 = this.f37728c;
            if (r0 >= this.f37727b) goto L10;
            if (m.a(this.f37726a, r0) != null) goto L10;
            this.f37728c++;
        L10:
            int r1 = this.f37728c;
            if (r1 >= this.f37727b) goto L14;
            m r2 = this.f37726a;
            this.f37728c = r1 + 1;
            return (E) m.a(r2, r1);
        L14:
            a();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void a() {
            if (this.f37729d == true) goto L6;
            this.f37729d = true;
            m.e(this.f37726a);
            return;
        }
    }

    public interface b extends Iterator {
    }

    static {
    }

    static /* synthetic */ Object a(m r0, int r1) {
        return r0.a(r1);
    }

    static /* synthetic */ void a(m r0) {
        r0.c();
    }

    static /* synthetic */ int b(m r0) {
        return r0.e();
    }

    static /* synthetic */ boolean c(m r0) {
        return r0.g;
    }

    static /* synthetic */ ThreadUtils.a d(m r0) {
        return r0.f37723c;
    }

    static /* synthetic */ void e(m r0) {
        r0.d();
    }

    public m() {
        this.f37722a = new ArrayList();
        this.g = true;
        this.f37723c = new ThreadUtils.a();
    }

    public void a() {
        this.g = false;
    }

    public boolean a(E r2) {
        if (this.g == false) goto L5;
        this.f37723c.a();
    L5:
        if (r2 != null) goto L7;
        return false;
    L7:
        if (this.f37722a.contains(r2) == true) goto L19;
        boolean r3 = this.f37722a.add(r2);
        if (f37721b == true) goto L15;
        if (r3 == true) goto L15;
        throw new AssertionError();
    L15:
        this.f37725e++;
        return true;
    L19:
        return false;
    }

    public boolean b(E r4) {
        if (this.g == false) goto L6;
        this.f37723c.a();
    L6:
        if (r4 != null) goto L8;
        return false;
    L8:
        int r5 = this.f37722a.indexOf(r4);
        if (r5 != (-1)) goto L12;
        return false;
    L12:
        if (this.f37724d != 0) goto L14;
        this.f37722a.remove(r5);
    L15:
        int r6 = this.f37725e - 1;
        this.f37725e = r6;
        if (f37721b == true) goto L21;
        if (r6 >= 0) goto L21;
        throw new AssertionError();
    L21:
        return true;
    L14:
        this.f = true;
        this.f37722a.set(r5, null);
        goto L15
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        if (this.g == false) goto L6;
        this.f37723c.a();
    L6:
        return new a(this, null);
    }

    private void b() {
        if (f37721b == false) goto L5;
    L9:
        int r0 = this.f37722a.size() - 1;
    L10:
        if (r0 < 0) goto L15;
        if (this.f37722a.get(r0) != null) goto L14;
        this.f37722a.remove(r0);
    L14:
        r0 = r0 - 1;
        goto L10
    L15:
        return;
    L5:
        if (this.f37724d == 0) goto L9;
        throw new AssertionError();
    }

    private void c() {
        this.f37724d++;
    }

    private void d() {
        int r0 = this.f37724d - 1;
        this.f37724d = r0;
        if (f37721b == true) goto L8;
        if (r0 >= 0) goto L8;
        throw new AssertionError();
    L8:
        if (r0 <= 0) goto L11;
        return;
    L11:
        if (this.f == true) goto L13;
        return;
    L13:
        this.f = false;
        b();
    }

    private int e() {
        return this.f37722a.size();
    }

    private E a(int r1) {
        return this.f37722a.get(r1);
    }
}
