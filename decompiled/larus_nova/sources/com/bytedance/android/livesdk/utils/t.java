package com.bytedance.android.livesdk.utils;

import android.content.Context;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes11.dex */
public final class t {

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f159162a;
    }

    public class b extends a {

        @SerializedName("landscape")
        public String landscapePath;

        @SerializedName("portrait")
        public String portraitPath;

        public final String a(Context r100) {
            if (r100 != null) goto L5;
            return "";
        L5:
            StringBuilder r101 = new StringBuilder();
            r101.append(this.f159162a);
            if (r100.getResources().getConfiguration().orientation != 1) goto L8;
            String r102 = this.portraitPath;
        L9:
            r101.append(r102);
            return r101.toString();
        L8:
            r102 = this.landscapePath;
            goto L9
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.bytedance.android.livesdk.utils.t$a, com.bytedance.android.livesdk.utils.t$b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.google.gson.Gson] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static b a(String r100) {
        String r101 = File.separator;
        if (r100.endsWith(r101) == true) goto L6;
        r100 = r100 + r101;
    L6:
        ?? r102 = r100 + ComposerHelper.CONFIG_FILE_NAME;
        ?? r103 = new PolarisFileWrapper(r102).exists();
        ?? r104 = 0;
        r104 = 0;
        if (r103 != 0) goto L67;
    L49:
        String r105 = null;
    L61:
        r103 = GsonHelper.get();     // Catch: Exception -> L52
        r102 = (b) r103.fromJson(r105, b.class);     // Catch: Exception -> L52
        r102.f159162a = r100;     // Catch: Exception -> L52
        return r102;
    L52:
        e = move-exception;
        ALogger.e("ttlive_msg", e.getMessage());
        return null;
    L67:
        r103 = new PolarisFileInputStreamWrapper(r102);     // Catch: Throwable -> L23 IOException -> L25
        InputStreamReader r106 = new InputStreamReader(r103, "UTF-8");     // Catch: Throwable -> L19 IOException -> L21
        char[] r107 = new char[r103.available()];     // Catch: IOException -> L17 Throwable -> L38
        r106.read(r107);     // Catch: IOException -> L15 Throwable -> L38
        r106.close();     // Catch: IOException -> L15 Throwable -> L38
        r103.close();     // Catch: IOException -> L15 Throwable -> L38
        r106.close();     // Catch: IOException -> L31
    L13:
        r103.close();     // Catch: IOException -> L31
    L36:
        if (r107 == null) goto L49;
        r105 = new String(r107);
    L15:
        IOException e100 = e;
    L27:
        ALogger.e("ttlive_msg", e100.getMessage());     // Catch: Throwable -> L38
        if (r106 == null) goto L33;
        r106.close();     // Catch: IOException -> L31
    L33:
        if (r103 == 0) goto L36;
    L17:
        e = move-exception;
        e100 = e;
        r107 = null;
        goto L27
    L21:
        e = move-exception;
        e100 = e;
        r106 = null;
        r107 = null;
    L19:
        th = th;
    L40:
        if (r104 != 0) goto L59;
    L44:
        if (r103 == 0) goto L48;
        r103.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        ALogger.e("ttlive_msg", e.getMessage());
    L48:
        throw th;
    L59:
        r104.close();     // Catch: IOException -> L42
        goto L44
    L25:
        e = move-exception;
        e100 = e;
        r106 = null;
        r103 = 0;
        r107 = null;
    L23:
        th = th;
        r103 = 0;
    L38:
        th = th;
        r104 = r102;
    L31:
        e = move-exception;
        ALogger.e("ttlive_msg", e.getMessage());
        goto L36
    }
}
