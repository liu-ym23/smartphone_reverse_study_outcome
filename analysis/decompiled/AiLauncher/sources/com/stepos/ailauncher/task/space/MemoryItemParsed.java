package com.stepos.ailauncher.task.space;

import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010\u0010¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/task/space/h0;", "", "", "slotKey", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "memoryId", "memoryName", "", "updatedAt", "", "isPersistent", "", "memoryIds", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLjava/util/List;)V", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", Const.INTENT_KEY_PKGNAME, "c", "e", "J", Const.INTENT_KEY_BACKGROUND_COMMAND, "()J", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "Ljava/util/List;", Const.INTENT_KEY_UMID, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.h0, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class MemoryItemParsed {
    private final String content;
    private final boolean isPersistent;
    private final String memoryId;
    private final List<String> memoryIds;
    private final String memoryName;
    private final String slotKey;
    private final long updatedAt;

    public MemoryItemParsed(String slotKey, String content, String memoryId, String memoryName, long j10, boolean z10, List<String> memoryIds) {
        kotlin.jvm.internal.p.i(slotKey, "slotKey");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(memoryId, "memoryId");
        kotlin.jvm.internal.p.i(memoryName, "memoryName");
        kotlin.jvm.internal.p.i(memoryIds, "memoryIds");
        this.slotKey = slotKey;
        this.content = content;
        this.memoryId = memoryId;
        this.memoryName = memoryName;
        this.updatedAt = j10;
        this.isPersistent = z10;
        this.memoryIds = memoryIds;
    }

    public final List<String> a() {
        List<String> list = this.memoryIds;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(La.H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List<String> listG0 = Z8.F.g0(arrayList2);
        if (!listG0.isEmpty()) {
            return listG0;
        }
        String string = La.H.D1(this.memoryId).toString();
        return string.length() == 0 ? C1173v.m() : C1172u.e(string);
    }

    /* renamed from: b, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: c, reason: from getter */
    public final String getMemoryId() {
        return this.memoryId;
    }

    public final List<String> d() {
        return this.memoryIds;
    }

    /* renamed from: e, reason: from getter */
    public final String getMemoryName() {
        return this.memoryName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemoryItemParsed)) {
            return false;
        }
        MemoryItemParsed memoryItemParsed = (MemoryItemParsed) other;
        return kotlin.jvm.internal.p.d(this.slotKey, memoryItemParsed.slotKey) && kotlin.jvm.internal.p.d(this.content, memoryItemParsed.content) && kotlin.jvm.internal.p.d(this.memoryId, memoryItemParsed.memoryId) && kotlin.jvm.internal.p.d(this.memoryName, memoryItemParsed.memoryName) && this.updatedAt == memoryItemParsed.updatedAt && this.isPersistent == memoryItemParsed.isPersistent && kotlin.jvm.internal.p.d(this.memoryIds, memoryItemParsed.memoryIds);
    }

    /* renamed from: f, reason: from getter */
    public final String getSlotKey() {
        return this.slotKey;
    }

    /* renamed from: g, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsPersistent() {
        return this.isPersistent;
    }

    public int hashCode() {
        return (((((((((((this.slotKey.hashCode() * 31) + this.content.hashCode()) * 31) + this.memoryId.hashCode()) * 31) + this.memoryName.hashCode()) * 31) + Long.hashCode(this.updatedAt)) * 31) + Boolean.hashCode(this.isPersistent)) * 31) + this.memoryIds.hashCode();
    }

    public String toString() {
        return "MemoryItemParsed(slotKey=" + this.slotKey + ", content=" + this.content + ", memoryId=" + this.memoryId + ", memoryName=" + this.memoryName + ", updatedAt=" + this.updatedAt + ", isPersistent=" + this.isPersistent + ", memoryIds=" + this.memoryIds + ")";
    }
}
