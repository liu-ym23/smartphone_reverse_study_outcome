package com.bytedance.android.live.base.model.data;

import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R:\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR.\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u0004R:\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001d\u0010\u000f¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/base/model/data/i;", "Lvh7/c;", "", "getFromRoomId", "()J", "getFromRoomId$annotations", "()V", "fromRoomId", "getToRoomId", "getToRoomId$annotations", "toRoomId", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getUpdateInfo", "()Ljava/util/Map;", "getUpdateInfo$annotations", "updateInfo", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkedUsers", "()Ljava/util/List;", "getLinkedUsers$annotations", "linkedUsers", "getVersion", "getVersion$annotations", "version", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "getLinkerContentMap", "getLinkerContentMap$annotations", "linkerContentMap", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i extends vh7.c<i> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    long getFromRoomId();

    @FieldName(name = "linked_users")
    List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedUsers();

    @FieldName(name = "linker_content_map")
    Map<Long, g2> getLinkerContentMap();

    @FieldName(name = "to_room_id")
    long getToRoomId();

    @FieldName(name = "update_info")
    Map<String, String> getUpdateInfo();

    @FieldName(name = "version")
    long getVersion();
}
