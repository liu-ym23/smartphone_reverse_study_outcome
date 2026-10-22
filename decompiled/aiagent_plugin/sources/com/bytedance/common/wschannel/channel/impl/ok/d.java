package com.bytedance.common.wschannel.channel.impl.ok;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import okhttp3.ad;

/* JADX INFO: compiled from: WsPolicy.java */
/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f6907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.common.wschannel.channel.impl.ok.a.b f6908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6910d;

    d(List<String> r3, com.bytedance.common.wschannel.channel.impl.ok.a.b r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.channel.impl.ok.a.b r6 = (com.bytedance.common.wschannel.channel.impl.ok.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.common.wschannel.channel.impl.ok.a.b.class, "com.obric.aiagent.plugin");
        this.f6909c = 0;
        ArrayList r0 = new ArrayList();
        this.f6907a = r0;
        if (r5 == null) goto L5;
        r0.addAll(r5);
    L5:
        Logger.d("WsChannelSdk_ok", "urls : " + r0);
        this.f6908b = r6;
        b();
    }

    synchronized Pair<String, Long> a(ad r6) {
        monitor-enter(this);
        String r0 = c();     // Catch: Throwable -> L11
        long r1 = this.f6908b.a(r6);     // Catch: Throwable -> L11
        if (r1 != (-1)) goto L8;
        this.f6908b.c();     // Catch: Throwable -> L11
        r0 = a();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r0) == true) goto L8;
        r1 = this.f6908b.b();     // Catch: Throwable -> L11
    L8:
        Pair<String, Long> r7 = new Pair(r0, Long.valueOf(r1));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r7;
    L11:
        th = move-exception;
        throw th;
    }

    synchronized String a() {
        monitor-enter(this);
        int r0 = this.f6909c + 1;     // Catch: Throwable -> L11
        this.f6909c = r0;     // Catch: Throwable -> L11
        if (this.f6907a.size() <= r0) goto L9;
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.f6907a.get(r0), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        this.f6910d = r1;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L9:
        monitor-exit(this);
        return "";
    L11:
        th = move-exception;
        throw th;
    }

    synchronized void b() {
        monitor-enter(this);
        this.f6908b.c();     // Catch: Throwable -> L6
        this.f6910d = null;     // Catch: Throwable -> L6
        this.f6909c = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String c() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (j.a(this.f6910d) == false) goto L8;
        int r0 = this.f6907a.size();     // Catch: Throwable -> L11
        int r1 = this.f6909c;     // Catch: Throwable -> L11
        if (r0 <= r1) goto L8;
        this.f6910d = (String) ZeusTransformUtils.preCheckCast(this.f6907a.get(r1), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
    L8:
        String r2 = this.f6910d;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }
}
