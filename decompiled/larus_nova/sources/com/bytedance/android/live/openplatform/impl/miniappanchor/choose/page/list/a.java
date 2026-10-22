package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.a$a, reason: collision with other inner class name */
    public static final class C1279a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1279a f84187a = null;

        static {
            f84187a = new C1279a();
        }

        public C1279a() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f84188a = null;

        static {
            f84188a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> f84189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c f84190b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L10;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f84189a, r101.f84189a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f84190b, r101.f84190b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> r100 = this.f84189a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c r104 = this.f84190b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Success(bannerList=" + this.f84189a + ", groupProperty=" + this.f84190b + ")";
        }

        public c(List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> r100, com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c r101) {
            Intrinsics.checkNotNullParameter(r100, "bannerList");
            Intrinsics.checkNotNullParameter(r101, "groupProperty");
            this.f84189a = r100;
            this.f84190b = r101;
        }
    }

    public a() {
    }
}
