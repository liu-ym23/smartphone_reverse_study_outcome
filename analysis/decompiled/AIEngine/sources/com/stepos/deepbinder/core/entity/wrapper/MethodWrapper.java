package com.stepos.deepbinder.core.entity.wrapper;

import com.stepos.cpuset.c;
import com.stepos.deepbinder.core.entity.pool.ObjectPool;
import f.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class MethodWrapper extends BaseWrapper {
    public static final Companion Companion = new Companion(null);
    private static final ObjectPool<MethodWrapper> pool = new ObjectPool<>(0, new c(11), new o6.a(5), 1, null);
    private boolean isOneway;
    private boolean isSync;
    private boolean isVoid;
    private int pid;
    private String returnType;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final MethodWrapper obtain() {
            return (MethodWrapper) MethodWrapper.pool.borrowObject();
        }

        private Companion() {
        }
    }

    private MethodWrapper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MethodWrapper pool$lambda$5() {
        return new MethodWrapper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n pool$lambda$6(MethodWrapper wrapper) {
        g.f(wrapper, "wrapper");
        wrapper.setName("");
        wrapper.pid = 0;
        wrapper.returnType = null;
        wrapper.isSync = false;
        wrapper.isVoid = false;
        wrapper.isOneway = false;
        return n.f10413a;
    }

    public final int getPid() {
        return this.pid;
    }

    public final String getReturnType() {
        return this.returnType;
    }

    public final boolean isOneway() {
        return this.isOneway;
    }

    public final boolean isSync() {
        return this.isSync;
    }

    public final boolean isVoid() {
        return this.isVoid;
    }

    @Override // com.stepos.deepbinder.core.entity.wrapper.BaseWrapper
    public void recycle() {
        pool.returnObject(this);
    }

    public final void setOneway(boolean z) {
        this.isOneway = z;
    }

    public final void setPid(int i10) {
        this.pid = i10;
    }

    public final void setReturnType(String str) {
        this.returnType = str;
    }

    public final void setSync(boolean z) {
        this.isSync = z;
    }

    public final void setVoid(boolean z) {
        this.isVoid = z;
    }

    public String toString() {
        String name = getName();
        String str = this.returnType;
        boolean z = this.isVoid;
        boolean z3 = this.isSync;
        boolean z10 = this.isOneway;
        int i10 = this.pid;
        StringBuilder sbS = ai.onnxruntime.a.s("MethodWrapper(name='", name, "', returnType='", str, "', isVoid=");
        sbS.append(z);
        sbS.append(", isSync=");
        sbS.append(z3);
        sbS.append(", isOneway=");
        sbS.append(z10);
        sbS.append(", pid=");
        sbS.append(i10);
        sbS.append(")");
        return sbS.toString();
    }

    public final MethodWrapper withMethodName(String name) {
        g.f(name, "name");
        setName(name);
        return this;
    }

    public final MethodWrapper withOneway(boolean z) {
        this.isOneway = z;
        return this;
    }

    public final MethodWrapper withReturnType(String str) {
        this.returnType = str;
        return this;
    }

    public final MethodWrapper withSync(boolean z) {
        this.isSync = z;
        return this;
    }

    public final MethodWrapper withVoid(boolean z) {
        this.isVoid = z;
        return this;
    }
}
