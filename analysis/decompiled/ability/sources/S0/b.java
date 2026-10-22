package S0;

import C9.B;
import C9.x;
import D7.q;
import D7.w;
import D9.n;
import F9.C0234l;
import H4.o;
import T8.A;
import U.h;
import U.i;
import a.AbstractC0291a;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import b8.C0841b;
import cc.dd.dd.cc.dd.ff.a$a;
import com.apm.insight.CrashType;
import com.apm.insight.MonitorCrash;
import com.apm.insight.log.ILog;
import com.blankj.utilcode.util.j;
import com.bytedance.apm.agent.v2.InstructOperationSwitch;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.applog.encryptor.EncryptorUtil;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.slardar.config.IConfigManager;
import com.mdisdk.capability.model.ViewNode;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.capability.request.DisplaySnapshot;
import com.mdisdk.capability.request.UiSnapshot;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import e2.C1404a;
import f6.AbstractC1436a;
import g1.AbstractC1451a;
import g2.C1452a;
import g8.C1468d;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1500H;
import h8.InterfaceC1501I;
import h8.InterfaceC1520c;
import h8.InterfaceC1536s;
import i8.C1562h;
import i8.InterfaceC1561g;
import io.modelcontextprotocol.spec.HttpHeaders;
import j9.m;
import j9.s;
import j9.t;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import k8.K;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import l0.AbstractC1654a;
import m0.C1670d;
import m8.C1681a;
import n8.AbstractC1744c;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q8.AbstractC1829b;
import q8.AbstractC1831d;
import q8.AbstractC1832e;
import q8.C1830c;
import q8.z;
import w2.l;
import z8.p;

/* loaded from: classes2.dex */
public abstract class b {
    public static File b = null;
    public static File c = null;
    public static File d = null;
    public static File e = null;
    public static String f = null;
    public static CopyOnWriteArrayList g = null;
    public static Properties h = null;
    public static String i = null;

    /* renamed from: j, reason: collision with root package name */
    public static String f1164j = "";
    public static String k = "";
    public static String l = "";
    public static String m = "";
    public static String n = "";
    public static Application o;
    public static Application p;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1165a;

    public /* synthetic */ b(int i6) {
        this.f1165a = i6;
    }

    public static void A(V.a aVar) {
        i iVar = aVar.b;
        h hVar = iVar.g;
        if (hVar.f1247a <= 0) {
            hVar.f1247a = System.currentTimeMillis();
        }
        if (!aVar.b()) {
            aVar.f1298a = a$a.c;
            iVar.g.b = System.currentTimeMillis() - iVar.g.f1247a;
        }
        try {
            n nVar = iVar.n;
            U.g gVar = iVar.e;
            nVar.f443a = "HttpURLConnection";
            JSONObject jSONObject = new JSONObject(iVar.toString());
            jSONObject.put("net_consume_type", "HttpURLConnection");
            jSONObject.put("timing_totalSendBytes", gVar.b);
            jSONObject.put("timing_totalReceivedBytes", gVar.c);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("request_log", jSONObject.toString());
            jSONObject2.put("data_type", iVar.f1248a);
            JSONObject jSONObject3 = iVar.f;
            jSONObject2.put("requestHeader", jSONObject3 != null ? jSONObject3.toString() : "");
            h hVar2 = iVar.g;
            x(hVar2.b, hVar2.f1247a, (String) iVar.i.c, (String) iVar.d.b, gVar.f1246a, jSONObject2);
            if (H.h.b) {
                Log.i("ApmInsight", U7.a.e(new String[]{"HttpURLConnection:" + jSONObject2.toString()}));
            }
        } catch (Exception unused) {
        }
    }

    public static short A0(BufferedInputStream bufferedInputStream) throws IOException {
        int i6 = bufferedInputStream.read();
        int i10 = bufferedInputStream.read();
        if ((i6 | i10) >= 0) {
            return (short) (i10 | (i6 << 8));
        }
        throw new EOFException();
    }

