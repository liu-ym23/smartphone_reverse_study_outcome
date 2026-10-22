package j9;

import D7.K;
import g1.AbstractC1451a;
import java.util.List;
import java.util.regex.Matcher;

/* loaded from: classes4.dex */
public final class l implements InterfaceC1616j {

    /* renamed from: a, reason: collision with root package name */
    public final Matcher f4788a;
    public final CharSequence b;
    public final C1617k c;
    public K d;

    public l(Matcher matcher, CharSequence input) {
        kotlin.jvm.internal.k.f(input, "input");
        this.f4788a = matcher;
        this.b = input;
        this.c = new C1617k(this);
    }

    public final List a() {
        if (this.d == null) {
            this.d = new K(this);
        }
        K k = this.d;
        kotlin.jvm.internal.k.c(k);
        return k;
    }

    public final Y7.f b() {
        Matcher matcher = this.f4788a;
        return AbstractC1451a.X(matcher.start(), matcher.end());
    }

    public final String c() {
        String strGroup = this.f4788a.group();
        kotlin.jvm.internal.k.e(strGroup, "group(...)");
        return strGroup;
    }

    public final l d() {
        Matcher matcher = this.f4788a;
        int iEnd = matcher.end() + (matcher.end() == matcher.start() ? 1 : 0);
        CharSequence charSequence = this.b;
        if (iEnd > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        kotlin.jvm.internal.k.e(matcher2, "matcher(...)");
        if (matcher2.find(iEnd)) {
            return new l(matcher2, charSequence);
        }
        return null;
    }
}
