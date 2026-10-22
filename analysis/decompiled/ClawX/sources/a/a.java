package a;

import a6.o0;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.emoji2.text.u;
import androidx.emoji2.text.v;
import b0.e;
import b5.h;
import c5.m;
import com.google.crypto.tink.shaded.protobuf.a0;
import com.google.crypto.tink.shaded.protobuf.b1;
import com.google.crypto.tink.shaded.protobuf.c0;
import com.google.crypto.tink.shaded.protobuf.d;
import com.google.crypto.tink.shaded.protobuf.e1;
import com.google.crypto.tink.shaded.protobuf.i;
import com.google.crypto.tink.shaded.protobuf.q1;
import com.google.crypto.tink.shaded.protobuf.x;
import com.google.crypto.tink.shaded.protobuf.z;
import com.stepos.stepclaw.SecurePrefs;
import e0.l;
import f5.c;
import i5.b;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import k4.g;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.asn1.BERTags;
import x.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a {
    public static int A(byte[] bArr, int i8, d dVar) {
        int i9 = i8 + 1;
        byte b9 = bArr[i8];
        if (b9 < 0) {
            return z(b9, bArr, i9, dVar);
        }
        dVar.f1441b = b9;
        return i9;
    }

    public static int B(int i8, byte[] bArr, int i9, int i10, z zVar, d dVar) {
        x xVar = (x) zVar;
        int iA = A(bArr, i9, dVar);
        xVar.g(dVar.f1441b);
        while (iA < i10) {
            int iA2 = A(bArr, iA, dVar);
            if (i8 != dVar.f1441b) {
                break;
            }
            iA = A(bArr, iA2, dVar);
            xVar.g(dVar.f1441b);
        }
        return iA;
    }

    public static int C(byte[] bArr, int i8, d dVar) {
        int i9 = i8 + 1;
        long j4 = bArr[i8];
        if (j4 >= 0) {
            dVar.f1442c = j4;
            return i9;
        }
        int i10 = i8 + 2;
        byte b9 = bArr[i9];
        long j8 = (j4 & 127) | ((b9 & AbstractJsonLexerKt.TC_INVALID) << 7);
        int i11 = 7;
        while (b9 < 0) {
            int i12 = i10 + 1;
            i11 += 7;
            j8 |= (r10 & AbstractJsonLexerKt.TC_INVALID) << i11;
            b9 = bArr[i10];
            i10 = i12;
        }
        dVar.f1442c = j8;
        return i10;
    }

    public static final void D(c cVar, Throwable th) throws Throwable {
        if (th instanceof o0) {
            th = ((o0) th).f201a;
        }
        cVar.resumeWith(o(th));
        throw th;
    }

    public static final b F(Enum[] entries) {
        p.e(entries, "entries");
        return new b(entries);
    }

    public static String G(i iVar) {
        StringBuilder sb = new StringBuilder(iVar.size());
        for (int i8 = 0; i8 < iVar.size(); i8++) {
            byte bF = iVar.f(i8);
            if (bF == 34) {
                sb.append("\\\"");
            } else if (bF == 39) {
                sb.append("\\'");
            } else if (bF != 92) {
                switch (bF) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case BERTags.RELATIVE_OID /* 13 */:
                        sb.append("\\r");
                        break;
                    default:
                        if (bF < 32 || bF > 126) {
                            sb.append(AbstractJsonLexerKt.STRING_ESC);
                            sb.append((char) (((bF >>> 6) & 3) + 48));
                            sb.append((char) (((bF >>> 3) & 7) + 48));
                            sb.append((char) ((bF & 7) + 48));
                            break;
                        } else {
                            sb.append((char) bF);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static String H(byte[] bArr, boolean z) {
        return h0(f0(bArr), 64, z);
    }

    public static Set I() {
        try {
            Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
            if (objInvoke == null) {
                return Collections.EMPTY_SET;
            }
            Set set = (Set) objInvoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    public static final int J(int i8, int i9, int i10) {
        if (i10 > 0) {
            if (i8 < i9) {
                int i11 = i9 % i10;
                if (i11 < 0) {
                    i11 += i10;
                }
                int i12 = i8 % i10;
                if (i12 < 0) {
                    i12 += i10;
                }
                int i13 = (i11 - i12) % i10;
                if (i13 < 0) {
                    i13 += i10;
                }
                return i9 - i13;
            }
        } else {
            if (i10 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i8 > i9) {
                int i14 = -i10;
                int i15 = i8 % i14;
                if (i15 < 0) {
                    i15 += i14;
                }
                int i16 = i9 % i14;
                if (i16 < 0) {
                    i16 += i14;
                }
                int i17 = (i15 - i16) % i14;
                if (i17 < 0) {
                    i17 += i14;
                }
                return i17 + i9;
            }
        }
        return i9;
    }

    public static l K(Display display, int i8) {
        int i9;
        RoundedCorner roundedCorner = display.getRoundedCorner(i8);
        if (roundedCorner == null) {
            return null;
        }
        int position = roundedCorner.getPosition();
        if (position != 0) {
            i9 = 1;
            if (position != 1) {
                i9 = 2;
                if (position != 2) {
                    i9 = 3;
                    if (position != 3) {
                        throw new IllegalArgumentException(a8.b.j(position, "Invalid position: "));
                    }
                }
            }
        } else {
            i9 = 0;
        }
        return new l(i9, roundedCorner.getRadius(), roundedCorner.getCenter());
    }

    public static final void O(f4.c cVar, String key, String str) {
        p.e(cVar, "<this>");
        p.e(key, "key");
        if (str != null) {
            cVar.f2593c.b(key, str.toString());
        }
    }

    public static boolean P(int i8, Rect rect, Rect rect2) {
        if (i8 == 17) {
            int i9 = rect.right;
            int i10 = rect2.right;
            return (i9 > i10 || rect.left >= i10) && rect.left > rect2.left;
        }
        if (i8 == 33) {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            return (i11 > i12 || rect.top >= i12) && rect.top > rect2.top;
        }
        if (i8 == 66) {
            int i13 = rect.left;
            int i14 = rect2.left;
            return (i13 < i14 || rect.right <= i14) && rect.right < rect2.right;
        }
        if (i8 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i15 = rect.top;
        int i16 = rect2.top;
        return (i15 < i16 || rect.bottom <= i16) && rect.bottom < rect2.bottom;
    }

    public static boolean Q(byte b9) {
        return b9 > -65;
    }

    public static List S(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        p.d(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static long T(byte[] bArr, int i8) {
        return (((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16)) & 4294967295L;
    }

    public static int U(int i8, Rect rect, Rect rect2) {
        int i9;
        int i10;
        if (i8 == 17) {
            i9 = rect.left;
            i10 = rect2.right;
        } else if (i8 == 33) {
            i9 = rect.top;
            i10 = rect2.bottom;
        } else if (i8 == 66) {
            i9 = rect2.left;
            i10 = rect.right;
        } else {
            if (i8 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i9 = rect2.top;
            i10 = rect.bottom;
        }
        return Math.max(0, i9 - i10);
    }

    public static int V(Object obj, b1 b1Var, byte[] bArr, int i8, int i9, d dVar) throws c0 {
        int iZ = i8 + 1;
        int i10 = bArr[i8];
        if (i10 < 0) {
            iZ = z(i10, bArr, iZ, dVar);
            i10 = dVar.f1441b;
        }
        int i11 = iZ;
        if (i10 < 0 || i10 > i9 - i11) {
            throw c0.g();
        }
        int i12 = i11 + i10;
        b1Var.f(obj, bArr, i11, i12, dVar);
        dVar.d = obj;
        return i12;
    }

    public static int W(int i8, Rect rect, Rect rect2) {
        if (i8 != 17) {
            if (i8 != 33) {
                if (i8 != 66) {
                    if (i8 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static void X(InputConnection inputConnection, EditorInfo editorInfo, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static LinkedHashSet Z(Set set, Iterable elements) {
        p.e(set, "<this>");
        p.e(elements, "elements");
        Integer numValueOf = elements instanceof Collection ? Integer.valueOf(((Collection) elements).size()) : null;
        LinkedHashSet linkedHashSet = new LinkedHashSet(c5.z.T(numValueOf != null ? set.size() + numValueOf.intValue() : set.size() * 2));
        linkedHashSet.addAll(set);
        m.p0(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static void a(Throwable th, Throwable exception) {
        p.e(th, "<this>");
        p.e(exception, "exception");
        if (th != exception) {
            Integer num = k5.a.f3654a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(exception);
                return;
            }
            Method method = j5.a.f3509a;
            if (method != null) {
                method.invoke(th, exception);
            }
        }
    }

    public static Set a0(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        p.d(setSingleton, "singleton(...)");
        return setSingleton;
    }

    public static int b(int i8) {
        if (i8 == 1) {
            return 4;
        }
        if (i8 == 2) {
            return 16;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static void b0(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        p.d(stringWriter.toString(), "toString(...)");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(int r8, android.graphics.Rect r9, android.graphics.Rect r10, android.graphics.Rect r11) {
        /*
            boolean r0 = d(r8, r9, r10)
            boolean r1 = d(r8, r9, r11)
            if (r1 != 0) goto L75
            if (r0 != 0) goto Le
            goto L75
        Le:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r2 = 33
            r3 = 66
            r4 = 17
            r5 = 1
            if (r8 == r4) goto L3c
            if (r8 == r2) goto L35
            if (r8 == r3) goto L2e
            if (r8 != r1) goto L28
            int r6 = r9.bottom
            int r7 = r11.top
            if (r6 > r7) goto L74
            goto L42
        L28:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L2e:
            int r6 = r9.right
            int r7 = r11.left
            if (r6 > r7) goto L74
            goto L42
        L35:
            int r6 = r9.top
            int r7 = r11.bottom
            if (r6 < r7) goto L74
            goto L42
        L3c:
            int r6 = r9.left
            int r7 = r11.right
            if (r6 < r7) goto L74
        L42:
            if (r8 == r4) goto L74
            if (r8 != r3) goto L47
            goto L74
        L47:
            int r10 = U(r8, r9, r10)
            if (r8 == r4) goto L69
            if (r8 == r2) goto L64
            if (r8 == r3) goto L5f
            if (r8 != r1) goto L59
            int r8 = r11.bottom
            int r9 = r9.bottom
        L57:
            int r8 = r8 - r9
            goto L6e
        L59:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L5f:
            int r8 = r11.right
            int r9 = r9.right
            goto L57
        L64:
            int r8 = r9.top
            int r9 = r11.top
            goto L57
        L69:
            int r8 = r9.left
            int r9 = r11.left
            goto L57
        L6e:
            int r8 = java.lang.Math.max(r5, r8)
            if (r10 >= r8) goto L75
        L74:
            return r5
        L75:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.c(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static final void c0(Object obj) {
        if (obj instanceof h) {
            throw ((h) obj).f894a;
        }
    }

    public static boolean d(int i8, Rect rect, Rect rect2) {
        if (i8 != 17) {
            if (i8 != 33) {
                if (i8 != 66) {
                    if (i8 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static void d0(long j4, byte[] bArr, int i8) {
        int i9 = 0;
        while (i9 < 4) {
            bArr[i8 + i9] = (byte) (255 & j4);
            i9++;
            j4 >>= 8;
        }
    }

    public static d5.c e(d5.c cVar) {
        cVar.k();
        cVar.f1825c = true;
        return cVar.f1824b > 0 ? cVar : d5.c.d;
    }

    public static String e0(byte[] bArr) {
        return (bArr[0] & 255) + "." + (bArr[1] & 255) + "." + (bArr[2] & 255) + "." + (bArr[3] & 255);
    }

    public static final Charset f(g gVar) {
        p.e(gVar, "<this>");
        String strT = gVar.t("charset");
        if (strT == null) {
            return null;
        }
        try {
            Charset charset = x5.a.f6276a;
            Charset charsetForName = Charset.forName(strT);
            p.d(charsetForName, "forName(...)");
            return charsetForName;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String f0(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i8 = 0; i8 < (bArr.length + 2) / 3; i8++) {
            short[] sArr = new short[3];
            short[] sArr2 = new short[4];
            for (int i9 = 0; i9 < 3; i9++) {
                int i10 = (i8 * 3) + i9;
                if (i10 < bArr.length) {
                    sArr[i9] = (short) (bArr[i10] & 255);
                } else {
                    sArr[i9] = -1;
                }
            }
            sArr2[0] = (short) (sArr[0] >> 2);
            short s8 = sArr[1];
            if (s8 == -1) {
                sArr2[1] = (short) ((sArr[0] & 3) << 4);
            } else {
                sArr2[1] = (short) (((sArr[0] & 3) << 4) + (s8 >> 4));
            }
            short s9 = sArr[1];
            if (s9 == -1) {
                sArr2[3] = 64;
                sArr2[2] = 64;
            } else {
                short s10 = sArr[2];
                if (s10 == -1) {
                    sArr2[2] = (short) ((s9 & 15) << 2);
                    sArr2[3] = 64;
                } else {
                    sArr2[2] = (short) (((s9 & 15) << 2) + (s10 >> 6));
                    sArr2[3] = (short) (sArr[2] & 63);
                }
            }
            for (int i11 = 0; i11 < 4; i11++) {
                byteArrayOutputStream.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(sArr2[i11]));
            }
        }
        return byteArrayOutputStream.toString();
    }

    public static void g(String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static final g g0(g gVar, Charset charset) {
        p.e(gVar, "<this>");
        p.e(charset, "charset");
        String lowerCase = gVar.d.toLowerCase(Locale.ROOT);
        p.d(lowerCase, "toLowerCase(...)");
        return !lowerCase.equals("text") ? gVar : gVar.v("charset", f.V(charset));
    }

    public static void h(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static String h0(String str, int i8, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i9 = 0;
        while (i9 < str.length()) {
            sb.append("\t");
            int i10 = i9 + i8;
            if (i10 >= str.length()) {
                sb.append(str.substring(i9));
                if (z) {
                    sb.append(" )");
                }
            } else {
                sb.append((CharSequence) str, i9, i10);
                sb.append("\n");
            }
            i9 = i10;
        }
        return sb.toString();
    }

    public static void i(int i8, int i9, int i10) {
        if (i8 < 0 || i9 > i10) {
            StringBuilder sbT = a8.b.t("startIndex: ", i8, ", endIndex: ", i9, ", size: ");
            sbT.append(i10);
            throw new IndexOutOfBoundsException(sbT.toString());
        }
        if (i8 > i9) {
            throw new IllegalArgumentException(a8.b.i(i8, i9, "startIndex: ", " > endIndex: "));
        }
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void k(int i8, int i9, int i10) {
        if (i8 < 0 || i9 > i10) {
            StringBuilder sbT = a8.b.t("fromIndex: ", i8, ", toIndex: ", i9, ", size: ");
            sbT.append(i10);
            throw new IndexOutOfBoundsException(sbT.toString());
        }
        if (i8 > i9) {
            throw new IllegalArgumentException(a8.b.i(i8, i9, "fromIndex: ", " > toIndex: "));
        }
    }

    public static int l(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static byte[] m(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        long jT = T(bArr, 0) & 67108863;
        int i8 = 3;
        long jT2 = (T(bArr, 3) >> 2) & 67108611;
        long jT3 = (T(bArr, 6) >> 4) & 67092735;
        long jT4 = (T(bArr, 9) >> 6) & 66076671;
        long jT5 = (T(bArr, 12) >> 8) & 1048575;
        long j4 = jT2 * 5;
        long j8 = jT3 * 5;
        long j9 = jT4 * 5;
        long j10 = jT5 * 5;
        byte[] bArr3 = new byte[17];
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        int i9 = 0;
        while (i9 < bArr2.length) {
            int iMin = Math.min(16, bArr2.length - i9);
            System.arraycopy(bArr2, i9, bArr3, 0, iMin);
            bArr3[iMin] = 1;
            if (iMin != 16) {
                Arrays.fill(bArr3, iMin + 1, 17, (byte) 0);
            }
            long jT6 = j15 + (T(bArr3, 0) & 67108863);
            long jT7 = j11 + ((T(bArr3, i8) >> 2) & 67108863);
            long jT8 = j12 + ((T(bArr3, 6) >> 4) & 67108863);
            long jT9 = j13 + ((T(bArr3, 9) >> 6) & 67108863);
            long j16 = jT2;
            long jT10 = j14 + (((T(bArr3, 12) >> 8) & 67108863) | (bArr3[16] << 24));
            long j17 = (jT10 * j4) + (jT9 * j8) + (jT8 * j9) + (jT7 * j10) + (jT6 * jT);
            long j18 = (jT10 * j8) + (jT9 * j9) + (jT8 * j10) + (jT7 * jT) + (jT6 * j16);
            long j19 = (jT10 * j9) + (jT9 * j10) + (jT8 * jT) + (jT7 * j16) + (jT6 * jT3);
            long j20 = (jT10 * j10) + (jT9 * jT) + (jT8 * j16) + (jT7 * jT3) + (jT6 * jT4);
            long j21 = jT9 * j16;
            long j22 = jT10 * jT;
            long j23 = j18 + (j17 >> 26);
            long j24 = j19 + (j23 >> 26);
            long j25 = j20 + (j24 >> 26);
            long j26 = j22 + j21 + (jT8 * jT3) + (jT7 * jT4) + (jT6 * jT5) + (j25 >> 26);
            long j27 = j26 >> 26;
            j14 = j26 & 67108863;
            long j28 = (j27 * 5) + (j17 & 67108863);
            i9 += 16;
            j12 = j24 & 67108863;
            j13 = j25 & 67108863;
            j15 = j28 & 67108863;
            j11 = (j23 & 67108863) + (j28 >> 26);
            jT2 = j16;
            i8 = 3;
        }
        long j29 = j12 + (j11 >> 26);
        long j30 = j29 & 67108863;
        long j31 = j13 + (j29 >> 26);
        long j32 = j31 & 67108863;
        long j33 = j14 + (j31 >> 26);
        long j34 = j33 & 67108863;
        long j35 = ((j33 >> 26) * 5) + j15;
        long j36 = j35 >> 26;
        long j37 = j35 & 67108863;
        long j38 = (j11 & 67108863) + j36;
        long j39 = j37 + 5;
        long j40 = j39 & 67108863;
        long j41 = j38 + (j39 >> 26);
        long j42 = j30 + (j41 >> 26);
        long j43 = j32 + (j42 >> 26);
        long j44 = j43 & 67108863;
        long j45 = (j34 + (j43 >> 26)) - 67108864;
        long j46 = j45 >> 63;
        long j47 = j37 & j46;
        long j48 = j38 & j46;
        long j49 = j30 & j46;
        long j50 = j32 & j46;
        long j51 = j34 & j46;
        long j52 = ~j46;
        long j53 = j48 | (j41 & 67108863 & j52);
        long j54 = j49 | (j42 & 67108863 & j52);
        long j55 = j50 | (j44 & j52);
        long j56 = (j47 | (j40 & j52) | (j53 << 26)) & 4294967295L;
        long j57 = ((j53 >> 6) | (j54 << 20)) & 4294967295L;
        long j58 = ((j54 >> 12) | (j55 << 14)) & 4294967295L;
        long j59 = ((j55 >> 18) | ((j51 | (j45 & j52)) << 8)) & 4294967295L;
        long jT11 = T(bArr, 16) + j56;
        long j60 = jT11 & 4294967295L;
        long jT12 = T(bArr, 20) + j57 + (jT11 >> 32);
        long jT13 = T(bArr, 24) + j58 + (jT12 >> 32);
        long jT14 = (T(bArr, 28) + j59 + (jT13 >> 32)) & 4294967295L;
        byte[] bArr4 = new byte[16];
        d0(j60, bArr4, 0);
        d0(jT12 & 4294967295L, bArr4, 4);
        d0(jT13 & 4294967295L, bArr4, 8);
        d0(jT14, bArr4, 12);
        return bArr4;
    }

    public static v n(Context context) {
        ProviderInfo providerInfo;
        e eVar;
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        j(packageManager, "Package manager required to locate emoji font provider");
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            eVar = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArr = packageManager.getPackageInfo(str2, 64).signatures;
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArr) {
                    arrayList.add(signature.toByteArray());
                }
                eVar = new e(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList), null, null);
            } catch (PackageManager.NameNotFoundException e9) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e9);
            }
        }
        if (eVar == null) {
            return null;
        }
        return new v(new u(context, eVar));
    }

    public static final h o(Throwable exception) {
        p.e(exception, "exception");
        return new h(exception);
    }

    public static d5.c p() {
        return new d5.c(10);
    }

    public static byte[] q(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr2 = new byte[16];
        for (int i8 = 0; i8 < 16; i8++) {
            byte b9 = (byte) ((bArr[i8] << 1) & 254);
            bArr2[i8] = b9;
            if (i8 < 15) {
                bArr2[i8] = (byte) (((byte) ((bArr[i8 + 1] >> 7) & 1)) | b9);
            }
        }
        bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
        return bArr2;
    }

    public static int r(byte[] bArr, int i8, d dVar) throws c0 {
        int iA = A(bArr, i8, dVar);
        int i9 = dVar.f1441b;
        if (i9 < 0) {
            throw c0.e();
        }
        if (i9 > bArr.length - iA) {
            throw c0.g();
        }
        if (i9 == 0) {
            dVar.d = i.f1465b;
            return iA;
        }
        dVar.d = i.h(iA, i9, bArr);
        return iA + i9;
    }

    public static int s(byte[] bArr, int i8) {
        return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
    }

    public static long t(byte[] bArr, int i8) {
        return ((bArr[i8 + 7] & 255) << 56) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24) | ((bArr[i8 + 4] & 255) << 32) | ((bArr[i8 + 5] & 255) << 40) | ((bArr[i8 + 6] & 255) << 48);
    }

    public static int u(b1 b1Var, int i8, byte[] bArr, int i9, int i10, z zVar, d dVar) throws c0 {
        Object objD = b1Var.d();
        b1 b1Var2 = b1Var;
        byte[] bArr2 = bArr;
        int i11 = i10;
        d dVar2 = dVar;
        int iV = V(objD, b1Var2, bArr2, i9, i11, dVar2);
        b1Var2.b(objD);
        dVar2.d = objD;
        zVar.add(objD);
        while (iV < i11) {
            d dVar3 = dVar2;
            int i12 = i11;
            int iA = A(bArr2, iV, dVar3);
            if (i8 != dVar3.f1441b) {
                break;
            }
            byte[] bArr3 = bArr2;
            b1 b1Var3 = b1Var2;
            Object objD2 = b1Var3.d();
            iV = V(objD2, b1Var3, bArr3, iA, i12, dVar3);
            b1Var2 = b1Var3;
            bArr2 = bArr3;
            i11 = i12;
            dVar2 = dVar3;
            b1Var2.b(objD2);
            dVar2.d = objD2;
            zVar.add(objD2);
        }
        return iV;
    }

    public static int v(byte[] bArr, int i8, d dVar) throws c0 {
        int iA = A(bArr, i8, dVar);
        int i9 = dVar.f1441b;
        if (i9 < 0) {
            throw c0.e();
        }
        if (i9 == 0) {
            dVar.d = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            return iA;
        }
        dVar.d = new String(bArr, iA, i9, a0.f1428a);
        return iA + i9;
    }

    public static int w(byte[] bArr, int i8, d dVar) throws c0 {
        int iA = A(bArr, i8, dVar);
        int i9 = dVar.f1441b;
        if (i9 < 0) {
            throw c0.e();
        }
        if (i9 == 0) {
            dVar.d = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            return iA;
        }
        dVar.d = q1.f1510a.y(iA, i9, bArr);
        return iA + i9;
    }

    public static int x(int i8, byte[] bArr, int i9, int i10, e1 e1Var, d dVar) throws c0 {
        if ((i8 >>> 3) == 0) {
            throw c0.a();
        }
        int i11 = i8 & 7;
        if (i11 == 0) {
            int iC = C(bArr, i9, dVar);
            e1Var.d(i8, Long.valueOf(dVar.f1442c));
            return iC;
        }
        if (i11 == 1) {
            e1Var.d(i8, Long.valueOf(t(bArr, i9)));
            return i9 + 8;
        }
        if (i11 == 2) {
            int iA = A(bArr, i9, dVar);
            int i12 = dVar.f1441b;
            if (i12 < 0) {
                throw c0.e();
            }
            if (i12 > bArr.length - iA) {
                throw c0.g();
            }
            if (i12 == 0) {
                e1Var.d(i8, i.f1465b);
            } else {
                e1Var.d(i8, i.h(iA, i12, bArr));
            }
            return iA + i12;
        }
        if (i11 != 3) {
            if (i11 != 5) {
                throw c0.a();
            }
            e1Var.d(i8, Integer.valueOf(s(bArr, i9)));
            return i9 + 4;
        }
        e1 e1VarC = e1.c();
        int i13 = (i8 & (-8)) | 4;
        int i14 = 0;
        while (true) {
            if (i9 >= i10) {
                break;
            }
            int iA2 = A(bArr, i9, dVar);
            i14 = dVar.f1441b;
            if (i14 == i13) {
                i9 = iA2;
                break;
            }
            i9 = x(i14, bArr, iA2, i10, e1VarC, dVar);
        }
        if (i9 > i10 || i14 != i13) {
            throw c0.f();
        }
        e1Var.d(i8, e1VarC);
        return i9;
    }

    public static int z(int i8, byte[] bArr, int i9, d dVar) {
        int i10 = i8 & 127;
        int i11 = i9 + 1;
        byte b9 = bArr[i9];
        if (b9 >= 0) {
            dVar.f1441b = i10 | (b9 << 7);
            return i11;
        }
        int i12 = i10 | ((b9 & AbstractJsonLexerKt.TC_INVALID) << 7);
        int i13 = i9 + 2;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            dVar.f1441b = i12 | (b10 << 14);
            return i13;
        }
        int i14 = i12 | ((b10 & AbstractJsonLexerKt.TC_INVALID) << 14);
        int i15 = i9 + 3;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            dVar.f1441b = i14 | (b11 << 21);
            return i15;
        }
        int i16 = i14 | ((b11 & AbstractJsonLexerKt.TC_INVALID) << 21);
        int i17 = i9 + 4;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            dVar.f1441b = i16 | (b12 << 28);
            return i17;
        }
        int i18 = i16 | ((b12 & AbstractJsonLexerKt.TC_INVALID) << 28);
        while (true) {
            int i19 = i17 + 1;
            if (bArr[i17] >= 0) {
                dVar.f1441b = i18;
                return i19;
            }
            i17 = i19;
        }
    }

    public abstract int E(String str, byte[] bArr, int i8, int i9);

    public abstract int L(View view, ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract int M();

    public abstract ViewPropertyAnimator N(View view, int i8);

    public boolean R(int i8, int i9, byte[] bArr) {
        return Y(i8, i9, bArr) == 0;
    }

    public abstract int Y(int i8, int i9, byte[] bArr);

    public abstract void i0(int i8, int i9, byte[] bArr);

    public abstract String y(int i8, int i9, byte[] bArr);
}
