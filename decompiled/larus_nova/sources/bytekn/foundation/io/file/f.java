package bytekn.foundation.io.file;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f21798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21799b;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("[component=");
        r100.append(this.f21799b);
        r100.append(", canonicalPath=");
        File r101 = this.f21798a;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getCanonicalPath();
    L6:
        r100.append(r103);
        r100.append(", absolutePath=");
        File r104 = this.f21798a;
        if (r104 == null) goto L9;
        r102 = r104.getAbsolutePath();
    L9:
        r100.append(r102);
        r100.append(']');
        return r100.toString();
    L5:
        r103 = null;
        goto L6
    }

    public f(String r100) {
        this.f21799b = r100;
        if (r100 == null) goto L5;
        File r101 = new PolarisFileWrapper(r100).getAbsoluteFile();
    L6:
        this.f21798a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }
}
