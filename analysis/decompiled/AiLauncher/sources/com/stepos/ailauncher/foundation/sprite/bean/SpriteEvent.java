package com.stepos.ailauncher.foundation.sprite.bean;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J8\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;", "", "type", "", "action", "timeStamp", "", "isSessionForeground", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Boolean;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getAction", "setAction", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "()Ljava/lang/Boolean;", "setSessionForeground", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Boolean;)Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;", "equals", "other", "hashCode", "", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SpriteEvent {
    private String action;
    private Boolean isSessionForeground;
    private long timeStamp;
    private String type;

    public SpriteEvent(String type, String action, long j10, Boolean bool) {
        p.i(type, "type");
        p.i(action, "action");
        this.type = type;
        this.action = action;
        this.timeStamp = j10;
        this.isSessionForeground = bool;
    }

    public static /* synthetic */ SpriteEvent copy$default(SpriteEvent spriteEvent, String str, String str2, long j10, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = spriteEvent.type;
        }
        if ((i10 & 2) != 0) {
            str2 = spriteEvent.action;
        }
        if ((i10 & 4) != 0) {
            j10 = spriteEvent.timeStamp;
        }
        if ((i10 & 8) != 0) {
            bool = spriteEvent.isSessionForeground;
        }
        Boolean bool2 = bool;
        return spriteEvent.copy(str, str2, j10, bool2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getIsSessionForeground() {
        return this.isSessionForeground;
    }

    public final SpriteEvent copy(String type, String action, long timeStamp, Boolean isSessionForeground) {
        p.i(type, "type");
        p.i(action, "action");
        return new SpriteEvent(type, action, timeStamp, isSessionForeground);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpriteEvent)) {
            return false;
        }
        SpriteEvent spriteEvent = (SpriteEvent) other;
        return p.d(this.type, spriteEvent.type) && p.d(this.action, spriteEvent.action) && this.timeStamp == spriteEvent.timeStamp && p.d(this.isSessionForeground, spriteEvent.isSessionForeground);
    }

    public final String getAction() {
        return this.action;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((((this.type.hashCode() * 31) + this.action.hashCode()) * 31) + Long.hashCode(this.timeStamp)) * 31;
        Boolean bool = this.isSessionForeground;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public final Boolean isSessionForeground() {
        return this.isSessionForeground;
    }

    public final void setAction(String str) {
        p.i(str, "<set-?>");
        this.action = str;
    }

    public final void setSessionForeground(Boolean bool) {
        this.isSessionForeground = bool;
    }

    public final void setTimeStamp(long j10) {
        this.timeStamp = j10;
    }

    public final void setType(String str) {
        p.i(str, "<set-?>");
        this.type = str;
    }

    public String toString() {
        return "SpriteEvent(type=" + this.type + ", action=" + this.action + ", timeStamp=" + this.timeStamp + ", isSessionForeground=" + this.isSessionForeground + ")";
    }

    public /* synthetic */ SpriteEvent(String str, String str2, long j10, Boolean bool, int i10, i iVar) {
        this(str, str2, (i10 & 4) != 0 ? System.currentTimeMillis() : j10, (i10 & 8) != 0 ? null : bool);
    }
}
