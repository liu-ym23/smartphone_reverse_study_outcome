package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.link.IRoomBattleProcessWaitingBattleContent;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/RoomBattleProcessWaitingBattleContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessWaitingBattleContent;", "()V", "selectGuestsWaitingSec", "", "getSelectGuestsWaitingSec", "()J", "setSelectGuestsWaitingSec", "(J)V", "toast", "", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomBattleProcessWaitingBattleContent extends FlexModelBase<IRoomBattleProcessWaitingBattleContent> implements IRoomBattleProcessWaitingBattleContent, h {

    @SerializedName("select_guests_waiting_sec")
    protected long selectGuestsWaitingSec;

    @SerializedName("toast")
    protected String toast;

    public RoomBattleProcessWaitingBattleContent() {
        super(IRoomBattleProcessWaitingBattleContent.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.link.IRoomBattleProcessWaitingBattleContent
    public long getSelectGuestsWaitingSec() {
        return this.selectGuestsWaitingSec;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.link.IRoomBattleProcessWaitingBattleContent
    public String getToast() {
        return this.toast;
    }

    public RoomBattleProcessWaitingBattleContent(g r100) {
        super(IRoomBattleProcessWaitingBattleContent.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.toast = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.selectGuestsWaitingSec = r100.j();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setSelectGuestsWaitingSec(long r100) {
        this.selectGuestsWaitingSec = r100;
    }

    public void setToast(String r100) {
        this.toast = r100;
    }
}
