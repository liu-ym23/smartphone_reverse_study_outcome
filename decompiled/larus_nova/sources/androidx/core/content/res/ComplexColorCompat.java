package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Xml;
import com.facebook.keyframes.model.KFFeatureEffect;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes17.dex */
public final class ComplexColorCompat {
    private static final String LOG_TAG = "ComplexColorCompat";
    private int mColor;
    private final ColorStateList mColorStateList;
    private final Shader mShader;

    public boolean isGradient() {
        if (this.mShader == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isStateful() {
        if (this.mShader != null) goto L9;
        ColorStateList r100 = this.mColorStateList;
        if (r100 == null) goto L9;
        if (r100.isStateful() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean willDraw() {
        if (isGradient() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mColor != 0) goto L8;
        return false;
    }

    public int getColor() {
        return this.mColor;
    }

    public Shader getShader() {
        return this.mShader;
    }

    public static ComplexColorCompat from(ColorStateList r100) {
        return new ComplexColorCompat(null, r100, r100.getDefaultColor());
    }

    public boolean onStateChanged(int[] r100) {
        if (isStateful() == false) goto L7;
        ColorStateList r101 = this.mColorStateList;
        int r102 = r101.getColorForState(r100, r101.getDefaultColor());
        if (r102 == this.mColor) goto L7;
        this.mColor = r102;
        return true;
    L7:
        return false;
    }

    public void setColor(int r100) {
        this.mColor = r100;
    }

    public static ComplexColorCompat from(Shader r100) {
        return new ComplexColorCompat(r100, null, 0);
    }

    public static ComplexColorCompat from(int r100) {
        return new ComplexColorCompat(null, null, r100);
    }

    private ComplexColorCompat(Shader r100, ColorStateList r101, int r102) {
        this.mShader = r100;
        this.mColorStateList = r101;
        this.mColor = r102;
    }

    private static ComplexColorCompat createFromXml(Resources r100, int r101, Resources.Theme r102) throws IOException, XmlPullParserException {
        XmlResourceParser r103 = r100.getXml(r101);
        AttributeSet r104 = Xml.asAttributeSet(r103);
    L3:
        int r105 = r103.next();
        if (r105 == 2) goto L8;
        if (r105 != 1) goto L3;
    L8:
        if (r105 != 2) goto L20;
        String r106 = r103.getName();
        r106.getClass();
        if (r106.equals(KFFeatureEffect.GRADIENT_JSON_FIELD) == true) goto L18;
        if (r106.equals("selector") == false) goto L16;
        return from(ColorStateListInflaterCompat.createFromXmlInner(r100, r103, r104, r102));
    L16:
        throw new XmlPullParserException(r103.getPositionDescription() + ": unsupported complex color tag " + r106);
    L18:
        return from(GradientColorInflaterCompat.createFromXmlInner(r100, r103, r104, r102));
    L20:
        throw new XmlPullParserException("No start tag found");
    }

    public static ComplexColorCompat inflate(Resources r100, int r101, Resources.Theme r102) {
        return createFromXml(r100, r101, r102);
    L4:
        return null;
    }
}
