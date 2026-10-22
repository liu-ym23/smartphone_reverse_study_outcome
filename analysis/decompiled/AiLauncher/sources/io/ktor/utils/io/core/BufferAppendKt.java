package io.ktor.utils.io.core;

import fb.C4074a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a#\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lfb/a;", "other", "", "maxSize", "writeBufferAppend", "(Lfb/a;Lfb/a;I)I", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BufferAppendKt {
    public static final int writeBufferAppend(C4074a c4074a, C4074a other, int i10) {
        p.i(c4074a, "<this>");
        p.i(other, "other");
        long jMin = Math.min(other.n(), i10);
        c4074a.write(other, jMin);
        return (int) jMin;
    }
}
