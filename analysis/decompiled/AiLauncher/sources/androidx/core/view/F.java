package androidx.core.view;

import android.os.Build;
import android.view.ScrollFeedbackProvider;
import android.view.View;

/* loaded from: classes.dex */
public class F {

    /* renamed from: a, reason: collision with root package name */
    public final d f13100a;

    public static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        public final ScrollFeedbackProvider f13101a;

        public b(View view) {
            this.f13101a = ScrollFeedbackProvider.createProvider(view);
        }

        @Override // androidx.core.view.F.d
        public void onScrollLimit(int i10, int i11, int i12, boolean z10) {
            this.f13101a.onScrollLimit(i10, i11, i12, z10);
        }

        @Override // androidx.core.view.F.d
        public void onScrollProgress(int i10, int i11, int i12, int i13) {
            this.f13101a.onScrollProgress(i10, i11, i12, i13);
        }
    }

    public static class c implements d {
        public c() {
        }

        @Override // androidx.core.view.F.d
        public void onScrollLimit(int i10, int i11, int i12, boolean z10) {
        }

        @Override // androidx.core.view.F.d
        public void onScrollProgress(int i10, int i11, int i12, int i13) {
        }
    }

    public interface d {
        void onScrollLimit(int i10, int i11, int i12, boolean z10);

        void onScrollProgress(int i10, int i11, int i12, int i13);
    }

    public F(View view) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f13100a = new b(view);
        } else {
            this.f13100a = new c();
        }
    }

    public static F a(View view) {
        return new F(view);
    }

    public void b(int i10, int i11, int i12, boolean z10) {
        this.f13100a.onScrollLimit(i10, i11, i12, z10);
    }

    public void c(int i10, int i11, int i12, int i13) {
        this.f13100a.onScrollProgress(i10, i11, i12, i13);
    }
}
