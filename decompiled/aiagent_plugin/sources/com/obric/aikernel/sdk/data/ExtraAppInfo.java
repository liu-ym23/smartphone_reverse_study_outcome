package com.obric.aikernel.sdk.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExtraAppInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
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
    public static final class CREATOR implements Parcelable.Creator<ExtraAppInfo> {
        public /* synthetic */ CREATOR(h r1) {
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
            o.e(r1, "parcel");
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

    public static /* synthetic */ ExtraAppInfo copy$default(ExtraAppInfo r10, String r11, String r12, String r13, String r14, String r15, String r16, Map r17, String r18, int r19, Object r20) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        if ((r19 & 1) == 0) goto L5;
        String r3 = r10.aid;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r4 = r10.appVersionName;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r5 = r10.sdkVersion;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r6 = r10.bridgeVersion;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r7 = r10.foundationVersion;
    L23:
        if ((r19 & 32) == 0) goto L25;
        String r8 = r10.vmVersion;
    L27:
        if ((r19 & 64) == 0) goto L30;
        r2 = r10.libsVersion;
    L30:
        if ((r19 & 128) == 0) goto L32;
        String r1 = r10.extraInfo;
    L34:
        return r10.copy(r3, r4, r5, r6, r7, r8, r2, r1);
    L32:
        r1 = r18;
        goto L34
    L25:
        r8 = r16;
        goto L27
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
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
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        o.e(r11, WsConstants.KEY_APP_ID);
        o.e(r12, "appVersionName");
        o.e(r13, "sdkVersion");
        o.e(r14, "bridgeVersion");
        o.e(r15, "foundationVersion");
        o.e(r16, "vmVersion");
        o.e(r8, "libsVersion");
        o.e(r18, "extraInfo");
        return new ExtraAppInfo(r11, r12, r13, r14, r15, r16, r8, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ExtraAppInfo(aid=" + this.aid + ", appVersionName=" + this.appVersionName + ", sdkVersion=" + this.sdkVersion + ", bridgeVersion=" + this.bridgeVersion + ", foundationVersion=" + this.foundationVersion + ", vmVersion=" + this.vmVersion + ", libsVersion=" + this.libsVersion + ", extraInfo=" + this.extraInfo + ')';
    }

    public ExtraAppInfo(String r3, String r4, String r5, String r6, String r7, String r8, Map<String, String> r9, String r10) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, WsConstants.KEY_APP_ID);
        o.e(r4, "appVersionName");
        o.e(r5, "sdkVersion");
        o.e(r6, "bridgeVersion");
        o.e(r7, "foundationVersion");
        o.e(r8, "vmVersion");
        o.e(r11, "libsVersion");
        o.e(r10, "extraInfo");
        this.aid = r3;
        this.appVersionName = r4;
        this.sdkVersion = r5;
        this.bridgeVersion = r6;
        this.foundationVersion = r7;
        this.vmVersion = r8;
        this.libsVersion = r11;
        this.extraInfo = r10;
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

    public ExtraAppInfo(Parcel r15) {
        o.e(r15, "parcel");
        String r0 = r15.readString();
        if (r0 != null) goto L5;
        String r3 = "";
    L6:
        String r1 = r15.readString();
        if (r1 != null) goto L9;
        String r4 = "";
    L10:
        String r2 = r15.readString();
        if (r2 != null) goto L13;
        String r5 = "";
    L14:
        String r6 = r15.readString();
        if (r6 != null) goto L17;
        String r7 = "";
    L18:
        String r8 = r15.readString();
        if (r8 != null) goto L21;
        String r9 = "";
    L22:
        String r10 = r15.readString();
        if (r10 != null) goto L25;
        String r11 = "";
    L26:
        Bundle r12 = r15.readBundle();
        if (r12 == null) goto L36;
        Map r13 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Set<String> r14 = r12.keySet();
        o.c(r14, "bundle.keySet()");
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L30:
        if (r16.hasNext() == false) goto L35;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin");
        o.c(r17, "key");
        String r18 = r12.getString(r17);
        if (r18 != null) goto L34;
        r18 = "";
    L34:
        o.c(r18, "bundle.getString(key) ?: \"\"");
        r13.put(r17, r18);
        goto L30
    L35:
        Map r19 = r13;
    L37:
        String r110 = r15.readString();
        if (r110 != null) goto L40;
        String r111 = "";
    L41:
        this(r3, r4, r5, r7, r9, r11, r19, r111);
        return;
    L40:
        r111 = r110;
        goto L41
    L36:
        r19 = ao.b();
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
    public void writeToParcel(Parcel r6, int r7) {
        o.e(r6, "parcel");
        r6.writeString(this.aid);
        r6.writeString(this.appVersionName);
        r6.writeString(this.sdkVersion);
        r6.writeString(this.bridgeVersion);
        r6.writeString(this.foundationVersion);
        r6.writeString(this.vmVersion);
        Bundle r8 = new Bundle();
        Iterator<Map.Entry<String, String>> r0 = this.libsVersion.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8.putString((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        r6.writeBundle(r8);
        r6.writeString(this.extraInfo);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 == null) goto L8;
        Class<?> r3 = r7.getClass();
    L10:
        if (o.a(r2, r3) == true) goto L12;
        return false;
    L12:
        o.a(r7, "null cannot be cast to non-null type com.obric.aikernel.sdk.data.ExtraAppInfo");
        ExtraAppInfo r4 = (ExtraAppInfo) ZeusTransformUtils.preCheckCast(r7, ExtraAppInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.aid, ((ExtraAppInfo) ZeusTransformUtils.preCheckCast(r7, ExtraAppInfo.class, "com.obric.aiagent.plugin")).aid) == true) goto L16;
        return false;
    L16:
        if (o.a(this.appVersionName, ((ExtraAppInfo) ZeusTransformUtils.preCheckCast(r7, ExtraAppInfo.class, "com.obric.aiagent.plugin")).appVersionName) == true) goto L19;
        return false;
    L19:
        if (o.a(this.sdkVersion, ((ExtraAppInfo) ZeusTransformUtils.preCheckCast(r7, ExtraAppInfo.class, "com.obric.aiagent.plugin")).sdkVersion) == true) goto L22;
        return false;
    L22:
        if (o.a(this.bridgeVersion, ((ExtraAppInfo) ZeusTransformUtils.preCheckCast(r7, ExtraAppInfo.class, "com.obric.aiagent.plugin")).bridgeVersion) == true) goto L25;
        return false;
    L25:
        if (o.a(this.foundationVersion, ((ExtraAppInfo) ZeusTransformUtils.preCheckCast(r7, ExtraAppInfo.class, "com.obric.aiagent.plugin")).foundationVersion) == true) goto L28;
        return false;
    L28:
        if (o.a(this.vmVersion, ((ExtraAppInfo) ZeusTransformUtils.preCheckCast(r7, ExtraAppInfo.class, "com.obric.aiagent.plugin")).vmVersion) == true) goto L31;
        return false;
    L31:
        if (o.a(this.libsVersion, ((ExtraAppInfo) ZeusTransformUtils.preCheckCast(r7, ExtraAppInfo.class, "com.obric.aiagent.plugin")).libsVersion) == true) goto L33;
        return false;
    L33:
        return true;
    L8:
        r3 = null;
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
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        JSONObject r6 = new JSONObject().put(WsConstants.KEY_APP_ID, this.aid).put("app_version_name", this.appVersionName).put("sdk_version", this.sdkVersion).put("bridge_version", this.bridgeVersion).put("foundation_version", this.foundationVersion).put("vm_version", this.vmVersion).put("libs_version", r0);
        o.c(r6, "JSONObject()\n           …(\"libs_version\", libsVer)");
        return r6;
    }
}
