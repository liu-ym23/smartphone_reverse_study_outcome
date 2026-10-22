package androidx.core.view;

import android.os.Build;
import android.view.ScrollFeedbackProvider;
import android.view.View;
import androidx.annotation.RequiresApi;

/* loaded from: classes2.dex */
public class ScrollFeedbackProviderCompat {
    private final ScrollFeedbackProviderImpl mImpl;

    @RequiresApi(35)
    public static class ScrollFeedbackProviderApi35Impl implements ScrollFeedbackProviderImpl {
        private final ScrollFeedbackProvider mProvider;

        public ScrollFeedbackProviderApi35Impl(View view) {
            this.mProvider = ScrollFeedbackProvider.createProvider(view);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollLimit(int i, int i6, int i10, boolean z10) {
            this.mProvider.onScrollLimit(i, i6, i10, z10);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollProgress(int i, int i6, int i10, int i11) {
            this.mProvider.onScrollProgress(i, i6, i10, i11);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onSnapToItem(int i, int i6, int i10) {
            this.mProvider.onSnapToItem(i, i6, i10);
        }
    }

    public static class ScrollFeedbackProviderBaseImpl implements ScrollFeedbackProviderImpl {
        private ScrollFeedbackProviderBaseImpl() {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollLimit(int i, int i6, int i10, boolean z10) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollProgress(int i, int i6, int i10, int i11) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onSnapToItem(int i, int i6, int i10) {
        }
    }

    public interface ScrollFeedbackProviderImpl {
        void onScrollLimit(int i, int i6, int i10, boolean z10);

        void onScrollProgress(int i, int i6, int i10, int i11);

        void onSnapToItem(int i, int i6, int i10);
    }

    private ScrollFeedbackProviderCompat(View view) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.mImpl = new ScrollFeedbackProviderApi35Impl(view);
        } else {
            this.mImpl = new ScrollFeedbackProviderBaseImpl();
        }
    }

    public static ScrollFeedbackProviderCompat createProvider(View view) {
        return new ScrollFeedbackProviderCompat(view);
    }

    public void onScrollLimit(int i, int i6, int i10, boolean z10) {
        this.mImpl.onScrollLimit(i, i6, i10, z10);
    }

    public void onScrollProgress(int i, int i6, int i10, int i11) {
        this.mImpl.onScrollProgress(i, i6, i10, i11);
    }

    public void onSnapToItem(int i, int i6, int i10) {
        this.mImpl.onSnapToItem(i, i6, i10);
    }
}
