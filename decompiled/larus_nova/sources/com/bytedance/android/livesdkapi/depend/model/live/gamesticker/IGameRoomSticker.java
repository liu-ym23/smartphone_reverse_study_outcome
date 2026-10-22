package com.bytedance.android.livesdkapi.depend.model.live.gamesticker;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/IGameRoomSticker;", "Lvh7/c;", "", "getStickerType", "()I", "getStickerType$annotations", "()V", "stickerType", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getStickerTypeList", "()Ljava/util/List;", "getStickerTypeList$annotations", "stickerTypeList", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IGameRoomSticker extends c<IGameRoomSticker> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "need_render_sticker_type")
        public static /* synthetic */ void getStickerType$annotations() {
        }

        @FieldName(name = "need_render_sticker_list")
        public static /* synthetic */ void getStickerTypeList$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "need_render_sticker_type")
    int getStickerType();

    @FieldName(name = "need_render_sticker_list")
    List<Long> getStickerTypeList();
}
