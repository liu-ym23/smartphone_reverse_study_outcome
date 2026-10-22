package com.stepos.statsrpk;

import B0.g;
import S.C0107m;
import Z2.C0125f0;
import Z2.I;
import Z2.r;
import a3.C0160e;
import a3.C0163h;
import a3.C0171p;
import a3.InterfaceC0164i;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import androidx.fragment.app.A;
import androidx.room.AbstractC0351g;
import androidx.room.C0352h;
import ch.qos.logback.core.CoreConstants;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.alphame.utils.Property;
import d3.u;
import f1.AbstractC0557a;
import g1.HandlerC0575c;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.l;
import kotlin.ExceptionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import s.AbstractC0831a;
import t0.J;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static Handler f12358a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f12359b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f12360c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f12361d = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f12362e = "";

    /* renamed from: f, reason: collision with root package name */
    public static String f12363f = "";

    /* renamed from: g, reason: collision with root package name */
    public static String f12364g;

    public static int A(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int iNextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, iNextDouble, iNextDouble2, iNextDouble3);
    }

    public static PointF B(JsonReader jsonReader, float f4) throws IOException {
        int i4 = O0.e.f1527a[jsonReader.peek().ordinal()];
        if (i4 == 1) {
            float fNextDouble = (float) jsonReader.nextDouble();
            float fNextDouble2 = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return new PointF(fNextDouble * f4, fNextDouble2 * f4);
        }
        if (i4 == 2) {
            jsonReader.beginArray();
            float fNextDouble3 = (float) jsonReader.nextDouble();
            float fNextDouble4 = (float) jsonReader.nextDouble();
            while (jsonReader.peek() != JsonToken.END_ARRAY) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return new PointF(fNextDouble3 * f4, fNextDouble4 * f4);
        }
        if (i4 != 3) {
            throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
        }
        jsonReader.beginObject();
        float fQ = Property.DEFAULT_FLOAT_VALUE;
        float fQ2 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("x")) {
                fQ = Q(jsonReader);
            } else if (strNextName.equals("y")) {
                fQ2 = Q(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new PointF(fQ * f4, fQ2 * f4);
    }

    public static ArrayList C(JsonReader jsonReader, float f4) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(B(jsonReader, f4));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static Typeface D(Configuration configuration, Typeface typeface) {
        int i4 = configuration.fontWeightAdjustment;
        if (i4 == Integer.MAX_VALUE || i4 == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, AbstractC0557a.o(typeface.getWeight() + configuration.fontWeightAdjustment, 1, 1000), typeface.isItalic());
    }

    public static void I(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
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

    public static final void J(String str) {
        System.err.println("SLF4J: " + str);
    }

    public static final void K(String str, Throwable th) {
        PrintStream printStream = System.err;
        printStream.println(str);
        printStream.println("Reported exception:");
        th.printStackTrace();
    }

    public static int L(Context context, int i4, int i5) {
        TypedValue typedValueV = AbstractC0557a.V(i4, context);
        return (typedValueV == null || typedValueV.type != 16) ? i5 : typedValueV.data;
    }

    public static TimeInterpolator M(Context context, int i4, Interpolator interpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i4, typedValue, true)) {
            return interpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!z(strValueOf, "cubic-bezier") && !z(strValueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (!z(strValueOf, "cubic-bezier")) {
            if (z(strValueOf, "path")) {
                return new PathInterpolator(J.r(strValueOf.substring(5, strValueOf.length() - 1)));
            }
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
        if (strArrSplit.length == 4) {
            return new PathInterpolator(w(strArrSplit, 0), w(strArrSplit, 1), w(strArrSplit, 2), w(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }

    public static void N(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z4 = onLongClickListener != null;
        boolean z5 = zHasOnClickListeners || z4;
        checkableImageButton.setFocusable(z5);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z4);
        checkableImageButton.setImportantForAccessibility(z5 ? 1 : 2);
    }

    public static final Object O(u uVar, u uVar2, Function2 function2) {
        Object rVar;
        Object objN;
        try {
            rVar = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(uVar2, uVar);
        } catch (Throwable th) {
            rVar = new r(th, false);
        }
        if (rVar != IntrinsicsKt.getCOROUTINE_SUSPENDED() && (objN = uVar.N(rVar)) != I.f2174g) {
            if (objN instanceof r) {
                throw ((r) objN).f2238a;
            }
            return I.G(objN);
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public static float Q(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        int i4 = O0.e.f1527a[jsonTokenPeek.ordinal()];
        if (i4 == 1) {
            return (float) jsonReader.nextDouble();
        }
        if (i4 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + jsonTokenPeek);
        }
        jsonReader.beginArray();
        float fNextDouble = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return fNextDouble;
    }

    public static byte R(Boolean bool) {
        if (bool != null) {
            return !bool.booleanValue() ? (byte) 0 : (byte) 1;
        }
        return (byte) -1;
    }

    public static String S(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            length = objArr.length;
            if (i5 >= length) {
                break;
            }
            Object obj = objArr[i5];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e4) {
                    String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str2), (Throwable) e4);
                    StringBuilder sbW = g.w("<", str2, " threw ");
                    sbW.append(e4.getClass().getName());
                    sbW.append(">");
                    string = sbW.toString();
                }
            }
            objArr[i5] = string;
            i5++;
        }
        StringBuilder sb = new StringBuilder((length * 16) + str.length());
        int i6 = 0;
        while (true) {
            length2 = objArr.length;
            if (i4 >= length2 || (iIndexOf = str.indexOf("%s", i6)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i6, iIndexOf);
            sb.append(objArr[i4]);
            i6 = iIndexOf + 2;
            i4++;
        }
        sb.append((CharSequence) str, i6, str.length());
        if (i4 < length2) {
            sb.append(" [");
            sb.append(objArr[i4]);
            for (int i7 = i4 + 1; i7 < objArr.length; i7++) {
                sb.append(", ");
                sb.append(objArr[i7]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static Boolean T(byte b4) {
        if (b4 == 0) {
            return Boolean.FALSE;
        }
        if (b4 != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public static C0160e a(int i4, int i5, int i6) {
        C0160e c0171p;
        if ((i6 & 2) != 0) {
            i5 = 1;
        }
        if (i4 != -2) {
            if (i4 == -1) {
                if (i5 == 1) {
                    return new C0171p(1, 2, null);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
            if (i4 != 0) {
                return i4 != Integer.MAX_VALUE ? i5 == 1 ? new C0160e(i4, null) : new C0171p(i4, i5, null) : new C0160e(Integer.MAX_VALUE, null);
            }
            c0171p = i5 == 1 ? new C0160e(0, null) : new C0171p(1, i5, null);
        } else if (i5 == 1) {
            InterfaceC0164i.f2311a0.getClass();
            c0171p = new C0160e(C0163h.f2310b, null);
        } else {
            c0171p = new C0171p(1, i5, null);
        }
        return c0171p;
    }

    public static float b(float f4) {
        return f4 <= 0.04045f ? f4 / 12.92f : (float) Math.pow((f4 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float c(float f4) {
        return f4 <= 0.0031308f ? f4 * 12.92f : (float) ((Math.pow(f4, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static void d(Parcel parcel, Parcelable parcelable, int i4) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i4);
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

    public static void f(Runnable runnable) {
        if (f12358a == null) {
            synchronized (c.class) {
                HandlerThread handlerThread = new HandlerThread("com.stepos.statsrpk.apiWorker", 5);
                handlerThread.start();
                f12358a = new HandlerC0575c(handlerThread.getLooper(), 3);
            }
        }
        f12358a.post(runnable);
    }

    public static final String g(String username, String password, Charset charset) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String str = username + CoreConstants.COLON_CHAR + password;
        l lVar = l.f13358d;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return Intrinsics.stringPlus("Basic ", new l(bytes).a());
    }

    public static final C0107m h(Function1 function1, Object obj, CoroutineContext coroutineContext) {
        return new C0107m(2, function1, obj, coroutineContext);
    }

    public static final A i(Function1 function1, Object obj, A a4) {
        try {
            function1.invoke(obj);
        } catch (Throwable th) {
            if (a4 == null || a4.getCause() == th) {
                return new A(AbstractC0351g.o("Exception in undelivered element handler for ", obj), 9, th);
            }
            ExceptionsKt.addSuppressed(a4, th);
        }
        return a4;
    }

    public static void j(String str, boolean z4) {
        if (!z4) {
            throw new IllegalArgumentException(String.valueOf(str));
        }
    }

    public static void k(HandlerC0575c handlerC0575c) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handlerC0575c.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            throw new IllegalStateException("Must be called on " + handlerC0575c.getLooper().getThread().getName() + " thread, but got " + name + ".");
        }
    }

    public static void l(Object obj) {
        if (obj == null) {
            throw new NullPointerException("null reference");
        }
    }

    public static void m(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void n(String str, boolean z4) {
        if (!z4) {
            throw new IllegalStateException(str);
        }
    }

    public static ImageView.ScaleType q(int i4) {
        return i4 != 0 ? i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 5 ? i4 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static int r(float f4, int i4, int i5) {
        float f5 = ((i4 >> 24) & 255) / 255.0f;
        float f6 = ((i5 >> 24) & 255) / 255.0f;
        float fB = b(((i4 >> 16) & 255) / 255.0f);
        float fB2 = b(((i4 >> 8) & 255) / 255.0f);
        float fB3 = b((i4 & 255) / 255.0f);
        float fB4 = b(((i5 >> 16) & 255) / 255.0f);
        float fB5 = b(((i5 >> 8) & 255) / 255.0f);
        float fB6 = b((i5 & 255) / 255.0f);
        float fC = AbstractC0831a.c(f6, f5, f4, f5);
        float fC2 = AbstractC0831a.c(fB4, fB, f4, fB);
        float fC3 = AbstractC0831a.c(fB5, fB2, f4, fB2);
        float fC4 = AbstractC0831a.c(fB6, fB3, f4, fB3);
        float fC5 = c(fC2) * 255.0f;
        float fC6 = c(fC3) * 255.0f;
        return Math.round(c(fC4) * 255.0f) | (Math.round(fC5) << 16) | (Math.round(fC * 255.0f) << 24) | (Math.round(fC6) << 8);
    }

    public static final Object s(androidx.room.A a4, Callable callable, Continuation continuation) {
        if (a4.isOpenInternal() && a4.inTransaction()) {
            return callable.call();
        }
        AbstractC0351g.D(continuation.get$context().get(androidx.room.I.f4193a));
        Map<String, Object> backingFieldMap = a4.getBackingFieldMap();
        Object c0125f0 = backingFieldMap.get("TransactionDispatcher");
        if (c0125f0 == null) {
            c0125f0 = new C0125f0(a4.getTransactionExecutor());
            backingFieldMap.put("TransactionDispatcher", c0125f0);
        }
        Intrinsics.checkNotNull(c0125f0, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return J.O(continuation, (Z2.A) c0125f0, new C0352h(callable, null));
    }

    public static String t(String str) {
        try {
            U2.b.f1913a.getClass();
            Class clsE = X.r.e("android.os.SystemProperties");
            return (String) X.r.f(clsE, String.class).invoke(clsE, str);
        } catch (IllegalArgumentException e4) {
            throw e4;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String u(String str, String str2) {
        try {
            U2.b.f1913a.getClass();
            Class clsE = X.r.e("android.os.SystemProperties");
            return (String) X.r.f(clsE, String.class, String.class).invoke(clsE, str, str2);
        } catch (IllegalArgumentException e4) {
            throw e4;
        } catch (Exception unused) {
            return str2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
    
        r0 = r2.processName;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00a1 -> B:84:0x00a4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String v(android.app.Application r5) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsrpk.c.v(android.app.Application):java.lang.String");
    }

    public static float w(String[] strArr, int i4) throws NumberFormatException {
        float f4 = Float.parseFloat(strArr[i4]);
        if (f4 >= Property.DEFAULT_FLOAT_VALUE && f4 <= 1.0f) {
            return f4;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f4);
    }

    public static boolean z(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public void E(int i4, View view) {
    }

    public abstract void F(int i4);

    public abstract void G(View view, int i4, int i5);

    public abstract void H(View view, float f4, float f5);

    public abstract boolean P(int i4, View view);

    public abstract int o(View view, int i4);

    public abstract int p(View view, int i4);

    public int x(View view) {
        return 0;
    }

    public int y() {
        return 0;
    }
}
