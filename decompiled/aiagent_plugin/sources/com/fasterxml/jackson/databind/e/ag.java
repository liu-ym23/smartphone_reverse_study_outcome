package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: TypeResolutionContext.java */
/* JADX INFO: loaded from: classes2.dex */
public interface ag {

    /* JADX INFO: compiled from: TypeResolutionContext.java */
    public static class a implements ag {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.fasterxml.jackson.databind.k.o f12598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.fasterxml.jackson.databind.k.n f12599b;

        public a(com.fasterxml.jackson.databind.k.o r1, com.fasterxml.jackson.databind.k.n r2) {
            this.f12598a = r1;
            this.f12599b = r2;
        }

        @Override // com.fasterxml.jackson.databind.e.ag
        public com.fasterxml.jackson.databind.k a(Type r3) {
            Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
            return this.f12598a.a(r4, this.f12599b);
        }
    }

    com.fasterxml.jackson.databind.k a(Type r1);
}
