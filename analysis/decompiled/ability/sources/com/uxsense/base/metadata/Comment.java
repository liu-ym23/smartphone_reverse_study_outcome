package com.uxsense.base.metadata;

import A9.d;
import B9.C0177d;
import B9.T;
import B9.d0;
import B9.h0;
import C7.c;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0087\b\u0018\u0000 _2\u00020\u0001:\u0002`_B¯\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0004\b\u0019\u0010\u001aBµ\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0017\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0019\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010 J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010 J\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010 J\u0010\u0010$\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b(\u0010'J\u0010\u0010)\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b)\u0010 J\u0010\u0010*\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b*\u0010'J\u0010\u0010+\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b+\u0010 J\u0010\u0010,\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b,\u0010%J\u0010\u0010-\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b/\u0010 J\u0010\u00100\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b2\u0010%J\u0010\u00103\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b3\u0010'J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\u0017HÆ\u0003¢\u0006\u0004\b4\u00105JÀ\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\t2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0017HÆ\u0001¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b8\u0010'J\u0010\u00109\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b9\u0010.J\u001a\u0010;\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b;\u0010<J'\u0010E\u001a\u00020B2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@H\u0001¢\u0006\u0004\bC\u0010DR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010F\u001a\u0004\bG\u0010 R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010F\u001a\u0004\bH\u0010 R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010F\u001a\u0004\bI\u0010 R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010F\u001a\u0004\bJ\u0010 R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010K\u001a\u0004\b\b\u0010%R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010L\u001a\u0004\bM\u0010'R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010L\u001a\u0004\bN\u0010'R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010F\u001a\u0004\bO\u0010 R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\r\u0010L\u001a\u0004\bP\u0010'R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010F\u001a\u0004\bQ\u0010 R\u0017\u0010\u000f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000f\u0010K\u001a\u0004\bR\u0010%R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010S\u001a\u0004\bT\u0010.R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010F\u001a\u0004\bU\u0010 R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010V\u001a\u0004\bW\u00101R \u0010\u0015\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010K\u0012\u0004\bY\u0010Z\u001a\u0004\bX\u0010%R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010L\u001a\u0004\b[\u0010'R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\\\u001a\u0004\b]\u00105R\u0011\u0010^\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b^\u0010%¨\u0006a"}, d2 = {"Lcom/uxsense/base/metadata/Comment;", "", "", "commentId", "creationId", "rootCommentId", "parentCommentId", "", "isAuthor", "", "nickname", "avatar", "userId", "content", "commentedAt", "hasReply", "", "replyCount", "likeCount", "Lcom/uxsense/base/metadata/CommentStatus;", "status", "deleted", "ip", "", "screenshots", AppAgent.CONSTRUCT, "(JJJJZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;JZIJLcom/uxsense/base/metadata/CommentStatus;ZLjava/lang/String;Ljava/util/List;)V", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IJJJJZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;JZIJLcom/uxsense/base/metadata/CommentStatus;ZLjava/lang/String;Ljava/util/List;LB9/d0;)V", "component1", "()J", "component2", "component3", "component4", "component5", "()Z", "component6", "()Ljava/lang/String;", "component7", "component8", "component9", "component10", "component11", "component12", "()I", "component13", "component14", "()Lcom/uxsense/base/metadata/CommentStatus;", "component15", "component16", "component17", "()Ljava/util/List;", "copy", "(JJJJZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;JZIJLcom/uxsense/base/metadata/CommentStatus;ZLjava/lang/String;Ljava/util/List;)Lcom/uxsense/base/metadata/Comment;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/base/metadata/Comment;LA9/d;Lz9/g;)V", "write$Self", "J", "getCommentId", "getCreationId", "getRootCommentId", "getParentCommentId", "Z", "Ljava/lang/String;", "getNickname", "getAvatar", "getUserId", "getContent", "getCommentedAt", "getHasReply", "I", "getReplyCount", "getLikeCount", "Lcom/uxsense/base/metadata/CommentStatus;", "getStatus", "getDeleted", "getDeleted$annotations", "()V", "getIp", "Ljava/util/List;", "getScreenshots", "isRoot", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Comment {
    private static final f[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String avatar;
    private final long commentId;
    private final long commentedAt;
    private final String content;
    private final long creationId;
    private final boolean deleted;
    private final boolean hasReply;
    private final String ip;
    private final boolean isAuthor;
    private final long likeCount;
    private final String nickname;
    private final long parentCommentId;
    private final int replyCount;
    private final long rootCommentId;
    private final List<String> screenshots;
    private final CommentStatus status;
    private final long userId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/metadata/Comment$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/metadata/Comment;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return Comment$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        $childSerializers = new f[]{null, null, null, null, null, null, null, null, null, null, null, null, null, kotlin.a.b(lazyThreadSafetyMode, new com.stepos.ability.voicewakeup.service.f(18)), null, null, kotlin.a.b(lazyThreadSafetyMode, new com.stepos.ability.voicewakeup.service.f(19))};
    }

    public Comment(int i, long j5, long j6, long j10, long j11, boolean z10, String str, String str2, long j12, String str3, long j13, boolean z11, int i6, long j14, CommentStatus commentStatus, boolean z12, String str4, List list, d0 d0Var) {
        if (135 != (i & 135)) {
            T.g(Comment$$serializer.INSTANCE.getDescriptor(), i, 135);
            throw null;
        }
        this.commentId = j5;
        this.creationId = j6;
        this.rootCommentId = j10;
        if ((i & 8) == 0) {
            this.parentCommentId = 0L;
        } else {
            this.parentCommentId = j11;
        }
        if ((i & 16) == 0) {
            this.isAuthor = false;
        } else {
            this.isAuthor = z10;
        }
        if ((i & 32) == 0) {
            this.nickname = "";
        } else {
            this.nickname = str;
        }
        if ((i & 64) == 0) {
            this.avatar = "";
        } else {
            this.avatar = str2;
        }
        this.userId = j12;
        if ((i & 256) == 0) {
            this.content = "";
        } else {
            this.content = str3;
        }
        this.commentedAt = (i & 512) == 0 ? System.currentTimeMillis() : j13;
        if ((i & 1024) == 0) {
            this.hasReply = false;
        } else {
            this.hasReply = z11;
        }
        if ((i & 2048) == 0) {
            this.replyCount = 0;
        } else {
            this.replyCount = i6;
        }
        if ((i & 4096) == 0) {
            this.likeCount = 0L;
        } else {
            this.likeCount = j14;
        }
        this.status = (i & 8192) == 0 ? CommentStatus.NORMAL : commentStatus;
        if ((i & 16384) == 0) {
            this.deleted = false;
        } else {
            this.deleted = z12;
        }
        if ((32768 & i) == 0) {
            this.ip = "";
        } else {
            this.ip = str4;
        }
        this.screenshots = (i & 65536) == 0 ? EmptyList.f4893a : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_() {
        return CommentStatus.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$0() {
        return new C0177d(h0.f242a);
    }

    public static /* synthetic */ Comment copy$default(Comment comment, long j5, long j6, long j10, long j11, boolean z10, String str, String str2, long j12, String str3, long j13, boolean z11, int i, long j14, CommentStatus commentStatus, boolean z12, String str4, List list, int i6, Object obj) {
        List list2;
        String str5;
        long j15 = (i6 & 1) != 0 ? comment.commentId : j5;
        long j16 = (i6 & 2) != 0 ? comment.creationId : j6;
        long j17 = (i6 & 4) != 0 ? comment.rootCommentId : j10;
        long j18 = (i6 & 8) != 0 ? comment.parentCommentId : j11;
        boolean z13 = (i6 & 16) != 0 ? comment.isAuthor : z10;
        String str6 = (i6 & 32) != 0 ? comment.nickname : str;
        String str7 = (i6 & 64) != 0 ? comment.avatar : str2;
        long j19 = (i6 & 128) != 0 ? comment.userId : j12;
        String str8 = (i6 & 256) != 0 ? comment.content : str3;
        long j20 = j15;
        long j21 = (i6 & 512) != 0 ? comment.commentedAt : j13;
        boolean z14 = (i6 & 1024) != 0 ? comment.hasReply : z11;
        int i10 = (i6 & 2048) != 0 ? comment.replyCount : i;
        long j22 = (i6 & 4096) != 0 ? comment.likeCount : j14;
        CommentStatus commentStatus2 = (i6 & 8192) != 0 ? comment.status : commentStatus;
        boolean z15 = (i6 & 16384) != 0 ? comment.deleted : z12;
        String str9 = (i6 & 32768) != 0 ? comment.ip : str4;
        if ((i6 & 65536) != 0) {
            str5 = str9;
            list2 = comment.screenshots;
        } else {
            list2 = list;
            str5 = str9;
        }
        return comment.copy(j20, j16, j17, j18, z13, str6, str7, j19, str8, j21, z14, i10, j22, commentStatus2, z15, str5, list2);
    }

    @c
    public static /* synthetic */ void getDeleted$annotations() {
    }

    public static final void write$Self$uxsense_release(Comment self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.commentId);
        output.encodeLongElement(serialDesc, 1, self.creationId);
        output.encodeLongElement(serialDesc, 2, self.rootCommentId);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.parentCommentId != 0) {
            output.encodeLongElement(serialDesc, 3, self.parentCommentId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.isAuthor) {
            output.encodeBooleanElement(serialDesc, 4, self.isAuthor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !k.b(self.nickname, "")) {
            output.encodeStringElement(serialDesc, 5, self.nickname);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !k.b(self.avatar, "")) {
            output.encodeStringElement(serialDesc, 6, self.avatar);
        }
        output.encodeLongElement(serialDesc, 7, self.userId);
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !k.b(self.content, "")) {
            output.encodeStringElement(serialDesc, 8, self.content);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.commentedAt != System.currentTimeMillis()) {
            output.encodeLongElement(serialDesc, 9, self.commentedAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.hasReply) {
            output.encodeBooleanElement(serialDesc, 10, self.hasReply);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.replyCount != 0) {
            output.encodeIntElement(serialDesc, 11, self.replyCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.likeCount != 0) {
            output.encodeLongElement(serialDesc, 12, self.likeCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.status != CommentStatus.NORMAL) {
            output.encodeSerializableElement(serialDesc, 13, (x9.f) fVarArr[13].getF4884a(), self.status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.deleted) {
            output.encodeBooleanElement(serialDesc, 14, self.deleted);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || !k.b(self.ip, "")) {
            output.encodeStringElement(serialDesc, 15, self.ip);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 16) && k.b(self.screenshots, EmptyList.f4893a)) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 16, (x9.f) fVarArr[16].getF4884a(), self.screenshots);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCommentId() {
        return this.commentId;
    }

    /* renamed from: component10, reason: from getter */
    public final long getCommentedAt() {
        return this.commentedAt;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getHasReply() {
        return this.hasReply;
    }

    /* renamed from: component12, reason: from getter */
    public final int getReplyCount() {
        return this.replyCount;
    }

    /* renamed from: component13, reason: from getter */
    public final long getLikeCount() {
        return this.likeCount;
    }

    /* renamed from: component14, reason: from getter */
    public final CommentStatus getStatus() {
        return this.status;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getDeleted() {
        return this.deleted;
    }

    /* renamed from: component16, reason: from getter */
    public final String getIp() {
        return this.ip;
    }

    public final List<String> component17() {
        return this.screenshots;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCreationId() {
        return this.creationId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getRootCommentId() {
        return this.rootCommentId;
    }

    /* renamed from: component4, reason: from getter */
    public final long getParentCommentId() {
        return this.parentCommentId;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsAuthor() {
        return this.isAuthor;
    }

    /* renamed from: component6, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component7, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component8, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final Comment copy(long commentId, long creationId, long rootCommentId, long parentCommentId, boolean isAuthor, String nickname, String avatar, long userId, String content, long commentedAt, boolean hasReply, int replyCount, long likeCount, CommentStatus status, boolean deleted, String ip, List<String> screenshots) {
        k.f(nickname, "nickname");
        k.f(avatar, "avatar");
        k.f(content, "content");
        k.f(status, "status");
        k.f(ip, "ip");
        k.f(screenshots, "screenshots");
        return new Comment(commentId, creationId, rootCommentId, parentCommentId, isAuthor, nickname, avatar, userId, content, commentedAt, hasReply, replyCount, likeCount, status, deleted, ip, screenshots);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Comment)) {
            return false;
        }
        Comment comment = (Comment) other;
        return this.commentId == comment.commentId && this.creationId == comment.creationId && this.rootCommentId == comment.rootCommentId && this.parentCommentId == comment.parentCommentId && this.isAuthor == comment.isAuthor && k.b(this.nickname, comment.nickname) && k.b(this.avatar, comment.avatar) && this.userId == comment.userId && k.b(this.content, comment.content) && this.commentedAt == comment.commentedAt && this.hasReply == comment.hasReply && this.replyCount == comment.replyCount && this.likeCount == comment.likeCount && this.status == comment.status && this.deleted == comment.deleted && k.b(this.ip, comment.ip) && k.b(this.screenshots, comment.screenshots);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final long getCommentId() {
        return this.commentId;
    }

    public final long getCommentedAt() {
        return this.commentedAt;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreationId() {
        return this.creationId;
    }

    public final boolean getDeleted() {
        return this.deleted;
    }

    public final boolean getHasReply() {
        return this.hasReply;
    }

    public final String getIp() {
        return this.ip;
    }

    public final long getLikeCount() {
        return this.likeCount;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final long getParentCommentId() {
        return this.parentCommentId;
    }

    public final int getReplyCount() {
        return this.replyCount;
    }

    public final long getRootCommentId() {
        return this.rootCommentId;
    }

    public final List<String> getScreenshots() {
        return this.screenshots;
    }

    public final CommentStatus getStatus() {
        return this.status;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.screenshots.hashCode() + B7.a.c(androidx.appfunctions.metadata.a.d((this.status.hashCode() + androidx.appfunctions.metadata.a.c(androidx.constraintlayout.core.dsl.a.a(this.replyCount, androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.c(B7.a.c(androidx.appfunctions.metadata.a.c(B7.a.c(B7.a.c(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(Long.hashCode(this.commentId) * 31, 31, this.creationId), 31, this.rootCommentId), 31, this.parentCommentId), 31, this.isAuthor), 31, this.nickname), 31, this.avatar), 31, this.userId), 31, this.content), 31, this.commentedAt), 31, this.hasReply), 31), 31, this.likeCount)) * 31, 31, this.deleted), 31, this.ip);
    }

    public final boolean isAuthor() {
        return this.isAuthor;
    }

    public final boolean isRoot() {
        return this.parentCommentId == 0 && this.rootCommentId == this.commentId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Comment(commentId=");
        sb.append(this.commentId);
        sb.append(", creationId=");
        sb.append(this.creationId);
        sb.append(", rootCommentId=");
        sb.append(this.rootCommentId);
        sb.append(", parentCommentId=");
        sb.append(this.parentCommentId);
        sb.append(", isAuthor=");
        sb.append(this.isAuthor);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", commentedAt=");
        sb.append(this.commentedAt);
        sb.append(", hasReply=");
        sb.append(this.hasReply);
        sb.append(", replyCount=");
        sb.append(this.replyCount);
        sb.append(", likeCount=");
        sb.append(this.likeCount);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", deleted=");
        sb.append(this.deleted);
        sb.append(", ip=");
        sb.append(this.ip);
        sb.append(", screenshots=");
        return B7.a.r(sb, this.screenshots, ')');
    }

    public Comment(long j5, long j6, long j10, long j11, boolean z10, String nickname, String avatar, long j12, String content, long j13, boolean z11, int i, long j14, CommentStatus status, boolean z12, String ip, List<String> screenshots) {
        k.f(nickname, "nickname");
        k.f(avatar, "avatar");
        k.f(content, "content");
        k.f(status, "status");
        k.f(ip, "ip");
        k.f(screenshots, "screenshots");
        this.commentId = j5;
        this.creationId = j6;
        this.rootCommentId = j10;
        this.parentCommentId = j11;
        this.isAuthor = z10;
        this.nickname = nickname;
        this.avatar = avatar;
        this.userId = j12;
        this.content = content;
        this.commentedAt = j13;
        this.hasReply = z11;
        this.replyCount = i;
        this.likeCount = j14;
        this.status = status;
        this.deleted = z12;
        this.ip = ip;
        this.screenshots = screenshots;
    }

    public Comment(long j5, long j6, long j10, long j11, boolean z10, String str, String str2, long j12, String str3, long j13, boolean z11, int i, long j14, CommentStatus commentStatus, boolean z12, String str4, List list, int i6, e eVar) {
        this(j5, j6, j10, (i6 & 8) != 0 ? 0L : j11, (i6 & 16) != 0 ? false : z10, (i6 & 32) != 0 ? "" : str, (i6 & 64) != 0 ? "" : str2, j12, (i6 & 256) != 0 ? "" : str3, (i6 & 512) != 0 ? System.currentTimeMillis() : j13, (i6 & 1024) != 0 ? false : z11, (i6 & 2048) != 0 ? 0 : i, (i6 & 4096) != 0 ? 0L : j14, (i6 & 8192) != 0 ? CommentStatus.NORMAL : commentStatus, (i6 & 16384) != 0 ? false : z12, (32768 & i6) != 0 ? "" : str4, (i6 & 65536) != 0 ? EmptyList.f4893a : list);
    }
}
