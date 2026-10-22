package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import com.bytedance.android.livesdk.link.model.bridge.m1;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class ListUserContent extends FlexModelBase<k1> implements k1 {

    @SerializedName("linkmic_content")
    public ListUserLinkmicContent linkmicContent;

    @SerializedName("linkmic_audience_content")
    public ListUserLinkmicAudienceContent mLinkmicAudienceContent;

    public ListUserContent() {
        super(k1.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.k1
    public /* bridge */ /* synthetic */ l1 getLinkMicAudienceContent() {
        return getLinkMicAudienceContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.k1
    public /* bridge */ /* synthetic */ m1 getLinkMicContent() {
        return getLinkMicContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.k1
    public ListUserLinkmicAudienceContent getLinkMicAudienceContent() {
        return this.mLinkmicAudienceContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.k1
    public ListUserLinkmicContent getLinkMicContent() {
        return this.linkmicContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.k1
    public void setLinkMicAudienceContent(l1 r100) {
        this.mLinkmicAudienceContent = (ListUserLinkmicAudienceContent) jm2.a.d(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.k1
    public void setLinkMicContent(m1 r100) {
        this.linkmicContent = (ListUserLinkmicContent) jm2.a.e(r100);
    }
}
