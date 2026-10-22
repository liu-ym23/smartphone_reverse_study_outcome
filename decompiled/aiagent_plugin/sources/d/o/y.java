package d.o;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes4.dex */
class y extends x {

    /* JADX INFO: compiled from: Strings.kt */
    static final class a extends d.h.b.p implements d.h.a.m<CharSequence, Integer, d.m<? extends Integer, ? extends Integer>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ char[] f38661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f38662b;

        a(char[] r1, boolean r2) {
            this.f38661a = r1;
            this.f38662b = r2;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ d.m<? extends Integer, ? extends Integer> invoke(CharSequence r3, Integer r4) {
            return a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue());
        }

        public final d.m<Integer, Integer> a(CharSequence r3, int r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "$this$$receiver");
            int r2 = o.a(r5, this.f38661a, r4, this.f38662b);
            if (r2 >= 0) goto L6;
            return null;
        L6:
            return d.s.a(Integer.valueOf(r2), 1);
        }
    }

    /* JADX INFO: compiled from: Strings.kt */
    static final class b extends d.h.b.p implements d.h.a.m<CharSequence, Integer, d.m<? extends Integer, ? extends Integer>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<String> f38663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f38664b;

        b(List<String> r3, boolean r4) {
            this.f38663a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            this.f38664b = r4;
            super(2);
        }

        public final d.m<Integer, Integer> a(CharSequence r4, int r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "$this$$receiver");
            d.m r3 = y.a(r6, (Collection) ZeusTransformUtils.preCheckCast(this.f38663a, Collection.class, "com.obric.aiagent.plugin"), r5, this.f38664b, false);
            if (r3 != null) goto L7;
            return null;
        L7:
            return d.s.a(r3.a(), Integer.valueOf(((String) ZeusTransformUtils.preCheckCast(r3.b(), String.class, "com.obric.aiagent.plugin")).length()));
        }

        @Override // d.h.a.m
        public /* synthetic */ d.m<? extends Integer, ? extends Integer> invoke(CharSequence r3, Integer r4) {
            return a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue());
        }
    }

    /* JADX INFO: compiled from: Strings.kt */
    static final class c extends d.h.b.p implements d.h.a.b<d.l.j, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f38665a;

        c(CharSequence r3) {
            this.f38665a = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            super(1);
        }

        public final String a(d.l.j r2) {
            d.h.b.o.e(r2, "it");
            return o.a(this.f38665a, r2);
        }

        @Override // d.h.a.b
        public /* synthetic */ String invoke(d.l.j r3) {
            return a((d.l.j) ZeusTransformUtils.preCheckCast(r3, d.l.j.class, "com.obric.aiagent.plugin"));
        }
    }

    public y() {
    }

    public static final /* synthetic */ d.m a(CharSequence r2, Collection r3, int r4, boolean r5, boolean r6) {
        return b((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    public static final CharSequence a(CharSequence r3, int r4, char r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        if (r4 < 0) goto L16;
        if (r4 <= r6.length()) goto L7;
        StringBuilder r0 = new StringBuilder(r4);
        int r7 = r4 - r6.length();
        int r2 = 1;
        if (1 > r7) goto L13;
    L10:
        r0.append(r5);
        if (r2 == r7) goto L13;
        r2 = r2 + 1;
    L13:
        r0.append(r6);
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
    L7:
        return r6.subSequence(0, r6.length());
    L16:
        throw new IllegalArgumentException("Desired length " + r4 + " is less than zero.");
    }

    public static final String a(String r2, int r3, char r4) {
        d.h.b.o.e(r2, "<this>");
        return o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), r3, r4).toString();
    }

    public static final int e(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return r3.length() - 1;
    }

    public static final String a(CharSequence r2, d.l.j r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r3, "range");
        return r4.subSequence(r3.f().intValue(), r3.i().intValue() + 1).toString();
    }

    public static /* synthetic */ String a(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return o.a(r0, r1, r2);
    }

    public static final String a(String r7, char r8, String r9) {
        d.h.b.o.e(r7, "<this>");
        d.h.b.o.e(r9, "missingDelimiterValue");
        int r10 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        d.h.b.o.c(r11, "substring(...)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String a(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return o.b(r0, r1, r2);
    }

    public static final String b(String r7, String r8, String r9) {
        d.h.b.o.e(r7, "<this>");
        d.h.b.o.e(r8, "delimiter");
        d.h.b.o.e(r9, "missingDelimiterValue");
        int r10 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        d.h.b.o.c(r11, "substring(...)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String b(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return o.b(r0, r1, r2);
    }

    public static final String b(String r7, char r8, String r9) {
        d.h.b.o.e(r7, "<this>");
        d.h.b.o.e(r9, "missingDelimiterValue");
        int r10 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(r10 + 1, r7.length());
        d.h.b.o.c(r11, "substring(...)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String b(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return o.c(r0, r1, r2);
    }

    public static final String c(String r7, String r8, String r9) {
        d.h.b.o.e(r7, "<this>");
        d.h.b.o.e(r8, "delimiter");
        d.h.b.o.e(r9, "missingDelimiterValue");
        int r0 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r8, 0, false, 6, null);
        if (r0 == (-1)) goto L7;
        String r10 = r7.substring(r0 + r8.length(), r7.length());
        d.h.b.o.c(r10, "substring(...)");
        return r10;
    L7:
        return r9;
    }

    public static final String c(String r7, char r8, String r9) {
        d.h.b.o.e(r7, "<this>");
        d.h.b.o.e(r9, "missingDelimiterValue");
        int r10 = o.b((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        d.h.b.o.c(r11, "substring(...)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String c(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return o.d(r0, r1, r2);
    }

    public static final String d(String r7, String r8, String r9) {
        d.h.b.o.e(r7, "<this>");
        d.h.b.o.e(r8, "delimiter");
        d.h.b.o.e(r9, "missingDelimiterValue");
        int r10 = o.b((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        d.h.b.o.c(r11, "substring(...)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String c(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return o.d(r0, r1, r2);
    }

    public static final String d(String r7, char r8, String r9) {
        d.h.b.o.e(r7, "<this>");
        d.h.b.o.e(r9, "missingDelimiterValue");
        int r10 = o.b((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(r10 + 1, r7.length());
        d.h.b.o.c(r11, "substring(...)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String d(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return o.e(r0, r1, r2);
    }

    public static final String e(String r7, String r8, String r9) {
        d.h.b.o.e(r7, "<this>");
        d.h.b.o.e(r8, "delimiter");
        d.h.b.o.e(r9, "missingDelimiterValue");
        int r0 = o.b((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r8, 0, false, 6, null);
        if (r0 == (-1)) goto L7;
        String r10 = r7.substring(r0 + r8.length(), r7.length());
        d.h.b.o.c(r10, "substring(...)");
        return r10;
    L7:
        return r9;
    }

    public static final String a(String r4, CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r6, "prefix");
        if (o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), r6, false, 2, null) == false) goto L6;
        String r7 = r4.substring(r6.length());
        d.h.b.o.c(r7, "substring(...)");
        return r7;
    L6:
        return r4;
    }

    public static final String b(String r4, CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r6, "suffix");
        if (o.b((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), r6, false, 2, null) == false) goto L6;
        String r7 = r4.substring(0, r4.length() - r6.length());
        d.h.b.o.c(r7, "substring(...)");
        return r7;
    L6:
        return r4;
    }

    public static final String a(String r5, CharSequence r6, CharSequence r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r8, "prefix");
        d.h.b.o.e(r9, "suffix");
        if (r5.length() >= (r8.length() + r9.length())) goto L5;
        return r5;
    L5:
        if (o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), r8, false, 2, null) == true) goto L7;
        return r5;
    L7:
        if (o.b((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), r9, false, 2, null) == false) goto L12;
        String r10 = r5.substring(r8.length(), r5.length() - r9.length());
        d.h.b.o.c(r10, "substring(...)");
        return r10;
    L12:
        return r5;
    }

    public static final String c(String r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r4, "delimiter");
        return o.a(r2, r4, r4);
    }

    public static final boolean a(CharSequence r4, int r5, CharSequence r6, int r7, int r8, boolean r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "<this>");
        d.h.b.o.e(r11, "other");
        if (r7 < 0) goto L18;
        if (r5 < 0) goto L18;
        if (r5 > (r10.length() - r8)) goto L18;
        if (r7 > (r11.length() - r8)) goto L18;
        int r1 = 0;
    L11:
        if (r1 >= r8) goto L16;
        if (d.o.a.a(r10.charAt(r5 + r1), r11.charAt(r7 + r1), r9) == false) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }

    public static /* synthetic */ boolean a(CharSequence r1, char r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return o.a(r6, r2, r3);
    }

    public static final boolean a(CharSequence r2, char r3, boolean r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (r5.length() > 0) goto L5;
        return false;
    L5:
        if (d.o.a.a(r5.charAt(0), r3, r4) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static /* synthetic */ boolean b(CharSequence r1, char r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return o.b(r6, r2, r3);
    }

    public static final boolean b(CharSequence r2, char r3, boolean r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (r5.length() > 0) goto L5;
    L7:
        return false;
    L5:
        if (d.o.a.a(r5.charAt(o.e(r5)), r3, r4) == false) goto L7;
        return true;
    }

    public static /* synthetic */ boolean a(CharSequence r1, CharSequence r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return o.a(r6, r7, r3);
    }

    public static final boolean a(CharSequence r8, CharSequence r9, boolean r10) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r4, "prefix");
        if (r10 == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L11;
        return o.b((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), false, 2, null);
    L11:
        return o.a(r2, 0, r4, 0, r4.length(), r10);
    }

    public static /* synthetic */ boolean b(CharSequence r1, CharSequence r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return o.b(r6, r7, r3);
    }

    public static final boolean b(CharSequence r8, CharSequence r9, boolean r10) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r4, "suffix");
        if (r10 == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L11;
        return o.c((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), false, 2, null);
    L11:
        return o.a(r2, r2.length() - r4.length(), r4, 0, r4.length(), r10);
    }

    public static final int a(CharSequence r7, char[] r8, int r9, boolean r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "<this>");
        d.h.b.o.e(r8, "chars");
        if (r10 == false) goto L5;
    L10:
        int r12 = d.l.n.c(r9, 0);
        int r2 = o.e(r11);
        if (r12 > r2) goto L23;
    L12:
        char r3 = r11.charAt(r12);
        int r4 = r8.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L18;
        if (d.o.a.a(r8[r5], r3, r10) == true) goto L16;
        r5 = r5 + 1;
        goto L13
    L16:
        boolean r6 = true;
    L19:
        if (r6 == true) goto L20;
        if (r12 == r2) goto L29;
        r12 = r12 + 1;
        goto L12
    L29:
        return -1;
    L20:
        return r12;
    L18:
        r6 = false;
        goto L19
    L23:
        return -1;
    L5:
        if (r8.length != 1) goto L10;
        if (ZeusTransformUtils.instanceOf(r11, String.class) == false) goto L10;
        return ((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin")).indexOf(d.a.i.a(r8), r9);
    }

    public static final int b(CharSequence r6, char[] r7, int r8, boolean r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "<this>");
        d.h.b.o.e(r7, "chars");
        if (r9 == false) goto L5;
    L10:
        int r11 = d.l.n.d(r8, o.e(r10));
    L12:
        if ((-1) >= r11) goto L22;
        char r1 = r10.charAt(r11);
        int r2 = r7.length;
        boolean r3 = false;
        int r4 = 0;
    L14:
        if (r4 >= r2) goto L19;
        if (d.o.a.a(r7[r4], r1, r9) == true) goto L17;
        r4 = r4 + 1;
        goto L14
    L17:
        r3 = true;
    L19:
        if (r3 == true) goto L20;
        r11 = r11 - 1;
        goto L12
    L20:
        return r11;
    L22:
        return -1;
    L5:
        if (r7.length != 1) goto L10;
        if (ZeusTransformUtils.instanceOf(r10, String.class) == false) goto L10;
        return ((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin")).lastIndexOf(d.a.i.a(r7), r8);
    }

    static /* synthetic */ int a(CharSequence r7, CharSequence r8, int r9, int r10, boolean r11, boolean r12, int r13, Object r14) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r13 & 16) == 0) goto L6;
        r12 = false;
    L6:
        return a(r1, r2, r9, r10, r11, r12);
    }

    private static final int a(CharSequence r8, CharSequence r9, int r10, int r11, boolean r12, boolean r13) {
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r13 == true) goto L5;
        d.l.h r16 = (d.l.h) ZeusTransformUtils.preCheckCast(new d.l.j(d.l.n.c(r10, 0), d.l.n.d(r11, r14.length())), d.l.h.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r14, String.class) == true) goto L9;
    L20:
        int r17 = r16.a();
        int r18 = r16.b();
        int r19 = r16.c();
        if (r19 <= 0) goto L23;
        if (r17 > r18) goto L23;
    L25:
        int r5 = r17;
        if (o.a(r15, 0, r14, r5, r15.length(), r12) == true) goto L27;
        if (r17 == r18) goto L42;
        r17 = r17 + r19;
        goto L25
    L42:
        return -1;
    L27:
        return r17;
    L23:
        if (r19 >= 0) goto L39;
        if (r18 <= r17) goto L25;
        return -1;
    L39:
        return -1;
    L9:
        if (ZeusTransformUtils.instanceOf(r15, String.class) == false) goto L20;
        int r110 = r16.a();
        int r111 = r16.b();
        int r112 = r16.c();
        if (r112 <= 0) goto L13;
        if (r110 > r111) goto L13;
    L15:
        int r6 = r110;
        if (o.a((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.aiagent.plugin"), 0, (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.aiagent.plugin"), r6, r15.length(), r12) == true) goto L17;
        if (r110 == r111) goto L41;
        r110 = r110 + r112;
        goto L15
    L41:
        return -1;
    L17:
        return r110;
    L13:
        if (r112 >= 0) goto L30;
        if (r111 <= r110) goto L15;
        return -1;
    L30:
        return -1;
    L5:
        r16 = d.l.n.a(d.l.n.d(r10, o.e(r14)), d.l.n.c(r11, 0));
        goto L7
    }

    private static final d.m<Integer, String> b(CharSequence r11, Collection<String> r12, int r13, boolean r14, boolean r15) {
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.wrapperContextForParams(r12, Collection.class, "com.obric.aiagent.plugin");
        if (r14 == true) goto L15;
        if (r17.size() != 1) goto L15;
        String r18 = (String) ZeusTransformUtils.preCheckCast(d.a.p.i((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin")), String.class, "com.obric.aiagent.plugin");
        if (r15 == true) goto L9;
        int r19 = o.a(r16, r18, r13, false, 4, null);
    L10:
        if (r19 >= 0) goto L13;
        return null;
    L13:
        return d.s.a(Integer.valueOf(r19), r18);
    L9:
        r19 = o.b(r16, r18, r13, false, 4, null);
    L15:
        if (r15 == true) goto L17;
        d.l.h r110 = (d.l.h) ZeusTransformUtils.preCheckCast(new d.l.j(d.l.n.c(r13, 0), r16.length()), d.l.h.class, "com.obric.aiagent.plugin");
    L19:
        if (ZeusTransformUtils.instanceOf(r16, String.class) == false) goto L38;
        int r111 = r110.a();
        int r2 = r110.b();
        int r112 = r110.c();
        if (r112 <= 0) goto L23;
        if (r111 > r2) goto L23;
    L25:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L27:
        if (r9.hasNext() == false) goto L31;
        Object r10 = r9.next();
        String r3 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        if (o.a(r3, 0, (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin"), r111, r3.length(), r14) == false) goto L27;
    L32:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L35;
        if (r111 == r2) goto L56;
        r111 = r111 + r112;
    L56:
        return null;
    L35:
        return d.s.a(Integer.valueOf(r111), r4);
    L31:
        r10 = null;
    L23:
        if (r112 >= 0) goto L56;
        if (r2 > r111) goto L56;
    L38:
        int r113 = r110.a();
        int r8 = r110.b();
        int r114 = r110.c();
        if (r114 <= 0) goto L41;
        if (r113 > r8) goto L41;
    L43:
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L45:
        if (r20.hasNext() == false) goto L49;
        Object r115 = r20.next();
        String r5 = (String) ZeusTransformUtils.preCheckCast(r115, String.class, "com.obric.aiagent.plugin");
        if (o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), 0, r16, r113, r5.length(), r14) == false) goto L45;
    L50:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r115, String.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L53;
        if (r113 == r8) goto L56;
        r113 = r113 + r114;
        goto L43
    L53:
        return d.s.a(Integer.valueOf(r113), r6);
    L49:
        r115 = null;
    L41:
        if (r114 >= 0) goto L56;
        if (r8 > r113) goto L56;
    L17:
        r110 = d.l.n.a(d.l.n.d(r13, o.e(r16)), 0);
        goto L19
    }

    public static /* synthetic */ int a(CharSequence r1, char r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return o.a(r7, r2, r3, r4);
    }

    public static final int a(CharSequence r2, char r3, int r4, boolean r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        if (r5 == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L9;
        return ((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin")).indexOf(r3, r4);
    L9:
        return o.a(r6, new char[]{r3}, r4, r5);
    }

    public static /* synthetic */ int a(CharSequence r1, String r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return o.a(r7, r2, r3, r4);
    }

    public static final int a(CharSequence r10, String r11, int r12, boolean r13) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r11, WsChannelMultiProcessSharedProvider.STRING_TYPE);
        if (r13 == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L9;
        return ((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin")).indexOf(r11, r12);
    L9:
        return a(r2, (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), r12, r2.length(), r13, false, 16, null);
    }

    public static /* synthetic */ int b(CharSequence r1, char r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = o.e(r7);
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return o.b(r7, r2, r3, r4);
    }

    public static final int b(CharSequence r2, char r3, int r4, boolean r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        if (r5 == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L9;
        return ((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin")).lastIndexOf(r3, r4);
    L9:
        return o.b(r6, new char[]{r3}, r4, r5);
    }

    public static /* synthetic */ int b(CharSequence r1, String r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = o.e(r7);
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return o.b(r7, r2, r3, r4);
    }

    public static final int b(CharSequence r8, String r9, int r10, boolean r11) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r9, WsChannelMultiProcessSharedProvider.STRING_TYPE);
        if (r11 == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L9;
        return ((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin")).lastIndexOf(r9, r10);
    L9:
        return a(r2, (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), r10, 0, r11, true);
    }

    public static /* synthetic */ boolean c(CharSequence r1, CharSequence r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return o.c(r6, r7, r3);
    }

    public static final boolean c(CharSequence r10, CharSequence r11, boolean r12) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r3, "other");
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L8;
        if (o.a(r2, (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), 0, r12, 2, null) < 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (a(r2, r3, 0, r2.length(), r12, false, 16, null) < 0) goto L11;
        return true;
    }

    public static /* synthetic */ boolean c(CharSequence r1, char r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return o.c(r6, r2, r3);
    }

    public static final boolean c(CharSequence r6, char r7, boolean r8) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r0, "<this>");
        if (o.a(r0, r7, 0, r8, 2, null) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ d.n.j a(CharSequence r1, char[] r2, int r3, boolean r4, int r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = 0;
    L12:
        return a(r8, r2, r3, r4, r5);
    }

    private static final d.n.j<d.l.j> a(CharSequence r3, char[] r4, int r5, boolean r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.a(r7);
        return (d.n.j) ZeusTransformUtils.preCheckCast(new e(r8, r5, r7, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r4, r6), d.h.a.m.class, "com.obric.aiagent.plugin")), d.n.j.class, "com.obric.aiagent.plugin");
    }

    static /* synthetic */ d.n.j a(CharSequence r1, String[] r2, int r3, boolean r4, int r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = 0;
    L12:
        return a(r8, r2, r3, r4, r5);
    }

    private static final d.n.j<d.l.j> a(CharSequence r3, String[] r4, int r5, boolean r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.a(r7);
        return (d.n.j) ZeusTransformUtils.preCheckCast(new e(r8, r5, r7, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(d.a.i.a(r4), r6), d.h.a.m.class, "com.obric.aiagent.plugin")), d.n.j.class, "com.obric.aiagent.plugin");
    }

    public static final void a(int r2) {
        if (r2 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + r2).toString());
    L4:
        r0 = false;
        goto L5
    }

    public static /* synthetic */ d.n.j a(CharSequence r1, String[] r2, boolean r3, int r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return o.a(r7, r2, r3, r4);
    }

    public static final d.n.j<String> a(CharSequence r9, String[] r10, boolean r11, int r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "<this>");
        d.h.b.o.e(r10, "delimiters");
        return d.n.m.d(a(r13, r10, 0, r11, r12, 2, null), (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r13), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ List b(CharSequence r1, String[] r2, boolean r3, int r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return o.b(r7, r2, r3, r4);
    }

    public static final List<String> b(CharSequence r9, String[] r10, boolean r11, int r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "<this>");
        d.h.b.o.e(r10, "delimiters");
        boolean r2 = true;
        if (r10.length != 1) goto L11;
        String r3 = r10[0];
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() == 0) goto L8;
        r2 = false;
    L8:
        if (r2 == true) goto L11;
        return a(r13, r3, r11, r12);
    L11:
        Iterable r14 = d.n.m.l(a(r13, r10, 0, r11, r12, 2, null));
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r14.iterator();
    L13:
        if (r16.hasNext() == false) goto L16;
        r15.add(o.a(r13, (d.l.j) ZeusTransformUtils.preCheckCast(r16.next(), d.l.j.class, "com.obric.aiagent.plugin")));
        goto L13
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ List a(CharSequence r1, char[] r2, boolean r3, int r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return o.a(r7, r2, r3, r4);
    }

    public static final List<String> a(CharSequence r9, char[] r10, boolean r11, int r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "<this>");
        d.h.b.o.e(r10, "delimiters");
        if (r10.length == 1) goto L5;
        Iterable r14 = d.n.m.l(a(r13, r10, 0, r11, r12, 2, null));
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L11;
        r15.add(o.a(r13, (d.l.j) ZeusTransformUtils.preCheckCast(r16.next(), d.l.j.class, "com.obric.aiagent.plugin")));
        goto L8
    L11:
        return (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin");
    L5:
        return a(r13, String.valueOf(r10[0]), r11, r12);
    }

    private static final List<String> a(CharSequence r8, String r9, boolean r10, int r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        o.a(r11);
        int r0 = 0;
        int r2 = o.a(r12, r9, 0, r10);
        if (r2 == (-1)) goto L23;
        if (r11 == 1) goto L23;
        if (r11 <= 0) goto L9;
        boolean r5 = true;
    L10:
        int r7 = 10;
        if (r5 == false) goto L13;
        r7 = d.l.n.d(r11, 10);
    L13:
        ArrayList r6 = new ArrayList(r7);
    L14:
        r6.add(r12.subSequence(r0, r2).toString());
        r0 = r9.length() + r2;
        if (r5 == true) goto L17;
    L18:
        r2 = o.a(r12, r9, r0, r10);
        if (r2 != (-1)) goto L14;
    L20:
        r6.add(r12.subSequence(r0, r12.length()).toString());
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
    L17:
        if (r6.size() == (r11 - 1)) goto L20;
    L9:
        r5 = false;
    L23:
        return d.a.p.a(r12.toString());
    }

    public static final d.n.j<String> f(CharSequence r6) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r0, "<this>");
        return o.a(r0, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> g(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return d.n.m.g(o.f(r3));
    }

    public static final boolean b(CharSequence r6, CharSequence r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L9;
        return d.h.b.o.a(r8, r9);
    L9:
        if (r8 != r9) goto L12;
        return true;
    L12:
        if (r8 == null) goto L24;
        if (r9 == null) goto L24;
        if (r8.length() != r9.length()) goto L24;
        int r2 = r8.length();
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L23;
        if (r8.charAt(r3) != r9.charAt(r3)) goto L21;
        r3 = r3 + 1;
        goto L18
    L21:
        return false;
    L23:
        return true;
    L24:
        return false;
    }

    public static final Boolean f(String r1) {
        d.h.b.o.e(r1, "<this>");
        if (d.h.b.o.a(r1, "true") == false) goto L6;
        return true;
    L6:
        if (d.h.b.o.a(r1, "false") == true) goto L11;
        return null;
    L11:
        return false;
    }

    public static final String a(String r5, char... r6) {
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r6, "chars");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        int r0 = r7.length() - 1;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 > r0) goto L16;
        if (r3 == true) goto L6;
        int r4 = r2;
    L7:
        boolean r8 = d.a.i.a(r6, r7.charAt(r4));
        if (r3 == false) goto L9;
        if (r8 == false) goto L16;
        r0 = r0 - 1;
        goto L3
    L9:
        if (r8 == false) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        r3 = true;
        goto L3
    L6:
        r4 = r0;
    L16:
        return r7.subSequence(r2, r0 + 1).toString();
    }

    public static final String b(String r4, char... r5) {
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "chars");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        int r0 = r6.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (d.a.i.a(r5, r6.charAt(r2)) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        CharSequence r7 = r6.subSequence(r2, r6.length());
    L10:
        return r7.toString();
    L8:
        r7 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
        goto L10
    }

    public static final String c(String r4, char... r5) {
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "chars");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        int r0 = r6.length() - 1;
        if (r0 < 0) goto L10;
    L4:
        int r2 = r0 - 1;
        if (d.a.i.a(r5, r6.charAt(r0)) == false) goto L6;
        if (r2 < 0) goto L10;
        r0 = r2;
        goto L4
    L6:
        CharSequence r7 = r6.subSequence(0, r0 + 1);
    L12:
        return r7.toString();
    L10:
        r7 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
        goto L12
    }

    public static final CharSequence a(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        int r0 = r6.length() - 1;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 > r0) goto L16;
        if (r3 == true) goto L6;
        int r4 = r2;
    L7:
        boolean r7 = d.o.a.a(r6.charAt(r4));
        if (r3 == false) goto L9;
        if (r7 == false) goto L16;
        r0 = r0 - 1;
        goto L3
    L9:
        if (r7 == false) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        r3 = true;
        goto L3
    L6:
        r4 = r0;
    L16:
        return r6.subSequence(r2, r0 + 1);
    }

    public static final CharSequence b(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        int r0 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (d.o.a.a(r5.charAt(r2)) == false) goto L12;
        r2 = r2 + 1;
        goto L3
    L12:
        return r5.subSequence(r2, r5.length());
    L9:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    }

    public static final CharSequence c(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        int r0 = r5.length() - 1;
        if (r0 < 0) goto L11;
    L4:
        int r2 = r0 - 1;
        if (d.o.a.a(r5.charAt(r0)) == false) goto L14;
        if (r2 < 0) goto L11;
        r0 = r2;
        goto L4
    L14:
        return r5.subSequence(0, r0 + 1);
    L11:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    }

    public static final boolean d(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        int r1 = 0;
    L4:
        if (r1 >= r4.length()) goto L9;
        if (d.o.a.a(r4.charAt(r1)) == false) goto L13;
        r1 = r1 + 1;
        goto L4
    L13:
        return false;
    L9:
        return true;
    }
}
