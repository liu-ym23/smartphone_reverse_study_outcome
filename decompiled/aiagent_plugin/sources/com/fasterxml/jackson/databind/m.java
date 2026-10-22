package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/* JADX INFO: compiled from: JsonMappingException.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected LinkedList<a> f13090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected transient Closeable f13091c;

    /* JADX INFO: compiled from: JsonMappingException.java */
    public static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected transient Object f13092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f13093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected int f13094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected String f13095d;

        public a() {
            this.f13094c = -1;
        }

        public a(Object r2, String r3) {
            this.f13094c = -1;
            this.f13092a = r2;
            Objects.requireNonNull(r3, "Cannot pass null fieldName");
            this.f13093b = r3;
        }

        public a(Object r2, int r3) {
            this.f13094c = -1;
            this.f13092a = r2;
            this.f13094c = r3;
        }

        public String a() {
            if (this.f13095d != null) goto L28;
            StringBuilder r0 = new StringBuilder();
            Object r1 = this.f13092a;
            if (r1 != null) goto L8;
            r0.append("UNKNOWN");
        L19:
            r0.append('[');
            if (this.f13093b == null) goto L22;
            r0.append('\"');
            r0.append(this.f13093b);
            r0.append('\"');
        L26:
            r0.append(']');
            this.f13095d = r0.toString();
            goto L28
        L22:
            int r2 = this.f13094c;
            if (r2 < 0) goto L25;
            r0.append(r2);
            goto L26
        L25:
            r0.append('?');
            goto L26
        L8:
            if (ZeusTransformUtils.instanceOf(r1, Class.class) == false) goto L10;
            Class<?> r3 = (Class) ZeusTransformUtils.preCheckCast(this.f13092a, Class.class, "com.obric.aiagent.plugin");
        L11:
            int r4 = 0;
        L13:
            if (r3.isArray() == false) goto L15;
            r3 = r3.getComponentType();
            r4 = r4 + 1;
            goto L13
        L15:
            r0.append(r3.getName());
        L16:
            r4 = r4 - 1;
            if (r4 < 0) goto L19;
            r0.append("[]");
            goto L16
        L10:
            r3 = this.f13092a.getClass();
        L28:
            return this.f13095d;
        }

        public String toString() {
            return a();
        }
    }

    public m(Closeable r3, String r4) {
        Closeable r5 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r3, Closeable.class, "com.obric.aiagent.plugin");
        super(r4);
        this.f13091c = r5;
        if (ZeusTransformUtils.instanceOf(r5, com.fasterxml.jackson.a.k.class) == false) goto L6;
        this.f12148a = ((com.fasterxml.jackson.a.k) ZeusTransformUtils.preCheckCast(r5, com.fasterxml.jackson.a.k.class, "com.obric.aiagent.plugin")).f();
        return;
    }

    public m(Closeable r3, String r4, Throwable r5) {
        Closeable r6 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r3, Closeable.class, "com.obric.aiagent.plugin");
        super(r4, r5);
        this.f13091c = r6;
        if (ZeusTransformUtils.instanceOf(r5, com.fasterxml.jackson.a.e.class) == false) goto L6;
        this.f12148a = ((com.fasterxml.jackson.a.e) ZeusTransformUtils.preCheckCast(r5, com.fasterxml.jackson.a.e.class, "com.obric.aiagent.plugin")).a();
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, com.fasterxml.jackson.a.k.class) == false) goto L10;
        this.f12148a = ((com.fasterxml.jackson.a.k) ZeusTransformUtils.preCheckCast(r6, com.fasterxml.jackson.a.k.class, "com.obric.aiagent.plugin")).f();
        return;
    }

    public m(Closeable r3, String r4, com.fasterxml.jackson.a.i r5) {
        Closeable r6 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r3, Closeable.class, "com.obric.aiagent.plugin");
        super(r4, r5);
        this.f13091c = r6;
    }

    public static m a(com.fasterxml.jackson.a.k r1, String r2) {
        return new m(r1, r2);
    }

    public static m a(com.fasterxml.jackson.a.k r1, String r2, Throwable r3) {
        return new m(r1, r2, r3);
    }

    public static m a(com.fasterxml.jackson.a.h r4, String r5) {
        return new m(r4, r5, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static m a(com.fasterxml.jackson.a.h r1, String r2, Throwable r3) {
        return new m(r1, r2, r3);
    }

    public static m a(h r1, String r2) {
        return new m(r1.j(), r2);
    }

    public static m a(IOException r4) {
        return new m(null, String.format("Unexpected IOException (of type %s): %s", new Object[]{r4.getClass().getName(), com.fasterxml.jackson.databind.l.h.h(r4)}));
    }

    public static m a(Throwable r1, Object r2, String r3) {
        return a(r1, new a(r2, r3));
    }

    public static m a(Throwable r1, Object r2, int r3) {
        return a(r1, new a(r2, r3));
    }

    public static m a(Throwable r5, a r6) {
        if (ZeusTransformUtils.instanceOf(r5, m.class) == false) goto L5;
        m r7 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
    L16:
        r7.a(r6);
        return r7;
    L5:
        String r0 = com.fasterxml.jackson.databind.l.h.h(r5);
        if (r0 != null) goto L8;
    L9:
        r0 = "(was " + r5.getClass().getName() + ")";
    L10:
        Closeable r1 = null;
        if (ZeusTransformUtils.instanceOf(r5, com.fasterxml.jackson.a.e.class) == false) goto L15;
        Object r3 = ((com.fasterxml.jackson.a.e) ZeusTransformUtils.preCheckCast(r5, com.fasterxml.jackson.a.e.class, "com.obric.aiagent.plugin")).c();
        if (ZeusTransformUtils.instanceOf(r3, Closeable.class) == false) goto L15;
        r1 = (Closeable) ZeusTransformUtils.preCheckCast(r3, Closeable.class, "com.obric.aiagent.plugin");
    L15:
        r7 = new m(r1, r0, r5);
        goto L16
    L8:
        if (r0.isEmpty() == false) goto L10;
        goto L9
    }

    public m a(Throwable r1) {
        initCause(r1);
        return this;
    }

    public StringBuilder a(StringBuilder r1) {
        b(r1);
        return r1;
    }

    @Override // com.fasterxml.jackson.databind.f
    public void a(Object r2, String r3) {
        a(new a(r2, r3));
    }

    public void a(a r3) {
        if (this.f13090b != null) goto L6;
        this.f13090b = new LinkedList();
    L6:
        if (this.f13090b.size() >= 1000) goto L9;
        this.f13090b.addFirst(r3);
        return;
    }

    @Override // com.fasterxml.jackson.a.l, com.fasterxml.jackson.a.e
    @JsonIgnore
    public Object c() {
        return this.f13091c;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return d();
    }

    @Override // com.fasterxml.jackson.a.l, java.lang.Throwable
    public String getMessage() {
        return d();
    }

    public String d() {
        String r0 = super.getMessage();
        if (this.f13090b != null) goto L5;
        return r0;
    L5:
        if (r0 != null) goto L7;
        StringBuilder r1 = new StringBuilder();
    L8:
        r1.append(" (through reference chain: ");
        StringBuilder r2 = a(r1);
        r2.append(')');
        return r2.toString();
    L7:
        r1 = new StringBuilder(r0);
        goto L8
    }

    @Override // com.fasterxml.jackson.a.l, java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    public void b(StringBuilder r4) {
        LinkedList<a> r3 = this.f13090b;
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator<a> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        r4.append(((a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.aiagent.plugin")).toString());
        if (r5.hasNext() == false) goto L7;
        r4.append("->");
        goto L7
    }
}
