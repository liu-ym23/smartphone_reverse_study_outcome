package com.bytedance.android.anniex.lite.container;

import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class n extends ib.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.anniex.base.lifecycle.a f40885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ia.c f40886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ib.f.a f40887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f40888d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f40889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f40890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WebView f40891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Throwable f40892d;

        public a(n r100, String r101, WebView r102, Throwable r103) {
            this.f40889a = r100;
            this.f40890b = r101;
            this.f40891c = r102;
            this.f40892d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n r100 = this.f40889a;     // Catch: Throwable -> L13
            ia.c r101 = r100.f40886b;     // Catch: Throwable -> L13
            if (r101 == null) goto L9;
            String r102 = this.f40890b;     // Catch: Throwable -> L13
            Throwable r103 = this.f40892d;     // Catch: Throwable -> L13
            com.bytedance.android.anniex.base.lifecycle.a r104 = r100.f40885a;     // Catch: Throwable -> L13
            if (r104 == null) goto L9;
            if (r102 != null) goto L8;
            r102 = null;
        L8:
            r104.g(r102, r101, r103);     // Catch: Throwable -> L13
        L9:
            ib.f.a r105 = this.f40889a.f40887c;     // Catch: Throwable -> L13
            if (r105 == null) goto L16;
            r105.onLoadFail(this.f40890b, this.f40891c, this.f40892d);     // Catch: Throwable -> L13
            return;
        L16:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f40893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f40894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WebView f40895c;

        public b(n r100, String r101, WebView r102) {
            this.f40893a = r100;
            this.f40894b = r101;
            this.f40895c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n r100 = this.f40893a;     // Catch: Throwable -> L13
            ia.c r101 = r100.f40886b;     // Catch: Throwable -> L13
            if (r101 == null) goto L9;
            String r102 = this.f40894b;     // Catch: Throwable -> L13
            com.bytedance.android.anniex.base.lifecycle.a r103 = r100.f40885a;     // Catch: Throwable -> L13
            if (r103 == null) goto L9;
            if (r102 != null) goto L8;
            r102 = null;
        L8:
            r103.h(r102, r101);     // Catch: Throwable -> L13
        L9:
            ib.f.a r104 = this.f40893a.f40887c;     // Catch: Throwable -> L13
            if (r104 == null) goto L16;
            r104.onLoadStart(this.f40894b, this.f40895c);     // Catch: Throwable -> L13
            return;
        L16:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f40896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f40897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WebView f40898c;

        public c(n r100, String r101, WebView r102) {
            this.f40896a = r100;
            this.f40897b = r101;
            this.f40898c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n r100 = this.f40896a;     // Catch: Throwable -> L13
            ia.c r101 = r100.f40886b;     // Catch: Throwable -> L13
            if (r101 == null) goto L9;
            String r102 = this.f40897b;     // Catch: Throwable -> L13
            com.bytedance.android.anniex.base.lifecycle.a r103 = r100.f40885a;     // Catch: Throwable -> L13
            if (r103 == null) goto L9;
            if (r102 != null) goto L8;
            r102 = null;
        L8:
            r103.i(r102, r101);     // Catch: Throwable -> L13
        L9:
            ib.f.a r104 = this.f40896a.f40887c;     // Catch: Throwable -> L13
            if (r104 == null) goto L16;
            r104.onLoadUriSuccess(this.f40897b, this.f40898c);     // Catch: Throwable -> L13
            return;
        L16:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f40899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f40900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WebView f40901c;

        public d(n r100, String r101, WebView r102) {
            this.f40899a = r100;
            this.f40900b = r101;
            this.f40901c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ib.f.a r100 = this.f40899a.f40887c;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a(this.f40900b, this.f40901c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f40902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f40903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WebView f40904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f40905d;

        public e(n r100, String r101, WebView r102, String r103) {
            this.f40902a = r100;
            this.f40903b = r101;
            this.f40904c = r102;
            this.f40905d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ib.f.a r100 = this.f40902a.f40887c;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.b(this.f40903b, this.f40904c, this.f40905d);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public n() {
        throw null;
    }

    public final void c(Runnable r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f40888d == false) goto L9;
        r100.run();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw null;     // Catch: Throwable -> L10
    }

    @Override // ib.f.a
    public final void a(String r100, WebView r101) {
        c(new d(this, r100, r101));
    }

    @Override // ib.f.a, ib.f
    public final void onLoadStart(String r100, WebView r101) {
        c(new b(this, r100, r101));
    }

    @Override // ib.f.a, ib.f
    public final void onLoadUriSuccess(String r100, WebView r101) {
        c(new c(this, r100, r101));
    }

    @Override // ib.f.a
    public final void b(String r100, WebView r101, String r102) {
        c(new e(this, r100, r101, r102));
    }

    @Override // ib.f.a, ib.f
    public final void onLoadFail(String r100, WebView r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r102, "e");
        c(new a(this, r100, r101, r102));
    }
}
