package com.obric.event.task.base.b;

import com.obric.aiagent.platform.depend.ILogDepend;
import d.h.b.o;

/* JADX INFO: compiled from: TMLog.kt */
/* JADX INFO: loaded from: classes4.dex */
final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f32685a = null;

    static {
        f32685a = new c();
    }

    private c() {
    }

    @Override // com.obric.event.task.base.b.d
    public void a(String r1, String r2) {
        o.e(r1, "tag");
        ILogDepend.Companion.d(r1, String.valueOf(r2));
    }

    @Override // com.obric.event.task.base.b.d
    public void b(String r1, String r2) {
        o.e(r1, "tag");
        ILogDepend.Companion.e(r1, String.valueOf(r2));
    }

    @Override // com.obric.event.task.base.b.d
    public void a(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        ILogDepend.Companion.e(r1, String.valueOf(r2), r3);
    }

    @Override // com.obric.event.task.base.b.d
    public void c(String r1, String r2) {
        o.e(r1, "tag");
        ILogDepend.Companion.i(r1, String.valueOf(r2));
    }

    @Override // com.obric.event.task.base.b.d
    public void d(String r1, String r2) {
        o.e(r1, "tag");
        ILogDepend.Companion.w(r1, String.valueOf(r2));
    }

    @Override // com.obric.event.task.base.b.d
    public void b(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        ILogDepend.Companion.w(r1, String.valueOf(r2), r3);
    }
}
