package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/DuoBattleConfigContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/u;", "", "duration", "J", "getDuration", "()J", "setDuration", "(J)V", "", "scoreType", "I", "getScoreType", "()I", "setScoreType", "(I)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DuoBattleConfigContent extends FlexModelBase<u> implements u, vh7.h {

    @SerializedName("duration")
    protected long duration;

    @SerializedName("score_type")
    protected int scoreType;

    public DuoBattleConfigContent() {
        super(u.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.u
    public long getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.u
    public int getScoreType() {
        return this.scoreType;
    }

    public DuoBattleConfigContent(am3.g r100) {
        super(u.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.duration = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.scoreType = r100.i();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.u
    public void setDuration(long r100) {
        this.duration = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.u
    public void setScoreType(int r100) {
        this.scoreType = r100;
    }
}
