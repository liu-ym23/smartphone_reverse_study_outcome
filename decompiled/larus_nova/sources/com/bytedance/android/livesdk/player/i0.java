package com.bytedance.android.livesdk.player;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f155402a;

    public static final class a extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f155403b;

        public a() {
            this(false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (this.f155403b == ((a) r100).f155403b) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            boolean r100 = this.f155403b;
            if (r100 == false) goto L6;
            return 1;
        L6:
            return r100 ? 1 : 0;
        }

        public final String toString() {
            return "Background(muted=" + this.f155403b + ")";
        }

        public a(boolean r100) {
            this.f155403b = r100;
        }
    }

    public static final class b extends i0 {
        public b() {
        }
    }

    public static final class c extends i0 {
        public c() {
        }
    }

    public static final class d extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f155404b;

        public d() {
            this(false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == true) goto L6;
            return false;
        L6:
            if (this.f155404b == ((d) r100).f155404b) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            boolean r100 = this.f155404b;
            if (r100 == false) goto L6;
            return 1;
        L6:
            return r100 ? 1 : 0;
        }

        public final String toString() {
            return "Playing(muted=" + this.f155404b + ")";
        }

        public d(boolean r100) {
            this.f155404b = r100;
        }
    }

    public static final class e extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f155405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f155406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f155407d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f155408e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f155409f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f155410g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Context f155411h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f155412i;

        public e() {
            this(false, false, false, false, false, false, 255);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == false) goto L22;
            e r101 = (e) r100;
            if (this.f155405b == r101.f155405b) goto L8;
            return false;
        L8:
            if (this.f155406c == r101.f155406c) goto L10;
            return false;
        L10:
            if (this.f155407d == r101.f155407d) goto L12;
            return false;
        L12:
            if (this.f155408e == r101.f155408e) goto L14;
            return false;
        L14:
            if (this.f155409f == r101.f155409f) goto L16;
            return false;
        L16:
            if (this.f155410g == r101.f155410g) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f155411h, r101.f155411h) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.f155412i, r101.f155412i) == true) goto L34;
            return false;
        L34:
            return true;
        L22:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        public final int hashCode() {
            boolean r100 = this.f155405b;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = r102 * 31;
            boolean r104 = this.f155406c;
            ?? r105 = r104;
            if (r104 == false) goto L8;
            r105 = 1;
        L8:
            int r106 = (r103 + r105) * 31;
            boolean r107 = this.f155407d;
            ?? r108 = r107;
            if (r107 == false) goto L11;
            r108 = 1;
        L11:
            int r109 = (r106 + r108) * 31;
            boolean r110 = this.f155408e;
            ?? r111 = r110;
            if (r110 == false) goto L14;
            r111 = 1;
        L14:
            int r112 = (r109 + r111) * 31;
            boolean r113 = this.f155409f;
            ?? r114 = r113;
            if (r113 == false) goto L17;
            r114 = 1;
        L17:
            int r115 = (r112 + r114) * 31;
            boolean r116 = this.f155410g;
            if (r116 == true) goto L21;
            r101 = r116;
        L21:
            int r117 = (r115 + r101) * 31;
            Context r118 = this.f155411h;
            int r119 = 0;
            if (r118 == null) goto L24;
            int r120 = r118.hashCode();
        L25:
            int r121 = (r117 + r120) * 31;
            String r122 = this.f155412i;
            if (r122 == null) goto L29;
            r119 = r122.hashCode();
        L29:
            return r121 + r119;
        L24:
            r120 = 0;
            goto L25
        }

        public final String toString() {
            return "Preparing(renderViewBound=" + this.f155405b + ", surfaceReady=" + this.f155406c + ", playerPrepared=" + this.f155407d + ", firstFrame=" + this.f155408e + ", reset=" + this.f155409f + ", preCreateSurface=" + this.f155410g + ", activity=" + this.f155411h + ", resolution=" + this.f155412i + ")";
        }

        public final Context getActivity() {
            return this.f155411h;
        }

        public e(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, int r106) {
            if ((r106 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r106 & 2) == 0) goto L9;
            r101 = false;
        L9:
            if ((r106 & 4) == 0) goto L12;
            r102 = false;
        L12:
            if ((r106 & 8) == 0) goto L15;
            r103 = false;
        L15:
            if ((r106 & 16) == 0) goto L18;
            r104 = false;
        L18:
            if ((r106 & 32) == 0) goto L21;
            r105 = false;
        L21:
            if ((r106 & 128) == 0) goto L23;
            String r107 = "";
        L24:
            Intrinsics.checkNotNullParameter(r107, "resolution");
            this.f155405b = r100;
            this.f155406c = r101;
            this.f155407d = r102;
            this.f155408e = r103;
            this.f155409f = r104;
            this.f155410g = r105;
            this.f155411h = null;
            this.f155412i = r107;
            return;
        L23:
            r107 = null;
            goto L24
        }
    }

    public static final class f extends i0 {
        public f() {
        }
    }

    public static final class g extends i0 {
        public g() {
        }
    }

    public i0() {
    }
}
