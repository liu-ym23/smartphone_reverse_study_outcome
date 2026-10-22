package b4;

import android.os.Build;
import android.view.View;
import f7.f;
import java.nio.ByteBuffer;
import java.util.ConcurrentModificationException;
import java.util.WeakHashMap;
import n3.i0;
import n3.k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: c, reason: collision with root package name */
    public int f1897c;

    /* renamed from: f, reason: collision with root package name */
    public int f1898f;

    /* renamed from: g, reason: collision with root package name */
    public int f1899g;

    /* renamed from: h, reason: collision with root package name */
    public Object f1900h;

    public c() {
        if (f.f3934g == null) {
            f.f3934g = new f(19);
        }
    }

    public int a(int i) {
        if (i < this.f1899g) {
            return ((ByteBuffer) this.f1900h).getShort(this.f1898f + i);
        }
        return 0;
    }

    public void b() {
        if (((lb.f) this.f1900h).f7844l != this.f1899g) {
            throw new ConcurrentModificationException();
        }
    }

    public abstract Object c(View view);

    public abstract void d(View view, Object obj);

    public void e() {
        while (true) {
            int i = this.f1897c;
            lb.f fVar = (lb.f) this.f1900h;
            if (i >= fVar.f7842j || fVar.f7840g[i] >= 0) {
                return;
            } else {
                this.f1897c = i + 1;
            }
        }
    }

    public void f(View view, CharSequence charSequence) {
        Object tag;
        if (Build.VERSION.SDK_INT >= this.f1898f) {
            d(view, charSequence);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.f1898f) {
            tag = c(view);
        } else {
            tag = view.getTag(this.f1897c);
            if (!((Class) this.f1900h).isInstance(tag)) {
                tag = null;
            }
        }
        if (g(tag, charSequence)) {
            WeakHashMap weakHashMap = k0.f8724a;
            View.AccessibilityDelegate accessibilityDelegateA = i0.a(view);
            n3.b bVar = accessibilityDelegateA != null ? accessibilityDelegateA instanceof n3.a ? ((n3.a) accessibilityDelegateA).f8679a : new n3.b(accessibilityDelegateA) : null;
            if (bVar == null) {
                bVar = new n3.b();
            }
            k0.g(view, bVar);
            view.setTag(this.f1897c, charSequence);
            k0.c(this.f1899g, view);
        }
    }

    public abstract boolean g(Object obj, Object obj2);

    public boolean hasNext() {
        return this.f1897c < ((lb.f) this.f1900h).f7842j;
    }

    public void remove() {
        lb.f fVar = (lb.f) this.f1900h;
        b();
        if (this.f1898f == -1) {
            od.f.e("Call next() before removing element from the iterator.");
            return;
        }
        fVar.c();
        fVar.k(this.f1898f);
        this.f1898f = -1;
        this.f1899g = fVar.f7844l;
    }
}
