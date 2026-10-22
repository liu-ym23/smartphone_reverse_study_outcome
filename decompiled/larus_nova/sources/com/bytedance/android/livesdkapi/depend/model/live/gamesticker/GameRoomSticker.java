package com.bytedance.android.livesdkapi.depend.model.live.gamesticker;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameRoomSticker;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/IGameRoomSticker;", "()V", "stickerType", "", "getStickerType", "()I", "stickerTypeList", "", "", "getStickerTypeList", "()Ljava/util/List;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GameRoomSticker extends FlexModelBase<IGameRoomSticker> implements IGameRoomSticker, h {

    @SerializedName("need_render_sticker_type")
    protected int stickerType;

    @SerializedName("need_render_sticker_list")
    protected List<Long> stickerTypeList;

    public GameRoomSticker() {
        super(IGameRoomSticker.class);
        this.stickerTypeList = CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.gamesticker.IGameRoomSticker
    public int getStickerType() {
        return this.stickerType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.gamesticker.IGameRoomSticker
    public List<Long> getStickerTypeList() {
        return this.stickerTypeList;
    }

    public GameRoomSticker(g r100) {
        super(IGameRoomSticker.class);
        this.stickerTypeList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.stickerType = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.stickerTypeList.add(Long.valueOf(r100.j()));
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this.stickerTypeList.isEmpty() == false) goto L25;
        this.stickerTypeList = CollectionsKt.emptyList();
        return;
    }
}
