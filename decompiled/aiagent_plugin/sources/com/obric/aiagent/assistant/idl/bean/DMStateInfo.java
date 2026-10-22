package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DMStateInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DMStateInfo implements Parcelable {
    public static final Parcelable.Creator<DMStateInfo> CREATOR = null;
    private final List<DMTaskState> activeTasks;
    private final IslandCardSession cardSession;
    private final boolean isIdle;
    private final boolean isQuerying;

    /* JADX INFO: compiled from: DMStateInfo.kt */
    public static final class Creator implements Parcelable.Creator<DMStateInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DMStateInfo createFromParcel(Parcel r6) {
            o.e(r6, "parcel");
            boolean r0 = true;
            int r1 = 0;
            if (r6.readInt() == 0) goto L5;
            boolean r5 = true;
        L7:
            if (r6.readInt() != 0) goto L10;
            r0 = false;
        L10:
            int r2 = r6.readInt();
            ArrayList r3 = new ArrayList(r2);
        L11:
            if (r1 == r2) goto L13;
            r3.add(DMTaskState.CREATOR.createFromParcel(r6));
            r1 = r1 + 1;
            goto L11
        L13:
            List r4 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
            if (r6.readInt() != 0) goto L16;
            IslandCardSession r7 = null;
        L18:
            return new DMStateInfo(r5, r0, r4, (IslandCardSession) ZeusTransformUtils.preCheckCast(r7, IslandCardSession.class, "com.obric.aiagent.plugin"));
        L16:
            r7 = IslandCardSession.CREATOR.createFromParcel(r6);
            goto L18
        L5:
            r5 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DMStateInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DMStateInfo[] newArray(int r1) {
            return new DMStateInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DMStateInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ DMStateInfo copy$default(DMStateInfo r1, boolean r2, boolean r3, List r4, IslandCardSession r5, int r6, Object r7) {
        List<DMTaskState> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.isIdle;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.isQuerying;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.activeTasks;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.cardSession;
    L15:
        return r1.copy(r2, r3, r8, r5);
    }

    public final boolean component1() {
        return this.isIdle;
    }

    public final boolean component2() {
        return this.isQuerying;
    }

    public final List<DMTaskState> component3() {
        return this.activeTasks;
    }

    public final IslandCardSession component4() {
        return this.cardSession;
    }

    public final DMStateInfo copy(boolean r2, boolean r3, List<DMTaskState> r4, IslandCardSession r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "activeTasks");
        return new DMStateInfo(r2, r3, r1, r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DMStateInfo.class) == true) goto L8;
        return false;
    L8:
        DMStateInfo r6 = (DMStateInfo) ZeusTransformUtils.preCheckCast(r5, DMStateInfo.class, "com.obric.aiagent.plugin");
        if (this.isIdle == r6.isIdle) goto L12;
        return false;
    L12:
        if (this.isQuerying == r6.isQuerying) goto L15;
        return false;
    L15:
        if (o.a(this.activeTasks, r6.activeTasks) == true) goto L18;
        return false;
    L18:
        if (o.a(this.cardSession, r6.cardSession) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Boolean.hashCode(this.isIdle) * 31) + Boolean.hashCode(this.isQuerying)) * 31) + this.activeTasks.hashCode()) * 31;
        IslandCardSession r2 = this.cardSession;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "DMStateInfo(isIdle=" + this.isIdle + ", isQuerying=" + this.isQuerying + ", activeTasks=" + this.activeTasks + ", cardSession=" + this.cardSession + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "dest");
        r5.writeInt(this.isIdle ? 1 : 0);
        r5.writeInt(this.isQuerying ? 1 : 0);
        List<DMTaskState> r0 = this.activeTasks;
        r5.writeInt(r0.size());
        Iterator<DMTaskState> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((DMTaskState) ZeusTransformUtils.preCheckCast(r1.next(), DMTaskState.class, "com.obric.aiagent.plugin")).writeToParcel(r5, r6);
        goto L4
    L6:
        IslandCardSession r4 = this.cardSession;
        if (r4 != null) goto L9;
        r5.writeInt(0);
        return;
    L9:
        r5.writeInt(1);
        r4.writeToParcel(r5, r6);
    }

    public DMStateInfo(boolean r3, boolean r4, List<DMTaskState> r5, IslandCardSession r6) {
        List<DMTaskState> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "activeTasks");
        this.isIdle = r3;
        this.isQuerying = r4;
        this.activeTasks = r7;
        this.cardSession = r6;
    }

    public final boolean isIdle() {
        return this.isIdle;
    }

    public final boolean isQuerying() {
        return this.isQuerying;
    }

    public final List<DMTaskState> getActiveTasks() {
        return this.activeTasks;
    }

    public final IslandCardSession getCardSession() {
        return this.cardSession;
    }
}
