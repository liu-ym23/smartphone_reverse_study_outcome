package com.mdisdk.mirror;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/mdisdk/mirror/LogicalTouchEvent;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "", "pointers", "", "Lcom/mdisdk/mirror/PointerRecord;", "downTime", "", "eventTime", AppAgent.CONSTRUCT, "(ILjava/util/List;JJ)V", "getAction", "()I", "getPointers", "()Ljava/util/List;", "getDownTime", "()J", "getEventTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LogicalTouchEvent {
    private final int action;
    private final long downTime;
    private final long eventTime;
    private final List<PointerRecord> pointers;

    public LogicalTouchEvent(int i, List<PointerRecord> pointers, long j5, long j6) {
        k.f(pointers, "pointers");
        this.action = i;
        this.pointers = pointers;
        this.downTime = j5;
        this.eventTime = j6;
    }

    public static /* synthetic */ LogicalTouchEvent copy$default(LogicalTouchEvent logicalTouchEvent, int i, List list, long j5, long j6, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = logicalTouchEvent.action;
        }
        if ((i6 & 2) != 0) {
            list = logicalTouchEvent.pointers;
        }
        if ((i6 & 4) != 0) {
            j5 = logicalTouchEvent.downTime;
        }
        if ((i6 & 8) != 0) {
            j6 = logicalTouchEvent.eventTime;
        }
        long j10 = j6;
        return logicalTouchEvent.copy(i, list, j5, j10);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAction() {
        return this.action;
    }

    public final List<PointerRecord> component2() {
        return this.pointers;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDownTime() {
        return this.downTime;
    }

    /* renamed from: component4, reason: from getter */
    public final long getEventTime() {
        return this.eventTime;
    }

    public final LogicalTouchEvent copy(int action, List<PointerRecord> pointers, long downTime, long eventTime) {
        k.f(pointers, "pointers");
        return new LogicalTouchEvent(action, pointers, downTime, eventTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogicalTouchEvent)) {
            return false;
        }
        LogicalTouchEvent logicalTouchEvent = (LogicalTouchEvent) other;
        return this.action == logicalTouchEvent.action && k.b(this.pointers, logicalTouchEvent.pointers) && this.downTime == logicalTouchEvent.downTime && this.eventTime == logicalTouchEvent.eventTime;
    }

    public final int getAction() {
        return this.action;
    }

    public final long getDownTime() {
        return this.downTime;
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    public final List<PointerRecord> getPointers() {
        return this.pointers;
    }

    public int hashCode() {
        return Long.hashCode(this.eventTime) + a.c(a.e(this.pointers, Integer.hashCode(this.action) * 31, 31), 31, this.downTime);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LogicalTouchEvent(action=");
        sb.append(this.action);
        sb.append(", pointers=");
        sb.append(this.pointers);
        sb.append(", downTime=");
        sb.append(this.downTime);
        sb.append(", eventTime=");
        return B7.a.p(sb, this.eventTime, ')');
    }
}
