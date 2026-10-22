package com.obric.event.task.base.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AbsEventTaskLogger.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0897a f32682b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f32683a;

    /* JADX INFO: renamed from: com.obric.event.task.base.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbsEventTaskLogger.kt */
    public static final class C0897a {
        public /* synthetic */ C0897a(h r1) {
            this();
        }

        private C0897a() {
        }
    }

    static {
        f32682b = new C0897a(null);
    }

    public a(String r2) {
        o.e(r2, "moduleTag");
        this.f32683a = r2;
    }

    private final String a(String r3) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        return "et_" + this.f32683a;
    L10:
        return "et_" + this.f32683a + '_' + r3;
    L5:
        r0 = false;
        goto L7
    }

    public final void a(String r2, String r3) {
        o.e(r2, "tag");
        e.f32686a.a(a(r2), r3);
    }

    public final void b(String r2, String r3) {
        o.e(r2, "tag");
        e.f32686a.c(a(r2), r3);
    }

    public final void c(String r2, String r3) {
        o.e(r2, "tag");
        e.f32686a.d(a(r2), r3);
    }

    public final void a(String r2, String r3, Throwable r4) {
        o.e(r2, "tag");
        e.f32686a.b(a(r2), r3, r4);
    }

    public final void d(String r2, String r3) {
        o.e(r2, "tag");
        e.f32686a.b(a(r2), r3);
    }

    public final void b(String r2, String r3, Throwable r4) {
        o.e(r2, "tag");
        e.f32686a.a(a(r2), r3, r4);
    }
}
