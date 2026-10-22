package ga;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class i implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final Pattern f4026f;

    public i(String str, j jVar) {
        int i2 = jVar.f4031f;
        Pattern patternCompile = Pattern.compile(str, (i2 & 2) != 0 ? i2 | 64 : i2);
        q7.k.d(patternCompile, "compile(...)");
        this.f4026f = patternCompile;
    }

    public static h a(i iVar, CharSequence charSequence) {
        iVar.getClass();
        q7.k.e(charSequence, "input");
        Matcher matcher = iVar.f4026f.matcher(charSequence);
        q7.k.d(matcher, "matcher(...)");
        if (matcher.find(0)) {
            return new h(matcher, charSequence);
        }
        return null;
    }

    public final h b(CharSequence charSequence) {
        q7.k.e(charSequence, "input");
        Matcher matcher = this.f4026f.matcher(charSequence);
        q7.k.d(matcher, "matcher(...)");
        if (matcher.matches()) {
            return new h(matcher, charSequence);
        }
        return null;
    }

    public final boolean c(String str) {
        q7.k.e(str, "input");
        return this.f4026f.matcher(str).matches();
    }

    public final String d(String str, p7.k kVar) {
        q7.k.e(str, "input");
        h hVarA = a(this, str);
        if (hVarA == null) {
            return str.toString();
        }
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i2 = 0;
        do {
            Matcher matcher = hVarA.f4023a;
            sb2.append((CharSequence) str, i2, nb.i.N(matcher.start(), matcher.end()).f10523f);
            sb2.append((CharSequence) kVar.invoke(hVarA));
            i2 = nb.i.N(matcher.start(), matcher.end()).f10524g + 1;
            CharSequence charSequence = hVarA.f4024b;
            int iEnd = matcher.end() + (matcher.end() != matcher.start() ? 0 : 1);
            h hVar = null;
            if (iEnd <= charSequence.length()) {
                Matcher matcher2 = matcher.pattern().matcher(charSequence);
                q7.k.d(matcher2, "matcher(...)");
                if (matcher2.find(iEnd)) {
                    hVar = new h(matcher2, charSequence);
                }
            }
            hVarA = hVar;
            if (i2 >= length) {
                break;
            }
        } while (hVarA != null);
        if (i2 < length) {
            sb2.append((CharSequence) str, i2, length);
        }
        String string = sb2.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }

    public final String toString() {
        String string = this.f4026f.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }

    public i(String str) {
        q7.k.e(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        q7.k.d(patternCompile, "compile(...)");
        this.f4026f = patternCompile;
    }
}
