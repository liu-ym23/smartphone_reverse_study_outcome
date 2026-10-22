package K;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public abstract class G {

    /* renamed from: a, reason: collision with root package name */
    public final int f933a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f934b;

    /* renamed from: c, reason: collision with root package name */
    public final int f935c;

    /* renamed from: d, reason: collision with root package name */
    public final int f936d;

    public G(int i4, Class cls, int i5, int i6) {
        this.f933a = i4;
        this.f934b = cls;
        this.f936d = i5;
        this.f935c = i6;
    }

    public final Object a(View view) {
        if (Build.VERSION.SDK_INT < this.f935c) {
            Object tag = view.getTag(this.f933a);
            if (this.f934b.isInstance(tag)) {
                return tag;
            }
            return null;
        }
        int i4 = ((E) this).f931e;
        switch (i4) {
            case 0:
                switch (i4) {
                    case 0:
                        return Boolean.valueOf(N.d(view));
                    default:
                        return Boolean.valueOf(N.c(view));
                }
            case 1:
                switch (i4) {
                    case 1:
                        return N.b(view);
                    default:
                        return P.b(view);
                }
            case 2:
                switch (i4) {
                    case 1:
                        return N.b(view);
                    default:
                        return P.b(view);
                }
            default:
                switch (i4) {
                    case 0:
                        return Boolean.valueOf(N.d(view));
                    default:
                        return Boolean.valueOf(N.c(view));
                }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0064. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.view.View r6, java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K.G.b(android.view.View, java.lang.Object):void");
    }
}
