package cma;

import com.obric.oui.image.OImageShape;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24244a = null;

        static {
            int[] r100 = new int[OImageShape.values().length];
            r100[OImageShape.STANDARD.ordinal()] = 1;
            r100[OImageShape.ROUNDED.ordinal()] = 2;
            f24244a = r100;
        }
    }

    public static final float a(OImageShape r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "shape");
        int r103 = a.f24244a[r100.ordinal()];
        if (r103 != 1) goto L5;
        return r101;
    L5:
        if (r103 != 2) goto L8;
        return r102;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
