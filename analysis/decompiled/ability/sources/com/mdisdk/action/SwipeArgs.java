package com.mdisdk.action;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003Jn\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\nHÖ\u0001J\t\u0010/\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001e¨\u00060"}, d2 = {"Lcom/mdisdk/action/SwipeArgs;", "", "startX", "", "startY", "endX", "endY", "durationInMs", "", "steps", "", WindowStateInfo.KEY_DISPLAY_ID, "packageName", "", "windowTitle", AppAgent.CONSTRUCT, "(FFFFJILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getStartX", "()F", "getStartY", "getEndX", "getEndY", "getDurationInMs", "()J", "getSteps", "()I", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPackageName", "()Ljava/lang/String;", "getWindowTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(FFFFJILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/mdisdk/action/SwipeArgs;", "equals", "", "other", "hashCode", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SwipeArgs {
    private final Integer displayId;
    private final long durationInMs;
    private final float endX;
    private final float endY;
    private final String packageName;
    private final float startX;
    private final float startY;
    private final int steps;
    private final String windowTitle;

    public SwipeArgs(float f, float f7, float f9, float f10, long j5, int i, Integer num, String str, String str2) {
        this.startX = f;
        this.startY = f7;
        this.endX = f9;
        this.endY = f10;
        this.durationInMs = j5;
        this.steps = i;
        this.displayId = num;
        this.packageName = str;
        this.windowTitle = str2;
    }

    public static /* synthetic */ SwipeArgs copy$default(SwipeArgs swipeArgs, float f, float f7, float f9, float f10, long j5, int i, Integer num, String str, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            f = swipeArgs.startX;
        }
        if ((i6 & 2) != 0) {
            f7 = swipeArgs.startY;
        }
        if ((i6 & 4) != 0) {
            f9 = swipeArgs.endX;
        }
        if ((i6 & 8) != 0) {
            f10 = swipeArgs.endY;
        }
        if ((i6 & 16) != 0) {
            j5 = swipeArgs.durationInMs;
        }
        if ((i6 & 32) != 0) {
            i = swipeArgs.steps;
        }
        if ((i6 & 64) != 0) {
            num = swipeArgs.displayId;
        }
        if ((i6 & 128) != 0) {
            str = swipeArgs.packageName;
        }
        if ((i6 & 256) != 0) {
            str2 = swipeArgs.windowTitle;
        }
        long j6 = j5;
        float f11 = f9;
        float f12 = f10;
        return swipeArgs.copy(f, f7, f11, f12, j6, i, num, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getStartX() {
        return this.startX;
    }

    /* renamed from: component2, reason: from getter */
    public final float getStartY() {
        return this.startY;
    }

    /* renamed from: component3, reason: from getter */
    public final float getEndX() {
        return this.endX;
    }

    /* renamed from: component4, reason: from getter */
    public final float getEndY() {
        return this.endY;
    }

    /* renamed from: component5, reason: from getter */
    public final long getDurationInMs() {
        return this.durationInMs;
    }

    /* renamed from: component6, reason: from getter */
    public final int getSteps() {
        return this.steps;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component9, reason: from getter */
    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public final SwipeArgs copy(float startX, float startY, float endX, float endY, long durationInMs, int steps, Integer displayId, String packageName, String windowTitle) {
        return new SwipeArgs(startX, startY, endX, endY, durationInMs, steps, displayId, packageName, windowTitle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SwipeArgs)) {
            return false;
        }
        SwipeArgs swipeArgs = (SwipeArgs) other;
        return Float.compare(this.startX, swipeArgs.startX) == 0 && Float.compare(this.startY, swipeArgs.startY) == 0 && Float.compare(this.endX, swipeArgs.endX) == 0 && Float.compare(this.endY, swipeArgs.endY) == 0 && this.durationInMs == swipeArgs.durationInMs && this.steps == swipeArgs.steps && k.b(this.displayId, swipeArgs.displayId) && k.b(this.packageName, swipeArgs.packageName) && k.b(this.windowTitle, swipeArgs.windowTitle);
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final long getDurationInMs() {
        return this.durationInMs;
    }

    public final float getEndX() {
        return this.endX;
    }

    public final float getEndY() {
        return this.endY;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final float getStartX() {
        return this.startX;
    }

    public final float getStartY() {
        return this.startY;
    }

    public final int getSteps() {
        return this.steps;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public int hashCode() {
        int iA = a.a(this.steps, androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.b(this.endY, androidx.appfunctions.metadata.a.b(this.endX, androidx.appfunctions.metadata.a.b(this.startY, Float.hashCode(this.startX) * 31, 31), 31), 31), 31, this.durationInMs), 31);
        Integer num = this.displayId;
        int iHashCode = (iA + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.packageName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.windowTitle;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SwipeArgs(startX=");
        sb.append(this.startX);
        sb.append(", startY=");
        sb.append(this.startY);
        sb.append(", endX=");
        sb.append(this.endX);
        sb.append(", endY=");
        sb.append(this.endY);
        sb.append(", durationInMs=");
        sb.append(this.durationInMs);
        sb.append(", steps=");
        sb.append(this.steps);
        sb.append(", displayId=");
        sb.append(this.displayId);
        sb.append(", packageName=");
        sb.append(this.packageName);
        sb.append(", windowTitle=");
        return B7.a.g(')', this.windowTitle, sb);
    }
}
