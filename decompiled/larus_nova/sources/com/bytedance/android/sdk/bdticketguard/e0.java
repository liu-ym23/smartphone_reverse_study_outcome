package com.bytedance.android.sdk.bdticketguard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f163645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f163646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f163647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f163648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f163649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f163650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final UUID f163651g;

    /* JADX INFO: loaded from: classes12.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f163652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f163653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f163654c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f163655d;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L28:
            return true;
        L5:
            if ((r100 instanceof a) == false) goto L27;
            a r101 = (a) r100;
            if (this.f163652a != r101.f163652a) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == false) goto L27;
            if (this.f163653b != r101.f163653b) goto L14;
            boolean r103 = true;
        L15:
            if (r103 == false) goto L27;
            if (this.f163654c != r101.f163654c) goto L19;
            boolean r104 = true;
        L20:
            if (r104 == false) goto L27;
            if (this.f163655d != r101.f163655d) goto L24;
            boolean r105 = true;
        L25:
            if (r105 == false) goto L27;
        L24:
            r105 = false;
            goto L25
        L19:
            r104 = false;
            goto L20
        L14:
            r103 = false;
            goto L15
        L9:
            r102 = false;
        L27:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public final int hashCode() {
            boolean r100 = this.f163652a;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = r102 * 31;
            boolean r104 = this.f163653b;
            ?? r105 = r104;
            if (r104 == false) goto L8;
            r105 = 1;
        L8:
            int r106 = (r103 + r105) * 31;
            boolean r107 = this.f163654c;
            ?? r108 = r107;
            if (r107 == false) goto L11;
            r108 = 1;
        L11:
            int r109 = (r106 + r108) * 31;
            boolean r110 = this.f163655d;
            if (r110 == true) goto L16;
            r101 = r110;
        L16:
            return r109 + r101;
        }

        public final String toString() {
            return "ConfigInfo(needTee=" + this.f163652a + ", needRee=" + this.f163653b + ", needHmac=" + this.f163654c + ", needAttestSign=" + this.f163655d + ")";
        }

        public a(int r100) {
            this.f163652a = false;
            this.f163653b = false;
            this.f163654c = false;
            this.f163655d = false;
        }
    }

    /* JADX INFO: loaded from: classes12.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.bytedance.android.sdk.bdticketguard.init.c f163656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.bytedance.android.sdk.bdticketguard.init.c f163657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f163658c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public l1 f163659d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public l1 f163660e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public l1 f163661f;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L18;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f163656a, r101.f163656a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f163657b, r101.f163657b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f163658c, r101.f163658c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f163659d, r101.f163659d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f163660e, r101.f163660e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f163661f, r101.f163661f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            com.bytedance.android.sdk.bdticketguard.init.c r100 = this.f163656a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            com.bytedance.android.sdk.bdticketguard.init.c r104 = this.f163657b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f163658c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            l1 r110 = this.f163659d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            l1 r113 = this.f163660e;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            l1 r116 = this.f163661f;
            if (r116 == null) goto L26;
            r101 = r116.hashCode();
        L26:
            return r115 + r101;
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
            return "ReeKeyInfo(reeInitResult=" + this.f163656a + ", encryptionInitResult=" + this.f163657b + ", publicKey=" + this.f163658c + ", containsAliasResult=" + this.f163659d + ", createKeyResult=" + this.f163660e + ", loadKeyResult=" + this.f163661f + ")";
        }

        public b(int r100) {
            this.f163656a = null;
            this.f163657b = null;
            this.f163658c = "";
            this.f163659d = null;
            this.f163660e = null;
            this.f163661f = null;
        }
    }

    /* JADX INFO: loaded from: classes12.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f163662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f163663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f163664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f163665d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f163666e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final byte[] f163667f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f163668g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f163669h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f163670i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f163671j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Throwable f163672k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Throwable f163673l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Throwable f163674m;

        public c() {
            this(0);
        }

        public final int hashCode() {
            String r100 = this.f163662a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            byte[] r104 = this.f163663b;
            if (r104 == null) goto L9;
            int r105 = Arrays.hashCode(r104);
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f163664c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            byte[] r110 = this.f163665d;
            if (r110 == null) goto L17;
            int r111 = Arrays.hashCode(r110);
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f163666e;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            byte[] r116 = this.f163667f;
            if (r116 == null) goto L25;
            int r117 = Arrays.hashCode(r116);
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.f163668g;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            long r122 = this.f163669h;
            int r123 = (((r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31) + this.f163670i) * 31;
            String r124 = this.f163671j;
            if (r124 == null) goto L33;
            int r125 = r124.hashCode();
        L34:
            int r126 = (r123 + r125) * 31;
            Throwable r127 = this.f163672k;
            if (r127 == null) goto L37;
            int r128 = r127.hashCode();
        L38:
            int r129 = (r126 + r128) * 31;
            Throwable r130 = this.f163673l;
            if (r130 == null) goto L41;
            int r131 = r130.hashCode();
        L42:
            int r132 = (r129 + r131) * 31;
            Throwable r133 = this.f163674m;
            if (r133 == null) goto L46;
            r101 = r133.hashCode();
        L46:
            return r132 + r101;
        L41:
            r131 = 0;
            goto L42
        L37:
            r128 = 0;
            goto L38
        L33:
            r125 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
            StringBuilder r100 = new StringBuilder("SignInfo(ticket=");
            String r101 = this.f163662a;
            int r102 = k0.f163802b;
            r100.append(p0.a(r101));
            r100.append(", teeSign=");
            r100.append(Arrays.toString(this.f163663b));
            r100.append(", teeSignBase64=");
            r100.append(p0.a(this.f163664c));
            r100.append(", reeSign=");
            r100.append(Arrays.toString(this.f163665d));
            r100.append(", reeSignBase64=");
            r100.append(p0.a(this.f163666e));
            r100.append(", hmacSign=");
            r100.append(Arrays.toString(this.f163667f));
            r100.append(", hmacSignBase64=");
            r100.append(p0.a(this.f163668g));
            r100.append(", timestamp=");
            r100.append(this.f163669h);
            r100.append(", retryCount=");
            r100.append(this.f163670i);
            r100.append(", path=");
            r100.append(this.f163671j);
            r100.append(", teeSignError=");
            r100.append(this.f163672k);
            r100.append(", reeSignError=");
            r100.append(this.f163673l);
            r100.append(", hmacSignError=");
            r100.append(this.f163674m);
            r100.append(")");
            return r100.toString();
        }

        public c(int r100) {
            int r101 = k0.f163802b;
            this.f163662a = "";
            this.f163663b = null;
            this.f163664c = "";
            this.f163665d = null;
            this.f163666e = "";
            this.f163667f = null;
            this.f163668g = "";
            this.f163669h = 0;
            this.f163670i = 0;
            this.f163671j = "";
            this.f163672k = null;
            this.f163673l = null;
            this.f163674m = null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L40:
            return true;
        L5:
            if ((r100 instanceof c) == false) goto L39;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(new k0(this.f163662a), new k0(r101.f163662a)) == false) goto L39;
            if (Intrinsics.areEqual(this.f163663b, r101.f163663b) == false) goto L39;
            if (Intrinsics.areEqual(new k0(this.f163664c), new k0(r101.f163664c)) == false) goto L39;
            if (Intrinsics.areEqual(this.f163665d, r101.f163665d) == false) goto L39;
            if (Intrinsics.areEqual(new k0(this.f163666e), new k0(r101.f163666e)) == false) goto L39;
            if (Intrinsics.areEqual(this.f163667f, r101.f163667f) == false) goto L39;
            if (Intrinsics.areEqual(new k0(this.f163668g), new k0(r101.f163668g)) == false) goto L39;
            if (this.f163669h != r101.f163669h) goto L23;
            boolean r102 = true;
        L24:
            if (r102 == false) goto L39;
            if (this.f163670i != r101.f163670i) goto L28;
            boolean r103 = true;
        L29:
            if (r103 == false) goto L39;
            if (Intrinsics.areEqual(this.f163671j, r101.f163671j) == false) goto L39;
            if (Intrinsics.areEqual(this.f163672k, r101.f163672k) == false) goto L39;
            if (Intrinsics.areEqual(this.f163673l, r101.f163673l) == false) goto L39;
            if (Intrinsics.areEqual(this.f163674m, r101.f163674m) == false) goto L39;
        L28:
            r103 = false;
            goto L29
        L23:
            r102 = false;
        L39:
            return false;
        }
    }

    /* JADX INFO: loaded from: classes12.dex */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.bytedance.android.sdk.bdticketguard.init.c f163675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f163676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f163677c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f163678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f163679e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f163680f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Boolean f163681g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public l1 f163682h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public l1 f163683i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public l1 f163684j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public com.bytedance.android.sdk.bdticketguard.data.d f163685k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public v f163686l;

        public d() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L30;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f163675a, r101.f163675a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f163676b, r101.f163676b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f163677c, r101.f163677c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f163678d, r101.f163678d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f163679e, r101.f163679e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f163680f, r101.f163680f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f163681g, r101.f163681g) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.f163682h, r101.f163682h) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.f163683i, r101.f163683i) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f163684j, r101.f163684j) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.f163685k, r101.f163685k) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.f163686l, r101.f163686l) == true) goto L46;
            return false;
        L46:
            return true;
        L30:
            return false;
        }

        public final int hashCode() {
            com.bytedance.android.sdk.bdticketguard.init.c r100 = this.f163675a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f163676b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f163677c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f163678d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f163679e;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            Boolean r116 = this.f163680f;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            Boolean r119 = this.f163681g;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            l1 r122 = this.f163682h;
            if (r122 == null) goto L33;
            int r123 = r122.hashCode();
        L34:
            int r124 = (r121 + r123) * 31;
            l1 r125 = this.f163683i;
            if (r125 == null) goto L37;
            int r126 = r125.hashCode();
        L38:
            int r127 = (r124 + r126) * 31;
            l1 r128 = this.f163684j;
            if (r128 == null) goto L41;
            int r129 = r128.hashCode();
        L42:
            int r130 = (r127 + r129) * 31;
            com.bytedance.android.sdk.bdticketguard.data.d r131 = this.f163685k;
            if (r131 == null) goto L45;
            int r132 = r131.hashCode();
        L46:
            int r133 = (r130 + r132) * 31;
            v r134 = this.f163686l;
            if (r134 == null) goto L50;
            r101 = r134.hashCode();
        L50:
            return r133 + r101;
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
            return "TeeKeyInfo(initResult=" + this.f163675a + ", publicKey=" + this.f163676b + ", credential=" + this.f163677c + ", certType=" + this.f163678d + ", reason=" + this.f163679e + ", isNewKey=" + this.f163680f + ", isTeeEverFail=" + this.f163681g + ", containsAliasResult=" + this.f163682h + ", createKeyResult=" + this.f163683i + ", loadKeyResult=" + this.f163684j + ", keyExtras=" + this.f163685k + ", createLog=" + this.f163686l + ")";
        }

        public d(int r100) {
            this.f163675a = null;
            this.f163676b = "";
            this.f163677c = "";
            this.f163678d = "";
            this.f163679e = "";
            this.f163680f = null;
            this.f163681g = null;
            this.f163682h = null;
            this.f163683i = null;
            this.f163684j = null;
            this.f163685k = null;
            this.f163686l = null;
        }
    }

    /* JADX INFO: loaded from: classes12.dex */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f163687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f163688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f163689c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f163690d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public f f163691e;

        public e() {
            this(0);
        }

        public final int hashCode() {
            String r100 = this.f163687a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f163688b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f163689c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f163690d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            f r113 = this.f163691e;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return r112 + r101;
        L17:
            r111 = 0;
            goto L18
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
            StringBuilder r100 = new StringBuilder("TicketAndTsSign(ticket=");
            String r101 = this.f163687a;
            int r102 = k0.f163802b;
            r100.append(p0.a(r101));
            r100.append(", tsSign=");
            r100.append(p0.a(this.f163688b));
            r100.append(", tsSignRee=");
            r100.append(p0.a(this.f163689c));
            r100.append(", attestTsSign=");
            r100.append(p0.a(this.f163690d));
            r100.append(", ticketAssociateInfo=");
            r100.append(this.f163691e);
            r100.append(")");
            return r100.toString();
        }

        public e(int r100) {
            int r101 = k0.f163802b;
            this.f163687a = "";
            this.f163688b = "";
            this.f163689c = "";
            this.f163690d = "";
            this.f163691e = null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == false) goto L16;
            e r101 = (e) r100;
            if (Intrinsics.areEqual(new k0(this.f163687a), new k0(r101.f163687a)) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(new k0(this.f163688b), new k0(r101.f163688b)) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(new k0(this.f163689c), new k0(r101.f163689c)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(new k0(this.f163690d), new k0(r101.f163690d)) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f163691e, r101.f163691e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f163692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f163693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f163694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f163695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f163696e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f163697f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f163698g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L25:
            return true;
        L5:
            if ((r100 instanceof f) == false) goto L24;
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f163692a, r101.f163692a) == false) goto L24;
            if (Intrinsics.areEqual(this.f163693b, r101.f163693b) == false) goto L24;
            if (Intrinsics.areEqual(this.f163694c, r101.f163694c) == false) goto L24;
            if (Intrinsics.areEqual(this.f163695d, r101.f163695d) == false) goto L24;
            if (Intrinsics.areEqual(this.f163696e, r101.f163696e) == false) goto L24;
            if (Intrinsics.areEqual(this.f163697f, r101.f163697f) == false) goto L24;
            if (this.f163698g != r101.f163698g) goto L21;
            boolean r102 = true;
        L22:
            if (r102 == false) goto L24;
        L21:
            r102 = false;
        L24:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f163692a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f163693b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f163694c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f163695d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f163696e;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.f163697f;
            if (r116 == null) goto L26;
            r101 = r116.hashCode();
        L26:
            return ((r115 + r101) * 31) + this.f163698g;
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
            return "TicketAssociateInfo(tsSignTeePubKey=" + this.f163692a + ", tsSignReePubKey=" + this.f163693b + ", sourcePath=" + this.f163694c + ", sourceLogId=" + this.f163695d + ", updateAttestSignPath=" + this.f163696e + ", updateAttestSignLogId=" + this.f163697f + ", trackDataVersion=" + this.f163698g + ")";
        }

        public f() {
            this("", "", "", "", "", "", 0);
        }

        public f(String r100, String r101, String r102, String r103, String r104, String r105, int r106) {
            this.f163692a = r100;
            this.f163693b = r101;
            this.f163694c = r102;
            this.f163695d = r103;
            this.f163696e = r104;
            this.f163697f = r105;
            this.f163698g = r106;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f163699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f163700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f163701c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f163702d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, ? extends Object> f163703e;

        public g() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L30:
            return true;
        L5:
            if ((r100 instanceof g) == false) goto L29;
            g r101 = (g) r100;
            if (this.f163699a != r101.f163699a) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == false) goto L29;
            if (this.f163700b != r101.f163700b) goto L14;
            boolean r103 = true;
        L15:
            if (r103 == false) goto L29;
            if (this.f163701c != r101.f163701c) goto L19;
            boolean r104 = true;
        L20:
            if (r104 == false) goto L29;
            if (this.f163702d != r101.f163702d) goto L24;
            boolean r105 = true;
        L25:
            if (r105 == false) goto L29;
            if (Intrinsics.areEqual(this.f163703e, r101.f163703e) == false) goto L29;
        L24:
            r105 = false;
            goto L25
        L19:
            r104 = false;
            goto L20
        L14:
            r103 = false;
            goto L15
        L9:
            r102 = false;
        L29:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f163699a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f163700b) * 31;
            long r102 = this.f163701c;
            int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f163702d) * 31;
            Map<String, ? extends Object> r104 = this.f163703e;
            if (r104 == null) goto L5;
            int r105 = r104.hashCode();
        L7:
            return r103 + r105;
        L5:
            r105 = 0;
            goto L7
        }

        public final String toString() {
            return "TimeStampInfo(timestamp=" + this.f163699a + ", timestampSource=" + this.f163700b + ", serverTimestamp=" + this.f163701c + ", flags=" + this.f163702d + ", extraParams=" + this.f163703e + ")";
        }

        public g(Object r100) {
            Map<String, ? extends Object> r101 = MapsKt.emptyMap();
            this.f163699a = 0;
            this.f163700b = 0;
            this.f163701c = 0;
            this.f163702d = 0;
            this.f163703e = r101;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e0) == false) goto L20;
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f163645a, r101.f163645a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f163646b, r101.f163646b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f163647c, r101.f163647c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f163648d, r101.f163648d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f163649e, r101.f163649e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f163650f, r101.f163650f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f163651g, r101.f163651g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        e r100 = this.f163645a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a r104 = this.f163646b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        d r107 = this.f163647c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        b r110 = this.f163648d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        c r113 = this.f163649e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        g r116 = this.f163650f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        UUID r119 = this.f163651g;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "RequestContext(ticketAndTsSign=" + this.f163645a + ", configInfo=" + this.f163646b + ", teeKeyInfo=" + this.f163647c + ", reeKeyInfo=" + this.f163648d + ", signInfo=" + this.f163649e + ", timestampInfo=" + this.f163650f + ", uuid=" + this.f163651g + ")";
    }

    public e0() {
        e r100 = new e(0);
        a r101 = new a(0);
        d r102 = new d(0);
        b r103 = new b(0);
        c r104 = new c(0);
        g r105 = new g(null);
        UUID r106 = UUID.randomUUID();
        this.f163645a = r100;
        this.f163646b = r101;
        this.f163647c = r102;
        this.f163648d = r103;
        this.f163649e = r104;
        this.f163650f = r105;
        this.f163651g = r106;
    }

    public final Pair<Boolean, String> a() {
        ArrayList r100 = new ArrayList();
        e r101 = this.f163645a;
        String r102 = this.f163647c.f163676b;
        r101.getClass();
        ArrayList r103 = new ArrayList();
        if (k0.a(r101.f163687a) == false) goto L6;
        r103.add("ticket is empty");
    L6:
        if (k0.a(r101.f163688b) == false) goto L9;
        r103.add("tsSign is empty");
    L9:
        if (k0.a(r101.f163689c) == false) goto L11;
        r103.add("tsSignRee is empty");
    L11:
        f r104 = r101.f163691e;
        boolean r110 = false;
        String r111 = "";
        if (r104 == null) goto L38;
        RequestContext$TicketAssociateInfo$hasAnomalies$1 r105 = RequestContext$TicketAssociateInfo$hasAnomalies$1.INSTANCE;
        ArrayList r106 = new ArrayList();
        if (r104.f163694c.length() != 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L20;
        r106.add("sourcePath is empty");
    L20:
        if (r104.f163695d.length() != 0) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == false) goto L120;
        r106.add("sourceLogId is empty");
    L120:
    L29:
        e = move-exception;
        int r109 = r0.f163979a;
        r0.d(6, "TicketAssociateInfo", "tsSignTeePubKey base64 decode error, currentTeePubKey: " + r102 + ", tsSignTeePubKey: " + r104.f163692a, e);
        r106.add("tsSignTeePubKey base64 decode error, currentTeePubKey: " + r102 + ", tsSignTeePubKey: " + r104.f163692a);
    L31:
        boolean r112 = !r106.isEmpty();
        if (r112 == false) goto L34;
        String r113 = CollectionsKt.joinToString$default(r106, ", ", null, null, 0, null, null, 62, null);
    L35:
        Pair r114 = new Pair(Boolean.valueOf(r112), r113);
        boolean r115 = ((Boolean) r114.component1()).booleanValue();
        String r116 = (String) r114.component2();
        if (r115 == false) goto L38;
        r103.add("TicketAssociateInfo: " + r116);
        goto L38
    L34:
        r113 = "";
        goto L35
    L26:
        if (r105.invoke2(r102, r104.f163692a) == true) goto L31;
        r106.add("tsSignTeePubKey mismatch (current: " + r102 + ", tsSign: " + r104.f163692a + ')');     // Catch: Exception -> L29
        goto L31
    L22:
        r108 = false;
        goto L23
    L16:
        r107 = false;
    L38:
        boolean r117 = !r103.isEmpty();
        if (r117 == false) goto L41;
        String r118 = CollectionsKt.joinToString$default(r103, ", ", null, null, 0, null, null, 62, null);
    L42:
        Pair r119 = new Pair(Boolean.valueOf(r117), r118);
        boolean r120 = ((Boolean) r119.component1()).booleanValue();
        String r121 = (String) r119.component2();
        if (r120 == false) goto L45;
        r100.add("TicketAndTsSign: " + r121);
    L45:
        c r122 = this.f163649e;
        r122.getClass();
        ArrayList r123 = new ArrayList();
        if (r122.f163672k == null) goto L49;
        r123.add("signError");
    L49:
        if (r122.f163663b != null) goto L52;
        r123.add("sign is null");
    L52:
        if (k0.a(r122.f163664c) == false) goto L55;
        r123.add("signBase64 is empty");
    L55:
        if (k0.a(r122.f163666e) == true) goto L57;
    L59:
        boolean r124 = !r123.isEmpty();
        if (r124 == false) goto L62;
        String r125 = CollectionsKt.joinToString$default(r123, ", ", null, null, 0, null, null, 62, null);
    L63:
        Pair r126 = new Pair(Boolean.valueOf(r124), r125);
        boolean r127 = ((Boolean) r126.component1()).booleanValue();
        String r128 = (String) r126.component2();
        if (r127 == false) goto L66;
        r100.add("SignInfo: " + r128);
    L66:
        d r129 = this.f163647c;
        r129.getClass();
        ArrayList r130 = new ArrayList();
        if ((!Intrinsics.areEqual(r129.f163675a, com.bytedance.android.sdk.bdticketguard.init.c.g.f163778b)) == false) goto L70;
        r130.add("initResult is " + r129.f163675a);
    L70:
        if (r129.f163676b.length() != 0) goto L72;
        boolean r131 = true;
    L73:
        if (r131 == false) goto L76;
        r130.add("publicKey is empty");
    L76:
        if (r129.f163677c.length() != 0) goto L78;
        boolean r132 = true;
    L79:
        if (r132 == false) goto L81;
        r130.add("credential is empty");
    L81:
        l1 r133 = r129.f163682h;
        if (r133 == null) goto L84;
        boolean r134 = r133.a();
    L85:
        if (r134 == true) goto L87;
        r130.add("containsAliasError");
    L87:
        l1 r135 = r129.f163684j;
        if (r135 == null) goto L90;
        boolean r136 = r135.a();
    L91:
        if (r136 == true) goto L108;
        l1 r137 = r129.f163683i;
        if (r137 == null) goto L95;
        boolean r138 = r137.a();
    L96:
        if (r138 == true) goto L108;
        l1 r139 = r129.f163684j;
        if (r139 == null) goto L100;
        boolean r140 = r139.a();
    L101:
        if (r140 == true) goto L103;
        r130.add("loadKeyError");
    L103:
        l1 r141 = r129.f163683i;
        if (r141 == null) goto L106;
        r110 = r141.a();
    L106:
        if (r110 == true) goto L108;
        r130.add("createKeyError");
        goto L108
    L100:
        r140 = false;
        goto L101
    L95:
        r138 = false;
    L108:
        boolean r142 = !r130.isEmpty();
        if (r142 == false) goto L111;
        String r143 = CollectionsKt.joinToString$default(r130, ", ", null, null, 0, null, null, 62, null);
    L112:
        Pair r144 = new Pair(Boolean.valueOf(r142), r143);
        boolean r145 = ((Boolean) r144.component1()).booleanValue();
        String r146 = (String) r144.component2();
        if (r145 == false) goto L115;
        r100.add("TeeKeyInfo: " + r146);
    L115:
        boolean r147 = !r100.isEmpty();
        if (r147 == false) goto L119;
        r111 = CollectionsKt.joinToString$default(r100, "; ", null, null, 0, null, null, 62, null);
    L119:
        return new Pair(Boolean.valueOf(r147), r111);
    L111:
        r143 = "";
        goto L112
    L90:
        r136 = false;
        goto L91
    L84:
        r134 = false;
        goto L85
    L78:
        r132 = false;
        goto L79
    L72:
        r131 = false;
        goto L73
    L62:
        r125 = "";
        goto L63
    L57:
        if (k0.a(r122.f163668g) == false) goto L59;
        r123.add("ree,hmacSignBase64 is empty");
        goto L59
    L41:
        r118 = "";
        goto L42
    }
}
