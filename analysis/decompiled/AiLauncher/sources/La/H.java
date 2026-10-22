package La;

import Z8.C1168p;
import Z8.C1172u;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import v9.C5678g;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000^\n\u0002\u0010\u000e\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0013\u001a\u001d\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\n\u0010\u0003\u001a\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\n\u0010\u0003\u001a\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001d\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\n\u0010\u0003\u001a\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\b¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\b*\u00020\b¢\u0006\u0004\b\u000b\u0010\n\u001a\u0011\u0010\f\u001a\u00020\b*\u00020\b¢\u0006\u0004\b\f\u0010\n\u001a#\u0010\u0010\u001a\u00020\b*\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a#\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0011\u001a#\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0013\u001a\u0011\u0010\u0017\u001a\u00020\u0016*\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u001a\u001a\u00020\u0016*\u00020\b2\u0006\u0010\u0019\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0019\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0019\u0010 \u001a\u00020\u0000*\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b \u0010!\u001a#\u0010$\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u0000¢\u0006\u0004\b$\u0010%\u001a#\u0010&\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u0000¢\u0006\u0004\b&\u0010'\u001a#\u0010(\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u0000¢\u0006\u0004\b(\u0010%\u001a#\u0010)\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u0000¢\u0006\u0004\b)\u0010'\u001a#\u0010*\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u0000¢\u0006\u0004\b*\u0010%\u001a#\u0010+\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u0000¢\u0006\u0004\b+\u0010'\u001a#\u0010,\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u0000¢\u0006\u0004\b,\u0010%\u001a#\u0010-\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u0000¢\u0006\u0004\b-\u0010'\u001a!\u00100\u001a\u00020\b*\u00020\b2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r¢\u0006\u0004\b0\u00101\u001a\u0019\u00103\u001a\u00020\u0000*\u00020\u00002\u0006\u00102\u001a\u00020\b¢\u0006\u0004\b3\u00104\u001a\u0019\u00106\u001a\u00020\u0000*\u00020\u00002\u0006\u00105\u001a\u00020\b¢\u0006\u0004\b6\u00104\u001a!\u00107\u001a\u00020\u0000*\u00020\u00002\u0006\u00102\u001a\u00020\b2\u0006\u00105\u001a\u00020\b¢\u0006\u0004\b7\u00108\u001a\u0019\u00109\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\"\u001a\u00020\b¢\u0006\u0004\b9\u00104\u001a;\u0010>\u001a\u00020\u0016*\u00020\b2\u0006\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u0016H\u0000¢\u0006\u0004\b>\u0010?\u001a#\u0010A\u001a\u00020\u0016*\u00020\b2\u0006\u0010@\u001a\u00020\u00022\b\b\u0002\u0010=\u001a\u00020\u0016¢\u0006\u0004\bA\u0010B\u001a#\u0010C\u001a\u00020\u0016*\u00020\b2\u0006\u0010@\u001a\u00020\u00022\b\b\u0002\u0010=\u001a\u00020\u0016¢\u0006\u0004\bC\u0010B\u001a#\u0010D\u001a\u00020\u0016*\u00020\b2\u0006\u00102\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020\u0016¢\u0006\u0004\bD\u0010E\u001a+\u0010F\u001a\u00020\u0016*\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u0010.\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0016¢\u0006\u0004\bF\u0010G\u001a#\u0010H\u001a\u00020\u0016*\u00020\b2\u0006\u00105\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020\u0016¢\u0006\u0004\bH\u0010E\u001a#\u0010I\u001a\u00020\u0000*\u00020\b2\u0006\u0010;\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020\u0016¢\u0006\u0004\bI\u0010J\u001a-\u0010K\u001a\u00020\r*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0016¢\u0006\u0004\bK\u0010L\u001a-\u0010M\u001a\u00020\r*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0016¢\u0006\u0004\bM\u0010L\u001a=\u0010O\u001a\u00020\r*\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u00162\b\b\u0002\u0010N\u001a\u00020\u0016H\u0002¢\u0006\u0004\bO\u0010P\u001aG\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0000\u0018\u00010S*\u00020\b2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00000Q2\u0006\u0010.\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u00162\u0006\u0010N\u001a\u00020\u0016H\u0002¢\u0006\u0004\bT\u0010U\u001a-\u0010V\u001a\u00020\r*\u00020\b2\u0006\u0010@\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0016¢\u0006\u0004\bV\u0010W\u001a-\u0010Y\u001a\u00020\r*\u00020\b2\u0006\u0010X\u001a\u00020\u00002\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0016¢\u0006\u0004\bY\u0010Z\u001a-\u0010[\u001a\u00020\r*\u00020\b2\u0006\u0010@\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0016¢\u0006\u0004\b[\u0010W\u001a-\u0010\\\u001a\u00020\r*\u00020\b2\u0006\u0010X\u001a\u00020\u00002\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0016¢\u0006\u0004\b\\\u0010Z\u001a&\u0010]\u001a\u00020\u0016*\u00020\b2\u0006\u0010;\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020\u0016H\u0086\u0002¢\u0006\u0004\b]\u0010E\u001a&\u0010^\u001a\u00020\u0016*\u00020\b2\u0006\u0010@\u001a\u00020\u00022\b\b\u0002\u0010=\u001a\u00020\u0016H\u0086\u0002¢\u0006\u0004\b^\u0010B\u001a?\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001c0a*\u00020\b2\u0006\u0010_\u001a\u00020\u00012\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u00162\b\b\u0002\u0010`\u001a\u00020\rH\u0002¢\u0006\u0004\bb\u0010c\u001aG\u0010e\u001a\b\u0012\u0004\u0012\u00020\u001c0a*\u00020\b2\u000e\u0010_\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000d2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u00162\b\b\u0002\u0010`\u001a\u00020\rH\u0002¢\u0006\u0004\be\u0010f\u001a\u0017\u0010h\u001a\u00020g2\u0006\u0010`\u001a\u00020\rH\u0000¢\u0006\u0004\bh\u0010i\u001a?\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00000a*\u00020\b2\u0012\u0010_\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000d\"\u00020\u00002\b\b\u0002\u0010=\u001a\u00020\u00162\b\b\u0002\u0010`\u001a\u00020\r¢\u0006\u0004\bj\u0010k\u001a?\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00000l*\u00020\b2\u0012\u0010_\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000d\"\u00020\u00002\b\b\u0002\u0010=\u001a\u00020\u00162\b\b\u0002\u0010`\u001a\u00020\r¢\u0006\u0004\bm\u0010n\u001a7\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00000l*\u00020\b2\n\u0010_\u001a\u00020\u0001\"\u00020\u00022\b\b\u0002\u0010=\u001a\u00020\u00162\b\b\u0002\u0010`\u001a\u00020\r¢\u0006\u0004\bo\u0010p\u001a1\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00000l*\u00020\b2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u00162\u0006\u0010`\u001a\u00020\rH\u0002¢\u0006\u0004\bq\u0010r\u001a\u0017\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00000a*\u00020\b¢\u0006\u0004\bs\u0010t\u001a\u0017\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00000l*\u00020\b¢\u0006\u0004\bu\u0010v\u001a\u0015\u0010w\u001a\u0004\u0018\u00010\u0016*\u00020\u0000H\u0007¢\u0006\u0004\bw\u0010x\"\u0015\u0010{\u001a\u00020\u001c*\u00020\b8F¢\u0006\u0006\u001a\u0004\by\u0010z\"\u0015\u0010~\u001a\u00020\r*\u00020\b8F¢\u0006\u0006\u001a\u0004\b|\u0010}¨\u0006\u007f"}, d2 = {"", "", "", "chars", "E1", "(Ljava/lang/String;[C)Ljava/lang/String;", "I1", "G1", "", "D1", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "H1", "F1", "", "length", "padChar", "I0", "(Ljava/lang/CharSequence;IC)Ljava/lang/CharSequence;", "J0", "(Ljava/lang/String;IC)Ljava/lang/String;", "G0", "H0", "", "x0", "(Ljava/lang/CharSequence;)Z", "index", "o0", "(Ljava/lang/CharSequence;I)Z", "Lv9/i;", "range", "l1", "(Ljava/lang/String;Lv9/i;)Ljava/lang/String;", "k1", "(Ljava/lang/CharSequence;Lv9/i;)Ljava/lang/String;", "delimiter", "missingDelimiterValue", "u1", "(Ljava/lang/String;CLjava/lang/String;)Ljava/lang/String;", "v1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "m1", "n1", "y1", "z1", "q1", "r1", "startIndex", "endIndex", "S0", "(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;", "prefix", "R0", "(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;", "suffix", "T0", "V0", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "U0", "thisOffset", "other", "otherOffset", "ignoreCase", "Q0", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z", "char", "f1", "(Ljava/lang/CharSequence;CZ)Z", "h0", "h1", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z", "g1", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IZ)Z", "i0", "b0", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Ljava/lang/String;", "v0", "(Ljava/lang/CharSequence;[CIZ)I", "C0", "last", "r0", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZ)I", "", "strings", "Lkotlin/Pair;", "l0", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZZ)Lkotlin/Pair;", "p0", "(Ljava/lang/CharSequence;CIZ)I", "string", "q0", "(Ljava/lang/CharSequence;Ljava/lang/String;IZ)I", "y0", "z0", "e0", "d0", "delimiters", "limit", "LKa/j;", "K0", "(Ljava/lang/CharSequence;[CIZI)LKa/j;", "", "L0", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)LKa/j;", "LY8/t;", "W0", "(I)V", "c1", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)LKa/j;", "", "Y0", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "X0", "(Ljava/lang/CharSequence;[CZI)Ljava/util/List;", "Z0", "(Ljava/lang/CharSequence;Ljava/lang/String;ZI)Ljava/util/List;", "E0", "(Ljava/lang/CharSequence;)LKa/j;", "F0", "(Ljava/lang/CharSequence;)Ljava/util/List;", "C1", "(Ljava/lang/String;)Ljava/lang/Boolean;", "m0", "(Ljava/lang/CharSequence;)Lv9/i;", "indices", "n0", "(Ljava/lang/CharSequence;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes5.dex */
public class H extends D {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"La/H$a", "LKa/j;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Ka.j<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f4335a;

