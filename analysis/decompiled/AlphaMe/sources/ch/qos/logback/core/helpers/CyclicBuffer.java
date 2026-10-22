package ch.qos.logback.core.helpers;

import B0.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CyclicBuffer<E> {
    E[] ea;
    int first;
    int last;
    int maxSize;
    int numElems;

    public CyclicBuffer(int i4) throws IllegalArgumentException {
        if (i4 < 1) {
            throw new IllegalArgumentException(g.j("The maxSize argument (", i4, ") is not a positive integer."));
        }
        init(i4);
    }

    private void init(int i4) {
        this.maxSize = i4;
        this.ea = (E[]) new Object[i4];
        this.first = 0;
        this.last = 0;
        this.numElems = 0;
    }

    public void add(E e4) {
        E[] eArr = this.ea;
        int i4 = this.last;
        eArr[i4] = e4;
        int i5 = i4 + 1;
        this.last = i5;
        int i6 = this.maxSize;
        if (i5 == i6) {
            this.last = 0;
        }
        int i7 = this.numElems;
        if (i7 < i6) {
            this.numElems = i7 + 1;
            return;
        }
        int i8 = this.first + 1;
        this.first = i8;
        if (i8 == i6) {
            this.first = 0;
        }
    }

    public List<E> asList() {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < length(); i4++) {
            arrayList.add(get(i4));
        }
        return arrayList;
    }

    public void clear() {
        init(this.maxSize);
    }

    public E get(int i4) {
        if (i4 < 0 || i4 >= this.numElems) {
            return null;
        }
        return this.ea[(this.first + i4) % this.maxSize];
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int length() {
        return this.numElems;
    }

    public void resize(int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException(g.j("Negative array size [", i4, "] not allowed."));
        }
        int i5 = this.numElems;
        if (i4 == i5) {
            return;
        }
        E[] eArr = (E[]) new Object[i4];
        if (i4 < i5) {
            i5 = i4;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            E[] eArr2 = this.ea;
            int i7 = this.first;
            eArr[i6] = eArr2[i7];
            eArr2[i7] = null;
            int i8 = i7 + 1;
            this.first = i8;
            if (i8 == this.numElems) {
                this.first = 0;
            }
        }
        this.ea = eArr;
        this.first = 0;
        this.numElems = i5;
        this.maxSize = i4;
        if (i5 == i4) {
            this.last = 0;
        } else {
            this.last = i5;
        }
    }

    public E get() {
        int i4 = this.numElems;
        if (i4 <= 0) {
            return null;
        }
        this.numElems = i4 - 1;
        E[] eArr = this.ea;
        int i5 = this.first;
        E e4 = eArr[i5];
        eArr[i5] = null;
        int i6 = i5 + 1;
        this.first = i6;
        if (i6 == this.maxSize) {
            this.first = 0;
        }
        return e4;
    }

    public CyclicBuffer(CyclicBuffer<E> cyclicBuffer) {
        int i4 = cyclicBuffer.maxSize;
        this.maxSize = i4;
        E[] eArr = (E[]) new Object[i4];
        this.ea = eArr;
        System.arraycopy(cyclicBuffer.ea, 0, eArr, 0, i4);
        this.last = cyclicBuffer.last;
        this.first = cyclicBuffer.first;
        this.numElems = cyclicBuffer.numElems;
    }
}
