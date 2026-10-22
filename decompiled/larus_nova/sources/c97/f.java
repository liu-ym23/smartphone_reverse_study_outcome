package c97;

import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.reparo.core.i f22873a;

    public static class a {
        public static e a(String r100) throws JSONException {
            e r101 = new e();
            if (TextUtils.isEmpty(r100) == false) goto L5;
        L15:
            return r101;
        L5:
            if (TextUtils.equals(SliceInitService.DEFAULT_SWITCH, r100) == true) goto L15;
            JSONObject r102 = new JSONObject(r100);
            r101.f22871a = r102.optString("hostAppVersion");
            HashSet r103 = new HashSet();
            JSONArray r104 = r102.optJSONArray("patchRecordInfoSet");
            if (r104 != null) goto L10;
            return r101;
        L10:
            int r105 = 0;
        L12:
            if (r105 >= r104.length()) goto L14;
            JSONObject r106 = JSONArrayProtectorUtils.getJSONObject(r104, r105);
            h r107 = new h();
            r107.f22882b = r106.optBoolean("hasJavaPatch");
            r107.f22884d = r106.optBoolean("hasSoLibraries");
            r107.f22891k = r106.optString("hostAppVersion");
            r107.f22881a = new PolarisFileWrapper(r106.optString("installDirPath"));
            r107.f22892l = r106.optBoolean("isAsyncLoad", true);
            r107.f22893m = r106.optBoolean("isSupportSubProcess", false);
            r107.f22883c = new PolarisFileWrapper(r106.optString("javaPatchRootDirPath"));
            r107.f22890j = r106.optString("patchId");
            r107.f22888h = r106.optString("issueId");
            r107.f22887g = r106.optString("patchMd5");
            r107.f22889i = r106.optString("patchVersion");
            r107.f22886f = new PolarisFileWrapper(r106.optString("soInfoFilePath"));
            r103.add(r107);
            r105 = r105 + 1;
            goto L12
        L14:
            r101.f22872b = r103;
            goto L15
        }

        public static String b(e r100) throws JSONException {
            JSONObject r101 = new JSONObject();
            if (TextUtils.isEmpty(r100.a()) == true) goto L5;
            r101.putOpt("hostAppVersion", r100.a());
        L5:
            Set<h> r102 = r100.b();
            if (r102.size() <= 0) goto L25;
            JSONArray r103 = new JSONArray();
            Iterator<h> r104 = r102.iterator();
        L9:
            if (r104.hasNext() == false) goto L23;
            h r105 = r104.next();
            JSONObject r106 = new JSONObject();
            r106.putOpt("hostAppVersion", r105.f22891k);
            r106.putOpt("hasJavaPatch", Boolean.valueOf(r105.f22882b));
            r106.putOpt("hasSoLibraries", Boolean.valueOf(r105.f22884d));
            File r107 = r105.f22881a;
            String r108 = "";
            if (r107 != null) goto L13;
            String r109 = "";
        L14:
            r106.putOpt("installDirPath", r109);
            r106.putOpt("isAsyncLoad", Boolean.valueOf(r105.f22892l));
            r106.putOpt("isSupportSubProcess", Boolean.valueOf(r105.f22893m));
            File r110 = r105.f22883c;
            if (r110 != null) goto L17;
            String r111 = "";
        L18:
            r106.putOpt("javaPatchRootDirPath", r111);
            r106.putOpt("patchId", r105.f22890j);
            r106.putOpt("issueId", r105.f22888h);
            r106.putOpt("patchMd5", r105.f22887g);
            r106.putOpt("patchVersion", r105.f22889i);
            File r112 = r105.f22886f;
            if (r112 == null) goto L22;
            r108 = r112.getAbsolutePath();
        L22:
            r106.putOpt("soInfoFilePath", r108);
            r103.put(r106);
            goto L9
        L17:
            r111 = r110.getAbsolutePath();
            goto L18
        L13:
            r109 = r107.getAbsolutePath();
            goto L14
        L23:
            r101.put("patchRecordInfoSet", r103);
        L25:
            return r101.toString();
        }
    }

    public final e a() {
        File r100 = this.f22873a.a();
        com.bytedance.reparo.core.i r101 = this.f22873a;
        if (r101.f267374d != null) goto L5;
        r101.f267374d = new PolarisFileWrapper(r101.b(), "public.lock");
    L5:
        PolarisFileWrapper r102 = r101.f267374d;
        StringBuilder r103 = new StringBuilder();
        c r104 = null;
        e r105 = null;
        InputStreamReader r106 = null;
        r104 = null;
        w87.b.c(r100);     // Catch: Throwable -> L25 IOException -> L27
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L25 IOException -> L27
        c r108 = new c(r102);     // Catch: Throwable -> L21 IOException -> L23
    L63:
        InputStreamReader r109 = new InputStreamReader(r107);     // Catch: Throwable -> L17 IOException -> L19
    L52:
        char[] r110 = new char[1024];     // Catch: IOException -> L15 Throwable -> L42
    L11:
        int r111 = r109.read(r110);     // Catch: IOException -> L15 Throwable -> L42
        if (r111 == (-1)) goto L57;
        r103.append(r110, 0, r111);     // Catch: IOException -> L15 Throwable -> L42
    L57:
        r108.close();     // Catch: IOException -> L33
    L35:
        w87.c.a(r107);
        w87.c.a(r109);
        String r112 = r103.toString();
        r105 = a.a(r112);     // Catch: Exception -> L38
    L39:
        if (r105 == null) goto L41;
        return r105;
    L41:
        return new e();
    L38:
        w87.b.delete(this.f22873a.a());
        com.bytedance.reparo.core.k.a("LocalRecordParser", "parse local-record.info failed. " + r112);
    L33:
        e = move-exception;
        com.bytedance.reparo.core.k.b("LocalRecordParser", "close lock helper failed.(read)", e);
    L15:
        IOException e100 = e;
    L29:
        com.bytedance.reparo.core.k.b("LocalRecordParser", "read local record failed.", e100);     // Catch: Throwable -> L42
        if (r108 == null) goto L35;
    L42:
        th = move-exception;
        r106 = r109;
        Throwable th10 = th;
    L44:
        InputStreamReader r113 = r106;
        r104 = r108;
        th = th10;
        InputStreamReader r114 = r113;
    L45:
        if (r104 != null) goto L55;
    L50:
        w87.c.a(r107);
        w87.c.a(r114);
        throw th;
    L55:
        r104.close();     // Catch: IOException -> L48
    L48:
        e = move-exception;
        com.bytedance.reparo.core.k.b("LocalRecordParser", "close lock helper failed.(read)", e);
    L19:
        e = move-exception;
        e100 = e;
        r109 = null;
    L17:
        th10 = th;
    L23:
        e = move-exception;
        e100 = e;
        r108 = null;
        r109 = null;
    L21:
        th = th;
        r114 = null;
        goto L45
    L27:
        e = move-exception;
        e100 = e;
        r108 = null;
        r109 = null;
        r107 = null;
    L25:
        th = th;
        r114 = null;
        r107 = null;
        goto L45
    }

    public f(com.bytedance.reparo.core.i r100) {
        this.f22873a = r100;
    }
}
