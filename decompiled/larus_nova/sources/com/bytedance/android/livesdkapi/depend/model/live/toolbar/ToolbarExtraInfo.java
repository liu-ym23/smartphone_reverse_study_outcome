package com.bytedance.android.livesdkapi.depend.model.live.toolbar;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/ToolbarExtraInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/IToolbarExtraInfo;", "()V", "gamePromotionCoexist", "", "getGamePromotionCoexist", "()Ljava/lang/Integer;", "setGamePromotionCoexist", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ToolbarExtraInfo extends FlexModelBase<IToolbarExtraInfo> implements IToolbarExtraInfo, h {

    @SerializedName("game_promotion_coexist")
    protected Integer gamePromotionCoexist;

    public ToolbarExtraInfo() {
        super(IToolbarExtraInfo.class);
        this.gamePromotionCoexist = 0;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.toolbar.IToolbarExtraInfo
    public Integer getGamePromotionCoexist() {
        return this.gamePromotionCoexist;
    }

    public ToolbarExtraInfo(g r100) {
        super(IToolbarExtraInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.gamePromotionCoexist = Integer.valueOf((int) r100.j());
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
        if (this.gamePromotionCoexist != null) goto L19;
        this.gamePromotionCoexist = 0;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.toolbar.IToolbarExtraInfo
    public void setGamePromotionCoexist(Integer r100) {
        this.gamePromotionCoexist = r100;
    }
}
