package bjc;

import com.ss.android.videoshop.log.tracer.PathID;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f19278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f19280e;

    public final void a(String r100, String r101) {
        if (this.f19280e != null) goto L5;
        this.f19280e = new HashMap();
    L5:
        ((HashMap) this.f19280e).put(r100, r101);
    }

    public b(String r100, String r101, int r102) {
        this.f19277b = r100;
        this.f19276a = r101;
        this.f19279d = r102;
        this.f19278c = System.currentTimeMillis();
    }

    public static b b(String r100, PathID r101, int r102) {
        if (r102 >= 6) goto L5;
        return null;
    L5:
        if (((HashSet) a.f19275a).contains(r101) == true) goto L7;
        return null;
    L7:
        return new b(r100, r101.name(), r102);
    }
}
