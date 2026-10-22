package com.alibaba.gaiax.template;

import android.graphics.Matrix;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J*\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ*\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0006\u0010\u001e\u001a\u00020\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006!"}, d2 = {"Lcom/alibaba/gaiax/template/GXMode;", "", "modeType", "", "mode", "(Ljava/lang/String;Ljava/lang/String;)V", "getMode", "()Ljava/lang/String;", "getModeType", "getCropLeftMatrix", "Landroid/graphics/Matrix;", "drawableWidth", "", "drawableHeight", "viewWidth", "viewHeight", "getCropMatrix", "getCropMatrixBottom", "getCropMatrixBottomLeft", "getCropMatrixBottomRight", "getCropMatrixRight", "getCropMatrixTop", "getCropMatrixTopLeft", "getCropMatrixTopRight", "getMatrix", "getScaleMatrix", "getScaleMatrixBottom", "getScaleMatrixLeft", "getScaleMatrixRight", "getScaleMatrixTop", "getScaleType", "Landroid/widget/ImageView$ScaleType;", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXMode {
    public static final Companion Companion = null;
    public static final String MODE_TYPE_CROP = "crop";
    public static final String MODE_TYPE_SCALE = "scale";
    private final String mode;
    private final String modeType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/template/GXMode$Companion;", "", "()V", "MODE_TYPE_CROP", "", "MODE_TYPE_SCALE", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final ImageView.ScaleType getScaleType() {
        String r100 = this.mode;
        switch(r100.hashCode()) {
            case -1687059567: goto L50;
            case -1383228885: goto L46;
            case -1364013995: goto L42;
            case -1362001767: goto L38;
            case -1024435214: goto L34;
            case -797304696: goto L30;
            case -667379492: goto L26;
            case 115029: goto L22;
            case 3317767: goto L18;
            case 108511772: goto L14;
            case 727618043: goto L10;
            case 791733223: goto L6;
            default: goto L54;
        };
    L6:
        if (r100.equals("bottom right") == false) goto L54;
        return ImageView.ScaleType.MATRIX;
    L10:
        if (r100.equals("aspectFill") == false) goto L54;
        return ImageView.ScaleType.CENTER_CROP;
    L14:
        if (r100.equals("right") == false) goto L54;
        return ImageView.ScaleType.MATRIX;
    L18:
        if (r100.equals("left") == false) goto L54;
        return ImageView.ScaleType.MATRIX;
    L22:
        if (r100.equals("top") == false) goto L54;
        return ImageView.ScaleType.MATRIX;
    L26:
        if (r100.equals("bottom left") == false) goto L54;
        return ImageView.ScaleType.MATRIX;
    L30:
        if (r100.equals("scaleToFill") == false) goto L54;
        return ImageView.ScaleType.FIT_XY;
    L34:
        if (r100.equals("top left") == false) goto L54;
        return ImageView.ScaleType.MATRIX;
    L38:
        if (r100.equals("aspectFit") == false) goto L54;
        return ImageView.ScaleType.FIT_CENTER;
    L42:
        if (r100.equals("center") == false) goto L54;
        return ImageView.ScaleType.CENTER;
    L46:
        if (r100.equals("bottom") == false) goto L54;
        return ImageView.ScaleType.MATRIX;
    L50:
        if (r100.equals("top right") == false) goto L54;
        return ImageView.ScaleType.MATRIX;
    L54:
        return ImageView.ScaleType.FIT_XY;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getModeType() {
        return this.modeType;
    }

    public GXMode(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "modeType");
        Intrinsics.checkNotNullParameter(r101, "mode");
        this.modeType = r100;
        this.mode = r101;
    }

    private final Matrix getCropLeftMatrix(int r100, int r101, int r102, int r103) {
        Matrix r104 = new Matrix();
        if (r101 <= r103) goto L5;
        float r105 = 2;
        float r106 = (r103 / r105) - (r101 / r105);
    L6:
        r104.postTranslate(0.0f, r106);
        return r104;
    L5:
        float r107 = 2;
        r106 = (r101 / r107) - (r103 / r107);
        goto L6
    }

    private final Matrix getCropMatrix(int r100, int r101, int r102, int r103) {
        String r104 = this.mode;
        switch(r104.hashCode()) {
            case -1687059567: goto L34;
            case -1383228885: goto L30;
            case -1024435214: goto L26;
            case -667379492: goto L22;
            case 115029: goto L18;
            case 3317767: goto L14;
            case 108511772: goto L10;
            case 791733223: goto L6;
            default: goto L37;
        };
    L37:
        return null;
    L6:
        if (r104.equals("bottom right") == false) goto L37;
        return getCropMatrixBottomRight(r100, r101, r102, r103);
    L10:
        if (r104.equals("right") == false) goto L37;
        return getCropMatrixRight(r100, r101, r102, r103);
    L14:
        if (r104.equals("left") == false) goto L37;
        return getCropLeftMatrix(r100, r101, r102, r103);
    L18:
        if (r104.equals("top") == false) goto L37;
        return getCropMatrixTop(r100, r101, r102, r103);
    L22:
        if (r104.equals("bottom left") == false) goto L37;
        return getCropMatrixBottomLeft(r100, r101, r102, r103);
    L26:
        if (r104.equals("top left") == false) goto L37;
        return getCropMatrixTopLeft(r100, r101, r102, r103);
    L30:
        if (r104.equals("bottom") == false) goto L37;
        return getCropMatrixBottom(r100, r101, r102, r103);
    L34:
        if (r104.equals("top right") == false) goto L37;
        return getCropMatrixTopRight(r100, r101, r102, r103);
    }

    private final Matrix getCropMatrixBottom(int r100, int r101, int r102, int r103) {
        Matrix r104 = new Matrix();
        if (r100 <= r102) goto L5;
        float r105 = 2;
        float r106 = (r100 / r105) - (r102 / r105);
    L6:
        if (r101 <= r103) goto L8;
        float r107 = r103 - r101;
    L9:
        r104.postTranslate(r106, r107);
        return r104;
    L8:
        r107 = r101 - r103;
        goto L9
    L5:
        float r108 = 2;
        r106 = (r102 / r108) - (r100 / r108);
        goto L6
    }

    private final Matrix getCropMatrixBottomLeft(int r100, int r101, int r102, int r103) {
        Matrix r104 = new Matrix();
        if (r101 <= r103) goto L5;
        float r105 = r103 - r101;
    L6:
        r104.postTranslate(0.0f, r105);
        return r104;
    L5:
        r105 = r101 - r103;
        goto L6
    }

    private final Matrix getCropMatrixBottomRight(int r100, int r101, int r102, int r103) {
        Matrix r104 = new Matrix();
        if (r100 <= r102) goto L5;
        float r105 = r100 - r102;
    L6:
        if (r101 <= r103) goto L8;
        float r106 = r103 - r101;
    L9:
        r104.postTranslate(r105, r106);
        return r104;
    L8:
        r106 = r101 - r103;
        goto L9
    L5:
        r105 = r102 - r100;
        goto L6
    }

    private final Matrix getCropMatrixRight(int r100, int r101, int r102, int r103) {
        Matrix r104 = new Matrix();
        if (r100 <= r102) goto L5;
        float r105 = r100 - r102;
    L7:
        if (r101 <= r103) goto L9;
        float r106 = 2;
        float r107 = (r103 / r106) - (r101 / r106);
    L10:
        r104.postTranslate(r105, r107);
        return r104;
    L9:
        float r108 = 2;
        r107 = (r101 / r108) - (r103 / r108);
        goto L10
    L5:
        r105 = r102 - r100;
        goto L7
    }

    private final Matrix getCropMatrixTop(int r100, int r101, int r102, int r103) {
        Matrix r104 = new Matrix();
        if (r100 <= r102) goto L5;
        float r105 = 2;
        float r106 = (r100 / r105) - (r102 / r105);
    L6:
        r104.postTranslate(r106, 0.0f);
        return r104;
    L5:
        float r107 = 2;
        r106 = (r102 / r107) - (r100 / r107);
        goto L6
    }

    private final Matrix getCropMatrixTopLeft(int r100, int r101, int r102, int r103) {
        Matrix r104 = new Matrix();
        r104.postTranslate(0.0f, 0.0f);
        return r104;
    }

    private final Matrix getCropMatrixTopRight(int r100, int r101, int r102, int r103) {
        Matrix r104 = new Matrix();
        if (r100 <= r102) goto L5;
        float r105 = r100 - r102;
    L6:
        r104.postTranslate(r105, 0.0f);
        return r104;
    L5:
        r105 = r102 - r100;
        goto L6
    }

    private final Matrix getScaleMatrix(int r100, int r101, int r102, int r103) {
        String r104 = this.mode;
        switch(r104.hashCode()) {
            case -1383228885: goto L18;
            case 115029: goto L14;
            case 3317767: goto L10;
            case 108511772: goto L6;
            default: goto L21;
        };
    L21:
        return null;
    L6:
        if (r104.equals("right") == false) goto L21;
        return getScaleMatrixRight(r100, r101, r102, r103);
    L10:
        if (r104.equals("left") == false) goto L21;
        return getScaleMatrixLeft(r100, r101, r102, r103);
    L14:
        if (r104.equals("top") == false) goto L21;
        return getScaleMatrixTop(r100, r101, r102, r103);
    L18:
        if (r104.equals("bottom") == false) goto L21;
        return getScaleMatrixBottom(r100, r101, r102, r103);
    }

    private final Matrix getScaleMatrixBottom(int r100, int r101, int r102, int r103) {
        Matrix r104 = new Matrix();
        float r105 = r100;
        float r106 = r103;
        float r107 = r101;
        float r108 = r102;
        if ((r105 * r106) < (r107 * r108)) goto L5;
        float r109 = Math.min(r108 / r105, r106 / r107);
        float r110 = r106 - (r107 * r109);
        float r111 = 0.0f;
    L6:
        r104.setScale(r109, r109);
        r104.postTranslate(r111, r110);
        return r104;
    L5:
        float r112 = r106 / r107;
        r110 = r106 - (r107 * r112);
        r111 = 0.5f * (r108 - (r105 * r112));
        r109 = r112;
        goto L6
    }

    private final Matrix getScaleMatrixLeft(int r100, int r101, int r102, int r103) {
        Matrix r104 = new Matrix();
        float r105 = r100;
        float r106 = r103;
        float r107 = r101;
        float r108 = r102;
        if ((r105 * r106) < (r107 * r108)) goto L5;
        float r109 = Math.min(r108 / r105, r106 / r107);
        float r110 = (r106 - (r107 * r109)) * 0.5f;
    L6:
        r104.setScale(r109, r109);
        r104.postTranslate(0.0f, r110);
        return r104;
    L5:
        r109 = r106 / r107;
        r110 = 0.0f;
        goto L6
    }

    private final Matrix getScaleMatrixRight(int r100, int r101, int r102, int r103) {
        Matrix r104 = new Matrix();
        float r105 = r100;
        float r106 = r103;
        float r107 = r101;
        float r108 = r102;
        if ((r105 * r106) < (r107 * r108)) goto L5;
        float r109 = Math.min(r108 / r105, r106 / r107);
        float r110 = r108 - (r105 * r109);
        float r111 = (r106 - (r107 * r109)) * 0.5f;
    L6:
        r104.setScale(r109, r109);
        r104.postTranslate(r110, r111);
        return r104;
    L5:
        r109 = r106 / r107;
        r110 = r108 - (r105 * r109);
        r111 = 0.0f;
        goto L6
    }

    private final Matrix getScaleMatrixTop(int r100, int r101, int r102, int r103) {
        Matrix r104 = new Matrix();
        float r105 = r100;
        float r106 = r103;
        float r107 = r101;
        float r108 = r102;
        if ((r105 * r106) < (r107 * r108)) goto L5;
        float r109 = Math.min(r108 / r105, r106 / r107);
        float r110 = 0.0f;
    L6:
        r104.setScale(r109, r109);
        r104.postTranslate(r110, 0.0f);
        return r104;
    L5:
        float r111 = r106 / r107;
        r110 = (r108 - (r105 * r111)) * 0.5f;
        r109 = r111;
        goto L6
    }

    public final Matrix getMatrix(int r100, int r101, int r102, int r103) {
        String r104 = this.modeType;
        if (Intrinsics.areEqual(r104, "scale") == false) goto L6;
        return getScaleMatrix(r102, r103, r100, r101);
    L6:
        if (Intrinsics.areEqual(r104, MODE_TYPE_CROP) == true) goto L11;
        return null;
    L11:
        return getCropMatrix(r102, r103, r100, r101);
    }
}
