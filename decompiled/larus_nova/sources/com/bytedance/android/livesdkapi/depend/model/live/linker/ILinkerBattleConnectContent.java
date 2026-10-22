package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdk.link.model.bridge.s1;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface ILinkerBattleConnectContent extends c<ILinkerBattleConnectContent> {
    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "anchor_user_list")
    List<k> getAnchorUserList();

    @FieldName(name = "linker_content_map")
    Map<Long, g2> getLinkerContentMap();

    @FieldName(name = "live_core_ext_info")
    String getLiveCoreExtInfo();

    @FieldName(name = "multi_channel_info")
    s1 getMultiChannelInfo();

    @FieldName(name = "rtc_ext_info")
    String getRtcExtInfo();

    @FieldName(name = "version")
    long getVersion();
}
