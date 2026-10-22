package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes17.dex */
public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = 0.0f;
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle;
    private float mMaximumTangent;
    private float mMinimumHorizontalAngle;
    private float mMinimumHorizontalTangent;
    private float mMinimumVerticalAngle;
    private float mMinimumVerticalTangent;

    public ArcMotion() {
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
    }

    static {
        DEFAULT_MAX_TANGENT = (float) Math.tan(Math.toRadians(35.0d));
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    private static float toTangent(float r100) {
        if (r100 < 0.0f) goto L9;
        if (r100 > 90.0f) goto L9;
        return (float) Math.tan(Math.toRadians(r100 / 2.0f));
    L9:
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public void setMaximumAngle(float r100) {
        this.mMaximumAngle = r100;
        this.mMaximumTangent = toTangent(r100);
    }

    public void setMinimumHorizontalAngle(float r100) {
        this.mMinimumHorizontalAngle = r100;
        this.mMinimumHorizontalTangent = toTangent(r100);
    }

    public void setMinimumVerticalAngle(float r100) {
        this.mMinimumVerticalAngle = r100;
        this.mMinimumVerticalTangent = toTangent(r100);
    }

    public ArcMotion(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray r102 = r100.obtainStyledAttributes(r101, Styleable.ARC_MOTION);
        XmlPullParser r103 = (XmlPullParser) r101;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(r102, r103, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(r102, r103, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(r102, r103, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        r102.recycle();
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float r110, float r111, float r112, float r113) {
        Path r100 = new Path();
        r100.moveTo(r110, r111);
        float r101 = r112 - r110;
        float r102 = r113 - r111;
        float r103 = (r101 * r101) + (r102 * r102);
        float r104 = (r110 + r112) / 2.0f;
        float r105 = (r111 + r113) / 2.0f;
        float r106 = 0.25f * r103;
        if (r111 <= r113) goto L5;
        boolean r107 = true;
    L7:
        if (Math.abs(r101) >= Math.abs(r102)) goto L13;
        float r108 = Math.abs(r103 / (r102 * 2.0f));
        if (r107 == false) goto L11;
        float r109 = r108 + r113;
        float r114 = r112;
    L12:
        float r115 = this.mMinimumVerticalTangent;
    L18:
        float r116 = (r106 * r115) * r115;
        float r117 = r104 - r114;
        float r118 = r105 - r109;
        float r119 = (r117 * r117) + (r118 * r118);
        float r120 = this.mMaximumTangent;
        float r121 = (r106 * r120) * r120;
        if (r119 < r116) goto L26;
        if (r119 <= r121) goto L24;
        r116 = r121;
        goto L26
    L24:
        r116 = 0.0f;
    L26:
        if (r116 == 0.0f) goto L28;
        float r122 = (float) Math.sqrt(r116 / r119);
        r114 = ((r114 - r104) * r122) + r104;
        r109 = r105 + (r122 * (r109 - r105));
    L28:
        r100.cubicTo((r110 + r114) / 2.0f, (r111 + r109) / 2.0f, (r114 + r112) / 2.0f, (r109 + r113) / 2.0f, r112, r113);
        return r100;
    L11:
        r109 = r108 + r111;
        r114 = r110;
        goto L12
    L13:
        float r123 = r103 / (r101 * 2.0f);
        if (r107 == false) goto L16;
        r109 = r111;
        r114 = r123 + r110;
    L17:
        r115 = this.mMinimumHorizontalTangent;
        goto L18
    L16:
        r114 = r112 - r123;
        r109 = r113;
        goto L17
    L5:
        r107 = false;
        goto L7
    }
}
