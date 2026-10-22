package com.stepos.deepbinder.core.entity.wrapper;

import Y8.t;
import androidx.annotation.Keep;
import com.stepos.deepbinder.core.entity.pool.ObjectPool;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u0007J\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u000bJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b\u0010\u0010$\"\u0004\b'\u0010&R\"\u0010(\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&¨\u0006+"}, d2 = {"Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;", "Lcom/stepos/deepbinder/core/entity/wrapper/BaseWrapper;", "<init>", "()V", "", "name", "withMethodName", "(Ljava/lang/String;)Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;", "", "oneway", "withOneway", "(Z)Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;", "type", "withReturnType", "sync", "withSync", "isVoid", "withVoid", "LY8/t;", "recycle", "toString", "()Ljava/lang/String;", "", "pid", "I", "getPid", "()I", "setPid", "(I)V", "returnType", "Ljava/lang/String;", "getReturnType", "setReturnType", "(Ljava/lang/String;)V", "isSync", "Z", "()Z", "setSync", "(Z)V", "setVoid", "isOneway", "setOneway", "Companion", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MethodWrapper extends BaseWrapper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObjectPool<MethodWrapper> pool = new ObjectPool<>(0, new InterfaceC5063a() { // from class: j7.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return MethodWrapper.pool$lambda$5();
        }
    }, new InterfaceC5074l() { // from class: j7.b
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return MethodWrapper.pool$lambda$6((MethodWrapper) obj);
        }
    }, 1, null);
    private boolean isOneway;
    private boolean isSync;
    private boolean isVoid;
    private int pid;
    private String returnType;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper$Companion;", "", "<init>", "()V", "pool", "Lcom/stepos/deepbinder/core/entity/pool/ObjectPool;", "Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;", "obtain", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
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
    public static final t pool$lambda$6(MethodWrapper wrapper) {
        p.i(wrapper, "wrapper");
        wrapper.setName("");
        wrapper.pid = 0;
        wrapper.returnType = null;
        wrapper.isSync = false;
        wrapper.isVoid = false;
        wrapper.isOneway = false;
        return t.f7040a;
    }

    public final int getPid() {
        return this.pid;
    }

    public final String getReturnType() {
        return this.returnType;
    }

    /* renamed from: isOneway, reason: from getter */
    public final boolean getIsOneway() {
        return this.isOneway;
    }

    /* renamed from: isSync, reason: from getter */
    public final boolean getIsSync() {
        return this.isSync;
    }

    /* renamed from: isVoid, reason: from getter */
    public final boolean getIsVoid() {
        return this.isVoid;
    }

    @Override // com.stepos.deepbinder.core.entity.wrapper.BaseWrapper
    public void recycle() {
        pool.returnObject(this);
    }

    public final void setOneway(boolean z10) {
        this.isOneway = z10;
    }

    public final void setPid(int i10) {
        this.pid = i10;
    }

    public final void setReturnType(String str) {
        this.returnType = str;
    }

    public final void setSync(boolean z10) {
        this.isSync = z10;
    }

    public final void setVoid(boolean z10) {
        this.isVoid = z10;
    }

    public String toString() {
        return "MethodWrapper(name='" + getName() + "', returnType='" + this.returnType + "', isVoid=" + this.isVoid + ", isSync=" + this.isSync + ", isOneway=" + this.isOneway + ", pid=" + this.pid + ")";
    }

    public final MethodWrapper withMethodName(String name) {
        p.i(name, "name");
        setName(name);
        return this;
    }

    public final MethodWrapper withOneway(boolean oneway) {
        this.isOneway = oneway;
        return this;
    }

    public final MethodWrapper withReturnType(String type) {
        this.returnType = type;
        return this;
    }

    public final MethodWrapper withSync(boolean sync) {
        this.isSync = sync;
        return this;
    }

    public final MethodWrapper withVoid(boolean isVoid) {
        this.isVoid = isVoid;
        return this;
    }
}
