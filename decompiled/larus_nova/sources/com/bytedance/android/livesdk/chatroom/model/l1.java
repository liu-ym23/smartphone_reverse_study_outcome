package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R:\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/l1;", "Lvh7/c;", "", "Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLockedPositions", "()Ljava/util/List;", "setLockedPositions", "(Ljava/util/List;)V", "getLockedPositions$annotations", "()V", "lockedPositions", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l1 extends vh7.c<l1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "locked_positions")
    List<LinkmicPositionItem> getLockedPositions();

    @FieldName(name = "locked_positions#setter")
    void setLockedPositions(List<? extends LinkmicPositionItem> r100);
}
