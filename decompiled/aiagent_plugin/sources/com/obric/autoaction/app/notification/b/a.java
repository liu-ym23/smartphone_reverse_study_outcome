package com.obric.autoaction.app.notification.b;

import android.content.Context;
import d.h.b.h;

/* JADX INFO: compiled from: AOSessionBasedNotifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements b {
    private static final String TAG = "AOSes-Notif";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0563a f24577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f24578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f24579c;

    /* JADX INFO: renamed from: com.obric.autoaction.app.notification.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOSessionBasedNotifier.kt */
    public static final class C0563a {
        public /* synthetic */ C0563a(h r1) {
            this();
        }

        private C0563a() {
        }
    }

    static {
        f24577a = new C0563a(null);
    }

    public void c() {
        b.a.a(this);
    }

    @Override // com.obric.autoaction.app.notification.b.b
    public String d() {
        return b.a.b(this);
    }

    public final Context getContext() {
        return this.f24578b;
    }

    public final String a() {
        return this.f24579c;
    }

    @Override // com.obric.autoaction.app.notification.b.b
    public String b() {
        return this.f24579c;
    }
}
