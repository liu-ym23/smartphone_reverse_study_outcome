package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import com.alibaba.gaiax.template.animation.GXPropAnimationSet;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes17.dex */
public class AnimatorInflaterCompat {
    private static final int MAX_NUM_POINTS = 100;
    private static final String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 3;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final int VALUE_TYPE_UNDEFINED = 4;

    public static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
        private PathParser.PathDataNode[] mNodeArray;

        public PathDataEvaluator() {
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public PathParser.PathDataNode[] evaluate2(float r100, PathParser.PathDataNode[] r101, PathParser.PathDataNode[] r102) {
            if (PathParser.canMorph(r101, r102) == false) goto L14;
            if (PathParser.canMorph(this.mNodeArray, r101) == true) goto L7;
            this.mNodeArray = PathParser.deepCopyNodes(r101);
        L7:
            int r103 = 0;
        L9:
            if (r103 >= r101.length) goto L12;
            this.mNodeArray[r103].interpolatePathDataNode(r101[r103], r102[r103], r100);
            r103 = r103 + 1;
            goto L9
        L12:
            return this.mNodeArray;
        L14:
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ PathParser.PathDataNode[] evaluate(float r100, PathParser.PathDataNode[] r101, PathParser.PathDataNode[] r102) {
            return evaluate2(r100, r101, r102);
        }
    }

    private static boolean isColorType(int r100) {
        if (r100 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 31) goto L7;
        return true;
    }

    private AnimatorInflaterCompat() {
    }

    private static Keyframe createNewKeyframe(Keyframe r100, float r101) {
        if (r100.getType() != Float.TYPE) goto L6;
        return Keyframe.ofFloat(r101);
    L6:
        if (r100.getType() != Integer.TYPE) goto L9;
        return Keyframe.ofInt(r101);
    L9:
        return Keyframe.ofObject(r101);
    }

    public static Animator loadAnimator(Context r100, int r101) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return AnimatorInflater.loadAnimator(r100, r101);
    L6:
        return loadAnimator(r100, r100.getResources(), r100.getTheme(), r101);
    }

    private static int inferValueTypeFromValues(TypedArray r100, int r101, int r102) {
        TypedValue r103 = r100.peekValue(r101);
        boolean r104 = true;
        if (r103 == null) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        int r106 = r103.type;
    L9:
        TypedValue r107 = r100.peekValue(r102);
        if (r107 != null) goto L13;
        r104 = false;
    L13:
        if (r104 == false) goto L15;
        int r108 = r107.type;
    L16:
        if (r105 == true) goto L18;
    L19:
        if (r104 == true) goto L21;
        return 0;
    L21:
        if (isColorType(r108) == false) goto L25;
    L22:
        return 3;
    L25:
        return 0;
    L18:
        if (isColorType(r106) == true) goto L22;
    L15:
        r108 = 0;
        goto L16
    L8:
        r106 = 0;
        goto L9
    L5:
        r105 = false;
        goto L6
    }

    private static void distributeKeyframes(Keyframe[] r100, float r101, int r102, int r103) {
        float r104 = r101 / ((r103 - r102) + 2);
    L3:
        if (r102 > r103) goto L5;
        r100[r102].setFraction(r100[r102 - 1].getFraction() + r104);
        r102 = r102 + 1;
        goto L3
    }

