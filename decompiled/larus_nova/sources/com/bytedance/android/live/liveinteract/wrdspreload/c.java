package com.bytedance.android.live.liveinteract.wrdspreload;

import com.bytedance.android.livesdk.message.model.in;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<Long, RoomLinkMicSyncData>> f81189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Map<Long, in>> f81190b;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f81189a = new ConcurrentHashMap();
        this.f81190b = new ConcurrentHashMap();
    }
}
