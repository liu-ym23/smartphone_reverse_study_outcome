package La;

import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.SlidingWindowKt;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u00000\n\u0002\u0010\r\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0019\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\r\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\f\u001a\u0019\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\f\u001a\u0019\u0010\u000f\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\f\u001a!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a5\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0011*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001aO\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0019*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"", "", "N1", "(Ljava/lang/CharSequence;)C", "O1", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "P1", "Q1", "", "", "n", "L1", "(Ljava/lang/String;I)Ljava/lang/String;", "M1", "R1", "S1", ContentDisposition.Parameters.Size, "", "K1", "(Ljava/lang/CharSequence;I)Ljava/util/List;", "step", "", "partialWindows", "T1", "(Ljava/lang/CharSequence;IIZ)Ljava/util/List;", "R", "Lkotlin/Function1;", "transform", "U1", "(Ljava/lang/CharSequence;IIZLp9/l;)Ljava/util/List;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes5.dex */
public class K extends I {
    public static List<String> K1(CharSequence charSequence, int i10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        return T1(charSequence, i10, i10, true);
    }

    public static String L1(String str, int i10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(C5685n.j(i10, str.length()));
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static String M1(String str, int i10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        if (i10 >= 0) {
            return R1(str, C5685n.f(str.length() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static char N1(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static Character O1(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    public static char P1(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(H.n0(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char Q1(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    public static String R1(String str, int i10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(0, C5685n.j(i10, str.length()));
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static String S1(String str, int i10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        if (i10 >= 0) {
            int length = str.length();
            String strSubstring = str.substring(length - C5685n.j(i10, length));
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static final List<String> T1(CharSequence charSequence, int i10, int i11, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        return U1(charSequence, i10, i11, z10, new InterfaceC5074l() { // from class: La.J
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return K.V1((CharSequence) obj);
            }
        });
    }

    public static final <R> List<R> U1(CharSequence charSequence, int i10, int i11, boolean z10, InterfaceC5074l<? super CharSequence, ? extends R> transform) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(transform, "transform");
        SlidingWindowKt.a(i10, i11);
        int length = charSequence.length();
        int i12 = 0;
        ArrayList arrayList = new ArrayList((length / i11) + (length % i11 == 0 ? 0 : 1));
        while (i12 >= 0 && i12 < length) {
            int i13 = i12 + i10;
            if (i13 < 0 || i13 > length) {
                if (!z10) {
                    break;
                }
                i13 = length;
            }
            arrayList.add(transform.invoke(charSequence.subSequence(i12, i13)));
            i12 += i11;
        }
        return arrayList;
    }

    public static final String V1(CharSequence it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.toString();
    }
}
