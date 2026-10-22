package f1;

import J0.e;
import O0.f;
import O0.k;
import P0.c;
import S.InterfaceC0103i;
import T2.d;
import Z0.j;
import Z2.E0;
import Z2.K;
import Z2.Q;
import Z2.T;
import Z2.y0;
import a2.AbstractC0155a;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.TypedValue;
import android.view.View;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.B;
import androidx.lifecycle.G;
import androidx.room.A;
import androidx.room.AbstractC0351g;
import androidx.room.E;
import androidx.room.w;
import androidx.work.impl.WorkDatabase;
import com.airbnb.lottie.LottieComposition;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.android.gms.common.api.Status;
import com.stepos.alphame.utils.Property;
import d3.g;
import d3.h;
import d3.q;
import d3.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import k3.C0679A;
import k3.C0688c;
import k3.C0689d;
import k3.InterfaceC0680B;
import k3.s;
import k3.u;
import k3.v;
import k3.z;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import l1.C0758c;
import m3.i;
import org.json.JSONObject;
import s.AbstractC0831a;
import s0.C0844b;
import s0.I;
import t0.J;
import t0.y;

/* renamed from: f1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0557a {

    /* renamed from: a, reason: collision with root package name */
    public static Context f12517a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f12518b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f12519c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f12520d;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f12521e;

    /* renamed from: f, reason: collision with root package name */
    public static Boolean f12522f;

    /* renamed from: g, reason: collision with root package name */
    public static Field f12523g;

    /* renamed from: h, reason: collision with root package name */
    public static Field f12524h;

    public static final void B(CoroutineContext coroutineContext, Throwable th) {
        Throwable runtimeException;
        Iterator it = g.f12452a.iterator();
        while (it.hasNext()) {
            try {
                ((CoroutineExceptionHandler) it.next()).handleException(coroutineContext, th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    ExceptionsKt.addSuppressed(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            ExceptionsKt.addSuppressed(th, new h(coroutineContext));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static T E(long j4, Runnable runnable, CoroutineContext coroutineContext) {
        return K.f2184a.invokeOnTimeout(j4, runnable, coroutineContext);
    }

    public static boolean F(Context context) {
        d.d("SharedPreferencesHelper", "init SharedPreferences, name: com.stepos.statsapp.v3.request_feq_restrict");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.stepos.statsapp.v3.request_feq_restrict", 0);
        d.a("SharedPreferencesHelper", "com.stepos.statsapp.v3.request_feq_restrict structure complete");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH");
        String string = sharedPreferences.getString("date", "");
        String str = simpleDateFormat.format(new Date());
        if (!string.equals(str)) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("date", str);
            editorEdit.putLong("current_request", 1L);
            editorEdit.commit();
            d.a("RequestFreqRestrict", "isAllow true");
            return true;
        }
        long j4 = sharedPreferences.getLong("current_request", 0L);
        if (j4 > 10) {
            d.a("RequestFreqRestrict", "isAllow false");
            return false;
        }
        sharedPreferences.edit().putLong("current_request", j4 + 1).commit();
        d.a("RequestFreqRestrict", "isAllow true");
        return true;
    }

    public static final boolean G(AssertionError assertionError) {
        String message;
        Logger logger = s.f13375a;
        Intrinsics.checkNotNullParameter(assertionError, "<this>");
        return (assertionError.getCause() == null || (message = assertionError.getMessage()) == null || !StringsKt.c(message, "getsockname failed")) ? false : true;
    }

    public static boolean H(int i4) {
        boolean z4;
        if (i4 != 0) {
            ThreadLocal threadLocal = D.a.f355a;
            double[] dArr = (double[]) threadLocal.get();
            if (dArr == null) {
                dArr = new double[3];
                threadLocal.set(dArr);
            }
            int iRed = Color.red(i4);
            int iGreen = Color.green(i4);
            int iBlue = Color.blue(i4);
            if (dArr.length != 3) {
                throw new IllegalArgumentException("outXyz must have a length of 3.");
            }
            double d4 = iRed / 255.0d;
            double dPow = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
            double d5 = iGreen / 255.0d;
            double dPow2 = d5 < 0.04045d ? d5 / 12.92d : Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
            double d6 = iBlue / 255.0d;
            double dPow3 = d6 < 0.04045d ? d6 / 12.92d : Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
            z4 = false;
            dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * 100.0d;
            double d7 = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * 100.0d;
            dArr[1] = d7;
            dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * 100.0d;
            if (d7 / 100.0d > 0.5d) {
                return true;
            }
        } else {
            z4 = false;
        }
        return z4;
    }

    public static boolean K(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f12519c == null) {
            f12519c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        f12519c.booleanValue();
        if (f12520d == null) {
            f12520d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f12520d.booleanValue();
    }

    public static int L(float f4, int i4, int i5) {
        return D.a.b(D.a.d(i5, Math.round(Color.alpha(i5) * f4)), i4);
    }

    public static float M(float f4, float f5, float f6) {
        return AbstractC0831a.c(f5, f4, f6, f4);
    }

    public static IntBuffer N() {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        return byteBufferAllocateDirect.asIntBuffer();
    }

    public static void Q(Context context, String str, String str2, String str3, String str4, String str5) {
        HashMap map = new HashMap(8);
        map.put("en", str);
        map.put("ti", str3);
        if (TextUtils.isEmpty(str5)) {
            str5 = String.valueOf(System.currentTimeMillis() / 1000);
        }
        map.put(MapBundleKey.MapObjKey.OBJ_SL_TIME, str5);
        map.put("pn", str2);
        map.put("pv", "5.0.7");
        map.put("nm", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("si", str4);
        map.put("di", "");
        try {
            String string = new JSONObject(map).toString();
            Intent intent = new Intent();
            String strD = J.d(context);
            intent.setPackage(strD);
            intent.setAction("com.stepos.pushservice".equals(strD) ? "com.stepos.cloud.pushservice.action.PUSH_TRACKER_SERVICE" : "com.meizu.cloud.pushservice.action.PUSH_TRACKER_SERVICE");
            intent.putExtra("extra_push_tracker", string);
            context.startService(intent);
            AbstractC0155a.a("UsageStatsUtils", "startTrackerService success" + string);
        } catch (Exception e4) {
            AbstractC0155a.c("UsageStatsUtils", "startTrackerService error " + e4.getMessage());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:631:0x099f A[LOOP:1: B:629:0x0999->B:631:0x099f, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static L0.b R(android.util.JsonReader r28, com.airbnb.lottie.LottieComposition r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3000
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.AbstractC0557a.R(android.util.JsonReader, com.airbnb.lottie.LottieComposition):L0.b");
    }

    public static ArrayList S(float f4, JsonReader jsonReader, LottieComposition lottieComposition, k kVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (!strNextName.equals("k")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(f.a(jsonReader, lottieComposition, f4, kVar, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(f.a(jsonReader, lottieComposition, f4, kVar, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(f.a(jsonReader, lottieComposition, f4, kVar, false));
            }
        }
        jsonReader.endObject();
        Z(arrayList);
        return arrayList;
    }

    public static stepos.support.v7.app.palette.b T(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                boolean z4 = false;
                Q0.a aVarA = f.a(jsonReader, lottieComposition, c.c(), O0.g.f1530a, jsonReader.peek() == JsonToken.BEGIN_OBJECT);
                Float f4 = aVarA.f1631f;
                float f5 = aVarA.f1630e;
                Object obj = aVarA.f1627b;
                Object obj2 = aVarA.f1628c;
                H0.f fVar = new H0.f(lottieComposition, obj, obj2, aVarA.f1629d, f5, f4);
                if (obj2 != null && obj != null) {
                    PointF pointF = (PointF) obj2;
                    if (((PointF) obj).equals(pointF.x, pointF.y)) {
                        z4 = true;
                    }
                }
                if (obj2 != null && !z4) {
                    PointF pointF2 = (PointF) obj;
                    PointF pointF3 = (PointF) obj2;
                    PointF pointF4 = aVarA.f1634i;
                    PointF pointF5 = aVarA.f1635j;
                    Path path = new Path();
                    path.moveTo(pointF2.x, pointF2.y);
                    if (pointF4 == null || pointF5 == null || (pointF4.length() == Property.DEFAULT_FLOAT_VALUE && pointF5.length() == Property.DEFAULT_FLOAT_VALUE)) {
                        path.lineTo(pointF3.x, pointF3.y);
                    } else {
                        float f6 = pointF4.x + pointF2.x;
                        float f7 = pointF2.y + pointF4.y;
                        float f8 = pointF3.x;
                        float f9 = f8 + pointF5.x;
                        float f10 = pointF3.y;
                        path.cubicTo(f6, f7, f9, f10 + pointF5.y, f8, f10);
                    }
                    fVar.f696k = path;
                }
                arrayList.add(fVar);
            }
            jsonReader.endArray();
            Z(arrayList);
        } else {
            arrayList.add(new Q0.a(com.stepos.statsrpk.c.B(jsonReader, c.c())));
        }
        return new stepos.support.v7.app.palette.b(2, arrayList);
    }

    public static K0.d U(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        stepos.support.v7.app.palette.b bVarT = null;
        K0.b bVarA0 = null;
        K0.b bVarA02 = null;
        boolean z4 = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "k":
                    bVarT = T(jsonReader, lottieComposition);
                    continue;
                case "x":
                    if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        break;
                    } else {
                        bVarA0 = B0.f.a0(jsonReader, lottieComposition, true);
                    }
                case "y":
                    if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        break;
                    } else {
                        bVarA02 = B0.f.a0(jsonReader, lottieComposition, true);
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            z4 = true;
        }
        jsonReader.endObject();
        if (z4) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
        }
        return bVarT != null ? bVarT : new i(bVarA0, bVarA02);
    }

    public static TypedValue V(int i4, Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i4, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean W(Context context, int i4, boolean z4) {
        TypedValue typedValueV = V(i4, context);
        return (typedValueV == null || typedValueV.type != 18) ? z4 : typedValueV.data != 0;
    }

    public static void X(e eVar, int i4, ArrayList arrayList, e eVar2, G0.k kVar) {
        if (eVar.a(i4, kVar.getName())) {
            String name = kVar.getName();
            eVar2.getClass();
            e eVar3 = new e(eVar2);
            eVar3.f872a.add(name);
            e eVar4 = new e(eVar3);
            eVar4.f873b = kVar;
            arrayList.add(eVar4);
        }
    }

    public static TypedValue Y(Context context, String str, int i4) {
        TypedValue typedValueV = V(i4, context);
        if (typedValueV != null) {
            return typedValueV;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i4)));
    }

    public static void Z(ArrayList arrayList) {
        int i4;
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            i4 = size - 1;
            if (i5 >= i4) {
                break;
            }
            Q0.a aVar = (Q0.a) arrayList.get(i5);
            i5++;
            aVar.f1631f = Float.valueOf(((Q0.a) arrayList.get(i5)).f1630e);
        }
        Q0.a aVar2 = (Q0.a) arrayList.get(i4);
        if (aVar2.f1627b == null) {
            arrayList.remove(aVar2);
        }
    }

    public static void a0(Status status, Object obj, C0758c c0758c) {
        if (status.f9612b <= 0) {
            c0758c.a(obj);
            return;
        }
        Exception jVar = status.f9614d != null ? new j(status) : new Z0.d(status);
        l1.h hVar = c0758c.f13454a;
        hVar.getClass();
        synchronized (hVar.f13463a) {
            hVar.a();
            hVar.f13465c = true;
            hVar.f13467e = jVar;
        }
        hVar.f13464b.g(hVar);
    }

    public static final z b0(Socket socket) throws IOException {
        Logger logger = s.f13375a;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        C0679A c0679a = new C0679A(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream()");
        return c0679a.sink(new C0688c(outputStream, c0679a));
    }

    public static void c(Context context, String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            str = context.getSharedPreferences("com.stepos.push", 0).getString("app_id", "");
        }
        context.getSharedPreferences("com.stepos.push", 0).edit().putInt(AbstractC0351g.p(str, ".push_id_expire_time"), i4).apply();
    }

    public static final InterfaceC0680B c0(Socket socket) throws IOException {
        Logger logger = s.f13375a;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        C0679A c0679a = new C0679A(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream()");
        return c0679a.source(new C0689d(inputStream, c0679a));
    }

    public static final long d0(String str, long j4, long j5, long j6) {
        String property;
        int i4 = x.f12483a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j4;
        }
        Long longOrNull = StringsKt.toLongOrNull(property);
        if (longOrNull == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = longOrNull.longValue();
        if (j5 <= jLongValue && jLongValue <= j6) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j5 + ".." + j6 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int e0(String str, int i4, int i5, int i6, int i7) {
        if ((i7 & 4) != 0) {
            i5 = 1;
        }
        if ((i7 & 8) != 0) {
            i6 = Integer.MAX_VALUE;
        }
        return (int) d0(str, i4, i5, i6);
    }

    public static PointF f(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void f0(Status status, Object obj, C0758c c0758c) {
        if (status.f9612b <= 0) {
            c0758c.c(obj);
        } else {
            c0758c.b(status.f9614d != null ? new j(status) : new Z0.d(status));
        }
    }

    public static final u g(z zVar) {
        Intrinsics.checkNotNullParameter(zVar, "<this>");
        return new u(zVar);
    }

    public static final v h(InterfaceC0680B interfaceC0680B) {
        Intrinsics.checkNotNullParameter(interfaceC0680B, "<this>");
        return new v(interfaceC0680B);
    }

    public static void i(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = context.getSharedPreferences("com.stepos.push", 0).getString("app_id", "");
        }
        context.getSharedPreferences("com.stepos.push", 0).edit().putString(AbstractC0351g.p(str, ".push_id"), str2).apply();
    }

    public static final void j(WorkDatabase workDatabase, C0844b configuration, y continuation) {
        int i4;
        Intrinsics.checkNotNullParameter(workDatabase, "workDatabase");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        List listMutableListOf = CollectionsKt.mutableListOf(continuation);
        int i5 = 0;
        while (!listMutableListOf.isEmpty()) {
            List list = ((y) CollectionsKt.removeLast(listMutableListOf)).f15430e;
            Intrinsics.checkNotNullExpressionValue(list, "current.work");
            List list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                i4 = 0;
            } else {
                Iterator it = list2.iterator();
                i4 = 0;
                while (it.hasNext()) {
                    if ((!((I) it.next()).f14164b.f176j.f14192h.isEmpty()) && (i4 = i4 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            i5 += i4;
        }
        if (i5 == 0) {
            return;
        }
        B0.u uVarG = workDatabase.g();
        uVarG.getClass();
        E eD = E.d(0, "Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)");
        A a4 = uVarG.f191a;
        a4.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(a4, eD);
        try {
            int i6 = cursorH.moveToFirst() ? cursorH.getInt(0) : 0;
            cursorH.close();
            eD.e();
            int i7 = configuration.f14178i;
            if (i6 + i5 > i7) {
                throw new IllegalArgumentException(AbstractC0831a.d(B0.g.u("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: ", i7, ";\nalready enqueued count: ", i6, ";\ncurrent enqueue operation count: "), i5, ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed."));
            }
        } catch (Throwable th) {
            cursorH.close();
            eD.e();
            throw th;
        }
    }

    public static void k(Object obj, boolean z4) throws NoSuchFieldException, SecurityException {
        if (!z4 || f12524h == null) {
            if (z4 || f12523g == null) {
                Field declaredField = null;
                try {
                    declaredField = obj.getClass().getDeclaredField("mStateSaved");
                    declaredField.setAccessible(true);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                if (z4) {
                    f12524h = declaredField;
                } else {
                    f12523g = declaredField;
                }
            }
        }
    }

    public static float n(float f4, float f5, float f6) {
        return f4 < f5 ? f5 : f4 > f6 ? f6 : f4;
    }

    public static int o(int i4, int i5, int i6) {
        return i4 < i5 ? i5 : i4 > i6 ? i6 : i4;
    }

    public static float p(float f4, float f5, float f6) {
        return Math.max(f5, Math.min(f6, f4));
    }

    public static final w q(Context context, Class klass, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(klass, "klass");
        if (!StringsKt.isBlank(str)) {
            return new w(context, klass, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder".toString());
    }

    public static final Object r(InterfaceC0103i interfaceC0103i, Function2 function2, Continuation continuation) {
        return interfaceC0103i.a(new V.i(function2, null), continuation);
    }

    public static int s(float f4, float f5) {
        int i4 = (int) f4;
        int i5 = (int) f5;
        int i6 = i4 / i5;
        int i7 = i4 % i5;
        if (!((i4 ^ i5) >= 0) && i7 != 0) {
            i6--;
        }
        return i4 - (i5 * i6);
    }

    public static int x(int i4, View view) {
        Context context = view.getContext();
        TypedValue typedValueY = Y(view.getContext(), view.getClass().getCanonicalName(), i4);
        int i5 = typedValueY.resourceId;
        return i5 != 0 ? androidx.core.content.b.a(context, i5) : typedValueY.data;
    }

    public static Integer y(int i4, Context context) {
        TypedValue typedValueV = V(i4, context);
        if (typedValueV == null) {
            return null;
        }
        int i5 = typedValueV.resourceId;
        return Integer.valueOf(i5 != 0 ? androidx.core.content.b.a(context, i5) : typedValueV.data);
    }

    public static final B z(G g4) {
        B b4;
        Intrinsics.checkNotNullParameter(g4, "<this>");
        AbstractC0328z lifecycle = g4.getLifecycle();
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        while (true) {
            b4 = (B) lifecycle.f3989a.get();
            if (b4 != null) {
                break;
            }
            E0 e0B = Z2.I.b();
            f3.d dVar = Q.f2189a;
            y0 y0Var = q.f12477a;
            b4 = new B(lifecycle, CoroutineContext.Element.DefaultImpls.plus(e0B, y0Var.getImmediate()));
            if (lifecycle.f3989a.compareAndSet(null, b4)) {
                J.y(b4, y0Var.getImmediate(), new androidx.lifecycle.A(b4, null), 2);
                break;
            }
        }
        return b4;
    }

    public abstract String[] A(Class cls);

    public abstract boolean J(Class cls);

    public abstract void O(int i4);

    public abstract void P(Typeface typeface, boolean z4);

    public abstract Method t(Class cls, Field field);

    public abstract Constructor v(Class cls);
}
