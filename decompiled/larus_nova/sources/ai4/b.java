package ai4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f3745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f3747i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f3748j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f3749k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f3750l;

    public b() {
    }

    public final String toString() {
        return "AppExitInfo{mProcessName='" + this.f3739a + "', mTimestamp=" + this.f3740b + ", mPid=" + this.f3741c + ", mReason='" + this.f3742d + "', mStatus=" + this.f3743e + ", mImportance=" + this.f3744f + ", mPss='" + this.f3745g + "', mRss='" + this.f3746h + "', mDescription='" + this.f3747i + "', mRealPss=" + this.f3748j + ", mRealRss=" + this.f3749k + ", subReason='" + this.f3750l + "'}";
    }

    public static void a(JSONObject r100, Map r101) {
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L10
        Iterator r103 = ((HashMap) r101).entrySet().iterator();     // Catch: Throwable -> L10
    L4:
        if (r103.hasNext() == false) goto L7;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Throwable -> L10
        r102.put((String) r104.getKey(), r104.getValue());     // Catch: Throwable -> L10
        goto L4
    L7:
        if (com.bytedance.crash.util.j.g(r102) == true) goto L14;
        r100.put("filters", r102);     // Catch: Throwable -> L10
        return;
    L14:
        return;
    }
}
