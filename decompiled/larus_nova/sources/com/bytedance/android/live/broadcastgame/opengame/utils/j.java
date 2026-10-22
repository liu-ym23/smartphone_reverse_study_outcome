package com.bytedance.android.live.broadcastgame.opengame.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f61161a = 0;

    static {
    }

    public static String a(File r100) {
        Intrinsics.checkNotNullParameter(r100, "res");
        Intrinsics.checkNotNullParameter("introduce", "pageAlias");
        com.bytedance.android.live.broadcastgame.opengame.lynx.b r101 = c(FilesKt.resolve(r100, ComposerHelper.CONFIG_FILE_NAME));
        if (r101 == null) goto L24;
        List<com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0988b> r102 = r101.f60147a;
        if (r102 == null) goto L31;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L17;
        Object r104 = r103.next();
        com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0988b r105 = (com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0988b) r104;
        if (Intrinsics.areEqual(r105.getType(), "panel") == true) goto L12;
    L14:
        boolean r106 = false;
    L15:
        if (r106 == false) goto L8;
    L18:
        com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0988b r107 = (com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0988b) r104;
        if (r107 == null) goto L32;
        String r108 = r107.f60152c;
        if (r108 == null) goto L33;
        return r108;
    L33:
        return "";
    L32:
        return "";
    L12:
        if (Intrinsics.areEqual(r105.f60151b, "introduce") == false) goto L14;
        r106 = true;
        goto L15
    L17:
        r104 = null;
        goto L18
    L31:
        return "";
    L24:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static byte[] b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "src");
        byte[] r101 = new byte[20480];
        PolarisFileInputStreamWrapper r102 = null;
        String r103 = null;
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L30 Exception -> L32
    L102:
        ByteArrayOutputStream r105 = new ByteArrayOutputStream(r104.available());     // Catch: Throwable -> L26 Exception -> L28
    L99:
        int r106 = r104.read(r101);     // Catch: Exception -> L24 Throwable -> L54
        if (r106 == (-1)) goto L8;
        r105.write(r101, 0, r106);     // Catch: Exception -> L24 Throwable -> L54
        goto L99
    L8:
        r105.flush();     // Catch: Exception -> L24 Throwable -> L54
        byte[] r107 = r105.toByteArray();     // Catch: Exception -> L24 Throwable -> L54
        r104.close();     // Catch: Throwable -> L11 IOException -> L13
    L89:
        r105.close();     // Catch: Throwable -> L17 IOException -> L19
    L21:
        return r107;
    L17:
        th = move-exception;
        throw th;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L24:
        Exception e100 = e;
    L34:
        e100.printStackTrace();     // Catch: Throwable -> L54
        if (r104 != null) goto L96;
    L78:
        if (r105 != null) goto L85;
    L53:
        return null;
    L85:
        r105.close();     // Catch: Throwable -> L47 IOException -> L49
    L77:
        goto L53
    L49:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    L96:
        r104.close();     // Catch: Throwable -> L38 IOException -> L40
    L40:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    L28:
        e = move-exception;
        e100 = e;
        r105 = null;
    L26:
        th = th;
    L27:
        ?? r108 = r103;
        r102 = r104;
    L56:
        if (r102 != null) goto L91;
    L81:
        if (r108 == 0) goto L105;
        r108.close();     // Catch: Throwable -> L68 IOException -> L70
    L80:
        throw th;
    L70:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L68
        goto L80
    L105:
        throw th;
    L68:
        th = move-exception;
        throw th;
    L91:
        r102.close();     // Catch: Throwable -> L59 IOException -> L61
    L61:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    L54:
        th = move-exception;
        r103 = r100;
        th = th;
    L32:
        e = move-exception;
        e100 = e;
        r105 = null;
        r104 = null;
    L30:
        th = th;
        r108 = 0;
        goto L56
    }

    public static com.bytedance.android.live.broadcastgame.opengame.lynx.b c(File r100) {
        if (r100.exists() == true) goto L5;
    L13:
        PolarisFileInputStreamWrapper r101 = null;
    L14:
        if (r101 != null) goto L34;
        return null;
    L34:
        BufferedReader r102 = new BufferedReader(new InputStreamReader(r101));     // Catch: Throwable -> L26
        String r103 = TextStreamsKt.readText(r102);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r102, null);     // Catch: Throwable -> L26
        JSONObject r104 = new JSONObject(r103);     // Catch: Throwable -> L26
    L27:
        if (r104 != null) goto L39;
        return null;
    L39:
        int r105 = com.bytedance.android.live.broadcastgame.opengame.lynx.b.f60146d;     // Catch: JSONException -> L31
        return com.bytedance.android.live.broadcastgame.opengame.lynx.b.a.a(r104);
    L31:
        return null;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        r104 = null;
        goto L27
    L5:
        if (r100.isFile() == true) goto L41;
        FilesKt.deleteRecursively(r100);     // Catch: IOException -> L11
    L11:
        e = move-exception;
        ALogger.e("GameFileUtils", String.valueOf(e.getMessage()));
        goto L13
    L41:
        r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: IOException -> L8
        goto L14
    }

    public static String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (Intrinsics.areEqual(r100, "") == false) goto L13;
        return "";
    L13:
        BufferedReader r101 = new BufferedReader(new InputStreamReader(new URL(r100).openStream()));     // Catch: Throwable -> L10
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L10
        String r103 = r101.readLine();     // Catch: Throwable -> L10
    L6:
        if (r103 == null) goto L8;
        r102.append(r103);     // Catch: Throwable -> L10
        r103 = r101.readLine();     // Catch: Throwable -> L10
        goto L6
    L8:
        r101.close();     // Catch: Throwable -> L10
        return r102.toString();
    L10:
        th = move-exception;
        ALogger.e("OpenPlatform", "OpenPlatformFileUtil : " + th);
        return "";
    }
}
