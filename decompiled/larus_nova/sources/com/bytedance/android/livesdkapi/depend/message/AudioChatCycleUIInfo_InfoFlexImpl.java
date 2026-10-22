package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.AudioChatCycleUIInfo.Info")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/AudioChatCycleUIInfo_InfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/message/AudioChatCycleUIInfo$Info;", "", "<set-?>", "track$delegate", "Ljava/lang/Object;", "getTrack", "()J", "setTrack", "(J)V", GXTemplateKey.GAIAX_TRACK, "", "headerRatio$delegate", "getHeaderRatio", "()F", "setHeaderRatio", "(F)V", "headerRatio", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioChatCycleUIInfo_InfoFlexImpl extends FlexModelBase<AudioChatCycleUIInfo.Info> implements AudioChatCycleUIInfo.Info, h {

    @SerializedName("header_ratio")
    protected float _$$headerRatio;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    protected long _$$track;

    public AudioChatCycleUIInfo_InfoFlexImpl() {
        super(AudioChatCycleUIInfo.Info.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.AudioChatCycleUIInfo.Info
    public final float getHeaderRatio() {
        return this._$$headerRatio;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.AudioChatCycleUIInfo.Info
    public final long getTrack() {
        return this._$$track;
    }

    public AudioChatCycleUIInfo_InfoFlexImpl(g r100) {
        super(AudioChatCycleUIInfo.Info.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$track = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$headerRatio = Float.intBitsToFloat(r100.g());
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.AudioChatCycleUIInfo.Info
    public final void setHeaderRatio(float r100) {
        this._$$headerRatio = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.AudioChatCycleUIInfo.Info
    public final void setTrack(long r100) {
        this._$$track = r100;
    }
}
