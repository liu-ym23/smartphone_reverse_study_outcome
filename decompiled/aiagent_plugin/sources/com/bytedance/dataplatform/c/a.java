package com.bytedance.dataplatform.c;

import com.bytedance.dataplatform.b.b;
import com.bytedance.dataplatform.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.t;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: ExperimentKey.kt */
/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f7939e;
    private C0178a<T> f;
    private String g;
    private Type h;
    private T i;

    /* JADX INFO: renamed from: com.bytedance.dataplatform.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExperimentKey.kt */
    private static final class C0178a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<b<T>> f7940a;

        public final com.bytedance.dataplatform.b.a<T> a(String r8, double r9) {
            Object[] r7 = ((Collection) ZeusTransformUtils.preCheckCast(this.f7940a, Collection.class, "com.obric.aiagent.plugin")).toArray(new b[0]);
            if (r7 == null) goto L7;
            b[] r10 = (b[]) ZeusTransformUtils.preCheckCast(r7, b[].class, "com.obric.aiagent.plugin");
            return new com.bytedance.dataplatform.b.a(r8, r9, "ab_test_noapt_module_name", null, (b[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r10, r10.length), b[].class, "com.obric.aiagent.plugin"));
        L7:
            throw new t("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public a(String r3, Type r4, T r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        o.d(r3, "key");
        o.d(r6, "type");
        this.g = r3;
        this.h = r6;
        this.i = r5;
        this.f7936b = true;
    }

    public final Type getType() {
        return this.h;
    }

    public T a(boolean r11) {
        String r0 = this.g;
        Type r1 = this.h;
        T r2 = this.i;
        boolean r3 = this.f7936b;
        boolean r4 = this.f7935a;
        boolean r6 = this.f7937c;
        C0178a<T> r5 = this.f;
        if (r5 == null) goto L9;
        String r7 = this.f7938d;
        if (r7 != null) goto L8;
        r7 = this.g + this.h.toString();
    L8:
        com.bytedance.dataplatform.b.a<T> r10 = r5.a(r7, this.f7939e);
    L10:
        T r12 = (T) d.a(r0, r1, r2, r3, r4, r11, r6, r10);
        if (r12 != null) goto L13;
        o.a();
    L13:
        return r12;
    L9:
        r10 = null;
        goto L10
    }
}
