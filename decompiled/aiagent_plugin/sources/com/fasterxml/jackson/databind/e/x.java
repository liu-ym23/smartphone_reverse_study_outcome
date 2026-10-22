package com.fasterxml.jackson.databind.e;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
public class x extends com.fasterxml.jackson.databind.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.a.m<?> f12672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final d f12673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final a f12674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final boolean f12675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final String f12676e;
    protected final String f;
    protected final String g;

    /* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
    public interface a {
        boolean a(char r1, String r2, int r3);
    }

    /* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
    public static class b extends com.fasterxml.jackson.databind.e.a.AbstractC0271a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final String f12677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final String f12678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final String f12679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final String f12680d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected final a f12681e;

        public b() {
            this("set", JsonPOJOBuilder.DEFAULT_WITH_PREFIX, MonitorConstants.CONNECT_TYPE_GET, "is", null);
        }

        public b(String r3, String r4, String r5, String r6, a r7) {
            a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.aiagent.plugin");
            this.f12677a = r3;
            this.f12678b = r4;
            this.f12679c = r5;
            this.f12680d = r6;
            this.f12681e = r8;
        }

        @Override // com.fasterxml.jackson.databind.e.a.AbstractC0271a
        public com.fasterxml.jackson.databind.e.a a(com.fasterxml.jackson.databind.a.m<?> r9, d r10) {
            return new x(r9, r10, this.f12677a, this.f12679c, this.f12680d, this.f12681e);
        }

        @Override // com.fasterxml.jackson.databind.e.a.AbstractC0271a
        public com.fasterxml.jackson.databind.e.a a(com.fasterxml.jackson.databind.a.m<?> r8, d r9, com.fasterxml.jackson.databind.c r10) {
            JsonPOJOBuilder.Value r0 = null;
            if (r8.f() == false) goto L5;
            com.fasterxml.jackson.databind.b r11 = r8.j();
        L6:
            if (r11 == null) goto L9;
            r0 = r11.h(r9);
        L9:
            if (r0 != null) goto L11;
            String r12 = this.f12678b;
        L13:
            return new x(r8, r9, r12, this.f12679c, this.f12680d, this.f12681e);
        L11:
            r12 = r0.withPrefix;
            goto L13
        L5:
            r11 = null;
            goto L6
        }

        @Override // com.fasterxml.jackson.databind.e.a.AbstractC0271a
        public com.fasterxml.jackson.databind.e.a b(com.fasterxml.jackson.databind.a.m<?> r1, d r2) {
            return new c(r1, r2);
        }
    }

    /* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
    public static class c extends x {
        protected final Set<String> h;

        public c(com.fasterxml.jackson.databind.a.m<?> r8, d r9) {
            super(r8, r9, null, MonitorConstants.CONNECT_TYPE_GET, "is", null);
            this.h = new HashSet();
            String[] r10 = com.fasterxml.jackson.databind.f.a.a(r9.c());
            int r11 = r10.length;
            int r0 = 0;
        L3:
            if (r0 >= r11) goto L5;
            String r1 = r10[r0];
            this.h.add(r1);
            r0 = r0 + 1;
            goto L3
        }

        @Override // com.fasterxml.jackson.databind.e.x, com.fasterxml.jackson.databind.e.a
        public String b(k r2, String r3) {
            if (this.h.contains(r3) == false) goto L6;
            return r3;
        L6:
            return super.b(r2, r3);
        }
    }

    @Override // com.fasterxml.jackson.databind.e.a
    public String a(h r1, String r2) {
        return r2;
    }

    public x(com.fasterxml.jackson.databind.a.m<?> r3, d r4, String r5, String r6, String r7, a r8) {
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r8, a.class, "com.obric.aiagent.plugin");
        this.f12672a = r3;
        this.f12673b = r4;
        this.f12675d = r3.a(com.fasterxml.jackson.databind.r.z);
        this.g = r5;
        this.f12676e = r6;
        this.f = r7;
        this.f12674c = r9;
    }

    @Override // com.fasterxml.jackson.databind.e.a
    public String a(k r2, String r3) {
        if (this.f == null) goto L15;
        Class<?> r4 = r2.c();
        if (r4 == Boolean.class) goto L9;
        if (r4 == Boolean.TYPE) goto L9;
        return null;
    L9:
        if (r3.startsWith(this.f) == true) goto L11;
        return null;
    L11:
        if (this.f12675d == false) goto L14;
        return b(r3, 2);
    L14:
        return a(r3, 2);
    L15:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.e.a
    public String b(k r3, String r4) {
        String r0 = this.f12676e;
        if (r0 != null) goto L5;
    L21:
        return null;
    L5:
        if (r4.startsWith(r0) == false) goto L21;
        if ("getCallbacks".equals(r4) == false) goto L12;
        if (a(r3) == false) goto L17;
        return null;
    L17:
        if (this.f12675d == false) goto L20;
        return b(r4, this.f12676e.length());
    L20:
        return a(r4, this.f12676e.length());
    L12:
        if ("getMetaClass".equals(r4) == false) goto L17;
        if (b(r3) == false) goto L17;
        return null;
    }

    @Override // com.fasterxml.jackson.databind.e.a
    public String c(k r1, String r2) {
        String r3 = this.g;
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r2.startsWith(r3) == true) goto L7;
        return null;
    L7:
        if (this.f12675d == false) goto L10;
        return b(r2, this.g.length());
    L10:
        return a(r2, this.g.length());
    }

    public String a(String r4, int r5) {
        int r0 = r4.length();
        if (r0 != r5) goto L5;
        return null;
    L5:
        char r2 = r4.charAt(r5);
        a r3 = this.f12674c;
        if (r3 != null) goto L8;
    L10:
        char r6 = Character.toLowerCase(r2);
        if (r2 == r6) goto L13;
        StringBuilder r1 = new StringBuilder(r0 - r5);
        r1.append(r6);
    L15:
        r5 = r5 + 1;
        if (r5 >= r0) goto L22;
        char r7 = r4.charAt(r5);
        char r8 = Character.toLowerCase(r7);
        if (r7 == r8) goto L19;
        r1.append(r8);
        goto L15
    L19:
        r1.append(r4, r5, r0);
    L22:
        return r1.toString();
    L13:
        return r4.substring(r5);
    L8:
        if (r3.a(r2, r4, r5) == true) goto L10;
        return null;
    }

    public String b(String r4, int r5) {
        int r0 = r4.length();
        if (r0 != r5) goto L5;
        return null;
    L5:
        char r2 = r4.charAt(r5);
        a r3 = this.f12674c;
        if (r3 != null) goto L8;
    L10:
        char r6 = Character.toLowerCase(r2);
        if (r2 == r6) goto L13;
        int r1 = r5 + 1;
        if (r1 < r0) goto L17;
    L20:
        StringBuilder r7 = new StringBuilder(r0 - r5);
        r7.append(r6);
        r7.append(r4, r1, r0);
        return r7.toString();
    L17:
        if (Character.isUpperCase(r4.charAt(r1)) == false) goto L20;
        return r4.substring(r5);
    L13:
        return r4.substring(r5);
    L8:
        if (r3.a(r2, r4, r5) == true) goto L10;
        return null;
    }

    public boolean a(k r2) {
        Class<?> r1 = r2.c();
        if (r1.isArray() == false) goto L14;
        String r3 = r1.getComponentType().getName();
        if (r3.contains(".cglib") == true) goto L7;
        return false;
    L7:
        if (r3.startsWith("net.sf.cglib") == false) goto L9;
    L12:
        return true;
    L9:
        if (r3.startsWith("org.hibernate.repackage.cglib") == true) goto L12;
        if (r3.startsWith("org.springframework.cglib") == true) goto L12;
        return false;
    L14:
        return false;
    }

    public boolean b(k r1) {
        return r1.c().getName().startsWith("groovy.lang");
    }
}
