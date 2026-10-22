package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/context/MultiDynamicLocalContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/g;", "localComponentService$delegate", "Lcom/bytedance/live/datacontext/p;", "getLocalComponentService", "()Lcom/bytedance/live/datacontext/j;", "localComponentService", "Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/context/c;", "topReserveContext$delegate", "getTopReserveContext", "topReserveContext", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiDynamicLocalContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final com.bytedance.live.datacontext.p localComponentService$delegate;
    private final com.bytedance.live.datacontext.p topReserveContext$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MultiDynamicLocalContext.class, "localComponentService", "getLocalComponentService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiDynamicLocalContext.class, "topReserveContext", "getTopReserveContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.dynamic.g> getLocalComponentService() {
        return (com.bytedance.live.datacontext.j) this.localComponentService$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.j<c> getTopReserveContext() {
        return (com.bytedance.live.datacontext.j) this.topReserveContext$delegate.a(this, $$delegatedProperties[1]);
    }

    public MultiDynamicLocalContext() {
        this.localComponentService$delegate = ConstantKt.c(this);
        this.topReserveContext$delegate = ConstantKt.c(this);
    }
}
