package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class w {

    public static final class a extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f167990a = null;

        static {
            f167990a = new a();
        }

        public a() {
        }
    }

    public static final class b extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f167991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bitmap f167992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f167993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f167994d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f167995e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f167996f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L18;
            b r101 = (b) r100;
            if (this.f167991a == r101.f167991a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f167992b, r101.f167992b) == true) goto L10;
            return false;
        L10:
            if (this.f167993c == r101.f167993c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f167994d, r101.f167994d) == true) goto L14;
            return false;
        L14:
            if (this.f167995e == r101.f167995e) goto L16;
            return false;
        L16:
            if (this.f167996f == r101.f167996f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        public final int hashCode() {
            int r100 = this.f167991a * 31;
            Bitmap r101 = this.f167992b;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            boolean r105 = this.f167993c;
            ?? r106 = r105;
            if (r105 == false) goto L9;
            r106 = 1;
        L9:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f167994d;
            if (r108 == null) goto L13;
            r102 = r108.hashCode();
        L13:
            return ((((r107 + r102) * 31) + this.f167995e) * 31) + this.f167996f;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "SuccessBitmap(index=" + this.f167991a + ", bitmap=" + this.f167992b + ", isHead=" + this.f167993c + ", uri=" + this.f167994d + ", imageWidth=" + this.f167995e + ", imageHeight=" + this.f167996f + ")";
        }

        public b(int r100, Bitmap r101, boolean r102, String r103, int r104, int r105) {
            Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
            this.f167991a = r100;
            this.f167992b = r101;
            this.f167993c = r102;
            this.f167994d = r103;
            this.f167995e = r104;
            this.f167996f = r105;
        }
    }

    public w() {
    }
}
