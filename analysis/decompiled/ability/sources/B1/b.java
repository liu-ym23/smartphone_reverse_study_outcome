package B1;

import F9.AbstractC0226d;
import F9.B;
import F9.C0233k;
import F9.C0238p;
import F9.E;
import F9.F;
import X6.n;
import a.AbstractC0291a;
import a5.AbstractC0303c;
import a7.AbstractC0307c;
import a7.f;
import cc.dd.hh.aa.g;
import com.google.android.material.timepicker.TimeModel;
import com.stepos.common.widget.C;
import com.stepos.common.widget.DatePicker;
import com.stepos.common.widget.DayTimeDatePicker;
import com.stepos.common.widget.TimePicker;
import e7.C1424a;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.jvm.internal.k;
import w0.C2086g;
import w0.C2088i;

/* loaded from: classes2.dex */
public final class b implements C {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f179a;
    public int b;
    public Object c;

    public /* synthetic */ b(int i, byte b) {
        this.f179a = i;
    }

    public static B i(n nVar) {
        HashMap map = nVar.m;
        String str = (map == null || !map.containsKey(HttpHeaders.CONTENT_TYPE)) ? "" : (String) nVar.m.get(HttpHeaders.CONTENT_TYPE);
        if (AbstractC0291a.x(str)) {
            return null;
        }
        Pattern pattern = B.e;
        return AbstractC0226d.j(str);
    }

