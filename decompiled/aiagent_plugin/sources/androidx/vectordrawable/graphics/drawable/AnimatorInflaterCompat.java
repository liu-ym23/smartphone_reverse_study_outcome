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
import androidx.core.graphics.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AnimatorInflaterCompat {
    private static final String TAG = "AnimatorInflater";

    private static class PathDataEvaluator implements TypeEvaluator<i.b[]> {
        private i.b[] mNodeArray;

        @Override // android.animation.TypeEvaluator
        public /* synthetic */ i.b[] evaluate(float r3, i.b[] r4, i.b[] r5) {
            return evaluate2(r3, (i.b[]) ZeusTransformUtils.preCheckCast(r4, i.b[].class, "com.obric.aiagent.plugin"), (i.b[]) ZeusTransformUtils.preCheckCast(r5, i.b[].class, "com.obric.aiagent.plugin"));
        }

        PathDataEvaluator() {
        }

        PathDataEvaluator(i.b[] r1) {
            this.mNodeArray = r1;
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public i.b[] evaluate2(float r5, i.b[] r6, i.b[] r7) {
            if (i.a(r6, r7) == false) goto L14;
            if (i.a(this.mNodeArray, r6) == true) goto L7;
            this.mNodeArray = i.a(r6);
        L7:
            int r0 = 0;
        L9:
            if (r0 >= r6.length) goto L12;
            this.mNodeArray[r0].a(r6[r0], r7[r0], r5);
            r0 = r0 + 1;
            goto L9
        L12:
            return this.mNodeArray;
        L14:
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static boolean a(int r1) {
        if (r1 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 31) goto L7;
        return true;
    }

    public static Animator a(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return AnimatorInflater.loadAnimator(r5, r4);
    L6:
        return a(r5, ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin"), r5.getTheme(), r4);
    }

    public static Animator a(Context r2, Resources r3, Resources.Theme r4, int r5) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4, r5, 1.0f);
    }

    public static Animator a(Context r3, Resources r4, Resources.Theme r5, int r6, float r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        XmlResourceParser r1 = null;
        r1 = r4.getAnimation(r6);     // Catch: Throwable -> L7 IOException -> L9 XmlPullParserException -> L12
        Animator r9 = a(r8, r4, r5, r1, r7);     // Catch: Throwable -> L7 IOException -> L9 XmlPullParserException -> L12
        if (r1 == null) goto L6;
        r1.close();
    L6:
        return r9;
    L7:
        th = move-exception;
        if (r1 == null) goto L17;
        r1.close();
    L17:
        throw th;
    L9:
        e = move-exception;
        Resources.NotFoundException r10 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(r6));     // Catch: Throwable -> L7
        r10.initCause(e);     // Catch: Throwable -> L7
        throw r10;     // Catch: Throwable -> L7
    L12:
        e = move-exception;
        Resources.NotFoundException r11 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(r6));     // Catch: Throwable -> L7
        r11.initCause(e);     // Catch: Throwable -> L7
        throw r11;     // Catch: Throwable -> L7
    }

    private static PropertyValuesHolder a(TypedArray r11, int r12, int r13, int r14, String r15) {
        TypedValue r0 = r11.peekValue(r13);
        if (r0 == null) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        int r1 = r0.type;
    L9:
        TypedValue r4 = r11.peekValue(r14);
        if (r4 == null) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        int r6 = r4.type;
    L17:
        if (r12 != 4) goto L26;
        if (r3 == true) goto L20;
    L21:
        if (r5 == true) goto L23;
    L25:
        r12 = 0;
        goto L26
    L23:
        if (a(r6) == false) goto L25;
    L24:
        r12 = 3;
        goto L26
    L20:
        if (a(r1) == true) goto L24;
    L26:
        if (r12 != 0) goto L28;
        boolean r7 = true;
    L29:
        PropertyValuesHolder r8 = null;
        if (r12 != 2) goto L46;
        String r16 = r11.getString(r13);
        String r17 = r11.getString(r14);
        i.b[] r18 = i.b(r16);
        i.b[] r19 = i.b(r17);
        if (r18 != null) goto L34;
        if (r19 != null) goto L34;
        return null;
    L34:
        if (r18 == null) goto L44;
        PathDataEvaluator r2 = new PathDataEvaluator();
        if (r19 != null) goto L38;
        PropertyValuesHolder r110 = PropertyValuesHolder.ofObject(r15, r2, new Object[]{r18});
    L95:
        return r110;
    L38:
        if (i.a(r18, r19) == false) goto L41;
        r110 = PropertyValuesHolder.ofObject(r15, r2, new Object[]{r18, r19});
        goto L95
    L41:
        throw new InflateException(" Can't morph from " + r16 + " to " + r17);
    L44:
        if (r19 != null) goto L97;
        return null;
    L97:
        return PropertyValuesHolder.ofObject(r15, new PathDataEvaluator(), new Object[]{r19});
    L46:
        if (r12 != 3) goto L48;
        ArgbEvaluator r111 = ArgbEvaluator.getInstance();
    L50:
        if (r7 == false) goto L66;
        if (r3 == false) goto L61;
        if (r1 != 5) goto L54;
        float r112 = r11.getDimension(r13, 0.0f);
    L55:
        if (r5 == false) goto L60;
        if (r6 != 5) goto L58;
        float r113 = r11.getDimension(r14, 0.0f);
    L59:
        PropertyValuesHolder r114 = PropertyValuesHolder.ofFloat(r15, new float[]{r112, r113});
    L65:
        r8 = r114;
    L90:
        if (r8 == null) goto L98;
        if (r111 == null) goto L99;
        r8.setEvaluator(r111);
        return r8;
    L99:
        return r8;
    L98:
        return r8;
    L58:
        r113 = r11.getFloat(r14, 0.0f);
        goto L59
    L60:
        r114 = PropertyValuesHolder.ofFloat(r15, new float[]{r112});
        goto L65
    L54:
        r112 = r11.getFloat(r13, 0.0f);
        goto L55
    L61:
        if (r6 != 5) goto L63;
        float r115 = r11.getDimension(r14, 0.0f);
    L64:
        r114 = PropertyValuesHolder.ofFloat(r15, new float[]{r115});
        goto L65
    L63:
        r115 = r11.getFloat(r14, 0.0f);
        goto L64
    L66:
        if (r3 == false) goto L82;
        if (r1 != 5) goto L70;
        int r116 = (int) r11.getDimension(r13, 0.0f);
    L73:
        if (r5 == false) goto L81;
        if (r6 != 5) goto L77;
        int r117 = (int) r11.getDimension(r14, 0.0f);
    L80:
        r8 = PropertyValuesHolder.ofInt(r15, new int[]{r116, r117});
        goto L90
    L77:
        if (a(r6) == false) goto L79;
        r117 = r11.getColor(r14, 0);
        goto L80
    L79:
        r117 = r11.getInt(r14, 0);
        goto L80
    L81:
        r8 = PropertyValuesHolder.ofInt(r15, new int[]{r116});
        goto L90
    L70:
        if (a(r1) == false) goto L72;
        r116 = r11.getColor(r13, 0);
        goto L73
    L72:
        r116 = r11.getInt(r13, 0);
        goto L73
    L82:
        if (r5 == false) goto L90;
        if (r6 != 5) goto L86;
        int r118 = (int) r11.getDimension(r14, 0.0f);
    L89:
        r8 = PropertyValuesHolder.ofInt(r15, new int[]{r118});
        goto L90
    L86:
        if (a(r6) == false) goto L88;
        r118 = r11.getColor(r14, 0);
        goto L89
    L88:
        r118 = r11.getInt(r14, 0);
        goto L89
    L48:
        r111 = null;
        goto L50
    L28:
        r7 = false;
        goto L29
    L15:
        r6 = 0;
        goto L17
    L12:
        r5 = false;
        goto L13
    L8:
        r1 = 0;
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    private static void a(ValueAnimator r11, TypedArray r12, TypedArray r13, float r14, XmlPullParser r15) {
        XmlPullParser r16 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r15, XmlPullParser.class, "com.obric.aiagent.plugin");
        long r2 = androidx.core.content.b.i.a(r12, r16, "duration", 1, 300);
        long r6 = androidx.core.content.b.i.a(r12, r16, "startOffset", 2, 0);
        int r0 = androidx.core.content.b.i.a(r12, r16, "valueType", 7, 4);
        if (androidx.core.content.b.i.a(r16, "valueFrom") == true) goto L5;
    L12:
        r11.setDuration(r2);
        r11.setStartDelay(r6);
        r11.setRepeatCount(androidx.core.content.b.i.a(r12, r16, "repeatCount", 3, 0));
        r11.setRepeatMode(androidx.core.content.b.i.a(r12, r16, "repeatMode", 4, 1));
        if (r13 == null) goto L16;
        a(r11, r13, r0, r14, r16);
        return;
    L16:
        return;
    L5:
        if (androidx.core.content.b.i.a(r16, "valueTo") == false) goto L12;
        if (r0 != 4) goto L9;
        r0 = a(r12, 5, 6);
    L9:
        PropertyValuesHolder r4 = a(r12, r0, 5, 6, "");
        if (r4 == null) goto L12;
        r11.setValues(new PropertyValuesHolder[]{r4});
        goto L12
    }

    private static void a(ValueAnimator r5, TypedArray r6, int r7, float r8, XmlPullParser r9) {
        XmlPullParser r10 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.aiagent.plugin");
        ObjectAnimator r11 = (ObjectAnimator) ZeusTransformUtils.preCheckCast(r5, ObjectAnimator.class, "com.obric.aiagent.plugin");
        String r0 = androidx.core.content.b.i.a(r6, r10, "pathData", 1);
        if (r0 == null) goto L13;
        String r1 = androidx.core.content.b.i.a(r6, r10, "propertyXName", 2);
        String r12 = androidx.core.content.b.i.a(r6, r10, "propertyYName", 3);
        if (r7 != 2) goto L7;
    L7:
        if (r1 != null) goto L12;
        if (r12 != null) goto L12;
        throw new InflateException(r6.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    L12:
        a(i.a(r0), r11, r8 * 0.5f, r1, r12);
        return;
    L13:
        r11.setPropertyName(androidx.core.content.b.i.a(r6, r10, "propertyName", 0));
    }

    private static void a(Path r17, ObjectAnimator r18, float r19, String r20, String r21) {
        PathMeasure r4 = new PathMeasure(r17, false);
        ArrayList r6 = new ArrayList();
        float r7 = 0.0f;
        r6.add(Float.valueOf(0.0f));
        float r8 = 0.0f;
    L3:
        r8 = r8 + r4.getLength();
        r6.add(Float.valueOf(r8));
        if (r4.nextContour() == true) goto L3;
        PathMeasure r5 = new PathMeasure(r17, false);
        int r0 = Math.min(100, ((int) (r8 / r19)) + 1);
        float[] r9 = new float[r0];
        float[] r11 = new float[r0];
        float[] r13 = new float[2];
        float r10 = r8 / (r0 - 1);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r0) goto L15;
        r5.getPosTan(r7 - ((Float) ZeusTransformUtils.preCheckCast(r6.get(r15), Float.class, "com.obric.aiagent.plugin")).floatValue(), r13, null);
        r9[r14] = r13[0];
        r11[r14] = r13[1];
        r7 = r7 + r10;
        int r12 = r15 + 1;
        if (r12 >= r6.size()) goto L12;
        int r16 = r0;
        if (r7 <= ((Float) ZeusTransformUtils.preCheckCast(r6.get(r12), Float.class, "com.obric.aiagent.plugin")).floatValue()) goto L13;
        r5.nextContour();
        r15 = r12;
    L13:
        r14 = r14 + 1;
        r0 = r16;
        goto L6
    L12:
        r16 = r0;
        goto L13
    L15:
        if (r20 == null) goto L17;
        PropertyValuesHolder r1 = PropertyValuesHolder.ofFloat(r20, r9);
    L18:
        if (r21 == null) goto L20;
        PropertyValuesHolder r110 = PropertyValuesHolder.ofFloat(r21, r11);
    L21:
        if (r1 != null) goto L24;
        r18.setValues(new PropertyValuesHolder[]{r110});
        return;
    L24:
        if (r110 != null) goto L26;
        r18.setValues(new PropertyValuesHolder[]{r1});
        return;
    L26:
        r18.setValues(new PropertyValuesHolder[]{r1, r110});
        return;
    L20:
        r110 = null;
        goto L21
    L17:
        r1 = null;
        goto L18
    }

    private static Animator a(Context r10, Resources r11, Resources.Theme r12, XmlPullParser r13, float r14) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r5 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r13, XmlPullParser.class, "com.obric.aiagent.plugin");
        return a(r2, r11, r12, r5, Xml.asAttributeSet(r5), null, 0, r14);
    }

    private static Animator a(Context r20, Resources r21, Resources.Theme r22, XmlPullParser r23, AttributeSet r24, AnimatorSet r25, int r26, float r27) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r13 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r23, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r24, AttributeSet.class, "com.obric.aiagent.plugin");
        int r15 = r13.getDepth();
        Animator r0 = null;
        ArrayList r16 = null;
    L3:
        int r1 = r13.next();
        boolean r7 = false;
        if (r1 != 3) goto L8;
        if (r13.getDepth() > r15) goto L8;
    L37:
        if (r25 == null) goto L46;
        if (r16 == null) goto L46;
        Animator[] r2 = new Animator[r16.size()];
        Iterator r3 = r16.iterator();
        int r8 = 0;
    L41:
        if (r3.hasNext() == false) goto L43;
        r2[r8] = (Animator) ZeusTransformUtils.preCheckCast(r3.next(), Animator.class, "com.obric.aiagent.plugin");
        r8 = r8 + 1;
        goto L41
    L43:
        if (r26 != 0) goto L45;
        r25.playTogether(r2);
        goto L46
    L45:
        r25.playSequentially(r2);
    L46:
        return r0;
    L8:
        if (r1 == 1) goto L37;
        if (r1 != 2) goto L3;
        String r4 = r13.getName();
        if (r4.equals("objectAnimator") == false) goto L16;
        r0 = a(r12, r21, r22, r14, r27, r13);
    L29:
        if (r25 == null) goto L3;
        if (r7 == true) goto L3;
        if (r16 != null) goto L33;
        r16 = new ArrayList();
    L33:
        ArrayList r5 = r16;
        r5.add(r0);
        r16 = r5;
        goto L3
    L16:
        if (r4.equals("animator") == false) goto L19;
        r0 = a(r12, r21, r22, r14, null, r27, r13);
        goto L29
    L19:
        if (r4.equals("set") == false) goto L22;
        AnimatorSet r6 = new AnimatorSet();
        TypedArray r9 = androidx.core.content.b.i.a(r21, r22, r14, a.h);
        a(r12, r21, r22, r13, r14, (AnimatorSet) ZeusTransformUtils.preCheckCast(r6, AnimatorSet.class, "com.obric.aiagent.plugin"), androidx.core.content.b.i.a(r9, r13, "ordering", 0, 0), r27);
        r9.recycle();
        r7 = false;
        r0 = r6;
        goto L29
    L22:
        if (r4.equals("propertyValuesHolder") == false) goto L35;
        PropertyValuesHolder[] r10 = a(r12, r21, r22, r13, Xml.asAttributeSet(r13));
        if (r10 != null) goto L26;
    L28:
        r7 = true;
        goto L29
    L26:
        if (ZeusTransformUtils.instanceOf(r0, ValueAnimator.class) == false) goto L28;
        ((ValueAnimator) ZeusTransformUtils.preCheckCast(r0, ValueAnimator.class, "com.obric.aiagent.plugin")).setValues(r10);
        goto L28
    L35:
        throw new RuntimeException("Unknown animator name: " + r13.getName());
    }

    private static PropertyValuesHolder[] a(Context r16, Resources r17, Resources.Theme r18, XmlPullParser r19, AttributeSet r20) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r8 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r19, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r20, AttributeSet.class, "com.obric.aiagent.plugin");
        ArrayList r11 = null;
    L3:
        int r2 = r8.getEventType();
        int r12 = 0;
        if (r2 == 3) goto L22;
        if (r2 == 1) goto L22;
        if (r2 != 2) goto L9;
        if (r8.getName().equals("propertyValuesHolder") == false) goto L21;
        TypedArray r7 = androidx.core.content.b.i.a(r17, r18, r9, a.i);
        String r6 = androidx.core.content.b.i.a(r7, r8, "propertyName", 3);
        int r5 = androidx.core.content.b.i.a(r7, r8, "valueType", 2, 4);
        PropertyValuesHolder r3 = a(r0, r17, r18, r8, r6, r5);
        if (r3 != null) goto L15;
        r3 = a(r7, r5, 0, 1, r6);
    L15:
        if (r3 == null) goto L19;
        if (r11 != null) goto L18;
        r11 = new ArrayList();
    L18:
        r11.add(r3);
    L19:
        r7.recycle();
    L21:
        r8.next();
        goto L3
    L9:
        r8.next();
    L22:
        if (r11 == null) goto L26;
        int r1 = r11.size();
        PropertyValuesHolder[] r10 = new PropertyValuesHolder[r1];
    L24:
        if (r12 >= r1) goto L36;
        r10[r12] = (PropertyValuesHolder) ZeusTransformUtils.preCheckCast(r11.get(r12), PropertyValuesHolder.class, "com.obric.aiagent.plugin");
        r12 = r12 + 1;
        goto L24
    L36:
        return r10;
    L26:
        return null;
    }

    private static int a(Resources r2, Resources.Theme r3, AttributeSet r4, XmlPullParser r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        XmlPullParser r7 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r5, XmlPullParser.class, "com.obric.aiagent.plugin");
        TypedArray r8 = androidx.core.content.b.i.a(r2, r3, r6, a.j);
        int r9 = 0;
        TypedValue r10 = androidx.core.content.b.i.b(r8, r7, "value", 0);
        if (r10 == null) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L8;
    L10:
        r8.recycle();
        return r9;
    L8:
        if (a(r10.type) == false) goto L10;
        r9 = 3;
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    private static int a(TypedArray r3, int r4, int r5) {
        TypedValue r6 = r3.peekValue(r4);
        boolean r0 = true;
        if (r6 == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        int r7 = r6.type;
    L9:
        TypedValue r8 = r3.peekValue(r5);
        if (r8 != null) goto L13;
        r0 = false;
    L13:
        if (r0 == false) goto L15;
        int r9 = r8.type;
    L16:
        if (r2 == true) goto L18;
    L19:
        if (r0 == true) goto L21;
        return 0;
    L21:
        if (a(r9) == false) goto L25;
    L22:
        return 3;
    L25:
        return 0;
    L18:
        if (a(r7) == true) goto L22;
    L15:
        r9 = 0;
        goto L16
    L8:
        r7 = 0;
        goto L9
    L5:
        r2 = false;
        goto L6
    }

    private static PropertyValuesHolder a(Context r10, Resources r11, Resources.Theme r12, XmlPullParser r13, String r14, int r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r17 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r13, XmlPullParser.class, "com.obric.aiagent.plugin");
        PropertyValuesHolder r0 = null;
        ArrayList r8 = null;
    L3:
        int r2 = r17.next();
        if (r2 == 3) goto L18;
        if (r2 == 1) goto L18;
        if (r17.getName().equals("keyframe") == false) goto L3;
        if (r15 != 4) goto L12;
        r15 = a(r11, r12, Xml.asAttributeSet(r17), r17);
    L12:
        Keyframe r3 = a(r16, r11, r12, Xml.asAttributeSet(r17), r15, r17);
        if (r3 == null) goto L17;
        if (r8 != null) goto L16;
        r8 = new ArrayList();
    L16:
        r8.add(r3);
    L17:
        r17.next();
    L18:
        if (r8 == null) goto L53;
        int r18 = r8.size();
        if (r18 <= 0) goto L53;
        int r19 = 0;
        Keyframe r110 = (Keyframe) ZeusTransformUtils.preCheckCast(r8.get(0), Keyframe.class, "com.obric.aiagent.plugin");
        Keyframe r111 = (Keyframe) ZeusTransformUtils.preCheckCast(r8.get(r18 - 1), Keyframe.class, "com.obric.aiagent.plugin");
        float r1 = r111.getFraction();
        if (r1 < 1.0f) goto L24;
    L27:
        float r112 = r110.getFraction();
        if (r112 != 0.0f) goto L30;
    L33:
        Keyframe[] r113 = new Keyframe[r18];
        r8.toArray(r113);
    L34:
        if (r19 >= r18) goto L50;
        Keyframe r114 = r113[r19];
        if (r114.getFraction() >= 0.0f) goto L49;
        if (r19 != 0) goto L39;
        r114.setFraction(0.0f);
        goto L49
    L39:
        int r4 = r18 - 1;
        if (r19 != r4) goto L42;
        r114.setFraction(1.0f);
        goto L49
    L42:
        int r115 = r19 + 1;
        int r5 = r19;
    L43:
        if (r115 >= r4) goto L48;
        if (r113[r115].getFraction() >= 0.0f) goto L48;
        r5 = r115;
        r115 = r115 + 1;
    L48:
        a(r113, r113[r5 + 1].getFraction() - r113[r19 - 1].getFraction(), r19, r5);
    L49:
        r19 = r19 + 1;
        goto L34
    L50:
        r0 = PropertyValuesHolder.ofKeyframe(r14, r113);
        if (r15 != 3) goto L53;
        r0.setEvaluator(ArgbEvaluator.getInstance());
        goto L53
    L30:
        if (r112 >= 0.0f) goto L32;
        r110.setFraction(0.0f);
        goto L33
    L32:
        r8.add(0, a(r110, 0.0f));
        r18 = r18 + 1;
        goto L33
    L24:
        if (r1 >= 0.0f) goto L26;
        r111.setFraction(1.0f);
        goto L27
    L26:
        r8.add(r8.size(), a(r111, 1.0f));
        r18 = r18 + 1;
    L53:
        return r0;
    }

    private static Keyframe a(Keyframe r2, float r3) {
        if (r2.getType() != Float.TYPE) goto L6;
        return Keyframe.ofFloat(r3);
    L6:
        if (r2.getType() != Integer.TYPE) goto L9;
        return Keyframe.ofInt(r3);
    L9:
        return Keyframe.ofObject(r3);
    }

    private static void a(Keyframe[] r2, float r3, int r4, int r5) {
        float r6 = r3 / ((r5 - r4) + 2);
    L3:
        if (r4 > r5) goto L5;
        r2[r4].setFraction(r2[r4 - 1].getFraction() + r6);
        r4 = r4 + 1;
        goto L3
    }

    private static Keyframe a(Context r6, Resources r7, Resources.Theme r8, AttributeSet r9, int r10, XmlPullParser r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        XmlPullParser r14 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.aiagent.plugin");
        TypedArray r15 = androidx.core.content.b.i.a(r7, r8, r13, a.j);
        float r16 = androidx.core.content.b.i.a(r15, r14, "fraction", 3, -1.0f);
        TypedValue r2 = androidx.core.content.b.i.b(r15, r14, "value", 0);
        if (r2 == null) goto L5;
        boolean r4 = true;
    L7:
        if (r10 != 4) goto L13;
        if (r4 == true) goto L10;
    L12:
        r10 = 0;
        goto L13
    L10:
        if (a(r2.type) == false) goto L12;
        r10 = 3;
    L13:
        if (r4 == false) goto L20;
        if (r10 == 0) goto L19;
        if (r10 == 1) goto L18;
        if (r10 == 3) goto L18;
        Keyframe r17 = null;
    L23:
        int r18 = androidx.core.content.b.i.c(r15, r14, "interpolator", 1, 0);
        if (r18 <= 0) goto L26;
        r17.setInterpolator(b.a(r12, r18));
    L26:
        r15.recycle();
        return r17;
    L18:
        r17 = Keyframe.ofInt(r16, androidx.core.content.b.i.a(r15, r14, "value", 0, 0));
        goto L23
    L19:
        r17 = Keyframe.ofFloat(r16, androidx.core.content.b.i.a(r15, r14, "value", 0, 0.0f));
        goto L23
    L20:
        if (r10 != 0) goto L22;
        r17 = Keyframe.ofFloat(r16);
        goto L23
    L22:
        r17 = Keyframe.ofInt(r16);
        goto L23
    L5:
        r4 = false;
        goto L7
    }

    private static ObjectAnimator a(Context r9, Resources r10, Resources.Theme r11, AttributeSet r12, float r13, XmlPullParser r14) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        XmlPullParser r8 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r14, XmlPullParser.class, "com.obric.aiagent.plugin");
        ObjectAnimator r15 = new ObjectAnimator();
        a(r2, r10, r11, r5, r15, r13, r8);
        return r15;
    }

    private static ValueAnimator a(Context r2, Resources r3, Resources.Theme r4, AttributeSet r5, ValueAnimator r6, float r7, XmlPullParser r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r8, XmlPullParser.class, "com.obric.aiagent.plugin");
        TypedArray r0 = androidx.core.content.b.i.a(r3, r4, r10, a.g);
        TypedArray r12 = androidx.core.content.b.i.a(r3, r4, r10, a.k);
        if (r6 != null) goto L5;
        r6 = new ValueAnimator();
    L5:
        a(r6, r0, r12, r7, r11);
        int r13 = androidx.core.content.b.i.c(r0, r11, "interpolator", 0, 0);
        if (r13 <= 0) goto L8;
        r6.setInterpolator(b.a(r9, r13));
    L8:
        r0.recycle();
        if (r12 == null) goto L11;
        r12.recycle();
    L11:
        return r6;
    }
}
