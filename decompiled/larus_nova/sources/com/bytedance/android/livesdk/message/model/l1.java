package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ForMain
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/l1;", "", "", "containerType", "I", "", "containerUrl", "Ljava/lang/String;", "containerTemplate", "containerPayload", "", "initFields", "Ljava/util/List;", "width", "Ljava/lang/Integer;", "height", "top", "right", "accessibleName", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class l1 implements vh7.h {

    @SerializedName("accessible_name")
    public String accessibleName;

    @SerializedName("container_payload")
    public String containerPayload;

    @SerializedName("container_template")
    public String containerTemplate;

    @SerializedName(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE)
    public int containerType;

    @SerializedName("container_url")
    public String containerUrl;

    @SerializedName("height")
    public Integer height;

    @SerializedName("init_fields")
    public List<String> initFields;

    @SerializedName("right")
    public Integer right;

    @SerializedName("top")
    public Integer top;

    @SerializedName("width")
    public Integer width;

    public l1() {
        this.containerUrl = "";
        this.containerTemplate = "";
        this.containerPayload = "";
        this.accessibleName = "";
    }

    public l1(am3.g r100) {
        this.initFields = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L29;
        if (r102 != 1) goto L8;
        this.containerType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.containerUrl = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.containerTemplate = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.containerPayload = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this.initFields.add(am3.h.c(r100));
        goto L3
    L16:
        if (r102 != 20) goto L17;
        this.accessibleName = am3.h.c(r100);
        goto L3
    L17:
        switch(r102) {
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            default: goto L18;
        };
    L19:
        this.right = Integer.valueOf(r100.i());
        goto L3
    L20:
        this.top = Integer.valueOf(r100.i());
        goto L3
    L21:
        this.height = Integer.valueOf(r100.i());
        goto L3
    L22:
        this.width = Integer.valueOf(r100.i());
        goto L3
    L18:
        am3.h.e(r100);
        goto L3
    L29:
        r100.d(r101);
        if (this.containerUrl != null) goto L33;
        this.containerUrl = "";
    L33:
        if (this.containerTemplate != null) goto L36;
        this.containerTemplate = "";
    L36:
        if (this.containerPayload != null) goto L39;
        this.containerPayload = "";
    L39:
        if (this.accessibleName != null) goto L72;
        this.accessibleName = "";
        return;
    }
}
