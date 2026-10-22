package com.obric.capabilitykit.common;

import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\b\u0010!\u001a\u00020\tH\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006\""}, d2 = {"Lcom/obric/capabilitykit/common/TimerInfo;", "", "id", "", WsConstants.KEY_CONNECTION_STATE, "", "totalLength", "remainingTime", ServerElements.LABEL, "", "deleteAfterUse", "", "(JIJJLjava/lang/String;Z)V", "getDeleteAfterUse", "()Z", "getId", "()J", "getLabel", "()Ljava/lang/String;", "getRemainingTime", "getState", "()I", "getTotalLength", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimerInfo {
    private final boolean deleteAfterUse;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f11254id;

    @NotNull
    private final String label;
    private final long remainingTime;
    private final int state;
    private final long totalLength;

    public TimerInfo() {
        long r10 = 0;
        int r11 = 0;
        long r12 = 0;
        long r13 = 0;
        String r14 = null;
        boolean r15 = false;
        this(r10, r11, r12, r13, r14, r15, 63, null);
    }

    public static /* synthetic */ TimerInfo copy$default(TimerInfo r10, long r11, int r13, long r14, long r16, String r18, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        long r12 = r10.f11254id;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r15 = r10.state;
    L11:
        if ((r20 & 4) == 0) goto L13;
        long r17 = r10.totalLength;
    L15:
        if ((r20 & 8) == 0) goto L17;
        long r22 = r10.remainingTime;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r23 = r10.label;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r24 = r10.deleteAfterUse;
    L27:
        return r10.copy(r12, r15, r17, r22, r23, r24);
    L25:
        r24 = r19;
        goto L27
    L21:
        r23 = r18;
        goto L23
    L17:
        r22 = r16;
        goto L19
    L13:
        r17 = r14;
        goto L15
    L9:
        r15 = r13;
        goto L11
    L5:
        r12 = r11;
        goto L7
    }

    public final long component1() {
        return this.f11254id;
    }

    public final int component2() {
        return this.state;
    }

    public final long component3() {
        return this.totalLength;
    }

    public final long component4() {
        return this.remainingTime;
    }

    @NotNull
    public final String component5() {
        return this.label;
    }

    public final boolean component6() {
        return this.deleteAfterUse;
    }

    @NotNull
    public final TimerInfo copy(long r12, int r14, long r15, long r17, @NotNull String r19, boolean r20) {
        kotlin.jvm.internal.q.g(r19, ServerElements.LABEL);
        return new TimerInfo(r12, r14, r15, r17, r19, r20);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TimerInfo) == true) goto L8;
        return false;
    L8:
        TimerInfo r11 = (TimerInfo) r10;
        if (this.f11254id == r11.f11254id) goto L12;
        return false;
    L12:
        if (this.state == r11.state) goto L15;
        return false;
    L15:
        if (this.totalLength == r11.totalLength) goto L18;
        return false;
    L18:
        if (this.remainingTime == r11.remainingTime) goto L21;
        return false;
    L21:
        if (kotlin.jvm.internal.q.b(this.label, r11.label) == true) goto L24;
        return false;
    L24:
        if (this.deleteAfterUse == r11.deleteAfterUse) goto L26;
        return false;
    L26:
        return true;
    }

    public final boolean getDeleteAfterUse() {
        return this.deleteAfterUse;
    }

    public final long getId() {
        return this.f11254id;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    public final long getRemainingTime() {
        return this.remainingTime;
    }

    public final int getState() {
        return this.state;
    }

    public final long getTotalLength() {
        return this.totalLength;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r10 = ((((((((Long.hashCode(this.f11254id) * 31) + Integer.hashCode(this.state)) * 31) + Long.hashCode(this.totalLength)) * 31) + Long.hashCode(this.remainingTime)) * 31) + this.label.hashCode()) * 31;
        boolean r11 = this.deleteAfterUse;
        ?? r12 = r11;
        if (r11 == false) goto L6;
        r12 = 1;
    L6:
        return r10 + r12;
    }

    @NotNull
    public String toString() {
        return "TimerInfo id: " + this.f11254id + ", state: " + this.state + ", totalLenght: " + this.totalLength + ", remainingTime: " + this.remainingTime + ", label: " + this.label + ", deleteAfterUse: " + this.deleteAfterUse;
    }

    public TimerInfo(long r10, int r11, long r12, long r13, @NotNull String r14, boolean r15) {
        kotlin.jvm.internal.q.g(r14, ServerElements.LABEL);
        this.f11254id = r10;
        this.state = r11;
        this.totalLength = r12;
        this.remainingTime = r13;
        this.label = r14;
        this.deleteAfterUse = r15;
    }

    public /* synthetic */ TimerInfo(long r11, int r13, long r14, long r16, String r18, boolean r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 1) == 0) goto L5;
        long r10 = -1;
    L6:
        boolean r12 = false;
        if ((r20 & 2) == 0) goto L9;
        int r15 = 0;
    L10:
        long r17 = 0;
        if ((r20 & 4) == 0) goto L13;
        long r22 = 0;
    L15:
        if ((r20 & 8) != 0) goto L19;
        r17 = r16;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r23 = "";
    L23:
        if ((r20 & 32) != 0) goto L26;
        r12 = r19;
    L26:
        this(r10, r15, r22, r17, r23, r12);
        return;
    L21:
        r23 = r18;
        goto L23
    L13:
        r22 = r14;
        goto L15
    L9:
        r15 = r13;
        goto L10
    L5:
        r10 = r11;
        goto L6
    }
}
