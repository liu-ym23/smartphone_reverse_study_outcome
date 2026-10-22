package Tb;

import Yb.z;
import bc.InterfaceC1477a;
import bc.InterfaceC1478b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* loaded from: classes5.dex */
public class r implements InterfaceC1477a {

    /* renamed from: a, reason: collision with root package name */
    public final char f6014a;

    /* renamed from: b, reason: collision with root package name */
    public int f6015b = 0;

    /* renamed from: c, reason: collision with root package name */
    public LinkedList<InterfaceC1477a> f6016c = new LinkedList<>();

    public r(char c10) {
        this.f6014a = c10;
    }

    private InterfaceC1477a g(int i10) {
        Iterator<InterfaceC1477a> it = this.f6016c.iterator();
        while (it.hasNext()) {
            InterfaceC1477a next = it.next();
            if (next.c() <= i10) {
                return next;
            }
        }
        return this.f6016c.getFirst();
    }

    @Override // bc.InterfaceC1477a
    public int a(InterfaceC1478b interfaceC1478b, InterfaceC1478b interfaceC1478b2) {
        return g(interfaceC1478b.length()).a(interfaceC1478b, interfaceC1478b2);
    }

    @Override // bc.InterfaceC1477a
    public char b() {
        return this.f6014a;
    }

    @Override // bc.InterfaceC1477a
    public int c() {
        return this.f6015b;
    }

    @Override // bc.InterfaceC1477a
    public char d() {
        return this.f6014a;
    }

    @Override // bc.InterfaceC1477a
    public void e(z zVar, z zVar2, int i10) {
        g(i10).e(zVar, zVar2, i10);
    }

    public void f(InterfaceC1477a interfaceC1477a) {
        int iC = interfaceC1477a.c();
        ListIterator<InterfaceC1477a> listIterator = this.f6016c.listIterator();
        while (listIterator.hasNext()) {
            int iC2 = listIterator.next().c();
            if (iC > iC2) {
                listIterator.previous();
                listIterator.add(interfaceC1477a);
                return;
            } else if (iC == iC2) {
                throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.f6014a + "' and minimum length " + iC);
            }
        }
        this.f6016c.add(interfaceC1477a);
        this.f6015b = iC;
    }
}
