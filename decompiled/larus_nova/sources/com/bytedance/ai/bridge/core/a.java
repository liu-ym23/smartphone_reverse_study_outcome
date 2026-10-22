package com.bytedance.ai.bridge.core;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f35243a = 0;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.core.a$a, reason: collision with other inner class name */
    public static final class C0684a {
        public C0684a() {
        }

        public static b a(int r100, String r101) {
            int r102 = a.f35243a;
            Intrinsics.checkNotNullParameter(r101, "msg");
            return new b(r100, r101, null, null, 24);
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f35245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JsonObject f35246d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final f3.a f35247e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final JsonObject f35248f;

        public b() {
            this(0, null, null, null, 31);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f35244b == r101.f35244b) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f35245c, r101.f35245c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f35246d, r101.f35246d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f35247e, r101.f35247e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f35248f, r101.f35248f) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final String toString() {
            return "Failure(code=" + this.f35244b + ", msg=" + this.f35245c + ", data=" + this.f35246d + ", errNo=" + this.f35247e + ", extras=" + this.f35248f + ')';
        }

        public final int hashCode() {
            int r100 = ((this.f35244b * 31) + this.f35245c.hashCode()) * 31;
            JsonObject r101 = this.f35246d;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            f3.a r105 = this.f35247e;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            JsonObject r108 = this.f35248f;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.f475285a;
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public /* synthetic */ b(int r100, String r101, JsonObject r102, f3.a r110, int r111) {
            if ((r111 & 1) == 0) goto L5;
            int r103 = 0;
        L7:
            if ((r111 & 2) == 0) goto L9;
            r101 = "";
        L9:
            String r104 = r101;
            if ((r111 & 4) == 0) goto L12;
            JsonObject r105 = null;
        L14:
            if ((r111 & 8) == 0) goto L16;
            f3.a r106 = null;
        L17:
            this(r103, r104, r105, r106, null);
            return;
        L16:
            r106 = r110;
            goto L17
        L12:
            r105 = r102;
            goto L14
        L5:
            r103 = r100;
            goto L7
        }

        public b(int r100, String r101, JsonObject r102, f3.a r103, JsonObject r104) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            this.f35244b = r100;
            this.f35245c = r101;
            this.f35246d = r102;
            this.f35247e = r103;
            this.f35248f = r104;
        }
    }

    public static final class c<T> extends a<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f35249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f35250c;

        public c() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f35249b, r101.f35249b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f35250c, r101.f35250c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f35249b;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f35250c.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "Success(data=" + this.f35249b + ", msg=" + this.f35250c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Object r100) {
            Intrinsics.checkNotNullParameter("", "msg");
            this.f35249b = r100;
            this.f35250c = "";
        }
    }

    static {
        new C0684a();
    }

    public a() {
    }
}
