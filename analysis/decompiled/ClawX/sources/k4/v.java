package k4;

import a6.h1;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.stepclaw.SecurePrefs;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class v {
    public static int A(Context context, int i8, int i9) {
        Integer numValueOf;
        TypedValue typedValueD = z.D(context, i8);
        if (typedValueD != null) {
            int i10 = typedValueD.resourceId;
            numValueOf = Integer.valueOf(i10 != 0 ? context.getColor(i10) : typedValueD.data);
        } else {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : i9;
    }

    public static int B(View view, int i8) {
        Context context = view.getContext();
        TypedValue typedValueE = z.E(view.getContext(), i8, view.getClass().getCanonicalName());
        int i9 = typedValueE.resourceId;
        return i9 != 0 ? context.getColor(i9) : typedValueE.data;
    }

    public static ColorStateList C(Context context, a4.d dVar, int i8) {
        int resourceId;
        ColorStateList colorStateListT;
        TypedArray typedArray = (TypedArray) dVar.f97c;
        return (!typedArray.hasValue(i8) || (resourceId = typedArray.getResourceId(i8, 0)) == 0 || (colorStateListT = z.t(context, resourceId)) == null) ? dVar.s(i8) : colorStateListT;
    }

    public static ColorStateList D(Context context, TypedArray typedArray, int i8) {
        int resourceId;
        ColorStateList colorStateListT;
        return (!typedArray.hasValue(i8) || (resourceId = typedArray.getResourceId(i8, 0)) == 0 || (colorStateListT = z.t(context, resourceId)) == null) ? typedArray.getColorStateList(i8) : colorStateListT;
    }

    public static Drawable F(Context context, TypedArray typedArray, int i8) {
        int resourceId;
        Drawable drawableP;
        return (!typedArray.hasValue(i8) || (resourceId = typedArray.getResourceId(i8, 0)) == 0 || (drawableP = b8.h.p(context, resourceId)) == null) ? typedArray.getDrawable(i8) : drawableP;
    }

    public static final Class I(v5.c cVar) {
        Class clsA = ((kotlin.jvm.internal.g) cVar).a();
        kotlin.jvm.internal.p.c(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return clsA;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class J(v5.c cVar) {
        kotlin.jvm.internal.p.e(cVar, "<this>");
        Class clsA = ((kotlin.jvm.internal.g) cVar).a();
        if (clsA.isPrimitive()) {
            String name = clsA.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return clsA;
    }

    public static float K(String[] strArr, int i8) throws NumberFormatException {
        float f3 = Float.parseFloat(strArr[i8]);
        if (f3 >= 0.0f && f3 <= 1.0f) {
            return f3;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f3);
    }

    public static final int P(String str) {
        int iQ1;
        char c3 = File.separatorChar;
        int iQ12 = x5.n.q1(str, c3, 0, 4);
        if (iQ12 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c3 || (iQ1 = x5.n.q1(str, c3, 2, 4)) < 0) {
                return 1;
            }
            int iQ13 = x5.n.q1(str, c3, iQ1 + 1, 4);
            return iQ13 >= 0 ? iQ13 + 1 : str.length();
        }
        if (iQ12 > 0 && str.charAt(iQ12 - 1) == ':') {
            return iQ12 + 1;
        }
        if (iQ12 == -1 && x5.n.l1(str, AbstractJsonLexerKt.COLON)) {
            return str.length();
        }
        return 0;
    }

    public static final KSerializer S(Object obj, SerializersModule module) {
        KSerializer kSerializerSerializer;
        kotlin.jvm.internal.p.e(module, "module");
        kotlin.jvm.internal.c0 c0Var = kotlin.jvm.internal.c0.f3665a;
        if (obj == null) {
            kSerializerSerializer = BuiltinSerializersKt.getNullable(BuiltinSerializersKt.serializer(c0Var));
        } else if (obj instanceof List) {
            kSerializerSerializer = BuiltinSerializersKt.ListSerializer(w((Collection) obj, module));
        } else {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                Object obj2 = objArr.length != 0 ? objArr[0] : null;
                kSerializerSerializer = obj2 != null ? S(obj2, module) : BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(c0Var));
            } else if (obj instanceof Set) {
                kSerializerSerializer = BuiltinSerializersKt.SetSerializer(w((Collection) obj, module));
            } else if (obj instanceof Map) {
                Map map = (Map) obj;
                kSerializerSerializer = BuiltinSerializersKt.MapSerializer(w(map.keySet(), module), w(map.values(), module));
            } else {
                KSerializer contextual$default = SerializersModule.getContextual$default(module, kotlin.jvm.internal.z.a(obj.getClass()), null, 2, null);
                kSerializerSerializer = contextual$default == null ? SerializersKt.serializer(kotlin.jvm.internal.z.a(obj.getClass())) : contextual$default;
            }
        }
        kotlin.jvm.internal.p.c(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        return kSerializerSerializer;
    }

    public static final void T(String name) {
        kotlin.jvm.internal.p.e(name, "name");
        if (name.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = name.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = name.charAt(i8);
            if ('!' > cCharAt || cCharAt >= 127) {
                StringBuilder sb = new StringBuilder("Unexpected char 0x");
                x.f.r(16);
                String string = Integer.toString(cCharAt, 16);
                kotlin.jvm.internal.p.d(string, "toString(...)");
                if (string.length() < 2) {
                    string = "0".concat(string);
                }
                sb.append(string);
                sb.append(" at ");
                sb.append(i8);
                sb.append(" in header name: ");
                sb.append(name);
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }

    public static final void U(String value, String str) {
        kotlin.jvm.internal.p.e(value, "value");
        int length = value.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = value.charAt(i8);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                StringBuilder sb = new StringBuilder("Unexpected char 0x");
                x.f.r(16);
                String string = Integer.toString(cCharAt, 16);
                kotlin.jvm.internal.p.d(string, "toString(...)");
                if (string.length() < 2) {
                    string = "0".concat(string);
                }
                sb.append(string);
                sb.append(" at ");
                sb.append(i8);
                sb.append(" in ");
                sb.append(str);
                sb.append(" value");
                sb.append(o6.d.j(str) ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : ": ".concat(value));
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }

    public static boolean W(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean X(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static final t3.c a(x3.a engineFactory, p5.l lVar) {
        kotlin.jvm.internal.p.e(engineFactory, "engineFactory");
        t3.d dVar = new t3.d();
        lVar.invoke(dVar);
        p5.l block = dVar.d;
        kotlin.jvm.internal.p.e(block, "block");
        x3.g gVar = new x3.g();
        gVar.f6269a = 100000;
        gVar.f6270b = 100000;
        gVar.f6271c = new o3.a(19);
        gVar.d = new o3.a(20);
        block.invoke(gVar);
        x3.d dVar2 = new x3.d(gVar);
        t3.c cVar = new t3.c(dVar2, dVar);
        f5.f fVarO = cVar.d.o(a6.c0.f143b);
        kotlin.jvm.internal.p.b(fVarO);
        ((h1) fVarO).A(new c5.a(15, dVar2));
        return cVar;
    }

    public static int a0(int i8, int i9, float f3) {
        return x.a.b(x.a.d(i9, Math.round(Color.alpha(i9) * f3)), i8);
    }

    public static final h0 b(String urlString) {
        kotlin.jvm.internal.p.e(urlString, "urlString");
        c0 c0Var = new c0();
        d0.b(c0Var, urlString);
        return c0Var.b();
    }

    public static Typeface b0(Configuration configuration, Typeface typeface) {
        int i8 = configuration.fontWeightAdjustment;
        if (i8 == Integer.MAX_VALUE || i8 == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, x.f.t(typeface.getWeight() + configuration.fontWeightAdjustment, 1, 1000), typeface.isItalic());
    }

    public static final void c(Logger logger, q6.a aVar, q6.c cVar, String str) {
        logger.fine(cVar.f4874b + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + aVar.f4868a);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long c0(int r14, java.lang.String r15) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.v.c0(int, java.lang.String):long");
    }

    public static final void d(p pVar, String str, int i8, int i9, int i10) {
        if (i9 == -1) {
            int iQ0 = q0(i8, i10, str);
            int iP0 = p0(iQ0, i10, str);
            if (iP0 > iQ0) {
                String strSubstring = str.substring(iQ0, iP0);
                kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
                pVar.j(strSubstring, c5.s.f1092a);
                return;
            }
            return;
        }
        int iQ02 = q0(i8, i9, str);
        int iP02 = p0(iQ02, i9, str);
        if (iP02 > iQ02) {
            String strSubstring2 = str.substring(iQ02, iP02);
            kotlin.jvm.internal.p.d(strSubstring2, "substring(...)");
            int iQ03 = q0(i9 + 1, i10, str);
            String strSubstring3 = str.substring(iQ03, p0(iQ03, i10, str));
            kotlin.jvm.internal.p.d(strSubstring3, "substring(...)");
            pVar.b(strSubstring2, strSubstring3);
        }
    }

    public static void e(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static void f0(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public static int g0(Context context, int i8, int i9) {
        TypedValue typedValueD = z.D(context, i8);
        return (typedValueD == null || typedValueD.type != 16) ? i9 : typedValueD.data;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0187 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x012f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0130 A[Catch: NumberFormatException -> 0x0144, LOOP:3: B:47:0x00ff->B:66:0x0130, LOOP_END, TryCatch #1 {NumberFormatException -> 0x0144, blocks: (B:44:0x00e9, B:47:0x00ff, B:49:0x0105, B:53:0x0111, B:66:0x0130, B:68:0x0136, B:74:0x014b, B:76:0x0150, B:78:0x0153, B:79:0x015f, B:80:0x0164, B:81:0x0165, B:82:0x016a), top: B:107:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0136 A[Catch: NumberFormatException -> 0x0144, TryCatch #1 {NumberFormatException -> 0x0144, blocks: (B:44:0x00e9, B:47:0x00ff, B:49:0x0105, B:53:0x0111, B:66:0x0130, B:68:0x0136, B:74:0x014b, B:76:0x0150, B:78:0x0153, B:79:0x015f, B:80:0x0164, B:81:0x0165, B:82:0x016a), top: B:107:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014b A[Catch: NumberFormatException -> 0x0144, TryCatch #1 {NumberFormatException -> 0x0144, blocks: (B:44:0x00e9, B:47:0x00ff, B:49:0x0105, B:53:0x0111, B:66:0x0130, B:68:0x0136, B:74:0x014b, B:76:0x0150, B:78:0x0153, B:79:0x015f, B:80:0x0164, B:81:0x0165, B:82:0x016a), top: B:107:0x00e9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.TimeInterpolator h0(android.content.Context r19, int r20, android.animation.TimeInterpolator r21) {
        /*
            Method dump skipped, instructions count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.v.h0(android.content.Context, int, android.animation.TimeInterpolator):android.animation.TimeInterpolator");
    }

    public static final KSerializer j0(SerializersModule serializersModule, w4.a typeInfo) {
        kotlin.jvm.internal.p.e(serializersModule, "<this>");
        kotlin.jvm.internal.p.e(typeInfo, "typeInfo");
        v5.c cVar = typeInfo.f6200a;
        v5.i iVar = typeInfo.f6201b;
        if (iVar != null) {
            KSerializer<Object> kSerializerSerializerOrNull = iVar.getArguments().isEmpty() ? null : SerializersKt.serializerOrNull(serializersModule, iVar);
            if (kSerializerSerializerOrNull != null) {
                return kSerializerSerializerOrNull;
            }
        }
        KSerializer contextual$default = SerializersModule.getContextual$default(serializersModule, cVar, null, 2, null);
        if (contextual$default != null) {
            return (iVar == null || !iVar.isMarkedNullable()) ? contextual$default : BuiltinSerializersKt.getNullable(contextual$default);
        }
        KSerializer kSerializerSerializer = SerializersKt.serializer(cVar);
        return (iVar == null || !iVar.isMarkedNullable()) ? kSerializerSerializer : BuiltinSerializersKt.getNullable(kSerializerSerializer);
    }

    public static final r4.c k(String str) {
        kotlin.jvm.internal.p.e(str, "<this>");
        return new r4.c(str);
    }

    public static void k0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z = onLongClickListener != null;
        boolean z2 = zHasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        checkableImageButton.setImportantForAccessibility(z2 ? 1 : 2);
    }

    public static final void l(AutoCloseable autoCloseable, Throwable th) throws Exception {
        boolean zIsTerminated;
        if (autoCloseable != null) {
            if (th != null) {
                try {
                    m0.f.k(autoCloseable);
                    return;
                } catch (Throwable th2) {
                    a.a.a(th, th2);
                    return;
                }
            }
            if (autoCloseable instanceof AutoCloseable) {
                autoCloseable.close();
                return;
            }
            if (!(autoCloseable instanceof ExecutorService)) {
                throw new IllegalArgumentException();
            }
            ExecutorService executorService = (ExecutorService) autoCloseable;
            if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
                return;
            }
            executorService.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        executorService.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static float m(float f3) {
        if (f3 < 0.0f) {
            return 0.0f;
        }
        if (f3 > 1.0f) {
            return 1.0f;
        }
        return f3;
    }

    public static int n(int i8, int i9, int i10) {
        if (i9 <= i10) {
            return i8 < i9 ? i9 : i8 > i10 ? i10 : i8;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i10 + " is less than minimum " + i9 + '.');
    }

    public static u5.d n0(u5.f fVar, int i8) {
        kotlin.jvm.internal.p.e(fVar, "<this>");
        boolean z = i8 > 0;
        Integer numValueOf = Integer.valueOf(i8);
        if (!z) {
            throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
        }
        int i9 = fVar.f5663a;
        int i10 = fVar.f5664b;
        if (fVar.f5665c <= 0) {
            i8 = -i8;
        }
        return new u5.d(i9, i10, i8);
    }

    public static long o(long j4, long j8, long j9) {
        if (j8 <= j9) {
            return j4 < j8 ? j8 : j4 > j9 ? j9 : j4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j9 + " is less than minimum " + j8 + '.');
    }

    public static final m5.c o0(File file) {
        List list;
        String path = file.getPath();
        kotlin.jvm.internal.p.b(path);
        int iP = P(path);
        String strSubstring = path.substring(0, iP);
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        String strSubstring2 = path.substring(iP);
        kotlin.jvm.internal.p.d(strSubstring2, "substring(...)");
        if (strSubstring2.length() == 0) {
            list = c5.s.f1092a;
        } else {
            List listH1 = x5.n.H1(strSubstring2, new char[]{File.separatorChar});
            ArrayList arrayList = new ArrayList(c5.o.n0(listH1, 10));
            Iterator it = listH1.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new m5.c(new File(strSubstring), list);
    }

    public static final void p(androidx.fragment.app.l lVar, String str, String value) {
        kotlin.jvm.internal.p.e(lVar, "<this>");
        kotlin.jvm.internal.p.e(value, "value");
        ArrayList arrayList = lVar.f682a;
        arrayList.add(str);
        arrayList.add(x5.n.T1(value).toString());
    }

    public static final int p0(int i8, int i9, String str) {
        while (i9 > i8 && x.f.j0(str.charAt(i9 - 1))) {
            i9--;
        }
        return i9;
    }

    public static byte[] q(byte[]... bArr) throws GeneralSecurityException {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            if (length > Integer.MAX_VALUE - bArr2.length) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return bArr3;
    }

    public static final int q0(int i8, int i9, String str) {
        while (i8 < i9 && x.f.j0(str.charAt(i8))) {
            i8++;
        }
        return i8;
    }

    public static final g r(f4.c cVar) {
        kotlin.jvm.internal.p.e(cVar, "<this>");
        p pVar = cVar.f2593c;
        List list = t.f3636a;
        String strF = pVar.f("Content-Type");
        if (strF == null) {
            return null;
        }
        g gVar = g.f3611f;
        return b8.h.F(strF);
    }

    public static u5.f r0(int i8, int i9) {
        if (i9 > Integer.MIN_VALUE) {
            return new u5.f(i8, i9 - 1, 1);
        }
        u5.f fVar = u5.f.d;
        return u5.f.d;
    }

    public static final void s(f4.c cVar, g type) {
        kotlin.jvm.internal.p.e(type, "type");
        p pVar = cVar.f2593c;
        List list = t.f3636a;
        String value = type.toString();
        pVar.getClass();
        kotlin.jvm.internal.p.e(value, "value");
        pVar.m(value);
        List listE = pVar.e("Content-Type");
        listE.clear();
        listE.add(value);
    }

    public static ImageView.ScaleType t(int i8) {
        return i8 != 0 ? i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 5 ? i8 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static final void t0(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i8) {
        if (i8 < 0 || byteBuffer2.remaining() < i8 || byteBuffer3.remaining() < i8 || byteBuffer.remaining() < i8) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i9 = 0; i9 < i8; i9++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static final long u(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i8 = inputStream.read(bArr);
        long j4 = 0;
        while (i8 >= 0) {
            outputStream.write(bArr, 0, i8);
            j4 += i8;
            i8 = inputStream.read(bArr);
        }
        return j4;
    }

    public static final byte[] u0(int i8, byte[] bArr, int i9, byte[] bArr2, int i10) {
        if (i10 < 0 || bArr.length - i10 < i8 || bArr2.length - i10 < i9) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr3[i11] = (byte) (bArr[i11 + i8] ^ bArr2[i11 + i9]);
        }
        return bArr3;
    }

    public static int v(boolean z, int i8, int i9, String str) {
        while (i8 < i9) {
            char cCharAt = str.charAt(i8);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z)) {
                return i8;
            }
            i8++;
        }
        return i9;
    }

    public static final byte[] v0(byte[] bArr, byte[] bArr2) {
        if (bArr.length == bArr2.length) {
            return u0(0, bArr, 0, bArr2, bArr.length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static final KSerializer w(Collection collection, SerializersModule serializersModule) {
        ArrayList arrayListT0 = c5.m.t0(collection);
        ArrayList arrayList = new ArrayList(c5.o.n0(arrayListT0, 10));
        int size = arrayListT0.size();
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayListT0.get(i9);
            i9++;
            arrayList.add(S(obj, serializersModule));
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            if (hashSet.add(((KSerializer) obj2).getDescriptor().getSerialName())) {
                arrayList2.add(obj2);
            }
        }
        if (arrayList2.size() > 1) {
            StringBuilder sb = new StringBuilder("Serializing collections of different element types is not yet supported. Selected serializers: ");
            ArrayList arrayList3 = new ArrayList(c5.o.n0(arrayList2, 10));
            int size3 = arrayList2.size();
            while (i8 < size3) {
                Object obj3 = arrayList2.get(i8);
                i8++;
                arrayList3.add(((KSerializer) obj3).getDescriptor().getSerialName());
            }
            sb.append(arrayList3);
            throw new IllegalStateException(sb.toString().toString());
        }
        KSerializer<String> kSerializerSerializer = (KSerializer) (arrayList2.size() == 1 ? arrayList2.get(0) : null);
        if (kSerializerSerializer == null) {
            kSerializerSerializer = BuiltinSerializersKt.serializer(kotlin.jvm.internal.c0.f3665a);
        }
        if (!kSerializerSerializer.getDescriptor().isNullable() && (collection == null || !collection.isEmpty())) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    return BuiltinSerializersKt.getNullable(kSerializerSerializer);
                }
            }
        }
        return kSerializerSerializer;
    }

    public static void x(r4.j jVar, p5.p pVar) {
        for (Map.Entry entry : jVar.a()) {
            pVar.invoke((String) entry.getKey(), (List) entry.getValue());
        }
    }

    public static final String y(long j4) {
        return String.format("%6s", Arrays.copyOf(new Object[]{j4 <= -999500000 ? a8.b.r(new StringBuilder(), (j4 - 500000000) / 1000000000, " s ") : j4 <= -999500 ? a8.b.r(new StringBuilder(), (j4 - 500000) / 1000000, " ms") : j4 <= 0 ? a8.b.r(new StringBuilder(), (j4 - 500) / 1000, " µs") : j4 < 999500 ? a8.b.r(new StringBuilder(), (j4 + 500) / 1000, " µs") : j4 < 999500000 ? a8.b.r(new StringBuilder(), (j4 + 500000) / 1000000, " ms") : a8.b.r(new StringBuilder(), (j4 + 500000000) / 1000000000, " s ")}, 1));
    }

    public static n6.o z(String str) {
        kotlin.jvm.internal.p.e(str, "<this>");
        x5.j jVarC = n6.o.f4070b.c(0, str);
        if (jVarC == null) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + AbstractJsonLexerKt.STRING);
        }
        String str2 = (String) ((x5.h) jVarC.a()).get(1);
        Locale locale = Locale.ROOT;
        String lowerCase = str2.toLowerCase(locale);
        kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
        String lowerCase2 = ((String) ((x5.h) jVarC.a()).get(2)).toLowerCase(locale);
        kotlin.jvm.internal.p.d(lowerCase2, "toLowerCase(...)");
        ArrayList arrayList = new ArrayList();
        Matcher matcher = jVarC.f6297a;
        int i8 = r0(matcher.start(), matcher.end()).f5664b;
        while (true) {
            int i9 = i8 + 1;
            if (i9 >= str.length()) {
                return new n6.o(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
            }
            x5.j jVarC2 = n6.o.f4071c.c(i9, str);
            if (jVarC2 == null) {
                StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                String strSubstring = str.substring(i9);
                kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
                sb.append(strSubstring);
                sb.append("\" for: \"");
                sb.append(str);
                sb.append(AbstractJsonLexerKt.STRING);
                throw new IllegalArgumentException(sb.toString().toString());
            }
            Matcher matcher2 = jVarC2.f6297a;
            x5.i iVar = jVarC2.f6299c;
            x5.g gVarG = iVar.g(1);
            String str3 = gVarG != null ? gVarG.f6293a : null;
            if (str3 == null) {
                i8 = r0(matcher2.start(), matcher2.end()).f5664b;
            } else {
                x5.g gVarG2 = iVar.g(2);
                String strSubstring2 = gVarG2 != null ? gVarG2.f6293a : null;
                if (strSubstring2 == null) {
                    x5.g gVarG3 = iVar.g(3);
                    kotlin.jvm.internal.p.b(gVarG3);
                    strSubstring2 = gVarG3.f6293a;
                } else if (x5.n.J1(strSubstring2, '\'') && x5.n.l1(strSubstring2, '\'') && strSubstring2.length() > 2) {
                    strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
                    kotlin.jvm.internal.p.d(strSubstring2, "substring(...)");
                }
                arrayList.add(str3);
                arrayList.add(strSubstring2);
                i8 = r0(matcher2.start(), matcher2.end()).f5664b;
            }
        }
    }

    public abstract void E(t1.w wVar, float f3, float f7);

    public abstract int G();

    public abstract int H();

    public abstract int L();

    public abstract int M();

    public abstract int N(View view);

    public abstract int O(CoordinatorLayout coordinatorLayout);

    public abstract int Q();

    public abstract float R(t1.x xVar);

    public abstract boolean V(float f3);

    public abstract boolean Y(View view);

    public abstract boolean Z(float f3, float f7);

    public abstract void d0(l.f fVar, l.f fVar2);

    public abstract void e0(l.f fVar, Thread thread);

    public abstract int f(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float g(int i8);

    public abstract boolean h(l.g gVar, l.c cVar);

    public abstract boolean i(l.g gVar, Object obj, Object obj2);

    public abstract void i0(RecyclerView recyclerView);

    public abstract boolean j(l.g gVar, l.f fVar, l.f fVar2);

    public abstract void l0(t1.x xVar, float f3);

    public abstract boolean m0(View view, float f3);

    public abstract void s0(ViewGroup.MarginLayoutParams marginLayoutParams, int i8, int i9);
}
