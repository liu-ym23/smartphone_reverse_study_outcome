package Nb;

import La.C0951a;
import La.D;
import La.H;
import Mb.InterfaceC0968f;
import Mb.z;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a5\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0000¢\u0006\u0004\b\t\u0010\n\u001a)\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0011\u001a\u00020\u0005*\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0017\u001a\u00020\u0013*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a5\u0010\u001f\u001a\u00020\u001d*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u0013\u0010!\u001a\u00020\u001d*\u00020\u0010H\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001b\u0010$\u001a\u00020\u0005*\u00020\u00102\u0006\u0010#\u001a\u00020\u0005H\u0000¢\u0006\u0004\b$\u0010%\u001a\u001f\u0010&\u001a\u0004\u0018\u00010\u0005*\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b&\u0010%\u001a\u0017\u0010(\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001cH\u0000¢\u0006\u0004\b(\u0010)\u001a!\u0010,\u001a\u0004\u0018\u00010\u001c2\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0019H\u0000¢\u0006\u0004\b,\u0010-\"\u0018\u00101\u001a\u00020.*\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"LMb/z;", "zipPath", "LMb/i;", "fileSystem", "Lkotlin/Function1;", "LNb/n;", "", "predicate", "LMb/L;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LMb/z;LMb/i;Lp9/l;)LMb/L;", "", "entries", "", Const.INTENT_KEY_UMID, "(Ljava/util/List;)Ljava/util/Map;", "LMb/f;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LMb/f;)LNb/n;", "LNb/i;", "l", "(LMb/f;)LNb/i;", "regularRecord", "q", "(LMb/f;LNb/i;)LNb/i;", "", "extraSize", "Lkotlin/Function2;", "", "LY8/t;", "block", "m", "(LMb/f;ILp9/p;)V", "r", "(LMb/f;)V", "centralDirectoryZipEntry", "n", "(LMb/f;LNb/n;)LNb/n;", "o", "filetime", "f", "(J)J", "date", "time", "e", "(II)Ljava/lang/Long;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Ljava/lang/String;", "hex", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class r {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(((n) t10).getCanonicalPath(), ((n) t11).getCanonicalPath());
        }
    }

    public static final Map<z, n> d(List<n> list) {
        z zVarE = z.Companion.e(z.INSTANCE, "/", false, 1, null);
        Map<z, n> mapP = kotlin.collections.a.p(Y8.j.a(zVarE, new n(zVarE, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null)));
        for (n nVar : F.c1(list, new a())) {
            if (mapP.put(nVar.getCanonicalPath(), nVar) == null) {
                while (true) {
                    z zVarK = nVar.getCanonicalPath().k();
                    if (zVarK != null) {
                        n nVar2 = mapP.get(zVarK);
                        if (nVar2 != null) {
                            nVar2.c().add(nVar.getCanonicalPath());
                            break;
                        }
                        n nVar3 = new n(zVarK, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null);
                        mapP.put(zVarK, nVar3);
                        nVar3.c().add(nVar.getCanonicalPath());
                        nVar = nVar3;
                    }
                }
            }
        }
        return mapP;
    }

    public static final Long e(int i10, int i11) {
        if (i11 == -1) {
            return null;
        }
        return Long.valueOf(v.a(((i10 >> 9) & 127) + 1980, (i10 >> 5) & 15, i10 & 31, (i11 >> 11) & 31, (i11 >> 5) & 63, (i11 & 31) << 1));
    }

    public static final long f(long j10) {
        return (j10 / 10000) - 11644473600000L;
    }

    public static final String g(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("0x");
        String string = Integer.toString(i10, C0951a.a(16));
        kotlin.jvm.internal.p.h(string, "toString(...)");
        sb2.append(string);
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00de A[Catch: all -> 0x00df, TRY_ENTER, TryCatch #13 {all -> 0x00df, blocks: (B:13:0x0062, B:15:0x006b, B:18:0x007c, B:43:0x00de, B:46:0x00e2, B:47:0x00e9, B:48:0x00ea), top: B:139:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010b A[Catch: all -> 0x0103, TryCatch #1 {all -> 0x0103, blocks: (B:3:0x0019, B:5:0x0027, B:6:0x0030, B:10:0x004e, B:12:0x005a, B:65:0x010b, B:59:0x00ff, B:66:0x010c, B:93:0x016e, B:97:0x017f, B:90:0x0168, B:100:0x0182, B:103:0x018e, B:104:0x0195, B:105:0x0196, B:106:0x0199, B:107:0x019a, B:108:0x01b4, B:7:0x0038, B:9:0x0041, B:67:0x011d, B:70:0x0125, B:72:0x0135, B:74:0x0141, B:77:0x0148, B:78:0x014c, B:79:0x0153, B:80:0x0154, B:87:0x0161, B:56:0x00f8), top: B:118:0x0019, inners: #0, #2, #3, #12 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final Mb.L h(Mb.z r18, Mb.AbstractC0971i r19, p9.InterfaceC5074l<? super Nb.n, java.lang.Boolean> r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Nb.r.h(Mb.z, Mb.i, p9.l):Mb.L");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final n i(final InterfaceC0968f interfaceC0968f) throws IOException {
        kotlin.jvm.internal.p.i(interfaceC0968f, "<this>");
        int iE1 = interfaceC0968f.e1();
        if (iE1 != 33639248) {
            throw new IOException("bad zip: expected " + g(33639248) + " but was " + g(iE1));
        }
        interfaceC0968f.skip(4L);
        short sL0 = interfaceC0968f.l0();
        int i10 = sL0 & 65535;
        if ((sL0 & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + g(i10));
        }
        int iL0 = interfaceC0968f.l0() & 65535;
        int iL02 = interfaceC0968f.l0() & 65535;
        int iL03 = interfaceC0968f.l0() & 65535;
        long jE1 = interfaceC0968f.e1() & 4294967295L;
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.f34819a = interfaceC0968f.e1() & 4294967295L;
        final Ref$LongRef ref$LongRef2 = new Ref$LongRef();
        ref$LongRef2.f34819a = interfaceC0968f.e1() & 4294967295L;
        int iL04 = interfaceC0968f.l0() & 65535;
        int iL05 = interfaceC0968f.l0() & 65535;
        int iL06 = interfaceC0968f.l0() & 65535;
        interfaceC0968f.skip(8L);
        final Ref$LongRef ref$LongRef3 = new Ref$LongRef();
        ref$LongRef3.f34819a = interfaceC0968f.e1() & 4294967295L;
        String strX0 = interfaceC0968f.x0(iL04);
        if (H.f0(strX0, (char) 0, false, 2, null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long j10 = ref$LongRef2.f34819a == 4294967295L ? 8 : 0L;
        if (ref$LongRef.f34819a == 4294967295L) {
            j10 += 8;
        }
        if (ref$LongRef3.f34819a == 4294967295L) {
            j10 += 8;
        }
        final long j11 = j10;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        m(interfaceC0968f, iL05, new p9.p() { // from class: Nb.p
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return r.j(ref$BooleanRef, j11, ref$LongRef2, interfaceC0968f, ref$LongRef, ref$LongRef3, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
            }
        });
        if (j11 <= 0 || ref$BooleanRef.f34815a) {
            return new n(z.Companion.e(z.INSTANCE, "/", false, 1, null).n(strX0), D.K(strX0, "/", false, 2, null), interfaceC0968f.x0(iL06), jE1, ref$LongRef.f34819a, ref$LongRef2.f34819a, iL0, ref$LongRef3.f34819a, iL03, iL02, (Long) ref$ObjectRef.f34820a, (Long) ref$ObjectRef2.f34820a, (Long) ref$ObjectRef3.f34820a, null, null, null, 57344, null);
        }
        throw new IOException("bad zip: zip64 extra required but absent");
    }

    public static final Y8.t j(Ref$BooleanRef ref$BooleanRef, long j10, Ref$LongRef ref$LongRef, final InterfaceC0968f interfaceC0968f, Ref$LongRef ref$LongRef2, Ref$LongRef ref$LongRef3, final Ref$ObjectRef ref$ObjectRef, final Ref$ObjectRef ref$ObjectRef2, final Ref$ObjectRef ref$ObjectRef3, int i10, long j11) throws IOException {
        if (i10 != 1) {
            if (i10 == 10) {
                if (j11 < 4) {
                    throw new IOException("bad zip: NTFS extra too short");
                }
                interfaceC0968f.skip(4L);
                m(interfaceC0968f, (int) (j11 - 4), new p9.p() { // from class: Nb.q
                    @Override // p9.p
                    public final Object invoke(Object obj, Object obj2) {
                        return r.k(ref$ObjectRef, interfaceC0968f, ref$ObjectRef2, ref$ObjectRef3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
                    }
                });
            }
        } else {
            if (ref$BooleanRef.f34815a) {
                throw new IOException("bad zip: zip64 extra repeated");
            }
            ref$BooleanRef.f34815a = true;
            if (j11 < j10) {
                throw new IOException("bad zip: zip64 extra too short");
            }
            long jO0 = ref$LongRef.f34819a;
            if (jO0 == 4294967295L) {
                jO0 = interfaceC0968f.o0();
            }
            ref$LongRef.f34819a = jO0;
            ref$LongRef2.f34819a = ref$LongRef2.f34819a == 4294967295L ? interfaceC0968f.o0() : 0L;
            ref$LongRef3.f34819a = ref$LongRef3.f34819a == 4294967295L ? interfaceC0968f.o0() : 0L;
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Long] */
    public static final Y8.t k(Ref$ObjectRef ref$ObjectRef, InterfaceC0968f interfaceC0968f, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, int i10, long j10) throws IOException {
        if (i10 == 1) {
            if (ref$ObjectRef.f34820a != 0) {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
            }
            if (j10 != 24) {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
            }
            ref$ObjectRef.f34820a = Long.valueOf(interfaceC0968f.o0());
            ref$ObjectRef2.f34820a = Long.valueOf(interfaceC0968f.o0());
            ref$ObjectRef3.f34820a = Long.valueOf(interfaceC0968f.o0());
        }
        return Y8.t.f7040a;
    }

    public static final i l(InterfaceC0968f interfaceC0968f) throws IOException {
        int iL0 = interfaceC0968f.l0() & 65535;
        int iL02 = interfaceC0968f.l0() & 65535;
        long jL0 = interfaceC0968f.l0() & 65535;
        if (jL0 != (interfaceC0968f.l0() & 65535) || iL0 != 0 || iL02 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        interfaceC0968f.skip(4L);
        return new i(jL0, 4294967295L & interfaceC0968f.e1(), interfaceC0968f.l0() & 65535);
    }

    public static final void m(InterfaceC0968f interfaceC0968f, int i10, p9.p<? super Integer, ? super Long, Y8.t> pVar) throws IOException {
        long j10 = i10;
        while (j10 != 0) {
            if (j10 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int iL0 = interfaceC0968f.l0() & 65535;
            long jL0 = interfaceC0968f.l0() & 65535;
            long j11 = j10 - 4;
            if (j11 < jL0) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            interfaceC0968f.j(jL0);
            long size = interfaceC0968f.getBufferField().getSize();
            pVar.invoke(Integer.valueOf(iL0), Long.valueOf(jL0));
            long size2 = (interfaceC0968f.getBufferField().getSize() + jL0) - size;
            if (size2 < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + iL0);
            }
            if (size2 > 0) {
                interfaceC0968f.getBufferField().skip(size2);
            }
            j10 = j11 - jL0;
        }
    }

    public static final n n(InterfaceC0968f interfaceC0968f, n centralDirectoryZipEntry) throws IOException {
        kotlin.jvm.internal.p.i(interfaceC0968f, "<this>");
        kotlin.jvm.internal.p.i(centralDirectoryZipEntry, "centralDirectoryZipEntry");
        n nVarO = o(interfaceC0968f, centralDirectoryZipEntry);
        kotlin.jvm.internal.p.f(nVarO);
        return nVarO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final n o(final InterfaceC0968f interfaceC0968f, n nVar) throws IOException {
        int iE1 = interfaceC0968f.e1();
        if (iE1 != 67324752) {
            throw new IOException("bad zip: expected " + g(67324752) + " but was " + g(iE1));
        }
        interfaceC0968f.skip(2L);
        short sL0 = interfaceC0968f.l0();
        int i10 = sL0 & 65535;
        if ((sL0 & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + g(i10));
        }
        interfaceC0968f.skip(18L);
        int iL0 = interfaceC0968f.l0() & 65535;
        interfaceC0968f.skip(interfaceC0968f.l0() & 65535);
        if (nVar == null) {
            interfaceC0968f.skip(iL0);
            return null;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        m(interfaceC0968f, iL0, new p9.p() { // from class: Nb.o
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return r.p(interfaceC0968f, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
            }
        });
        return nVar.a((Integer) ref$ObjectRef.f34820a, (Integer) ref$ObjectRef2.f34820a, (Integer) ref$ObjectRef3.f34820a);
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r13v6, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r9v5, types: [T, java.lang.Integer] */
    public static final Y8.t p(InterfaceC0968f interfaceC0968f, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, int i10, long j10) throws IOException {
        if (i10 == 21589) {
            if (j10 < 1) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            byte b10 = interfaceC0968f.readByte();
            boolean z10 = (b10 & 1) == 1;
            boolean z11 = (b10 & 2) == 2;
            boolean z12 = (b10 & 4) == 4;
            long j11 = z10 ? 5L : 1L;
            if (z11) {
                j11 += 4;
            }
            if (z12) {
                j11 += 4;
            }
            if (j10 < j11) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            if (z10) {
                ref$ObjectRef.f34820a = Integer.valueOf(interfaceC0968f.e1());
            }
            if (z11) {
                ref$ObjectRef2.f34820a = Integer.valueOf(interfaceC0968f.e1());
            }
            if (z12) {
                ref$ObjectRef3.f34820a = Integer.valueOf(interfaceC0968f.e1());
            }
        }
        return Y8.t.f7040a;
    }

    public static final i q(InterfaceC0968f interfaceC0968f, i iVar) throws IOException {
        interfaceC0968f.skip(12L);
        int iE1 = interfaceC0968f.e1();
        int iE12 = interfaceC0968f.e1();
        long jO0 = interfaceC0968f.o0();
        if (jO0 != interfaceC0968f.o0() || iE1 != 0 || iE12 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        interfaceC0968f.skip(8L);
        return new i(jO0, interfaceC0968f.o0(), iVar.getCommentByteCount());
    }

    public static final void r(InterfaceC0968f interfaceC0968f) {
        kotlin.jvm.internal.p.i(interfaceC0968f, "<this>");
        o(interfaceC0968f, null);
    }
}
