package bytekn.foundation.encryption;

import kotlin.UByte;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21774a = 0;

    public static final class a {
    }

    static {
    }

    public static final String a(byte[] r100) {
        String r101 = d0.b.f466155a;
        StringBuilder r102 = new StringBuilder(r100.length * 2);
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        int r105 = r100[r104] & UByte.MAX_VALUE;
        r102.append(r101.charAt((r105 >>> 4) & 15));
        r102.append(r101.charAt((r105 >>> 0) & 15));
        r104 = r104 + 1;
        goto L3
    L6:
        return r102.toString();
    }
}
