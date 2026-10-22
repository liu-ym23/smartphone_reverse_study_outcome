package kotlin.text;

import A6.i;
import B7.a;
import H4.o;
import O7.h;
import j9.l;
import j9.m;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "input", "LC7/r;", "readObject", "(Ljava/io/ObjectInputStream;)V", "Serialized", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Regex implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f5167a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Serialized implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final String f5168a;
        public final int b;

        public Serialized(String str, int i) {
            this.f5168a = str;
            this.b = i;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.f5168a, this.b);
            k.e(patternCompile, "compile(...)");
            return new Regex(patternCompile);
        }
    }

    public Regex(Pattern pattern) {
        this.f5167a = pattern;
    }

    public static h c(Regex regex, String input) {
        regex.getClass();
        k.f(input, "input");
        if (input.length() < 0) {
            StringBuilder sbU = a.u(0, "Start index out of bounds: ", ", input length: ");
            sbU.append(input.length());
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        i iVar = new i(17, regex, input);
        Regex$findAll$2 nextFunction = Regex$findAll$2.f5169a;
        k.f(nextFunction, "nextFunction");
        return new h(iVar, nextFunction);
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        Pattern pattern = this.f5167a;
        String strPattern = pattern.pattern();
        k.e(strPattern, "pattern(...)");
        return new Serialized(strPattern, pattern.flags());
    }

    public final boolean a(String input) {
        k.f(input, "input");
        return this.f5167a.matcher(input).find();
    }

    public final l b(CharSequence input) {
        k.f(input, "input");
        Matcher matcher = this.f5167a.matcher(input);
        k.e(matcher, "matcher(...)");
        if (matcher.find(0)) {
            return new l(matcher, input);
        }
        return null;
    }

    public final boolean d(String input) {
        k.f(input, "input");
        return this.f5167a.matcher(input).matches();
    }

    public final String e(S7.k kVar, String input) {
        k.f(input, "input");
        l lVarB = b(input);
        if (lVarB == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        do {
            sb.append((CharSequence) input, i, lVarB.b().f1569a);
            sb.append((CharSequence) kVar.invoke(lVarB));
            i = lVarB.b().b + 1;
            lVarB = lVarB.d();
            if (i >= length) {
                break;
            }
        } while (lVarB != null);
        if (i < length) {
            sb.append((CharSequence) input, i, length);
        }
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public final String f(String input, String str) {
        k.f(input, "input");
        String strReplaceAll = this.f5167a.matcher(input).replaceAll(str);
        k.e(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final List g(String str) {
        int iEnd = 0;
        m.B0(0);
        Matcher matcher = this.f5167a.matcher(str);
        if (!matcher.find()) {
            return o.M(str.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        do {
            arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
        } while (matcher.find());
        arrayList.add(str.subSequence(iEnd, str.length()).toString());
        return arrayList;
    }

    public final String toString() {
        String string = this.f5167a.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public Regex(String pattern) {
        k.f(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        k.e(patternCompile, "compile(...)");
        this.f5167a = patternCompile;
    }
}
