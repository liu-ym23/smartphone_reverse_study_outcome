package com.stepos.ailauncher.taskstore.vector;

import a7.InterfaceC1237a;
import a7.InterfaceC1238b;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.datacenter.entity.FieldPriority;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@InterfaceC1238b(collection = "task_store_memory_v2")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJj\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\"R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\"R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\"R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001f\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\"R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001f\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\"R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001f\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\"R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b-\u0010\u0012\"\u0004\b.\u0010\"R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001a\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001e¨\u00061"}, d2 = {"Lcom/stepos/ailauncher/taskstore/vector/a;", "", "", "id", "", "bizKey", "bizType", "entityClassName", "bizId", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "metadata", "updateTime", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", Const.INTENT_KEY_APIKEY, "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lcom/stepos/ailauncher/taskstore/vector/a;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()J", "setId", "(J)V", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "setBizKey", "(Ljava/lang/String;)V", "e", "setBizType", Const.INTENT_KEY_BACKGROUND_COMMAND, "setEntityClassName", "c", "setBizId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "setTitle", "f", "setContent", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "setMetadata", "k", "setUpdateTime", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.vector.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class LauncherVectorEntity {
    private String bizId;

    @InterfaceC1237a(filter = true, fts = false, vector = false)
    private String bizKey;

    @InterfaceC1237a(filter = true, fts = false, vector = false)
    private String bizType;

    @InterfaceC1237a
    private String content;

    @InterfaceC1237a(filter = true, fts = false, vector = false)
    private String entityClassName;
    private long id;
    private String metadata;

    @InterfaceC1237a(priority = FieldPriority.HIGH)
    private String title;
    private long updateTime;

    public LauncherVectorEntity() {
        this(0L, null, null, null, null, null, null, null, 0L, 511, null);
    }

    public static /* synthetic */ LauncherVectorEntity b(LauncherVectorEntity launcherVectorEntity, long j10, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = launcherVectorEntity.id;
        }
        return launcherVectorEntity.a(j10, (i10 & 2) != 0 ? launcherVectorEntity.bizKey : str, (i10 & 4) != 0 ? launcherVectorEntity.bizType : str2, (i10 & 8) != 0 ? launcherVectorEntity.entityClassName : str3, (i10 & 16) != 0 ? launcherVectorEntity.bizId : str4, (i10 & 32) != 0 ? launcherVectorEntity.title : str5, (i10 & 64) != 0 ? launcherVectorEntity.content : str6, (i10 & 128) != 0 ? launcherVectorEntity.metadata : str7, (i10 & 256) != 0 ? launcherVectorEntity.updateTime : j11);
    }

    public final LauncherVectorEntity a(long id, String bizKey, String bizType, String entityClassName, String bizId, String title, String content, String metadata, long updateTime) {
        p.i(bizKey, "bizKey");
        p.i(bizType, "bizType");
        p.i(entityClassName, "entityClassName");
        p.i(bizId, "bizId");
        p.i(title, "title");
        p.i(content, "content");
        p.i(metadata, "metadata");
        return new LauncherVectorEntity(id, bizKey, bizType, entityClassName, bizId, title, content, metadata, updateTime);
    }

    /* renamed from: c, reason: from getter */
    public final String getBizId() {
        return this.bizId;
    }

    /* renamed from: d, reason: from getter */
    public final String getBizKey() {
        return this.bizKey;
    }

    /* renamed from: e, reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LauncherVectorEntity)) {
            return false;
        }
        LauncherVectorEntity launcherVectorEntity = (LauncherVectorEntity) other;
        return this.id == launcherVectorEntity.id && p.d(this.bizKey, launcherVectorEntity.bizKey) && p.d(this.bizType, launcherVectorEntity.bizType) && p.d(this.entityClassName, launcherVectorEntity.entityClassName) && p.d(this.bizId, launcherVectorEntity.bizId) && p.d(this.title, launcherVectorEntity.title) && p.d(this.content, launcherVectorEntity.content) && p.d(this.metadata, launcherVectorEntity.metadata) && this.updateTime == launcherVectorEntity.updateTime;
    }

    /* renamed from: f, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: g, reason: from getter */
    public final String getEntityClassName() {
        return this.entityClassName;
    }

    /* renamed from: h, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        return (((((((((((((((Long.hashCode(this.id) * 31) + this.bizKey.hashCode()) * 31) + this.bizType.hashCode()) * 31) + this.entityClassName.hashCode()) * 31) + this.bizId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + this.metadata.hashCode()) * 31) + Long.hashCode(this.updateTime);
    }

    /* renamed from: i, reason: from getter */
    public final String getMetadata() {
        return this.metadata;
    }

    /* renamed from: j, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: k, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
    }

    public String toString() {
        return "LauncherVectorEntity(id=" + this.id + ", bizKey=" + this.bizKey + ", bizType=" + this.bizType + ", entityClassName=" + this.entityClassName + ", bizId=" + this.bizId + ", title=" + this.title + ", content=" + this.content + ", metadata=" + this.metadata + ", updateTime=" + this.updateTime + ")";
    }

    public LauncherVectorEntity(long j10, String bizKey, String bizType, String entityClassName, String bizId, String title, String content, String metadata, long j11) {
        p.i(bizKey, "bizKey");
        p.i(bizType, "bizType");
        p.i(entityClassName, "entityClassName");
        p.i(bizId, "bizId");
        p.i(title, "title");
        p.i(content, "content");
        p.i(metadata, "metadata");
        this.id = j10;
        this.bizKey = bizKey;
        this.bizType = bizType;
        this.entityClassName = entityClassName;
        this.bizId = bizId;
        this.title = title;
        this.content = content;
        this.metadata = metadata;
        this.updateTime = j11;
    }

    public /* synthetic */ LauncherVectorEntity(long j10, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j11, int i10, i iVar) {
        this((i10 & 1) != 0 ? 0L : j10, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? "" : str2, (i10 & 8) != 0 ? "LauncherVectorEntity" : str3, (i10 & 16) != 0 ? "" : str4, (i10 & 32) != 0 ? "" : str5, (i10 & 64) != 0 ? "" : str6, (i10 & 128) == 0 ? str7 : "", (i10 & 256) != 0 ? 0L : j11);
    }
}
