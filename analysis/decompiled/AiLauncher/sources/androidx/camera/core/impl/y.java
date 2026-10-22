package androidx.camera.core.impl;

import D.B;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.f;

/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final Range<Integer> f11539a = new Range<>(0, 0);

    public static abstract class a {
        public abstract y a();

        public abstract a b(B b10);

        public abstract a c(Range<Integer> range);

        public abstract a d(Config config);

        public abstract a e(Size size);

        public abstract a f(Size size);

        public abstract a g(int i10);

        public abstract a h(boolean z10);
    }

    public static a a(Size size) {
        return new f.b().f(size).e(size).g(0).c(f11539a).b(B.f1998d).h(false);
    }

    public abstract B b();

    public abstract Range<Integer> c();

    public abstract Config d();

    public abstract Size e();

    public abstract Size f();

    public abstract int g();

    public abstract boolean h();

    public abstract a i();
}
