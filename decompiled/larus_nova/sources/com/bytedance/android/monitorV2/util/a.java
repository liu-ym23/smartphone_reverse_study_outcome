package com.bytedance.android.monitorV2.util;

import android.util.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f163229c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f163230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2495a f163231b;

    /* JADX INFO: renamed from: com.bytedance.android.monitorV2.util.a$a, reason: collision with other inner class name */
    public static final class C2495a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f163232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f163233b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C2495a) == true) goto L8;
            return false;
        L8:
            C2495a r101 = (C2495a) r100;
            if (Intrinsics.areEqual(this.f163232a, r101.f163232a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f163233b, r101.f163233b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f163232a.hashCode() * 31) + this.f163233b.hashCode();
        }

        public final String toString() {
            return "BidMatchResult(bid=" + this.f163232a + ", source=" + this.f163233b + ')';
        }

        public final boolean a() {
            boolean r100 = false;
            if (this.f163232a.length() != 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
        L9:
            r100 = true;
        L11:
            return !r100;
        L8:
            if (Intrinsics.areEqual(this.f163232a, "__hybrid_default") == false) goto L11;
        L5:
            r101 = false;
            goto L6
        }

        public C2495a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "bid");
            Intrinsics.checkNotNullParameter(r101, "source");
            this.f163232a = r100;
            this.f163233b = r101;
        }
    }

    public static final class b extends LruCache<String, String> {
        public b(int r100) {
            super(r100);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, String r101) {
            String r102 = r100;
            String r103 = r101;
            int r104 = 0;
            if (r102 == null) goto L9;
            int r105 = r102.length();
            if (r103 == null) goto L8;
            r104 = r103.length();
        L8:
            return r104 + r105;
        L9:
            return 0;
        }
    }

    public static final class c {
    }

    public abstract C2495a a(String r100, String r101);

    static {
        f163229c = new b((((int) Runtime.getRuntime().maxMemory()) / 1024) / 8);
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "matcherName");
        this.f163230a = r100;
        this.f163231b = new C2495a("__hybrid_default", "default_bid");
    }

    public final C2495a b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        return new C2495a(r100, this.f163230a);
    }
}
