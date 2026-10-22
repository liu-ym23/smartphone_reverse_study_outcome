package com.bytedance.android.live.base.model.message;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.im.NewHotGatherMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/base/model/message/k6;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "Lcom/bytedance/android/live/base/model/message/i;", "hotWordList", "Ljava/util/List;", ExifInterface.LONGITUDE_EAST, "()Ljava/util/List;", "setHotWordList", "(Ljava/util/List;)V", "", "switchDuration", "J", "G", "()J", "setSwitchDuration", "(J)V", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "highlightAreaPriorityConfig", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "getHighlightAreaPriorityConfig", "()Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "setHighlightAreaPriorityConfig", "(Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class k6 extends com.bytedance.android.livesdk.message.model.o0 implements vh7.h {

    @SerializedName("highlight_area_priority_config")
    protected HighlightAreaPriorityConfig highlightAreaPriorityConfig;

    @SerializedName("hot_word_list")
    protected List<i> hotWordList;

    @SerializedName("switch_duration")
    protected long switchDuration;

    public k6() {
        this.type = MessageType.NEW_HOT_MSG_MESSAGE;
    }

    public final List<i> E() {
        return this.hotWordList;
    }

    public final long G() {
        return this.switchDuration;
    }

    public final HighlightAreaPriorityConfig getHighlightAreaPriorityConfig() {
        return this.highlightAreaPriorityConfig;
    }

    public k6(am3.g r100) {
        this.hotWordList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.hotWordList.add(new i(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.switchDuration = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.highlightAreaPriorityConfig = new HighlightAreaPriorityConfig(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        this.type = MessageType.NEW_HOT_MSG_MESSAGE;
    }
}
