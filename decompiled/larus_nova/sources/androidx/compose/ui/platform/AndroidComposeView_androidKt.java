package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.text.input.PlatformTextInputService;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\u000f\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a/\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0014\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020 H\u0002\u001a\u000e\u0010!\u001a\u0004\u0018\u00010\"*\u00020 H\u0002\"&\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"platformTextInputServiceInterceptor", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "getPlatformTextInputServiceInterceptor", "()Lkotlin/jvm/functions/Function1;", "setPlatformTextInputServiceInterceptor", "(Lkotlin/jvm/functions/Function1;)V", "ONE_FRAME_120_HERTZ_IN_MILLISECONDS", "", "preTransform", "", "Landroidx/compose/ui/graphics/Matrix;", "other", "preTransform-JiSxe2E", "([F[F)V", "preTranslate", "x", "", "y", "tmpMatrix", "preTranslate-cG2Xzmc", "([FFF[F)V", "dot", Keys.API_PARAM_KEY_M1, SlcFlexDirection.FLEX_ROW, "", Keys.API_PARAM_KEY_M2, "column", "dot-p89u6pk", "([FI[FI)F", "containsDescendant", "", "Landroid/view/View;", "getContentCaptureSessionCompat", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidComposeView_androidKt {
    private static final long ONE_FRAME_120_HERTZ_IN_MILLISECONDS = 8;
    private static Function1<? super PlatformTextInputService, ? extends PlatformTextInputService> platformTextInputServiceInterceptor;

    static {
        platformTextInputServiceInterceptor = AndroidComposeView_androidKt$platformTextInputServiceInterceptor$1.INSTANCE;
    }

    public static final Function1<PlatformTextInputService, PlatformTextInputService> getPlatformTextInputServiceInterceptor() {
        return platformTextInputServiceInterceptor;
    }

    public static final /* synthetic */ ContentCaptureSessionCompat access$getContentCaptureSessionCompat(View r100) {
        return getContentCaptureSessionCompat(r100);
    }

    private static final ContentCaptureSessionCompat getContentCaptureSessionCompat(View r100) {
        ViewCompatShims.setImportantForContentCapture(r100, 1);
        return ViewCompatShims.getContentCaptureSession(r100);
    }

    public static final void setPlatformTextInputServiceInterceptor(Function1<? super PlatformTextInputService, ? extends PlatformTextInputService> r100) {
        platformTextInputServiceInterceptor = r100;
    }

    public static final /* synthetic */ boolean access$containsDescendant(View r100, View r101) {
        return containsDescendant(r100, r101);
    }

    /* JADX INFO: renamed from: access$preTransform-JiSxe2E, reason: not valid java name */
    public static final /* synthetic */ void m6672access$preTransformJiSxe2E(float[] r100, float[] r101) {
        m6675preTransformJiSxe2E(r100, r101);
    }

    private static final boolean containsDescendant(View r100, View r101) {
        if (Intrinsics.areEqual(r101, r100) == false) goto L5;
        return false;
    L5:
        ViewParent r102 = r101.getParent();
    L6:
        if (r102 == null) goto L11;
        if (r102 == r100) goto L8;
        r102 = r102.getParent();
        goto L6
    L8:
        return true;
    L11:
        return false;
    }

    /* JADX INFO: renamed from: preTransform-JiSxe2E, reason: not valid java name */
    private static final void m6675preTransformJiSxe2E(float[] r210, float[] r211) {
        float r100 = m6674dotp89u6pk(r211, 0, r210, 0);
        float r101 = m6674dotp89u6pk(r211, 0, r210, 1);
        float r102 = m6674dotp89u6pk(r211, 0, r210, 2);
        float r103 = m6674dotp89u6pk(r211, 0, r210, 3);
        float r110 = m6674dotp89u6pk(r211, 1, r210, 0);
        float r111 = m6674dotp89u6pk(r211, 1, r210, 1);
        float r112 = m6674dotp89u6pk(r211, 1, r210, 2);
        float r113 = m6674dotp89u6pk(r211, 1, r210, 3);
        float r114 = m6674dotp89u6pk(r211, 2, r210, 0);
        float r115 = m6674dotp89u6pk(r211, 2, r210, 1);
        float r116 = m6674dotp89u6pk(r211, 2, r210, 2);
        float r117 = m6674dotp89u6pk(r211, 2, r210, 3);
        float r118 = m6674dotp89u6pk(r211, 3, r210, 0);
        float r119 = m6674dotp89u6pk(r211, 3, r210, 1);
        float r212 = m6674dotp89u6pk(r211, 3, r210, 2);
        float r104 = m6674dotp89u6pk(r211, 3, r210, 3);
        r210[0] = r100;
        r210[1] = r101;
        r210[2] = r102;
        r210[3] = r103;
        r210[4] = r110;
        r210[5] = r111;
        r210[6] = r112;
        r210[7] = r113;
        r210[8] = r114;
        r210[9] = r115;
        r210[10] = r116;
        r210[11] = r117;
        r210[12] = r118;
        r210[13] = r119;
        r210[14] = r212;
        r210[15] = r104;
    }

    /* JADX INFO: renamed from: access$preTranslate-cG2Xzmc, reason: not valid java name */
    public static final /* synthetic */ void m6673access$preTranslatecG2Xzmc(float[] r100, float r101, float r102, float[] r103) {
        m6676preTranslatecG2Xzmc(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: dot-p89u6pk, reason: not valid java name */
    private static final float m6674dotp89u6pk(float[] r100, int r101, float[] r102, int r103) {
        int r104 = r101 * 4;
        return (((r100[r104 + 0] * r102[0 + r103]) + (r100[r104 + 1] * r102[4 + r103])) + (r100[r104 + 2] * r102[8 + r103])) + (r100[r104 + 3] * r102[12 + r103]);
    }

    /* JADX INFO: renamed from: preTranslate-cG2Xzmc, reason: not valid java name */
    private static final void m6676preTranslatecG2Xzmc(float[] r100, float r101, float r102, float[] r103) {
        Matrix.m5086resetimpl(r103);
        Matrix.m5099translateimpl$default(r103, r101, r102, 0.0f, 4, null);
        m6675preTransformJiSxe2E(r100, r103);
    }
}
