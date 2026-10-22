package com.google.zxing.oned;

import H3.c;
import H3.m;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Code128Writer extends m {

    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public static final class MinimalEncoder {

        /* renamed from: a, reason: collision with root package name */
        public int[][] f21827a;

        /* renamed from: b, reason: collision with root package name */
        public Latch[][] f21828b;

        public enum Charset {
            A,
            B,
            C,
            NONE
        }

        public enum Latch {
            A,
            B,
            C,
            SHIFT,
            NONE
        }

        public MinimalEncoder() {
        }

        public static void b(Collection<int[]> collection, int i10, int[] iArr, int[] iArr2, int i11) {
            collection.add(c.f2976a[i10]);
            if (i11 != 0) {
                iArr2[0] = iArr2[0] + 1;
            }
            iArr[0] = iArr[0] + (i10 * iArr2[0]);
        }

        public static boolean f(char c10) {
            return c10 >= '0' && c10 <= '9';
        }

        public final boolean c(CharSequence charSequence, Charset charset, int i10) {
            int i11;
            char cCharAt = charSequence.charAt(i10);
            int iOrdinal = charset.ordinal();
            if (iOrdinal == 0) {
                return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fÿ".indexOf(cCharAt) >= 0;
            }
            if (iOrdinal == 1) {
                return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007fÿ".indexOf(cCharAt) >= 0;
            }
            if (iOrdinal != 2) {
                return false;
            }
            return cCharAt == 241 || ((i11 = i10 + 1) < charSequence.length() && f(cCharAt) && f(charSequence.charAt(i11)));
        }

        public final int d(CharSequence charSequence, Charset charset, int i10) {
            int iD;
            int iD2;
            int i11 = this.f21827a[charset.ordinal()][i10];
            if (i11 > 0) {
                return i11;
            }
            Latch latch = Latch.NONE;
            int i12 = i10 + 1;
            int i13 = 0;
            boolean z10 = i12 >= charSequence.length();
            Charset[] charsetArr = {Charset.A, Charset.B};
            int i14 = Integer.MAX_VALUE;
            while (true) {
                if (i13 > 1) {
                    break;
                }
                if (c(charSequence, charsetArr[i13], i10)) {
                    Latch latchValueOf = Latch.NONE;
                    Charset charset2 = charsetArr[i13];
                    if (charset != charset2) {
                        latchValueOf = Latch.valueOf(charset2.toString());
                        iD2 = 2;
                    } else {
                        iD2 = 1;
                    }
                    if (!z10) {
                        iD2 += d(charSequence, charsetArr[i13], i12);
                    }
                    if (iD2 < i14) {
                        latch = latchValueOf;
                        i14 = iD2;
                    }
                    if (charset == charsetArr[(i13 + 1) % 2]) {
                        Latch latch2 = Latch.SHIFT;
                        int iD3 = z10 ? 2 : 2 + d(charSequence, charset, i12);
                        if (iD3 < i14) {
                            i14 = iD3;
                            latch = latch2;
                        }
                    }
                }
                i13++;
            }
            Charset charset3 = Charset.C;
            if (c(charSequence, charset3, i10)) {
                Latch latch3 = Latch.NONE;
                if (charset != charset3) {
                    latch3 = Latch.C;
                    iD = 2;
                } else {
                    iD = 1;
                }
                int i15 = (charSequence.charAt(i10) != 241 ? 2 : 1) + i10;
                if (i15 < charSequence.length()) {
                    iD += d(charSequence, charset3, i15);
                }
                if (iD < i14) {
                    latch = latch3;
                    i14 = iD;
                }
            }
            if (i14 != Integer.MAX_VALUE) {
                this.f21827a[charset.ordinal()][i10] = i14;
                this.f21828b[charset.ordinal()][i10] = latch;
                return i14;
            }
            throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) charSequence.charAt(i10)));
        }

        public final boolean[] e(String str) {
            this.f21827a = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, str.length());
            this.f21828b = (Latch[][]) Array.newInstance((Class<?>) Latch.class, 4, str.length());
            Charset charset = Charset.NONE;
            d(str, charset, 0);
            ArrayList arrayList = new ArrayList();
            int[] iArr = {0};
            int[] iArr2 = {1};
            int length = str.length();
            int i10 = 0;
            while (i10 < length) {
                Latch latch = this.f21828b[charset.ordinal()][i10];
                int iOrdinal = latch.ordinal();
                int iCharAt = 101;
                if (iOrdinal == 0) {
                    charset = Charset.A;
                    b(arrayList, i10 == 0 ? 103 : 101, iArr, iArr2, i10);
                } else if (iOrdinal == 1) {
                    charset = Charset.B;
                    b(arrayList, i10 == 0 ? 104 : 100, iArr, iArr2, i10);
                } else if (iOrdinal == 2) {
                    charset = Charset.C;
                    b(arrayList, i10 == 0 ? 105 : 99, iArr, iArr2, i10);
                } else if (iOrdinal == 3) {
                    b(arrayList, 98, iArr, iArr2, i10);
                }
                if (charset != Charset.C) {
                    switch (str.charAt(i10)) {
                        case 241:
                            iCharAt = 102;
                            break;
                        case 242:
                            iCharAt = 97;
                            break;
                        case 243:
                            iCharAt = 96;
                            break;
                        case 244:
                            if ((charset != Charset.A || latch == Latch.SHIFT) && (charset != Charset.B || latch != Latch.SHIFT)) {
                                iCharAt = 100;
                                break;
                            }
                            break;
                        default:
                            iCharAt = str.charAt(i10) - ' ';
                            break;
                    }
                    if (((charset == Charset.A && latch != Latch.SHIFT) || (charset == Charset.B && latch == Latch.SHIFT)) && iCharAt < 0) {
                        iCharAt += 96;
                    }
                    b(arrayList, iCharAt, iArr, iArr2, i10);
                } else if (str.charAt(i10) == 241) {
                    b(arrayList, 102, iArr, iArr2, i10);
                } else {
                    b(arrayList, Integer.parseInt(str.substring(i10, i10 + 2)), iArr, iArr2, i10);
                    int i11 = i10 + 1;
                    if (i11 < length) {
                        i10 = i11;
                    }
                }
                i10++;
            }
            this.f21827a = null;
            this.f21828b = null;
            return Code128Writer.m(arrayList, iArr[0]);
        }
    }

    public static int i(String str, Map<EncodeHintType, ?> map) {
        String string;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.FORCE_CODE_SET;
            if (map.containsKey(encodeHintType)) {
                string = map.get(encodeHintType).toString();
                string.getClass();
                switch (string) {
                    case "A":
                        break;
                    case "B":
                        break;
                    case "C":
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported code set hint: " + string);
                }
            }
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            switch (cCharAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (cCharAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) cCharAt));
                    }
                    break;
            }
            /*  JADX ERROR: Method code generation error
                java.lang.NullPointerException: Switch insn not found in header
                	at java.base/java.util.Objects.requireNonNull(Unknown Source)
                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:84)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:195)
                	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:298)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:277)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:410)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                */
            /*
                Method dump skipped, instructions count: 292
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.i(java.lang.String, java.util.Map):int");
        }

        public static int j(CharSequence charSequence, int i10, int i11) {
            CType cTypeL;
            CType cTypeL2;
            char cCharAt;
            CType cTypeL3 = l(charSequence, i10);
            CType cType = CType.ONE_DIGIT;
            if (cTypeL3 == cType) {
                return i11 == 101 ? 101 : 100;
            }
            CType cType2 = CType.UNCODABLE;
            if (cTypeL3 == cType2) {
                return (i10 >= charSequence.length() || ((cCharAt = charSequence.charAt(i10)) >= ' ' && (i11 != 101 || (cCharAt >= '`' && (cCharAt < 241 || cCharAt > 244))))) ? 100 : 101;
            }
            if (i11 == 101 && cTypeL3 == CType.FNC_1) {
                return 101;
            }
            if (i11 == 99) {
                return 99;
            }
            if (i11 != 100) {
                if (cTypeL3 == CType.FNC_1) {
                    cTypeL3 = l(charSequence, i10 + 1);
                }
                return cTypeL3 == CType.TWO_DIGITS ? 99 : 100;
            }
            CType cType3 = CType.FNC_1;
            if (cTypeL3 == cType3 || (cTypeL = l(charSequence, i10 + 2)) == cType2 || cTypeL == cType) {
                return 100;
            }
            if (cTypeL == cType3) {
                return l(charSequence, i10 + 3) == CType.TWO_DIGITS ? 99 : 100;
            }
            int i12 = i10 + 4;
            while (true) {
                cTypeL2 = l(charSequence, i12);
                if (cTypeL2 != CType.TWO_DIGITS) {
                    break;
                }
                i12 += 2;
            }
            return cTypeL2 == CType.ONE_DIGIT ? 100 : 99;
        }

        public static boolean[] k(String str, int i10) throws NumberFormatException {
            int length = str.length();
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 1;
            while (i11 < length) {
                int iJ = i10 == -1 ? j(str, i11, i13) : i10;
                int iCharAt = 100;
                if (iJ == i13) {
                    switch (str.charAt(i11)) {
                        case 241:
                            iCharAt = 102;
                            break;
                        case 242:
                            iCharAt = 97;
                            break;
                        case 243:
                            iCharAt = 96;
                            break;
                        case 244:
                            if (i13 == 101) {
                                iCharAt = 101;
                                break;
                            }
                            break;
                        default:
                            if (i13 == 100) {
                                iCharAt = str.charAt(i11) - ' ';
                                break;
                            } else if (i13 == 101) {
                                char cCharAt = str.charAt(i11);
                                iCharAt = cCharAt - ' ';
                                if (iCharAt < 0) {
                                    iCharAt = cCharAt + '@';
                                    break;
                                }
                            } else {
                                int i15 = i11 + 1;
                                if (i15 == length) {
                                    throw new IllegalArgumentException("Bad number of characters for digit only encoding.");
                                }
                                iCharAt = Integer.parseInt(str.substring(i11, i11 + 2));
                                i11 = i15;
                                break;
                            }
                            break;
                    }
                    i11++;
                } else {
                    if (i13 == 0) {
                        iCharAt = iJ != 100 ? iJ != 101 ? 105 : 103 : 104;
                    } else {
                        iCharAt = iJ;
                    }
                    i13 = iJ;
                }
                arrayList.add(c.f2976a[iCharAt]);
                i12 += iCharAt * i14;
                if (i11 != 0) {
                    i14++;
                }
            }
            return m(arrayList, i12);
        }

        public static CType l(CharSequence charSequence, int i10) {
            int length = charSequence.length();
            if (i10 >= length) {
                return CType.UNCODABLE;
            }
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt == 241) {
                return CType.FNC_1;
            }
            if (cCharAt < '0' || cCharAt > '9') {
                return CType.UNCODABLE;
            }
            int i11 = i10 + 1;
            if (i11 >= length) {
                return CType.ONE_DIGIT;
            }
            char cCharAt2 = charSequence.charAt(i11);
            return (cCharAt2 < '0' || cCharAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
        }

        public static boolean[] m(Collection<int[]> collection, int i10) {
            int i11 = i10 % 103;
            if (i11 < 0) {
                throw new IllegalArgumentException("Unable to compute a valid input checksum");
            }
            int[][] iArr = c.f2976a;
            collection.add(iArr[i11]);
            collection.add(iArr[106]);
            int iB = 0;
            int i12 = 0;
            for (int[] iArr2 : collection) {
                for (int i13 : iArr2) {
                    i12 += i13;
                }
            }
            boolean[] zArr = new boolean[i12];
            Iterator<int[]> it = collection.iterator();
            while (it.hasNext()) {
                iB += m.b(zArr, iB, it.next(), true);
            }
            return zArr;
        }

        @Override // H3.m
        public boolean[] d(String str) {
            return e(str, null);
        }

        @Override // H3.m
        public boolean[] e(String str, Map<EncodeHintType, ?> map) {
            int i10 = i(str, map);
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.CODE128_COMPACT;
                if (map.containsKey(encodeHintType) && Boolean.parseBoolean(map.get(encodeHintType).toString())) {
                    return new MinimalEncoder().e(str);
                }
            }
            return k(str, i10);
        }

        @Override // H3.m
        public Collection<BarcodeFormat> g() {
            return Collections.singleton(BarcodeFormat.CODE_128);
        }
    }
