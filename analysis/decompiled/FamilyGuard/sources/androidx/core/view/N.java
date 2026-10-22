package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import i4.InterfaceC0772l;
import java.util.Iterator;
import k4.InterfaceC0814a;
import q4.InterfaceC0988b;

/* loaded from: classes.dex */
public final class N {

    public static final class a implements InterfaceC0988b<View> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f9745a;

        a(ViewGroup viewGroup) {
            this.f9745a = viewGroup;
        }

        @Override // q4.InterfaceC0988b
        public Iterator<View> iterator() {
            return N.c(this.f9745a);
        }
    }

    static final class b extends j4.l implements InterfaceC0772l<View, Iterator<? extends View>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f9746a = new b();

        b() {
            super(1);
        }

        @Override // i4.InterfaceC0772l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<View> invoke(View view) {
            InterfaceC0988b<View> interfaceC0988bA;
            ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
            if (viewGroup == null || (interfaceC0988bA = N.a(viewGroup)) == null) {
                return null;
            }
            return interfaceC0988bA.iterator();
        }
    }

    public static final class c implements Iterator<View>, InterfaceC0814a {

        /* renamed from: a, reason: collision with root package name */
        private int f9747a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f9748b;

        c(ViewGroup viewGroup) {
            this.f9748b = viewGroup;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public View next() {
            ViewGroup viewGroup = this.f9748b;
            int i5 = this.f9747a;
            this.f9747a = i5 + 1;
            View childAt = viewGroup.getChildAt(i5);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9747a < this.f9748b.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.f9748b;
            int i5 = this.f9747a - 1;
            this.f9747a = i5;
            viewGroup.removeViewAt(i5);
        }
    }

    public static final class d implements InterfaceC0988b<View> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f9749a;

        public d(ViewGroup viewGroup) {
            this.f9749a = viewGroup;
        }

        @Override // q4.InterfaceC0988b
        public Iterator<View> iterator() {
            return new D(N.a(this.f9749a).iterator(), b.f9746a);
        }
    }

    public static final InterfaceC0988b<View> a(ViewGroup viewGroup) {
        return new a(viewGroup);
    }

    public static final InterfaceC0988b<View> b(ViewGroup viewGroup) {
        return new d(viewGroup);
    }

    public static final Iterator<View> c(ViewGroup viewGroup) {
        return new c(viewGroup);
    }
}
