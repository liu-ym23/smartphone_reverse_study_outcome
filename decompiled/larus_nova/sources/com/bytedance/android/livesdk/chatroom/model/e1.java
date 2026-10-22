package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface e1 extends vh7.c<e1> {
    public static final int[] CURRENT_VERSION_SUPPORT_TYPE = null;

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "cur_interact_type")
    List<Integer> getCurInteractType();

    @FieldName(name = "exclusive_list")
    Map<Long, ? extends a1> getExclusiveList();

    @FieldName(name = "interact_items")
    List<k1> getInteractItems();

    @FieldName(name = "playing_list")
    List<Long> getPlayingList();

    @FieldName(name = "room_mode_item_list")
    List<f3> getRoomModeItemList();

    static {
        CURRENT_VERSION_SUPPORT_TYPE = new int[]{1, 3, 2, 5, 6, 10, 7, 8, 10};
    }
}
