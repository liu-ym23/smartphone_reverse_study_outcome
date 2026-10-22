package a;

import A0.f;
import D7.N;
import D7.v;
import D7.w;
import I8.l;
import O7.i;
import Q8.n;
import Q8.o;
import S0.b;
import Y7.e;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.widget.EditText;
import com.apm.insight.IUploadCallback;
import com.apm.insight.g;
import com.stepos.statsrpk.d;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import com.volcengine.tos.TosClientException;
import e1.C1403b;
import e2.C1404a;
import io.modelcontextprotocol.spec.HttpHeaders;
import j2.RunnableC1594a;
import j9.AbstractC1607a;
import j9.t;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r.C1871c;
import t8.C2026c;
import x8.InterfaceC2119b;
import y2.AbstractC2128a;
import z8.r;

/* renamed from: a.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0291a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f1622a = false;
    public static boolean c = false;
    public static String d;
    public static JSONObject e;
    public static JSONObject g;

    /* renamed from: j, reason: collision with root package name */
    public static HashMap f1623j;
    public static final f b = new f();
    public static final String[] f = {"GET", "POST"};
    public static final String[] h = {"aid", "app_version", "tt_data", "device_id"};
    public static final String[] i = {"aid", "version_code", "ab_version", "iid", "device_platform"};

    public static final g9.f A(ArrayList arrayList) {
        g9.f fVar = new g9.f();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            o oVar = (o) next;
            if (oVar != null && oVar != n.b) {
                fVar.add(next);
            }
        }
        return fVar;
    }

    public static C8.a B(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        Y7.f fVar = new Y7.f(1, dataInputStream.readInt(), 1);
        ArrayList arrayList = new ArrayList(w.c0(fVar, 10));
        e eVarB = fVar.iterator();
        while (eVarB.c) {
            eVarB.nextInt();
            arrayList.add(Integer.valueOf(dataInputStream.readInt()));
        }
        int[] iArrE1 = v.e1(arrayList);
        return new C8.a(Arrays.copyOf(iArrE1, iArrE1.length));
    }

    public static String C(Path path) throws IOException {
        Charset charset = AbstractC1607a.f4778a;
        k.f(path, "<this>");
        k.f(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), charset);
        try {
            String strO1 = b.o1(inputStreamReader);
            inputStreamReader.close();
            return strO1;
        } finally {
        }
    }

    public static final String D(G8.f fVar) {
        k.f(fVar, "<this>");
        String strB = fVar.b();
        k.e(strB, "asString(...)");
        if (!l.f850a.contains(strB)) {
            int i6 = 0;
            while (true) {
                if (i6 < strB.length()) {
                    char cCharAt = strB.charAt(i6);
                    if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_') {
                        break;
                    }
                    i6++;
                } else if (strB.length() != 0 && Character.isJavaIdentifierStart(strB.codePointAt(0))) {
                    String strB2 = fVar.b();
                    k.e(strB2, "asString(...)");
                    return strB2;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        String strB3 = fVar.b();
        k.e(strB3, "asString(...)");
        sb.append("`".concat(strB3));
        sb.append('`');
        return sb.toString();
    }

    public static final String E(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            G8.f fVar = (G8.f) it.next();
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(D(fVar));
        }
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public static final String F(String lowerRendered, String lowerPrefix, String upperRendered, String upperPrefix, String foldedPrefix) {
        k.f(lowerRendered, "lowerRendered");
        k.f(lowerPrefix, "lowerPrefix");
        k.f(upperRendered, "upperRendered");
        k.f(upperPrefix, "upperPrefix");
        k.f(foldedPrefix, "foldedPrefix");
        if (!t.e0(lowerRendered, lowerPrefix, false) || !t.e0(upperRendered, upperPrefix, false)) {
            return null;
        }
        String strSubstring = lowerRendered.substring(lowerPrefix.length());
        k.e(strSubstring, "substring(...)");
        String strSubstring2 = upperRendered.substring(upperPrefix.length());
        k.e(strSubstring2, "substring(...)");
        String strConcat = foldedPrefix.concat(strSubstring);
        if (strSubstring.equals(strSubstring2)) {
            return strConcat;
        }
        if (!J(strSubstring, strSubstring2)) {
            return null;
        }
        return strConcat + '!';
    }

    public static final C2026c G(K1.a aVar, InterfaceC2119b annotationsOwner) {
        k.f(aVar, "<this>");
        k.f(annotationsOwner, "annotationsOwner");
        return new C2026c(aVar, annotationsOwner, false);
    }

    public static G7.a H(String str, S7.a aVar) {
        G7.a aVar2 = new G7.a(aVar);
        aVar2.setDaemon(true);
        if (str != null) {
            aVar2.setName(str);
        }
        aVar2.start();
        return aVar2;
    }

    public static String I(InputStream inputStream, String str) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i6 = inputStream.read(bArr);
                if (i6 == -1) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, i6);
            }
        } catch (IOException e6) {
            throw new TosClientException(B7.a.m("tos: read ", str, " from body failed"), e6);
        }
    }

    public static final boolean J(String lower, String upper) {
        k.f(lower, "lower");
        k.f(upper, "upper");
        if (lower.equals(t.c0(upper, "?", ""))) {
            return true;
        }
        if (t.W(upper, "?", false) && k.b(lower.concat("?"), upper)) {
            return true;
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(lower);
        sb.append(")?");
        return k.b(sb.toString(), upper);
    }

    public static final void K(Path path, CharSequence text, Charset charset, OpenOption... openOptionArr) throws IOException {
        k.f(path, "<this>");
        k.f(text, "text");
        k.f(charset, "charset");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        try {
            if (text instanceof String) {
                k.c(outputStreamNewOutputStream);
                i.Z(outputStreamNewOutputStream, (String) text, charset);
            } else {
                CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
                CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
                CharsetEncoder charsetEncoderOnUnmappableCharacter = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
                CharBuffer charBufferAsReadOnlyBuffer = text instanceof CharBuffer ? ((CharBuffer) text).asReadOnlyBuffer() : CharBuffer.wrap(text);
                int iMin = Math.min(text.length(), 8192);
                k.c(charsetEncoderOnUnmappableCharacter);
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iMin * ((int) Math.ceil(charsetEncoderOnUnmappableCharacter.maxBytesPerChar())));
                k.e(byteBufferAllocate, "allocate(...)");
                while (charBufferAsReadOnlyBuffer.hasRemaining()) {
                    if (charsetEncoderOnUnmappableCharacter.encode(charBufferAsReadOnlyBuffer, byteBufferAllocate, true).isError()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    outputStreamNewOutputStream.write(byteBufferAllocate.array(), 0, byteBufferAllocate.position());
                    byteBufferAllocate.clear();
                }
            }
            N.t(outputStreamNewOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                N.t(outputStreamNewOutputStream, th);
                throw th2;
            }
        }
    }

    public static Object a(Parcel parcel) {
        Parcelable.Creator creator = Bundle.CREATOR;
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static void b(Parcel parcel, Bundle bundle) {
        if (bundle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(java.lang.String[] r12, byte[] r13, s.g r14) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.AbstractC0291a.c(java.lang.String[], byte[], s.g):int");
    }

    public static String d() {
        return g.f2160a.getFilesDir() + "/apminsight/selflib/libapminsightb.so";
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i6 = C1404a.e;
        Uri uri = Uri.parse(str);
        String query = uri.getQuery();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 4; i10++) {
            String str2 = h[i10];
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            builderBuildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        builderBuildUpon.appendQueryParameter("tt_info", new String(Base64.encode(d.f(query), 8)));
        return builderBuildUpon.build().toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b8 A[Catch: all -> 0x01bb, TRY_ENTER, TryCatch #2 {all -> 0x01bb, blocks: (B:70:0x01a8, B:75:0x01b8, B:76:0x01ba), top: B:84:0x01a8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String f(java.lang.String r8, java.util.HashMap r9, byte[] r10) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.AbstractC0291a.f(java.lang.String, java.util.HashMap, byte[]):java.lang.String");
    }

    public static String g(String str, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            byte[] bArrDecode = Base64.decode(bArr, 0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            String str2 = new String(cipher.doFinal(bArrDecode));
            try {
                int iIndexOf = str2.indexOf("$");
                if (iIndexOf != -1) {
                    return str2.substring(0, iIndexOf);
                }
            } catch (Exception unused) {
            }
            return str2;
        } catch (Exception unused2) {
            return "";
        }
    }

    public static HashMap h() {
        HashMap map = new HashMap(4);
        int i6 = C1404a.e;
        map.put(HttpHeaders.CONTENT_TYPE, "application/octet-stream;tt-data=a");
        map.put("Content-Encoding", "gzip");
        return map;
    }

    public static JSONArray i(File file, File file2) {
        int iIndexOf;
        List list;
        HashMap map = new HashMap();
        try {
            JSONArray jSONArrayC = M.a.C(file.getAbsolutePath());
            if (jSONArrayC != null) {
                for (int i6 = 0; i6 < jSONArrayC.length(); i6++) {
                    String strOptString = jSONArrayC.optString(i6);
                    if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("[tid:0") && strOptString.endsWith("sigstack:0x0]")) {
                        int iIndexOf2 = strOptString.indexOf("[routine:0x");
                        int i10 = iIndexOf2 + 11;
                        String strSubstring = iIndexOf2 > 0 ? strOptString.substring(i10, strOptString.indexOf(93, i10)) : "unknown addr";
                        List arrayList = (List) map.get(strSubstring);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            map.put(strSubstring, arrayList);
                        }
                        arrayList.add(strOptString);
                    }
                }
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            int i11 = com.apm.insight.b.f2156a;
            M0.i.k("NPTH_CATCH", th);
        }
        JSONArray jSONArray = new JSONArray();
        if (!map.isEmpty()) {
            try {
                JSONArray jSONArrayC2 = M.a.C(file2.getAbsolutePath());
                if (jSONArrayC2 != null) {
                    for (int i12 = 0; i12 < jSONArrayC2.length(); i12++) {
                        String strOptString2 = jSONArrayC2.optString(i12);
                        if (!TextUtils.isEmpty(strOptString2) && (iIndexOf = strOptString2.indexOf(":")) > 2) {
                            String strSubstring2 = strOptString2.substring(2, iIndexOf);
                            if (map.containsKey(strSubstring2) && (list = (List) map.get(strSubstring2)) != null) {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    jSONArray.put(((String) it.next()) + " " + strOptString2);
                                }
                                map.remove(strSubstring2);
                            }
                        }
                    }
                    Iterator it2 = map.values().iterator();
                    while (it2.hasNext()) {
                        Iterator it3 = ((List) it2.next()).iterator();
                        while (it3.hasNext()) {
                            jSONArray.put(((String) it3.next()) + "  0x000000:unknown");
                        }
                    }
                }
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                int i13 = com.apm.insight.b.f2156a;
                M0.i.k("NPTH_CATCH", th2);
            }
        }
        return jSONArray;
    }

    public static void j() {
        JSONObject jSONObject;
        if (d == null) {
            d = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + g.f2160a.getPackageName() + "/AutomationTestInfo.json";
        }
        if (e == null) {
            try {
                e = new JSONObject(M.a.w(d));
            } catch (IOException unused) {
                jSONObject = new JSONObject();
                e = jSONObject;
            } catch (JSONException unused2) {
                jSONObject = new JSONObject();
                e = jSONObject;
            }
        }
    }

    public static void k(String str, Map map, Map map2, Map map3, IUploadCallback iUploadCallback) {
        try {
            z2.l.i().a(new RunnableC1594a(System.currentTimeMillis(), str, map, map2, map3, iUploadCallback));
        } catch (Throwable unused) {
        }
    }

    public static void l(JSONObject jSONObject) {
        try {
            long jOptLong = jSONObject.optLong("server_time");
            if (jOptLong > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("server_time", jOptLong);
                jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                g = jSONObject2;
            }
        } catch (Exception unused) {
        }
    }

    public static void m(String... strArr) {
        StringBuilder sb = new StringBuilder(400);
        for (String str : strArr) {
            sb.append(str);
        }
        Log.d("ApmInsight", sb.toString());
    }

    public static boolean n(C1871c c1871c, JSONObject jSONObject, String str) {
        C1871c c1871c2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("header", c1871c.f.d());
            JSONArray jSONArray = new JSONArray();
            if (jSONObject != null) {
                jSONArray.put(jSONObject);
            }
            jSONObject2.put("event_v3", jSONArray);
        } catch (JSONException unused) {
        }
        HashMap mapH = h();
        mapH.put("Cookie", str);
        try {
            if (new JSONObject(f("https://databyterangers.com.cn/simulator/mobile/log", mapH, d.f(jSONObject2.toString()))).getJSONObject(SettingsConfig.KEY_DATA).getBoolean("keep") || (c1871c2 = C1404a.c(c1871c.f.a()).c) == null) {
                return true;
            }
            c1871c2.g.removeMessages(15);
            c1871c2.g.obtainMessage(15, new Object[]{Boolean.FALSE, str}).sendToTarget();
            return true;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static String o() {
        String str = "";
        if (!AbstractC2128a.d()) {
            String str2 = Build.DISPLAY;
            if (!str2.contains("Flyme") && !Build.USER.equals("flyme")) {
                String str3 = Build.MANUFACTURER;
                if (!(!TextUtils.isEmpty(str3) ? str3.toLowerCase(Locale.getDefault()).contains("oppo") : false)) {
                    String strA = AbstractC2128a.a();
                    String strB = (strA == null || !strA.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : B7.a.B(strA, "_", str2);
                    if (!TextUtils.isEmpty(strB)) {
                        return strB;
                    }
                    String strP = p("ro.vivo.os.build.display.id");
                    if (!TextUtils.isEmpty(strP) && strP.toLowerCase(Locale.getDefault()).contains("funtouch")) {
                        return p("ro.vivo.os.build.display.id") + "_" + p("ro.vivo.product.version");
                    }
                    if (!TextUtils.isEmpty(str2) && str2.toLowerCase(Locale.getDefault()).contains("amigo")) {
                        StringBuilder sbX = androidx.appfunctions.metadata.a.x(str2, "_");
                        sbX.append(p("ro.gn.sv.version"));
                        return sbX.toString();
                    }
                    StringBuilder sbV = androidx.compose.foundation.b.v(str3);
                    sbV.append(Build.BRAND);
                    String string = sbV.toString();
                    if (!TextUtils.isEmpty(string)) {
                        String lowerCase = string.toLowerCase(Locale.getDefault());
                        if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
                            return p("ro.build.uiversion") + "_" + str2;
                        }
                    }
                    if (!TextUtils.isEmpty(p("ro.letv.release.version"))) {
                        str = "eui_" + p("ro.letv.release.version") + "_" + str2;
                    }
                    return !TextUtils.isEmpty(str) ? str : str2;
                }
                if (TextUtils.isEmpty(str3) ? false : str3.toLowerCase(Locale.getDefault()).contains("oppo")) {
                    return "coloros_" + p("ro.build.version.opporom") + "_" + str2;
                }
            } else if (str2 != null && str2.toLowerCase(Locale.getDefault()).contains("flyme")) {
                return str2;
            }
        } else if (AbstractC2128a.d()) {
            return "miui_" + p("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    public static String p(String str) {
        String line = "";
        BufferedReader bufferedReader = null;
        try {
            Process processExec = Runtime.getRuntime().exec("getprop ".concat(str));
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            try {
                line = bufferedReader2.readLine();
                processExec.destroy();
                M0.i.i(bufferedReader2);
                return line;
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                M0.i.i(bufferedReader);
                return line;
            }
        } catch (Throwable unused2) {
        }
    }

    public static void q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            j();
            JSONObject jSONObject2 = e;
            if (jSONObject2 == null) {
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("slardar_filter");
            if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() == 0) {
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("filters");
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject2 = new JSONObject();
                try {
                    jSONObject.put("filters", jSONObjectOptJSONObject2);
                } catch (JSONException unused) {
                }
            }
            n2.a.o(jSONObjectOptJSONObject2, jSONObjectOptJSONObject);
        } catch (Throwable unused2) {
        }
    }

    public static final Collection r(Collection collection, Collection collection2) {
        k.f(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == null) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static boolean s(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public static r t(b bVar) {
        if (bVar instanceof F8.e) {
            F8.e eVar = (F8.e) bVar;
            String name = eVar.f593q;
            String desc = eVar.f594r;
            k.f(name, "name");
            k.f(desc, "desc");
            return new r(name.concat(desc));
        }
        if (!(bVar instanceof F8.d)) {
            throw new NoWhenBranchMatchedException();
        }
        F8.d dVar = (F8.d) bVar;
        String name2 = dVar.f591q;
        String desc2 = dVar.f592r;
        k.f(name2, "name");
        k.f(desc2, "desc");
        return new r(name2 + '#' + desc2);
    }

    public static String u(String str) {
        try {
            X5.b.f1504a.getClass();
            Class clsA = C1403b.a("android.os.SystemProperties");
            return (String) C1403b.b(clsA, String.class).invoke(clsA, str);
        } catch (IllegalArgumentException e6) {
            throw e6;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String v(String str, String str2) {
        try {
            X5.b.f1504a.getClass();
            Class clsA = C1403b.a("android.os.SystemProperties");
            return (String) C1403b.b(clsA, String.class, String.class).invoke(clsA, str, str2);
        } catch (IllegalArgumentException e6) {
            throw e6;
        } catch (Exception unused) {
            return str2;
        }
    }

    public static boolean w(EditText editText) {
        return editText.getInputType() != 0;
    }

    public static boolean x(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean y(String str) {
        return str != null && str.length() > 0;
    }

    public static String z(String str, ArrayList arrayList) {
        if (x(str)) {
            throw new TosClientException("concat is empty", null);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((String) arrayList.get(0));
        for (int i6 = 1; i6 < arrayList.size(); i6++) {
            sb.append(str);
            sb.append((String) arrayList.get(i6));
        }
        return sb.toString();
    }
}
