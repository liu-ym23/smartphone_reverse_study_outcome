package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: loaded from: classes3.dex */
public final class AppIntentImplInfo implements Parcelable {
    public static final Parcelable.Creator<AppIntentImplInfo> CREATOR = null;
    private final String implClassName;
    private final String packageName;

    public static final class a implements Parcelable.Creator<AppIntentImplInfo> {
        public a() {
        }

        public final AppIntentImplInfo a(Parcel r5) {
            int r4 = r5.readInt();
            o.e(r5, "parcel");
            AppIntentImplInfo r0 = new AppIntentImplInfo(r5.readString(), r5.readString());
            int r1 = Math.min(r4, 0);
            ClassLoader r2 = a.class.getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r1) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r4) goto L7;
            com.obric.a.a.a(r5, r2);
            r3 = r3 + 1;
            goto L5
        L7:
            return r0;
        }

        public final AppIntentImplInfo[] a(int r1) {
            return new AppIntentImplInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AppIntentImplInfo createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AppIntentImplInfo[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public AppIntentImplInfo(String r2, String r3) {
        o.e(r2, "packageName");
        o.e(r3, "implClassName");
        this.packageName = r2;
        this.implClassName = r3;
    }

    public static /* synthetic */ AppIntentImplInfo copy$default(AppIntentImplInfo r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.packageName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.implClassName;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.implClassName;
    }

    public final AppIntentImplInfo copy(String r1, String r2) {
        o.e(r1, "packageName");
        o.e(r2, "implClassName");
        return new AppIntentImplInfo(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppIntentImplInfo.class) == true) goto L8;
        return false;
    L8:
        AppIntentImplInfo r6 = (AppIntentImplInfo) ZeusTransformUtils.preCheckCast(r5, AppIntentImplInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.packageName, r6.packageName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.implClassName, r6.implClassName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getImplClassName() {
        return this.implClassName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (this.packageName.hashCode() * 31) + this.implClassName.hashCode();
    }

    public String toString() {
        return "AppIntentImplInfo(packageName=" + this.packageName + ", implClassName=" + this.implClassName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.packageName);
        r1.writeString(this.implClassName);
    }
}
