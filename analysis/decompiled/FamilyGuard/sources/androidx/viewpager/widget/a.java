package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final DataSetObservable f11691a = new DataSetObservable();

    /* renamed from: b, reason: collision with root package name */
    private DataSetObserver f11692b;

    public abstract void a(ViewGroup viewGroup, int i5, Object obj);

    public abstract void b(ViewGroup viewGroup);

    public abstract int c();

    public int d(Object obj) {
        return -1;
    }

    public float e(int i5) {
        return 1.0f;
    }

    public abstract Object f(ViewGroup viewGroup, int i5);

    public abstract boolean g(View view, Object obj);

    public void h(DataSetObserver dataSetObserver) {
        this.f11691a.registerObserver(dataSetObserver);
    }

    public abstract void i(Parcelable parcelable, ClassLoader classLoader);

    public abstract Parcelable j();

    public abstract void k(ViewGroup viewGroup, int i5, Object obj);

    void l(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f11692b = dataSetObserver;
        }
    }

    public abstract void m(ViewGroup viewGroup);

    public void n(DataSetObserver dataSetObserver) {
        this.f11691a.unregisterObserver(dataSetObserver);
    }
}
