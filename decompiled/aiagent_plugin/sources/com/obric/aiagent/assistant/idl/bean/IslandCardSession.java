package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IslandCardSession.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IslandCardSession implements Parcelable {
    public static final Parcelable.Creator<IslandCardSession> CREATOR = null;
    private final long flags;
    private final int type;

    /* JADX INFO: compiled from: IslandCardSession.kt */
    public static final class Creator implements Parcelable.Creator<IslandCardSession> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IslandCardSession createFromParcel(Parcel r4) {
            o.e(r4, "parcel");
            return new IslandCardSession(r4.readInt(), r4.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandCardSession createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IslandCardSession[] newArray(int r1) {
            return new IslandCardSession[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandCardSession[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ IslandCardSession copy$default(IslandCardSession r0, int r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.flags;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.type;
    }

    public final long component2() {
        return this.flags;
    }

    public final IslandCardSession copy(int r1, long r2) {
        return new IslandCardSession(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, IslandCardSession.class) == true) goto L8;
        return false;
    L8:
        IslandCardSession r8 = (IslandCardSession) ZeusTransformUtils.preCheckCast(r7, IslandCardSession.class, "com.obric.aiagent.plugin");
        if (this.type == r8.type) goto L12;
        return false;
    L12:
        if (this.flags == r8.flags) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.type) * 31) + Long.hashCode(this.flags);
    }

    public String toString() {
        return "IslandCardSession(type=" + this.type + ", flags=" + this.flags + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeInt(this.type);
        r3.writeLong(this.flags);
    }

    public IslandCardSession(int r1, long r2) {
        this.type = r1;
        this.flags = r2;
    }

    public final int getType() {
        return this.type;
    }

    public final long getFlags() {
        return this.flags;
    }
}
