package io.ktor.server.engine;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "", "toStringFast", "(J)Ljava/lang/String;", "", "longStrings", "[Ljava/lang/String;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LongKt {
    private static final String[] longStrings;

    static {
        String[] strArr = new String[1024];
        for (int i10 = 0; i10 < 1024; i10++) {
            strArr[i10] = String.valueOf(i10);
        }
        longStrings = strArr;
    }

    public static final String toStringFast(long j10) {
        return (0 > j10 || j10 >= 1024) ? String.valueOf(j10) : longStrings[(int) j10];
    }
}
