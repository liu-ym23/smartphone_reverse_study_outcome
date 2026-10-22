package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface ILinkerDetail extends c<ILinkerDetail> {
    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    long getEnlargeGuestTurnOnSource();

    String getFunctionType2();

    String getInitSource();

    int getIntegrationAnchorEnableAudienceLinkmic();

    int getKtvExhibitMode();

    String getKtvLyricMode();

    int getLayoutConfigVersion();

    Map<String, String> getPlayModeDetail();

    List<Long> getPlayModes();

    int getUiLayout();

    boolean isAnchorAcceptAudiencePreApply();

    boolean isForbidApplyFromOther();

    void setAnchorAcceptAudiencePreApply(boolean r100);
}
