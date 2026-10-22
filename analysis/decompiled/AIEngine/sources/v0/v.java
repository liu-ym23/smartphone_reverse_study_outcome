package v0;

import android.os.Build;
import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final c f13337a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final ScrollFeedbackProvider f13338a;

        public a(NestedScrollView nestedScrollView) {
            this.f13338a = ScrollFeedbackProvider.createProvider(nestedScrollView);
        }

        @Override // v0.v.c
        public final void onScrollLimit(int i10, int i11, int i12, boolean z) {
            this.f13338a.onScrollLimit(i10, i11, i12, z);
        }

        @Override // v0.v.c
        public final void onScrollProgress(int i10, int i11, int i12, int i13) {
            this.f13338a.onScrollProgress(i10, i11, i12, i13);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface c {
        void onScrollLimit(int i10, int i11, int i12, boolean z);

        void onScrollProgress(int i10, int i11, int i12, int i13);
    }

    public v(NestedScrollView nestedScrollView) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f13337a = new a(nestedScrollView);
        } else {
            this.f13337a = new b();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b implements c {
        @Override // v0.v.c
        public final void onScrollLimit(int i10, int i11, int i12, boolean z) {
        }

        @Override // v0.v.c
        public final void onScrollProgress(int i10, int i11, int i12, int i13) {
        }
    }
}
