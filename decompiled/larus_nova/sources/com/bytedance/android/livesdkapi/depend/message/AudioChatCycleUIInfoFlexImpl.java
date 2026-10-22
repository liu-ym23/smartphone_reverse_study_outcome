package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.AudioChatCycleUIInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016RG\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR/\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000e8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/AudioChatCycleUIInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/message/AudioChatCycleUIInfo;", "", "", "Lcom/bytedance/android/livesdkapi/depend/message/AudioChatCycleUIInfo$Info;", "<set-?>", "uiInfo$delegate", "Ljava/lang/Object;", "getUiInfo", "()Ljava/util/Map;", "setUiInfo", "(Ljava/util/Map;)V", "uiInfo", "", "upTimeMs$delegate", "getUpTimeMs", "()Ljava/lang/String;", "setUpTimeMs", "(Ljava/lang/String;)V", "upTimeMs", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioChatCycleUIInfoFlexImpl extends FlexModelBase<AudioChatCycleUIInfo> implements AudioChatCycleUIInfo, h {

    @SerializedName("ui_info")
    protected Map<Long, ? extends AudioChatCycleUIInfo.Info> _$$uiInfo;

    @SerializedName("up_time_ms")
    protected String _$$upTimeMs;

    public AudioChatCycleUIInfoFlexImpl() {
        super(AudioChatCycleUIInfo.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.AudioChatCycleUIInfo
    public final Map<Long, AudioChatCycleUIInfo.Info> getUiInfo() {
        return this._$$uiInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.AudioChatCycleUIInfo
    public final String getUpTimeMs() {
        return this._$$upTimeMs;
    }

    public AudioChatCycleUIInfoFlexImpl(g r110) {
        super(AudioChatCycleUIInfo.class);
        this._$$uiInfo = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L28;
        g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 3) goto L8;
        long r103 = r110.c();
        Long r104 = null;
        Object r105 = null;
    L12:
        int r106 = r110.f();
        if (r106 == (-1)) goto L20;
        if (r106 != 1) goto L16;
        r104 = Long.valueOf(r110.j());
        goto L12
    L16:
        if (r106 != 2) goto L17;
        r105 = f.a(r110, AudioChatCycleUIInfo.Info.class);
        goto L12
    L17:
        am3.h.e(r110);
        goto L12
    L20:
        r110.d(r103);
        Map<Long, ? extends AudioChatCycleUIInfo.Info> r107 = this._$$uiInfo;
        if (r104 == null) goto L27;
        if (r105 == null) goto L25;
        r107.put(r104, r105);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L8:
        if (r101 != 4) goto L9;
        this._$$upTimeMs = am3.h.c(r110);
        goto L3
    L9:
        am3.h.d(r102, r110);
        goto L3
    L28:
        r110.d(r100);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.AudioChatCycleUIInfo
    public final void setUiInfo(Map<Long, ? extends AudioChatCycleUIInfo.Info> r100) {
        this._$$uiInfo = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.AudioChatCycleUIInfo
    public final void setUpTimeMs(String r100) {
        this._$$upTimeMs = r100;
    }
}
