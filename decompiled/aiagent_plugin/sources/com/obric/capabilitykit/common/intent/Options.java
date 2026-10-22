package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Params.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Options implements Parcelable {
    public static final Parcelable.Creator<Options> CREATOR = null;
    private final String action;
    private final String text;
    private final String uiType;

    /* JADX INFO: compiled from: Params.kt */
    public static final class Creator implements Parcelable.Creator<Options> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Options createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
            Options r1 = new Options(r6.readString(), r6.readString(), r6.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r5 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r6, r5);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Options createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Options[] newArray(int r1) {
            return new Options[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Options[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ Options copy$default(Options r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.action;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.text;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.uiType;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.uiType;
    }

    public final Options copy(String r1, String r2, String r3) {
        return new Options(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Options.class) == true) goto L8;
        return false;
    L8:
        Options r6 = (Options) ZeusTransformUtils.preCheckCast(r5, Options.class, "com.obric.aiagent.plugin");
        if (o.a(this.action, r6.action) == true) goto L12;
        return false;
    L12:
        if (o.a(this.text, r6.text) == true) goto L15;
        return false;
    L15:
        if (o.a(this.uiType, r6.uiType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.action;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.text;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.uiType;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Options(action=" + this.action + ", text=" + this.text + ", uiType=" + this.uiType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.action);
        r1.writeString(this.text);
        r1.writeString(this.uiType);
    }

    public Options(String r1, String r2, String r3) {
        this.action = r1;
        this.text = r2;
        this.uiType = r3;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getText() {
        return this.text;
    }

    public final String getUiType() {
        return this.uiType;
    }
}
