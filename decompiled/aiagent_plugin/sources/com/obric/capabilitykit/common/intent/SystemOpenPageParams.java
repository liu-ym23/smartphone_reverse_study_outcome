package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SystemOpenPageParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemOpenPageParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemOpenPageParams> CREATOR = null;
    private String pageType;
    private String uri;

    /* JADX INFO: compiled from: SystemOpenPageParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemOpenPageParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemOpenPageParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            SystemOpenPageParams r1 = new SystemOpenPageParams(r5.readString(), r5.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r4 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r5, r4);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemOpenPageParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemOpenPageParams[] newArray(int r1) {
            return new SystemOpenPageParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemOpenPageParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemOpenPageParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemOpenPageParams copy$default(SystemOpenPageParams r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.pageType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.uri;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.pageType;
    }

    public final String component2() {
        return this.uri;
    }

    public final SystemOpenPageParams copy(String r1, String r2) {
        return new SystemOpenPageParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemOpenPageParams.class) == true) goto L8;
        return false;
    L8:
        SystemOpenPageParams r6 = (SystemOpenPageParams) ZeusTransformUtils.preCheckCast(r5, SystemOpenPageParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.pageType, r6.pageType) == true) goto L12;
        return false;
    L12:
        if (o.a(this.uri, r6.uri) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.pageType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.uri;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemOpenPageParams(pageType=" + this.pageType + ", uri=" + this.uri + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.pageType);
        r1.writeString(this.uri);
    }

    public SystemOpenPageParams(String r1, String r2) {
        this.pageType = r1;
        this.uri = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ SystemOpenPageParams(String r2, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final void setPageType(String r1) {
        this.pageType = r1;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void setUri(String r1) {
        this.uri = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SystemOpenPageParams.class) == false) goto L5;
        String r1 = this.pageType;
        if (r1 != null) goto L9;
        r1 = ((SystemOpenPageParams) ZeusTransformUtils.preCheckCast(r4, SystemOpenPageParams.class, "com.obric.aiagent.plugin")).pageType;
    L9:
        String r3 = this.uri;
        if (r3 != null) goto L13;
        r3 = ((SystemOpenPageParams) ZeusTransformUtils.preCheckCast(r4, SystemOpenPageParams.class, "com.obric.aiagent.plugin")).uri;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemOpenPageParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