        public a(CharSequence charSequence) {
            this.f4335a = charSequence;
        }

        @Override // Ka.j
        public Iterator<String> iterator() {
            return new C0959i(this.f4335a);
        }
    }

    public static /* synthetic */ int A0(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = n0(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return y0(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ String A1(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return y1(str, c10, str2);
    }

    public static /* synthetic */ int B0(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = n0(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return z0(charSequence, str, i10, z10);
    }

    public static /* synthetic */ String B1(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return z1(str, str2, str3);
    }

    public static final int C0(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(Z8.r.D0(chars), i10);
        }
        for (int iJ = C5685n.j(i10, n0(charSequence)); -1 < iJ; iJ--) {
            char cCharAt = charSequence.charAt(iJ);
            for (char c10 : chars) {
                if (C0952b.d(c10, cCharAt, z10)) {
                    return iJ;
                }
            }
        }
        return -1;
    }

    public static Boolean C1(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        if (kotlin.jvm.internal.p.d(str, "true")) {
            return Boolean.TRUE;
        }
        if (kotlin.jvm.internal.p.d(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static /* synthetic */ int D0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = n0(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return C0(charSequence, cArr, i10, z10);
    }

    public static CharSequence D1(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zC = C0951a.c(charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static Ka.j<String> E0(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        return new a(charSequence);
    }

    public static String E1(String str, char... chars) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(chars, "chars");
        int length = str.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zO = Z8.r.O(chars, str.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zO) {
                    break;
                }
                length--;
            } else if (zO) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return str.subSequence(i10, length + 1).toString();
    }

    public static List<String> F0(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        return SequencesKt___SequencesKt.d0(E0(charSequence));
    }

    public static CharSequence F1(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i10 = length - 1;
            if (!C0951a.c(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i10 < 0) {
                return "";
            }
            length = i10;
        }
    }

    public static final CharSequence G0(CharSequence charSequence, int i10, char c10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
        }
        if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i10);
        sb2.append(charSequence);
        int length = i10 - charSequence.length();
        int i11 = 1;
        if (1 <= length) {
            while (true) {
                sb2.append(c10);
                if (i11 == length) {
                    break;
                }
                i11++;
            }
        }
        return sb2;
    }

    public static String G1(String str, char... chars) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(chars, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (!Z8.r.O(chars, str.charAt(length))) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
            charSequenceSubSequence = "";
        } else {
            charSequenceSubSequence = "";
        }
        return charSequenceSubSequence.toString();
    }

    public static String H0(String str, int i10, char c10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        return G0(str, i10, c10).toString();
    }

    public static CharSequence H1(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!C0951a.c(charSequence.charAt(i10))) {
                return charSequence.subSequence(i10, charSequence.length());
            }
        }
        return "";
    }

    public static final CharSequence I0(CharSequence charSequence, int i10, char c10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
        }
        if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i10);
        int length = i10 - charSequence.length();
        int i11 = 1;
        if (1 <= length) {
            while (true) {
                sb2.append(c10);
                if (i11 == length) {
                    break;
                }
                i11++;
            }
        }
        sb2.append(charSequence);
        return sb2;
    }

    public static String I1(String str, char... chars) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(chars, "chars");
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                charSequenceSubSequence = "";
                break;
            }
            if (!Z8.r.O(chars, str.charAt(i10))) {
                charSequenceSubSequence = str.subSequence(i10, str.length());
                break;
            }
            i10++;
        }
        return charSequenceSubSequence.toString();
    }

    public static String J0(String str, int i10, char c10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        return I0(str, i10, c10).toString();
    }

    public static final Ka.j<C5680i> K0(CharSequence charSequence, final char[] cArr, int i10, final boolean z10, int i11) {
        W0(i11);
        return new C0954d(charSequence, i10, i11, new p9.p() { // from class: La.E
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return H.O0(cArr, z10, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static final Ka.j<C5680i> L0(CharSequence charSequence, String[] strArr, int i10, final boolean z10, int i11) {
        W0(i11);
        final List listD = C1168p.d(strArr);
        return new C0954d(charSequence, i10, i11, new p9.p() { // from class: La.F
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return H.P0(listD, z10, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static /* synthetic */ Ka.j M0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return K0(charSequence, cArr, i10, z10, i11);
    }

    public static /* synthetic */ Ka.j N0(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return L0(charSequence, strArr, i10, z10, i11);
    }

    public static final Pair O0(char[] cArr, boolean z10, CharSequence DelimitedRangesSequence, int i10) {
        kotlin.jvm.internal.p.i(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int iV0 = v0(DelimitedRangesSequence, cArr, i10, z10);
        if (iV0 < 0) {
            return null;
        }
        return Y8.j.a(Integer.valueOf(iV0), 1);
    }

    public static final Pair P0(List list, boolean z10, CharSequence DelimitedRangesSequence, int i10) {
        kotlin.jvm.internal.p.i(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        Pair<Integer, String> pairL0 = l0(DelimitedRangesSequence, list, i10, z10, false);
        if (pairL0 != null) {
            return Y8.j.a(pairL0.e(), Integer.valueOf(pairL0.f().length()));
        }
        return null;
    }

    public static final boolean Q0(CharSequence charSequence, int i10, CharSequence other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > other.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!C0952b.d(charSequence.charAt(i10 + i13), other.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static String R0(String str, CharSequence prefix) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        if (!j1(str, prefix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence S0(CharSequence charSequence, int i10, int i11) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("End index (" + i11 + ") is less than start index (" + i10 + ").");
        }
        if (i11 == i10) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(charSequence.length() - (i11 - i10));
        sb2.append(charSequence, 0, i10);
        kotlin.jvm.internal.p.h(sb2, "append(...)");
        sb2.append(charSequence, i11, charSequence.length());
        kotlin.jvm.internal.p.h(sb2, "append(...)");
        return sb2;
    }

    public static String T0(String str, CharSequence suffix) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(suffix, "suffix");
        if (!k0(str, suffix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - suffix.length());
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String U0(String str, CharSequence delimiter) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(delimiter, "delimiter");
        return V0(str, delimiter, delimiter);
    }

    public static final String V0(String str, CharSequence prefix, CharSequence suffix) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        kotlin.jvm.internal.p.i(suffix, "suffix");
        if (str.length() < prefix.length() + suffix.length() || !j1(str, prefix, false, 2, null) || !k0(str, suffix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length(), str.length() - suffix.length());
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final void W0(int i10) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
    }

    public static final List<String> X0(CharSequence charSequence, char[] delimiters, boolean z10, int i10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return Z0(charSequence, String.valueOf(delimiters[0]), z10, i10);
        }
        Iterable iterableZ = SequencesKt___SequencesKt.z(M0(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(C1174w.x(iterableZ, 10));
        Iterator it = iterableZ.iterator();
        while (it.hasNext()) {
            arrayList.add(k1(charSequence, (C5680i) it.next()));
        }
        return arrayList;
    }

    public static final List<String> Y0(CharSequence charSequence, String[] delimiters, boolean z10, int i10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return Z0(charSequence, str, z10, i10);
            }
        }
        Iterable iterableZ = SequencesKt___SequencesKt.z(N0(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(C1174w.x(iterableZ, 10));
        Iterator it = iterableZ.iterator();
        while (it.hasNext()) {
            arrayList.add(k1(charSequence, (C5680i) it.next()));
        }
        return arrayList;
    }

    public static final List<String> Z0(CharSequence charSequence, String str, boolean z10, int i10) {
        W0(i10);
        int length = 0;
        int iQ0 = q0(charSequence, str, 0, z10);
        if (iQ0 == -1 || i10 == 1) {
            return C1172u.e(charSequence.toString());
        }
        boolean z11 = i10 > 0;
        ArrayList arrayList = new ArrayList(z11 ? C5685n.j(i10, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iQ0).toString());
            length = str.length() + iQ0;
            if (z11 && arrayList.size() == i10 - 1) {
                break;
            }
            iQ0 = q0(charSequence, str, length, z10);
        } while (iQ0 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List a1(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return X0(charSequence, cArr, z10, i10);
    }

    public static final String b0(CharSequence charSequence, CharSequence other, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        int iMin = Math.min(charSequence.length(), other.length());
        int i10 = 0;
        while (i10 < iMin && C0952b.d(charSequence.charAt(i10), other.charAt(i10), z10)) {
            i10++;
        }
        int i11 = i10 - 1;
        if (o0(charSequence, i11) || o0(other, i11)) {
            i10--;
        }
        return charSequence.subSequence(0, i10).toString();
    }

    public static /* synthetic */ List b1(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return Y0(charSequence, strArr, z10, i10);
    }

    public static /* synthetic */ String c0(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return b0(charSequence, charSequence2, z10);
    }

    public static final Ka.j<String> c1(final CharSequence charSequence, String[] delimiters, boolean z10, int i10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(delimiters, "delimiters");
        return SequencesKt___SequencesKt.R(N0(charSequence, delimiters, 0, z10, i10, 2, null), new InterfaceC5074l() { // from class: La.G
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return H.e1(charSequence, (C5680i) obj);
            }
        });
    }

    public static final boolean d0(CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        return t0(charSequence, c10, 0, z10, 2, null) >= 0;
    }

    public static /* synthetic */ Ka.j d1(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return c1(charSequence, strArr, z10, i10);
    }

    public static boolean e0(CharSequence charSequence, CharSequence other, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        return other instanceof String ? u0(charSequence, (String) other, 0, z10, 2, null) >= 0 : s0(charSequence, other, 0, charSequence.length(), z10, false, 16, null) >= 0;
    }

    public static final String e1(CharSequence charSequence, C5680i it) {
        kotlin.jvm.internal.p.i(it, "it");
        return k1(charSequence, it);
    }

    public static /* synthetic */ boolean f0(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return d0(charSequence, c10, z10);
    }

    public static final boolean f1(CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        return charSequence.length() > 0 && C0952b.d(charSequence.charAt(0), c10, z10);
    }

    public static /* synthetic */ boolean g0(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return e0(charSequence, charSequence2, z10);
    }

    public static boolean g1(CharSequence charSequence, CharSequence prefix, int i10, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        return (!z10 && (charSequence instanceof String) && (prefix instanceof String)) ? D.W((String) charSequence, (String) prefix, i10, false, 4, null) : Q0(charSequence, i10, prefix, 0, prefix.length(), z10);
    }

    public static final boolean h0(CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        return charSequence.length() > 0 && C0952b.d(charSequence.charAt(n0(charSequence)), c10, z10);
    }

    public static boolean h1(CharSequence charSequence, CharSequence prefix, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        return (!z10 && (charSequence instanceof String) && (prefix instanceof String)) ? D.X((String) charSequence, (String) prefix, false, 2, null) : Q0(charSequence, 0, prefix, 0, prefix.length(), z10);
    }

    public static final boolean i0(CharSequence charSequence, CharSequence suffix, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(suffix, "suffix");
        return (!z10 && (charSequence instanceof String) && (suffix instanceof String)) ? D.K((String) charSequence, (String) suffix, false, 2, null) : Q0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z10);
    }

    public static /* synthetic */ boolean i1(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return f1(charSequence, c10, z10);
    }

    public static /* synthetic */ boolean j0(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return h0(charSequence, c10, z10);
    }

    public static /* synthetic */ boolean j1(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return h1(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ boolean k0(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return i0(charSequence, charSequence2, z10);
    }

    public static final String k1(CharSequence charSequence, C5680i range) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(range, "range");
        return charSequence.subSequence(range.l().intValue(), range.k().intValue() + 1).toString();
    }

    public static final Pair<Integer, String> l0(CharSequence charSequence, Collection<String> collection, int i10, boolean z10, boolean z11) {
        CharSequence charSequence2;
        Object next;
        boolean z12;
        Object next2;
        if (!z10 && collection.size() == 1) {
            String str = (String) Z8.F.W0(collection);
            int iU0 = !z11 ? u0(charSequence, str, i10, false, 4, null) : B0(charSequence, str, i10, false, 4, null);
            if (iU0 < 0) {
                return null;
            }
            return Y8.j.a(Integer.valueOf(iU0), str);
        }
        CharSequence charSequence3 = charSequence;
        C5678g c5680i = !z11 ? new C5680i(C5685n.f(i10, 0), charSequence3.length()) : C5685n.p(C5685n.j(i10, n0(charSequence3)), 0);
        if (charSequence3 instanceof String) {
            int iB = c5680i.getFirst();
            int iC = c5680i.getLast();
            int iE = c5680i.getStep();
            if ((iE > 0 && iB <= iC) || (iE < 0 && iC <= iB)) {
                int i11 = iB;
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z12 = z10;
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        z12 = z10;
                        if (D.N(str2, 0, (String) charSequence3, i11, str2.length(), z12)) {
                            break;
                        }
                        z10 = z12;
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (i11 == iC) {
                            break;
                        }
                        i11 += iE;
                        z10 = z12;
                    } else {
                        return Y8.j.a(Integer.valueOf(i11), str3);
                    }
                }
            }
        } else {
            boolean z13 = z10;
            int iB2 = c5680i.getFirst();
            int iC2 = c5680i.getLast();
            int iE2 = c5680i.getStep();
            if ((iE2 > 0 && iB2 <= iC2) || (iE2 < 0 && iC2 <= iB2)) {
                int i12 = iB2;
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            charSequence2 = charSequence3;
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        boolean z14 = z13;
                        charSequence2 = charSequence3;
                        z13 = z14;
                        if (Q0(str4, 0, charSequence2, i12, str4.length(), z14)) {
                            break;
                        }
                        charSequence3 = charSequence2;
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (i12 == iC2) {
                            break;
                        }
                        i12 += iE2;
                        charSequence3 = charSequence2;
                    } else {
                        return Y8.j.a(Integer.valueOf(i12), str5);
                    }
                }
            }
        }
        return null;
    }

    public static String l1(String str, C5680i range) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(range, "range");
        String strSubstring = str.substring(range.l().intValue(), range.k().intValue() + 1);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static C5680i m0(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        return new C5680i(0, charSequence.length() - 1);
    }

    public static String m1(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(missingDelimiterValue, "missingDelimiterValue");
        int iT0 = t0(str, c10, 0, false, 6, null);
        if (iT0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iT0 + 1, str.length());
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static int n0(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static String n1(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(delimiter, "delimiter");
        kotlin.jvm.internal.p.i(missingDelimiterValue, "missingDelimiterValue");
        int iU0 = u0(str, delimiter, 0, false, 6, null);
        if (iU0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iU0 + delimiter.length(), str.length());
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean o0(CharSequence charSequence, int i10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        return i10 >= 0 && i10 <= charSequence.length() + (-2) && Character.isHighSurrogate(charSequence.charAt(i10)) && Character.isLowSurrogate(charSequence.charAt(i10 + 1));
    }

    public static /* synthetic */ String o1(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return m1(str, c10, str2);
    }

    public static final int p0(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? v0(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).indexOf(c10, i10);
    }

    public static /* synthetic */ String p1(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return n1(str, str2, str3);
    }

    public static int q0(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(string, "string");
        return (z10 || !(charSequence instanceof String)) ? s0(charSequence, string, i10, charSequence.length(), z10, false, 16, null) : ((String) charSequence).indexOf(string, i10);
    }

    public static String q1(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(missingDelimiterValue, "missingDelimiterValue");
        int iA0 = A0(str, c10, 0, false, 6, null);
        if (iA0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iA0 + 1, str.length());
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final int r0(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        C5678g c5680i = !z11 ? new C5680i(C5685n.f(i10, 0), C5685n.j(i11, charSequence.length())) : C5685n.p(C5685n.j(i10, n0(charSequence)), C5685n.f(i11, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iB = c5680i.getFirst();
            int iC = c5680i.getLast();
            int iE = c5680i.getStep();
            if ((iE <= 0 || iB > iC) && (iE >= 0 || iC > iB)) {
                return -1;
            }
            int i12 = iB;
            while (true) {
                String str = (String) charSequence2;
                boolean z12 = z10;
                if (D.N(str, 0, (String) charSequence, i12, str.length(), z12)) {
                    return i12;
                }
                if (i12 == iC) {
                    return -1;
                }
                i12 += iE;
                z10 = z12;
            }
        } else {
            boolean z13 = z10;
            int iB2 = c5680i.getFirst();
            int iC2 = c5680i.getLast();
            int iE2 = c5680i.getStep();
            if ((iE2 <= 0 || iB2 > iC2) && (iE2 >= 0 || iC2 > iB2)) {
                return -1;
            }
            int i13 = iB2;
            while (true) {
                boolean z14 = z13;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z13 = z14;
                if (Q0(charSequence4, 0, charSequence3, i13, charSequence2.length(), z14)) {
                    return i13;
                }
                if (i13 == iC2) {
                    return -1;
                }
                i13 += iE2;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }

    public static String r1(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(delimiter, "delimiter");
        kotlin.jvm.internal.p.i(missingDelimiterValue, "missingDelimiterValue");
        int iB0 = B0(str, delimiter, 0, false, 6, null);
        if (iB0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iB0 + delimiter.length(), str.length());
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ int s0(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        return r0(charSequence, charSequence2, i10, i11, z10, z11);
    }

    public static /* synthetic */ String s1(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return q1(str, c10, str2);
    }

    public static /* synthetic */ int t0(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return p0(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ String t1(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return r1(str, str2, str3);
    }

    public static /* synthetic */ int u0(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return q0(charSequence, str, i10, z10);
    }

    public static String u1(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(missingDelimiterValue, "missingDelimiterValue");
        int iT0 = t0(str, c10, 0, false, 6, null);
        if (iT0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iT0);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final int v0(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(Z8.r.D0(chars), i10);
        }
        int iF = C5685n.f(i10, 0);
        int iN0 = n0(charSequence);
        if (iF > iN0) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iF);
            for (char c10 : chars) {
                if (C0952b.d(c10, cCharAt, z10)) {
                    return iF;
                }
            }
            if (iF == iN0) {
                return -1;
            }
            iF++;
        }
    }

    public static final String v1(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(delimiter, "delimiter");
        kotlin.jvm.internal.p.i(missingDelimiterValue, "missingDelimiterValue");
        int iU0 = u0(str, delimiter, 0, false, 6, null);
        if (iU0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iU0);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ int w0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return v0(charSequence, cArr, i10, z10);
    }

    public static /* synthetic */ String w1(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return u1(str, c10, str2);
    }

    public static boolean x0(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (!C0951a.c(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ String x1(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return v1(str, str2, str3);
    }

    public static final int y0(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? C0(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).lastIndexOf(c10, i10);
    }

    public static String y1(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(missingDelimiterValue, "missingDelimiterValue");
        int iA0 = A0(str, c10, 0, false, 6, null);
        if (iA0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iA0);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final int z0(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        kotlin.jvm.internal.p.i(string, "string");
        return (z10 || !(charSequence instanceof String)) ? r0(charSequence, string, i10, 0, z10, true) : ((String) charSequence).lastIndexOf(string, i10);
    }

    public static String z1(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(delimiter, "delimiter");
        kotlin.jvm.internal.p.i(missingDelimiterValue, "missingDelimiterValue");
        int iB0 = B0(str, delimiter, 0, false, 6, null);
        if (iB0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iB0);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }
}
