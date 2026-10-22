package com.bytedance.android.live.revlink.link.streaminteract.stream;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR-\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/revlink/link/streaminteract/stream/StreamManagerDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/link/streaminteract/stream/a;", "Lcom/bytedance/live/datacontext/m;", "", "", "", "validStreams$delegate", "Lcom/bytedance/live/datacontext/p;", "getValidStreams", "()Lcom/bytedance/live/datacontext/m;", "validStreams", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StreamManagerDataContext extends DataContext implements a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p validStreams$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(StreamManagerDataContext.class, "validStreams", "getValidStreams()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public m<Map<String, Object>> getValidStreams() {
        return (m) this.validStreams$delegate.a(this, $$delegatedProperties[0]);
    }

    public StreamManagerDataContext() {
        this.validStreams$delegate = q.a(this, MapsKt.emptyMap(), StreamManagerDataContext$validStreams$2.INSTANCE);
    }
}
