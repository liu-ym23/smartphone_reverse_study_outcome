package com.fasterxml.jackson.core.util;

import com.google.crypto.tink.shaded.protobuf.Reader;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class InternalJacksonUtil {
    public static int addOverflowSafe(int i, int i3) {
        int i10 = i + i3;
        return i10 < 0 ? Reader.READ_DONE : i10;
    }
}
