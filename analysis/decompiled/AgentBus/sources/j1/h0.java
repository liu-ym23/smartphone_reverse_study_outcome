package j1;

import android.view.View;
import android.view.translation.ViewTranslationCallback;

/* loaded from: classes.dex */
public final class h0 implements ViewTranslationCallback {

    /* renamed from: a, reason: collision with root package name */
    public static final h0 f5189a = new h0();

    public final boolean onClearTranslation(View view) {
        p7.a aVar;
        q7.k.c(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
        p0.c contentCaptureManager$ui_release = ((y) view).getContentCaptureManager$ui_release();
        contentCaptureManager$ui_release.getClass();
        contentCaptureManager$ui_release.f8249k = p0.a.f8237f;
        k.j jVarG = contentCaptureManager$ui_release.g();
        Object[] objArr = jVarG.f5500c;
        long[] jArr = jVarG.f5498a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i2 = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i2 - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j2) < 128) {
                        k.a0 a0Var = ((p1.o) objArr[(i2 << 3) + i11]).f8319a.f8315d.f8304f;
                        Object objG = a0Var.g(p1.s.A);
                        if (objG == null) {
                            objG = null;
                        }
                        if (objG != null) {
                            Object objG2 = a0Var.g(p1.h.f8289l);
                            p1.a aVar2 = (p1.a) (objG2 != null ? objG2 : null);
                            if (aVar2 != null && (aVar = (p7.a) aVar2.f8267b) != null) {
                            }
                        }
                    }
                    j2 >>= 8;
                }
                if (i10 != 8) {
                    return true;
                }
            }
            if (i2 == length) {
                return true;
            }
            i2++;
        }
    }

    public final boolean onHideTranslation(View view) {
        p7.k kVar;
        q7.k.c(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
        p0.c contentCaptureManager$ui_release = ((y) view).getContentCaptureManager$ui_release();
        contentCaptureManager$ui_release.getClass();
        contentCaptureManager$ui_release.f8249k = p0.a.f8237f;
        k.j jVarG = contentCaptureManager$ui_release.g();
        Object[] objArr = jVarG.f5500c;
        long[] jArr = jVarG.f5498a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i2 = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i2 - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j2) < 128) {
                        k.a0 a0Var = ((p1.o) objArr[(i2 << 3) + i11]).f8319a.f8315d.f8304f;
                        Object objG = a0Var.g(p1.s.A);
                        if (objG == null) {
                            objG = null;
                        }
                        if (q7.k.a(objG, Boolean.TRUE)) {
                            Object objG2 = a0Var.g(p1.h.f8288k);
                            p1.a aVar = (p1.a) (objG2 != null ? objG2 : null);
                            if (aVar != null && (kVar = (p7.k) aVar.f8267b) != null) {
                            }
                        }
                    }
                    j2 >>= 8;
                }
                if (i10 != 8) {
                    return true;
                }
            }
            if (i2 == length) {
                return true;
            }
            i2++;
        }
    }

    public final boolean onShowTranslation(View view) {
        p7.k kVar;
        q7.k.c(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
        p0.c contentCaptureManager$ui_release = ((y) view).getContentCaptureManager$ui_release();
        contentCaptureManager$ui_release.getClass();
        contentCaptureManager$ui_release.f8249k = p0.a.f8238g;
        k.j jVarG = contentCaptureManager$ui_release.g();
        Object[] objArr = jVarG.f5500c;
        long[] jArr = jVarG.f5498a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i2 = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i2 - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j2) < 128) {
                        k.a0 a0Var = ((p1.o) objArr[(i2 << 3) + i11]).f8319a.f8315d.f8304f;
                        Object objG = a0Var.g(p1.s.A);
                        if (objG == null) {
                            objG = null;
                        }
                        if (q7.k.a(objG, Boolean.FALSE)) {
                            Object objG2 = a0Var.g(p1.h.f8288k);
                            p1.a aVar = (p1.a) (objG2 != null ? objG2 : null);
                            if (aVar != null && (kVar = (p7.k) aVar.f8267b) != null) {
                            }
                        }
                    }
                    j2 >>= 8;
                }
                if (i10 != 8) {
                    return true;
                }
            }
            if (i2 == length) {
                return true;
            }
            i2++;
        }
    }
}
