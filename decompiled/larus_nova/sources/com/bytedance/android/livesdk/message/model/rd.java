package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class rd extends o0 implements vh7.c.a<o8>, o8 {
    private static final int COLD_STARTING_SONG = 1;
    private transient FlexModelDelegate<o8> modelDefaultDelegate;

    @SerializedName("play_mode_type")
    public int playModeType;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    public String prompt;

    public boolean isForColdStartRecommend() {
        if (this.playModeType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public rd() {
        this.modelDefaultDelegate = new FlexModelDelegate(o8.class, this);
        this.type = MessageType.KTV_PLAY_MODE_START_MESSAGE;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<o8> getDelegate() {
        return this.modelDefaultDelegate;
    }

    @Override // com.bytedance.android.livesdk.message.model.o8
    public int getPlayModeType() {
        return this.playModeType;
    }

    @Override // com.bytedance.android.livesdk.message.model.o8
    public String getPrompt() {
        return this.prompt;
    }

    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<o8>> R castTo(Class<R> r100) {
        return (R) this.modelDefaultDelegate.castTo(r100);
    }

    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<o8>> R castToOrNull(Class<R> r100) {
        return (R) this.modelDefaultDelegate.castToOrNull(r100);
    }
}
