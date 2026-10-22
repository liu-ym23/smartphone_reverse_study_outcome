package y4;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.bytedance.frameworks.baselib.network.a.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile e f26120d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicBoolean f26121c;

    public e(int r10) {
        super(r10);
        this.f26121c = new AtomicBoolean(false);
    }

    public static e f() {
        if (f26120d != null) goto L16;
        monitor-enter(e.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f26120d != null) goto L11;
        f26120d = new e(30000);     // Catch: Throwable -> L9
    L11:
        monitor-exit(e.class);     // Catch: Throwable -> L9
    L16:
        return f26120d;
    }

    @Override // com.bytedance.frameworks.baselib.network.a.b
    public void c() {
        this.f26121c.set(true);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToBackground");
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.a.b
    public void d() {
        this.f26121c.set(false);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToForeground");
        return;
    }

    public void g(JSONObject r10) {
        e(r10.optInt("qf_enter_background_time", 30000));
    }
}
