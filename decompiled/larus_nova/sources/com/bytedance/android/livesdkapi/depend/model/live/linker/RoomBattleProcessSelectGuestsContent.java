package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.link.IRoomBattleProcessSelectGuestsContent;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/RoomBattleProcessSelectGuestsContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessSelectGuestsContent;", "()V", "guestInfos", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightReplyGuestInfo;", "getGuestInfos", "()Ljava/util/List;", "setGuestInfos", "(Ljava/util/List;)V", "maxMember", "", "getMaxMember", "()Ljava/lang/String;", "setMaxMember", "(Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomBattleProcessSelectGuestsContent extends FlexModelBase<IRoomBattleProcessSelectGuestsContent> implements IRoomBattleProcessSelectGuestsContent, h {

    @SerializedName("guest_infos")
    protected List<? extends LinkRoomFightReplyGuestInfo> guestInfos;

    @SerializedName("max_member")
    protected String maxMember;

    public RoomBattleProcessSelectGuestsContent() {
        super(IRoomBattleProcessSelectGuestsContent.class);
    }

    public RoomBattleProcessSelectGuestsContent(g r100) {
        super(IRoomBattleProcessSelectGuestsContent.class);
        this.guestInfos = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.guestInfos.add(f.a(r100, LinkRoomFightReplyGuestInfo.class));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.maxMember = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.link.IRoomBattleProcessSelectGuestsContent
    public List<LinkRoomFightReplyGuestInfo> getGuestInfos() {
        return this.guestInfos;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.link.IRoomBattleProcessSelectGuestsContent
    public String getMaxMember() {
        return this.maxMember;
    }

    public void setGuestInfos(List<? extends LinkRoomFightReplyGuestInfo> r100) {
        this.guestInfos = r100;
    }

    public void setMaxMember(String r100) {
        this.maxMember = r100;
    }
}
