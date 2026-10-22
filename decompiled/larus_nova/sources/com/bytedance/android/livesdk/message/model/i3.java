package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ForMain
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/i3;", "", "", "domain", "Ljava/lang/Integer;", "type", "priority", "Lcom/bytedance/android/livesdk/message/model/e3;", "combineType", "Lcom/bytedance/android/livesdk/message/model/e3;", "Lcom/bytedance/android/livesdk/message/model/j3;", "cardDisplayInfo", "Lcom/bytedance/android/livesdk/message/model/j3;", "mockType", "Lcom/bytedance/android/livesdk/message/model/u;", "animConfig", "Lcom/bytedance/android/livesdk/message/model/u;", "", "isPreloadingNeeded", "Ljava/lang/Boolean;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i3 implements vh7.h {

    @SerializedName("anim_config")
    public u animConfig;

    @SerializedName("card_display_info")
    public j3 cardDisplayInfo;

    @SerializedName("combine_type")
    public e3 combineType;

    @SerializedName("domain")
    public Integer domain;

    @SerializedName("is_preloading")
    public Boolean isPreloadingNeeded;

    @SerializedName(BasicTestActionHandler.MOCK_TYPE)
    public Integer mockType;

    @SerializedName("priority")
    public Integer priority;

    @SerializedName("type")
    public Integer type;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("CommonCardArea(type=");
        r100.append(this.type);
        r100.append(", priority=");
        r100.append(this.priority);
        r100.append(", content=");
        j3 r101 = this.cardDisplayInfo;
        if (r101 == null) goto L7;
        LiveDSLModel r102 = r101.dslDetail;
        if (r102 == null) goto L7;
        String r103 = r102.getDslData();
    L8:
        r100.append(String.valueOf(r103));
        r100.append(')');
        return r100.toString();
    L7:
        r103 = null;
        goto L8
    }

    public i3() {
        this.domain = 0;
        this.type = 0;
        this.animConfig = new u();
        this.isPreloadingNeeded = Boolean.FALSE;
    }

    public i3(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L30;
        if (r102 != 1) goto L8;
        this.domain = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.type = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.priority = Integer.valueOf(r100.i());
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this.combineType = new e3(r100);
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this.mockType = Integer.valueOf(r100.i());
        goto L3
    L16:
        if (r102 != 10) goto L18;
        this.cardDisplayInfo = new j3(r100);
        goto L3
    L18:
        if (r102 != 61) goto L20;
        this.animConfig = new u(r100);
        goto L3
    L20:
        if (r102 != 62) goto L21;
        this.isPreloadingNeeded = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L21:
        am3.h.e(r100);
        goto L3
    L30:
        r100.d(r101);
        if (this.domain != null) goto L34;
        this.domain = 0;
    L34:
        if (this.type != null) goto L37;
        this.type = 0;
    L37:
        if (this.animConfig != null) goto L40;
        this.animConfig = new u();
    L40:
        if (this.isPreloadingNeeded != null) goto L70;
        this.isPreloadingNeeded = Boolean.FALSE;
        return;
    }
}
