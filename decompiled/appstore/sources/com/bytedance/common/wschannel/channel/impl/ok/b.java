package com.bytedance.common.wschannel.channel.impl.ok;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.e;
import com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f6972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RetryPolicy f6973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6975d;

    public b(List r10, RetryPolicy r11) {
        this.f6974c = 0;
        ArrayList r12 = new ArrayList();
        this.f6972a = r12;
        if (r10 == null) goto L5;
        r12.addAll(r10);
    L5:
        Logger.d("WsChannelSdk_ok", "urls : " + r12);
        this.f6973b = r11;
        d();
    }

    public final synchronized String a() {
        monitor-enter(this);
        int r10 = this.f6974c + 1;     // Catch: Throwable -> L8
        this.f6974c = r10;     // Catch: Throwable -> L8
        if (this.f6972a.size() <= r10) goto L11;
        String r11 = (String) this.f6972a.get(r10);     // Catch: Throwable -> L8
        this.f6975d = r11;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L11:
        monitor-exit(this);
        return "";
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized Pair b(Response r10) {
        monitor-enter(this);
        String r11 = c();     // Catch: Throwable -> L8
        long r12 = this.f6973b.getRetryIntervalWithResponse(r10);     // Catch: Throwable -> L8
        if (r12 != (-1)) goto L10;
        this.f6973b.reset();     // Catch: Throwable -> L8
        r11 = a();     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r11) == true) goto L10;
        r12 = this.f6973b.getRandomInterval();     // Catch: Throwable -> L8
    L10:
        Pair r13 = new Pair(r11, Long.valueOf(r12));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r13;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized String c() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (e.b(this.f6975d) == false) goto L10;
        int r10 = this.f6972a.size();     // Catch: Throwable -> L8
        int r11 = this.f6974c;     // Catch: Throwable -> L8
        if (r10 <= r11) goto L10;
        this.f6975d = (String) this.f6972a.get(r11);     // Catch: Throwable -> L8
    L10:
        String r12 = this.f6975d;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r12;
    }

    public synchronized void d() {
        monitor-enter(this);
        this.f6973b.reset();     // Catch: Throwable -> L6
        this.f6975d = null;     // Catch: Throwable -> L6
        this.f6974c = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
