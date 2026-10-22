package io.ktor.utils.io.core;

import fb.v;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a1\u0010\u0007\u001a\u00020\u0004*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\"\u0019\u0010\f\u001a\u00020\t*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b*\n\u0010\r\"\u00020\u00002\u00020\u0000¨\u0006\u000e"}, d2 = {"Lfb/v;", "Lio/ktor/utils/io/core/Input;", "", "buffer", "", "offset", "length", "readAvailable", "(Lfb/v;[BII)I", "", "getEndOfInput", "(Lfb/v;)Z", "endOfInput", "Input", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InputKt {
    public static final boolean getEndOfInput(v vVar) {
        p.i(vVar, "<this>");
        return vVar.k();
    }

    public static final int readAvailable(v vVar, byte[] buffer, int i10, int i11) {
        p.i(vVar, "<this>");
        p.i(buffer, "buffer");
        int iG0 = vVar.G0(buffer, i10, i11 + i10);
        if (iG0 == -1) {
            return 0;
        }
        return iG0;
    }

    public static /* synthetic */ int readAvailable$default(v vVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        return readAvailable(vVar, bArr, i10, i11);
    }
}
