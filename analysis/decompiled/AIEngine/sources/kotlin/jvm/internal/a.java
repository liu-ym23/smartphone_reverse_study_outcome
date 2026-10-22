package kotlin.jvm.internal;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.NoSuchElementException;
import mb.m;
import mb.s;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements Iterator, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10077a = 2;

    /* renamed from: b, reason: collision with root package name */
    public int f10078b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f10079c;

    public a(Object[] array) {
        g.f(array, "array");
        this.f10079c = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f10077a) {
            case 0:
                return this.f10078b < ((Object[]) this.f10079c).length;
            case 1:
                return ((Iterator) this.f10079c).hasNext();
            default:
                return this.f10078b < ((ViewGroup) this.f10079c).getChildCount();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f10077a) {
            case 0:
                try {
                    Object[] objArr = (Object[]) this.f10079c;
                    int i10 = this.f10078b;
                    this.f10078b = i10 + 1;
                    return objArr[i10];
                } catch (ArrayIndexOutOfBoundsException e10) {
                    this.f10078b--;
                    throw new NoSuchElementException(e10.getMessage());
                }
            case 1:
                int i11 = this.f10078b;
                this.f10078b = i11 + 1;
                if (i11 >= 0) {
                    return new s(i11, ((Iterator) this.f10079c).next());
                }
                m.f0();
                throw null;
            default:
                ViewGroup viewGroup = (ViewGroup) this.f10079c;
                int i12 = this.f10078b;
                this.f10078b = i12 + 1;
                View childAt = viewGroup.getChildAt(i12);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f10077a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                ViewGroup viewGroup = (ViewGroup) this.f10079c;
                int i10 = this.f10078b - 1;
                this.f10078b = i10;
                viewGroup.removeViewAt(i10);
                return;
        }
    }

    public a(Iterator iterator) {
        g.f(iterator, "iterator");
        this.f10079c = iterator;
    }

    public a(ViewGroup viewGroup) {
        this.f10079c = viewGroup;
    }
}
