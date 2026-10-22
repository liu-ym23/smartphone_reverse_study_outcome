package com.uxsense.base.metadata;

import A9.d;
import B9.C0177d;
import B9.T;
import B9.d0;
import B9.h0;
import C7.f;
import D7.N;
import D7.v;
import D7.w;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\b\u0087\b\u0018\u0000 y2\u00020\u0001:\u0002yzB\u0087\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b \u0010!B\u0095\u0002\b\u0010\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n\u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b \u0010&J\r\u0010'\u001a\u00020\u0004¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0004¢\u0006\u0004\b)\u0010(J\u0015\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0000¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b/\u0010(J\u0010\u00100\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b0\u0010.J\u0010\u00101\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b1\u0010(J\u0010\u00102\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b2\u0010(J\u0010\u00103\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b3\u0010(J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0003¢\u0006\u0004\b4\u00105J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0003¢\u0006\u0004\b6\u00105J\u0010\u00107\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b9\u0010(J\u0010\u0010:\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b:\u0010(J\u0010\u0010;\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b;\u0010(J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0003¢\u0006\u0004\b<\u00105J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0003¢\u0006\u0004\b=\u00105J\u0010\u0010>\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b>\u0010(J\u0010\u0010?\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b?\u0010(J\u0010\u0010@\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b@\u0010.J\u0010\u0010A\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\bA\u0010.J\u0010\u0010B\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\bB\u0010.J\u0010\u0010C\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\bG\u0010HJ\u0016\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0003¢\u0006\u0004\bI\u00105J\u0094\u0002\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0001¢\u0006\u0004\bJ\u0010KJ\u0010\u0010L\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\bL\u0010(J\u0010\u0010M\u001a\u00020\"HÖ\u0001¢\u0006\u0004\bM\u0010NJ\u001a\u0010P\u001a\u00020O2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bP\u0010QJ'\u0010Z\u001a\u00020W2\u0006\u0010R\u001a\u00020\u00002\u0006\u0010T\u001a\u00020S2\u0006\u0010V\u001a\u00020UH\u0001¢\u0006\u0004\bX\u0010YR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010[\u001a\u0004\b\\\u0010.R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010]\u001a\u0004\b^\u0010(R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010[\u001a\u0004\b_\u0010.R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010]\u001a\u0004\b`\u0010(R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010]\u001a\u0004\ba\u0010(R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010]\u001a\u0004\bb\u0010(R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010c\u001a\u0004\bd\u00105R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006¢\u0006\f\n\u0004\b\f\u0010c\u001a\u0004\be\u00105R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010f\u001a\u0004\bg\u00108R\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010]\u001a\u0004\bh\u0010(R\u0017\u0010\u0010\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010]\u001a\u0004\bi\u0010(R\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010]\u001a\u0004\bj\u0010(R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010c\u001a\u0004\bk\u00105R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010c\u001a\u0004\bl\u00105R\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010]\u001a\u0004\bm\u0010(R\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010]\u001a\u0004\bn\u0010(R\u0017\u0010\u0016\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010[\u001a\u0004\bo\u0010.R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010[\u001a\u0004\bp\u0010.R\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010[\u001a\u0004\bq\u0010.R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010r\u001a\u0004\bs\u0010DR\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010t\u001a\u0004\bu\u0010FR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010v\u001a\u0004\bw\u0010HR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006¢\u0006\f\n\u0004\b\u001f\u0010c\u001a\u0004\bx\u00105¨\u0006{"}, d2 = {"Lcom/uxsense/base/metadata/Creation;", "", "", "creationId", "", "postId", "userId", "uuid", "authorNickname", "cover", "", "images", "videos", "Lcom/uxsense/base/metadata/CreationType;", "type", "title", "content", "group", "tags", "mentionedUsers", "location", "extra", "createdAt", "publishedAt", "lastEditedAt", "Lcom/uxsense/base/metadata/Visibility;", "visibility", "Lcom/uxsense/base/metadata/InteractionStats;", "interactionStats", "Lcom/uxsense/base/metadata/CommentIndex;", "commentIndex", "screenshots", AppAgent.CONSTRUCT, "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/uxsense/base/metadata/CreationType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JJJLcom/uxsense/base/metadata/Visibility;Lcom/uxsense/base/metadata/InteractionStats;Lcom/uxsense/base/metadata/CommentIndex;Ljava/util/List;)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/uxsense/base/metadata/CreationType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JJJLcom/uxsense/base/metadata/Visibility;Lcom/uxsense/base/metadata/InteractionStats;Lcom/uxsense/base/metadata/CommentIndex;Ljava/util/List;LB9/d0;)V", "getDayFileName", "()Ljava/lang/String;", "getMonthFileName", "other", "mergeWith", "(Lcom/uxsense/base/metadata/Creation;)Lcom/uxsense/base/metadata/Creation;", "component1", "()J", "component2", "component3", "component4", "component5", "component6", "component7", "()Ljava/util/List;", "component8", "component9", "()Lcom/uxsense/base/metadata/CreationType;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "()Lcom/uxsense/base/metadata/Visibility;", "component21", "()Lcom/uxsense/base/metadata/InteractionStats;", "component22", "()Lcom/uxsense/base/metadata/CommentIndex;", "component23", "copy", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/uxsense/base/metadata/CreationType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JJJLcom/uxsense/base/metadata/Visibility;Lcom/uxsense/base/metadata/InteractionStats;Lcom/uxsense/base/metadata/CommentIndex;Ljava/util/List;)Lcom/uxsense/base/metadata/Creation;", "toString", "hashCode", "()I", "", "equals", "(Ljava/lang/Object;)Z", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/base/metadata/Creation;LA9/d;Lz9/g;)V", "write$Self", "J", "getCreationId", "Ljava/lang/String;", "getPostId", "getUserId", "getUuid", "getAuthorNickname", "getCover", "Ljava/util/List;", "getImages", "getVideos", "Lcom/uxsense/base/metadata/CreationType;", "getType", "getTitle", "getContent", "getGroup", "getTags", "getMentionedUsers", "getLocation", "getExtra", "getCreatedAt", "getPublishedAt", "getLastEditedAt", "Lcom/uxsense/base/metadata/Visibility;", "getVisibility", "Lcom/uxsense/base/metadata/InteractionStats;", "getInteractionStats", "Lcom/uxsense/base/metadata/CommentIndex;", "getCommentIndex", "getScreenshots", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Creation {
    private static final f[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DateTimeFormatter dateFormatter;
    private final String authorNickname;
    private final CommentIndex commentIndex;
    private final String content;
    private final String cover;
    private final long createdAt;
    private final long creationId;
    private final String extra;
    private final String group;
    private final List<String> images;
    private final InteractionStats interactionStats;
    private final long lastEditedAt;
    private final String location;
    private final List<String> mentionedUsers;
    private final String postId;
    private final long publishedAt;
    private final List<String> screenshots;
    private final List<String> tags;
    private final String title;
    private final CreationType type;
    private final long userId;
    private final String uuid;
    private final List<String> videos;
    private final Visibility visibility;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/uxsense/base/metadata/Creation$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/metadata/Creation;", "serializer", "()Lx9/b;", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "dateFormatter", "Ljava/time/format/DateTimeFormatter;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final b serializer() {
            return Creation$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        $childSerializers = new f[]{null, null, null, null, null, null, kotlin.a.b(lazyThreadSafetyMode, new com.stepos.ability.voicewakeup.service.f(24)), kotlin.a.b(lazyThreadSafetyMode, new com.stepos.ability.voicewakeup.service.f(25)), kotlin.a.b(lazyThreadSafetyMode, new com.stepos.ability.voicewakeup.service.f(26)), null, null, null, kotlin.a.b(lazyThreadSafetyMode, new com.stepos.ability.voicewakeup.service.f(27)), kotlin.a.b(lazyThreadSafetyMode, new com.stepos.ability.voicewakeup.service.f(28)), null, null, null, null, null, kotlin.a.b(lazyThreadSafetyMode, new com.stepos.ability.voicewakeup.service.f(29)), null, null, kotlin.a.b(lazyThreadSafetyMode, new a(0))};
        dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    public Creation(int i, long j5, String str, long j6, String str2, String str3, String str4, List list, List list2, CreationType creationType, String str5, String str6, String str7, List list3, List list4, String str8, String str9, long j10, long j11, long j12, Visibility visibility, InteractionStats interactionStats, CommentIndex commentIndex, List list5, d0 d0Var) {
        if (5 != (i & 5)) {
            T.g(Creation$$serializer.INSTANCE.getDescriptor(), i, 5);
            throw null;
        }
        this.creationId = j5;
        if ((i & 2) == 0) {
            this.postId = "";
        } else {
            this.postId = str;
        }
        this.userId = j6;
        if ((i & 8) == 0) {
            this.uuid = "";
        } else {
            this.uuid = str2;
        }
        if ((i & 16) == 0) {
            this.authorNickname = "";
        } else {
            this.authorNickname = str3;
        }
        if ((i & 32) == 0) {
            this.cover = "";
        } else {
            this.cover = str4;
        }
        this.images = (i & 64) == 0 ? EmptyList.f4893a : list;
        this.videos = (i & 128) == 0 ? EmptyList.f4893a : list2;
        this.type = (i & 256) == 0 ? CreationType.TEXT : creationType;
        if ((i & 512) == 0) {
            this.title = "";
        } else {
            this.title = str5;
        }
        if ((i & 1024) == 0) {
            this.content = "";
        } else {
            this.content = str6;
        }
        if ((i & 2048) == 0) {
            this.group = "";
        } else {
            this.group = str7;
        }
        this.tags = (i & 4096) == 0 ? EmptyList.f4893a : list3;
        this.mentionedUsers = (i & 8192) == 0 ? EmptyList.f4893a : list4;
        if ((i & 16384) == 0) {
            this.location = "";
        } else {
            this.location = str8;
        }
        if ((32768 & i) == 0) {
            this.extra = "";
        } else {
            this.extra = str9;
        }
        if ((65536 & i) == 0) {
            this.createdAt = 0L;
        } else {
            this.createdAt = j10;
        }
        if ((131072 & i) == 0) {
            this.publishedAt = 0L;
        } else {
            this.publishedAt = j11;
        }
        this.lastEditedAt = (262144 & i) != 0 ? j12 : 0L;
        this.visibility = (524288 & i) == 0 ? Visibility.PUBLIC : visibility;
        this.interactionStats = (1048576 & i) == 0 ? new InteractionStats(0L, 0L, 0L, 0L, 0L, 0L, (List) null, 127, (e) null) : interactionStats;
        this.commentIndex = (2097152 & i) == 0 ? new CommentIndex((List) null, (Map) null, 3, (e) null) : commentIndex;
        this.screenshots = (i & 4194304) == 0 ? EmptyList.f4893a : list5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_() {
        return new C0177d(h0.f242a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$10() {
        return new C0177d(h0.f242a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$11() {
        return CreationType.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$12() {
        return new C0177d(h0.f242a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$13() {
        return new C0177d(h0.f242a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$14() {
        return Visibility.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$15() {
        return new C0177d(h0.f242a);
    }

    public static /* synthetic */ Creation copy$default(Creation creation, long j5, String str, long j6, String str2, String str3, String str4, List list, List list2, CreationType creationType, String str5, String str6, String str7, List list3, List list4, String str8, String str9, long j10, long j11, long j12, Visibility visibility, InteractionStats interactionStats, CommentIndex commentIndex, List list5, int i, Object obj) {
        List list6;
        CommentIndex commentIndex2;
        long j13 = (i & 1) != 0 ? creation.creationId : j5;
        String str10 = (i & 2) != 0 ? creation.postId : str;
        long j14 = (i & 4) != 0 ? creation.userId : j6;
        String str11 = (i & 8) != 0 ? creation.uuid : str2;
        String str12 = (i & 16) != 0 ? creation.authorNickname : str3;
        String str13 = (i & 32) != 0 ? creation.cover : str4;
        List list7 = (i & 64) != 0 ? creation.images : list;
        List list8 = (i & 128) != 0 ? creation.videos : list2;
        CreationType creationType2 = (i & 256) != 0 ? creation.type : creationType;
        String str14 = (i & 512) != 0 ? creation.title : str5;
        String str15 = (i & 1024) != 0 ? creation.content : str6;
        String str16 = (i & 2048) != 0 ? creation.group : str7;
        long j15 = j13;
        List list9 = (i & 4096) != 0 ? creation.tags : list3;
        List list10 = (i & 8192) != 0 ? creation.mentionedUsers : list4;
        List list11 = list9;
        String str17 = (i & 16384) != 0 ? creation.location : str8;
        String str18 = (i & 32768) != 0 ? creation.extra : str9;
        String str19 = str17;
        long j16 = (i & 65536) != 0 ? creation.createdAt : j10;
        long j17 = (i & 131072) != 0 ? creation.publishedAt : j11;
        long j18 = (i & 262144) != 0 ? creation.lastEditedAt : j12;
        Visibility visibility2 = (i & 524288) != 0 ? creation.visibility : visibility;
        InteractionStats interactionStats2 = (i & 1048576) != 0 ? creation.interactionStats : interactionStats;
        Visibility visibility3 = visibility2;
        CommentIndex commentIndex3 = (i & 2097152) != 0 ? creation.commentIndex : commentIndex;
        if ((i & 4194304) != 0) {
            commentIndex2 = commentIndex3;
            list6 = creation.screenshots;
        } else {
            list6 = list5;
            commentIndex2 = commentIndex3;
        }
        return creation.copy(j15, str10, j14, str11, str12, str13, list7, list8, creationType2, str14, str15, str16, list11, list10, str19, str18, j16, j17, j18, visibility3, interactionStats2, commentIndex2, list6);
    }

    public static final void write$Self$uxsense_release(Creation self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.creationId);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !k.b(self.postId, "")) {
            output.encodeStringElement(serialDesc, 1, self.postId);
        }
        output.encodeLongElement(serialDesc, 2, self.userId);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !k.b(self.uuid, "")) {
            output.encodeStringElement(serialDesc, 3, self.uuid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !k.b(self.authorNickname, "")) {
            output.encodeStringElement(serialDesc, 4, self.authorNickname);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !k.b(self.cover, "")) {
            output.encodeStringElement(serialDesc, 5, self.cover);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !k.b(self.images, EmptyList.f4893a)) {
            output.encodeSerializableElement(serialDesc, 6, (x9.f) fVarArr[6].getF4884a(), self.images);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !k.b(self.videos, EmptyList.f4893a)) {
            output.encodeSerializableElement(serialDesc, 7, (x9.f) fVarArr[7].getF4884a(), self.videos);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.type != CreationType.TEXT) {
            output.encodeSerializableElement(serialDesc, 8, (x9.f) fVarArr[8].getF4884a(), self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !k.b(self.title, "")) {
            output.encodeStringElement(serialDesc, 9, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !k.b(self.content, "")) {
            output.encodeStringElement(serialDesc, 10, self.content);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || !k.b(self.group, "")) {
            output.encodeStringElement(serialDesc, 11, self.group);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || !k.b(self.tags, EmptyList.f4893a)) {
            output.encodeSerializableElement(serialDesc, 12, (x9.f) fVarArr[12].getF4884a(), self.tags);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || !k.b(self.mentionedUsers, EmptyList.f4893a)) {
            output.encodeSerializableElement(serialDesc, 13, (x9.f) fVarArr[13].getF4884a(), self.mentionedUsers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || !k.b(self.location, "")) {
            output.encodeStringElement(serialDesc, 14, self.location);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || !k.b(self.extra, "")) {
            output.encodeStringElement(serialDesc, 15, self.extra);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.createdAt != 0) {
            output.encodeLongElement(serialDesc, 16, self.createdAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.publishedAt != 0) {
            output.encodeLongElement(serialDesc, 17, self.publishedAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.lastEditedAt != 0) {
            output.encodeLongElement(serialDesc, 18, self.lastEditedAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.visibility != Visibility.PUBLIC) {
            output.encodeSerializableElement(serialDesc, 19, (x9.f) fVarArr[19].getF4884a(), self.visibility);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || !k.b(self.interactionStats, new InteractionStats(0L, 0L, 0L, 0L, 0L, 0L, (List) null, 127, (e) null))) {
            output.encodeSerializableElement(serialDesc, 20, InteractionStats$$serializer.INSTANCE, self.interactionStats);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || !k.b(self.commentIndex, new CommentIndex((List) null, (Map) null, 3, (e) null))) {
            output.encodeSerializableElement(serialDesc, 21, CommentIndex$$serializer.INSTANCE, self.commentIndex);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 22) && k.b(self.screenshots, EmptyList.f4893a)) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 22, (x9.f) fVarArr[22].getF4884a(), self.screenshots);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCreationId() {
        return this.creationId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component11, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component12, reason: from getter */
    public final String getGroup() {
        return this.group;
    }

    public final List<String> component13() {
        return this.tags;
    }

    public final List<String> component14() {
        return this.mentionedUsers;
    }

    /* renamed from: component15, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component16, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    /* renamed from: component17, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component18, reason: from getter */
    public final long getPublishedAt() {
        return this.publishedAt;
    }

    /* renamed from: component19, reason: from getter */
    public final long getLastEditedAt() {
        return this.lastEditedAt;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPostId() {
        return this.postId;
    }

    /* renamed from: component20, reason: from getter */
    public final Visibility getVisibility() {
        return this.visibility;
    }

    /* renamed from: component21, reason: from getter */
    public final InteractionStats getInteractionStats() {
        return this.interactionStats;
    }

    /* renamed from: component22, reason: from getter */
    public final CommentIndex getCommentIndex() {
        return this.commentIndex;
    }

    public final List<String> component23() {
        return this.screenshots;
    }

    /* renamed from: component3, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAuthorNickname() {
        return this.authorNickname;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCover() {
        return this.cover;
    }

    public final List<String> component7() {
        return this.images;
    }

    public final List<String> component8() {
        return this.videos;
    }

    /* renamed from: component9, reason: from getter */
    public final CreationType getType() {
        return this.type;
    }

    public final Creation copy(long creationId, String postId, long userId, String uuid, String authorNickname, String cover, List<String> images, List<String> videos, CreationType type, String title, String content, String group, List<String> tags, List<String> mentionedUsers, String location, String extra, long createdAt, long publishedAt, long lastEditedAt, Visibility visibility, InteractionStats interactionStats, CommentIndex commentIndex, List<String> screenshots) {
        k.f(postId, "postId");
        k.f(uuid, "uuid");
        k.f(authorNickname, "authorNickname");
        k.f(cover, "cover");
        k.f(images, "images");
        k.f(videos, "videos");
        k.f(type, "type");
        k.f(title, "title");
        k.f(content, "content");
        k.f(group, "group");
        k.f(tags, "tags");
        k.f(mentionedUsers, "mentionedUsers");
        k.f(location, "location");
        k.f(extra, "extra");
        k.f(visibility, "visibility");
        k.f(interactionStats, "interactionStats");
        k.f(commentIndex, "commentIndex");
        k.f(screenshots, "screenshots");
        return new Creation(creationId, postId, userId, uuid, authorNickname, cover, images, videos, type, title, content, group, tags, mentionedUsers, location, extra, createdAt, publishedAt, lastEditedAt, visibility, interactionStats, commentIndex, screenshots);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Creation)) {
            return false;
        }
        Creation creation = (Creation) other;
        return this.creationId == creation.creationId && k.b(this.postId, creation.postId) && this.userId == creation.userId && k.b(this.uuid, creation.uuid) && k.b(this.authorNickname, creation.authorNickname) && k.b(this.cover, creation.cover) && k.b(this.images, creation.images) && k.b(this.videos, creation.videos) && this.type == creation.type && k.b(this.title, creation.title) && k.b(this.content, creation.content) && k.b(this.group, creation.group) && k.b(this.tags, creation.tags) && k.b(this.mentionedUsers, creation.mentionedUsers) && k.b(this.location, creation.location) && k.b(this.extra, creation.extra) && this.createdAt == creation.createdAt && this.publishedAt == creation.publishedAt && this.lastEditedAt == creation.lastEditedAt && this.visibility == creation.visibility && k.b(this.interactionStats, creation.interactionStats) && k.b(this.commentIndex, creation.commentIndex) && k.b(this.screenshots, creation.screenshots);
    }

    public final String getAuthorNickname() {
        return this.authorNickname;
    }

    public final CommentIndex getCommentIndex() {
        return this.commentIndex;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getCover() {
        return this.cover;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final long getCreationId() {
        return this.creationId;
    }

    public final String getDayFileName() {
        long j5 = this.publishedAt;
        if (j5 <= 0) {
            j5 = this.createdAt;
        }
        LocalDate localDate = Instant.ofEpochMilli(j5).atZone(ZoneId.systemDefault()).toLocalDate();
        k.e(localDate, "toLocalDate(...)");
        return dateFormatter.format(localDate) + ".json";
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getGroup() {
        return this.group;
    }

    public final List<String> getImages() {
        return this.images;
    }

    public final InteractionStats getInteractionStats() {
        return this.interactionStats;
    }

    public final long getLastEditedAt() {
        return this.lastEditedAt;
    }

    public final String getLocation() {
        return this.location;
    }

    public final List<String> getMentionedUsers() {
        return this.mentionedUsers;
    }

    public final String getMonthFileName() {
        long j5 = this.publishedAt;
        if (j5 <= 0) {
            j5 = this.createdAt;
        }
        LocalDate localDate = Instant.ofEpochMilli(j5).atZone(ZoneId.systemDefault()).toLocalDate();
        k.e(localDate, "toLocalDate(...)");
        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM")) + ".json";
    }

    public final String getPostId() {
        return this.postId;
    }

    public final long getPublishedAt() {
        return this.publishedAt;
    }

    public final List<String> getScreenshots() {
        return this.screenshots;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    public final CreationType getType() {
        return this.type;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final List<String> getVideos() {
        return this.videos;
    }

    public final Visibility getVisibility() {
        return this.visibility;
    }

    public int hashCode() {
        return this.screenshots.hashCode() + ((this.commentIndex.hashCode() + ((this.interactionStats.hashCode() + ((this.visibility.hashCode() + androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(B7.a.c(B7.a.c(androidx.appfunctions.metadata.a.e(this.mentionedUsers, androidx.appfunctions.metadata.a.e(this.tags, B7.a.c(B7.a.c(B7.a.c((this.type.hashCode() + androidx.appfunctions.metadata.a.e(this.videos, androidx.appfunctions.metadata.a.e(this.images, B7.a.c(B7.a.c(B7.a.c(androidx.appfunctions.metadata.a.c(B7.a.c(Long.hashCode(this.creationId) * 31, 31, this.postId), 31, this.userId), 31, this.uuid), 31, this.authorNickname), 31, this.cover), 31), 31)) * 31, 31, this.title), 31, this.content), 31, this.group), 31), 31), 31, this.location), 31, this.extra), 31, this.createdAt), 31, this.publishedAt), 31, this.lastEditedAt)) * 31)) * 31)) * 31);
    }

    public final Creation mergeWith(Creation other) {
        k.f(other, "other");
        long j5 = this.creationId;
        long j6 = this.userId;
        String str = other.postId;
        if (str.length() == 0) {
            str = this.postId;
        }
        String str2 = other.uuid;
        if (str2.length() == 0) {
            str2 = this.uuid;
        }
        String str3 = other.authorNickname;
        if (str3.length() == 0) {
            str3 = this.authorNickname;
        }
        String str4 = other.cover;
        if (str4.length() == 0) {
            str4 = this.cover;
        }
        List<String> listV0 = v.v0(v.Q0(other.images, this.images));
        List<String> listV02 = v.v0(v.Q0(other.videos, this.videos));
        CreationType creationType = other.type;
        if (creationType == CreationType.TEXT) {
            creationType = this.type;
        }
        String str5 = other.title;
        if (str5.length() == 0) {
            str5 = this.title;
        }
        String str6 = other.content;
        if (str6.length() == 0) {
            str6 = this.content;
        }
        String str7 = other.group;
        if (str7.length() == 0) {
            str7 = this.group;
        }
        List<String> listV03 = v.v0(v.Q0(other.tags, this.tags));
        List<String> listV04 = v.v0(v.Q0(other.mentionedUsers, this.mentionedUsers));
        String str8 = other.location;
        if (str8.length() == 0) {
            str8 = this.location;
        }
        String str9 = other.extra;
        if (str9.length() == 0) {
            str9 = this.extra;
        }
        String str10 = str9;
        String str11 = str8;
        long j10 = this.createdAt;
        if (j10 <= 0) {
            j10 = other.createdAt;
        }
        long j11 = j10;
        long j12 = this.publishedAt;
        if (j12 <= 0) {
            j12 = other.publishedAt;
        }
        long j13 = j12;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Visibility visibility = other.visibility;
        InteractionStats interactionStatsMergeWith = this.interactionStats.mergeWith(other.interactionStats);
        List listV05 = v.v0(v.Q0(other.commentIndex.getRootComments(), this.commentIndex.getRootComments()));
        String str12 = str;
        LinkedHashSet linkedHashSetL = N.L(this.commentIndex.getReplies().keySet(), other.commentIndex.getReplies().keySet());
        int iP = kotlin.collections.a.P(w.c0(linkedHashSetL, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
        Iterator it = linkedHashSetL.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            long jLongValue = ((Number) next).longValue();
            Iterator it2 = it;
            List<Long> list = this.commentIndex.getReplies().get(Long.valueOf(jLongValue));
            if (list == null) {
                list = EmptyList.f4893a;
            }
            List<Long> list2 = list;
            String str13 = str2;
            List<Long> list3 = other.commentIndex.getReplies().get(Long.valueOf(jLongValue));
            linkedHashMap.put(next, v.v0(v.Q0(list3 != null ? list3 : EmptyList.f4893a, list2)));
            it = it2;
            str2 = str13;
        }
        return copy(j5, str12, j6, str2, str3, str4, listV0, listV02, creationType, str5, str6, str7, listV03, listV04, str11, str10, j11, j13, jCurrentTimeMillis, visibility, interactionStatsMergeWith, new CommentIndex(listV05, linkedHashMap), v.v0(v.Q0(other.screenshots, this.screenshots)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Creation(creationId=");
        sb.append(this.creationId);
        sb.append(", postId=");
        sb.append(this.postId);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", uuid=");
        sb.append(this.uuid);
        sb.append(", authorNickname=");
        sb.append(this.authorNickname);
        sb.append(", cover=");
        sb.append(this.cover);
        sb.append(", images=");
        sb.append(this.images);
        sb.append(", videos=");
        sb.append(this.videos);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", group=");
        sb.append(this.group);
        sb.append(", tags=");
        sb.append(this.tags);
        sb.append(", mentionedUsers=");
        sb.append(this.mentionedUsers);
        sb.append(", location=");
        sb.append(this.location);
        sb.append(", extra=");
        sb.append(this.extra);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", publishedAt=");
        sb.append(this.publishedAt);
        sb.append(", lastEditedAt=");
        sb.append(this.lastEditedAt);
        sb.append(", visibility=");
        sb.append(this.visibility);
        sb.append(", interactionStats=");
        sb.append(this.interactionStats);
        sb.append(", commentIndex=");
        sb.append(this.commentIndex);
        sb.append(", screenshots=");
        return B7.a.r(sb, this.screenshots, ')');
    }

    public Creation(long j5, String postId, long j6, String uuid, String authorNickname, String cover, List<String> images, List<String> videos, CreationType type, String title, String content, String group, List<String> tags, List<String> mentionedUsers, String location, String extra, long j10, long j11, long j12, Visibility visibility, InteractionStats interactionStats, CommentIndex commentIndex, List<String> screenshots) {
        k.f(postId, "postId");
        k.f(uuid, "uuid");
        k.f(authorNickname, "authorNickname");
        k.f(cover, "cover");
        k.f(images, "images");
        k.f(videos, "videos");
        k.f(type, "type");
        k.f(title, "title");
        k.f(content, "content");
        k.f(group, "group");
        k.f(tags, "tags");
        k.f(mentionedUsers, "mentionedUsers");
        k.f(location, "location");
        k.f(extra, "extra");
        k.f(visibility, "visibility");
        k.f(interactionStats, "interactionStats");
        k.f(commentIndex, "commentIndex");
        k.f(screenshots, "screenshots");
        this.creationId = j5;
        this.postId = postId;
        this.userId = j6;
        this.uuid = uuid;
        this.authorNickname = authorNickname;
        this.cover = cover;
        this.images = images;
        this.videos = videos;
        this.type = type;
        this.title = title;
        this.content = content;
        this.group = group;
        this.tags = tags;
        this.mentionedUsers = mentionedUsers;
        this.location = location;
        this.extra = extra;
        this.createdAt = j10;
        this.publishedAt = j11;
        this.lastEditedAt = j12;
        this.visibility = visibility;
        this.interactionStats = interactionStats;
        this.commentIndex = commentIndex;
        this.screenshots = screenshots;
    }

    public Creation(long j5, String str, long j6, String str2, String str3, String str4, List list, List list2, CreationType creationType, String str5, String str6, String str7, List list3, List list4, String str8, String str9, long j10, long j11, long j12, Visibility visibility, InteractionStats interactionStats, CommentIndex commentIndex, List list5, int i, e eVar) {
        this(j5, (i & 2) != 0 ? "" : str, j6, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? EmptyList.f4893a : list, (i & 128) != 0 ? EmptyList.f4893a : list2, (i & 256) != 0 ? CreationType.TEXT : creationType, (i & 512) != 0 ? "" : str5, (i & 1024) != 0 ? "" : str6, (i & 2048) != 0 ? "" : str7, (i & 4096) != 0 ? EmptyList.f4893a : list3, (i & 8192) != 0 ? EmptyList.f4893a : list4, (i & 16384) != 0 ? "" : str8, (32768 & i) != 0 ? "" : str9, (65536 & i) != 0 ? 0L : j10, (131072 & i) != 0 ? 0L : j11, (262144 & i) != 0 ? 0L : j12, (524288 & i) != 0 ? Visibility.PUBLIC : visibility, (1048576 & i) != 0 ? new InteractionStats(0L, 0L, 0L, 0L, 0L, 0L, (List) null, 127, (e) null) : interactionStats, (2097152 & i) != 0 ? new CommentIndex((List) null, (Map) null, 3, (e) null) : commentIndex, (i & 4194304) != 0 ? EmptyList.f4893a : list5);
    }
}
