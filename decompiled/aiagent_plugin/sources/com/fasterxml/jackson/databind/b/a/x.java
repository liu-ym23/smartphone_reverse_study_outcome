package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: PropertyValue.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f12342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12343b;

    /* JADX INFO: compiled from: PropertyValue.java */
    static final class a extends x {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final com.fasterxml.jackson.databind.b.u f12344c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final String f12345d;

        public a(x r1, Object r2, com.fasterxml.jackson.databind.b.u r3, String r4) {
            super(r1, r2);
            this.f12344c = r3;
            this.f12345d = r4;
        }

        @Override // com.fasterxml.jackson.databind.b.a.x
        public void a(Object r3) {
            this.f12344c.a(r3, this.f12345d, this.f12343b);
        }
    }

    /* JADX INFO: compiled from: PropertyValue.java */
    static final class b extends x {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Object f12346c;

        public b(x r1, Object r2, Object r3) {
            super(r1, r2);
            this.f12346c = r3;
        }

        @Override // com.fasterxml.jackson.databind.b.a.x
        public void a(Object r3) {
            ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin")).put(this.f12346c, this.f12343b);
        }
    }

    /* JADX INFO: compiled from: PropertyValue.java */
    static final class c extends x {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final com.fasterxml.jackson.databind.b.v f12347c;

        public c(x r1, Object r2, com.fasterxml.jackson.databind.b.v r3) {
            super(r1, r2);
            this.f12347c = r3;
        }

        @Override // com.fasterxml.jackson.databind.b.a.x
        public void a(Object r2) {
            this.f12347c.a(r2, this.f12343b);
        }
    }

    public abstract void a(Object r1);

    public x(x r1, Object r2) {
        this.f12342a = r1;
        this.f12343b = r2;
    }
}
