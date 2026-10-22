package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OPushEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OPushEvent implements Parcelable {
    public static final Parcelable.Creator<OPushEvent> CREATOR = null;
    public static final a Companion = null;
    public static final int EVENT_TYPE_APP_ACTION = 3;

    @SerializedName("app_action")
    private final OAppAction action;

    @SerializedName("event_type")
    private final Integer eventType;

    /* JADX INFO: compiled from: OPushEvent.kt */
    public static final class Creator implements Parcelable.Creator<OPushEvent> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OPushEvent createFromParcel(Parcel r4) {
            o.e(r4, "parcel");
            OAppAction r1 = null;
            if (r4.readInt() != 0) goto L5;
            Integer r0 = null;
        L7:
            if (r4.readInt() == 0) goto L11;
            r1 = OAppAction.CREATOR.createFromParcel(r4);
        L11:
            return new OPushEvent(r0, (OAppAction) ZeusTransformUtils.preCheckCast(r1, OAppAction.class, "com.obric.aiagent.plugin"));
        L5:
            r0 = Integer.valueOf(r4.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OPushEvent createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OPushEvent[] newArray(int r1) {
            return new OPushEvent[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OPushEvent[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: OPushEvent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OPushEvent() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OPushEvent copy$default(OPushEvent r0, Integer r1, OAppAction r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.eventType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.action;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.eventType;
    }

    public final OAppAction component2() {
        return this.action;
    }

    public final OPushEvent copy(Integer r1, OAppAction r2) {
        return new OPushEvent(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OPushEvent.class) == true) goto L8;
        return false;
    L8:
        OPushEvent r6 = (OPushEvent) ZeusTransformUtils.preCheckCast(r5, OPushEvent.class, "com.obric.aiagent.plugin");
        if (o.a(this.eventType, r6.eventType) == true) goto L12;
        return false;
    L12:
        if (o.a(this.action, r6.action) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.eventType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        OAppAction r4 = this.action;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OPushEvent(eventType=" + this.eventType + ", action=" + this.action + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "dest");
        Integer r0 = this.eventType;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        OAppAction r3 = this.action;
        if (r3 != null) goto L9;
        r4.writeInt(0);
        return;
    L9:
        r4.writeInt(1);
        r3.writeToParcel(r4, r5);
        return;
    L5:
        r4.writeInt(1);
        r4.writeInt(r0.intValue());
        goto L6
    }

    public OPushEvent(Integer r1, OAppAction r2) {
        this.eventType = r1;
        this.action = r2;
    }

    public final Integer getEventType() {
        return this.eventType;
    }

    public /* synthetic */ OPushEvent(Integer r1, OAppAction r2, int r3, h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 3;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }

    public final OAppAction getAction() {
        return this.action;
    }
}
