package com.uxsense.parse;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.base.metadata.CreationType;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B±\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0015HÆ\u0003J³\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006F"}, d2 = {"Lcom/uxsense/parse/CreationKeyMapping;", "", "postId", "", "uuid", "authorNickname", "type", "Lcom/uxsense/base/metadata/CreationType;", "cover", "title", "content", "group", "tags", "mentionedUsers", "extra", "location", "createdAt", "publishAt", "lastEditedAt", "visibility", "statsMapping", "Lcom/uxsense/parse/InteractionStatsKeyMapping;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/base/metadata/CreationType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/parse/InteractionStatsKeyMapping;)V", "getPostId", "()Ljava/lang/String;", "getUuid", "getAuthorNickname", "getType", "()Lcom/uxsense/base/metadata/CreationType;", "setType", "(Lcom/uxsense/base/metadata/CreationType;)V", "getCover", "getTitle", "getContent", "getGroup", "getTags", "getMentionedUsers", "getExtra", "getLocation", "getCreatedAt", "getPublishAt", "getLastEditedAt", "getVisibility", "getStatsMapping", "()Lcom/uxsense/parse/InteractionStatsKeyMapping;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "", "other", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CreationKeyMapping {
    private final String authorNickname;
    private final String content;
    private final String cover;
    private final String createdAt;
    private final String extra;
    private final String group;
    private final String lastEditedAt;
    private final String location;
    private final String mentionedUsers;
    private final String postId;
    private final String publishAt;
    private final InteractionStatsKeyMapping statsMapping;
    private final String tags;
    private final String title;
    private CreationType type;
    private final String uuid;
    private final String visibility;

    public CreationKeyMapping() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ CreationKeyMapping copy$default(CreationKeyMapping creationKeyMapping, String str, String str2, String str3, CreationType creationType, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, InteractionStatsKeyMapping interactionStatsKeyMapping, int i, Object obj) {
        InteractionStatsKeyMapping interactionStatsKeyMapping2;
        String str16;
        String str17;
        CreationKeyMapping creationKeyMapping2;
        String str18;
        String str19;
        String str20;
        CreationType creationType2;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31 = (i & 1) != 0 ? creationKeyMapping.postId : str;
        String str32 = (i & 2) != 0 ? creationKeyMapping.uuid : str2;
        String str33 = (i & 4) != 0 ? creationKeyMapping.authorNickname : str3;
        CreationType creationType3 = (i & 8) != 0 ? creationKeyMapping.type : creationType;
        String str34 = (i & 16) != 0 ? creationKeyMapping.cover : str4;
        String str35 = (i & 32) != 0 ? creationKeyMapping.title : str5;
        String str36 = (i & 64) != 0 ? creationKeyMapping.content : str6;
        String str37 = (i & 128) != 0 ? creationKeyMapping.group : str7;
        String str38 = (i & 256) != 0 ? creationKeyMapping.tags : str8;
        String str39 = (i & 512) != 0 ? creationKeyMapping.mentionedUsers : str9;
        String str40 = (i & 1024) != 0 ? creationKeyMapping.extra : str10;
        String str41 = (i & 2048) != 0 ? creationKeyMapping.location : str11;
        String str42 = (i & 4096) != 0 ? creationKeyMapping.createdAt : str12;
        String str43 = (i & 8192) != 0 ? creationKeyMapping.publishAt : str13;
        String str44 = str31;
        String str45 = (i & 16384) != 0 ? creationKeyMapping.lastEditedAt : str14;
        String str46 = (i & 32768) != 0 ? creationKeyMapping.visibility : str15;
        if ((i & 65536) != 0) {
            str16 = str46;
            interactionStatsKeyMapping2 = creationKeyMapping.statsMapping;
            str18 = str45;
            str19 = str32;
            str20 = str33;
            creationType2 = creationType3;
            str21 = str34;
            str22 = str35;
            str23 = str36;
            str24 = str37;
            str25 = str38;
            str26 = str39;
            str27 = str40;
            str28 = str41;
            str29 = str42;
            str30 = str43;
            str17 = str44;
            creationKeyMapping2 = creationKeyMapping;
        } else {
            interactionStatsKeyMapping2 = interactionStatsKeyMapping;
            str16 = str46;
            str17 = str44;
            creationKeyMapping2 = creationKeyMapping;
            str18 = str45;
            str19 = str32;
            str20 = str33;
            creationType2 = creationType3;
            str21 = str34;
            str22 = str35;
            str23 = str36;
            str24 = str37;
            str25 = str38;
            str26 = str39;
            str27 = str40;
            str28 = str41;
            str29 = str42;
            str30 = str43;
        }
        return creationKeyMapping2.copy(str17, str19, str20, creationType2, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str18, str16, interactionStatsKeyMapping2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPostId() {
        return this.postId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getMentionedUsers() {
        return this.mentionedUsers;
    }

    /* renamed from: component11, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    /* renamed from: component12, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component13, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component14, reason: from getter */
    public final String getPublishAt() {
        return this.publishAt;
    }

    /* renamed from: component15, reason: from getter */
    public final String getLastEditedAt() {
        return this.lastEditedAt;
    }

    /* renamed from: component16, reason: from getter */
    public final String getVisibility() {
        return this.visibility;
    }

    /* renamed from: component17, reason: from getter */
    public final InteractionStatsKeyMapping getStatsMapping() {
        return this.statsMapping;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAuthorNickname() {
        return this.authorNickname;
    }

    /* renamed from: component4, reason: from getter */
    public final CreationType getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCover() {
        return this.cover;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component7, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component8, reason: from getter */
    public final String getGroup() {
        return this.group;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTags() {
        return this.tags;
    }

    public final CreationKeyMapping copy(String postId, String uuid, String authorNickname, CreationType type, String cover, String title, String content, String group, String tags, String mentionedUsers, String extra, String location, String createdAt, String publishAt, String lastEditedAt, String visibility, InteractionStatsKeyMapping statsMapping) {
        k.f(postId, "postId");
        k.f(uuid, "uuid");
        k.f(authorNickname, "authorNickname");
        k.f(type, "type");
        k.f(cover, "cover");
        k.f(title, "title");
        k.f(content, "content");
        k.f(group, "group");
        k.f(tags, "tags");
        k.f(mentionedUsers, "mentionedUsers");
        k.f(extra, "extra");
        k.f(location, "location");
        k.f(createdAt, "createdAt");
        k.f(publishAt, "publishAt");
        k.f(lastEditedAt, "lastEditedAt");
        k.f(visibility, "visibility");
        k.f(statsMapping, "statsMapping");
        return new CreationKeyMapping(postId, uuid, authorNickname, type, cover, title, content, group, tags, mentionedUsers, extra, location, createdAt, publishAt, lastEditedAt, visibility, statsMapping);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreationKeyMapping)) {
            return false;
        }
        CreationKeyMapping creationKeyMapping = (CreationKeyMapping) other;
        return k.b(this.postId, creationKeyMapping.postId) && k.b(this.uuid, creationKeyMapping.uuid) && k.b(this.authorNickname, creationKeyMapping.authorNickname) && this.type == creationKeyMapping.type && k.b(this.cover, creationKeyMapping.cover) && k.b(this.title, creationKeyMapping.title) && k.b(this.content, creationKeyMapping.content) && k.b(this.group, creationKeyMapping.group) && k.b(this.tags, creationKeyMapping.tags) && k.b(this.mentionedUsers, creationKeyMapping.mentionedUsers) && k.b(this.extra, creationKeyMapping.extra) && k.b(this.location, creationKeyMapping.location) && k.b(this.createdAt, creationKeyMapping.createdAt) && k.b(this.publishAt, creationKeyMapping.publishAt) && k.b(this.lastEditedAt, creationKeyMapping.lastEditedAt) && k.b(this.visibility, creationKeyMapping.visibility) && k.b(this.statsMapping, creationKeyMapping.statsMapping);
    }

    public final String getAuthorNickname() {
        return this.authorNickname;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getLastEditedAt() {
        return this.lastEditedAt;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getMentionedUsers() {
        return this.mentionedUsers;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final String getPublishAt() {
        return this.publishAt;
    }

    public final InteractionStatsKeyMapping getStatsMapping() {
        return this.statsMapping;
    }

    public final String getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    public final CreationType getType() {
        return this.type;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getVisibility() {
        return this.visibility;
    }

    public int hashCode() {
        return this.statsMapping.hashCode() + B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c((this.type.hashCode() + B7.a.c(B7.a.c(this.postId.hashCode() * 31, 31, this.uuid), 31, this.authorNickname)) * 31, 31, this.cover), 31, this.title), 31, this.content), 31, this.group), 31, this.tags), 31, this.mentionedUsers), 31, this.extra), 31, this.location), 31, this.createdAt), 31, this.publishAt), 31, this.lastEditedAt), 31, this.visibility);
    }

    public final void setType(CreationType creationType) {
        k.f(creationType, "<set-?>");
        this.type = creationType;
    }

    public String toString() {
        return "CreationKeyMapping(postId=" + this.postId + ", uuid=" + this.uuid + ", authorNickname=" + this.authorNickname + ", type=" + this.type + ", cover=" + this.cover + ", title=" + this.title + ", content=" + this.content + ", group=" + this.group + ", tags=" + this.tags + ", mentionedUsers=" + this.mentionedUsers + ", extra=" + this.extra + ", location=" + this.location + ", createdAt=" + this.createdAt + ", publishAt=" + this.publishAt + ", lastEditedAt=" + this.lastEditedAt + ", visibility=" + this.visibility + ", statsMapping=" + this.statsMapping + ')';
    }

    public CreationKeyMapping(String postId, String uuid, String authorNickname, CreationType type, String cover, String title, String content, String group, String tags, String mentionedUsers, String extra, String location, String createdAt, String publishAt, String lastEditedAt, String visibility, InteractionStatsKeyMapping statsMapping) {
        k.f(postId, "postId");
        k.f(uuid, "uuid");
        k.f(authorNickname, "authorNickname");
        k.f(type, "type");
        k.f(cover, "cover");
        k.f(title, "title");
        k.f(content, "content");
        k.f(group, "group");
        k.f(tags, "tags");
        k.f(mentionedUsers, "mentionedUsers");
        k.f(extra, "extra");
        k.f(location, "location");
        k.f(createdAt, "createdAt");
        k.f(publishAt, "publishAt");
        k.f(lastEditedAt, "lastEditedAt");
        k.f(visibility, "visibility");
        k.f(statsMapping, "statsMapping");
        this.postId = postId;
        this.uuid = uuid;
        this.authorNickname = authorNickname;
        this.type = type;
        this.cover = cover;
        this.title = title;
        this.content = content;
        this.group = group;
        this.tags = tags;
        this.mentionedUsers = mentionedUsers;
        this.extra = extra;
        this.location = location;
        this.createdAt = createdAt;
        this.publishAt = publishAt;
        this.lastEditedAt = lastEditedAt;
        this.visibility = visibility;
        this.statsMapping = statsMapping;
    }

    public /* synthetic */ CreationKeyMapping(String str, String str2, String str3, CreationType creationType, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, InteractionStatsKeyMapping interactionStatsKeyMapping, int i, e eVar) {
        this((i & 1) != 0 ? "postId" : str, (i & 2) != 0 ? "uuid" : str2, (i & 4) != 0 ? "authorNickname" : str3, (i & 8) != 0 ? CreationType.TEXT : creationType, (i & 16) != 0 ? "cover" : str4, (i & 32) != 0 ? "title" : str5, (i & 64) != 0 ? "content" : str6, (i & 128) != 0 ? "group" : str7, (i & 256) != 0 ? "tags" : str8, (i & 512) != 0 ? "mentionedUsers" : str9, (i & 1024) != 0 ? "extra" : str10, (i & 2048) != 0 ? "location" : str11, (i & 4096) != 0 ? "createdAt" : str12, (i & 8192) != 0 ? "publishAt" : str13, (i & 16384) != 0 ? "lastEditedAt" : str14, (i & 32768) != 0 ? "visibility" : str15, (i & 65536) != 0 ? new InteractionStatsKeyMapping(null, null, null, null, null, 31, null) : interactionStatsKeyMapping);
    }
}
