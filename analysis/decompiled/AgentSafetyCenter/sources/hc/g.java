package hc;

import h5.t;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final Pattern f5464c;

    public g(String str) {
        Pattern patternCompile = Pattern.compile(str);
        patternCompile.getClass();
        this.f5464c = patternCompile;
    }

    public static f b(g gVar, String str) {
        gVar.getClass();
        str.getClass();
        Matcher matcher = gVar.f5464c.matcher(str);
        matcher.getClass();
        return t.h(matcher, 0, str);
    }

    public final boolean a(String str) {
        str.getClass();
        return this.f5464c.matcher(str).find();
    }

    public final boolean c(CharSequence charSequence) {
        charSequence.getClass();
        return this.f5464c.matcher(charSequence).matches();
    }

    public final String d(String str, String str2) {
        str.getClass();
        String strReplaceAll = this.f5464c.matcher(str).replaceAll(str2);
        strReplaceAll.getClass();
        return strReplaceAll;
    }

    public final String toString() {
        String string = this.f5464c.toString();
        string.getClass();
        return string;
    }
}
