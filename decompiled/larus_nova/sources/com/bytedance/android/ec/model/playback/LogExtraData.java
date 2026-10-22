package com.bytedance.android.ec.model.playback;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b$\b\u0086\b\u0018\u0000 D2\u00020\u0001:\u0001EB\u0097\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bB\u0010CJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003J \u0001\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u0002HÖ\u0001J\t\u0010!\u001a\u00020 HÖ\u0001J\u0013\u0010$\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010%\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010%\u001a\u0004\b0\u0010'\"\u0004\b1\u0010)R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010%\u001a\u0004\b2\u0010'\"\u0004\b3\u0010)R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010%\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R$\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u00106\u001a\u0004\b7\u0010\f\"\u0004\b8\u00109R$\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u00106\u001a\u0004\b:\u0010\f\"\u0004\b;\u00109R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010%\u001a\u0004\b<\u0010'\"\u0004\b=\u0010)R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010%\u001a\u0004\b>\u0010'\"\u0004\b?\u0010)R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010%\u001a\u0004\b@\u0010'\"\u0004\bA\u0010)¨\u0006F"}, d2 = {"Lcom/bytedance/android/ec/model/playback/LogExtraData;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "", "component8", "()Ljava/lang/Boolean;", "component9", "component10", "component11", "component12", "sourcePage", "enterMethod", "eComEntranceForm", "searchParam", "searchType", "roomId", "entranceInfo", "fromSearch", "needShowAnchorPage", "enterScene", "carrierSource", "fragmentId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/ec/model/playback/LogExtraData;", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getSourcePage", "()Ljava/lang/String;", "setSourcePage", "(Ljava/lang/String;)V", "getEnterMethod", "setEnterMethod", "getEComEntranceForm", "setEComEntranceForm", "getSearchParam", "setSearchParam", "getSearchType", "setSearchType", "getRoomId", "setRoomId", "getEntranceInfo", "setEntranceInfo", "Ljava/lang/Boolean;", "getFromSearch", "setFromSearch", "(Ljava/lang/Boolean;)V", "getNeedShowAnchorPage", "setNeedShowAnchorPage", "getEnterScene", "setEnterScene", "getCarrierSource", "setCarrierSource", "getFragmentId", "setFragmentId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class LogExtraData implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private String carrierSource;
    private String eComEntranceForm;
    private String enterMethod;
    private String enterScene;
    private String entranceInfo;
    private String fragmentId;
    private Boolean fromSearch;
    private Boolean needShowAnchorPage;
    private String roomId;
    private String searchParam;
    private String searchType;
    private String sourcePage;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LogExtraData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ LogExtraData copy$default(LogExtraData r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, Boolean r211, Boolean r212, String r213, String r214, String r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.sourcePage;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.enterMethod;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.eComEntranceForm;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.searchParam;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.searchType;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.roomId;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.entranceInfo;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Boolean r107 = r110.fromSearch;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Boolean r117 = r110.needShowAnchorPage;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r118 = r110.enterScene;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.carrierSource;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        String r108 = r110.fragmentId;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
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
        return this.sourcePage;
    }

    public final String component10() {
        return this.enterScene;
    }

    public final String component11() {
        return this.carrierSource;
    }

    public final String component12() {
        return this.fragmentId;
    }

    public final String component2() {
        return this.enterMethod;
    }

    public final String component3() {
        return this.eComEntranceForm;
    }

    public final String component4() {
        return this.searchParam;
    }

    public final String component5() {
        return this.searchType;
    }

    public final String component6() {
        return this.roomId;
    }

    public final String component7() {
        return this.entranceInfo;
    }

    public final Boolean component8() {
        return this.fromSearch;
    }

    public final Boolean component9() {
        return this.needShowAnchorPage;
    }

    public final LogExtraData copy(String r110, String r111, String r112, String r113, String r114, String r210, String r211, Boolean r212, Boolean r213, String r214, String r215, String r216) {
        return new LogExtraData(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LogExtraData) == false) goto L30;
        LogExtraData r101 = (LogExtraData) r100;
        if (Intrinsics.areEqual(this.sourcePage, r101.sourcePage) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eComEntranceForm, r101.eComEntranceForm) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchParam, r101.searchParam) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.searchType, r101.searchType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.entranceInfo, r101.entranceInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.fromSearch, r101.fromSearch) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.needShowAnchorPage, r101.needShowAnchorPage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enterScene, r101.enterScene) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.carrierSource, r101.carrierSource) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.fragmentId, r101.fragmentId) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        String r100 = this.sourcePage;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.enterMethod;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.eComEntranceForm;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.searchParam;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.searchType;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.roomId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.entranceInfo;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.fromSearch;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.needShowAnchorPage;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.enterScene;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.carrierSource;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.fragmentId;
        if (r134 == null) goto L50;
        r101 = r134.hashCode();
    L50:
        return r133 + r101;
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LogExtraData(sourcePage=" + this.sourcePage + ", enterMethod=" + this.enterMethod + ", eComEntranceForm=" + this.eComEntranceForm + ", searchParam=" + this.searchParam + ", searchType=" + this.searchType + ", roomId=" + this.roomId + ", entranceInfo=" + this.entranceInfo + ", fromSearch=" + this.fromSearch + ", needShowAnchorPage=" + this.needShowAnchorPage + ", enterScene=" + this.enterScene + ", carrierSource=" + this.carrierSource + ", fragmentId=" + this.fragmentId + ")";
    }

    public final String getCarrierSource() {
        return this.carrierSource;
    }

    public final String getEComEntranceForm() {
        return this.eComEntranceForm;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEnterScene() {
        return this.enterScene;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final String getFragmentId() {
        return this.fragmentId;
    }

    public final Boolean getFromSearch() {
        return this.fromSearch;
    }

    public final Boolean getNeedShowAnchorPage() {
        return this.needShowAnchorPage;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSearchParam() {
        return this.searchParam;
    }

    public final String getSearchType() {
        return this.searchType;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final void setCarrierSource(String r100) {
        this.carrierSource = r100;
    }

    public final void setEComEntranceForm(String r100) {
        this.eComEntranceForm = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setEnterScene(String r100) {
        this.enterScene = r100;
    }

    public final void setEntranceInfo(String r100) {
        this.entranceInfo = r100;
    }

    public final void setFragmentId(String r100) {
        this.fragmentId = r100;
    }

    public final void setFromSearch(Boolean r100) {
        this.fromSearch = r100;
    }

    public final void setNeedShowAnchorPage(Boolean r100) {
        this.needShowAnchorPage = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setSearchParam(String r100) {
        this.searchParam = r100;
    }

    public final void setSearchType(String r100) {
        this.searchType = r100;
    }

    public final void setSourcePage(String r100) {
        this.sourcePage = r100;
    }

    public LogExtraData(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Boolean r107, Boolean r108, String r110, String r111, String r112) {
        this.sourcePage = r100;
        this.enterMethod = r101;
        this.eComEntranceForm = r102;
        this.searchParam = r103;
        this.searchType = r104;
        this.roomId = r105;
        this.entranceInfo = r106;
        this.fromSearch = r107;
        this.needShowAnchorPage = r108;
        this.enterScene = r110;
        this.carrierSource = r111;
        this.fragmentId = r112;
    }

    public /* synthetic */ LogExtraData(String r110, String r111, String r112, String r113, String r114, String r115, String r210, Boolean r211, Boolean r212, String r213, String r214, String r215, int r216, DefaultConstructorMarker r217) {
        String r100 = null;
        if ((r216 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Boolean r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Boolean r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r117 = null;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
