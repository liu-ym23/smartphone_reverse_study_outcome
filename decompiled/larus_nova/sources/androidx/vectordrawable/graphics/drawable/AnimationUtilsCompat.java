package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.core.util.ObjectsCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes17.dex */
public class AnimationUtilsCompat {
    private AnimationUtilsCompat() {
    }

    private static Interpolator createInterpolatorFromXml(Context r100, XmlPullParser r101) throws XmlPullParserException, IOException {
        int r102 = r101.getDepth();
        Interpolator r103 = null;
    L3:
        int r104 = r101.next();
        byte r105 = 3;
        if (r104 != 3) goto L8;
        if (r101.getDepth() > r102) goto L8;
    L68:
        if (r103 == null) goto L71;
        return r103;
    L71:
        throw new RuntimeException("Failed to parse interpolator, no start tag found");
    L8:
        if (r104 == 1) goto L68;
        if (r104 != 2) goto L3;
        AttributeSet r106 = Xml.asAttributeSet(r101);
        String r107 = r101.getName();
        r107.getClass();
        switch(r107.hashCode()) {
            case -2140409460: goto L51;
            case -2120889007: goto L47;
            case -1248486260: goto L43;
            case -935873468: goto L40;
            case -425326737: goto L36;
            case 1192587314: goto L32;
            case 1472030440: goto L28;
            case 1962594083: goto L24;
            case 2019672672: goto L20;
            case 2038238413: goto L16;
            default: goto L14;
        };
    L14:
        r105 = -1;
    L54:
        switch(r105) {
            case 0: goto L67;
            case 1: goto L66;
            case 2: goto L65;
            case 3: goto L63;
            case 4: goto L62;
            case 5: goto L61;
            case 6: goto L60;
            case 7: goto L59;
            case 8: goto L58;
            case 9: goto L57;
            default: goto L56;
        };
    L56:
        throw new RuntimeException("Unknown interpolator name: " + r101.getName());
    L58:
        r103 = new AccelerateDecelerateInterpolator();
        goto L3
    L62:
        r103 = new BounceInterpolator();
        goto L3
    L65:
        r103 = new LinearInterpolator();
        goto L3
    L57:
        Interpolator r108 = new CycleInterpolator(r100, r106);
    L64:
        r103 = r108;
        goto L3
    L59:
        r108 = new DecelerateInterpolator(r100, r106);
        goto L64
    L60:
        r108 = new AnticipateOvershootInterpolator(r100, r106);
        goto L64
    L61:
        r108 = new OvershootInterpolator(r100, r106);
        goto L64
    L63:
        r108 = new AccelerateInterpolator(r100, r106);
        goto L64
    L66:
        r108 = new AnticipateInterpolator(r100, r106);
        goto L64
    L67:
        r108 = new PathInterpolatorCompat(r100, r106, r101);
        goto L64
    L16:
        if (r107.equals("cycleInterpolator") == false) goto L14;
        r105 = 9;
        goto L54
    L20:
        if (r107.equals("accelerateDecelerateInterpolator") == false) goto L14;
        r105 = 8;
        goto L54
    L24:
        if (r107.equals("decelerateInterpolator") == false) goto L14;
        r105 = 7;
        goto L54
    L28:
        if (r107.equals("anticipateOvershootInterpolator") == false) goto L14;
        r105 = 6;
        goto L54
    L32:
        if (r107.equals("overshootInterpolator") == false) goto L14;
        r105 = 5;
        goto L54
    L36:
        if (r107.equals("bounceInterpolator") == false) goto L14;
        r105 = 4;
        goto L54
    L40:
        if (r107.equals("accelerateInterpolator") == true) goto L54;
    L43:
        if (r107.equals("linearInterpolator") == false) goto L14;
        r105 = 2;
        goto L54
    L47:
        if (r107.equals("anticipateInterpolator") == false) goto L14;
        r105 = 1;
        goto L54
    L51:
        if (r107.equals("pathInterpolator") == false) goto L14;
        r105 = 0;
        goto L54
    }

    public static Interpolator loadInterpolator(Context r100, int r101) throws Resources.NotFoundException {
        Interpolator r102 = AnimationUtils.loadInterpolator(r100, r101);
        ObjectsCompat.requireNonNull(r102, "Failed to parse interpolator, no start tag found");
        return r102;
    }
}
