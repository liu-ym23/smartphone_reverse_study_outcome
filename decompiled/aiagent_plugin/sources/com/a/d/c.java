package com.a.d;

import com.a.c.b.c.d;
import com.a.c.b.c.e;
import com.a.c.b.c.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: FieldParser.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f3189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f3190b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f3191c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.a.c.b.a.a f3192d;

    static {
        f3189a = new char[]{'/', '-', ','};
        f3190b = Pattern.compile("[0-9]L", 2);
        f3191c = Pattern.compile("[0-9]W", 2);
    }

    public c(com.a.c.b.a.a r3) {
        this.f3192d = (com.a.c.b.a.a) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r3, "FieldConstraints must not be null"), com.a.c.b.a.a.class, "com.obric.aiagent.plugin");
    }

    public e a(String r6) {
        if (com.a.e.c.a(r6, f3189a) == false) goto L5;
        String[] r0 = r6.split(",");
        if (r0.length > 1) goto L16;
        String[] r1 = r6.split("-");
        if (r6.contains("-") == false) goto L25;
        if (r1.length == 2) goto L25;
        throw new IllegalArgumentException("Missing values for range: " + r6);
    L25:
        if (r1[0].equalsIgnoreCase("L") == false) goto L28;
        return a(r1[0], h(r1[1]));
    L28:
        return a(r6, r1);
    L16:
        return b(r0);
    L5:
        if (r6.contains("?") == false) goto L12;
        if (this.f3192d.c().contains(com.a.c.b.d.c.f3136e) == true) goto L12;
        throw new IllegalArgumentException("Invalid expression: " + r6);
    L12:
        return k(r6);
    }

    private e a(String r3, String[] r4) {
        if (r4.length <= 1) goto L7;
        return a(r4);
    L7:
        return b(r3, r3.split("/"));
    }

    private e b(String[] r5) {
        com.a.c.b.c.b r0 = new com.a.c.b.c.b();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.a(a(r5[r2]));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private e b(String r4, String[] r5) {
        if (r5.length != 2) goto L7;
        return a(r5[0], r5[1]);
    L7:
        if (r5.length != 1) goto L11;
        throw new IllegalArgumentException("Missing steps for expression: " + r4);
    L11:
        throw new IllegalArgumentException("Invalid expression: " + r4);
    }

    private e a(String r4, String r5) {
        String r0 = r4.trim();
        if ("*".equals(r0) == false) goto L9;
        if (r5.equals("1") == false) goto L9;
        return k(r4);
    L9:
        if ("*".equals(r0) == true) goto L16;
        if ("".equals(r4.trim()) == true) goto L16;
        return new d(new f(h(r4)), new com.a.c.b.d.b(Integer.parseInt(r5)));
    L16:
        return new d(new com.a.c.b.d.b(Integer.parseInt(r5)));
    }

    private e k(String r2) {
        if ("*".equals(r2) == false) goto L7;
        return e.d();
    L7:
        if ("?".equals(r2) == false) goto L11;
        return e.e();
    L11:
        return b(r2);
    }

    public e a(String[] r6) {
        if (r6[0].isEmpty() == true) goto L13;
        if (r6[1].isEmpty() == true) goto L13;
        if (r6[1].contains("/") == false) goto L11;
        String[] r1 = r6[1].split("/");
        return new d(new com.a.c.b.c.c(i(r6[0]), i(r1[0])), h(r1[1]));
    L11:
        return new com.a.c.b.c.c(i(r6[0]), i(r6[1]));
    L13:
        throw new IllegalArgumentException(String.format("Invalid expression! Expression: %s-%s does not describe a range. Negative numbers are not allowed.", new Object[]{r6[0], r6[1]}));
    }

    public f b(String r4) {
        if ("?".equals(r4) == false) goto L7;
        return d(r4);
    L7:
        if (r4.contains("#") == false) goto L11;
        return c(r4);
    L11:
        if (r4.contains("LW") == false) goto L15;
        return e(r4);
    L15:
        if (f3190b.matcher(r4).find() == true) goto L26;
        if (r4.equalsIgnoreCase("L") == true) goto L26;
        if (f3191c.matcher(r4).find() == false) goto L24;
        return g(r4);
    L24:
        return new f(h(r4), new com.a.c.b.d.d(com.a.c.b.d.c.f), new com.a.c.b.d.b(-1));
    L26:
        return f(r4);
    }

    public f c(String r5) {
        if (this.f3192d.c().contains(com.a.c.b.d.c.f3135d) == false) goto L15;
        com.a.c.b.d.d r0 = new com.a.c.b.d.d(com.a.c.b.d.c.f3135d);
        String[] r6 = r5.split("#");
        if (r6.length == 0) goto L13;
        com.a.c.b.d.b r1 = h(r6[1]);
        if (r6[0].isEmpty() == true) goto L11;
        return new f(h(r6[0]), r0, r1);
    L11:
        throw new IllegalArgumentException("Time should be specified!");
    L13:
        throw new IllegalArgumentException("Invalid Position of # Character!");
    L15:
        throw new IllegalArgumentException("Invalid expression: " + r5);
    }

    public f d(String r4) {
        com.a.c.b.d.d r3 = new com.a.c.b.d.d(com.a.c.b.d.c.f3136e);
        String r5 = r4.replace("?", "");
        if ("".equals(r5) == false) goto L7;
        return new f(new com.a.c.b.d.b(-1), r3, new com.a.c.b.d.b(-1));
    L7:
        throw new IllegalArgumentException(String.format("Expected: '?', found: %s", new Object[]{r5}));
    }

    public f e(String r4) {
        com.a.c.b.d.d r3 = new com.a.c.b.d.d(com.a.c.b.d.c.f3132a);
        String r5 = r4.replace("LW", "");
        if ("".equals(r5) == false) goto L7;
        return new f(new com.a.c.b.d.b(-1), r3, new com.a.c.b.d.b(-1));
    L7:
        throw new IllegalArgumentException(String.format("Expected: LW, found: %s", new Object[]{r5}));
    }

    public f f(String r3) {
        return a(r3, new com.a.c.b.d.b(-1));
    }

    public f a(String r5, com.a.c.b.d.b r6) {
        com.a.c.b.d.d r0 = new com.a.c.b.d.d(com.a.c.b.d.c.f3133b);
        String r7 = r5.replace("L", "");
        com.a.c.b.d.b r1 = new com.a.c.b.d.b(-1);
        if ("".equals(r7) == true) goto L6;
        r1 = h(r7);
    L6:
        return new f(r1, r0, r6);
    }

    public f g(String r4) {
        return new f(h(r4.replace("W", "")), new com.a.c.b.d.d(com.a.c.b.d.c.f3134c), new com.a.c.b.d.b(-1));
    }

    public com.a.c.b.d.b h(String r3) {
        return new com.a.c.b.d.b(a(Integer.valueOf(j(r3))));
    L5:
        throw new IllegalArgumentException(String.format("Invalid value. Expected some integer, found %s", new Object[]{r3}));
    }

    public com.a.c.b.d.a<?> i(String r6) {
        com.a.c.b.d.c[] r0 = com.a.c.b.d.c.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        com.a.c.b.d.c r3 = r0[r2];
        if (r3.toString().equals(r6) == true) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return new com.a.c.b.d.d(r3);
    L10:
        return new com.a.c.b.d.b(j(r6));
    }

    public int j(String r4) {
        Integer r0 = this.f3192d.a(r4);
        if (r0 != null) goto L5;
        return Integer.parseInt(r4);
    L9:
        throw new IllegalArgumentException(String.format("Invalid chars in expression! Expression: %s Invalid chars: %s", new Object[]{r4, new com.a.b(this.f3192d).a(r4)}));
    L5:
        return r0.intValue();
    }

    public int a(Integer r1) {
        Integer r0 = this.f3192d.a(r1);
        if (r0 == null) goto L7;
        return r0.intValue();
    L7:
        return r1.intValue();
    }
}
