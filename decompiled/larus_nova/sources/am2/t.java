package am2;

import com.bytedance.android.live.GsonHelper;
import com.google.gson.JsonElement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class t {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f4338i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Long, String> f4340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Long, String> f4341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Long, String> f4342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Long, String> f4343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4346h;

    public static final class a {
    }

    static {
        f4338i = new String[]{sz1.a.KEY_IS_RECOMMEND, "channel_id", "is_default_search", "previous_page"};
    }

    public final Map<String, String> b() {
        String r100 = this.f4344f;
        HashMap r101 = new HashMap();
        Iterator<T> r102 = GsonHelper.parser().parse(r100).getAsJsonObject().entrySet().iterator();     // Catch: Throwable -> L8
    L5:
        if (r102.hasNext() == false) goto L11;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Throwable -> L8
        r101.put(r103.getKey(), ((JsonElement) r103.getValue()).getAsString());     // Catch: Throwable -> L8
    L11:
        return Collections.synchronizedMap(r101);
    L8:
        th = move-exception;
        th.getMessage();
        goto L11
    }

    public t() {
        this.f4340b = Collections.synchronizedMap(new HashMap());
        this.f4341c = Collections.synchronizedMap(new HashMap());
        this.f4342d = Collections.synchronizedMap(new HashMap());
        this.f4343e = Collections.synchronizedMap(new HashMap());
    }

    public final Map<Long, String> a() {
        return this.f4341c;
    }

    public final String c() {
        return this.f4344f;
    }

    public final Map<Long, String> d() {
        return this.f4342d;
    }

    public final Map<Long, String> e() {
        return this.f4340b;
    }

    public final void f(String r100) {
        this.f4346h = r100;
    }

    public final void g(String r100) {
        this.f4344f = r100;
    }
}
