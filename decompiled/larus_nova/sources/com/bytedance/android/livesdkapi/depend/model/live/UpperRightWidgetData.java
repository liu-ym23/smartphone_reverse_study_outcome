package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.UpperRightWidgetData")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/UpperRightWidgetData;", "", "()V", "extra", "", "name", "priority", "", "Ljava/lang/Integer;", "widgetType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UpperRightWidgetData implements h {

    @SerializedName("extra")
    public String extra;

    @SerializedName("name")
    public String name;

    @SerializedName("priority")
    public Integer priority;

    @SerializedName("widget_type")
    public Integer widgetType;

    public UpperRightWidgetData() {
    }

    public UpperRightWidgetData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.name = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.widgetType = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.extra = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.priority = Integer.valueOf(r100.i());
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
