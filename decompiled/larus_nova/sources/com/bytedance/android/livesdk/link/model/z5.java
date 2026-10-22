package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001JR6\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\u00020\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\u000b\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0014R\u001c\u0010$\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b\"\u0010\u0019R\"\u0010+\u001a\u00020%8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\u000b\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010.\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\u000b\u001a\u0004\b,\u0010\u0019R\u001a\u00101\u001a\u00020%8&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\u000b\u001a\u0004\b/\u0010'R\u001c\u00104\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\u000b\u001a\u0004\b2\u0010\u0019R\u001a\u00108\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010\u000b\u001a\u0004\b5\u00106R\u001a\u0010;\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\u000b\u001a\u0004\b9\u0010\u000fR:\u0010A\u001a\"\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010<j\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u0001`=8&X§\u0004¢\u0006\f\u0012\u0004\b@\u0010\u000b\u001a\u0004\b>\u0010?R\"\u0010E\u001a\u00020\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bD\u0010\u000b\u001a\u0004\bB\u0010\u000f\"\u0004\bC\u0010\u0014R.\u0010H\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058&X§\u0004¢\u0006\f\u0012\u0004\bG\u0010\u000b\u001a\u0004\bF\u0010\u0007¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/z5;", "Lvh7/c;", "", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPlayModes", "()Ljava/util/List;", "setPlayModes", "(Ljava/util/List;)V", "getPlayModes$annotations", "()V", "playModes", "", "getLayoutConfigVersion", "()I", "getLayoutConfigVersion$annotations", "layoutConfigVersion", "getUiLayout", "setUiLayout", "(I)V", "getUiLayout$annotations", "uiLayout", "", "getClientUiInfo", "()Ljava/lang/String;", "setClientUiInfo", "(Ljava/lang/String;)V", "getClientUiInfo$annotations", "clientUiInfo", "getIntegrationAnchorEnableAudienceLinkmic", "setIntegrationAnchorEnableAudienceLinkmic", "getIntegrationAnchorEnableAudienceLinkmic$annotations", "integrationAnchorEnableAudienceLinkmic", "getKtvLyricMode", "getKtvLyricMode$annotations", "ktvLyricMode", "", "getAnchorAcceptAudiencePreApply", "()Z", "setAnchorAcceptAudiencePreApply", "(Z)V", "getAnchorAcceptAudiencePreApply$annotations", "anchorAcceptAudiencePreApply", "getFunctionType2", "getFunctionType2$annotations", "functionType2", "getForbidApplyFromOther", "getForbidApplyFromOther$annotations", "forbidApplyFromOther", "getInitSource", "getInitSource$annotations", "initSource", "getEnlargeGuestTurnOnSource", "()J", "getEnlargeGuestTurnOnSource$annotations", "enlargeGuestTurnOnSource", "getKtvExhibitMode", "getKtvExhibitMode$annotations", "ktvExhibitMode", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getPlayModeDetail", "()Ljava/util/Map;", "getPlayModeDetail$annotations", "playModeDetail", "getAnchorManualUiLayout", "setAnchorManualUiLayout", "getAnchorManualUiLayout$annotations", "anchorManualUiLayout", "getFeatureList", "getFeatureList$annotations", "featureList", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface z5 extends vh7.c<z5> {
    public static final a Companion = null;
    public static final long FeatureType_HamletAvatar = 1;
    public static final long FeatureType_MultiCamera = 2;
    public static final long FeatureType_ShowMedia = 4;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147107a = null;

        public a() {
        }

        static {
            f147107a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f147107a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "accept_audience_pre_apply")
    boolean getAnchorAcceptAudiencePreApply();

    @FieldName(name = "manual_open_ui")
    int getAnchorManualUiLayout();

    @FieldName(name = "client_ui_info")
    String getClientUiInfo();

    @FieldName(name = "enlarge_guest_turn_on_source")
    long getEnlargeGuestTurnOnSource();

    @FieldName(name = "feature_list")
    List<Long> getFeatureList();

    @FieldName(name = "forbid_apply_from_other")
    boolean getForbidApplyFromOther();

    @FieldName(name = "function_type")
    String getFunctionType2();

    @FieldName(name = "init_source")
    String getInitSource();

    @FieldName(name = "enable_audience_linkmic")
    int getIntegrationAnchorEnableAudienceLinkmic();

    @FieldName(name = "ktv_exhibit_mode")
    int getKtvExhibitMode();

    @FieldName(name = "ktv_lyric_mode")
    String getKtvLyricMode();

    @FieldName(name = "big_party_layout_config_version")
    int getLayoutConfigVersion();

    @FieldName(name = "playmode_detail")
    Map<String, String> getPlayModeDetail();

    @FieldName(name = "linker_play_modes")
    List<Long> getPlayModes();

    @FieldName(name = "linker_ui_layout")
    int getUiLayout();

    /* synthetic */ boolean isFlexibleTeamFight();

    /* synthetic */ boolean isTeamFightShowing();

    @FieldName(name = "accept_audience_pre_apply#setter")
    void setAnchorAcceptAudiencePreApply(boolean r100);

    @FieldName(name = "manual_open_ui#setter")
    void setAnchorManualUiLayout(int r100);

    @FieldName(name = "client_ui_info#setter")
    void setClientUiInfo(String r100);

    /* synthetic */ void setFlexibleTeamFight(boolean r100);

    @FieldName(name = "enable_audience_linkmic#setter")
    void setIntegrationAnchorEnableAudienceLinkmic(int r100);

    @FieldName(name = "linker_play_modes#setter")
    void setPlayModes(List<Long> r100);

    /* synthetic */ void setTeamFightShowing(boolean r100);

    @FieldName(name = "linker_ui_layout#setter")
    void setUiLayout(int r100);
}
