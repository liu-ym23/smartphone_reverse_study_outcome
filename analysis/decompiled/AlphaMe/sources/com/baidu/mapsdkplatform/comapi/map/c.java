package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.AbstractC0351g;
import ch.qos.logback.classic.spi.CallerData;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.commonutils.b.c;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.stepos.alphame.utils.Consts;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f8027a = "c";

    /* renamed from: b, reason: collision with root package name */
    private AsyncHttpClient f8028b;

    public class a extends HttpClient.ProtoResultCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8029a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8030b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC0029c f8031c;

        public a(Context context, String str, InterfaceC0029c interfaceC0029c) {
            this.f8029a = context;
            this.f8030b = str;
            this.f8031c = interfaceC0029c;
        }

        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        public void onFailed(HttpClient.HttpStateError httpStateError) {
            String strA = c.this.a(this.f8029a, this.f8030b);
            if (!c.this.b(strA)) {
                strA = null;
            }
            InterfaceC0029c interfaceC0029c = this.f8031c;
            if (interfaceC0029c != null) {
                interfaceC0029c.onCustomMapStyleLoadFailed(httpStateError.ordinal(), httpStateError.name(), strA);
            }
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap failed error = " + httpStateError.ordinal());
            }
        }

        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        public void onSuccess(String str) throws IOException {
            c.this.a(this.f8029a, str, this.f8030b, this.f8031c);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap result = " + str);
            }
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.map.c$c, reason: collision with other inner class name */
    public interface InterfaceC0029c {
        void onCustomMapStyleLoadFailed(int i4, String str, String str2);

        void onCustomMapStyleLoadSuccess(boolean z4, String str);

        void onPreLoadLastCustomMapStyle(String str);
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final c f8039a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    private c() {
        this.f8028b = new AsyncHttpClient();
    }

    private void b(Context context, String str, String str2, InterfaceC0029c interfaceC0029c) {
        this.f8028b.get(str, new a(context, str2, interfaceC0029c));
    }

    private String b(Context context, String str) {
        if (!b(a(context, str))) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray(a(context));
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                String strOptString = ((JSONObject) jSONArray.opt(i4)).optString(str);
                if (!TextUtils.isEmpty(strOptString)) {
                    return strOptString;
                }
            }
            return "";
        } catch (JSONException unused) {
            return "";
        }
    }

    public static c a() {
        return d.f8039a;
    }

    public void a(Context context, String str, InterfaceC0029c interfaceC0029c) {
        a(context, str, true, interfaceC0029c);
    }

    private void a(Context context, String str, boolean z4, InterfaceC0029c interfaceC0029c) {
        String strA = a(context, str);
        if (!b(strA)) {
            strA = null;
        }
        if (interfaceC0029c != null) {
            interfaceC0029c.onPreLoadLastCustomMapStyle(strA);
        }
        if (!NetworkUtil.isNetworkAvailable(context)) {
            if (interfaceC0029c != null) {
                HttpClient.HttpStateError httpStateError = HttpClient.HttpStateError.NETWORK_ERROR;
                interfaceC0029c.onCustomMapStyleLoadFailed(httpStateError.ordinal(), httpStateError.name(), strA);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA2 = a(context, str, z4);
        if (TextUtils.isEmpty(strA2)) {
            Log.e(f8027a, "build request url failed");
        } else {
            b(context, strA2, str, interfaceC0029c);
        }
    }

    public class b implements c.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8033a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8034b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC0029c f8035c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f8036d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f8037e;

        public b(Context context, String str, InterfaceC0029c interfaceC0029c, String str2, String str3) {
            this.f8033a = context;
            this.f8034b = str;
            this.f8035c = interfaceC0029c;
            this.f8036d = str2;
            this.f8037e = str3;
        }

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.b.c.d
        public void a(File file) throws Throwable {
            boolean zA = c.this.a(this.f8033a, file, this.f8034b);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap loadStyleFile success ret = " + zA);
            }
            if (zA) {
                c.this.a(this.f8033a, this.f8034b, this.f8036d);
                if (this.f8035c != null) {
                    this.f8035c.onCustomMapStyleLoadSuccess(true, c.this.b(this.f8037e) ? this.f8037e : null);
                    return;
                }
                return;
            }
            InterfaceC0029c interfaceC0029c = this.f8035c;
            if (interfaceC0029c != null) {
                interfaceC0029c.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "UnZipStyleFile onFailed", null);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.b.c.d
        public void a() {
            InterfaceC0029c interfaceC0029c = this.f8035c;
            if (interfaceC0029c != null) {
                interfaceC0029c.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "loadStyleFile onFailed", null);
            }
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap loadStyleFile failed");
            }
        }
    }

    private String a(Context context, String str, boolean z4) {
        if (context == null) {
            return "";
        }
        String strB = b(context, str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MapBundleKey.MapObjKey.OBJ_STYLE_ID, str);
        if (z4) {
            linkedHashMap.put("type", "publish");
        } else {
            linkedHashMap.put("type", "edit");
        }
        linkedHashMap.put("md5", strB);
        linkedHashMap.put("token", SyncSysInfo.getAuthToken());
        StringBuilder sbS = B0.g.s(a(linkedHashMap));
        sbS.append(SyncSysInfo.getPhoneInfo());
        String string = sbS.toString();
        StringBuilder sbV = B0.g.v(string, "&sign=");
        sbV.append(AppMD5.getSignMD5String(string));
        return a("api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/custom/v2/getjsonstyle") + CallerData.NA + sbV.toString();
    }

    private String a(Map<String, String> map) {
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        for (String str : map.keySet()) {
            String strEncodeUrlParamsValue = AppMD5.encodeUrlParamsValue(map.get(str));
            if (i4 == 0) {
                AbstractC0831a.h(sb, str, Consts.SPLITTER_EQUAL, strEncodeUrlParamsValue);
            } else {
                AbstractC0351g.C(sb, "&", str, Consts.SPLITTER_EQUAL, strEncodeUrlParamsValue);
            }
            i4++;
        }
        return sb.toString();
    }

    private String a(String str) {
        if (HttpClient.isHttpsEnable) {
            return B0.g.m("https://", str);
        }
        return B0.g.m("http://", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, InterfaceC0029c interfaceC0029c) throws IOException {
        String strA = a(context, str2);
        String str3 = b(strA) ? strA : null;
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0029c != null) {
                HttpClient.HttpStateError httpStateError = HttpClient.HttpStateError.SERVER_ERROR;
                interfaceC0029c.onCustomMapStyleLoadFailed(httpStateError.ordinal(), httpStateError.name(), str3);
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("status");
            String strOptString = jSONObject.optString("message");
            if (!a(iOptInt, strA)) {
                if (interfaceC0029c != null) {
                    interfaceC0029c.onCustomMapStyleLoadSuccess(false, str3);
                }
            } else {
                if (iOptInt != 0) {
                    if (interfaceC0029c != null) {
                        interfaceC0029c.onCustomMapStyleLoadFailed(iOptInt, strOptString, str3);
                        return;
                    }
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                    a(context, jSONObjectOptJSONObject.optString("pb_url", ""), str2, jSONObjectOptJSONObject.optString("md5", ""), interfaceC0029c);
                } else if (interfaceC0029c != null) {
                    interfaceC0029c.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.SERVER_ERROR.ordinal(), "custom style data is null", str3);
                }
            }
        } catch (JSONException unused) {
            if (interfaceC0029c != null) {
                interfaceC0029c.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "parse response result failed", str3);
            }
        }
    }

    private boolean a(int i4, String str) {
        return (103 == i4 && b(str)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + "sc_sty_" + str + ".sty";
    }

    private void a(Context context, String str, String str2, String str3, InterfaceC0029c interfaceC0029c) throws IOException {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        String strA = a(str);
        String strA2 = a(context, str2);
        new com.baidu.mapsdkplatform.comapi.commonutils.b.c().a(strA, context.getFilesDir().getAbsolutePath(), AbstractC0351g.p(str2, ".zip"), 2, new b(context, str2, interfaceC0029c, str3, strA2));
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(android.content.Context r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r4 = 0
            if (r5 != 0) goto L4
            return r4
        L4:
            java.io.File r5 = r5.getFilesDir()
            java.lang.String r5 = r5.getAbsolutePath()
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "ver.cfg"
            r0.<init>(r5, r1)
            boolean r5 = r0.exists()
            java.lang.String r1 = ""
            if (r5 != 0) goto L1c
            return r1
        L1c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b
        L2b:
            java.lang.String r4 = r2.readLine()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
            if (r4 == 0) goto L39
            r5.append(r4)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
            goto L2b
        L35:
            r4 = move-exception
            goto L46
        L37:
            r4 = move-exception
            goto L4e
        L39:
            r2.close()     // Catch: java.io.IOException -> L3d
            goto L41
        L3d:
            r4 = move-exception
            r4.printStackTrace()
        L41:
            java.lang.String r4 = r5.toString()
            return r4
        L46:
            r5 = r4
            r4 = r2
            goto L5c
        L49:
            r5 = move-exception
            goto L5c
        L4b:
            r5 = move-exception
            r2 = r4
            r4 = r5
        L4e:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L35
            if (r2 == 0) goto L5b
            r2.close()     // Catch: java.io.IOException -> L57
            goto L5b
        L57:
            r4 = move-exception
            r4.printStackTrace()
        L5b:
            return r1
        L5c:
            if (r4 == 0) goto L66
            r4.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r4 = move-exception
            r4.printStackTrace()
        L66:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.c.a(android.content.Context):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2) throws Throwable {
        JSONArray jSONArray;
        PrintWriter printWriter;
        if (context == null) {
            return;
        }
        File file = new File(context.getFilesDir().getAbsolutePath(), "ver.cfg");
        String strA = a(context);
        PrintWriter printWriter2 = null;
        try {
            try {
                if (TextUtils.isEmpty(strA)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(strA);
                }
                int length = jSONArray.length();
                if (length == 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, str2);
                    jSONArray.put(jSONObject);
                } else {
                    int i4 = 0;
                    JSONObject jSONObject2 = null;
                    while (true) {
                        if (i4 >= length) {
                            i4 = -1;
                            break;
                        }
                        jSONObject2 = (JSONObject) jSONArray.opt(i4);
                        if (jSONObject2 != null && jSONObject2.has(str)) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i4 != -1 && jSONObject2 != null) {
                        jSONObject2.put(str, str2);
                        jSONArray.put(i4, jSONObject2);
                    } else {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(str, str2);
                        jSONArray.put(jSONObject3);
                    }
                }
                printWriter = new PrintWriter(new FileWriter(file.getAbsoluteFile()));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e4) {
            e = e4;
        }
        try {
            printWriter.write(jSONArray.toString());
            printWriter.close();
        } catch (Exception e5) {
            e = e5;
            printWriter2 = printWriter;
            e.printStackTrace();
            if (printWriter2 != null) {
                printWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, File file, String str) throws Throwable {
        ZipFile zipFile;
        if (file == null || context == null) {
            return false;
        }
        ZipFile zipFile2 = null;
        try {
            try {
                try {
                    zipFile = new ZipFile(file.getAbsoluteFile());
                } catch (IOException e4) {
                    Log.e(f8027a, "Close zipFile failed", e4);
                    return false;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
            } catch (IOException e6) {
                e = e6;
            } catch (IllegalStateException e7) {
                e = e7;
            } catch (NullPointerException e8) {
                e = e8;
            } catch (SecurityException e9) {
                e = e9;
            } catch (ZipException e10) {
                e = e10;
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            ZipEntry entry = zipFile.getEntry(str + ".sty");
            if (entry == null) {
                try {
                    zipFile.close();
                } catch (IOException e11) {
                    Log.e(f8027a, "Close zipFile failed", e11);
                }
                return false;
            }
            boolean zA = a(zipFile.getInputStream(entry), new FileOutputStream(new File(a(context, str))));
            file.delete();
            try {
                zipFile.close();
            } catch (IOException e12) {
                Log.e(f8027a, "Close zipFile failed", e12);
            }
            return zA;
        } catch (FileNotFoundException e13) {
            e = e13;
            zipFile2 = zipFile;
            Log.e(f8027a, "unzip style file FileNotFoundException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (IOException e14) {
            e = e14;
            zipFile2 = zipFile;
            Log.e(f8027a, "unzip style file IOException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (IllegalStateException e15) {
            e = e15;
            zipFile2 = zipFile;
            Log.e(f8027a, "unzip style file IllegalStateException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (NullPointerException e16) {
            e = e16;
            zipFile2 = zipFile;
            Log.e(f8027a, "unzip style file NullPointerException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (SecurityException e17) {
            e = e17;
            zipFile2 = zipFile;
            Log.e(f8027a, "unzip style file SecurityException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (ZipException e18) {
            e = e18;
            zipFile2 = zipFile;
            Log.e(f8027a, "unzip style file ZipException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (Exception unused2) {
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException e19) {
                    Log.e(f8027a, "Close zipFile failed", e19);
                }
            }
            throw th;
        }
    }

    private boolean a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException, NullPointerException {
        if (inputStream == null || fileOutputStream == null) {
            return false;
        }
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i4 = inputStream.read(bArr);
                if (i4 == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i4);
            } finally {
            }
        }
        fileOutputStream.flush();
        try {
            inputStream.close();
        } catch (IOException e4) {
            Log.e(f8027a, "Close InputStream error", e4);
        }
        try {
            fileOutputStream.close();
            return true;
        } catch (IOException e5) {
            Log.e(f8027a, "Close OutputStream error", e5);
            return true;
        }
    }
}
