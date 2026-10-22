package com.ttnet.org.chromium.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Date;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: RequestFinishedInfo.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class w {

    /* JADX INFO: compiled from: RequestFinishedInfo.java */
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Executor f38300a;

        public abstract void a(w r1);

        public a(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L7;
            this.f38300a = r4;
            return;
        L7:
            throw new IllegalStateException("Executor must not be null");
        }

        public Executor a() {
            return this.f38300a;
        }
    }

    /* JADX INFO: compiled from: RequestFinishedInfo.java */
    public static abstract class b {
        public abstract boolean A();

        public abstract boolean B();

        public abstract int C();

        public abstract String D();

        public abstract long E();

        public abstract long F();

        public abstract long G();

        public abstract long H();

        public abstract long I();

        public abstract Long J();

        public abstract Date a();

        public abstract Date b();

        public abstract Date c();

        public abstract Date d();

        public abstract Date e();

        public abstract Date f();

        public abstract Date g();

        public abstract Date h();

        public abstract Date i();

        public abstract Date j();

        public abstract Date k();

        public abstract Date l();

        public abstract Date m();

        public abstract boolean n();

        public abstract Long o();

        public abstract Long p();

        public abstract Long q();

        public abstract String r();

        public abstract Long s();

        public abstract Long t();

        public abstract String u();

        public abstract String v();

        public abstract Long w();

        public abstract Long x();

        public abstract Integer y();

        public abstract String z();

        public b() {
        }
    }

    public abstract b a();

    public w() {
    }
}
