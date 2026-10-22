package com.fasterxml.jackson.core;

import a3.c;
import ai.onnxruntime.a;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.d;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Base64Variant implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final transient int[] f3505a;

    /* renamed from: b, reason: collision with root package name */
    public final transient char[] f3506b;

    /* renamed from: c, reason: collision with root package name */
    public final transient byte[] f3507c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3508d;

    /* renamed from: e, reason: collision with root package name */
    public final char f3509e;
    public final int h;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3510j;

    /* renamed from: k, reason: collision with root package name */
    public final PaddingReadBehaviour f3511k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class PaddingReadBehaviour {

        /* renamed from: a, reason: collision with root package name */
        public static final PaddingReadBehaviour f3512a;

        /* renamed from: b, reason: collision with root package name */
        public static final PaddingReadBehaviour f3513b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ PaddingReadBehaviour[] f3514c;

        static {
            PaddingReadBehaviour paddingReadBehaviour = new PaddingReadBehaviour("PADDING_FORBIDDEN", 0);
            f3512a = paddingReadBehaviour;
            PaddingReadBehaviour paddingReadBehaviour2 = new PaddingReadBehaviour("PADDING_REQUIRED", 1);
            f3513b = paddingReadBehaviour2;
            f3514c = new PaddingReadBehaviour[]{paddingReadBehaviour, paddingReadBehaviour2, new PaddingReadBehaviour("PADDING_ALLOWED", 2)};
        }

        public PaddingReadBehaviour() {
            throw null;
        }

        public static PaddingReadBehaviour valueOf(String str) {
            return (PaddingReadBehaviour) Enum.valueOf(PaddingReadBehaviour.class, str);
        }

        public static PaddingReadBehaviour[] values() {
            return (PaddingReadBehaviour[]) f3514c.clone();
        }
    }

    public Base64Variant(String str, String str2, boolean z, char c9, int i10) {
        int[] iArr = new int[TraceIdKeys.MAX_LENGTH];
        this.f3505a = iArr;
        char[] cArr = new char[64];
        this.f3506b = cArr;
        this.f3507c = new byte[64];
        this.f3508d = str;
        this.f3510j = z;
        this.f3509e = c9;
        this.h = i10;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException(a.g(length, "Base64Alphabet length must be exactly 64 (was ", ")"));
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i11 = 0; i11 < length; i11++) {
            char c10 = this.f3506b[i11];
            this.f3507c[i11] = (byte) c10;
            this.f3505a[c10] = i11;
        }
        if (z) {
            this.f3505a[c9] = -2;
        }
        this.f3511k = z ? PaddingReadBehaviour.f3513b : PaddingReadBehaviour.f3512a;
    }

    public final void a(char c9, int i10, String str) {
        String strI;
        if (c9 <= ' ') {
            strI = "Illegal white space character (code 0x" + Integer.toHexString(c9) + ") as character #" + (i10 + 1) + " of 4-char base64 unit: can only used between units";
        } else {
            char c10 = this.f3509e;
            if (c9 == c10) {
                strI = "Unexpected padding character ('" + c10 + "') as character #" + (i10 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
            } else if (!Character.isDefined(c9) || Character.isISOControl(c9)) {
                strI = "Illegal character (code 0x" + Integer.toHexString(c9) + ") in base64 content";
            } else {
                strI = "Illegal character '" + c9 + "' (code 0x" + Integer.toHexString(c9) + ") in base64 content";
            }
        }
        if (str != null) {
            strI = d.i(strI, ": ", str);
        }
        throw new IllegalArgumentException(strI);
    }

    public final void b(String str, c cVar) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt > ' ') {
                int iC = c(cCharAt);
                if (iC < 0) {
                    a(cCharAt, 0, null);
                    throw null;
                }
                if (i11 >= length) {
                    throw new IllegalArgumentException(j());
                }
                int i12 = i10 + 2;
                char cCharAt2 = str.charAt(i11);
                int iC2 = c(cCharAt2);
                if (iC2 < 0) {
                    a(cCharAt2, 1, null);
                    throw null;
                }
                int i13 = (iC << 6) | iC2;
                PaddingReadBehaviour paddingReadBehaviour = PaddingReadBehaviour.f3513b;
                PaddingReadBehaviour paddingReadBehaviour2 = this.f3511k;
                if (i12 >= length) {
                    if (paddingReadBehaviour2 == paddingReadBehaviour) {
                        throw new IllegalArgumentException(j());
                    }
                    cVar.o(i13 >> 4);
                    return;
                }
                int i14 = i10 + 3;
                char cCharAt3 = str.charAt(i12);
                int iC3 = c(cCharAt3);
                String str2 = this.f3508d;
                PaddingReadBehaviour paddingReadBehaviour3 = PaddingReadBehaviour.f3512a;
                if (iC3 >= 0) {
                    int i15 = (i13 << 6) | iC3;
                    if (i14 >= length) {
                        if (paddingReadBehaviour2 == paddingReadBehaviour) {
                            throw new IllegalArgumentException(j());
                        }
                        cVar.C(i15 >> 2);
                        return;
                    }
                    i10 += 4;
                    char cCharAt4 = str.charAt(i14);
                    int iC4 = c(cCharAt4);
                    if (iC4 >= 0) {
                        cVar.w((i15 << 6) | iC4);
                    } else {
                        if (iC4 != -2) {
                            a(cCharAt4, 3, null);
                            throw null;
                        }
                        if (paddingReadBehaviour2 == paddingReadBehaviour3) {
                            throw new IllegalArgumentException(a0.a.k("Unexpected end of base64-encoded String: base64 variant '", str2, "' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured"));
                        }
                        cVar.C(i15 >> 2);
                    }
                } else {
                    if (iC3 != -2) {
                        a(cCharAt3, 2, null);
                        throw null;
                    }
                    if (paddingReadBehaviour2 == paddingReadBehaviour3) {
                        throw new IllegalArgumentException(a0.a.k("Unexpected end of base64-encoded String: base64 variant '", str2, "' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured"));
                    }
                    if (i14 >= length) {
                        throw new IllegalArgumentException(j());
                    }
                    i10 += 4;
                    char cCharAt5 = str.charAt(i14);
                    char c9 = this.f3509e;
                    if (cCharAt5 != c9) {
                        a(cCharAt5, 3, "expected padding character '" + c9 + "'");
                        throw null;
                    }
                    cVar.o(i13 >> 4);
                }
            } else {
                i10 = i11;
            }
        }
    }

    public final int c(char c9) {
        if (c9 <= 127) {
            return this.f3505a[c9];
        }
        return -1;
    }

    public final int d(int i10) {
        if (i10 <= 127) {
            return this.f3505a[i10];
        }
        return -1;
    }

    public final String e(byte[] bArr) {
        char[] cArr;
        int length = bArr.length;
        StringBuilder sb2 = new StringBuilder((length >> 2) + length + (length >> 3));
        int i10 = this.h >> 2;
        int i11 = length - 3;
        int i12 = 0;
        loop0: while (true) {
            int i13 = i10;
            do {
                cArr = this.f3506b;
                if (i12 > i11) {
                    break loop0;
                }
                int i14 = i12 + 2;
                int i15 = ((bArr[i12 + 1] & 255) | (bArr[i12] << 8)) << 8;
                i12 += 3;
                int i16 = i15 | (bArr[i14] & 255);
                sb2.append(cArr[(i16 >> 18) & 63]);
                sb2.append(cArr[(i16 >> 12) & 63]);
                sb2.append(cArr[(i16 >> 6) & 63]);
                sb2.append(cArr[i16 & 63]);
                i13--;
            } while (i13 > 0);
            sb2.append("\\n");
        }
        int i17 = length - i12;
        if (i17 > 0) {
            int i18 = i12 + 1;
            int i19 = bArr[i12] << 16;
            if (i17 == 2) {
                i19 |= (bArr[i18] & 255) << 8;
            }
            sb2.append(cArr[(i19 >> 18) & 63]);
            sb2.append(cArr[(i19 >> 12) & 63]);
            if (this.f3510j) {
                char c9 = this.f3509e;
                sb2.append(i17 == 2 ? cArr[(i19 >> 6) & 63] : c9);
                sb2.append(c9);
            } else if (i17 == 2) {
                sb2.append(cArr[(i19 >> 6) & 63]);
            }
        }
        return sb2.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Base64Variant.class) {
            return false;
        }
        Base64Variant base64Variant = (Base64Variant) obj;
        return base64Variant.f3509e == this.f3509e && base64Variant.h == this.h && base64Variant.f3510j == this.f3510j && base64Variant.f3511k == this.f3511k && this.f3508d.equals(base64Variant.f3508d);
    }

    public final int f(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = this.f3507c;
        bArr[i11] = bArr2[(i10 >> 18) & 63];
        bArr[i11 + 1] = bArr2[(i10 >> 12) & 63];
        int i12 = i11 + 3;
        bArr[i11 + 2] = bArr2[(i10 >> 6) & 63];
        int i13 = i11 + 4;
        bArr[i12] = bArr2[i10 & 63];
        return i13;
    }

    public final int g(char[] cArr, int i10, int i11) {
        char[] cArr2 = this.f3506b;
        cArr[i11] = cArr2[(i10 >> 18) & 63];
        cArr[i11 + 1] = cArr2[(i10 >> 12) & 63];
        int i12 = i11 + 3;
        cArr[i11 + 2] = cArr2[(i10 >> 6) & 63];
        int i13 = i11 + 4;
        cArr[i12] = cArr2[i10 & 63];
        return i13;
    }

    public final int h(int i10, int i11, int i12, char[] cArr) {
        char[] cArr2 = this.f3506b;
        cArr[i12] = cArr2[(i10 >> 18) & 63];
        int i13 = i12 + 2;
        cArr[i12 + 1] = cArr2[(i10 >> 12) & 63];
        if (!this.f3510j) {
            if (i11 != 2) {
                return i13;
            }
            int i14 = i12 + 3;
            cArr[i13] = cArr2[(i10 >> 6) & 63];
            return i14;
        }
        int i15 = i12 + 3;
        char c9 = this.f3509e;
        cArr[i13] = i11 == 2 ? cArr2[(i10 >> 6) & 63] : c9;
        int i16 = i12 + 4;
        cArr[i15] = c9;
        return i16;
    }

    public final int hashCode() {
        return this.f3508d.hashCode();
    }

    public final int i(byte[] bArr, int i10, int i11, int i12) {
        byte[] bArr2 = this.f3507c;
        bArr[i12] = bArr2[(i10 >> 18) & 63];
        int i13 = i12 + 2;
        bArr[i12 + 1] = bArr2[(i10 >> 12) & 63];
        if (!this.f3510j) {
            if (i11 != 2) {
                return i13;
            }
            int i14 = i12 + 3;
            bArr[i13] = bArr2[(i10 >> 6) & 63];
            return i14;
        }
        byte b10 = (byte) this.f3509e;
        int i15 = i12 + 3;
        bArr[i13] = i11 == 2 ? bArr2[(i10 >> 6) & 63] : b10;
        int i16 = i12 + 4;
        bArr[i15] = b10;
        return i16;
    }

    public final String j() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects padding (one or more '%c' characters) at the end. This Base64Variant might have been incorrectly configured", this.f3508d, Character.valueOf(this.f3509e));
    }

    public Object readResolve() {
        Base64Variant base64Variant = v2.a.f13371a;
        String str = base64Variant.f3508d;
        String str2 = this.f3508d;
        if (!str.equals(str2)) {
            base64Variant = v2.a.f13372b;
            if (!base64Variant.f3508d.equals(str2)) {
                base64Variant = v2.a.f13373c;
                if (!base64Variant.f3508d.equals(str2)) {
                    base64Variant = v2.a.f13374d;
                    if (!base64Variant.f3508d.equals(str2)) {
                        throw new IllegalArgumentException(a.k("No Base64Variant with name ", str2 == null ? "<null>" : a0.a.k("'", str2, "'")));
                    }
                }
            }
        }
        Base64Variant base64Variant2 = base64Variant;
        boolean z = base64Variant2.f3510j;
        boolean z3 = this.f3510j;
        if (z3 == z && this.f3509e == base64Variant2.f3509e && this.f3511k == base64Variant2.f3511k && this.h == base64Variant2.h && z3 == z) {
            return base64Variant2;
        }
        return new Base64Variant(base64Variant2, this.f3508d, z3, this.f3509e, this.f3511k, this.h);
    }

    public final String toString() {
        return this.f3508d;
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z, char c9, PaddingReadBehaviour paddingReadBehaviour, int i10) {
        int[] iArr = new int[TraceIdKeys.MAX_LENGTH];
        this.f3505a = iArr;
        char[] cArr = new char[64];
        this.f3506b = cArr;
        byte[] bArr = new byte[64];
        this.f3507c = bArr;
        this.f3508d = str;
        byte[] bArr2 = base64Variant.f3507c;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = base64Variant.f3506b;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = base64Variant.f3505a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.f3510j = z;
        this.f3509e = c9;
        this.h = i10;
        this.f3511k = paddingReadBehaviour;
    }
}
