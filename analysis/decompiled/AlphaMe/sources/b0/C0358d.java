package b0;

import android.view.ViewGroup;
import androidx.fragment.app.D;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: b0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0358d extends AbstractC0364j {

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup f4365b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0358d(D fragment, ViewGroup container, int i4) {
        super(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + container);
        if (i4 != 1) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.f4365b = container;
            return;
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(container, "container");
        super(fragment, "Attempting to add fragment " + fragment + " to container " + container + " which is not a FragmentContainerView");
        this.f4365b = container;
    }
}
