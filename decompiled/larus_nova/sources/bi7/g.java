package bi7;

import android.content.ClipData;
import ci7.w;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ClipData f19152c;

    @Override // java.lang.Runnable
    public final void run() {
        fi7.d.a(this.f19150a, this.f19151b, this.f19152c, false);     // Catch: Throwable -> L6
        ConcurrentHashMap<Class<?>, di7.d> r100 = w.f23890a;     // Catch: Throwable -> L6
        ei7.b r101 = (ei7.b) w.b(ei7.b.class);     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.g();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public g(String r100, String r101, ClipData r102, JSONObject r103) {
        this.f19150a = r100;
        this.f19151b = r101;
        this.f19152c = r102;
    }
}
