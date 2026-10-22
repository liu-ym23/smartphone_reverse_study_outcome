package com.bytedance.android.livesdk.gecko;

import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public interface j {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f125807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f125808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f125809c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f125807a, r101.f125807a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f125808b, r101.f125808b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f125809c, r101.f125809c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f125807a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f125808b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f125809c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Cache(accessKey=" + this.f125807a + ", channel=" + this.f125808b + ", version=" + this.f125809c + ")";
        }

        public a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "accessKey");
            Intrinsics.checkNotNullParameter(r101, "channel");
            Intrinsics.checkNotNullParameter(r102, "version");
            this.f125807a = r100;
            this.f125808b = r101;
            this.f125809c = r102;
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f125810a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Float.compare(this.f125810a, ((c) r100).f125810a) == 0) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f125810a);
        }

        public final String toString() {
            return "DownloadProgressEntry(percent=" + this.f125810a + ")";
        }

        public c(float r100) {
            this.f125810a = r100;
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f125811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f125812b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L10;
            d r101 = (d) r100;
            if (this.f125811a == r101.f125811a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f125812b, r101.f125812b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final int hashCode() {
            boolean r100 = this.f125811a;
            ?? r101 = r100;
            if (r100 == false) goto L5;
            r101 = 1;
        L5:
            int r102 = r101 * 31;
            String r103 = this.f125812b;
            if (r103 == null) goto L8;
            int r104 = r103.hashCode();
        L10:
            return r102 + r104;
        L8:
            r104 = 0;
            goto L10
        }

        public final String toString() {
            return "DownloadResultEntry(isCache=" + this.f125811a + ", path=" + this.f125812b + ")";
        }

        public d(boolean r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "path");
            this.f125811a = r100;
            this.f125812b = r101;
        }
    }

    public static final class e implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f125813a = null;

        public e() {
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final String a() {
            return "";
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final Long c() {
            Intrinsics.checkNotNullParameter("social_linkmic_dynamic_lynx_saas", "channel");
            return null;
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final boolean d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "relativePath");
            return false;
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final Long getChannelVersion(String r100) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            return null;
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final InputStream getInputStream(String r100) {
            Intrinsics.checkNotNullParameter(r100, "relativePath");
            Intrinsics.checkNotNullParameter("live_im_push_compress_zstd_dict", "channel");
            return null;
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final WebResourceResponse interceptRequest(String r100) {
            return null;
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public void update(com.bytedance.android.livesdk.gecko.e r100) {
            Intrinsics.checkNotNullParameter(r100, "geckoUpdateListenerWrapper");
        }

        static {
            f125813a = new e();
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final List<String> b() {
            return CollectionsKt.emptyList();
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f125814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f125815b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof f) == false) goto L10;
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f125814a, r101.f125814a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f125815b, r101.f125815b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f125814a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f125815b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "GeckoArgs(channel=" + this.f125814a + ", version=" + this.f125815b + ")";
        }

        public f(String r100, String r101) {
            this.f125814a = r100;
            this.f125815b = r101;
        }
    }

    String a();

    List<String> b();

    Long c();

    boolean d(String r100);

    Long getChannelVersion(String r100);

    InputStream getInputStream(String r100);

    WebResourceResponse interceptRequest(String r100);

    void update(com.bytedance.android.livesdk.gecko.e r100);
}
