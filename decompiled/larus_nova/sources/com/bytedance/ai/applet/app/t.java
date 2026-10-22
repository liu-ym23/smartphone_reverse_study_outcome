package com.bytedance.ai.applet.app;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public interface t {

    public static final class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f34426a = null;

        static {
            f34426a = new a();
        }

        public a() {
        }
    }

    public static final class b implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34427a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f34427a, ((b) r100).f34427a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f34427a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Error(message=" + this.f34427a + ')';
        }

        public b(String r100) {
            this.f34427a = r100;
        }
    }

    public static final class c implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f34428a = null;

        static {
            f34428a = new c();
        }

        public c() {
        }
    }
}
