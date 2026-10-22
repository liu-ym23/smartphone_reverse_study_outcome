package com.bytedance.reparo.core.i.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: GetDeclaredMethods.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.bytedance.reparo.core.i.a.a<Method[]> {

    /* JADX INFO: renamed from: com.bytedance.reparo.core.i.a.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetDeclaredMethods.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: GetDeclaredMethods.java */
    private class a extends com.bytedance.reparo.core.i.a.a<Method[]>.AbstractC0213a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f9281c;

        private a(c r1) {
            this.f9281c = r1;
            super(r1);
        }

        /* synthetic */ a(c r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.bytedance.reparo.core.i.a.a.AbstractC0213a
        /* synthetic */ Method[] a(Object r1, Object[] r2) {
            return b(r1, r2);
        }

        @Override // com.bytedance.reparo.core.i.a.a.AbstractC0213a
        Method a() {
            return Class.class.getDeclaredMethod("getDeclaredMethods", new Class[]{Boolean.TYPE, List.class});
        }

        Method[] b(Object r4, Object... r5) {
            ArrayList r6 = new ArrayList();
            super.a(r4, new Object[]{false, r6});
            return (Method[]) ZeusTransformUtils.preCheckCast(r6.toArray(new Method[r6.size()]), Method[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: GetDeclaredMethods.java */
    private class b extends com.bytedance.reparo.core.i.a.a<Method[]>.AbstractC0213a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f9282c;

        private b(c r1) {
            this.f9282c = r1;
            super(r1);
        }

        /* synthetic */ b(c r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.bytedance.reparo.core.i.a.a.AbstractC0213a
        /* synthetic */ Method[] a(Object r1, Object[] r2) {
            return b(r1, r2);
        }

        @Override // com.bytedance.reparo.core.i.a.a.AbstractC0213a
        Method a() {
            return Class.class.getDeclaredMethod("getDeclaredMethodsUnchecked", new Class[]{Boolean.TYPE});
        }

        Method[] b(Object r3, Object... r4) {
            return (Method[]) ZeusTransformUtils.preCheckCast(super.a(r3, new Object[]{false}), Method[].class, "com.obric.aiagent.plugin");
        }
    }

    public c() {
    }

    @Override // com.bytedance.reparo.core.i.a.a
    List<? extends com.bytedance.reparo.core.i.a.a<Method[]>.AbstractC0213a> b() {
        AnonymousClass1 r2 = null;
        return Arrays.asList(new com.bytedance.reparo.core.i.a.a.AbstractC0213a[]{new b(this, r2), new a(this, r2)});
    }
}
