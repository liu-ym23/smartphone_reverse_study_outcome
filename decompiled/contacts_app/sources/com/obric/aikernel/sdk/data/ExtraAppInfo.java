package com.obric.aikernel.sdk.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExtraAppInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 02\u00020\u0001:\u00010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BQ\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rHÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003Je\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001J\b\u0010#\u001a\u00020$H\u0016J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0002J\b\u0010)\u001a\u00020$H\u0016J\u0006\u0010*\u001a\u00020+J\t\u0010,\u001a\u00020\u0006HÖ\u0001J\u0018\u0010-\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010/\u001a\u00020$H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u00061"}, d2 = {"Lcom/obric/aikernel/sdk/data/ExtraAppInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "aid", "", "appVersionName", "sdkVersion", "bridgeVersion", "foundationVersion", "vmVersion", "libsVersion", "", "extraInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getAid", "()Ljava/lang/String;", "getAppVersionName", "getBridgeVersion", "getExtraInfo", "getFoundationVersion", "getLibsVersion", "()Ljava/util/Map;", "getSdkVersion", "getVmVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toJSONObject", "Lorg/json/JSONObject;", "toString", "writeToParcel", "", "flags", "CREATOR", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExtraAppInfo implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final String aid;
    private final String appVersionName;
    private final String bridgeVersion;
    private final String extraInfo;
    private final String foundationVersion;
    private final Map<String, String> libsVersion;
    private final String sdkVersion;
    private final String vmVersion;

    /* JADX INFO: compiled from: ExtraAppInfo.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/sdk/data/ExtraAppInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/aikernel/sdk/data/ExtraAppInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "(I)[Lcom/obric/aikernel/sdk/data/ExtraAppInfo;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<ExtraAppInfo> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ExtraAppInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ExtraAppInfo[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExtraAppInfo createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ExtraAppInfo(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExtraAppInfo[] newArray(int r1) {
            return new ExtraAppInfo[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtraAppInfo copy$default(ExtraAppInfo r9, String r10, String r11, String r12, String r13, String r14, String r15, Map r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.aid;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.appVersionName;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.sdkVersion;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.bridgeVersion;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.foundationVersion;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.vmVersion;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Map r8 = r9.libsVersion;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.extraInfo;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.aid;
    }

    public final String component2() {
        return this.appVersionName;
    }

    public final String component3() {
        return this.sdkVersion;
    }

    public final String component4() {
        return this.bridgeVersion;
    }

    public final String component5() {
        return this.foundationVersion;
    }

    public final String component6() {
        return this.vmVersion;
    }

    public final Map<String, String> component7() {
        return this.libsVersion;
    }

    public final String component8() {
        return this.extraInfo;
    }

    public final ExtraAppInfo copy(String r11, String r12, String r13, String r14, String r15, String r16, Map<String, String> r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "aid");
        Intrinsics.checkNotNullParameter(r12, "appVersionName");
        Intrinsics.checkNotNullParameter(r13, "sdkVersion");
        Intrinsics.checkNotNullParameter(r14, "bridgeVersion");
        Intrinsics.checkNotNullParameter(r15, "foundationVersion");
        Intrinsics.checkNotNullParameter(r16, "vmVersion");
        Intrinsics.checkNotNullParameter(r17, "libsVersion");
        Intrinsics.checkNotNullParameter(r18, "extraInfo");
        return new ExtraAppInfo(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ExtraAppInfo(aid=" + this.aid + ", appVersionName=" + this.appVersionName + ", sdkVersion=" + this.sdkVersion + ", bridgeVersion=" + this.bridgeVersion + ", foundationVersion=" + this.foundationVersion + ", vmVersion=" + this.vmVersion + ", libsVersion=" + this.libsVersion + ", extraInfo=" + this.extraInfo + ')';
    }

    public ExtraAppInfo(String r2, String r3, String r4, String r5, String r6, String r7, Map<String, String> r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "aid");
        Intrinsics.checkNotNullParameter(r3, "appVersionName");
        Intrinsics.checkNotNullParameter(r4, "sdkVersion");
        Intrinsics.checkNotNullParameter(r5, "bridgeVersion");
        Intrinsics.checkNotNullParameter(r6, "foundationVersion");
        Intrinsics.checkNotNullParameter(r7, "vmVersion");
        Intrinsics.checkNotNullParameter(r8, "libsVersion");
        Intrinsics.checkNotNullParameter(r9, "extraInfo");
        this.aid = r2;
        this.appVersionName = r3;
        this.sdkVersion = r4;
        this.bridgeVersion = r5;
        this.foundationVersion = r6;
        this.vmVersion = r7;
        this.libsVersion = r8;
        this.extraInfo = r9;
    }

    public final String getAid() {
        return this.aid;
    }

    public final String getAppVersionName() {
        return this.appVersionName;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final String getBridgeVersion() {
        return this.bridgeVersion;
    }

    public final String getFoundationVersion() {
        return this.foundationVersion;
    }

    public final String getVmVersion() {
        return this.vmVersion;
    }

    public final Map<String, String> getLibsVersion() {
        return this.libsVersion;
    }

    public final String getExtraInfo() {
        return this.extraInfo;
    }

    public ExtraAppInfo(Parcel r14) {
        Intrinsics.checkNotNullParameter(r14, "parcel");
        String r0 = r14.readString();
        if (r0 != null) goto L5;
        String r3 = "";
    L6:
        String r1 = r14.readString();
        if (r1 != null) goto L9;
        String r4 = "";
    L10:
        String r2 = r14.readString();
        if (r2 != null) goto L13;
        String r5 = "";
    L14:
        String r6 = r14.readString();
        if (r6 != null) goto L17;
        String r7 = "";
    L18:
        String r8 = r14.readString();
        if (r8 != null) goto L21;
        String r9 = "";
    L22:
        String r10 = r14.readString();
        if (r10 != null) goto L25;
        String r11 = "";
    L26:
        Bundle r12 = r14.readBundle();
        if (r12 == null) goto L36;
        LinkedHashMap r13 = new LinkedHashMap();
        Set<String> r15 = r12.keySet();
        Intrinsics.checkNotNullExpressionValue(r15, "bundle.keySet()");
        Iterator<T> r16 = r15.iterator();
    L30:
        if (r16.hasNext() == false) goto L35;
        String r17 = (String) r16.next();
        Intrinsics.checkNotNullExpressionValue(r17, "key");
        String r18 = r12.getString(r17);
        if (r18 != null) goto L34;
        r18 = "";
    L34:
        Intrinsics.checkNotNullExpressionValue(r18, "bundle.getString(key) ?: \"\"");
        r13.put(r17, r18);
        goto L30
    L35:
        Map r19 = r13;
    L37:
        String r110 = r14.readString();
        if (r110 != null) goto L40;
        String r111 = "";
    L41:
        this(r3, r4, r5, r7, r9, r11, r19, r111);
        return;
    L40:
        r111 = r110;
        goto L41
    L36:
        r19 = MapsKt.emptyMap();
        goto L37
    L25:
        r11 = r10;
        goto L26
    L21:
        r9 = r8;
        goto L22
    L17:
        r7 = r6;
        goto L18
    L13:
        r5 = r2;
        goto L14
    L9:
        r4 = r1;
        goto L10
    L5:
        r3 = r0;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        r4.writeString(this.aid);
        r4.writeString(this.appVersionName);
        r4.writeString(this.sdkVersion);
        r4.writeString(this.bridgeVersion);
        r4.writeString(this.foundationVersion);
        r4.writeString(this.vmVersion);
        Bundle r6 = new Bundle();
        Iterator<Map.Entry<String, String>> r0 = this.libsVersion.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r0.next();
        r6.putString(r1.getKey(), r1.getValue());
        goto L4
    L6:
        r4.writeBundle(r6);
        r4.writeString(this.extraInfo);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        Class<?> r1 = getClass();
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.obric.aikernel.sdk.data.ExtraAppInfo");
        ExtraAppInfo r6 = (ExtraAppInfo) r5;
        if (Intrinsics.areEqual(this.aid, r6.aid) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.appVersionName, r6.appVersionName) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.sdkVersion, r6.sdkVersion) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bridgeVersion, r6.bridgeVersion) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.foundationVersion, r6.foundationVersion) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.vmVersion, r6.vmVersion) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.libsVersion, r6.libsVersion) == true) goto L33;
        return false;
    L33:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public int hashCode() {
        return (((((((((((this.aid.hashCode() * 31) + this.appVersionName.hashCode()) * 31) + this.sdkVersion.hashCode()) * 31) + this.bridgeVersion.hashCode()) * 31) + this.foundationVersion.hashCode()) * 31) + this.vmVersion.hashCode()) * 31) + this.libsVersion.hashCode();
    }

    public final JSONObject toJSONObject() {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r1 = this.libsVersion.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, String> r2 = r1.next();
        r0.put(r2.getKey(), r2.getValue());
        goto L4
    L6:
        JSONObject r4 = new JSONObject().put("aid", this.aid).put("app_version_name", this.appVersionName).put(WsConstants.KEY_SDK_VERSION, this.sdkVersion).put("bridge_version", this.bridgeVersion).put("foundation_version", this.foundationVersion).put("vm_version", this.vmVersion).put("libs_version", r0);
        Intrinsics.checkNotNullExpressionValue(r4, "JSONObject()\n           …(\"libs_version\", libsVer)");
        return r4;
    }
}
