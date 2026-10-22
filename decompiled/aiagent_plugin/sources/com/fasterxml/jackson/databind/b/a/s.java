package com.fasterxml.jackson.databind.b.a;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: ObjectIdReader.java */
/* JADX INFO: loaded from: classes2.dex */
public class s implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fasterxml.jackson.databind.x f12329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObjectIdGenerator<?> f12330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ObjectIdResolver f12331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l<Object> f12332e;
    public final com.fasterxml.jackson.databind.b.v f;

    public s(com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.x r4, ObjectIdGenerator<?> r5, com.fasterxml.jackson.databind.l<?> r6, com.fasterxml.jackson.databind.b.v r7, ObjectIdResolver r8) {
        ObjectIdResolver r9 = (ObjectIdResolver) ZeusTransformUtils.wrapperContextForParams(r8, ObjectIdResolver.class, "com.obric.aiagent.plugin");
        this.f12328a = r3;
        this.f12329b = r4;
        this.f12330c = r5;
        this.f12331d = r9;
        this.f12332e = r6;
        this.f = r7;
    }

    public static s a(com.fasterxml.jackson.databind.k r7, com.fasterxml.jackson.databind.x r8, ObjectIdGenerator<?> r9, com.fasterxml.jackson.databind.l<?> r10, com.fasterxml.jackson.databind.b.v r11, ObjectIdResolver r12) {
        return new s(r7, r8, r9, r10, r11, (ObjectIdResolver) ZeusTransformUtils.wrapperContextForParams(r12, ObjectIdResolver.class, "com.obric.aiagent.plugin"));
    }

    public com.fasterxml.jackson.databind.l<Object> a() {
        return this.f12332e;
    }

    public com.fasterxml.jackson.databind.k b() {
        return this.f12328a;
    }

    public boolean c() {
        return this.f12330c.maySerializeAsObject();
    }

    public boolean a(String r1, com.fasterxml.jackson.a.k r2) {
        return this.f12330c.isValidReferencePropertyName(r1, r2);
    }

    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return this.f12332e.a(r1, r2);
    }
}
