package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class ActiveAgentEvent extends AppEvent {
    public static final CREATOR CREATOR = null;
    private String expandState;
    private boolean forceOmni;
    private String instructionEntry;
    private String instructionType;
    private boolean openMic;
    private String query;

    public static final class CREATOR implements Parcelable.Creator<ActiveAgentEvent> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActiveAgentEvent createFromParcel(Parcel r2) {
            o.e(r2, DBHelper.BATTERY_COL_SOURCE);
            return (ActiveAgentEvent) ZeusTransformUtils.preCheckCast(AppEvent.CREATOR.createAppEventFromParcel$eventstaskkit_release(r2), ActiveAgentEvent.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ActiveAgentEvent createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActiveAgentEvent[] newArray(int r1) {
            return new ActiveAgentEvent[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ActiveAgentEvent[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ActiveAgentEvent() {
        this(null, null, null, false, false, null, null, null, 255, null);
    }

    public ActiveAgentEvent(String r2, String r3, String r4, boolean r5, boolean r6, String r7, String r8, String r9) {
        o.e(r7, "expandState");
        super(r2, r3, null);
        this.query = r4;
        this.openMic = r5;
        this.forceOmni = r6;
        this.expandState = r7;
        this.instructionType = r8;
        this.instructionEntry = r9;
    }

    public /* synthetic */ ActiveAgentEvent(String r3, String r4, String r5, boolean r6, boolean r7, String r8, String r9, String r10, int r11, h r12) {
        if ((r11 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r6 = false;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r7 = false;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r8 = "half";
    L21:
        if ((r11 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r11 & 128) == 0) goto L26;
        r10 = null;
    L26:
        this(r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public final String getExpandState() {
        return this.expandState;
    }

    public final boolean getForceOmni() {
        return this.forceOmni;
    }

    public final String getInstructionEntry() {
        return this.instructionEntry;
    }

    public final String getInstructionType() {
        return this.instructionType;
    }

    public final boolean getOpenMic() {
        return this.openMic;
    }

    public final String getQuery() {
        return this.query;
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent
    public void readFromParcel(Parcel r4) {
        o.e(r4, "parcel");
        super.readFromParcel(r4);
        this.query = r4.readString();
        boolean r1 = true;
        if (r4.readInt() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.openMic = r0;
        if (r4.readInt() != 0) goto L10;
        r1 = false;
    L10:
        this.forceOmni = r1;
        String r2 = r4.readString();
        if (r2 != null) goto L13;
        r2 = "half";
    L13:
        this.expandState = r2;
        this.instructionType = r4.readString();
        this.instructionEntry = r4.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setExpandState(String r2) {
        o.e(r2, "<set-?>");
        this.expandState = r2;
    }

    public final void setForceOmni(boolean r1) {
        this.forceOmni = r1;
    }

    public final void setInstructionEntry(String r1) {
        this.instructionEntry = r1;
    }

    public final void setInstructionType(String r1) {
        this.instructionType = r1;
    }

    public final void setOpenMic(boolean r1) {
        this.openMic = r1;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ActiveAgentEvent(id=").append(getId()).append(", content=").append(getContent()).append(", extra=").append(getExtra()).append(", createTime=").append(getCreateTime()).append(", lastModifiedTime=").append(getLastModifiedTime()).append(", source='").append(getSource()).append("', eventType='").append(getEventType()).append("', query='").append(this.query).append("', openMic=").append(this.openMic).append(", forceOmni=").append(this.forceOmni).append(", expandState='").append(this.expandState).append("'instructionType='");
        r0.append(this.instructionType).append("', instructionEntry='").append(this.instructionEntry).append("')");
        return r0.toString();
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "dest");
        super.writeToParcel(r2, r3);
        r2.writeString(this.query);
        r2.writeInt(this.openMic ? 1 : 0);
        r2.writeInt(this.forceOmni ? 1 : 0);
        r2.writeString(this.expandState);
        r2.writeString(this.instructionType);
        r2.writeString(this.instructionEntry);
    }
}
