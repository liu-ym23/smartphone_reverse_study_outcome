package X0;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class a extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String text, int i4) {
        super(text);
        if (i4 != 1) {
            Intrinsics.checkNotNullParameter(text, "text");
        } else {
            Intrinsics.checkNotNullParameter(text, "text");
            super(text);
        }
    }
}
