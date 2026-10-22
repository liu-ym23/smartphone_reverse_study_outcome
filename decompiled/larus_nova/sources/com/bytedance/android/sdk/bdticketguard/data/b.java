package com.bytedance.android.sdk.bdticketguard.data;

import java.security.PrivateKey;
import java.security.PublicKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f163597a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f163597a, ((a) r100).f163597a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            Throwable r100 = this.f163597a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Error(error=" + this.f163597a + ")";
        }

        public a(Throwable r100) {
            this.f163597a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.sdk.bdticketguard.data.b$b, reason: collision with other inner class name */
    public static final class C2498b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PublicKey f163598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PrivateKey f163599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f163600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f163601d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L19:
            return true;
        L5:
            if ((r100 instanceof C2498b) == false) goto L18;
            C2498b r101 = (C2498b) r100;
            if (Intrinsics.areEqual(this.f163598a, r101.f163598a) == false) goto L18;
            if (Intrinsics.areEqual(this.f163599b, r101.f163599b) == false) goto L18;
            if (this.f163600c != r101.f163600c) goto L13;
            boolean r102 = true;
        L14:
            if (r102 == false) goto L18;
            if (Intrinsics.areEqual(this.f163601d, r101.f163601d) == false) goto L18;
        L13:
            r102 = false;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public final int hashCode() {
            PublicKey r100 = this.f163598a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            PrivateKey r104 = this.f163599b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            boolean r107 = this.f163600c;
            ?? r108 = r107;
            if (r107 == false) goto L13;
            r108 = 1;
        L13:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f163601d;
            if (r110 == null) goto L17;
            r101 = r110.hashCode();
        L17:
            return r109 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Success(pubKey=" + this.f163598a + ", privKey=" + this.f163599b + ", isPubKeyFromLocalSp=" + this.f163600c + ", phaseTimes=" + this.f163601d + ")";
        }

        public C2498b(PublicKey r100, PrivateKey r101, boolean r102, String r103) {
            this.f163598a = r100;
            this.f163599b = r101;
            this.f163600c = r102;
            this.f163601d = r103;
        }
    }

    public b() {
    }
}
