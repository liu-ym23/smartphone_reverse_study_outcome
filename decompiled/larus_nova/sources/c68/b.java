package c68;

import kotlin.jvm.internal.Intrinsics;
import m58.h;
import m58.v;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f22600a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        v r102 = h.f512138i;
        if (r102 == null) goto L6;
        r102.i("AudioTrace", r100 + ' ' + r101);
        return;
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        v r102 = h.f512138i;
        if (r102 == null) goto L6;
        r102.e("AudioTrace", r100 + ' ' + r101);
        return;
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        v r102 = h.f512138i;
        if (r102 == null) goto L6;
        r102.i("AudioTrace", r100 + ' ' + r101);
        return;
    }

    public static void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        v r102 = h.f512138i;
        if (r102 == null) goto L6;
        r102.w("AudioTrace", r100 + ' ' + r101);
        return;
    }

    public static void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "tr");
        v r103 = h.f512138i;
        if (r103 == null) goto L6;
        r103.e(r100 + ' ' + r101, r102);
        return;
    }
}
