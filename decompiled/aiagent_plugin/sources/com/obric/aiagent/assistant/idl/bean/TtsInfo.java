package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TtsInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TtsInfo implements Parcelable {
    public static final Parcelable.Creator<TtsInfo> CREATOR = null;
    private final String messageId;
    private final Integer playStateEnum;

    /* JADX INFO: compiled from: TtsInfo.kt */
    public static final class Creator implements Parcelable.Creator<TtsInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TtsInfo createFromParcel(Parcel r3) {
            o.e(r3, "parcel");
            String r0 = r3.readString();
            if (r3.readInt() != 0) goto L5;
            Integer r4 = null;
        L7:
            return new TtsInfo(r0, r4);
        L5:
            r4 = Integer.valueOf(r3.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TtsInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TtsInfo[] newArray(int r1) {
            return new TtsInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TtsInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TtsInfo() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TtsInfo copy$default(TtsInfo r0, String r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.messageId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.playStateEnum;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.messageId;
    }

    public final Integer component2() {
        return this.playStateEnum;
    }

    public final TtsInfo copy(String r1, Integer r2) {
        return new TtsInfo(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TtsInfo.class) == true) goto L8;
        return false;
    L8:
        TtsInfo r6 = (TtsInfo) ZeusTransformUtils.preCheckCast(r5, TtsInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.messageId, r6.messageId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.playStateEnum, r6.playStateEnum) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.messageId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.playStateEnum;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TtsInfo(messageId=" + this.messageId + ", playStateEnum=" + this.playStateEnum + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.messageId);
        Integer r0 = this.playStateEnum;
        if (r0 != null) goto L5;
        int r3 = 0;
    L6:
        r1.writeInt(r3);
        return;
    L5:
        r1.writeInt(1);
        r3 = r0.intValue();
        goto L6
    }

    public TtsInfo(String r1, Integer r2) {
        this.messageId = r1;
        this.playStateEnum = r2;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public /* synthetic */ TtsInfo(String r1, Integer r2, int r3, h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2);
    }

    public final Integer getPlayStateEnum() {
        return this.playStateEnum;
    }
}
