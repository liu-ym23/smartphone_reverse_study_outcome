package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentReuseViolation;", "Landroidx/fragment/app/strictmode/Violation;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "previousFragmentId", "", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "getPreviousFragmentId", "()Ljava/lang/String;", "fragment_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FragmentReuseViolation extends Violation {
    private final String previousFragmentId;

    public final String getPreviousFragmentId() {
        return this.previousFragmentId;
    }

    public FragmentReuseViolation(Fragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "previousFragmentId");
        super(r100, "Attempting to reuse fragment " + r100 + " with previous ID " + r101);
        this.previousFragmentId = r101;
    }
}
