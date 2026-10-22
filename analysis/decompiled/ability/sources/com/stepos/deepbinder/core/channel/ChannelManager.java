package com.stepos.deepbinder.core.channel;

import android.os.IBinder;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.channel.client.BaseClientChannel;
import com.stepos.deepbinder.core.channel.client.DefaultClientChannel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/deepbinder/core/channel/ChannelManager;", "", AppAgent.CONSTRUCT, "()V", "clientChannelMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/os/IBinder;", "Lcom/stepos/deepbinder/core/channel/client/BaseClientChannel;", "getClientChannel", "binder", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChannelManager {
    public static final ChannelManager INSTANCE = new ChannelManager();
    private static final ConcurrentHashMap<IBinder, BaseClientChannel> clientChannelMap = new ConcurrentHashMap<>();

    private ChannelManager() {
    }

    public final synchronized BaseClientChannel getClientChannel(IBinder binder) {
        BaseClientChannel defaultClientChannel;
        BaseClientChannel baseClientChannelPutIfAbsent;
        try {
            k.f(binder, "binder");
            ConcurrentHashMap<IBinder, BaseClientChannel> concurrentHashMap = clientChannelMap;
            defaultClientChannel = concurrentHashMap.get(binder);
            if (defaultClientChannel == null && (baseClientChannelPutIfAbsent = concurrentHashMap.putIfAbsent(binder, (defaultClientChannel = new DefaultClientChannel(binder)))) != null) {
                defaultClientChannel = baseClientChannelPutIfAbsent;
            }
        } catch (Throwable th) {
            throw th;
        }
        return defaultClientChannel;
    }
}
