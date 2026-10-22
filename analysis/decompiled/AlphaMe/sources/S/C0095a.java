package S;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: S.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0095a extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0095a(String message) {
        super(message, null);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
