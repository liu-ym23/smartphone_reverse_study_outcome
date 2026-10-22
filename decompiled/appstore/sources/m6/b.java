package m6;

import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes.dex */
public class b extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f22157a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f22158b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f22159c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f22160d = "";

    static {
    }

    public b() {
    }

    public static b a() {
        if (f22157a != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22157a != null) goto L11;
        f22157a = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f22157a;
    }

    public final void b(Map r10) {
        setChanged();
        notifyObservers(r10);
    }

    public void c(String r10, String r11, String r12) {
        Logger.d("CronetDataStorageAccess", "onStoreIdcChanged idc: " + r10 + " region: " + r11 + " source: " + r12);
        f22158b = r10;
        f22159c = r11;
        f22160d = r12;
        HashMap r13 = new HashMap();
        r13.put("store_idc", r10);
        r13.put("store_region", r11);
        r13.put("region_source", r12);
        b(r13);
    }
}
