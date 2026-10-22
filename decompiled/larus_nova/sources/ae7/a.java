package ae7;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3109a = null;

    static {
        f3109a = new a();
    }

    public a() {
    }

    public static String a(Context r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "filePath");
        Uri r112 = UriProtector.parse(r111);
        String r100 = r112.getScheme();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L96;
        if (Intrinsics.areEqual(r100, "file") == true) goto L96;
        FileInputStream r103 = null;
        FileChannel r104 = null;
        FileChannel r105 = null;
        if (Intrinsics.areEqual(r100, "content") == false) goto L115;
        String r106 = r110.getCacheDir().getAbsolutePath() + "/tools/temMedia/" + System.currentTimeMillis();
        if (r106.length() != 0) goto L18;
        boolean r107 = true;
    L19:
        if (r107 == false) goto L21;
        boolean r108 = false;
    L22:
        if (r108 == false) goto L24;
    L103:
        AssetFileDescriptor r113 = ContentResolverWrapper.openAssetFileDescriptor(r110.getContentResolver(), r112, "r", null);     // Catch: Throwable -> L72 Exception -> L83
        if (r113 == null) goto L116;
        FileInputStream r114 = r113.createInputStream();     // Catch: Throwable -> L72 Exception -> L83
        PolarisFileOutputStreamWrapper r115 = new PolarisFileOutputStreamWrapper(r106);     // Catch: Throwable -> L67 Exception -> L71
        if (r114 != null) goto L106;
        FileChannel r109 = null;
    L111:
        FileChannel r116 = r115.getChannel();     // Catch: Throwable -> L64 Exception -> L66
        if (r109 != null) goto L109;
    L56:
        if (r114 == null) goto L58;
        r114.close();     // Catch: IOException -> L98
    L58:
        r115.close();     // Catch: IOException -> L98
        if (r109 == null) goto L61;
        r109.close();     // Catch: IOException -> L98
    L61:
        if (r116 == null) goto L117;
        r116.close();     // Catch: IOException -> L98
    L117:
        return r106;
    L109:
        r109.transferTo(0, r109.size(), r116);     // Catch: Throwable -> L53 Exception -> L55
    L53:
        Throwable th10 = th;
        r104 = r116;
    L65:
        FileChannel r117 = r109;
        PolarisFileOutputStreamWrapper r118 = r115;
        FileChannel r119 = r104;
        r105 = r117;
    L70:
        FileChannel r120 = r105;
        r103 = r114;
        FileChannel r121 = r120;
    L74:
        if (r103 != null) goto L99;
    L76:
        if (r118 == null) goto L78;
        r118.close();     // Catch: IOException -> L97
    L78:
        if (r121 == null) goto L80;
        r121.close();     // Catch: IOException -> L97
    L80:
        if (r119 == null) goto L113;
        r119.close();     // Catch: IOException -> L97
        throw th10;
    L114:
        throw th10;
    L113:
        throw th10;
    L99:
        r103.close();     // Catch: IOException -> L97
    L86:
        if (r114 == null) goto L88;
        r114.close();     // Catch: IOException -> L98
    L88:
        if (r115 == null) goto L90;
        r115.close();     // Catch: IOException -> L98
    L90:
        if (r109 == null) goto L92;
        r109.close();     // Catch: IOException -> L98
    L92:
        if (r116 == null) goto L118;
        r116.close();     // Catch: IOException -> L98
        return null;
    L118:
        return null;
    L66:
        r116 = null;
    L64:
        th10 = th;
        goto L65
    L106:
        r109 = r114.getChannel();     // Catch: Throwable -> L44 Exception -> L46
    L44:
        th10 = th;
    L69:
        r118 = r115;
        r119 = null;
    L85:
        r109 = null;
        r116 = null;
        goto L86
    L67:
        th = move-exception;
        th10 = th;
        r115 = null;
    L84:
        r115 = null;
        goto L85
    L116:
        return null;
    L83:
        r114 = null;
    L72:
        th = move-exception;
        th10 = th;
        r121 = null;
        r119 = null;
        r118 = null;
        goto L74
    L119:
        return null;
    L24:
        if (r106.length() <= 0) goto L26;
        r101 = true;
    L26:
        if (r101 == false) goto L103;
        PolarisFileWrapper r122 = new PolarisFileWrapper(r106);
        if (r122.exists() == true) goto L103;
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L34
        File r124 = r122.getParentFile();     // Catch: Throwable -> L34
        if (r124.exists() == true) goto L32;
        r124.mkdirs();     // Catch: Throwable -> L34
    L32:
        Result.m9449constructorimpl(Boolean.valueOf(r122.createNewFile()));     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L103
    L21:
        r108 = new PolarisFileWrapper(r106).exists();
        goto L22
    L18:
        r107 = false;
        goto L19
    L115:
        return null;
    L96:
        return r112.getPath();
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static ArrayList b(Context r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "filePaths");
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        String r104 = (String) r103.next();
        f3109a.getClass();
        String r105 = a(r100, r104);
        if (r105 == null) goto L4;
        r102.add(r105);
        goto L4
    L8:
        return r102;
    }

    public static boolean c(Context r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "filePaths");
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        String r103 = (String) r102.next();
        f3109a.getClass();
        if (d(r100, r103) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static boolean d(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "filePath");
        Uri r102 = UriProtector.parse(r101);
        String r103 = r102.getScheme();
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
    L23:
        String r106 = r102.getPath();
        if (r106 != null) goto L26;
    L29:
        boolean r107 = true;
    L30:
        if (r107 == true) goto L44;
        PolarisFileWrapper r108 = new PolarisFileWrapper(r106);
        if (r108.exists() == true) goto L35;
    L37:
        r104 = false;
    L39:
        return r104;
    L35:
        if (r108.canRead() == false) goto L37;
    L44:
        return false;
    L26:
        if (r106.length() == 0) goto L29;
        r107 = false;
        goto L30
    L11:
        if (Intrinsics.areEqual(r103, "file") == true) goto L23;
        if (Intrinsics.areEqual(r103, "content") == true) goto L41;
        return false;
    L41:
        InputStream r109 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r102);     // Catch: Exception -> L40
        if (r109 == null) goto L20;
        r109.close();     // Catch: Exception -> L40
        return true;
    L20:
        return false;
    L5:
        if (r103.length() == 0) goto L8;
        r105 = false;
        goto L9
    }

    public static boolean e(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "filePath");
        Uri r102 = UriProtector.parse(r101);
        String r103 = r102.getScheme();
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
    L23:
        String r106 = r102.getPath();
        if (r106 != null) goto L26;
    L29:
        if (r104 == false) goto L32;
        return false;
    L32:
        return new PolarisFileWrapper(r106).exists();
    L26:
        if (r106.length() == 0) goto L29;
        r104 = false;
        goto L29
    L11:
        if (Intrinsics.areEqual(r103, "file") == true) goto L23;
        if (Intrinsics.areEqual(r103, "content") == true) goto L34;
        return false;
    L34:
        InputStream r107 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r102);     // Catch: Exception -> L33
        if (r107 == null) goto L20;
        r107.close();     // Catch: Exception -> L33
        return true;
    L20:
        return false;
    L5:
        if (r103.length() == 0) goto L8;
        r105 = false;
        goto L9
    }
}
