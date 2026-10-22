package bi4;

import android.text.TextUtils;
import com.bytedance.crash.i;
import com.bytedance.crash.util.g;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f19135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PolarisFileWrapper f19136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PolarisFileWrapper f19137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static PolarisFileWrapper f19138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static PolarisFileWrapper f19139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f19140g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19141a;

    static {
        f19140g = new e();
    }

    public static File a() {
        PolarisFileWrapper r100 = f19139f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (f19135b == true) goto L10;
        PolarisFileWrapper r101 = new PolarisFileWrapper(i.d(), "processTrack");
        f19136c = r101;
        g.c(r101);
        PolarisFileWrapper r102 = new PolarisFileWrapper(f19136c, String.valueOf(i.b() / 86400000));
        f19137d = r102;
        g.c(r102);
        PolarisFileWrapper r103 = new PolarisFileWrapper(f19137d, com.bytedance.crash.util.b.c());
        f19138e = r103;
        g.c(r103);
        f19135b = true;
    L10:
        if (f19138e == null) goto L14;
        PolarisFileWrapper r104 = new PolarisFileWrapper(f19138e, String.valueOf(i.b()));
        f19139f = r104;
        return r104;
    L14:
        return f19139f;
    }

    public e() {
    }

    public static PolarisFileWrapper b(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        String r102 = String.valueOf(r101 / 86400000);
        String r103 = String.valueOf(r101);
        PolarisFileWrapper r104 = i.d();
        StringBuilder r105 = new StringBuilder("processTrack");
        String r106 = File.separator;
        r105.append(r106);
        r105.append(r102);
        r105.append(r106);
        r105.append(r100);
        r105.append(r106);
        r105.append(r103);
        return new PolarisFileWrapper(r104, r105.toString());
    }
}
