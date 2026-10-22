package com.stepos.agentbus.config;

import a1.a;
import kotlin.Metadata;
import q7.f;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentbus/config/HeartbeatConfig;", "", "missedTicksBeforeDisconnect", "", "<init>", "(I)V", "getMissedTicksBeforeDisconnect", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class HeartbeatConfig {
    private final int missedTicksBeforeDisconnect;

    public HeartbeatConfig() {
        this(0, 1, null);
    }

    public static /* synthetic */ HeartbeatConfig copy$default(HeartbeatConfig heartbeatConfig, int i2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i2 = heartbeatConfig.missedTicksBeforeDisconnect;
        }
        return heartbeatConfig.copy(i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMissedTicksBeforeDisconnect() {
        return this.missedTicksBeforeDisconnect;
    }

    public final HeartbeatConfig copy(int missedTicksBeforeDisconnect) {
        return new HeartbeatConfig(missedTicksBeforeDisconnect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HeartbeatConfig) && this.missedTicksBeforeDisconnect == ((HeartbeatConfig) other).missedTicksBeforeDisconnect;
    }

    public final int getMissedTicksBeforeDisconnect() {
        return this.missedTicksBeforeDisconnect;
    }

    public int hashCode() {
        return Integer.hashCode(this.missedTicksBeforeDisconnect);
    }

    public String toString() {
        return a.f(this.missedTicksBeforeDisconnect, "HeartbeatConfig(missedTicksBeforeDisconnect=", ")");
    }

    public HeartbeatConfig(int i2) {
        this.missedTicksBeforeDisconnect = i2;
    }

    public /* synthetic */ HeartbeatConfig(int i2, int i10, f fVar) {
        this((i10 & 1) != 0 ? 3 : i2);
    }
}
