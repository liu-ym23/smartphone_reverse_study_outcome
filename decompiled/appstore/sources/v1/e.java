package v1;

import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.util.ListUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile e f24982c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArraySet f24983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap f24984b;

    public e() {
        this.f24983a = new CopyOnWriteArraySet();
        this.f24984b = new ConcurrentHashMap();
    }

    public static e a() {
        if (f24982c != null) goto L16;
        monitor-enter(e.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f24982c != null) goto L11;
        f24982c = new e();     // Catch: Throwable -> L9
    L11:
        monitor-exit(e.class);     // Catch: Throwable -> L9
    L16:
        return f24982c;
    }

    public JSONObject b(boolean r10) {
        JSONObject r11 = new JSONObject();
        Iterator r12 = this.f24984b.entrySet().iterator();     // Catch: JSONException -> L10
    L5:
        if (r12.hasNext() == false) goto L7;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: JSONException -> L10
        r11.put((String) r13.getKey(), r13.getValue());     // Catch: JSONException -> L10
        goto L5
    L7:
        if (r10 == false) goto L9;
        com.bytedance.apm.util.d.k().e(r11);     // Catch: JSONException -> L10
        com.bytedance.apm.util.d.k().a(r11);     // Catch: JSONException -> L10
    L9:
        return r11;
    }

    public String c() {
        String r10 = ListUtils.a(this.f24983a.toArray(), "#");
        if (TextUtils.isEmpty(r10) == true) goto L5;
        return r10;
    L5:
        return ActivityLifeObserver.getInstance().getTopActivityClassName();
    }
}
