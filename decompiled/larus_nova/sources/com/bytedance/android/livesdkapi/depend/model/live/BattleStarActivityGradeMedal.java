package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BattleStarActivityGradeMedal")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGradeMedal;", "", "()V", "gradeMedal", "Lcom/bytedance/android/live/base/model/ImageModel;", "getGradeMedal", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setGradeMedal", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "levelImage", "getLevelImage", "setLevelImage", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattleStarActivityGradeMedal implements h {

    @SerializedName("grade_medal")
    protected ImageModel gradeMedal;

    @SerializedName("level_image")
    protected ImageModel levelImage;

    public BattleStarActivityGradeMedal() {
    }

    public BattleStarActivityGradeMedal(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.gradeMedal = x.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.levelImage = x.a(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final ImageModel getGradeMedal() {
        return this.gradeMedal;
    }

    public final ImageModel getLevelImage() {
        return this.levelImage;
    }

    public final void setGradeMedal(ImageModel r100) {
        this.gradeMedal = r100;
    }

    public final void setLevelImage(ImageModel r100) {
        this.levelImage = r100;
    }
}
