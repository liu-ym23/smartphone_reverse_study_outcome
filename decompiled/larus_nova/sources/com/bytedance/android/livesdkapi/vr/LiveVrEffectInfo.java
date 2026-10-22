package com.bytedance.android.livesdkapi.vr;

import com.bytedance.android.livesdkapi.roomplayer.VideoEffectInitConfigBuilder;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b@\b\u0086\b\u0018\u0000 Q2\u00020\u0001:\u0001QB\u008f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0014J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00104J\u0017\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010I\u001a\u00020\u000eHÆ\u0003J\t\u0010J\u001a\u00020\u000eHÆ\u0003J\u0098\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020\u000e2\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020\u0012HÖ\u0001J\t\u0010P\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118F¢\u0006\u0006\u001a\u0004\b+\u0010'R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010.R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010!\"\u0004\b0\u0010#R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b=\u0010\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010.¨\u0006R"}, d2 = {"Lcom/bytedance/android/livesdkapi/vr/LiveVrEffectInfo;", "", "vrTransferType", "", "streamMapping", "", "", "materialId", "materialUrl", "roomId", "configBuilder", "Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfigBuilder;", "effectContextId", "curRealVrEffectEnable", "", "lastVrEnableNotPkOrMultiLink", "layerStatusList", "", "", "roomIsInInteraction", "(JLjava/util/Map;JLjava/lang/String;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfigBuilder;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/Boolean;)V", "getConfigBuilder", "()Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfigBuilder;", "setConfigBuilder", "(Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfigBuilder;)V", "getCurRealVrEffectEnable", "()Z", "setCurRealVrEffectEnable", "(Z)V", "default2dStreamId", "getDefault2dStreamId", "()J", "getEffectContextId", "()Ljava/lang/String;", "setEffectContextId", "(Ljava/lang/String;)V", "getLastVrEnableNotPkOrMultiLink", "setLastVrEnableNotPkOrMultiLink", "getLayerStatusList", "()Ljava/util/List;", "setLayerStatusList", "(Ljava/util/List;)V", "layerStatusListNonNull", "getLayerStatusListNonNull", "getMaterialId", "setMaterialId", "(J)V", "getMaterialUrl", "setMaterialUrl", "getRoomId", "setRoomId", "getRoomIsInInteraction", "()Ljava/lang/Boolean;", "setRoomIsInInteraction", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getStreamMapping", "()Ljava/util/Map;", "setStreamMapping", "(Ljava/util/Map;)V", "transferSixDofStreamId", "getTransferSixDofStreamId", "getVrTransferType", "setVrTransferType", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/util/Map;JLjava/lang/String;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfigBuilder;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/Boolean;)Lcom/bytedance/android/livesdkapi/vr/LiveVrEffectInfo;", "equals", "other", "hashCode", "toString", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveVrEffectInfo {
    public static final Companion Companion = null;
    public static final String STREAM_FORMAT_LITE_MODE_6DOF_OFF_MIXED = "mixed";
    public static final String STREAM_FORMAT_LITE_MODE_6DOF_ON_SEPERATED = "seperated";
    public static final String STREAM_MAPPING_DEFAULT_2D_STREAM_ID_KEY = "default_2d_stream_id";
    public static final String STREAM_MAPPING_TRANSFER_SIXDOF_STREAM_ID = "transfer_sixdof_stream_id";
    public static final String TAG = "LiveVrEffect";
    public static final long VR_LITE_MODE_6DOF_OFF = 1;
    public static final long VR_LITE_MODE_6DOF_ON = 2;
    public static final long VR_TRANSFER_TYPE_6DOF_OFF = 1;
    public static final long VR_TRANSFER_TYPE_6DOF_ON = 2;
    public static final long VR_TRANSFER_TYPE_NORMAL = 0;
    private VideoEffectInitConfigBuilder configBuilder;
    private boolean curRealVrEffectEnable;
    private String effectContextId;
    private boolean lastVrEnableNotPkOrMultiLink;
    private List<Integer> layerStatusList;
    private long materialId;
    private String materialUrl;
    private String roomId;
    private Boolean roomIsInInteraction;
    private Map<String, Long> streamMapping;
    private long vrTransferType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/vr/LiveVrEffectInfo$Companion;", "", "()V", "STREAM_FORMAT_LITE_MODE_6DOF_OFF_MIXED", "", "STREAM_FORMAT_LITE_MODE_6DOF_ON_SEPERATED", "STREAM_MAPPING_DEFAULT_2D_STREAM_ID_KEY", "STREAM_MAPPING_TRANSFER_SIXDOF_STREAM_ID", "TAG", "VR_LITE_MODE_6DOF_OFF", "", "VR_LITE_MODE_6DOF_ON", "VR_TRANSFER_TYPE_6DOF_OFF", "VR_TRANSFER_TYPE_6DOF_ON", "VR_TRANSFER_TYPE_NORMAL", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LiveVrEffectInfo() {
        this(0, null, 0, null, null, null, null, false, false, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveVrEffectInfo copy$default(LiveVrEffectInfo r110, long r111, Map r112, long r113, String r210, String r211, VideoEffectInitConfigBuilder r212, String r213, boolean r214, boolean r215, List r216, Boolean r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        long r100 = r110.vrTransferType;
    L7:
        if ((r218 & 2) == 0) goto L9;
        Map r101 = r110.streamMapping;
    L11:
        if ((r218 & 4) == 0) goto L13;
        long r102 = r110.materialId;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r103 = r110.materialUrl;
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r104 = r110.roomId;
    L23:
        if ((r218 & 32) == 0) goto L25;
        VideoEffectInitConfigBuilder r105 = r110.configBuilder;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r114 = r110.effectContextId;
    L31:
        if ((r218 & 128) == 0) goto L33;
        boolean r115 = r110.curRealVrEffectEnable;
    L35:
        if ((r218 & 256) == 0) goto L37;
        boolean r116 = r110.lastVrEnableNotPkOrMultiLink;
    L39:
        if ((r218 & 512) == 0) goto L41;
        List r117 = r110.layerStatusList;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        Boolean r106 = r110.roomIsInInteraction;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r114, r115, r116, r117, r106);
    L45:
        r106 = r217;
        goto L47
    L41:
        r117 = r216;
        goto L43
    L37:
        r116 = r215;
        goto L39
    L33:
        r115 = r214;
        goto L35
    L29:
        r114 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
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

    public final long component1() {
        return this.vrTransferType;
    }

    public final List<Integer> component10() {
        return this.layerStatusList;
    }

    public final Boolean component11() {
        return this.roomIsInInteraction;
    }

    public final Map<String, Long> component2() {
        return this.streamMapping;
    }

    public final long component3() {
        return this.materialId;
    }

    public final String component4() {
        return this.materialUrl;
    }

    public final String component5() {
        return this.roomId;
    }

    public final VideoEffectInitConfigBuilder component6() {
        return this.configBuilder;
    }

    public final String component7() {
        return this.effectContextId;
    }

    public final boolean component8() {
        return this.curRealVrEffectEnable;
    }

    public final boolean component9() {
        return this.lastVrEnableNotPkOrMultiLink;
    }

    public final LiveVrEffectInfo copy(long r110, Map<String, Long> r111, long r112, String r210, String r211, VideoEffectInitConfigBuilder r212, String r213, boolean r214, boolean r215, List<Integer> r216, Boolean r217) {
        Intrinsics.checkNotNullParameter(r210, "materialUrl");
        Intrinsics.checkNotNullParameter(r211, "roomId");
        return new LiveVrEffectInfo(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveVrEffectInfo) == false) goto L28;
        LiveVrEffectInfo r101 = (LiveVrEffectInfo) r100;
        if (this.vrTransferType == r101.vrTransferType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.streamMapping, r101.streamMapping) == true) goto L10;
        return false;
    L10:
        if (this.materialId == r101.materialId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.materialUrl, r101.materialUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.configBuilder, r101.configBuilder) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.effectContextId, r101.effectContextId) == true) goto L20;
        return false;
    L20:
        if (this.curRealVrEffectEnable == r101.curRealVrEffectEnable) goto L22;
        return false;
    L22:
        if (this.lastVrEnableNotPkOrMultiLink == r101.lastVrEnableNotPkOrMultiLink) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.layerStatusList, r101.layerStatusList) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.roomIsInInteraction, r101.roomIsInInteraction) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        long r100 = this.vrTransferType;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        Map<String, Long> r102 = this.streamMapping;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        long r105 = this.materialId;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.materialUrl;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.roomId;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 31;
        VideoEffectInitConfigBuilder r113 = this.configBuilder;
        if (r113 == null) goto L17;
        int r114 = r113.hashCode();
    L18:
        int r115 = (r112 + r114) * 31;
        String r116 = this.effectContextId;
        if (r116 == null) goto L21;
        int r117 = r116.hashCode();
    L22:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.curRealVrEffectEnable;
        ?? r120 = 1;
        ?? r121 = r119;
        if (r119 == false) goto L25;
        r121 = 1;
    L25:
        int r122 = (r118 + r121) * 31;
        boolean r123 = this.lastVrEnableNotPkOrMultiLink;
        if (r123 == true) goto L29;
        r120 = r123;
    L29:
        int r124 = (r122 + r120) * 31;
        List<Integer> r125 = this.layerStatusList;
        if (r125 == null) goto L32;
        int r126 = r125.hashCode();
    L33:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.roomIsInInteraction;
        if (r128 == null) goto L37;
        r103 = r128.hashCode();
    L37:
        return r127 + r103;
    L32:
        r126 = 0;
        goto L33
    L21:
        r117 = 0;
        goto L22
    L17:
        r114 = 0;
        goto L18
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "LiveVrEffectInfo(vrTransferType=" + this.vrTransferType + ", streamMapping=" + this.streamMapping + ", materialId=" + this.materialId + ", materialUrl=" + this.materialUrl + ", roomId=" + this.roomId + ", configBuilder=" + this.configBuilder + ", effectContextId=" + this.effectContextId + ", curRealVrEffectEnable=" + this.curRealVrEffectEnable + ", lastVrEnableNotPkOrMultiLink=" + this.lastVrEnableNotPkOrMultiLink + ", layerStatusList=" + this.layerStatusList + ", roomIsInInteraction=" + this.roomIsInInteraction + ")";
    }

    public final long getDefault2dStreamId() {
        Map<String, Long> r100 = this.streamMapping;
        if (r100 == null) goto L7;
        Long r101 = r100.get(STREAM_MAPPING_DEFAULT_2D_STREAM_ID_KEY);
        if (r101 == null) goto L7;
        return r101.longValue();
    L7:
        return 0;
    }

    public final List<Integer> getLayerStatusListNonNull() {
        List<Integer> r100 = this.layerStatusList;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public final long getTransferSixDofStreamId() {
        Map<String, Long> r100 = this.streamMapping;
        if (r100 == null) goto L7;
        Long r101 = r100.get(STREAM_MAPPING_TRANSFER_SIXDOF_STREAM_ID);
        if (r101 == null) goto L7;
        return r101.longValue();
    L7:
        return 0;
    }

    public final VideoEffectInitConfigBuilder getConfigBuilder() {
        return this.configBuilder;
    }

    public final boolean getCurRealVrEffectEnable() {
        return this.curRealVrEffectEnable;
    }

    public final String getEffectContextId() {
        return this.effectContextId;
    }

    public final boolean getLastVrEnableNotPkOrMultiLink() {
        return this.lastVrEnableNotPkOrMultiLink;
    }

    public final List<Integer> getLayerStatusList() {
        return this.layerStatusList;
    }

    public final long getMaterialId() {
        return this.materialId;
    }

    public final String getMaterialUrl() {
        return this.materialUrl;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final Boolean getRoomIsInInteraction() {
        return this.roomIsInInteraction;
    }

    public final Map<String, Long> getStreamMapping() {
        return this.streamMapping;
    }

    public final long getVrTransferType() {
        return this.vrTransferType;
    }

    public final void setConfigBuilder(VideoEffectInitConfigBuilder r100) {
        this.configBuilder = r100;
    }

    public final void setCurRealVrEffectEnable(boolean r100) {
        this.curRealVrEffectEnable = r100;
    }

    public final void setEffectContextId(String r100) {
        this.effectContextId = r100;
    }

    public final void setLastVrEnableNotPkOrMultiLink(boolean r100) {
        this.lastVrEnableNotPkOrMultiLink = r100;
    }

    public final void setLayerStatusList(List<Integer> r100) {
        this.layerStatusList = r100;
    }

    public final void setMaterialId(long r100) {
        this.materialId = r100;
    }

    public final void setMaterialUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.materialUrl = r100;
    }

    public final void setRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomId = r100;
    }

    public final void setRoomIsInInteraction(Boolean r100) {
        this.roomIsInInteraction = r100;
    }

    public final void setStreamMapping(Map<String, Long> r100) {
        this.streamMapping = r100;
    }

    public final void setVrTransferType(long r100) {
        this.vrTransferType = r100;
    }

    public LiveVrEffectInfo(long r100, Map<String, Long> r101, long r102, String r103, String r104, VideoEffectInitConfigBuilder r105, String r110, boolean r111, boolean r112, List<Integer> r113, Boolean r114) {
        Intrinsics.checkNotNullParameter(r103, "materialUrl");
        Intrinsics.checkNotNullParameter(r104, "roomId");
        this.vrTransferType = r100;
        this.streamMapping = r101;
        this.materialId = r102;
        this.materialUrl = r103;
        this.roomId = r104;
        this.configBuilder = r105;
        this.effectContextId = r110;
        this.curRealVrEffectEnable = r111;
        this.lastVrEnableNotPkOrMultiLink = r112;
        this.layerStatusList = r113;
        this.roomIsInInteraction = r114;
    }

    public /* synthetic */ LiveVrEffectInfo(long r110, Map r111, long r112, String r210, String r211, VideoEffectInitConfigBuilder r212, String r213, boolean r214, boolean r215, List r216, Boolean r217, int r218, DefaultConstructorMarker r219) {
        long r100 = 0;
        if ((r218 & 1) == 0) goto L5;
        long r101 = 0;
    L6:
        List r102 = null;
        if ((r218 & 2) == 0) goto L9;
        Map r103 = null;
    L11:
        if ((r218 & 4) != 0) goto L14;
        r100 = r112;
    L14:
        String r104 = "";
        if ((r218 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r218 & 16) != 0) goto L23;
        r104 = r211;
    L23:
        if ((r218 & 32) == 0) goto L25;
        VideoEffectInitConfigBuilder r106 = null;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r113 = null;
    L30:
        boolean r114 = true;
        if ((r218 & 128) == 0) goto L33;
        boolean r115 = true;
    L35:
        if ((r218 & 256) != 0) goto L39;
        r114 = r215;
    L39:
        if ((r218 & 512) != 0) goto L43;
        r102 = r216;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        Boolean r107 = Boolean.FALSE;
    L46:
        this(r101, r103, r100, r105, r104, r106, r113, r115, r114, r102, r107);
        return;
    L45:
        r107 = r217;
        goto L46
    L33:
        r115 = r214;
        goto L35
    L29:
        r113 = r213;
        goto L30
    L25:
        r106 = r212;
        goto L27
    L17:
        r105 = r210;
        goto L19
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
