package b0;

import androidx.fragment.app.D;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: b0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0360f extends AbstractC0361g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0360f(D fragment, int i4) {
        super(1, fragment, "Attempting to get target request code from fragment " + fragment);
        if (i4 != 1) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            return;
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        super(1, fragment, "Attempting to get target fragment from fragment " + fragment);
    }
}
