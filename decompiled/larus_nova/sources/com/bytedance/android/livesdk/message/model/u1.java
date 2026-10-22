package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ForMain
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0007¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/u1;", "", "", "cardId", "Ljava/lang/Integer;", "", "url", "Ljava/lang/String;", "fallbackUrl", "containerType", "I", "", "durationMs", "Ljava/lang/Long;", "width", "height", "bottom", "right", "containerPayload", "Lcom/bytedance/android/livesdk/message/model/z1;", "triggerConfig", "Lcom/bytedance/android/livesdk/message/model/z1;", "", "Lcom/bytedance/android/livesdk/message/model/t1;", "conditionList", "Ljava/util/List;", "Lcom/bytedance/android/livesdk/message/model/w1;", "preDefeatStrategy", "Lcom/bytedance/android/livesdk/message/model/w1;", "Lcom/bytedance/android/livesdk/message/model/x1;", "showDefeatStrategy", "Lcom/bytedance/android/livesdk/message/model/x1;", "Lcom/bytedance/android/livesdk/message/model/vd;", "landScapeConfig", "Lcom/bytedance/android/livesdk/message/model/vd;", "accessibleName", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class u1 implements vh7.h {

    @SerializedName("accessible_name")
    public String accessibleName;

    @SerializedName("bottom")
    public Integer bottom;

    @SerializedName("card_id")
    public Integer cardId;

    @SerializedName("condition_list")
    public List<t1> conditionList;

    @SerializedName("container_payload")
    public String containerPayload;

    @SerializedName(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE)
    public int containerType;

    @SerializedName("duration_ms")
    public Long durationMs;

    @SerializedName("fallback_url")
    public String fallbackUrl;

    @SerializedName("height")
    public Integer height;

    @SerializedName("landscape_config")
    public vd landScapeConfig;

    @SerializedName("pre_defeat_strategy")
    public w1 preDefeatStrategy;

    @SerializedName("right")
    public Integer right;

    @SerializedName("show_defeat_strategy")
    public x1 showDefeatStrategy;

    @SerializedName("trigger_config")
    public z1 triggerConfig;

    @SerializedName("url")
    public String url;

    @SerializedName("width")
    public Integer width;

    public u1() {
        this.landScapeConfig = new vd();
        this.accessibleName = "";
    }

    public u1(am3.g r100) {
        this.conditionList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L47;
        if (r102 != 1) goto L8;
        this.cardId = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.url = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.fallbackUrl = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.containerType = r100.i();
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this.durationMs = Long.valueOf(r100.j());
        goto L3
    L16:
        if (r102 != 20) goto L18;
        this.containerPayload = am3.h.c(r100);
        goto L3
    L18:
        if (r102 != 50) goto L20;
        this.accessibleName = am3.h.c(r100);
        goto L3
    L20:
        if (r102 != 60) goto L22;
        this.landScapeConfig = new vd(r100);
        goto L3
    L22:
        if (r102 != 30) goto L24;
        this.triggerConfig = new z1(r100);
        goto L3
    L24:
        if (r102 != 31) goto L26;
        this.conditionList.add(new t1(r100));
        goto L3
    L26:
        if (r102 != 40) goto L28;
        this.preDefeatStrategy = new w1(r100);
        goto L3
    L28:
        if (r102 != 41) goto L29;
        this.showDefeatStrategy = new x1(r100);
        goto L3
    L29:
        switch(r102) {
            case 10: goto L34;
            case 11: goto L33;
            case 12: goto L32;
            case 13: goto L31;
            default: goto L30;
        };
    L31:
        this.right = Integer.valueOf(r100.i());
        goto L3
    L32:
        this.bottom = Integer.valueOf(r100.i());
        goto L3
    L33:
        this.height = Integer.valueOf(r100.i());
        goto L3
    L34:
        this.width = Integer.valueOf(r100.i());
        goto L3
    L30:
        am3.h.e(r100);
        goto L3
    L47:
        r100.d(r101);
        if (this.landScapeConfig != null) goto L51;
        this.landScapeConfig = new vd();
    L51:
        if (this.accessibleName != null) goto L102;
        this.accessibleName = "";
        return;
    }
}
