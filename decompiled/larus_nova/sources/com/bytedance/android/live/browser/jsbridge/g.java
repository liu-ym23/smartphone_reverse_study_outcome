package com.bytedance.android.live.browser.jsbridge;

import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public interface g {

    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f63197c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f63198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f63199b;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.g$a$a, reason: collision with other inner class name */
        public static final class C1035a {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f63198a, r101.f63198a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f63199b, r101.f63199b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f63198a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f63199b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ChanneledConfig(channel=" + this.f63198a + ", configString=" + this.f63199b + ")";
        }

        static {
            f63197c = new a("__invalid__", "");
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "configString");
            this.f63198a = r100;
            this.f63199b = r101;
        }
    }

    Observable<a> getConfig();
}
