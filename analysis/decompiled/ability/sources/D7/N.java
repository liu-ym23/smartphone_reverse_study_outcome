package D7;

import X8.S;
import android.R;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.opengl.GLES20;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import androidx.core.graphics.PathParser;
import b8.d0;
import b8.i0;
import c3.AbstractC0872b;
import com.stepos.ability.voicewakeup.training.TrainingActivity;
import com.stepos.aiengine.args.SingleFileBundle;
import g1.AbstractC1451a;
import h8.InterfaceC1519b;
import h8.InterfaceC1536s;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import k8.Q;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.builders.SetBuilder;
import okhttp3.Protocol;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class N {

    /* renamed from: a, reason: collision with root package name */
    public static ArrayList f399a = null;
    public static int b = 3;
    public static int c = 3;
    public static int d = 3;
    public static boolean e = false;
    public static final w.f f = new w.f(0);
    public static long g = -1;

    public static final Object A(d0 d0Var) {
        i0 i0VarP = d0Var.p();
        return H4.o.u(i0VarP.f2043j, i0VarP.g());
    }

    public static com.stepos.taskrobot.taskmemory.b B() {
        return (com.stepos.taskrobot.taskmemory.b) com.stepos.taskrobot.taskmemory.b.f4062a.getF4884a();
    }

    public static float C(String[] strArr, int i) throws NumberFormatException {
        float f7 = Float.parseFloat(strArr[i]);
        if (f7 >= 0.0f && f7 <= 1.0f) {
            return f7;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f7);
    }

    public static Set D(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("voice_wakeup_active_word", 0);
        Set<String> set = EmptySet.f4895a;
        Set<String> stringSet = sharedPreferences.getStringSet("trained_ids", set);
        if (stringSet != null) {
            set = stringSet;
        }
        return v.j1(set);
    }

    public static List E(Context context) {
        Set setD = D(context);
        if (setD.isEmpty()) {
            return EmptyList.f4893a;
        }
        List list = (List) C4.h.e.getF4884a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (setD.contains(((C4.g) obj).f296a)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static boolean F(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0115, code lost:
    
        if (kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(r0).equals(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(r2)) == false) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static z8.m G(h8.InterfaceC1536s r8, k8.Q r9) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D7.N.G(h8.s, k8.Q):z8.m");
    }

    public static LinkedHashSet H(Set set, Object obj) {
        kotlin.jvm.internal.k.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(kotlin.collections.a.P(set.size()));
        boolean z10 = false;
        for (Object obj2 : set) {
            boolean z11 = true;
            if (!z10 && kotlin.jvm.internal.k.b(obj2, obj)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                linkedHashSet.add(obj2);
            }
        }
        return linkedHashSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e0, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static V9.p I(okio.ByteString... r11) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D7.N.I(okio.ByteString[]):V9.p");
    }

    public static D9.l J(String statusLine) throws ProtocolException, NumberFormatException {
        int i;
        String strSubstring;
        kotlin.jvm.internal.k.f(statusLine, "statusLine");
        boolean zE0 = j9.t.e0(statusLine, "HTTP/1.", false);
        Protocol protocol = Protocol.HTTP_1_0;
        if (zE0) {
            i = 9;
            if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            int iCharAt = statusLine.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                protocol = Protocol.HTTP_1_1;
            }
        } else {
            if (!j9.t.e0(statusLine, "ICY ", false)) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            i = 4;
        }
        int i6 = i + 3;
        if (statusLine.length() < i6) {
            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
        }
        try {
            String strSubstring2 = statusLine.substring(i, i6);
            kotlin.jvm.internal.k.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            int i10 = Integer.parseInt(strSubstring2);
            if (statusLine.length() <= i6) {
                strSubstring = "";
            } else {
                if (statusLine.charAt(i6) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                strSubstring = statusLine.substring(i + 4);
                kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            }
            return new D9.l(protocol, i10, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
        }
    }

    public static float K(float f7, float f9, float f10, float f11, float f12) {
        if (f12 <= 0.0f) {
            return 0.0f;
        }
        if (f12 >= 1.0f) {
            return 1.0f;
        }
        float fT = f12;
        for (int i = 0; i < 6; i++) {
            float fL = l(f7, f10, fT) - f12;
            float f13 = 1.0f - fT;
            float f14 = 3.0f * fT * fT;
            float fB = B7.a.b(1.0f, f10, f14, B7.a.b(f10, f7, f13 * 6.0f * fT, f13 * 3.0f * f13 * f7));
            if (Math.abs(fB) > 1.0E-6f) {
                fT = AbstractC1451a.t(fT - (fL / fB), 0.0f, 1.0f);
            }
        }
        return l(f9, f11, fT);
    }

    public static LinkedHashSet L(Set set, Iterable elements) {
        kotlin.jvm.internal.k.f(set, "<this>");
        kotlin.jvm.internal.k.f(elements, "elements");
        Integer numValueOf = elements instanceof Collection ? Integer.valueOf(((Collection) elements).size()) : null;
        LinkedHashSet linkedHashSet = new LinkedHashSet(kotlin.collections.a.P(numValueOf != null ? set.size() + numValueOf.intValue() : set.size() * 2));
        linkedHashSet.addAll(set);
        A.e0(elements, linkedHashSet);
        return linkedHashSet;
    }

    public static LinkedHashSet M(Set set, Object obj) {
        kotlin.jvm.internal.k.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(kotlin.collections.a.P(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(obj);
        return linkedHashSet;
    }

    public static int N(Context context, int i, int i6) {
        TypedValue typedValueA = AbstractC0872b.a(i, context);
        return (typedValueA == null || typedValueA.type != 16) ? i6 : typedValueA.data;
    }

    public static TimeInterpolator O(Context context, int i, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!F(strValueOf, "cubic-bezier") && !F(strValueOf, SingleFileBundle.KEY_PATH)) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (!F(strValueOf, "cubic-bezier")) {
            if (F(strValueOf, SingleFileBundle.KEY_PATH)) {
                return new PathInterpolator(PathParser.createPathFromPathData(strValueOf.substring(5, strValueOf.length() - 1)));
            }
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
        if (strArrSplit.length == 4) {
            return new PathInterpolator(C(strArrSplit, 0), C(strArrSplit, 1), C(strArrSplit, 2), C(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }

    public static Triple P(float f7, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20) {
        Float fValueOf = Float.valueOf(0.0f);
        if (f14 < 0.001f) {
            return new Triple(fValueOf, fValueOf, fValueOf);
        }
        return new Triple(Float.valueOf(Math.max((((f10 - f7) * f12) + f7) * f19 * 0.5f, 1.0f)), Float.valueOf(Math.max((((f11 - f9) * f12) + f9) * f19 * 0.5f, 1.0f)), Float.valueOf(Math.max(((((f16 - f15) * f12) + f15) * f19 * 0.5f) + ((((f18 - f17) * f13) + f17) * f20), 1.0f) * 3.0f));
    }

    public static Set Q(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        kotlin.jvm.internal.k.e(setSingleton, "singleton(...)");
        return setSingleton;
    }

    public static FloatBuffer R(float[] fArr) {
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    public static void S(Parcel parcel, Parcelable parcelable, int i) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i);
        }
    }

    public static Object a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static int b(JSONObject jSONObject, int i, String... strArr) {
        JSONObject jSONObjectQ = q(jSONObject, strArr);
        if (jSONObjectQ == null) {
            return i;
        }
        int iOptInt = jSONObjectQ.optInt(strArr[strArr.length - 1], i);
        S0.b.c0("JSONUtil", "normal get jsonInt: " + strArr[strArr.length - 1] + " : " + iOptInt);
        return iOptInt;
    }

    public static String c(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    public static String d(String str, Map map) {
        if (!TextUtils.isDigitsOnly(str) && map != null && !map.isEmpty()) {
            if (str.indexOf("?") < 0) {
                str = str.concat("?");
            }
            if (str.endsWith("?")) {
                StringBuilder sbV = androidx.compose.foundation.b.v(str);
                sbV.append(c("sdk_version"));
                sbV.append("=");
                sbV.append(c(String.valueOf(1)));
                str = sbV.toString();
            } else {
                StringBuilder sbX = androidx.appfunctions.metadata.a.x(str, "&");
                sbX.append(c("sdk_version"));
                sbX.append("=");
                sbX.append(c(String.valueOf(1)));
                str = sbX.toString();
            }
            if (map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    if (map.get(entry.getKey()) != null) {
                        if (str.endsWith("?")) {
                            StringBuilder sbV2 = androidx.compose.foundation.b.v(str);
                            sbV2.append(c(entry.getKey().toString()));
                            sbV2.append("=");
                            sbV2.append(c(((String) map.get(entry.getKey())).toString()));
                            str = sbV2.toString();
                        } else {
                            StringBuilder sbX2 = androidx.appfunctions.metadata.a.x(str, "&");
                            sbX2.append(c(entry.getKey().toString()));
                            sbX2.append("=");
                            sbX2.append(c(((String) map.get(entry.getKey())).toString()));
                            str = sbX2.toString();
                        }
                    }
                }
            }
        }
        return str;
    }

    public static JSONArray e(JSONArray jSONArray) {
        int i;
        if (jSONArray.length() <= 384) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i6 = 0;
        while (true) {
            if (i6 >= 256) {
                break;
            }
            jSONArray2.put(jSONArray.opt(i6));
            i6++;
        }
        for (i = 256; i < 384; i++) {
            jSONArray2.put(jSONArray.opt(jSONArray.length() - (384 - i)));
        }
        return jSONArray2;
    }

    public static JSONArray f(JSONObject jSONObject, String... strArr) {
        JSONObject jSONObjectQ = q(jSONObject, strArr);
        if (jSONObjectQ == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectQ.optJSONArray(strArr[strArr.length - 1]);
        S0.b.c0("ApmConfig", "normal get configArray: " + strArr[strArr.length - 1] + " : " + jSONArrayOptJSONArray);
        return jSONArrayOptJSONArray;
    }

    public static boolean g(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static boolean h(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0 || g(jSONObject.optJSONArray("logcat"));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0106  */
    /* JADX WARN: Type inference failed for: r0v40, types: [C7.f, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final c8.e i(b8.d0 r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D7.N.i(b8.d0, boolean):c8.e");
    }

    public static void j(TrainingActivity trainingActivity, String wordId, String keyphrase) {
        kotlin.jvm.internal.k.f(wordId, "wordId");
        kotlin.jvm.internal.k.f(keyphrase, "keyphrase");
        if (wordId.length() == 0) {
            return;
        }
        Log.i("WakeupWordStorage", "addTrained id=" + wordId + " keyphraseLen=" + keyphrase.length());
        Set<String> setD = D(trainingActivity);
        if (!setD.contains(wordId)) {
            setD = M(setD, wordId);
        }
        trainingActivity.getApplicationContext().getSharedPreferences("voice_wakeup_active_word", 0).edit().putStringSet("trained_ids", setD).putString("keyphrase_".concat(wordId), keyphrase).apply();
    }

    public static String k(JSONObject jSONObject, String... strArr) {
        JSONObject jSONObjectQ = q(jSONObject, strArr);
        if (jSONObjectQ == null) {
            return null;
        }
        String strOptString = jSONObjectQ.optString(strArr[strArr.length - 1]);
        S0.b.c0("ApmConfig", "normal get configArray: " + strArr[strArr.length - 1] + " : " + strOptString);
        return strOptString;
    }

    public static float l(float f7, float f9, float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        float f13 = f11 * f12 * f10 * f7;
        return (f10 * f10 * f10) + (f12 * f10 * f10 * f9) + f13;
    }

    public static SetBuilder m(SetBuilder setBuilder) {
        setBuilder.f4904a.b();
        return setBuilder.size() > 0 ? setBuilder : SetBuilder.b;
    }

    public static final StateListDrawable n(Context context, float[] radii, int i, boolean z10) {
        kotlin.jvm.internal.k.f(radii, "radii");
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (z10) {
            stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, new LayerDrawable(new GradientDrawable[]{o(radii, i), o(radii, context.getColor(com.stepos.ability.R.color.stepos_list_item_pressed))}));
        }
        stateListDrawable.addState(new int[0], o(radii, i));
        return stateListDrawable;
    }

    public static final GradientDrawable o(float[] fArr, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii((float[]) fArr.clone());
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    public static void p(long j5, V9.g gVar, int i, ArrayList arrayList, int i6, int i10, ArrayList arrayList2) {
        int i11;
        int i12;
        ArrayList arrayList3;
        long j6;
        int i13;
        int i14 = i;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i6 >= i10) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i15 = i6; i15 < i10; i15++) {
            if (((ByteString) arrayList4.get(i15)).c() < i14) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        ByteString byteString = (ByteString) arrayList.get(i6);
        ByteString byteString2 = (ByteString) arrayList4.get(i10 - 1);
        if (i14 == byteString.c()) {
            int iIntValue = ((Number) arrayList5.get(i6)).intValue();
            int i16 = i6 + 1;
            ByteString byteString3 = (ByteString) arrayList4.get(i16);
            i11 = i16;
            i12 = iIntValue;
            byteString = byteString3;
        } else {
            i11 = i6;
            i12 = -1;
        }
        if (byteString.f(i14) == byteString2.f(i14)) {
            int iMin = Math.min(byteString.c(), byteString2.c());
            int i17 = 0;
            for (int i18 = i14; i18 < iMin && byteString.f(i18) == byteString2.f(i18); i18++) {
                i17++;
            }
            long j10 = 4;
            long j11 = (gVar.b / j10) + j5 + 2 + i17 + 1;
            gVar.O(-i17);
            gVar.O(i12);
            int i19 = i14 + i17;
            while (i14 < i19) {
                gVar.O(byteString.f(i14) & 255);
                i14++;
            }
            if (i11 + 1 == i10) {
                if (i19 != ((ByteString) arrayList4.get(i11)).c()) {
                    throw new IllegalStateException("Check failed.");
                }
                gVar.O(((Number) arrayList5.get(i11)).intValue());
                return;
            } else {
                V9.g gVar2 = new V9.g();
                gVar.O(((int) ((gVar2.b / j10) + j11)) * (-1));
                p(j11, gVar2, i19, arrayList4, i11, i10, arrayList5);
                gVar.B(gVar2);
                return;
            }
        }
        int i20 = 1;
        for (int i21 = i11 + 1; i21 < i10; i21++) {
            if (((ByteString) arrayList4.get(i21 - 1)).f(i14) != ((ByteString) arrayList4.get(i21)).f(i14)) {
                i20++;
            }
        }
        long j12 = 4;
        long j13 = (gVar.b / j12) + j5 + 2 + (i20 * 2);
        gVar.O(i20);
        gVar.O(i12);
        for (int i22 = i11; i22 < i10; i22++) {
            int iF = ((ByteString) arrayList4.get(i22)).f(i14);
            if (i22 == i11 || iF != ((ByteString) arrayList4.get(i22 - 1)).f(i14)) {
                gVar.O(iF & 255);
            }
        }
        V9.g gVar3 = new V9.g();
        int i23 = i11;
        while (i23 < i10) {
            byte bF = ((ByteString) arrayList4.get(i23)).f(i14);
            int i24 = i23 + 1;
            int i25 = i24;
            while (true) {
                if (i25 >= i10) {
                    i25 = i10;
                    break;
                } else if (bF != ((ByteString) arrayList4.get(i25)).f(i14)) {
                    break;
                } else {
                    i25++;
                }
            }
            if (i24 == i25 && i14 + 1 == ((ByteString) arrayList4.get(i23)).c()) {
                gVar.O(((Number) arrayList5.get(i23)).intValue());
                arrayList3 = arrayList5;
                j6 = j13;
                i13 = i25;
            } else {
                gVar.O(((int) ((gVar3.b / j12) + j13)) * (-1));
                arrayList3 = arrayList5;
                j6 = j13;
                i13 = i25;
                p(j6, gVar3, i14 + 1, arrayList, i23, i13, arrayList3);
                arrayList4 = arrayList;
            }
            j13 = j6;
            i23 = i13;
            arrayList5 = arrayList3;
        }
        gVar.B(gVar3);
    }

    public static JSONObject q(JSONObject jSONObject, String... strArr) {
        if (jSONObject == null) {
            RuntimeException runtimeException = new RuntimeException();
            if (com.apm.insight.g.g.isDebugMode()) {
                Log.e("npth", "JSONUtil err get JsonFromParent: null json", runtimeException);
            }
            return null;
        }
        for (int i = 0; i < strArr.length - 1; i++) {
            jSONObject = jSONObject.optJSONObject(strArr[i]);
            if (jSONObject == null) {
                S0.b.c0("JSONUtil", "err get json: not found node:" + strArr[i]);
                return null;
            }
        }
        return jSONObject;
    }

    public static void r(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException(androidx.appfunctions.metadata.a.j(obj2, "null key in entry: null="));
        }
        if (obj2 == null) {
            throw new NullPointerException(androidx.compose.foundation.b.s(obj, "null value in entry: ", "=null"));
        }
    }

    public static float s(float f7, float f9, float f10, float f11, float f12) {
        if (f7 >= f9) {
            if (f7 < f9 + f10) {
                return K(0.17f, 0.0f, 0.83f, 1.0f, (f7 - f9) / Math.max(f10, 0.001f));
            }
            if (f7 < f11) {
                return 1.0f;
            }
            if (f7 < f11 + f12) {
                return 1.0f - K(0.3f, 0.0f, 0.66f, 1.0f, (f7 - f11) / Math.max(f12, 0.001f));
            }
        }
        return 0.0f;
    }

    public static final void t(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                S0.b.e0(th, th2);
            }
        }
    }

    public static int u(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateShader;
        }
        throw new IllegalStateException(B7.a.k("compile failed: ", GLES20.glGetShaderInfoLog(iGlCreateShader)).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final c8.v v(b8.d0 r4, boolean r5, java.lang.reflect.Field r6) {
        /*
            b8.i0 r0 = r4.p()
            h8.I r0 = r0.g()
            h8.j r1 = r0.d()
            java.lang.String r2 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.k.e(r1, r2)
            boolean r2 = J8.e.l(r1)
            r3 = 1
            if (r2 != 0) goto L19
            goto L3c
        L19:
            h8.j r1 = r1.d()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r2 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.b
            boolean r2 = J8.e.n(r1, r2)
            if (r2 != 0) goto L2d
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r2 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.e
            boolean r1 = J8.e.n(r1, r2)
            if (r1 == 0) goto L46
        L2d:
            boolean r1 = r0 instanceof V8.r
            if (r1 == 0) goto L3c
            V8.r r0 = (V8.r) r0
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r0 = r0.f1402A
            boolean r0 = F8.i.d(r0)
            if (r0 == 0) goto L3c
            goto L46
        L3c:
            int r0 = r6.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 != 0) goto L86
        L46:
            java.lang.String r0 = "field"
            if (r5 == 0) goto L64
            boolean r5 = r4.n()
            if (r5 == 0) goto L5a
            c8.h r5 = new c8.h
            java.lang.Object r4 = A(r4)
            r5.<init>(r4, r6)
            return r5
        L5a:
            c8.j r4 = new c8.j
            kotlin.jvm.internal.k.f(r6, r0)
            r5 = 0
            r4.<init>(r6, r3, r5)
            return r4
        L64:
            boolean r5 = r4.n()
            if (r5 == 0) goto L78
            c8.l r5 = new c8.l
            boolean r0 = w(r4)
            java.lang.Object r4 = A(r4)
            r5.<init>(r6, r0, r4)
            return r5
        L78:
            c8.n r5 = new c8.n
            boolean r4 = w(r4)
            kotlin.jvm.internal.k.f(r6, r0)
            r0 = 0
            r5.<init>(r6, r4, r3, r0)
            return r5
        L86:
            b8.i0 r0 = r4.p()
            h8.I r0 = r0.g()
            i8.g r0 = r0.getAnnotations()
            G8.c r1 = b8.v0.f2060a
            boolean r0 = r0.k(r1)
            r1 = 0
            if (r0 == 0) goto Lcb
            if (r5 == 0) goto Lb0
            boolean r4 = r4.n()
            if (r4 == 0) goto La9
            c8.i r4 = new c8.i
            r4.<init>(r6, r1)
            return r4
        La9:
            c8.j r4 = new c8.j
            r5 = 1
            r4.<init>(r6, r3, r5)
            return r4
        Lb0:
            boolean r5 = r4.n()
            if (r5 == 0) goto Lc0
            c8.m r5 = new c8.m
            boolean r4 = w(r4)
            r5.<init>(r6, r4, r1)
            return r5
        Lc0:
            c8.n r5 = new c8.n
            boolean r4 = w(r4)
            r0 = 1
            r5.<init>(r6, r4, r3, r0)
            return r5
        Lcb:
            if (r5 == 0) goto Ld4
            c8.j r4 = new c8.j
            r5 = 2
            r4.<init>(r6, r1, r5)
            return r4
        Ld4:
            c8.n r5 = new c8.n
            boolean r4 = w(r4)
            r0 = 2
            r5.<init>(r6, r4, r1, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: D7.N.v(b8.d0, boolean, java.lang.reflect.Field):c8.v");
    }

    public static final boolean w(d0 d0Var) {
        return !S.e(d0Var.p().g().getType());
    }

    public static int x(String str, String str2) {
        int iU = u(35633, str);
        int iU2 = u(35632, str2);
        int iGlCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(iGlCreateProgram, iU);
        GLES20.glAttachShader(iGlCreateProgram, iU2);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            throw new IllegalStateException(B7.a.k("link failed: ", GLES20.glGetProgramInfoLog(iGlCreateProgram)).toString());
        }
        GLES20.glDeleteShader(iU);
        GLES20.glDeleteShader(iU2);
        return iGlCreateProgram;
    }

    public static boolean y(InterfaceC1519b superDescriptor, InterfaceC1519b subDescriptor) {
        kotlin.jvm.internal.k.f(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.k.f(subDescriptor, "subDescriptor");
        if (!(subDescriptor instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.a) || !(superDescriptor instanceof InterfaceC1536s)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.a) subDescriptor;
        aVar.x().size();
        InterfaceC1536s interfaceC1536s = (InterfaceC1536s) superDescriptor;
        interfaceC1536s.x().size();
        List listX = aVar.a().x();
        kotlin.jvm.internal.k.e(listX, "getValueParameters(...)");
        List listX2 = interfaceC1536s.a().x();
        kotlin.jvm.internal.k.e(listX2, "getValueParameters(...)");
        Iterator it = v.m1(listX, listX2).iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Q q5 = (Q) pair.f4886a;
            Q q10 = (Q) pair.b;
            kotlin.jvm.internal.k.c(q5);
            boolean z10 = G((InterfaceC1536s) subDescriptor, q5) instanceof z8.l;
            kotlin.jvm.internal.k.c(q10);
            if (z10 != (G(interfaceC1536s, q10) instanceof z8.l)) {
                return true;
            }
        }
        return false;
    }

    public static String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        kotlin.jvm.internal.k.c(str);
        if (!j9.t.e0(str, "16-", false)) {
            return null;
        }
        String strSubstring = str.substring(3);
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        int length = strSubstring.length() - 1;
        int i = 0;
        boolean z10 = false;
        while (i <= length) {
            boolean z11 = kotlin.jvm.internal.k.g(strSubstring.charAt(!z10 ? i : length), 32) <= 0;
            if (z10) {
                if (!z11) {
                    break;
                }
                length--;
            } else if (z11) {
                i++;
            } else {
                z10 = true;
            }
        }
        String string = strSubstring.subSequence(i, length + 1).toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return "16-" + new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date(Long.parseLong(string) * 1000));
        } catch (Exception unused) {
            return null;
        }
    }
}
