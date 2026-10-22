package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.PerformanceFinishMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ih;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "appId", "Ljava/lang/String;", DBDefinition.TASK_ID, "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ih extends o0 implements vh7.h {

    @SerializedName("app_id")
    public String appId;

    @SerializedName("task_id")
    public String taskId;

    public ih() {
        this.appId = "";
        this.taskId = "";
        this.type = MessageType.OPEN_GAME_PERFORMANCE_FINISH_MESSAGE;
    }

    public ih(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.appId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.taskId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.appId != null) goto L19;
        this.appId = "";
    L19:
        if (this.taskId != null) goto L21;
        this.taskId = "";
    L21:
        this.type = MessageType.OPEN_GAME_PERFORMANCE_FINISH_MESSAGE;
    }
}
