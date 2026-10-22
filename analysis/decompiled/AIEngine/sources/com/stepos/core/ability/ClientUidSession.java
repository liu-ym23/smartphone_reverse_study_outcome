package com.stepos.core.ability;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ClientUidSession {
    private final Set<Integer> pids;
    private final long sessionStartMs;
    private final int uid;

    public ClientUidSession(int i10, Set<Integer> pids, long j10) {
        kotlin.jvm.internal.g.f(pids, "pids");
        this.uid = i10;
        this.pids = pids;
        this.sessionStartMs = j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClientUidSession copy$default(ClientUidSession clientUidSession, int i10, Set set, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = clientUidSession.uid;
        }
        if ((i11 & 2) != 0) {
            set = clientUidSession.pids;
        }
        if ((i11 & 4) != 0) {
            j10 = clientUidSession.sessionStartMs;
        }
        return clientUidSession.copy(i10, set, j10);
    }

    public final int component1() {
        return this.uid;
    }

    public final Set<Integer> component2() {
        return this.pids;
    }

    public final long component3() {
        return this.sessionStartMs;
    }

    public final ClientUidSession copy(int i10, Set<Integer> pids, long j10) {
        kotlin.jvm.internal.g.f(pids, "pids");
        return new ClientUidSession(i10, pids, j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientUidSession)) {
            return false;
        }
        ClientUidSession clientUidSession = (ClientUidSession) obj;
        return this.uid == clientUidSession.uid && kotlin.jvm.internal.g.b(this.pids, clientUidSession.pids) && this.sessionStartMs == clientUidSession.sessionStartMs;
    }

    public final Set<Integer> getPids() {
        return this.pids;
    }

    public final long getSessionStartMs() {
        return this.sessionStartMs;
    }

    public final int getUid() {
        return this.uid;
    }

    public int hashCode() {
        return Long.hashCode(this.sessionStartMs) + ((this.pids.hashCode() + (Integer.hashCode(this.uid) * 31)) * 31);
    }

    public String toString() {
        int i10 = this.uid;
        Set<Integer> set = this.pids;
        long j10 = this.sessionStartMs;
        StringBuilder sb2 = new StringBuilder("ClientUidSession(uid=");
        sb2.append(i10);
        sb2.append(", pids=");
        sb2.append(set);
        sb2.append(", sessionStartMs=");
        return ai.onnxruntime.a.m(sb2, j10, ")");
    }

    public /* synthetic */ ClientUidSession(int i10, Set set, long j10, int i11, kotlin.jvm.internal.e eVar) {
        this(i10, (i11 & 2) != 0 ? ConcurrentHashMap.newKeySet() : set, (i11 & 4) != 0 ? System.currentTimeMillis() : j10);
    }
}
