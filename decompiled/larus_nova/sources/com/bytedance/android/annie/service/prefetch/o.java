package com.bytedance.android.annie.service.prefetch;

import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public interface o {

    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f39971c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f39972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f39973b;

        /* JADX INFO: renamed from: com.bytedance.android.annie.service.prefetch.o$a$a, reason: collision with other inner class name */
        public static final class C0749a {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f39972a, r101.f39972a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f39973b, r101.f39973b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f39972a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f39973b.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "ChanneledConfig(channel=" + this.f39972a + ", configString=" + this.f39973b + ')';
        }

        static {
            f39971c = new a("__invalid__", "");
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "configString");
            this.f39972a = r100;
            this.f39973b = r101;
        }
    }

    Observable<a> getConfig();
}
