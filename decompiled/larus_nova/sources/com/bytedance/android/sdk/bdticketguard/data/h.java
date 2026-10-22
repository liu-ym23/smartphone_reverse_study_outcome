package com.bytedance.android.sdk.bdticketguard.data;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class h {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Pair<String, Throwable>> f163632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f163633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f163634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f163635d;

        public a() {
            throw null;
        }

        public final int hashCode() {
            List<Pair<String, Throwable>> r100 = this.f163632a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            long r103 = this.f163633b;
            int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            List<String> r105 = this.f163634c;
            if (r105 == null) goto L9;
            int r106 = r105.hashCode();
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f163635d;
            if (r108 == null) goto L14;
            r101 = r108.hashCode();
        L14:
            return r107 + r101;
        L9:
            r106 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Failed(failedMethods=" + this.f163632a + ", durationNs=" + this.f163633b + ", enabledMethods=" + this.f163634c + ", phaseTimes=" + this.f163635d + ")";
        }

        @Override // com.bytedance.android.sdk.bdticketguard.data.h
        public final long a() {
            return this.f163633b;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.data.h
        public final List<String> b() {
            return this.f163634c;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.data.h
        public final List<Pair<String, Throwable>> c() {
            return this.f163632a;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.data.h
        public final String d() {
            return this.f163635d;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L19:
            return true;
        L5:
            if ((r100 instanceof a) == false) goto L18;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f163632a, r101.f163632a) == false) goto L18;
            if (this.f163633b != r101.f163633b) goto L11;
            boolean r102 = true;
        L12:
            if (r102 == false) goto L18;
            if (Intrinsics.areEqual(this.f163634c, r101.f163634c) == false) goto L18;
            if (Intrinsics.areEqual(this.f163635d, r101.f163635d) == false) goto L18;
        L11:
            r102 = false;
        L18:
            return false;
        }

        public a(List r100, long r101, List r102) {
            this.f163632a = r100;
            this.f163633b = r101;
            this.f163634c = r102;
            this.f163635d = null;
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PublicKey f163636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PrivateKey f163637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f163638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f163639d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f163640e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<Pair<String, Throwable>> f163641f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f163642g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<String> f163643h;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        public final int hashCode() {
            PublicKey r100 = this.f163636a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            PrivateKey r104 = this.f163637b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f163638c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            boolean r110 = this.f163639d;
            ?? r111 = r110;
            if (r110 == false) goto L17;
            r111 = 1;
        L17:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f163640e;
            if (r113 == null) goto L20;
            int r114 = r113.hashCode();
        L21:
            int r115 = (r112 + r114) * 31;
            List<Pair<String, Throwable>> r116 = this.f163641f;
            if (r116 == null) goto L24;
            int r117 = r116.hashCode();
        L25:
            int r118 = (r115 + r117) * 31;
            long r119 = this.f163642g;
            int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
            List<String> r121 = this.f163643h;
            if (r121 == null) goto L29;
            r101 = r121.hashCode();
        L29:
            return r120 + r101;
        L24:
            r117 = 0;
            goto L25
        L20:
            r114 = 0;
            goto L21
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Success(pubKey=" + this.f163636a + ", privKey=" + this.f163637b + ", keySource=" + this.f163638c + ", isPubKeyFromLocalSp=" + this.f163639d + ", phaseTimes=" + this.f163640e + ", failedMethods=" + this.f163641f + ", durationNs=" + this.f163642g + ", enabledMethods=" + this.f163643h + ")";
        }

        @Override // com.bytedance.android.sdk.bdticketguard.data.h
        public final long a() {
            return this.f163642g;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.data.h
        public final List<String> b() {
            return this.f163643h;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.data.h
        public final List<Pair<String, Throwable>> c() {
            return this.f163641f;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.data.h
        public final String d() {
            return this.f163640e;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L30:
            return true;
        L5:
            if ((r100 instanceof b) == false) goto L29;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f163636a, r101.f163636a) == false) goto L29;
            if (Intrinsics.areEqual(this.f163637b, r101.f163637b) == false) goto L29;
            if (Intrinsics.areEqual(this.f163638c, r101.f163638c) == false) goto L29;
            if (this.f163639d != r101.f163639d) goto L15;
            boolean r102 = true;
        L16:
            if (r102 == false) goto L29;
            if (Intrinsics.areEqual(this.f163640e, r101.f163640e) == false) goto L29;
            if (Intrinsics.areEqual(this.f163641f, r101.f163641f) == false) goto L29;
            if (this.f163642g != r101.f163642g) goto L24;
            boolean r103 = true;
        L25:
            if (r103 == false) goto L29;
            if (Intrinsics.areEqual(this.f163643h, r101.f163643h) == false) goto L29;
        L24:
            r103 = false;
            goto L25
        L15:
            r102 = false;
        L29:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(PublicKey r100, PrivateKey r101, String r102, boolean r103, String r104, List<? extends Pair<String, ? extends Throwable>> r105, long r106, List<String> r107) {
            this.f163636a = r100;
            this.f163637b = r101;
            this.f163638c = r102;
            this.f163639d = r103;
            this.f163640e = r104;
            this.f163641f = r105;
            this.f163642g = r106;
            this.f163643h = r107;
        }
    }

    public h() {
    }

    public abstract long a();

    public abstract List<String> b();

    public abstract List<Pair<String, Throwable>> c();

    public abstract String d();
}
