package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaApp extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String appName;
    private final boolean installed;
    private final String packageName;

    public static final class CREATOR implements Parcelable.Creator<MetaApp> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaApp createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new MetaApp(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaApp createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaApp[] newArray(int r1) {
            return new MetaApp[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaApp[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaApp(Parcel r4) {
        o.e(r4, "parcel");
        this(EntityExtKt.a(r4), EntityExtKt.a(r4), r4.readBoolean());
        readMetaValueExtensionField$capabilitykitcommon_release(r4, 0, r4.readInt());
    }

    public MetaApp(String r2, String r3, boolean r4) {
        o.e(r2, "appName");
        o.e(r3, "packageName");
        super(10003);
        this.appName = r2;
        this.packageName = r3;
        this.installed = r4;
    }

    public /* synthetic */ MetaApp(String r1, String r2, boolean r3, int r4, h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }

    public static /* synthetic */ MetaApp copy$default(MetaApp r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.appName;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.packageName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.installed;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.appName;
    }

    public final String component2() {
        return this.packageName;
    }

    public final boolean component3() {
        return this.installed;
    }

    public final MetaApp copy(String r1, String r2, boolean r3) {
        o.e(r1, "appName");
        o.e(r2, "packageName");
        return new MetaApp(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MetaApp.class) == true) goto L8;
        return false;
    L8:
        MetaApp r6 = (MetaApp) ZeusTransformUtils.preCheckCast(r5, MetaApp.class, "com.obric.aiagent.plugin");
        if (o.a(this.appName, r6.appName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.packageName, r6.packageName) == true) goto L15;
        return false;
    L15:
        if (this.installed == r6.installed) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final boolean getInstalled() {
        return this.installed;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r0 = ((this.appName.hashCode() * 31) + this.packageName.hashCode()) * 31;
        boolean r2 = this.installed;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r0 + r3;
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaApp(appName=" + this.appName + ", packageName=" + this.packageName + ", installed=" + this.installed + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.appName);
        r1.writeString(this.packageName);
        r1.writeBoolean(this.installed);
        r1.writeInt(0);
    }
}
