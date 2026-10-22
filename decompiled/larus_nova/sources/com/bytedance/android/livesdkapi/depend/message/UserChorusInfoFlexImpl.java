package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.UserChorusInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0012\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R/\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R+\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00198V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010!\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010(\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00198V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001e¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/UserChorusInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/message/UserChorusInfo;", "", "<set-?>", "userId$delegate", "Ljava/lang/Object;", "getUserId", "()J", "setUserId", "(J)V", "userId", "order$delegate", "getOrder", "setOrder", "order", "", "isNeedPushRtc$delegate", "isNeedPushRtc", "()Ljava/lang/Boolean;", "setNeedPushRtc", "(Ljava/lang/Boolean;)V", "isNeedApproach$delegate", "isNeedApproach", "setNeedApproach", "", "midiScore$delegate", "getMidiScore", "()D", "setMidiScore", "(D)V", "midiScore", "isLead$delegate", "isLead", "()Z", "setLead", "(Z)V", "averageScore$delegate", "getAverageScore", "setAverageScore", "averageScore", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UserChorusInfoFlexImpl extends FlexModelBase<UserChorusInfo> implements UserChorusInfo, h {

    @SerializedName("average_midi_score")
    protected double _$$averageScore;

    @SerializedName("is_lead")
    protected boolean _$$isLead;

    @SerializedName("need_approach")
    protected Boolean _$$isNeedApproach;

    @SerializedName("need_push_rtc")
    protected Boolean _$$isNeedPushRtc;

    @SerializedName("single_segment_midi_score")
    protected double _$$midiScore;

    @SerializedName("order")
    protected long _$$order;

    @SerializedName("user_id")
    protected long _$$userId;

    public UserChorusInfoFlexImpl() {
        super(UserChorusInfo.class);
        this._$$isLead = false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final double getAverageScore() {
        return this._$$averageScore;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final double getMidiScore() {
        return this._$$midiScore;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final long getOrder() {
        return this._$$order;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final long getUserId() {
        return this._$$userId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final boolean isLead() {
        return this._$$isLead;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final Boolean isNeedApproach() {
        return this._$$isNeedApproach;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final Boolean isNeedPushRtc() {
        return this._$$isNeedPushRtc;
    }

    public UserChorusInfoFlexImpl(g r100) {
        super(UserChorusInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        g.a r104 = decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this._$$isLead = am3.h.a(r100);
        r102 = r102 | 8;
        goto L3
    L9:
        this._$$averageScore = Double.longBitsToDouble(r100.h());
        r102 = r102 | 16;
        goto L3
    L10:
        this._$$midiScore = Double.longBitsToDouble(r100.h());
        r102 = r102 | 4;
        goto L3
    L11:
        this._$$isNeedApproach = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L12:
        this._$$isNeedPushRtc = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L13:
        this._$$order = r100.j();
        r102 = r102 | 2;
        goto L3
    L14:
        this._$$userId = r100.j();
        r102 = r102 | 1;
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 8) != 0) goto L37;
        this._$$isLead = false;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final void setAverageScore(double r100) {
        this._$$averageScore = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final void setLead(boolean r100) {
        this._$$isLead = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final void setMidiScore(double r100) {
        this._$$midiScore = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final void setNeedApproach(Boolean r100) {
        this._$$isNeedApproach = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final void setNeedPushRtc(Boolean r100) {
        this._$$isNeedPushRtc = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final void setOrder(long r100) {
        this._$$order = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.UserChorusInfo
    public final void setUserId(long r100) {
        this._$$userId = r100;
    }
}
