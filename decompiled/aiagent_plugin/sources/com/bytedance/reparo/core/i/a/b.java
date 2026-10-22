package com.bytedance.reparo.core.i.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: GetDeclaredFields.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.reparo.core.i.a.a<Field[]> {

    /* JADX INFO: renamed from: com.bytedance.reparo.core.i.a.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetDeclaredFields.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: GetDeclaredFields.java */
    private class a extends com.bytedance.reparo.core.i.a.a<Field[]>.AbstractC0213a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f9279c;

        private a(b r1) {
            this.f9279c = r1;
            super(r1);
        }

        /* synthetic */ a(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.bytedance.reparo.core.i.a.a.AbstractC0213a
        /* synthetic */ Field[] a(Object r1, Object[] r2) {
            return b(r1, r2);
        }

        @Override // com.bytedance.reparo.core.i.a.a.AbstractC0213a
        Method a() {
            return Class.class.getDeclaredMethod("getDeclaredFields", new Class[]{Boolean.TYPE, List.class});
        }

        Field[] b(Object r4, Object... r5) {
            ArrayList r6 = new ArrayList();
            super.a(r4, new Object[]{false, r6});
            return (Field[]) ZeusTransformUtils.preCheckCast(r6.toArray(new Field[r6.size()]), Field[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.reparo.core.i.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GetDeclaredFields.java */
    private class C0214b extends com.bytedance.reparo.core.i.a.a<Field[]>.AbstractC0213a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f9280c;

        private C0214b(b r1) {
            this.f9280c = r1;
            super(r1);
        }

        /* synthetic */ C0214b(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.bytedance.reparo.core.i.a.a.AbstractC0213a
        /* synthetic */ Field[] a(Object r1, Object[] r2) {
            return b(r1, r2);
        }

        @Override // com.bytedance.reparo.core.i.a.a.AbstractC0213a
        Method a() {
            return Class.class.getDeclaredMethod("getDeclaredFieldsUnchecked", new Class[]{Boolean.TYPE});
        }

        Field[] b(Object r3, Object... r4) {
            return (Field[]) ZeusTransformUtils.preCheckCast(super.a(r3, new Object[]{false}), Field[].class, "com.obric.aiagent.plugin");
        }
    }

    public b() {
    }

    @Override // com.bytedance.reparo.core.i.a.a
    List<? extends com.bytedance.reparo.core.i.a.a<Field[]>.AbstractC0213a> b() {
        AnonymousClass1 r2 = null;
        return Arrays.asList(new com.bytedance.reparo.core.i.a.a.AbstractC0213a[]{new C0214b(this, r2), new a(this, r2)});
    }
}
