package io.ktor.utils.io.core;

import fb.C4074a;
import fb.x;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lfb/a;", "", "count", "", "readBytes", "(Lfb/a;I)[B", "", "isEmpty", "(Lfb/a;)Z", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BuffersKt {
    public static final boolean isEmpty(C4074a c4074a) {
        p.i(c4074a, "<this>");
        return c4074a.n() == 0;
    }

    public static final byte[] readBytes(C4074a c4074a, int i10) {
        p.i(c4074a, "<this>");
        return x.d(c4074a, i10);
    }

    public static /* synthetic */ byte[] readBytes$default(C4074a c4074a, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = (int) c4074a.n();
        }
        return readBytes(c4074a, i10);
    }
}
