package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSetObservable f2912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DataSetObserver f2913b;

    public abstract int a();

    public int a(Object r1) {
        return -1;
    }

    public CharSequence a(int r1) {
        return null;
    }

    public void a(Parcelable r1, ClassLoader r2) {
        Parcelable r0 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r1, Parcelable.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public void a(View r1) {
    }

    public abstract boolean a(View r1, Object r2);

    public float b(int r1) {
        return 1.0f;
    }

    public Parcelable b() {
        return null;
    }

    @Deprecated
    public void b(View r1) {
    }

    @Deprecated
    public void b(View r1, int r2, Object r3) {
    }

    public a() {
        this.f2912a = new DataSetObservable();
    }

    public void a(ViewGroup r1) {
        a(r1);
    }

    public Object a(ViewGroup r1, int r2) {
        return a(r1, r2);
    }

    public void a(ViewGroup r1, int r2, Object r3) {
        a(r1, r2, r3);
    }

    public void b(ViewGroup r1, int r2, Object r3) {
        b(r1, r2, r3);
    }

    public void b(ViewGroup r1) {
        b(r1);
    }

    @Deprecated
    public Object a(View r1, int r2) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void a(View r1, int r2, Object r3) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void c() {
        monitor-enter(this);
        DataSetObserver r0 = this.f2913b;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.onChanged();     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        this.f2912a.notifyChanged();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void a(DataSetObserver r1) {
        this.f2912a.registerObserver(r1);
    }

    public void b(DataSetObserver r1) {
        this.f2912a.unregisterObserver(r1);
    }

    void c(DataSetObserver r1) {
        monitor-enter(this);
        this.f2913b = r1;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
