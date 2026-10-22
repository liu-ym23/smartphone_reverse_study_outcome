package com.bytedance.android.livesdkapi.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.GameImageBundler")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/GameImageBundler;", "", "()V", "originImage", "Lcom/bytedance/android/livesdkapi/model/GameImage;", "getOriginImage", "()Lcom/bytedance/android/livesdkapi/model/GameImage;", "setOriginImage", "(Lcom/bytedance/android/livesdkapi/model/GameImage;)V", "thumbHeifImage", "getThumbHeifImage", "setThumbHeifImage", "thumbImage", "getThumbImage", "setThumbImage", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameImageBundler implements h {

    @SerializedName("origin_image")
    protected GameImage originImage;

    @SerializedName("thumb_heif_image")
    protected GameImage thumbHeifImage;

    @SerializedName("thumb_image")
    protected GameImage thumbImage;

    public GameImageBundler() {
    }

    public GameImageBundler(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.originImage = new GameImage(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.thumbImage = new GameImage(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.thumbHeifImage = new GameImage(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final GameImage getOriginImage() {
        return this.originImage;
    }

    public final GameImage getThumbHeifImage() {
        return this.thumbHeifImage;
    }

    public final GameImage getThumbImage() {
        return this.thumbImage;
    }

    public final void setOriginImage(GameImage r100) {
        this.originImage = r100;
    }

    public final void setThumbHeifImage(GameImage r100) {
        this.thumbHeifImage = r100;
    }

    public final void setThumbImage(GameImage r100) {
        this.thumbImage = r100;
    }
}
