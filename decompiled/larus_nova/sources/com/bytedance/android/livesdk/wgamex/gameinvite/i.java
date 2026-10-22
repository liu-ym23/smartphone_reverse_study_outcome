package com.bytedance.android.livesdk.wgamex.gameinvite;

import com.bytedance.android.livesdk.message.model.z4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z4.b f160733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z4.a f160734b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f160733a, r101.f160733a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f160734b, r101.f160734b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            z4.b r100 = this.f160733a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            z4.a r104 = this.f160734b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "CreatingState(switch=" + this.f160733a + ", inviteItem=" + this.f160734b + ")";
        }

        public a(z4.b r100, z4.a r101) {
            Intrinsics.checkNotNullParameter(r100, "switch");
            Intrinsics.checkNotNullParameter(r101, "inviteItem");
            this.f160733a = r100;
            this.f160734b = r101;
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z4.b f160735a;

        public b(z4.b r100) {
            Intrinsics.checkNotNullParameter(r100, "switch");
            this.f160735a = r100;
        }
    }

    public static final class c extends i {
        public c() {
        }
    }

    public static final class d extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z4.b f160736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z4.a f160737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f160738c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L12;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f160736a, r101.f160736a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f160737b, r101.f160737b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f160738c, r101.f160738c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            z4.b r100 = this.f160736a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            z4.a r104 = this.f160737b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Long r107 = this.f160738c;
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
            return "InvitingState(switch=" + this.f160736a + ", inviteItem=" + this.f160737b + ", userId=" + this.f160738c + ")";
        }

        public d(z4.b r100, z4.a r101) {
            Intrinsics.checkNotNullParameter(r100, "switch");
            Intrinsics.checkNotNullParameter(r101, "inviteItem");
            this.f160736a = r100;
            this.f160737b = r101;
            this.f160738c = 0L;
        }
    }

    public i() {
    }
}
