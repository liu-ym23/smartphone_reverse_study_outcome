package x5;

import com.stepos.stepclaw.SecurePrefs;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f6301a;

    public l(String str, m mVar) {
        int i8 = mVar.f6305a;
        Pattern patternCompile = Pattern.compile(str, (i8 & 2) != 0 ? i8 | 64 : i8);
        kotlin.jvm.internal.p.d(patternCompile, "compile(...)");
        this.f6301a = patternCompile;
    }

    public static j b(l lVar, String input) {
        lVar.getClass();
        kotlin.jvm.internal.p.e(input, "input");
        Matcher matcher = lVar.f6301a.matcher(input);
        kotlin.jvm.internal.p.d(matcher, "matcher(...)");
        return x.e.a(matcher, 0, input);
    }

    public final boolean a(String input) {
        kotlin.jvm.internal.p.e(input, "input");
        return this.f6301a.matcher(input).find();
    }

    public final j c(int i8, String input) {
        kotlin.jvm.internal.p.e(input, "input");
        Matcher matcherRegion = this.f6301a.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i8, input.length());
        if (matcherRegion.lookingAt()) {
            return new j(matcherRegion, input);
        }
        return null;
    }

    public final j d(String input) {
        kotlin.jvm.internal.p.e(input, "input");
        Matcher matcher = this.f6301a.matcher(input);
        kotlin.jvm.internal.p.d(matcher, "matcher(...)");
        if (matcher.matches()) {
            return new j(matcher, input);
        }
        return null;
    }

    public final boolean e(String input) {
        kotlin.jvm.internal.p.e(input, "input");
        return this.f6301a.matcher(input).matches();
    }

    public final String f(String input) {
        kotlin.jvm.internal.p.e(input, "input");
        String strReplaceAll = this.f6301a.matcher(input).replaceAll(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        kotlin.jvm.internal.p.d(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final String toString() {
        String string = this.f6301a.toString();
        kotlin.jvm.internal.p.d(string, "toString(...)");
        return string;
    }

    public l(String str) {
        Pattern patternCompile = Pattern.compile(str);
        kotlin.jvm.internal.p.d(patternCompile, "compile(...)");
        this.f6301a = patternCompile;
    }

    public l(String str, Set set) {
        Iterator it = set.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            i8 |= ((m) ((d) it.next())).f6305a;
        }
        Pattern patternCompile = Pattern.compile(str, (i8 & 2) != 0 ? i8 | 64 : i8);
        kotlin.jvm.internal.p.d(patternCompile, "compile(...)");
        this.f6301a = patternCompile;
    }
}
