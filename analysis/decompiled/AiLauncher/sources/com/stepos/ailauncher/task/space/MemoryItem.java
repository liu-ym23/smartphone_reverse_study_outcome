package com.stepos.ailauncher.task.space;

import Z8.C1172u;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\\\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\b\u0010\u001fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/task/space/e0;", "", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "time", "memoryId", "memoryName", "", "isPersistent", "", "updatedAt", "", "memoryIds", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/util/List;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/util/List;)Lcom/stepos/ailauncher/task/space/e0;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "f", "Z", "()Z", "J", "getUpdatedAt", "()J", "Ljava/util/List;", "e", "()Ljava/util/List;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.e0, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class MemoryItem {
    private final String content;
    private final boolean isPersistent;
    private final String memoryId;
    private final List<String> memoryIds;
    private final String memoryName;
    private final String time;
    private final long updatedAt;

    public MemoryItem(String content, String time, String memoryId, String memoryName, boolean z10, long j10, List<String> memoryIds) {
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(time, "time");
        kotlin.jvm.internal.p.i(memoryId, "memoryId");
        kotlin.jvm.internal.p.i(memoryName, "memoryName");
        kotlin.jvm.internal.p.i(memoryIds, "memoryIds");
        this.content = content;
        this.time = time;
        this.memoryId = memoryId;
        this.memoryName = memoryName;
        this.isPersistent = z10;
        this.updatedAt = j10;
        this.memoryIds = memoryIds;
    }

    public static /* synthetic */ MemoryItem b(MemoryItem memoryItem, String str, String str2, String str3, String str4, boolean z10, long j10, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = memoryItem.content;
        }
        if ((i10 & 2) != 0) {
            str2 = memoryItem.time;
        }
        if ((i10 & 4) != 0) {
            str3 = memoryItem.memoryId;
        }
        if ((i10 & 8) != 0) {
            str4 = memoryItem.memoryName;
        }
        if ((i10 & 16) != 0) {
            z10 = memoryItem.isPersistent;
        }
        if ((i10 & 32) != 0) {
            j10 = memoryItem.updatedAt;
        }
        if ((i10 & 64) != 0) {
            list = memoryItem.memoryIds;
        }
        List list2 = list;
        long j11 = j10;
        boolean z11 = z10;
        String str5 = str3;
        return memoryItem.a(str, str2, str5, str4, z11, j11, list2);
    }

    public final MemoryItem a(String content, String time, String memoryId, String memoryName, boolean isPersistent, long updatedAt, List<String> memoryIds) {
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(time, "time");
        kotlin.jvm.internal.p.i(memoryId, "memoryId");
        kotlin.jvm.internal.p.i(memoryName, "memoryName");
        kotlin.jvm.internal.p.i(memoryIds, "memoryIds");
        return new MemoryItem(content, time, memoryId, memoryName, isPersistent, updatedAt, memoryIds);
    }

    /* renamed from: c, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: d, reason: from getter */
    public final String getMemoryId() {
        return this.memoryId;
    }

    public final List<String> e() {
        return this.memoryIds;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemoryItem)) {
            return false;
        }
        MemoryItem memoryItem = (MemoryItem) other;
        return kotlin.jvm.internal.p.d(this.content, memoryItem.content) && kotlin.jvm.internal.p.d(this.time, memoryItem.time) && kotlin.jvm.internal.p.d(this.memoryId, memoryItem.memoryId) && kotlin.jvm.internal.p.d(this.memoryName, memoryItem.memoryName) && this.isPersistent == memoryItem.isPersistent && this.updatedAt == memoryItem.updatedAt && kotlin.jvm.internal.p.d(this.memoryIds, memoryItem.memoryIds);
    }

    /* renamed from: f, reason: from getter */
    public final String getMemoryName() {
        return this.memoryName;
    }

    /* renamed from: g, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((((((((((this.content.hashCode() * 31) + this.time.hashCode()) * 31) + this.memoryId.hashCode()) * 31) + this.memoryName.hashCode()) * 31) + Boolean.hashCode(this.isPersistent)) * 31) + Long.hashCode(this.updatedAt)) * 31) + this.memoryIds.hashCode();
    }

    public String toString() {
        return "MemoryItem(content=" + this.content + ", time=" + this.time + ", memoryId=" + this.memoryId + ", memoryName=" + this.memoryName + ", isPersistent=" + this.isPersistent + ", updatedAt=" + this.updatedAt + ", memoryIds=" + this.memoryIds + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MemoryItem(String str, String str2, String str3, String str4, boolean z10, long j10, List list, int i10, kotlin.jvm.internal.i iVar) {
        str3 = (i10 & 4) != 0 ? "" : str3;
        this(str, str2, str3, (i10 & 8) != 0 ? "" : str4, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? 0L : j10, (i10 & 64) != 0 ? !La.H.x0(str3) ? C1172u.e(str3) : C1173v.m() : list);
    }
}
