package kotlin.text;

import gc.i;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Regex implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f10092a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Serialized implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final String f10093a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10094b;

        public Serialized(String str, int i10) {
            this.f10093a = str;
            this.f10094b = i10;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.f10093a, this.f10094b);
            g.e(patternCompile, "compile(...)");
            return new Regex(patternCompile);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    public Regex(Pattern pattern) {
        this.f10092a = pattern;
    }

    private final Object writeReplace() {
        Pattern pattern = this.f10092a;
        String strPattern = pattern.pattern();
        g.e(strPattern, "pattern(...)");
        return new Serialized(strPattern, pattern.flags());
    }

    public final boolean a(String input) {
        g.f(input, "input");
        return this.f10092a.matcher(input).find();
    }

    public final i b(CharSequence input, int i10) {
        g.f(input, "input");
        Matcher matcher = this.f10092a.matcher(input);
        g.e(matcher, "matcher(...)");
        if (matcher.find(i10)) {
            return new i(matcher, input);
        }
        return null;
    }

    public final boolean c(String input) {
        g.f(input, "input");
        return this.f10092a.matcher(input).matches();
    }

    public final String d(String input, String str) {
        g.f(input, "input");
        String strReplaceAll = this.f10092a.matcher(input).replaceAll(str);
        g.e(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String e(java.lang.String r10, zb.l r11) {
        /*
            r9 = this;
            java.lang.String r0 = "input"
            kotlin.jvm.internal.g.f(r10, r0)
            r0 = 0
            gc.i r9 = r9.b(r10, r0)
            if (r9 != 0) goto L11
            java.lang.String r9 = r10.toString()
            return r9
        L11:
            int r1 = r10.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r3 = r0
        L1b:
            dc.e r4 = r9.b()
            int r4 = r4.f8451a
            r2.append(r10, r3, r4)
            java.lang.Object r3 = r11.invoke(r9)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.append(r3)
            dc.e r3 = r9.b()
            int r3 = r3.f8452b
            r4 = 1
            int r3 = r3 + r4
            java.lang.CharSequence r5 = r9.f9137b
            java.util.regex.Matcher r9 = r9.f9136a
            int r6 = r9.end()
            int r7 = r9.end()
            int r8 = r9.start()
            if (r7 != r8) goto L48
            goto L49
        L48:
            r4 = r0
        L49:
            int r6 = r6 + r4
            int r4 = r5.length()
            r7 = 0
            if (r6 > r4) goto L64
            java.util.regex.Pattern r9 = r9.pattern()
            java.util.regex.Matcher r9 = r9.matcher(r5)
            java.lang.String r4 = "matcher(...)"
            kotlin.jvm.internal.g.e(r9, r4)
            boolean r4 = r9.find(r6)
            if (r4 != 0) goto L66
        L64:
            r9 = r7
            goto L6c
        L66:
            gc.i r4 = new gc.i
            r4.<init>(r9, r5)
            r9 = r4
        L6c:
            if (r3 >= r1) goto L70
            if (r9 != 0) goto L1b
        L70:
            if (r3 >= r1) goto L75
            r2.append(r10, r3, r1)
        L75:
            java.lang.String r9 = r2.toString()
            java.lang.String r10 = "toString(...)"
            kotlin.jvm.internal.g.e(r9, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.e(java.lang.String, zb.l):java.lang.String");
    }

    public final String toString() {
        String string = this.f10092a.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public Regex(String str) {
        Pattern patternCompile = Pattern.compile(str);
        g.e(patternCompile, "compile(...)");
        this.f10092a = patternCompile;
    }

    public Regex(String str, int i10) {
        RegexOption regexOption = RegexOption.f10095b;
        Pattern patternCompile = Pattern.compile(str, 66);
        g.e(patternCompile, "compile(...)");
        this.f10092a = patternCompile;
    }
}
