package com.bytedance.reparo.core.i.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ClassMethodFinder.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a<T>.AbstractC0213a f9275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f9276b;

    /* JADX INFO: renamed from: com.bytedance.reparo.core.i.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClassMethodFinder.java */
    abstract class AbstractC0213a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Method f9277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f9278b;

        abstract Method a();

        AbstractC0213a(a r1) {
            this.f9278b = r1;
        }

        a<T>.AbstractC0213a b() {
            Method r0 = a();
            this.f9277a = r0;
            r0.setAccessible(true);
            return this;
        }

        T a(Object r1, Object... r2) {
            return (T) this.f9277a.invoke(r1, r2);
        }
    }

    abstract List<? extends a<T>.AbstractC0213a> b();

    public a() {
        this.f9275a = null;
        this.f9276b = false;
    }

    a<T>.AbstractC0213a a() {
        if (this.f9276b == true) goto L5;
        this.f9276b = true;
        a<T>.AbstractC0213a r0 = c();
        this.f9275a = r0;
        return r0;
    L5:
        return this.f9275a;
    }

    public T a(Object r2, Object... r3) {
        a<T>.AbstractC0213a r0 = a();
        if (r0 == null) goto L7;
        return r0.a(r2, r3);
    L7:
        throw new NoSuchMethodException("NotFound method with " + getClass());
    }

    private a<T>.AbstractC0213a c() {
        List<? extends a<T>.AbstractC0213a> r0 = b();
        if (r0 != null) goto L5;
    L15:
        return null;
    L5:
        if (r0.isEmpty() == true) goto L15;
        Iterator<? extends a<T>.AbstractC0213a> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L15;
        goto L9
    L12:
        return ((AbstractC0213a) ZeusTransformUtils.preCheckCast(r1.next(), AbstractC0213a.class, "com.obric.aiagent.plugin")).b();
    L13:
        th = move-exception;
        com.bytedance.reparo.core.f.a.b("Error when getMethod in " + this.getClass(), th);
        goto L9
    }
}
