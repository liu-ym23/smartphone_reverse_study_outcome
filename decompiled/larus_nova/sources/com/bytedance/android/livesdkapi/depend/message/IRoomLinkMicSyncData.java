package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.q;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface IRoomLinkMicSyncData extends c<IRoomLinkMicSyncData> {
    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    ClientUIInfo getClientUIInfo();

    @FieldName(name = "linker_base_info")
    q getLinkerBaseInfo();

    @FieldName(name = "linker_content_map")
    Map<Long, g2> getLinkerContentMap();

    @FieldName(name = "locked_positions")
    List<LinkmicPositionItem> getLockedPositions();

    @FieldName(name = "linked_users")
    List<k> getMLinkUsers();

    @FieldName(name = "positions")
    List<LinkmicPositionItem> getPositions();
}
