package com.fasterxml.jackson.databind.b.a;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: ReadableObjectId.java */
/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Object f12353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final ObjectIdGenerator.IdKey f12354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected LinkedList<a> f12355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ObjectIdResolver f12356d;

    /* JADX INFO: compiled from: ReadableObjectId.java */
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.fasterxml.jackson.databind.b.w f12357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<?> f12358b;

        public abstract void a(Object r1, Object r2);

        public a(com.fasterxml.jackson.databind.b.w r1, Class<?> r2) {
            this.f12357a = r1;
            this.f12358b = r2;
        }

        public a(com.fasterxml.jackson.databind.b.w r1, com.fasterxml.jackson.databind.k r2) {
            this.f12357a = r1;
            this.f12358b = r2.e();
        }

        public com.fasterxml.jackson.a.i a() {
            return this.f12357a.a();
        }

        public Class<?> b() {
            return this.f12358b;
        }

        public boolean b(Object r1) {
            return r1.equals(this.f12357a.g());
        }
    }

    public boolean a(com.fasterxml.jackson.databind.h r1) {
        return false;
    }

    public z(ObjectIdGenerator.IdKey r1) {
        this.f12354b = r1;
    }

    public void a(ObjectIdResolver r3) {
        this.f12356d = (ObjectIdResolver) ZeusTransformUtils.wrapperContextForParams(r3, ObjectIdResolver.class, "com.obric.aiagent.plugin");
    }

    public ObjectIdGenerator.IdKey a() {
        return this.f12354b;
    }

    public void a(a r2) {
        if (this.f12355c != null) goto L5;
        this.f12355c = new LinkedList();
    L5:
        this.f12355c.add(r2);
    }

    public void a(Object r5) {
        this.f12356d.bindItem(this.f12354b, r5);
        this.f12353a = r5;
        Object r0 = this.f12354b.key;
        LinkedList<a> r1 = this.f12355c;
        if (r1 == null) goto L8;
        Iterator<a> r2 = r1.iterator();
        this.f12355c = null;
    L6:
        if (r2.hasNext() == false) goto L10;
        ((a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.aiagent.plugin")).a(r0, r5);
        goto L6
    L10:
        return;
    }

    public Object b() {
        Object r0 = this.f12356d.resolveId(this.f12354b);
        this.f12353a = r0;
        return r0;
    }

    public boolean c() {
        LinkedList<a> r0 = this.f12355c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return true;
    }

    public Iterator<a> d() {
        LinkedList<a> r0 = this.f12355c;
        if (r0 != null) goto L7;
        return Collections.emptyList().iterator();
    L7:
        return r0.iterator();
    }

    public String toString() {
        return String.valueOf(this.f12354b);
    }
}
