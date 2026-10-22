package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/TagDressPageItem;", "", "()V", "common", "Lcom/bytedance/android/livesdkapi/depend/message/DressPageItemCommon;", "micPosTagInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/MicPosTagInfo;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TagDressPageItem implements h {

    @SerializedName("common")
    public DressPageItemCommon common;

    @SerializedName("mic_pos_tag_info")
    public MicPosTagInfo micPosTagInfo;

    public TagDressPageItem() {
    }

    public TagDressPageItem(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.common = new DressPageItemCommon(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.micPosTagInfo = new MicPosTagInfo(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
