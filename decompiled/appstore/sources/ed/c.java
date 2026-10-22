package ed;

import com.obric.oui.image.OImageShape;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19411a = null;

        static {
            int[] r10 = new int[OImageShape.values().length];
            r10[OImageShape.STANDARD.ordinal()] = 1;
            r10[OImageShape.ROUNDED.ordinal()] = 2;
            f19411a = r10;
        }
    }

    public static final float a(OImageShape r10, float r11, float r12) {
        q.g(r10, "shape");
        int r13 = a.f19411a[r10.ordinal()];
        if (r13 != 1) goto L5;
        return r11;
    L5:
        if (r13 != 2) goto L8;
        return r12;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
