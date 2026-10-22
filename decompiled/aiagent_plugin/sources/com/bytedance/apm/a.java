package com.bytedance.apm;

import android.content.Context;
import com.bytedance.apm.internal.ApmDelegate;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Apm.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.apm.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: Apm.java */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            b.b("Apm#init", "Apm init");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Apm.java */
    private static class C0104a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f4113a = null;

        static /* synthetic */ a a() {
            return f4113a;
        }

        static {
            f4113a = new a(null);
        }
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    public static a a() {
        return C0104a.a();
    }

    public void a(Context r3, com.bytedance.apm.config.b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ApmDelegate.a().a(r5, r4);
        if (c.j() == false) goto L6;
        com.bytedance.apm.thread.c.a().a(new AnonymousClass2(this));
        return;
    }

    public void a(com.bytedance.apm.config.c r2) {
        ApmDelegate.a().a(r2);
        if (c.j() == false) goto L6;
        com.bytedance.apm.thread.c.a().a(new AnonymousClass3(this));
        return;
    }

    private a() {
    }
}
