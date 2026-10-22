package com.a;

import com.a.c.b.d.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: StringValidations.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c[] f3063a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f3064b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Pattern f3065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pattern f3066d;

    static {
        f3063a = new c[]{c.f3133b, c.f3132a, c.f3134c};
        f3064b = Pattern.compile("[#\\?/\\*0-9]");
    }

    public b(com.a.c.b.a.a r2) {
        this.f3066d = b(r2.c());
        this.f3065c = a(r2.d());
    }

    Pattern a(Set<String> r3) {
        return c((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"));
    }

    public String a(String r3) {
        Matcher r4 = f3064b.matcher(r3.toUpperCase());
        Matcher r5 = this.f3065c.matcher(r4.replaceAll(""));
        return this.f3066d.matcher(r5.replaceAll("")).replaceAll("").replaceAll("\\s+", "").replaceAll(",", "").replaceAll("-", "");
    }

    Pattern b(Set<c> r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        HashSet r0 = new HashSet();
        c[] r1 = f3063a;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L9;
        c r4 = r1[r3];
        if (r8.contains(r4) == false) goto L7;
        r0.add(r4.name());
    L7:
        r3 = r3 + 1;
        goto L3
    L9:
        return c(r0);
    }

    Pattern c(Set<String> r5) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        StringBuilder r6 = new StringBuilder("\\b(");
        Iterator r7 = r4.iterator();
        if (r7.hasNext() == true) goto L6;
        r6.append(")\\b");
        return Pattern.compile(r6.toString());
    L6:
        r6.append((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"));
    L8:
        if (r7.hasNext() == false) goto L10;
        r6.append("|");
        r6.append((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"));
        goto L8
    L10:
        r6.append(")\\b");
        return Pattern.compile(r6.toString());
    }
}
