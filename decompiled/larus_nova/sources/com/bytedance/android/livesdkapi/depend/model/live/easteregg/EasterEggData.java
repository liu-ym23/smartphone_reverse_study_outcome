package com.bytedance.android.livesdkapi.depend.model.live.easteregg;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.EasterEggData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\b¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/easteregg/EasterEggData;", "", "()V", "count", "", "getCount", "()J", "setCount", "(J)V", "effectsNum", "getEffectsNum", "setEffectsNum", "endCount", "getEndCount", "setEndCount", "entranceIcon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getEntranceIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setEntranceIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "hasEasterEgg", "", "getHasEasterEgg", "()Z", "setHasEasterEgg", "(Z)V", "panelUrl", "", "getPanelUrl", "()Ljava/lang/String;", "setPanelUrl", "(Ljava/lang/String;)V", "stage", "getStage", "setStage", "startCount", "getStartCount", "setStartCount", "totalStage", "getTotalStage", "setTotalStage", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EasterEggData implements h {

    @SerializedName("count")
    protected long count;

    @SerializedName("effects_num")
    protected long effectsNum;

    @SerializedName("end_count")
    protected long endCount;

    @SerializedName("entrance_icon")
    protected ImageModel entranceIcon;

    @SerializedName("has_easter_egg")
    protected boolean hasEasterEgg;

    @SerializedName("panel_url")
    protected String panelUrl;

    @SerializedName("stage")
    protected long stage;

    @SerializedName("start_count")
    protected long startCount;

    @SerializedName("total_stage")
    protected long totalStage;

    public EasterEggData() {
    }

    public final long getCount() {
        return this.count;
    }

    public final long getEffectsNum() {
        return this.effectsNum;
    }

    public final long getEndCount() {
        return this.endCount;
    }

    public final ImageModel getEntranceIcon() {
        return this.entranceIcon;
    }

    public final boolean getHasEasterEgg() {
        return this.hasEasterEgg;
    }

    public final String getPanelUrl() {
        return this.panelUrl;
    }

    public final long getStage() {
        return this.stage;
    }

    public final long getStartCount() {
        return this.startCount;
    }

    public final long getTotalStage() {
        return this.totalStage;
    }

    public EasterEggData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.entranceIcon = x.a(r100);
        goto L3
    L8:
        this.panelUrl = am3.h.c(r100);
        goto L3
    L9:
        this.count = r100.j();
        goto L3
    L10:
        this.endCount = r100.j();
        goto L3
    L11:
        this.startCount = r100.j();
        goto L3
    L12:
        this.effectsNum = r100.j();
        goto L3
    L13:
        this.totalStage = r100.j();
        goto L3
    L14:
        this.stage = r100.j();
        goto L3
    L15:
        this.hasEasterEgg = am3.h.a(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }

    public final void setCount(long r100) {
        this.count = r100;
    }

    public final void setEffectsNum(long r100) {
        this.effectsNum = r100;
    }

    public final void setEndCount(long r100) {
        this.endCount = r100;
    }

    public final void setEntranceIcon(ImageModel r100) {
        this.entranceIcon = r100;
    }

    public final void setHasEasterEgg(boolean r100) {
        this.hasEasterEgg = r100;
    }

    public final void setPanelUrl(String r100) {
        this.panelUrl = r100;
    }

    public final void setStage(long r100) {
        this.stage = r100;
    }

    public final void setStartCount(long r100) {
        this.startCount = r100;
    }

    public final void setTotalStage(long r100) {
        this.totalStage = r100;
    }
}
