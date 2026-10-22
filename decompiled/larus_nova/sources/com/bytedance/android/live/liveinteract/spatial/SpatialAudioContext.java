package com.bytedance.android.live.liveinteract.spatial;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/spatial/SpatialAudioContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "", "currentStrategyId$delegate", "Lcom/bytedance/live/datacontext/p;", "getCurrentStrategyId", "()Lcom/bytedance/live/datacontext/m;", "currentStrategyId", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SpatialAudioContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p currentStrategyId$delegate;

    public static final class a {
        @JvmStatic
        public final SpatialAudioContext getContext() {
            DataContext r100 = d.d(SpatialAudioContext.class);
            if ((r100 instanceof SpatialAudioContext) == true) goto L6;
            r100 = null;
        L6:
            return (SpatialAudioContext) r100;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(SpatialAudioContext.class, "currentStrategyId", "getCurrentStrategyId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final SpatialAudioContext getContext() {
        return Companion.getContext();
    }

    public final m<Integer> getCurrentStrategyId() {
        return (m) this.currentStrategyId$delegate.a(this, $$delegatedProperties[0]);
    }

    public SpatialAudioContext() {
        this.currentStrategyId$delegate = q.d(this, -1);
    }
}
