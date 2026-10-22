package n3;

import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u implements w {

    /* renamed from: a, reason: collision with root package name */
    public final ScrollFeedbackProvider f8754a;

    public u(NestedScrollView nestedScrollView) {
        this.f8754a = ScrollFeedbackProvider.createProvider(nestedScrollView);
    }

    @Override // n3.w
    public final void onScrollLimit(int i, int i3, int i10, boolean z10) {
        this.f8754a.onScrollLimit(i, i3, i10, z10);
    }

    @Override // n3.w
    public final void onScrollProgress(int i, int i3, int i10, int i11) {
        this.f8754a.onScrollProgress(i, i3, i10, i11);
    }
}
