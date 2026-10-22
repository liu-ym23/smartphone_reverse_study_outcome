package a5;

import android.content.Context;
import com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask;
import com.bytedance.framwork.core.sdklib.util.ListUtils;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements IMonitorTimeTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f52a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList f53b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f54c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f55d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f56e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f57f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f58g;

    public d(Context r10, String r11) {
        this.f53b = new LinkedList();
        this.f54c = 5;
        this.f55d = 0;
        this.f56e = 120000;
        this.f58g = false;
        this.f52a = c.e(r10);
        this.f57f = r11;
    }

    public void a() {
        LinkedList r10 = this.f53b;
        monitor-enter(r10);
        this.f53b.clear();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void b(c5.a r10) {
        if (this.f53b.size() < 200) goto L5;
        e(System.currentTimeMillis(), true);
    L5:
        this.f53b.add(r10);
    }

    public void c() {
        e5.a.e().d(this);
    }

    public void d(String r10, String r11, JSONObject r12) {
        if (this.f58g == true) goto L8;
        if (r12 == null) goto L9;
        b(new c5.a(this.f57f, r10, r11, r12.toString(), System.currentTimeMillis()));
        return;
    L9:
        return;
    }

    public boolean e(long r10, boolean r11) {
        int r12 = this.f53b.size();
        if (r12 <= 0) goto L21;
        if (r11 == false) goto L6;
    L9:
        this.f55d = r10;
        LinkedList r13 = this.f53b;
        monitor-enter(r13);
        LinkedList r14 = new LinkedList(this.f53b);     // Catch: Throwable -> L18
        this.f53b.clear();     // Catch: Throwable -> L18
        monitor-exit(r13);     // Catch: Throwable -> L18
        if (ListUtils.a(r14) == true) goto L28;
        this.f52a.j(this.f57f, r14);     // Catch: Exception -> L23
        return true;
    L29:
        return true;
    L28:
        return true;
    L18:
        th = move-exception;
        throw th;
    L6:
        if (r12 >= 5) goto L9;
        if ((r10 - this.f55d) > 120000) goto L9;
        return false;
    L21:
        return false;
    }

    public void f(boolean r10) {
        this.f58g = r10;
    }

    @Override // com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask
    public void onTimeEvent(long r10) {
        if (this.f58g == true) goto L6;
        e(r10, false);
        return;
    }
}
