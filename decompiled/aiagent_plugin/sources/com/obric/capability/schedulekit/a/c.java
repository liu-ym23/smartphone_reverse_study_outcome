package com.obric.capability.schedulekit.a;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppHost.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31868a = null;

    /* JADX INFO: compiled from: AppHost.kt */
    public static final class a implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ a f31869b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static c f31870c;

        static {
            f31869b = new a();
        }

        private a() {
        }

        private final c b() {
            c r1 = f31870c;
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new IllegalStateException("app module must call Apphost.setApphost()");
        }

        public final void a(c r2) {
            c r1 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
            o.e(r1, "impl");
            f31870c = r1;
        }

        @Override // com.obric.capability.schedulekit.a.c
        public Application a() {
            return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b().a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f31868a = a.f31869b;
    }

    Application a();
}
