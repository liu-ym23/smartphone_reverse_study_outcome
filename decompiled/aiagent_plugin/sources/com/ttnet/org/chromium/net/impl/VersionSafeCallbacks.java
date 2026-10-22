package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.aj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public class VersionSafeCallbacks {

    public static final class UrlRequestStatusListener extends com.ttnet.org.chromium.net.ai.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.ttnet.org.chromium.net.ai.c f38068a;

        public UrlRequestStatusListener(com.ttnet.org.chromium.net.ai.c r1) {
            this.f38068a = r1;
        }

        @Override // com.ttnet.org.chromium.net.ai.c
        public void onStatus(int r1) {
            this.f38068a.onStatus(r1);
        }
    }

    public static final class a extends com.ttnet.org.chromium.net.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.ttnet.org.chromium.net.b.a f38069a;

        @Override // com.ttnet.org.chromium.net.b.a
        public void a(com.ttnet.org.chromium.net.b r1) {
            this.f38069a.a(r1);
        }

        @Override // com.ttnet.org.chromium.net.b.a
        public void a(com.ttnet.org.chromium.net.b r1, aj r2) {
            this.f38069a.a(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.b.a
        public void a(com.ttnet.org.chromium.net.b r1, aj r2, ByteBuffer r3, boolean r4) {
            this.f38069a.a(r1, r2, r3, r4);
        }

        @Override // com.ttnet.org.chromium.net.b.a
        public void b(com.ttnet.org.chromium.net.b r1, aj r2, ByteBuffer r3, boolean r4) {
            this.f38069a.b(r1, r2, r3, r4);
        }

        @Override // com.ttnet.org.chromium.net.b.a
        public void a(com.ttnet.org.chromium.net.b r1, aj r2, aj.a r3) {
            this.f38069a.a(r1, r2, r3);
        }

        @Override // com.ttnet.org.chromium.net.b.a
        public void b(com.ttnet.org.chromium.net.b r1, aj r2) {
            this.f38069a.b(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.b.a
        public void a(com.ttnet.org.chromium.net.b r1, aj r2, com.ttnet.org.chromium.net.e r3) {
            this.f38069a.a(r1, r2, r3);
        }

        @Override // com.ttnet.org.chromium.net.b.a
        public void c(com.ttnet.org.chromium.net.b r1, aj r2) {
            this.f38069a.c(r1, r2);
        }
    }

    public static final class b extends com.ttnet.org.chromium.net.d.a.AbstractC1027a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.ttnet.org.chromium.net.d.a.AbstractC1027a f38070a;

        public b(com.ttnet.org.chromium.net.d.a.AbstractC1027a r1) {
            this.f38070a = r1;
        }

        @Override // com.ttnet.org.chromium.net.d.a.AbstractC1027a
        public void loadLibrary(String r1) {
            this.f38070a.loadLibrary(r1);
        }
    }

    public static final class c extends com.ttnet.org.chromium.net.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.ttnet.org.chromium.net.p f38071a;

        @Override // com.ttnet.org.chromium.net.p
        public void a(int r1, long r2, int r4) {
            this.f38071a.a(r1, r2, r4);
        }

        @Override // com.ttnet.org.chromium.net.p
        public Executor a() {
            return this.f38071a.a();
        }

        public int hashCode() {
            return this.f38071a.hashCode();
        }

        public boolean equals(Object r3) {
            if (r3 != null) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L8;
            return false;
        L8:
            return this.f38071a.equals(((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin")).f38071a);
        }
    }

    public static final class d extends com.ttnet.org.chromium.net.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.ttnet.org.chromium.net.q f38072a;

        @Override // com.ttnet.org.chromium.net.q
        public void a(int r1, long r2, int r4) {
            this.f38072a.a(r1, r2, r4);
        }

        @Override // com.ttnet.org.chromium.net.q
        public Executor a() {
            return this.f38072a.a();
        }

        public int hashCode() {
            return this.f38072a.hashCode();
        }

        public boolean equals(Object r3) {
            if (r3 != null) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, d.class) == true) goto L8;
            return false;
        L8:
            return this.f38072a.equals(((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin")).f38072a);
        }
    }

    public static final class e extends com.ttnet.org.chromium.net.w.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.ttnet.org.chromium.net.w.a f38073a;

        public e(com.ttnet.org.chromium.net.w.a r2) {
            super(r2.a());
            this.f38073a = r2;
        }

        @Override // com.ttnet.org.chromium.net.w.a
        public void a(com.ttnet.org.chromium.net.w r1) {
            this.f38073a.a(r1);
        }

        @Override // com.ttnet.org.chromium.net.w.a
        public Executor a() {
            return this.f38073a.a();
        }
    }

    public static final class f extends com.ttnet.org.chromium.net.ag {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.ttnet.org.chromium.net.ag f38074a;

        public f(com.ttnet.org.chromium.net.ag r1) {
            this.f38074a = r1;
        }

        @Override // com.ttnet.org.chromium.net.ag
        public long a() {
            return this.f38074a.a();
        }

        @Override // com.ttnet.org.chromium.net.ag
        public void a(com.ttnet.org.chromium.net.ah r1, ByteBuffer r2) {
            this.f38074a.a(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.ag
        public void a(com.ttnet.org.chromium.net.ah r1) {
            this.f38074a.a(r1);
        }

        @Override // com.ttnet.org.chromium.net.ag, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f38074a.close();
        }
    }

    public static final class g extends com.ttnet.org.chromium.net.ai.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.ttnet.org.chromium.net.ai.b f38075a;

        public g(com.ttnet.org.chromium.net.ai.b r1) {
            this.f38075a = r1;
        }

        @Override // com.ttnet.org.chromium.net.ai.b
        public void a(com.ttnet.org.chromium.net.ai r1, aj r2, String r3, String r4) {
            this.f38075a.a(r1, r2, r3, r4);
        }

        @Override // com.ttnet.org.chromium.net.ai.b
        public void a(com.ttnet.org.chromium.net.ai r1, aj r2, String r3) {
            this.f38075a.a(r1, r2, r3);
        }

        @Override // com.ttnet.org.chromium.net.ai.b
        public void a(com.ttnet.org.chromium.net.ai r1, aj r2, ByteBuffer r3) {
            this.f38075a.a(r1, r2, r3);
        }

        @Override // com.ttnet.org.chromium.net.ai.b
        public void a(com.ttnet.org.chromium.net.ai r1, aj r2) {
            this.f38075a.a(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.ai.b
        public void a(com.ttnet.org.chromium.net.ai r1, aj r2, com.ttnet.org.chromium.net.e r3) {
            this.f38075a.a(r1, r2, r3);
        }

        @Override // com.ttnet.org.chromium.net.ai.b
        public void b(com.ttnet.org.chromium.net.ai r1, aj r2) {
            this.f38075a.b(r1, r2);
        }
    }
}
