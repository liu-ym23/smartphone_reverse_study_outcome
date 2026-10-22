package axb;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.officesdk.di.core.deps.StorageVolume;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.r;
import com.ss.android.lark.officewebview.util.k;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final String b(Context r100) {
        if (r100 != null) goto L6;
        j.b("WebErrorPageUIOptimize", "getErrorPageFilePath,context null");
        return "";
    L6:
        String r101 = a(r100, "lk_error_page");
        if (TextUtils.isEmpty(r101) == false) goto L10;
        j.b("WebErrorPageUIOptimize", "getErrorPageFilePath,errorPageDir null");
        return "";
    L10:
        int r102 = r.f437233a;
        File r103 = r.a.b(r101 + File.separator + "index.html");
        if (r103.exists() == true) goto L13;
        j.b("WebErrorPageUIOptimize", "getErrorPageFilePath,errorPageFile not exists " + r103.getAbsolutePath());
        return "";
    L13:
        return r103.getAbsolutePath();
    }

    @JvmStatic
    public static final boolean c(String r100) {
        if (r100 != null) goto L10;
        return false;
    L10:
        return TextUtils.equals(UriProtector.parse(r100).buildUpon().clearQuery().toString(), "lkweb://local/netdetect");
    L7:
        th = move-exception;
        j.d("WebErrorPageUIOptimize", th);
        return false;
    }

    @JvmStatic
    public static final byte[] d(String r100) {
        if (r100 != null) goto L18;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L14;
        j.b("WebErrorPageUIOptimize", "readBytes file is empty");     // Catch: Throwable -> L8
        return null;
    L14:
        int r102 = r.f437233a;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r100, "file");     // Catch: Throwable -> L8
        InputStream r103 = r.a.a().k(r100);     // Catch: Throwable -> L8
        byte[] r104 = new byte[r103.available()];     // Catch: Throwable -> L8
        r103.read(r104);     // Catch: Throwable -> L8
        r103.close();     // Catch: Throwable -> L8
        return r104;
    L18:
    L8:
        th = move-exception;
        j.d("WebErrorPageUIOptimize", th);
        return null;
    L5:
        if (r100.length() == 0) goto L10;
        r101 = false;
        goto L11
    }

    @JvmStatic
    public static final String a(Context r100, String r101) {
        if (r100 != null) goto L19;
        return "";
    L19:
        int r102 = r.f437233a;     // Catch: Throwable -> L7
        StorageVolume r103 = StorageVolume.INTERNAL_FILES;     // Catch: Throwable -> L7
        int r104 = k.f437551a;     // Catch: Throwable -> L7
        String[] r105 = {r101};     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r103, ITTVideoEngineEventSource.KEY_VOLUME);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter("open_platform", "domain");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r105, "path");     // Catch: Throwable -> L7
        File r106 = r.a.a().l0(r103, (String[]) Arrays.copyOf(r105, 1));     // Catch: Throwable -> L7
    L9:
        if (r106 != null) goto L13;
        j.e("WebErrorPageUIOptimize", "mkdirs errorPageDir == null");
        return "";
    L13:
        if (r106.isDirectory() == true) goto L18;
        j.e("WebErrorPageUIOptimize", "mkdirs errorPageDir");
        int r107 = r.f437233a;
        String r108 = r106.getAbsolutePath();
        Intrinsics.checkNotNullParameter(r108, "path");
        PolarisFileWrapper r109 = new PolarisFileWrapper(r108);
        if (r109.exists() == true) goto L18;
        r109.mkdirs();
    L18:
        return r106.getAbsolutePath();
    L7:
        th = move-exception;
        j.c("WebErrorPageUIOptimize", "checkAndGetErrorPageDir error", th);
        r106 = null;
        goto L9
    }
}
