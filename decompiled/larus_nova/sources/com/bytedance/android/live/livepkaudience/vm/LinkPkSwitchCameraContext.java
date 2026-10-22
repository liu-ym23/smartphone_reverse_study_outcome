package com.bytedance.android.live.livepkaudience.vm;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/vm/LinkPkSwitchCameraContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/livepkaudience/vm/c;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "<init>", "()V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPkSwitchCameraContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p service$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkPkSwitchCameraContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
    }

    public final j<c> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public LinkPkSwitchCameraContext() {
        this.service$delegate = ConstantKt.b(this, LinkPkSwitchCameraContext$service$2.INSTANCE);
    }
}
