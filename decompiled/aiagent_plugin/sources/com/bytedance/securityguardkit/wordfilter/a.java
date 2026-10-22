package com.bytedance.securityguardkit.wordfilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ACAutomatonCategory.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0255a f11154a;

    /* JADX INFO: renamed from: com.bytedance.securityguardkit.wordfilter.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ACAutomatonCategory.java */
    private class C0255a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f11155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<Character, C0255a> f11156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private C0255a f11157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f11158d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f11159e;
        private String f;

        public C0255a(a r2) {
            this.f11155a = r2;
            this.f11156b = new HashMap();
            this.f11157c = null;
            this.f11158d = false;
            this.f11159e = null;
            this.f = null;
        }

        public Map<Character, C0255a> a() {
            return this.f11156b;
        }

        public C0255a b() {
            return this.f11157c;
        }

        public void a(C0255a r1) {
            this.f11157c = r1;
        }

        public boolean c() {
            return this.f11158d;
        }

        public void a(boolean r1) {
            this.f11158d = r1;
        }

        public String d() {
            return this.f11159e;
        }

        public void a(String r1) {
            this.f11159e = r1;
        }

        public String e() {
            return this.f;
        }

        public void b(String r1) {
            this.f = r1;
        }
    }

    public a() {
        this.f11154a = new C0255a(this);
    }

    public void a(Map<String, Set<String>> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.isEmpty() == true) goto L19;
        Iterator r8 = r7.entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L14;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        Iterator r1 = ((Set) ZeusTransformUtils.preCheckCast(r0.getValue(), Set.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r1.hasNext() == false) goto L9;
        a((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin"), r2);
        goto L12
    L14:
        a();
        return;
    }

    private void a(String r9, String r10) {
        C0255a r0 = this.f11154a;
        char[] r1 = r9.toCharArray();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        char r4 = r1[r3];
        r0.a().putIfAbsent(Character.valueOf(r4), new C0255a(this));
        r0 = (C0255a) ZeusTransformUtils.preCheckCast(r0.a().get(Character.valueOf(r4)), C0255a.class, "com.obric.aiagent.plugin");
        r3 = r3 + 1;
        goto L3
    L5:
        r0.a(true);
        r0.a(r9);
        r0.b(r10);
    }

    private void a() {
        LinkedList r0 = new LinkedList();
        Iterator<C0255a> r1 = this.f11154a.a().values().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        C0255a r2 = (C0255a) ZeusTransformUtils.preCheckCast(r1.next(), C0255a.class, "com.obric.aiagent.plugin");
        r2.a(this.f11154a);
        r0.add(r2);
    L7:
        if (r0.isEmpty() == true) goto L20;
        C0255a r3 = (C0255a) ZeusTransformUtils.preCheckCast(r0.poll(), C0255a.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<Character, C0255a>> r4 = r3.a().entrySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L7;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        char r6 = ((Character) ZeusTransformUtils.preCheckCast(r5.getKey(), Character.class, "com.obric.aiagent.plugin")).charValue();
        C0255a r7 = (C0255a) ZeusTransformUtils.preCheckCast(r5.getValue(), C0255a.class, "com.obric.aiagent.plugin");
        C0255a r8 = r3.b();
    L12:
        if (r8 == null) goto L16;
        if (r8.a().containsKey(Character.valueOf(r6)) == true) goto L16;
        r8 = r8.b();
    L16:
        if (r8 == null) goto L18;
        C0255a r9 = (C0255a) ZeusTransformUtils.preCheckCast(r8.a().getOrDefault(Character.valueOf(r6), this.f11154a), C0255a.class, "com.obric.aiagent.plugin");
    L19:
        r7.a(r9);
        r0.add(r7);
        goto L10
    L18:
        r9 = this.f11154a;
        goto L19
    }

    private boolean a(char r1) {
        if (r1 != ' ') goto L5;
    L12:
        return true;
    L5:
        if (r1 < '0') goto L9;
        if (r1 <= '9') goto L12;
    L9:
        if ("!@#$%^&*()_+-=[]{}|;:'\",.<>/?~·！@#￥%……&*（）——+-=【】{}|；：‘’“”，。《》？、".contains(String.valueOf(r1)) == true) goto L12;
        return false;
    }

    public Map<String, String> a(String r8) {
        HashMap r0 = new HashMap();
        C0255a r1 = this.f11154a;
        char[] r9 = r8.toCharArray();
        int r2 = r9.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L22;
        char r4 = r9[r3];
        if (a(r4) == true) goto L21;
    L7:
        if (r1 == null) goto L11;
        if (r1.a().containsKey(Character.valueOf(r4)) == true) goto L11;
        r1 = r1.b();
    L11:
        if (r1 != null) goto L13;
        r1 = this.f11154a;
    L14:
        C0255a r5 = r1;
    L16:
        if (r5 == this.f11154a) goto L21;
        if (r5.c() == false) goto L20;
        r0.put(r5.d(), r5.e());
    L20:
        r5 = r5.b();
        goto L16
    L13:
        r1 = (C0255a) ZeusTransformUtils.preCheckCast(r1.a().getOrDefault(Character.valueOf(r4), this.f11154a), C0255a.class, "com.obric.aiagent.plugin");
    L21:
        r3 = r3 + 1;
        goto L3
    L22:
        return r0;
    }

    public Set<String> b(String r1) {
        return new HashSet(a(r1).values());
    }
}
