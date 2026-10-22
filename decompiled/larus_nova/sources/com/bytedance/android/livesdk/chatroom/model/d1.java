package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0007\u001a\u0004\b\n\u0010\u0005R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\r\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/d1;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/chatroom/model/ILinkmicInteractEntrance;", "getEntranceList", "()Ljava/util/List;", "getEntranceList$annotations", "()V", "entranceList", "Lcom/bytedance/android/livesdk/chatroom/model/j1;", "getEntrancePosList", "getEntrancePosList$annotations", "entrancePosList", "getBannerList", "getBannerList$annotations", "bannerList", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d1 extends vh7.c<d1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "banner_list")
    List<ILinkmicInteractEntrance> getBannerList();

    @FieldName(name = "entrance_list")
    List<ILinkmicInteractEntrance> getEntranceList();

    @FieldName(name = "entrance_pos_list")
    List<j1> getEntrancePosList();
}
