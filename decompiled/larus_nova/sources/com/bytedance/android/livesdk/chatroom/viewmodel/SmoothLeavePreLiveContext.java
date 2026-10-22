package com.bytedance.android.livesdk.chatroom.viewmodel;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/SmoothLeavePreLiveContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/livesdk/chatroom/viewmodel/SmoothLeavePreLiveContext$a;", "smoothLeavePre$delegate", "Lcom/bytedance/live/datacontext/p;", "getSmoothLeavePre", "()Lcom/bytedance/live/datacontext/k;", "smoothLeavePre", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SmoothLeavePreLiveContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p smoothLeavePre$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(SmoothLeavePreLiveContext.class, "smoothLeavePre", "getSmoothLeavePre()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
    }

    public final com.bytedance.live.datacontext.k<a> getSmoothLeavePre() {
        return (com.bytedance.live.datacontext.k) this.smoothLeavePre$delegate.a(this, $$delegatedProperties[0]);
    }

    public SmoothLeavePreLiveContext() {
        this.smoothLeavePre$delegate = com.bytedance.live.datacontext.e.b(this);
        com.bytedance.live.datacontext.b.a(this, "data_smooth_leave_live_context");
    }
}
