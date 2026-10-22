package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import io.reactivex.Single;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class l {

    public static final class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c f91459a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f91459a, ((a) r100).f91459a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r100 = this.f91459a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Created(sharer=" + this.f91459a + ")";
        }

        public a(com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r100) {
            Intrinsics.checkNotNullParameter(r100, "sharer");
            this.f91459a = r100;
        }
    }

    public static final class b extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Single<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c> f91460a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f91460a, ((b) r100).f91460a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            Single<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c> r100 = this.f91460a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Creating(onResult=" + this.f91460a + ")";
        }

        public b(Single<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c> r100) {
            Intrinsics.checkNotNullParameter(r100, "onResult");
            this.f91460a = r100;
        }
    }

    public l() {
    }
}
