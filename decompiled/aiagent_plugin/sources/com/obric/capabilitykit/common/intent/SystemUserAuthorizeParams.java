package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SystemUserAuthorizeParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemUserAuthorizeParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemUserAuthorizeParams> CREATOR = null;
    String scene;

    /* JADX INFO: compiled from: SystemUserAuthorizeParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemUserAuthorizeParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        public final SystemUserAuthorizeParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            o.e(r9, "parcel");
            SystemUserAuthorizeParams r1 = new SystemUserAuthorizeParams(null, 1, 0 == true ? 1 : 0);
            int r2 = Math.min(r0, 1);
            ClassLoader r8 = getClass().getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r2) goto L9;
            if (r4 != 1) goto L8;
            Object r5 = a.b(r9, r8);
            if (r5 == null) goto L8;
            r1.scene = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        L8:
            r4 = r4 + 1;
        L9:
            if (r4 > r0) goto L11;
            a.a(r9, r8);
            r4 = r4 + 1;
            goto L9
        L11:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserAuthorizeParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserAuthorizeParams[] newArray(int r1) {
            return new SystemUserAuthorizeParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserAuthorizeParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemUserAuthorizeParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemUserAuthorizeParams copy$default(SystemUserAuthorizeParams r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.scene;
    L6:
        return r0.copy(r1);
    }

    public static /* synthetic */ void getScene$annotations() {
    }

    public final String component1() {
        return this.scene;
    }

    public final SystemUserAuthorizeParams copy(String r1) {
        return new SystemUserAuthorizeParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemUserAuthorizeParams.class) == true) goto L8;
        return false;
    L8:
        SystemUserAuthorizeParams r6 = (SystemUserAuthorizeParams) ZeusTransformUtils.preCheckCast(r5, SystemUserAuthorizeParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.scene, r6.scene) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.scene;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "SystemUserAuthorizeParams(scene=" + this.scene + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(1);
        o.e(r1, "out");
        r1.writeValue(this.scene);
    }

    public SystemUserAuthorizeParams(String r1) {
        this.scene = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ SystemUserAuthorizeParams(String r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setScene(String r1) {
        this.scene = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SystemUserAuthorizeParams.class) == false) goto L5;
        String r3 = this.scene;
        if (r3 != null) goto L10;
        r3 = ((SystemUserAuthorizeParams) ZeusTransformUtils.preCheckCast(r4, SystemUserAuthorizeParams.class, "com.obric.aiagent.plugin")).scene;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemUserAuthorizeParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        String r0 = this.scene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }
}
