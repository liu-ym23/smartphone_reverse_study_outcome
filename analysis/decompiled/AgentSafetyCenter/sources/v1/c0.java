package v1;

import android.view.View;
import android.view.translation.ViewTranslationCallback;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 implements ViewTranslationCallback {

    /* renamed from: a, reason: collision with root package name */
    public static final c0 f14389a = new c0();

    @Override // android.view.translation.ViewTranslationCallback
    public final boolean onClearTranslation(View view) {
        xb.a aVar;
        view.getClass();
        y0.d contentCaptureManager$ui_release = ((t) view).getContentCaptureManager$ui_release();
        contentCaptureManager$ui_release.getClass();
        contentCaptureManager$ui_release.f15858j = y0.b.f15847c;
        p.j jVarF = contentCaptureManager$ui_release.f();
        Object[] objArr = jVarF.f9582c;
        long[] jArr = jVarF.f9580a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j10 = jArr[i];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i3; i10++) {
                    if ((255 & j10) < 128) {
                        p.f0 f0Var = ((a2.q) objArr[(i << 3) + i10]).f92a.f88d.f75c;
                        Object objG = f0Var.g(a2.u.B);
                        if (objG == null) {
                            objG = null;
                        }
                        if (objG != null) {
                            Object objG2 = f0Var.g(a2.j.f61m);
                            a2.a aVar2 = (a2.a) (objG2 != null ? objG2 : null);
                            if (aVar2 != null && (aVar = (xb.a) aVar2.f30b) != null) {
                            }
                        }
                    }
                    j10 >>= 8;
                }
                if (i3 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    @Override // android.view.translation.ViewTranslationCallback
    public final boolean onHideTranslation(View view) {
        xb.l lVar;
        view.getClass();
        y0.d contentCaptureManager$ui_release = ((t) view).getContentCaptureManager$ui_release();
        contentCaptureManager$ui_release.getClass();
        contentCaptureManager$ui_release.f15858j = y0.b.f15847c;
        p.j jVarF = contentCaptureManager$ui_release.f();
        Object[] objArr = jVarF.f9582c;
        long[] jArr = jVarF.f9580a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j10 = jArr[i];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i3; i10++) {
                    if ((255 & j10) < 128) {
                        p.f0 f0Var = ((a2.q) objArr[(i << 3) + i10]).f92a.f88d.f75c;
                        Object objG = f0Var.g(a2.u.B);
                        if (objG == null) {
                            objG = null;
                        }
                        if (yb.k.a(objG, Boolean.TRUE)) {
                            Object objG2 = f0Var.g(a2.j.f60l);
                            a2.a aVar = (a2.a) (objG2 != null ? objG2 : null);
                            if (aVar != null && (lVar = (xb.l) aVar.f30b) != null) {
                            }
                        }
                    }
                    j10 >>= 8;
                }
                if (i3 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    @Override // android.view.translation.ViewTranslationCallback
    public final boolean onShowTranslation(View view) {
        xb.l lVar;
        view.getClass();
        y0.d contentCaptureManager$ui_release = ((t) view).getContentCaptureManager$ui_release();
        contentCaptureManager$ui_release.getClass();
        contentCaptureManager$ui_release.f15858j = y0.b.f15848f;
        p.j jVarF = contentCaptureManager$ui_release.f();
        Object[] objArr = jVarF.f9582c;
        long[] jArr = jVarF.f9580a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j10 = jArr[i];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i3; i10++) {
                    if ((255 & j10) < 128) {
                        p.f0 f0Var = ((a2.q) objArr[(i << 3) + i10]).f92a.f88d.f75c;
                        Object objG = f0Var.g(a2.u.B);
                        if (objG == null) {
                            objG = null;
                        }
                        if (yb.k.a(objG, Boolean.FALSE)) {
                            Object objG2 = f0Var.g(a2.j.f60l);
                            a2.a aVar = (a2.a) (objG2 != null ? objG2 : null);
                            if (aVar != null && (lVar = (xb.l) aVar.f30b) != null) {
                            }
                        }
                    }
                    j10 >>= 8;
                }
                if (i3 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }
}
