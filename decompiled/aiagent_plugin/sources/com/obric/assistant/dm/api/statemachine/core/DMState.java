package com.obric.assistant.dm.api.statemachine.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.livecard.api.entity.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DMState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DMState implements Parcelable {
    public static final Parcelable.Creator<DMState> CREATOR = null;
    private final List<State> activeTasks;
    private final boolean isIdle;
    private final boolean isQuerying;
    private final IslandSession topIslandCard;

    /* JADX INFO: compiled from: DMState.kt */
    public static final class Creator implements Parcelable.Creator<DMState> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DMState createFromParcel(Parcel r6) {
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
            if (r1 == r2) goto L14;
            r3.add(r6.readParcelable(DMState.class.getClassLoader()));
            r1 = r1 + 1;
            goto L11
        L14:
            return new DMState(r5, r0, (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), (IslandSession) ZeusTransformUtils.preCheckCast(r6.readParcelable(DMState.class.getClassLoader()), IslandSession.class, "com.obric.aiagent.plugin"));
        L5:
            r5 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DMState createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DMState[] newArray(int r1) {
            return new DMState[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DMState[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ DMState copy$default(DMState r1, boolean r2, boolean r3, List r4, IslandSession r5, int r6, Object r7) {
        List<State> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
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
        r5 = r1.topIslandCard;
    L15:
        return r1.copy(r2, r3, r8, r5);
    }

    public final boolean component1() {
        return this.isIdle;
    }

    public final boolean component2() {
        return this.isQuerying;
    }

    public final List<State> component3() {
        return this.activeTasks;
    }

    public final IslandSession component4() {
        return this.topIslandCard;
    }

    public final DMState copy(boolean r2, boolean r3, List<? extends State> r4, IslandSession r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "activeTasks");
        return new DMState(r2, r3, r1, r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DMState.class) == true) goto L8;
        return false;
    L8:
        DMState r6 = (DMState) ZeusTransformUtils.preCheckCast(r5, DMState.class, "com.obric.aiagent.plugin");
        if (this.isIdle == r6.isIdle) goto L12;
        return false;
    L12:
        if (this.isQuerying == r6.isQuerying) goto L15;
        return false;
    L15:
        if (o.a(this.activeTasks, r6.activeTasks) == true) goto L18;
        return false;
    L18:
        if (o.a(this.topIslandCard, r6.topIslandCard) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Boolean.hashCode(this.isIdle) * 31) + Boolean.hashCode(this.isQuerying)) * 31) + this.activeTasks.hashCode()) * 31;
        IslandSession r2 = this.topIslandCard;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "DMState(isIdle=" + this.isIdle + ", isQuerying=" + this.isQuerying + ", activeTasks=" + this.activeTasks + ", topIslandCard=" + this.topIslandCard + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "dest");
        r5.writeInt(this.isIdle ? 1 : 0);
        r5.writeInt(this.isQuerying ? 1 : 0);
        List<State> r0 = this.activeTasks;
        r5.writeInt(r0.size());
        Iterator<State> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r1.next(), Parcelable.class, "com.obric.aiagent.plugin"), r6);
        goto L4
    L6:
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.topIslandCard, Parcelable.class, "com.obric.aiagent.plugin"), r6);
    }

    public DMState(boolean r3, boolean r4, List<? extends State> r5, IslandSession r6) {
        List<State> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "activeTasks");
        this.isIdle = r3;
        this.isQuerying = r4;
        this.activeTasks = r7;
        this.topIslandCard = r6;
    }

    public final boolean isIdle() {
        return this.isIdle;
    }

    public final boolean isQuerying() {
        return this.isQuerying;
    }

    public final List<State> getActiveTasks() {
        return this.activeTasks;
    }

    public final IslandSession getTopIslandCard() {
        return this.topIslandCard;
    }
}