    private static int inferValueTypeOfKeyframe(Resources r100, Resources.Theme r101, AttributeSet r102, XmlPullParser r103) {
        TypedArray r104 = TypedArrayUtils.obtainAttributes(r100, r101, r102, AndroidResources.STYLEABLE_KEYFRAME);
        int r105 = 0;
        TypedValue r106 = TypedArrayUtils.peekNamedValue(r104, r103, "value", 0);
        if (r106 == null) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == true) goto L8;
    L10:
        r104.recycle();
        return r105;
    L8:
        if (isColorType(r106.type) == false) goto L10;
        r105 = 3;
        goto L10
    L5:
        r107 = false;
        goto L6
    }

    public static Animator loadAnimator(Context r100, Resources r101, Resources.Theme r102, int r103) throws Resources.NotFoundException {
        return loadAnimator(r100, r101, r102, r103, 1.0f);
    }

    private static Animator createAnimatorFromXml(Context r100, Resources r101, Resources.Theme r110, XmlPullParser r111, float r112) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(r100, r101, r110, r111, Xml.asAttributeSet(r111), null, 0, r112);
    }

    private static PropertyValuesHolder getPVH(TypedArray r110, int r111, int r112, int r113, String r114) {
        TypedValue r100 = r110.peekValue(r112);
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        int r102 = r100.type;
    L9:
        TypedValue r103 = r110.peekValue(r113);
        if (r103 == null) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        int r105 = r103.type;
    L17:
        if (r111 != 4) goto L26;
        if (r101 == true) goto L20;
    L21:
        if (r104 == true) goto L23;
    L25:
        r111 = 0;
        goto L26
    L23:
        if (isColorType(r105) == false) goto L25;
    L24:
        r111 = 3;
        goto L26
    L20:
        if (isColorType(r102) == true) goto L24;
    L26:
        if (r111 != 0) goto L28;
        boolean r106 = true;
    L29:
        PropertyValuesHolder r107 = null;
        if (r111 != 2) goto L46;
        String r115 = r110.getString(r112);
        String r116 = r110.getString(r113);
        PathParser.PathDataNode[] r117 = PathParser.createNodesFromPathData(r115);
        PathParser.PathDataNode[] r118 = PathParser.createNodesFromPathData(r116);
        if (r117 != null) goto L34;
        if (r118 != null) goto L34;
        return null;
    L34:
        if (r117 == null) goto L44;
        PathDataEvaluator r108 = new PathDataEvaluator();
        if (r118 != null) goto L38;
        PropertyValuesHolder r119 = PropertyValuesHolder.ofObject(r114, r108, new Object[]{r117});
    L95:
        return r119;
    L38:
        if (PathParser.canMorph(r117, r118) == false) goto L41;
        r119 = PropertyValuesHolder.ofObject(r114, r108, new Object[]{r117, r118});
        goto L95
    L41:
        throw new InflateException(" Can't morph from " + r115 + " to " + r116);
    L44:
        if (r118 != null) goto L97;
        return null;
    L97:
        return PropertyValuesHolder.ofObject(r114, new PathDataEvaluator(), new Object[]{r118});
    L46:
        if (r111 != 3) goto L48;
        ArgbEvaluator r120 = ArgbEvaluator.getInstance();
    L50:
        if (r106 == false) goto L66;
        if (r101 == false) goto L61;
        if (r102 != 5) goto L54;
        float r121 = r110.getDimension(r112, 0.0f);
    L55:
        if (r104 == false) goto L60;
        if (r105 != 5) goto L58;
        float r122 = r110.getDimension(r113, 0.0f);
    L59:
        PropertyValuesHolder r123 = PropertyValuesHolder.ofFloat(r114, new float[]{r121, r122});
    L65:
        r107 = r123;
    L90:
        if (r107 == null) goto L98;
        if (r120 == null) goto L99;
        r107.setEvaluator(r120);
        return r107;
    L99:
        return r107;
    L98:
        return r107;
    L58:
        r122 = r110.getFloat(r113, 0.0f);
        goto L59
    L60:
        r123 = PropertyValuesHolder.ofFloat(r114, new float[]{r121});
        goto L65
    L54:
        r121 = r110.getFloat(r112, 0.0f);
        goto L55
    L61:
        if (r105 != 5) goto L63;
        float r124 = r110.getDimension(r113, 0.0f);
    L64:
        r123 = PropertyValuesHolder.ofFloat(r114, new float[]{r124});
        goto L65
    L63:
        r124 = r110.getFloat(r113, 0.0f);
        goto L64
    L66:
        if (r101 == false) goto L82;
        if (r102 != 5) goto L70;
        int r125 = (int) r110.getDimension(r112, 0.0f);
    L73:
        if (r104 == false) goto L81;
        if (r105 != 5) goto L77;
        int r126 = (int) r110.getDimension(r113, 0.0f);
    L80:
        r107 = PropertyValuesHolder.ofInt(r114, new int[]{r125, r126});
        goto L90
    L77:
        if (isColorType(r105) == false) goto L79;
        r126 = r110.getColor(r113, 0);
        goto L80
    L79:
        r126 = r110.getInt(r113, 0);
        goto L80
    L81:
        r107 = PropertyValuesHolder.ofInt(r114, new int[]{r125});
        goto L90
    L70:
        if (isColorType(r102) == false) goto L72;
        r125 = r110.getColor(r112, 0);
        goto L73
    L72:
        r125 = r110.getInt(r112, 0);
        goto L73
    L82:
        if (r104 == false) goto L90;
        if (r105 != 5) goto L86;
        int r127 = (int) r110.getDimension(r113, 0.0f);
    L89:
        r107 = PropertyValuesHolder.ofInt(r114, new int[]{r127});
        goto L90
    L86:
        if (isColorType(r105) == false) goto L88;
        r127 = r110.getColor(r113, 0);
        goto L89
    L88:
        r127 = r110.getInt(r113, 0);
        goto L89
    L48:
        r120 = null;
        goto L50
    L28:
        r106 = false;
        goto L29
    L15:
        r105 = 0;
        goto L17
    L12:
        r104 = false;
        goto L13
    L8:
        r102 = 0;
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    public static Animator loadAnimator(Context r100, Resources r101, Resources.Theme r102, int r103, float r104) throws Resources.NotFoundException {
        XmlResourceParser r105 = null;
        r105 = r101.getAnimation(r103);     // Catch: Throwable -> L7 IOException -> L9 XmlPullParserException -> L12
        Animator r106 = createAnimatorFromXml(r100, r101, r102, r105, r104);     // Catch: Throwable -> L7 IOException -> L9 XmlPullParserException -> L12
        if (r105 == null) goto L6;
        r105.close();
    L6:
        return r106;
    L7:
        th = move-exception;
        if (r105 == null) goto L17;
        r105.close();
    L17:
        throw th;
    L12:
        e = move-exception;
        Resources.NotFoundException r107 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(r103));     // Catch: Throwable -> L7
        r107.initCause(e);     // Catch: Throwable -> L7
        throw r107;     // Catch: Throwable -> L7
    L9:
        e = move-exception;
        Resources.NotFoundException r108 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(r103));     // Catch: Throwable -> L7
        r108.initCause(e);     // Catch: Throwable -> L7
        throw r108;     // Catch: Throwable -> L7
    }

    private static PropertyValuesHolder[] loadValues(Context r110, Resources r111, Resources.Theme r112, XmlPullParser r210, AttributeSet r211) throws XmlPullParserException, IOException {
        PropertyValuesHolder[] r100 = null;
        ArrayList r101 = null;
    L3:
        int r102 = r210.getEventType();
        int r103 = 0;
        if (r102 == 3) goto L22;
        if (r102 == 1) goto L22;
        if (r102 != 2) goto L9;
        if (r210.getName().equals("propertyValuesHolder") == false) goto L21;
        TypedArray r113 = TypedArrayUtils.obtainAttributes(r111, r112, r211, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
        String r114 = TypedArrayUtils.getNamedString(r113, r210, "propertyName", 3);
        int r104 = TypedArrayUtils.getNamedInt(r113, r210, "valueType", 2, 4);
        PropertyValuesHolder r105 = loadPvh(r110, r111, r112, r210, r114, r104);
        if (r105 != null) goto L15;
        r105 = getPVH(r113, r104, 0, 1, r114);
    L15:
        if (r105 == null) goto L19;
        if (r101 != null) goto L18;
        r101 = new ArrayList();
    L18:
        r101.add(r105);
    L19:
        r113.recycle();
    L21:
        r210.next();
        goto L3
    L9:
        r210.next();
    L22:
        if (r101 == null) goto L26;
        int r106 = r101.size();
        r100 = new PropertyValuesHolder[r106];
    L24:
        if (r103 >= r106) goto L26;
        r100[r103] = (PropertyValuesHolder) ListProtector.get(r101, r103);
        r103 = r103 + 1;
    L26:
        return r100;
    }

    private static void parseAnimatorFromTypeArray(ValueAnimator r110, TypedArray r111, TypedArray r112, float r113, XmlPullParser r114) {
        long r100 = TypedArrayUtils.getNamedInt(r111, r114, "duration", 1, 300);
        long r101 = TypedArrayUtils.getNamedInt(r111, r114, "startOffset", 2, 0);
        int r102 = TypedArrayUtils.getNamedInt(r111, r114, "valueType", 7, 4);
        if (TypedArrayUtils.hasAttribute(r114, "valueFrom") == true) goto L5;
    L12:
        r110.setDuration(r100);
        r110.setStartDelay(r101);
        r110.setRepeatCount(TypedArrayUtils.getNamedInt(r111, r114, "repeatCount", 3, 0));
        r110.setRepeatMode(TypedArrayUtils.getNamedInt(r111, r114, "repeatMode", 4, 1));
        if (r112 == null) goto L16;
        setupObjectAnimator(r110, r112, r102, r113, r114);
        return;
    L16:
        return;
    L5:
        if (TypedArrayUtils.hasAttribute(r114, "valueTo") == false) goto L12;
        if (r102 != 4) goto L9;
        r102 = inferValueTypeFromValues(r111, 5, 6);
    L9:
        PropertyValuesHolder r103 = getPVH(r111, r102, 5, 6, "");
        if (r103 == null) goto L12;
        r110.setValues(new PropertyValuesHolder[]{r103});
        goto L12
    }

    private static void setupObjectAnimator(ValueAnimator r100, TypedArray r101, int r102, float r103, XmlPullParser r104) {
        ObjectAnimator r105 = (ObjectAnimator) r100;
        String r106 = TypedArrayUtils.getNamedString(r101, r104, "pathData", 1);
        if (r106 == null) goto L13;
        String r107 = TypedArrayUtils.getNamedString(r101, r104, "propertyXName", 2);
        String r108 = TypedArrayUtils.getNamedString(r101, r104, "propertyYName", 3);
        if (r102 != 2) goto L7;
    L7:
        if (r107 != null) goto L12;
        if (r108 != null) goto L12;
        throw new InflateException(r101.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    L12:
        setupPathMotion(PathParser.createPathFromPathData(r106), r105, r103 * 0.5f, r107, r108);
        return;
    L13:
        r105.setPropertyName(TypedArrayUtils.getNamedString(r101, r104, "propertyName", 0));
    }

    private static void setupPathMotion(Path r110, ObjectAnimator r111, float r112, String r210, String r211) {
        PathMeasure r100 = new PathMeasure(r110, false);
        ArrayList r101 = new ArrayList();
        float r102 = 0.0f;
        r101.add(Float.valueOf(0.0f));
        float r103 = 0.0f;
    L3:
        r103 = r103 + r100.getLength();
        r101.add(Float.valueOf(r103));
        if (r100.nextContour() == true) goto L3;
        PathMeasure r104 = new PathMeasure(r110, false);
        int r105 = Math.min(100, ((int) (r103 / r112)) + 1);
        float[] r113 = new float[r105];
        float[] r114 = new float[r105];
        float[] r115 = new float[2];
        float r106 = r103 / (r105 - 1);
        int r116 = 0;
        int r117 = 0;
    L6:
        PropertyValuesHolder r118 = null;
        if (r116 >= r105) goto L14;
        r104.getPosTan(r102 - ((Float) ListProtector.get(r101, r117)).floatValue(), r115, null);
        r113[r116] = r115[0];
        r114[r116] = r115[1];
        r102 = r102 + r106;
        int r107 = r117 + 1;
        if (r107 >= r101.size()) goto L13;
        if (r102 <= ((Float) ListProtector.get(r101, r107)).floatValue()) goto L13;
        r104.nextContour();
        r117 = r107;
    L13:
        r116 = r116 + 1;
        goto L6
    L14:
        if (r210 == null) goto L16;
        PropertyValuesHolder r108 = PropertyValuesHolder.ofFloat(r210, r113);
    L17:
        if (r211 == null) goto L19;
        r118 = PropertyValuesHolder.ofFloat(r211, r114);
    L19:
        if (r108 != null) goto L22;
        r111.setValues(new PropertyValuesHolder[]{r118});
        return;
    L22:
        if (r118 != null) goto L24;
        r111.setValues(new PropertyValuesHolder[]{r108});
        return;
    L24:
        r111.setValues(new PropertyValuesHolder[]{r108, r118});
        return;
    L16:
        r108 = null;
        goto L17
    }

    private static Keyframe loadKeyframe(Context r100, Resources r101, Resources.Theme r102, AttributeSet r103, int r110, XmlPullParser r111) throws XmlPullParserException, IOException {
        TypedArray r104 = TypedArrayUtils.obtainAttributes(r101, r102, r103, AndroidResources.STYLEABLE_KEYFRAME);
        float r105 = TypedArrayUtils.getNamedFloat(r104, r111, "fraction", 3, -1.0f);
        TypedValue r106 = TypedArrayUtils.peekNamedValue(r104, r111, "value", 0);
        if (r106 == null) goto L5;
        boolean r107 = true;
    L7:
        if (r110 != 4) goto L13;
        if (r107 == true) goto L10;
    L12:
        r110 = 0;
        goto L13
    L10:
        if (isColorType(r106.type) == false) goto L12;
        r110 = 3;
    L13:
        if (r107 == false) goto L20;
        if (r110 == 0) goto L19;
        if (r110 == 1) goto L18;
        if (r110 == 3) goto L18;
        Keyframe r108 = null;
    L23:
        int r109 = TypedArrayUtils.getNamedResourceId(r104, r111, "interpolator", 1, 0);
        if (r109 <= 0) goto L26;
        r108.setInterpolator(AnimationUtilsCompat.loadInterpolator(r100, r109));
    L26:
        r104.recycle();
        return r108;
    L18:
        r108 = Keyframe.ofInt(r105, TypedArrayUtils.getNamedInt(r104, r111, "value", 0, 0));
        goto L23
    L19:
        r108 = Keyframe.ofFloat(r105, TypedArrayUtils.getNamedFloat(r104, r111, "value", 0, 0.0f));
        goto L23
    L20:
        if (r110 != 0) goto L22;
        r108 = Keyframe.ofFloat(r105);
        goto L23
    L22:
        r108 = Keyframe.ofInt(r105);
        goto L23
    L5:
        r107 = false;
        goto L7
    }

    private static ObjectAnimator loadObjectAnimator(Context r100, Resources r101, Resources.Theme r110, AttributeSet r111, float r112, XmlPullParser r113) throws Resources.NotFoundException {
        ObjectAnimator r102 = new ObjectAnimator();
        loadAnimator(r100, r101, r110, r111, r102, r112, r113);
        return r102;
    }

    private static PropertyValuesHolder loadPvh(Context r100, Resources r110, Resources.Theme r111, XmlPullParser r112, String r113, int r114) throws XmlPullParserException, IOException {
        PropertyValuesHolder r101 = null;
        ArrayList r102 = null;
    L3:
        int r103 = r112.next();
        if (r103 == 3) goto L18;
        if (r103 == 1) goto L18;
        if (r112.getName().equals("keyframe") == false) goto L3;
        if (r114 != 4) goto L12;
        r114 = inferValueTypeOfKeyframe(r110, r111, Xml.asAttributeSet(r112), r112);
    L12:
        Keyframe r104 = loadKeyframe(r100, r110, r111, Xml.asAttributeSet(r112), r114, r112);
        if (r104 == null) goto L17;
        if (r102 != null) goto L16;
        r102 = new ArrayList();
    L16:
        r102.add(r104);
    L17:
        r112.next();
    L18:
        if (r102 == null) goto L53;
        int r105 = r102.size();
        if (r105 <= 0) goto L53;
        int r115 = 0;
        Keyframe r116 = (Keyframe) ListProtector.get(r102, 0);
        Keyframe r117 = (Keyframe) ListProtector.get(r102, r105 - 1);
        float r106 = r117.getFraction();
        if (r106 < 1.0f) goto L24;
    L27:
        float r118 = r116.getFraction();
        if (r118 != 0.0f) goto L30;
    L33:
        Keyframe[] r119 = new Keyframe[r105];
        r102.toArray(r119);
    L34:
        if (r115 >= r105) goto L50;
        Keyframe r120 = r119[r115];
        if (r120.getFraction() >= 0.0f) goto L49;
        if (r115 != 0) goto L39;
        r120.setFraction(0.0f);
        goto L49
    L39:
        int r107 = r105 - 1;
        if (r115 != r107) goto L42;
        r120.setFraction(1.0f);
        goto L49
    L42:
        int r121 = r115 + 1;
        int r108 = r115;
    L43:
        if (r121 >= r107) goto L48;
        if (r119[r121].getFraction() >= 0.0f) goto L48;
        r108 = r121;
        r121 = r121 + 1;
    L48:
        distributeKeyframes(r119, r119[r108 + 1].getFraction() - r119[r115 - 1].getFraction(), r115, r108);
    L49:
        r115 = r115 + 1;
        goto L34
    L50:
        r101 = PropertyValuesHolder.ofKeyframe(r113, r119);
        if (r114 != 3) goto L53;
        r101.setEvaluator(ArgbEvaluator.getInstance());
        goto L53
    L30:
        if (r118 >= 0.0f) goto L32;
        r116.setFraction(0.0f);
        goto L33
    L32:
        ListProtector.add(r102, 0, createNewKeyframe(r116, 0.0f));
        r105 = r105 + 1;
        goto L33
    L24:
        if (r106 >= 0.0f) goto L26;
        r117.setFraction(1.0f);
        goto L27
    L26:
        ListProtector.add(r102, r102.size(), createNewKeyframe(r117, 1.0f));
        r105 = r105 + 1;
    L53:
        return r101;
    }

    private static ValueAnimator loadAnimator(Context r100, Resources r101, Resources.Theme r102, AttributeSet r103, ValueAnimator r104, float r105, XmlPullParser r106) throws Resources.NotFoundException {
        TypedArray r107 = TypedArrayUtils.obtainAttributes(r101, r102, r103, AndroidResources.STYLEABLE_ANIMATOR);
        TypedArray r108 = TypedArrayUtils.obtainAttributes(r101, r102, r103, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        if (r104 != null) goto L5;
        r104 = new ValueAnimator();
    L5:
        parseAnimatorFromTypeArray(r104, r107, r108, r105, r106);
        int r109 = TypedArrayUtils.getNamedResourceId(r107, r106, "interpolator", 0, 0);
        if (r109 <= 0) goto L8;
        r104.setInterpolator(AnimationUtilsCompat.loadInterpolator(r100, r109));
    L8:
        r107.recycle();
        if (r108 == null) goto L11;
        r108.recycle();
    L11:
        return r104;
    }

    private static Animator createAnimatorFromXml(Context r110, Resources r111, Resources.Theme r210, XmlPullParser r211, AttributeSet r212, AnimatorSet r213, int r214, float r215) throws XmlPullParserException, IOException {
        int r112 = r211.getDepth();
        Animator r100 = null;
        ArrayList r113 = null;
    L3:
        int r101 = r211.next();
        int r114 = 0;
        if (r101 != 3) goto L8;
        if (r211.getDepth() > r112) goto L8;
    L37:
        if (r213 == null) goto L46;
        if (r113 == null) goto L46;
        Animator[] r102 = new Animator[r113.size()];
        Iterator r103 = r113.iterator();
    L41:
        if (r103.hasNext() == false) goto L43;
        r102[r114] = (Animator) r103.next();
        r114 = r114 + 1;
        goto L41
    L43:
        if (r214 != 0) goto L45;
        r213.playTogether(r102);
        goto L46
    L45:
        r213.playSequentially(r102);
    L46:
        return r100;
    L8:
        if (r101 == 1) goto L37;
        if (r101 != 2) goto L3;
        String r104 = r211.getName();
        if (r104.equals("objectAnimator") == false) goto L17;
        r100 = loadObjectAnimator(r110, r111, r210, r212, r215, r211);
    L30:
        if (r213 == null) goto L3;
        if (r114 != 0) goto L3;
        if (r113 != null) goto L34;
        r113 = new ArrayList();
    L34:
        r113.add(r100);
        goto L3
    L17:
        if (r104.equals("animator") == false) goto L20;
        r100 = loadAnimator(r110, r111, r210, r212, null, r215, r211);
        goto L30
    L20:
        if (r104.equals("set") == false) goto L23;
        AnimatorSet r115 = new AnimatorSet();
        TypedArray r105 = TypedArrayUtils.obtainAttributes(r111, r210, r212, AndroidResources.STYLEABLE_ANIMATOR_SET);
        createAnimatorFromXml(r110, r111, r210, r211, r212, r115, TypedArrayUtils.getNamedInt(r105, r211, GXPropAnimationSet.GXPropOrderingType.KEY_ORDERING, 0, 0), r215);
        r105.recycle();
        r100 = r115;
        goto L30
    L23:
        if (r104.equals("propertyValuesHolder") == false) goto L36;
        PropertyValuesHolder[] r106 = loadValues(r110, r111, r210, r211, Xml.asAttributeSet(r211));
        if (r106 != null) goto L27;
    L29:
        r114 = 1;
        goto L30
    L27:
        if ((r100 instanceof ValueAnimator) == false) goto L29;
        ((ValueAnimator) r100).setValues(r106);
        goto L29
    L36:
        throw new RuntimeException("Unknown animator name: " + r211.getName());
    }
}
