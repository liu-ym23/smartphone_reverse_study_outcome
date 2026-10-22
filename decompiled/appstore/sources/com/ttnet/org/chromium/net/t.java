package com.ttnet.org.chromium.net;

import java.util.Date;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public abstract class t {

    public static abstract class a {
        private final Executor mExecutor;

        public a(Executor r10) {
            if (r10 == null) goto L7;
            this.mExecutor = r10;
            return;
        L7:
            throw new IllegalStateException("Executor must not be null");
        }

        public Executor getExecutor() {
            return this.mExecutor;
        }

        public abstract void onRequestFinished(t r10);
    }

    public static abstract class b {
        public b() {
        }

        public abstract Date a();

        public abstract Date b();

        public abstract Date c();

        public abstract Date d();

        public abstract String e();

        public abstract Long f();

        public abstract Date g();

        public abstract Date h();

        public abstract Date i();

        public abstract Long j();

        public abstract Date k();

        public abstract String l();

        public abstract Date m();

        public abstract String n();

        public abstract Date o();

        public abstract Long p();

        public abstract Date q();

        public abstract Date r();

        public abstract Long s();

        public abstract boolean t();

        public abstract Date u();

        public abstract Date v();

        public abstract Long w();

        public abstract Long x();
    }

    public t() {
    }

    public abstract CronetException a();

    public abstract int b();

    public abstract b c();

    public abstract b0 d();

    public abstract String e();
}
