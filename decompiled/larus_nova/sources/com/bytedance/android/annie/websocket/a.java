package com.bytedance.android.annie.websocket;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.nio.charset.StandardCharsets;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a implements b, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f40107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f40108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f40109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f40110d;

    /* JADX INFO: renamed from: com.bytedance.android.annie.websocket.a$a, reason: collision with other inner class name */
    public static final class C0751a {
    }

    static {
    }

    @Override // com.bytedance.android.annie.websocket.b
    public final void a() {
        monitor-enter(this);
        int r100 = this.f40110d;     // Catch: Throwable -> L9
        monitor-exit(this);
        if (r100 == (-1)) goto L14;
        h();
        e(-1);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public abstract void g();

    public abstract void h();

    public final void d() {
        j r100 = this.f40109c;
        if (r100 == null) goto L6;
        r100.onClosed();
        return;
    }

    public final void f() {
        Context r100 = this.f40107a;
        boolean r101 = false;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L21
        Object r103 = r100.getSystemService("connectivity");     // Catch: Throwable -> L21
        NetworkInfo r104 = null;
        if ((r103 instanceof ConnectivityManager) == false) goto L6;
        ConnectivityManager r105 = (ConnectivityManager) r103;     // Catch: Throwable -> L21
    L7:
        if (r105 == null) goto L10;
        r104 = r105.getActiveNetworkInfo();     // Catch: Throwable -> L21
    L10:
        if (r104 != null) goto L12;
    L14:
        boolean r106 = false;
    L15:
        if (r106 == true) goto L17;
    L19:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        if (r101 == true) goto L28;
        Intrinsics.checkNotNullParameter("net error", "reason");
        j r107 = this.f40109c;
        if (r107 == null) goto L32;
        r107.onFailed("net error");
        return;
    L32:
        return;
    L28:
        g();
        return;
    L17:
        if (r104.getState() != NetworkInfo.State.CONNECTED) goto L19;
        r101 = true;
        goto L23
    L12:
        if (r104.isConnected() != true) goto L14;
        r106 = true;
        goto L15
    L6:
        r105 = null;
    L21:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    public final Context getContext() {
        return this.f40107a;
    }

    public final synchronized void e(int r100) {
        monitor-enter(this);
        this.f40110d = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public a(Context r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "requestTask");
        this.f40107a = r100;
        this.f40108b = r101;
        this.f40110d = -1;
    }

    @Override // com.bytedance.android.annie.websocket.c
    public final void c(int r100, String r101) {
        boolean r102 = true;
        if (r100 != 2) goto L5;
        if (r101 != null) goto L18;
    L21:
        if (r102 == false) goto L25;
        Intrinsics.checkNotNullParameter(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN, "reason");
        j r103 = this.f40109c;
        if (r103 == null) goto L33;
        r103.onFailed(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        return;
    L33:
        return;
    L25:
        Intrinsics.checkNotNullParameter(r101, "reason");
        j r104 = this.f40109c;
        if (r104 == null) goto L35;
        r104.onFailed(r101);
        return;
    L35:
        return;
    L18:
        if (r101.length() == 0) goto L21;
        r102 = false;
        goto L21
    L5:
        if (r100 != 4) goto L36;
        monitor-enter(this);
        this.f40110d = 1;     // Catch: Throwable -> L13
        monitor-exit(this);
        j r105 = this.f40109c;
        if (r105 == null) goto L31;
        r105.onConnected();
        return;
    L31:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.annie.websocket.c
    public final void onMessage(byte[] r100, int r101) {
        if (1 != r101) goto L10;
        if (r100 == null) goto L6;
        String r102 = new String(r100, StandardCharsets.UTF_8);
    L7:
        Intrinsics.checkNotNullParameter(r102, "msg");
        j r103 = this.f40109c;
        if (r103 == null) goto L16;
        r103.onMessage(r102);
        return;
    L16:
        return;
    L6:
        r102 = "";
        goto L7
    L10:
        if (r100 != null) goto L12;
        r100 = new byte[0];
    L12:
        Intrinsics.checkNotNullParameter(r100, "msg");
        j r104 = this.f40109c;
        if (r104 == null) goto L18;
        r104.onMessage(r100);
        return;
    }
}
