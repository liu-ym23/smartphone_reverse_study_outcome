package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.a0;
import com.ttnet.org.chromium.net.b0;
import com.ttnet.org.chromium.net.y;
import com.ttnet.org.chromium.net.z;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VersionSafeCallbacks {

    public static final class UrlRequestStatusListener extends a0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a0.c f18763a;

        public UrlRequestStatusListener(a0.c r10) {
            this.f18763a = r10;
        }

        @Override // com.ttnet.org.chromium.net.a0.c
        public void onStatus(int r10) {
            this.f18763a.onStatus(r10);
        }
    }

    public static final class a extends com.ttnet.org.chromium.net.b.a {
    }

    public static final class b extends com.ttnet.org.chromium.net.c.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ttnet.org.chromium.net.c.a.b f18764a;

        public b(com.ttnet.org.chromium.net.c.a.b r10) {
            this.f18764a = r10;
        }

        @Override // com.ttnet.org.chromium.net.c.a.b
        public void loadLibrary(String r10) {
            this.f18764a.loadLibrary(r10);
        }
    }

    public static final class c extends com.ttnet.org.chromium.net.l {
    }

    public static final class d extends com.ttnet.org.chromium.net.m {
    }

    public static final class e extends com.ttnet.org.chromium.net.t.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ttnet.org.chromium.net.t.a f18765a;

        public e(com.ttnet.org.chromium.net.t.a r10) {
            super(r10.getExecutor());
            this.f18765a = r10;
        }

        @Override // com.ttnet.org.chromium.net.t.a
        public Executor getExecutor() {
            return this.f18765a.getExecutor();
        }

        @Override // com.ttnet.org.chromium.net.t.a
        public void onRequestFinished(com.ttnet.org.chromium.net.t r10) {
            this.f18765a.onRequestFinished(r10);
        }
    }

    public static final class f extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f18766a;

        public f(y r10) {
            this.f18766a = r10;
        }

        @Override // com.ttnet.org.chromium.net.y
        public long a() {
            return this.f18766a.a();
        }

        @Override // com.ttnet.org.chromium.net.y
        public void b(z r10, ByteBuffer r11) {
            this.f18766a.b(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.y
        public void c(z r10) {
            this.f18766a.c(r10);
        }

        @Override // com.ttnet.org.chromium.net.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f18766a.close();
        }
    }

    public static final class g extends a0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a0.b f18767a;

        public g(a0.b r10) {
            this.f18767a = r10;
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void a(a0 r10, b0 r11) {
            this.f18767a.a(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void b(a0 r10, b0 r11, CronetException r12) {
            this.f18767a.b(r10, r11, r12);
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void c(a0 r10, com.ttnet.org.chromium.net.t r11) {
            this.f18767a.c(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void d(a0 r10, b0 r11, ByteBuffer r12) {
            this.f18767a.d(r10, r11, r12);
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void e(a0 r10, b0 r11, String r12, String r13) {
            this.f18767a.e(r10, r11, r12, r13);
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void f(String r10, com.ttnet.org.chromium.net.t r11) {
            this.f18767a.f(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void g(a0 r10, b0 r11, String r12) {
            this.f18767a.g(r10, r11, r12);
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void h(a0 r10, b0 r11) {
            this.f18767a.h(r10, r11);
        }
    }
}
