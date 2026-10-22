package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.WelfareProjectInfo;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.SlashMentionConfig;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.WelfareProjectOperateMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/tn;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "opType", "I", "getOpType", "()I", "setOpType", "(I)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/WelfareProjectInfo;", "projectInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/WelfareProjectInfo;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdkapi/depend/model/live/WelfareProjectInfo;", "setProjectInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/WelfareProjectInfo;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class tn extends o0 implements vh7.h {

    @SerializedName("op_type")
    protected int opType;

    @SerializedName(SlashMentionConfig.SLASH_CONTENT_PROJECT)
    protected WelfareProjectInfo projectInfo;

    public static final class a {
    }

    static {
    }

    public tn() {
        this.type = MessageType.WELFARE_PROJECT_OPERATE_MESSAGE;
    }

    public final WelfareProjectInfo E() {
        return this.projectInfo;
    }

    public final int getOpType() {
        return this.opType;
    }

    public tn(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.opType = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.projectInfo = new WelfareProjectInfo(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        this.type = MessageType.WELFARE_PROJECT_OPERATE_MESSAGE;
    }
}
