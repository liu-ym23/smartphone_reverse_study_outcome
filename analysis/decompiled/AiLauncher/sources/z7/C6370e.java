package z7;

import Y8.t;
import Z8.C1165m;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import stepos.view.effects.StepOSBackdropLayer;
import z7.C6370e;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003$ >B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\rJG\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00132\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001dJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010%R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R4\u00100\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010#0-j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010#`.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010/R\u001b\u00104\u001a\u0006\u0012\u0002\b\u00030\u00148\u0006¢\u0006\f\n\u0004\b\u0017\u00101\u001a\u0004\b2\u00103R\u001b\u00106\u001a\u0006\u0012\u0002\b\u00030\u00148\u0006¢\u0006\f\n\u0004\b\u001a\u00101\u001a\u0004\b5\u00103R\u001b\u00108\u001a\u0006\u0012\u0002\b\u00030\u00148\u0006¢\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b7\u00103R\u0011\u0010;\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010=\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010:¨\u0006?"}, d2 = {"Lz7/e;", "", "<init>", "()V", "Landroid/view/View;", "view", "Lz7/e$c;", "f", "(Landroid/view/View;)Lz7/e$c;", "", "px", "LY8/t;", "q", "(Landroid/view/View;F)V", "v", "s", "drawable", "", "name", "", "Ljava/lang/Class;", "types", "args", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)V", "Lz7/e$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "o", "(Landroid/view/View;Lz7/e$b;)V", "(Landroid/view/View;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", Const.INTENT_KEY_PKGNAME, "Z", "sdkAvailable", "Ljava/lang/reflect/Method;", "c", "Ljava/lang/reflect/Method;", "getViewRootImpl", Const.INTENT_KEY_UMID, "createMethod", "Ljava/util/WeakHashMap;", "e", "Ljava/util/WeakHashMap;", "holders", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "methodCache", "Ljava/lang/Class;", "l", "()Ljava/lang/Class;", "I", "k", "F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "B", "n", "()Z", "isAvailable", "m", "reflectAvailable", Const.INTENT_KEY_APIKEY, "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: z7.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6370e {

    /* renamed from: a, reason: collision with root package name */
    public static final C6370e f45191a = new C6370e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final boolean sdkAvailable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Method getViewRootImpl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Method createMethod;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final WeakHashMap<View, b> holders;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final HashMap<String, Method> methodCache;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Class<?> I;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Class<?> F;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Class<?> B;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lz7/e$a;", "", "<init>", "()V", "Landroid/view/View;", "view", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)Ljava/lang/Object;", "drawable", "", "name", "", "args", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Z", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: z7.e$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f45200a = new a();

        public final Object a(View view) {
            p.i(view, "view");
            return StepOSBackdropLayer.createBackdropLayerDrawable(view);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final boolean b(Object drawable, String name, Object[] args) {
            p.i(drawable, "drawable");
            p.i(name, "name");
            p.i(args, "args");
            Drawable drawable2 = drawable instanceof Drawable ? (Drawable) drawable : null;
            if (drawable2 == null) {
                return false;
            }
            try {
                switch (name.hashCode()) {
                    case -2070385286:
                        if (name.equals("setLightDirs")) {
                            Object obj = args[0];
                            p.g(obj, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue = ((Float) obj).floatValue();
                            Object obj2 = args[1];
                            p.g(obj2, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue2 = ((Float) obj2).floatValue();
                            Object obj3 = args[2];
                            p.g(obj3, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue3 = ((Float) obj3).floatValue();
                            Object obj4 = args[3];
                            p.g(obj4, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setLightDirs(drawable2, fFloatValue, fFloatValue2, fFloatValue3, ((Float) obj4).floatValue());
                            break;
                        }
                        break;
                    case -1960043633:
                        if (!name.equals("setEdgeColors")) {
                            break;
                        } else {
                            Object obj5 = args[0];
                            p.g(obj5, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue = ((Integer) obj5).intValue();
                            Object obj6 = args[1];
                            p.g(obj6, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setEdgeColors(drawable2, iIntValue, ((Integer) obj6).intValue());
                            break;
                        }
                    case -1835830646:
                        if (!name.equals("setBlendArray")) {
                            break;
                        } else {
                            Object obj7 = args[0];
                            p.g(obj7, "null cannot be cast to non-null type kotlin.IntArray");
                            Object obj8 = args[1];
                            p.g(obj8, "null cannot be cast to non-null type kotlin.IntArray");
                            StepOSBackdropLayer.setBlendArray(drawable2, (int[]) obj7, (int[]) obj8);
                            break;
                        }
                    case -1762158830:
                        if (!name.equals("setGlassStroke")) {
                            break;
                        } else {
                            Object obj9 = args[0];
                            p.g(obj9, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj9).booleanValue();
                            Object obj10 = args[1];
                            p.g(obj10, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue4 = ((Float) obj10).floatValue();
                            Object obj11 = args[2];
                            p.g(obj11, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue5 = ((Float) obj11).floatValue();
                            Object obj12 = args[3];
                            p.g(obj12, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue6 = ((Float) obj12).floatValue();
                            Object obj13 = args[4];
                            p.g(obj13, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setGlassStroke(drawable2, zBooleanValue, fFloatValue4, fFloatValue5, fFloatValue6, ((Integer) obj13).intValue());
                            break;
                        }
                    case -1405168505:
                        if (!name.equals("setGlassText")) {
                            break;
                        } else {
                            Object obj14 = args[0];
                            p.g(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue2 = ((Boolean) obj14).booleanValue();
                            Object obj15 = args[1];
                            p.g(obj15, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue7 = ((Float) obj15).floatValue();
                            Object obj16 = args[2];
                            p.g(obj16, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setGlassText(drawable2, zBooleanValue2, fFloatValue7, ((Float) obj16).floatValue());
                            break;
                        }
                    case -1360553359:
                        if (!name.equals("setColorGradient")) {
                            break;
                        } else {
                            Object obj17 = args[0];
                            p.g(obj17, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue2 = ((Integer) obj17).intValue();
                            Object obj18 = args[1];
                            p.g(obj18, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue3 = ((Integer) obj18).intValue();
                            Object obj19 = args[2];
                            p.g(obj19, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue4 = ((Integer) obj19).intValue();
                            Object obj20 = args[3];
                            p.g(obj20, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue8 = ((Float) obj20).floatValue();
                            Object obj21 = args[4];
                            p.g(obj21, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setColorGradient(drawable2, iIntValue2, iIntValue3, iIntValue4, fFloatValue8, ((Integer) obj21).intValue());
                            break;
                        }
                    case -1174108983:
                        if (!name.equals("setCornerRadius")) {
                            break;
                        } else if (args.length != 1) {
                            Object obj22 = args[0];
                            p.g(obj22, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue9 = ((Float) obj22).floatValue();
                            Object obj23 = args[1];
                            p.g(obj23, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue10 = ((Float) obj23).floatValue();
                            Object obj24 = args[2];
                            p.g(obj24, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue11 = ((Float) obj24).floatValue();
                            Object obj25 = args[3];
                            p.g(obj25, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setCornerRadius(drawable2, fFloatValue9, fFloatValue10, fFloatValue11, ((Float) obj25).floatValue());
                            break;
                        } else {
                            Object obj26 = args[0];
                            p.g(obj26, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setCornerRadius(drawable2, ((Float) obj26).floatValue());
                            break;
                        }
                    case -951818789:
                        if (name.equals("setBlurRadius")) {
                            Object obj27 = args[0];
                            p.g(obj27, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setBlurRadius(drawable2, ((Integer) obj27).intValue());
                            break;
                        }
                        break;
                    case -623010042:
                        if (!name.equals("setDispersion")) {
                            break;
                        } else {
                            Object obj28 = args[0];
                            p.g(obj28, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setDispersion(drawable2, ((Float) obj28).floatValue());
                            break;
                        }
                    case -320423506:
                        if (!name.equals("setDarkWidth")) {
                            break;
                        } else {
                            Object obj29 = args[0];
                            p.g(obj29, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setDarkWidth(drawable2, ((Float) obj29).floatValue());
                            break;
                        }
                    case 10984892:
                        if (!name.equals("setCornerSmoothness")) {
                            break;
                        } else {
                            Object obj30 = args[0];
                            p.g(obj30, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setCornerSmoothness(drawable2, ((Float) obj30).floatValue());
                            break;
                        }
                    case 25621303:
                        if (!name.equals("setRefraction")) {
                            break;
                        } else {
                            Object obj31 = args[0];
                            p.g(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue3 = ((Boolean) obj31).booleanValue();
                            Object obj32 = args[1];
                            p.g(obj32, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue12 = ((Float) obj32).floatValue();
                            Object obj33 = args[2];
                            p.g(obj33, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setRefraction(drawable2, zBooleanValue3, fFloatValue12, ((Float) obj33).floatValue());
                            break;
                        }
                    case 228676044:
                        if (!name.equals("setRefractionDepth")) {
                            break;
                        } else {
                            Object obj34 = args[0];
                            p.g(obj34, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setRefractionDepth(drawable2, ((Float) obj34).floatValue());
                            break;
                        }
                    case 250921529:
                        if (!name.equals("setBlurGradient")) {
                            break;
                        } else {
                            Object obj35 = args[0];
                            p.g(obj35, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue5 = ((Integer) obj35).intValue();
                            Object obj36 = args[1];
                            p.g(obj36, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setBlurGradient(drawable2, iIntValue5, ((Integer) obj36).intValue());
                            break;
                        }
                    case 1200042816:
                        if (!name.equals("setAnisoRim")) {
                            break;
                        } else {
                            Object obj37 = args[0];
                            p.g(obj37, "null cannot be cast to non-null type kotlin.Boolean");
                            StepOSBackdropLayer.setAnisoRim(drawable2, ((Boolean) obj37).booleanValue());
                            break;
                        }
                    case 1290130772:
                        if (!name.equals("setInnerShadow")) {
                            break;
                        } else {
                            Object obj38 = args[0];
                            p.g(obj38, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue4 = ((Boolean) obj38).booleanValue();
                            Object obj39 = args[1];
                            p.g(obj39, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue6 = ((Integer) obj39).intValue();
                            Object obj40 = args[2];
                            p.g(obj40, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue13 = ((Float) obj40).floatValue();
                            Object obj41 = args[3];
                            p.g(obj41, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue14 = ((Float) obj41).floatValue();
                            Object obj42 = args[4];
                            p.g(obj42, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue15 = ((Float) obj42).floatValue();
                            Object obj43 = args[5];
                            p.g(obj43, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setInnerShadow(drawable2, zBooleanValue4, iIntValue6, fFloatValue13, fFloatValue14, fFloatValue15, ((Float) obj43).floatValue());
                            break;
                        }
                    case 1389555745:
                        if (!name.equals("setColor")) {
                            break;
                        } else {
                            Object obj44 = args[0];
                            p.g(obj44, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setColor(drawable2, ((Integer) obj44).intValue());
                            break;
                        }
                    case 1390471317:
                        if (!name.equals("setDodge")) {
                            break;
                        } else {
                            Object obj45 = args[0];
                            p.g(obj45, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setDodge(drawable2, ((Float) obj45).floatValue());
                            break;
                        }
                    case 1392418690:
                        if (!name.equals("setFrost")) {
                            break;
                        } else {
                            Object obj46 = args[0];
                            p.g(obj46, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setFrost(drawable2, ((Float) obj46).floatValue());
                            break;
                        }
                    case 1756172231:
                        if (!name.equals("setEdgeWidth")) {
                            break;
                        } else {
                            Object obj47 = args[0];
                            p.g(obj47, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setEdgeWidth(drawable2, ((Float) obj47).floatValue());
                            break;
                        }
                    case 1882377614:
                        if (!name.equals("setOverlay")) {
                            break;
                        } else {
                            Object obj48 = args[0];
                            p.g(obj48, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setOverlay(drawable2, ((Float) obj48).floatValue());
                            break;
                        }
                    case 1946113869:
                        if (!name.equals("setStrokeSpread")) {
                            break;
                        } else {
                            Object obj49 = args[0];
                            p.g(obj49, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setStrokeSpread(drawable2, ((Float) obj49).floatValue());
                            break;
                        }
                    case 2081520598:
                        if (!name.equals("setAmbient")) {
                            break;
                        } else {
                            Object obj50 = args[0];
                            p.g(obj50, "null cannot be cast to non-null type kotlin.Float");
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
                Log.w("MotionKitCrossWindowMaterial", "StepOSBackdropLayer." + name + " 失败，回退反射: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
                return false;
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\bR\"\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00020\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010 R&\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\t0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0011\u0010+\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b&\u0010*¨\u0006,"}, d2 = {"Lz7/e$b;", "", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "LY8/t;", "e", "()V", "Lkotlin/Function1;", "action", "c", "(Lp9/l;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", Const.INTENT_KEY_APIKEY, "Ljava/lang/ref/WeakReference;", "viewRef", "", Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_BACKGROUND_COMMAND, "()I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)V", "refCount", "Ljava/lang/Object;", "drawable", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "prevBackground", "LZ8/m;", "LZ8/m;", "queued", "Landroid/view/View$OnAttachStateChangeListener;", "f", "Landroid/view/View$OnAttachStateChangeListener;", "attachListener", "", "()Z", "hasDrawable", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: z7.e$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final WeakReference<View> viewRef;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int refCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public Object drawable;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public Drawable prevBackground;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final C1165m<InterfaceC5074l<Object, t>> queued;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public View.OnAttachStateChangeListener attachListener;

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"z7/e$b$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* renamed from: z7.e$b$a */
        public static final class a implements View.OnAttachStateChangeListener {
            public a() {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v10) {
                p.i(v10, "v");
                v10.removeOnAttachStateChangeListener(this);
                b.this.attachListener = null;
                b.this.i();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v10) {
                p.i(v10, "v");
            }
        }

        public b(View view) {
            p.i(view, "view");
            this.viewRef = new WeakReference<>(view);
            this.queued = new C1165m<>();
        }

        public final void c(InterfaceC5074l<Object, t> action) {
            p.i(action, "action");
            Object obj = this.drawable;
            if (obj != null) {
                action.invoke(obj);
            } else {
                this.queued.addLast(action);
            }
        }

        public final void d() {
            View view;
            if (this.attachListener == null && (view = this.viewRef.get()) != null) {
                a aVar = new a();
                this.attachListener = aVar;
                view.addOnAttachStateChangeListener(aVar);
            }
        }

        public final void e() {
            View view;
            if (this.drawable == null && (view = this.viewRef.get()) != null) {
                if (view.isAttachedToWindow()) {
                    i();
                } else {
                    d();
                }
            }
        }

        public final boolean f() {
            return this.drawable != null;
        }

        /* renamed from: g, reason: from getter */
        public final int getRefCount() {
            return this.refCount;
        }

        public final void h(int i10) {
            this.refCount = i10;
        }

        public final void i() {
            Object objH;
            View view = this.viewRef.get();
            if (view == null || (objH = C6370e.f45191a.h(view)) == null) {
                return;
            }
            this.drawable = objH;
            this.prevBackground = view.getBackground();
            view.setBackground((Drawable) objH);
            while (!this.queued.isEmpty()) {
                this.queued.removeFirst().invoke(objH);
            }
        }

        public final void j() {
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

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u000b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\u00020\t2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000e\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00020\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013¨\u0006\u0015"}, d2 = {"Lz7/e$c;", "", "Landroid/view/View;", "view", "Lz7/e$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "<init>", "(Landroid/view/View;Lz7/e$b;)V", "Lkotlin/Function1;", "LY8/t;", "action", Const.INTENT_KEY_PKGNAME, "(Lp9/l;)V", "reset", "c", Const.INTENT_KEY_APIKEY, "Lz7/e$b;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "viewRef", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: z7.e$c */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final b h;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final WeakReference<View> viewRef;

        public c(View view, b h10) {
            p.i(view, "view");
            p.i(h10, "h");
            this.h = h10;
            this.viewRef = new WeakReference<>(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void d(c cVar, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                interfaceC5074l = new InterfaceC5074l() { // from class: z7.f
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj2) {
                        return C6370e.c.e(obj2);
                    }
                };
            }
            cVar.c(interfaceC5074l);
        }

        public static final t e(Object it) {
            p.i(it, "it");
            return t.f7040a;
        }

        public final void b(InterfaceC5074l<Object, t> action) {
            p.i(action, "action");
            this.h.c(action);
        }

        public final void c(InterfaceC5074l<Object, t> reset) {
            p.i(reset, "reset");
            this.h.c(reset);
            View view = this.viewRef.get();
            if (view == null) {
                return;
            }
            C6370e.f45191a.o(view, this.h);
        }
    }

    static {
        boolean z10;
        Method method;
        try {
            Class.forName("stepos.view.effects.StepOSBackdropLayer");
            z10 = true;
        } catch (Throwable th) {
            Log.i("MotionKitCrossWindowMaterial", "StepOSBackdropLayer 不可用，将尝试反射 createBackdropLayerDrawable: " + th.getClass().getSimpleName() + ": " + th.getMessage());
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
            Log.e("MotionKitCrossWindowMaterial", "createBackdropLayerDrawable unavailable: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
        }
        createMethod = method2;
        holders = new WeakHashMap<>();
        methodCache = new HashMap<>();
        Class<?> cls = Integer.TYPE;
        p.f(cls);
        I = cls;
        Class<?> cls2 = Float.TYPE;
        p.f(cls2);
        F = cls2;
        Class<?> cls3 = Boolean.TYPE;
        p.f(cls3);
        B = cls3;
    }

    public static final void p(b bVar, View view) {
        synchronized (f45191a) {
            try {
                if (bVar.getRefCount() <= 0) {
                    bVar.j();
                    holders.remove(view);
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final t r(float f10, Object d10) {
        p.i(d10, "d");
        f45191a.g(d10, "setCornerRadius", new Class[]{F}, Float.valueOf(f10));
        return t.f7040a;
    }

    public static final t t(float f10, Object d10) {
        p.i(d10, "d");
        f45191a.g(d10, "setCornerSmoothness", new Class[]{F}, Float.valueOf(f10));
        return t.f7040a;
    }

    public final synchronized c f(View view) {
        try {
            p.i(view, "view");
            if (!n()) {
                return null;
            }
            WeakHashMap<View, b> weakHashMap = holders;
            b bVar = weakHashMap.get(view);
            if (bVar == null) {
                bVar = new b(view);
                weakHashMap.put(view, bVar);
            }
            b bVar2 = bVar;
            bVar2.h(bVar2.getRefCount() + 1);
            bVar2.e();
            if (!view.isAttachedToWindow() || bVar2.f()) {
                return new c(view, bVar2);
            }
            bVar2.h(bVar2.getRefCount() - 1);
            if (bVar2.getRefCount() <= 0) {
                bVar2.j();
                weakHashMap.remove(view);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void g(Object drawable, String name, Class<?>[] types, Object... args) {
        Method method;
        p.i(drawable, "drawable");
        p.i(name, "name");
        p.i(types, "types");
        p.i(args, "args");
        if (sdkAvailable && a.f45200a.b(drawable, name, args)) {
            return;
        }
        String str = name + types.length;
        HashMap<String, Method> map = methodCache;
        Method method2 = map.get(str);
        if (method2 == null) {
            try {
                method = drawable.getClass().getMethod(name, (Class[]) Arrays.copyOf(types, types.length));
            } catch (Throwable th) {
                Log.e("MotionKitCrossWindowMaterial", name + " reflection failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
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
            Log.e("MotionKitCrossWindowMaterial", name + " invocation failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
        }
    }

    public final Object h(View view) {
        if (sdkAvailable) {
            try {
                return a.f45200a.a(view);
            } catch (Throwable th) {
                th = th;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                Log.w("MotionKitCrossWindowMaterial", "StepOSBackdropLayer.create 失败，回退反射: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            }
        }
        return this.i(view);
    }

    public final Object i(View view) {
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
            Log.e("MotionKitCrossWindowMaterial", "ViewRootImpl is null (View not attached)");
            return null;
        } catch (Throwable th) {
            th = th;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.e("MotionKitCrossWindowMaterial", "createBackdropLayerDrawable failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            return null;
        }
    }

    public final Class<?> j() {
        return B;
    }

    public final Class<?> k() {
        return F;
    }

    public final Class<?> l() {
        return I;
    }

    public final boolean m() {
        return (getViewRootImpl == null || createMethod == null) ? false : true;
    }

    public final boolean n() {
        return sdkAvailable || m();
    }

    public final synchronized void o(final View view, final b h10) {
        try {
            h10.h(h10.getRefCount() - 1);
            if (h10.getRefCount() <= 0) {
                if (view.isAttachedToWindow()) {
                    view.post(new Runnable() { // from class: z7.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            C6370e.p(h10, view);
                        }
                    });
                } else {
                    h10.j();
                    holders.remove(view);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void q(View view, final float px) {
        p.i(view, "view");
        b bVar = holders.get(view);
        if (bVar == null) {
            return;
        }
        bVar.c(new InterfaceC5074l() { // from class: z7.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C6370e.r(px, obj);
            }
        });
    }

    public final synchronized void s(View view, final float v10) {
        p.i(view, "view");
        b bVar = holders.get(view);
        if (bVar == null) {
            return;
        }
        bVar.c(new InterfaceC5074l() { // from class: z7.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C6370e.t(v10, obj);
            }
        });
    }
}
