package com.bytedance.ai.applet.login;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class h {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LocalFinishReason f34753a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f34753a == ((a) r100).f34753a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f34753a.hashCode();
        }

        public final String toString() {
            return "Finished(reason=" + this.f34753a + ')';
        }

        public a(LocalFinishReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f34753a = r100;
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f34754a = null;

        static {
            f34754a = new b();
        }

        public b() {
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f34755a = null;

        static {
            f34755a = new c();
        }

        public c() {
        }
    }

    public static final class d extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f34756a = null;

        static {
            f34756a = new d();
        }

        public d() {
        }
    }

    public static final class e extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f34757a = null;

        static {
            f34757a = new e();
        }

        public e() {
        }
    }

    public h() {
    }
}
