package com.bytedance.ai.applet.login;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class o {

    public static final class a extends o {
    }

    public static final class b extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FinishReason f34778a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f34778a == ((b) r100).f34778a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f34778a.hashCode();
        }

        public final String toString() {
            return "Finished(reason=" + this.f34778a + ')';
        }

        public b(FinishReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f34778a = r100;
        }
    }

    public static final class c extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f34779a = null;

        static {
            f34779a = new c();
        }

        public c() {
        }
    }

    public static final class d extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f34780a = null;

        static {
            f34780a = new d();
        }

        public d() {
        }
    }

    public o() {
    }
}
