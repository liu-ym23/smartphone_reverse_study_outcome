package bd8;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {
    public static final <T extends t1a.a> T a(b r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Fragment r102 = r100.f18691c;
        if (r102 == null) goto L7;
        t1a.b r103 = s1a.a.g(r102);
        if (r103 == null) goto L7;
        return (T) r103.getAbility(r101);
    L7:
        return null;
    }

    public static final <T extends t1a.c> T b(b r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Fragment r102 = r100.f18691c;
        if (r102 == null) goto L7;
        t1a.b r103 = s1a.a.g(r102);
        if (r103 == null) goto L7;
        return (T) r103.a(r101);
    L7:
        return null;
    }
}
