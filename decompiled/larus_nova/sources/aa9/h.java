package aa9;

import android.app.Application;
import android.os.Environment;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.q0;
import com.larus.utils.r;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements aa9.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy<File> f2366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy<File> f2367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy<File> f2368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy<File> f2369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy<File> f2370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy<File> f2371g;

    public static final class a {
    }

    static {
    }

    private final Application getContext() {
        return AppHost.f326268a.getApplication();
    }

    public h() {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.f2366b = LazyKt.lazy(r100, new b(this));
        this.f2367c = LazyKt.lazy(r100, new c(this));
        this.f2368d = LazyKt.lazy(r100, new d(this));
        this.f2369e = LazyKt.lazy(r100, new e(this));
        this.f2370f = LazyKt.lazy(r100, new f(this));
        this.f2371g = LazyKt.lazy(r100, new g(this));
    }

    public static File a(h r100) {
        File r101 = r100.getContext().getExternalCacheDir();
        if (r101 != null) goto L5;
    L12:
        r101 = r100.f2366b.getValue();
    L13:
        r100.g(r101, "external_cache");
        return r101;
    L5:
        if (r101.isDirectory() == true) goto L7;
    L9:
        r101 = null;
    L10:
        if (r101 == null) goto L12;
    L7:
        if (r.m(r101) == false) goto L9;
        goto L9
    }

    public static File b(h r100) {
        File r101 = r100.getContext().getCacheDir();
        r100.g(r101, "internal_cache");
        return r101;
    }

    public static File c(h r100) {
        r100.getClass();
        if (Environment.isExternalStorageEmulated() == false) goto L5;
        File r101 = r100.f2367c.getValue();
    L16:
        r100.g(r101, "external_files");
        return r101;
    L5:
        r101 = r100.getContext().getExternalFilesDir(null);
        if (r101 != null) goto L8;
    L15:
        r101 = r100.f2367c.getValue();
        goto L16
    L8:
        if (r101.isDirectory() == true) goto L10;
    L12:
        r101 = null;
    L13:
        if (r101 == null) goto L15;
    L10:
        if (r.m(r101) == false) goto L12;
        goto L12
    }

    public static File d(h r100) {
        File r101 = r100.getContext().getFilesDir();
        r100.g(r101, "internal_files");
        return r101;
    }

    public final PolarisFileWrapper e(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "subPath");
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.f2366b.getValue(), r100);
        if (r101 == false) goto L5;
        r102.mkdirs();
    L5:
        g(r102, "getDirOfCache");
        return r102;
    }

    public final PolarisFileWrapper f(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "subPath");
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.f2367c.getValue(), r100);
        if (r101 == false) goto L5;
        r102.mkdirs();
    L5:
        g(r102, "getDirOfFiles");
        return r102;
    }

    public final void g(File r100, String r101) {
        if (AppHost.f326268a.isDebug() == false) goto L6;
        FLogger.f375446a.d("FileManagerImpl", "path[" + q0.b(getContext()) + "]: " + r101 + " = " + r100.getCanonicalPath() + ", exists = " + r100.exists());
        return;
    }
}
