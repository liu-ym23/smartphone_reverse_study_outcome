package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class gd extends o0 implements vh7.c.a<g8>, g8 {
    private transient FlexModelDelegate<g8> modelDefaultDelegate;

    @SerializedName("ktv_atmosphere_video_content")
    public dd videoContent;

    public gd() {
        this.modelDefaultDelegate = new FlexModelDelegate(g8.class, this);
        this.type = MessageType.KTV_MV_VIDEO_MESSAGE;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<g8> getDelegate() {
        return this.modelDefaultDelegate;
    }

    @Override // com.bytedance.android.livesdk.message.model.g8
    public dd getVideoContent() {
        return this.videoContent;
    }

    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<g8>> R castTo(Class<R> r100) {
        return (R) this.modelDefaultDelegate.castTo(r100);
    }

    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<g8>> R castToOrNull(Class<R> r100) {
        return (R) this.modelDefaultDelegate.castToOrNull(r100);
    }
}
