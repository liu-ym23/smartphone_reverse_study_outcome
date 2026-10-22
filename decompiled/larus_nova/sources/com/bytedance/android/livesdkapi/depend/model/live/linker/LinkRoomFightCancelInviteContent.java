package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.live.base.model.data.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.CrossRoomLinkCancelInviteContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightCancelInviteContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/data/g;", "", "cancellerRoomId", "J", "getCancellerRoomId", "()J", "setCancellerRoomId", "(J)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkRoomFightCancelInviteContent extends FlexModelBase<g> implements g, h {

    @SerializedName("canceller_room_id")
    protected long cancellerRoomId;

    public LinkRoomFightCancelInviteContent() {
        super(g.class);
    }

    @Override // com.bytedance.android.live.base.model.data.g
    public long getCancellerRoomId() {
        return this.cancellerRoomId;
    }

    public LinkRoomFightCancelInviteContent(am3.g r100) {
        super(g.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.cancellerRoomId = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setCancellerRoomId(long r100) {
        this.cancellerRoomId = r100;
    }
}
