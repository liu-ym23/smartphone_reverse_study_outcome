package com.uxsense.base.metadata;

import A9.d;
import B9.T;
import B9.d0;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002*)B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007B3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J.\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b'\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b(\u0010\u0017¨\u0006+"}, d2 = {"Lcom/uxsense/base/metadata/FollowersBucket;", "", "", "timestamp", "gainedCount", "lostCount", AppAgent.CONSTRUCT, "(JJJ)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IJJJLB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/base/metadata/FollowersBucket;LA9/d;Lz9/g;)V", "write$Self", "component1", "()J", "component2", "component3", "copy", "(JJJ)Lcom/uxsense/base/metadata/FollowersBucket;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimestamp", "getGainedCount", "getLostCount", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FollowersBucket {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long gainedCount;
    private final long lostCount;
    private final long timestamp;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/metadata/FollowersBucket$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/metadata/FollowersBucket;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return FollowersBucket$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public /* synthetic */ FollowersBucket(int i, long j5, long j6, long j10, d0 d0Var) {
        if (1 != (i & 1)) {
            T.g(FollowersBucket$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.timestamp = j5;
        if ((i & 2) == 0) {
            this.gainedCount = 0L;
        } else {
            this.gainedCount = j6;
        }
        if ((i & 4) == 0) {
            this.lostCount = 0L;
        } else {
            this.lostCount = j10;
        }
    }

    public static /* synthetic */ FollowersBucket copy$default(FollowersBucket followersBucket, long j5, long j6, long j10, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = followersBucket.timestamp;
        }
        long j11 = j5;
        if ((i & 2) != 0) {
            j6 = followersBucket.gainedCount;
        }
        long j12 = j6;
        if ((i & 4) != 0) {
            j10 = followersBucket.lostCount;
        }
        return followersBucket.copy(j11, j12, j10);
    }

    public static final /* synthetic */ void write$Self$uxsense_release(FollowersBucket self, d output, g serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.timestamp);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.gainedCount != 0) {
            output.encodeLongElement(serialDesc, 1, self.gainedCount);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.lostCount == 0) {
            return;
        }
        output.encodeLongElement(serialDesc, 2, self.lostCount);
    }

    /* renamed from: component1, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component2, reason: from getter */
    public final long getGainedCount() {
        return this.gainedCount;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLostCount() {
        return this.lostCount;
    }

    public final FollowersBucket copy(long timestamp, long gainedCount, long lostCount) {
        return new FollowersBucket(timestamp, gainedCount, lostCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FollowersBucket)) {
            return false;
        }
        FollowersBucket followersBucket = (FollowersBucket) other;
        return this.timestamp == followersBucket.timestamp && this.gainedCount == followersBucket.gainedCount && this.lostCount == followersBucket.lostCount;
    }

    public final long getGainedCount() {
        return this.gainedCount;
    }

    public final long getLostCount() {
        return this.lostCount;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Long.hashCode(this.lostCount) + androidx.appfunctions.metadata.a.c(Long.hashCode(this.timestamp) * 31, 31, this.gainedCount);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FollowersBucket(timestamp=");
        sb.append(this.timestamp);
        sb.append(", gainedCount=");
        sb.append(this.gainedCount);
        sb.append(", lostCount=");
        return B7.a.p(sb, this.lostCount, ')');
    }

    public FollowersBucket(long j5, long j6, long j10) {
        this.timestamp = j5;
        this.gainedCount = j6;
        this.lostCount = j10;
    }

    public /* synthetic */ FollowersBucket(long j5, long j6, long j10, int i, e eVar) {
        this(j5, (i & 2) != 0 ? 0L : j6, (i & 4) != 0 ? 0L : j10);
    }
}
