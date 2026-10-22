package com.bytedance.android.gamecp.business.imagechoose;

import com.bytedance.android.gamecp.base.core.service.depend.w;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f56086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final pt.a.C7243a f56087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f56088c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f56086a, r101.f56086a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f56087b, r101.f56087b) == true) goto L10;
            return false;
        L10:
            if (this.f56088c == r101.f56088c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            w r100 = this.f56086a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            pt.a.C7243a r104 = this.f56087b;
            if (r104 == null) goto L9;
            r101 = r104.hashCode();
        L9:
            int r105 = (r103 + r101) * 31;
            boolean r106 = this.f56088c;
            ?? r107 = r106;
            if (r106 == false) goto L13;
            r107 = 1;
        L13:
            return r105 + r107;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Image(model=" + this.f56086a + ", compressResponse=" + this.f56087b + ", uploadSuccess=" + this.f56088c + ")";
        }

        public b(w r100, pt.a.C7243a r101) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Intrinsics.checkNotNullParameter(r101, "compressResponse");
            this.f56086a = r100;
            this.f56087b = r101;
            this.f56088c = false;
        }
    }

    static {
    }

    public i() {
    }

    public static final void a(i r100, String r101, b r102) {
        r100.getClass();
        yr.b.b(4, "Together#ImagePickerProvider", r101 + ' ' + r102.f56086a.f51415e + " ==> [" + r102.f56087b.f530617a + "]: " + r102.f56087b.f530618b + " [" + r102.f56088c + "]: " + r102.f56086a.f51417g);
    }
}
