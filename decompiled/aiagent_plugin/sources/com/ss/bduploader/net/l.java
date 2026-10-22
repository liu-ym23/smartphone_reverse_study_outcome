package com.ss.bduploader.net;

import android.os.Handler;
import com.ss.bduploader.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: LocalDNS.java */
/* JADX INFO: loaded from: classes4.dex */
public class l extends h {
    private static final String TAG = "LocalDNS";
    private InetAddress[] f;
    private boolean g;
    private Future h;

    /* JADX INFO: compiled from: LocalDNS.java */
    private static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<l> f37549a;

        public a(l r2) {
            this.f37549a = new WeakReference(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            s.c(l.TAG, String.format("----implement delayed check for local dns", new Object[0]));
            l r10 = (l) ZeusTransformUtils.preCheckCast(this.f37549a.get(), l.class, "com.obric.aiagent.plugin");
            if (r10 != null) goto L7;
            s.c(l.TAG, String.format("****end implement delayed check for local dns, dns object null", new Object[0]));
            return;
        L7:
            if (l.b(r10) == true) goto L10;
            r10.b();
            s.c(l.TAG, String.format("****end implement delayed check cancel local dns,", new Object[0]));
            r10.a(new b(0, r10.f37534c, null, 0, r10.f37536e));
            return;
        }
    }

    static /* synthetic */ boolean a(l r0, boolean r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ InetAddress[] a(l r0) {
        return r0.f;
    }

    static /* synthetic */ InetAddress[] a(l r0, InetAddress[] r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ boolean b(l r0) {
        return r0.g;
    }

    public l(String r1, Handler r2) {
        super(r1, r2);
        this.g = false;
    }

    @Override // com.ss.bduploader.net.h
    public void a() {
        this.h = f.a(new AnonymousClass1(this));     // Catch: Exception -> L4
    L6:
        this.f37532a.postDelayed(new a(this), 10000);
        return;
    L4:
        e = move-exception;
        s.c(TAG, String.format("****end call local dns, exception:%s host:%s", new Object[]{e, this.f37534c}));
        a(new b(0, this.f37534c, null, 0, this.f37536e));
        goto L6
    }

    @Override // com.ss.bduploader.net.h
    public void b() {
        if (this.f37533b == false) goto L5;
        return;
    L5:
        this.f37533b = true;
        Future r1 = this.h;
        if (r1 == null) goto L9;
        r1.cancel(true);
        this.h = null;
        return;
    }

    @Override // com.ss.bduploader.net.h
    public void c() {
        super.c();
        Future r0 = this.h;
        if (r0 == null) goto L6;
        r0.cancel(true);
        this.h = null;
        return;
    }
}
