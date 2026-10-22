package kotlinx.coroutines.internal;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;

/* JADX INFO: compiled from: SystemProps.common.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class ao {
    public static final boolean a(String r0, boolean r1) {
        String r2 = am.a(r0);
        if (r2 != null) goto L5;
        return r1;
    L5:
        return Boolean.parseBoolean(r2);
    }

    public static /* synthetic */ int a(String r0, int r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r4 & 8) == 0) goto L9;
        r3 = Integer.MAX_VALUE;
    L9:
        return am.a(r0, r1, r2, r3);
    }

    public static final int a(String r7, int r8, int r9, int r10) {
        return (int) am.a(r7, r8, r9, r10);
    }

    public static /* synthetic */ long a(String r7, long r8, long r10, long r12, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = 1;
    L5:
        long r3 = r10;
        if ((r14 & 8) == 0) goto L9;
        r12 = Long.MAX_VALUE;
    L9:
        return am.a(r7, r8, r3, r12);
    }

    public static final long a(String r4, long r5, long r7, long r9) {
        String r0 = am.a(r4);
        if (r0 != null) goto L5;
        return r5;
    L5:
        Long r6 = d.o.o.e(r0);
        if (r6 == null) goto L17;
        long r2 = r6.longValue();
        boolean r1 = false;
        if (r7 <= r2) goto L10;
    L12:
        if (r1 == false) goto L15;
        return r2;
    L15:
        throw new IllegalStateException(("System property '" + r4 + "' should be in range " + r7 + DownloadConstants.VULNERABILITY_PATH + r9 + ", but is '" + r2 + '\'').toString());
    L10:
        if (r2 > r9) goto L12;
        r1 = true;
        goto L12
    L17:
        throw new IllegalStateException(("System property '" + r4 + "' has unrecognized value '" + r0 + '\'').toString());
    }

    public static final String a(String r0, String r1) {
        String r2 = am.a(r0);
        if (r2 != null) goto L6;
        return r1;
    L6:
        return r2;
    }
}
