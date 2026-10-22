package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class i extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConnectivityManager f5545f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f5546g;

    public static final class a extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f5547a;

        public a(i r10) {
            this.f5547a = r10;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r10, NetworkCapabilities r11) {
            q.g(r10, "network");
            q.g(r11, "capabilities");
            androidx.work.i.e().a(j.b(), "Network capabilities changed: " + r11);
            i r12 = this.f5547a;
            r12.g(j.c(i.j(r12)));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r10) {
            q.g(r10, "network");
            androidx.work.i.e().a(j.b(), "Network connection lost");
            i r11 = this.f5547a;
            r11.g(j.c(i.j(r11)));
        }
    }

    public i(Context r10, TaskExecutor r11) {
        q.g(r10, "context");
        q.g(r11, "taskExecutor");
        super(r10, r11);
        Object r12 = d().getSystemService("connectivity");
        q.e(r12, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f5545f = (ConnectivityManager) r12;
        this.f5546g = new a(this);
    }

    public static final /* synthetic */ ConnectivityManager j(i r10) {
        return r10.f5545f;
    }

    @Override // androidx.work.impl.constraints.trackers.g
    public /* bridge */ /* synthetic */ Object e() {
        return k();
    }

    @Override // androidx.work.impl.constraints.trackers.g
    public void h() {
        androidx.work.i.e().a(j.b(), "Registering network callback");     // Catch: SecurityException -> L5 IllegalArgumentException -> L7
        androidx.work.impl.utils.k.a(this.f5545f, this.f5546g);     // Catch: SecurityException -> L5 IllegalArgumentException -> L7
    L15:
        return;
    L7:
        e = move-exception;
        androidx.work.i.e().d(j.b(), "Received exception while registering network callback", e);
        return;
    L5:
        e = move-exception;
        androidx.work.i.e().d(j.b(), "Received exception while registering network callback", e);
    }

    @Override // androidx.work.impl.constraints.trackers.g
    public void i() {
        androidx.work.i.e().a(j.b(), "Unregistering network callback");     // Catch: SecurityException -> L5 IllegalArgumentException -> L7
        androidx.work.impl.utils.i.c(this.f5545f, this.f5546g);     // Catch: SecurityException -> L5 IllegalArgumentException -> L7
    L15:
        return;
    L7:
        e = move-exception;
        androidx.work.i.e().d(j.b(), "Received exception while unregistering network callback", e);
        return;
    L5:
        e = move-exception;
        androidx.work.i.e().d(j.b(), "Received exception while unregistering network callback", e);
    }

    public androidx.work.impl.constraints.a k() {
        return j.c(this.f5545f);
    }
}
