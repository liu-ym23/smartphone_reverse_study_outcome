package com.obric.appstore.network.entity;

import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u0006!"}, d2 = {"Lcom/obric/appstore/network/entity/CommonParams;", "", "app_id", "", "udid", "udid_type", "android_id", NetKey.MODEL, "app_version", CommonKey.KEY_OS_VERSION, "terminal", DownloadInfoColumns.APP_VERSION_CODE, "", "device_id", "androidver", "imei_1", "imei_2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAndroid_id", "()Ljava/lang/String;", "getAndroidver", "getApp_id", "getApp_version", "getApp_version_code", "()I", "getDevice_id", "getImei_1", "getImei_2", "getModel", "getOs_version", "getTerminal", "getUdid", "getUdid_type", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CommonParams {

    @SerializedName("android_id")
    @NotNull
    private final String android_id;

    @SerializedName("androidver")
    @Nullable
    private final String androidver;

    @SerializedName("app_id")
    @NotNull
    private final String app_id;

    @SerializedName("app_version")
    @NotNull
    private final String app_version;

    @SerializedName(DownloadInfoColumns.APP_VERSION_CODE)
    private final int app_version_code;

    @SerializedName("device_id")
    @Nullable
    private final String device_id;

    @SerializedName("imei_1")
    @Nullable
    private final String imei_1;

    @SerializedName("imei_2")
    @Nullable
    private final String imei_2;

    @SerializedName(NetKey.MODEL)
    @NotNull
    private final String model;

    @SerializedName(CommonKey.KEY_OS_VERSION)
    @NotNull
    private final String os_version;

    @SerializedName("terminal")
    @NotNull
    private final String terminal;

    @SerializedName("udid")
    @NotNull
    private final String udid;

    @SerializedName("udid_type")
    @NotNull
    private final String udid_type;

    public CommonParams(@NotNull String r10, @NotNull String r11, @NotNull String r12, @NotNull String r13, @NotNull String r14, @NotNull String r15, @NotNull String r16, @NotNull String r17, int r18, @Nullable String r19, @Nullable String r110, @Nullable String r111, @Nullable String r112) {
        q.g(r10, "app_id");
        q.g(r11, "udid");
        q.g(r12, "udid_type");
        q.g(r13, "android_id");
        q.g(r14, NetKey.MODEL);
        q.g(r15, "app_version");
        q.g(r16, CommonKey.KEY_OS_VERSION);
        q.g(r17, "terminal");
        this.app_id = r10;
        this.udid = r11;
        this.udid_type = r12;
        this.android_id = r13;
        this.model = r14;
        this.app_version = r15;
        this.os_version = r16;
        this.terminal = r17;
        this.app_version_code = r18;
        this.device_id = r19;
        this.androidver = r110;
        this.imei_1 = r111;
        this.imei_2 = r112;
    }

    @NotNull
    public final String getAndroid_id() {
        return this.android_id;
    }

    @Nullable
    public final String getAndroidver() {
        return this.androidver;
    }

    @NotNull
    public final String getApp_id() {
        return this.app_id;
    }

    @NotNull
    public final String getApp_version() {
        return this.app_version;
    }

    public final int getApp_version_code() {
        return this.app_version_code;
    }

    @Nullable
    public final String getDevice_id() {
        return this.device_id;
    }

    @Nullable
    public final String getImei_1() {
        return this.imei_1;
    }

    @Nullable
    public final String getImei_2() {
        return this.imei_2;
    }

    @NotNull
    public final String getModel() {
        return this.model;
    }

    @NotNull
    public final String getOs_version() {
        return this.os_version;
    }

    @NotNull
    public final String getTerminal() {
        return this.terminal;
    }

    @NotNull
    public final String getUdid() {
        return this.udid;
    }

    @NotNull
    public final String getUdid_type() {
        return this.udid_type;
    }
}
