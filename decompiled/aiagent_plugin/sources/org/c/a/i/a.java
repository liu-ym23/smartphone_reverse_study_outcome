package org.c.a.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Resolver.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f40473a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f40474b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f40475c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f40476d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f40477e = null;
    public static final Pattern f = null;
    public static final Pattern g = null;
    public static final Pattern h = null;
    public static final Pattern i = null;
    protected Map<Character, List<b>> j;

    /* JADX INFO: renamed from: org.c.a.i.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: Resolver.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f40478a = null;

        static {
            int[] r0 = new int[org.c.a.f.a.values().length];
            f40478a = r0;
            r0[org.c.a.f.a.f40416a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f40478a[org.c.a.f.a.f40417b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        f40473a = Pattern.compile("^(?:yes|Yes|YES|no|No|NO|true|True|TRUE|false|False|FALSE|on|On|ON|off|Off|OFF)$");
        f40474b = Pattern.compile("^([-+]?(?:[0-9][0-9_]*)\\.[0-9_]*(?:[eE][-+]?[0-9]+)?|[-+]?(?:[0-9][0-9_]*)(?:[eE][-+]?[0-9]+)|[-+]?\\.[0-9_]+(?:[eE][-+]?[0-9]+)?|[-+]?[0-9][0-9_]*(?::[0-5]?[0-9])+\\.[0-9_]*|[-+]?\\.(?:inf|Inf|INF)|\\.(?:nan|NaN|NAN))$");
        f40475c = Pattern.compile("^(?:[-+]?0b_*[0-1][0-1_]*|[-+]?0_*[0-7][0-7_]*|[-+]?(?:0|[1-9][0-9_]*)|[-+]?0x_*[0-9a-fA-F][0-9a-fA-F_]*|[-+]?[1-9][0-9_]*(?::[0-5]?[0-9])+)$");
        f40476d = Pattern.compile("^(?:<<)$");
        f40477e = Pattern.compile("^(?:~|null|Null|NULL| )$");
        f = Pattern.compile("^$");
        g = Pattern.compile("^(?:[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]|[0-9][0-9][0-9][0-9]-[0-9][0-9]?-[0-9][0-9]?(?:[Tt]|[ \t]+)[0-9][0-9]?:[0-9][0-9]:[0-9][0-9](?:\\.[0-9]*)?(?:[ \t]*(?:Z|[-+][0-9][0-9]?(?::[0-9][0-9])?))?)$");
        h = Pattern.compile("^(?:=)$");
        i = Pattern.compile("^(?:!|&|\\*)$");
    }

    public void a() {
        a(org.c.a.f.b.j, f40473a, "yYnNtTfFoO", 10);
        a(org.c.a.f.b.g, f40475c, "-+0123456789");
        a(org.c.a.f.b.h, f40474b, "-+0123456789.");
        a(org.c.a.f.b.f40422b, f40476d, "<", 10);
        a(org.c.a.f.b.k, f40477e, "~nN\u0000", 10);
        a(org.c.a.f.b.k, f, null, 10);
        a(org.c.a.f.b.i, g, "0123456789", 50);
        a(org.c.a.f.b.f40421a, i, "!&*", 10);
    }

    public a() {
        this.j = new HashMap();
        a();
    }

    public void a(org.c.a.f.b r2, Pattern r3, String r4) {
        a(r2, r3, r4, 1024);
    }

    public void a(org.c.a.f.b r8, Pattern r9, String r10, int r11) {
        if (r10 != null) goto L8;
        List<b> r12 = (List) ZeusTransformUtils.preCheckCast(this.j.get(null), List.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L7;
        r12 = new ArrayList();
        this.j.put(null, r12);
    L7:
        r12.add(new b(r8, r9, r11));
        return;
    L8:
        char[] r13 = r10.toCharArray();
        int r2 = 0;
        int r3 = r13.length;
    L9:
        if (r2 >= r3) goto L21;
        Character r4 = Character.valueOf(r13[r2]);
        if (r4.charValue() != 0) goto L13;
        r4 = null;
    L13:
        List<b> r5 = (List) ZeusTransformUtils.preCheckCast(this.j.get(r4), List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L16;
        r5 = new ArrayList();
        this.j.put(r4, r5);
    L16:
        r5.add(new b(r8, r9, r11));
        r2 = r2 + 1;
        goto L9
    }

    public org.c.a.f.b a(org.c.a.f.a r6, String r7, boolean r8) {
        if (r6 != org.c.a.f.a.f40416a) goto L28;
        if (r8 == false) goto L28;
        if (r7.length() != 0) goto L8;
        List r9 = (List) ZeusTransformUtils.preCheckCast(this.j.get((char) 0), List.class, "com.obric.aiagent.plugin");
    L9:
        if (r9 == null) goto L19;
        Iterator r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L19;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r10.next(), b.class, "com.obric.aiagent.plugin");
        org.c.a.f.b r2 = r0.a();
        Pattern r3 = r0.b();
        if (r7.length() > r0.c()) goto L12;
        if (r3.matcher(r7).matches() == false) goto L12;
        return r2;
    L19:
        if (this.j.containsKey(null) == false) goto L28;
        Iterator r5 = ((List) ZeusTransformUtils.preCheckCast(this.j.get(null), List.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r5.hasNext() == false) goto L28;
        b r11 = (b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin");
        org.c.a.f.b r1 = r11.a();
        Pattern r4 = r11.b();
        if (r7.length() > r11.c()) goto L22;
        if (r4.matcher(r7).matches() == false) goto L22;
        return r1;
    L8:
        r9 = (List) ZeusTransformUtils.preCheckCast(this.j.get(Character.valueOf(r7.charAt(0))), List.class, "com.obric.aiagent.plugin");
    L28:
        int r12 = AnonymousClass1.f40478a[r6.ordinal()];
        if (r12 == 1) goto L37;
        if (r12 == 2) goto L35;
        return org.c.a.f.b.n;
    L35:
        return org.c.a.f.b.m;
    L37:
        return org.c.a.f.b.l;
    }
}
