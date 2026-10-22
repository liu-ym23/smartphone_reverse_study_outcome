package com.stepos.taskrobot.taskmemory.bean;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/bean/MemoryFrame;", "", "imagePath", "", "description", "actionType", "timestamp", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getImagePath", "()Ljava/lang/String;", "getDescription", "getActionType", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/stepos/taskrobot/taskmemory/bean/MemoryFrame;", "equals", "", "other", "hashCode", "", "toString", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MemoryFrame {
    private final String actionType;
    private final String description;
    private final String imagePath;
    private final Long timestamp;

    public MemoryFrame(String str, String str2, String str3, Long l) {
        this.imagePath = str;
        this.description = str2;
        this.actionType = str3;
        this.timestamp = l;
    }

    public static /* synthetic */ MemoryFrame copy$default(MemoryFrame memoryFrame, String str, String str2, String str3, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = memoryFrame.imagePath;
        }
        if ((i & 2) != 0) {
            str2 = memoryFrame.description;
        }
        if ((i & 4) != 0) {
            str3 = memoryFrame.actionType;
        }
        if ((i & 8) != 0) {
            l = memoryFrame.timestamp;
        }
        return memoryFrame.copy(str, str2, str3, l);
    }

    /* renamed from: component1, reason: from getter */
    public final String getImagePath() {
        return this.imagePath;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3, reason: from getter */
    public final String getActionType() {
        return this.actionType;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final MemoryFrame copy(String imagePath, String description, String actionType, Long timestamp) {
        return new MemoryFrame(imagePath, description, actionType, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemoryFrame)) {
            return false;
        }
        MemoryFrame memoryFrame = (MemoryFrame) other;
        return k.b(this.imagePath, memoryFrame.imagePath) && k.b(this.description, memoryFrame.description) && k.b(this.actionType, memoryFrame.actionType) && k.b(this.timestamp, memoryFrame.timestamp);
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getImagePath() {
        return this.imagePath;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        String str = this.imagePath;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.actionType;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.timestamp;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        String str = this.imagePath;
        String str2 = this.description;
        String str3 = this.actionType;
        Long l = this.timestamp;
        StringBuilder sbW = a.w("MemoryFrame(imagePath=", str, ", description=", str2, ", actionType=");
        sbW.append(str3);
        sbW.append(", timestamp=");
        sbW.append(l);
        sbW.append(")");
        return sbW.toString();
    }
}
