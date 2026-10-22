package com.mdisdk.action;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003JP\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006%"}, d2 = {"Lcom/mdisdk/action/ClickArgs;", "", "x", "", "y", "durationInMs", "", WindowStateInfo.KEY_DISPLAY_ID, "packageName", "", "windowTitle", AppAgent.CONSTRUCT, "(IIJLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getX", "()I", "getY", "getDurationInMs", "()J", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPackageName", "()Ljava/lang/String;", "getWindowTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(IIJLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/mdisdk/action/ClickArgs;", "equals", "", "other", "hashCode", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ClickArgs {
    private final Integer displayId;
    private final long durationInMs;
    private final String packageName;
    private final String windowTitle;
    private final int x;
    private final int y;

    public ClickArgs(int i, int i6, long j5, Integer num, String str, String str2) {
        this.x = i;
        this.y = i6;
        this.durationInMs = j5;
        this.displayId = num;
        this.packageName = str;
        this.windowTitle = str2;
    }

    public static /* synthetic */ ClickArgs copy$default(ClickArgs clickArgs, int i, int i6, long j5, Integer num, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = clickArgs.x;
        }
        if ((i10 & 2) != 0) {
            i6 = clickArgs.y;
        }
        if ((i10 & 4) != 0) {
            j5 = clickArgs.durationInMs;
        }
        if ((i10 & 8) != 0) {
            num = clickArgs.displayId;
        }
        if ((i10 & 16) != 0) {
            str = clickArgs.packageName;
        }
        if ((i10 & 32) != 0) {
            str2 = clickArgs.windowTitle;
        }
        String str3 = str2;
        Integer num2 = num;
        long j6 = j5;
        return clickArgs.copy(i, i6, j6, num2, str, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final int getY() {
        return this.y;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDurationInMs() {
        return this.durationInMs;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public final ClickArgs copy(int x10, int y, long durationInMs, Integer displayId, String packageName, String windowTitle) {
        return new ClickArgs(x10, y, durationInMs, displayId, packageName, windowTitle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClickArgs)) {
            return false;
        }
        ClickArgs clickArgs = (ClickArgs) other;
        return this.x == clickArgs.x && this.y == clickArgs.y && this.durationInMs == clickArgs.durationInMs && k.b(this.displayId, clickArgs.displayId) && k.b(this.packageName, clickArgs.packageName) && k.b(this.windowTitle, clickArgs.windowTitle);
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final long getDurationInMs() {
        return this.durationInMs;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public int hashCode() {
        int iC = a.c(androidx.constraintlayout.core.dsl.a.a(this.y, Integer.hashCode(this.x) * 31, 31), 31, this.durationInMs);
        Integer num = this.displayId;
        int iHashCode = (iC + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.packageName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.windowTitle;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClickArgs(x=");
        sb.append(this.x);
        sb.append(", y=");
        sb.append(this.y);
        sb.append(", durationInMs=");
        sb.append(this.durationInMs);
        sb.append(", displayId=");
        sb.append(this.displayId);
        sb.append(", packageName=");
        sb.append(this.packageName);
        sb.append(", windowTitle=");
        return B7.a.g(')', this.windowTitle, sb);
    }
}
