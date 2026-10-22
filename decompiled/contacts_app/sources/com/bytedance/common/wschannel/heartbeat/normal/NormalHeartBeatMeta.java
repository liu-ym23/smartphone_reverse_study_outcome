package com.bytedance.common.wschannel.heartbeat.normal;

import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;

/* JADX INFO: loaded from: classes2.dex */
public class NormalHeartBeatMeta implements IHeartBeatMeta<NormalHeartBeatMeta> {
    public static final long DEFAULT_PING_INTERVAL = 270000;
    private long pingInterval;
    private long timeout;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatMeta$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class DefaultNormalHeartBeatMeta extends NormalHeartBeatMeta {
        private static final long DEFAULT_PING_INTERVAL = -1;
        private static final long DEFAULT_TIMEOUT = 5000;

        /* synthetic */ DefaultNormalHeartBeatMeta(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatMeta, com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta
        public /* bridge */ /* synthetic */ IHeartBeatMeta provideDefaultMeta() {
            return super.provideDefaultMeta();
        }

        private DefaultNormalHeartBeatMeta() {
            super(-1, 5000);
        }
    }

    @Override // com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta
    public /* bridge */ /* synthetic */ IHeartBeatMeta provideDefaultMeta() {
        return provideDefaultMeta();
    }

    public NormalHeartBeatMeta() {
    }

    public NormalHeartBeatMeta(long r1, long r3) {
        this.pingInterval = r1;
        this.timeout = r3;
    }

    public long getPingInterval() {
        return this.pingInterval;
    }

    void setPingInterval(long r1) {
        this.pingInterval = r1;
    }

    public long getTimeout() {
        return this.timeout;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta
    public NormalHeartBeatMeta provideDefaultMeta() {
        return new DefaultNormalHeartBeatMeta(null);
    }
}
