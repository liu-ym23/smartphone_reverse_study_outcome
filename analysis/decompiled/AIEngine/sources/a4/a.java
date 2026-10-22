package a4;

import android.app.AppOpsManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.widget.f1;
import androidx.lifecycle.q;
import b1.b;
import ba.e;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.MalformedJsonException;
import com.stepos.aiengine.R;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.crypto.OtaAtRestDecryptor;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.database.DownloadInfo;
import d5.o;
import dd.d;
import f5.g;
import fc.j;
import g1.a;
import hb.h;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Logger;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.random.Random;
import kotlin.time.DurationUnit;
import mb.m;
import org.json.JSONException;
import org.json.JSONObject;
import z7.a;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class a implements g, h {
    public static Method h;

    /* renamed from: i, reason: collision with root package name */
    public static volatile OtaAtRestDecryptor f37i;

    /* renamed from: j, reason: collision with root package name */
    public static Field f38j;

    /* renamed from: k, reason: collision with root package name */
    public static Field f39k;

    /* renamed from: l, reason: collision with root package name */
    public static a f40l;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f41g;

    public /* synthetic */ a(int i10) {
        this.f41g = i10;
    }

    public static final boolean a(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (kotlin.jvm.internal.g.g(cCharAt, TraceIdKeys.MAX_LENGTH) >= 0 || Character.isLetter(cCharAt)) {
                return true;
            }
        }
        return false;
    }

    public static final void b(Logger logger, dd.a aVar, d dVar, String str) {
        logger.fine(dVar.f8473b + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + aVar.f8466a);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.coroutines.jvm.internal.RestrictedSuspendLambda, zb.p] */
    public static final void e(View view) {
        kotlin.jvm.internal.g.f(view, "<this>");
        j jVarO = o((RestrictedSuspendLambda) androidx.core.view.a.a(view).f8823b);
        while (jVarO.hasNext()) {
            View view2 = (View) jVarO.next();
            b bVar = (b) view2.getTag(R.id.pooling_container_listener_holder_tag);
            if (bVar == null) {
                bVar = new b();
                view2.setTag(R.id.pooling_container_listener_holder_tag, bVar);
            }
            ArrayList<b1.a> arrayList = bVar.f3035a;
            for (int iA0 = m.a0(arrayList); -1 < iA0; iA0--) {
                arrayList.get(iA0).a();
            }
        }
    }

    public static int f(Context context, String str, int i10, int i11, String str2) {
        int iNoteProxyOpNoThrow;
        if (context.checkPermission(str, i10, i11) != -1) {
            String strPermissionToOp = AppOpsManager.permissionToOp(str);
            if (strPermissionToOp != null) {
                if (str2 == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(i11);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        str2 = packagesForUid[0];
                    }
                }
                int iMyUid = Process.myUid();
                String packageName = context.getPackageName();
                if (iMyUid == i11 && Objects.equals(packageName, str2)) {
                    AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
                    iNoteProxyOpNoThrow = appOpsManager == null ? 1 : appOpsManager.checkOpNoThrow(strPermissionToOp, Binder.getCallingUid(), str2);
                    if (iNoteProxyOpNoThrow == 0) {
                        iNoteProxyOpNoThrow = appOpsManager != null ? appOpsManager.checkOpNoThrow(strPermissionToOp, i11, context.getOpPackageName()) : 1;
                    }
                } else {
                    iNoteProxyOpNoThrow = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(strPermissionToOp, str2);
                }
                if (iNoteProxyOpNoThrow != 0) {
                    return -2;
                }
            }
            return 0;
        }
        return -1;
    }

    public static int g(Context context, String str) {
        return f(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static void h(Object obj, boolean z) throws NoSuchFieldException, SecurityException {
        if (!z || f39k == null) {
            if (z || f38j == null) {
                Field declaredField = null;
                try {
                    declaredField = obj.getClass().getDeclaredField("mStateSaved");
                    declaredField.setAccessible(true);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (z) {
                    f39k = declaredField;
                } else {
                    f38j = declaredField;
                }
            }
        }
    }

    public static final double i(double d8, DurationUnit durationUnit, DurationUnit targetUnit) {
        kotlin.jvm.internal.g.f(targetUnit, "targetUnit");
        long jConvert = targetUnit.f10105a.convert(1L, durationUnit.f10105a);
        return jConvert > 0 ? d8 * jConvert : d8 / r8.convert(1L, r9);
    }

    public static final long j(long j10, DurationUnit sourceUnit, DurationUnit targetUnit) {
        kotlin.jvm.internal.g.f(sourceUnit, "sourceUnit");
        kotlin.jvm.internal.g.f(targetUnit, "targetUnit");
        return targetUnit.f10105a.convert(j10, sourceUnit.f10105a);
    }

    public static void k(String str, String str2) {
        Log.d("CloudSDK_".concat(str), str2);
    }

    public static final String l(long j10) {
        return String.format("%6s", Arrays.copyOf(new Object[]{j10 <= -999500000 ? ai.onnxruntime.a.m(new StringBuilder(), (j10 - 500000000) / 1000000000, " s ") : j10 <= -999500 ? ai.onnxruntime.a.m(new StringBuilder(), (j10 - 500000) / 1000000, " ms") : j10 <= 0 ? ai.onnxruntime.a.m(new StringBuilder(), (j10 - 500) / 1000, " µs") : j10 < 999500 ? ai.onnxruntime.a.m(new StringBuilder(), (j10 + 500) / 1000, " µs") : j10 < 999500000 ? ai.onnxruntime.a.m(new StringBuilder(), (j10 + 500000) / 1000000, " ms") : ai.onnxruntime.a.m(new StringBuilder(), (j10 + 500000000) / 1000000000, " s ")}, 1));
    }

    public static String m(Context context) throws Throwable {
        e eVarC;
        Throwable th;
        Exception exc;
        String str;
        Cursor cursorQuery;
        ba.d dVarB = ba.d.b();
        Context applicationContext = context.getApplicationContext();
        ba.a aVar = dVarB.f3148b;
        String str2 = aVar.f3143c;
        if (aVar.f3141a > System.currentTimeMillis()) {
            return aVar.f3142b;
        }
        Cursor cursor = null;
        str = null;
        str = null;
        String str3 = null;
        cursor = null;
        if (!dVarB.e(applicationContext, true) || (eVarC = dVarB.c(applicationContext)) == null || !eVarC.f3156c) {
            return null;
        }
        try {
            try {
                cursorQuery = applicationContext.getContentResolver().query(Uri.parse(eVarC.f3155b), null, null, new String[]{str2}, null);
            } catch (Exception e10) {
                exc = e10;
                str = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (cursorQuery != null) {
                ba.b bVarA = ba.d.a(cursorQuery);
                str3 = bVarA.f3144a;
                aVar.f3142b = str3;
                aVar.f3141a = bVarA.f3146c;
                if (bVarA.f3145b != 1000) {
                    dVarB.d(applicationContext, eVarC.f3154a);
                    if (!dVarB.e(applicationContext, false)) {
                        dVarB.e(applicationContext, true);
                    }
                }
            } else if (dVarB.e(applicationContext, false)) {
                dVarB.e(applicationContext, true);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return str3;
        } catch (Exception e11) {
            exc = e11;
            str = str3;
            cursor = cursorQuery;
            exc.getMessage();
            if (cursor != null) {
                cursor.close();
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            cursor = cursorQuery;
            if (cursor == null) {
                throw th;
            }
            cursor.close();
            throw th;
        }
    }

    public static final boolean n() throws NoSuchMethodException, SecurityException {
        Context context = null;
        try {
            if (h == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null);
                h = method;
                method.setAccessible(true);
            }
            context = (Context) h.invoke(null, null);
        } catch (Exception e10) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e10.toString());
        }
        if (context == null) {
            return false;
        }
        return ba.d.b().e(context, false);
    }

    public static j o(p pVar) {
        j jVar = new j();
        jVar.f8821d = jd.b.o(pVar, jVar, jVar);
        return jVar;
    }

    public static final long p(Random random, dc.g gVar) {
        kotlin.jvm.internal.g.f(random, "<this>");
        long j10 = gVar.f8463a;
        if (!gVar.isEmpty()) {
            long j11 = gVar.f8464b;
            return j11 < Long.MAX_VALUE ? random.d(j10, j11 + 1) : j10 > Long.MIN_VALUE ? random.d(j10 - 1, j11) + 1 : random.c();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + gVar);
    }

    public static void q(InputConnection inputConnection, EditorInfo editorInfo, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof f1) {
                editorInfo.hintText = ((f1) parent).a();
                return;
            }
        }
    }

    public static o r(k5.a aVar) {
        boolean z;
        try {
            try {
                aVar.R0();
                z = false;
            } catch (EOFException e10) {
                e = e10;
                z = true;
            }
            try {
                return (o) g5.p.z.a(aVar);
            } catch (EOFException e11) {
                e = e11;
                if (z) {
                    return d5.p.f8382a;
                }
                throw new JsonSyntaxException(e);
            }
        } catch (MalformedJsonException e12) {
            throw new JsonSyntaxException(e12);
        } catch (IOException e13) {
            throw new JsonIOException(e13);
        } catch (NumberFormatException e14) {
            throw new JsonSyntaxException(e14);
        }
    }

    public static final boolean s(String method) {
        kotlin.jvm.internal.g.f(method, "method");
        return (method.equals("GET") || method.equals("HEAD")) ? false : true;
    }

    public static boolean t(Context context, String str, String str2, String str3, String str4) {
        long jA = w7.a.a(context);
        if (jA < 1000001) {
            return true;
        }
        z7.a aVar = a.C0182a.f14277a;
        String packageName = context.getPackageName();
        aVar.getClass();
        return !TextUtils.isEmpty(str4) && str4.equals(z7.a.a(str, str2, packageName, jA, str3));
    }

    public static final void u(View view, q qVar) {
        kotlin.jvm.internal.g.f(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, qVar);
    }

    public static final a.C0083a v(String name) {
        kotlin.jvm.internal.g.f(name, "name");
        return new a.C0083a(name);
    }

    public static final void w(Download download, DownloadInfo downloadInfo) {
        kotlin.jvm.internal.g.f(download, "<this>");
        kotlin.jvm.internal.g.f(downloadInfo, "downloadInfo");
        downloadInfo.setId(download.getId());
        downloadInfo.setNamespace(download.getNamespace());
        downloadInfo.setUrl(download.getUrl());
        downloadInfo.setFile(download.getFile());
        downloadInfo.setGroup(download.getGroup());
        downloadInfo.setPriority(download.getPriority());
        downloadInfo.setHeaders(kotlin.collections.b.n0(download.getHeaders()));
        downloadInfo.setDownloaded(download.getDownloaded());
        downloadInfo.setTotal(download.getTotal());
        downloadInfo.setStatus(download.getStatus());
        downloadInfo.setNetworkType(download.getNetworkType());
        downloadInfo.setError(download.getError());
        downloadInfo.setCreated(download.getCreated());
        downloadInfo.setTag(download.getTag());
        downloadInfo.setEnqueueAction(download.getEnqueueAction());
        downloadInfo.setIdentifier(download.getIdentifier());
        downloadInfo.setDownloadOnEnqueue(download.getDownloadOnEnqueue());
        downloadInfo.setExtras(download.getExtras());
        downloadInfo.setAutoRetryMaxAttempts(download.getAutoRetryMaxAttempts());
        downloadInfo.setAutoRetryAttempts(download.getAutoRetryAttempts());
    }

    @Override // f5.g
    public Object c() {
        switch (this.f41g) {
            case 14:
                return new TreeSet();
            case 15:
                return new ArrayDeque();
            case 16:
                return new ConcurrentSkipListMap();
            case 17:
                return new TreeMap();
            default:
                return new LinkedTreeMap();
        }
    }

    @Override // hb.h
    public boolean d() {
        return false;
    }

    public String toString() throws JSONException {
        switch (this.f41g) {
            case 12:
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("noBootUp", false);
                    jSONObject.put("replacePackage", "");
                    jSONObject.put("printLog", false);
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
                return jSONObject.toString();
            default:
                return super.toString();
        }
    }
}
