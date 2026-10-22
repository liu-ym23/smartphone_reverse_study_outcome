package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.text.input.PlatformTextInputService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001b\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a/\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001b\u0010\u0017\u001a\u00020\u0016*\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0019*\u00020\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\".\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\"\u0014\u0010%\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Landroidx/compose/ui/graphics/Matrix;", "other", "LC7/r;", "preTransform-JiSxe2E", "([F[F)V", "preTransform", "", "x", "y", "tmpMatrix", "preTranslate-cG2Xzmc", "([FFF[F)V", "preTranslate", "m1", "", "row", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "dot", "Landroid/view/View;", "", "containsDescendant", "(Landroid/view/View;Landroid/view/View;)Z", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "getContentCaptureSessionCompat", "(Landroid/view/View;)Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "platformTextInputServiceInterceptor", "LS7/k;", "getPlatformTextInputServiceInterceptor", "()LS7/k;", "setPlatformTextInputServiceInterceptor", "(LS7/k;)V", "", "ONE_FRAME_120_HERTZ_IN_MILLISECONDS", "J", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidComposeView_androidKt {
    private static final long ONE_FRAME_120_HERTZ_IN_MILLISECONDS = 8;
    private static S7.k platformTextInputServiceInterceptor = new S7.k() { // from class: androidx.compose.ui.platform.AndroidComposeView_androidKt$platformTextInputServiceInterceptor$1
        @Override // S7.k
        public final PlatformTextInputService invoke(PlatformTextInputService platformTextInputService) {
            return platformTextInputService;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean containsDescendant(View view, View view2) {
        if (kotlin.jvm.internal.k.b(view2, view)) {
            return false;
        }
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: dot-p89u6pk, reason: not valid java name */
    private static final float m5980dotp89u6pk(float[] fArr, int i, float[] fArr2, int i6) {
        int i10 = i * 4;
        return (fArr[i10 + 3] * fArr2[12 + i6]) + (fArr[i10 + 2] * fArr2[8 + i6]) + (fArr[i10 + 1] * fArr2[4 + i6]) + (fArr[i10] * fArr2[i6]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentCaptureSessionCompat getContentCaptureSessionCompat(View view) {
        ViewCompatShims.setImportantForContentCapture(view, 1);
        return ViewCompatShims.getContentCaptureSession(view);
    }

    public static final S7.k getPlatformTextInputServiceInterceptor() {
        return platformTextInputServiceInterceptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: preTransform-JiSxe2E, reason: not valid java name */
    public static final void m5981preTransformJiSxe2E(float[] fArr, float[] fArr2) {
        float fM5980dotp89u6pk = m5980dotp89u6pk(fArr2, 0, fArr, 0);
        float fM5980dotp89u6pk2 = m5980dotp89u6pk(fArr2, 0, fArr, 1);
        float fM5980dotp89u6pk3 = m5980dotp89u6pk(fArr2, 0, fArr, 2);
        float fM5980dotp89u6pk4 = m5980dotp89u6pk(fArr2, 0, fArr, 3);
        float fM5980dotp89u6pk5 = m5980dotp89u6pk(fArr2, 1, fArr, 0);
        float fM5980dotp89u6pk6 = m5980dotp89u6pk(fArr2, 1, fArr, 1);
        float fM5980dotp89u6pk7 = m5980dotp89u6pk(fArr2, 1, fArr, 2);
        float fM5980dotp89u6pk8 = m5980dotp89u6pk(fArr2, 1, fArr, 3);
        float fM5980dotp89u6pk9 = m5980dotp89u6pk(fArr2, 2, fArr, 0);
        float fM5980dotp89u6pk10 = m5980dotp89u6pk(fArr2, 2, fArr, 1);
        float fM5980dotp89u6pk11 = m5980dotp89u6pk(fArr2, 2, fArr, 2);
        float fM5980dotp89u6pk12 = m5980dotp89u6pk(fArr2, 2, fArr, 3);
        float fM5980dotp89u6pk13 = m5980dotp89u6pk(fArr2, 3, fArr, 0);
        float fM5980dotp89u6pk14 = m5980dotp89u6pk(fArr2, 3, fArr, 1);
        float fM5980dotp89u6pk15 = m5980dotp89u6pk(fArr2, 3, fArr, 2);
        float fM5980dotp89u6pk16 = m5980dotp89u6pk(fArr2, 3, fArr, 3);
        fArr[0] = fM5980dotp89u6pk;
        fArr[1] = fM5980dotp89u6pk2;
        fArr[2] = fM5980dotp89u6pk3;
        fArr[3] = fM5980dotp89u6pk4;
        fArr[4] = fM5980dotp89u6pk5;
        fArr[5] = fM5980dotp89u6pk6;
        fArr[6] = fM5980dotp89u6pk7;
        fArr[7] = fM5980dotp89u6pk8;
        fArr[8] = fM5980dotp89u6pk9;
        fArr[9] = fM5980dotp89u6pk10;
        fArr[10] = fM5980dotp89u6pk11;
        fArr[11] = fM5980dotp89u6pk12;
        fArr[12] = fM5980dotp89u6pk13;
        fArr[13] = fM5980dotp89u6pk14;
        fArr[14] = fM5980dotp89u6pk15;
        fArr[15] = fM5980dotp89u6pk16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: preTranslate-cG2Xzmc, reason: not valid java name */
    public static final void m5982preTranslatecG2Xzmc(float[] fArr, float f, float f7, float[] fArr2) {
        Matrix.m4389resetimpl(fArr2);
        Matrix.m4402translateimpl$default(fArr2, f, f7, 0.0f, 4, null);
        m5981preTransformJiSxe2E(fArr, fArr2);
    }

    public static final void setPlatformTextInputServiceInterceptor(S7.k kVar) {
        platformTextInputServiceInterceptor = kVar;
    }
}
