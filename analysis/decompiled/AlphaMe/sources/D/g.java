package D;

import android.content.res.Resources;
import ch.qos.logback.core.CoreConstants;
import q.k;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final h f364a = new h(0);

    /* renamed from: b, reason: collision with root package name */
    public static final k f365b = new k(16);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface a(android.content.Context r14, C.f r15, android.content.res.Resources r16, int r17, java.lang.String r18, int r19, int r20, C.b r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.g.a(android.content.Context, C.f, android.content.res.Resources, int, java.lang.String, int, int, C.b, boolean):android.graphics.Typeface");
    }

    public static String b(Resources resources, int i4, String str, int i5, int i6) {
        return resources.getResourcePackageName(i4) + CoreConstants.DASH_CHAR + str + CoreConstants.DASH_CHAR + i5 + CoreConstants.DASH_CHAR + i4 + CoreConstants.DASH_CHAR + i6;
    }
}
