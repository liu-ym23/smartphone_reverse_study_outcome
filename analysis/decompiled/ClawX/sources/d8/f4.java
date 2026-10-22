package d8;

import java.util.function.Supplier;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class f4 {

    /* renamed from: a, reason: collision with root package name */
    public static final l3 f1995a;

    static {
        l3 l3Var = new l3(1);
        f1995a = l3Var;
        l3Var.g(1, "A", new g3(7));
        l3Var.g(2, "NS", new g3(9));
        final int i8 = 3;
        l3Var.g(3, "MD", new g3(21));
        l3Var.g(4, "MF", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i9 = 15;
        l3Var.g(5, "CNAME", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i10 = 27;
        l3Var.g(6, "SOA", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i11 = 0;
        l3Var.g(7, "MB", new Supplier() { // from class: d8.e4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return new c1();
                    case 1:
                        return new f1();
                    case 2:
                        return new i1();
                    case 3:
                        return new h1();
                    case 4:
                        return new v1();
                    case 5:
                        return new a4();
                    case 6:
                        return new s2();
                    case 7:
                        return new c();
                    default:
                        return new m4();
                }
            }
        });
        final int i12 = 1;
        l3Var.g(8, "MG", new Supplier() { // from class: d8.e4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return new c1();
                    case 1:
                        return new f1();
                    case 2:
                        return new i1();
                    case 3:
                        return new h1();
                    case 4:
                        return new v1();
                    case 5:
                        return new a4();
                    case 6:
                        return new s2();
                    case 7:
                        return new c();
                    default:
                        return new m4();
                }
            }
        });
        final int i13 = 3;
        l3Var.g(9, "MR", new Supplier() { // from class: d8.e4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return new c1();
                    case 1:
                        return new f1();
                    case 2:
                        return new i1();
                    case 3:
                        return new h1();
                    case 4:
                        return new v1();
                    case 5:
                        return new a4();
                    case 6:
                        return new s2();
                    case 7:
                        return new c();
                    default:
                        return new m4();
                }
            }
        });
        final int i14 = 4;
        l3Var.g(10, "NULL", new Supplier() { // from class: d8.e4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return new c1();
                    case 1:
                        return new f1();
                    case 2:
                        return new i1();
                    case 3:
                        return new h1();
                    case 4:
                        return new v1();
                    case 5:
                        return new a4();
                    case 6:
                        return new s2();
                    case 7:
                        return new c();
                    default:
                        return new m4();
                }
            }
        });
        l3Var.g(11, "WKS", new g3(18));
        l3Var.g(12, "PTR", new g3(29));
        final int i15 = 10;
        l3Var.g(13, "HINFO", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i15) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i16 = 21;
        l3Var.g(14, "MINFO", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i16) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i17 = 2;
        l3Var.g(15, "MX", new Supplier() { // from class: d8.e4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i17) {
                    case 0:
                        return new c1();
                    case 1:
                        return new f1();
                    case 2:
                        return new i1();
                    case 3:
                        return new h1();
                    case 4:
                        return new v1();
                    case 5:
                        return new a4();
                    case 6:
                        return new s2();
                    case 7:
                        return new c();
                    default:
                        return new m4();
                }
            }
        });
        final int i18 = 5;
        l3Var.g(16, "TXT", new Supplier() { // from class: d8.e4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i18) {
                    case 0:
                        return new c1();
                    case 1:
                        return new f1();
                    case 2:
                        return new i1();
                    case 3:
                        return new h1();
                    case 4:
                        return new v1();
                    case 5:
                        return new a4();
                    case 6:
                        return new s2();
                    case 7:
                        return new c();
                    default:
                        return new m4();
                }
            }
        });
        final int i19 = 6;
        l3Var.g(17, "RP", new Supplier() { // from class: d8.e4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i19) {
                    case 0:
                        return new c1();
                    case 1:
                        return new f1();
                    case 2:
                        return new i1();
                    case 3:
                        return new h1();
                    case 4:
                        return new v1();
                    case 5:
                        return new a4();
                    case 6:
                        return new s2();
                    case 7:
                        return new c();
                    default:
                        return new m4();
                }
            }
        });
        final int i20 = 7;
        l3Var.g(18, "AFSDB", new Supplier() { // from class: d8.e4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i20) {
                    case 0:
                        return new c1();
                    case 1:
                        return new f1();
                    case 2:
                        return new i1();
                    case 3:
                        return new h1();
                    case 4:
                        return new v1();
                    case 5:
                        return new a4();
                    case 6:
                        return new s2();
                    case 7:
                        return new c();
                    default:
                        return new m4();
                }
            }
        });
        final int i21 = 8;
        l3Var.g(19, "X25", new Supplier() { // from class: d8.e4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i21) {
                    case 0:
                        return new c1();
                    case 1:
                        return new f1();
                    case 2:
                        return new i1();
                    case 3:
                        return new h1();
                    case 4:
                        return new v1();
                    case 5:
                        return new a4();
                    case 6:
                        return new s2();
                    case 7:
                        return new c();
                    default:
                        return new m4();
                }
            }
        });
        l3Var.g(20, "ISDN", new g3(8));
        l3Var.g(21, "RT", new g3(10));
        l3Var.g(22, "NSAP", new g3(11));
        l3Var.g(23, "NSAP-PTR", new g3(12));
        l3Var.g(24, "SIG", new g3(13));
        l3Var.g(25, "KEY", new g3(14));
        l3Var.g(26, "PX", new g3(15));
        l3Var.g(27, "GPOS", new g3(16));
        l3Var.g(28, "AAAA", new g3(17));
        l3Var.g(29, "LOC", new g3(19));
        l3Var.g(30, "NXT", new g3(20));
        l3Var.a(31, "EID");
        l3Var.a(32, "NIMLOC");
        l3Var.g(33, "SRV", new g3(22));
        l3Var.a(34, "ATMA");
        l3Var.g(35, "NAPTR", new g3(23));
        l3Var.g(36, "KX", new g3(24));
        l3Var.g(37, "CERT", new g3(25));
        l3Var.g(38, "A6", new g3(26));
        l3Var.g(39, "DNAME", new g3(27));
        l3Var.a(40, "SINK");
        l3Var.g(41, "OPT", new g3(28));
        final int i22 = 0;
        l3Var.g(42, "APL", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i22) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i23 = 1;
        l3Var.g(43, "DS", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i23) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i24 = 2;
        l3Var.g(44, "SSHFP", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i24) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i25 = 4;
        l3Var.g(45, "IPSECKEY", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i25) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i26 = 5;
        l3Var.g(46, "RRSIG", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i26) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i27 = 6;
        l3Var.g(47, "NSEC", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i27) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i28 = 7;
        l3Var.g(48, "DNSKEY", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i28) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i29 = 8;
        l3Var.g(49, "DHCID", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i29) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i30 = 9;
        l3Var.g(50, "NSEC3", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i30) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i31 = 11;
        l3Var.g(51, "NSEC3PARAM", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i31) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i32 = 12;
        l3Var.g(52, "TLSA", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i32) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i33 = 13;
        l3Var.g(53, "SMIMEA", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i33) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i34 = 14;
        l3Var.g(55, "HIP", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i34) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        l3Var.a(56, "NINFO");
        l3Var.a(57, "RKEY");
        l3Var.a(58, "TALINK");
        final int i35 = 16;
        l3Var.g(59, "CDS", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i35) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i36 = 17;
        l3Var.g(60, "CDNSKEY", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i36) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i37 = 18;
        l3Var.g(61, "OPENPGPKEY", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i37) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        l3Var.a(62, "CSYNC");
        final int i38 = 19;
        l3Var.g(63, "ZONEMD", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i38) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i39 = 20;
        l3Var.g(64, "SVCB", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i39) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i40 = 22;
        l3Var.g(65, "HTTPS", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i40) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i41 = 23;
        l3Var.g(99, "SPF", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i41) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        l3Var.a(100, "UINFO");
        l3Var.a(101, "UID");
        l3Var.a(102, "GID");
        l3Var.a(103, "UNSPEC");
        l3Var.a(104, "NID");
        l3Var.a(105, "L32");
        l3Var.a(106, "L64");
        l3Var.a(107, "LP");
        l3Var.a(108, "EUI48");
        l3Var.a(109, "EUI64");
        final int i42 = 24;
        l3Var.g(249, "TKEY", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i42) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i43 = 25;
        l3Var.g(250, "TSIG", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i43) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        l3Var.a(251, "IXFR");
        l3Var.a(252, "AXFR");
        l3Var.a(253, "MAILB");
        l3Var.a(254, "MAILA");
        l3Var.a(255, "ANY");
        final int i44 = 26;
        l3Var.g(256, "URI", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i44) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        final int i45 = 28;
        l3Var.g(257, "CAA", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i45) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
        l3Var.a(258, "AVC");
        l3Var.a(259, "DOA");
        l3Var.a(260, "AMTRELAY");
        l3Var.a(32768, "TA");
        final int i46 = 29;
        l3Var.g(32769, "DLV", new Supplier() { // from class: d8.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i46) {
                    case 0:
                        return new e();
                    case 1:
                        return new y();
                    case 2:
                        return new f3();
                    case 3:
                        return new e1();
                    case 4:
                        return new v0();
                    case 5:
                        return new t2();
                    case 6:
                        return new s1();
                    case 7:
                        return new v();
                    case 8:
                        return new r();
                    case 9:
                        return new r1();
                    case 10:
                        return new q0();
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        return new p1();
                    case 12:
                        return new x3();
                    case BERTags.RELATIVE_OID /* 13 */:
                        return new b3();
                    case BERTags.TIME /* 14 */:
                        return new s0();
                    case 15:
                        return new k();
                    case 16:
                        return new i();
                    case 17:
                        return new h();
                    case BERTags.NUMERIC_STRING /* 18 */:
                        return new m2();
                    case 19:
                        return new o4();
                    case 20:
                        return new p3();
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        return new g1();
                    case BERTags.IA5_STRING /* 22 */:
                        return new t0();
                    case BERTags.UTC_TIME /* 23 */:
                        return new d3();
                    case 24:
                        return new w3();
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        return new y3();
                    case BERTags.VISIBLE_STRING /* 26 */:
                        j4 j4Var = new j4();
                        j4Var.f2041h = new byte[0];
                        return j4Var;
                    case BERTags.GENERAL_STRING /* 27 */:
                        return new c3();
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        return new g();
                    default:
                        return new s();
                }
            }
        });
    }

    public static void a(int i8) {
        if (i8 < 0 || i8 > 65535) {
            throw new x0(a8.b.j(i8, "Invalid DNS type: "));
        }
    }
}
