package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.VoteSetting")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IVoteSettingFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/aa;", "", "<set-?>", "voteType$delegate", "Ljava/lang/Object;", "getVoteType", "()J", "setVoteType", "(J)V", "voteType", "", "voteDes$delegate", "getVoteDes", "()Ljava/lang/String;", "setVoteDes", "(Ljava/lang/String;)V", "voteDes", "durationTime$delegate", "getDurationTime", "setDurationTime", "durationTime", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IVoteSettingFlexImpl extends FlexModelBase<aa> implements aa, vh7.h {

    @SerializedName("duration_time")
    protected long _$$durationTime;

    @SerializedName("vote_des")
    protected String _$$voteDes;

    @SerializedName("vote_type")
    protected long _$$voteType;

    public IVoteSettingFlexImpl() {
        super(aa.class);
        this._$$voteDes = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.aa
    public final long getDurationTime() {
        return this._$$durationTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.aa
    public final String getVoteDes() {
        return this._$$voteDes;
    }

    @Override // com.bytedance.android.livesdk.link.model.aa
    public final long getVoteType() {
        return this._$$voteType;
    }

    public IVoteSettingFlexImpl(am3.g r100) {
        super(aa.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$voteType = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$voteDes = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$durationTime = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$voteDes != null) goto L31;
        this._$$voteDes = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.aa
    public final void setDurationTime(long r100) {
        this._$$durationTime = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.aa
    public final void setVoteDes(String r100) {
        this._$$voteDes = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.aa
    public final void setVoteType(long r100) {
        this._$$voteType = r100;
    }
}
