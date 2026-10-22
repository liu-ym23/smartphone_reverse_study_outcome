package c68;

import com.larus.audio.utils.f0;
import kotlin.jvm.internal.Intrinsics;
import m58.h;
import m58.k;
import m58.l;
import m58.m;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f22599a = null;

    static {
        m r100 = h.f512139j;
        if (r100 == null) goto L5;
        f0 r101 = r100.create();
    L6:
        f22599a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static k a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "what");
        l r101 = f22599a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(3, r100);
    }

    public static k b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "what");
        l r101 = f22599a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(6, r100);
    }

    public static k c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "what");
        l r101 = f22599a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(4, r100);
    }

    public static k d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "what");
        l r101 = f22599a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(5, r100);
    }
}
