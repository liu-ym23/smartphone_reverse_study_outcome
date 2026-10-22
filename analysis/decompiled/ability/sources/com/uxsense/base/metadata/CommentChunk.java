package com.uxsense.base.metadata;

import A9.d;
import B9.C0177d;
import B9.T;
import B9.d0;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000298BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rBS\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0012J'\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001dJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001dJR\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010-\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b-\u0010.R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u0010\u001dR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010/\u001a\u0004\b1\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010/\u001a\u0004\b2\u0010\u001dR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u00103\u001a\u0004\b4\u0010!R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00105\u001a\u0004\b6\u0010#R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010/\u001a\u0004\b7\u0010\u001d¨\u0006:"}, d2 = {"Lcom/uxsense/base/metadata/CommentChunk;", "", "", "chunkId", "creationId", "rootCommentId", "", "Lcom/uxsense/base/metadata/Comment;", "comments", "", "hasMore", "fetchedAt", AppAgent.CONSTRUCT, "(JJJLjava/util/List;ZJ)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IJJJLjava/util/List;ZJLB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/base/metadata/CommentChunk;LA9/d;Lz9/g;)V", "write$Self", "component1", "()J", "component2", "component3", "component4", "()Ljava/util/List;", "component5", "()Z", "component6", "copy", "(JJJLjava/util/List;ZJ)Lcom/uxsense/base/metadata/CommentChunk;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getChunkId", "getCreationId", "getRootCommentId", "Ljava/util/List;", "getComments", "Z", "getHasMore", "getFetchedAt", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CommentChunk {
    private final long chunkId;
    private final List<Comment> comments;
    private final long creationId;
    private final long fetchedAt;
    private final boolean hasMore;
    private final long rootCommentId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final f[] $childSerializers = {null, null, null, kotlin.a.b(LazyThreadSafetyMode.b, new com.stepos.ability.voicewakeup.service.f(20)), null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/metadata/CommentChunk$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/metadata/CommentChunk;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return CommentChunk$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public /* synthetic */ CommentChunk(int i, long j5, long j6, long j10, List list, boolean z10, long j11, d0 d0Var) {
        if (43 != (i & 43)) {
            T.g(CommentChunk$$serializer.INSTANCE.getDescriptor(), i, 43);
            throw null;
        }
        this.chunkId = j5;
        this.creationId = j6;
        if ((i & 4) == 0) {
            this.rootCommentId = 0L;
        } else {
            this.rootCommentId = j10;
        }
        this.comments = list;
        if ((i & 16) == 0) {
            this.hasMore = false;
        } else {
            this.hasMore = z10;
        }
        this.fetchedAt = j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_() {
        return new C0177d(Comment$$serializer.INSTANCE);
    }

    public static /* synthetic */ CommentChunk copy$default(CommentChunk commentChunk, long j5, long j6, long j10, List list, boolean z10, long j11, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = commentChunk.chunkId;
        }
        long j12 = j5;
        if ((i & 2) != 0) {
            j6 = commentChunk.creationId;
        }
        return commentChunk.copy(j12, j6, (i & 4) != 0 ? commentChunk.rootCommentId : j10, (i & 8) != 0 ? commentChunk.comments : list, (i & 16) != 0 ? commentChunk.hasMore : z10, (i & 32) != 0 ? commentChunk.fetchedAt : j11);
    }

    public static final /* synthetic */ void write$Self$uxsense_release(CommentChunk self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.chunkId);
        output.encodeLongElement(serialDesc, 1, self.creationId);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.rootCommentId != 0) {
            output.encodeLongElement(serialDesc, 2, self.rootCommentId);
        }
        output.encodeSerializableElement(serialDesc, 3, (x9.f) fVarArr[3].getF4884a(), self.comments);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.hasMore) {
            output.encodeBooleanElement(serialDesc, 4, self.hasMore);
        }
        output.encodeLongElement(serialDesc, 5, self.fetchedAt);
    }

    /* renamed from: component1, reason: from getter */
    public final long getChunkId() {
        return this.chunkId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCreationId() {
        return this.creationId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getRootCommentId() {
        return this.rootCommentId;
    }

    public final List<Comment> component4() {
        return this.comments;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: component6, reason: from getter */
    public final long getFetchedAt() {
        return this.fetchedAt;
    }

    public final CommentChunk copy(long chunkId, long creationId, long rootCommentId, List<Comment> comments, boolean hasMore, long fetchedAt) {
        k.f(comments, "comments");
        return new CommentChunk(chunkId, creationId, rootCommentId, comments, hasMore, fetchedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentChunk)) {
            return false;
        }
        CommentChunk commentChunk = (CommentChunk) other;
        return this.chunkId == commentChunk.chunkId && this.creationId == commentChunk.creationId && this.rootCommentId == commentChunk.rootCommentId && k.b(this.comments, commentChunk.comments) && this.hasMore == commentChunk.hasMore && this.fetchedAt == commentChunk.fetchedAt;
    }

    public final long getChunkId() {
        return this.chunkId;
    }

    public final List<Comment> getComments() {
        return this.comments;
    }

    public final long getCreationId() {
        return this.creationId;
    }

    public final long getFetchedAt() {
        return this.fetchedAt;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final long getRootCommentId() {
        return this.rootCommentId;
    }

    public int hashCode() {
        return Long.hashCode(this.fetchedAt) + androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.e(this.comments, androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(Long.hashCode(this.chunkId) * 31, 31, this.creationId), 31, this.rootCommentId), 31), 31, this.hasMore);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CommentChunk(chunkId=");
        sb.append(this.chunkId);
        sb.append(", creationId=");
        sb.append(this.creationId);
        sb.append(", rootCommentId=");
        sb.append(this.rootCommentId);
        sb.append(", comments=");
        sb.append(this.comments);
        sb.append(", hasMore=");
        sb.append(this.hasMore);
        sb.append(", fetchedAt=");
        return B7.a.p(sb, this.fetchedAt, ')');
    }

    public CommentChunk(long j5, long j6, long j10, List<Comment> comments, boolean z10, long j11) {
        k.f(comments, "comments");
        this.chunkId = j5;
        this.creationId = j6;
        this.rootCommentId = j10;
        this.comments = comments;
        this.hasMore = z10;
        this.fetchedAt = j11;
    }

    public /* synthetic */ CommentChunk(long j5, long j6, long j10, List list, boolean z10, long j11, int i, e eVar) {
        this(j5, j6, (i & 4) != 0 ? 0L : j10, list, (i & 16) != 0 ? false : z10, j11);
    }
}
