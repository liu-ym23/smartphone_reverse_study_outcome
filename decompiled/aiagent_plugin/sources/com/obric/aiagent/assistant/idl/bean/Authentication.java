package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: Authentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Authentication implements Parcelable {
    public static final Parcelable.Creator<Authentication> CREATOR = null;
    private final boolean isPass;
    private final Integer type;

    /* JADX INFO: compiled from: Authentication.kt */
    public static final class Creator implements Parcelable.Creator<Authentication> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Authentication createFromParcel(Parcel r3) {
            o.e(r3, "parcel");
            if (r3.readInt() == 0) goto L5;
            boolean r0 = true;
        L7:
            if (r3.readInt() != 0) goto L9;
            Integer r4 = null;
        L11:
            return new Authentication(r0, r4);
        L9:
            r4 = Integer.valueOf(r3.readInt());
            goto L11
        L5:
            r0 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Authentication createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Authentication[] newArray(int r1) {
            return new Authentication[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Authentication[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ Authentication copy$default(Authentication r0, boolean r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.isPass;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.isPass;
    }

    public final Integer component2() {
        return this.type;
    }

    public final Authentication copy(boolean r1, Integer r2) {
        return new Authentication(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Authentication.class) == true) goto L8;
        return false;
    L8:
        Authentication r6 = (Authentication) ZeusTransformUtils.preCheckCast(r5, Authentication.class, "com.obric.aiagent.plugin");
        if (this.isPass == r6.isPass) goto L12;
        return false;
    L12:
        if (o.a(this.type, r6.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.isPass) * 31;
        Integer r1 = this.type;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "Authentication(isPass=" + this.isPass + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeInt(this.isPass ? 1 : 0);
        Integer r0 = this.type;
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

    public Authentication(boolean r1, Integer r2) {
        this.isPass = r1;
        this.type = r2;
    }

    public final boolean isPass() {
        return this.isPass;
    }

    public /* synthetic */ Authentication(boolean r1, Integer r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        this(r1, r2);
    }

    public final Integer getType() {
        return this.type;
    }
}
