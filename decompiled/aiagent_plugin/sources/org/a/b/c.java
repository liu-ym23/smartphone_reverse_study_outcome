package org.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: compiled from: Trie.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f40254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f40255b;

    /* JADX INFO: renamed from: org.a.b.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: Trie.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: Trie.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f40256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c f40257b;

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        private a() {
            this.f40256a = new d();
            this.f40257b = new c(this.f40256a, null);
        }

        public a a(String r2) {
            c.a(this.f40257b, r2);
            return this;
        }

        public c a() {
            c.a(this.f40257b);
            return this.f40257b;
        }
    }

    /* synthetic */ c(d r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ void a(c r0) {
        r0.b();
    }

    static /* synthetic */ void a(c r0, String r1) {
        r0.a(r1);
    }

    private c(d r1) {
        this.f40254a = r1;
        this.f40255b = new b();
    }

    private void a(String r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.length() == 0) goto L21;
        b r0 = this.f40255b;
        char[] r1 = r7.toCharArray();
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L13;
        Character r4 = Character.valueOf(r1[r3]);
        if (this.f40254a.a() == false) goto L11;
        r4 = Character.valueOf(Character.toLowerCase(r4.charValue()));
    L11:
        r0 = r0.c(r4);
        r3 = r3 + 1;
        goto L7
    L13:
        if (this.f40254a.a() == false) goto L15;
        r7 = r7.toLowerCase();
    L15:
        r0.a(r7);
        return;
    }

    private void b() {
        LinkedBlockingDeque r0 = new LinkedBlockingDeque();
        Iterator<b> r1 = this.f40255b.c().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.aiagent.plugin");
        r2.a(this.f40255b);
        r0.add(r2);
    L7:
        if (r0.isEmpty() == true) goto L16;
        b r7 = (b) ZeusTransformUtils.preCheckCast(r0.remove(), b.class, "com.obric.aiagent.plugin");
        Iterator<Character> r3 = r7.d().iterator();
    L10:
        if (r3.hasNext() == false) goto L7;
        Character r4 = (Character) ZeusTransformUtils.preCheckCast(r3.next(), Character.class, "com.obric.aiagent.plugin");
        b r5 = r7.a(r4);
        r0.add(r5);
        b r6 = r7.b();
    L13:
        if (r6.a(r4) != null) goto L15;
        r6 = r6.b();
        goto L13
    L15:
        b r8 = r6.a(r4);
        r5.a(r8);
        r5.a(r8.a());
        goto L10
    }

    public static a a() {
        return new a(null);
    }
}
