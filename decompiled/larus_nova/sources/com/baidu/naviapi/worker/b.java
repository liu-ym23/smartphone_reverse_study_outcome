package com.baidu.naviapi.worker;

import com.baidu.naviapi.okhttp.log.BNLogUtil;
import com.baidu.naviapi.open.MsgBean;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes39.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f32714c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ b[] f32715d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f32716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<MsgBean> f32717b;

    static {
        b r100 = new b("INSTANCE", 0);
        f32714c = r100;
        f32715d = new b[]{r100};
    }

    public static b[] values() {
        return (b[]) f32715d.clone();
    }

    public void a() {
        Object r100 = this.f32716a;
        monitor-enter(r100);
        this.f32717b.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public MsgBean b() {
        Object r100 = this.f32716a;
        monitor-enter(r100);
        BNLogUtil.logI("BNAProducer", "consume: " + this.f32717b.size());     // Catch: Throwable -> L7
        MsgBean r101 = this.f32717b.pollLast();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public void c() {
        Object r100 = this.f32716a;
        monitor-enter(r100);
        this.f32716a.wait();     // Catch: Throwable -> L6 InterruptedException -> L8
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        BNLogUtil.logE("BNAProducer", "waitData", e);     // Catch: Throwable -> L6
        goto L10
    }

    public static b valueOf(String r100) {
        return (b) r27.a.a(b.class, r100);
    }

    public void a(MsgBean r100) {
        Object r101 = this.f32716a;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f32717b.size() <= 20) goto L7;
        this.f32717b.pollLast();     // Catch: Throwable -> L10
    L7:
        this.f32717b.push(r100);     // Catch: Throwable -> L10
        this.f32716a.notifyAll();     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
    }

    public b(String r100, int r101) {
        super(r100, r101);
        this.f32716a = new Object();
        this.f32717b = new LinkedList();
    }
}
