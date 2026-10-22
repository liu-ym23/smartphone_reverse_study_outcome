package com.bytedance.android.livesdk.message.linker;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/linker/LinkerLockPositionContent;", "Lvh7/c;", "", "Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem;", "getLockedPositions", "()Ljava/util/List;", "setLockedPositions", "(Ljava/util/List;)V", "getLockedPositions$annotations", "()V", "lockedPositions", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkerLockPositionContent extends vh7.c<LinkerLockPositionContent> {

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
