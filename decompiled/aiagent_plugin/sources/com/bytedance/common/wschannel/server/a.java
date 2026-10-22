package com.bytedance.common.wschannel.server;

import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.SocketState;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ChannelKeeper.java */
/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<Integer, IWsApp> f7031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Map<Integer, IWsChannelClient> f7032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<Integer, SocketState> f7033c;

    a() {
        this.f7031a = new ConcurrentHashMap();
        this.f7032b = new ConcurrentHashMap();
        this.f7033c = new ConcurrentHashMap();
    }
}
