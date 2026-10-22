package com.mdisdk.action;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/mdisdk/action/CaptureArgs;", "", WindowStateInfo.KEY_DISPLAY_ID, "", "targetPackageName", "", AppAgent.CONSTRUCT, "(Ljava/lang/Integer;Ljava/lang/String;)V", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTargetPackageName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/mdisdk/action/CaptureArgs;", "equals", "", "other", "hashCode", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CaptureArgs {
    private final Integer displayId;
    private final String targetPackageName;

    public CaptureArgs(Integer num, String str) {
        this.displayId = num;
        this.targetPackageName = str;
    }

    public static /* synthetic */ CaptureArgs copy$default(CaptureArgs captureArgs, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = captureArgs.displayId;
        }
        if ((i & 2) != 0) {
            str = captureArgs.targetPackageName;
        }
        return captureArgs.copy(num, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTargetPackageName() {
        return this.targetPackageName;
    }

    public final CaptureArgs copy(Integer displayId, String targetPackageName) {
        return new CaptureArgs(displayId, targetPackageName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptureArgs)) {
            return false;
        }
        CaptureArgs captureArgs = (CaptureArgs) other;
        return k.b(this.displayId, captureArgs.displayId) && k.b(this.targetPackageName, captureArgs.targetPackageName);
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final String getTargetPackageName() {
        return this.targetPackageName;
    }

    public int hashCode() {
        Integer num = this.displayId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.targetPackageName;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CaptureArgs(displayId=");
        sb.append(this.displayId);
        sb.append(", targetPackageName=");
        return a.g(')', this.targetPackageName, sb);
    }
}
