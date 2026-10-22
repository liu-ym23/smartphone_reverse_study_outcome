package com.stepos.core.common.notification;

import android.content.Context;
import androidx.core.app.g;
import kotlin.jvm.internal.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadNotificationState {
    private volatile g builder;

    /* renamed from: id, reason: collision with root package name */
    private volatile int f7381id;
    private volatile boolean liveCreated;
    private volatile long whenMs;

    public DownloadNotificationState() {
        this(0, 1, null);
    }

    public final int getId() {
        return this.f7381id;
    }

    public final boolean getLiveCreated() {
        return this.liveCreated;
    }

    public final synchronized g getOrCreateBuilder(Context context, String channelId) {
        g gVar;
        try {
            kotlin.jvm.internal.g.f(context, "context");
            kotlin.jvm.internal.g.f(channelId, "channelId");
            gVar = this.builder;
            if (gVar != null) {
                gVar.f1504l = channelId;
            } else {
                gVar = new g(context, channelId);
                this.builder = gVar;
            }
        } catch (Throwable th) {
            throw th;
        }
        return gVar;
    }

    public final long getWhenMs() {
        return this.whenMs;
    }

    public final void renew() {
        this.f7381id = NotificationIdGen.INSTANCE.next();
        this.builder = null;
        this.liveCreated = false;
        this.whenMs = 0L;
    }

    public final void setId(int i10) {
        this.f7381id = i10;
    }

    public final void setLiveCreated(boolean z) {
        this.liveCreated = z;
    }

    public final void setWhenMs(long j10) {
        this.whenMs = j10;
    }

    public DownloadNotificationState(int i10) {
        this.f7381id = i10;
    }

    public /* synthetic */ DownloadNotificationState(int i10, int i11, e eVar) {
        this((i11 & 1) != 0 ? NotificationIdGen.INSTANCE.next() : i10);
    }
}
