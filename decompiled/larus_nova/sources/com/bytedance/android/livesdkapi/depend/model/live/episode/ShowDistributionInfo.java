package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ShowDistributionInfo;", "", "()V", "modelMatchedHighLight", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStartHighLight;", "recommendText", "", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowDistributionInfo implements h {

    @SerializedName("model_matched_hl")
    public IEpisodeStartHighLight modelMatchedHighLight;

    @SerializedName("recommend_text")
    public String recommendText;

    public ShowDistributionInfo() {
        this.recommendText = "";
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStartHighLight, java.lang.Object] */
    public ShowDistributionInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.recommendText = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.modelMatchedHighLight = f.a(r100, IEpisodeStartHighLight.class);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.recommendText != null) goto L25;
        this.recommendText = "";
        return;
    }
}
