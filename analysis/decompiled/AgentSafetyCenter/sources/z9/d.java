package z9;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import stepos.view.effects.StepOSBackdropLayer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d {
    public static Drawable a(View view) {
        return StepOSBackdropLayer.createBackdropLayerDrawable(view);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean b(Object obj, String str, Object[] objArr) {
        obj.getClass();
        Drawable drawable = obj instanceof Drawable ? (Drawable) obj : null;
        if (drawable != null) {
            try {
                switch (str.hashCode()) {
                    case -2070385286:
                        if (str.equals("setLightDirs")) {
                            Object obj2 = objArr[0];
                            obj2.getClass();
                            float fFloatValue = ((Float) obj2).floatValue();
                            Object obj3 = objArr[1];
                            obj3.getClass();
                            float fFloatValue2 = ((Float) obj3).floatValue();
                            Object obj4 = objArr[2];
                            obj4.getClass();
                            float fFloatValue3 = ((Float) obj4).floatValue();
                            Object obj5 = objArr[3];
                            obj5.getClass();
                            StepOSBackdropLayer.setLightDirs(drawable, fFloatValue, fFloatValue2, fFloatValue3, ((Float) obj5).floatValue());
                            return true;
                        }
                        break;
                    case -1960043633:
                        if (!str.equals("setEdgeColors")) {
                            break;
                        } else {
                            Object obj6 = objArr[0];
                            obj6.getClass();
                            int iIntValue = ((Integer) obj6).intValue();
                            Object obj7 = objArr[1];
                            obj7.getClass();
                            StepOSBackdropLayer.setEdgeColors(drawable, iIntValue, ((Integer) obj7).intValue());
                            return true;
                        }
                    case -1835830646:
                        if (!str.equals("setBlendArray")) {
                            break;
                        } else {
                            Object obj8 = objArr[0];
                            obj8.getClass();
                            Object obj9 = objArr[1];
                            obj9.getClass();
                            StepOSBackdropLayer.setBlendArray(drawable, (int[]) obj8, (int[]) obj9);
                            return true;
                        }
                    case -1762158830:
                        if (!str.equals("setGlassStroke")) {
                            break;
                        } else {
                            Object obj10 = objArr[0];
                            obj10.getClass();
                            boolean zBooleanValue = ((Boolean) obj10).booleanValue();
                            Object obj11 = objArr[1];
                            obj11.getClass();
                            float fFloatValue4 = ((Float) obj11).floatValue();
                            Object obj12 = objArr[2];
                            obj12.getClass();
                            float fFloatValue5 = ((Float) obj12).floatValue();
                            Object obj13 = objArr[3];
                            obj13.getClass();
                            float fFloatValue6 = ((Float) obj13).floatValue();
                            Object obj14 = objArr[4];
                            obj14.getClass();
                            StepOSBackdropLayer.setGlassStroke(drawable, zBooleanValue, fFloatValue4, fFloatValue5, fFloatValue6, ((Integer) obj14).intValue());
                            return true;
                        }
                    case -1405168505:
                        if (!str.equals("setGlassText")) {
                            break;
                        } else {
                            Object obj15 = objArr[0];
                            obj15.getClass();
                            boolean zBooleanValue2 = ((Boolean) obj15).booleanValue();
                            Object obj16 = objArr[1];
                            obj16.getClass();
                            float fFloatValue7 = ((Float) obj16).floatValue();
                            Object obj17 = objArr[2];
                            obj17.getClass();
                            StepOSBackdropLayer.setGlassText(drawable, zBooleanValue2, fFloatValue7, ((Float) obj17).floatValue());
                            return true;
                        }
                    case -1360553359:
                        if (!str.equals("setColorGradient")) {
                            break;
                        } else {
                            Object obj18 = objArr[0];
                            obj18.getClass();
                            int iIntValue2 = ((Integer) obj18).intValue();
                            Object obj19 = objArr[1];
                            obj19.getClass();
                            int iIntValue3 = ((Integer) obj19).intValue();
                            Object obj20 = objArr[2];
                            obj20.getClass();
                            int iIntValue4 = ((Integer) obj20).intValue();
                            Object obj21 = objArr[3];
                            obj21.getClass();
                            float fFloatValue8 = ((Float) obj21).floatValue();
                            Object obj22 = objArr[4];
                            obj22.getClass();
                            StepOSBackdropLayer.setColorGradient(drawable, iIntValue2, iIntValue3, iIntValue4, fFloatValue8, ((Integer) obj22).intValue());
                            return true;
                        }
                    case -1174108983:
                        if (!str.equals("setCornerRadius")) {
                            break;
                        } else {
                            if (objArr.length == 1) {
                                Object obj23 = objArr[0];
                                obj23.getClass();
                                StepOSBackdropLayer.setCornerRadius(drawable, ((Float) obj23).floatValue());
                                return true;
                            }
                            Object obj24 = objArr[0];
                            obj24.getClass();
                            float fFloatValue9 = ((Float) obj24).floatValue();
                            Object obj25 = objArr[1];
                            obj25.getClass();
                            float fFloatValue10 = ((Float) obj25).floatValue();
                            Object obj26 = objArr[2];
                            obj26.getClass();
                            float fFloatValue11 = ((Float) obj26).floatValue();
                            Object obj27 = objArr[3];
                            obj27.getClass();
                            StepOSBackdropLayer.setCornerRadius(drawable, fFloatValue9, fFloatValue10, fFloatValue11, ((Float) obj27).floatValue());
                            return true;
                        }
                    case -951818789:
                        if (str.equals("setBlurRadius")) {
                            Object obj28 = objArr[0];
                            obj28.getClass();
                            StepOSBackdropLayer.setBlurRadius(drawable, ((Integer) obj28).intValue());
                            return true;
                        }
                        break;
                    case -623010042:
                        if (!str.equals("setDispersion")) {
                            break;
                        } else {
                            Object obj29 = objArr[0];
                            obj29.getClass();
                            StepOSBackdropLayer.setDispersion(drawable, ((Float) obj29).floatValue());
                            return true;
                        }
                    case -320423506:
                        if (!str.equals("setDarkWidth")) {
                            break;
                        } else {
                            Object obj30 = objArr[0];
                            obj30.getClass();
                            StepOSBackdropLayer.setDarkWidth(drawable, ((Float) obj30).floatValue());
                            return true;
                        }
                    case 10984892:
                        if (!str.equals("setCornerSmoothness")) {
                            break;
                        } else {
                            Object obj31 = objArr[0];
                            obj31.getClass();
                            StepOSBackdropLayer.setCornerSmoothness(drawable, ((Float) obj31).floatValue());
                            return true;
                        }
                    case 25621303:
                        if (!str.equals("setRefraction")) {
                            break;
                        } else {
                            Object obj32 = objArr[0];
                            obj32.getClass();
                            boolean zBooleanValue3 = ((Boolean) obj32).booleanValue();
                            Object obj33 = objArr[1];
                            obj33.getClass();
                            float fFloatValue12 = ((Float) obj33).floatValue();
                            Object obj34 = objArr[2];
                            obj34.getClass();
                            StepOSBackdropLayer.setRefraction(drawable, zBooleanValue3, fFloatValue12, ((Float) obj34).floatValue());
                            return true;
                        }
                    case 228676044:
                        if (!str.equals("setRefractionDepth")) {
                            break;
                        } else {
                            Object obj35 = objArr[0];
                            obj35.getClass();
                            StepOSBackdropLayer.setRefractionDepth(drawable, ((Float) obj35).floatValue());
                            return true;
                        }
                    case 250921529:
                        if (!str.equals("setBlurGradient")) {
                            break;
                        } else {
                            Object obj36 = objArr[0];
                            obj36.getClass();
                            int iIntValue5 = ((Integer) obj36).intValue();
                            Object obj37 = objArr[1];
                            obj37.getClass();
                            StepOSBackdropLayer.setBlurGradient(drawable, iIntValue5, ((Integer) obj37).intValue());
                            return true;
                        }
                    case 1200042816:
                        if (!str.equals("setAnisoRim")) {
                            break;
                        } else {
                            Object obj38 = objArr[0];
                            obj38.getClass();
                            StepOSBackdropLayer.setAnisoRim(drawable, ((Boolean) obj38).booleanValue());
                            return true;
                        }
                    case 1290130772:
                        if (!str.equals("setInnerShadow")) {
                            break;
                        } else {
                            Object obj39 = objArr[0];
                            obj39.getClass();
                            boolean zBooleanValue4 = ((Boolean) obj39).booleanValue();
                            Object obj40 = objArr[1];
                            obj40.getClass();
                            int iIntValue6 = ((Integer) obj40).intValue();
                            Object obj41 = objArr[2];
                            obj41.getClass();
                            float fFloatValue13 = ((Float) obj41).floatValue();
                            Object obj42 = objArr[3];
                            obj42.getClass();
                            float fFloatValue14 = ((Float) obj42).floatValue();
                            Object obj43 = objArr[4];
                            obj43.getClass();
                            float fFloatValue15 = ((Float) obj43).floatValue();
                            Object obj44 = objArr[5];
                            obj44.getClass();
                            StepOSBackdropLayer.setInnerShadow(drawable, zBooleanValue4, iIntValue6, fFloatValue13, fFloatValue14, fFloatValue15, ((Float) obj44).floatValue());
                            return true;
                        }
                    case 1389555745:
                        if (!str.equals("setColor")) {
                            break;
                        } else {
                            Object obj45 = objArr[0];
                            obj45.getClass();
                            StepOSBackdropLayer.setColor(drawable, ((Integer) obj45).intValue());
                            return true;
                        }
                    case 1390471317:
                        if (!str.equals("setDodge")) {
                            break;
                        } else {
                            Object obj46 = objArr[0];
                            obj46.getClass();
                            StepOSBackdropLayer.setDodge(drawable, ((Float) obj46).floatValue());
                            return true;
                        }
                    case 1392418690:
                        if (!str.equals("setFrost")) {
                            break;
                        } else {
                            Object obj47 = objArr[0];
                            obj47.getClass();
                            StepOSBackdropLayer.setFrost(drawable, ((Float) obj47).floatValue());
                            return true;
                        }
                    case 1756172231:
                        if (!str.equals("setEdgeWidth")) {
                            break;
                        } else {
                            Object obj48 = objArr[0];
                            obj48.getClass();
                            StepOSBackdropLayer.setEdgeWidth(drawable, ((Float) obj48).floatValue());
                            return true;
                        }
                    case 1882377614:
                        if (!str.equals("setOverlay")) {
                            break;
                        } else {
                            Object obj49 = objArr[0];
                            obj49.getClass();
                            StepOSBackdropLayer.setOverlay(drawable, ((Float) obj49).floatValue());
                            return true;
                        }
                    case 1946113869:
                        if (!str.equals("setStrokeSpread")) {
                            break;
                        } else {
                            Object obj50 = objArr[0];
                            obj50.getClass();
                            StepOSBackdropLayer.setStrokeSpread(drawable, ((Float) obj50).floatValue());
                            return true;
                        }
                    case 2081520598:
                        if (!str.equals("setAmbient")) {
                            break;
                        } else {
                            Object obj51 = objArr[0];
                            obj51.getClass();
                            StepOSBackdropLayer.setAmbient(drawable, ((Float) obj51).floatValue());
                            return true;
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
                StringBuilder sbP = androidx.activity.b.p("StepOSBackdropLayer.", str, " 失败，回退反射: ", simpleName, ": ");
                sbP.append(message);
                Log.w("MotionKitCrossWindowMaterial", sbP.toString());
                return false;
            }
        }
        return false;
    }
}