    @Override // com.stepos.common.widget.C
    public String a(int i) {
        String str;
        switch (this.f179a) {
            case 7:
                DatePicker datePicker = (DatePicker) this.c;
                int i6 = this.b;
                if (i6 == 1) {
                    return String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i + datePicker.l));
                }
                if (i6 != 2) {
                    if (i6 != 3) {
                        return null;
                    }
                    if (!datePicker.h) {
                        Calendar calendar = datePicker.n;
                        return (calendar != null && calendar.get(1) == datePicker.k && datePicker.n.get(2) == datePicker.f3676j) ? datePicker.f3672Q[datePicker.n.get(5) + i] : datePicker.f3672Q[i + 1];
                    }
                    String[] strArr = datePicker.f3671P;
                    if (i > strArr.length - 1) {
                        return null;
                    }
                    return strArr[i];
                }
                if (datePicker.h) {
                    return datePicker.f(i);
                }
                Calendar calendar2 = datePicker.n;
                if (calendar2 != null && calendar2.get(1) == datePicker.k) {
                    i += datePicker.n.get(2);
                }
                String[] strArr2 = datePicker.f3678r;
                if (i < strArr2.length) {
                    return strArr2[i];
                }
                return null;
            case 8:
                DayTimeDatePicker dayTimeDatePicker = (DayTimeDatePicker) this.c;
                int i10 = this.b;
                if (i10 == 4) {
                    return dayTimeDatePicker.f3698q[i];
                }
                if (i10 == 5) {
                    return dayTimeDatePicker.f3699r[i];
                }
                if (i10 != 6) {
                    return null;
                }
                if (dayTimeDatePicker.g) {
                    int i11 = dayTimeDatePicker.f3697j;
                    int iA = DayTimeDatePicker.a(dayTimeDatePicker, i);
                    if (iA > dayTimeDatePicker.d(i11) - 1) {
                        iA -= dayTimeDatePicker.d(i11);
                        i11++;
                    } else if (iA < 0) {
                        iA += dayTimeDatePicker.d(i11 - 1);
                        i11--;
                    }
                    int length = iA + 1;
                    String[] strArr3 = dayTimeDatePicker.f3689D;
                    int iC = AbstractC0303c.c(i11);
                    if (iC == 0 || length <= iC) {
                        if (iA >= strArr3.length) {
                            length = strArr3.length - 1;
                        }
                        str = strArr3[length - 1];
                    } else {
                        str = strArr3[iA - 1];
                    }
                    int iB = DayTimeDatePicker.b(dayTimeDatePicker, i);
                    StringBuilder sbV = androidx.compose.foundation.b.v(str);
                    sbV.append(dayTimeDatePicker.e() ? dayTimeDatePicker.f3694N : " ");
                    int i12 = iB - 1;
                    String[] strArr4 = dayTimeDatePicker.E;
                    sbV.append(i12 <= strArr4.length - 1 ? strArr4[i12] : null);
                    return sbV.toString();
                }
                int iA2 = DayTimeDatePicker.a(dayTimeDatePicker, i);
                if (iA2 > dayTimeDatePicker.d(dayTimeDatePicker.f3697j) - 1) {
                    iA2 -= dayTimeDatePicker.d(dayTimeDatePicker.f3697j);
                } else if (iA2 < 0) {
                    iA2 += dayTimeDatePicker.d(dayTimeDatePicker.f3697j);
                }
                if (!dayTimeDatePicker.e()) {
                    return dayTimeDatePicker.f3689D[iA2] + " " + dayTimeDatePicker.f3693M[DayTimeDatePicker.b(dayTimeDatePicker, i)];
                }
                int i13 = iA2 + 1;
                Calendar calendar3 = dayTimeDatePicker.o;
                if (calendar3 != null && calendar3.get(1) == dayTimeDatePicker.f3697j && dayTimeDatePicker.o.get(2) == dayTimeDatePicker.i) {
                    return i13 + dayTimeDatePicker.f3694N + dayTimeDatePicker.f3693M[dayTimeDatePicker.o.get(5) + (DayTimeDatePicker.b(dayTimeDatePicker, i) - 1)] + dayTimeDatePicker.f3695O;
                }
                return i13 + dayTimeDatePicker.f3694N + dayTimeDatePicker.f3693M[DayTimeDatePicker.b(dayTimeDatePicker, i)] + dayTimeDatePicker.f3695O;
            default:
                TimePicker timePicker = (TimePicker) this.c;
                int i14 = this.b;
                if (i14 == 1) {
                    if (timePicker.c.booleanValue()) {
                        return timePicker.f3797r[i];
                    }
                    if (i == 0) {
                        i = 12;
                    }
                    return timePicker.f3797r[i];
                }
                if (i14 == 2) {
                    return timePicker.f3798s[i];
                }
                if (i14 == 3) {
                    if (i == 0) {
                        return timePicker.h;
                    }
                    if (i == 1) {
                        return timePicker.i;
                    }
                }
                return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x026e  */
    @Override // com.stepos.common.widget.C
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(int r14) {
        /*
            Method dump skipped, instructions count: 780
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.b.b(int):void");
    }

    public int c(int i, b bVar) throws IOException {
        BufferedInputStream bufferedInputStream = (BufferedInputStream) this.c;
        e eVarG = S0.b.g(bufferedInputStream, this.b);
        S0.b.d(bufferedInputStream);
        int iD = S0.b.d(bufferedInputStream);
        int i6 = bufferedInputStream.read();
        g gVarA = g.a(i6);
        if (gVarA == null) {
            throw new IllegalStateException(B7.a.h(i6, "accept primitive array failed, lost type def of typeId: "));
        }
        int i10 = this.b;
        int i11 = gVarA.b;
        if (i11 != 0) {
            i10 = i11;
        }
        int i12 = i10 * iD;
        S0.b.J(bufferedInputStream, new byte[i12], i12);
        try {
            d dVar = (d) bVar.c;
            ByteArrayOutputStream byteArrayOutputStream = dVar.e;
            dVar.e.write(i);
            byteArrayOutputStream.write(eVarG.f181a);
            S0.b.K(byteArrayOutputStream, iD);
            byteArrayOutputStream.write(i6);
            g gVarA2 = g.a(i6);
            if (gVarA2 != g.CHAR && gVarA2 != g.BYTE) {
                g gVarA3 = g.a(i6);
                int i13 = dVar.d;
                int i14 = gVarA3.b;
                if (i14 != 0) {
                    i13 = i14;
                }
                S0.b.D(byteArrayOutputStream, iD * i13);
            }
            return this.b + 9 + i12;
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public void d(int i, int i6, long j5, c cVar) throws IOException {
        RuntimeException runtimeException;
        long j6;
        int iC;
        int i10;
        int i11;
        Object objG;
        a[] aVarArr;
        int iD;
        int i12;
        long j10 = j5;
        BufferedInputStream bufferedInputStream = (BufferedInputStream) this.c;
        b bVarA = cVar.a(i, i6, j10);
        if (bVarA == null) {
            S0.b.C(bufferedInputStream, j10);
            return;
        }
        d dVar = (d) bVarA.c;
        BufferedOutputStream bufferedOutputStream = dVar.c;
        ByteArrayOutputStream byteArrayOutputStream = dVar.e;
        while (j10 > 0) {
            int i13 = bufferedInputStream.read();
            long j11 = j10 - 1;
            if (i13 == 144) {
                j6 = j11;
                bVarA.e(i13, S0.b.g(bufferedInputStream, this.b));
                iC = this.b;
            } else if (i13 != 195) {
                if (i13 == 254) {
                    j6 = j11;
                    int iD2 = S0.b.d(bufferedInputStream);
                    e eVarG = S0.b.g(bufferedInputStream, this.b);
                    try {
                        byteArrayOutputStream.write(254);
                        S0.b.K(byteArrayOutputStream, iD2);
                        byteArrayOutputStream.write(eVarG.f181a);
                        i10 = this.b;
                    } finally {
                    }
                } else if (i13 != 255) {
                    switch (i13) {
                        case 1:
                            j6 = j11;
                            bVarA.e(i13, S0.b.g(bufferedInputStream, this.b));
                            S0.b.C(bufferedInputStream, this.b);
                            iC = this.b << 1;
                            break;
                        case 2:
                            j6 = j11;
                            e eVarG2 = S0.b.g(bufferedInputStream, this.b);
                            S0.b.d(bufferedInputStream);
                            S0.b.d(bufferedInputStream);
                            try {
                                byteArrayOutputStream.write(2);
                                byteArrayOutputStream.write(eVarG2.f181a);
                                i11 = this.b;
                                iC = i11 + 8;
                                break;
                            } finally {
                            }
                        case 3:
                            j6 = j11;
                            e eVarG3 = S0.b.g(bufferedInputStream, this.b);
                            S0.b.d(bufferedInputStream);
                            S0.b.d(bufferedInputStream);
                            try {
                                byteArrayOutputStream.write(3);
                                byteArrayOutputStream.write(eVarG3.f181a);
                                i11 = this.b;
                                iC = i11 + 8;
                                break;
                            } finally {
                            }
                        case 4:
                            j6 = j11;
                            e eVarG4 = S0.b.g(bufferedInputStream, this.b);
                            S0.b.d(bufferedInputStream);
                            try {
                                byteArrayOutputStream.write(4);
                                byteArrayOutputStream.write(eVarG4.f181a);
                                i10 = this.b;
                                break;
                            } finally {
                            }
                        case 5:
                            j6 = j11;
                            bVarA.e(i13, S0.b.g(bufferedInputStream, this.b));
                            iC = this.b;
                            break;
                        case 6:
                            j6 = j11;
                            e eVarG5 = S0.b.g(bufferedInputStream, this.b);
                            S0.b.d(bufferedInputStream);
                            try {
                                byteArrayOutputStream.write(6);
                                byteArrayOutputStream.write(eVarG5.f181a);
                                i10 = this.b;
                                break;
                            } finally {
                            }
                        case 7:
                            j6 = j11;
                            bVarA.e(i13, S0.b.g(bufferedInputStream, this.b));
                            iC = this.b;
                            break;
                        case 8:
                            j6 = j11;
                            e eVarG6 = S0.b.g(bufferedInputStream, this.b);
                            S0.b.d(bufferedInputStream);
                            S0.b.d(bufferedInputStream);
                            try {
                                byteArrayOutputStream.write(8);
                                byteArrayOutputStream.write(eVarG6.f181a);
                                i11 = this.b;
                                iC = i11 + 8;
                                break;
                            } finally {
                            }
                        default:
                            switch (i13) {
                                case 32:
                                    e eVarG7 = S0.b.g(bufferedInputStream, this.b);
                                    S0.b.d(bufferedInputStream);
                                    e eVarG8 = S0.b.g(bufferedInputStream, this.b);
                                    e eVarG9 = S0.b.g(bufferedInputStream, this.b);
                                    S0.b.C(bufferedInputStream, this.b << 2);
                                    int iD3 = S0.b.d(bufferedInputStream);
                                    int i14 = this.b * 7;
                                    short sA0 = S0.b.A0(bufferedInputStream);
                                    int i15 = i14 + 10;
                                    int i16 = 0;
                                    while (i16 < sA0) {
                                        int i17 = i16;
                                        S0.b.C(bufferedInputStream, 2L);
                                        int i18 = bufferedInputStream.read();
                                        g gVarA = g.a(i18);
                                        if (gVarA == null) {
                                            throw new IllegalStateException(B7.a.h(i18, "failure to skip type, cannot find type def of typeid: "));
                                        }
                                        int i19 = this.b;
                                        int i20 = gVarA.b;
                                        if (i20 != 0) {
                                            i19 = i20;
                                        }
                                        S0.b.C(bufferedInputStream, i19);
                                        i15 = i19 + 3 + i15;
                                        i16 = i17 + 1;
                                        eVarG8 = eVarG8;
                                    }
                                    e eVar = eVarG8;
                                    int iA0 = S0.b.A0(bufferedInputStream);
                                    a[] aVarArr2 = new a[iA0];
                                    int i21 = i15 + 2;
                                    int i22 = 0;
                                    while (i22 < iA0) {
                                        e eVarG10 = S0.b.g(bufferedInputStream, this.b);
                                        int i23 = bufferedInputStream.read();
                                        long j12 = j11;
                                        g gVarA2 = g.a(i23);
                                        if (gVarA2 == null) {
                                            throw new IllegalStateException(B7.a.h(i23, "accept class failed, lost type def of typeId: "));
                                        }
                                        int i24 = this.b;
                                        switch (gVarA2.ordinal()) {
                                            case 0:
                                                objG = S0.b.g(bufferedInputStream, i24);
                                                aVarArr = aVarArr2;
                                                break;
                                            case 1:
                                                objG = Boolean.valueOf(bufferedInputStream.read() != 0);
                                                aVarArr = aVarArr2;
                                                break;
                                            case 2:
                                                objG = Character.valueOf((char) S0.b.A0(bufferedInputStream));
                                                aVarArr = aVarArr2;
                                                break;
                                            case 3:
                                                objG = Float.valueOf(Float.intBitsToFloat(S0.b.d(bufferedInputStream)));
                                                aVarArr = aVarArr2;
                                                break;
                                            case 4:
                                                objG = Double.valueOf(Double.longBitsToDouble(S0.b.h0(bufferedInputStream)));
                                                aVarArr = aVarArr2;
                                                break;
                                            case 5:
                                                objG = Byte.valueOf((byte) bufferedInputStream.read());
                                                aVarArr = aVarArr2;
                                                break;
                                            case 6:
                                                objG = Short.valueOf(S0.b.A0(bufferedInputStream));
                                                aVarArr = aVarArr2;
                                                break;
                                            case 7:
                                                objG = Integer.valueOf(S0.b.d(bufferedInputStream));
                                                aVarArr = aVarArr2;
                                                break;
                                            case 8:
                                                objG = Long.valueOf(S0.b.h0(bufferedInputStream));
                                                aVarArr = aVarArr2;
                                                break;
                                            default:
                                                aVarArr = aVarArr2;
                                                objG = null;
                                                break;
                                        }
                                        aVarArr[i22] = new a(i23, eVarG10, objG);
                                        int i25 = this.b;
                                        int i26 = i25 + 1;
                                        int i27 = gVarA2.b;
                                        if (i27 != 0) {
                                            i25 = i27;
                                        }
                                        i21 = i26 + i25 + i21;
                                        i22++;
                                        j11 = j12;
                                        aVarArr2 = aVarArr;
                                    }
                                    j6 = j11;
                                    a[] aVarArr3 = aVarArr2;
                                    int iA02 = S0.b.A0(bufferedInputStream);
                                    a[] aVarArr4 = new a[iA02];
                                    int i28 = i21 + 2;
                                    int i29 = 0;
                                    while (i29 < iA02) {
                                        a[] aVarArr5 = aVarArr4;
                                        aVarArr5[i29] = new a(bufferedInputStream.read(), S0.b.g(bufferedInputStream, this.b), null);
                                        i28 = this.b + 1 + i28;
                                        i29++;
                                        aVarArr4 = aVarArr5;
                                    }
                                    a[] aVarArr6 = aVarArr4;
                                    try {
                                        byteArrayOutputStream.write(32);
                                        byteArrayOutputStream.write(eVarG7.f181a);
                                        byteArrayOutputStream.write(eVar.f181a);
                                        byteArrayOutputStream.write(eVarG9.f181a);
                                        S0.b.D(byteArrayOutputStream, dVar.d << 1);
                                        S0.b.m0(byteArrayOutputStream, iD3);
                                        S0.b.m0(byteArrayOutputStream, 0);
                                        S0.b.m0(byteArrayOutputStream, iA0);
                                        for (int i30 = 0; i30 < iA0; i30++) {
                                            a aVar = aVarArr3[i30];
                                            byteArrayOutputStream.write(aVar.b.f181a);
                                            byteArrayOutputStream.write(aVar.f178a);
                                            S0.b.E(byteArrayOutputStream, aVar.c);
                                        }
                                        S0.b.m0(byteArrayOutputStream, iA02);
                                        for (int i31 = 0; i31 < iA02; i31++) {
                                            a aVar2 = aVarArr6[i31];
                                            byteArrayOutputStream.write(aVar2.b.f181a);
                                            byteArrayOutputStream.write(aVar2.f178a);
                                        }
                                        iC = i28;
                                        break;
                                    } finally {
                                    }
                                case 33:
                                    e eVarG11 = S0.b.g(bufferedInputStream, this.b);
                                    S0.b.d(bufferedInputStream);
                                    e eVarG12 = S0.b.g(bufferedInputStream, this.b);
                                    iD = S0.b.d(bufferedInputStream);
                                    byte[] bArr = new byte[iD];
                                    S0.b.J(bufferedInputStream, bArr, iD);
                                    try {
                                        byteArrayOutputStream.write(33);
                                        byteArrayOutputStream.write(eVarG11.f181a);
                                        byteArrayOutputStream.write(eVarG12.f181a);
                                        S0.b.K(byteArrayOutputStream, iD);
                                        byteArrayOutputStream.write(bArr);
                                        int i32 = this.b;
                                        i12 = i32 + 4 + i32 + 4;
                                        iC = i12 + iD;
                                        j6 = j11;
                                        break;
                                    } finally {
                                    }
                                case 34:
                                    e eVarG13 = S0.b.g(bufferedInputStream, this.b);
                                    S0.b.d(bufferedInputStream);
                                    int iD4 = S0.b.d(bufferedInputStream);
                                    e eVarG14 = S0.b.g(bufferedInputStream, this.b);
                                    iD = this.b * iD4;
                                    byte[] bArr2 = new byte[iD];
                                    S0.b.J(bufferedInputStream, bArr2, iD);
                                    try {
                                        byteArrayOutputStream.write(34);
                                        byteArrayOutputStream.write(eVarG13.f181a);
                                        S0.b.K(byteArrayOutputStream, iD4);
                                        byteArrayOutputStream.write(eVarG14.f181a);
                                        byteArrayOutputStream.write(bArr2, 0, iD4 * dVar.d);
                                        int i33 = this.b;
                                        i12 = i33 + 8 + i33;
                                        iC = i12 + iD;
                                        j6 = j11;
                                        break;
                                    } finally {
                                    }
                                case 35:
                                    iC = c(i13, bVarA);
                                    j6 = j11;
                                    break;
                                default:
                                    switch (i13) {
                                        case 137:
                                            bVarA.e(i13, S0.b.g(bufferedInputStream, this.b));
                                            iC = this.b;
                                            break;
                                        case 138:
                                            bVarA.e(i13, S0.b.g(bufferedInputStream, this.b));
                                            iC = this.b;
                                            break;
                                        case 139:
                                            bVarA.e(i13, S0.b.g(bufferedInputStream, this.b));
                                            iC = this.b;
                                            break;
                                        case 140:
                                            bVarA.e(i13, S0.b.g(bufferedInputStream, this.b));
                                            iC = this.b;
                                            break;
                                        case 141:
                                            bVarA.e(i13, S0.b.g(bufferedInputStream, this.b));
                                            iC = this.b;
                                            break;
                                        case 142:
                                            e eVarG15 = S0.b.g(bufferedInputStream, this.b);
                                            S0.b.d(bufferedInputStream);
                                            S0.b.d(bufferedInputStream);
                                            try {
                                                byteArrayOutputStream.write(142);
                                                byteArrayOutputStream.write(eVarG15.f181a);
                                                iC = this.b + 8;
                                                break;
                                            } finally {
                                            }
                                        default:
                                            StringBuilder sbU = B7.a.u(i13, "acceptHeapDumpRecord loop with unknown tag ", " with ");
                                            sbU.append(bufferedInputStream.available());
                                            sbU.append(" bytes possibly remaining");
                                            throw new IllegalArgumentException(sbU.toString());
                                    }
                                    j6 = j11;
                                    break;
                            }
                    }
                } else {
                    j6 = j11;
                    bVarA.e(i13, S0.b.g(bufferedInputStream, this.b));
                    iC = this.b;
                }
                iC = i10 + 4;
            } else {
                j6 = j11;
                iC = c(i13, bVarA);
            }
            j10 = j6 - iC;
        }
        try {
            bufferedOutputStream.write(bVarA.b);
            bufferedOutputStream.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.reset();
        } finally {
        }
    }

    public void e(int i, e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = ((d) this.c).e;
        try {
            byteArrayOutputStream.write(i);
            byteArrayOutputStream.write(eVar.f181a);
            if (i == 1) {
                S0.b.D(byteArrayOutputStream, r1.d);
            }
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public void f(c cVar) throws IOException {
        BufferedInputStream bufferedInputStream = (BufferedInputStream) this.c;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i6 = bufferedInputStream.read(); i6 != 0; i6 = bufferedInputStream.read()) {
            sb.append((char) i6);
            i++;
            if (i > 2048) {
                throw new IOException("Bad string data which causes result to be too long.");
            }
        }
        String string = sb.toString();
        int iD = S0.b.d(bufferedInputStream);
        if (iD <= 0 || iD >= 1073741823) {
            throw new IOException(B7.a.h(iD, "bad idSize: "));
        }
        long jH0 = S0.b.h0(bufferedInputStream);
        this.b = iD;
        c cVar2 = cVar;
        cVar2.g(iD, string, jH0);
        while (true) {
            try {
                int i10 = bufferedInputStream.read();
                int iD2 = S0.b.d(bufferedInputStream);
                long jD = S0.b.d(bufferedInputStream) & 4294967295L;
                if (i10 == 1) {
                    e eVarG = S0.b.g(bufferedInputStream, this.b);
                    long j5 = jD - this.b;
                    byte[] bArr = new byte[(int) j5];
                    S0.b.J(bufferedInputStream, bArr, j5);
                    cVar.i(eVarG, new String(bArr, Charset.forName("UTF-8")), iD2, jD);
                } else if (i10 == 2) {
                    cVar.e(S0.b.d(bufferedInputStream), S0.b.g(bufferedInputStream, this.b), S0.b.d(bufferedInputStream), S0.b.g(bufferedInputStream, this.b), iD2, jD);
                } else if (i10 == 4) {
                    cVar.h(S0.b.g(bufferedInputStream, this.b), S0.b.g(bufferedInputStream, this.b), S0.b.g(bufferedInputStream, this.b), S0.b.g(bufferedInputStream, this.b), S0.b.d(bufferedInputStream), S0.b.d(bufferedInputStream), iD2, jD);
                } else if (i10 == 5) {
                    int iD3 = S0.b.d(bufferedInputStream);
                    int iD4 = S0.b.d(bufferedInputStream);
                    int iD5 = S0.b.d(bufferedInputStream);
                    e[] eVarArr = new e[iD5];
                    for (int i11 = 0; i11 < iD5; i11++) {
                        eVarArr[i11] = S0.b.g(bufferedInputStream, this.b);
                    }
                    cVar.d(iD3, iD4, eVarArr, iD2, jD);
                } else if (i10 == 12 || i10 == 28) {
                    d(i10, iD2, jD, cVar);
                } else {
                    byte[] bArr2 = new byte[(int) jD];
                    S0.b.J(bufferedInputStream, bArr2, jD);
                    cVar2.c(i10, iD2, jD, bArr2);
                }
                cVar2 = cVar;
            } catch (EOFException unused) {
                cVar.b();
                return;
            }
        }
    }

    public void g(C2088i c2088i) {
        PriorityQueue priorityQueue = (PriorityQueue) this.c;
        if (priorityQueue.size() < this.b) {
            priorityQueue.add(c2088i);
        } else if (c2088i.compareTo((Comparable) priorityQueue.peek()) > 0) {
            priorityQueue.poll();
            priorityQueue.add(c2088i);
        }
    }

    public void h(int i, int i6) {
        int i10 = i6 + i;
        char[] cArr = (char[]) this.c;
        if (cArr.length <= i10) {
            int i11 = i * 2;
            if (i10 < i11) {
                i10 = i11;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i10);
            k.e(cArrCopyOf, "copyOf(...)");
            this.c = cArrCopyOf;
        }
    }

    public void j() {
        D9.c cVar = D9.c.c;
        char[] array = (char[]) this.c;
        cVar.getClass();
        k.f(array, "array");
        synchronized (cVar) {
            int i = cVar.b;
            if (array.length + i < D9.b.f436a) {
                cVar.b = i + array.length;
                cVar.f437a.addLast(array);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x025e, code lost:
    
        r0 = java.lang.System.currentTimeMillis();
        a7.AbstractC0307c.a(r9, "okhttp response");
        r3 = r9.f;
        r4 = r9.g;
        r5 = r9.d;
        a7.f.e.info("tos: status code:{}, request id:{}, request cost {} ms, request {} times\n", java.lang.Integer.valueOf(r5), F9.M.b(r9, "X-Tos-Request-Id"), java.lang.Long.valueOf(r0 - r18), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x028e, code lost:
    
        if (r22.i == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0292, code lost:
    
        if (r5 >= 300) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0294, code lost:
    
        r0 = r22.k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0296, code lost:
    
        if (r0 == null) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x029a, code lost:
    
        if ((r0 instanceof java.util.zip.CheckedInputStream) == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x029c, code lost:
    
        r0 = U7.a.M(((java.util.zip.CheckedInputStream) r0).getChecksum().getValue());
        r1 = F9.M.b(r9, "x-tos-hash-crc64ecma");
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02b4, code lost:
    
        if (a.AbstractC0291a.s(r0, r1) == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02c4, code lost:
    
        throw new com.volcengine.tos.TosClientException(B7.a.n("tos: crc64 check failed, expected:", r1, ", in fact:", r0), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02c5, code lost:
    
        if (r4 != null) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02c7, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02c9, code lost:
    
        r0 = r4.f().D();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02d1, code lost:
    
        r1 = new com.volcengine.tos.internal.TosResponse();
        r1.f4236a = r5;
        r2 = F9.M.b(r9, io.modelcontextprotocol.spec.HttpHeaders.CONTENT_LENGTH);
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02e2, code lost:
    
        if (a.AbstractC0291a.x(r2) == false) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02e4, code lost:
    
        r12 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02e7, code lost:
    
        r12 = java.lang.Long.parseLong(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02eb, code lost:
    
        r1.b = r12;
        r2 = new java.util.HashMap(r3.size());
        r3 = r3.f().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0302, code lost:
    
        if (r3.hasNext() == false) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0304, code lost:
    
        r5 = (java.lang.String) r3.next();
        r9.getClass();
        kotlin.jvm.internal.k.f(r5, "name");
        r7 = F9.M.b(r9, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0324, code lost:
    
        if (r5.toLowerCase().startsWith("X-Tos-Meta-".toLowerCase()) == false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0326, code lost:
    
        r5 = a7.f.d(r5);
        r7 = a7.f.d(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x032e, code lost:
    
        if (r5 != null) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0330, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0332, code lost:
    
        r8 = r5.equalsIgnoreCase("Content-Disposition");
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0338, code lost:
    
        if (r8 == false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x033a, code lost:
    
        r7 = a7.f.d(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x033e, code lost:
    
        r2.put(r5.toLowerCase(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0346, code lost:
    
        r1.c = r2;
        r1.d = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x034a, code lost:
    
        if (r4 != null) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x034d, code lost:
    
        r6 = r4.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0351, code lost:
    
        r1.e = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0353, code lost:
    
        return r1;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r0v51, types: [java.lang.Exception, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v53, types: [java.io.IOException, java.lang.Object, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v56, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.volcengine.tos.internal.TosResponse k(X6.n r22) throws java.lang.InterruptedException, java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 888
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.b.k(X6.n):com.volcengine.tos.internal.TosResponse");
    }

    public void l(String text) {
        k.f(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        h(this.b, length);
        text.getChars(0, text.length(), (char[]) this.c, this.b);
        this.b += length;
    }

    public String toString() {
        switch (this.f179a) {
            case 2:
                return new String((char[]) this.c, 0, this.b);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ b(Object obj, int i, int i6) {
        this.f179a = i6;
        this.c = obj;
        this.b = i;
    }

    public b(int i) {
        this.f179a = 5;
        if (i > 0) {
            this.b = i;
            this.c = new PriorityQueue(i, new M.d(0));
            return;
        }
        throw new IllegalStateException();
    }

    public b(BufferedInputStream bufferedInputStream) {
        this.f179a = 0;
        this.b = 0;
        this.c = bufferedInputStream;
    }

    public b(C1424a c1424a) {
        this.f179a = 6;
        AbstractC0307c.a(c1424a, "TransportConfig");
        this.b = 3;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        C0233k c0233k = new C0233k(1024, 60000, timeUnit);
        C0238p c0238p = new C0238p();
        c0238p.f(1024);
        c0238p.g(1024);
        E e = new E();
        C2086g c2086g = new C2086g(f.e);
        e.f602a = c0238p;
        e.b = c0233k;
        e.f = true;
        e.c(30000, timeUnit);
        e.e(30000, timeUnit);
        e.b(10000, timeUnit);
        e.h = false;
        e.i = false;
        e.e = c2086g;
        this.c = new F(e);
    }
}
