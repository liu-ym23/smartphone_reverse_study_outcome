package com.stepos.deepbinder.client.channel;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.client.channel.remote.BaseRemoteChannel;
import com.stepos.deepbinder.client.channel.remote.MixRemoteChannel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0016R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/stepos/deepbinder/client/channel/ClientChannelManager;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/ComponentName;", "componentName", "Lcom/stepos/deepbinder/client/channel/remote/BaseRemoteChannel;", "getRemoteChannel", "(Landroid/content/ComponentName;)Lcom/stepos/deepbinder/client/channel/remote/BaseRemoteChannel;", "Lcom/stepos/deepbinder/client/channel/remote/MixRemoteChannel;", "mixRemoteChannel", "(Landroid/content/ComponentName;Lcom/stepos/deepbinder/client/channel/remote/MixRemoteChannel;)Lcom/stepos/deepbinder/client/channel/remote/BaseRemoteChannel;", "", "isRelease", "(Landroid/content/ComponentName;)Z", "LC7/r;", "releaseRemoteChannel", "(Landroid/content/ComponentName;)V", "", "time", "setDisconnectTime", "(I)V", "(Landroid/content/ComponentName;I)V", "", "remoteChannelMap", "Ljava/util/Map;", "defaultDisconnectTime", "I", "customDisconnectTimes", "Lcom/stepos/deepbinder/client/channel/ClientChannelManager$DisconnectHandler;", "disconnectHandler", "Lcom/stepos/deepbinder/client/channel/ClientChannelManager$DisconnectHandler;", "DisconnectHandler", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClientChannelManager {
    public static final ClientChannelManager INSTANCE = new ClientChannelManager();
    private static final Map<ComponentName, BaseRemoteChannel> remoteChannelMap = new LinkedHashMap();
    private static int defaultDisconnectTime = 300000;
    private static final Map<Integer, Integer> customDisconnectTimes = new LinkedHashMap();
    private static final DisconnectHandler disconnectHandler = new DisconnectHandler();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/deepbinder/client/channel/ClientChannelManager$DisconnectHandler;", "Landroid/os/Handler;", AppAgent.CONSTRUCT, "()V", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "LC7/r;", "handleMessage", "(Landroid/os/Message;)V", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DisconnectHandler extends Handler {
        public DisconnectHandler() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message msg) {
            Object next;
            k.f(msg, "msg");
            super.handleMessage(msg);
            Iterator it = ClientChannelManager.remoteChannelMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((ComponentName) ((Map.Entry) next).getKey()).hashCode() == msg.what) {
                        break;
                    }
                }
            }
            Map.Entry entry = (Map.Entry) next;
            if (entry != null) {
                ClientChannelManager.INSTANCE.releaseRemoteChannel((ComponentName) entry.getKey());
            }
        }
    }

    private ClientChannelManager() {
    }

    public final synchronized BaseRemoteChannel getRemoteChannel(ComponentName componentName) {
        k.f(componentName, "componentName");
        return getRemoteChannel(componentName, null);
    }

    public final boolean isRelease(ComponentName componentName) {
        k.f(componentName, "componentName");
        return remoteChannelMap.get(componentName) == null;
    }

    public final synchronized void releaseRemoteChannel(ComponentName componentName) {
        k.f(componentName, "componentName");
        BaseRemoteChannel baseRemoteChannelRemove = remoteChannelMap.remove(componentName);
        if (baseRemoteChannelRemove != null) {
            baseRemoteChannelRemove.release();
        }
    }

    public final void setDisconnectTime(int time) {
        defaultDisconnectTime = time;
    }

    public final synchronized BaseRemoteChannel getRemoteChannel(ComponentName componentName, MixRemoteChannel mixRemoteChannel) {
        BaseRemoteChannel baseRemoteChannel;
        try {
            k.f(componentName, "componentName");
            Map<ComponentName, BaseRemoteChannel> map = remoteChannelMap;
            baseRemoteChannel = map.get(componentName);
            if (baseRemoteChannel == null) {
                if (mixRemoteChannel == null) {
                    mixRemoteChannel = new MixRemoteChannel(componentName);
                }
                map.put(componentName, mixRemoteChannel);
                baseRemoteChannel = mixRemoteChannel;
            }
            int iHashCode = componentName.hashCode();
            DisconnectHandler disconnectHandler2 = disconnectHandler;
            if (disconnectHandler2.hasMessages(iHashCode)) {
                disconnectHandler2.removeMessages(iHashCode);
            }
            Integer num = customDisconnectTimes.get(Integer.valueOf(iHashCode));
            int iIntValue = num != null ? num.intValue() : defaultDisconnectTime;
            if (iIntValue != -1) {
                disconnectHandler2.sendEmptyMessageDelayed(iHashCode, iIntValue);
            }
        } catch (Throwable th) {
            throw th;
        }
        return baseRemoteChannel;
    }

    public final void setDisconnectTime(ComponentName componentName, int time) {
        k.f(componentName, "componentName");
        customDisconnectTimes.put(Integer.valueOf(componentName.hashCode()), Integer.valueOf(time));
    }
}
