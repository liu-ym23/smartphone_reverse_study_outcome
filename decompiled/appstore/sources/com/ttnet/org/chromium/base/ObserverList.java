package com.ttnet.org.chromium.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class ObserverList implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f18270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18273d;

    public interface RewindableIterator<E> extends Iterator<E> {
        void rewind();
    }

    public static /* synthetic */ class a {
    }

    public class b implements RewindableIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f18276c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ObserverList f18277d;

        public /* synthetic */ b(ObserverList r10, a r11) {
            this(r10);
        }

        public final void a() {
            if (this.f18276c == true) goto L6;
            this.f18276c = true;
            ObserverList.d(this.f18277d);
            return;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int r10 = this.f18275b;
        L4:
            if (r10 >= this.f18274a) goto L9;
            if (ObserverList.c(this.f18277d, r10) != null) goto L9;
            r10 = r10 + 1;
        L9:
            if (r10 >= this.f18274a) goto L12;
            return true;
        L12:
            a();
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
        L2:
            int r10 = this.f18275b;
            if (r10 >= this.f18274a) goto L7;
            if (ObserverList.c(this.f18277d, r10) != null) goto L7;
            this.f18275b++;
        L7:
            int r11 = this.f18275b;
            if (r11 >= this.f18274a) goto L11;
            ObserverList r12 = this.f18277d;
            this.f18275b = r11 + 1;
            return ObserverList.c(r12, r11);
        L11:
            a();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // com.ttnet.org.chromium.base.ObserverList.RewindableIterator
        public void rewind() {
            a();
            ObserverList.a(this.f18277d);
            this.f18274a = ObserverList.b(this.f18277d);
            this.f18276c = false;
            this.f18275b = 0;
        }

        public b(ObserverList r10) {
            this.f18277d = r10;
            ObserverList.a(r10);
            this.f18274a = ObserverList.b(r10);
        }
    }

    static {
    }

    public ObserverList() {
        this.f18270a = new ArrayList();
    }

    public static /* synthetic */ void a(ObserverList r10) {
        r10.j();
    }

    public static /* synthetic */ int b(ObserverList r10) {
        return r10.f();
    }

    public static /* synthetic */ Object c(ObserverList r10, int r11) {
        return r10.i(r11);
    }

    public static /* synthetic */ void d(ObserverList r10) {
        r10.h();
    }

    public boolean e(Object r10) {
        if (r10 != null) goto L4;
        return false;
    L4:
        if (this.f18270a.contains(r10) == true) goto L10;
        this.f18270a.add(r10);
        this.f18272c++;
        return true;
    L10:
        return false;
    }

    public final int f() {
        return this.f18270a.size();
    }

    public final void g() {
        int r10 = this.f18270a.size() - 1;
    L3:
        if (r10 < 0) goto L8;
        if (this.f18270a.get(r10) != null) goto L7;
        this.f18270a.remove(r10);
    L7:
        r10 = r10 - 1;
        goto L3
    }

    public final void h() {
        int r10 = this.f18271b - 1;
        this.f18271b = r10;
        if (r10 <= 0) goto L6;
        return;
    L6:
        if (this.f18273d == true) goto L8;
        return;
    L8:
        this.f18273d = false;
        g();
    }

    public final Object i(int r10) {
        return this.f18270a.get(r10);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new b(this, null);
    }

    public final void j() {
        this.f18271b++;
    }

    public boolean k(Object r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = this.f18270a.indexOf(r10);
        if (r11 != (-1)) goto L9;
        return false;
    L9:
        if (this.f18271b != 0) goto L11;
        this.f18270a.remove(r11);
    L12:
        this.f18272c--;
        return true;
    L11:
        this.f18273d = true;
        this.f18270a.set(r11, null);
        goto L12
    }
}
