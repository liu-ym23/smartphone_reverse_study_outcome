package androidx.compose.ui.graphics;

import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/RenderEffectVerificationHelper;", "", "<init>", "()V", "createBlurEffect", "Landroid/graphics/RenderEffect;", "inputRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "createBlurEffect-8A-3gB4", "(Landroidx/compose/ui/graphics/RenderEffect;FFI)Landroid/graphics/RenderEffect;", "createOffsetEffect", "offset", "Landroidx/compose/ui/geometry/Offset;", "createOffsetEffect-Uv8p0NA", "(Landroidx/compose/ui/graphics/RenderEffect;J)Landroid/graphics/RenderEffect;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RenderEffectVerificationHelper {
    public static final RenderEffectVerificationHelper INSTANCE = null;

    static {
        INSTANCE = new RenderEffectVerificationHelper();
    }

    private RenderEffectVerificationHelper() {
    }

    /* JADX INFO: renamed from: createOffsetEffect-Uv8p0NA, reason: not valid java name */
    public final android.graphics.RenderEffect m5159createOffsetEffectUv8p0NA(RenderEffect r100, long r101) {
        if (r100 != null) goto L6;
        return android.graphics.RenderEffect.createOffsetEffect(Float.intBitsToFloat((int) (r101 >> 32)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)));
    L6:
        return android.graphics.RenderEffect.createOffsetEffect(Float.intBitsToFloat((int) (r101 >> 32)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)), r100.asAndroidRenderEffect());
    }

    /* JADX INFO: renamed from: createBlurEffect-8A-3gB4, reason: not valid java name */
    public final android.graphics.RenderEffect m5158createBlurEffect8A3gB4(RenderEffect r100, float r101, float r102, int r103) {
        boolean r104 = true;
        if (r101 != 0.0f) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == true) goto L8;
    L13:
        if (r100 != null) goto L16;
        return android.graphics.RenderEffect.createBlurEffect(r101, r102, AndroidTileMode_androidKt.m4731toAndroidTileMode0vamqd0(r103));
    L16:
        return android.graphics.RenderEffect.createBlurEffect(r101, r102, r100.asAndroidRenderEffect(), AndroidTileMode_androidKt.m4731toAndroidTileMode0vamqd0(r103));
    L8:
        if (r102 == 0.0f) goto L11;
        r104 = false;
    L11:
        if (r104 == false) goto L13;
        return android.graphics.RenderEffect.createOffsetEffect(0.0f, 0.0f);
    L5:
        r105 = false;
        goto L6
    }
}
