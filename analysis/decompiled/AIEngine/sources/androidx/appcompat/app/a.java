package androidx.appcompat.app;

import android.view.ViewGroup;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        void a();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0001a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f315a;

        public C0001a(C0001a c0001a) {
            super((ViewGroup.MarginLayoutParams) c0001a);
            this.f315a = 0;
            this.f315a = c0001a.f315a;
        }

        public C0001a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f315a = 0;
        }
    }
}
