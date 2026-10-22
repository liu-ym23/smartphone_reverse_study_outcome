package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.inv.export.router.InvRouter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_profit.AudioSubtitleOpenResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/AudioSubtitleOpenResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/o;", "", "<set-?>", "versionId$delegate", "Ljava/lang/Object;", "getVersionId", "()J", "setVersionId", "(J)V", "versionId", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioSubtitleOpenResponse extends FlexModelBase<o> implements o, vh7.h {

    @SerializedName(InvRouter.VERSION_ID)
    protected long _$$versionId;

    public AudioSubtitleOpenResponse() {
        super(o.class);
        this._$$versionId = 0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.o
    public final long getVersionId() {
        return this._$$versionId;
    }

    public AudioSubtitleOpenResponse(am3.g r100) {
        super(o.class);
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        this._$$versionId = r100.j();
        r101 = r101 | true;
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L9:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & true) == true) goto L19;
        this._$$versionId = 0;
        return;
    }

    public final void setVersionId(long r100) {
        this._$$versionId = r100;
    }
}
