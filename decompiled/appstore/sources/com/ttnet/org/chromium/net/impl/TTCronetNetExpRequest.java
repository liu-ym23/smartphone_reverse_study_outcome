package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("cronet")
public final class TTCronetNetExpRequest extends TTNetDiagnosisRequest {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f18743k = "TTCronetNetExpRequest";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CronetUrlRequestContext f18744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f18746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TTNetDiagnosisRequest.Callback f18749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Executor f18750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f18751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f18752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f18753j;

    public interface Natives {
        long createRequestAdapter(TTCronetNetExpRequest r10, long r11, int r12, String[] r13, int r14, int r15);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void destroy(long r10, TTCronetNetExpRequest r11);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void doExtraCommand(long r10, TTCronetNetExpRequest r11, String r12, String r13);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void start(long r10, TTCronetNetExpRequest r11);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f18755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TTCronetNetExpRequest f18756c;

        public a(TTCronetNetExpRequest r10, boolean r11, String r12) {
            this.f18756c = r10;
            this.f18754a = r11;
            this.f18755b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f18754a == true) goto L20;
            Object r10 = TTCronetNetExpRequest.d(this.f18756c);
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (TTCronetNetExpRequest.e(this.f18756c) == true) goto L11;
            TTCronetNetExpRequest.f(this.f18756c);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
        L20:
            TTCronetNetExpRequest.g(this.f18756c).onNetDiagnosisRequestComplete(this.f18756c, this.f18755b);     // Catch: Exception -> L17
            return;
        L17:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(TTCronetNetExpRequest.h(), "Exception in callback: ", new Object[]{e});
        }
    }

    static {
    }

    public TTCronetNetExpRequest(CronetUrlRequestContext r10, TTNetDiagnosisRequest.Callback r11, Executor r12, int r13, List r14, int r15, int r16) {
        this.f18753j = new Object();
        this.f18744a = r10;
        this.f18749f = r11;
        this.f18750g = r12;
        this.f18745b = r13;
        this.f18746c = r14;
        this.f18747d = r15;
        this.f18748e = r16;
    }

    public static /* synthetic */ Object d(TTCronetNetExpRequest r10) {
        return r10.f18753j;
    }

    public static /* synthetic */ boolean e(TTCronetNetExpRequest r10) {
        return r10.j();
    }

    public static /* synthetic */ void f(TTCronetNetExpRequest r10) {
        r10.i();
    }

    public static /* synthetic */ TTNetDiagnosisRequest.Callback g(TTCronetNetExpRequest r10) {
        return r10.f18749f;
    }

    public static /* synthetic */ String h() {
        return f18743k;
    }

    @CalledByNative
    private void onNetExpRequestComplete(String r10, boolean r11) {
        k(new a(this, r11, r10));
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void a() {
        Object r10 = this.f18753j;
        monitor-enter(r10);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (j() == false) goto L7;
    L14:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L7:
        if (this.f18752i == false) goto L14;
        i();     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void b(String r10, String r11) {
        Object r12 = this.f18753j;
        monitor-enter(r12);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (j() == false) goto L7;
    L14:
        monitor-exit(r12);     // Catch: Throwable -> L12
        return;
    L7:
        if (this.f18752i == false) goto L14;
        p.b().doExtraCommand(this.f18751h, this, r10, r11);     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void c() {
        Object r10 = this.f18753j;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f18752i == false) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        Natives r11 = p.b();     // Catch: Throwable -> L8
        long r12 = this.f18744a.Y();     // Catch: Throwable -> L8
        int r13 = this.f18745b;     // Catch: Throwable -> L8
        List r14 = this.f18746c;     // Catch: Throwable -> L8
        long r15 = r11.createRequestAdapter(this, r12, r13, (String[]) r14.toArray(new String[r14.size()]), this.f18747d, this.f18748e);     // Catch: Throwable -> L8
        this.f18751h = r15;     // Catch: Throwable -> L8
        if (r15 == 0) goto L16;
        this.f18752i = true;     // Catch: Throwable -> L8
        p.b().start(this.f18751h, this);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L16:
        throw new NullPointerException("Create native net exp request adapter failed.");     // Catch: Throwable -> L8
    }

    public final void i() {
        if (this.f18751h != 0) goto L5;
        return;
    L5:
        p.b().destroy(this.f18751h, this);
        this.f18751h = 0;
    }

    public final boolean j() {
        if (this.f18752i == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f18751h != 0) goto L7;
        return true;
    }

    public final void k(Runnable r10) {
        Executor r11 = this.f18750g;     // Catch: RejectedExecutionException -> L5
        if (r11 == null) goto L7;
        r11.execute(r10);     // Catch: RejectedExecutionException -> L5
    L11:
        return;
    L7:
        new Thread(r10, "NetExpCallback").start();     // Catch: RejectedExecutionException -> L5
    L5:
        e = move-exception;
        com.ttnet.org.chromium.base.j.a(f18743k, "Exception posting task to executor", new Object[]{e});
    }
}
