package B9;

import androidx.exifinterface.media.ExifInterface;
import k9.AbstractC1651b;
import k9.C1650a;
import kotlin.time.DurationUnit;
import z9.C2203e;

/* renamed from: B9.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0191s implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0191s f256a = new C0191s();
    public static final Z b = new Z("kotlin.time.Duration", C2203e.k);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        int i = C1650a.d;
        String value = decoder.decodeString();
        kotlin.jvm.internal.k.f(value, "value");
        try {
            return new C1650a(z2.l.g(value));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(B7.a.m("Invalid ISO duration string format: '", value, "'."), e);
        }
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        long j5;
        long j6;
        int iF;
        long j10 = ((C1650a) obj).f4876a;
        int i = C1650a.d;
        StringBuilder sb = new StringBuilder();
        if (j10 < 0) {
            sb.append('-');
        }
        sb.append("PT");
        boolean z10 = true;
        if (j10 < 0) {
            j5 = ((-(j10 >> 1)) << 1) + (((int) j10) & 1);
            int i6 = AbstractC1651b.f4877a;
        } else {
            j5 = j10;
        }
        long jF = C1650a.f(j5, DurationUnit.f);
        if (C1650a.d(j5)) {
            j6 = 0;
            iF = 0;
        } else {
            j6 = 0;
            iF = (int) (C1650a.f(j5, DurationUnit.e) % 60);
        }
        int iF2 = C1650a.d(j5) ? 0 : (int) (C1650a.f(j5, DurationUnit.d) % 60);
        int iC = C1650a.c(j5);
        if (C1650a.d(j10)) {
            jF = 9999999999999L;
        }
        boolean z11 = jF != j6;
        boolean z12 = (iF2 == 0 && iC == 0) ? false : true;
        if (iF == 0 && (!z12 || !z11)) {
            z10 = false;
        }
        if (z11) {
            sb.append(jF);
            sb.append('H');
        }
        if (z10) {
            sb.append(iF);
            sb.append('M');
        }
        if (z12 || (!z11 && !z10)) {
            C1650a.b(sb, iF2, iC, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        fVar.encodeString(sb.toString());
    }
}
