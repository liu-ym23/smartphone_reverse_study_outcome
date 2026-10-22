package D;

import android.graphics.Rect;
import android.util.Size;

/* loaded from: classes.dex */
public final class p0 extends androidx.camera.core.g {

    /* renamed from: d, reason: collision with root package name */
    public final Object f2157d;

    /* renamed from: e, reason: collision with root package name */
    public final T f2158e;

    /* renamed from: f, reason: collision with root package name */
    public Rect f2159f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2160g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2161h;

    public p0(androidx.camera.core.i iVar, T t10) {
        this(iVar, null, t10);
    }

    @Override // androidx.camera.core.g, androidx.camera.core.i
    public void S(Rect rect) {
        if (rect != null) {
            Rect rect2 = new Rect(rect);
            if (!rect2.intersect(0, 0, getWidth(), getHeight())) {
                rect2.setEmpty();
            }
            rect = rect2;
        }
        synchronized (this.f2157d) {
            this.f2159f = rect;
        }
    }

    @Override // androidx.camera.core.g, androidx.camera.core.i
    public T Z0() {
        return this.f2158e;
    }

    @Override // androidx.camera.core.g, androidx.camera.core.i
    public int getHeight() {
        return this.f2161h;
    }

    @Override // androidx.camera.core.g, androidx.camera.core.i
    public int getWidth() {
        return this.f2160g;
    }

    public p0(androidx.camera.core.i iVar, Size size, T t10) {
        super(iVar);
        this.f2157d = new Object();
        if (size == null) {
            this.f2160g = super.getWidth();
            this.f2161h = super.getHeight();
        } else {
            this.f2160g = size.getWidth();
            this.f2161h = size.getHeight();
        }
        this.f2158e = t10;
    }
}
