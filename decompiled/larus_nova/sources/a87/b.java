package a87;

import android.net.Uri;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2158d;

    public static b a(Uri r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        List<String> r101 = r100.getPathSegments();
        if (r101 != null) goto L8;
    L12:
        return null;
    L8:
        if (r101.size() < 4) goto L12;
        return new b((String) ListProtector.get(r101, 0), (String) ListProtector.get(r101, 1), (String) ListProtector.get(r101, 2), (String) ListProtector.get(r101, 3));
    }

    public final Uri b(Uri r100) {
        return r100.buildUpon().appendPath(this.f2155a).appendPath(this.f2156b).appendPath(this.f2157c).appendPath(this.f2158d).build();
    }

    public b(String r100, String r101, String r102, String r103) {
        this.f2155a = r100;
        this.f2156b = r101;
        this.f2157c = r102;
        this.f2158d = r103;
    }
}
