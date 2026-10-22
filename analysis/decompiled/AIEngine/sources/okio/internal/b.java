package okio.internal;

import androidx.datastore.preferences.protobuf.b1;
import gc.o;
import gc.q;
import java.io.IOException;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.g;
import lb.n;
import sd.e;
import sd.x;
import sd.z;
import td.f;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.LinkedHashMap a(java.util.ArrayList r28) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.b.a(java.util.ArrayList):java.util.LinkedHashMap");
    }

    public static final String b(int i10) {
        b1.l(16);
        String string = Integer.toString(i10, 16);
        g.e(string, "toString(...)");
        return "0x".concat(string);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final f c(final z zVar) throws IOException {
        int iO = zVar.o();
        if (iO != 33639248) {
            throw new IOException("bad zip: expected " + b(33639248) + " but was " + b(iO));
        }
        zVar.skip(4L);
        short sC = zVar.C();
        int i10 = sC & 65535;
        if ((sC & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + b(i10));
        }
        int iC = zVar.C() & 65535;
        int iC2 = zVar.C() & 65535;
        int iC3 = zVar.C() & 65535;
        long jO = zVar.o() & 4294967295L;
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.f10075a = zVar.o() & 4294967295L;
        final Ref$LongRef ref$LongRef2 = new Ref$LongRef();
        ref$LongRef2.f10075a = zVar.o() & 4294967295L;
        int iC4 = zVar.C() & 65535;
        int iC5 = zVar.C() & 65535;
        int iC6 = 65535 & zVar.C();
        zVar.skip(8L);
        final Ref$LongRef ref$LongRef3 = new Ref$LongRef();
        ref$LongRef3.f10075a = zVar.o() & 4294967295L;
        String strK = zVar.K(iC4);
        if (q.m0(strK, (char) 0)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        final long j10 = ref$LongRef2.f10075a == 4294967295L ? 8 : 0L;
        if (ref$LongRef.f10075a == 4294967295L) {
            j10 += 8;
        }
        if (ref$LongRef3.f10075a == 4294967295L) {
            j10 += 8;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        d(zVar, iC5, new p<Integer, Long, n>() { // from class: okio.internal.ZipFilesKt$readCentralDirectoryZipEntry$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // zb.p
            public final n invoke(Integer num, Long l10) throws IOException {
                int iIntValue = num.intValue();
                long jLongValue = l10.longValue();
                final z zVar2 = zVar;
                if (iIntValue == 1) {
                    Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
                    if (ref$BooleanRef2.f10073a) {
                        throw new IOException("bad zip: zip64 extra repeated");
                    }
                    ref$BooleanRef2.f10073a = true;
                    if (jLongValue < j10) {
                        throw new IOException("bad zip: zip64 extra too short");
                    }
                    Ref$LongRef ref$LongRef4 = ref$LongRef2;
                    long jW = ref$LongRef4.f10075a;
                    if (jW == 4294967295L) {
                        jW = zVar2.w();
                    }
                    ref$LongRef4.f10075a = jW;
                    Ref$LongRef ref$LongRef5 = ref$LongRef;
                    ref$LongRef5.f10075a = ref$LongRef5.f10075a == 4294967295L ? zVar2.w() : 0L;
                    Ref$LongRef ref$LongRef6 = ref$LongRef3;
                    ref$LongRef6.f10075a = ref$LongRef6.f10075a == 4294967295L ? zVar2.w() : 0L;
                } else if (iIntValue == 10) {
                    if (jLongValue < 4) {
                        throw new IOException("bad zip: NTFS extra too short");
                    }
                    zVar2.skip(4L);
                    final Ref$ObjectRef<Long> ref$ObjectRef4 = ref$ObjectRef2;
                    final Ref$ObjectRef<Long> ref$ObjectRef5 = ref$ObjectRef3;
                    final Ref$ObjectRef<Long> ref$ObjectRef6 = ref$ObjectRef;
                    b.d(zVar2, (int) (jLongValue - 4), new p<Integer, Long, n>() { // from class: okio.internal.ZipFilesKt$readCentralDirectoryZipEntry$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Long] */
                        /* JADX WARN: Type inference failed for: r5v6, types: [T, java.lang.Long] */
                        /* JADX WARN: Type inference failed for: r5v8, types: [T, java.lang.Long] */
                        @Override // zb.p
                        public final n invoke(Integer num2, Long l11) throws IOException {
                            int iIntValue2 = num2.intValue();
                            long jLongValue2 = l11.longValue();
                            if (iIntValue2 == 1) {
                                Ref$ObjectRef<Long> ref$ObjectRef7 = ref$ObjectRef6;
                                if (ref$ObjectRef7.f10076a != null) {
                                    throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
                                }
                                if (jLongValue2 != 24) {
                                    throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                                }
                                z zVar3 = zVar2;
                                ref$ObjectRef7.f10076a = Long.valueOf(zVar3.w());
                                ref$ObjectRef4.f10076a = Long.valueOf(zVar3.w());
                                ref$ObjectRef5.f10076a = Long.valueOf(zVar3.w());
                            }
                            return n.f10413a;
                        }
                    });
                }
                return n.f10413a;
            }
        });
        if (j10 > 0 && !ref$BooleanRef.f10073a) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        String strK2 = zVar.K(iC6);
        String str = x.f11981b;
        return new f(x.a.a("/").c(strK), o.e0(strK, "/", false), strK2, jO, ref$LongRef.f10075a, ref$LongRef2.f10075a, iC, ref$LongRef3.f10075a, iC3, iC2, (Long) ref$ObjectRef.f10076a, (Long) ref$ObjectRef2.f10076a, (Long) ref$ObjectRef3.f10076a, 57344);
    }

    public static final void d(z zVar, int i10, p pVar) throws IOException {
        e eVar = zVar.f11987b;
        long j10 = i10;
        while (j10 != 0) {
            if (j10 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int iC = zVar.C() & 65535;
            long jC = zVar.C() & 65535;
            long j11 = j10 - 4;
            if (j11 < jC) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            zVar.T(jC);
            long j12 = eVar.f11926b;
            pVar.invoke(Integer.valueOf(iC), Long.valueOf(jC));
            long j13 = (eVar.f11926b + jC) - j12;
            if (j13 < 0) {
                throw new IOException(ai.onnxruntime.providers.a.a(iC, "unsupported zip: too many bytes processed for "));
            }
            if (j13 > 0) {
                eVar.skip(j13);
            }
            j10 = j11 - jC;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final f e(final z zVar, f fVar) throws IOException {
        int iO = zVar.o();
        if (iO != 67324752) {
            throw new IOException("bad zip: expected " + b(67324752) + " but was " + b(iO));
        }
        zVar.skip(2L);
        short sC = zVar.C();
        int i10 = sC & 65535;
        if ((sC & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + b(i10));
        }
        zVar.skip(18L);
        int iC = zVar.C() & 65535;
        zVar.skip(zVar.C() & 65535);
        if (fVar == null) {
            zVar.skip(iC);
            return null;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        d(zVar, iC, new p<Integer, Long, n>() { // from class: okio.internal.ZipFilesKt$readOrSkipLocalHeader$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r12v11, types: [T, java.lang.Integer] */
            /* JADX WARN: Type inference failed for: r12v13, types: [T, java.lang.Integer] */
            /* JADX WARN: Type inference failed for: r12v9, types: [T, java.lang.Integer] */
            @Override // zb.p
            public final n invoke(Integer num, Long l10) throws IOException {
                int iIntValue = num.intValue();
                long jLongValue = l10.longValue();
                if (iIntValue == 21589) {
                    if (jLongValue < 1) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    z zVar2 = zVar;
                    byte b10 = zVar2.readByte();
                    boolean z = (b10 & 1) == 1;
                    boolean z3 = (b10 & 2) == 2;
                    boolean z10 = (b10 & 4) == 4;
                    long j10 = z ? 5L : 1L;
                    if (z3) {
                        j10 += 4;
                    }
                    if (z10) {
                        j10 += 4;
                    }
                    if (jLongValue < j10) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    if (z) {
                        ref$ObjectRef.f10076a = Integer.valueOf(zVar2.o());
                    }
                    if (z3) {
                        ref$ObjectRef2.f10076a = Integer.valueOf(zVar2.o());
                    }
                    if (z10) {
                        ref$ObjectRef3.f10076a = Integer.valueOf(zVar2.o());
                    }
                }
                return n.f10413a;
            }
        });
        return new f(fVar.f13085a, fVar.f13086b, fVar.f13087c, fVar.f13088d, fVar.f13089e, fVar.f13090f, fVar.f13091g, fVar.h, fVar.f13092i, fVar.f13093j, fVar.f13094k, fVar.f13095l, fVar.f13096m, (Integer) ref$ObjectRef.f10076a, (Integer) ref$ObjectRef2.f10076a, (Integer) ref$ObjectRef3.f10076a);
    }
}
