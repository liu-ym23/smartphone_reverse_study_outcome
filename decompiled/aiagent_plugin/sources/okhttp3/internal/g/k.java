package okhttp3.internal.g;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Huffman.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f40074a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f40075b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f40076c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a f40077d = null;

    /* JADX INFO: compiled from: Huffman.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a[] f40078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f40079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f40080c;

        public final a[] a() {
            return this.f40078a;
        }

        public final int b() {
            return this.f40079b;
        }

        public final int c() {
            return this.f40080c;
        }

        public a() {
            this.f40078a = new a[256];
            this.f40079b = 0;
            this.f40080c = 0;
        }

        public a(int r2, int r3) {
            this.f40078a = null;
            this.f40079b = r2;
            int r4 = r3 & 7;
            if (r4 != 0) goto L5;
            r4 = 8;
        L5:
            this.f40080c = r4;
        }
    }

    private k() {
    }

    static {
        f40074a = new k();
        f40075b = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, DownloadErrorCode.ERROR_DB_READONLY, DownloadErrorCode.ERROR_DB_DISKIO, 4090, 8185, 21, 248, 2042, DownloadErrorCode.ERROR_RETRY_COUNT_ALL_USED, DownloadErrorCode.ERROR_CANNOT_ACCESS_NETWORK, 249, 2043, ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, DownloadErrorCode.ERROR_THREAD_INTERRUPT, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, IdlErrors.E_RejectInferDeviceOverheat, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        byte[] r0 = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        f40076c = r0;
        f40077d = new a();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        f40074a.a(r2, f40075b[r2], f40076c[r2]);
        r2 = r2 + 1;
        goto L3
    }

    public final void a(e.h r8, e.f r9) {
        e.f r7 = (e.f) ZeusTransformUtils.wrapperContextForParams(r9, e.f.class, "com.obric.aiagent.plugin");
        o.e(r8, DBHelper.BATTERY_COL_SOURCE);
        o.e(r7, "sink");
        int r10 = r8.k();
        int r0 = 0;
        long r2 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r10) goto L9;
        int r4 = okhttp3.internal.c.a(r8.c(r0), 255);
        int r5 = f40075b[r4];
        byte r6 = f40076c[r4];
        r2 = (r2 << r6) | ((long) r5);
        r1 = r1 + r6;
    L6:
        if (r1 < 8) goto L8;
        r1 = r1 - 8;
        r7.h((int) (r2 >> r1));
        goto L6
    L8:
        r0 = r0 + 1;
        goto L3
    L9:
        if (r1 <= 0) goto L14;
        r7.h((int) ((r2 << (8 - r1)) | (255 >>> r1)));
        return;
    }

    public final int a(e.h r6) {
        o.e(r6, "bytes");
        int r5 = r6.k();
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L6;
        int r3 = okhttp3.internal.c.a(r6.c(r2), 255);
        r0 = r0 + ((long) f40076c[r3]);
        r2 = r2 + 1;
        goto L3
    L6:
        return (int) ((r0 + ((long) 7)) >> 3);
    }

    public final void a(e.g r7, long r8, e.f r10) {
        e.g r6 = (e.g) ZeusTransformUtils.wrapperContextForParams(r7, e.g.class, "com.obric.aiagent.plugin");
        e.f r9 = (e.f) ZeusTransformUtils.wrapperContextForParams(r10, e.f.class, "com.obric.aiagent.plugin");
        o.e(r6, DBHelper.BATTERY_COL_SOURCE);
        o.e(r9, "sink");
        a r11 = f40077d;
        int r0 = 0;
        long r2 = 0;
        int r1 = 0;
    L4:
        if (r2 >= r8) goto L13;
        r0 = (r0 << 8) | okhttp3.internal.c.a(r6.k(), 255);
        r1 = r1 + 8;
    L7:
        if (r1 < 8) goto L12;
        a[] r12 = r11.a();
        o.a(r12);
        r11 = r12[(r0 >>> (r1 - 8)) & 255];
        o.a(r11);
        if (r11.a() == null) goto L10;
        r1 = r1 - 8;
        goto L7
    L10:
        r9.h(r11.b());
        r1 = r1 - r11.c();
        r11 = f40077d;
        goto L7
    L12:
        r2 = r2 + 1;
    L13:
        if (r1 <= 0) goto L31;
        a[] r13 = r11.a();
        o.a(r13);
        a r14 = r13[(r0 << (8 - r1)) & 255];
        o.a(r14);
        if (r14.a() != null) goto L32;
        if (r14.c() > r1) goto L20;
        r9.h(r14.b());
        r1 = r1 - r14.c();
        r11 = f40077d;
        goto L13
    L20:
        return;
    L32:
        return;
    }

    private final void a(int r3, int r4, int r5) {
        a r2 = new a(r3, r5);
        a r6 = f40077d;
    L4:
        if (r5 <= 8) goto L9;
        r5 = r5 - 8;
        int r0 = (r4 >>> r5) & 255;
        a[] r7 = r6.a();
        o.a(r7);
        a r1 = r7[r0];
        if (r1 != null) goto L8;
        r1 = new a();
        r7[r0] = r1;
    L8:
        r6 = r1;
        goto L4
    L9:
        int r8 = 8 - r5;
        int r9 = (r4 << r8) & 255;
        a[] r10 = r6.a();
        o.a(r10);
        d.a.i.a(r10, r2, r9, (1 << r8) + r9);
    }
}
