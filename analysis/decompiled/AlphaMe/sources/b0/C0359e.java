package b0;

import androidx.fragment.app.D;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: b0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0359e extends AbstractC0361g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0359e(D fragment, int i4) {
        super(0, fragment, "Attempting to get retain instance for fragment " + fragment);
        if (i4 != 1) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            return;
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        super(0, fragment, "Attempting to set retain instance for fragment " + fragment);
    }
}
