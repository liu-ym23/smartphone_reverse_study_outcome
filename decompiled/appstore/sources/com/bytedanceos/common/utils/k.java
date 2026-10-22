package com.bytedanceos.common.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.android.volley.NetworkError;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.network.error.ClientVersionLowError;
import com.bytedanceos.common.network.error.HttpServerError;
import com.bytedanceos.common.network.error.SSLNetworkError;
import com.bytedanceos.common.network.error.ServerSafeguardError;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlinx.coroutines.TimeoutCancellationException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {
    public static boolean a(int r10) {
        if (com.bytedanceos.common.toolbox.l.f10067a.indexOfKey(r10) >= 0) goto L5;
        return false;
    L5:
        return true;
    }

    public static int b(Throwable r10) {
        if ((r10 instanceof HttpServerError) == false) goto L7;
        return 500;
    L7:
        if ((r10 instanceof ClientVersionLowError) == false) goto L11;
        return 800;
    L11:
        if ((r10 instanceof ServerSafeguardError) == false) goto L15;
        return 900;
    L15:
        if ((r10 instanceof NetworkError) == false) goto L17;
    L18:
        r10 = r10.getCause();
    L20:
        if ((r10 instanceof SocketTimeoutException) == false) goto L24;
        q.b();
        return -2;
    L24:
        if ((r10 instanceof ConnectTimeoutException) == false) goto L28;
        q.b();
        return -3;
    L28:
        if ((r10 instanceof ConnectException) == false) goto L30;
    L48:
        q.b();
        return -1;
    L30:
        if ((r10 instanceof UnknownHostException) == true) goto L48;
        if ((r10 instanceof SSLHandshakeException) == false) goto L37;
        return -6;
    L37:
        if ((r10 instanceof SSLPeerUnverifiedException) == false) goto L40;
        return -4;
    L40:
        if ((r10 instanceof SSLException) == false) goto L43;
        return -4;
    L43:
        if ((r10 instanceof TimeoutCancellationException) == false) goto L46;
        return -7;
    L46:
        return 0;
    L17:
        if ((r10 instanceof SSLNetworkError) == false) goto L20;
        goto L18
    }

    public static String c(Context r10, int r11) {
        SparseIntArray r12 = com.bytedanceos.common.toolbox.l.f10067a;
        String r13 = r10.getString(r12.get(r11));
        if (TextUtils.isEmpty(r13) == true) goto L5;
        return r13;
    L5:
        return r10.getString(r12.get(0));
    }

    public static String d(Context r10, Throwable r11) {
        if ((r11 instanceof HttpServerError) == false) goto L7;
        return r10.getString(com.bytedanceos.common.toolbox.l.f10067a.get(500));
    L7:
        if ((r11 instanceof ClientVersionLowError) == false) goto L11;
        return r10.getString(com.bytedanceos.common.toolbox.l.f10067a.get(800));
    L11:
        if ((r11 instanceof ServerSafeguardError) == false) goto L15;
        return r10.getString(com.bytedanceos.common.toolbox.l.f10067a.get(900));
    L15:
        if ((r11 instanceof NetworkError) == false) goto L17;
    L18:
        r11 = r11.getCause();
    L20:
        if ((r11 instanceof SocketTimeoutException) == false) goto L24;
        q.b();
        return r10.getString(com.bytedanceos.common.toolbox.l.f10067a.get(-2));
    L24:
        if ((r11 instanceof ConnectTimeoutException) == false) goto L28;
        q.b();
        return r10.getString(com.bytedanceos.common.toolbox.l.f10067a.get(-3));
    L28:
        if ((r11 instanceof ConnectException) == false) goto L30;
    L58:
        q.b();
        if (PermissionUtil.checkNetWork() == false) goto L63;
        return r10.getString(com.bytedanceos.common.toolbox.l.f10067a.get(-1));
    L63:
        return r10.getString(R$string.permission_internet, new Object[]{BaseApplication.c().getAppName()});
    L30:
        if ((r11 instanceof UnknownHostException) == true) goto L58;
        if ((r11 instanceof SSLHandshakeException) == false) goto L37;
        return r10.getString(com.bytedanceos.common.toolbox.l.f10067a.get(-4));
    L37:
        if ((r11 instanceof SSLPeerUnverifiedException) == false) goto L41;
        return r10.getString(com.bytedanceos.common.toolbox.l.f10067a.get(-4));
    L41:
        if ((r11 instanceof SSLException) == false) goto L49;
        if (com.bytedanceos.common.toolbox.e.A0(r10) == false) goto L47;
        return r10.getString(com.bytedanceos.common.toolbox.l.f10067a.get(-2));
    L47:
        return r10.getString(com.bytedanceos.common.toolbox.l.f10067a.get(-1));
    L49:
        if ((r11 instanceof IOException) == false) goto L57;
        if (PermissionUtil.checkNetWork() == false) goto L55;
        return r10.getString(com.bytedanceos.common.toolbox.l.f10067a.get(0));
    L55:
        return r10.getString(R$string.permission_internet, new Object[]{BaseApplication.c().getAppName()});
    L57:
        return r10.getString(com.bytedanceos.common.toolbox.l.f10067a.get(0));
    L17:
        if ((r11 instanceof SSLNetworkError) == false) goto L20;
        goto L18
    }

    public static String e(int r10) {
        if (r10 == 1) goto L51;
        switch(r10) {
            case -121: goto L48;
            case -120: goto L47;
            case -119: goto L46;
            case -118: goto L45;
            case -117: goto L44;
            case -116: goto L43;
            case -115: goto L42;
            case -114: goto L41;
            case -113: goto L40;
            case -112: goto L39;
            case -111: goto L38;
            case -110: goto L37;
            case -109: goto L36;
            case -108: goto L35;
            case -107: goto L34;
            case -106: goto L33;
            case -105: goto L32;
            case -104: goto L31;
            case -103: goto L30;
            case -102: goto L29;
            case -101: goto L28;
            case -100: goto L27;
            default: goto L5;
        };
    L5:
        switch(r10) {
            case -20: goto L26;
            case -19: goto L25;
            case -18: goto L24;
            case -17: goto L23;
            case -16: goto L22;
            case -15: goto L21;
            case -14: goto L20;
            case -13: goto L19;
            case -12: goto L18;
            case -11: goto L17;
            case -10: goto L16;
            case -9: goto L15;
            case -8: goto L14;
            case -7: goto L13;
            case -6: goto L12;
            case -5: goto L11;
            case -4: goto L10;
            case -3: goto L9;
            case -2: goto L8;
            case -1: goto L7;
            default: goto L6;
        };
    L6:
        String r11 = "install failed: unknow reason ";
    L49:
        com.bytedanceos.common.toolbox.j.a(r11);
        return r11;
    L7:
        r11 = "install failed: package already exists";
        goto L49
    L8:
        r11 = "install failed: invalid apk file";
        goto L49
    L9:
        r11 = "install failed: passed invalid uri ";
        goto L49
    L10:
        r11 = "install failed: didn't have enough space";
        goto L49
    L11:
        r11 = "install failed: already installed with the same name";
        goto L49
    L12:
        r11 = "install failed: requested shared user does not exist ";
        goto L49
    L13:
        r11 = "install failed: previously installed package of the same name has a different signature ";
        goto L49
    L14:
        r11 = "install failed: requested a shared user which is already installed on the device and does not have matching signature ";
        goto L49
    L15:
        r11 = "install failed: package uses a shared library that is not available ";
        goto L49
    L16:
        r11 = "install failed: replace couldn't delete ";
        goto L49
    L17:
        r11 = "install failed: optimizing and validating its dex files failed ";
        goto L49
    L18:
        r11 = "install failed: current SDK version is older than that required by the package ";
        goto L49
    L19:
        r11 = "install failed: a provider already installed ";
        goto L49
    L20:
        r11 = "install failed: current SDK version is newer than that required by the package ";
        goto L49
    L21:
        r11 = "install failed: it is a test-only package";
        goto L49
    L22:
        r11 = "install failed: contains native code, but none that is compatible with the the device's CPU_ABI ";
        goto L49
    L23:
        r11 = "install failed: package uses a feature that is not available ";
        goto L49
    L24:
        r11 = "install failed: a secure container mount point couldn't be accessed on external media ";
        goto L49
    L25:
        r11 = "install failed: the new package couldn't be installed in the specified install location ";
        goto L49
    L26:
        r11 = "install failed: the media is not available ";
        goto L49
    L27:
        r11 = "install failed: a path that is not a file, or does not end with the expected '.apk' extension";
        goto L49
    L28:
        r11 = "install failed: the parser was unable to retrieve the AndroidManifest.xml file";
        goto L49
    L29:
        r11 = "install failed: the parser encountered an unexpected exception";
        goto L49
    L30:
        r11 = "install failed: parser did not find any certificates in the .apk ";
        goto L49
    L31:
        r11 = "install failed: parser found inconsistent certificates on the files in the .apk";
        goto L49
    L32:
        r11 = "install failed: parser encountered a CertificateEncodingException";
        goto L49
    L33:
        r11 = "install failed: parser encountered a bad or missing package name in the manifest ";
        goto L49
    L34:
        r11 = "install failed: parser encountered a bad shared user id name in the manifest ";
        goto L49
    L35:
        r11 = "install failed: parser encountered some structural problem in the manifest ";
        goto L49
    L36:
        r11 = "install failed: parser did not find any actionable tags (instrumentation or application) in the manifest";
        goto L49
    L37:
        r11 = "install failed: the system failed to install the package because of system issues ";
        goto L49
    L38:
        r11 = "install failed: user restricted ";
        goto L49
    L39:
        r11 = "install failed: duplicate permission ";
        goto L49
    L40:
        r11 = "install failed: no matching abis ";
        goto L49
    L41:
        r11 = "install failed: no native libraries ";
        goto L49
    L42:
        r11 = "install failed: aborted ";
        goto L49
    L43:
        r11 = "install failed: instant app invalid ";
        goto L49
    L44:
        r11 = "install failed: bad dex metadata ";
        goto L49
    L45:
        r11 = "install failed: bad signature ";
        goto L49
    L46:
        r11 = "install failed: staged session in progress ";
        goto L49
    L47:
        r11 = "install failed: multipackage inconsistency ";
        goto L49
    L48:
        r11 = "install failed: wrong installed version ";
        goto L49
    L51:
        return null;
    }
}
