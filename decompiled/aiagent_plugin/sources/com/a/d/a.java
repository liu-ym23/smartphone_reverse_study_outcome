package com.a.d;

import com.a.c.a.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: CronParser.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, List<b>> f3183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.c.a.c f3184b;

    public static /* synthetic */ boolean lambda$NkI_ZfaJHfebWjMbSPziSS_P62I(String r0) {
        return b(r0);
    }

    public static /* synthetic */ int lambda$ROiLagCIjBOAx2ySDszHul4HWbw(String r0) {
        return c(r0);
    }

    public static /* synthetic */ b lambda$tApCOUo5SgJq5xZ9SJSZvCgkXyE(a r0, com.a.c.b.b.c r1) {
        return r0.a(r1);
    }

    public a(com.a.c.a.c r4) {
        this.f3183a = new HashMap();
        this.f3184b = (com.a.c.a.c) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r4, "CronDefinition must not be null"), com.a.c.a.c.class, "com.obric.aiagent.plugin");
        a(r4);
    }

    private void a(com.a.c.a.c r5) {
        List<b> r6 = (List) ZeusTransformUtils.preCheckCast(r5.b().stream().map(new $$Lambda$a$tApCOUo5SgJq5xZ9SJSZvCgkXyE(this)).sorted(b.c()).collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
        List<b> r0 = r6;
    L4:
        if (a(r0) == false) goto L6;
        int r1 = r0.size() - 1;
        ArrayList r2 = new ArrayList(r0.subList(0, r1));
        this.f3183a.put(Integer.valueOf(r1), r2);
        r0 = r2;
        goto L4
    L6:
        this.f3183a.put(Integer.valueOf(r6.size()), r6);
    }

    private b a(com.a.c.b.b.c r3) {
        return new b(r3.b(), r3.c(), r3.d());
    }

    private boolean a(List<b> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r2.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (((b) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), b.class, "com.obric.aiagent.plugin")).b() == false) goto L7;
        return true;
    }

    private com.a.c.b a(String r2, Set<e> r3, e r4, com.a.c.b r5) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        com.a.c.b r6 = (com.a.c.b) ZeusTransformUtils.wrapperContextForParams(r5, com.a.c.b.class, "com.obric.aiagent.plugin");
        if (r1.contains(r4) == false) goto L6;
        return r6;
    L6:
        throw new IllegalArgumentException(String.format("Nickname %s not supported!", new Object[]{r2}));
    }

    public com.a.c.b a(String r18) {
        com.a.e.a.a(r18, "Expression must not be null");
        String r4 = r18.replaceAll("\\s+", " ").trim();
        if (com.a.e.c.a(r4) == true) goto L98;
        Set<e> r5 = this.f3184b.d();
        int r8 = 1;
        int r9 = 0;
        if (r18.startsWith("@") == false) goto L64;
        if (r5.isEmpty() == true) goto L62;
        r18.hashCode();
        byte r6 = -1;
        switch(r18.hashCode()) {
            case -1353831664: goto L40;
            case -357645332: goto L36;
            case -245765455: goto L32;
            case 30722021: goto L28;
            case 173953217: goto L24;
            case 231099082: goto L20;
            case 1107347405: goto L16;
            case 1927611865: goto L12;
            default: goto L43;
        };
    L43:
        switch(r6) {
            case 0: goto L60;
            case 1: goto L58;
            case 2: goto L56;
            case 3: goto L54;
            case 4: goto L52;
            case 5: goto L50;
            case 6: goto L48;
            case 7: goto L46;
            default: goto L64;
        };
    L46:
        return a(r18, r5, e.f3089e, com.a.a.a.e(this.f3184b));
    L48:
        return a(r18, r5, e.f3087c, com.a.a.a.c(this.f3184b));
    L50:
        return a(r18, r5, e.f3085a, com.a.a.a.a(this.f3184b));
    L52:
        return a(r18, r5, e.f3088d, com.a.a.a.d(this.f3184b));
    L54:
        return a(r18, r5, e.h, com.a.a.a.h(this.f3184b));
    L56:
        return a(r18, r5, e.g, com.a.a.a.g(this.f3184b));
    L58:
        return a(r18, r5, e.f3086b, com.a.a.a.b(this.f3184b));
    L60:
        return a(r18, r5, e.f, com.a.a.a.f(this.f3184b));
    L12:
        if (r18.equals("@daily") == false) goto L43;
        r6 = 7;
        goto L43
    L16:
        if (r18.equals("@monthly") == false) goto L43;
        r6 = 6;
        goto L43
    L20:
        if (r18.equals("@yearly") == false) goto L43;
        r6 = 5;
        goto L43
    L24:
        if (r18.equals("@weekly") == false) goto L43;
        r6 = 4;
        goto L43
    L28:
        if (r18.equals("@reboot") == false) goto L43;
        r6 = 3;
        goto L43
    L32:
        if (r18.equals("@hourly") == false) goto L43;
        r6 = 2;
        goto L43
    L36:
        if (r18.equals("@annually") == false) goto L43;
        r6 = 1;
        goto L43
    L40:
        if (r18.equals("@midnight") == false) goto L43;
        r6 = 0;
        goto L43
    L62:
        throw new IllegalArgumentException("Nicknames not supported!");
    L64:
        if (r18.contains("||") == false) goto L68;
        return new com.a.c.a((List) ZeusTransformUtils.preCheckCast(Arrays.stream(r18.split("\\|\\|")).map(new $$Lambda$PqeuOp3uAwHKx9imZJSqYnrjL_Q(this)).collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin"));
    L68:
        if (r18.contains("|") == false) goto L81;
        ArrayList r3 = new ArrayList();
        int r7 = Arrays.stream(r18.split("\\s+")).mapToInt($$Lambda$a$ROiLagCIjBOAx2ySDszHul4HWbw.INSTANCE).max().orElse(0);
        int r10 = 0;
    L70:
        if (r10 >= r7) goto L80;
        StringBuilder r11 = new StringBuilder();
        String[] r12 = r18.split("\\s+");
        int r13 = r12.length;
        int r14 = r9;
    L72:
        if (r14 >= r13) goto L78;
        String r15 = r12[r14];
        if (r15.contains("|") == false) goto L76;
        Object[] r16 = new Object[r8];
        r16[0] = r15.split("\\|")[r10];
        r11.append(String.format("%s ", r16));
    L77:
        r14 = r14 + 1;
        r8 = 1;
        goto L72
    L76:
        Object[] r17 = new Object[r8];
        r17[0] = r15;
        r11.append(String.format("%s ", r17));
        goto L77
    L78:
        r3.add(r11.toString().trim());
        r10 = r10 + 1;
        r8 = 1;
        r9 = 0;
        goto L70
    L80:
        return new com.a.c.a((List) ZeusTransformUtils.preCheckCast(r3.stream().map(new $$Lambda$PqeuOp3uAwHKx9imZJSqYnrjL_Q(this)).collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin"));
    L81:
        String[] r1 = r4.toUpperCase().split(" ");
        int r2 = r1.length;
        String r19 = (String) ZeusTransformUtils.preCheckCast(Arrays.stream(r1).filter($$Lambda$a$NkI_ZfaJHfebWjMbSPziSS_P62I.INSTANCE).findAny().orElse(null), String.class, "com.obric.aiagent.plugin");
        if (r19 != null) goto L96;
        List r20 = (List) ZeusTransformUtils.preCheckCast(this.f3183a.get(Integer.valueOf(r2)), List.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L94;
        int r21 = r1.length;     // Catch: IllegalArgumentException -> L90
        ArrayList r22 = new ArrayList(r21 + 1);     // Catch: IllegalArgumentException -> L90
        int r23 = 0;
    L86:
        if (r23 >= r21) goto L88;
        r22.add(((b) ZeusTransformUtils.preCheckCast(r20.get(r23), b.class, "com.obric.aiagent.plugin")).a(r1[r23]));     // Catch: IllegalArgumentException -> L90
        r23 = r23 + 1;     // Catch: IllegalArgumentException -> L90
        goto L86
    L88:
        return new com.a.c.e(this.f3184b, r22).d();
    L90:
        e = move-exception;
        throw new IllegalArgumentException(String.format("Failed to parse cron expression. %s", new Object[]{e.getMessage()}), e);
    L94:
        throw new IllegalArgumentException(String.format("Cron expression contains %s parts but we expect one of %s", new Object[]{Integer.valueOf(r2), this.f3183a.keySet()}));
    L96:
        throw new IllegalArgumentException(String.format("Invalid field value! Trailing commas not permitted! '%s'", new Object[]{r19}));
    L98:
        throw new IllegalArgumentException("Empty expression!");
    }

    private static /* synthetic */ int c(String r1) {
        return r1.split("\\|").length;
    }

    private static /* synthetic */ boolean b(String r1) {
        return r1.endsWith(",");
    }
}
