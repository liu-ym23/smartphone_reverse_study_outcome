package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/model/objects/PackageUseCountInfo;", "Landroid/os/Parcelable;", "packageName", "", "isDebug", "", "sessionId", RuleConditionBean.VERSION_CODE_KEY, "", "scmVersion", "useCount", "", "<init>", "(Ljava/lang/String;ZLjava/lang/String;JLjava/lang/String;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPackageName", "()Ljava/lang/String;", "()Z", "getSessionId", "getVersionCode", "()J", "getScmVersion", "getUseCount", "()I", "writeToParcel", "", "flags", "describeContents", "CREATOR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PackageUseCountInfo implements Parcelable {
    public static final a CREATOR = null;
    private final boolean isDebug;
    private final String packageName;
    private final String scmVersion;
    private final String sessionId;
    private final int useCount;
    private final long versionCode;

    public static final class a implements Parcelable.Creator<PackageUseCountInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PackageUseCountInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new PackageUseCountInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final PackageUseCountInfo[] newArray(int r100) {
            return new PackageUseCountInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getScmVersion() {
        return this.scmVersion;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getUseCount() {
        return this.useCount;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public PackageUseCountInfo(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        String r100 = r110.readString();
        Intrinsics.checkNotNull(r100);
        if (r110.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        String r102 = r110.readString();
        if (r102 != null) goto L9;
        String r103 = "";
    L10:
        long r104 = r110.readLong();
        String r105 = r110.readString();
        if (r105 != null) goto L13;
        String r106 = "";
    L14:
        this(r100, r101, r103, r104, r106, r110.readInt());
        return;
    L13:
        r106 = r105;
        goto L14
    L9:
        r103 = r102;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.packageName);
        r100.writeByte(this.isDebug ? 1 : 0);
        r100.writeString(this.sessionId);
        r100.writeLong(this.versionCode);
        r100.writeString(this.scmVersion);
        r100.writeInt(this.useCount);
    }

    public PackageUseCountInfo(String r100, boolean r101, String r102, long r103, String r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        Intrinsics.checkNotNullParameter(r104, "scmVersion");
        this.packageName = r100;
        this.isDebug = r101;
        this.sessionId = r102;
        this.versionCode = r103;
        this.scmVersion = r104;
        this.useCount = r105;
    }
}
