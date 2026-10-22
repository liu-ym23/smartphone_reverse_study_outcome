package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ProjectDTaskInfo")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/mi;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "awardUrl", "Ljava/lang/String;", "getAwardUrl", "()Ljava/lang/String;", "setAwardUrl", "(Ljava/lang/String;)V", "", "leftTaskCount", "J", "getLeftTaskCount", "()J", "setLeftTaskCount", "(J)V", "fallbackContext", "getFallbackContext", "setFallbackContext", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "taskBegin", "Z", "getTaskBegin", "()Z", "setTaskBegin", "(Z)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class mi extends o0 implements vh7.h {

    @SerializedName("award_url")
    protected String awardUrl;

    @SerializedName("fallback_context")
    protected String fallbackContext;

    @SerializedName("icon")
    protected ImageModel icon;

    @SerializedName("left_task_count")
    protected long leftTaskCount;

    @IgnoreProtoFieldCheck
    @SerializedName("task_begin")
    @IgnoreProtoDecode
    private boolean taskBegin;

    public static final class a {
    }

    static {
    }

    public mi() {
        this.awardUrl = "https://s3.bytecdn.cn/ies/venus/webcast_activity/douyin/task_gift/package/index.html?web_bg_color=%2300FFFFFF&type=2";
        this.type = MessageType.DOUYIN_OFFICIAL_TASK_INFO;
    }

    public mi(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.icon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L10:
        if (r102 != 5) goto L12;
        this.fallbackContext = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 6) goto L14;
        this.awardUrl = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 7) goto L15;
        this.leftTaskCount = r100.j();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.awardUrl != null) goto L24;
        this.awardUrl = "https://s3.bytecdn.cn/ies/venus/webcast_activity/douyin/task_gift/package/index.html?web_bg_color=%2300FFFFFF&type=2";
    L24:
        this.type = MessageType.DOUYIN_OFFICIAL_TASK_INFO;
    }
}
