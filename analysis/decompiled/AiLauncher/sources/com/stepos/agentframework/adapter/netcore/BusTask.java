package com.stepos.agentframework.adapter.netcore;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.taskstore.provider.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b7\b\u0086\b\u0018\u00002\u00020\u0001BÁ\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010!\u001a\u00020\u001d\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010$¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010-\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b-\u0010.R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u0010)R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010/\u001a\u0004\b1\u0010)R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u00102\u001a\u0004\b3\u00104R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010/\u001a\u0004\b5\u0010)R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u00106\u001a\u0004\b7\u00108R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010/\u001a\u0004\b9\u0010)R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010:\u001a\u0004\b;\u0010+R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\f\u0010:\u001a\u0004\b<\u0010+R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b=\u0010)R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010A\u001a\u0004\bB\u0010CR\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010/\u001a\u0004\bD\u0010)R\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010/\u001a\u0004\bE\u0010)R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010F\u001a\u0004\bG\u0010HR\u001f\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u00102\u001a\u0004\bI\u00104R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010/\u001a\u0004\bJ\u0010)R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\bK\u0010)R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\bL\u0010)R\u001f\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\bM\u00104R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\bN\u0010)R\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010O\u001a\u0004\bP\u0010QR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001f\u0010R\u001a\u0004\bS\u0010TR\u0019\u0010 \u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b \u0010R\u001a\u0004\bU\u0010TR\u0017\u0010!\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b!\u0010O\u001a\u0004\bV\u0010QR\u001f\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b#\u00102\u001a\u0004\bW\u00104R'\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010$8\u0006¢\u0006\f\n\u0004\b%\u0010X\u001a\u0004\bY\u0010Z¨\u0006["}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/e;", "", "", "taskId", "parentTaskId", "", "subTaskIds", "type", "", "version", "versionId", "taskVersion", "activeTaskVersion", "iconUrl", "", "noTaskDetail", "Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "status", "title", "subTitle", "Lcom/stepos/agentframework/adapter/netcore/g;", "progress", "subTasks", c.a.COL_SUMMARY, SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "requestSessionKey", "Lcom/stepos/agentframework/adapter/netcore/d;", "pendingQuestions", "intention", "", "createdAt", "startedAt", "endedAt", "updatedAt", "Lcom/stepos/agentframework/adapter/netcore/c;", "result", "", "extensions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;IILjava/lang/String;ZLcom/stepos/agentframework/adapter/netcore/BusTaskStatus;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/netcore/g;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;JLjava/util/List;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "t", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/List;", "p", "()Ljava/util/List;", "w", "Ljava/lang/Integer;", "y", "()Ljava/lang/Integer;", "z", "I", "u", Const.INTENT_KEY_APIKEY, "e", "Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "o", "()Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "v", "r", "Lcom/stepos/agentframework/adapter/netcore/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lcom/stepos/agentframework/adapter/netcore/g;", "q", "s", "m", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "f", "J", Const.INTENT_KEY_PKGNAME, "()J", "Ljava/lang/Long;", "n", "()Ljava/lang/Long;", "c", "x", "l", "Ljava/util/Map;", Const.INTENT_KEY_UMID, "()Ljava/util/Map;", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.netcore.e, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class BusTask {
    private final int activeTaskVersion;
    private final long createdAt;
    private final Long endedAt;
    private final Map<String, Object> extensions;
    private final String iconUrl;
    private final String intention;
    private final boolean noTaskDetail;
    private final String parentTaskId;
    private final List<BusQuestion> pendingQuestions;
    private final BusTaskProgress progress;
    private final String requestSessionKey;
    private final List<BusPart> result;
    private final String sessionKey;
    private final Long startedAt;
    private final BusTaskStatus status;
    private final List<String> subTaskIds;
    private final List<BusTask> subTasks;
    private final String subTitle;
    private final String summary;
    private final String taskId;
    private final int taskVersion;
    private final String title;
    private final String type;
    private final long updatedAt;
    private final Integer version;
    private final String versionId;

    public BusTask(String taskId, String str, List<String> subTaskIds, String type, Integer num, String str2, int i10, int i11, String str3, boolean z10, BusTaskStatus status, String title, String subTitle, BusTaskProgress busTaskProgress, List<BusTask> list, String str4, String str5, String str6, List<BusQuestion> list2, String str7, long j10, Long l10, Long l11, long j11, List<BusPart> list3, Map<String, ? extends Object> map) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(subTaskIds, "subTaskIds");
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(status, "status");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(subTitle, "subTitle");
        this.taskId = taskId;
        this.parentTaskId = str;
        this.subTaskIds = subTaskIds;
        this.type = type;
        this.version = num;
        this.versionId = str2;
        this.taskVersion = i10;
        this.activeTaskVersion = i11;
        this.iconUrl = str3;
        this.noTaskDetail = z10;
        this.status = status;
        this.title = title;
        this.subTitle = subTitle;
        this.progress = busTaskProgress;
        this.subTasks = list;
        this.summary = str4;
        this.sessionKey = str5;
        this.requestSessionKey = str6;
        this.pendingQuestions = list2;
        this.intention = str7;
        this.createdAt = j10;
        this.startedAt = l10;
        this.endedAt = l11;
        this.updatedAt = j11;
        this.result = list3;
        this.extensions = map;
    }

    /* renamed from: a, reason: from getter */
    public final int getActiveTaskVersion() {
        return this.activeTaskVersion;
    }

    /* renamed from: b, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: c, reason: from getter */
    public final Long getEndedAt() {
        return this.endedAt;
    }

    public final Map<String, Object> d() {
        return this.extensions;
    }

    /* renamed from: e, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BusTask)) {
            return false;
        }
        BusTask busTask = (BusTask) other;
        return kotlin.jvm.internal.p.d(this.taskId, busTask.taskId) && kotlin.jvm.internal.p.d(this.parentTaskId, busTask.parentTaskId) && kotlin.jvm.internal.p.d(this.subTaskIds, busTask.subTaskIds) && kotlin.jvm.internal.p.d(this.type, busTask.type) && kotlin.jvm.internal.p.d(this.version, busTask.version) && kotlin.jvm.internal.p.d(this.versionId, busTask.versionId) && this.taskVersion == busTask.taskVersion && this.activeTaskVersion == busTask.activeTaskVersion && kotlin.jvm.internal.p.d(this.iconUrl, busTask.iconUrl) && this.noTaskDetail == busTask.noTaskDetail && this.status == busTask.status && kotlin.jvm.internal.p.d(this.title, busTask.title) && kotlin.jvm.internal.p.d(this.subTitle, busTask.subTitle) && kotlin.jvm.internal.p.d(this.progress, busTask.progress) && kotlin.jvm.internal.p.d(this.subTasks, busTask.subTasks) && kotlin.jvm.internal.p.d(this.summary, busTask.summary) && kotlin.jvm.internal.p.d(this.sessionKey, busTask.sessionKey) && kotlin.jvm.internal.p.d(this.requestSessionKey, busTask.requestSessionKey) && kotlin.jvm.internal.p.d(this.pendingQuestions, busTask.pendingQuestions) && kotlin.jvm.internal.p.d(this.intention, busTask.intention) && this.createdAt == busTask.createdAt && kotlin.jvm.internal.p.d(this.startedAt, busTask.startedAt) && kotlin.jvm.internal.p.d(this.endedAt, busTask.endedAt) && this.updatedAt == busTask.updatedAt && kotlin.jvm.internal.p.d(this.result, busTask.result) && kotlin.jvm.internal.p.d(this.extensions, busTask.extensions);
    }

    /* renamed from: f, reason: from getter */
    public final String getIntention() {
        return this.intention;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getNoTaskDetail() {
        return this.noTaskDetail;
    }

    /* renamed from: h, reason: from getter */
    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    public int hashCode() {
        int iHashCode = this.taskId.hashCode() * 31;
        String str = this.parentTaskId;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.subTaskIds.hashCode()) * 31) + this.type.hashCode()) * 31;
        Integer num = this.version;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.versionId;
        int iHashCode4 = (((((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.taskVersion)) * 31) + Integer.hashCode(this.activeTaskVersion)) * 31;
        String str3 = this.iconUrl;
        int iHashCode5 = (((((((((iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.noTaskDetail)) * 31) + this.status.hashCode()) * 31) + this.title.hashCode()) * 31) + this.subTitle.hashCode()) * 31;
        BusTaskProgress busTaskProgress = this.progress;
        int iHashCode6 = (iHashCode5 + (busTaskProgress == null ? 0 : busTaskProgress.hashCode())) * 31;
        List<BusTask> list = this.subTasks;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.summary;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.sessionKey;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.requestSessionKey;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<BusQuestion> list2 = this.pendingQuestions;
        int iHashCode11 = (iHashCode10 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str7 = this.intention;
        int iHashCode12 = (((iHashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31) + Long.hashCode(this.createdAt)) * 31;
        Long l10 = this.startedAt;
        int iHashCode13 = (iHashCode12 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.endedAt;
        int iHashCode14 = (((iHashCode13 + (l11 == null ? 0 : l11.hashCode())) * 31) + Long.hashCode(this.updatedAt)) * 31;
        List<BusPart> list3 = this.result;
        int iHashCode15 = (iHashCode14 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Map<String, Object> map = this.extensions;
        return iHashCode15 + (map != null ? map.hashCode() : 0);
    }

    public final List<BusQuestion> i() {
        return this.pendingQuestions;
    }

    /* renamed from: j, reason: from getter */
    public final BusTaskProgress getProgress() {
        return this.progress;
    }

    /* renamed from: k, reason: from getter */
    public final String getRequestSessionKey() {
        return this.requestSessionKey;
    }

    public final List<BusPart> l() {
        return this.result;
    }

    /* renamed from: m, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: n, reason: from getter */
    public final Long getStartedAt() {
        return this.startedAt;
    }

    /* renamed from: o, reason: from getter */
    public final BusTaskStatus getStatus() {
        return this.status;
    }

    public final List<String> p() {
        return this.subTaskIds;
    }

    public final List<BusTask> q() {
        return this.subTasks;
    }

    /* renamed from: r, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    /* renamed from: s, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* renamed from: t, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public String toString() {
        return "BusTask(taskId=" + this.taskId + ", parentTaskId=" + this.parentTaskId + ", subTaskIds=" + this.subTaskIds + ", type=" + this.type + ", version=" + this.version + ", versionId=" + this.versionId + ", taskVersion=" + this.taskVersion + ", activeTaskVersion=" + this.activeTaskVersion + ", iconUrl=" + this.iconUrl + ", noTaskDetail=" + this.noTaskDetail + ", status=" + this.status + ", title=" + this.title + ", subTitle=" + this.subTitle + ", progress=" + this.progress + ", subTasks=" + this.subTasks + ", summary=" + this.summary + ", sessionKey=" + this.sessionKey + ", requestSessionKey=" + this.requestSessionKey + ", pendingQuestions=" + this.pendingQuestions + ", intention=" + this.intention + ", createdAt=" + this.createdAt + ", startedAt=" + this.startedAt + ", endedAt=" + this.endedAt + ", updatedAt=" + this.updatedAt + ", result=" + this.result + ", extensions=" + this.extensions + ")";
    }

    /* renamed from: u, reason: from getter */
    public final int getTaskVersion() {
        return this.taskVersion;
    }

    /* renamed from: v, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: w, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: x, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: y, reason: from getter */
    public final Integer getVersion() {
        return this.version;
    }

    /* renamed from: z, reason: from getter */
    public final String getVersionId() {
        return this.versionId;
    }

    public /* synthetic */ BusTask(String str, String str2, List list, String str3, Integer num, String str4, int i10, int i11, String str5, boolean z10, BusTaskStatus busTaskStatus, String str6, String str7, BusTaskProgress busTaskProgress, List list2, String str8, String str9, String str10, List list3, String str11, long j10, Long l10, Long l11, long j11, List list4, Map map, int i12, kotlin.jvm.internal.i iVar) {
        this(str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? C1173v.m() : list, str3, (i12 & 16) != 0 ? null : num, (i12 & 32) != 0 ? null : str4, (i12 & 64) != 0 ? 0 : i10, (i12 & 128) != 0 ? 0 : i11, (i12 & 256) != 0 ? null : str5, (i12 & 512) != 0 ? false : z10, busTaskStatus, str6, str7, (i12 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : busTaskProgress, (i12 & 16384) != 0 ? null : list2, (32768 & i12) != 0 ? null : str8, (65536 & i12) != 0 ? null : str9, (131072 & i12) != 0 ? null : str10, (262144 & i12) != 0 ? null : list3, (524288 & i12) != 0 ? null : str11, j10, (2097152 & i12) != 0 ? null : l10, (4194304 & i12) != 0 ? null : l11, j11, (16777216 & i12) != 0 ? null : list4, (i12 & Const.FLAG_MUTABLE) != 0 ? null : map);
    }
}
