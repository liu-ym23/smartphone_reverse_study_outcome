package com.bytedance.applet.event;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/applet/event/AppAction;", "", "eventType", "", "action", "Lcom/bytedance/applet/event/IMAppAction;", "<init>", "(Ljava/lang/Integer;Lcom/bytedance/applet/event/IMAppAction;)V", "getEventType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAction", "()Lcom/bytedance/applet/event/IMAppAction;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/bytedance/applet/event/IMAppAction;)Lcom/bytedance/applet/event/AppAction;", "equals", "", "other", "hashCode", "toString", "", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppAction {
    public static final a Companion = null;
    public static final int EVENT_TYPE_APP_ACTION = 3;

    @SerializedName("app_action")
    private final IMAppAction action;

    @SerializedName("event_type")
    private final Integer eventType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppAction() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AppAction copy$default(AppAction r100, Integer r101, IMAppAction r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.eventType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.action;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.eventType;
    }

    public final IMAppAction component2() {
        return this.action;
    }

    public final AppAction copy(Integer r100, IMAppAction r101) {
        return new AppAction(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppAction) == true) goto L8;
        return false;
    L8:
        AppAction r101 = (AppAction) r100;
        if (Intrinsics.areEqual(this.eventType, r101.eventType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.eventType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        IMAppAction r104 = this.action;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AppAction(eventType=" + this.eventType + ", action=" + this.action + ')';
    }

    public final IMAppAction getAction() {
        return this.action;
    }

    public final Integer getEventType() {
        return this.eventType;
    }

    public AppAction(Integer r100, IMAppAction r101) {
        this.eventType = r100;
        this.action = r101;
    }

    public /* synthetic */ AppAction(Integer r100, IMAppAction r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 3;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
