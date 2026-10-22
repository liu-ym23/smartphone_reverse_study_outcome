package com.stepos.motionkit.fx.material.backend;

import B7.a;
import C7.r;
import D6.m;
import D7.p;
import I4.l;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.autofill.HintConstants;
import androidx.compose.ui.text.d;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepos.view.effects.StepOSBackdropLayer;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003CDEB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0014J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJG\u0010#\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001d2\u0010\u0010!\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u001f2\u0016\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001f\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u0004\u0018\u00010,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u00010,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010.R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R4\u00105\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010,03j\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010,`48\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001b\u00107\u001a\u0006\u0012\u0002\b\u00030 8\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010;\u001a\u0006\u0012\u0002\b\u00030 8\u0006¢\u0006\f\n\u0004\b;\u00108\u001a\u0004\b<\u0010:R\u001b\u0010=\u001a\u0006\u0012\u0002\b\u00030 8\u0006¢\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010:R\u0014\u0010A\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0011\u0010B\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bB\u0010@¨\u0006F"}, d2 = {"Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/View;", "view", "Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Holder;", "h", "LC7/r;", "releaseHolder", "(Landroid/view/View;Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Holder;)V", "create", "(Landroid/view/View;)Ljava/lang/Object;", "createByReflection", "Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;", "acquire", "(Landroid/view/View;)Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;", "", "px", "setCornerRadius", "(Landroid/view/View;F)V", "v", "setCornerSmoothness", "host", "Landroid/graphics/drawable/Drawable;", "createRawDrawable$motionkit_fx_release", "(Landroid/view/View;)Landroid/graphics/drawable/Drawable;", "createRawDrawable", "drawable", "", HintConstants.AUTOFILL_HINT_NAME, "", "Ljava/lang/Class;", "types", "args", "call", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)V", "TAG", "Ljava/lang/String;", "CLASS_NAME", "SDK_CLASS", "", "sdkAvailable", "Z", "Ljava/lang/reflect/Method;", "getViewRootImpl", "Ljava/lang/reflect/Method;", "createMethod", "Ljava/util/WeakHashMap;", "holders", "Ljava/util/WeakHashMap;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "methodCache", "Ljava/util/HashMap;", "I", "Ljava/lang/Class;", "getI", "()Ljava/lang/Class;", "F", "getF", "B", "getB", "getReflectAvailable", "()Z", "reflectAvailable", "isAvailable", "Token", "Holder", "Api", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CrossWindowMaterialBackend {
    private static final Class<?> B;
    private static final String CLASS_NAME = "com.android.internal.graphics.backdrop.BackdropLayerDrawable";
    private static final Class<?> F;
    private static final Class<?> I;
    public static final CrossWindowMaterialBackend INSTANCE = new CrossWindowMaterialBackend();
    private static final String SDK_CLASS = "stepos.view.effects.StepOSBackdropLayer";
    private static final String TAG = "MotionKitCrossWindowMaterial";
    private static final Method createMethod;
    private static final Method getViewRootImpl;
    private static final WeakHashMap<View, Holder> holders;
    private static final HashMap<String, Method> methodCache;
    private static final boolean sdkAvailable;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006J-\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\r¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Api;", "", AppAgent.CONSTRUCT, "()V", "create", "view", "Landroid/view/View;", "dispatch", "", "drawable", HintConstants.AUTOFILL_HINT_NAME, "", "args", "", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Z", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Api {
        public static final Api INSTANCE = new Api();

        private Api() {
        }

        public final Object create(View view) {
            k.f(view, "view");
            return StepOSBackdropLayer.createBackdropLayerDrawable(view);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final boolean dispatch(Object drawable, String name, Object[] args) {
            k.f(drawable, "drawable");
            k.f(name, "name");
            k.f(args, "args");
            Drawable drawable2 = drawable instanceof Drawable ? (Drawable) drawable : null;
            if (drawable2 == null) {
                return false;
            }
            try {
                switch (name.hashCode()) {
                    case -2070385286:
                        if (name.equals("setLightDirs")) {
                            Object obj = args[0];
                            k.d(obj, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue = ((Float) obj).floatValue();
                            Object obj2 = args[1];
                            k.d(obj2, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue2 = ((Float) obj2).floatValue();
                            Object obj3 = args[2];
                            k.d(obj3, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue3 = ((Float) obj3).floatValue();
                            Object obj4 = args[3];
                            k.d(obj4, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setLightDirs(drawable2, fFloatValue, fFloatValue2, fFloatValue3, ((Float) obj4).floatValue());
                            break;
                        }
                        break;
                    case -1960043633:
                        if (!name.equals("setEdgeColors")) {
                            break;
                        } else {
                            Object obj5 = args[0];
                            k.d(obj5, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue = ((Integer) obj5).intValue();
                            Object obj6 = args[1];
                            k.d(obj6, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setEdgeColors(drawable2, iIntValue, ((Integer) obj6).intValue());
                            break;
                        }
                    case -1835830646:
                        if (!name.equals("setBlendArray")) {
                            break;
                        } else {
                            Object obj7 = args[0];
                            k.d(obj7, "null cannot be cast to non-null type kotlin.IntArray");
                            Object obj8 = args[1];
                            k.d(obj8, "null cannot be cast to non-null type kotlin.IntArray");
                            StepOSBackdropLayer.setBlendArray(drawable2, (int[]) obj7, (int[]) obj8);
                            break;
                        }
                    case -1762158830:
                        if (!name.equals("setGlassStroke")) {
                            break;
                        } else {
                            Object obj9 = args[0];
                            k.d(obj9, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj9).booleanValue();
                            Object obj10 = args[1];
                            k.d(obj10, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue4 = ((Float) obj10).floatValue();
                            Object obj11 = args[2];
                            k.d(obj11, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue5 = ((Float) obj11).floatValue();
                            Object obj12 = args[3];
                            k.d(obj12, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue6 = ((Float) obj12).floatValue();
                            Object obj13 = args[4];
                            k.d(obj13, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setGlassStroke(drawable2, zBooleanValue, fFloatValue4, fFloatValue5, fFloatValue6, ((Integer) obj13).intValue());
                            break;
                        }
                    case -1405168505:
                        if (!name.equals("setGlassText")) {
                            break;
                        } else {
                            Object obj14 = args[0];
                            k.d(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue2 = ((Boolean) obj14).booleanValue();
                            Object obj15 = args[1];
                            k.d(obj15, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue7 = ((Float) obj15).floatValue();
                            Object obj16 = args[2];
                            k.d(obj16, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setGlassText(drawable2, zBooleanValue2, fFloatValue7, ((Float) obj16).floatValue());
                            break;
                        }
                    case -1360553359:
                        if (!name.equals("setColorGradient")) {
                            break;
                        } else {
                            Object obj17 = args[0];
                            k.d(obj17, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue2 = ((Integer) obj17).intValue();
                            Object obj18 = args[1];
                            k.d(obj18, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue3 = ((Integer) obj18).intValue();
                            Object obj19 = args[2];
                            k.d(obj19, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue4 = ((Integer) obj19).intValue();
                            Object obj20 = args[3];
                            k.d(obj20, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue8 = ((Float) obj20).floatValue();
                            Object obj21 = args[4];
                            k.d(obj21, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setColorGradient(drawable2, iIntValue2, iIntValue3, iIntValue4, fFloatValue8, ((Integer) obj21).intValue());
                            break;
                        }
                    case -1174108983:
                        if (!name.equals("setCornerRadius")) {
                            break;
                        } else if (args.length != 1) {
                            Object obj22 = args[0];
                            k.d(obj22, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue9 = ((Float) obj22).floatValue();
                            Object obj23 = args[1];
                            k.d(obj23, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue10 = ((Float) obj23).floatValue();
                            Object obj24 = args[2];
                            k.d(obj24, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue11 = ((Float) obj24).floatValue();
                            Object obj25 = args[3];
                            k.d(obj25, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setCornerRadius(drawable2, fFloatValue9, fFloatValue10, fFloatValue11, ((Float) obj25).floatValue());
                            break;
                        } else {
                            Object obj26 = args[0];
                            k.d(obj26, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setCornerRadius(drawable2, ((Float) obj26).floatValue());
                            break;
                        }
                    case -951818789:
                        if (name.equals("setBlurRadius")) {
                            Object obj27 = args[0];
                            k.d(obj27, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setBlurRadius(drawable2, ((Integer) obj27).intValue());
                            break;
                        }
                        break;
                    case -623010042:
                        if (!name.equals("setDispersion")) {
                            break;
                        } else {
                            Object obj28 = args[0];
                            k.d(obj28, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setDispersion(drawable2, ((Float) obj28).floatValue());
                            break;
                        }
                    case -320423506:
                        if (!name.equals("setDarkWidth")) {
                            break;
                        } else {
                            Object obj29 = args[0];
                            k.d(obj29, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setDarkWidth(drawable2, ((Float) obj29).floatValue());
                            break;
                        }
                    case 10984892:
                        if (!name.equals("setCornerSmoothness")) {
                            break;
                        } else {
                            Object obj30 = args[0];
                            k.d(obj30, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setCornerSmoothness(drawable2, ((Float) obj30).floatValue());
                            break;
                        }
                    case 25621303:
                        if (!name.equals("setRefraction")) {
                            break;
                        } else {
                            Object obj31 = args[0];
                            k.d(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue3 = ((Boolean) obj31).booleanValue();
                            Object obj32 = args[1];
                            k.d(obj32, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue12 = ((Float) obj32).floatValue();
                            Object obj33 = args[2];
                            k.d(obj33, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setRefraction(drawable2, zBooleanValue3, fFloatValue12, ((Float) obj33).floatValue());
                            break;
                        }
                    case 228676044:
                        if (!name.equals("setRefractionDepth")) {
                            break;
                        } else {
                            Object obj34 = args[0];
                            k.d(obj34, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setRefractionDepth(drawable2, ((Float) obj34).floatValue());
                            break;
                        }
                    case 250921529:
                        if (!name.equals("setBlurGradient")) {
                            break;
                        } else {
                            Object obj35 = args[0];
                            k.d(obj35, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue5 = ((Integer) obj35).intValue();
                            Object obj36 = args[1];
                            k.d(obj36, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setBlurGradient(drawable2, iIntValue5, ((Integer) obj36).intValue());
                            break;
                        }
                    case 1200042816:
                        if (!name.equals("setAnisoRim")) {
                            break;
                        } else {
                            Object obj37 = args[0];
                            k.d(obj37, "null cannot be cast to non-null type kotlin.Boolean");
                            StepOSBackdropLayer.setAnisoRim(drawable2, ((Boolean) obj37).booleanValue());
                            break;
                        }
                    case 1290130772:
                        if (!name.equals("setInnerShadow")) {
                            break;
                        } else {
                            Object obj38 = args[0];
                            k.d(obj38, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue4 = ((Boolean) obj38).booleanValue();
                            Object obj39 = args[1];
                            k.d(obj39, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue6 = ((Integer) obj39).intValue();
                            Object obj40 = args[2];
                            k.d(obj40, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue13 = ((Float) obj40).floatValue();
                            Object obj41 = args[3];
                            k.d(obj41, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue14 = ((Float) obj41).floatValue();
                            Object obj42 = args[4];
                            k.d(obj42, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue15 = ((Float) obj42).floatValue();
                            Object obj43 = args[5];
                            k.d(obj43, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setInnerShadow(drawable2, zBooleanValue4, iIntValue6, fFloatValue13, fFloatValue14, fFloatValue15, ((Float) obj43).floatValue());
                            break;
                        }
                    case 1389555745:
                        if (!name.equals("setColor")) {
                            break;
                        } else {
                            Object obj44 = args[0];
                            k.d(obj44, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setColor(drawable2, ((Integer) obj44).intValue());
                            break;
                        }
                    case 1390471317:
                        if (!name.equals("setDodge")) {
                            break;
                        } else {
                            Object obj45 = args[0];
                            k.d(obj45, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setDodge(drawable2, ((Float) obj45).floatValue());
                            break;
                        }
                    case 1392418690:
                        if (!name.equals("setFrost")) {
                            break;
                        } else {
                            Object obj46 = args[0];
                            k.d(obj46, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setFrost(drawable2, ((Float) obj46).floatValue());
                            break;
                        }
                    case 1756172231:
                        if (!name.equals("setEdgeWidth")) {
                            break;
                        } else {
                            Object obj47 = args[0];
                            k.d(obj47, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setEdgeWidth(drawable2, ((Float) obj47).floatValue());
                            break;
                        }
                    case 1882377614:
                        if (!name.equals("setOverlay")) {
                            break;
                        } else {
                            Object obj48 = args[0];
                            k.d(obj48, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setOverlay(drawable2, ((Float) obj48).floatValue());
                            break;
                        }
                    case 1946113869:
                        if (!name.equals("setStrokeSpread")) {
                            break;
                        } else {
                            Object obj49 = args[0];
                            k.d(obj49, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setStrokeSpread(drawable2, ((Float) obj49).floatValue());
                            break;
                        }
                    case 2081520598:
                        if (!name.equals("setAmbient")) {
                            break;
                        } else {
                            Object obj50 = args[0];
                            k.d(obj50, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setAmbient(drawable2, ((Float) obj50).floatValue());
                            break;
                        }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Throwable cause = th2.getCause();
                if (cause != null) {
                    th2 = cause;
                }
                String simpleName = th2.getClass().getSimpleName();
                String message = th2.getMessage();
                StringBuilder sbW = a.w("StepOSBackdropLayer.", name, " 失败，回退反射: ", simpleName, ": ");
                sbW.append(message);
                Log.w(CrossWindowMaterialBackend.TAG, sbW.toString());
                return false;
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\bR\"\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00020\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR&\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u000b0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0011\u0010)\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Holder;", "", "Landroid/view/View;", "view", AppAgent.CONSTRUCT, "(Landroid/view/View;)V", "LC7/r;", "defer", "()V", "start", "ensureStarted", "Lkotlin/Function1;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "config", "(LS7/k;)V", "stop", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "viewRef", "Ljava/lang/ref/WeakReference;", "", "refCount", "I", "getRefCount", "()I", "setRefCount", "(I)V", "drawable", "Ljava/lang/Object;", "Landroid/graphics/drawable/Drawable;", "prevBackground", "Landroid/graphics/drawable/Drawable;", "LD7/p;", "queued", "LD7/p;", "Landroid/view/View$OnAttachStateChangeListener;", "attachListener", "Landroid/view/View$OnAttachStateChangeListener;", "", "getHasDrawable", "()Z", "hasDrawable", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Holder {
        private View.OnAttachStateChangeListener attachListener;
        private Object drawable;
        private Drawable prevBackground;
        private final p queued;
        private int refCount;
        private final WeakReference<View> viewRef;

        public Holder(View view) {
            k.f(view, "view");
            this.viewRef = new WeakReference<>(view);
            this.queued = new p();
        }

        private final void defer() {
            View view;
            if (this.attachListener == null && (view = this.viewRef.get()) != null) {
                View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.stepos.motionkit.fx.material.backend.CrossWindowMaterialBackend$Holder$defer$l$1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View v10) {
                        k.f(v10, "v");
                        v10.removeOnAttachStateChangeListener(this);
                        this.this$0.attachListener = null;
                        this.this$0.start();
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View v10) {
                        k.f(v10, "v");
                    }
                };
                this.attachListener = onAttachStateChangeListener;
                view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void start() {
            Object objCreate;
            View view = this.viewRef.get();
            if (view == null || (objCreate = CrossWindowMaterialBackend.INSTANCE.create(view)) == null) {
                return;
            }
            this.drawable = objCreate;
            this.prevBackground = view.getBackground();
            view.setBackground((Drawable) objCreate);
            while (!this.queued.isEmpty()) {
                ((S7.k) this.queued.removeFirst()).invoke(objCreate);
            }
        }

        public final void config(S7.k action) {
            k.f(action, "action");
            Object obj = this.drawable;
            if (obj != null) {
                action.invoke(obj);
            } else {
                this.queued.addLast(action);
            }
        }

        public final void ensureStarted() {
            View view;
            if (this.drawable == null && (view = this.viewRef.get()) != null) {
                if (view.isAttachedToWindow()) {
                    start();
                } else {
                    defer();
                }
            }
        }

        public final boolean getHasDrawable() {
            return this.drawable != null;
        }

        public final int getRefCount() {
            return this.refCount;
        }

        public final void setRefCount(int i) {
            this.refCount = i;
        }

        public final void stop() {
            View view = this.viewRef.get();
            View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachListener;
            if (onAttachStateChangeListener != null && view != null) {
                view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            this.attachListener = null;
            Object obj = this.drawable;
            if (obj != null && view != null && view.getBackground() == obj) {
                view.setBackground(this.prevBackground);
            }
            this.drawable = null;
            this.prevBackground = null;
            this.queued.clear();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u000b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\u00020\t2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000e\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\"\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00020\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;", "", "Landroid/view/View;", "view", "Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Holder;", "h", AppAgent.CONSTRUCT, "(Landroid/view/View;Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Holder;)V", "Lkotlin/Function1;", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "config", "(LS7/k;)V", "reset", "release", "Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Holder;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "viewRef", "Ljava/lang/ref/WeakReference;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Token {
        private final Holder h;
        private final WeakReference<View> viewRef;

        public Token(View view, Holder h) {
            k.f(view, "view");
            k.f(h, "h");
            this.h = h;
            this.viewRef = new WeakReference<>(view);
        }

        public static /* synthetic */ void release$default(Token token, S7.k kVar, int i, Object obj) {
            if ((i & 1) != 0) {
                kVar = new d(26);
            }
            token.release(kVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r release$lambda$0(Object it) {
            k.f(it, "it");
            return r.f317a;
        }

        public final void config(S7.k action) {
            k.f(action, "action");
            this.h.config(action);
        }

        public final void release(S7.k reset) {
            k.f(reset, "reset");
            this.h.config(reset);
            View view = this.viewRef.get();
            if (view == null) {
                return;
            }
            CrossWindowMaterialBackend.INSTANCE.releaseHolder(view, this.h);
        }
    }

    static {
        boolean z10;
        Method method;
        try {
            Class.forName(SDK_CLASS);
            z10 = true;
        } catch (Throwable th) {
            Log.i(TAG, "StepOSBackdropLayer 不可用，将尝试反射 createBackdropLayerDrawable: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            z10 = false;
        }
        sdkAvailable = z10;
        Method method2 = null;
        try {
            method = View.class.getMethod("getViewRootImpl", null);
            method.setAccessible(true);
        } catch (Throwable unused) {
            method = null;
        }
        getViewRootImpl = method;
        try {
            Method method3 = Class.forName("android.view.ViewRootImpl").getMethod("createBackdropLayerDrawable", null);
            method3.setAccessible(true);
            method2 = method3;
        } catch (Throwable th2) {
            Log.e(TAG, "createBackdropLayerDrawable unavailable: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
        }
        createMethod = method2;
        holders = new WeakHashMap<>();
        methodCache = new HashMap<>();
        Class<?> cls = Integer.TYPE;
        k.c(cls);
        I = cls;
        Class<?> cls2 = Float.TYPE;
        k.c(cls2);
        F = cls2;
        Class<?> cls3 = Boolean.TYPE;
        k.c(cls3);
        B = cls3;
    }

    private CrossWindowMaterialBackend() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object create(View view) {
        if (sdkAvailable) {
            try {
                return Api.INSTANCE.create(view);
            } catch (Throwable th) {
                th = th;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                androidx.constraintlayout.core.dsl.a.x("StepOSBackdropLayer.create 失败，回退反射: ", th.getClass().getSimpleName(), ": ", th.getMessage(), TAG);
            }
        }
        return this.createByReflection(view);
    }

    private final Object createByReflection(View view) {
        Method method;
        Method method2 = getViewRootImpl;
        if (method2 == null || (method = createMethod) == null) {
            return null;
        }
        try {
            Object objInvoke = method2.invoke(view, null);
            if (objInvoke != null) {
                return method.invoke(objInvoke, null);
            }
            Log.e(TAG, "ViewRootImpl is null (View not attached)");
            return null;
        } catch (Throwable th) {
            th = th;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.e(TAG, "createBackdropLayerDrawable failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            return null;
        }
    }

    private final boolean getReflectAvailable() {
        return (getViewRootImpl == null || createMethod == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void releaseHolder(View view, Holder h) {
        try {
            h.setRefCount(h.getRefCount() - 1);
            if (h.getRefCount() <= 0) {
                if (view.isAttachedToWindow()) {
                    view.post(new l(view, 12, h));
                } else {
                    h.stop();
                    holders.remove(view);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void releaseHolder$lambda$6(Holder holder, View view) {
        synchronized (INSTANCE) {
            if (holder.getRefCount() <= 0) {
                holder.stop();
                holders.remove(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r setCornerRadius$lambda$3(float f, Object d) {
        k.f(d, "d");
        INSTANCE.call(d, "setCornerRadius", new Class[]{F}, Float.valueOf(f));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r setCornerSmoothness$lambda$4(float f, Object d) {
        k.f(d, "d");
        INSTANCE.call(d, "setCornerSmoothness", new Class[]{F}, Float.valueOf(f));
        return r.f317a;
    }

    public final synchronized Token acquire(View view) {
        try {
            k.f(view, "view");
            if (!isAvailable()) {
                return null;
            }
            WeakHashMap<View, Holder> weakHashMap = holders;
            Holder holder = weakHashMap.get(view);
            if (holder == null) {
                holder = new Holder(view);
                weakHashMap.put(view, holder);
            }
            Holder holder2 = holder;
            holder2.setRefCount(holder2.getRefCount() + 1);
            holder2.ensureStarted();
            if (!view.isAttachedToWindow() || holder2.getHasDrawable()) {
                return new Token(view, holder2);
            }
            holder2.setRefCount(holder2.getRefCount() - 1);
            if (holder2.getRefCount() <= 0) {
                holder2.stop();
                weakHashMap.remove(view);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void call(Object drawable, String name, Class<?>[] types, Object... args) {
        Method method;
        k.f(drawable, "drawable");
        k.f(name, "name");
        k.f(types, "types");
        k.f(args, "args");
        if (sdkAvailable && Api.INSTANCE.dispatch(drawable, name, args)) {
            return;
        }
        String str = name + types.length;
        HashMap<String, Method> map = methodCache;
        Method method2 = map.get(str);
        if (method2 == null) {
            try {
                method = drawable.getClass().getMethod(name, (Class[]) Arrays.copyOf(types, types.length));
            } catch (Throwable th) {
                Log.e(TAG, name + " reflection failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
                method = null;
            }
            method2 = method;
            map.put(str, method2);
        }
        Method method3 = method2;
        if (method3 == null) {
            return;
        }
        try {
            method3.invoke(drawable, Arrays.copyOf(args, args.length));
        } catch (Throwable th2) {
            th = th2;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.e(TAG, name + " invocation failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
        }
    }

    public final Drawable createRawDrawable$motionkit_fx_release(View host) {
        k.f(host, "host");
        if (!isAvailable()) {
            return null;
        }
        Object objCreate = create(host);
        if (objCreate instanceof Drawable) {
            return (Drawable) objCreate;
        }
        return null;
    }

    public final Class<?> getB() {
        return B;
    }

    public final Class<?> getF() {
        return F;
    }

    public final Class<?> getI() {
        return I;
    }

    public final boolean isAvailable() {
        return sdkAvailable || getReflectAvailable();
    }

    public final synchronized void setCornerRadius(View view, float px) {
        k.f(view, "view");
        Holder holder = holders.get(view);
        if (holder == null) {
            return;
        }
        holder.config(new m(px, 2));
    }

    public final synchronized void setCornerSmoothness(View view, float v10) {
        k.f(view, "view");
        Holder holder = holders.get(view);
        if (holder == null) {
            return;
        }
        holder.config(new m(v10, 3));
    }
}
