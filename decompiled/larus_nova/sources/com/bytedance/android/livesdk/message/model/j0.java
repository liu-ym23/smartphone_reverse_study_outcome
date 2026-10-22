package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.BackRecordVideoMessage")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 ¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/j0;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "m3u8Url", "Ljava/lang/String;", "G", "()Ljava/lang/String;", "setM3u8Url", "(Ljava/lang/String;)V", "", "tsUrls", "Ljava/util/List;", FaceService.neutralLabel, "()Ljava/util/List;", "setTsUrls", "(Ljava/util/List;)V", "executionId", ExifInterface.LONGITUDE_EAST, "setExecutionId", "", "succeed", "Z", "getSucceed", "()Z", "setSucceed", "(Z)V", "", DyPayConstant.KEY_START_TIME, "J", "getStartTime", "()J", "setStartTime", "(J)V", "endTime", "getEndTime", "setEndTime", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j0 extends o0 implements vh7.h {

    @SerializedName("end_time")
    protected long endTime;

    @SerializedName("execution_id")
    protected String executionId;

    @SerializedName("m3u8_url")
    protected String m3u8Url;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long startTime;

    @SerializedName("succeed")
    protected boolean succeed;

    @SerializedName("ts_urls")
    protected List<String> tsUrls;

    public j0() {
        this.type = MessageType.ANCHOR_BACK_RECORD_MESSAGE;
    }

    public final String E() {
        return this.executionId;
    }

    public final String G() {
        return this.m3u8Url;
    }

    public final List<String> H() {
        return this.tsUrls;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final boolean getSucceed() {
        return this.succeed;
    }

    public j0(am3.g r100) {
        this.tsUrls = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.endTime = r100.j();
        goto L3
    L8:
        this.startTime = r100.j();
        goto L3
    L9:
        this.succeed = am3.h.a(r100);
        goto L3
    L10:
        this.executionId = am3.h.c(r100);
        goto L3
    L11:
        this.tsUrls.add(am3.h.c(r100));
        goto L3
    L12:
        this.m3u8Url = am3.h.c(r100);
        goto L3
    L13:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        this.type = MessageType.ANCHOR_BACK_RECORD_MESSAGE;
    }
}
