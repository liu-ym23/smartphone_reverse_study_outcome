package com.smt.obric.appstore.domain.sysapp;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ApplicationInfoEx;
import android.content.pm.PackageInfo;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.j;
import java.io.File;
import java.nio.file.Paths;
import java.util.Set;
import kotlin.collections.r0;
import kotlin.coroutines.Continuation;
import kotlin.io.g;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SysAppUtilKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f18102a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f18103b = null;

    static {
        f18102a = r0.i(new String[]{"com.obric.appstore", "com.android.launcher3", "com.larus.mcp", "com.modemdebug.sconf", "com.obric.matrix", "com.qualcomm.qti.dcf.nearbyclient", "com.android.documentsui", "com.obric.memorydata"});
        f18103b = r0.i(new String[]{"com.obric.music", "com.obric.notes", "com.obric.securitymanager", "com.obric.recorder", "com.obric.weather", "com.obric.calendar", "com.obric.compass", "com.obric.clock", "com.obric.calculator", "com.obric.filemanager"});
    }

    public static final String a(File r10, File r11) {
    L19:
        return null;
    L4:
        if (r10.exists() == true) goto L8;
        j.n("source file not exists");     // Catch: Exception -> L19
        return null;
    L8:
        if (r10.isFile() == true) goto L12;
        j.n("source file not a file");     // Catch: Exception -> L19
        return null;
    L12:
        if (r11.exists() == false) goto L18;
        if (r11.isDirectory() == false) goto L18;
        j.n("target file is a directory");     // Catch: Exception -> L19
        return null;
    L18:
        return g.b(r10, r11, true, 0, 4, null).toString();
    }

    public static final String b(Context r10, AppInfo r11) {
        q.g(r10, "context");
        q.g(r11, ServerElements.INFO);
        String r12 = r11.appPackageName;
        if (r12 != null) goto L5;
    L30:
        j.n("[AppStatus][SysApp] copyObricSysApkFile err: pkg is null");
        return null;
    L5:
        if (r12.length() == 0) goto L30;
        String r13 = r11.obricPreloadApkFilePath;
        if (r13 != null) goto L10;
    L28:
        j.n("[AppStatus][SysApp] copyObricSysApkFile err: preloadApkPath is null");
        return null;
    L10:
        if (r13.length() == 0) goto L28;
        String r14 = Paths.get(d(r10), new String[]{r12 + '_' + r11.appVersionCode + "_bak.apk"}).toString();     // Catch: Exception -> L26
        File r15 = new File(r13);
        File r16 = new File(r14);
        if (r15.exists() == true) goto L18;
        j.n("[AppStatus][SysApp] copyObricSysApkFile err: preloadApkFile is not exists /pkg=" + r12 + " /path=" + r13);
        return null;
    L18:
        int r17 = 3;
    L19:
        if (r17 <= 0) goto L25;
        String r18 = a(r15, r16);
        if (r18 != null) goto L22;
        r17 = r17 - 1;
        goto L19
    L22:
        j.o("[AppStatus][SysApp] apk file copied to " + r18);
        return r13;
    L25:
        return null;
    L26:
        j.n("[AppStatus][SysApp] copyObricSysApkFile err: get tempApkTarget err");
        return null;
    }

    public static final Set c() {
        return f18103b;
    }

    public static final String d(Context r10) {
        q.g(r10, "context");
        return r10.getFilesDir().getAbsolutePath() + "/sysapp/apk";
    }

    public static final boolean e(PackageInfo r10) {
        q.g(r10, ServerElements.INFO);
        ApplicationInfo r11 = r10.applicationInfo;
        if (r11 != null) goto L6;
        j.n("[AppStatus][SysApp] isSysApp err: applicationInfo is null");
        return false;
    L6:
        int r12 = r11.flags;
        if ((r12 & 128) == 0) goto L10;
        return true;
    L10:
        if ((r12 & 1) == 0) goto L13;
        return true;
    L13:
        if (ApplicationInfoEx.isObricApp(r11) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static final boolean f(PackageInfo r10) {
        q.g(r10, ServerElements.INFO);
        String r11 = r10.packageName;
        if (r11 != null) goto L6;
        return false;
    L6:
        if (f18102a.contains(r11) == false) goto L9;
        return false;
    L9:
        return e(r10);
    }

    public static final Object g(Context r10, Continuation r11) {
        return h.g(l0.b(), new SysAppUtilKt$isSysImeDisplaying$2(r10, null), r11);
    }
}
