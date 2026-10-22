package com.obric.autoaction.presentation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SessionStorage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SessionStorage.kt */
    public static final class a<T> implements d.j.c<Object, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ T f24903a;

        a(T r1) {
            this.f24903a = r1;
        }

        @Override // d.j.c
        public T getValue(Object r3, d.m.h<?> r4) {
            d.m.h<?> r5 = (d.m.h) ZeusTransformUtils.wrapperContextForParams(r4, d.m.h.class, "com.obric.aiagent.plugin");
            o.e(r5, "property");
            T r6 = (T) e.f24900a.a(a(r3, r5));
            if (r6 == null) goto L5;
            return r6;
        L5:
            return this.f24903a;
        }

        @Override // d.j.c
        public void setValue(Object r3, d.m.h<?> r4, T r5) {
            d.m.h<?> r6 = (d.m.h) ZeusTransformUtils.wrapperContextForParams(r4, d.m.h.class, "com.obric.aiagent.plugin");
            o.e(r6, "property");
            e.f24900a.a(a(r3, r6), r5);
        }

        private final String a(Object r2, d.m.h<?> r3) {
            d.m.h r1 = (d.m.h) ZeusTransformUtils.wrapperContextForParams(r3, d.m.h.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            Class<?> r4 = r2.getClass();
            if (r4 == null) goto L8;
            String r5 = r4.getName();
            if (r5 == null) goto L8;
        L10:
            return r1.getName() + r5;
        L8:
            r5 = "GlobalProps";
            goto L10
        }
    }

    public static final <T> d.j.c<Object, T> a(T r2) {
        return (d.j.c) ZeusTransformUtils.preCheckCast(new a(r2), d.j.c.class, "com.obric.aiagent.plugin");
    }
}
