package androidx.camera.core;

import D.T;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class g implements i {

    /* renamed from: b, reason: collision with root package name */
    public final i f11307b;

    /* renamed from: a, reason: collision with root package name */
    public final Object f11306a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Set<a> f11308c = new HashSet();

    public interface a {
        void c(i iVar);
    }

    public g(i iVar) {
        this.f11307b = iVar;
    }

    @Override // androidx.camera.core.i
    public void S(Rect rect) {
        this.f11307b.S(rect);
    }

    @Override // androidx.camera.core.i
    public T Z0() {
        return this.f11307b.Z0();
    }

    public void b(a aVar) {
        synchronized (this.f11306a) {
            this.f11308c.add(aVar);
        }
    }

    @Override // androidx.camera.core.i, java.lang.AutoCloseable
    public void close() {
        this.f11307b.close();
        e();
    }

    public void e() {
        HashSet hashSet;
        synchronized (this.f11306a) {
            hashSet = new HashSet(this.f11308c);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(this);
        }
    }

    @Override // androidx.camera.core.i
    public Image g1() {
        return this.f11307b.g1();
    }

    @Override // androidx.camera.core.i
    public int getFormat() {
        return this.f11307b.getFormat();
    }

    @Override // androidx.camera.core.i
    public int getHeight() {
        return this.f11307b.getHeight();
    }

    @Override // androidx.camera.core.i
    public int getWidth() {
        return this.f11307b.getWidth();
    }

    @Override // androidx.camera.core.i
    public i.a[] w0() {
        return this.f11307b.w0();
    }
}
