package io.ktor.http.cio.internals;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.HttpMethod;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000V\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\u001a'\u0010\u0004\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u0001H\u0082\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\r\u001a\u00020\f*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u000f\u001a\u00020\f*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u00020\f*\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001f\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0017\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001c\u0010\u001e\"\u0014\u0010 \u001a\u00020\u001f8\u0000X\u0080T¢\u0006\u0006\n\u0004\b \u0010!\" \u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*\"\u001a\u0010,\u001a\u00020+8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "hashCodeLowerCase", "(Ljava/lang/CharSequence;II)I", "other", "", "equalsLowerCase", "(Ljava/lang/CharSequence;IILjava/lang/CharSequence;)Z", "toLowerCase", "(I)I", "", "parseHexLong", "(Ljava/lang/CharSequence;)J", "parseDecLong", "parseDecLongWithCheck", "Lio/ktor/utils/io/ByteWriteChannel;", UxipConstants.f30680s, "LY8/t;", "writeIntHex", "(Lio/ktor/utils/io/ByteWriteChannel;ILe9/c;)Ljava/lang/Object;", "s", "idx", "", "hexNumberFormatException", "(Ljava/lang/CharSequence;I)Ljava/lang/Void;", "cs", "numberFormatException", "(Ljava/lang/CharSequence;I)V", "(Ljava/lang/CharSequence;)V", "", "HTAB", "C", "Lio/ktor/http/cio/internals/AsciiCharTree;", "Lio/ktor/http/HttpMethod;", "DefaultHttpMethods", "Lio/ktor/http/cio/internals/AsciiCharTree;", "getDefaultHttpMethods", "()Lio/ktor/http/cio/internals/AsciiCharTree;", "", "HexTable", "[J", "", "HexLetterTable", "[B", "getHexLetterTable", "()[B", "ktor-http-cio"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CharsKt {
    private static final AsciiCharTree<HttpMethod> DefaultHttpMethods = AsciiCharTree.INSTANCE.build(HttpMethod.INSTANCE.getDefaultMethods(), new InterfaceC5074l() { // from class: io.ktor.http.cio.internals.c
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return Integer.valueOf(CharsKt.DefaultHttpMethods$lambda$0((HttpMethod) obj));
        }
    }, new p() { // from class: io.ktor.http.cio.internals.d
        @Override // p9.p
        public final Object invoke(Object obj, Object obj2) {
            return Character.valueOf(CharsKt.DefaultHttpMethods$lambda$1((HttpMethod) obj, ((Integer) obj2).intValue()));
        }
    });
    public static final char HTAB = '\t';
    private static final byte[] HexLetterTable;
    private static final long[] HexTable;

    @InterfaceC4112d(c = "io.ktor.http.cio.internals.CharsKt", f = "Chars.kt", l = {110, 118}, m = "writeIntHex")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.internals.CharsKt$writeIntHex$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CharsKt.writeIntHex(null, 0, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056 A[PHI: r6
      0x0056: PHI (r6v2 long) = (r6v1 long), (r6v0 long) binds: [B:18:0x0064, B:13:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    static {
        /*
            io.ktor.http.cio.internals.AsciiCharTree$Companion r0 = io.ktor.http.cio.internals.AsciiCharTree.INSTANCE
            io.ktor.http.HttpMethod$Companion r1 = io.ktor.http.HttpMethod.INSTANCE
            java.util.List r1 = r1.getDefaultMethods()
            io.ktor.http.cio.internals.c r2 = new io.ktor.http.cio.internals.c
            r2.<init>()
            io.ktor.http.cio.internals.d r3 = new io.ktor.http.cio.internals.d
            r3.<init>()
            io.ktor.http.cio.internals.AsciiCharTree r0 = r0.build(r1, r2, r3)
            io.ktor.http.cio.internals.CharsKt.DefaultHttpMethods = r0
            v9.i r0 = new v9.i
            r1 = 255(0xff, float:3.57E-43)
            r2 = 0
            r0.<init>(r2, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r3 = 10
            int r4 = Z8.C1174w.x(r0, r3)
            r1.<init>(r4)
            java.util.Iterator r0 = r0.iterator()
        L2f:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L71
            r4 = r0
            Z8.M r4 = (Z8.M) r4
            int r4 = r4.nextInt()
            r5 = 48
            if (r5 > r4) goto L49
            r5 = 58
            if (r4 >= r5) goto L49
            long r4 = (long) r4
            r6 = 48
            long r4 = r4 - r6
            goto L69
        L49:
            long r4 = (long) r4
            r6 = 97
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L5a
            r8 = 102(0x66, double:5.04E-322)
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 > 0) goto L5a
        L56:
            long r4 = r4 - r6
            long r6 = (long) r3
            long r4 = r4 + r6
            goto L69
        L5a:
            r6 = 65
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L67
            r8 = 70
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 > 0) goto L67
            goto L56
        L67:
            r4 = -1
        L69:
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.add(r4)
            goto L2f
        L71:
            long[] r0 = Z8.F.n1(r1)
            io.ktor.http.cio.internals.CharsKt.HexTable = r0
            v9.i r0 = new v9.i
            r1 = 15
            r0.<init>(r2, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = Z8.C1174w.x(r0, r3)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L8b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Lac
            r2 = r0
            Z8.M r2 = (Z8.M) r2
            int r2 = r2.nextInt()
            if (r2 >= r3) goto L9e
            int r2 = r2 + 48
        L9c:
            byte r2 = (byte) r2
            goto La4
        L9e:
            int r2 = r2 + 97
            char r2 = (char) r2
            int r2 = r2 - r3
            char r2 = (char) r2
            goto L9c
        La4:
            java.lang.Byte r2 = java.lang.Byte.valueOf(r2)
            r1.add(r2)
            goto L8b
        Lac:
            byte[] r0 = Z8.F.i1(r1)
            io.ktor.http.cio.internals.CharsKt.HexLetterTable = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.internals.CharsKt.<clinit>():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int DefaultHttpMethods$lambda$0(HttpMethod it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getValue().length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final char DefaultHttpMethods$lambda$1(HttpMethod m10, int i10) {
        kotlin.jvm.internal.p.i(m10, "m");
        return m10.getValue().charAt(i10);
    }

    public static final boolean equalsLowerCase(CharSequence charSequence, int i10, int i11, CharSequence other) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        if (i11 - i10 != other.length()) {
            return false;
        }
        for (int i12 = i10; i12 < i11; i12++) {
            int iCharAt = charSequence.charAt(i12);
            if (65 <= iCharAt && iCharAt < 91) {
                iCharAt += 32;
            }
            int iCharAt2 = other.charAt(i12 - i10);
            if (65 <= iCharAt2 && iCharAt2 < 91) {
                iCharAt2 += 32;
            }
            if (iCharAt != iCharAt2) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean equalsLowerCase$default(CharSequence charSequence, int i10, int i11, CharSequence charSequence2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = charSequence.length();
        }
        return equalsLowerCase(charSequence, i10, i11, charSequence2);
    }

    public static final AsciiCharTree<HttpMethod> getDefaultHttpMethods() {
        return DefaultHttpMethods;
    }

    public static final byte[] getHexLetterTable() {
        return HexLetterTable;
    }

    public static final int hashCodeLowerCase(CharSequence charSequence, int i10, int i11) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        int i12 = 0;
        while (i10 < i11) {
            int iCharAt = charSequence.charAt(i10);
            if (65 <= iCharAt && iCharAt < 91) {
                iCharAt += 32;
            }
            i12 = (i12 * 31) + iCharAt;
            i10++;
        }
        return i12;
    }

    public static /* synthetic */ int hashCodeLowerCase$default(CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = charSequence.length();
        }
        return hashCodeLowerCase(charSequence, i10, i11);
    }

    private static final Void hexNumberFormatException(CharSequence charSequence, int i10) {
        throw new NumberFormatException("Invalid HEX number: " + ((Object) charSequence) + ", wrong digit: " + charSequence.charAt(i10));
    }

    private static final void numberFormatException(CharSequence charSequence, int i10) {
        throw new NumberFormatException("Invalid number: " + ((Object) charSequence) + ", wrong digit: " + charSequence.charAt(i10) + " at position " + i10);
    }

    public static final long parseDecLong(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        int length = charSequence.length();
        if (length > 19) {
            numberFormatException(charSequence);
        }
        if (length == 19) {
            return parseDecLongWithCheck(charSequence);
        }
        long j10 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            long jCharAt = charSequence.charAt(i10) - 48;
            if (jCharAt < 0 || jCharAt > 9) {
                numberFormatException(charSequence, i10);
            }
            j10 = (j10 << 3) + (j10 << 1) + jCharAt;
        }
        return j10;
    }

    private static final long parseDecLongWithCheck(CharSequence charSequence) {
        int length = charSequence.length();
        long j10 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            long jCharAt = charSequence.charAt(i10) - 48;
            if (jCharAt < 0 || jCharAt > 9) {
                numberFormatException(charSequence, i10);
            }
            j10 = (j10 << 3) + (j10 << 1) + jCharAt;
            if (j10 < 0) {
                numberFormatException(charSequence);
            }
        }
        return j10;
    }

    public static final long parseHexLong(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        long[] jArr = HexTable;
        int length = charSequence.length();
        long j10 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            int iCharAt = charSequence.charAt(i10) & 65535;
            long j11 = iCharAt < 255 ? jArr[iCharAt] : -1L;
            if (j11 == -1) {
                hexNumberFormatException(charSequence, i10);
                throw new KotlinNothingValueException();
            }
            j10 = (j10 << 4) | j11;
        }
        return j10;
    }

    private static final int toLowerCase(int i10) {
        return (65 > i10 || i10 >= 91) ? i10 : i10 + 32;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0070, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeByte(r9, r8, r0) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writeIntHex(io.ktor.utils.io.ByteWriteChannel r9, int r10, e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof io.ktor.http.cio.internals.CharsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.http.cio.internals.CharsKt$writeIntHex$1 r0 = (io.ktor.http.cio.internals.CharsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.http.cio.internals.CharsKt$writeIntHex$1 r0 = new io.ktor.http.cio.internals.CharsKt$writeIntHex$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 8
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L49
            if (r2 == r5) goto L33
            if (r2 != r4) goto L2b
            goto L33
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L33:
            int r9 = r0.I$2
            int r10 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$1
            byte[] r5 = (byte[]) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            kotlin.C4849c.b(r11)
            r7 = r9
            r9 = r6
            r6 = r10
            r10 = r2
            goto L76
        L49:
            kotlin.C4849c.b(r11)
            if (r10 <= 0) goto L9a
            byte[] r11 = io.ktor.http.cio.internals.CharsKt.HexLetterTable
            r2 = 0
            r6 = r10
        L52:
            int r7 = r2 + 1
            if (r2 >= r3) goto L75
            int r2 = r6 >>> 28
            int r6 = r6 << 4
            if (r2 == 0) goto L73
            r8 = r11[r2]
            r0.L$0 = r9
            r0.L$1 = r11
            r0.I$0 = r10
            r0.I$1 = r6
            r0.I$2 = r7
            r0.I$3 = r2
            r0.label = r5
            java.lang.Object r2 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writeByte(r9, r8, r0)
            if (r2 != r1) goto L75
            goto L94
        L73:
            r2 = r7
            goto L52
        L75:
            r5 = r11
        L76:
            int r11 = r7 + 1
            if (r7 >= r3) goto L97
            int r2 = r6 >>> 28
            int r6 = r6 << 4
            r7 = r5[r2]
            r0.L$0 = r9
            r0.L$1 = r5
            r0.I$0 = r10
            r0.I$1 = r6
            r0.I$2 = r11
            r0.I$3 = r2
            r0.label = r4
            java.lang.Object r2 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writeByte(r9, r7, r0)
            if (r2 != r1) goto L95
        L94:
            return r1
        L95:
            r7 = r11
            goto L76
        L97:
            Y8.t r9 = Y8.t.f7040a
            return r9
        L9a:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Does only work for positive numbers"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.internals.CharsKt.writeIntHex(io.ktor.utils.io.ByteWriteChannel, int, e9.c):java.lang.Object");
    }

    private static final void numberFormatException(CharSequence charSequence) {
        throw new NumberFormatException("Invalid number " + ((Object) charSequence) + ": too large for Long type");
    }
}
