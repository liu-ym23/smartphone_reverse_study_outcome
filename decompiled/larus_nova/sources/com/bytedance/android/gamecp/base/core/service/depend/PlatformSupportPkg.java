package com.bytedance.android.gamecp.base.core.service.depend;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.PlatformSupportPkg")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013Jx\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001a¨\u00060"}, d2 = {"Lcom/bytedance/android/gamecp/base/core/service/depend/PlatformSupportPkg;", "Ljava/io/Serializable;", "name", "", "type", "", "supportOpen", "", "priority", "supportCallback", "openGameUrl", "clickIdNature", "forceTransferGameUser", "userHasPkgAccount", "userPkgAccountTransferred", "(Ljava/lang/String;IZIZLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Z)V", "getClickIdNature", "()Ljava/lang/String;", "getForceTransferGameUser", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getOpenGameUrl", "getPriority", "()I", "getSupportCallback", "()Z", "getSupportOpen", "getType", "getUserHasPkgAccount", "getUserPkgAccountTransferred", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;IZIZLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Z)Lcom/bytedance/android/gamecp/base/core/service/depend/PlatformSupportPkg;", "equals", "other", "", "hashCode", "toString", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformSupportPkg implements Serializable, vh7.h {

    @SerializedName(EventConstants.ExtraJson.KEY_DOWNLOAD_CLICK_ID_NATURE)
    protected String clickIdNature;

    @SerializedName("force_transfer_game_user")
    protected Boolean forceTransferGameUser;

    @SerializedName("name")
    protected String name;

    @SerializedName("open_game_url")
    protected String openGameUrl;

    @SerializedName("open_priority")
    protected int priority;

    @SerializedName("support_callback")
    protected boolean supportCallback;

    @SerializedName("support_open")
    protected boolean supportOpen;

    @SerializedName("pkg_type")
    protected int type;

    @SerializedName("user_has_pkg_account")
    protected Boolean userHasPkgAccount;

    @SerializedName("user_pkg_account_transferred")
    protected boolean userPkgAccountTransferred;

    public PlatformSupportPkg(String r100, int r101, boolean r102, int r103, boolean r104, String r105, String r106, Boolean r107, Boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r105, "openGameUrl");
        Intrinsics.checkNotNullParameter(r106, "clickIdNature");
        this.name = r100;
        this.type = r101;
        this.supportOpen = r102;
        this.priority = r103;
        this.supportCallback = r104;
        this.openGameUrl = r105;
        this.clickIdNature = r106;
        this.forceTransferGameUser = r107;
        this.userHasPkgAccount = r110;
        this.userPkgAccountTransferred = r111;
    }

    public static /* synthetic */ PlatformSupportPkg copy$default(PlatformSupportPkg r110, String r111, int r112, boolean r113, int r114, boolean r115, String r116, String r117, Boolean r118, Boolean r210, boolean r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.name;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = r110.type;
    L11:
        if ((r212 & 4) == 0) goto L13;
        boolean r102 = r110.supportOpen;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r103 = r110.priority;
    L19:
        if ((r212 & 16) == 0) goto L21;
        boolean r104 = r110.supportCallback;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.openGameUrl;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.clickIdNature;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Boolean r107 = r110.forceTransferGameUser;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Boolean r119 = r110.userHasPkgAccount;
    L39:
        if ((r212 & 512) == 0) goto L41;
        boolean r108 = r110.userPkgAccountTransferred;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final boolean component10() {
        return this.userPkgAccountTransferred;
    }

    public final int component2() {
        return this.type;
    }

    public final boolean component3() {
        return this.supportOpen;
    }

    public final int component4() {
        return this.priority;
    }

    public final boolean component5() {
        return this.supportCallback;
    }

    public final String component6() {
        return this.openGameUrl;
    }

    public final String component7() {
        return this.clickIdNature;
    }

    public final Boolean component8() {
        return this.forceTransferGameUser;
    }

    public final Boolean component9() {
        return this.userHasPkgAccount;
    }

    public final PlatformSupportPkg copy(String r110, int r111, boolean r112, int r113, boolean r114, String r115, String r116, Boolean r210, Boolean r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r115, "openGameUrl");
        Intrinsics.checkNotNullParameter(r116, "clickIdNature");
        return new PlatformSupportPkg(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlatformSupportPkg) == false) goto L26;
        PlatformSupportPkg r101 = (PlatformSupportPkg) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (this.type == r101.type) goto L10;
        return false;
    L10:
        if (this.supportOpen == r101.supportOpen) goto L12;
        return false;
    L12:
        if (this.priority == r101.priority) goto L14;
        return false;
    L14:
        if (this.supportCallback == r101.supportCallback) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.openGameUrl, r101.openGameUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.clickIdNature, r101.clickIdNature) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.forceTransferGameUser, r101.forceTransferGameUser) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.userHasPkgAccount, r101.userHasPkgAccount) == true) goto L24;
        return false;
    L24:
        if (this.userPkgAccountTransferred == r101.userPkgAccountTransferred) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.type) * 31;
        boolean r104 = this.supportOpen;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (((r103 + r106) * 31) + this.priority) * 31;
        boolean r108 = this.supportCallback;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (r107 + r109) * 31;
        String r111 = this.openGameUrl;
        if (r111 == null) goto L15;
        int r112 = r111.hashCode();
    L16:
        int r113 = (r110 + r112) * 31;
        String r114 = this.clickIdNature;
        if (r114 == null) goto L19;
        int r115 = r114.hashCode();
    L20:
        int r116 = (r113 + r115) * 31;
        Boolean r117 = this.forceTransferGameUser;
        if (r117 == null) goto L23;
        int r118 = r117.hashCode();
    L24:
        int r119 = (r116 + r118) * 31;
        Boolean r120 = this.userHasPkgAccount;
        if (r120 == null) goto L27;
        r101 = r120.hashCode();
    L27:
        int r121 = (r119 + r101) * 31;
        boolean r122 = this.userPkgAccountTransferred;
        if (r122 == true) goto L32;
        r105 = r122;
    L32:
        return r121 + r105;
    L23:
        r118 = 0;
        goto L24
    L19:
        r115 = 0;
        goto L20
    L15:
        r112 = 0;
        goto L16
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PlatformSupportPkg(name=" + this.name + ", type=" + this.type + ", supportOpen=" + this.supportOpen + ", priority=" + this.priority + ", supportCallback=" + this.supportCallback + ", openGameUrl=" + this.openGameUrl + ", clickIdNature=" + this.clickIdNature + ", forceTransferGameUser=" + this.forceTransferGameUser + ", userHasPkgAccount=" + this.userHasPkgAccount + ", userPkgAccountTransferred=" + this.userPkgAccountTransferred + ")";
    }

    public PlatformSupportPkg() {
        this.name = null;
        this.type = 0;
        this.supportOpen = true;
        this.priority = 0;
        this.supportCallback = true;
        this.openGameUrl = "";
        this.clickIdNature = "";
        this.forceTransferGameUser = null;
        this.userHasPkgAccount = null;
        this.userPkgAccountTransferred = false;
    }

    public final String getClickIdNature() {
        return this.clickIdNature;
    }

    public final Boolean getForceTransferGameUser() {
        return this.forceTransferGameUser;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOpenGameUrl() {
        return this.openGameUrl;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final boolean getSupportCallback() {
        return this.supportCallback;
    }

    public final boolean getSupportOpen() {
        return this.supportOpen;
    }

    public final int getType() {
        return this.type;
    }

    public final Boolean getUserHasPkgAccount() {
        return this.userHasPkgAccount;
    }

    public final boolean getUserPkgAccountTransferred() {
        return this.userPkgAccountTransferred;
    }

    public PlatformSupportPkg(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        switch(r103) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.userPkgAccountTransferred = am3.h.a(r100);
        r102 = r102 | 16;
        goto L3
    L8:
        this.userHasPkgAccount = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L9:
        this.forceTransferGameUser = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L10:
        this.clickIdNature = am3.h.c(r100);
        goto L3
    L11:
        this.openGameUrl = am3.h.c(r100);
        goto L3
    L12:
        this.supportCallback = am3.h.a(r100);
        r102 = r102 | 8;
        goto L3
    L13:
        this.priority = r100.i();
        r102 = r102 | 4;
        goto L3
    L14:
        this.supportOpen = am3.h.a(r100);
        r102 = r102 | 2;
        goto L3
    L15:
        this.type = r100.i();
        r102 = r102 | 1;
        goto L3
    L16:
        this.name = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.name != null) goto L21;
        this.name = null;
    L21:
        if ((r102 & 1) != 0) goto L24;
        this.type = 0;
    L24:
        if ((r102 & 2) != 0) goto L27;
        this.supportOpen = true;
    L27:
        if ((r102 & 4) != 0) goto L30;
        this.priority = 0;
    L30:
        if ((r102 & 8) != 0) goto L33;
        this.supportCallback = true;
    L33:
        if (this.openGameUrl != null) goto L36;
        this.openGameUrl = "";
    L36:
        if (this.clickIdNature != null) goto L39;
        this.clickIdNature = "";
    L39:
        if (this.forceTransferGameUser != null) goto L42;
        this.forceTransferGameUser = null;
    L42:
        if (this.userHasPkgAccount != null) goto L45;
        this.userHasPkgAccount = null;
    L45:
        if ((r102 & 16) != 0) goto L72;
        this.userPkgAccountTransferred = false;
        return;
    }

    public /* synthetic */ PlatformSupportPkg(String r110, int r111, boolean r112, int r113, boolean r114, String r115, String r116, Boolean r210, Boolean r211, boolean r212, int r213, DefaultConstructorMarker r214) {
        Boolean r100 = null;
        if ((r213 & 1) == 0) goto L5;
        String r101 = null;
    L6:
        boolean r102 = false;
        if ((r213 & 2) == 0) goto L9;
        int r103 = 0;
    L10:
        boolean r104 = true;
        if ((r213 & 4) == 0) goto L13;
        boolean r105 = true;
    L15:
        if ((r213 & 8) == 0) goto L17;
        int r106 = 0;
    L19:
        if ((r213 & 16) != 0) goto L22;
        r104 = r114;
    L22:
        String r107 = "";
        if ((r213 & 32) == 0) goto L25;
        String r108 = "";
    L27:
        if ((r213 & 64) != 0) goto L31;
        r107 = r116;
    L31:
        if ((r213 & 128) == 0) goto L33;
        Boolean r117 = null;
    L35:
        if ((r213 & 256) != 0) goto L39;
        r100 = r211;
    L39:
        if ((r213 & 512) != 0) goto L42;
        r102 = r212;
    L42:
        this(r101, r103, r105, r106, r104, r108, r107, r117, r100, r102);
        return;
    L33:
        r117 = r210;
        goto L35
    L25:
        r108 = r115;
        goto L27
    L17:
        r106 = r113;
        goto L19
    L13:
        r105 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L6
    }
}
