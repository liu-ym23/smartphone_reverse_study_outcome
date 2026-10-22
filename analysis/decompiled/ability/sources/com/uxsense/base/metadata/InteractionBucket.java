package com.uxsense.base.metadata;

import A9.d;
import B9.T;
import B9.d0;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000254BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nBS\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u0010J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001bJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001bJ\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001bJL\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010,\u001a\u0004\b.\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b/\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010,\u001a\u0004\b0\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b1\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b2\u0010\u001bR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b3\u0010\u001b¨\u00066"}, d2 = {"Lcom/uxsense/base/metadata/InteractionBucket;", "", "", "timestamp", "like", "star", "share", "comment", "view", AppAgent.CONSTRUCT, "(JJJJJJ)V", "", "seen0", "total", "LB9/d0;", "serializationConstructorMarker", "(IJJJJJJJLB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/base/metadata/InteractionBucket;LA9/d;Lz9/g;)V", "write$Self", "component1", "()J", "component2", "component3", "component4", "component5", "component6", "copy", "(JJJJJJ)Lcom/uxsense/base/metadata/InteractionBucket;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimestamp", "getLike", "getStar", "getShare", "getComment", "getView", "getTotal", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InteractionBucket {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long comment;
    private final long like;
    private final long share;
    private final long star;
    private final long timestamp;
    private final long total;
    private final long view;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/metadata/InteractionBucket$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/metadata/InteractionBucket;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return InteractionBucket$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public /* synthetic */ InteractionBucket(int i, long j5, long j6, long j10, long j11, long j12, long j13, long j14, d0 d0Var) {
        if (1 != (i & 1)) {
            T.g(InteractionBucket$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.timestamp = j5;
        if ((i & 2) == 0) {
            this.like = 0L;
        } else {
            this.like = j6;
        }
        if ((i & 4) == 0) {
            this.star = 0L;
        } else {
            this.star = j10;
        }
        if ((i & 8) == 0) {
            this.share = 0L;
        } else {
            this.share = j11;
        }
        if ((i & 16) == 0) {
            this.comment = 0L;
        } else {
            this.comment = j12;
        }
        if ((i & 32) == 0) {
            this.view = 0L;
        } else {
            this.view = j13;
        }
        this.total = (i & 64) == 0 ? this.like + this.star + this.share + this.comment : j14;
    }

    public static /* synthetic */ InteractionBucket copy$default(InteractionBucket interactionBucket, long j5, long j6, long j10, long j11, long j12, long j13, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = interactionBucket.timestamp;
        }
        return interactionBucket.copy(j5, (i & 2) != 0 ? interactionBucket.like : j6, (i & 4) != 0 ? interactionBucket.star : j10, (i & 8) != 0 ? interactionBucket.share : j11, (i & 16) != 0 ? interactionBucket.comment : j12, (i & 32) != 0 ? interactionBucket.view : j13);
    }

    public static final /* synthetic */ void write$Self$uxsense_release(InteractionBucket self, d output, g serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.timestamp);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.like != 0) {
            output.encodeLongElement(serialDesc, 1, self.like);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.star != 0) {
            output.encodeLongElement(serialDesc, 2, self.star);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.share != 0) {
            output.encodeLongElement(serialDesc, 3, self.share);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.comment != 0) {
            output.encodeLongElement(serialDesc, 4, self.comment);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.view != 0) {
            output.encodeLongElement(serialDesc, 5, self.view);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.total == self.like + self.star + self.share + self.comment) {
            return;
        }
        output.encodeLongElement(serialDesc, 6, self.total);
    }

    /* renamed from: component1, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component2, reason: from getter */
    public final long getLike() {
        return this.like;
    }

    /* renamed from: component3, reason: from getter */
    public final long getStar() {
        return this.star;
    }

    /* renamed from: component4, reason: from getter */
    public final long getShare() {
        return this.share;
    }

    /* renamed from: component5, reason: from getter */
    public final long getComment() {
        return this.comment;
    }

    /* renamed from: component6, reason: from getter */
    public final long getView() {
        return this.view;
    }

    public final InteractionBucket copy(long timestamp, long like, long star, long share, long comment, long view) {
        return new InteractionBucket(timestamp, like, star, share, comment, view);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionBucket)) {
            return false;
        }
        InteractionBucket interactionBucket = (InteractionBucket) other;
        return this.timestamp == interactionBucket.timestamp && this.like == interactionBucket.like && this.star == interactionBucket.star && this.share == interactionBucket.share && this.comment == interactionBucket.comment && this.view == interactionBucket.view;
    }

    public final long getComment() {
        return this.comment;
    }

    public final long getLike() {
        return this.like;
    }

    public final long getShare() {
        return this.share;
    }

    public final long getStar() {
        return this.star;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final long getTotal() {
        return this.total;
    }

    public final long getView() {
        return this.view;
    }

    public int hashCode() {
        return Long.hashCode(this.view) + androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(Long.hashCode(this.timestamp) * 31, 31, this.like), 31, this.star), 31, this.share), 31, this.comment);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("InteractionBucket(timestamp=");
        sb.append(this.timestamp);
        sb.append(", like=");
        sb.append(this.like);
        sb.append(", star=");
        sb.append(this.star);
        sb.append(", share=");
        sb.append(this.share);
        sb.append(", comment=");
        sb.append(this.comment);
        sb.append(", view=");
        return B7.a.p(sb, this.view, ')');
    }

    public InteractionBucket(long j5, long j6, long j10, long j11, long j12, long j13) {
        this.timestamp = j5;
        this.like = j6;
        this.star = j10;
        this.share = j11;
        this.comment = j12;
        this.view = j13;
        this.total = j6 + j10 + j11 + j12;
    }

    public /* synthetic */ InteractionBucket(long j5, long j6, long j10, long j11, long j12, long j13, int i, e eVar) {
        this(j5, (i & 2) != 0 ? 0L : j6, (i & 4) != 0 ? 0L : j10, (i & 8) != 0 ? 0L : j11, (i & 16) != 0 ? 0L : j12, (i & 32) != 0 ? 0L : j13);
    }
}
