package android.ss.com.vboost.h;

import android.content.Context;
import android.os.Build;
import android.ss.com.vboost.utils.LogUtil;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;

/* JADX INFO: loaded from: classes2.dex */
public class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4664a = "i";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static h f4665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int[] f4666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int[] f4667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int[] f4668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int[] f4669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int[] f4670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int[] f4671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int[] f4672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int[] f4673j;

    static {
        f4666c = new int[]{1077936128, 1, 1086324736, 1, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1082130944, UnixStat.PERM_MASK, 1098907648, 255, 1119944704, 1, 1124073472, 255, 1128267776, 65535, 1115799552, 2000, 1115734016, 1000};
        f4667d = new int[]{1077936128, 1, 1086324736, 1, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1098907648, 255, 1119944704, 1, 1124073472, 255, 1128267776, 65535, 1115799552, 2000, 1115734016, 1000};
        f4668e = new int[]{1077936128, 1, 1086324736, 1, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1098907648, 255, 1119944704, 1, 1124073472, 255, 1128267776, 65535, 1115799552, 1, 1115734016, 1000};
        f4669f = new int[]{1077936128, 1, 1086324736, 1, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1098907648, 255, 1119944704, 1};
        f4670g = new int[]{1077936128, 1, 1086324736, 1, 1090519040, 4, 1090519296, 4, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1098907648, 255};
        int[] r100 = {1077936128, 1, 1086324736, 1, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1098907648, 255, 1119944704, 1};
        f4671h = r100;
        f4672i = r100;
        f4673j = new int[]{1077936128, 1, 1115799552, 2000, 1115734016, 1000};
    }

    public i() {
    }

    @Override // android.ss.com.vboost.h.c
    public void a() {
        if (f4665b == null) goto L6;
        LogUtil.debug(f4664a, "release");
        f4665b.b();
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void a(long r100) {
        if (f4665b == null) goto L6;
        LogUtil.debug(f4664a, "try boost timeout " + r100);
        f4665b.a((int) r100, f4672i);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public boolean a(Context r100) {
        if (f4665b != null) goto L6;
        f4665b = new h(r100);
    L6:
        if (f4665b.a() == false) goto L24;
        int r101 = e.c();
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 28) goto L14;
        LogUtil.debug(f4664a, "cluster num:" + r101);
        if (r101 != 3) goto L12;
        f4672i = f4666c;
    L22:
        LogUtil.info(f4664a, "QcomPerfInterface init.");
        return true;
    L12:
        f4672i = f4667d;
        goto L22
    L14:
        if (r102 < 26) goto L17;
        f4672i = f4668e;
        goto L22
    L17:
        if (r102 < 24) goto L20;
        f4672i = f4669f;
        goto L22
    L20:
        if (r102 < 23) goto L24;
        f4672i = f4670g;
    L24:
        return false;
    }

    @Override // android.ss.com.vboost.h.c
    public void b() {
        if (f4665b == null) goto L6;
        LogUtil.debug(f4664a, "try boost");
        f4665b.a(30000, f4672i);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void b(long r100) {
        if (f4665b == null) goto L6;
        LogUtil.debug(f4664a, "try boost gpu with timeout " + r100);
        f4665b.a((int) r100, f4673j);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void c(long r100) {
        if (f4665b == null) goto L6;
        LogUtil.debug(f4664a, "try boost storage with timeout " + r100);
        f4665b.a((int) r100, f4672i);
        return;
    }
}
