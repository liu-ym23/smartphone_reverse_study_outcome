package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.UpperRightWidgetData;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.UpperRightWidgetDataMessage")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/sm;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "randomTime", "Ljava/lang/Long;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/UpperRightWidgetData;", "upperRightWidgetDataList", "Ljava/util/List;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class sm extends o0 implements vh7.h {

    @SerializedName("random_time")
    public Long randomTime;

    @SerializedName("upper_right_widget_data_list")
    public List<UpperRightWidgetData> upperRightWidgetDataList;

    public final String toString() {
        return "UpperRightWidgetDataMessage(upperRightWidgetDataList=" + this.upperRightWidgetDataList + ')';
    }

    public sm() {
        this.type = MessageType.UPPER_RIGHT_WIDGET_DATA_MESSAGE;
    }

    public sm(am3.g r100) {
        this.upperRightWidgetDataList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.upperRightWidgetDataList.add(new UpperRightWidgetData(r100));
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.randomTime = Long.valueOf(r100.j());
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        this.type = MessageType.UPPER_RIGHT_WIDGET_DATA_MESSAGE;
    }
}
