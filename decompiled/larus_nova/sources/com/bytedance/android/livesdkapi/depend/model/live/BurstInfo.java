package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BurstInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BurstInfo;", "", "()V", "burstTimeRemainSeconds", "", "getBurstTimeRemainSeconds", "()J", "setBurstTimeRemainSeconds", "(J)V", BdpAppEventConstant.MULTIPLE, "getMultiple", "setMultiple", "propertyDefinitionId", "getPropertyDefinitionId", "setPropertyDefinitionId", "propertyIcon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getPropertyIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setPropertyIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BurstInfo implements h {

    @SerializedName("burst_time_remain_seconds")
    protected long burstTimeRemainSeconds;

    @SerializedName(BdpAppEventConstant.MULTIPLE)
    protected long multiple;

    @SerializedName("property_definition_id")
    protected long propertyDefinitionId;

    @SerializedName("property_icon")
    protected ImageModel propertyIcon;

    public BurstInfo() {
    }

    public final long getBurstTimeRemainSeconds() {
        return this.burstTimeRemainSeconds;
    }

    public final long getMultiple() {
        return this.multiple;
    }

    public final long getPropertyDefinitionId() {
        return this.propertyDefinitionId;
    }

    public final ImageModel getPropertyIcon() {
        return this.propertyIcon;
    }

    public BurstInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.burstTimeRemainSeconds = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.multiple = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.propertyDefinitionId = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.propertyIcon = x.a(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setBurstTimeRemainSeconds(long r100) {
        this.burstTimeRemainSeconds = r100;
    }

    public final void setMultiple(long r100) {
        this.multiple = r100;
    }

    public final void setPropertyDefinitionId(long r100) {
        this.propertyDefinitionId = r100;
    }

    public final void setPropertyIcon(ImageModel r100) {
        this.propertyIcon = r100;
    }
}
