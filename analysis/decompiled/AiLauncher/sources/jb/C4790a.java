package jb;

import La.D;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "", "beginIndex", "endIndex", "", Const.INTENT_KEY_APIKEY, "([BII)Ljava/lang/String;", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: jb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4790a {
    public static final String a(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = i10;
        p.i(bArr, "<this>");
        if (i17 < 0 || i11 > bArr.length || i17 > i11) {
            throw new IndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i17 + " endIndex=" + i11);
        }
        char[] cArr = new char[i11 - i17];
        int i18 = 0;
        while (i17 < i11) {
            byte b10 = bArr[i17];
            if (b10 >= 0) {
                i12 = i18 + 1;
                cArr[i18] = (char) b10;
                i17++;
                while (i17 < i11) {
                    byte b11 = bArr[i17];
                    if (b11 < 0) {
                        break;
                    }
                    i17++;
                    cArr[i12] = (char) b11;
                    i12++;
                }
                t tVar = t.f7040a;
            } else {
                if ((b10 >> 5) == -2) {
                    int i19 = i17 + 1;
                    if (i11 <= i19) {
                        i12 = i18 + 1;
                        cArr[i18] = (char) 65533;
                    } else {
                        byte b12 = bArr[i19];
                        if ((b12 & 192) == 128) {
                            int i20 = (b10 << 6) ^ (b12 ^ 3968);
                            if (i20 < 128) {
                                i12 = i18 + 1;
                                cArr[i18] = (char) 65533;
                            } else {
                                i12 = i18 + 1;
                                cArr[i18] = (char) i20;
                            }
                            t tVar2 = t.f7040a;
                        } else {
                            i12 = i18 + 1;
                            cArr[i18] = (char) 65533;
                        }
                    }
                    t tVar3 = t.f7040a;
                } else if ((b10 >> 4) == -2) {
                    int i21 = i17 + 2;
                    if (i11 <= i21) {
                        i12 = i18 + 1;
                        cArr[i18] = (char) 65533;
                        t tVar4 = t.f7040a;
                        int i22 = i17 + 1;
                        i13 = (i11 <= i22 || (bArr[i22] & 192) != 128) ? 1 : 2;
                    } else {
                        byte b13 = bArr[i17 + 1];
                        if ((b13 & 192) == 128) {
                            byte b14 = bArr[i21];
                            if ((b14 & 192) == 128) {
                                int i23 = (b10 << 12) ^ ((b14 ^ (-123008)) ^ (b13 << 6));
                                if (i23 < 2048) {
                                    i12 = i18 + 1;
                                    cArr[i18] = (char) 65533;
                                } else if (55296 > i23 || i23 >= 57344) {
                                    i12 = i18 + 1;
                                    cArr[i18] = (char) i23;
                                } else {
                                    i12 = i18 + 1;
                                    cArr[i18] = (char) 65533;
                                }
                                t tVar5 = t.f7040a;
                                i13 = 3;
                            } else {
                                i12 = i18 + 1;
                                cArr[i18] = (char) 65533;
                                t tVar6 = t.f7040a;
                            }
                        } else {
                            i12 = i18 + 1;
                            cArr[i18] = (char) 65533;
                            t tVar7 = t.f7040a;
                        }
                    }
                } else {
                    if ((b10 >> 3) == -2) {
                        int i24 = i17 + 3;
                        if (i11 <= i24) {
                            i14 = i18 + 1;
                            cArr[i18] = 65533;
                            t tVar8 = t.f7040a;
                            int i25 = i17 + 1;
                            if (i11 > i25 && (bArr[i25] & 192) == 128) {
                                int i26 = i17 + 2;
                                i16 = (i11 <= i26 || (bArr[i26] & 192) != 128) ? 2 : 3;
                            }
                            i16 = 1;
                        } else {
                            byte b15 = bArr[i17 + 1];
                            if ((b15 & 192) == 128) {
                                byte b16 = bArr[i17 + 2];
                                if ((b16 & 192) == 128) {
                                    byte b17 = bArr[i24];
                                    if ((b17 & 192) == 128) {
                                        int i27 = (b10 << 18) ^ (((b17 ^ 3678080) ^ (b16 << 6)) ^ (b15 << 12));
                                        if (i27 > 1114111) {
                                            i14 = i18 + 1;
                                            cArr[i18] = 65533;
                                        } else if ((55296 > i27 || i27 >= 57344) && i27 >= 65536) {
                                            if (i27 != 65533) {
                                                cArr[i18] = (char) ((i27 >>> 10) + 55232);
                                                i15 = i18 + 2;
                                                cArr[i18 + 1] = (char) ((i27 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) + GeneratorBase.SURR2_FIRST);
                                            } else {
                                                cArr[i18] = 65533;
                                                i15 = i18 + 1;
                                            }
                                            t tVar9 = t.f7040a;
                                            i14 = i15;
                                            i16 = 4;
                                        } else {
                                            i14 = i18 + 1;
                                            cArr[i18] = 65533;
                                        }
                                        t tVar10 = t.f7040a;
                                        i16 = 4;
                                    } else {
                                        i14 = i18 + 1;
                                        cArr[i18] = 65533;
                                        t tVar11 = t.f7040a;
                                    }
                                } else {
                                    i14 = i18 + 1;
                                    cArr[i18] = 65533;
                                    t tVar12 = t.f7040a;
                                }
                            } else {
                                i14 = i18 + 1;
                                cArr[i18] = 65533;
                                t tVar13 = t.f7040a;
                                i16 = 1;
                            }
                        }
                        i17 += i16;
                    } else {
                        i14 = i18 + 1;
                        cArr[i18] = 65533;
                        i17++;
                    }
                    i18 = i14;
                }
                i17 += i13;
            }
            i18 = i12;
        }
        return D.C(cArr, 0, i18);
    }

    public static /* synthetic */ String b(byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        return a(bArr, i10, i11);
    }
}
