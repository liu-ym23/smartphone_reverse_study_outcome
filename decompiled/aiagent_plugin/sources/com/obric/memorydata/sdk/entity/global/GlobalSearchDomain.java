package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: GlobalAssistantSearchResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GlobalSearchDomain implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final String name;

    /* JADX INFO: compiled from: GlobalAssistantSearchResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<GlobalSearchDomain> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalSearchDomain createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalSearchDomain[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalSearchDomain createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new GlobalSearchDomain(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalSearchDomain[] newArray(int r1) {
            return new GlobalSearchDomain[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ GlobalSearchDomain copy$default(GlobalSearchDomain r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.name;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.name;
    }

    public final GlobalSearchDomain copy(String r1) {
        o.e(r1, "name");
        return new GlobalSearchDomain(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalSearchDomain.class) == true) goto L8;
        return false;
    L8:
        GlobalSearchDomain r6 = (GlobalSearchDomain) ZeusTransformUtils.preCheckCast(r5, GlobalSearchDomain.class, "com.obric.aiagent.plugin");
        if (o.a(this.name, r6.name) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "GlobalSearchDomain(name=" + this.name + ')';
    }

    public GlobalSearchDomain(String r2) {
        o.e(r2, "name");
        this.name = r2;
    }

    public final String getName() {
        return this.name;
    }

    public GlobalSearchDomain(Parcel r2) {
        o.e(r2, "parcel");
        String r3 = r2.readString();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        this(r3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.name);
    }
}
