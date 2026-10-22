package com.obric.appstore.network;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10971b;

        public a(int r10, String r11) {
            q.g(r11, "msg");
            super(null);
            this.f10970a = r10;
            this.f10971b = r11;
        }

        public final int a() {
            return this.f10970a;
        }

        public final String b() {
            return this.f10971b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.f10970a == r11.f10970a) goto L12;
            return false;
        L12:
            if (q.b(this.f10971b, r11.f10971b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f10970a) * 31) + this.f10971b.hashCode();
        }

        public String toString() {
            return "Error(code=" + this.f10970a + ", msg=" + this.f10971b + ')';
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f10972a = null;

        static {
            f10972a = new b();
        }

        public b() {
            super(null);
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f10973a = null;

        static {
            f10973a = new c();
        }

        public c() {
            super(null);
        }
    }

    public static final class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f10974a;

        public d(Object r10) {
            super(null);
            this.f10974a = r10;
        }

        public final Object a() {
            return this.f10974a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof d) == true) goto L9;
            return false;
        L9:
            if (q.b(this.f10974a, ((d) r10).f10974a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            Object r10 = this.f10974a;
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.f10974a + ')';
        }
    }

    public /* synthetic */ g(DefaultConstructorMarker r10) {
        this();
    }

    public g() {
    }
}
