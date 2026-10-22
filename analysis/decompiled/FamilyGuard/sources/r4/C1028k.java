package r4;

import i4.InterfaceC0772l;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: r4.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1028k implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f20114b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Pattern f20115a;

    /* renamed from: r4.k$a */
    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i5) {
            return (i5 & 2) != 0 ? i5 | 64 : i5;
        }

        private a() {
        }
    }

    public C1028k(Pattern pattern) {
        j4.k.g(pattern, "nativePattern");
        this.f20115a = pattern;
    }

    public static /* synthetic */ InterfaceC1025h c(C1028k c1028k, CharSequence charSequence, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        return c1028k.b(charSequence, i5);
    }

    public final boolean a(CharSequence charSequence) {
        j4.k.g(charSequence, "input");
        return this.f20115a.matcher(charSequence).find();
    }

    public final InterfaceC1025h b(CharSequence charSequence, int i5) {
        j4.k.g(charSequence, "input");
        Matcher matcher = this.f20115a.matcher(charSequence);
        j4.k.f(matcher, "matcher(...)");
        return C1029l.d(matcher, i5, charSequence);
    }

    public final boolean d(CharSequence charSequence) {
        j4.k.g(charSequence, "input");
        return this.f20115a.matcher(charSequence).matches();
    }

    public final String e(CharSequence charSequence, InterfaceC0772l<? super InterfaceC1025h, ? extends CharSequence> interfaceC0772l) {
        j4.k.g(charSequence, "input");
        j4.k.g(interfaceC0772l, "transform");
        int iIntValue = 0;
        InterfaceC1025h interfaceC1025hC = c(this, charSequence, 0, 2, null);
        if (interfaceC1025hC == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(charSequence, iIntValue, interfaceC1025hC.b().n().intValue());
            sb.append(interfaceC0772l.invoke(interfaceC1025hC));
            iIntValue = interfaceC1025hC.b().m().intValue() + 1;
            interfaceC1025hC = interfaceC1025hC.next();
            if (iIntValue >= length) {
                break;
            }
        } while (interfaceC1025hC != null);
        if (iIntValue < length) {
            sb.append(charSequence, iIntValue, length);
        }
        String string = sb.toString();
        j4.k.f(string, "toString(...)");
        return string;
    }

    public final String f(CharSequence charSequence, String str) {
        j4.k.g(charSequence, "input");
        j4.k.g(str, "replacement");
        String strReplaceAll = this.f20115a.matcher(charSequence).replaceAll(str);
        j4.k.f(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public String toString() {
        String string = this.f20115a.toString();
        j4.k.f(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C1028k(String str) {
        j4.k.g(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        j4.k.f(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C1028k(String str, EnumC1030m enumC1030m) {
        j4.k.g(str, "pattern");
        j4.k.g(enumC1030m, "option");
        Pattern patternCompile = Pattern.compile(str, f20114b.b(enumC1030m.d()));
        j4.k.f(patternCompile, "compile(...)");
        this(patternCompile);
    }
}
