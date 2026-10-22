package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicThemedCompetitionCloseContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicThemedCompetitionCloseContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/ca;", "", "competitionId$delegate", "Ljava/lang/Object;", "getCompetitionId", "()J", "competitionId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicThemedCompetitionCloseContent extends FlexModelBase<ca> implements ca, vh7.h {

    @SerializedName("competition_id")
    protected long _$$competitionId;

    public LinkmicThemedCompetitionCloseContent() {
        super(ca.class);
        this._$$competitionId = 0;
    }

    @Override // com.bytedance.android.livesdk.message.model.ca
    public final long getCompetitionId() {
        return this._$$competitionId;
    }

    public LinkmicThemedCompetitionCloseContent(am3.g r100) {
        super(ca.class);
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        this._$$competitionId = r100.j();
        r101 = r101 | true;
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L9:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & true) == true) goto L19;
        this._$$competitionId = 0;
        return;
    }
}
