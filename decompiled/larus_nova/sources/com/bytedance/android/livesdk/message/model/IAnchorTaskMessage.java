package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/IAnchorTaskMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "Lcom/bytedance/android/livesdk/message/model/vl;", "taskRecords", "Ljava/util/List;", "getTaskRecords", "()Ljava/util/List;", "setTaskRecords", "(Ljava/util/List;)V", "", "action", "I", "getAction", "()I", "setAction", "(I)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorTaskMessage extends o0 implements vh7.h {

    @SerializedName("action")
    protected int action;

    @SerializedName("task_records")
    protected List<vl> taskRecords;

    public IAnchorTaskMessage() {
        this.type = MessageType.ANCHOR_TASK_MESSAGE;
    }

    public final int getAction() {
        return this.action;
    }

    public final List<vl> getTaskRecords() {
        return this.taskRecords;
    }

    public IAnchorTaskMessage(am3.g r100) {
        this.taskRecords = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.taskRecords.add(new vl(r100));
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.action = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        this.type = MessageType.ANCHOR_TASK_MESSAGE;
    }

    public final void setAction(int r100) {
        this.action = r100;
    }

    public final void setTaskRecords(List<vl> r100) {
        this.taskRecords = r100;
    }
}
