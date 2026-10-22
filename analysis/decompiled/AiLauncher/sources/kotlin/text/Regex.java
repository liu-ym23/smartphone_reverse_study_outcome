package kotlin.text;

import Ka.j;
import Ka.t;
import La.H;
import La.m;
import La.n;
import La.q;
import Z8.C1172u;
import com.autonavi.aps.amapapi.config.Const;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 \u001c2\u00060\u0001j\u0002`\u0002:\u000296B\u0011\b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fB\u001f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u0005\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0018H\u0086\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001bJ!\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0014\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b \u0010!J%\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\"2\u0006\u0010\u0014\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0014\u001a\u00020\u0018¢\u0006\u0004\b%\u0010&J!\u0010(\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0014\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u001dH\u0007¢\u0006\u0004\b(\u0010!J\u001d\u0010*\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0007¢\u0006\u0004\b*\u0010+J)\u0010.\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00182\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00180,¢\u0006\u0004\b.\u0010/J%\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007012\u0006\u0010\u0014\u001a\u00020\u00182\b\b\u0002\u00100\u001a\u00020\u001d¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u00105R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b8\u00105¨\u0006:"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/regex/Pattern;", "nativePattern", "<init>", "(Ljava/util/regex/Pattern;)V", "", "pattern", "(Ljava/lang/String;)V", "Lkotlin/text/RegexOption;", "option", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "", "options", "(Ljava/lang/String;Ljava/util/Set;)V", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "input", "LY8/t;", "readObject", "(Ljava/io/ObjectInputStream;)V", "", "", "k", "(Ljava/lang/CharSequence;)Z", Const.INTENT_KEY_PKGNAME, "", "startIndex", "LLa/m;", "c", "(Ljava/lang/CharSequence;I)LLa/m;", "LKa/j;", "e", "(Ljava/lang/CharSequence;I)LKa/j;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/CharSequence;)LLa/m;", "index", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "replacement", "l", "(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/Function1;", "transform", "m", "(Ljava/lang/CharSequence;Lp9/l;)Ljava/lang/String;", "limit", "", "n", "(Ljava/lang/CharSequence;I)Ljava/util/List;", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/util/regex/Pattern;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Serialized", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Regex implements Serializable {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Pattern nativePattern;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\f\b\u0002\u0018\u0000 \u00142\u00060\u0001j\u0002`\u0002:\u0001\fB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "pattern", "", "flags", "<init>", "(Ljava/lang/String;I)V", "", "readResolve", "()Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getPattern", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "I", "getFlags", "()I", "c", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Serialized implements Serializable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String pattern;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int flags;

        public Serialized(String pattern, int i10) {
            p.i(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i10;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            p.h(patternCompile, "compile(...)");
            return new Regex(patternCompile);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/text/Regex$a;", "", "<init>", "()V", "", "literal", "c", "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_UMID, "", "flags", Const.INTENT_KEY_PKGNAME, "(I)I", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlin.text.Regex$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final int b(int flags) {
            return (flags & 2) != 0 ? flags | 64 : flags;
        }

        public final String c(String literal) {
            p.i(literal, "literal");
            String strQuote = Pattern.quote(literal);
            p.h(strQuote, "quote(...)");
            return strQuote;
        }

        public final String d(String literal) {
            p.i(literal, "literal");
            String strQuoteReplacement = Matcher.quoteReplacement(literal);
            p.h(strQuoteReplacement, "quoteReplacement(...)");
            return strQuoteReplacement;
        }

        public Companion() {
        }
    }

    public Regex(Pattern nativePattern) {
        p.i(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static /* synthetic */ m d(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.c(charSequence, i10);
    }

    public static /* synthetic */ j f(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.e(charSequence, i10);
    }

    public static final m g(Regex regex, CharSequence charSequence, int i10) {
        return regex.c(charSequence, i10);
    }

    public static /* synthetic */ List q(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.n(charSequence, i10);
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        p.h(strPattern, "pattern(...)");
        return new Serialized(strPattern, this.nativePattern.flags());
    }

    public final boolean b(CharSequence input) {
        p.i(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final m c(CharSequence input, int startIndex) {
        p.i(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        p.h(matcher, "matcher(...)");
        return q.f(matcher, startIndex, input);
    }

    public final j<m> e(final CharSequence input, final int startIndex) {
        p.i(input, "input");
        if (startIndex >= 0 && startIndex <= input.length()) {
            return t.s(new InterfaceC5063a() { // from class: La.p
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Regex.g(this.f4401a, input, startIndex);
                }
            }, Regex$findAll$2.f36179a);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + startIndex + ", input length: " + input.length());
    }

    public final String h() {
        String strPattern = this.nativePattern.pattern();
        p.h(strPattern, "pattern(...)");
        return strPattern;
    }

    public final m i(CharSequence input, int index) {
        p.i(input, "input");
        Matcher matcherRegion = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length());
        if (!matcherRegion.lookingAt()) {
            return null;
        }
        p.f(matcherRegion);
        return new n(matcherRegion, input);
    }

    public final m j(CharSequence input) {
        p.i(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        p.h(matcher, "matcher(...)");
        return q.g(matcher, input);
    }

    public final boolean k(CharSequence input) {
        p.i(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final String l(CharSequence input, String replacement) {
        p.i(input, "input");
        p.i(replacement, "replacement");
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        p.h(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final String m(CharSequence input, InterfaceC5074l<? super m, ? extends CharSequence> transform) {
        p.i(input, "input");
        p.i(transform, "transform");
        int iIntValue = 0;
        m mVarD = d(this, input, 0, 2, null);
        if (mVarD == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb2 = new StringBuilder(length);
        do {
            sb2.append(input, iIntValue, mVarD.a().l().intValue());
            sb2.append(transform.invoke(mVarD));
            iIntValue = mVarD.a().k().intValue() + 1;
            mVarD = mVarD.next();
            if (iIntValue >= length) {
                break;
            }
        } while (mVarD != null);
        if (iIntValue < length) {
            sb2.append(input, iIntValue, length);
        }
        String string = sb2.toString();
        p.h(string, "toString(...)");
        return string;
    }

    public final List<String> n(CharSequence input, int limit) {
        p.i(input, "input");
        H.W0(limit);
        Matcher matcher = this.nativePattern.matcher(input);
        if (limit == 1 || !matcher.find()) {
            return C1172u.e(input.toString());
        }
        ArrayList arrayList = new ArrayList(limit > 0 ? C5685n.j(limit, 10) : 10);
        int i10 = limit - 1;
        int iEnd = 0;
        do {
            arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i10 >= 0 && arrayList.size() == i10) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(iEnd, input.length()).toString());
        return arrayList;
    }

    public String toString() {
        String string = this.nativePattern.toString();
        p.h(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern) {
        p.i(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        p.h(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern, RegexOption option) {
        p.i(pattern, "pattern");
        p.i(option, "option");
        Pattern patternCompile = Pattern.compile(pattern, INSTANCE.b(option.getValue()));
        p.h(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern, Set<? extends RegexOption> options) {
        p.i(pattern, "pattern");
        p.i(options, "options");
        Pattern patternCompile = Pattern.compile(pattern, INSTANCE.b(q.j(options)));
        p.h(patternCompile, "compile(...)");
        this(patternCompile);
    }
}
