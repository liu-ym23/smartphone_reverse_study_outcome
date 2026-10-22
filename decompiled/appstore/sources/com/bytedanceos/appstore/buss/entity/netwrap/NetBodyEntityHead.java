package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003Js\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000f¨\u0006."}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/NetBodyEntityHead;", "", "app_id", "", "udid", "udid_type", "ticket", "device_id", "uid", "android_id", "access_token", CommonKey.KEY_OS_VERSION, "local_language", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccess_token", "()Ljava/lang/String;", "setAccess_token", "(Ljava/lang/String;)V", "getAndroid_id", "getApp_id", "getDevice_id", "getLocal_language", "setLocal_language", "getOs_version", "getTicket", "setTicket", "getUdid", "getUdid_type", "getUid", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NetBodyEntityHead {

    @Nullable
    private String access_token;

    @NotNull
    private final String android_id;

    @NotNull
    private final String app_id;

    @NotNull
    private final String device_id;

    @Nullable
    private String local_language;

    @NotNull
    private final String os_version;

    @Nullable
    private String ticket;

    @NotNull
    private final String udid;

    @NotNull
    private final String udid_type;

    @NotNull
    private final String uid;

    public NetBodyEntityHead(@NotNull String r10, @NotNull String r11, @NotNull String r12, @Nullable String r13, @NotNull String r14, @NotNull String r15, @NotNull String r16, @Nullable String r17, @NotNull String r18, @Nullable String r19) {
        q.g(r10, "app_id");
        q.g(r11, "udid");
        q.g(r12, "udid_type");
        q.g(r14, "device_id");
        q.g(r15, "uid");
        q.g(r16, "android_id");
        q.g(r18, CommonKey.KEY_OS_VERSION);
        this.app_id = r10;
        this.udid = r11;
        this.udid_type = r12;
        this.ticket = r13;
        this.device_id = r14;
        this.uid = r15;
        this.android_id = r16;
        this.access_token = r17;
        this.os_version = r18;
        this.local_language = r19;
    }

    public static /* synthetic */ NetBodyEntityHead copy$default(NetBodyEntityHead r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r10 = r11.app_id;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r24 = r11.udid;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r25 = r11.udid_type;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r26 = r11.ticket;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r27 = r11.device_id;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r28 = r11.uid;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r29 = r11.android_id;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r30 = r11.access_token;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r110 = r11.os_version;
    L39:
        if ((r22 & 512) == 0) goto L41;
        String r31 = r11.local_language;
    L43:
        return r11.copy(r10, r24, r25, r26, r27, r28, r29, r30, r110, r31);
    L41:
        r31 = r21;
        goto L43
    L37:
        r110 = r20;
        goto L39
    L33:
        r30 = r19;
        goto L35
    L29:
        r29 = r18;
        goto L31
    L25:
        r28 = r17;
        goto L27
    L21:
        r27 = r16;
        goto L23
    L17:
        r26 = r15;
        goto L19
    L13:
        r25 = r14;
        goto L15
    L9:
        r24 = r13;
        goto L11
    L5:
        r10 = r12;
        goto L7
    }

    @NotNull
    public final String component1() {
        return this.app_id;
    }

    @Nullable
    public final String component10() {
        return this.local_language;
    }

    @NotNull
    public final String component2() {
        return this.udid;
    }

    @NotNull
    public final String component3() {
        return this.udid_type;
    }

    @Nullable
    public final String component4() {
        return this.ticket;
    }

    @NotNull
    public final String component5() {
        return this.device_id;
    }

    @NotNull
    public final String component6() {
        return this.uid;
    }

    @NotNull
    public final String component7() {
        return this.android_id;
    }

    @Nullable
    public final String component8() {
        return this.access_token;
    }

    @NotNull
    public final String component9() {
        return this.os_version;
    }

    @NotNull
    public final NetBodyEntityHead copy(@NotNull String r13, @NotNull String r14, @NotNull String r15, @Nullable String r16, @NotNull String r17, @NotNull String r18, @NotNull String r19, @Nullable String r20, @NotNull String r21, @Nullable String r22) {
        q.g(r13, "app_id");
        q.g(r14, "udid");
        q.g(r15, "udid_type");
        q.g(r17, "device_id");
        q.g(r18, "uid");
        q.g(r19, "android_id");
        q.g(r21, CommonKey.KEY_OS_VERSION);
        return new NetBodyEntityHead(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof NetBodyEntityHead) == true) goto L8;
        return false;
    L8:
        NetBodyEntityHead r11 = (NetBodyEntityHead) r10;
        if (q.b(this.app_id, r11.app_id) == true) goto L12;
        return false;
    L12:
        if (q.b(this.udid, r11.udid) == true) goto L15;
        return false;
    L15:
        if (q.b(this.udid_type, r11.udid_type) == true) goto L18;
        return false;
    L18:
        if (q.b(this.ticket, r11.ticket) == true) goto L21;
        return false;
    L21:
        if (q.b(this.device_id, r11.device_id) == true) goto L24;
        return false;
    L24:
        if (q.b(this.uid, r11.uid) == true) goto L27;
        return false;
    L27:
        if (q.b(this.android_id, r11.android_id) == true) goto L30;
        return false;
    L30:
        if (q.b(this.access_token, r11.access_token) == true) goto L33;
        return false;
    L33:
        if (q.b(this.os_version, r11.os_version) == true) goto L36;
        return false;
    L36:
        if (q.b(this.local_language, r11.local_language) == true) goto L38;
        return false;
    L38:
        return true;
    }

    @Nullable
    public final String getAccess_token() {
        return this.access_token;
    }

    @NotNull
    public final String getAndroid_id() {
        return this.android_id;
    }

    @NotNull
    public final String getApp_id() {
        return this.app_id;
    }

    @NotNull
    public final String getDevice_id() {
        return this.device_id;
    }

    @Nullable
    public final String getLocal_language() {
        return this.local_language;
    }

    @NotNull
    public final String getOs_version() {
        return this.os_version;
    }

    @Nullable
    public final String getTicket() {
        return this.ticket;
    }

    @NotNull
    public final String getUdid() {
        return this.udid;
    }

    @NotNull
    public final String getUdid_type() {
        return this.udid_type;
    }

    @NotNull
    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        int r10 = ((((this.app_id.hashCode() * 31) + this.udid.hashCode()) * 31) + this.udid_type.hashCode()) * 31;
        String r11 = this.ticket;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (((((((r10 + r13) * 31) + this.device_id.hashCode()) * 31) + this.uid.hashCode()) * 31) + this.android_id.hashCode()) * 31;
        String r15 = this.access_token;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (((r14 + r16) * 31) + this.os_version.hashCode()) * 31;
        String r18 = this.local_language;
        if (r18 == null) goto L15;
        r12 = r18.hashCode();
    L15:
        return r17 + r12;
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final void setAccess_token(@Nullable String r10) {
        this.access_token = r10;
    }

    public final void setLocal_language(@Nullable String r10) {
        this.local_language = r10;
    }

    public final void setTicket(@Nullable String r10) {
        this.ticket = r10;
    }

    @NotNull
    public String toString() {
        return "NetBodyEntityHead(app_id=" + this.app_id + ", udid=" + this.udid + ", udid_type=" + this.udid_type + ", ticket=" + this.ticket + ", device_id=" + this.device_id + ", uid=" + this.uid + ", android_id=" + this.android_id + ", access_token=" + this.access_token + ", os_version=" + this.os_version + ", local_language=" + this.local_language + ')';
    }

    public /* synthetic */ NetBodyEntityHead(String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 8) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r25 & 128) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r25 & 512) == 0) goto L13;
        String r13 = null;
    L14:
        this(r15, r16, r17, r10, r19, r20, r21, r11, r23, r13);
        return;
    L13:
        r13 = r24;
        goto L14
    L9:
        r11 = r22;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }
}
