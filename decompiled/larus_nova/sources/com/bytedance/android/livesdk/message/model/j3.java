package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ForMain
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/j3;", "", "", "cardId", "Ljava/lang/Integer;", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel;", "dslDetail", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel;", "", "", "initFields", "Ljava/util/List;", "", "durationMs", "Ljava/lang/Long;", "width", "height", "bottom", "top", "left", "right", "Lcom/bytedance/android/livesdk/message/model/z1;", "triggerConfig", "Lcom/bytedance/android/livesdk/message/model/z1;", "Lcom/bytedance/android/livesdk/message/model/t1;", "conditionList", "Lcom/bytedance/android/livesdk/message/model/w1;", "preDefeatStrategy", "Lcom/bytedance/android/livesdk/message/model/w1;", "Lcom/bytedance/android/livesdk/message/model/x1;", "showDefeatStrategy", "Lcom/bytedance/android/livesdk/message/model/x1;", "Lcom/bytedance/android/livesdk/message/model/vd;", "landScapeConfig", "Lcom/bytedance/android/livesdk/message/model/vd;", "accessibleName", "Ljava/lang/String;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class j3 implements vh7.h {

    @SerializedName("accessible_name")
    public String accessibleName;

    @SerializedName("bottom")
    public Integer bottom;

    @SerializedName("card_id")
    public Integer cardId;

    @SerializedName("condition_list")
    public List<t1> conditionList;

    @SerializedName("dsl_detail")
    public LiveDSLModel dslDetail;

    @SerializedName("duration_ms")
    public Long durationMs;

    @SerializedName("height")
    public Integer height;

    @SerializedName("init_fields")
    public List<String> initFields;

    @SerializedName("landscape_config")
    public vd landScapeConfig;

    @SerializedName("left")
    public Integer left;

    @SerializedName("pre_defeat_strategy")
    public w1 preDefeatStrategy;

    @SerializedName("right")
    public Integer right;

    @SerializedName("show_defeat_strategy")
    public x1 showDefeatStrategy;

    @SerializedName("top")
    public Integer top;

    @SerializedName("trigger_config")
    public z1 triggerConfig;

    @SerializedName("width")
    public Integer width;

    public j3() {
        this.landScapeConfig = new vd();
        this.accessibleName = "";
    }

    public j3(am3.g r100) {
        this.initFields = new ArrayList();
        this.conditionList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L44;
        if (r102 != 1) goto L8;
        this.cardId = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.dslDetail = new LiveDSLModel(r100);
        goto L3
    L10:
        if (r102 == 20) goto L40;
        if (r102 != 21) goto L14;
        this.durationMs = Long.valueOf(r100.j());
        goto L3
    L14:
        if (r102 != 30) goto L16;
        this.triggerConfig = new z1(r100);
        goto L3
    L16:
        if (r102 != 31) goto L18;
        List r103 = this.conditionList;
        Object r104 = new t1(r100);
    L41:
        r103.add(r104);
        goto L3
    L18:
        if (r102 != 40) goto L20;
        this.preDefeatStrategy = new w1(r100);
        goto L3
    L20:
        if (r102 != 41) goto L22;
        this.showDefeatStrategy = new x1(r100);
        goto L3
    L22:
        if (r102 != 50) goto L24;
        this.accessibleName = am3.h.c(r100);
        goto L3
    L24:
        if (r102 != 60) goto L25;
        this.landScapeConfig = new vd(r100);
        goto L3
    L25:
        switch(r102) {
            case 10: goto L32;
            case 11: goto L31;
            case 12: goto L30;
            case 13: goto L29;
            case 14: goto L28;
            case 15: goto L27;
            default: goto L26;
        };
    L27:
        this.left = Integer.valueOf(r100.i());
        goto L3
    L28:
        this.top = Integer.valueOf(r100.i());
        goto L3
    L29:
        this.right = Integer.valueOf(r100.i());
        goto L3
    L30:
        this.bottom = Integer.valueOf(r100.i());
        goto L3
    L31:
        this.height = Integer.valueOf(r100.i());
        goto L3
    L32:
        this.width = Integer.valueOf(r100.i());
        goto L3
    L26:
        am3.h.e(r100);
        goto L3
    L40:
        r103 = this.initFields;
        r104 = am3.h.c(r100);
        goto L41
    L44:
        r100.d(r101);
        if (this.landScapeConfig != null) goto L48;
        this.landScapeConfig = new vd();
    L48:
        if (this.accessibleName != null) goto L95;
        this.accessibleName = "";
        return;
    }
}
