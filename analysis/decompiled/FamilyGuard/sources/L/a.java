package L;

import java.io.IOException;

/* loaded from: classes.dex */
public final class a extends IOException {
    public /* synthetic */ a(String str, Throwable th, int i5, j4.g gVar) {
        this(str, (i5 & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, Throwable th) {
        super(str, th);
        j4.k.g(str, "message");
    }
}
