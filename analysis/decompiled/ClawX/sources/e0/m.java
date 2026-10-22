package e0;

import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m implements n {

    /* renamed from: a, reason: collision with root package name */
    public final ScrollFeedbackProvider f2324a;

    public m(NestedScrollView nestedScrollView) {
        this.f2324a = ScrollFeedbackProvider.createProvider(nestedScrollView);
    }

    @Override // e0.n
    public final void onScrollLimit(int i8, int i9, int i10, boolean z) {
        this.f2324a.onScrollLimit(i8, i9, i10, z);
    }

    @Override // e0.n
    public final void onScrollProgress(int i8, int i9, int i10, int i11) {
        this.f2324a.onScrollProgress(i8, i9, i10, i11);
    }
}