    public static void B(View view, Activity activity) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (view.getContext() == activity) {
            if (view.getBackground() != null) {
                try {
                    view.getBackground().setCallback(null);
                    view.setBackgroundDrawable(null);
                } catch (Throwable unused) {
                }
            }
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                Drawable drawable = imageView.getDrawable();
                if (drawable != null) {
                    drawable.setCallback(null);
                }
                imageView.setImageDrawable(null);
            }
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                for (Drawable drawable2 : textView.getCompoundDrawables()) {
                    if (drawable2 != null) {
                        drawable2.setCallback(null);
                    }
                }
                textView.setCompoundDrawables(null, null, null, null);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                B(viewGroup.getChildAt(i6), activity);
            }
        }
    }

    public static void B0(MonitorCrash monitorCrash, Throwable th, String str, Map map, String str2) {
        if (th == null) {
            return;
        }
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            StackTraceElement stackTraceElement = stackTrace[0];
            if (stackTraceElement == null) {
                return;
            }
            String strB = y2.e.b(th);
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            n2.d dVarV = n2.d.v(stackTraceElement, strB, str, Thread.currentThread().getName(), str2);
            if (monitorCrash != null) {
                dVarV.e(n2.c.a(monitorCrash, th, stackTrace), "exception_line_num");
            }
            T(map, dVarV);
            u1.d.s().p(CrashType.ENSURE, dVarV);
            l.b(monitorCrash, dVarV);
            t0("[reportException] " + str);
            C1452a c1452aB = C1452a.b();
            JSONObject jSONObject = dVarV.f5345a;
            c1452aB.getClass();
            try {
                ILog iLogF = C1452a.f();
                if (iLogF == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("log_type", "ensure");
                jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "ensure");
                jSONObject2.put("body", jSONObject);
                iLogF.w("APMPlus", jSONObject2.toString());
            } catch (Throwable unused) {
            }
        } catch (Throwable th2) {
            p0(th2);
        }
    }

    public static void C(BufferedInputStream bufferedInputStream, long j5) throws IOException {
        long j6 = 0;
        while (j6 < j5) {
            long jSkip = bufferedInputStream.skip(j5 - j6);
            if (jSkip < 0) {
                throw new EOFException();
            }
            j6 += jSkip;
        }
    }

    public static void C0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            IApmAgent iApmAgent = (IApmAgent) L2.a.a(IApmAgent.class);
            if (iApmAgent != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, 1);
                iApmAgent.monitorEvent("memory_dump_event", jSONObject, null, null);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void D(ByteArrayOutputStream byteArrayOutputStream, long j5) throws IOException {
        byte[] bArr = new byte[4096];
        for (int i6 = 0; i6 < (j5 >> 12); i6++) {
            byteArrayOutputStream.write(bArr);
        }
        byteArrayOutputStream.write(bArr, 0, (int) (j5 & 4095));
    }

    public static boolean D0() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo");
    }

    public static void E(ByteArrayOutputStream byteArrayOutputStream, Object obj) throws IOException {
        if (obj == null) {
            throw new IllegalArgumentException("value is null.");
        }
        if (obj instanceof B1.e) {
            byteArrayOutputStream.write(((B1.e) obj).f181a);
            return;
        }
        if ((obj instanceof Boolean) || Boolean.TYPE.isAssignableFrom(obj.getClass())) {
            byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 0);
            return;
        }
        if ((obj instanceof Character) || Character.TYPE.isAssignableFrom(obj.getClass())) {
            m0(byteArrayOutputStream, ((Character) obj).charValue());
            return;
        }
        if ((obj instanceof Float) || Float.TYPE.isAssignableFrom(obj.getClass())) {
            K(byteArrayOutputStream, Float.floatToRawIntBits(((Float) obj).floatValue()));
            return;
        }
        if ((obj instanceof Double) || Double.TYPE.isAssignableFrom(obj.getClass())) {
            n0(byteArrayOutputStream, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
            return;
        }
        if ((obj instanceof Byte) || Byte.TYPE.isAssignableFrom(obj.getClass())) {
            byteArrayOutputStream.write(((Byte) obj).byteValue());
            return;
        }
        if ((obj instanceof Short) || Short.TYPE.isAssignableFrom(obj.getClass())) {
            m0(byteArrayOutputStream, ((Short) obj).shortValue());
            return;
        }
        if ((obj instanceof Integer) || Integer.TYPE.isAssignableFrom(obj.getClass())) {
            K(byteArrayOutputStream, ((Integer) obj).intValue());
        } else {
            if (!(obj instanceof Long) && !Long.TYPE.isAssignableFrom(obj.getClass())) {
                throw new IllegalArgumentException("bad value type: ".concat(obj.getClass().getName()));
            }
            n0(byteArrayOutputStream, ((Long) obj).longValue());
        }
    }

    public static boolean E0(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    public static void F(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0025: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:12:0x0025 */
    public static byte[] F0(File file) throws Throwable {
        BufferedInputStream bufferedInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        if (!file.exists()) {
            return null;
        }
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    bufferedInputStream.read(bArr, 0, length);
                    bufferedInputStream.close();
                    F(bufferedInputStream);
                    return bArr;
                } catch (FileNotFoundException e6) {
                    e = e6;
                    e.printStackTrace();
                    F(bufferedInputStream);
                    return null;
                } catch (IOException e9) {
                    e = e9;
                    e.printStackTrace();
                    F(bufferedInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                F(closeable2);
                throw th;
            }
        } catch (FileNotFoundException e10) {
            e = e10;
            bufferedInputStream = null;
        } catch (IOException e11) {
            e = e11;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            F(closeable2);
            throw th;
        }
    }

    public static void G(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            file.delete();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Type inference failed for: r5v12, types: [C7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8, types: [C7.f, java.lang.Object] */
    public static L8.f G0(Class cls) {
        int i6 = 0;
        while (cls.isArray()) {
            i6++;
            cls = cls.getComponentType();
        }
        if (!cls.isPrimitive()) {
            G8.b bVarA = AbstractC1744c.a(cls);
            String str = C1468d.f4490a;
            G8.c fqName = bVarA.a();
            k.f(fqName, "fqName");
            G8.b bVar = (G8.b) C1468d.h.get(fqName.i());
            if (bVar != null) {
                bVarA = bVar;
            }
            return new L8.f(bVarA, i6);
        }
        if (cls.equals(Void.TYPE)) {
            G8.c cVarG = e8.n.d.g();
            G8.c cVarE = cVarG.e();
            G8.f fVarF = cVarG.f();
            k.e(fVarF, "shortName(...)");
            return new L8.f(new G8.b(cVarE, fVarF), i6);
        }
        PrimitiveType primitiveTypeD = JvmPrimitiveType.b(cls.getName()).d();
        k.e(primitiveTypeD, "getPrimitiveType(...)");
        if (i6 > 0) {
            G8.c topLevelFqName = (G8.c) primitiveTypeD.d.getF4884a();
            k.f(topLevelFqName, "topLevelFqName");
            G8.c cVarE2 = topLevelFqName.e();
            G8.f fVarF2 = topLevelFqName.f();
            k.e(fVarF2, "shortName(...)");
            return new L8.f(new G8.b(cVarE2, fVarF2), i6 - 1);
        }
        G8.c topLevelFqName2 = (G8.c) primitiveTypeD.c.getF4884a();
        k.f(topLevelFqName2, "topLevelFqName");
        G8.c cVarE3 = topLevelFqName2.e();
        G8.f fVarF3 = topLevelFqName2.f();
        k.e(fVarF3, "shortName(...)");
        return new L8.f(new G8.b(cVarE3, fVarF3), i6);
    }

    public static void H(File file, File file2) throws Throwable {
        ZipOutputStream zipOutputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                try {
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (IOException e9) {
            e9.printStackTrace();
        }
        try {
            I(file, file.getName(), zipOutputStream);
            U7.a.j("Compress over cost： %d ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            zipOutputStream.close();
        } catch (Exception e10) {
            e = e10;
            zipOutputStream2 = zipOutputStream;
            U7.a.i(e, "HeapFile compress failed", new Object[0]);
            if (zipOutputStream2 != null) {
                zipOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            if (zipOutputStream2 != null) {
                try {
                    zipOutputStream2.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static final InterfaceC1561g H0(InterfaceC1561g first, InterfaceC1561g second) {
        k.f(first, "first");
        k.f(second, "second");
        return first.isEmpty() ? second : second.isEmpty() ? first : new C1562h(new InterfaceC1561g[]{first, second});
    }

    public static void I(File file, String str, ZipOutputStream zipOutputStream) throws IOException {
        byte[] bArr = new byte[2048];
        zipOutputStream.putNextEntry(new ZipEntry(str));
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            int i6 = fileInputStream.read(bArr);
            if (i6 == -1) {
                zipOutputStream.closeEntry();
                fileInputStream.close();
                return;
            }
            zipOutputStream.write(bArr, 0, i6);
        }
    }

    public static long I0(String str, JSONObject jSONObject) {
        try {
            if (!jSONObject.has(str)) {
                return 0L;
            }
            long j5 = jSONObject.getLong(str);
            jSONObject.remove(str);
            return j5;
        } catch (Exception e6) {
            o.g("JsonUtils", "removeLong", e6);
            return 0L;
        }
    }

    public static void J(InputStream inputStream, byte[] bArr, long j5) throws IOException {
        int i6 = 0;
        while (true) {
            long j6 = i6;
            if (j6 >= j5) {
                return;
            }
            int i10 = inputStream.read(bArr, i6, (int) (j5 - j6));
            if (i10 < 0) {
                throw new EOFException();
            }
            i6 += i10;
        }
    }

    public static String J0() {
        Application application = AbstractC1451a.b;
        if (h == null) {
            Properties properties = new Properties();
            h = properties;
            try {
                properties.load(application.getApplicationContext().getAssets().open("slardar.properties"));
            } catch (Throwable unused) {
            }
        }
        Object obj = null;
        try {
            if (h.containsKey("release_build")) {
                obj = h.get("release_build");
            }
        } catch (Exception unused2) {
        }
        return String.valueOf(obj);
    }

    public static void K(OutputStream outputStream, int i6) throws IOException {
        outputStream.write((i6 >>> 24) & 255);
        outputStream.write((i6 >>> 16) & 255);
        outputStream.write((i6 >>> 8) & 255);
        outputStream.write(i6 & 255);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject K0(org.json.JSONObject r5) {
        /*
            java.lang.String r0 = "timestamp"
            if (r5 != 0) goto L5
            goto Lb
        L5:
            java.util.Iterator r1 = r5.keys()     // Catch: java.lang.Exception -> L3c
            if (r1 != 0) goto Ld
        Lb:
            r1 = 0
            goto L27
        Ld:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L3c
            r2.<init>()     // Catch: java.lang.Exception -> L3c
        L12:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Exception -> L3c
            if (r3 == 0) goto L26
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Exception -> L3c
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Exception -> L3c
            java.lang.Object r4 = r5.opt(r3)     // Catch: java.lang.Exception -> L3c
            r2.put(r3, r4)     // Catch: java.lang.Exception -> L3c
            goto L12
        L26:
            r1 = r2
        L27:
            if (r1 != 0) goto L2e
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L3c
            r1.<init>()     // Catch: java.lang.Exception -> L3c
        L2e:
            boolean r2 = r1.isNull(r0)     // Catch: java.lang.Exception -> L3c
            if (r2 == 0) goto L3b
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L3c
            r1.put(r0, r2)     // Catch: java.lang.Exception -> L3c
        L3b:
            return r1
        L3c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: S0.b.K0(org.json.JSONObject):org.json.JSONObject");
    }

    public static void L(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str.concat(" must not be null"));
        }
    }

    public static void L0(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void M(Object obj, boolean z10) {
        if (InstructOperationSwitch.sUiSwitch) {
            String name = obj instanceof String ? (String) obj : obj.getClass().getName();
            JSONObject jSONObject = new JSONObject();
            String str = z10 ? "page_show" : "page_hide";
            if (z10 && J2.c.f865a.f866a == null) {
                new B0.f(new C0234l());
            }
            L0.d.f925a.b(new H.a(str, jSONObject, name));
        }
    }

    public static void M0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            IApmAgent iApmAgent = (IApmAgent) L2.a.a(IApmAgent.class);
            if (iApmAgent != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, 1);
                B.a aVar = new B.a();
                aVar.f170a = "memory_dump_event";
                aVar.b = jSONObject;
                aVar.c = true;
                iApmAgent.monitorEvent(aVar);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void N(String str) {
        if (com.apm.insight.g.g.isDebugMode()) {
            Log.i("npth", String.valueOf(str));
        }
    }

    public static boolean N0() {
        String str = Build.DISPLAY;
        return (!TextUtils.isEmpty(str) && str.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static void O(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            Log.w("apm", str2.concat(" is empty, please make sure"));
        }
    }

    public static final C1531n O0(ProtoBuf$Visibility protoBuf$Visibility) {
        switch (protoBuf$Visibility == null ? -1 : A.b[protoBuf$Visibility.ordinal()]) {
            case 1:
                C1531n INTERNAL = AbstractC1532o.d;
                k.e(INTERNAL, "INTERNAL");
                return INTERNAL;
            case 2:
                C1531n PRIVATE = AbstractC1532o.f4583a;
                k.e(PRIVATE, "PRIVATE");
                return PRIVATE;
            case 3:
                C1531n PRIVATE_TO_THIS = AbstractC1532o.b;
                k.e(PRIVATE_TO_THIS, "PRIVATE_TO_THIS");
                return PRIVATE_TO_THIS;
            case 4:
                C1531n PROTECTED = AbstractC1532o.c;
                k.e(PROTECTED, "PROTECTED");
                return PROTECTED;
            case 5:
                C1531n PUBLIC = AbstractC1532o.e;
                k.e(PUBLIC, "PUBLIC");
                return PUBLIC;
            case 6:
                C1531n LOCAL = AbstractC1532o.f;
                k.e(LOCAL, "LOCAL");
                return LOCAL;
            default:
                C1531n PRIVATE2 = AbstractC1532o.f4583a;
                k.e(PRIVATE2, "PRIVATE");
                return PRIVATE2;
        }
    }

    public static void P(String str, byte[] bArr) throws IOException {
        String str2;
        String str3;
        HttpURLConnection httpURLConnection;
        LinkedList<Pair> linkedList;
        if (str == null) {
            return;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr.length > 128) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                str2 = "gzip";
            } catch (Throwable unused) {
                gZIPOutputStream.close();
                return;
            }
        } else {
            str2 = null;
        }
        byte[] bArrA = EncryptorUtil.a(bArr.length, bArr);
        if (bArrA != null) {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith("?")) {
                    str = str.concat("?");
                }
            } else if (!str.endsWith("&")) {
                str = str.concat("&");
            }
            str = androidx.appfunctions.metadata.a.l(str, "tt_data=a");
            str3 = "application/octet-stream;tt-data=a";
            bArr = bArrA;
        } else {
            str3 = "application/json; charset=utf-8";
        }
        try {
            linkedList = new LinkedList();
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
        }
        try {
            D2.b.g(httpURLConnection);
            if (!linkedList.isEmpty()) {
                for (Pair pair : linkedList) {
                    if (pair != null) {
                        httpURLConnection.setRequestProperty((String) pair.first, (String) pair.second);
                    }
                }
            }
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, str3);
            if (str2 != null) {
                httpURLConnection.setRequestProperty("Content-Encoding", str2);
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            httpURLConnection.setRequestProperty("Version-Code", "1");
            if (!TextUtils.isEmpty(H.h.f718w)) {
                httpURLConnection.setRequestProperty("aid", H.h.a());
                httpURLConnection.setRequestProperty("x-auth-token", H.h.f718w);
            }
            httpURLConnection.setRequestMethod("POST");
            if (bArr != null && bArr.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                dataOutputStream.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                httpURLConnection.getResponseMessage();
                cc.dd.ff.cc.cc.cc.e eVar = new cc.dd.ff.cc.cc.cc.e();
                eVar.f2143a = responseCode;
                throw eVar;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            String contentEncoding = httpURLConnection.getContentEncoding();
            if (TextUtils.isEmpty(contentEncoding) || !contentEncoding.equalsIgnoreCase("gzip")) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[8192];
                while (true) {
                    int i6 = inputStream.read(bArr2);
                    if (-1 == i6) {
                        break;
                    } else {
                        byteArrayOutputStream2.write(bArr2, 0, i6);
                    }
                }
                inputStream.close();
                byteArrayOutputStream2.toByteArray();
            } else {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                byte[] bArr3 = new byte[8192];
                while (true) {
                    int i10 = gZIPInputStream.read(bArr3);
                    if (-1 == i10) {
                        break;
                    } else {
                        byteArrayOutputStream3.write(bArr3, 0, i10);
                    }
                }
                gZIPInputStream.close();
                byteArrayOutputStream3.toByteArray();
                gZIPInputStream.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused3) {
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                throw th;
            } finally {
            }
        }
    }

    public static String P0() {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("00-");
        JSONObject jSONObjectD = H.h.d();
        if (jSONObjectD != null) {
            try {
                string = jSONObjectD.getString("device_id");
                if (TextUtils.isEmpty(string)) {
                    String string2 = jSONObjectD.getString("aid");
                    string = (TextUtils.isEmpty(string2) || C1404a.c(string2) == null) ? "" : C1404a.c(string2).b();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } else {
            string = null;
        }
        sb.append(l(8, string));
        sb.append(l(6, H.h.a()));
        sb.append(l(13, Long.toString(System.currentTimeMillis())));
        sb.append(k(5));
        sb.append("-");
        sb.append(k(16));
        sb.append("-");
        int i6 = O.c.p;
        if (O.b.f1029a.k) {
            sb.append("01");
        } else {
            sb.append("00");
        }
        if (H.h.b) {
            Log.d("ApmInsight", U7.a.e(new String[]{"x-rum-traceparent time:" + (System.currentTimeMillis() - jCurrentTimeMillis)}));
        }
        return sb.toString();
    }

    public static void Q(String str, byte[] bArr, int i6) {
        String str2 = new String(bArr);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            w(i6, str, new JSONObject(str2));
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    public static String Q0(String str, JSONObject jSONObject) {
        try {
            if (!jSONObject.has(str)) {
                return null;
            }
            String string = jSONObject.getString(str);
            jSONObject.remove(str);
            return string;
        } catch (Exception e6) {
            o.g("JsonUtils", "removeString", e6);
            return null;
        }
    }

    public static void R(Throwable th) {
        if (com.apm.insight.g.g.isDebugMode()) {
            Log.e("npth", "NPTH Catch Error", th);
        }
    }

    public static boolean R0() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("honor")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("honor");
    }

    public static void S(HashMap map, int i6) {
        BufferedReader bufferedReader;
        Integer numValueOf;
        int iIntValue;
        String strSubstring;
        long j5;
        BufferedReader bufferedReader2 = null;
        for (File file : new File(androidx.appfunctions.metadata.a.i(i6, "/proc/", "/task/")).listFiles()) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath() + "/stat")), 1000);
                try {
                    String line = bufferedReader.readLine();
                    int iLastIndexOf = line.lastIndexOf(41);
                    String strSubstring2 = line.substring(0, iLastIndexOf);
                    String strSubstring3 = line.substring(iLastIndexOf + 4);
                    int iIndexOf = strSubstring2.indexOf(40);
                    numValueOf = Integer.valueOf(strSubstring2.substring(0, iIndexOf - 1));
                    iIntValue = numValueOf.intValue();
                    strSubstring = strSubstring2.substring(iIndexOf + 1);
                    String[] strArrSplit = strSubstring3.split(" ");
                    j5 = Long.parseLong(strArrSplit[10]) + Long.parseLong(strArrSplit[11]);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
            if (iIntValue != 0 && !strSubstring.isEmpty() && j5 != 0) {
                c1.c cVar = new c1.c();
                cVar.b = strSubstring;
                cVar.f2083a = iIntValue;
                cVar.c = j5;
                map.put(numValueOf, cVar);
                L0(bufferedReader);
                bufferedReader2 = bufferedReader;
            }
            bufferedReader2 = bufferedReader;
            L0(bufferedReader2);
        }
    }

    public static JSONObject S0(String str, JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : jSONObject.optJSONObject(str);
    }

    public static void T(Map map, n2.d dVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
                dVar.e(jSONObject, "custom");
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean T0() {
        String strR = r(((CopyOnWriteArraySet) Z0.a.C().f1582a).toArray());
        if (TextUtils.isEmpty(strR)) {
            strR = "";
        }
        boolean z10 = !strR.equals(i);
        i = strR;
        return z10;
    }

    public static void U(JSONObject jSONObject) {
        try {
            new JSONObject();
        } catch (Throwable unused) {
        }
    }

    public static boolean U0() {
        return Class.forName("miui.os.Build").getName().length() > 0;
    }

    public static void V(JSONObject jSONObject, C1670d c1670d) throws JSONException {
        if (c1670d == null) {
            return;
        }
        String str = c1670d.e;
        String str2 = c1670d.d;
        String str3 = c1670d.c;
        String str4 = c1670d.b;
        String str5 = c1670d.f5295a;
        if (!TextUtils.isEmpty(str5)) {
            jSONObject.put("version_code", str5);
        }
        if (!TextUtils.isEmpty(str4)) {
            jSONObject.put("version_name", str4);
        }
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("manifest_version_code", str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("update_version_code", str2);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        jSONObject.put("app_version", str);
    }

    public static ViewNode V0(ViewNode viewNode, String str, String str2) {
        if (viewNode == null) {
            return null;
        }
        String strD1 = d1(viewNode);
        String strB1 = b1(viewNode);
        if ((str != null && strB1 != null && m.h0(strB1, str, false)) || (str2 != null && strD1 != null && m.h0(strD1, str2, false))) {
            return viewNode;
        }
        List listA1 = a1(viewNode);
        if (listA1 == null) {
            return null;
        }
        Iterator it = listA1.iterator();
        while (it.hasNext()) {
            ViewNode viewNodeV0 = V0((ViewNode) it.next(), str, str2);
            if (viewNodeV0 != null) {
                return viewNodeV0;
            }
        }
        return null;
    }

    public static void W(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.get(next));
            }
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    public static kotlin.Pair W0(UiSnapshot uiSnapshot, String str, String str2) {
        List<DisplaySnapshot> displays;
        List<DisplaySnapshot> list;
        ViewNode viewNodeV0;
        int[] iArrZ0;
        Method method;
        Object objInvoke;
        try {
            displays = uiSnapshot.getDisplays();
            list = displays;
        } catch (Throwable th) {
            AbstractC1436a.c("ability", "findNodeCenter error", th);
        }
        if (list != null && !list.isEmpty()) {
            List<WindowStateInfo> allWindows = displays.get(0).getAllWindows();
            if (allWindows == null) {
                allWindows = EmptyList.f4893a;
            }
            for (WindowStateInfo windowStateInfo : allWindows) {
                try {
                    Method[] methods = windowStateInfo.getClass().getMethods();
                    k.e(methods, "getMethods(...)");
                    int length = methods.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            method = null;
                            break;
                        }
                        method = methods[i6];
                        if (k.b(method.getName(), "getRootNode")) {
                            break;
                        }
                        i6++;
                    }
                    objInvoke = method != null ? method.invoke(windowStateInfo, null) : null;
                } catch (Throwable unused) {
                }
                ViewNode viewNode = objInvoke instanceof ViewNode ? (ViewNode) objInvoke : null;
                if (viewNode != null && (viewNodeV0 = V0(viewNode, str, str2)) != null && (iArrZ0 = Z0(viewNodeV0)) != null) {
                    int i10 = (iArrZ0[0] + iArrZ0[2]) / 2;
                    int i11 = (iArrZ0[1] + iArrZ0[3]) / 2;
                    AbstractC1436a.d("ability", "findNodeCenter: found (" + i10 + "," + i11 + ") for desc=" + str + " text=" + str2, true);
                    return new kotlin.Pair(Integer.valueOf(i10), Integer.valueOf(i11));
                }
            }
            AbstractC1436a.e("ability", B7.a.n("findNodeCenter: not found for desc=", str, " text=", str2), true);
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a5 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean X(b1.C0821b r8, double r9, boolean r11) {
        /*
            r0 = 0
            r2 = 1
            r3 = 0
            if (r11 == 0) goto L56
            java.util.HashMap r11 = r8.g
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L4b
            Z0.a r11 = Z0.a.C()
            java.lang.Object r11 = r11.f1582a
            java.util.concurrent.CopyOnWriteArraySet r11 = (java.util.concurrent.CopyOnWriteArraySet) r11
            java.util.Iterator r11 = r11.iterator()
            r4 = r3
        L1b:
            boolean r5 = r11.hasNext()
            if (r5 == 0) goto L4c
            java.lang.Object r5 = r11.next()
            java.lang.String r5 = (java.lang.String) r5
            java.util.HashMap r6 = r8.g
            boolean r6 = r6.containsKey(r5)
            if (r6 != 0) goto L30
            goto L1b
        L30:
            java.util.HashMap r6 = r8.g
            java.lang.Object r5 = r6.get(r5)
            java.lang.Double r5 = (java.lang.Double) r5
            double r5 = r5.doubleValue()
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 >= 0) goto L41
            goto L1b
        L41:
            int r4 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r4 <= 0) goto L47
            r4 = r2
            goto L48
        L47:
            r4 = r3
        L48:
            if (r4 == 0) goto L1b
            goto L4c
        L4b:
            r4 = r3
        L4c:
            if (r4 != 0) goto L55
            double r0 = r8.c
            int r8 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r8 <= 0) goto La5
            goto La4
        L55:
            return r4
        L56:
            java.util.HashMap r11 = r8.h
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L9b
            Z0.a r11 = Z0.a.C()
            java.lang.Object r11 = r11.f1582a
            java.util.concurrent.CopyOnWriteArraySet r11 = (java.util.concurrent.CopyOnWriteArraySet) r11
            java.util.Iterator r11 = r11.iterator()
            r4 = r3
        L6b:
            boolean r5 = r11.hasNext()
            if (r5 == 0) goto L9c
            java.lang.Object r5 = r11.next()
            java.lang.String r5 = (java.lang.String) r5
            java.util.HashMap r6 = r8.h
            boolean r6 = r6.containsKey(r5)
            if (r6 != 0) goto L80
            goto L6b
        L80:
            java.util.HashMap r6 = r8.h
            java.lang.Object r5 = r6.get(r5)
            java.lang.Double r5 = (java.lang.Double) r5
            double r5 = r5.doubleValue()
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 >= 0) goto L91
            goto L6b
        L91:
            int r4 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r4 <= 0) goto L97
            r4 = r2
            goto L98
        L97:
            r4 = r3
        L98:
            if (r4 == 0) goto L6b
            goto L9c
        L9b:
            r4 = r3
        L9c:
            if (r4 != 0) goto La6
            double r0 = r8.d
            int r8 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r8 <= 0) goto La5
        La4:
            return r2
        La5:
            return r3
        La6:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: S0.b.X(b1.b, double, boolean):boolean");
    }

    public static Application X0() throws ClassNotFoundException {
        Object objInvoke;
        Application application = o;
        if (application != null) {
            return application;
        }
        j.g.getClass();
        Application application2 = null;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objC = j.c();
            if (objC != null && (objInvoke = cls.getMethod("getApplication", null).invoke(objC, null)) != null) {
                application2 = (Application) objInvoke;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        k1(application2);
        if (o == null) {
            throw new NullPointerException("reflect failed.");
        }
        Log.i("Utils", N9.j.t() + " reflect app success.");
        return o;
    }

    public static boolean Y(String str) {
        JSONObject configJSON;
        JSONObject jSONObjectOptJSONObject;
        if (!TextUtils.isEmpty("performance_modules") && !TextUtils.isEmpty("memory") && !TextUtils.isEmpty(str)) {
            try {
                IConfigManager iConfigManager = (IConfigManager) L2.a.a(IConfigManager.class);
                if (iConfigManager != null && (configJSON = iConfigManager.getConfigJSON("performance_modules")) != null && (jSONObjectOptJSONObject = configJSON.optJSONObject("memory")) != null) {
                    if (jSONObjectOptJSONObject.optInt(str, 0) == 1) {
                        return true;
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.util.Map] */
    public static final String Y0(InterfaceC1536s interfaceC1536s) {
        G8.f fVar;
        InterfaceC1520c interfaceC1520cE1 = e8.i.z(interfaceC1536s) ? e1(interfaceC1536s) : null;
        if (interfaceC1520cE1 != null) {
            InterfaceC1520c interfaceC1520cK = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.k(interfaceC1520cE1);
            if (interfaceC1520cK instanceof InterfaceC1501I) {
                e8.i.z(interfaceC1520cK);
                InterfaceC1520c interfaceC1520cB = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.b(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.k(interfaceC1520cK), C1830c.d);
                if (interfaceC1520cB != null && (fVar = (G8.f) AbstractC1832e.f5599a.get(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(interfaceC1520cB))) != null) {
                    return fVar.b();
                }
            } else if (interfaceC1520cK instanceof K) {
                int i6 = AbstractC1829b.l;
                LinkedHashMap linkedHashMap = z.i;
                String strU = com.stepos.ability.task.executor.e.u((K) interfaceC1520cK);
                G8.f fVar2 = strU == null ? null : (G8.f) linkedHashMap.get(strU);
                if (fVar2 != null) {
                    return fVar2.b();
                }
            }
        }
        return null;
    }

    public static boolean Z(ArrayList arrayList, ArrayList arrayList2, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!r0(arrayList)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (str.contains((String) it.next())) {
                    return true;
                }
            }
        }
        try {
            String path = new URI(str).getPath();
            if (r0(arrayList2)) {
                return false;
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (((Pattern) it2.next()).matcher(path).matches()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int[] Z0(ViewNode viewNode) {
        Method method;
        Object objInvoke;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        try {
            Method[] methods = viewNode.getClass().getMethods();
            k.e(methods, "getMethods(...)");
            int length = methods.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    method = null;
                    break;
                }
                method = methods[i6];
                if (k.b(method.getName(), "getBounds")) {
                    break;
                }
                i6++;
            }
            if (method != null && (objInvoke = method.invoke(viewNode, null)) != null) {
                Class<?> cls = objInvoke.getClass();
                Method[] methods2 = cls.getMethods();
                k.e(methods2, "getMethods(...)");
                int length2 = methods2.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length2) {
                        method2 = null;
                        break;
                    }
                    method2 = methods2[i10];
                    if (k.b(method2.getName(), "getLeft")) {
                        break;
                    }
                    i10++;
                }
                Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, null) : null;
                Integer num = objInvoke2 instanceof Integer ? (Integer) objInvoke2 : null;
                int iIntValue = num != null ? num.intValue() : 0;
                Method[] methods3 = cls.getMethods();
                k.e(methods3, "getMethods(...)");
                int length3 = methods3.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length3) {
                        method3 = null;
                        break;
                    }
                    method3 = methods3[i11];
                    if (k.b(method3.getName(), "getTop")) {
                        break;
                    }
                    i11++;
                }
                Object objInvoke3 = method3 != null ? method3.invoke(objInvoke, null) : null;
                Integer num2 = objInvoke3 instanceof Integer ? (Integer) objInvoke3 : null;
                int iIntValue2 = num2 != null ? num2.intValue() : 0;
                Method[] methods4 = cls.getMethods();
                k.e(methods4, "getMethods(...)");
                int length4 = methods4.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length4) {
                        method4 = null;
                        break;
                    }
                    method4 = methods4[i12];
                    if (k.b(method4.getName(), "getRight")) {
                        break;
                    }
                    i12++;
                }
                Object objInvoke4 = method4 != null ? method4.invoke(objInvoke, null) : null;
                Integer num3 = objInvoke4 instanceof Integer ? (Integer) objInvoke4 : null;
                int iIntValue3 = num3 != null ? num3.intValue() : 0;
                Method[] methods5 = cls.getMethods();
                k.e(methods5, "getMethods(...)");
                int length5 = methods5.length;
                int i13 = 0;
                while (true) {
                    if (i13 >= length5) {
                        method5 = null;
                        break;
                    }
                    method5 = methods5[i13];
                    if (k.b(method5.getName(), "getBottom")) {
                        break;
                    }
                    i13++;
                }
                Object objInvoke5 = method5 != null ? method5.invoke(objInvoke, null) : null;
                Integer num4 = objInvoke5 instanceof Integer ? (Integer) objInvoke5 : null;
                return new int[]{iIntValue, iIntValue2, iIntValue3, num4 != null ? num4.intValue() : 0};
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Object a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static boolean a0(List list) {
        return list == null || list.size() == 0;
    }

    public static List a1(ViewNode viewNode) {
        Method method;
        try {
            Method[] methods = viewNode.getClass().getMethods();
            k.e(methods, "getMethods(...)");
            int length = methods.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    method = null;
                    break;
                }
                method = methods[i6];
                if (k.b(method.getName(), "getChildren")) {
                    break;
                }
                i6++;
            }
            Object objInvoke = method != null ? method.invoke(viewNode, null) : null;
            if (objInvoke instanceof List) {
                return (List) objInvoke;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void b(Parcel parcel, Parcelable parcelable, int i6) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i6);
        }
    }

    public static void b0(File file, File file2) throws Throwable {
        FileInputStream fileInputStream;
        DeflaterOutputStream deflaterOutputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        DeflaterOutputStream deflaterOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    deflaterOutputStream = new DeflaterOutputStream(new FileOutputStream(file2));
                } catch (Exception e6) {
                    e = e6;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e9) {
            e = e9;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i6 = fileInputStream.read(bArr);
                    if (i6 == -1) {
                        break;
                    } else {
                        deflaterOutputStream.write(bArr, 0, i6);
                    }
                }
                U7.a.j("Compress over cost： %d ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                if (file2.exists()) {
                    file.delete();
                }
                try {
                    deflaterOutputStream.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            } catch (Exception e11) {
                e = e11;
                deflaterOutputStream2 = deflaterOutputStream;
                U7.a.i(e, "HeapFile compress failed", new Object[0]);
                if (deflaterOutputStream2 != null) {
                    try {
                        deflaterOutputStream2.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                if (fileInputStream == null) {
                    return;
                }
                fileInputStream.close();
            } catch (Throwable th3) {
                th = th3;
                deflaterOutputStream2 = deflaterOutputStream;
                if (deflaterOutputStream2 != null) {
                    try {
                        deflaterOutputStream2.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                if (fileInputStream == null) {
                    throw th;
                }
                try {
                    fileInputStream.close();
                    throw th;
                } catch (IOException e14) {
                    e14.printStackTrace();
                    throw th;
                }
            }
            fileInputStream.close();
        } catch (IOException e15) {
            e15.printStackTrace();
        }
    }

    public static String b1(ViewNode viewNode) {
        Method method;
        try {
            Method[] methods = viewNode.getClass().getMethods();
            k.e(methods, "getMethods(...)");
            int length = methods.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    method = null;
                    break;
                }
                method = methods[i6];
                if (k.b(method.getName(), "getContentDescription")) {
                    break;
                }
                i6++;
            }
            Object objInvoke = method != null ? method.invoke(viewNode, null) : null;
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static double c() throws InterruptedException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jA = M.a.a();
        try {
            Thread.sleep(360L);
        } catch (InterruptedException unused) {
        }
        return (((M.a.a() - jA) * 1000.0d) / (System.currentTimeMillis() - jCurrentTimeMillis)) / M.a.v();
    }

    public static void c0(String str, String str2) {
        if (com.apm.insight.g.g.isDebugMode()) {
            Log.i("npth", str + " " + ((Object) str2));
        }
    }

    public static boolean c1(ViewNode viewNode, String str) {
        Method method;
        try {
            Method[] methods = viewNode.getClass().getMethods();
            k.e(methods, "getMethods(...)");
            int length = methods.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    method = null;
                    break;
                }
                method = methods[i6];
                if (k.b(method.getName(), str)) {
                    break;
                }
                i6++;
            }
            Object objInvoke = method != null ? method.invoke(viewNode, null) : null;
            Boolean bool = objInvoke instanceof Boolean ? (Boolean) objInvoke : null;
            if (bool != null) {
                return bool.booleanValue();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int d(InputStream inputStream) throws IOException {
        int i6 = inputStream.read();
        int i10 = inputStream.read();
        int i11 = inputStream.read();
        int i12 = inputStream.read();
        if ((i6 | i10 | i11 | i12) >= 0) {
            return (i6 << 24) + (i10 << 16) + (i11 << 8) + i12;
        }
        throw new EOFException();
    }

    public static final String d0(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        k.e(parameterTypes, "getParameterTypes(...)");
        sb.append(q.x0(parameterTypes, "", "(", ")", C0841b.f2036j, 24));
        Class<?> returnType = method.getReturnType();
        k.e(returnType, "getReturnType(...)");
        sb.append(AbstractC1744c.b(returnType));
        return sb.toString();
    }

    public static String d1(ViewNode viewNode) {
        Method method;
        try {
            Method[] methods = viewNode.getClass().getMethods();
            k.e(methods, "getMethods(...)");
            int length = methods.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    method = null;
                    break;
                }
                method = methods[i6];
                if (k.b(method.getName(), "getText")) {
                    break;
                }
                i6++;
            }
            Object objInvoke = method != null ? method.invoke(viewNode, null) : null;
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static int e(Exception exc) {
        if (exc == null) {
            return 1;
        }
        if (exc instanceof UnknownHostException) {
            return 11;
        }
        if (exc instanceof ConnectException) {
            return 8;
        }
        if ((exc instanceof SocketTimeoutException) || (exc instanceof ConnectTimeoutException)) {
            return 3;
        }
        return ((exc instanceof SSLHandshakeException) || (exc instanceof SSLException)) ? 4 : 1;
    }

    public static void e0(Throwable th, Throwable exception) {
        k.f(th, "<this>");
        k.f(exception, "exception");
        if (th != exception) {
            Integer num = M7.a.f972a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(exception);
                return;
            }
            Method method = L7.a.f937a;
            if (method != null) {
                method.invoke(th, exception);
            }
        }
    }

    public static final InterfaceC1520c e1(InterfaceC1520c interfaceC1520c) {
        k.f(interfaceC1520c, "<this>");
        if (!z.f5621j.contains(interfaceC1520c.getName()) && !AbstractC1832e.d.contains(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.k(interfaceC1520c).getName())) {
            return null;
        }
        if ((interfaceC1520c instanceof InterfaceC1501I) || (interfaceC1520c instanceof InterfaceC1500H)) {
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.b(interfaceC1520c, C1830c.f);
        }
        if (interfaceC1520c instanceof K) {
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.b(interfaceC1520c, C1830c.g);
        }
        return null;
    }

    public static B.b f(String str, List list, Map map) {
        try {
            IHttpService defaultHttpServiceImpl = (IHttpService) L2.a.a(IHttpService.class);
            if (defaultHttpServiceImpl == null) {
                defaultHttpServiceImpl = new DefaultHttpServiceImpl();
            }
            B.e eVarBuildMultipartUpload = defaultHttpServiceImpl.buildMultipartUpload(str, "UTF-8", false);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    if (file.exists()) {
                        eVarBuildMultipartUpload.b(file.getName(), file, null, "binary", new HashMap());
                    }
                }
            }
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    eVarBuildMultipartUpload.a((String) entry.getKey(), (String) entry.getValue());
                }
            }
            String str2 = new String(eVarBuildMultipartUpload.a().c);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                return new B.b(jSONObject.optInt("error_code", 0), jSONObject.optString("message", "").getBytes());
            } catch (JSONException e6) {
                e6.printStackTrace();
                return null;
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static void f0(ViewNode viewNode, int i6, StringBuilder sb) {
        String string;
        if (viewNode == null || i6 > 50 || sb.length() > 32000) {
            return;
        }
        String strD1 = d1(viewNode);
        String strB1 = b1(viewNode);
        int[] iArrZ0 = Z0(viewNode);
        if (iArrZ0 == null) {
            string = null;
        } else {
            int i10 = iArrZ0[0];
            int i11 = iArrZ0[1];
            int i12 = iArrZ0[2];
            int i13 = iArrZ0[3];
            StringBuilder sbS = androidx.appfunctions.metadata.a.s(i10, "[", i11, ",", "][");
            sbS.append(i12);
            sbS.append(",");
            sbS.append(i13);
            sbS.append("]");
            string = sbS.toString();
        }
        boolean zC1 = c1(viewNode, "isClickable");
        boolean zC12 = c1(viewNode, "isScrollable");
        if ((strD1 != null && !m.s0(strD1)) || ((strB1 != null && !m.s0(strB1)) || zC1 || zC12 || i6 <= 2)) {
            sb.append(t.a0(i6 <= 20 ? i6 : 20, "  "));
            if (zC1) {
                sb.append("[C]");
            }
            if (zC12) {
                sb.append("[S]");
            }
            if (strD1 != null && !m.s0(strD1)) {
                androidx.compose.foundation.b.C(sb, " text='", strD1, "'");
            }
            if (strB1 != null && !m.s0(strB1)) {
                androidx.compose.foundation.b.C(sb, " desc='", strB1, "'");
            }
            if (string != null) {
                sb.append(" ");
                sb.append(string);
            }
            sb.append("\n");
        }
        List listA1 = a1(viewNode);
        if (listA1 != null) {
            Iterator it = listA1.iterator();
            while (it.hasNext()) {
                f0((ViewNode) it.next(), i6 + 1, sb);
            }
        }
    }

    public static final InterfaceC1520c f1(InterfaceC1520c interfaceC1520c) {
        k.f(interfaceC1520c, "<this>");
        InterfaceC1520c interfaceC1520cE1 = e1(interfaceC1520c);
        if (interfaceC1520cE1 != null) {
            return interfaceC1520cE1;
        }
        int i6 = AbstractC1831d.l;
        G8.f name = interfaceC1520c.getName();
        k.e(name, "getName(...)");
        if (AbstractC1831d.b(name)) {
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.b(interfaceC1520c, C1830c.h);
        }
        return null;
    }

    public static B1.e g(InputStream inputStream, int i6) throws IOException {
        byte[] bArr = new byte[i6];
        J(inputStream, bArr, i6);
        return new B1.e(bArr);
    }

    public static final Object g1(W8.j jVar, Z7.t p3) {
        k.f(jVar, "<this>");
        k.f(p3, "p");
        return jVar.invoke();
    }

    public static K1.a h(Context context) {
        if (context == null) {
            return null;
        }
        if (K1.a.f == null) {
            synchronized (K1.a.class) {
                try {
                    if (K1.a.f == null) {
                        J1.a aVar = J1.a.b;
                        K1.a.f = new K1.a(context);
                    }
                } finally {
                }
            }
        }
        return K1.a.f;
    }

    public static long h0(BufferedInputStream bufferedInputStream) throws IOException {
        J(bufferedInputStream, new byte[8], 8L);
        return (r1[0] << 56) + ((r1[1] & 255) << 48) + ((r1[2] & 255) << 40) + ((r1[3] & 255) << 32) + ((r1[4] & 255) << 24) + ((r1[5] & 255) << 16) + ((r1[6] & 255) << 8) + (r1[7] & 255);
    }

    public static String h1(String str, JSONObject jSONObject) {
        return jSONObject == null ? "" : jSONObject.optString(str, "");
    }

    public static synchronized File i() {
        try {
            if (c == null) {
                File file = new File(x0(), "flush");
                if (!file.exists()) {
                    file.mkdirs();
                }
                c = file;
                if (AbstractC1451a.f4467a) {
                    o.f(a.f1163a, "prepare FlushDirectory success. name=" + c);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return c;
    }

    public static synchronized File i0() {
        try {
            if (d == null) {
                File file = AbstractC1451a.P() ? new File(x0(), "persistent") : new File(x0(), "child_process_persistent");
                if (!file.exists()) {
                    file.mkdirs();
                }
                d = file;
                if (AbstractC1451a.f4467a) {
                    o.f(a.f1163a, "prepare PersistentDirectory success. name=" + d);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x014d, code lost:
    
        if (r6 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0154, code lost:
    
        return !e8.i.z(r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean i1(h8.InterfaceC1522e r13, h8.InterfaceC1520c r14) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S0.b.i1(h8.e, h8.c):boolean");
    }

    public static String j() throws IOException {
        Throwable th;
        String str;
        BufferedReader bufferedReader = null;
        String line = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.build.version.emui").getInputStream()), 1024);
            try {
                line = bufferedReader2.readLine();
                bufferedReader2.close();
                try {
                    bufferedReader2.close();
                } catch (IOException unused) {
                }
                return line;
            } catch (Throwable th2) {
                str = line;
                bufferedReader = bufferedReader2;
                th = th2;
                try {
                    w.h.b(th);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return str;
                } catch (Throwable th3) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            str = null;
        }
    }

    public static File j0(File file, File file2) throws Throwable {
        FileInputStream fileInputStream;
        BufferedOutputStream bufferedOutputStream;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            C0("shrink_begin");
            D1.a aVarB = D1.a.b();
            L(aVarB.b, "a mustn't be null");
            aVarB.b.getClass();
            File file3 = new File((File) F1.b.b().e, ".mini.hprof");
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    try {
                        new B1.b(new BufferedInputStream(fileInputStream)).f(new B1.c(new B1.d(bufferedOutputStream)));
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable unused) {
                        }
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                        b0(file2, file3);
                        H1.c.d().e().edit().putInt("hprof_type", 5).commit();
                        C0("shrink_end");
                        y(System.currentTimeMillis() - jCurrentTimeMillis, "shrink_time");
                        y(file.length() / 1024, "origin_size");
                        y(file3.length() / 1024, "shrink_size");
                        U7.a.j("shrink hprof file %s, size: %dk to %s, size: %dk, use time:%d", file.getPath(), Long.valueOf(file.length() / 1024), file3.getPath(), Long.valueOf(file3.length() / 1024), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        if (!file3.exists() || file3.length() <= 0) {
                            return null;
                        }
                        return file3;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (fileInputStream == null) {
                            throw th;
                        }
                        try {
                            fileInputStream.close();
                            throw th;
                        } catch (Throwable unused4) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                bufferedOutputStream = null;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static void j1(String str, JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(SettingsConfig.KEY_DATA);
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("timer");
            if (jSONArrayOptJSONArray != null) {
                for (int i6 = 0; i6 < jSONArrayOptJSONArray.length(); i6++) {
                    AbstractC1654a.f5271a.b(str, jSONArrayOptJSONArray.getJSONObject(i6));
                }
            }
            if (jSONArrayOptJSONArray2 != null) {
                for (int i10 = 0; i10 < jSONArrayOptJSONArray2.length(); i10++) {
                    AbstractC1654a.f5271a.b(str, jSONArrayOptJSONArray2.getJSONObject(i10));
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static String k(int i6) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i10 = 0; i10 < i6; i10++) {
            sb.append(Integer.toHexString(random.nextInt(16)));
        }
        return sb.length() > i6 ? sb.substring(0, i6) : sb.toString();
    }

    public static ArrayList k0(String str, JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                return null;
            }
            int length = jSONArrayOptJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i6 = 0; i6 < length; i6++) {
                String string = jSONArrayOptJSONArray.getString(i6);
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(Pattern.compile(string));
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void k1(Application application) {
        Executor executorB;
        if (application == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application2 = o;
        if (application2 != null) {
            if (application2.equals(application)) {
                return;
            }
            Application application3 = o;
            j jVar = j.g;
            jVar.f2208a.clear();
            application3.unregisterActivityLifecycleCallbacks(jVar);
            o = application;
            jVar.getClass();
            application.registerActivityLifecycleCallbacks(jVar);
            return;
        }
        o = application;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = j.g;
        activityLifecycleCallbacks.getClass();
        application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        Runnable runnable = new Runnable[]{new A1.a(14)}[0];
        HashMap map = com.blankj.utilcode.util.i.b;
        synchronized (map) {
            try {
                Map map2 = (Map) map.get(-2);
                if (map2 == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    executorB = com.blankj.utilcode.util.g.b();
                    concurrentHashMap.put(5, executorB);
                    map.put(-2, concurrentHashMap);
                } else {
                    executorB = (ExecutorService) map2.get(5);
                    if (executorB == null) {
                        executorB = com.blankj.utilcode.util.g.b();
                        map2.put(5, executorB);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        executorB.execute(runnable);
    }

    public static String l(int i6, String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            for (char c2 : str.toCharArray()) {
                sb.append(Integer.toHexString(Character.getNumericValue(c2)));
                if (sb.length() > i6) {
                    break;
                }
            }
        }
        if (sb.length() > i6) {
            return sb.substring(0, i6);
        }
        while (sb.length() < i6) {
            sb.append("0");
        }
        return sb.toString();
    }

    public static JSONObject l0(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public static final CallableMemberDescriptor$Kind l1(ProtoBuf$MemberKind protoBuf$MemberKind) {
        int i6 = protoBuf$MemberKind == null ? -1 : A.f1211a[protoBuf$MemberKind.ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                return CallableMemberDescriptor$Kind.b;
            }
            if (i6 == 3) {
                return CallableMemberDescriptor$Kind.c;
            }
            if (i6 == 4) {
                return CallableMemberDescriptor$Kind.d;
            }
        }
        return CallableMemberDescriptor$Kind.f4950a;
    }

    public static String m(int i6, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        int i10 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            i10++;
            sb.append("\tat " + stackTraceElement.getClassName());
            sb.append(".");
            sb.append(stackTraceElement.getMethodName());
            sb.append("(");
            sb.append(stackTraceElement.getFileName());
            sb.append(":");
            sb.append(stackTraceElement.getLineNumber());
            sb.append(")\n");
            if (i10 > i6) {
                break;
            }
        }
        return sb.toString();
    }

    public static void m0(OutputStream outputStream, int i6) throws IOException {
        outputStream.write((i6 >>> 8) & 255);
        outputStream.write(i6 & 255);
    }

    public static void m1(p pVar, Annotation annotation) {
        Class clsZ = M.a.Z(M.a.V(annotation));
        z8.n nVarC = pVar.c(AbstractC1744c.a(clsZ), new C1681a(annotation));
        if (nVarC != null) {
            n1(nVarC, annotation, clsZ);
        }
    }

    public static String n(String str) throws IOException {
        BufferedReader bufferedReader;
        Process processExec;
        String line = "";
        try {
            processExec = Runtime.getRuntime().exec("getprop ".concat(str));
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            line = bufferedReader.readLine();
            processExec.destroy();
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
            return line;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            return line;
        }
    }

    public static void n0(OutputStream outputStream, long j5) throws IOException {
        outputStream.write(new byte[]{(byte) (j5 >>> 56), (byte) (j5 >>> 48), (byte) (j5 >>> 40), (byte) (j5 >>> 32), (byte) (j5 >>> 24), (byte) (j5 >>> 16), (byte) (j5 >>> 8), (byte) j5}, 0, 8);
    }

    public static void n1(z8.n nVar, Annotation annotation, Class cls) {
        C7.i iVarJ = k.j(cls.getDeclaredMethods());
        while (iVarJ.hasNext()) {
            Method method = (Method) iVarJ.next();
            try {
                Object objInvoke = method.invoke(annotation, null);
                k.c(objInvoke);
                G8.f fVarE = G8.f.e(method.getName());
                Class<?> enclosingClass = objInvoke.getClass();
                if (enclosingClass.equals(Class.class)) {
                    nVar.m(fVarE, G0((Class) objInvoke));
                } else if (m8.c.f5308a.contains(enclosingClass)) {
                    nVar.t(fVarE, objInvoke);
                } else {
                    List list = AbstractC1744c.f5355a;
                    if (Enum.class.isAssignableFrom(enclosingClass)) {
                        if (!enclosingClass.isEnum()) {
                            enclosingClass = enclosingClass.getEnclosingClass();
                        }
                        k.c(enclosingClass);
                        nVar.y(fVarE, AbstractC1744c.a(enclosingClass), G8.f.e(((Enum) objInvoke).name()));
                    } else if (Annotation.class.isAssignableFrom(enclosingClass)) {
                        Class<?>[] interfaces = enclosingClass.getInterfaces();
                        k.e(interfaces, "getInterfaces(...)");
                        Class cls2 = (Class) q.A0(interfaces);
                        k.c(cls2);
                        z8.n nVarL = nVar.l(AbstractC1744c.a(cls2), fVarE);
                        if (nVarL != null) {
                            n1(nVarL, (Annotation) objInvoke, cls2);
                        }
                    } else {
                        if (!enclosingClass.isArray()) {
                            throw new UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + objInvoke);
                        }
                        z8.o oVarN = nVar.n(fVarE);
                        if (oVarN != null) {
                            Class<?> componentType = enclosingClass.getComponentType();
                            int i6 = 0;
                            if (componentType.isEnum()) {
                                G8.b bVarA = AbstractC1744c.a(componentType);
                                Object[] objArr = (Object[]) objInvoke;
                                int length = objArr.length;
                                while (i6 < length) {
                                    Object obj = objArr[i6];
                                    k.d(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
                                    oVarN.f0(bVarA, G8.f.e(((Enum) obj).name()));
                                    i6++;
                                }
                            } else if (componentType.equals(Class.class)) {
                                Object[] objArr2 = (Object[]) objInvoke;
                                int length2 = objArr2.length;
                                while (i6 < length2) {
                                    Object obj2 = objArr2[i6];
                                    k.d(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                                    oVarN.C(G0((Class) obj2));
                                    i6++;
                                }
                            } else if (Annotation.class.isAssignableFrom(componentType)) {
                                Object[] objArr3 = (Object[]) objInvoke;
                                int length3 = objArr3.length;
                                while (i6 < length3) {
                                    Object obj3 = objArr3[i6];
                                    z8.n nVarL2 = oVarN.L(AbstractC1744c.a(componentType));
                                    if (nVarL2 != null) {
                                        k.d(obj3, "null cannot be cast to non-null type kotlin.Annotation");
                                        n1(nVarL2, (Annotation) obj3, componentType);
                                    }
                                    i6++;
                                }
                            } else {
                                Object[] objArr4 = (Object[]) objInvoke;
                                int length4 = objArr4.length;
                                while (i6 < length4) {
                                    oVarN.j0(objArr4[i6]);
                                    i6++;
                                }
                            }
                            oVarN.k();
                        }
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        nVar.k();
    }

    public static String o(String str, Collection collection) {
        if (collection == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z10 = true;
        for (Object obj : collection) {
            if (z10) {
                z10 = false;
            } else {
                sb.append(str);
            }
            sb.append(obj.toString());
        }
        return sb.toString();
    }

    public static void o0(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (str.length() <= 3072) {
            Log.d("ApmInsight", str);
            return;
        }
        while (str.length() > 3072) {
            String strSubstring = str.substring(0, 3072);
            str = str.replace(strSubstring, "");
            Log.d("ApmInsight", strSubstring);
        }
        Log.d("ApmInsight", str);
    }

    public static final String o1(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[8192];
        int i6 = reader.read(cArr);
        while (i6 >= 0) {
            stringWriter.write(cArr, 0, i6);
            i6 = reader.read(cArr);
        }
        String string = stringWriter.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public static String p(String str, Map map) {
        if (!TextUtils.isDigitsOnly(str) && map != null && !map.isEmpty()) {
            if (str.indexOf("?") < 0) {
                str = str.concat("?");
            }
            if (str.endsWith("?")) {
                StringBuilder sbV = androidx.compose.foundation.b.v(str);
                sbV.append(y0("sdk_version"));
                sbV.append("=");
                sbV.append(y0(String.valueOf(400)));
                str = sbV.toString();
            } else {
                StringBuilder sbX = androidx.appfunctions.metadata.a.x(str, "&");
                sbX.append(y0("sdk_version"));
                sbX.append("=");
                sbX.append(y0(String.valueOf(400)));
                str = sbX.toString();
            }
            if (map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    if (map.get(entry.getKey()) != null) {
                        if (str.endsWith("?")) {
                            StringBuilder sbV2 = androidx.compose.foundation.b.v(str);
                            sbV2.append(y0(entry.getKey().toString()));
                            sbV2.append("=");
                            sbV2.append(y0(((String) map.get(entry.getKey())).toString()));
                            str = sbV2.toString();
                        } else {
                            StringBuilder sbX2 = androidx.appfunctions.metadata.a.x(str, "&");
                            sbX2.append(y0(entry.getKey().toString()));
                            sbX2.append("=");
                            sbX2.append(y0(((String) map.get(entry.getKey())).toString()));
                            str = sbX2.toString();
                        }
                    }
                }
            }
        }
        return str;
    }

    public static void p0(Throwable th) {
        if (com.apm.insight.g.g.isDebugMode()) {
            Log.w("npth", "NPTH Catch Error", th);
        }
    }

    public static String p1(Throwable th) {
        k.f(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public static String q(Map map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static void q0(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys;
        if (jSONObject == null || jSONObject2 == null || (itKeys = jSONObject2.keys()) == null) {
            return;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.isNull(next)) {
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
    }

    public static final LinkedHashMap q1(C9.l lVar) {
        k.f(lVar, "<this>");
        x xVar = lVar instanceof x ? (x) lVar : null;
        if (xVar == null) {
            return null;
        }
        Map map = xVar.f335a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.a.P(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), r1((C9.l) entry.getValue()));
        }
        return linkedHashMap;
    }

    public static String r(Object[] objArr) {
        if (objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z10 = true;
        for (Object obj : objArr) {
            if (z10) {
                z10 = false;
            } else {
                sb.append("#");
            }
            sb.append(obj.toString());
        }
        return sb.toString();
    }

    public static boolean r0(List list) {
        return list == null || list.size() == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Serializable r1(C9.l lVar) {
        k.f(lVar, "<this>");
        if (lVar instanceof B) {
            B b5 = (B) lVar;
            if (b5.e()) {
                return b5.b();
            }
            Serializable serializableP0 = m.P0(b5.b());
            return (serializableP0 == null && (serializableP0 = t.g0(b5.b())) == null && (serializableP0 = s.U(b5.b())) == null) ? b5.b() : serializableP0;
        }
        if (lVar instanceof x) {
            return q1(lVar);
        }
        if (!(lVar instanceof C9.d)) {
            return null;
        }
        Iterable iterable = (Iterable) lVar;
        ArrayList arrayList = new ArrayList(w.c0(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(r1((C9.l) it.next()));
        }
        return arrayList;
    }

    public static String s(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            throw new IllegalArgumentException("stackTraceElements must not be null or empty");
        }
        StringBuilder sb = new StringBuilder(stackTraceElementArr.length * 30);
        for (int i6 = 0; i6 < stackTraceElementArr.length && i6 <= 40; i6++) {
            if ((i6 != 0 || !"getThreadStackTrace".equals(stackTraceElementArr[0].getMethodName())) && (i6 != 1 || !"getStackTrace".equals(stackTraceElementArr[1].getMethodName()))) {
                sb.append("\tat " + stackTraceElementArr[i6].getClassName());
                sb.append(".");
                sb.append(stackTraceElementArr[i6].getMethodName());
                sb.append("(");
                sb.append(stackTraceElementArr[i6].getFileName());
                sb.append(":");
                sb.append(stackTraceElementArr[i6].getLineNumber());
                sb.append(")\n");
            }
        }
        return sb.toString();
    }

    public static boolean s0(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    public static final int s1(stepai.android.mindx.base.d dVar) {
        k.f(dVar, "<this>");
        if (dVar.equals(stepai.android.mindx.base.c.f6199a)) {
            return 1;
        }
        if (dVar.equals(stepai.android.mindx.base.c.b)) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static ArrayList t(String str, JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                int length = jSONArrayOptJSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i6 = 0; i6 < length; i6++) {
                    String string = jSONArrayOptJSONArray.getString(i6);
                    if (!TextUtils.isEmpty(string)) {
                        arrayList.add(string);
                    }
                }
                return arrayList;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void t0(String str) {
        if (com.apm.insight.g.g.isDebugMode()) {
            Log.d("npth", String.valueOf(str));
        }
    }

    public static JSONObject u(String str, JSONObject jSONObject, String str2) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject(str2);
    }

    public static String u0(UiSnapshot uiSnapshot) {
        List<DisplaySnapshot> displays;
        List<DisplaySnapshot> list;
        Method method;
        StringBuilder sb = new StringBuilder();
        try {
            displays = uiSnapshot.getDisplays();
            list = displays;
        } catch (Throwable th) {
            AbstractC1436a.c("ability", "buildUiTreeString error", th);
        }
        if (list != null && !list.isEmpty()) {
            List<WindowStateInfo> allWindows = displays.get(0).getAllWindows();
            List<WindowStateInfo> list2 = allWindows;
            if (list2 != null && !list2.isEmpty()) {
                for (WindowStateInfo windowStateInfo : allWindows) {
                    ViewNode viewNode = null;
                    try {
                        Method[] methods = windowStateInfo.getClass().getMethods();
                        k.e(methods, "getMethods(...)");
                        int length = methods.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= length) {
                                method = null;
                                break;
                            }
                            method = methods[i6];
                            if (k.b(method.getName(), "getRootNode")) {
                                break;
                            }
                            i6++;
                        }
                        Object objInvoke = method != null ? method.invoke(windowStateInfo, null) : null;
                        if (objInvoke instanceof ViewNode) {
                            viewNode = (ViewNode) objInvoke;
                        }
                    } catch (Throwable unused) {
                    }
                    if (viewNode != null) {
                        f0(viewNode, 0, sb);
                    }
                }
                String string = sb.toString();
                k.e(string, "toString(...)");
                return string;
            }
            return "";
        }
        return "";
    }

    public static void v(int i6, String str, String str2, String str3) {
        if (AbstractC0291a.c) {
            AbstractC0291a.m(B7.a.k("report: commandId=", str2), B7.a.k(", message=", str3), B7.a.h(i6, ", code="), ", specificParams=null");
        }
        J9.k kVar = new J9.k(str, str2, null);
        kVar.b = i6;
        kVar.e = str3;
        S1.a.a(kVar);
    }

    public static double v0() throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        double dDoubleValue;
        try {
            dDoubleValue = ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", null).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(H.h.f711a), null)).doubleValue();
        } catch (Exception e6) {
            e6.printStackTrace();
            dDoubleValue = 0.0d;
        }
        Log.e("steven_battery", U7.a.e(new String[]{"capacity：" + dDoubleValue}));
        return dDoubleValue;
    }

    public static void w(int i6, String str, JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(SettingsConfig.KEY_DATA);
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("timer");
            if (jSONArrayOptJSONArray != null) {
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i10);
                    try {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("DATA_DOCTOR");
                        jSONObject3.put("DATA_SEND_RESULT", i6);
                        jSONObject3.put("DATA_SEND_URL", str);
                    } catch (Exception unused) {
                    }
                    AbstractC1654a.f5271a.b("DATA_SEND_END", jSONObject2);
                }
            }
            if (jSONArrayOptJSONArray2 != null) {
                for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                    JSONObject jSONObject4 = jSONArrayOptJSONArray2.getJSONObject(i11);
                    try {
                        JSONObject jSONObject5 = jSONObject4.getJSONObject("DATA_DOCTOR");
                        jSONObject5.put("DATA_SEND_RESULT", i6);
                        jSONObject5.put("DATA_SEND_URL", str);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    AbstractC1654a.f5271a.b("DATA_SEND_END", jSONObject4);
                }
            }
        } catch (Exception e9) {
            e9.printStackTrace();
        }
    }

    public static int w0(String str, JSONObject jSONObject) {
        try {
            if (!jSONObject.has(str)) {
                return 0;
            }
            int i6 = jSONObject.getInt(str);
            jSONObject.remove(str);
            return i6;
        } catch (Exception e6) {
            o.g("JsonUtils", "removeInt", e6);
            return 0;
        }
    }

    public static void x(long j5, long j6, String str, String str2, int i6, JSONObject jSONObject) {
        L0.d.f925a.b(new X.a(j5, j6, str, str2, i6, jSONObject));
        if (H.h.b) {
            Log.d("ApmInsight", U7.a.e(new String[]{"Receive:NetData"}));
        }
    }

    public static synchronized File x0() {
        try {
            if (e == null) {
                File file = new File(AbstractC1451a.b.getFilesDir(), "apm6");
                e = file;
                if (!file.exists()) {
                    e.mkdirs();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return e;
    }

    public static void y(long j5, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            IApmAgent iApmAgent = (IApmAgent) L2.a.a(IApmAgent.class);
            if (iApmAgent != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, j5);
                iApmAgent.monitorEvent("memory_dump_event", null, jSONObject, null);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static String y0(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    public static void z(P.e eVar) {
        O0.a aVarA = O0.a.a();
        aVarA.getClass();
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry entry : aVarA.f1031a.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        eVar.f = jSONObject;
    }

    public static JSONObject z0(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys;
        if (jSONObject == null || jSONObject2 == null || (itKeys = jSONObject2.keys()) == null) {
            return null;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.isNull(next)) {
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
        return jSONObject;
    }

    public abstract String g0();

    public String toString() {
        switch (this.f1165a) {
            case 3:
                return g0();
            default:
                return super.toString();
        }
    }
}
