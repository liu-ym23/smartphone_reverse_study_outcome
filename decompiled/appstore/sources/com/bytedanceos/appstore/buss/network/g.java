package com.bytedanceos.appstore.buss.network;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f8810b;

        public a(int r10, String r11) {
            q.g(r11, "msg");
            super(null);
            this.f8809a = r10;
            this.f8810b = r11;
        }

        public final int a() {
            return this.f8809a;
        }

        public final String b() {
            return this.f8810b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.f8809a == r11.f8809a) goto L12;
            return false;
        L12:
            if (q.b(this.f8810b, r11.f8810b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f8809a) * 31) + this.f8810b.hashCode();
        }

        public String toString() {
            return this.f8810b + " 错误码 " + this.f8809a;
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8811a = null;

        static {
            f8811a = new b();
        }

        public b() {
            super(null);
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f8813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f8814c;

        public c(int r10, String r11, Object r12) {
            q.g(r11, "msg");
            super(null);
            this.f8812a = r10;
            this.f8813b = r11;
            this.f8814c = r12;
        }

        public final Object a() {
            return this.f8814c;
        }

        public final int b() {
            return this.f8812a;
        }

        public final String c() {
            return this.f8813b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (this.f8812a == r11.f8812a) goto L12;
            return false;
        L12:
            if (q.b(this.f8813b, r11.f8813b) == true) goto L15;
            return false;
        L15:
            if (q.b(this.f8814c, r11.f8814c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r10 = ((Integer.hashCode(this.f8812a) * 31) + this.f8813b.hashCode()) * 31;
            Object r11 = this.f8814c;
            if (r11 != null) goto L5;
            int r12 = 0;
        L7:
            return r10 + r12;
        L5:
            r12 = r11.hashCode();
            goto L7
        }

        public String toString() {
            return "Success(code=" + this.f8812a + ", msg=" + this.f8813b + ", body=" + this.f8814c + ')';
        }
    }

    public /* synthetic */ g(DefaultConstructorMarker r10) {
        this();
    }

    public g() {
    }
}
