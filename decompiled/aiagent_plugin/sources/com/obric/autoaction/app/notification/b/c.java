package com.obric.autoaction.app.notification.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: NeedUserNotifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.obric.autoaction.app.notification.b.a {
    private static final String TAG = "CallUser-Notif";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24580b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WeakReference<c> f24581d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24582c;

    /* JADX INFO: compiled from: NeedUserNotifier.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final void a() {
            c r2 = (c) ZeusTransformUtils.preCheckCast(c.f().get(), c.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L5;
            r2.c();
        L5:
            c.f().clear();
        }
    }

    public static final /* synthetic */ WeakReference f() {
        return f24581d;
    }

    static {
        f24580b = new a(null);
        f24581d = new WeakReference(null);
    }

    @Override // com.obric.autoaction.app.notification.b.b
    public int e() {
        return this.f24582c;
    }
}
