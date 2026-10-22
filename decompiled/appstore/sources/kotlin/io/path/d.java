package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.collections.q0;
import kotlin.collections.r0;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f21140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkOption[] f21141b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkOption[] f21142c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f21143d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set f21144e = null;

    static {
        f21140a = new d();
        f21141b = new LinkOption[]{LinkOption.NOFOLLOW_LINKS};
        f21142c = new LinkOption[0];
        f21143d = r0.e();
        f21144e = q0.d(FileVisitOption.FOLLOW_LINKS);
    }

    public d() {
    }

    public final LinkOption[] a(boolean r10) {
        if (r10 == false) goto L5;
        return f21142c;
    L5:
        return f21141b;
    }

    public final Set b(boolean r10) {
        if (r10 == false) goto L5;
        return f21144e;
    L5:
        return f21143d;
    }
}
