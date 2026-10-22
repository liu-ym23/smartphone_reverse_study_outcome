package com.bytedance.android.livesdk.chatroom.newcontainer.business.common.logger.datacenter;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.p;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/newcontainer/business/common/logger/datacenter/LiveLoggerDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/livesdk/chatroom/newcontainer/business/common/logger/datacenter/a;", "liveRoomLoggerEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "getLiveRoomLoggerEvent", "()Lcom/bytedance/live/datacontext/k;", "liveRoomLoggerEvent", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLoggerDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p liveRoomLoggerEvent$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LiveLoggerDataContext.class, "liveRoomLoggerEvent", "getLiveRoomLoggerEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
    }

    public final k<a> getLiveRoomLoggerEvent() {
        return (k) this.liveRoomLoggerEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    public LiveLoggerDataContext() {
        this.liveRoomLoggerEvent$delegate = e.b(this);
    }
}
