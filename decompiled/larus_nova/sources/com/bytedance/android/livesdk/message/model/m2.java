package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/m2;", "", "", "roomId", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setRoomId", "(J)V", "", DBDefinition.TASK_ID, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/chatroom/model/v;", "chorusCdnInfo", "Lcom/bytedance/android/livesdk/chatroom/model/v;", "getChorusCdnInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/v;", "setChorusCdnInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/v;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m2 implements vh7.h {

    @SerializedName("cdn_info")
    protected com.bytedance.android.livesdk.chatroom.model.v chorusCdnInfo;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("task_id")
    protected String taskId;

    public m2() {
        this.taskId = "";
    }

    public final long a() {
        return this.roomId;
    }

    public final String b() {
        return this.taskId;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.chatroom.model.v, java.lang.Object] */
    public m2(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.roomId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.taskId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.chorusCdnInfo = vh7.f.a(r100, com.bytedance.android.livesdk.chatroom.model.v.class);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.taskId != null) goto L31;
        this.taskId = "";
        return;
    }

    public final void c(String r100) {
        this.taskId = r100;
    }
}
