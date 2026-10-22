package com.fasterxml.jackson.databind.h;

import com.fasterxml.jackson.databind.a.m;
import com.fasterxml.jackson.databind.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: PolymorphicTypeValidator.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements Serializable {

    /* JADX INFO: compiled from: PolymorphicTypeValidator.java */
    public static abstract class a extends c implements Serializable {
        public a() {
        }

        @Override // com.fasterxml.jackson.databind.h.c
        public b a(m<?> r1, k r2) {
            return b.f12750c;
        }

        @Override // com.fasterxml.jackson.databind.h.c
        public b a(m<?> r1, k r2, String r3) {
            return b.f12750c;
        }

        @Override // com.fasterxml.jackson.databind.h.c
        public b a(m<?> r1, k r2, k r3) {
            return b.f12750c;
        }
    }

    /* JADX INFO: compiled from: PolymorphicTypeValidator.java */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12748a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f12749b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f12750c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f12751d = null;

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f12751d.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("ALLOWED", 0);
            f12748a = r0;
            b r1 = new b("DENIED", 1);
            f12749b = r1;
            b r3 = new b("INDETERMINATE", 2);
            f12750c = r3;
            f12751d = new b[]{r0, r1, r3};
        }
    }

    public abstract b a(m<?> r1, k r2);

    public abstract b a(m<?> r1, k r2, k r3);

    public abstract b a(m<?> r1, k r2, String r3);

    public c() {
    }
}
