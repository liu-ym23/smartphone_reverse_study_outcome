package d9;

import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.utils.ReflectTool;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f19128b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f19129a;

    public b() {
        c();
    }

    public static b b() {
        monitor-enter(b.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f19128b != null) goto L9;
        f19128b = new b();     // Catch: Throwable -> L7
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L7
        return f19128b;
    }

    public void a() {
        ReflectTool.onTrackerEvent(this.f19129a, "flush", new Object[0]);
    }

    public final void c() {
        if (BaseApplication.c() == null) goto L5;
        this.f19129a = ReflectTool.initTracker();
        return;
    L5:
        j.a("init exception with appstoreapplication not init");
    }

    public void d(a.C0234a r10) {
        if (r10 == null) goto L4;
        ReflectTool.onTrackerEvent(this.f19129a, "onEvent", new Object[]{r10.c(), r10.b()});
        return;
    L4:
        j.a("report build is null");
    }

    public void e(String r10) {
        ReflectTool.onTrackerEvent(this.f19129a, "onEvent", new Object[]{r10});
    }

    public void f(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L9;
        ReflectTool.onAgentOs("onEvent", r10, r11);
        return;
    }

    public void g() {
        ReflectTool.onTrackerEvent(this.f19129a, "onLaunch", new Object[0]);
    }

    public void h() {
        ReflectTool.onTrackerEvent(this.f19129a, "onPause", new Object[0]);
    }

    public void i() {
        ReflectTool.onTrackerEvent(this.f19129a, "onResume", new Object[0]);
    }

    public void j(a.C0234a r10) {
        if (r10 == null) goto L5;
        ReflectTool.onTrackerEvent(this.f19129a, "onStatus", new Object[]{r10.c(), r10.b()});
        return;
    }

    public void k(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L9;
        ReflectTool.onAgentOs("onStatus", r10, r11);
        return;
    }
}
