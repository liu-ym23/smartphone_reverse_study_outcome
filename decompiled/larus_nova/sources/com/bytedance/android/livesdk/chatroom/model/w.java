package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/w;", "", "", "stream", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setStream", "(Ljava/lang/String;)V", DBDefinition.TASK_ID, "b", "d", "", "isStarPush", "Z", "c", "()Z", "setStarPush", "(Z)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class w implements vh7.h {

    @SerializedName("is_mix_stream_to_cdn")
    protected boolean isStarPush;

    @SerializedName("stream")
    protected String stream;

    @SerializedName("task_id")
    protected String taskId;

    public w() {
        this.stream = "";
        this.taskId = "";
    }

    public final String a() {
        return this.stream;
    }

    public final String b() {
        return this.taskId;
    }

    public final boolean c() {
        return this.isStarPush;
    }

    public w(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.stream = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.taskId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.isStarPush = am3.h.a(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.stream != null) goto L19;
        this.stream = "";
    L19:
        if (this.taskId != null) goto L34;
        this.taskId = "";
        return;
    }

    public final void d(String r100) {
        this.taskId = r100;
    }
}
